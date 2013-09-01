package org.andrew.malapura.service;

import java.util.List;

import org.andrew.malapura.dao.FlatDAO;
import org.andrew.malapura.dao.HouseDAO;
import org.andrew.malapura.dao.OwnerDAO;
import org.andrew.malapura.dao.PersonalAccountDAO;
import org.andrew.malapura.dao.StreetDAO;
import org.andrew.malapura.entity.Street;

/**
 *  Реализация сервиса SomeService
 * @author mav
 *
 */
public class SomeServiceImpl implements SomeService {
	/**
	 *  инъекция DAO объектов
	 */
	StreetDAO streetDAO;
	FlatDAO flatDAO;
	HouseDAO houseDAO;
	OwnerDAO ownerDAO;
	PersonalAccountDAO personalAccountDAO;
	/**
	 *  список всех записей сущности УЛИЦА
	 */
	public List<Street> getAllStreet() {
		return streetDAO.getAll();
	}
	/**
	 *   получить объект улица по id
	 * @param уникальный ключ записи УЛИЦА
	 */
	public Street findStreetById(Long id) {
		// TODO Auto-generated method stub
		return streetDAO.getById(id);
	}
	/**
	 *  добавить новую запись УЛИЦА
	 */
	public void addStreet(Street street) {
		streetDAO.add(street);	
	}
   /**
    * 		обновление записи УЛИЦА
    */
	public void updateStreet(Long id, Street street) {
		streetDAO.update(id, street);	
	}
	/**
	 *    удаление записи УЛИЦА
	 */
	public void deleteStreet(Long id){
		
	}
	/**
	 *   setters для DAO объектов
	 */
	public void setStreetDAO(StreetDAO streetDAO) {
		this.streetDAO = streetDAO;
	}

	public void setFlatDAO(FlatDAO flatDAO) {
		this.flatDAO = flatDAO;
	}

	public void setHouseDAO(HouseDAO houseDAO) {
		this.houseDAO = houseDAO;
	}

	public void setOwnerDAO(OwnerDAO ownerDAO) {
		this.ownerDAO = ownerDAO;
	}

	public void setPersonalAccountDAO(PersonalAccountDAO personalAccountDAO) {
		this.personalAccountDAO = personalAccountDAO;
	}

}
