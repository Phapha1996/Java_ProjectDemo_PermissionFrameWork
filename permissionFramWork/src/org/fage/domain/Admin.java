package org.fage.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_admin")
public class Admin {
	//后台维护人员表
	private int id;
	private String username;
	private String password;
	private String position;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getPosition() {
		return position;
	}
	public String getUsername() {
		return username;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
