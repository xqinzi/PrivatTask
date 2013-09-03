package org.andrew.malapura.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.andrew.malapura.dao.PersonalAccountDAO;
import org.andrew.malapura.entity.PersonalAccount;
import org.andrew.malapura.model.PersonalAccountRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
/**
 *		 имплементация DAO для сущности ЛИЦЕВОЙ СЧЕТ
 * 		@author malapura
 *
 */
public class JdbcPersonalAccountDAO extends JdbcDaoSupport implements
		PersonalAccountDAO {
	/**
	 * 	создание нового ЛИЦЕВОГО СЧЕТА
	 * 	@param personalAccount(ЛИЦЕВОЙ СЧЕТ)
	 */
	public void add(PersonalAccount personalAccount) {
		String sql = "INSERT INTO PERSONAL_ACCOUNT (ACCOUNT_NUMBER, ACCOUNT_TYPE, FLAT_ID, OWNER_ID, CREATED_DATE) VALUES ( ?, ?, ?, ?, ?)";
		getJdbcTemplate().update(sql, new Object[] { personalAccount.getAccountNumber(), personalAccount.getAccountType(),
				personalAccount.getFlat().getId(), personalAccount.getOwner().getId(), personalAccount.getCreatedDate()});
	}
	/**
	 *    поиск ЛИЦЕВОГО СЧЕТА по ID 
	 *    @param ID Л.С.
	 *    @return объект Л.С. 
	 */
	public PersonalAccount getById(Long id) {
		String sql = "select * from personal_account where id = ?";
		PersonalAccountRowMapper mapper = new PersonalAccountRowMapper();
		getJdbcTemplate().query(sql, mapper);
		return mapper.getPersonalAccount();
	}
	/**
	 *   возвращает коллекцию Л.С.
	 * @return List<PersonalAccount>(коллекция Л.С).
	 */
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
	/**
	 *   обновление Л.С.
	 *   @param personalAccount(ЛИЦЕВОЙ СЧЕТ)
	 */
	public void update(PersonalAccount personalAccount) {
		String sql = "UPDATE PERSONAL_ACCOUNT SET ACCOUNT_NUMBER = ?, ACCOUNT_TYPE = ?, FLAT_ID = ?, OWNER_ID = ?, CREATED_DATE = ? WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { personalAccount.getAccountNumber(), personalAccount.getAccountType(),
				personalAccount.getFlat().getId(), personalAccount.getOwner().getId(), personalAccount.getCreatedDate(), personalAccount.getId() });

	}
   /**
    *   удаление Л.С.
    *   @param personalAccount(ЛИЦЕВОЙ СЧЕТ)
    *   
    */
	public void delete(PersonalAccount personalAccount) {
		String sql = "DELETE FROM PERSONAL_ACCOUNT WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { personalAccount.getId() });
	}

}
