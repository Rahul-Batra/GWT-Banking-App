package com.ma.BMS.shared.dto;

import java.io.Serializable;

import javax.persistence.Id;

@SuppressWarnings("serial")
public class AccountCustomer implements Serializable{

	@Id
	Long acid;	
	Long acctno;	
	Long custid;
	Boolean IsPrimary;
	public Long getAcid() {
		return acid;
	}
	public void setAcid(Long acid) {
		this.acid = acid;
	}
	public Long getAcctno() {
		return acctno;
	}
	public void setAcctno(Long acctno) {
		this.acctno = acctno;
	}
	
	
	public Long getCustid() {
		return custid;
	}
	public void setCustid(Long custid) {
		this.custid = custid;
	}
	public Boolean getIsPrimary() {
		return IsPrimary;
	}
	public void setIsPrimary(Boolean isPrimary) {
		IsPrimary = isPrimary;
	}
	
	
}
