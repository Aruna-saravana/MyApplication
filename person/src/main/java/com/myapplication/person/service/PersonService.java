package com.myapplication.person.service;

import org.springframework.stereotype.Service;

import com.myapplication.person.exception.PersonException;
import com.myapplication.person.request.AddressRequest;
import com.myapplication.person.request.PersonRequest;
import com.myapplication.person.request.PersonUpdateRequest;
import com.myapplication.person.response.AddressResponse;
import com.myapplication.person.response.CountResponse;
import com.myapplication.person.response.PersonResponse;
import com.myapplication.person.response.PersonsResponse;

/**
 * Interface provides adding/updating/deleting a person
 * 
 * @author Aruna
 * 
 *
 * @since 1.0.0
 */
@Service
public interface PersonService {

	/**
	 * Service for adding a new Person
	 * 
	 * @param personRequest {@link PersonRequest} personRequest
	 * @return {@link PersonResponse} response
	 */
	public PersonResponse addPerson(PersonRequest personRequest);

	/**
	 * Service for updating a new person
	 * First Name/Last name updated
	 * 
	 * @param personUpdateRequest {@link PersonUpdateRequest} personUpdateRequest
	 * @param id personid
	 * @return {@link PersonResponse} response
	 */
	public PersonResponse editPerson(PersonUpdateRequest personUpdateRequest, String id);

	/**
	 * Service for deleting a person
	 * First Name/Last name updated
	 * 
	 * @param id delete id
	 * @return {@link PersonResponse} response
	 */
	public PersonResponse deletePerson(String id);
	
	/**
	 * Service for getting all persons
	 * 
	 * 
	 * @return {@link PersonsResponse} response
	 * @throws PersonException when empty
	 */
	public PersonsResponse getPersons() throws PersonException;
	
	/**
	 * Service for getting count of Persons
	 * 
	 * 
	 * @return {@link CountResponse} response
	 * 
	 */
	public CountResponse getPersonsCount();
	
	
	/**
	 * Service for adding address
	 * 	 * 
	 * @param addressRequest {@link AddressRequest} addressRequest
	 * @return {@link AddressResponse} response
	 * @throws PersonException address is already present
	 */
	public AddressResponse addAddress(AddressRequest addressRequest) throws PersonException;

	/**
	 * Service for update address
	 * 
	 *@param addressRequest {@link AddressRequest} addressRequest
	 * @return {@link AddressResponse} response
	 * @throws PersonException  when address is empty
	 */
	public AddressResponse updateAddress(AddressRequest addressRequest) throws PersonException;
	/**
	 * Service for deleting address
	 * 
	 * @param personId personId
	 * @param id id of address
	 * @return {@link AddressResponse} response
	 * @throws PersonException when address is empty
	 */
	public AddressResponse deleteAddress(String personId, String id) throws PersonException;
}
