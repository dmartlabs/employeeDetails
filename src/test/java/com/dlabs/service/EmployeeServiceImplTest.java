package com.dlabs.service;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.dlabs.dto.EmployeeDto;
import com.dlabs.exception.EmployeeNotFound;
import com.dlabs.model.Address;
import com.dlabs.model.Employee;
import com.dlabs.model.Name;
import com.dlabs.repo.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;


/**
 * @author Kamlesh Kumar
 * Date 27-August-2020
 * This is a EmployeeServiceImplTest class, use for Junit testing of EmployeeServiceImpl class
 */
@SpringBootTest
@Slf4j
class EmployeeServiceImplTest {

	@InjectMocks
	EmployeeService employeeService = new EmployeeServiceImpl();

	@Mock
	EmployeeRepository employeeRepository;

	private Employee setupEmployee = new Employee();
	private Name setupName = new Name();
	private Address setupAddress = new Address();

	/**
	 * Use to setup employeeDetails in Employee Model
	 */
	
	@BeforeEach
	public void setUp() {

		setupName.setFirstName("Rahul");
		setupName.setLastName("Kumar");

		setupAddress.setHouseNum("13 A");
		setupAddress.setCity("Danapur");
		setupAddress.setState("Bihar");
		setupEmployee.setEmpId("12345678");
		setupEmployee.setName(setupName);
		setupEmployee.setAddress(setupAddress);
		setupEmployee.setEmpId("9876543210");
	}
	
	/**
	 * Use to test employeeService.getEmployee()
	 */
	
	@Test
	@DisplayName("CreateEmployee")
	public void testCreateEmployee() {
		log.info("inside testCreateEmployee");
		log.info("Use to test employeeService.createEmployee()");
		
		when(employeeRepository.save(setupEmployee)).thenReturn(setupEmployee);
		assertEquals(setupEmployee, employeeService.createEmployee(setupEmployee));
		
		log.info("testCreateEmployee completed");
	}
	
	/**
	 * Use to test employeeService.getEmployee()
	 */
	
	@Test
	@DisplayName("GetEmployee")
	public void testGetEmployee() throws EmployeeNotFound {
		log.info("inside testGetEmployee");
		log.info("Use to test employeeService.getEmployee()");
		
		when(employeeRepository.findById("12345678")).thenReturn(Optional.of(setupEmployee));
		assertEquals(setupEmployee, employeeService.getEmployee("12345678"));
		
		log.info("testGetEmployee completed");
	}
	
	/**
	 * Use to test exception in employeeService.getEmployee()
	 */
	
	@Test
	@DisplayName("GetEmployee_Exception")
	public void testGetEmployeeException() throws EmployeeNotFound {
		log.info("inside testGetEmployee");
		log.info("Use to test employeeService.getEmployee()");
		
		when(employeeRepository.findById("12345679")).thenReturn(Optional.empty());
		assertThrows(EmployeeNotFound.class, () ->  employeeService.getEmployee("12345679"));
		
		log.info("testGetEmployeeException completed");
	}
	
	/**
	 * Use to test employeeService.updateEmployee()
	 */
	
	@Test
	@DisplayName("UpdateEmployee")
	public void testUpdateEmployee() throws EmployeeNotFound {
		log.info("inside testUpdateEmployee");
		log.info("Use to test employeeService.updateEmployee()");
		
		EmployeeDto setupEmpDto = new EmployeeDto();
		Address setupAddress = new Address();

		setupAddress.setHouseNum("18 B");
		setupAddress.setCity("Patna");
		setupAddress.setState("Bihar");

		setupEmpDto.setEmpId("12345678");
		setupEmpDto.setAddress(setupAddress);
		setupEmpDto.setPhone("8980896105");

		when(employeeRepository.findById("12345678")).thenReturn(Optional.of(setupEmployee));
		assertNotEquals(setupEmployee, employeeService.updateEmployee(setupEmpDto));
		
		log.info("testUpdateEmployee completed");
	}
	
	/**
	 * Use to test exception in  employeeService.updateEmployee()
	 */
	
	@Test
	@DisplayName("UpdateEmployee_Exception")
	public void testUpdateEmployeeException() throws EmployeeNotFound {
		log.info("inside testUpdateEmployeeException");
		log.info("Use to test exception in employeeService.updateEmployee()");
		
		EmployeeDto setupEmpDto = new EmployeeDto();
		when(employeeRepository.findById("12345679")).thenReturn(Optional.empty());
		assertThrows(EmployeeNotFound.class, () ->  employeeService.updateEmployee(setupEmpDto));
		
		log.info("testUpdateEmployeeException completed");
	}
	
	/**
	 * Use to test employeeService.deleteEmployee()
	 */
	
	@Test
	@DisplayName("DeleteEmployee")
	public void testDeleteEmployee() throws EmployeeNotFound {
		log.info("inside testDeleteEmployee");
		log.info("Use to test employeeService.deleteEmployee()");
		
		when(employeeRepository.findById("12345678")).thenReturn(Optional.of(setupEmployee));
		assertEquals(setupEmployee, employeeService.deleteEmployee("12345678"));
		
		log.info("testDeleteEmployee completed");
	}
	
	/**
	 * Use to test exception in  employeeService.deleteEmployee()
	 */
	
	@Test()
	@DisplayName("DeleteEmployee_Exception")
	public void testDeleteEmployeeException() throws EmployeeNotFound {
		log.info("inside testDeleteEmployeeException");
		log.info("Use to test exception in  employeeService.deleteEmployee()");
		
		when(employeeRepository.findById("12345679")).thenReturn(Optional.empty());
		assertThrows(EmployeeNotFound.class, () ->  employeeService.deleteEmployee("12345679"));
		
		log.info("testDeleteEmployeeException completed");
	}
}
