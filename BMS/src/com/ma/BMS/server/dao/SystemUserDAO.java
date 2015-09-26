package com.ma.BMS.server.dao;

import java.util.ArrayList;

import com.google.appengine.api.datastore.QueryResultIterator;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.ma.BMS.shared.dto.SystemUserDTO;

public class SystemUserDAO {

	static{
		ObjectifyService.register(SystemUserDTO.class);
	}
	
	public void add(SystemUserDTO systemuser){
		Objectify objectify = ObjectifyService.begin();
		objectify.put(systemuser);
	}
	
	public ArrayList<SystemUserDTO> show()
	{
		ObjectifyService.register(SystemUserDTO.class);
		Objectify ofy = ObjectifyService.begin();

		Query<SystemUserDTO> q = ofy.query(SystemUserDTO.class);

		ArrayList<SystemUserDTO> systemuser = new ArrayList<SystemUserDTO>();

		// Loop the query results and add to the array
		for (SystemUserDTO fetched : q) {

			systemuser.add(fetched);
		}

		return systemuser;
		
	}
	
	public boolean isUserExist(Long id) {
		Objectify objectify = ObjectifyService.begin();
		Query<SystemUserDTO> query = objectify.query(SystemUserDTO.class).filter("id", id);
		QueryResultIterator<SystemUserDTO> iterator = query.iterator();
		return iterator.hasNext();
	}
	
public void update(SystemUserDTO systemuser){
		
		Objectify objectify = ObjectifyService.begin();
		Query<SystemUserDTO> query = objectify.query(SystemUserDTO.class).filter("id", systemuser.getId());
		QueryResultIterator<SystemUserDTO> iterator = query.iterator();
		if(iterator.hasNext()){
			SystemUserDTO tempUser = iterator.next();
			tempUser.setName(systemuser.getName());
			tempUser.setRole(systemuser.getRole());
			tempUser.setPassword(systemuser.getPassword());
			objectify.put(tempUser);
		}
	}
	
	
	public void delete(Long idd)
	{
		
		Objectify objectify = ObjectifyService.begin();
		Query<SystemUserDTO> query = objectify.query(SystemUserDTO.class).filter("id", idd);
		QueryResultIterator<SystemUserDTO> iterator = query.iterator();
		if(iterator.hasNext()){
			SystemUserDTO tempUser = iterator.next();
			tempUser.setIsactive(Boolean.FALSE);
			objectify.put(tempUser);
		}
		
		
	}
	
	
	public ArrayList<SystemUserDTO> SearchData(String searchUser) {

		ObjectifyService.register(SystemUserDTO.class);
		Objectify ofy = ObjectifyService.begin();

		Query<SystemUserDTO> q = ofy.query(SystemUserDTO.class).filter("name",searchUser);

		ArrayList<SystemUserDTO> user = new ArrayList<SystemUserDTO>();

		// Loop the query results and add to the array
		for (SystemUserDTO fetched : q) {
			user.add(fetched);
		}
		return user;

	}

	public boolean isUserNameExist(String user) {
		Objectify objectify = ObjectifyService.begin();
		Query<SystemUserDTO> query = objectify.query(SystemUserDTO.class).filter("name", user);
		QueryResultIterator<SystemUserDTO> iterator = query.iterator();
		return iterator.hasNext();
	}
		
	public SystemUserDTO isExist(String user,String pswd)
	{
		Objectify objectify = ObjectifyService.begin();
Query<SystemUserDTO> query = objectify.query(SystemUserDTO.class).filter("name", user).filter("password", pswd);
	   return query.get();
	}

}
