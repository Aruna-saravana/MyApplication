/**
 * 
 */
package com.myapplication.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapplication.person.exception.PersonException;
import com.myapplication.person.request.AddressRequest;
import com.myapplication.person.request.PersonRequest;
import com.myapplication.person.request.PersonUpdateRequest;
import com.myapplication.person.response.AddressResponse;
import com.myapplication.person.response.CountResponse;
import com.myapplication.person.response.PersonResponse;
import com.myapplication.person.response.PersonsResponse;
import com.myapplication.person.service.PersonService;

/**
 * Rest Controller for Person Controller Service
 * 
 * @author Aruna
 * 
 *
 * @since 1.0.0
 */
@RestController
public class PersonController {
	
	/**
	 * {@link PersonService} personService
	 */	
	@Autowired
	private PersonService personService;
	
	/**
	 * Controller for adding a new Person
	 * 
	 * @param personRequest {@link PersonRequest} personRequest
	 * @return {@link PersonResponse} response
	 */
	@PutMapping("/person")
	public ResponseEntity<PersonResponse> addPerson(@RequestBody PersonRequest personRequest)
	{
		return new ResponseEntity<>(personService.addPerson(personRequest), HttpStatus.OK);
		
	}
	
	
	/**
	 * Controller for updating a new person
	 * First Name/Last name updated
	 * 
	 * @param personUpdateRequest {@link PersonUpdateRequest} personUpdateRequest
	 * @param id personid
	 * @return {@link PersonResponse} response
	 */
	@PostMapping("/person/{id}")
	public ResponseEntity<PersonResponse> editPerson(@RequestBody PersonUpdateRequest personUpdateRequest,@PathVariable String id)
	{
		return new ResponseEntity<>(personService.editPerson(personUpdateRequest,id), HttpStatus.OK);
	}
	
	/**
	 * Controller for deleting a person
	 * First Name/Last name updated
	 * 
	 * @param id personid
	 * @return {@link PersonResponse} response
	 */
	@DeleteMapping("/person/{id}")
	public ResponseEntity<PersonResponse> deletePerson(@PathVariable String id)
	{
		return new ResponseEntity<>(personService.deletePerson(id), HttpStatus.OK);
	}
	
	/**
	 * Controller for getting a persons
	 * 
	 * @return {@link PersonsResponse} response
	 * @throws PersonException exception when list is empty
	 * 
	 */
	@GetMapping("/persons")
	public ResponseEntity<PersonsResponse> getPersons() throws PersonException
	{
		return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
	}
	
	/**
	 * Controller for getting a person's count
	 * 
	 * @return {@link CountResponse} response
	 * @throws PersonException exception when list is empty
	 * 
	 */
	@GetMapping("/person/count")
	public ResponseEntity<CountResponse> getPersonsCount() throws PersonException
	{
		return new ResponseEntity<>(personService.getPersonsCount(), HttpStatus.OK);
	}
	
	/**
	 * Controller for adding address
	 * @param addressRequest  {@link AddressRequest} addressRequest
	 * @throws PersonException add address
	 * @return {@link AddressResponse} response
	 * 
	 * 
	 *  
	 */
	@PutMapping("/person/address")
	public ResponseEntity<AddressResponse> addAddress(@RequestBody AddressRequest addressRequest) throws PersonException
	{
		return new ResponseEntity<>(personService.addAddress(addressRequest), HttpStatus.OK);
	}
	
	/**
	 * Controller for update address
	 * @param addressRequest  {@link AddressRequest} addressRequest
	 * @throws PersonException updated address
	 * @return {@link AddressResponse} response
	 * 
	 *  
	 */
	@PostMapping("/person/address")
	public ResponseEntity<AddressResponse> updateAddress(@RequestBody AddressRequest addressRequest) throws PersonException
	{
		return new ResponseEntity<>(personService.updateAddress(addressRequest), HttpStatus.OK);
	}
	
	/**
	 * Controller for deleting a address
	 * 
	 * @param personId personId
	 * @param id addressId
	 * @return {@link PersonResponse} response
	 * @throws PersonException no address
	 */
	@DeleteMapping("/person/address/{personId}/{id}")
	public ResponseEntity<AddressResponse> deleteAddress(@PathVariable String personId,@PathVariable String id) throws PersonException
	{
		return new ResponseEntity<>(personService.deleteAddress(personId,id), HttpStatus.OK);
	}


}
