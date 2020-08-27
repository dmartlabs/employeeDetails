package com.dlabs.dto;



import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dlabs.model.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
/**
 * @author Kamlesh Kumar
 * Date 26-August-2020
 * This is a EmployeeDto Model class, use to update employee details
 */
@Data
@JsonInclude(Include.NON_NULL)
public class EmployeeDto {

	@NotNull(message = "empId cannot be blank")
	@Size(min=5,message = "empid length should be greater than 4")
	@JsonProperty("empId")
	private String empId;
	
	@NotNull(message = "address of employee cannot be blank")
	@JsonProperty("address")
	private Address address;
	
	@NotNull(message = "phone number cannot be blank")
	@Size(min=10,max=10,message = "length phone number must be 10")
	@JsonProperty("phone")
	private String phone;

}
