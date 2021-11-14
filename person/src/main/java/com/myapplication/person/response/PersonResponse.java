/**
 * 
 */
package com.myapplication.person.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Aruna
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class PersonResponse extends Response{
	
	private String id;

}
