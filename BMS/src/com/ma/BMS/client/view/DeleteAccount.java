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

public class DeleteAccount extends Composite  {

	private static DeleteAccountUiBinder uiBinder = GWT
			.create(DeleteAccountUiBinder.class);

	interface DeleteAccountUiBinder extends UiBinder<Widget, DeleteAccount> {
	}

	public DeleteAccount() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	public TextBox delaccnt;
	
	@UiField
	public Button delaccntt;
	
	@UiField
	public Button resetacnt;
	
	

	@UiHandler("resetacnt")
	void onClickresetbtn(ClickEvent event) {
		resetacnt.setText("");
	}

}
