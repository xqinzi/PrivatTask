package org.andrew.malapura.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.andrew.malapura.dao.StreetDAO;
import org.andrew.malapura.entity.Street;
import org.andrew.malapura.model.StreetRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
/**
 * 
 *  ���������� ���������� �����
 *  
 * @author mav
 *
 */
public class JdbcStreetDAO extends JdbcDaoSupport implements StreetDAO {
	
	/**
	 *  �������� ������
	 */
	public void add(Street street) {
		String sql = "INSERT INTO STREET (STREET_NAME) VALUES (?)";
		getJdbcTemplate().update(sql, new Object[] { street.getStreetName() });
	}
	/**
	 * �������� ������ � �������� id �� ������� �����
	 *  @param id 
	 *  @return ������ ���� �����
	 */
	public Street getById(Long id) {
		String sql = "SELECT * FROM STREET WHERE ID = ?";
		StreetRowMapper mapper = new StreetRowMapper();
		getJdbcTemplate().queryForObject(sql, new Object[]{id}, mapper);
		return mapper.getStreet();
	}
    /**
     *   �������� ��� ������ ������� �����
     *   @return ������ ���� ���� 
     */
	public List<Street> getAll() {
		String sql = "SELECT * FROM STREET";
		@SuppressWarnings("unchecked")
		ArrayList<Street> result = (ArrayList<Street>) getJdbcTemplate().query(sql, new StreetRowMapper());
		return result;
	}
	/**
	 * 	���������� ������ 
	 */
	public void update(Street street) {
		String sql = "UPDATE STREET SET STREET_NAME = ? WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { street.getStreetName(), street.getId() });
	}
	/**
	 * 	������� ������
	 */
	public void delete(Long id) {
		String sql = "DELETE FROM STREET WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { id });
	}


}
