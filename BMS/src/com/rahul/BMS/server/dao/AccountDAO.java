package com.rahul.BMS.server.dao;

import java.util.ArrayList;
import java.util.Date;

import com.google.appengine.api.datastore.QueryResultIterator;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.rahul.BMS.shared.dto.AccountDTO;


public class AccountDAO {
	static{
		ObjectifyService.register(AccountDTO.class);
	}
	
	public void add(AccountDTO account){
		Objectify objectify = ObjectifyService.begin();
		objectify.put(account);
	}
	public void updateacc(AccountDTO account){
		Objectify objectify = ObjectifyService.begin();
		Query<AccountDTO> query = objectify.query(AccountDTO.class).filter("acctno", account.getAcctno());
		QueryResultIterator<AccountDTO> iterator = query.iterator();
			
		
		if(iterator.hasNext()){
			AccountDTO tempacc = iterator.next();
			tempacc.setBalance((tempacc.getBalance()+account.getBalance()));
			tempacc.setLasttransaction(new Date());
			objectify.put(tempacc);
		}
			
	}
	public int withdrwacc(AccountDTO account){
		Objectify objectify = ObjectifyService.begin();
		Query<AccountDTO> query = objectify.query(AccountDTO.class).filter("acctno", account.getAcctno());
		QueryResultIterator<AccountDTO> iterator = query.iterator();
		
		if(iterator.hasNext()){
			AccountDTO tempacc = iterator.next();
			if((tempacc.getBalance()-account.getBalance())<500)
				return 0;
			else
			{
			tempacc.setBalance((tempacc.getBalance()-account.getBalance()));
			tempacc.setLasttransaction(new Date());
			objectify.put(tempacc);
			}	
		}
		
		return 1;
			
	}
	public void deleteacc(Long dela)
	{
	
		Objectify objectify = ObjectifyService.begin();
		
		Query<AccountDTO> query = objectify.query(AccountDTO.class).filter("acctno", dela);
		QueryResultIterator<AccountDTO> iterator = query.iterator();
		
		if(iterator.hasNext()){
			AccountDTO tempUser = iterator.next();
			tempUser.setIsactive(Boolean.FALSE);
			objectify.put(tempUser);
			CustomerDAO customerdao=new CustomerDAO();
            customerdao.delete(tempUser.getAcctno());
		}
		
	}
	
	
	public void delete(Long acntNo)
	{
		
		Objectify objectify = ObjectifyService.begin();
		Query<AccountDTO> query = objectify.query(AccountDTO.class).filter("id", acntNo);
   		objectify.delete(query);
   		
	}
	
	

	public  ArrayList<AccountDTO> SearchAccnt(Long searchaccount) {
		ObjectifyService.register(AccountDTO.class);
		Objectify ofy = ObjectifyService.begin();

		Query<AccountDTO> q = ofy.query(AccountDTO.class).filter("acctno",searchaccount);

		ArrayList<AccountDTO> account = new ArrayList<AccountDTO>();
			for (AccountDTO fetched : q) {
				account.add(fetched);
				}
		return account;
		}
	

	
}
