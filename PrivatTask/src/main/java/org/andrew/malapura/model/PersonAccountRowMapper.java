package org.andrew.malapura.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.andrew.malapura.entity.PersonAccount;
import org.springframework.jdbc.core.RowMapper;
/**
 * 
 * @author mav
 *
 */
public class PersonAccountRowMapper implements RowMapper {
	
	  PersonAccount personAccount;

	public PersonAccount getPersonalAccount() {
			return personAccount;
		}

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		/**
		 *   	соданиие объекта ЛИЦЕВОЙ СЧЕТ
		 */
		personAccount = new PersonAccount();
		/**
		 * 	заполнение данными из объекта типа ResultSet
		 */
		personAccount.setId(rs.getLong("ID"));
		personAccount.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
		personAccount.setCreatedDate(rs.getDate("CREATED_DATE"));
		personAccount.setAccountType(rs.getString("ACCOUNT_TYPE"));
		personAccount.setFlatId(rs.getLong("FLAT_ID"));
		personAccount.setOwnerId(rs.getLong("OWNER_ID"));
		
		return personAccount;
	}

}
