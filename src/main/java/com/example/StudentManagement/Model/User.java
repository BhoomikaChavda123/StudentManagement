package com.example.StudentManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;   
	
	private String userName;  
	
	private String password;
	
	private String state;    
	
	private String email;   
	
	private boolean isActive;

	public User() {
		super();
	}

	public User(String userName, String password, String state, String email, boolean isActive) {
		super();
		this.userName = userName;
		this.password = password;
		this.state = state;
		this.email = email;
		this.isActive = isActive; 
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", state=" + state + ", email="
				+ email + ", isActive=" + isActive + "]";
	}

         	
}
