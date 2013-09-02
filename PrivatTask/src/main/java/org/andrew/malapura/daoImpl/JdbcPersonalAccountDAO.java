package org.andrew.malapura.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.andrew.malapura.dao.PersonalAccountDAO;
import org.andrew.malapura.entity.PersonalAccount;
import org.andrew.malapura.model.PersonalAccountRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcPersonalAccountDAO extends JdbcDaoSupport implements
		PersonalAccountDAO {

	public void add(PersonalAccount obj) {
		// TODO Auto-generated method stub

	}

	public PersonalAccount getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PersonalAccount> getAll() {
		  String sql = "select * from personal_account as pa" +
							" left join flat as f on pa.flat_id = f.id"+
							" left join owner as o on pa.owner_id = o.id"+
							" left join house as h on f.house_id = h.id"+
							" left join street as s on h.street_id = s.id";
		  @SuppressWarnings("unchecked")
		ArrayList<PersonalAccount> persAccounts = ( ArrayList<PersonalAccount>) getJdbcTemplate().query(sql, new PersonalAccountRowMapper());
		return persAccounts;
	}

	public void update(PersonalAccount obj) {
		// TODO Auto-generated method stub

	}

	public void delete(PersonalAccount personalAccount) {
		// TODO Auto-generated method stub

	}

}
