package com.ma.BMS.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.ma.BMS.client.AppController;
import com.ma.BMS.client.DataService;
import com.ma.BMS.client.DataServiceAsync;
import com.ma.BMS.shared.dto.SystemUserDTO;

public class LoginBox extends DialogBox {

	private static LoginBoxUiBinder uiBinder = GWT
			.create(LoginBoxUiBinder.class);

	interface LoginBoxUiBinder extends UiBinder<Widget, LoginBox> {
	}
	
	DataServiceAsync dataServiceAsync = GWT.create(DataService.class);
	
		
	@UiField
	TextBox usernameTxt;
	
	@UiField
	PasswordTextBox passwordTxt;
	
	@UiField
	Button submitBttn;

	@UiField
	Button resetBttn;
	
	
	
	AppController application = null;

	public LoginBox(AppController application) {
		setWidget(uiBinder.createAndBindUi(this));
		this.application = application;
		
	}
	
			
	public void checkUser()
	{
	dataServiceAsync.checkExist(usernameTxt.getText(), passwordTxt.getText(),  new AsyncCallback<SystemUserDTO>() {


		@Override
		public void onSuccess(SystemUserDTO result) {
			String s=result.getRole();
	 		if(s.equals("System User"))
				{
				
		    	if((result!=null)&&(result.getIsactive().equals(true)))
				{
		    					    					    					    		
					Welcome.lab.setText("Welcome "+ result.getName());
					hide();
					application.go(RootPanel.get());
																	
				}
				else
				{
					Window.alert("User doesn't Exist");
			   	}
		}	
				
				
				else if(s.equals("Accountant"))
				{

					MenuPanel.SystemUser.setStyleName("snvisible");
											
					if((result!=null)&&(result.getIsactive().equals(true)))
					{
												
						
						Welcome.lab.setText("Welcome "+ result.getName());
						hide();
						application.go(RootPanel.get());
						
				}
					else
					{
						Window.alert("User doesn't Exist");
				   	}
			
				}
	 		
	 		else if(s.equals("Analyst"))
				{
				
	 			MenuPanel.SystemUser.setStyleName("snvisible");
				MenuPanel.customer.setStyleName("cnvisible");
				MenuPanel.transaction.setStyleName("tnvisible");
				MenuPanel.account.setStyleName("rnvisible");
											
					if((result!=null)&&(result.getIsactive().equals(true)))
					{
												
						
						Welcome.lab.setText("Welcome "+ result.getName());
						hide();
						application.go(RootPanel.get());
						
				}
					else
					{
						Window.alert("User doesn't Exist");
				   	}
			
				}
				
				else
				{
					Window.alert("User doesn't Exist");
				}			
	
}
		
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("User doesn't Exist");
			}

		 	
		    });

	}
	
	@UiHandler("passwordTxt")
	public void onKeyPress(KeyPressEvent event) {
	if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER)
     	{
	     checkUser();
	  
    }

}
	
	
	@Override
	public void show() {
		setGlassEnabled(true);
		super.show();
	}
	
	@UiHandler("resetBttn")
	void onClickResetBttn(ClickEvent event) {

	usernameTxt.setText("");
	passwordTxt.setText("");
	}

	
/*	public static LoginBox instance = null;

	 public static LoginBox getInstance() {
	
		 if (instance == null)
		 instance = new LoginBox();
		 return instance;

	 }
*/
	
	 public LoginBox() {
			setWidget(uiBinder.createAndBindUi(this));
	  }
	
	@UiHandler("submitBttn")
	void onClickSubmitBttn(ClickEvent event) {
		checkUser();
		/*	if(usernameTxt.getText().equals("rahul") && passwordTxt.getText().equals("rahul"))
			{
				hide();
				application.go(RootPanel.get());
			}
			else
			{
				Window.alert("User doesn't exist");
			}*/
		
	}
}
