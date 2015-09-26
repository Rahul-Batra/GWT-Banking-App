package com.ma.BMS.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.ma.BMS.shared.dto.AccountCustomer;
import com.ma.BMS.shared.dto.AccountDTO;
import com.ma.BMS.shared.dto.CustomerDTO;
import com.ma.BMS.shared.dto.SystemUserDTO;

@RemoteServiceRelativePath("dataservercall")
public interface DataService extends RemoteService {
	
	void addUser(com.ma.BMS.shared.dto.SystemUserDTO systemuser);
	public ArrayList<SystemUserDTO> showData();
	public void updateSystemUser(SystemUserDTO systemUser);
	public void deleteSystemUser(Long idd);
	public ArrayList<SystemUserDTO> searchSystemUser(String user);
    public Boolean checkUserExist(String username);
	public SystemUserDTO checkExist(String user,String pswd);
	
	public void addCustomer(CustomerDTO customer);
	public void deleteCustomer(Long acntNo);
	public void deleteCustomr(String name);
	public void updateCustomer(CustomerDTO customer);
	public ArrayList<CustomerDTO> searchCustomer(String cust);
	public ArrayList<CustomerDTO> showCustomers();
	
	
	public void addAccount(AccountDTO account,ArrayList<String> acustomer);
	public void deleteAccount(Long dela);
	public void updateAccount(AccountDTO account);
	public ArrayList<AccountDTO> SearchAccount(Long searchaccount);
	public ArrayList<AccountDTO> viewaccountData();
	public int withdAccount(AccountDTO account);
	
	
	public ArrayList<AccountCustomer> viewaccntcust(Long acnt);
	public ArrayList<CustomerDTO> searchCust(Long cust);
	
	public ArrayList<String> reportgenrte(Long searchaccount);
}
