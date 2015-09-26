package com.rahul.BMS.client.presenter;

import com.google.gwt.user.client.ui.RootPanel;
import com.rahul.BMS.client.view.Account;
import com.rahul.BMS.client.view.Customer;
import com.rahul.BMS.client.view.CustomerView;
import com.rahul.BMS.client.view.DeleteAccount;
import com.rahul.BMS.client.view.Deposit;
import com.rahul.BMS.client.view.ModifyAccount;
import com.rahul.BMS.client.view.ModifyCust;
import com.rahul.BMS.client.view.ModifySystem;
import com.rahul.BMS.client.view.ReportGenerate;
import com.rahul.BMS.client.view.SearchAccount;
import com.rahul.BMS.client.view.SearchCust;
import com.rahul.BMS.client.view.SystemUser;
import com.rahul.BMS.client.view.SystemUserView;
import com.rahul.BMS.client.view.ViewAccount;

public class RightPresenter extends Presenter{
	public CustomerView cust=null;
	public SystemUserView users =null;
	public SystemUser systemUser = null;
	public static RootPanel rightPanel;
	private RootPanel leftPanel;
	private Account account=null;
	private Customer customer=null;
	private ReportGenerate reportgenerate=null;
	public static ModifySystem modifysystem=null;
	private ModifyCust modifycust=null;
	private SearchCust searchcust=null;
	private ModifyAccount modaccount=null;
	private DeleteAccount delaccount=null;
	private SearchAccount searchaccount=null;
	private Deposit deposit=null;
	private ViewAccount viewaccount=null;
		
	public RightPresenter() {
		systemUser = new SystemUser();
		account =new Account();
		customer=new Customer();
		reportgenerate=new ReportGenerate();
		modifysystem=new ModifySystem();
		modifycust=new ModifyCust();
		searchcust=new SearchCust();
		modaccount=new ModifyAccount();
		delaccount=new DeleteAccount();
		searchaccount=new SearchAccount();
		users = new SystemUserView();
		cust=new CustomerView();
		deposit=new Deposit();
		viewaccount=new ViewAccount();
	}


 
    
 	
	public void bindScreen(RootPanel rightPanel) {
		this.rightPanel = rightPanel;
	}
	
	
		
	public void showSystemUserForm(){
		rightPanel.clear();
		rightPanel.add(systemUser);
	}
	
	public void showAccount(){
		rightPanel.clear();
		account.showall();
		rightPanel.add(account);
	}
	
	public void showCustomer(){
		rightPanel.clear();
		rightPanel.add(customer);
	}
	
	public void showreport(){
		rightPanel.clear();
		rightPanel.add(reportgenerate);
	}
	
	
	public void showmodifysystem(){
		
		rightPanel.clear();
		rightPanel.add(modifysystem);
	}
	
		
	public void showmodifycust(){
		rightPanel.clear();
		rightPanel.add(modifycust);
	}

	
	
	
	public void showsearchcust(){
		rightPanel.clear();
		rightPanel.add(searchcust);
	}

	public void showmodifyaccnt(){
		rightPanel.clear();
		rightPanel.add(modaccount);
		
	}
	
	public void showdeleteaccnt(){
		rightPanel.clear();
		rightPanel.add(delaccount);
	}
	
	
	public void showsearchaccnt(){
		rightPanel.clear();
		rightPanel.add(searchaccount);
	}


	public void showusers(){
		rightPanel.clear();
		users.EditDelete();
		rightPanel.add(users);
	}

	public void showcustomers(){
		rightPanel.clear();
		rightPanel.add(cust);
	}
	
	public void viewacct()
	{
		rightPanel.clear();
		rightPanel.add(users);
	}
	
 	public void depositwithdraw()
	 {
		 rightPanel.clear();
		 rightPanel.add(deposit);
	 }
 	
 	public void viewaccont(){
		rightPanel.clear();
		viewaccount.viewaccnt();
		rightPanel.add(viewaccount);
	}
/*	public void modify(){
		shw.getmodsys().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			showmodifysystem();	
			}
		});
	}*/

	
}
