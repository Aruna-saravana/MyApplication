package com.myapplication.person.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AddressResponse extends Response {
	
	private String personId;
	
	private String id;

}
