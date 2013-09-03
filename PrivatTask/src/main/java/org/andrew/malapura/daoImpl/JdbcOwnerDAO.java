package org.andrew.malapura.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.andrew.malapura.dao.OwnerDAO;
import org.andrew.malapura.entity.Owner;
import org.andrew.malapura.model.OwnerRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcOwnerDAO extends JdbcDaoSupport implements OwnerDAO {
     /**
      *   �������� ����� ������ ��������
      * @param ��������
      */
	public void add(Owner owner) {
		String sql = "INSERT INTO OWNER (FIRST_NAME, PATRONYMIC, SECOND_NAME, BIRTHDAY, INN) VALUES (?, ?, ?, ?, ?)";
		getJdbcTemplate().update(sql, new Object[] {owner.getFirstName(), owner.getPatronymic(), owner.getSecondName(), owner.getBirthday(), owner.getInn() });

	}
    /**
     * 	
     * @param ID ������ ��������
     * @return ������ ��������
     */
	public Owner getById(Long id) {
		String sql = "SELECT * FROM OWNER WHERE ID = ?";
		OwnerRowMapper mapper = new OwnerRowMapper();
		getJdbcTemplate().query(sql, new Object[]{ id }, mapper);
		return mapper.getOwner();
	}
	/**
	 *         ��������� ���� ����������
	 * @return ������ ���������� ������� ������
	 */
	public List<Owner> getAll() {
		String sql = "SELECT * FROM OWNER";
		@SuppressWarnings("unchecked")
		ArrayList<Owner> owners = (ArrayList<Owner>) getJdbcTemplate().query(sql, new OwnerRowMapper());
		return owners;
	}
    /**
     * 	���������� ������ ��������
	 *     @param ��������
     */
	public void update(Owner owner) {
		String sql = "UPDATE OWNER SET FIRST_NAME=?, PATRONYMIC=?, SECOND_NAME=?, BIRTHDAY=?, INN=? WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { owner.getFirstName(), owner.getPatronymic(), owner.getSecondName(), owner.getBirthday(), owner.getInn(), owner.getId() });
	}
	/**
	 * 	�������� ������ ��������
	 *    @param ��������
	 */
	public void delete(Owner owner) {
		String sql = "DELETE FROM OWNER WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { owner.getId() });
	}
	/**
	 * @param ���
	 * @param ��������
	 * @param �������
	 * @return ��������� �������� ��������
	 */
	@SuppressWarnings("unchecked")
	public List<Owner> getOwnerByName(String firstName, String patronymic, String secondName) {
		String sql = "SELECT * FROM OWNER WHERE  FIRST_NAME = ? AND PATRONYMIC = ? AND SECOND_NAME = ?";
				ArrayList<Owner> ownerList = (ArrayList<Owner>)getJdbcTemplate().query(sql, new Object[]{ firstName, patronymic, secondName }, new OwnerRowMapper());
		return ownerList;
	}

}
