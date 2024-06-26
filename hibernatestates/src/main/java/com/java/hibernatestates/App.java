package com.java.hibernatestates;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class);
    	
    	ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory(sr);
       	Session session = sf.openSession(); 
       	
       	session.beginTransaction();
       	
       	Laptop lap = (Laptop) session.get(Laptop.class, 6); //get
       	System.out.println(lap);
       	
       	Laptop lap1 = (Laptop) session.load(Laptop.class, 6); //load will give proxy object 
       	System.out.println(lap1);
//       	
       	
       	
       	session.getTransaction().commit();
       	
       	/*
	   	Random r = new Random();              	
	   	for(int i=1;i<=50;i++)
	   	{
	   		Laptop lap = new Laptop();
	   		lap.setLid(i);
	   		lap.setBrand("Brand " +i);
	   		lap.setPrice(r.nextInt(10000));
	   		session.save(lap);
	   	}
	   	*/
       	
//       	Laptop l = new Laptop();
//   		l.setLid(51);
//   		l.setBrand("Sony");
//   		l.setPrice(7000);
//   		session.save(l); // object is  in persistent state
//   		l.setPrice(8000);
//
//    	Laptop l2 = new Laptop();
//   		l2.setLid(52);
//   		l2.setBrand("lenovo");
//   		l2.setPrice(7000);
//   		   		   		
//   		session.save(l2); // object is  in persistent state
//   		l2.setPrice(8000);
//    		   	
//       
//	   	session.getTransaction().commit();
//	   	
//   		session.delete(l2); //session.detach(l2) // object is now set to detach set , will not reflect any modification in database
//   		l2.setPrice(6000);

    }
}
