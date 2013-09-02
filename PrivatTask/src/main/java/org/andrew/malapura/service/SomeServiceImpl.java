package org.andrew.malapura.service;

import java.util.List;

import org.andrew.malapura.dao.FlatDAO;
import org.andrew.malapura.dao.HouseDAO;
import org.andrew.malapura.dao.OwnerDAO;
import org.andrew.malapura.dao.PersonalAccountDAO;
import org.andrew.malapura.dao.StreetDAO;
import org.andrew.malapura.entity.Flat;
import org.andrew.malapura.entity.House;
import org.andrew.malapura.entity.Street;

/**
 *  ������������� ������� SomeService
 * @author mav
 *
 */
public class SomeServiceImpl implements SomeService {
	
	/**
	 *    �������� DAO ��������
	 */
	StreetDAO streetDAO; 										 // ��� �������� �����
	FlatDAO flatDAO;													 // ��� �������� ��������
	HouseDAO houseDAO;											 // ��� �������� ���	
	OwnerDAO ownerDAO;										 // ��� �������� ��������
	PersonalAccountDAO personalAccountDAO;			 // ��� �������� ������� ����
	
	// **************     CRUD ��� �������� �����     ********************
	
	/**
	 *  ���������� ������ ���� ����
	 */
	public List<Street> getAllStreet() {
		return streetDAO.getAll();
	}
	/**
	 *   �������� ������ ����� �� id
	 * @param ���������� ���� ������ �����
	 * @return ������ �����
	 * 
	 */
	public Street findStreetById(Long id) {
		return streetDAO.getById(id);
	}
	/**
	 *  �������� ����� ������ �����
	 */
	public void addStreet(Street street) {
		streetDAO.add(street);	
	}
   /**
    * 		���������� ������ �����
    */
	public void updateStreet(Street street) {
		streetDAO.update(street);	
	}
	/**
	 *    �������� ������ �����
	 */
	public void deleteStreet(Long id){
		
	}
	
	// **************     CRUD ��� �������� ���     ********************
	/**
	 *   ���������� ������ ���� �����
	 */
	public List<House> getAllHouses(){	
		return houseDAO.getAll();
	}
	public House findHouseById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void addHouse(House house) {
		// TODO Auto-generated method stub
		
	}
	public void updateHouse(House house) {
		// TODO Auto-generated method stub
		
	}
	public void deleteHouse(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	// **************     CRUD ��� �������� ��������     *************
	
	public Flat findFlatById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Flat> getAllFlats() {
		return flatDAO.getAll();
	}
	public void addFlat(Flat flat) {
		// TODO Auto-generated method stub
		
	}
	public void updateFlat(Flat flat) {
		// TODO Auto-generated method stub
		
	}
	public void deleteFlat(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	// ************   setters ��� DAO �������� ***********************
	
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
