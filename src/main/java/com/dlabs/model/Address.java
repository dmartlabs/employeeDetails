package com.dlabs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Kamlesh Kumar
 * Date 26-August-2020
 * This is a Address Model class
 */
@Data
public class Address {

	@JsonProperty("houseNum")
	private String houseNum;
	
	@JsonProperty("city")
	private String City;
	
	@JsonProperty("state")
	private String state;
	
}
