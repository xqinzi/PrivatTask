package org.andrew.malapura.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.andrew.malapura.entity.House;
import org.andrew.malapura.entity.Street;
import org.springframework.jdbc.core.RowMapper;
/**
 * 
 *    
 * 
 * @author mav
 *
 */
public class HouseRowMapper implements RowMapper {
	House house;
	
	/**
	 * @return the house
	 */
	public final House getHouse() {
		return house;
	}


	public House mapRow(ResultSet rs, int rowNum) throws SQLException {
		/**
		/* заполнение данными из объекта типа ResultSet
		 * 
		 */
		if(house == null){ house = new House(); }
		house.setId(rs.getLong("ID"));
		house.setHouseNumber(rs.getString("HOUSE_NUNBER"));
		house.setHouseType(rs.getString("HOUSE_TYPE"));
		house.setMatType(rs.getString("MAT_TYPE"));
		  Street street = new Street();
		  street.setStreetName(rs.getString("STREET_NAME"));
		
		return null;
	}

}
