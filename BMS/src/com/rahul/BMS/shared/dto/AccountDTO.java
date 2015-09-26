package com.rahul.BMS.shared.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

@SuppressWarnings("serial")
public class AccountDTO implements Serializable {

	@Id
	Long acctno;
	boolean isactive;
	String typeofaccount;
	Long balance;
	Date lasttransaction;
	String typeofholder;
	Date dateofopening;

	public String getTypeofholder() {
		return typeofholder;
	}

	public void setTypeofholder(String string) {
		this.typeofholder = string;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public String getTypeofaccount() {
		return typeofaccount;
	}

	public void setTypeofaccount(String typeofaccount) {
		this.typeofaccount = typeofaccount;
	}

	public Long getAcctno() {
		return acctno;
	}

	public void setAcctno(Long acctno) {
		this.acctno = acctno;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	

	public Date getLasttransaction() {
		return lasttransaction;
	}

	public void setLasttransaction(Date lasttransaction) {
		this.lasttransaction = lasttransaction;
	}

	public Date getDateofopening() {
		return dateofopening;
	}

	public void setDateofopening(Date dateofopening) {
		this.dateofopening = dateofopening;
	}

	
	
}
