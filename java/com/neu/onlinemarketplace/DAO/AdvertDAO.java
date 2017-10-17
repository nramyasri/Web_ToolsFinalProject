package com.neu.onlinemarketplace.DAO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.neu.onlinemarketplace.pojo.Advertisement;
import com.neu.onlinemarketplace.pojo.User;



public class AdvertDAO extends DAO {
	
	
	 public Advertisement create(Advertisement advert){
	            
	           
	            begin();            
	            getSession().save(advert);     
	            commit();
	            return advert;
	        
	    }
	 
	 public List<Advertisement> adminSearch(String category, String city){
		 
		 begin();
         Query q = getSession().createQuery("from Advertisement where categoryDescription= :categoryDescription and city= :city order by postedOn asc");
         q.setString("categoryDescription",category);
         q.setString("city", city);
         List<Advertisement> adverts = q.list();
         commit();
         return adverts;
	 }
	 
	 public List<Advertisement> searchByAccount(long userAccountId){
		 
		 begin();
         Query q = getSession().createQuery("from Advertisement where user_userAccountId= :userAccountId");
         q.setLong("userAccountId",userAccountId);
         List<Advertisement> adverts = q.list();
         commit();
         return adverts;
		 
	 }
	 
	 public void delete(int id){
		 
		 begin();
		 Query q1=getSession().createQuery("delete from Message where advert_advertID=:id");
	     Query q=getSession().createQuery("delete from Advertisement where advertID=:id");
	     q1.setInteger("id",id);
	     q.setInteger("id",id);
	     q1.executeUpdate();
	     q.executeUpdate();
	     commit();
	 }
	 
	 public Advertisement get(long l){
		 
		 begin();
		 Query q = getSession().createQuery("from Advertisement where advertID= :advertID");
			q.setLong("advertID", l);		
			Advertisement a = (Advertisement) q.uniqueResult();
			commit();
			return a;
		 
	 }
	 public Long getAdvertId(String title){
		 begin();
		 Query q = getSession().createQuery("from Advertisement where title= :title");
			//q.setLong("userAccountId", userAccountId);	
			q.setString("title", title);
			Advertisement a = (Advertisement) q.uniqueResult();
			commit();
			return a.getId();
		 
		 
	 }

	public Set<Advertisement> searchByUserName(String userName) {
		// TODO Auto-generated method stub
		
		 Query q = getSession().createQuery("from Advertisement as a join a.Message as m with m.fromUser= :userName or m.toUser= :userName");
	         q.setString("userName",userName);
	         q.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	         HashSet<Advertisement> adverts=new HashSet<Advertisement>(q.list());
	         //List<Advertisement> adverts = q.list();
	         commit();
	         return adverts;	
		
	}
	
 public List<Advertisement> userSearch(String keyword, String city){
		 
		 begin();
		 Criteria crit = getSession().createCriteria(Advertisement.class);
		 Criterion matchMessage = Restrictions.ilike("message",keyword, MatchMode.ANYWHERE);
		 Criterion matchTitle = Restrictions.ilike("title",keyword, MatchMode.ANYWHERE);
		 Criterion matchCategory = Restrictions.ilike("categoryDescription",keyword, MatchMode.ANYWHERE);
		 //Criterion matchcity = Restrictions.ilike("title",keyword, MatchMode.ANYWHERE);
		 Disjunction orExp = Restrictions.or(matchTitle, matchMessage,matchCategory);
		 //crit.add(Restrictions.ilike("message",keyword, MatchMode.ANYWHERE));
		 crit.add(Restrictions.like("city",city));
		 crit.add(orExp);
         List<Advertisement> adverts = crit.list();
         commit();
         return adverts;
	 }
	
	
	 
	 
}

