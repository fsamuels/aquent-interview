package com.fsamuels.contactmanager.service;

import java.util.List;

import com.fsamuels.contactmanager.domain.Contact;

/**
 * 
 * @author Forrest
 *
 */
public interface ContactService {

	public void create(Contact contact);  

	public void update(Contact contact);

	public void delete(String id);
	
	public Contact getContact(String id);
	
	public List<Contact> getContacts();
}
