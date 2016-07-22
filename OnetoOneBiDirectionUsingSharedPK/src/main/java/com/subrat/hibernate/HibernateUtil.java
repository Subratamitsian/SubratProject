package com.subrat.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	
	static{
		
		try{
			sessionFactory= new AnnotationConfiguration().configure().buildSessionFactory();
			
		}
		catch(Throwable tx){
			System.out.println("Error in creating SessionFactory..."+tx);
			throw new ExceptionInInitializerError(tx);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		
		return sessionFactory;
	}

}
