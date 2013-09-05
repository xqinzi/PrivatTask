package org.andrew.malapura.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
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
 *  Имплементация сервиса SomeService
 * @author mav
 *
 */
public class SomeServiceImpl implements SomeService {
	
	/**
	 *    инъекция DAO объектов
	 */
	StreetDAO streetDAO; 										 // для сущности УЛИЦА
	FlatDAO flatDAO;													 // для сущности КВАРТИРА
	HouseDAO houseDAO;											 // для сущности ДОМ	
	OwnerDAO ownerDAO;										 // для сущности ВЛАДЕЛЕЦ
	PersonalAccountDAO personalAccountDAO;			 // для сущности ЛИЦЕВОЙ СЧЕТ
	
	// **************     CRUD для сущности УЛИЦА     ********************
	
	/**
	 *  возвращает список всех УЛИЦ
	 */
	public List<Street> getAllStreet() {
		return streetDAO.getAll();
	}
	/**
	 *   получить объект улица по id
	 * @param уникальный ключ записи УЛИЦА
	 * @return объект УЛИЦА
	 * 
	 */
	public Street findStreetById(Long id) {
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
	public void updateStreet(Street street) {
		streetDAO.update(street);	
	}
	/**
	 *    удаление записи УЛИЦА
	 */
	public void deleteStreet(Street street){
		streetDAO.delete(street);
	}
	
	// **************     CRUD для сущности ДОМ     ********************
	/**
	 *   возвращает список ДОМОВ
	 */
	public List<House> getAllHouses(){	
		return houseDAO.getAll();
	}
	/**
	 *  поиск ДОМа по id записи в БД
	 */
	public House findHouseById(Long id) {
		return houseDAO.getById(id);
	}
	/**
	 *  создаёт новую запись ДОМ
	 */
	public void addHouse(House house) {
		houseDAO.add(house);
	}
	/**
	 *   обновляет запись ДОМ
	 */
	public void updateHouse(House house) {
		houseDAO.update(house);
		
	}
	/**
	 *   удаляет запись ДОМ
	 */
	public void deleteHouse(House house) {
		houseDAO.delete(house);
		
	}
	
	// **************     CRUD для сущности КВАРТИРА     *************
	
	/**
	 *   поиск КВАРТИРЫ по ID записи в БД
	 */
	public Flat findFlatById(Long id) {
		return flatDAO.getById(id);
	}
	/**
	 *  возвращает список КВАРТИР
	 */
	public List<Flat> getAllFlats() {
		return flatDAO.getAll();
	}
	/**
	 *  создаёт новую запись КВАРТИРА в БД
	 */
	public void addFlat(Flat flat) {
		flatDAO.add(flat);		
	}
	/**
	 *  обновляет запись КВАРТИРА в БД
	 */
	public void updateFlat(Flat flat) {
		flatDAO.update(flat);	
	}
	/**
	 *   удаляет запись КВАРТИРА
	 */
	public void deleteFlat(Flat flat) {
		flatDAO.delete(flat);		
	}
	
	// **************     CRUD для сущности ВЛАДЕЛЕЦ     *************
	
	/**
	 *  поиск ВЛАДЕЛЬЦА по ID записи
	 * @param id
	 * @return объект  ВЛАДЕЛЕЦ
	 */
	public Owner findOwnerById(Long id) {
		return ownerDAO.getById(id);
	}
	/**
	 *   возвращает список ВЛАДЕЛЬЦЕВ
	 * @return коллекция объектов ВЛАДЕЛЕЦ   
	 */
	public List<Owner> getAllOwners() {
		return  ownerDAO.getAll();
	}
	/**
	 * 	создаёт новую запись ВЛАДЕЛЕЦ
	 * @param owner(ВЛАДЕЛЕЦ)
	 */
	public void addOwner(Owner owner) {
		ownerDAO.add(owner);		
	}
	/**
	 * 	обновляет запись ВЛАДЕЛЕЦ
	 * @param owner(ВЛАДЕЛЕЦ)
	 */
	public void updateOwner(Owner owner) {
		ownerDAO.update(owner);	
	}
	/**
	 * 	удаляет запись ВЛАДЕЛЕЦ
	 * @param owner(ВЛАДЕЛЕЦ)
	 */
	public void deleteOwner(Owner owner) {
		ownerDAO.delete(owner);		
	}
	
	// **************     CRUD для сущности ЛИЦЕВОЙ СЧЕТ     *************
         /**
          * 	получить лицевой счет по ID
          * @param id записи ЛИЦЕВОГО СЧЕТА
          * @return объект ЛИЦЕВОЙ СЧЕТ
          */
		public PersonalAccount findPersonalAccountById(Long id) {
			return personalAccountDAO.getById(id);
		}
		/**
		 * 	получить список Л.С.
		 * @return список ЛИЦЕВЫХ СЧЕТОВ
		 */
		public List< PersonalAccount> getAllPersonalAccounts() {
			return personalAccountDAO.getAll();
		}
		/**
		 * 	создать ЛИЦЕВОЙ СЧЕТ
		 * @param personalAccount
		 */
		public void addPersonalAccount(PersonalAccount personalAccount) {
			personalAccountDAO.add(personalAccount);		
		}
		/**
		 * 	обновление записи ЛИЦЕВОЙ СЧЕТ
		 * @param personalAccount
		 */
		public void updatePersonalAccount(PersonalAccount personalAccount) {
			personalAccountDAO.update(personalAccount);	
		}
		/**
		 * 	удалить запись ЛИЦЕВОЙ СЧЕТ
		 * @param personalAccount
		 */
		public void deletePersonalAccount(PersonalAccount personalAccount) {
			personalAccountDAO.delete(personalAccount);		
		}
		
		//***************  реализация поиска ***********************
		
		/**
		 *   		поиск ВЛАДЕЛЬЦА по Ф.И.О.
		 *   @param  Ф.И.О. владельца
		 *   @return List<PersonalAccount>(коллеция Л.С.)
		 */
		public List<PersonalAccount> findByOwnerName(String firstName, String patronymic, String secondName){
			/**
			 *      коллекция ВЛАДЕЛЬЦЕВ с заданным ФИО
			 */
			ArrayList<Owner> owners = (ArrayList<Owner>) ownerDAO.getOwnerByName(firstName, patronymic, secondName);
			/**
			 *     коллекция Л.С.
			 */
			ArrayList<PersonalAccount> target = new ArrayList<PersonalAccount>(); 
			
			for(Iterator<Owner> iterator = owners.iterator(); iterator.hasNext();){
					/**
					 *    коллекция объектов Л.С. на данной итерации
					 */
				    ArrayList<PersonalAccount> paList =  (ArrayList<PersonalAccount>) personalAccountDAO.findPersonalAccount(BY_OWNER , iterator.next());
				    /**
				     *     склеиваем коллекции
				     */
				    ArrayList<PersonalAccount> tmp = new ArrayList<PersonalAccount>(target);
				    tmp.addAll(paList);
				    target = tmp;
			}
			return target;
		}
		
		/**
		 *   		поиск по номеру ЛИЦЕВОГО СЧЕТА
		 *   @param номер ЛИЦЕВОГО СЧЕТА
		 *   @return ЛИЦЕВОЙ СЧЕТ
		 */
		public PersonalAccount findByPersonalAccountNumber(String personalAccountNumber){
			return personalAccountDAO.findByAccountNumber(personalAccountNumber);
		}
		
		/**
		 *   		поиск по адресу
		 *   @param название улицы
		 *   @param номер дома
		 *   @param номер квартиры
		 *   @return List<PersonalAccount>(коллеция Л.С.)
		 */
		public List<PersonalAccount> findByAddress(String streetName, String houseNumber, String flatNumber){
						/**
						 *    квартира по данному адресу
						 */
					Flat address = flatDAO.findFlatByAddress(streetName, houseNumber, flatNumber);
					  /**
					   *     коллекция Л.С. для квартиры(адресу)
					   */
					ArrayList<PersonalAccount> target = (ArrayList<PersonalAccount>) personalAccountDAO.findPersonalAccount(BY_FLATE, address);
			return target;
		}
		
		/**
		 *   				поиск по номеру дома
		 *   @param номер дома
		 *   @return List<PersonalAccount>(коллеция Л.С.)
		 */
		public List<PersonalAccount> findByHouseNumber(String houseNumber){			
			/**
			 *      коллекция ВЛАДЕЛЬЦЕВ с заданным номером ДОМА
			 */
			ArrayList<House> houses = (ArrayList<House>) houseDAO.findHousesByNumber(houseNumber);
			/**
			 *     коллекция Л.С.
			 */
			ArrayList<PersonalAccount> target = new ArrayList<PersonalAccount>(); 
			
			for(Iterator<House> iterator = houses.iterator(); iterator.hasNext();){
					/**
					 *    коллекция объектов Л.С. на данной итерации
					 */
				    ArrayList<PersonalAccount> paList =  (ArrayList<PersonalAccount>) personalAccountDAO.findPersonalAccount(BY_HOUSE , iterator.next());
				    /**
				     *     склеиваем коллекции
				     */
				    ArrayList<PersonalAccount> tmp = new ArrayList<PersonalAccount>(target);
				    tmp.addAll(paList);
				    target = tmp;
			}
			return target;
		}
		
		
		/**
		 *   				поиск по названию улицы
		 *   @param номер улицы
		 *   @return List<PersonalAccount>(коллеция Л.С.)
		 */
		public List<PersonalAccount> findByStreetName(String streetName){
			/**
			 *      УЛИЦА с названием ...
			 */
			Street street = (Street) streetDAO.findStreetByName(streetName);
			/**
			 *     коллекция Л.С.
			 */
			ArrayList<PersonalAccount> target = (ArrayList<PersonalAccount>) personalAccountDAO.findPersonalAccount(BY_STREET ,street);

			return target;
		}
		
		// *************** реализация бизнес логики ******************
		

		public BigDecimal getBalance() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	
	// ************   setters для DAO объектов ***********************
	
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
