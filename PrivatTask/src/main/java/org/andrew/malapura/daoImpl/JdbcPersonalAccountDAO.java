package org.andrew.malapura.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.andrew.malapura.dao.PersonalAccountDAO;
import org.andrew.malapura.entity.Flat;
import org.andrew.malapura.entity.House;
import org.andrew.malapura.entity.Owner;
import org.andrew.malapura.entity.PersonalAccount;
import org.andrew.malapura.entity.Street;
import org.andrew.malapura.model.PersonalAccountRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
/**
 *		 ������������� DAO ��� �������� ������� ����
 * 		@author malapura
 *
 */
public class JdbcPersonalAccountDAO extends JdbcDaoSupport implements
		PersonalAccountDAO {
	/**
	 * 	�������� ������ �������� �����
	 * 	@param personalAccount(������� ����)
	 */
	public void add(PersonalAccount personalAccount) {
		String sql = "INSERT INTO PERSONAL_ACCOUNT (ACCOUNT_NUMBER, ACCOUNT_TYPE, FLAT_ID, OWNER_ID, CREATED_DATE) VALUES ( ?, ?, ?, ?, ?)";
		getJdbcTemplate().update(sql, new Object[] { personalAccount.getAccountNumber(), personalAccount.getAccountType(),
				personalAccount.getFlat().getId(), personalAccount.getOwner().getId(), personalAccount.getCreatedDate()});
	}
	/**
	 *    ����� �������� ����� �� ID 
	 *    @param ID �.�.
	 *    @return ������ �.�. 
	 */
	public PersonalAccount getById(Long id) {
		String sql = SELECT_QUERY + " where pa.id = ?";
		PersonalAccountRowMapper mapper = new PersonalAccountRowMapper();
		getJdbcTemplate().query(sql, new Object[] {id}, mapper);
		return mapper.getPersonalAccount();
	}
	/**
	 *   ���������� ��������� �.�.
	 * @return List<PersonalAccount>(��������� �.�).
	 */
	public List<PersonalAccount> getAll() {
		  String sql = SELECT_QUERY ;
		  @SuppressWarnings("unchecked")
		ArrayList<PersonalAccount> persAccounts = ( ArrayList<PersonalAccount>) getJdbcTemplate().query(sql, new PersonalAccountRowMapper());
		return persAccounts;
	}
	/**
	 *   ���������� �.�.
	 *   @param personalAccount(������� ����)
	 */
	public void update(PersonalAccount personalAccount) {
		String sql = "UPDATE PERSONAL_ACCOUNT SET ACCOUNT_NUMBER = ?, ACCOUNT_TYPE = ?, FLAT_ID = ?, OWNER_ID = ?, CREATED_DATE = ? WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { personalAccount.getAccountNumber(), personalAccount.getAccountType(),
				personalAccount.getFlat().getId(), personalAccount.getOwner().getId(), personalAccount.getCreatedDate(), personalAccount.getId() });

	}
   /**
    *   �������� �.�.
    *   @param personalAccount(������� ����)
    *   
    */
	public void delete(PersonalAccount personalAccount) {
		String sql = "DELETE FROM PERSONAL_ACCOUNT WHERE ID = ?";
		getJdbcTemplate().update(sql, new Object[] { personalAccount.getId() });
	}
	
   /**
    * 							 ����� �.�. �� ���������
    */
	@SuppressWarnings("unchecked")
	public<V> List<PersonalAccount> findPersonalAccount(final int findParam, V value) {
		
		ArrayList<PersonalAccount> target = null;
		String sql = "";
		
		switch (findParam) {
		
						/**
						 *   ����� ��  ��������� ��������
						 */
			case 0:
				if(value.getClass().equals(Owner.class)){
						Owner owner = (Owner) value;  
						sql = SELECT_QUERY + "where o.id = ?";
						target = (ArrayList<PersonalAccount>) getJdbcTemplate().query(sql, new Object[] { owner.getId() } , new PersonalAccountRowMapper());
				}
				break;
				
				
						/**
						 *   ����� ��  ��������� ��������
						 */
			case 1:
				if(value.getClass().equals(Flat.class)){
						Flat flat = (Flat) value;
						sql = SELECT_QUERY + "where f.id = ?";
						target = (ArrayList<PersonalAccount>) getJdbcTemplate().query(sql, new Object[] { flat.getId() } , new PersonalAccountRowMapper());
				}
				
				break;
				
				
						/**
						 *   ����� ��  ��������� ���
						 */
			case 2:
				if(value.getClass().equals(House.class)){
						House house = (House) value;
						sql = SELECT_QUERY + "where h.id = ?";
						target = (ArrayList<PersonalAccount>) getJdbcTemplate().query(sql, new Object[] { house.getId() } , new PersonalAccountRowMapper());
				}
				break;
				
				
						/**
						 *   ����� ��  ��������� �����
						 */
			case 3:
				if(value.getClass().equals(Street.class)){
					Street street = (Street) value;
					sql = SELECT_QUERY + "where s.id = ?";
					target = (ArrayList<PersonalAccount>) getJdbcTemplate().query(sql, new Object[] { street.getId() } , new PersonalAccountRowMapper());
			}
				break;
		}
		
		return target;
	}
	/**
	 * 
	 * @param ����� �.�.
	 * @return ������ �.�.
	 */
	public PersonalAccount findByAccountNumber(String accountNumber) {
		String sql = SELECT_QUERY + "where pa.account_number = ?";
		PersonalAccountRowMapper mapper = new PersonalAccountRowMapper();
		getJdbcTemplate().query(sql, new Object[] { accountNumber }, mapper);
		return mapper.getPersonalAccount();
	}

}
