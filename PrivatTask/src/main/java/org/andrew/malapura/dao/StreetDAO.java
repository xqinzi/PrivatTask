package org.andrew.malapura.dao;

import org.andrew.malapura.entity.Street;
    /**
     * 
     * @author mav
     *  
     */
public interface StreetDAO extends GeneralizedDAO<Street>{
		/**
		 *   ���������� ������ ����� �� ��������
		 *   @param �������� �����
		 *   @return ������ �����
		 */
		Street findStreetByName(String nameStreet);
}
