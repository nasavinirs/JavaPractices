package com.practice.jdbc.exs;

/* 
 * Program-2 :
 * public class User {
	Integer id;
	String name;
	Role role;
	Contact contact;

	public User(Integer id, String name, Role role, Contact contact) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.contact = contact;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

} */

public class User {

	private String name;
	private String userName;
	private String password;
	private String mobileNumber;
	private Role role;

	public User(String name, String userName, String password, String mobileNumber, Role role) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.mobileNumber = mobileNumber;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
