/**
 * 
 */
package com.fsamuels.contactmanager.domain;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Contact model.
 * 
 * @author Forrest
 * 
 */
public class Contact {
	
	private int id;
	
	@NotEmpty
	@Length(min=1, max=30)
	private String firstName;
    
	@NotEmpty
	@Length(min=1, max=30)
	private String lastName;
    
	@NotEmpty
	@Length(min=1, max=30)
	@Email
    private String email;
    
	@NotEmpty
	@Length(min=1, max=60)
    private String address1;
    
	@NotEmpty
	@Length(min=1, max=30)
    private String city;
    
	@NotEmpty
	@Length(min=2, max=2)
    private String state;
    
	@Length(min=5, max=5)
	@Digits(integer=5,fraction=0)
    private String zipCode; 

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
        
}
