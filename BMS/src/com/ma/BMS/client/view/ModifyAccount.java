package com.ma.BMS.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ModifyAccount extends Composite  {

	private static ModifyAccountUiBinder uiBinder = GWT
			.create(ModifyAccountUiBinder.class);

	interface ModifyAccountUiBinder extends UiBinder<Widget, ModifyAccount> {
	}

	public ModifyAccount() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	public TextBox modaccnt;
	
	@UiField
	public Button modaccntt;
	
	@UiField
	public Button resetacnt;
	
	

	@UiHandler("resetacnt")
	void onClickresetbtn(ClickEvent event) {
		resetacnt.setText("");
	}

}
