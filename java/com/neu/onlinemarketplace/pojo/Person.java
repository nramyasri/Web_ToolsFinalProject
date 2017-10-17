package com.neu.onlinemarketplace.pojo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="person_table")
@Inheritance(strategy=InheritanceType.JOINED) //table per subclass
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userAccountId", unique=true, nullable = false)
	private long userAccountId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name ="lastName")
	private String lastName;
	
	public Person(){
	}
	
	
public long getUserAccountId() {
	        return userAccountId;
	    }

public void setUserAccountId(long userAccountId) {
	        this.userAccountId = userAccountId;
	    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}

