package com.dlabs.service;

import org.springframework.stereotype.Service;

import com.dlabs.dto.EmployeeDto;
import com.dlabs.exception.EmployeeNotFound;
import com.dlabs.model.Employee;

/**
 * @author Kamlesh Kumar
 * Date 26-August-2020
 * This is a EmployeeServiceImpl class
 */
@Service
public interface EmployeeService {

	/**
	 * @param name
	 * @return employee
	 * @throws EmployeeNotFound
	 */
	Employee createEmployee(Employee employee);
	
	/**
	 * @param name
	 * @return employee
	 * @throws EmployeeNotFound
	 */
	Employee getEmployee(String empId) throws EmployeeNotFound;
	
	/**
	 * @param employeeDto
	 * @return employee
	 * @throws EmployeeNotFound
	 */
	Employee updateEmployee(EmployeeDto employeeDto) throws EmployeeNotFound;
	
	/**
	 * @param empId
	 * @return employee
	 * @throws EmployeeNotFound
	 */
	Employee deleteEmployee(String empId) throws EmployeeNotFound;
}
