package com.rahul.BMS.client.view;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.rahul.BMS.client.DataService;
import com.rahul.BMS.client.DataServiceAsync;

public class ReportGenerate extends Composite {

	private static ReportGenerateUiBinder uiBinder = GWT
			.create(ReportGenerateUiBinder.class);

	interface ReportGenerateUiBinder extends UiBinder<Widget, ReportGenerate> {
	}

	public ReportGenerate() {
		
		initWidget(uiBinder.createAndBindUi(this));
		reporttble.setWidget(0,0,acclabel);
		reporttble.setWidget(0,1,acc);
		reporttble.setWidget(0,2,submitbttn);
		reporttble.setWidget(1,1,rprt);
		reporttble.setWidget(2,0,actno);
		reporttble.setWidget(2,1,acntnolbl);
		reporttble.setWidget(3,0,actttype);
		reporttble.setWidget(3,1,actttypelbl);
		reporttble.setWidget(4,0,actttypehldr);
		reporttble.setWidget(4,1,actttypehldrlbl);
		reporttble.setWidget(5,0,pname);
		reporttble.setWidget(5,1,pnamelbl);
		reporttble.setWidget(6,0,pdetails);
		reporttble.setWidget(7,0,padrr);
		reporttble.setWidget(7,1,padrrlbl);
		reporttble.setWidget(8,0,pmobile);
		reporttble.setWidget(8,1,pmobilelbl);
		reporttble.setWidget(9,0,pemail);
		reporttble.setWidget(9,1,pemaillbl);
		reporttble.setWidget(10,0,ppan);
		reporttble.setWidget(10,1,ppanlbl);
		reporttble.setWidget(11,0,sname1);
		reporttble.setWidget(11,1,snamelbl1);
		reporttble.setWidget(12,1,snamelbl2);
		reporttble.setWidget(13,1,snamelbl3);
	}
	 
	@UiField
	public TextBox acc;
	
	@UiField
	public Label acclabel;
	
	
	@UiField
	public Button submitbttn;
	
	
	@UiField
	public Button downloadbttn;
	
	@UiField
	public Button printbttn;
	
	@UiField
	public Button resetbttn;
	
		
	@UiField
	public Label rprt;
	
	@UiField
	public Label actno;
	
	
	@UiField
	public Label acntnolbl;
	
	@UiField
	public Label actttype;
	
	@UiField
	public Label actttypelbl;
	
	@UiField
	public Label actttypehldr;
	
	@UiField
	public Label actttypehldrlbl;
	
	@UiField
	public Label pname;
	
	@UiField
	public Label pnamelbl;
	
	
	@UiField
	public Label pdetails;
	
	@UiField
	public Label padrr;
	
	@UiField
	public Label padrrlbl;
	
	@UiField
	public Label pmobile;
	
	@UiField
	public Label pmobilelbl;
	
	@UiField
	public Label pemail;
	
	@UiField
	public Label pemaillbl;
	
	@UiField
	public Label ppan;
	
	@UiField
	public Label ppanlbl;
	
	@UiField
	public Label sname1;
	@UiField
	public Label snamelbl1;
	@UiField
	public Label snamelbl2;
	@UiField
	public Label snamelbl3;
	
	
	@UiField
	public FlexTable reporttble;
	
	@UiHandler("submitbttn")
	void onClickGenerate(ClickEvent event)
	{
		DataServiceAsync dataServiceAsync = GWT.create(DataService.class);
		dataServiceAsync.reportgenrte(Long.parseLong(acc.getText()),new AsyncCallback<ArrayList<String>>() 
				{
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
			
			public void onSuccess(ArrayList<String> result) {
				if(result.isEmpty())
				{
				Window.alert("No data found for the given account");
				
				}   
				else{
					    acntnolbl.setText(result.get(0));
						actttypelbl.setText(result.get(1));
						actttypehldrlbl.setText(result.get(2));
						pnamelbl.setText(result.get(3));
						pemaillbl.setText(result.get(4));
		                pmobilelbl.setText(result.get(5));
		                padrrlbl.setText(result.get(6));
		                ppanlbl.setText(result.get(7));
		                snamelbl1.setText(result.get(8));
		                snamelbl2.setText(result.get(9));
		                snamelbl3.setText(result.get(10));
					}
				
			}
	});
	}
	
		
		@UiHandler("downloadbttn")
		void onClickdnldbttn(ClickEvent event) {
			String url="/BMS/GetPdf?id="+acc.getText();
			Window.open(url, "", "");
			}
		
		@UiHandler("printbttn")
		void onClickprintbttn(ClickEvent event) {
			Window.print(); 
			}
	
		
	
	@UiHandler("resetbttn")
	void onClickresetbttn(ClickEvent event) {
	acc.setText("");
	acntnolbl.setText("");
	actttypelbl.setText("");
	actttypehldrlbl.setText("");
	pnamelbl.setText("");
	padrrlbl.setText("");
	pmobilelbl.setText("");
	pemaillbl.setText("");
	ppanlbl.setText("");
	snamelbl1.setText("");
	snamelbl2.setText("");
	snamelbl3.setText("");
	}
}
