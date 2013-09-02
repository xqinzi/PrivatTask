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
	
	/// ----------  ������  CRUD ��� ������� �����   ---------------------
	/**
	 * ���������� ������ ���� ����
	 * @return Arraylist<Street>
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
	 *   @param ����� ������ 
	 */
	void updateStreet(Street street);
	/**
	 *  �������� ������ �����
	 */
	void deleteStreet(Long id);
	
	/// --------------   ������ CRUD ��� ������� ���   ---------------------
	/**
	 * ���������� ������ ���� ����� 
	 * @return ArrayList<House>
	 */
	List<House> getAllHouses();
	/**
	 * ����� ��� �� id
	 * @param id
	 * @return ���
	 */
	House findHouseById(Long id);
	/**
	 *  �������� ��� � ����������
	 *  @param ������ ����� ���
	 */
	void addHouse(House house);
	/**
	 *   ���������� ������ ���
	 *   
	 *   @param  ������ ��� 
	 */
	void updateHouse(House house);
	/**
	 *  �������� ������ ���
	 *  @param id ������ ���
	 */
	void deleteHouse(Long id);
	
	/// --------------   ������ CRUD ��� ������� ��������   ---------------------
	
	/**
	 * ���������� ������ ���� ������� 
	 * @return ArrayList<Flat>
	 */
	List<Flat> getAllFlats();
	/**
	 * ����� �������� �� id
	 * @param id
	 * @return ��������
	 */
	Flat findFlatById(Long id);
	/**
	 *  �������� �������� � ����������
	 *  @param ������ ����� ��������
	 */
	void addFlat(Flat flat);
	/**
	 *   ���������� ������ ��������
	 *   
	 *   @param  ������ �������� 
	 */
	void updateFlat(Flat flat);
	/**
	 *  �������� ������ ��������
	 *  @param id ������ ��������
	 */
	void deleteFlat(Long id);
}
