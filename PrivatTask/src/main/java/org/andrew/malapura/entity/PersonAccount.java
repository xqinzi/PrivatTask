package org.andrew.malapura.entity;

import java.util.Date;

/**
 * 
 *  Сущность "Лицевой счет"
 * 
 * @author mav
 *
 */

public class PersonAccount {
	 
	private Long id;  					// id записи
	private String accountNumber;  // Номер лицевого счета
	private String accountType;		// тип л.с. (квартплата, газоснабж., водоснабж, и т.д.)
	private Long flatId;				    // ссылка на объект КВАРТ�?РА
	private Long ownerId;				// ссылка на объект ВЛАДЕЛЕЦ л.с.
	private Date createdDate;        // дата создания л.с.
	
	//   Getters and Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Long getFlatId() {
		return flatId;
	}
	public void setFlatId(Long flatId) {
		this.flatId = flatId;
	}
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	

}
