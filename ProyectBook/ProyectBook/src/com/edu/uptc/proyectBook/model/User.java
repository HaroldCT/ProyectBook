package com.edu.uptc.proyectBook.model;

import java.io.Serializable;

public class User implements Serializable{
	private String Username;
	private String password;
	
	
	public User() {
		super();
	}
	public User(String username, String password) {
		super();
		Username = username;
		this.password = password;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
