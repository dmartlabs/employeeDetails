package com.dlabs.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Kamlesh Kumar
 * Date 26-August-2020
 * This is a Address Model class
 */
@Data
public class Address {

	@NotNull(message = "house number of address cannot be blank")
	@JsonProperty("houseNum")
	private String houseNum;
	
	@NotNull(message = "city of address cannot be blank")
	@JsonProperty("city")
	private String city;
	
	@NotNull(message = "state of address cannot be blank")
	@JsonProperty("state")
	private String state;
	
}
