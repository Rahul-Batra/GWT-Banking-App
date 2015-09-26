package com.rahul.BMS.server.dao;

import java.util.ArrayList;

import com.google.gwt.user.client.Window;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.rahul.BMS.shared.dto.AccountCustomer;

public class AccountCustomerDAO {

	static{
		ObjectifyService.register(AccountCustomer.class);
	}
	public void add(AccountCustomer accountcustomer){
		Objectify objectify = ObjectifyService.begin();
		objectify.put(accountcustomer);
	}
	
	public  ArrayList<AccountCustomer> viewacntcust(Long acnt) {
		ObjectifyService.register(AccountCustomer.class);
		Objectify ofy = ObjectifyService.begin();

		Query<AccountCustomer> q = ofy.query(AccountCustomer.class).filter("acctno",acnt);

		ArrayList<AccountCustomer> accountcustomer = new ArrayList<AccountCustomer>();
			for (AccountCustomer fetched : q) {
				accountcustomer.add(fetched);
				}
		return accountcustomer;
		}
	
	
	public void delete(Long acntNo)
	{
		
		Objectify objectify = ObjectifyService.begin();
		Query<AccountCustomer> query = objectify.query(AccountCustomer.class).filter("acctno", acntNo);
   		objectify.delete(query);
   		
	}
	

	
	
	
	public static ArrayList<String> accntcust(Long actno)
	{
		
		CustomerDAO customerdao=new CustomerDAO();
		AccountDAO accountdao=new AccountDAO();
		AccountCustomerDAO accountcustomerdao=new AccountCustomerDAO();
		 ArrayList<String> acntcust=new ArrayList<String>();
		 ArrayList<AccountCustomer> result=new ArrayList<AccountCustomer>();
		 ArrayList<com.rahul.BMS.shared.dto.AccountDTO> reslt=new ArrayList<com.rahul.BMS.shared.dto.AccountDTO>();
		 ArrayList<com.rahul.BMS.shared.dto.CustomerDTO> resltcust=new ArrayList<com.rahul.BMS.shared.dto.CustomerDTO>();
		 result=accountcustomerdao.viewacntcust(actno);
		 if(result.isEmpty())
				Window.alert("No data found for the given account");
		 else{
				
				for (com.rahul.BMS.shared.dto.AccountCustomer acntcustomer : result)
				{
					if(acntcustomer.getIsPrimary()==true)
					{
						reslt=accountdao.SearchAccnt(acntcustomer.getAcctno());
						for (com.rahul.BMS.shared.dto.AccountDTO account : reslt) 
							{
						 	
							acntcust.add(""+account.getAcctno());
							acntcust.add(""+account.getTypeofaccount());
							acntcust.add(""+account.getTypeofholder());							
							}
						resltcust=customerdao.Searchrecord(acntcustomer.getCustid());
						for (com.rahul.BMS.shared.dto.CustomerDTO customer : resltcust) 
							{							
							acntcust.add(""+customer.getPholdername());
							acntcust.add(""+customer.getEmail());
							acntcust.add(""+customer.getMobile());
							acntcust.add(customer.getAddress());
							acntcust.add(customer.getPan());
			              
			                }	
					}
					else
					{
						resltcust=customerdao.Searchrecord(acntcustomer.getCustid());
						for (com.rahul.BMS.shared.dto.CustomerDTO customer : resltcust) 
						{							
						acntcust.add(""+customer.getPholdername());		              
		                }	
					}
				}
		 	}
			return acntcust;		
	}
}

