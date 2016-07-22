package com.subrat.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.subrat.springmvc.model.Employee;
import com.subrat.springmvc.service.EmployeeService;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	MessageSource messageSource;
	
	
	@RequestMapping( value={ "/","/list" }, method=RequestMethod.GET)
	public String listEmployees(ModelMap map){
		
		List<Employee> listOfEmployees= empService.findAllEmployees();
		map.addAttribute("employees", listOfEmployees);
		 return "allemployees";
	}
	
	@RequestMapping(value={"/delete-{ssn}-employee"}, method=RequestMethod.GET)
	public String deleteEmployeeBySsn(@PathVariable String ssn){
		empService.deleteEmployeeBySsn(ssn);
		return "redirect:/list";
	}
	
	@RequestMapping(value={"/new"}, method=RequestMethod.GET)
	public String newEmployee(ModelMap map){
		Employee emp= new Employee();
		map.addAttribute("employee",emp);
		map.addAttribute("edit",false);
		//empService.saveEmployee(emp);
		return "registration";
	}
	
	@RequestMapping(value={"/new"}, method=RequestMethod.POST)
	public String saveEmployee(@Valid Employee emp,BindingResult result, ModelMap map){
		if (result.hasErrors()) {
            return "registration";
        }
		if(!empService.isEmployeeSsnUnique(emp.getId(), emp.getSsn())){
            //FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{emp.getSsn()}, Locale.ENGLISH));
            FieldError ssnError =new FieldError("employee","ssn", "SSN "+ emp.getSsn() +" already exist. Please fill in different value");
            result.addError(ssnError);
            return "registration";
        }
		
		empService.saveEmployee(emp);
		map.addAttribute("success","Employee" +emp.getName()+" registered Successfully");
		
		return "success";
	}
	
	
	@RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.GET)
    public String editEmployee(@PathVariable String ssn, ModelMap model) {
        Employee employee = empService.findEmployeeBySsn(ssn);
        model.addAttribute("employee", employee);
        model.addAttribute("edit", true);
        return "registration";
    }
	
	@RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.POST)
	public String updateEmployee(@Valid Employee employee, BindingResult result,
            ModelMap model, @PathVariable String ssn){
		 if (result.hasErrors()) {
	            return "registration";
	        }
	 
	        if(!empService.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
	            FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
	            result.addError(ssnError);
	            return "registration";
	        }
	 
	        empService.updateEmployee(employee);
	 
	        model.addAttribute("success", "Employee " + employee.getName()  + " updated successfully");
	        
		return"success";
	}

}
