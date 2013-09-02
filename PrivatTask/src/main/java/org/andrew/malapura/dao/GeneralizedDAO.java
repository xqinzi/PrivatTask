package org.andrew.malapura.dao;

import java.util.List;
/**
 * 
 *     ���������� ��������� CRUD ��������
 * 
 * @author mav
 *
 * @param <T>
 */
public interface GeneralizedDAO<T> {

	void add(T obj);                   // create
	T getById(Long id);               //  read
	List<T> getAll();					  //  read all records
	void update(T obj);              // update
	void delete(Long id);            // delete
}
