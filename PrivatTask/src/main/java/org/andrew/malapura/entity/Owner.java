package org.andrew.malapura.entity;

import java.util.Date;
/**
 * 
 * @author mav
 *
 *   �������� ��������
 *
 */
public class Owner {

	private Long id;
	private String firstName;            //  ��� 
    private String patronymic;          //  ��������
	private String secondName;        //  �������
	private Date birthday;                //  ���� ��������
	private String inn;						   // ���
	
	// Getters and Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getInn() {
		return inn;
	}
	public void setInn(String inn) {
		this.inn = inn;
	}
		
}
