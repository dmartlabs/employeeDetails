package com.dlabs.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@NotNull()
	@Size(min=5,message = "empid length should be greater than 4")
	@JsonProperty("empId")
	private String empId;
	
	@NotNull(message = "name of employee cannot be blank")
	@JsonProperty("name")
	private Name name;
	
	@NotNull(message = "address of employee cannot be blank")
	@JsonProperty("address")
	private Address address;
	
	@NotNull(message = "phone number cannot be blank")
	@Size(min=10,max=10,message = "length phone number must be 10")
	@JsonProperty("phone")
	private String phone;

}
