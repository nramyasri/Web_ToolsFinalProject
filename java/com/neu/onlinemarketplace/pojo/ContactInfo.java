package com.neu.onlinemarketplace.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contactInfo")

public class ContactInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "contactinfoId", unique=true, nullable = false)
	private long contactinfoId;
	
	@Column(name = "contactEmail")
	private String contactEmail;
	
	@Column(name ="contactNumber")
	private long contactNumber;
	
    @OneToOne
    @JoinColumn(name = "userAccountId")
    private Person person;
    
    public long getcontactinfoId() {
		return contactinfoId;
	}

	public void setcontactinfoId(long contactinfoId) {
		this.contactinfoId = contactinfoId;
	}

	public long getcontactNumber() {
		return contactNumber;
	}

	public void setcontactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getcontactEmail() {
		return contactEmail;
	}

	public void setcontactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	

}
