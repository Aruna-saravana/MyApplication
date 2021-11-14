package com.myapplication.person.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {
	
	@Id
	private String id;
	
	@Column(name="person_id")
	private String personId;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="postal_code")
	@Pattern(regexp = "[0-9]+")
	private String postalCode;


}
