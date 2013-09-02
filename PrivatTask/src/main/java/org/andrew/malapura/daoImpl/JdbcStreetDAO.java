package org.andrew.malapura.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.andrew.malapura.dao.StreetDAO;
import org.andrew.malapura.entity.Street;
import org.andrew.malapura.model.StreetRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
/**
 * 
 *  реализация интерфейса УЛИЦА
 *  
 * @author mav
 *
 */
public class JdbcStreetDAO extends JdbcDaoSupport implements StreetDAO {
	
	/**
	 *  добавить запись
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
	 * 	обновление записи 
	 */
	public void update(Street street) {
		String sql = "UPDATE STREET SET STREET_NAME = ? WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { street.getStreetName(), street.getId() });
	}
	/**
	 * 	удалить запись
	 */
	public void delete(Long id) {
		String sql = "DELETE FROM STREET WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { id });
	}


}
