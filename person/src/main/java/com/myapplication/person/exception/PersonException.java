package com.myapplication.person.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PersonException extends Exception {
	
	private String code;

	/**
	 * 
	 */
	private static final long serialVersionUID = 8671134916777763394L;
	
	public PersonException(String code, String errorMessage) {
		super(errorMessage);
		this.code=code;
	}

}
