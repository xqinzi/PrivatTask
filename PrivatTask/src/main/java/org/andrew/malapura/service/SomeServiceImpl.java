package org.andrew.malapura.service;

import java.math.BigDecimal;
import java.util.List;

import org.andrew.malapura.dao.FlatDAO;
import org.andrew.malapura.dao.HouseDAO;
import org.andrew.malapura.dao.OwnerDAO;
import org.andrew.malapura.dao.PersonalAccountDAO;
import org.andrew.malapura.dao.StreetDAO;
import org.andrew.malapura.entity.Flat;
import org.andrew.malapura.entity.House;
import org.andrew.malapura.entity.Owner;
import org.andrew.malapura.entity.PersonalAccount;
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
	public void deleteStreet(Street street){
		streetDAO.delete(street);
	}
	
	// **************     CRUD ��� �������� ���     ********************
	/**
	 *   ���������� ������ �����
	 */
	public List<House> getAllHouses(){	
		return houseDAO.getAll();
	}
	/**
	 *  ����� ���� �� id ������ � ��
	 */
	public House findHouseById(Long id) {
		return houseDAO.getById(id);
	}
	/**
	 *  ������ ����� ������ ���
	 */
	public void addHouse(House house) {
		houseDAO.add(house);
	}
	/**
	 *   ��������� ������ ���
	 */
	public void updateHouse(House house) {
		houseDAO.update(house);
		
	}
	/**
	 *   ������� ������ ���
	 */
	public void deleteHouse(House house) {
		houseDAO.delete(house);
		
	}
	
	// **************     CRUD ��� �������� ��������     *************
	
	/**
	 *   ����� �������� �� ID ������ � ��
	 */
	public Flat findFlatById(Long id) {
		return flatDAO.getById(id);
	}
	/**
	 *  ���������� ������ �������
	 */
	public List<Flat> getAllFlats() {
		return flatDAO.getAll();
	}
	/**
	 *  ������ ����� ������ �������� � ��
	 */
	public void addFlat(Flat flat) {
		flatDAO.add(flat);		
	}
	/**
	 *  ��������� ������ �������� � ��
	 */
	public void updateFlat(Flat flat) {
		flatDAO.update(flat);	
	}
	/**
	 *   ������� ������ ��������
	 */
	public void deleteFlat(Flat flat) {
		flatDAO.delete(flat);		
	}
	
	// **************     CRUD ��� �������� ��������     *************
	
	/**
	 *  ����� ��������� �� ID ������
	 * @param id
	 * @return ������  ��������
	 */
	public Owner findOwnerById(Long id) {
		return ownerDAO.getById(id);
	}
	/**
	 *   ���������� ������ ����������
	 * @return ��������� �������� ��������   
	 */
	public List<Owner> getAllOwners() {
		return  ownerDAO.getAll();
	}
	/**
	 * 	������ ����� ������ ��������
	 * @param owner(��������)
	 */
	public void addOwner(Owner owner) {
		ownerDAO.add(owner);		
	}
	/**
	 * 	��������� ������ ��������
	 * @param owner(��������)
	 */
	public void updateOwner(Owner owner) {
		ownerDAO.update(owner);	
	}
	/**
	 * 	������� ������ ��������
	 * @param owner(��������)
	 */
	public void deleteOwner(Owner owner) {
		ownerDAO.delete(owner);		
	}
	
	// **************     CRUD ��� �������� ������� ����     *************
         /**
          * 	�������� ������� ���� �� ID
          * @param id ������ �������� �����
          * @return ������ ������� ����
          */
		public PersonalAccount findPersonalAccountById(Long id) {
			return personalAccountDAO.getById(id);
		}
		/**
		 * 	�������� ������ �.�.
		 * @return ������ ������� ������
		 */
		public List< PersonalAccount> getAllPersonalAccounts() {
			return personalAccountDAO.getAll();
		}
		/**
		 * 	������� ������� ����
		 * @param personalAccount
		 */
		public void addPersonalAccount(PersonalAccount personalAccount) {
			personalAccountDAO.add(personalAccount);		
		}
		/**
		 * 	���������� ������ ������� ����
		 * @param personalAccount
		 */
		public void updatePersonalAccount(PersonalAccount personalAccount) {
			personalAccountDAO.update(personalAccount);	
		}
		/**
		 * 	������� ������ ������� ����
		 * @param personalAccount
		 */
		public void deletePersonalAccount(PersonalAccount personalAccount) {
			personalAccountDAO.delete(personalAccount);		
		}
		
		// *************** ���������� ������ ������ ******************
		

		public BigDecimal getBalance() {
			// TODO Auto-generated method stub
			return null;
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
