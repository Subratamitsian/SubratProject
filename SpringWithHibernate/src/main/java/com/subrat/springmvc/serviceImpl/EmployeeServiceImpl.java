package com.subrat.springmvc.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subrat.springmvc.dao.EmployeeDao;
import com.subrat.springmvc.model.Employee;
import com.subrat.springmvc.service.EmployeeService;


@Service ("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao empDao;
	

	public Employee findById(int id) {
		
		return empDao.findById(id);
	}

	public void saveEmployee(Employee employee) {

		empDao.saveEmployee(employee);
	}

	public void updateEmployee(Employee employee) {

		Employee emp= empDao.findById(employee.getId());
		if(emp!=null){
			emp.setName(employee.getName());
			emp.setSalary(employee.getSalary());
			emp.setSsn(employee.getSsn());
			emp.setJoiningDate(employee.getJoiningDate());
		}
	}

	public void deleteEmployeeBySsn(String ssn) {
		empDao.deleteEmployeeBySsn(ssn);
		
	}

	public List<Employee> findAllEmployees() {
		
		return empDao.findAllEmployees();
	}

	public Employee findEmployeeBySsn(String ssn) {
		
		return empDao.findEmployeeBySsn(ssn);
	}

	public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		Employee employee= findEmployeeBySsn(ssn);
		
		return (employee==null || ((id!=null) && (employee.getId()==id)));
	}

}
