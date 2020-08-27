package com.dlabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dlabs.dto.EmployeeDto;
import com.dlabs.exception.EmployeeNotFound;
import com.dlabs.model.Employee;
import com.dlabs.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Kamlesh Kumar
 * date 26-August-2020
 * This is a EmployeeController class
 */
@RestController
@Slf4j
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	/**
	 * @param employee
	 * @return employee
	 * This is createEmployee method and can be invoked at url /employee
	 */
	@PostMapping(path = "employee",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee createEmployee(@RequestBody Employee employee) {
		log.info("Inside createEmployee() "+this.getClass().getName());
		return employeeService.createEmployee(employee);
	}
	
	/**
	 * @param empId
	 * @return
	 * @throws EmployeeNotFound
	 * This is getEmployee method and can be invoked at url /employee/{empId}
	 */
	@GetMapping(path = "employee/{empId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee(@PathVariable String empId) throws EmployeeNotFound
	{
		log.info("Inside getEmployee() "+this.getClass().getName());
		log.debug("Parameter: "+empId);
		return employeeService.getEmployee(empId);
	}
	
	/**
	 * @param employee
	 * @return
	 * @throws EmployeeNotFound
	 * This is updateEmployee method and can be invoked at url /employee
	 */
	@PutMapping(path="employee",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee updateEmployee(@RequestBody EmployeeDto employeeDto) throws EmployeeNotFound {
		log.info("Inside updateEmployee() "+this.getClass().getName());
		return employeeService.updateEmployee(employeeDto);
	}
	
	/**
	 * @param empId
	 * @return employee
	 * @throws EmployeeNotFound
	 * This is deleteEmployee method and can be invoked at url /employee/{empId}
	 */
	@DeleteMapping(path = "employee/{empId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee deleteEmployee(@PathVariable String empId) throws EmployeeNotFound {
		log.info("Inside deleteEmployee() "+this.getClass().getName());
		log.debug("Parameter: "+empId);
		return employeeService.deleteEmployee(empId);
	}
}
