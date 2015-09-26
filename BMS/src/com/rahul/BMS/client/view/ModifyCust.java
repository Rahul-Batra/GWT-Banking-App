package com.rahul.BMS.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.rahul.BMS.client.DataService;
import com.rahul.BMS.client.DataServiceAsync;
import com.rahul.BMS.shared.JSNIutility;

public class ModifyCust extends Composite {

	private static ModifyCustUiBinder uiBinder = GWT
			.create(ModifyCustUiBinder.class);

	interface ModifyCustUiBinder extends UiBinder<Widget, ModifyCust> {
	}

	public ModifyCust() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	@UiField
	public TextBox modifycust;
	
	@UiField
	public Button submitbtn;
	
	@UiField
	public Button resetbtn;
	
	@UiField
	public TextBox modifyaddr;
	
	@UiField
	public TextBox modifyemail;
	
	@UiField
	public TextBox modifymobile;
	
	@UiField
	public TextBox modifypswd;
	
	@UiHandler("modifyemail")
	public void onLostFocus(BlurEvent event)
	{
		String inp=modifyemail.getText();
		JSNIutility.regex(inp);
		
    }
	
	@UiHandler("modifymobile")
	public void onlostfocus(BlurEvent event)
	{
		String inp=modifymobile.getText();
		JSNIutility.validate(inp);
		
    }
	
	
	@UiHandler("submitbtn")
	void onClickModifyCustomer(ClickEvent event) {
		DataServiceAsync dataServiceAsync = GWT.create(DataService.class);
		com.rahul.BMS.shared.dto.CustomerDTO customer =  new com.rahul.BMS.shared.dto.CustomerDTO();
		
		if((modifycust.getText()).isEmpty()||(modifyaddr.getText()).isEmpty()||(modifyemail.getText()).isEmpty()||(modifymobile.getText()).isEmpty()||(modifypswd.getText()).isEmpty())
		{
			JSNIutility.alertmsg();	
		}
		else if(!(modifyemail.getText()).matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
			Window.alert("Email id is not valid");
		}
		else if(!(modifymobile.getText()).matches("^(\\+91[\\-\\s]?)?[89]\\d{9}$")){
			Window.alert("Mobile no is not valid");
		}
		else{
			
		customer.setAcctno(Long.parseLong(modifycust.getText()));
		customer.setAddress(modifyaddr.getText());
		customer.setEmail(modifyemail.getText());
		customer.setMobile(Long.parseLong(modifymobile.getText()));
		customer.setPasswd(modifypswd.getText());
							
		
		dataServiceAsync.updateCustomer(customer, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				Window.alert("Modification Done");
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});}
	}


	@UiHandler("resetbtn")
	void onClickresetbtn(ClickEvent event) {
		modifycust.setText("");
		modifyaddr.setText("");
		modifyemail.setText("");
		modifymobile.setText("");
		modifypswd.setText("");
	}
	

}
