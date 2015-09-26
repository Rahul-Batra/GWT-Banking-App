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

public class SearchCust extends Composite {

	private static SearchCustUiBinder uiBinder = GWT
			.create(SearchCustUiBinder.class);

	interface SearchCustUiBinder extends UiBinder<Widget, SearchCust> {
	}

	public SearchCust() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	public TextBox searchcust;
	
	@UiField
	public Button searchcustt;
	
	@UiField
	public Button resetcustt;
	
	@UiField
	public FlexTable table;
	
	@UiHandler("searchcustt")
	void onClickShowCustomer(ClickEvent event) {
		
		DataServiceAsync dataServiceAsync = GWT.create(DataService.class);
		
		table.removeAllRows();
		
		table.setText(0, 0, "Name");
		table.setText(0, 1, "Password");
		table.setText(0, 2, "EmailId");
		table.setText(0, 3, "MobileNo");
		table.setText(0, 4, "Address");
		table.setText(0, 5, "PanNumber");
	     
		dataServiceAsync.searchCustomer(searchcust.getText(),new AsyncCallback<ArrayList<com.ma.BMS.shared.dto.CustomerDTO>>() {
					
			
			 @Override
 			public void onFailure(Throwable caught) {
 				
				 Window.alert("This customer doesn't exists");
				 
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

		       
		    });
	}

	@UiHandler("resetcustt")
	void onClickresetbtn(ClickEvent event) {
		searchcust.setText("");
		 table.removeAllRows();
	}

}
