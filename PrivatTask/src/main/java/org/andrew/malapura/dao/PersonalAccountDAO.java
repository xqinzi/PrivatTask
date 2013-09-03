package org.andrew.malapura.dao;

import java.util.List;

import org.andrew.malapura.entity.PersonalAccount;

public interface PersonalAccountDAO extends GeneralizedDAO<PersonalAccount>{
	
	String SELECT_QUERY =  "select * from personal_account as pa" +
										  " left join flat as f on pa.flat_id = f.id"+
										  " left join owner as o on pa.owner_id = o.id"+
										  " left join house as h on f.house_id = h.id"+
										  " left join street as s on h.street_id = s.id ";
	/**
	 *  ïîèñê ËÈÖÅÂÛÕ Ñ×ÅÒÎÂ ÏÎ ÏÀĞÀÌÅÒĞÓ
	 * @param <V>
	 * @return
	 */
	<V> List<PersonalAccount> findPersonalAccount(final int findParam, V value);
	
	/**
	 * ïîèñê ËÈÖÅÂÎÃÎ Ñ×ÅÒÀ ïî íîìåğó Ë.Ñ.
	 * @param íîìåğ Ë.Ñ.
	 * @return îáúåêò Ë.Ñ.
	 */
	PersonalAccount findByAccountNumber(String accountNumber);
}
