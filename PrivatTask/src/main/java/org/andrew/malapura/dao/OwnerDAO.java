package org.andrew.malapura.dao;

import java.util.List;

import org.andrew.malapura.entity.Owner;

public interface OwnerDAO extends GeneralizedDAO<Owner> {
	
	/**
	 * 
	 * @param Ф.И.О. владельца Л.С.
	 * @return объект ВЛАДЕЛЕЦ
	 */
	List<Owner> getOwnerByName(String firstName, String patronymic, String secondName);

}
