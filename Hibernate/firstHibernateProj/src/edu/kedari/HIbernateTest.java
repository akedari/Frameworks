package edu.kedari;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.kedari.dto.Address;
import edu.kedari.dto.College;
import edu.kedari.dto.UserDetails;
import edu.kedari.dto.Vehicle;

public class HIbernateTest {

	public static void main(String[] args) {

		UserDetails user  = new UserDetails();
//		user.setUserId(1);		// because i have marked userId as @GeneratedValue i.e. Auto-generated value = surrogate value
		user.setUserName("Abhijeet");
		
		//Embedded object
		Address addr = new Address();
		addr.setCity("Pune");
		addr.setStreet("JM Road");
		addr.setState("MH");
		addr.setPincode("411042");
		user.setHomeAddress(addr);
	
		
		Address addro = new Address();
		addro.setCity("Chicago");
		addro.setStreet("33rd Street");
		addro.setState("IL");
		addro.setPincode("60616");
		user.setOfficeAddress(addro);
		
		
		
		College clgE = new College();
		clgE.setCity("Pune");
		clgE.setCountry("India");
		clgE.setName("SITE");
		
		College clgM = new College();
		clgM.setCity("Chicago");
		clgM.setCountry("USA");
		clgM.setName("IIT");
		
		user.getListOfCollege().add(clgE);
		user.getListOfCollege().add(clgM);
		
		user.setJoinedDate(new Date());
		user.setDescription("Student at IIT Chicago");
		

		Vehicle veh = new Vehicle();
		veh.setVehicleName("Car");
		Vehicle veh2 = new Vehicle();
		veh2.setVehicleName("Jeep");
		
		user.getVehicle().add(veh);
		user.getVehicle().add(veh2);
		
		
		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.persist(user);
		
//		session.save(user);
//		session.save(veh);
//		session.save(veh2);
		session.getTransaction().commit();
		
//		fetch data from database, we are fetching it using primary key i.e. 1
		session = sessionFactory.openSession();
		session.beginTransaction();
		user =  (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User name: "+ user.getUserName());
		session.close();
		System.out.println("colleges size: "+user.getListOfCollege().size());
		
	}

}
