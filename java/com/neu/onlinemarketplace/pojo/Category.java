package com.neu.onlinemarketplace.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")

public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="categoryId", unique = true, nullable = false)
	private int id;
	
	@Column(name="categoryDescription", unique=true, nullable = false)
    private String categoryDescription;
	
	
	 public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getcategoryDescription() {
	        return categoryDescription;
	    }

	    public void setcategoryDescription(String categoryDescription) {
	        this.categoryDescription = categoryDescription;
	    }
   
	    public Category(){
	    	
	    }
	    
	    public Category(String categoryDescription){
	    	this.categoryDescription=categoryDescription;
	    }
	    
	    @Override 
		public String toString(){
			return categoryDescription;
		}
	
}
