package com.neu.onlinemarketplace.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.onlinemarketplace.DAO.AdvertDAO;
import com.neu.onlinemarketplace.DAO.MessageDAO;
import com.neu.onlinemarketplace.pojo.Advertisement;
import com.neu.onlinemarketplace.pojo.Message;
import com.neu.onlinemarketplace.pojo.User;


@Controller
public class MessageController {
	
	
	@Autowired
	@Qualifier("messageDao")
	private MessageDAO messageDao;
	
	@Autowired
	@Qualifier("advertDao")
	private AdvertDAO advertDao;

	@RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
	protected String MessageSeller(HttpServletRequest request,HttpServletResponse response) {
		String ad=request.getParameter("postedBy");
		int userAccountId=Integer.parseInt(request.getParameter("userAccountId"));
		int advertID=Integer.parseInt(request.getParameter("advertID"));
		HttpSession session=request.getSession();
		System.out.println("***** ad posted by " +ad);
		System.out.println("ad id " +advertID);
		
		session.setAttribute("adPostedBy", ad);
		session.setAttribute("advertId", advertID);
	
		return "Message";
	}
	
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
protected String sendMessage(HttpServletRequest request,HttpServletResponse response) {
	    System.out.println("This is sendMessage method");
		
		HttpSession session=request.getSession();
		String toUser= (String) session.getAttribute("adPostedBy");
		System.out.println("ad posted by " +toUser);
		System.out.println("The advert id " +session.getAttribute("advertId"));
		int advertID=(Integer)(session.getAttribute("advertId"));
		
		
		    
			Date d = new Date();
			String message=request.getParameter("message");
			SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
            String messageDate = format.format(d);
            User u=(User) session.getAttribute("user");
            String userName=u.getUsername();
            Advertisement ad=advertDao.get(advertID);
           
            messageDao.insertMessage(message, messageDate,userName,toUser,ad);
          
            return "Message";
		
		
		
	}
	
	@RequestMapping(value = "/myMessages")
	protected String selectTitle(HttpServletRequest request){
		
		HttpSession session=request.getSession();
		User u=(User) session.getAttribute("user");
        String userName=u.getUsername();
        //List<Message> msgList= messageDao.getMessages(userName);
        //session.setAttribute("msgList", msgList);
        List<Message> m=messageDao.getAdvert(u.getLastName());
        HashSet<Advertisement> adList=new HashSet<Advertisement>();
        for(Message message :m){
        	Advertisement ad=advertDao.get(message.getAdvert().getId());
        	adList.add(ad);
        }
		//List<Advertisement> adList=advertDao.searchByAccount(u.getUserAccountId());
		session.setAttribute("adList", adList);
		
		return "myMessages";
		 
	}
	
	@RequestMapping(value = "/myMessages", method = RequestMethod.POST)
	protected ModelAndView viewMessage(HttpServletRequest request){
		
		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		System.out.println("*** The action is " +action);
		String title=request.getParameter("title");
		System.out.println("the title is " +title);
		User u=(User) session.getAttribute("user");
		long userAccountId=u.getUserAccountId();
		long advertId=advertDao.getAdvertId(title);
		System.out.println("The advert id is " +advertId);
		List<Message> msgList=messageDao.getMessages(advertId,u.getUsername());
		session.setAttribute("msgList", msgList);
		ModelAndView mv=new ModelAndView();
		mv.addObject("msgList", msgList);
		mv.addObject("title",title);
		
		mv.setViewName("myMessages");
		return mv;
		
	}
	
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	protected String chat(HttpServletRequest request){
		
		String toUser=request.getParameter("toUser");
		
		String advertId=request.getParameter("advertID");
		System.out.println("*** The toUser is " +toUser);
		
		HttpSession session=request.getSession();
		User u=(User) session.getAttribute("user");
        String fromUser=u.getUsername();
        System.out.println("*** The fromUser is " +fromUser);
		//messageDao.insertMessage(message, messageDate,userName,adPostedBy,ad);
		session.setAttribute("fromUser", fromUser);
		session.setAttribute("toUser", toUser);
		session.setAttribute("advertId", advertId);
		return "Chat";
		
	}
	@RequestMapping(value = "/chat", method = RequestMethod.POST)
	protected String sendChat(HttpServletRequest request){
		HttpSession session=request.getSession();
		
		String toUser=(String)session.getAttribute("toUser");
		String fromUser=(String) session.getAttribute("fromUser");
		int advertId=Integer.parseInt((String) session.getAttribute("advertId"));
		String message=request.getParameter("message");
		
		System.out.println("*** The toUser is " +toUser);
		System.out.println("*** The fromUser is " +fromUser);
		
		Date d = new Date();
		//String message=request.getParameter("message");
		SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        String messageDate = format.format(d);
        Advertisement ad=advertDao.get(advertId);
		messageDao.insertMessage(message, messageDate,fromUser,toUser,ad);
	
	     return "Chat";
	}
	
}
