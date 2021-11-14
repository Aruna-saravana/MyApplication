package com.myapplication.person.exception;

public enum PersonErrorCodes {
	
	EMPTY_PERSON_ERROR_CODE("P-01", "List is empty");

	/**
	 * The errorCode.
	 */
	public final String errorCode;

	/**
	 * The errorMessage.
	 */
	public final String errorMessage;

	/**
	 * The constructor to set exception errorCode and errorMessage.
	 * 
	 * @param errorCode    The error code to be set.
	 * @param errorMessage The error message to be set.
	 */
	private PersonErrorCodes(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * Getter for errorCode.
	 * 
	 * @return the error code.
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Getter for errorMessage.
	 * 
	 * @return the error message.
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

}
