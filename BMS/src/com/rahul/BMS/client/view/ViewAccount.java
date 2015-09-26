package com.rahul.BMS.client.view;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.rahul.BMS.client.DataService;
import com.rahul.BMS.client.DataServiceAsync;

public class ViewAccount extends Composite {

	private static ViewAccountUiBinder uiBinder = GWT
			.create(ViewAccountUiBinder.class);

	interface ViewAccountUiBinder extends UiBinder<Widget, ViewAccount> {
	}

	public ViewAccount() {
		initWidget(uiBinder.createAndBindUi(this));
		viewaccnt();
	}

		
	@UiField
	public FlexTable tableaccnt;
	
	@UiField
	public Button bsrch;
	
	@UiField
	public TextBox srch;
	
	@UiHandler("bsrch")
 public void onClickSrchAccount(ClickEvent event) {
		
		DataServiceAsync dataServiceAsync = GWT.create(DataService.class);
		
		tableaccnt.removeAllRows();
		dataServiceAsync.SearchAccount(Long.parseLong(srch.getText()),new AsyncCallback<ArrayList<com.rahul.BMS.shared.dto.AccountDTO>>() {
					
			
			 @Override
 			public void onFailure(Throwable caught) {
 				// TODO Auto-generated method stub

 			}
			 
			 @Override
			public void onSuccess(ArrayList<com.rahul.BMS.shared.dto.AccountDTO> result) {
				int row = 0;
				tableaccnt.setVisible(true);
				tableaccnt.setText(0, 0, "account number ");
				tableaccnt.setText(0, 1,  "Isactive");
				tableaccnt.setText(0, 2, "Type of account ");
				tableaccnt.setText(0, 3, "current balance");
				tableaccnt.setText(0, 4, "last transaction ");
				tableaccnt.setText(0, 5, "Type of account holder");
				tableaccnt.setText(0, 6, "Date of opening");

			      //loop the array list and user getters to add 
                //records to the table
                for (com.rahul.BMS.shared.dto.AccountDTO account : result) {
                  row = tableaccnt.getRowCount();
                 if(!(account.isIsactive()))
                 {
                	 tableaccnt.removeAllRows();
                	 tableaccnt.setVisible(false);
                	 Window.alert("Account has been deactivated");
                 }
                 else
                 {
                	 tableaccnt.setText(row, 0, ""+account.getAcctno());
                	 tableaccnt.setText(row, 1, ""+account.isIsactive());
                	 tableaccnt.setText(row, 2, ""+account.getTypeofaccount());
                	 tableaccnt.setText(row, 3, ""+account.getBalance());
                	 tableaccnt.setText(row, 4, ""+account.getLasttransaction());
                	 tableaccnt.setText(row, 5, ""+account.getTypeofholder());
                	 tableaccnt.setText(row, 6, ""+account.getDateofopening());
                              }
                }
			}

		 });
	}
	public void viewaccnt() {
		
		final DataServiceAsync dataServiceAsync = GWT.create(DataService.class);
		
		tableaccnt.removeAllRows();
		
		tableaccnt.setText(0, 0, "account number ");
		tableaccnt.setText(0, 1,  "Isactive");
		tableaccnt.setText(0, 2, "Type of account ");
		tableaccnt.setText(0, 3, "current balance");
		tableaccnt.setText(0, 4, "last transaction ");
		tableaccnt.setText(0, 5, "Type of account holder");
		tableaccnt.setText(0, 6, "Date of opening");
		tableaccnt.setText(0, 7, "Remove");
		tableaccnt.setVisible(true);
		
			dataServiceAsync.viewaccountData(new AsyncCallback<ArrayList<com.rahul.BMS.shared.dto.AccountDTO>>() {
				 @Override
 			public void onFailure(Throwable caught) {
 				// TODO Auto-generated method stub

 			}
			@Override
			public void onSuccess(ArrayList<com.rahul.BMS.shared.dto.AccountDTO> result) {
				
				int row = 0;
              
                for (final com.rahul.BMS.shared.dto.AccountDTO account : result) {
                 
                	row = tableaccnt.getRowCount();
                    Button deleteaccnt;
                    deleteaccnt=new Button("X");
                                    
                  tableaccnt.setText(row, 0, ""+account.getAcctno());
                  tableaccnt.setText(row, 1, ""+account.isIsactive());
                  tableaccnt.setText(row, 2, account.getTypeofaccount());
                  tableaccnt.setText(row, 3, ""+account.getBalance());
                  tableaccnt.setText(row, 4, ""+account.getLasttransaction());
                  tableaccnt.setText(row, 5, ""+account.getTypeofholder());
                  tableaccnt.setText(row, 6, ""+account.getDateofopening());
                  tableaccnt.setWidget(row, 7, deleteaccnt);
                 
                  
                  deleteaccnt.addClickHandler(new ClickHandler() {
                	  
                	@Override
              		public void onClick(ClickEvent event) {
              				
              		Boolean r=Window.confirm("Do You wish to continue");
              				if(r==true){
              					dataServiceAsync.deleteAccount(account.getAcctno(), new AsyncCallback<Void>()
              					{
              					
              					@Override
              					public void onSuccess(Void result) {
              						Window.alert("User Deactivated");
              						viewaccnt();
               					}
              					
              					@Override
              					public void onFailure(Throwable caught) {
              						// TODO Auto-generated method stub
              				
              					}
              		    	});
              	    	}
                    					
                  	}
              	});    
                          
                  
                  
                  
                }
                
			}            
               
		    });
	
			
			
			
			
	}
}
