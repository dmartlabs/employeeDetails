package com.dlabs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Kamlesh Kumar
 * Date 26-August-2020
 * This is a Employee Model class
 */
@Data
@Document("Employee")
public class Employee {
	
	@Id
	@JsonProperty("empId")
	public String empId;
	
	@JsonProperty("name")
	public Name name;
	
	@JsonProperty("address")
	public Address address;
	
	@JsonProperty("phone")
	public String phone;

}
