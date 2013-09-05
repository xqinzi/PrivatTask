package org.andrew.malapura.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.andrew.malapura.dao.FlatDAO;
import org.andrew.malapura.entity.Flat;
import org.andrew.malapura.model.FlatRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
/**
 *      имплементация DAO сущности КВАРТИРА
 * 
 * @author mav
 *
 */
public class JdbcFlatDAO extends JdbcDaoSupport implements FlatDAO {
   /**
    *   создание новой записи КВАРТИРА
    * 
    * @param КВАРТИРА
    */
	public void add(Flat flat) {
		/**
		 *  	SQL запрос
		 */
		String sql = "INSERT INTO FLAT (NUMBER, HOUSE_ID, SQ_TOTAL, SQ_LIV, FLOOR_NUM, DOOR_WAY_NUM) VALUES ( ?, ?, ?, ?, ?, ?)";
		getJdbcTemplate().update(sql, new Object[] { flat.getNumber(), flat.getHouse().getId(), flat.getSqTotal(), flat.getSqLiv(), flat.getFloorNum(), flat.getDoorWayNum()});
	}
   /**
    * @param ID записи КВАРТИРА
    * @return объект КВАРТИРА
    */
	public Flat getById(Long id) {
		/**
		 *  	SQL запрос
		 */
		String sql = "SELECT * FROM FLAT AS F LEFT JOIN HOUSE AS H ON F.HOUSE_ID = H.ID  LEFT JOIN STREET AS S  ON H.STREET_ID = S.ID WHERE F.ID = ?";
		FlatRowMapper mapper = new FlatRowMapper();
		getJdbcTemplate().query(sql, new Object[]{id}, mapper);
		return mapper.getFlat();
	}
    /**
     * 	возвращает коллекцию объектов КВАРТИРА 
     * @return List<Flat>
     */
	public List<Flat> getAll() {
		/**
		 *  	SQL запрос 
		 */
		String sql = "SELECT * FROM FLAT AS F LEFT JOIN HOUSE AS H ON F.HOUSE_ID = H.ID  LEFT JOIN STREET AS S  ON H.STREET_ID = S.ID";
		@SuppressWarnings("unchecked")
		ArrayList<Flat> flats = (ArrayList<Flat>) getJdbcTemplate().query(sql, new FlatRowMapper());
		return flats;
	}
	/**
	 *    обновление записи 
	 * 	@param КВАРТИРА
	 */
	public void update(Flat flat) {
		/**
		 *  	SQL запрос
		 */
		String sql = "UPDATE FLAT SET NUMBER=?, HOUSE_ID= ?, SQ_TOTAL = ?, SQ_LIV = ?, FLOOR_NUM = ?, DOOR_WAY_NUM = ? WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { flat.getNumber(), flat.getHouse().getId(), flat.getSqTotal(), flat.getSqLiv(), flat.getFloorNum(), flat.getDoorWayNum(), flat.getId() });
	}
    /**
     * 
     *  удаляет запись из БД
     * @param КВАРТИРА
     */
	public void delete(Flat flat) {
		/**
		 *  	SQL запрос
		 */
		String sql = "DELETE FROM FLAT WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { flat.getId() });
	}
	
	
	public Flat findFlatByAddress(String streetName, String houseNumber, String flatNumber) {
		String sql = "SELECT * FROM FLAT AS F LEFT JOIN HOUSE AS H ON F.HOUSE_ID = H.ID  LEFT JOIN STREET AS S  ON H.STREET_ID = S.ID "+
						  "WHERE S.STREET_NAME = ? AND H.HOUSE_NUMBER = ? AND F.NUMBER = ?";
		FlatRowMapper mapper = new FlatRowMapper();
		getJdbcTemplate().query(sql, new Object[]{streetName, houseNumber, flatNumber}, mapper);
		return mapper.getFlat();
	}

}
