package com.subrat.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	
	static{
		
		try{
			sessionFactory= new AnnotationConfiguration().configure().buildSessionFactory();
		}
		catch(Throwable th){
			System.err.println("SessionFactory can not be created.. due to.. "+th.getMessage()+th);
			throw new ExceptionInInitializerError(th);
		}
	}
	
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
