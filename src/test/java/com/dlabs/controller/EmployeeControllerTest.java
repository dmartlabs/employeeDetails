package com.dlabs.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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

	@Autowired
	private MockMvc mockMvc;

	/**
	 * Use to setup mockMvc
	 */
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new EmployeeController()).build();
	}

	/**
	 *  Use to test createEmployee() of EmployeeController
	 */
	
	@Test
	@DisplayName("createEmployee_Controller")
	void testCreateEmployeeController() throws Exception {
		log.info("inside testCreateEmployeeController");
		log.info("Use to test createEmployee() of EmployeeController");

		mockMvc.perform(post("/employee").content(JsonResponseSetup.EMPLOYEE_RESPONSE)
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$.empId").value("12345678"));
		
		log.info("testCreateEmployeeController completed");
	}

	/**
	 *  Use to test updateEmployee() of EmployeeController
	 */
	
	@Test
	@DisplayName("updateEmployee_Controller")
	void testUpdateEmployeeController() throws Exception {
		log.info("inside testUpdateEmployeeController");
		log.info("Use to test updateEmployee() of EmployeeController");
		
		mockMvc.perform(put("/employee").content(JsonResponseSetup.UPDATE_EMPLOYEE_RESPONSE)
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$.address.city").value("Patna"));
		
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
		
		mockMvc.perform(get("/employee/{empId}", 12345678).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$.empId").value("12345678"));
		
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
		
		mockMvc.perform(delete("/employee/{empId}", 12345678).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$.empId").value("12345678"));
		
		log.info("testDeleteEmployeeController completed");
	}

}
