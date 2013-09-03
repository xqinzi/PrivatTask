package org.andrew.malapura.dao;

import java.util.List;

import org.andrew.malapura.entity.Owner;

public interface OwnerDAO extends GeneralizedDAO<Owner> {
	
	/**
	 * 
	 * @param �.�.�. ��������� �.�.
	 * @return ������ ��������
	 */
	List<Owner> getOwnerByName(String firstName, String patronymic, String secondName);

}
