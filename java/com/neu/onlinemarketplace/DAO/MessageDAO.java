package com.neu.onlinemarketplace.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

import com.neu.onlinemarketplace.pojo.Advertisement;
import com.neu.onlinemarketplace.pojo.Message;
import com.neu.onlinemarketplace.pojo.User;

public class MessageDAO extends DAO {

	public Message insertMessage(String message,String messageDate,String fromUser,String toUser,Advertisement ad){
		
		Message m=new Message(); 
		m.setMessage(message);
		m.setMessageDate(messageDate);
		m.setFromUser(fromUser);
		m.setToUser(toUser);
		
		m.setAdvert(ad);	
		begin();
		getSession().save(m);
		 
		 commit();
		
		return m;
	}
	
	
	public List<Message> getMessages(long advertId,String userName){
		
		
		begin();
		Query q = getSession().createQuery("from Message where advert_advertId= :advertId and(fromUser= :userName or toUser= :userName)");
		q.setString("userName",userName);
		q.setLong("advertId", advertId);	
		 List<Message> message = q.list();
		commit();
		return message;
	}
	
	public List<Message> getAdvert(String userName){
		begin();
		
		Query q=getSession().createQuery("from Message where fromUser= :userName or toUser= :userName");
		q.setString("userName", userName);
		q.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Message> messages=q.list(); 
		return messages;
		
	}
	
}
