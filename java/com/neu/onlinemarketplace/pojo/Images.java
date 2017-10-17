package com.neu.onlinemarketplace.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name="images")
public class Images {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "imageID", unique=true, nullable = false)
	private long imageID;
	
	@Transient
	private CommonsMultipartFile photo;   //for DataBinder to bind <input type="file".../>
										  //will not be mapped for Hibernate as we store the file in the FileSystem
										  //file will be placed into this field by DataBinder
										  //file is in the memory. needs to be transferred to the FileSystem using java.io.file
	@Column(name = "filename")
	private String filename;     
	
	
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

	@ManyToOne
	@JoinColumn(name = "AdvertID", nullable = false)
	private Advertisement advert;
	public Advertisement getAdvert() {
		return this.advert;
	}

	public void setAdvert(Advertisement advert) {
		this.advert = advert;
	}

	
}
