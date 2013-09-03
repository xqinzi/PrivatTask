package org.andrew.malapura.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.andrew.malapura.entity.Flat;
import org.andrew.malapura.entity.House;
import org.andrew.malapura.entity.Owner;
import org.andrew.malapura.entity.PersonalAccount;
import org.andrew.malapura.entity.Street;
import org.springframework.jdbc.core.RowMapper;
/**
 * 
 * @author mav
 *
 */
public class PersonalAccountRowMapper implements RowMapper {
	
	  PersonalAccount personalAccount;

	public PersonalAccount getPersonalAccount() {
			return personalAccount;
		}

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		/**
		 *   	соданиие объекта ЛИЦЕВОЙ СЧЕТ
		 */
		personalAccount = new PersonalAccount();
		/**
		 * 	заполнение данными из объекта типа ResultSet
		 */
		personalAccount.setId(rs.getLong("ID"));
		personalAccount.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
		personalAccount.setCreatedDate(rs.getDate("CREATED_DATE"));
		personalAccount.setAccountType(rs.getString("ACCOUNT_TYPE"));
			   Flat flat = new Flat();
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
		personalAccount.setFlat(flat);	
		/**
   	  	*     Вставляем объект ВЛАДЕЛЕЦ в объект ЛИЦЕВОЙ СЧЕТ
   	    */
			    	Owner owner = new Owner();
			    		owner.setId(rs.getLong("ID"));
			    		owner.setBirthday(rs.getDate("BIRTHDAY"));								// дата рождения
			    		owner.setFirstName(rs.getString("FIRST_NAME"));						// Имя
			    		owner.setPatronymic(rs.getString("PATRONYMIC"));					// Отчество
			    		owner.setSecondName(rs.getString("SECOND_NAME"));				// Фамилия	
			    		owner.setInn(rs.getString("INN"));											// Индефикационный код
		personalAccount.setOwner(owner);
		
		return personalAccount;
	}

}
