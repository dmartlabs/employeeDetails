package com.dlabs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Kamlesh Kumar
 * Date 26-August-2020
 * This is a Name Model class
 */
@Data
public class Name {

	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
}
