package com.subrat.springmvc.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.subrat.springmvc.dao.EmployeeDao;
import com.subrat.springmvc.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	

	public Employee findById(int id) {
		return (Employee) getSession().get(Employee.class, id);
	}

	public void saveEmployee(Employee emp) {
		//getSession().persist(emp);
		getSession().save(emp);
		
	}

	public void deleteEmployeeBySsn(String ssn) {
		Query query= getSession().createSQLQuery("delete From Employee where ssn = :ssn");
		query.setString("ssn",ssn);
		query.executeUpdate();
		
		
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		Criteria criteria= getSession().createCriteria(Employee.class);
		
		return (List<Employee>) criteria.list();
	}

	public Employee findEmployeeBySsn(String ssn) {
		Criteria criteria= getSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Employee)criteria.uniqueResult();
	}

}
