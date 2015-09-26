package com.ma.BMS.client.presenter;

import com.google.gwt.user.client.ui.RootPanel;
import com.ma.BMS.client.view.MenuShow;

public class MenuPresenter extends Presenter {
	
	public MenuShow menus;
	
	
	public MenuPresenter() {
				
		menus =new MenuShow();
		
}

	public void bindScreen(RootPanel menuShow) {
			menuShow.add(menus);
			
		}
	
	

}
