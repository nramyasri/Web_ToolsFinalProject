package com.neu.onlinemarketplace.DAO;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.onlinemarketplace.Exception.UserException;
import com.neu.onlinemarketplace.pojo.Admin;
import com.neu.onlinemarketplace.pojo.User;

public class UserDAO extends DAO {
	
	public UserDAO() {
	}
	
	public User register(User u)
			throws UserException {
		try {
			begin();
			System.out.println("....inside DAO");

			
			User user = new User(u.getUsername(), u.getpassword());

			user.setFirstName(u.getFirstName());
			user.setLastName(u.getLastName());
			user.setUsername(u.getUsername());
			user.setpassword(u.getpassword());
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			user.setdt_created(timeStamp);
			
			getSession().save(user);
			commit();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public User get(int  userAccountId) {
		// TODO Auto-generated method stub
		
		begin();
		Query q = getSession().createQuery("from User where userAccountId= :userAccountId");
		q.setInteger("userAccountId", userAccountId);		
		User user = (User) q.uniqueResult();
		commit();
		return user;
	}

	public User get(String username, String password) {
		// TODO Auto-generated method stub
		begin();
		Query q = getSession().createQuery("from User where username = :username and password = :password");
		q.setString("username", username);
		q.setString("password", password);			
		User user = (User) q.uniqueResult();
		commit();
		return user;
	}
	public Admin getAdmin(String username,String password){
		
		begin();
		Query q = getSession().createQuery("from Admin where username = :username and password = :password");
		q.setString("username", username);
		q.setString("password", password);
		Admin a=(Admin) q.uniqueResult();
		commit();
		return a;
		
	}

}
