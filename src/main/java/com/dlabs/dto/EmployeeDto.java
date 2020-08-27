package com.dlabs.dto;

import com.dlabs.model.Address;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
/**
 * @author Kamlesh Kumar
 * Date 26-August-2020
 * This is a EmployeeDto Model class, use to upade employee details
 */
@Data
public class EmployeeDto {

	@JsonProperty("empId")
	private String empId;
	
	@JsonProperty("address")
	private Address address;
	
	@JsonProperty("phone")
    private String phone;
}
