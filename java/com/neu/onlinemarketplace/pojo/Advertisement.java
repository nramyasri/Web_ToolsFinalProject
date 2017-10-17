package com.neu.onlinemarketplace.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;




@Entity
@Table(name="advertisement")
public class Advertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="advertID", unique = true, nullable = false)
    private long id;
	
	@Column(name="title")
    private String title;
	
	@Column(name="message")
    private String message;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="advert",cascade = CascadeType.ALL)
	//@CollectionTable
	private List<Images> images;
	
	@Transient
	private CommonsMultipartFile photo;
	
	@Column(name="postedOn")
	private String postedOn;
	
	@Column(name="price")
	private String price;
	
	@Transient
	int postedBy;
	
	@Column(name="city")
	private String city;
	
	@Column(name = "filename")
	private String filename;  
	
	
	
	//@Column(name="filename")
	//private String filename; 
	
    public Advertisement(String title, String message, User user,List<Images> images) {
        this.title = title;
        this.message = message;
        this.user = user; 
        this.images=images;
        //this.categories.add(catergory);
    }

    public Advertisement() {
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name="categoryDescription")
	private String categoryDescription;

	public int getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(int postedBy) {
		this.postedBy = postedBy;
	}

	
	/*public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}*/
	
	public String getcategoryDescription() {
		return categoryDescription;
	}
	public void setcategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public CommonsMultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(CommonsMultipartFile photo) {
		this.photo = photo;
	}
    
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(String postedOn) {
		this.postedOn = postedOn;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}
