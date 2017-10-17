package com.neu.onlinemarketplace.pojo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="userAccount")
@PrimaryKeyJoinColumn(name = "userAccountId")
public class User extends Person{
	
	public User(){
		
	}
	public User(String userName,String password){
		userName=username;
		this.password=password;
		
	}
	@Column(name = "dt_created", nullable = false)
    private String dt_created;
	
    @OneToMany(mappedBy = "user")
    private List<Item> itemList;
    
    @Column(name = "userName",unique=true,nullable=false)
	private String username;

	@Column(name = "password")
	private String password;
	
	
	
	public String getdt_created() {
        return dt_created;
    }

    public void setdt_created(String dt_created) {
        this.dt_created = dt_created;
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
