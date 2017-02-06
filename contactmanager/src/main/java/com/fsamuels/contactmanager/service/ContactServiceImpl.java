/**
 * 
 */
package com.fsamuels.contactmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fsamuels.contactmanager.dao.ContactDAO;
import com.fsamuels.contactmanager.domain.Contact;

/**
 * @author Forrest
 *
 */
public class ContactServiceImpl implements ContactService {

	@Autowired  
	private ContactDAO contactDAO;
	
	public void create(Contact contact) {
		contactDAO.create(contact);
	}

	public void update(Contact contact) {
		contactDAO.update(contact);
	}

	public void delete(String id) {
		contactDAO.delete(id);
	}

	public Contact getContact(String id) {
		return contactDAO.getContact(id);
	}

	public List<Contact> getContacts() {
		return contactDAO.getContacts();
	}

}
