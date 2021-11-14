package com.myapplication.person.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PersonData {
	
	private String id;

	private String firstName;

	private String lastName;

	private List<AddressData> address = new ArrayList<>();


}
