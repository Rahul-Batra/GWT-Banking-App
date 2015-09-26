package com.ma.BMS.client.view;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
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
import com.ma.BMS.client.DataService;
import com.ma.BMS.client.DataServiceAsync;

public class CustomerView extends Composite{

	private static CustomerViewUiBinder uiBinder = GWT
			.create(CustomerViewUiBinder.class);

	interface CustomerViewUiBinder extends UiBinder<Widget, CustomerView> {
	}

	public CustomerView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	
	@UiField
	public TextBox delcust;
	
	@UiField
	public Button deletecust;
	
	@UiField
	public Button resetcustt;
		
	@UiField
	public Button view;
	
	@UiField
	public FlexTable table;
		 
	
	@UiHandler("view")
	void onClickShowCustomer(ClickEvent event) {
		
		DataServiceAsync dataServiceAsync = GWT.create(DataService.class);
	     
		table.removeAllRows();
		
		table.setText(0, 0, "Name");
		table.setText(0, 1, "Password");
		table.setText(0, 2, "Email Id");
		table.setText(0, 3, "Mobile No");
		table.setText(0, 4, "Address");
		table.setText(0, 5, "Pan Number");
	     
		
				
		dataServiceAsync.showCustomers(new AsyncCallback<ArrayList<com.ma.BMS.shared.dto.CustomerDTO>>() {
					
			
			 @Override
 			public void onFailure(Throwable caught) {
 				// TODO Auto-generated method stub

 			}
			
			@Override
			public void onSuccess(ArrayList<com.ma.BMS.shared.dto.CustomerDTO> result) {
				
				int row = 0;
				table.setVisible(true);
                //loop the array list and user getters to add 
                //records to the table
                for (com.ma.BMS.shared.dto.CustomerDTO customer : result) {
                  row = table.getRowCount();
                  table.setText(row, 0, customer.getPholdername());
                  table.setText(row, 1, customer.getPasswd());
                  table.setText(row, 2, customer.getEmail());
                  table.setText(row, 3, ""+customer.getMobile());
                  table.setText(row, 4, customer.getAddress());
                  table.setText(row, 5, customer.getPan());
                }
                
			}            
               
	    });}
	
		@UiHandler("deletecust")
		void onClickDelCustomer(ClickEvent event) {
			
			DataServiceAsync dataServiceAsync = GWT.create(DataService.class);
			
			dataServiceAsync.deleteCustomr(delcust.getText(), new AsyncCallback<Void>()
					{
				
				@Override
				public void onSuccess(Void result) {
					Window.alert("Customer Deleted");
				}
				
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}
			});
		}

		@UiHandler("resetcustt")
		void onClickresetbtn(ClickEvent event) {
			delcust.setText("");
		}
	

	}
	

