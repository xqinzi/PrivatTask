package org.andrew.malapura.entity;

/**
 * 
 * @author mav
 *
 *   таблица КВАРТИРА
 *
 */

public class Flat {
	/**
	 *  	уникальное поле записи
	 */
	private Long id;
	/**
	 * 	номер квартиры
	 */
	private Integer number;
	/**
	 * 	общая площадь квартиры
	 */
	private Double sqTotal;   
	/**
	 *   	жилая площадь
	 */
	private Double sqLiv;
	/**
	 *  	id дома в котором находится квартира
	 */
	private Long houseId;  
	/**
	 * 	этаж
	 */
	private Integer floorNum; 
	/**
	 *    номер подъезда
	 */
	private Integer doorWayNum;  
	
	// ----------  getters and setters ----------------
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Double getSqTotal() {
		return sqTotal;
	}
	public void setSqTotal(Double sqTotal) {
		this.sqTotal = sqTotal;
	}
	public Double getSqLiv() {
		return sqLiv;
	}
	public void setSqLiv(Double sqLiv) {
		this.sqLiv = sqLiv;
	}
	public Long getHouseId() {
		return houseId;
	}
	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}
	public Integer getFloorNum() {
		return floorNum;
	}
	public void setFloorNum(Integer floorNum) {
		this.floorNum = floorNum;
	}
	public Integer getDoorWayNum() {
		return doorWayNum;
	}
	public void setDoorWayNum(Integer doorWayNum) {
		this.doorWayNum = doorWayNum;
	}
  
}
