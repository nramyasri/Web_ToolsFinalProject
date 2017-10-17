package com.neu.onlinemarketplace.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.onlinemarketplace.DAO.AdvertDAO;
import com.neu.onlinemarketplace.DAO.CategoryDAO;
import com.neu.onlinemarketplace.DAO.CityDAO;
import com.neu.onlinemarketplace.DAO.ImageDAO;
import com.neu.onlinemarketplace.DAO.UserDAO;
import com.neu.onlinemarketplace.pojo.Advertisement;
import com.neu.onlinemarketplace.pojo.Category;
import com.neu.onlinemarketplace.pojo.City;
import com.neu.onlinemarketplace.pojo.Images;
import com.neu.onlinemarketplace.pojo.User;




@Controller
public class ItemController {
	@Autowired
	@Qualifier("categoryDao")
	private CategoryDAO categoryDao;
	
	@Autowired
	@Qualifier("userDao")
	private UserDAO userDao;
	
	@Autowired
	@Qualifier("advertDao")
	private AdvertDAO advertDao;
	
	@Autowired
	@Qualifier("cityDao")
	private  CityDAO cityDao;
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	@Qualifier("imageDao")
	private  ImageDAO imageDao;
	
	
	@RequestMapping(value = "/addItem", method = RequestMethod.GET)
	protected ModelAndView AddanItem(HttpServletRequest request) throws Exception {
		
		HttpSession session = (HttpSession) request.getSession();
		System.out.println("Username " +session.getAttribute("username"));
		
		List<Category> categories=categoryDao.listCategory();
		for(Category c : categories){
			System.out.println(c.getcategoryDescription());
		}
		
		List<City> cities =cityDao.listCity();
		session.setAttribute("catlist", categories);
		session.setAttribute("cityList", cities);
		ModelAndView mv = new ModelAndView();
		//mv.addObject(attributeValue);
		mv.addObject("advert", new Advertisement());
		mv.setViewName("addItem-Form");
		return mv;
		
		//return new ModelAndView("addItem");
	}
	
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	protected ModelAndView PostAnItem(@ModelAttribute("advert") Advertisement advert, BindingResult result,HttpServletRequest request) {
		
			System.out.println("Adding the ad to the database..");	
			//String categoryName=request.getParameter("selectedRecord");
			User u = userDao.get(advert.getPostedBy());
			System.out.println("posted by..."+advert.getPostedBy());
			advert.setUser(u);
			advert.setFilename("Bags");
			Date d = new Date();
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
            String postedOn = format.format(d);
            advert.setPostedOn(postedOn);
            
			try {
				
				if (advert.getFilename().trim() != "" || advert.getFilename() != null) {
					File directory;
					String check = File.separator; // Checking if system is linux
													// based or windows based by
													// checking seprator used.
					String path = null;
					if (check.equalsIgnoreCase("\\")) {
						path = servletContext.getRealPath("").replace("build\\", ""); // gives real path as Lab9/build/web/
																					  // so we need to replace build in the path
																							}

					if (check.equalsIgnoreCase("/")) {
						path = servletContext.getRealPath("").replace("build/", "");
						path += "/"; // Adding trailing slash for Mac systems.
					}
					directory = new File(path + "\\" + advert.getFilename());
					boolean temp = directory.exists();
					if (!temp) {
						temp = directory.mkdir();
					}
					if (temp) {
						// We need to transfer to a file
						CommonsMultipartFile photoInMemory = advert.getPhoto();

						String fileName = photoInMemory.getOriginalFilename();
						// could generate file names as well
                         System.out.println("The file Name is " +fileName); 
						
						
						//File localFile = new File(directory.getPath(), fileName);
						File localFile = new File(directory.getPath(), fileName);

						// move the file from memory to the file

						photoInMemory.transferTo(localFile);
						advert.setFilename(localFile.getPath());
						System.out.println("File is stored at" + localFile.getPath());
						
						

					} else {
						System.out.println("Failed to create directory!");
					}
				}

			} catch (IllegalStateException e) {
				System.out.println("*** IllegalStateException: " + e.getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("*** IOException: " + e.getMessage());
			} 
			
			//code ends here
			//advert = advertDao.create(advert);

			advert = advertDao.create(advert);
			System.out.println("categoryDesc  :"+advert.getcategoryDescription());
			
		   return new ModelAndView("addItem-Form","advert",advert);
	}
	
	@RequestMapping(value = "/veiwMyAdds", method = RequestMethod.GET)
	protected ModelAndView myAdds(HttpServletRequest request){
		
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		User u=(User) session.getAttribute("user");
		int userAccountId=(int) u.getUserAccountId();
		List<Advertisement> adList=advertDao.searchByAccount(userAccountId);
		int size=adList.size();
		mv.addObject("adList", adList);
		mv.addObject("size",size);
		System.out.println("The user Account " +userAccountId);
		mv.setViewName("my-Adds");
		return mv;
		
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	protected String deleteAd(HttpServletRequest request){
		int id=Integer.parseInt(request.getParameter("id"));
		advertDao.delete(id);
		
		return "my-Adds";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	
	protected ModelAndView searchAdd(HttpServletRequest request){
		String keyword=request.getParameter("keyword");
		System.out.println("The keyword is "+keyword);
		
		String city=request.getParameter("city");
		List<Advertisement> adList=advertDao.userSearch(keyword, city);
		
		return new ModelAndView("search-result","adList",adList);
	}

}
