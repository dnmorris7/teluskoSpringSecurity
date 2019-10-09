package com.davidonus.secureapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	private int uid;
	private String username;
	private String password;
	
	public User(int uid, String username, String password) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
	}
	
	@Column(name="user_id")
	public int getId() {
		return uid;
	}
	public void setId(int id) {
		this.uid = id;
	}
	
	@Column(name="user_name")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="user_pwd")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
