package com.ma.BMS.client.view;

import com.google.gwt.core.client.GWT;
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
import com.ma.BMS.client.DataService;
import com.ma.BMS.client.DataServiceAsync;

public class Deposit extends Composite {

	private static DepositUiBinder uiBinder = GWT.create(DepositUiBinder.class);

	interface DepositUiBinder extends UiBinder<Widget, Deposit> {
	}

	public Deposit() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	public TextBox accnttran;
	
	@UiField
	public TextBox amnt;
	
	@UiField
	public Button depst;
	
	@UiField
	public Button withdrw;
	
	@UiField
	public Button rest;
	
	@UiHandler("depst")
	void onClickDepositAmnt(ClickEvent event) {
		com.ma.BMS.shared.dto.AccountDTO accnt =  new com.ma.BMS.shared.dto.AccountDTO();
		accnt.setAcctno(Long.parseLong(accnttran.getText()));
		accnt.setBalance(Long.parseLong(amnt.getText()));
				DataServiceAsync dataServiceAsync = GWT.create(DataService.class);
				dataServiceAsync.updateAccount(accnt, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				Window.alert("Modification Done");
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	@UiHandler("withdrw")
	void onClickWithdrwAmnt(ClickEvent event) {
		com.ma.BMS.shared.dto.AccountDTO accnt =  new com.ma.BMS.shared.dto.AccountDTO();
		accnt.setAcctno(Long.parseLong(accnttran.getText()));
		accnt.setBalance(Long.parseLong(amnt.getText()));
				DataServiceAsync dataServiceAsync = GWT.create(DataService.class);
				dataServiceAsync.withdAccount(accnt, new AsyncCallback<Integer>() {
			
			@Override
			public void onSuccess(Integer result) {
				if(result.equals(0))
					Window.alert("Amount exceeded the limit");
				else
				Window.alert("Modification Done");
				
					
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("transaction not possible");
				
			}

			
		});
		
	}
	@UiHandler("rest")
	void onClickRestAmnt(ClickEvent event) {
		accnttran.setText("");
		amnt.setText("");
		
	}
	
	
	
}
