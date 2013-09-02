package org.andrew.malapura.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.andrew.malapura.dao.OwnerDAO;
import org.andrew.malapura.entity.Owner;
import org.andrew.malapura.model.OwnerRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcOwnerDAO extends JdbcDaoSupport implements OwnerDAO {
     /**
      *   создание новой записи ВЛАДЕЛЕЦ
      * @param ВЛАДЕЛЕЦ
      */
	public void add(Owner owner) {
		String sql = "INSERT INTO OWNER (FIRST_NAME, PATRONYMIC, SECOND_NAME, BIRTHDAY, INN) VALUES (?, ?, ?, ?, ?)";
		getJdbcTemplate().update(sql, new Object[] {owner.getFirstName(), owner.getPatronymic(), owner.getSecondName(), owner.getBirthday(), owner.getInn() });

	}
    /**
     * 	
     * @param ID записи ВЛАДЕЛЕЦ
     * @return объект ВЛАДЕЛЕЦ
     */
	public Owner getById(Long id) {
		String sql = "SELECT * FROM OWNER WHERE ID = ?";
		OwnerRowMapper mapper = new OwnerRowMapper();
		getJdbcTemplate().query(sql, new Object[]{}, mapper);
		return mapper.getOwner();
	}
	/**
	 *         коллекция всех ВЛАДЕЛЬЦЕВ
	 * @return список ВЛАДЕЛЬЦЕВ лицевых счетов
	 */
	public List<Owner> getAll() {
		String sql = "SELECT * FROM OWNER";
		@SuppressWarnings("unchecked")
		ArrayList<Owner> owners = (ArrayList<Owner>) getJdbcTemplate().query(sql, new OwnerRowMapper());
		return owners;
	}
    /**
     * 	обновление записи ВЛАДЕЛЕЦ
	 *     @param ВЛАДЕЛЕЦ
     */
	public void update(Owner owner) {
		String sql = "UPDATE OWNER SET FIRST_NAME=?, PATRONYMIC=?, SECOND_NAME=?, BIRTHDAY=?, INN=? WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { owner.getFirstName(), owner.getPatronymic(), owner.getSecondName(), owner.getBirthday(), owner.getInn(), owner.getId() });
	}
	/**
	 * 	удаление записи ВЛАДЕЛЕЦ
	 *    @param ВЛАДЕЛЕЦ
	 */
	public void delete(Owner owner) {
		String sql = "DELETE FROM OWNER WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { owner.getId() });
	}

}
