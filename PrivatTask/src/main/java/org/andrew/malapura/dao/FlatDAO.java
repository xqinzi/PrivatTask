package org.andrew.malapura.dao;

import org.andrew.malapura.entity.Flat;
    /**
     *  DAO �������� ��������
     * @author mav
     *
     */
public interface FlatDAO extends GeneralizedDAO<Flat>{
	
	/**
	 *  ����� �������� �� ������
	 *  @param �������� �����
	 *  @param ����� ����
	 *  @param ����� ��������
	 *  @return ������ ��������
	 */
	public Flat findFlatByAddress(String streetName, String houseNumber, String flatNumber);
}
