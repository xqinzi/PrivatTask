package org.andrew.malapura.entity;

/**
 * 
 * @author mav
 *
 *  сущность ДОМ
 *
 */

public class House {
	
	private Long id;						// id записи
	private String houseNumber;     // номер дома
	private String houseType;        //  тип дома (частный, многоэтажный и т.д.)
	private Street street;				//  улица
	private String matType;			// материал из которого построен
	
	// ----------  getters and setters ----------------
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	public Street getStreet() {
		return street;
	}
	public void setStreet(Street street) {
		this.street = street;
	}
	public String getMatType() {
		return matType;
	}
	public void setMatType(String matType) {
		this.matType = matType;
	}

}
