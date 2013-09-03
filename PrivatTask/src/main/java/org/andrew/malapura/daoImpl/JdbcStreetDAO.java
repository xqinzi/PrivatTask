package org.andrew.malapura.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.andrew.malapura.dao.StreetDAO;
import org.andrew.malapura.entity.Street;
import org.andrew.malapura.model.StreetRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
/**
 * 
 *  имплементация DAO сущности УЛИЦА
 *  
 * @author mav
 *
 */
public class JdbcStreetDAO extends JdbcDaoSupport implements StreetDAO {
	
	/**
	 *  добавить УЛИЦУ в справочник
	 */
	public void add(Street street) {
		String sql = "INSERT INTO STREET (STREET_NAME) VALUES (?)";
		getJdbcTemplate().update(sql, new Object[] { street.getStreetName() });
	}
	/**
	 * получить запись с заданным id из таблицы УЛИЦА
	 *  @param id 
	 *  @return объект типа УЛИЦА
	 */
	public Street getById(Long id) {
		String sql = "SELECT * FROM STREET WHERE ID = ?";
		StreetRowMapper mapper = new StreetRowMapper();
		getJdbcTemplate().queryForObject(sql, new Object[]{id}, mapper);
		return mapper.getStreet();
	}
    /**
     *   получить все записи таблицы УЛИЦА
     *   @return список всех улиц 
     */
	public List<Street> getAll() {
		String sql = "SELECT * FROM STREET";
		@SuppressWarnings("unchecked")
		ArrayList<Street> result = (ArrayList<Street>) getJdbcTemplate().query(sql, new StreetRowMapper());
		return result;
	}
	/**
	 * 	обновление объекта УЛИЦА
	 */
	public void update(Street street) {
		String sql = "UPDATE STREET SET STREET_NAME = ? WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { street.getStreetName(), street.getId() });
	}
	/**
	 * 	удалить УЛИЦУ из справочника
	 * 	@param Street street ( объект УЛИЦА ) 
	 */
	public void delete(Street street) {
		String sql = "DELETE FROM STREET WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { street.getId() });
	}
	/**
	 *   возвращает объект УЛИЦА на названию
	 *   @param название улицы
	 *   @return объект УЛИЦА
	 */
	public Street findStreetByName(String nameStreet){
		String sql = "SELECT * FROM STREET WHERE STREET_NAME = ?";
		StreetRowMapper mapper = new StreetRowMapper();
		getJdbcTemplate().queryForObject(sql, new Object[]{ nameStreet }, mapper);
		return mapper.getStreet();
	}

}
