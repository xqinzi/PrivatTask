package org.andrew.malapura.entity;

import java.util.Date;
/**
 * 
 * @author mav
 *
 *   Сущность ВЛАДЕЛЕЦ Л.С.
 *
 */
public class Owner {

	private Long id;
	private String firstName;            //  Имя
    private String patronymic;          //  Отчество
	private String secondName;        //  Фамилия
	private Date birthday;                //  дата рождения
	private String inn;						   // индификационный код
	
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
