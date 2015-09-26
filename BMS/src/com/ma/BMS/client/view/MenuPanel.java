package com.ma.BMS.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;

public class MenuPanel extends Composite {

	private static MenuPanelUiBinder uiBinder = GWT
			.create(MenuPanelUiBinder.class);

	interface MenuPanelUiBinder extends UiBinder<Widget, MenuPanel> {
	}

	
	@UiField
	public static TreeItem customer;

	@UiField
	public static TreeItem account;

	@UiField
	public static TreeItem SystemUser;

	@UiField
	public static InlineLabel report;

		
	@UiField
	public InlineLabel add;
	
	@UiField
	public static InlineLabel transaction;
	
	@UiField
	public static InlineLabel cusadd;

	@UiField
	public InlineLabel accadd;
	
	
	@UiField
	public InlineLabel viewsys;
	

	@UiField
	public InlineLabel modcus;
	
	
	@UiField
	public InlineLabel searchcus;
			
	@UiField
	public InlineLabel accsearch;
	
	@UiField
	public InlineLabel viewcust;
	
	@UiField
	public InlineLabel accview;
	
		
/*	public static MenuPanel instance = null;

	 public static MenuPanel getInstance() {
		 if (instance == null)
		 instance = new MenuPanel();
		 return instance;
		 }

*/
	
	
	public MenuPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		
		cusadd.getElement().setAttribute("id", "cnvisibleadd");
	
		add.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				
			}
		});
		

			
		
     }
}
