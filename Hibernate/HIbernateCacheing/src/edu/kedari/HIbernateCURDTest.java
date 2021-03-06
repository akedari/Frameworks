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
		
//		second Level cache
//		UserDetails user =  (UserDetails) session.get(UserDetails.class, 1);
		
//		Query level cache
		Query query = session.createQuery("from UserDetails where userId=1");
		query.setCacheable(true);
		List users = query.list();
		
		
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		
//		Second Level cache
//		UserDetails user2 =  (UserDetails) session2.get(UserDetails.class, 1);
		
		Query query2 = session2.createQuery("from UserDetails where userId=1");
		query2.setCacheable(true);
		users = query2.list();
		
		session2.getTransaction().commit();
		session2.close();
		
		
		
		
//		System.out.println("Resulr size: "+ users.size());
		
		
	}

}
