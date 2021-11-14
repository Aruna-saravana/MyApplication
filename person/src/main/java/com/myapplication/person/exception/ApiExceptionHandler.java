package com.myapplication.person.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value =  PersonException.class )
	public ResponseEntity<ServiceError> personErrorHandler(final HttpServletRequest httpServletRequest, PersonException e)
	{
		ServiceError error = new ServiceError(e.getCode(), e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}

	@ExceptionHandler(value = { Exception.class, RuntimeException.class })
	public ResponseEntity<ServiceError> defaultErrorHandler(final HttpServletRequest httpServletRequest, Exception e)
			throws IOException {
		e.printStackTrace();
		ServiceError error = new ServiceError(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
