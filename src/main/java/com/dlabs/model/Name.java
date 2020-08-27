package com.dlabs.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Kamlesh Kumar
 * Date 26-August-2020
 * This is a Name Model class
 */
@Data
public class Name {

	@NotNull
	@Min(value=3,message = "firstName length should be greater than 3")
	@JsonProperty("firstName")
	private String firstName;
	
	@NotNull(message = "lastName of cannot be blank")
	@JsonProperty("lastName")
	private String lastName;
}
