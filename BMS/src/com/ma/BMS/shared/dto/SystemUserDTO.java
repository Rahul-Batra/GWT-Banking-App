package com.ma.BMS.shared.dto;

import java.io.Serializable;

import javax.persistence.Id;

@SuppressWarnings("serial")
public class SystemUserDTO implements Serializable {
	
	@Id
	public Long id;
	String name;
	String role;
	String dateofcreation;
	String password;
	Boolean Isactive;
	String lastactive;

	
	public SystemUserDTO() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	
	

	public String getDateofcreation() {
		return dateofcreation;
	}

	public void setDateofcreation(String dateofcreation) {
		this.dateofcreation = dateofcreation;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsactive() {
		return Isactive;
	}
	public void setIsactive(Boolean isactive) {
		Isactive = isactive;
	}
	public String getLastactive() {
		return lastactive;
	}
	public void setLastactive(String lastactive) {
		this.lastactive = lastactive;
	}

	
	
}


