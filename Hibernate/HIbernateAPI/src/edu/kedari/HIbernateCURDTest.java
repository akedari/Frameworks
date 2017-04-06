package edu.kedari;

import java.util.Date;
import java.util.List;

import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import edu.kedari.dto.UserDetails;

public class HIbernateCURDTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		/*Create	
		 * for(int i=0;i<10;i++){
			UserDetails user  = new UserDetails();
			user.setUserName("User"+i);
			session.save(user);
		}*/
		
		
		/*Read
		 * UserDetails user = (UserDetails) session.get(UserDetails.class, 6);
		System.out.println("user Name:"+ user.getUserName());*/
		
		
		/*delete
		 * UserDetails user = (UserDetails) session.get(UserDetails.class, 5);
		session.delete(user);*/
		
		
		/* update
		 * UserDetails user = (UserDetails) session.get(UserDetails.class, 4);
		user.setUserName("Abhijeet");
		session.update(user);*/
		
		/* Basic Queries
		 * Query  query = session.createQuery("select userName from UserDetails");
		query.setFirstResult(5);
		query.setMaxResults(3);
		List<String> users = (List<String>) query.list();*/
		
		
		int minId =5;
		String username = "User8";
		
//		Query  query = session.createQuery("from UserDetails where UserId> ? and userName=:userName");
		
//		NamedQuery example
//		Query query = session.getNamedQuery("UserDetails.byId");
//		query.setInteger(0, minId);
		
		
//		NamedNativeQuery
//		Query query = session.getNamedQuery("UserDetails.byName");
//		query.setString(0, username);
		
		
		
//		Simple Criteria
//		Criteria cr = session.createCriteria(UserDetails.class);
//		cr.add(Restrictions.eq("userName", "User8"));
//		List<UserDetails> users = (List<UserDetails>) cr.list();
		
		
		
//		Criteria Projection
//		Criteria cr = session.createCriteria(UserDetails.class)
//				 .setProjection(Projections.property("userName"))
//				 .addOrder(Order.desc("userName"));
//		List<String> users = (List<String>) cr.list();

		
//		Query By Example
		UserDetails exampleUser = new UserDetails();
		exampleUser.setUserId(5);
		exampleUser.setUserName("User8");
		
		Example example = Example.create(exampleUser);
		
		Criteria cr = session.createCriteria(UserDetails.class)
							 .add(example);
		List<UserDetails> users = (List<UserDetails>) cr.list();
		
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Resulr size: "+ users.size());
		
		
	}

}
