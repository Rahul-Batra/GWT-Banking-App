package com.ma.BMS.client.presenter;

import com.google.gwt.user.client.ui.RootPanel;
import com.ma.BMS.client.view.Welcome;

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
