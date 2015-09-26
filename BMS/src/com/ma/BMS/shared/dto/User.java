package com.ma.BMS.shared.dto;

import java.util.Date;

public class User {
	long accountno;
	String primaryholdername;
	String address;
	String role;
	long mobile;
	String emailid;
	String panno;
	Boolean isactive;
	String password;
	char typeofaccount;
	long currentbal;
	Date lasttransaction;
	String Typeofaccountholder;
	Date dateofopening;
	String benificiary;
	String nameofaccountholders[];
	String nameofbranch;
	public long getAccountno() {
		return accountno;
	}
	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}
	public String getPrimaryholdername() {
		return primaryholdername;
	}
	public void setPrimaryholdername(String primaryholdername) {
		this.primaryholdername = primaryholdername;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPanno() {
		return panno;
	}
	public void setPanno(String panno) {
		this.panno = panno;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getTypeofaccount() {
		return typeofaccount;
	}
	public void setTypeofaccount(char typeofaccount) {
		this.typeofaccount = typeofaccount;
	}
	public long getCurrentbal() {
		return currentbal;
	}
	public void setCurrentbal(long currentbal) {
		this.currentbal = currentbal;
	}
	public Date getLasttransaction() {
		return lasttransaction;
	}
	public void setLasttransaction(Date lasttransaction) {
		this.lasttransaction = lasttransaction;
	}
	public String getTypeofaccountholder() {
		return Typeofaccountholder;
	}
	public void setTypeofaccountholder(String typeofaccountholder) {
		Typeofaccountholder = typeofaccountholder;
	}
	public Date getDateofopening() {
		return dateofopening;
	}
	public void setDateofopening(Date dateofopening) {
		this.dateofopening = dateofopening;
	}
	public String getBenificiary() {
		return benificiary;
	}
	public void setBenificiary(String benificiary) {
		this.benificiary = benificiary;
	}
	public String[] getNameofaccountholders() {
		return nameofaccountholders;
	}
	public void setNameofaccountholders(String[] nameofaccountholders) {
		this.nameofaccountholders = nameofaccountholders;
	}
	public String getNameofbranch() {
		return nameofbranch;
	}
	public void setNameofbranch(String nameofbranch) {
		this.nameofbranch = nameofbranch;
	}

}
