package com.neu.onlinemarketplace.pojo;

import java.sql.Timestamp;
import java.text.DecimalFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cityId", unique = true, nullable = false)
	private long cityId;
	

	@Column(name="city")
    private String city;
	
	
	


   
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

   /* public DecimalFormat getLatitude() {
        return latitude;
    }

    public void setLatitude(DecimalFormat latitude) {
        this.latitude = latitude;
    }

    public DecimalFormat getLongitude() {
        return longitude;
    }

    public void setLongitude(DecimalFormat longitude) {
        this.longitude = longitude;
    }*/

   
	
}
