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
	 * сервис предоставляющий методы CRUD
	 * и реализацию бизнес логики
	 * 
	 * @author mav
	 *
	 */
public interface SomeService {
	
	/**
	 *   Параметры для поиска ЛИЦЕВЫХ СЧЕТОВ
	 */
	int BY_OWNER = 0;   				// по владельцу
	int BY_FLATE = 1;   				// по квартире (адресу)
	int BY_HOUSE = 2;					// по дому	
	int BY_STREET = 3;				// по улице
	
	/// ----------  методы  CRUD для сущности УЛИЦА   ---------------------
	/**
	 * Возвращает список всех улиц
	 * @return Arraylist<Street>
	 */
	List<Street> getAllStreet();	
	/**
	 * Поиск улицы по id
	 * @param id
	 * @return УЛИЦА
	 */
	Street findStreetById(Long id);
	/**
	 *  добавить улицу в справочник
	 *  @param объект новая улица
	 */
	void addStreet(Street street);
	/**
	 *   обновление записи УЛИЦА
	 *   
	 *   @param новый объект 
	 */
	void updateStreet(Street street);
	/**
	 *  удаление записи УЛИЦА
	 */
	void deleteStreet(Street street);
	
	/// --------------   методы CRUD для сущности ДОМ   ---------------------
	/**
	 * Возвращает список всех домов 
	 * @return ArrayList<House>
	 */
	List<House> getAllHouses();
	/**
	 * Поиск ДОМ по id
	 * @param id
	 * @return ДОМ
	 */
	House findHouseById(Long id);
	/**
	 *  добавить ДОМ в справочник
	 *  @param объект новый дом
	 */
	void addHouse(House house);
	/**
	 *   обновление записи ДОМ
	 *   
	 *   @param  объект ДОМ 
	 */
	void updateHouse(House house);
	/**
	 *  удаление записи ДОМ
	 *  @param id записи ДОМ
	 */
	void deleteHouse(House house);
	
	/// --------------   методы CRUD для сущности КВАРТИРА   ---------------------
	
	/**
	 * Возвращает список всех квартир 
	 * @return ArrayList<Flat>
	 */
	List<Flat> getAllFlats();
	/**
	 * Поиск КВАРТИРЫ по id
	 * @param id
	 * @return КВАРТИРА
	 */
	Flat findFlatById(Long id);
	/**
	 *  добавить КВАРТИРУ в справочник
	 *  @param объект новая КВАРТИРА
	 */
	void addFlat(Flat flat);
	/**
	 *   обновление записи КВАРТИРА
	 *   @param  объект КВАРТИРА 
	 */
	void updateFlat(Flat flat);
	/**
	 *  удаление записи КВАРТИРА
	 *  @param id записи КВАРТИРА
	 */
	void deleteFlat(Flat flat);
	
	// **************   методы CRUD для сущности ВЛАДЕЛЕЦ     *************
	
		/**
		 *  поиск ВЛАДЕЛЬЦА по ID записи
		 */
		Owner findOwnerById(Long id);
		/**
		 *   возвращает список ВЛАДЕЛЬЦЕВ
		 * @return коллекция объектов ВЛАДЕЛЕЦ   
		 */
		List<Owner> getAllOwners();
		/**
		 * 	создаёт новую запись ВЛАДЕЛЕЦ
		 * @param owner(ВЛАДЕЛЕЦ)
		 */
		void addOwner(Owner owner);
		/**
		 * 	обновляет запись ВЛАДЕЛЕЦ
		 * @param owner(ВЛАДЕЛЕЦ)
		 */
		void updateOwner(Owner owner);
		/**
		 * 	удаляет запись ВЛАДЕЛЕЦ
		 * @param owner(ВЛАДЕЛЕЦ)
		 */
		void deleteOwner(Owner owner);
		
		// **************     CRUD для сущности ЛИЦЕВОЙ СЧЕТ     *************
	         /**
	          * 	получить лицевой счет по ID
	          * @param id записи ЛИЦЕВОГО СЧЕТА
	          * @return объект ЛИЦЕВОЙ СЧЕТ
	          */
			 PersonalAccount findPersonalAccountById(Long id);
			/**
			 * 	получить список Л.С.
			 * @return список ЛИЦЕВЫХ СЧЕТОВ
			 */
			List< PersonalAccount> getAllPersonalAccounts();
			/**
			 * 	создать ЛИЦЕВОЙ СЧЕТ
			 * @param personalAccount
			 */
			void addPersonalAccount(PersonalAccount personalAccount);
			/**
			 * 	обновление записи ЛИЦЕВОЙ СЧЕТ
			 * @param personalAccount
			 */
			void updatePersonalAccount(PersonalAccount personalAccount);
			/**
			 * 	удалить запись ЛИЦЕВОЙ СЧЕТ
			 * @param personalAccount
			 */
			void deletePersonalAccount(PersonalAccount personalAccount);
			
		// ************ поиск ЛИЦЕВЫХ СЧЕТОВ ******************
			
			/**
			 *   		поиск по Ф.И.О.
			 *   @param  Ф.И.О. владельца
			 *   @return List<PersonalAccount>(коллеция Л.С.)
			 */
			List<PersonalAccount> findByOwnerName(String ownerName, String patronymic, String secondName);
			
			/**
			 *   		поиск по номеру ЛИЦЕВОГО СЧЕТА
			 *   @param номер ЛИЦЕВОГО СЧЕТА
			 *   @return ЛИЦЕВОЙ СЧЕТ
			 */
			PersonalAccount findByPersonalAccountNumber(String personalAccountNumber);
			
			/**
			 *   					поиск по адресу
			 *   @param название улицы
			 *   @param номер дома
			 *   @param номер квартиры
			 *   @return List<PersonalAccount>(коллеция Л.С.)
			 */
			List<PersonalAccount> findByAddress(String streetName, String houseNumber, String flatNumber);
			
			/**
			 *   				поиск по номеру дома
			 *   @param номер дома
			 *   @return List<PersonalAccount>(коллеция Л.С.)
			 */
			List<PersonalAccount> findByHouseNumber(String houseNumber);
			
			/**
			 *   				поиск по названию улицы
			 *   @param номер улицы
			 *   @return List<PersonalAccount>(коллеция Л.С.)
			 */
			List<PersonalAccount> findByStreetName(String streetName);
			
		// ************  методы БИЗНЕС-ЛОГИКИ  *****************
			
			/**
			 *   возвращает сальдо начисленных и оплаченных средств
			 */
		BigDecimal getBalance();
}
