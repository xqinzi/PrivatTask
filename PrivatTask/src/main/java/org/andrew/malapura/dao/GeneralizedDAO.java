package org.andrew.malapura.dao;

import java.util.List;
/**
 * 
 *      Обобщенный интерфейс содержащий
 *   основные CRUD операции для работы с БД
 * 
 * @author mav
 *
 * @param <T>
 */
public interface GeneralizedDAO<T> {

	void add(T obj);                   // create
	T getById(Long id);               //  read
	List<T> getAll();					 //  read all records
	void update(Long id, T obj);   // update
	void delete(Long id);             // delete
}
