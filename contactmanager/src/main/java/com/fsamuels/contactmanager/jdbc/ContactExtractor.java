/**
 * 
 */
package com.fsamuels.contactmanager.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fsamuels.contactmanager.domain.Contact;

/**
 * @author Forrest
 * Creates a {@link Contact} object from the query ResultSet.
 */
public class ContactExtractor implements ResultSetExtractor<Contact> {

	public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
		Contact contact = new Contact();
		contact.setId(rs.getInt("person_id"));
		contact.setFirstName(rs.getString("first_name"));
		contact.setLastName(rs.getString("last_name"));
		contact.setEmail(rs.getString("email"));
		contact.setAddress1(rs.getString("address1"));
		contact.setCity(rs.getString("city"));
		contact.setState(rs.getString("state"));
		contact.setZipCode(rs.getString("zip"));
		return contact;
	}

}
