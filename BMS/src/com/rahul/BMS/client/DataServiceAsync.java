package com.rahul.BMS.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rahul.BMS.shared.dto.AccountCustomer;
import com.rahul.BMS.shared.dto.AccountDTO;
import com.rahul.BMS.shared.dto.CustomerDTO;
import com.rahul.BMS.shared.dto.SystemUserDTO;

public interface DataServiceAsync {
	void addCustomer(CustomerDTO customer, AsyncCallback<Void> callback);

	
	void addUser(SystemUserDTO systemuser, AsyncCallback<Void> callback);

	void showData(AsyncCallback<ArrayList<SystemUserDTO>> callback);

	void updateSystemUser(SystemUserDTO systemUser, AsyncCallback<Void> callback);

	void deleteSystemUser(Long idd, AsyncCallback<Void> callback);

	void searchSystemUser(String user,
			AsyncCallback<ArrayList<SystemUserDTO>> callback);

	void updateCustomer(CustomerDTO customer, AsyncCallback<Void> callback);

	

	
	void searchCustomer(String cust,
			AsyncCallback<ArrayList<CustomerDTO>> callback);

	void checkUserExist(String username, AsyncCallback<Boolean> callback);

	void checkExist(String user, String pswd,
			AsyncCallback<SystemUserDTO> callback);

	void deleteAccount(Long dela, AsyncCallback<Void> callback);

	
	void viewaccntcust(Long acnt,
			AsyncCallback<ArrayList<AccountCustomer>> callback);

	


	void addAccount(AccountDTO account, ArrayList<String> acustomer,
			AsyncCallback<Void> callback);


	void updateAccount(AccountDTO account, AsyncCallback<Void> callback);


	void SearchAccount(Long searchaccount,
			AsyncCallback<ArrayList<AccountDTO>> callback);


	void viewaccountData(AsyncCallback<ArrayList<AccountDTO>> callback);


	void withdAccount(AccountDTO account, AsyncCallback<Integer> callback);


	void showCustomers(AsyncCallback<ArrayList<CustomerDTO>> callback);


	void searchCust(Long cust, AsyncCallback<ArrayList<CustomerDTO>> callback);


	void reportgenrte(Long searchaccount,
			AsyncCallback<ArrayList<String>> callback);


	void deleteCustomer(Long acntNo, AsyncCallback<Void> callback);


	void deleteCustomr(String name, AsyncCallback<Void> callback);


	
}