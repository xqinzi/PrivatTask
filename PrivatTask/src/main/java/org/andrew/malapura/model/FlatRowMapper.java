package org.andrew.malapura.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.andrew.malapura.entity.Flat;
import org.andrew.malapura.entity.House;
import org.andrew.malapura.entity.Street;
import org.springframework.jdbc.core.RowMapper;
/**
 * 
 * @author mav
 *
 */
public class FlatRowMapper implements RowMapper {
	Flat flat;
	
	public final Flat getFlat() {
			return flat;
		}
	
	public Flat mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		flat = new Flat();
	    /**
		/* заполнение данными из объекта типа ResultSet
		 * 
		 */
	    flat.setId(rs.getLong("ID"));
	    flat.setNumber(rs.getInt("NUMBER"));
	    flat.setFloorNum(rs.getInt("FLOOR_NUM"));
	    flat.setDoorWayNum(rs.getInt("DOOR_WAY_NUM"));
	    flat.setSqTotal(rs.getDouble("SQ_TOTAL"));
	    flat.setSqLiv(rs.getDouble("SQ_LIV"));
	     /**
	      *  вставляем объект ДОМ в объект КВАРТИРА
	      */
		        House house = new House();
		    	house.setId(rs.getLong("ID"));
		    	house.setHouseNumber(rs.getString("HOUSE_NUMBER"));
		    	house.setHouseType(rs.getString("HOUSE_TYPE"));
		    	house.setMatType(rs.getString("MAT_TYPE"));
		    	 /**
		    	  *     Вставляем объект УЛИЦА в объект ДОМ  
		    	  */
			    	  Street street = new Street();
					  street.setId(rs.getLong("ID"));
					  street.setStreetName(rs.getString("STREET_NAME"));
				house.setStreet(street);  	    	
	    flat.setHouse(house);
	    
		return flat;
	}

}
