package com.dlabs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dlabs.dto.EmployeeDto;
import com.dlabs.exception.EmployeeNotFound;
import com.dlabs.model.Employee;
import com.dlabs.model.Name;

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
	
	/**
	 * @param name and city
	 * @return List<Employee>
	 */
	List<Employee> getEmployeeByNameAndCity(Name name,String city);

	/**
	 * @param name
	 * @return List<Employee>
	 */
	List<Employee> getEmployeeByName(Name name);
}
