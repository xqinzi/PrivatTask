package org.andrew.malapura.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.andrew.malapura.dao.FlatDAO;
import org.andrew.malapura.entity.Flat;
import org.andrew.malapura.model.FlatRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcFlatDAO extends JdbcDaoSupport implements FlatDAO {

	public void add(Flat obj) {
		// TODO Auto-generated method stub

	}

	public Flat getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Flat> getAll() {
		String sql = "SELECT * FROM FLAT AS F LEFT JOIN HOUSE AS H ON F.HOUSE_ID = H.ID  LEFT JOIN STREET AS S  ON H.STREET_ID = S.ID";
		@SuppressWarnings("unchecked")
		ArrayList<Flat> flats = (ArrayList<Flat>) getJdbcTemplate().query(sql, new FlatRowMapper());
		return flats;
	}

	public void update(Flat flat) {
		// TODO Auto-generated method stub

	}

	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
