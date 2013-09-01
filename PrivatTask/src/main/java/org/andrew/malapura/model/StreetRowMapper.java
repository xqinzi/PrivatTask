package org.andrew.malapura.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.andrew.malapura.entity.Street;
import org.springframework.jdbc.core.RowMapper;
/**
 * 
 *  ������  ������ � ������� ����� 
 * 
 * @author mav
 *
 */
public class StreetRowMapper implements RowMapper {
	
	Street street;

	/**
	 * @return the street
	 */
	public final Street getStreet() {
		return street;
	}

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
 
		 if(street == null ) street = new Street();
		
		/**
		 *    ���������� ������� �� ������� ���� ResultSet
		 */

		street.setId(rs.getLong("ID"));
		street.setStreetName(rs.getString("STREET_NAME"));
		
		return null;
	}

}
