package org.andrew.malapura.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.andrew.malapura.dao.OwnerDAO;
import org.andrew.malapura.entity.Flat;
import org.andrew.malapura.entity.Owner;
import org.andrew.malapura.model.FlatRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcOwnerDAO extends JdbcDaoSupport implements OwnerDAO {

	public void add(Owner obj) {
		// TODO Auto-generated method stub

	}

	public Owner getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return список ¬Ћјƒ≈Ћ№÷≈¬ лицевых счетов
	 */
	public List<Owner> getAll() {
		String sql = "SELECT * FROM OWNER";
		@SuppressWarnings("unchecked")
		ArrayList<Owner> owners = (ArrayList<Owner>) getJdbcTemplate().query(sql, new FlatRowMapper());
		return owners;
	}

	public void update(Owner obj) {
		// TODO Auto-generated method stub

	}
	
	public void delete(Long id) {
		String sql = "DELETE FROM OWNER WHERE ID = ?";

	}

}
