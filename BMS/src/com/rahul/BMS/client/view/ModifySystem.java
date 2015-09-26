package com.rahul.BMS.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.rahul.BMS.client.DataService;
import com.rahul.BMS.client.DataServiceAsync;
import com.rahul.BMS.shared.dto.SystemUserDTO;

public class ModifySystem extends DialogBox {

	private static ModifySystemUiBinder uiBinder = GWT
			.create(ModifySystemUiBinder.class);

	interface ModifySystemUiBinder extends UiBinder<Widget, ModifySystem> {
	}
	
	public ModifySystem() {
		setWidget(uiBinder.createAndBindUi(this));
		close.setText("X");
		close.setStyleName("clos");
	}

	
	
public static SystemUserDTO systemUser =  new SystemUserDTO();
	
	
	@UiField
	public Button submitbtn;
	
	@UiField
	public Button resetbtn;
	
	@UiField
	public TextBox modifyname;
	
	@UiField
	public ListBox modifyrole;
	
	@UiField
	public PasswordTextBox modifypswd;
	
	@UiField
	public Button close;
	
	@Override
	public void show() {
		setGlassEnabled(true);
		super.show();
	}
	
	
	
	@UiHandler("close")
	void onClickClose(ClickEvent event)
	{
		hide();
	}
	
	
	@UiHandler("submitbtn")
	void onClickModifySystemuser(ClickEvent event) {
				
		systemUser.setName(modifyname.getText());
		int i=modifyrole.getSelectedIndex();
	     
		systemUser.setRole(modifyrole.getItemText(i));
		systemUser.setPassword(modifypswd.getText());
				
		DataServiceAsync dataServiceAsync = GWT.create(DataService.class);
		
		
		dataServiceAsync.updateSystemUser(systemUser, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				Window.alert("Modification Done");
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@UiHandler("resetbtn")
	void onClickresetbtn(ClickEvent event) {
		modifyname.setText("");
		
		modifypswd.setText("");
		
	}
}
