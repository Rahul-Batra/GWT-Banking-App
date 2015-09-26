package com.rahul.BMS.client;



import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;
import com.rahul.BMS.client.presenter.LeftPresenter;
import com.rahul.BMS.client.presenter.MenuPresenter;
import com.rahul.BMS.client.presenter.RightPresenter;
import com.rahul.BMS.client.presenter.WelPresenter;

public class AppController {
	
   
   
	public HandlerManager eventbus;
	private LeftPresenter leftPresenter;
	private RightPresenter rightPresenter;
    private MenuPresenter menuPresenter; 
	private WelPresenter welpresenter;
    
	private RootPanel leftPanel = null;
	private RootPanel rightPanel = null;
	private RootPanel menuShow = null;
	private RootPanel welShow=null;
	
	//private RootPanel mainPanel=null;
	

	public AppController(HandlerManager eventbus) {
		this.eventbus = eventbus;
		this.leftPresenter = new LeftPresenter();
		this.rightPresenter = new RightPresenter();
		this.menuPresenter= new MenuPresenter();
		this.welpresenter=new WelPresenter();
		bindEvent();
		
	}

	private void bindEvent() {

	}

	public void go(RootPanel rootPanel) {
		leftPanel = RootPanel.get("leftPanel");
		rightPanel = RootPanel.get("rightPanel");
		menuShow = RootPanel.get("menu");
		welShow = RootPanel.get("welcome");
		
		
		this.leftPresenter.bindRightPresenter(rightPresenter);
		this.leftPresenter.bindScreen(leftPanel);
		this.rightPresenter.bindScreen(rightPanel);
		this.menuPresenter.bindScreen(menuShow);
		this.welpresenter.bindScreen(welShow);
	}
}
