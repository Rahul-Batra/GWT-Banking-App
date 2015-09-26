package com.ma.BMS.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.ma.BMS.client.view.MenuPanel;

public class LeftPresenter extends Presenter {

	private MenuPanel menuPanel=null;
	private RightPresenter rightPresenter;
	
	
	public LeftPresenter() {
		
		menuPanel = new MenuPanel();
		
}
	
	public void bindScreen(RootPanel leftPanel) {
		leftPanel.add(menuPanel);
		
		
		menuPanel.add.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				rightPresenter.showSystemUserForm();
			}
		});
		
	menuPanel.cusadd.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				rightPresenter.showCustomer();
			}
		});
	
	menuPanel.accadd.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				rightPresenter.showAccount();
			}
		});
	
	
	menuPanel.accview.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			rightPresenter.viewaccont();
			
			
		}
	});
	
/*	
menuPanel.modsys.addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			rightPresenter.showmodifysystem();
		}
	});
	
menuPanel.delsys.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		rightPresenter.showdelsystem();
	}
});
*/
	
	

menuPanel.modcus.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		rightPresenter.showmodifycust();
	}
});



menuPanel.searchcus.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		rightPresenter.showsearchcust();
	}
});



menuPanel.accsearch.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		rightPresenter.showsearchaccnt();
	}
});



menuPanel.viewsys.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		rightPresenter.showusers();
	}
});


menuPanel.viewcust.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		rightPresenter.showcustomers();
	}
});



menuPanel.transaction.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		rightPresenter.depositwithdraw();
		
	}
});

menuPanel.report.addClickHandler(new ClickHandler() {
	
	@Override
	public void onClick(ClickEvent event) {
		rightPresenter.showreport();
	}
});

	}
		
	public void bindRightPresenter(RightPresenter rightPresenter){
		this.rightPresenter = rightPresenter;
	}
			
}
