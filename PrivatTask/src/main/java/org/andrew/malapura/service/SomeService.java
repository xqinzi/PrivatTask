package org.andrew.malapura.service;

import java.util.List;

import org.andrew.malapura.entity.Street;
	/**
	 * @author mav
	 *
	 */
public interface SomeService {
	
	/// --------------   CRUD ��� ������� �����   ---------------------
	/**
	 * �������� ������ ���� ����
	 * @return
	 */
	List<Street> getAllStreet();	
	/**
	 * ����� ����� �� id
	 * @param id
	 * @return �����
	 */
	Street findStreetById(Long id);
	/**
	 *  �������� ����� � ����������
	 *  @param ������ ����� �����
	 */
	void addStreet(Street street);
	/**
	 *   ���������� ������ �����
	 *   
	 *   @param id ����������� ������
	 *   @param ����� ������ 
	 */
	void updateStreet(Long id, Street street);
	/**
	 *  �������� ������ �����
	 */
	void deleteStreet(Long id);
	
	/// --------------   ������ CRUD ��� ������� ���   ---------------------
}
