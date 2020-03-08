package com.springboot.learn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column(name = "HOLDER_NAME")
	String name;
	@Column(name= "CONTACT_NO")
	int contactNo;
	
	String[] dbCardNo;
	
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Card(String name, int contactNo, String[] dbCardNo) {
		super();
		this.name = name;
		this.contactNo = contactNo;
		this.dbCardNo = dbCardNo;
	}
	public int getContactNo() {
		return contactNo;
	}
	
	public String[] getDbCardNo() {
		return dbCardNo;
	}
	public String getName() {
		return name;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	public void setDbCardNo(String[] dbCardNo) {
		this.dbCardNo = dbCardNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Card [name=" + name + ", contactNo=" + contactNo + "]";
	}
	
}
