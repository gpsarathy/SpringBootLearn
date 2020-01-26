package com.springboot.learn.SBLearn;

public class Card {

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	String name;
	int contactNo;
	
	String[] dbCardNo;
	
	
	public String[] getDbCardNo() {
		return dbCardNo;
	}
	public void setDbCardNo(String[] dbCardNo) {
		this.dbCardNo = dbCardNo;
	}
	
	public Card(String name, int contactNo, String[] dbCardNo) {
		super();
		this.name = name;
		this.contactNo = contactNo;
		this.dbCardNo = dbCardNo;
	}
	@Override
	public String toString() {
		return "Card [name=" + name + ", contactNo=" + contactNo + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	
}
