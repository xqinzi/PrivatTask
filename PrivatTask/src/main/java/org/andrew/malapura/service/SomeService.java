package org.andrew.malapura.service;

import java.math.BigDecimal;
import java.util.List;

import org.andrew.malapura.entity.Flat;
import org.andrew.malapura.entity.House;
import org.andrew.malapura.entity.Owner;
import org.andrew.malapura.entity.PersonalAccount;
import org.andrew.malapura.entity.Street;
	/**
	 * 
	 * ������ ��������������� ������ CRUD
	 * � ���������� ������ ������
	 * 
	 * @author mav
	 *
	 */
public interface SomeService {
	
	/**
	 *   ��������� ��� ������ ������� ������
	 */
	int BY_OWNER = 0;   				// �� ���������
	int BY_FLATE = 1;   				// �� �������� (������)
	int BY_HOUSE = 2;					// �� ����	
	int BY_STREET = 3;				// �� �����
	
	/// ----------  ������  CRUD ��� �������� �����   ---------------------
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
	void deleteStreet(Street street);
	
	/// --------------   ������ CRUD ��� �������� ���   ---------------------
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
	void deleteHouse(House house);
	
	/// --------------   ������ CRUD ��� �������� ��������   ---------------------
	
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
	 *   @param  ������ �������� 
	 */
	void updateFlat(Flat flat);
	/**
	 *  �������� ������ ��������
	 *  @param id ������ ��������
	 */
	void deleteFlat(Flat flat);
	
	// **************   ������ CRUD ��� �������� ��������     *************
	
		/**
		 *  ����� ��������� �� ID ������
		 */
		Owner findOwnerById(Long id);
		/**
		 *   ���������� ������ ����������
		 * @return ��������� �������� ��������   
		 */
		List<Owner> getAllOwners();
		/**
		 * 	������ ����� ������ ��������
		 * @param owner(��������)
		 */
		void addOwner(Owner owner);
		/**
		 * 	��������� ������ ��������
		 * @param owner(��������)
		 */
		void updateOwner(Owner owner);
		/**
		 * 	������� ������ ��������
		 * @param owner(��������)
		 */
		void deleteOwner(Owner owner);
		
		// **************     CRUD ��� �������� ������� ����     *************
	         /**
	          * 	�������� ������� ���� �� ID
	          * @param id ������ �������� �����
	          * @return ������ ������� ����
	          */
			 PersonalAccount findPersonalAccountById(Long id);
			/**
			 * 	�������� ������ �.�.
			 * @return ������ ������� ������
			 */
			List< PersonalAccount> getAllPersonalAccounts();
			/**
			 * 	������� ������� ����
			 * @param personalAccount
			 */
			void addPersonalAccount(PersonalAccount personalAccount);
			/**
			 * 	���������� ������ ������� ����
			 * @param personalAccount
			 */
			void updatePersonalAccount(PersonalAccount personalAccount);
			/**
			 * 	������� ������ ������� ����
			 * @param personalAccount
			 */
			void deletePersonalAccount(PersonalAccount personalAccount);
			
		// ************ ����� ������� ������ ******************
			
			/**
			 *   		����� �� �.�.�.
			 *   @param  �.�.�. ���������
			 *   @return List<PersonalAccount>(�������� �.�.)
			 */
			List<PersonalAccount> findByOwnerName(String ownerName, String patronymic, String secondName);
			
			/**
			 *   		����� �� ������ �������� �����
			 *   @param ����� �������� �����
			 *   @return ������� ����
			 */
			PersonalAccount findByPersonalAccountNumber(String personalAccountNumber);
			
			/**
			 *   					����� �� ������
			 *   @param �������� �����
			 *   @param ����� ����
			 *   @param ����� ��������
			 *   @return List<PersonalAccount>(�������� �.�.)
			 */
			List<PersonalAccount> findByAddress(String streetName, String houseNumber, String flatNumber);
			
			/**
			 *   				����� �� ������ ����
			 *   @param ����� ����
			 *   @return List<PersonalAccount>(�������� �.�.)
			 */
			List<PersonalAccount> findByHouseNumber(String houseNumber);
			
			/**
			 *   				����� �� �������� �����
			 *   @param ����� �����
			 *   @return List<PersonalAccount>(�������� �.�.)
			 */
			List<PersonalAccount> findByStreetName(String streetName);
			
		// ************  ������ ������-������  *****************
			
			/**
			 *   ���������� ������ ����������� � ���������� �������
			 */
		BigDecimal getBalance();
}
