package org.andrew.malapura.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.andrew.malapura.dao.PersonalAccountDAO;
import org.andrew.malapura.entity.PersonAccount;
import org.andrew.malapura.model.PersonAccountRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcPersonAccountDAO extends JdbcDaoSupport implements
		PersonalAccountDAO {

	public void add(PersonAccount obj) {
		// TODO Auto-generated method stub

	}

	public PersonAccount getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PersonAccount> getAll() {
		  String sql = "select * from personal_account as pa" +
							" left join flat as f on pa.flat_id = f.id"+
							" left join owner as o on pa.owner_id = o.id"+
							" left join house as h on f.house_id = h.id"+
							" left join street as s on h.street_id = s.id";
		  @SuppressWarnings("unchecked")
		ArrayList<PersonAccount> persAccounts = ( ArrayList<PersonAccount>) getJdbcTemplate().query(sql, new PersonAccountRowMapper());
		return persAccounts;
	}

	public void update(PersonAccount obj) {
		// TODO Auto-generated method stub

	}

	public void delete(PersonAccount personAccount) {
		// TODO Auto-generated method stub

	}

}
