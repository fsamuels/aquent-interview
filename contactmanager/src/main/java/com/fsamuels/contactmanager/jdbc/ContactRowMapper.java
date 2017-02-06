/**
 * 
 */
package com.fsamuels.contactmanager.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fsamuels.contactmanager.domain.Contact;

/**
 * @author Forrest
 * 
 */
public class ContactRowMapper implements RowMapper<Contact> {

	public Contact mapRow(ResultSet rs, int line) throws SQLException {
		return new ContactExtractor().extractData(rs);
	}

}
