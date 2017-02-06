package com.fsamuels.contactmanager.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fsamuels.contactmanager.domain.Contact;
import com.fsamuels.contactmanager.jdbc.ContactRowMapper;

/**
 * Implementation of the Data Access Object for Contact. This class manages the database interactions
 * for persisting Contact objects.
 * 
 * TODO: Add created and modified dates to tables for auditing
 * 
 * @author Forrest
 */
public class ContactDAOImpl implements ContactDAO {

	public static int STATUS_ACTIVE 	= 1;
	public static int STATUS_DELETED 	= 2;
		
	@Autowired
	DataSource dataSource;
	
	/**
	 * Create a Person and Address in the database from a {@link Contact}.
	 * TODO: This needs to be done in a Transaction.
	 */
	public void create(Contact contact) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		int addressId = template.queryForObject("INSERT INTO address (address1, city, state, zip) VALUES (?,?,?,?) RETURNING id",
									new Object[]{ contact.getAddress1(), contact.getCity(), contact.getState(), contact.getZipCode() },
									Integer.class);
		
		template.update("INSERT INTO person (first_name, last_name, email, address_id, status_id) VALUES (?,?,?,?,?)",
				new Object[]{ contact.getFirstName(), contact.getLastName(), contact.getEmail(), addressId, STATUS_ACTIVE });
		
	}

	/**
	 * Update the Person and Address for a {@link Contact}.
	 * TODO: This needs to be done in a Transaction.
	 */
	public void update(Contact contact) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		int addressId = template.queryForObject("SELECT address_id FROM person WHERE id = " + contact.getId(), Integer.class);
		
		template.update("UPDATE person SET first_name = ?, last_name = ?, email = ? WHERE id = ?",
				new Object[]{ contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getId() });

		template.update("UPDATE address SET address1 = ?, city = ?, state = ?, zip = ? WHERE id = ?",
				new Object[]{ contact.getAddress1(), contact.getCity(), contact.getState(), contact.getZipCode(), addressId });
		
	}

	/**
	 * Mark the Person as deleted for the {@link Contact} id (contact id == person id)
	 */
	public void delete(String id) {
		JdbcTemplate template = new JdbcTemplate(dataSource);			
		template.execute("UPDATE person SET status_id = " + STATUS_DELETED + " WHERE id = " + id);
	}

	/**
	 * Return the active {@link Contact} based on the id
	 */
	public Contact getContact(String id) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		return template.query("SELECT person.id AS person_id, * FROM person, address WHERE person.status_id = " + STATUS_ACTIVE + " AND person.address_id = address.id AND person.id = " + id, new ContactRowMapper()).get(0);
	}

	/**
	 * Returns a list of all active {@link Contact} objects.
	 */
	public List<Contact> getContacts() {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		return template.query("SELECT person.id AS person_id, * FROM person, address WHERE person.status_id = " + STATUS_ACTIVE + " AND person.address_id = address.id", new ContactRowMapper());
	}

}
