package com.neu.onlinemarketplace.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.onlinemarketplace.DAO.AdvertDAO;
import com.neu.onlinemarketplace.DAO.CategoryDAO;
import com.neu.onlinemarketplace.DAO.CityDAO;
import com.neu.onlinemarketplace.pojo.Advertisement;
import com.neu.onlinemarketplace.pojo.Category;
import com.neu.onlinemarketplace.pojo.City;




@Controller
public class AdminController {

	
	@Autowired
	@Qualifier("advertDao")
	private AdvertDAO advertDao;
	
	@Autowired
	@Qualifier("categoryDao")
	private CategoryDAO categoryDao;
	
	
	@Autowired
	@Qualifier("cityDao")
	private  CityDAO cityDao;
	
	@RequestMapping(value = "/admin/AdminSearch", method = RequestMethod.GET)
	public ModelAndView showAdverts(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		List<Category> catList=categoryDao.listCategory();
		List<City> cityList=cityDao.listCity();
		mv.addObject("catList",catList);
		mv.addObject("cityList", cityList);
		mv.setViewName("AdminSearch");
		return mv;
		
		//return null;
		
	}
	
	@RequestMapping(value = "/admin/AdminSearch", method = RequestMethod.POST)
	public ModelAndView searchResults(HttpServletRequest request) {
		
		String city=request.getParameter("city");
		String category=request.getParameter("category");
		System.out.println("the city is " +city);
		System.out.println("the category" +category);
		List<Advertisement> advertList=advertDao.adminSearch(category, city);
		ModelAndView mv=new ModelAndView();
		mv.addObject("advertList",advertList);
		System.out.println("the size " +advertList.size());
		mv.setViewName("AdminSearch");
		
		return mv;
		
		//return null;
		
	}
	
	@RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
	public String deleteAdd(HttpServletRequest request) {
		
		int id=Integer.parseInt(request.getParameter("id"));
		advertDao.delete(id);
		
		return "user-Home";
		
	//return null;
	}
	
	
	@RequestMapping(value = "/admin/addCategory", method = RequestMethod.GET)
	public ModelAndView addCategory(HttpServletRequest request) {
		
		return new ModelAndView("Category-form", "category", new Category());
	}
	
	@RequestMapping(value = "/admin/addCategory", method = RequestMethod.POST)
	public String add(HttpServletRequest request,@ModelAttribute("category") Category category, BindingResult result) {
		category=categoryDao.create(category.getcategoryDescription());
		
		
		return "user-Home";
	}
	
	
	
}
