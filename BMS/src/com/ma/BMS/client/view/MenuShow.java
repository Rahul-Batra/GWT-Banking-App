package com.ma.BMS.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;
import com.ma.BMS.client.AppController;

public class MenuShow extends Composite {

	private static MenuShowUiBinder uiBinder = GWT
			.create(MenuShowUiBinder.class);

	interface MenuShowUiBinder extends UiBinder<Widget, MenuShow> {
	}

	@UiField
	public MenuBar menuBar;
	
	@UiField
	public MenuItem btnHome;
	
	@UiField
	public MenuItem btnAbout;
	
	@UiField
	public MenuItem btnContact;
	
	@UiField
	public MenuItem btnSettings;
	
	@UiField
	public MenuItem btnLogout;
	
	@UiField
	public MenuItem btnAccount;
	
	
	
	
	public MenuShow(AppController application) {
		initWidget(uiBinder.createAndBindUi(this));
		
	}

	
	public MenuShow() {
		initWidget(uiBinder.createAndBindUi(this));
		btnHome.setStyleName("home");
		btnAbout.setStyleName("about");
		btnContact.setStyleName("contact");
		btnSettings.setStyleName("setting");
		btnAccount.setStyleName("account");
		btnLogout.setStyleName("logout");
		
		
		btnLogout.setScheduledCommand(new Command() {
		    public void execute() {
		    	//RootPanel.get("leftPanel").clear();
				//RootPanel.get("rightPanel").clear();
				//RootPanel.get("menu").clear();
				Window.Location.reload();
		    }
		});
	     
		
		
			
	}
	
	
		
	
	
}

	