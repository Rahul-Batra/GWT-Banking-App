package com.ma.BMS.server;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.ma.BMS.server.dao.AccountCustomerDAO;

	public class GetPdf extends HttpServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	 public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			String id = request.getParameter("id");
			ArrayList<String> user=new ArrayList<String>();
			response.setContentType("application/pdf");
			Document document = new Document();
			
			user=AccountCustomerDAO.accntcust(Long.parseLong(id));
			
			try {
				PdfWriter.getInstance(document, response.getOutputStream());
				document.open();
				 
				PdfPTable table = new PdfPTable(2);
				PdfPCell cell;
				Font Verdana = FontFactory.getFont("Verdana", 24F, Font.NORMAL, BaseColor.BLACK);
				cell = new PdfPCell( new Phrase("REPORT",Verdana) ) ;			
				cell.setColspan(2);
				cell.setFixedHeight(45);
			
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(cell);
				table.addCell("Account number:");
				table.addCell(user.get(0));
				table.addCell("Type of Account:");
				table.addCell(user.get(1));
				table.addCell("Type of Account Holders:");
				table.addCell(user.get(2));
				table.addCell("Primary Customer Name :");
				table.addCell(user.get(3));
				table.addCell("Address :");
				table.addCell(user.get(4));
				table.addCell("Mobile No. :");
				table.addCell(user.get(5));
				table.addCell("Email Id :");
				table.addCell(user.get(6));
				table.addCell("Pan Number :");
				table.addCell(user.get(7));
				table.addCell("Secondary Customer names:");
				int usersize=user.size();
				if(usersize>8)
				{
				table.addCell(user.get(8));
					if(usersize>9)
					{
				table.addCell("");
				table.addCell(user.get(9));
						if(usersize>10)
						{
							table.addCell("");
							table.addCell(user.get(10));
						}
					}
				}
			
				document.add(table);
				
				
				document.close();
						} catch (DocumentException e) {
				e.printStackTrace();
			}
		}

	}


