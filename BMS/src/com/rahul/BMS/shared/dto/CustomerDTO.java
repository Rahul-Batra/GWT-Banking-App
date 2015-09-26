package com.rahul.BMS.shared.dto;

import java.io.Serializable;

import javax.persistence.Id;

@SuppressWarnings("serial")
public class CustomerDTO implements Serializable {

	@Id
	Long acctno;
	String pholdername;
	String address;
	Long mobile;
	String email;
	String passwd;
	String pan;

	public void setAcctno(Long acctno) {
		this.acctno = acctno;
	}
	
	public long getAcctno() {
		return acctno;
	}

	public String getPholdername() {
		return pholdername;
	}

	public void setPholdername(String pholdername) {
		this.pholdername = pholdername;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

}
