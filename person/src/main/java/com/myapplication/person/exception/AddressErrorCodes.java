package com.myapplication.person.exception;

public enum AddressErrorCodes {
	
	ADDRESS_ALREADY_EXIST_ERROR_CODE("AD-01", "Address already exist"),
	ADDRESS_DOESNT_EXIST_ERROR_CODE("AD-02", "Address doesn't exist");

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
	private AddressErrorCodes(String errorCode, String errorMessage) {
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
