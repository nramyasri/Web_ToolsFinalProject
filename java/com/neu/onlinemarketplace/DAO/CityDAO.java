package com.neu.onlinemarketplace.DAO;

import java.util.List;

import org.hibernate.Query;

import com.neu.onlinemarketplace.pojo.City;



public class CityDAO extends DAO{

	public List<City> listCity(){
        begin();
        Query q = getSession().createQuery("from City");
        List<City> categories = q.list();
        commit();
        return categories;
	
}
	
}
