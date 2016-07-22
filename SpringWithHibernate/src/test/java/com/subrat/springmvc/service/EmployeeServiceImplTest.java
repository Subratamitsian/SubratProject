package com.subrat.springmvc.service;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.taglibs.standard.tag.common.xml.WhenTag;
import org.joda.time.LocalDate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.BeforeClass;

import com.subrat.springmvc.dao.EmployeeDao;
import com.subrat.springmvc.model.Employee;
import com.subrat.springmvc.serviceImpl.EmployeeServiceImpl;

public class EmployeeServiceImplTest  {
	
	@Mock
	EmployeeDao dao;
	
	@InjectMocks
	EmployeeServiceImpl empService;
	
	@Spy
	List<Employee> employees= new ArrayList<Employee>();
	
	@BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        employees = getEmployeeList();
    }

	  public List<Employee> getEmployeeList(){
	        Employee e1 = new Employee();
	        e1.setId(1);
	        e1.setName("Axel");
	        e1.setJoiningDate(new LocalDate());
	        e1.setSalary(new BigDecimal(10000));
	        e1.setSsn("XXX111");
	         
	        Employee e2 = new Employee();
	        e2.setId(2);
	        e2.setName("Jeremy");
	        e2.setJoiningDate(new LocalDate());
	        e2.setSalary(new BigDecimal(20000));
	        e2.setSsn("XXX222");
	         
	        employees.add(e1);
	        employees.add(e2);
	        return employees;
	    }

	public void findById(int id) {
		
		Employee emp= employees.get(0);
		 when(dao.findById(anyInt())).thenReturn(emp);
		Assert.assertEquals(empService.findById(emp.getId()),emp);
		
	}

	public void saveEmployee() {
		doNothing().when(dao).saveEmployee(any(Employee.class));
		empService.saveEmployee(any(Employee.class));
		verify(dao,atLeastOnce()).saveEmployee(any(Employee.class));
	}

	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	public void deleteEmployeeBySsn(String ssn) {
		// TODO Auto-generated method stub
		
	}

	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee findEmployeeBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		// TODO Auto-generated method stub
		return false;
	}
	  
	  
	     
}
