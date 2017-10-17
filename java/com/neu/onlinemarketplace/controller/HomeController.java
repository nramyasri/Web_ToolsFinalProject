package com.neu.onlinemarketplace.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.onlinemarketplace.DAO.CategoryDAO;
import com.neu.onlinemarketplace.DAO.CityDAO;
import com.neu.onlinemarketplace.DAO.MessageDAO;
import com.neu.onlinemarketplace.DAO.UserDAO;
import com.neu.onlinemarketplace.pojo.Admin;
import com.neu.onlinemarketplace.pojo.Category;
import com.neu.onlinemarketplace.pojo.City;
import com.neu.onlinemarketplace.pojo.Message;
import com.neu.onlinemarketplace.pojo.User;
import com.neu.onlinemarketplace.validator.UserValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("userDao")
	private UserDAO userDao;
	
	@Autowired
	@Qualifier("messageDao")
	private MessageDAO messageDao;
	
	@Autowired
	@Qualifier("cityDao")
	private  CityDAO cityDao;
	
	@Autowired
	@Qualifier("categoryDao")
	private  CategoryDAO categoryDao;
	
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	protected ModelAndView goToUserHome() throws Exception {
		
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	protected ModelAndView register(HttpServletRequest request) throws Exception {
		
		
		
		//return new ModelAndView("user-home", "user", u);
		
		return new ModelAndView("register","user",new User());
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request,  @ModelAttribute("user")User user, BindingResult result) throws Exception {
		System.out.println("Registering the user...");
		validator.validate(user, result);
		
		if (result.hasErrors()) {
			return new ModelAndView("register", "user", user);
		}
		
		try {
		//UserDAO userDao=new UserDAO();
		User u = userDao.register(user);
		HttpSession session = (HttpSession) request.getSession();
		session.setAttribute("user", u);
		return new ModelAndView("user-Home","user",u);
		}
		catch(Exception e){
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
	}
	
	/*@RequestMapping(value = "/addItem", method = RequestMethod.GET)
	protected ModelAndView AddanItem() throws Exception {
		
		return new ModelAndView("addItem");
	}*/
	
	@RequestMapping(value = "/HomePage", method = RequestMethod.POST)
	protected ModelAndView loginUser(HttpServletRequest request){
		
		ModelAndView mv=new ModelAndView();
		
		HttpSession session = (HttpSession) request.getSession();
		User u = userDao.get(request.getParameter("username"), request.getParameter("password"));
		Admin a=userDao.getAdmin(request.getParameter("username"), request.getParameter("password"));
		if((u == null)&&(a==null) ){
			System.out.println("UserName/Password does not exist");
			session.setAttribute("errorMessage", "UserName/Password does not exist");
			mv.setViewName("Error");
		}
		
		else if(request.getParameter("username").endsWith("@admin.com")){
			    String Role="admin";
			    session.setAttribute("ROLE", Role);
				mv.setViewName("user-Home");
			
		}
		
		else if(u!=null){
		 String role="user";
		 session.setAttribute("ROLE", role);
		 List<City> cityList =cityDao.listCity();
		 List<Category> catList=categoryDao.listCategory();
		 System.out.println("Logging in...");
		session.setAttribute("user", u);
		
		//setting the messages
       mv.addObject("cityList", cityList);
       mv.addObject("catList",catList);
       mv.setViewName("user-Home");
		}
	
       		
		
		
		
		
		 return mv;
	}
	
	@RequestMapping(value = "/logout")
	protected String logoutUser(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession(false);
		if(session != null)
		session.invalidate();
		
			//request.getRequestDispatcher("/login.jsp").forward(request,response);
			return "login";
		 
	}
	
}

