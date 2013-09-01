package org.andrew.malapura.service;

import java.util.List;

import org.andrew.malapura.entity.Street;
	/**
	 * @author mav
	 *
	 */
public interface SomeService {
	
	/// --------------   CRUD для таблицы УЛИЦА   ---------------------
	/**
	 * Получить список всех улиц
	 * @return
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
	 *   @param id обновляемой записи
	 *   @param новый объект 
	 */
	void updateStreet(Long id, Street street);
	/**
	 *  удаление записи УЛИЦА
	 */
	void deleteStreet(Long id);
	
	/// --------------   методы CRUD для таблицы ДОМ   ---------------------
}
