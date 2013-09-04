package org.andrew.malapura.entity;
/**
 * 
 * @author mav
 *  
 *  сущность Улица
 */
public class Street {
	
	private Long id;						  //  ID
	private String streetName;		  //  название улицы
	
	// ----------  getters and setters ----------------
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	
	
	

}
