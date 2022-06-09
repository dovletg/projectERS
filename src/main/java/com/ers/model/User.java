package com.ers.model;

public class User {
	private int id;
	private String userName;
	private String password;
	private String type;
	
	public User() {}
	
	public User(int id, String userName, String password,String type) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
