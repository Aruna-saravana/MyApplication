package com.myapplication.person.response;

import lombok.Data;

@Data
public class AddressData {
	
	private String id;
	
	private String personId;
	
	private String street;
	
	private String city;
	
	private String state;

	private String postalCode;

}
