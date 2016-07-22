package com.subrat.hibernate.HibernateStandaloneWithAnnotation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.subrat.hibernate.model.Student;
import com.subrat.hibernate.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
	public  Session getSession(){
		Session session= HibernateUtil.getSessionFactory().openSession();
		
		return session;
	}
	
    public static void main( String[] args )
    {
    	
    	App app= new App();
    	
    	//Saving some student information into database
    	int std1=app.saveStudent("Subrat", "Panda", "CSE");
    	int std3=app.saveStudent("Mukesh", "Nanda", "IT");
    	int std2=	app.saveStudent("Sambit", "Sahu", "ECE");
    	
    	//Retriving all the student information
    	
    	List<Student> allStud= app.getAllStudent();
    	System.out.println("List of Persisted Students are...");
    	for (Student student : allStud) {
			System.out.println("Student is:- "+ student);
		}
    	
    	//Updating one student record
    	app.updateStudent(std1, "Computer Science");
    	
    	//delete student record
    	
    	app.deleteStudent(std2);
    	
    	//get persisted record after delete
    	List<Student> persistedStd= app.getAllStudent();
    	System.out.println("List of Persisted Students are...");
    	for (Student student1 : persistedStd) {
			System.out.println("Student is:- "+ student1);
		}
    }
    
    public int saveStudent(String firstName,String lastName,String section){
    	Student std= new Student();
    	std.setFirstName(firstName);
    	std.setLastName(lastName);
    	std.setSection(section);
    	
    	Session session= HibernateUtil.getSessionFactory().openSession();
    	
    	session.beginTransaction();
    	int id= (Integer)session.save(std);
    	session.getTransaction().commit();
    	session.close();
    	return id;
    }
    
    @SuppressWarnings("unchecked")
	public  List<Student> getAllStudent(){
    	Transaction tx= getSession().beginTransaction();
    	List<Student> allStudent= getSession().createQuery("From Student s Order By s.firstName ASC").list();
    	tx.commit();
    	getSession().close();
    	return allStudent;
    }
    
    public void updateStudent(int id, String section){
    	Transaction tx= getSession().beginTransaction();
    	Student std= (Student) getSession().get(Student.class,id);
    	std.setSection(section);
    	
    	//getSession().update(std);
    	
    	tx.commit();
    	getSession().close();
    	   	
    }
    
    public void deleteStudent(int id){
    	Transaction tx= getSession().beginTransaction();
    	Student std= (Student) getSession().get(Student.class,id);
    	getSession().delete(std);
    	tx.commit();
    	getSession().close();
    }
}
