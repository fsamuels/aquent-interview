package com.fsamuels.contactmanager.dao;

import java.util.List;

import com.fsamuels.contactmanager.domain.Contact;

/**
 * 
 * @author Forrest
 *
 */
public interface ContactDAO {

	/**
	 * Creates a new contact.
	 * @param contact
	 */
	public void create(Contact contact);  
	
	/**
	 * Updates an existing contact.
	 * @param contact
	 */
	public void update(Contact contact);
	
	/**
	 * Deletes and existing contact based on the unique contact ID.
	 * @param id
	 */
	public void delete(String id);
	
	/**
	 * Returns the {@link Contact} for the specified ID or NULL if no contact is found.
	 * @param id
	 * @return
	 */
	public Contact getContact(String id);
	
	/**
	 * Returns a list of all Contacts.
	 * @return
	 */
	public List<Contact> getContacts();
	
	 
}
