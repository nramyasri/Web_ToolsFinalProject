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
@Table(name="messages")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="messageId", unique = true, nullable = false)
	private int messageId;
	
	//@OneToOne
	@Column(name = "toUser")
	 private String toUser;
	
	@Column(name="fromUser")
	private String fromUser;
	
	@Column(name = "message")
	private String message;
	
	@Column(name="messageDate")
	private String messageDate;
	
	@ManyToOne
	private Advertisement advert;
	
	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

  
    
    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }
     
	public Message(){
		
	}
	 
	 public Advertisement getAdvert() {
	        return advert;
	    }

	    public void setAdvert(Advertisement advert) {
	        this.advert = advert;
	    }
	    
	    public String getFromUser() {
	        return fromUser;
	    }

	    public void setFromUser(String fromUser) {
	        this.fromUser = fromUser;
	    }

	    public String getToUser() {
	        return toUser;
	    }

	    public void setToUser(String toUser) {
	        this.toUser = toUser;
	    }    

}
