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
import com.rahul.BMS.shared.dto.SystemUserDTO;

public class SystemUserView extends Composite {
	
		
	private static SystemUserViewUiBinder uiBinder = GWT
			.create(SystemUserViewUiBinder.class);

	interface SystemUserViewUiBinder extends UiBinder<Widget, SystemUserView> {
	}

		
	DataServiceAsync dataServiceAsync = GWT.create(DataService.class);
		
	@UiField
	public FlexTable table;
	
	@UiField
	public Button refresh;
	
	@UiField
	public Button search;
	
	@UiField
	public TextBox searchsys;
	
		
	public SystemUserView() {
		initWidget(uiBinder.createAndBindUi(this));
	    refresh.setStyleName("refresh");
		
	}

	
	
	@UiHandler("search")
	public void onClickSearch(ClickEvent event)
	{
		EditDeleteSearch();
		
	}
	
	@UiHandler("refresh")
	public void onClickrefresh(ClickEvent event)
	{
		EditDelete();
	}
	
	
	
	
	public void EditDeleteSearch()
	{
		table.setBorderWidth(1);
		table.setCellPadding(3);
		table.setCellSpacing(3);
		
		table.removeAllRows();
		table.setText(0, 0, "Name");
		table.setText(0, 1, "Password");
		table.setText(0, 2, "Role");
		table.setText(0, 3, "IsActive");
		table.setText(0, 4, "LastActive");
		table.setText(0, 5, "DateOfCreation");
		table.setText(0, 6, "Edit");
		table.setText(0, 7, "Remove");
		
		
dataServiceAsync.searchSystemUser(searchsys.getText(),new AsyncCallback<ArrayList<SystemUserDTO>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("This user doesn't exists");
				
			}

			@Override
			public void onSuccess(ArrayList<SystemUserDTO> result) {
				int row = 0;
	               
	               //loop the array list and user getters to add 
	               //records to the table
	           for (final SystemUserDTO systemuser : result) {

	        	   row = table.getRowCount();
	                 table.setText(row, 0, systemuser.getName());
	                 table.setText(row, 1, systemuser.getPassword());
	                 table.setText(row, 2, systemuser.getRole());
	                 table.setText(row, 3, systemuser.getIsactive().toString());
	                 table.setText(row, 4, systemuser.getLastactive());
	                 table.setText(row, 5, systemuser.getDateofcreation());
	        	    
	                 Button modsys;
	                 Button delsys;
	                 modsys=new Button("->");
	                 delsys=new Button("X");
	                 table.setWidget(row, 6, modsys);
	                 table.setWidget(row, 7, delsys);
	        	     
	                 modsys.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
						
							ModifySystem.systemUser.setId(systemuser.getId());
						
							//RightPresenter.rightPanel.clear();
							ModifySystem ms=new ModifySystem();
							ms.center();
							ms.show();
													
							
						}
					});
	           
	            delsys.addClickHandler(new ClickHandler() {
	    				
	    		@Override
	    		public void onClick(ClickEvent event) {
	    				
	    		Boolean r=Window.confirm("Do You wish to continue");
	    				if(r==true){
	    	dataServiceAsync.deleteSystemUser(systemuser.getId(), new AsyncCallback<Void>()
	    					{
	    					
	    					@Override
	    					public void onSuccess(Void result) {
	    						Window.alert("User Deactivated");
	    						EditDelete();
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
	
	public void EditDelete()
        {
				
		table.setBorderWidth(2);
		table.setCellPadding(3);
		table.setCellSpacing(3);
		
		table.removeAllRows();
		
		table.setText(0, 0, "Name");
		table.setText(0, 1, "Password");
		table.setText(0, 2, "Role");
		table.setText(0, 3, "IsActive");
		table.setText(0, 4, "LastActive");
		table.setText(0, 5, "DateOfCreation");
		table.setText(0, 6, "Edit");
		table.setText(0, 7, "Remove");
		
		dataServiceAsync.showData(new AsyncCallback<ArrayList<SystemUserDTO>>() {
			
			
			 @Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void onSuccess(ArrayList<SystemUserDTO> result) {
				
				int row = 0;
               
               //loop the array list and user getters to add 
               //records to the table
           for (final SystemUserDTO systemuser : result) {
                 
        	   Boolean bol=systemuser.getIsactive();
        	   if(bol.booleanValue()==true)
        	   {
        	   row = table.getRowCount();
                 table.setText(row, 0, systemuser.getName());
                 table.setText(row, 1, systemuser.getPassword());
                 table.setText(row, 2, systemuser.getRole());
                 table.setText(row, 3, systemuser.getIsactive().toString());
                 table.setText(row, 4, systemuser.getLastactive());
                 table.setText(row, 5, systemuser.getDateofcreation());
        	    
                 Button modsys;
                 Button delsys;
                 modsys=new Button("->");
                 delsys=new Button("X");
                 table.setWidget(row, 6, modsys);
                 table.setWidget(row, 7, delsys);
        	     
                 modsys.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
					
						ModifySystem.systemUser.setId(systemuser.getId());
					
						//RightPresenter.rightPanel.clear();
						ModifySystem ms=new ModifySystem();
						ms.center();
						ms.show();
												
						
					}
				});
           
            delsys.addClickHandler(new ClickHandler() {
    				
    		@Override
    		public void onClick(ClickEvent event) {
    				
    		Boolean r=Window.confirm("Do You wish to continue");
    				if(r==true){
    	dataServiceAsync.deleteSystemUser(systemuser.getId(), new AsyncCallback<Void>()
    					{
    					
    					@Override
    					public void onSuccess(Void result) {
    						Window.alert("User Deactivated");
    						EditDelete();
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
          
    }            
              
 });
			
}
	
}
