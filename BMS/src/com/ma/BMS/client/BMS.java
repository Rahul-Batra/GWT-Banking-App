package com.ma.BMS.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.ma.BMS.client.view.LoginBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class BMS implements EntryPoint {
	private HandlerManager eventbus = new HandlerManager(null);
	private AppController application = new AppController(eventbus);

	public void onModuleLoad() {
		LoginBox loginBox = new LoginBox(application);
		loginBox.show();
		loginBox.center();
		
	
	}
}