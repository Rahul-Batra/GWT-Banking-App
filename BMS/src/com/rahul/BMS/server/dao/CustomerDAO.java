package com.rahul.BMS.server.dao;

import java.util.ArrayList;

import com.google.appengine.api.datastore.QueryResultIterator;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.rahul.BMS.shared.dto.CustomerDTO;


public class CustomerDAO {
	static{
		ObjectifyService.register(CustomerDTO.class);
	}
	
	public void add(CustomerDTO customer){
		Objectify objectify = ObjectifyService.begin();
		objectify.put(customer);
	}
	

	public ArrayList<CustomerDTO> show()
	{
		ObjectifyService.register(CustomerDTO.class);
		Objectify ofy = ObjectifyService.begin();

		Query<CustomerDTO> q = ofy.query(CustomerDTO.class);

		ArrayList<CustomerDTO> cust = new ArrayList<CustomerDTO>();

		// Loop the query results and add to the array
		for (CustomerDTO fetched : q) {

			cust.add(fetched);
		}

		return cust;
		
	}
	
	public boolean isUserExist(Long id) {
		Objectify objectify = ObjectifyService.begin();
		Query<CustomerDTO> query = objectify.query(CustomerDTO.class).filter("id", id);
		QueryResultIterator<CustomerDTO> iterator = query.iterator();
		return iterator.hasNext();
	}
	
	public void update(CustomerDTO customeruser){
		
		Objectify objectify = ObjectifyService.begin();
		Query<CustomerDTO> query = objectify.query(CustomerDTO.class).filter("id", customeruser.getAcctno());
    	QueryResultIterator<CustomerDTO> iterator = query.iterator();
		if(iterator.hasNext()){
			CustomerDTO tempUser = iterator.next();
			tempUser.setAddress(customeruser.getAddress());
			tempUser.setEmail(customeruser.getEmail());
			tempUser.setMobile(customeruser.getMobile());
			tempUser.setPasswd(customeruser.getPasswd());
			objectify.put(tempUser);
		}
	}
	
	
	public void delete(Long acntNo)
	{
		
		Objectify objectify = ObjectifyService.begin();
		Query<CustomerDTO> query = objectify.query(CustomerDTO.class).filter("id", acntNo);
   		objectify.delete(query);
   		
	}
	
	public void delette(String name)
	{
		
		Objectify objectify = ObjectifyService.begin();
		Query<CustomerDTO> query = objectify.query(CustomerDTO.class).filter("pholdername", name);
   		objectify.delete(query);
   		
        QueryResultIterator<CustomerDTO> iterator = query.iterator();
		
		if(iterator.hasNext()){
			CustomerDTO tempUser = iterator.next();
		    AccountDAO accountDao=new AccountDAO();
		    AccountCustomerDAO acntCustDao=new AccountCustomerDAO();
		    
		    accountDao.delete(tempUser.getAcctno());
		    acntCustDao.delete(tempUser.getAcctno());
		}
	}
	
	
	public ArrayList<CustomerDTO> SearchData(String searchCust) {

		ObjectifyService.register(CustomerDTO.class);
		Objectify ofy = ObjectifyService.begin();

		Query<CustomerDTO> q = ofy.query(CustomerDTO.class).filter("pholdername",searchCust);

		ArrayList<CustomerDTO> custt = new ArrayList<CustomerDTO>();

		// Loop the query results and add to the array
		for (CustomerDTO fetched : q) {

			custt.add(fetched);
		}

		return custt;

	}
	public ArrayList<CustomerDTO> Searchrecord(Long cid) {

		ObjectifyService.register(CustomerDTO.class);
		Objectify ofy = ObjectifyService.begin();

		Query<CustomerDTO> q = ofy.query(CustomerDTO.class).filter("acctno",cid);

		ArrayList<CustomerDTO> custt = new ArrayList<CustomerDTO>();

		// Loop the query results and add to the array
		for (CustomerDTO fetched : q) {

			custt.add(fetched);
		}

		return custt;

	}

	
}

