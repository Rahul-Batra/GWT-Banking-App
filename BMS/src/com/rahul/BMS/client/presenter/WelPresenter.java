package com.rahul.BMS.client.presenter;

import com.google.gwt.user.client.ui.RootPanel;
import com.rahul.BMS.client.view.Welcome;

public class WelPresenter extends Presenter {
	public Welcome welcome=null;
	
	public WelPresenter()
	{
		welcome=new Welcome();	
	}
	
	public void bindScreen(RootPanel welcomeShow) {
		
		welcomeShow.add(welcome);
	}

}
