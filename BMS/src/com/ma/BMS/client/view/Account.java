package com.ma.BMS.client.view;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.ma.BMS.client.DataService;
import com.ma.BMS.client.DataServiceAsync;
import com.ma.BMS.shared.dto.CustomerDTO;

public class Account extends Composite {

	private static AccountUiBinder uiBinder = GWT.create(AccountUiBinder.class);

	interface AccountUiBinder extends UiBinder<Widget, Account> {
	}

	public Account() {
		initWidget(uiBinder.createAndBindUi(this));
		}

	@UiField
	public ListBox pholder;

	@UiField
	public RadioButton current;

	@UiField
	public RadioButton saving;

	@UiField
	public RadioButton single;

	@UiField
	public RadioButton joint;

	@UiField
	public TextBox balance;

	@UiField
	public ListBox accntholdersnme1;

	@UiField
	public Button addtextbutton;

	@UiField
	public Button addtextbutton1;

	@UiField
	public ListBox accntholdersnme2;

	@UiField
	public ListBox accntholdersnme3;

	@UiField
	public Button submitaccnt;

	@UiField
	public Button resetaccnt;

	@UiField
	public Label aholder;

	public static AccountUiBinder getUiBinder() {
		return uiBinder;
	}

	public static void setUiBinder(AccountUiBinder uiBinder) {
		Account.uiBinder = uiBinder;
	}

	public void showall()
	{	
		pholder.clear();
		accntholdersnme1.clear();
		accntholdersnme2.clear();
		accntholdersnme3.clear();
		pholder.addItem("");
		accntholdersnme1.addItem("");
		accntholdersnme2.addItem("");

		accntholdersnme3.addItem("");

		DataServiceAsync dataServiceAsync = GWT.create(DataService.class);
	dataServiceAsync.showCustomers(new AsyncCallback<ArrayList<com.ma.BMS.shared.dto.CustomerDTO>>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(ArrayList<CustomerDTO> result) {
			
								
		for (com.ma.BMS.shared.dto.CustomerDTO customer : result) {
					pholder.addItem(customer.getPholdername() , customer.getAcctno()+"");
					accntholdersnme1.addItem(customer.getPholdername(),customer.getAcctno()+"");
					accntholdersnme2.addItem(customer.getPholdername(),customer.getAcctno()+"");
					accntholdersnme3.addItem(customer.getPholdername(),customer.getAcctno()+"");
				}
			}
				
		
	});
	
	
	}
	
	
	
	@UiHandler("joint")
	void jointClicked(ClickEvent e) {
		accntholdersnme1.setVisible(true);
		addtextbutton.setVisible(true);
		addtextbutton.setEnabled(true);
		aholder.setVisible(true);
	}

	@UiHandler("single")
	void singleClicked(ClickEvent e) {
		accntholdersnme1.setVisible(false);
		addtextbutton.setVisible(false);
		addtextbutton.setEnabled(false);
		aholder.setVisible(false);
	}

	@UiHandler("addtextbutton")
	void onClickAddButton(ClickEvent event) {
		if (addtextbutton.getText().equalsIgnoreCase("+")) {
			String mypholder = pholder.getValue((pholder.getSelectedIndex()));
			String acpholder = accntholdersnme1.getValue(accntholdersnme1.getSelectedIndex());
			if (mypholder.equals(acpholder)) {
				Window.alert("Same name cant be added");
			} else {
				accntholdersnme2.setVisible(true);
				addtextbutton1.setVisible(true);
				addtextbutton.setText("-");
			}
		} else if (addtextbutton.getText().equalsIgnoreCase("-")) {
			accntholdersnme2.setSelectedIndex(0);
			accntholdersnme2.setVisible(false);
			addtextbutton.setText("+");
			addtextbutton1.setVisible(false);
		}
	}

	@UiHandler("addtextbutton1")
	void onClickAddButton1(ClickEvent event) {
		if (addtextbutton1.getText().equalsIgnoreCase("+")) {
			String mypholder = pholder.getValue(pholder.getSelectedIndex());
			String acpholder = accntholdersnme1.getValue(accntholdersnme1
					.getSelectedIndex());
			String accpholder = accntholdersnme2.getValue(accntholdersnme2
					.getSelectedIndex());
			if (mypholder.equals(accpholder) || acpholder.equals(accpholder)) {
				Window.alert("Same name cant be added");
			} else {
				accntholdersnme3.setVisible(true);
				addtextbutton1.setText("-");

			}
		} else if (addtextbutton1.getText().equalsIgnoreCase("-")) {
			accntholdersnme3.setSelectedIndex(0);
			accntholdersnme3.setVisible(false);
			addtextbutton1.setText("+");
		}
	}

	@UiHandler("accntholdersnme3")
	public void onselected(ChangeEvent event) {
		String mypholder = pholder.getValue(pholder.getSelectedIndex());
		String acpholder = accntholdersnme1.getValue(accntholdersnme1
				.getSelectedIndex());
		String accpholder = accntholdersnme2.getValue(accntholdersnme2
				.getSelectedIndex());
		String apholder = accntholdersnme3.getValue(accntholdersnme3
				.getSelectedIndex());
		if (mypholder.equals(apholder) || acpholder.equals(apholder)
				|| accpholder.equals(apholder)) {
			Window.alert("Same name cant be added");
		}
	}

	@UiHandler("submitaccnt")
	void onClickSubmitAcnt(ClickEvent event) {

		String mypholder = pholder.getValue(pholder.getSelectedIndex());
		String acpholder = accntholdersnme1.getValue(accntholdersnme1
				.getSelectedIndex());
		String accpholder = accntholdersnme2.getValue(accntholdersnme2
				.getSelectedIndex());
		String apholder = accntholdersnme3.getValue(accntholdersnme3
				.getSelectedIndex());

		if ((!current.getValue() && !saving.getValue())
				|| (!single.getValue() && !joint.getValue())
				|| balance.getValue() == ""||pholder.getValue(pholder.getSelectedIndex()).isEmpty())
			Window.alert("fill all the details");
		else if (joint.getValue() && !acpholder.isEmpty()
				&& (mypholder.equals(acpholder))) {

			Window.alert("Same name cant be added");
		} else if (joint.getValue() && !accpholder.isEmpty()
				&& (mypholder.equals(accpholder) || acpholder.equals(accpholder))) {

			Window.alert("Same name cant be added");
		} else if (joint.getValue()
				&& !apholder.isEmpty()
				&& (mypholder.equals(apholder) || acpholder.equals(apholder) || accpholder.equals(apholder))) {

			Window.alert("Same name cant be added");
		}

		else {
			DataServiceAsync dataServiceAsync = GWT.create(DataService.class);

			com.ma.BMS.shared.dto.AccountDTO account = new com.ma.BMS.shared.dto.AccountDTO();
			ArrayList<String> acustomer=new ArrayList<String>();

			acustomer.add(pholder.getValue(pholder.getSelectedIndex()));
			acustomer.add(accntholdersnme1
					.getValue(accntholdersnme1.getSelectedIndex()));
			acustomer.add(accntholdersnme2
					.getValue(accntholdersnme2.getSelectedIndex()));
			acustomer.add(accntholdersnme3
					.getValue(accntholdersnme3.getSelectedIndex()));
			
			account.setDateofopening(new Date());
			account.setTypeofaccount((current.getValue()) ? "current"
					: "saving");
			account.setTypeofholder((single.getValue()) ? "single" : "joint");
			account.setBalance(Long.parseLong(balance.getText()));
			account.setIsactive(true);
			account.setLasttransaction(new Date());
					
		    dataServiceAsync.addAccount(account, acustomer, new AsyncCallback<Void>() {

				@Override
				public void onSuccess(Void result) {
														
					Window.alert("Account Added");
	
				}

				@Override
				public void onFailure(Throwable caught) {
					 // TODO Auto-generated method stub
				}
			});
			 
			 }
	}
	

	@UiHandler("resetaccnt")
	void onClickresetbttn(ClickEvent event) {
		pholder.setSelectedIndex(0);
		addtextbutton.setVisible(false);
		addtextbutton.setText("+");
		addtextbutton1.setText("+");
		addtextbutton1.setVisible(false);
		balance.setText("");
		aholder.setVisible(false);
		accntholdersnme1.setVisible(false);
		accntholdersnme2.setVisible(false);
		accntholdersnme3.setVisible(false);
		accntholdersnme1.setSelectedIndex(0);
		accntholdersnme2.setSelectedIndex(0);
		accntholdersnme3.setSelectedIndex(0);
		current.setValue(false);
		saving.setValue(false);
		single.setValue(false);
		joint.setValue(false);
	}
}
