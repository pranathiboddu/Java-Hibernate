package com.javacourse.DemoHibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {  
		
		/*
		
		Laptop lap = new Laptop();
		lap.setLid(101);
		lap.setLname("Dell");
		
		Student s = new Student();
		s.setRollno(1);
		s.setName("pranathi");
		s.setMarks(90);
//		s.setLaptop(lap);
		s.getLaptop1().add(lap);
		
		lap.getStudent1().add(s);

		
		Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sf = config.buildSessionFactory(reg);
		Session session = sf.openSession();
		
       	Transaction tx = session.beginTransaction();

		session.save(lap);
		session.save(s);
		
       	tx.commit();
       	
       	s= (Student)session.get(Student.class, 1);
		System.out.println(s.getName());

		*/
		
		
    	Alien alien = new Alien();
    	AlienName an = new AlienName();
//    	an.setFname("pranathi");
//    	an.setLname("boddu");
//    	an.setMname("");
//    	 
//    	alien.setAid(103);
//    	alien.setAname(an);
//    	alien.setColor("Black");
//    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
    	
    	ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory(sr);
       	Session session = sf.openSession(); 
       	
       	session.beginTransaction();
       	
//       	session.save(alien);
       	
       	
//	   fetch data from database
       alien = (Alien)session.get(Alien.class,101);
//     alien = (Alien)session.get(Alien.class,101); // fetch data from first level cache
       
       
//		query based
//      Query q1 = session.createQuery("from Alien where aid=101");
//      q1.setCacheable(true);  
//      alien = (Alien)q1.uniqueResult();      
        
       System.out.println(alien);
       
       session.beginTransaction().commit();
       session.close();
       
       //new session
       Session session2 = sf.openSession();
       session2.beginTransaction();
      
       
       alien = (Alien)session.get(Alien.class,101);
       System.out.println(alien);
       
       session2.beginTransaction().commit();
       session2.close();

       	
       	
       	
    	
    }
}
