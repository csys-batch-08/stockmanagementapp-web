package com.stock.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stock.impl.InvoiceImpl;
import com.stock.model.Invoice;
@WebServlet("/invoiceview")
public class AdminInvoiceServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    HttpSession session=req.getSession();
		InvoiceImpl impl=new InvoiceImpl();
         List<Invoice> invoiceview=impl.showInvoice();
	    session.setAttribute("admininvoice", invoiceview);
     
          resp.sendRedirect("invoice.jsp");

	}
	
	
	
	
}