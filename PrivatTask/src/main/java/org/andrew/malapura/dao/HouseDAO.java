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
	 *  ���������� ��������� ����� �� ������
	 *  @param ����� ����
	 *  @return ��������� �������� ���
	 */
	List<House> findHousesByNumber(String houseNumber);
	/**
	 *  ���������� ��������� ����� �� �����
	 *  @param �������� �����
	 *  @return ��������� �������� ���  
	 */
	List<House> findHousesByStreetName(String streetName);
}
