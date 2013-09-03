package org.andrew.malapura.entity;

import java.util.Date;

/**
 * 
 *  �������� ������� ����
 * 
 * @author mav
 *
 */

public class PersonalAccount {
	 
	private Long id;  					     // id ������ � ��
	private String accountNumber;   // ����� �������� �����
	private String accountType;		 // ��� �.�. (����������, �������������, �������������)
	private Flat flat;				         // �������� 
	private Owner owner;				 // �������� �������� �����
	private Date createdDate;          // ���� �������� �.�.
	
	//  *******    Getters and Setters  ***************
	
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
	public Flat getFlat() {
		return flat;
	}
	public void setFlat(Flat flat) {
		this.flat = flat;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	

}
