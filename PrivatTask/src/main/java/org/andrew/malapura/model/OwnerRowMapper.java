package org.andrew.malapura.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.andrew.malapura.entity.Owner;
import org.springframework.jdbc.core.RowMapper;
/**
 * 
 * @author mav
 *
 */
public class OwnerRowMapper implements RowMapper {
	
	Owner owner;

	public final Owner getOwner() {
		return owner;
	}

	public Owner mapRow(ResultSet rs, int rowNum) throws SQLException {
		owner = new Owner();
		
		owner.setId(rs.getLong("ID"));
		owner.setBirthday(rs.getDate("BIRTHDAY"));								// дата рождения
		owner.setFirstName(rs.getString("FIRST_NAME"));						// Имя
		owner.setPatronymic(rs.getString("PATRONYMIC"));					// Отчество
		owner.setSecondName(rs.getString("SECOND_NAME"));				// Фамилия	
		owner.setInn(rs.getString("INN"));											// Индефикационный код
		
		return owner;
	}

}
