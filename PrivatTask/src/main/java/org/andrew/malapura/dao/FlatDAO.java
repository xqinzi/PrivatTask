package org.andrew.malapura.dao;

import org.andrew.malapura.entity.Flat;
    /**
     *  DAO сущности КВАРТИРА
     * @author mav
     *
     */
public interface FlatDAO extends GeneralizedDAO<Flat>{
	
	/**
	 *  поиск квартиры по адресу
	 *  @param название улицы
	 *  @param номер дома
	 *  @param номер квартиры
	 *  @return объект КВАРТИРА
	 */
	public Flat findFlatByAddress(String streetName, String houseNumber, String flatNumber);
}
