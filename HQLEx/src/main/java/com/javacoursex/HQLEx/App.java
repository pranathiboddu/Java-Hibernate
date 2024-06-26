package com.javacoursex.HQLEx;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class App 
{
    public static void main( String[] args )
    {
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
    	
    	ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory(sr);
       	Session session = sf.openSession(); 
       	
       	session.beginTransaction();
       	
       	
//       	Random r = new Random();              	
//       	for(int i=1;i<=50;i++)
//       	{
//       		Student s = new Student();
//       		s.setRollno(i);
//       		s.setName("pranathi" +i);
//       		s.setMarks(r.nextInt(100));
//       		session.save(s);
//       	}
       	//HQL Queries
       	Query q = session.createQuery("from Student where marks >50");
       	List<Student> students= q.list();
       	
       	for(Student s : students)
       	{
       		System.out.println(s);
       	}
       	Query q1 = session.createQuery("from Student where rollno =7");
       	Student s1= (Student) q1.uniqueResult();
       	System.out.println(s1);
       	
       	Query q2 = session.createQuery("select rollno,name,marks from Student where rollno =7");
       	Object[] o2 =(Object[]) q2.uniqueResult();
       	
//       	for(Object o : o2)
//       	{
//       		System.out.println(o);
//       	}  
//       	
       	System.out.println(o2[0]+ " : "+ o2[1] + " : " + o2[2]);
       	
       	Query q3 = session.createQuery("select rollno,name,marks from Student");
       	List<Object[]> o3 =(List<Object[]>) q3.list();
       	
       	for(Object[] stud: o3)
       	{
           	System.out.println(stud[0]+ " : "+ stud[1] + " : " + stud[2]);
       	}
       	
       	int b= 60;
//       	Query q4 = session.createQuery("select sum(marks) from Student s where s.marks>60");
       	Query q4 = session.createQuery("select sum(marks) from Student s where s.marks> :b");
       	q4.setParameter("b", b);
       	Long marks = (Long)q4.uniqueResult();
       	System.out.println(marks);

       //SQL Query in Hibernate - Native Queries
       	
       SQLQuery query = session.createSQLQuery("select * from Student where marks >60");
       query.addEntity(Student.class);
       List<Student> l1 = query.list();
       for(Student student1 : l1)  	   
       {
    	   System.out.println(student1);
       }
       	
       SQLQuery query1 = session.createSQLQuery("select name,marks from Student where marks>60");
       query1.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
       List l2 = query1.list();
       
       for(Object o : l2)
       {
    	   Map m = (Map)o;
    	   System.out.println(m.get("name") +" : " +m.get("marks"));
       }
      
       
       session.getTransaction().commit();
    }
}
