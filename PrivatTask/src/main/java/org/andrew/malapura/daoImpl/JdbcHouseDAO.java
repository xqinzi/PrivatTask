package org.andrew.malapura.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.andrew.malapura.dao.HouseDAO;
import org.andrew.malapura.entity.House;
import org.andrew.malapura.model.HouseRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcHouseDAO extends JdbcDaoSupport implements HouseDAO {

	public void add(House house) {
		/**
	     *  SQL ������ 
	     */
		String sql = "INSERT INTO HOUSE (HOUSE_NUMBER, HOUSE_TYPE, STREET_ID, MAT_TYPE) VALUES (?,?,?,?)";
		getJdbcTemplate().update(sql, new Object[] { house.getHouseNumber(), house.getHouseType(), house.getStreet().getId(), house.getMatType() });

	}
	/**
	 *   ���������� ������ ���  �� ����������� ����� id
	 *   @param id
	 *    @return House
	 */
	public House getById(Long id) {
		/**
	     *  SQL ������ 
	     */
		String sql = "SELECT * FROM HOUSE AS H LEFT JOIN STREET AS S  ON H.STREET_ID = S.ID WHERE H.ID = ?";
		HouseRowMapper mapper = new HouseRowMapper();
		getJdbcTemplate().queryForObject(sql, new Object[]{id}, mapper);
		return mapper.getHouse();
	}

	/**
	 *   ��� ������ �� ������� ���
	 *  
	 *   @return Arraylist<House>
	 */
	  	public List<House> getAll() {
	    /**
	     *  SQL ������ 
	     */
		String sql = "SELECT * FROM HOUSE AS H LEFT JOIN STREET AS S  ON H.STREET_ID = S.ID";
		@SuppressWarnings("unchecked")
		ArrayList<House> houses=(ArrayList<House>) getJdbcTemplate().query(sql, new HouseRowMapper());
		
		return houses;
	}

	public void update(House house) {
		/**
	     *  SQL ������ 
	     */
		String sql = "UPDATE HOUSE SET HOUSE_NUMBER=?, HOUSE_TYPE=?, STREET_ID=?, MAT_TYPE=? WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { house.getHouseNumber(), house.getHouseType(), house.getStreet().getId(), house.getMatType(), house.getId() });

	}
	/**
	 * 		�������� ������ �� �������
	 */
	public void delete(Long id) {
		/**
	     *  SQL ������ 
	     */
		String sql = "DELETE FROM HOUSE WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { id });

	}

}
