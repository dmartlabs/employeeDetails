package com.dlabs.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.dlabs.dto.EmployeeDto;
import com.dlabs.model.Address;
import com.dlabs.model.Employee;
import com.dlabs.model.Name;
import com.dlabs.service.EmployeeService;
import com.dlabs.setup.JsonResponseSetup;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Kamlesh Kumar
 * Date 27-August-2020
 * This is a EmployeeControllerTest class, use for Junit testing of EmployeeController class
 */

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class EmployeeControllerTest {

	/**
	 * Use to setup mockMvc
	 */
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	EmployeeService employeeService;

	private Employee setupEmployee = new Employee();
	private Name setupName = new Name();
	private Address setupAddress = new Address();
	private List<Employee> setupEmployeeList = new ArrayList<>();

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new EmployeeController()).build();
	}

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
		setupEmployee.setEmpId("12345675");
		setupEmployee.setName(setupName);
		setupEmployee.setAddress(setupAddress);
		setupEmployee.setPhone("9876543210");
		setupEmployeeList.add(setupEmployee);
	}

	/**
	 * Use to test createEmployee() of EmployeeController
	 */

	@Test
	@DisplayName("createEmployee_Controller")
	void testCreateEmployeeController() throws Exception {
		log.info("inside testCreateEmployeeController");
		log.info("Use to test createEmployee() of EmployeeController");

		Mockito.when(employeeService.createEmployee(setupEmployee)).thenReturn(setupEmployee);
		mockMvc.perform(post("/employee").content(JsonResponseSetup.EMPLOYEE_RESPONSE)
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$.empId").value("12345675"));

		log.info("testCreateEmployeeController completed");
	}

	/**
	 * Use to test updateEmployee() of EmployeeController
	 */

	@Test
	@DisplayName("updateEmployee_Controller")
	void testUpdateEmployeeController() throws Exception {
		log.info("inside testUpdateEmployeeController");
		log.info("Use to test updateEmployee() of EmployeeController");

		EmployeeDto setupEmpDto = new EmployeeDto();
		Address setupAddress = new Address();

		setupAddress.setHouseNum("19 B");
		setupAddress.setCity("Danapur");
		setupAddress.setState("Bihar");

		setupEmpDto.setEmpId("12345675");
		setupEmpDto.setAddress(setupAddress);
		setupEmpDto.setPhone("8980896105");

		Mockito.when(employeeService.updateEmployee(setupEmpDto)).thenReturn(setupEmployee);
		mockMvc.perform(put("/employee").content(JsonResponseSetup.UPDATE_EMPLOYEE_RESPONSE)
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$.address.city").value("Danapur"));

		log.info("testUpdateEmployeeController completed");
	}

	/**
	 * Use to test getEmployee() of EmployeeController
	 */

	@Test
	@DisplayName("getEmployee_Controller")
	public void testGetEmployeeController() throws Exception {
		log.info("inside testGetEmployeeController");
		log.info("Use to test getEmployee() of EmployeeController");

		Mockito.when(employeeService.getEmployee(setupEmployee.getEmpId())).thenReturn(setupEmployee);
		mockMvc.perform(get("/employee/{empId}", 12345675).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$.empId").value("12345675"));

		log.info("testGetEmployeeController completed");
	}

	/**
	 * Use to test deleteEmployee() of EmployeeController
	 */

	@Test
	@DisplayName("deleteEmployee_Controller")
	void testDeleteEmployeeController() throws Exception {
		log.info("inside testDeleteEmployeeController");
		log.info("Use to testdeleteEmployee() of EmployeeController");

		Mockito.when(employeeService.deleteEmployee(setupEmployee.getEmpId())).thenReturn(setupEmployee);
		mockMvc.perform(delete("/employee/{empId}", 12345675).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$.empId").value("12345675"));

		log.info("testDeleteEmployeeController completed");
	}

	/**
	 * Use to test getEmployeeByName() of EmployeeController
	 */

	@Test
	@DisplayName("getEmployeeByName_Controller")
	public void testGetEmployeeByNameController() throws Exception {
		log.info("inside testGetEmployeeByNameController");
		log.info("Use to test getEmployeeByName() of EmployeeController");

		Mockito.when(employeeService.getEmployeeByName(setupName)).thenReturn(setupEmployeeList);
		mockMvc.perform(get("/employee/name").content(JsonResponseSetup.EMPLOYEE_NAME)
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$.*.empId").value("12345675"));

		log.info("testGetEmployeeByNameController completed");
	}

	/**
	 * Use to test getEmployeeByNameAndCity() of EmployeeController
	 */

	@Test
	@DisplayName("getEmployeeByNameAndCity_Controller")
	public void testGetEmployeeByNameAndCityController() throws Exception {
		log.info("inside testGetEmployeeByNameAndCityController");
		log.info("Use to test getEmployeeByNameAndCity() of EmployeeController");

		Mockito.when(employeeService.getEmployeeByNameAndCity(setupName, setupAddress.getCity()))
				.thenReturn(setupEmployeeList);
		mockMvc.perform(
				get("/employee/details").param("city", setupAddress.getCity()).content(JsonResponseSetup.EMPLOYEE_NAME)
						.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$.*.empId").value("12345675"));

		log.info("testGetEmployeeByNameAndCityController completed");
	}
}
