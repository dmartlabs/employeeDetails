package com.dlabs.setup;

/**
 * @author Kamlesh Kumar
 * Date 27-August-2020
 * This is a JsonResponseSetup class, use for setting up string constant
 */

public class JsonResponseSetup {

	/**
	 * Use to setup EMPLOYEE_RESPONSE with Employee json
	 */
	
	public static final String EMPLOYEE_RESPONSE="{   \"empId\":\"12345678\",\r\n" + 
			"    \"name\":{\r\n" + 
			"        \"firstName\":\"Kamlesh\",\r\n" + 
			"        \"lastName\":\"Kumar\"\r\n" + 
			"    },\r\n" + 
			"    \"address\":{\r\n" + 
			"        \"houseNum\":\"13 A\",\r\n" + 
			"         \"city\":\"Danapur\",\r\n" + 
			"         \"state\":\"Bihar\"\r\n" + 
			"    },\r\n" + 
			"    \"phone\":\"9876543210\"\r\n" + 
			"}";
		
	
	/**
	 * Use to setup UPDATE_EMPLOYEE_RESPONSE with EmployeeDto json
	 */
	
	public static final String UPDATE_EMPLOYEE_RESPONSE	="{ \"empId\":\"12345678\",\r\n" + 
			"  \"address\":{\r\n" + 
			"        \"houseNum\":\"19 B\",\r\n" + 
			"         \"city\":\"Patna\",\r\n" + 
			"         \"state\":\"Bihar\"\r\n" + 
			"    },\r\n" + 
			"    \"phone\":\"8980896105\"\r\n" + 
			"}";
}