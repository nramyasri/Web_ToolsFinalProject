package com.neu.onlinemarketplace.DAO;

import com.neu.onlinemarketplace.pojo.Images;

public class ImageDAO extends DAO {

	
	public Images createImage(Images image){
		
		 begin();            
         getSession().save(image);     
         commit();
         return image;
     
		
		
	}
	
	
	
}
