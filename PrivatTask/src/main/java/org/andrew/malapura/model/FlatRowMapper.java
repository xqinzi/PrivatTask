package org.andrew.malapura.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.andrew.malapura.entity.Flat;
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
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
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
	    flat.setHouseId(rs.getLong("HOUSE_ID"));
	    
		return flat;
	}

}
