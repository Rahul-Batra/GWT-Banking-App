package com.ma.BMS.client.view;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.ma.BMS.client.DataService;
import com.ma.BMS.client.DataServiceAsync;

public class SystemUser extends Composite {

	private static SystemUserUiBinder uiBinder = GWT
			.create(SystemUserUiBinder.class);

	interface SystemUserUiBinder extends UiBinder<Widget, SystemUser> {
	}

	public SystemUser() {
		initWidget(uiBinder.createAndBindUi(this));
							
	}

	DataServiceAsync dataServiceAsync = GWT.create(DataService.class);

	@UiField
	public TextBox name;

	@UiField
	public PasswordTextBox password;

	@UiField
	public ListBox role;

 	@UiField
	public Button add;
 	
 	@UiField
 	Label uservalid;

	@UiField
	public Button clear;
	
	
	@UiHandler("name")
	public void nameOnLostFocus(BlurEvent event)
	  {
		String inp=name.getText();
				
		if(!inp.equals(""))
		{
		if(!inp.matches("[a-zA-Z0-9]*"))
		{   uservalid.setText("X Special Chars are not allowed"); 
			uservalid.setStyleName("invalid");
		}
		else 
		{
			dataServiceAsync.checkUserExist(inp , new AsyncCallback<Boolean>() {

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("UserName already Existed");
					
				}

				@Override
				public void onSuccess(Boolean result) {
					
					if(result.equals(true))
					{
					uservalid.setText("User is not Available");
   					uservalid.setStyleName("invalid"); 
										 
	                }
	                 else
	                  {
	               	 uservalid.setText("");
	                 uservalid.setStyleName("validd");
	                                                                                  
	              }
	    	}
    });
			
  }
}
		else
		   {
			Window.alert("Username can't be null");
		   }
				
}
		
	
	
	public void addUserName(String username)
	    {
	 	
		dataServiceAsync.checkUserExist(username , new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("UserName already Existed");
				
			}

			@Override
			public void onSuccess(Boolean result) {
			
				
				if(result.equals(false))
				{
 com.ma.BMS.shared.dto.SystemUserDTO systemuser =  new com.ma.BMS.shared.dto.SystemUserDTO();
						
			 systemuser.setName(name.getText());
			 systemuser.setPassword(password.getText());
				
			int i=role.getSelectedIndex();
		    systemuser.setRole(role.getItemText(i));
					
			        
		systemuser.setDateofcreation(DateTimeFormat.getFormat( "d-M-yyyy" ).format(new Date()));
					 systemuser.setIsactive(Boolean.TRUE);
					 systemuser.setLastactive(null);
					
								 
		 dataServiceAsync.addUser(systemuser, new AsyncCallback<Void>() {
						 
								
						@Override
						public void onSuccess(Void result) {
							Window.alert("User Added");
						}

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("UserName already Existed");

				}
							
			});
				
		 				}
				else 
				{
					Window.alert("User already Existed");
				}
			}
	
               		
		});	
			 
	}
	
	
	
	@UiHandler("add")
	void onClickadd(ClickEvent event) {

		String user=name.getText();
		if(!user.equals(""))
		{
			if(user.matches("[a-zA-Z0-9]*"))
			{ 
				addUserName(user);
			}
			else
			{
				Window.alert("Special Chars are not allowed");
			}
				
		}
	
		else
		{
			Window.alert("UserName can't be null");
		}
}
		
	
	@UiHandler("clear")
	void onClickcleartbttn(ClickEvent event) {
		name.setText("");
		password.setText("");
		uservalid.setStyleName("valid");
		//role.setText("");
		
	}
}
