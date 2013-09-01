package org.andrew.malapura.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.andrew.malapura.entity.PersonalAccount;
import org.springframework.jdbc.core.RowMapper;
/**
 * 
 * @author mav
 *
 */
public class PersonAccountRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		/**
		 *   	соданиие объекта ЛИЦЕВОЙ СЧЕТ
		 */
		PersonalAccount personalAccount = new PersonalAccount();
		/**
		 * 	заполнение данными из объекта типа ResultSet
		 */
		personalAccount.setId(rs.getLong("ID"));
		personalAccount.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
		personalAccount.setCreatedDate(rs.getDate("CREATED_DATE"));
		personalAccount.setAccountType(rs.getString("ACCOUNT_TYPE"));
		personalAccount.setFlatId(rs.getLong("FLAT_ID"));
		personalAccount.setOwnerId(rs.getLong("OWNER_ID"));
		
		return personalAccount;
	}

}
