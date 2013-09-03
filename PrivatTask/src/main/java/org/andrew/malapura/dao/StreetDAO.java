package org.andrew.malapura.dao;

import org.andrew.malapura.entity.Street;
    /**
     * 
     * @author mav
     *  
     */
public interface StreetDAO extends GeneralizedDAO<Street>{
		/**
		 *   возвращает объект УЛИЦА на названию
		 *   @param название улицы
		 *   @return объект УЛИЦА
		 */
		Street findStreetByName(String nameStreet);
}
