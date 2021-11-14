package com.myapplication.person.request;

import lombok.Data;

@Data
public class AddressRequest {
	
	private String id;
	private String personId;
	private String street;
	private String city;
	private String state;
	private String postalCode;

}
