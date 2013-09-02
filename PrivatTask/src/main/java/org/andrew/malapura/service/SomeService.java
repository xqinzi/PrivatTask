package org.andrew.malapura.service;

import java.util.List;

import org.andrew.malapura.entity.Flat;
import org.andrew.malapura.entity.House;
import org.andrew.malapura.entity.Street;
	/**
	 * @author mav
	 *
	 */
public interface SomeService {
	
	/// ----------  методы  CRUD для таблицы УЛИЦА   ---------------------
	/**
	 * Возвращает список всех улиц
	 * @return Arraylist<Street>
	 */
	List<Street> getAllStreet();	
	/**
	 * Поиск улицы по id
	 * @param id
	 * @return УЛИЦА
	 */
	Street findStreetById(Long id);
	/**
	 *  добавить улицу в справочник
	 *  @param объект новая улица
	 */
	void addStreet(Street street);
	/**
	 *   обновление записи УЛИЦА
	 *   
	 *   @param новый объект 
	 */
	void updateStreet(Street street);
	/**
	 *  удаление записи УЛИЦА
	 */
	void deleteStreet(Long id);
	
	/// --------------   методы CRUD для таблицы ДОМ   ---------------------
	/**
	 * Возвращает список всех домов 
	 * @return ArrayList<House>
	 */
	List<House> getAllHouses();
	/**
	 * Поиск ДОМ по id
	 * @param id
	 * @return ДОМ
	 */
	House findHouseById(Long id);
	/**
	 *  добавить ДОМ в справочник
	 *  @param объект новый дом
	 */
	void addHouse(House house);
	/**
	 *   обновление записи ДОМ
	 *   
	 *   @param  объект ДОМ 
	 */
	void updateHouse(House house);
	/**
	 *  удаление записи ДОМ
	 *  @param id записи ДОМ
	 */
	void deleteHouse(Long id);
	
	/// --------------   методы CRUD для таблицы КВАРТИРА   ---------------------
	
	/**
	 * Возвращает список всех квартир 
	 * @return ArrayList<Flat>
	 */
	List<Flat> getAllFlats();
	/**
	 * Поиск КВАРТИРЫ по id
	 * @param id
	 * @return КВАРТИРА
	 */
	Flat findFlatById(Long id);
	/**
	 *  добавить КВАРТИРУ в справочник
	 *  @param объект новая КВАРТИРА
	 */
	void addFlat(Flat flat);
	/**
	 *   обновление записи КВАРТИРА
	 *   
	 *   @param  объект КВАРТИРА 
	 */
	void updateFlat(Flat flat);
	/**
	 *  удаление записи КВАРТИРА
	 *  @param id записи КВАРТИРА
	 */
	void deleteFlat(Long id);
}
