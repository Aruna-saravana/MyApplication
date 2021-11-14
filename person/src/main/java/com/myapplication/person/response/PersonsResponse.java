package com.myapplication.person.response;

import java.util.List;

import lombok.Data;

@Data
public class PersonsResponse {
	
	List<PersonData> persons;

}
