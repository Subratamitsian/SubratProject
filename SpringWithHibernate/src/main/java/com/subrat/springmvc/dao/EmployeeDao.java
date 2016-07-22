package com.subrat.springmvc.dao;

import java.util.List;

import com.subrat.springmvc.model.Employee;

public interface EmployeeDao {

	public Employee findById( int id);
	
	public void saveEmployee(Employee emp);
	
	public void deleteEmployeeBySsn(String ssn);
    
    public List<Employee> findAllEmployees();
 
    public  Employee findEmployeeBySsn(String ssn);
}
