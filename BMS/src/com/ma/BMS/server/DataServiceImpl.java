package com.ma.BMS.server;

import java.util.ArrayList;

import com.googlecode.objectify.Query;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.ma.BMS.client.DataService;
import com.ma.BMS.server.dao.AccountCustomerDAO;
import com.ma.BMS.server.dao.AccountDAO;
import com.ma.BMS.server.dao.CustomerDAO;
import com.ma.BMS.server.dao.SystemUserDAO;
import com.ma.BMS.shared.dto.AccountCustomer;
import com.ma.BMS.shared.dto.AccountDTO;
import com.ma.BMS.shared.dto.CustomerDTO;
import com.ma.BMS.shared.dto.SystemUserDTO;

@SuppressWarnings("serial")
public class DataServiceImpl extends RemoteServiceServlet implements
		DataService {

	@Override
	public void addCustomer(CustomerDTO customer) 
	{
		CustomerDAO customerDAO =  new CustomerDAO();
		customerDAO.add(customer);
	}

	
	@Override
	public void addUser(SystemUserDTO systemuser) {
		
		SystemUserDAO systemuserDAO =  new SystemUserDAO();
		systemuserDAO.add(systemuser);
		
	}

	@Override
	public ArrayList<SystemUserDTO> showData() {
		
		SystemUserDAO systemuserDAO =  new SystemUserDAO();
		ArrayList<SystemUserDTO> system = new ArrayList<SystemUserDTO>();

		system=systemuserDAO.show();
		return system;
	}

	
	@Override
	public void updateSystemUser(SystemUserDTO systemUser) 
	{
		SystemUserDAO systemUserDAO =  new SystemUserDAO();
		systemUserDAO.update(systemUser);
	}

	
	@Override
	public void deleteSystemUser(Long idd) {
	
		SystemUserDAO systemUserDAO =  new SystemUserDAO();
		systemUserDAO.delete(idd);
	
	}
	
	
	
	@Override
	public ArrayList<SystemUserDTO> searchSystemUser(String user) {

		SystemUserDAO systemuserDAO =  new SystemUserDAO();
		ArrayList<SystemUserDTO> system = new ArrayList<SystemUserDTO>();

		system=systemuserDAO.SearchData(user);
		return system;

	}
	
	
	@Override
	public void updateCustomer(CustomerDTO customer) {
		
		CustomerDAO customerDAO =  new CustomerDAO();
		customerDAO.update(customer);
	}


	@Override
	public void deleteCustomer(Long acntNo) {
	
		CustomerDAO customerDAO =  new CustomerDAO();
		customerDAO.delete(acntNo);
	
	}
	
	
	@Override
	public ArrayList<CustomerDTO> searchCustomer(String cust) {

		CustomerDAO customerDAO =  new CustomerDAO();
		ArrayList<CustomerDTO> customer = new ArrayList<CustomerDTO>();

		customer=customerDAO.SearchData(cust);
		return customer;

	}

	@Override
	public Boolean checkUserExist(String username) {
		SystemUserDAO systemuserDAO=new SystemUserDAO();
		
		return systemuserDAO.isUserNameExist(username);
		
	}

	@Override
	public SystemUserDTO checkExist(String user, String pswd) {
		SystemUserDAO systemuserDAO=new SystemUserDAO();
		return systemuserDAO.isExist(user, pswd);
		
	}

	

	@Override
	public void deleteAccount(Long dela) {
		AccountDAO accountDAO =  new AccountDAO();
		accountDAO.deleteacc(dela);
		
	}

	

	@Override
	public ArrayList<AccountDTO> SearchAccount(Long searchaccount) {
		AccountDAO accountDAO =  new AccountDAO();
		ArrayList<AccountDTO> account = new ArrayList<AccountDTO>();
		account=accountDAO.SearchAccnt(searchaccount);
		return account;

	}

	
	

	@Override
	public ArrayList<AccountCustomer> viewaccntcust(Long acnt) {
		
		AccountCustomerDAO accountcustomerDAO =  new AccountCustomerDAO();
		ArrayList<AccountCustomer> accountcust = new ArrayList<AccountCustomer>();
		accountcust=accountcustomerDAO.viewacntcust(acnt);
		return accountcust;
	}

	
	@Override
	public void addAccount(AccountDTO account, ArrayList<String> acustomer) {
		AccountDAO accountDAO = new AccountDAO();
		accountDAO.add(account);
		acustomer.trimToSize();		
		for(int i=0;i<acustomer.size();i++)
		{
			if(acustomer.get(i).isEmpty())
				continue;
			else
			{
		AccountCustomerDAO accountcustomerdao=new AccountCustomerDAO();
		AccountCustomer accust=new AccountCustomer();
		accust.setCustid(Long.parseLong(acustomer.get(i)));
		accust.setAcctno(account.getAcctno());
			if(i==0)
				accust.setIsPrimary(true);
			else
				accust.setIsPrimary(false);
		accountcustomerdao.add(accust);
		
		
		
			}
		}
	
		
	}


	@Override
	public void updateAccount(AccountDTO account) {
		AccountDAO accountDAO =  new AccountDAO();
		accountDAO.updateacc(account);
		
	}


	@Override
	public int withdAccount(AccountDTO account) {
		AccountDAO accountDAO =  new AccountDAO();
		int amnt=accountDAO.withdrwacc(account);
		return amnt;
	}


	@Override
	public ArrayList<CustomerDTO> showCustomers() {
		CustomerDAO customerDAO =  new CustomerDAO();
		ArrayList<CustomerDTO> custt = new ArrayList<CustomerDTO>();

		custt=customerDAO.show();
		return custt;
	}


	@Override
	public ArrayList<CustomerDTO> searchCust(Long cust) {
		CustomerDAO customerDAO =  new CustomerDAO();
		ArrayList<CustomerDTO> customer = new ArrayList<CustomerDTO>();

		customer=customerDAO.Searchrecord(cust);
		return customer;

	}


	@Override
	public ArrayList<AccountDTO> viewaccountData() {
		ObjectifyService.register(AccountDTO.class);
		Objectify ofy = ObjectifyService.begin();

		Query<AccountDTO> q = ofy.query(AccountDTO.class);

		ArrayList<AccountDTO> account = new ArrayList<AccountDTO>();

		// Loop the query results and add to the array
		for (AccountDTO fetched : q) {
			if(fetched.isIsactive())
			account.add(fetched);
		}
		return account;
	}

	@Override
	public ArrayList<String> reportgenrte(Long searchaccount) {
	ArrayList<String> accountcustomr = new ArrayList<String>();
	accountcustomr=AccountCustomerDAO.accntcust(searchaccount);
	return accountcustomr;

	}


	@Override
	public void deleteCustomr(String name) {
		
		CustomerDAO customerDAO =  new CustomerDAO();
		customerDAO.delette(name);
			
	}


	
}
