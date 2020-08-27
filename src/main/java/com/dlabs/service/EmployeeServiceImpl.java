package com.dlabs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlabs.dto.EmployeeDto;
import com.dlabs.exception.EmployeeNotFound;
import com.dlabs.model.Employee;
import com.dlabs.repo.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Kamlesh Kumar
 * Date 26-August-2020
 * This is a EmployeeServiceImpl class
 */
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	/**
	 * @param employee
	 * @return employee
	 * This is service method for createEmployee
	 */
	@Override
	public Employee createEmployee(Employee employee) {
		log.info("Inside createEmployee()");
		log.debug("Employee Details with id: "+employee.getEmpId()+" saved into db" );
		
		employeeRepository.save(employee);
		
		log.trace("employee: "+employee.toString());
		return employee;
	}

	/**
	 * @param empId
	 * @return employee
	 * @throws EmployeeNotFound
	 *  This is service method for getEmployee
	 */
	@Override
	public Employee getEmployee(String empId) throws EmployeeNotFound {
		log.info("Inside getEmployee()");
		log.debug("Parameter empId: "+empId);
		
		Optional<Employee> employee=employeeRepository.findById(empId);
		if(employee.isEmpty())
		{
			 throw new EmployeeNotFound("Employee Datails Not Available");
		}
		
		log.debug("Get Employee Details with id: "+empId);
		log.trace("employee: "+employee.get().toString());
		return employee.get();
	}


	


	/**
	 * @param employeeDto
	 * @return employee
	 * @throws EmployeeNotFound
	 * This is service method for updateEmployee
	 */
	@Override
	public Employee updateEmployee(EmployeeDto employeeDto) throws EmployeeNotFound {
		log.info("Inside updateEmployee()");
		
		 Optional<Employee> emp=employeeRepository.findById(employeeDto.getEmpId());
		 if(emp.isEmpty())
		 {
			 throw new EmployeeNotFound("Employee Datails Not Available");
		 }
		 
		 log.debug("Employee details with id: "+employeeDto.getEmpId()+" updated into db" );
		 
		 emp.get().setAddress(employeeDto.getAddress());
		 emp.get().setPhone(employeeDto.getPhone());
		 log.trace("employee: "+emp.get().toString());
		 
		 return employeeRepository.save(emp.get());
	}

	
	/**
	 * @param empId
	 * @return employee
	 * @throws EmployeeNotFound
	 * This is service method for deleteEmployee
	 */
	@Override
	public Employee deleteEmployee(String empId) throws EmployeeNotFound {
		log.info("Inside deleteEmployee()");
		log.debug("Parameter empId: "+empId);
		
		Optional<Employee> emp=employeeRepository.findById(empId);
		if(emp.isEmpty())
		{
			throw new EmployeeNotFound("Employee Datails Not Available");
		}
		 log.debug("Employee details with id: "+empId+" deleted from db" );
		 log.trace("employee: "+emp.get().toString());
		 
		employeeRepository.deleteById(empId);
		return emp.get();
	}
}