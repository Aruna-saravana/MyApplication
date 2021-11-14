package com.myapplication.person.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myapplication.person.entity.Address;
import com.myapplication.person.entity.Person;
import com.myapplication.person.exception.AddressErrorCodes;
import com.myapplication.person.exception.PersonErrorCodes;
import com.myapplication.person.exception.PersonException;
import com.myapplication.person.repo.AddressRepo;
import com.myapplication.person.repo.PersonRepo;
import com.myapplication.person.request.AddressRequest;
import com.myapplication.person.request.PersonRequest;
import com.myapplication.person.request.PersonUpdateRequest;
import com.myapplication.person.response.AddressData;
import com.myapplication.person.response.AddressResponse;
import com.myapplication.person.response.CountResponse;
import com.myapplication.person.response.PersonData;
import com.myapplication.person.response.PersonResponse;
import com.myapplication.person.response.PersonsResponse;
import com.myapplication.person.service.PersonService;
import com.myapplication.person.constant.AddressConstant;
import com.myapplication.person.constant.PersonConstant;

/**
 * Service Implementation for {@link PersonService} interface
 * 
 * @author Aruna
 *
 * @since 1.0.0
 */
@Component
public class PersonServiceImpl implements PersonService {

	/**
	 * {@link PersonRepo} personRepo
	 */
	@Autowired
	private PersonRepo personRepo;

	/**
	 * {@link AddressRepo} addressRepo
	 */
	@Autowired
	private AddressRepo addressRepo;

	/**
	 * Method to add person
	 */
	@Override
	public PersonResponse addPerson(PersonRequest personRequest) {
		PersonResponse res = new PersonResponse();
		Optional<Person> p = personRepo.findById(personRequest.getId());
		if (p.isPresent()) {
			res.setId(personRequest.getId());
			res.setMessage(PersonConstant.PERSON_ALREADY_EXIST);
			return res;
		}
		Person person = personRequestToEntity(personRequest);
		personRepo.save(person);
		res.setMessage(PersonConstant.PERSON_CREATED);
		res.setId(personRequest.getId());
		return res;
	}

	private Person personRequestToEntity(PersonRequest personRequest) {
		Person person = new Person();
		person.setId(personRequest.getId());
		person.setFirstName(personRequest.getFirstName());
		person.setLastName(personRequest.getLastName());
		return person;
	}

	private Person personUpdateRequestToEntity(PersonUpdateRequest personUpdateRequest, String id) {
		Person person = new Person();
		person.setId(id);
		person.setFirstName(personUpdateRequest.getFirstName());
		person.setLastName(personUpdateRequest.getLastName());
		return person;
	}

	@Override
	public PersonResponse editPerson(PersonUpdateRequest personUpdateRequest, String id) {
		PersonResponse res = new PersonResponse();
		Optional<Person> p = personRepo.findById(id);
		if (p.isPresent()) {
			res.setId(id);
			res.setMessage(PersonConstant.PERSON_NOT_EXIST);
		}
		Person person = personUpdateRequestToEntity(personUpdateRequest, id);
		personRepo.save(person);
		res.setMessage(PersonConstant.PERSON_UPDATED);
		res.setId(id);
		return res;
	}

	@Override
	public PersonResponse deletePerson(String id) {
		PersonResponse res = new PersonResponse();
		Optional<Person> p = personRepo.findById(id);
		if (p.isPresent()) {
			res.setId(id);
			res.setMessage(PersonConstant.PERSON_NOT_EXIST);
		}
		personRepo.deleteById(id);
		res.setMessage(PersonConstant.PERSON_DELETED);
		res.setId(id);
		return res;
	}

	@Override
	public PersonsResponse getPersons() throws PersonException {
		PersonsResponse persons = new PersonsResponse();
		List<Person> peronsList = personRepo.findAll();
		if (peronsList.isEmpty()) {
			throw new PersonException(PersonErrorCodes.EMPTY_PERSON_ERROR_CODE.getErrorCode(),PersonErrorCodes.EMPTY_PERSON_ERROR_CODE.getErrorMessage() );
		}
		persons = mapPersonList(peronsList);
		return persons;
	}

	private PersonsResponse mapPersonList(List<Person> peronsList) {
		PersonsResponse personRes = new PersonsResponse();
		List<PersonData> persons = mapPersonDataList(peronsList);
		personRes.setPersons(persons);
		return personRes;
	}

	private List<PersonData> mapPersonDataList(List<Person> peronsList) {
		List<PersonData> persons = new ArrayList<>();
		for (Person p : peronsList) {
			PersonData pd = new PersonData();
			pd.setId(p.getId());
			pd.setFirstName(p.getFirstName());
			pd.setLastName(p.getLastName());
			List<AddressData> address = mapAddressData(p.getAddress());
			pd.setAddress(address);
			persons.add(pd);
		}
		return persons;
	}

	private List<AddressData> mapAddressData(List<Address> address) {
		List<AddressData> addressData = new ArrayList<>();
		for (Address a : address) {
			AddressData ad = new AddressData();
			ad.setId(a.getId());
			ad.setCity(a.getCity());
			ad.setPersonId(a.getPersonId());
			ad.setPostalCode(a.getPostalCode());
			ad.setState(ad.getState());
			ad.setStreet(ad.getStreet());
			addressData.add(ad);
		}

		return addressData;
	}

	@Override
	public CountResponse getPersonsCount() {
		CountResponse countResponse = new CountResponse();
		long count = personRepo.count();
		countResponse.setMessage("Total count of persons " + String.valueOf(count));
		return countResponse;
	}

	@Override
	public AddressResponse addAddress(AddressRequest addressRequest) throws PersonException {
		AddressResponse adRes = new AddressResponse();
		adRes.setId(addressRequest.getId());
		adRes.setPersonId(addressRequest.getPersonId());
		Person p = personRepo.getById(addressRequest.getPersonId());
		Optional<Address> ad = addressRepo.findById(addressRequest.getId());
		if (ad.isPresent()) {
			throw new PersonException(AddressErrorCodes.ADDRESS_ALREADY_EXIST_ERROR_CODE.getErrorCode(),AddressErrorCodes.ADDRESS_ALREADY_EXIST_ERROR_CODE.getErrorMessage() );
		} else {
			p.getAddress().add(mapAddressToEntity(addressRequest));
		}
		personRepo.save(p);
		adRes.setMessage(AddressConstant.ADDRESS_ADDED);
		return adRes;
	}

	private Address mapAddressToEntity(AddressRequest a) {
		Address ad = new Address();
		ad.setId(a.getId());
		ad.setCity(a.getCity());
		ad.setPersonId(a.getPersonId());
		ad.setPostalCode(a.getPostalCode());
		ad.setState(ad.getState());
		ad.setStreet(ad.getStreet());
		return ad;
	}

	@Override
	public AddressResponse updateAddress(AddressRequest addressRequest) throws PersonException {
		AddressResponse adRes = new AddressResponse();
		Person p = personRepo.getById(addressRequest.getPersonId());
		Optional<Address> ad = addressRepo.findById(addressRequest.getId());
		if (ad.isPresent()) {
			throw new PersonException(AddressErrorCodes.ADDRESS_DOESNT_EXIST_ERROR_CODE.getErrorCode(),AddressErrorCodes.ADDRESS_DOESNT_EXIST_ERROR_CODE.getErrorMessage() );
		} else {
			p.getAddress().add(mapAddressToEntity(addressRequest));
		}
		personRepo.save(p);
		adRes.setId(addressRequest.getId());
		adRes.setPersonId(addressRequest.getPersonId());
		adRes.setMessage(AddressConstant.ADDRESS_UPDATED);
		return adRes;
	}

	@Override
	public AddressResponse deleteAddress(String personId, String id) throws PersonException {
		AddressResponse adRes = new AddressResponse();
		adRes.setId(personId);
		adRes.setPersonId(id);
		Person p = personRepo.getById(personId);
		Optional<Address> ad = addressRepo.findById(id);
		if (ad.isPresent()) {
			throw new PersonException(AddressErrorCodes.ADDRESS_DOESNT_EXIST_ERROR_CODE.getErrorCode(),AddressErrorCodes.ADDRESS_DOESNT_EXIST_ERROR_CODE.getErrorMessage() );
		} else {
			p.getAddress().remove(ad.get());
		}
		personRepo.save(p);
		adRes.setMessage(AddressConstant.ADDRESS_DELETED);
		return adRes;
	}

}
