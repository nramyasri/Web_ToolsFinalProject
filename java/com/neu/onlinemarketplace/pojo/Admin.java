package com.neu.onlinemarketplace.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="adminId", unique = true, nullable = false)
    private long id;
	
	@Column(name = "userName",unique=true,nullable=false)
	private String username;

	@Column(name = "password")
	private String password;
	
	public Admin(){
		
	}
	
	 public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	   

	    public String getpassword() {
	        return password;
	    }

	    public void setpassword(String password) {
	        this.password = password;
	    }
	
	
}
