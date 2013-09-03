package org.andrew.malapura.dao;

import java.util.List;

import org.andrew.malapura.entity.House;

/**
 * 
 * @author mav
 *
 */
public interface HouseDAO extends GeneralizedDAO<House>{
	
	/**
	 *  возвращает коллекцию ДОМОВ по номеру
	 *  @param номер ДОМА
	 *  @return коллекция объектов ДОМ
	 */
	List<House> findHousesByNumber(String houseNumber);
	/**
	 *  возвращает коллекцию ДОМОВ по улице
	 *  @param название улицы
	 *  @return коллекция объектов ДОМ  
	 */
	List<House> findHousesByStreetName(String streetName);
}
