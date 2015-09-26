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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.rahul.BMS.client.DataService;
import com.rahul.BMS.client.DataServiceAsync;
import com.rahul.BMS.shared.JSNIutility;



public class Customer extends Composite  {

	private static CustomerUiBinder uiBinder = GWT
			.create(CustomerUiBinder.class);

	interface CustomerUiBinder extends UiBinder<Widget, Customer> {
	}
 
	public Customer() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	

	@UiField
	public TextBox pholdername;

	@UiField
	public TextArea address;

	@UiField
	public TextBox mobile;

	@UiField
	public TextBox email;

	@UiField
	public PasswordTextBox passwd;

	@UiField
	public PasswordTextBox cpswd;
	
	@UiField
	public TextBox pan;

	@UiField
	public Button submitcust;

	@UiField
	public Button resetcust;
	
	@UiField
	public Label uservalid;
	

	@UiField
	public Label uservalid1;
	
	@UiField
	public Label uservalid2;
	
	@UiHandler("email")
	public void onLostFocus(BlurEvent event)
	{
		String inp=email.getText();
		JSNIutility.regex(inp);
		
 }
	
	@UiHandler("mobile")
	public void onlostfocus(BlurEvent event)
	{
		String inp=mobile.getText();
		JSNIutility.validate(inp);
		
 }
	
	@UiHandler("cpswd")
	public void onlostFocus(BlurEvent event)
	{    
		if(!(cpswd.getText()).equals(""))
	{
		if(!(cpswd.getText()).equals(passwd.getText()))
		{uservalid1.setText("X wrong password");
		uservalid1.setStyleName("invalid");
		}
	}
	}	
	@UiHandler("pan")
	public void onLostfocus(BlurEvent event)
	{
		String inp=pan.getText();
		if(!inp.equals(""))
		{
			if(inp.length()!=10)
			{
				uservalid2.setText("X PAN is not valid");
				uservalid2.setStyleName("invalid");
			}
		}
		
	}
	
	@UiHandler("submitcust")
	void onClickSubmitCust(ClickEvent event) {
		DataServiceAsync dataServiceAsync = GWT.create(DataService.class);
		
		 final com.rahul.BMS.shared.dto.CustomerDTO customer =  new com.rahul.BMS.shared.dto.CustomerDTO();

		if ((pholdername.getText()).isEmpty()||(address.getText
				()).isEmpty()||(mobile.getText()).isEmpty()||(email.getText()).isEmpty()||(passwd.getText()).isEmpty()||(cpswd.getText()).isEmpty()||(pan.getText()).isEmpty()){
			JSNIutility.alertmsg();
			}
		else if(!(email.getText()).matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
			Window.alert("Email id is not valid");
		}
		else if(!(mobile.getText()).matches("^(\\+91[\\-\\s]?)?[89]\\d{9}$")){
			Window.alert("Mobile no is not valid");
		}

		else if((pan.getText()).length()!=10){
			Window.alert("PAN is not valid");
		}
		else if(!(cpswd.getText()).equals(passwd.getText())){
			Window.alert("Invalid password");
		}


		else{	
			    customer.setAddress(address.getText());
				customer.setPholdername(pholdername.getText());
				
				customer.setEmail(email.getText());
				
				customer.setMobile(Long.parseLong(mobile.getText()));
				customer.setPan(pan.getText());
				customer.setPasswd(passwd.getText());
			dataServiceAsync.addCustomer(customer, new AsyncCallback<Void>() {
		

			@Override
			public void onSuccess(Void result) {
				Window.alert("Customer Added");
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});}
	}

	@UiHandler("resetcust")
	void onClickresetbttn(ClickEvent event) {
		
		pholdername.setText("");
		address.setText("");
		mobile.setText("");
		email.setText("");
		passwd.setText("");
		pan.setText("");
		cpswd.setText("");
		uservalid.setStyleName("valid");
		uservalid1.setStyleName("valid");
		uservalid2.setStyleName("valid");

	}
}
