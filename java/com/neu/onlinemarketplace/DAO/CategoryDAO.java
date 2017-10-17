package com.neu.onlinemarketplace.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.onlinemarketplace.pojo.Category;

public class CategoryDAO extends DAO {
	
	public List<Category> listCategory(){
		
		
            begin();
            Query q = getSession().createQuery("from Category");
            List<Category> categories = q.list();
            commit();
            return categories;
       
		
	}
	
	public Category create(String categoryDescription) {
        
            begin();
            Category cat = new Category(categoryDescription);
            getSession().save(cat);
            commit();
            return cat;
        
    }
	

}
