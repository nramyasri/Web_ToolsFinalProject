package com.neu.onlinemarketplace.pojo;

import java.sql.Timestamp;

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
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="itemId", unique = true, nullable = false)
    private long itemId;
	
    @Column(name = "dt_published", nullable = false)
    private Timestamp dt_published;
    
    @Column(name = "final_price")
    private float final_price;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userAccountId")
    private User user;
    
    @Column(name = "categoryID")
    private int categoryID;
    
    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public Timestamp getDt_published() {
        return dt_published;
    }

    public void setDt_published(Timestamp dt_published) {
        this.dt_published = dt_published;
    }

    public float getFinal_price() {
        return final_price;
    }

    public void setFinal_price(float final_price) {
        this.final_price = final_price;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
   
    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
      
      
    
    

}
