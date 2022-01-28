package com.stock.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stock.impl.InvoiceImpl;
import com.stock.impl.PuruchaseImpl;
import com.stock.model.Invoice;
import com.stock.model.Purchase;

/**
 * Servlet implementation class InvoiceServlet
 */
@WebServlet("/invoice")
public class InvoiceServlet extends HttpServlet {

    
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	Date deliverydate=null;
        HttpSession session=request.getSession();
		System.out.println("invoice");
		int orderid=Integer.parseInt(session.getAttribute("orderid").toString());
		System.out.println(orderid);
	try {
			deliverydate = sdf.parse(request.getParameter("deliveryDate"));
			System.out.println(deliverydate);
			int userid = Integer.parseInt(session.getAttribute("userid").toString());
			
			
			Invoice invoice=new Invoice(orderid, deliverydate, userid);
			InvoiceImpl impl=new InvoiceImpl();
		    impl.insert(invoice);
		    
         List<Invoice> invoiceview=impl.showInvoice();
		session.setAttribute("admininvoice", invoiceview);
         
         response.sendRedirect("invoice.jsp");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
	}
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
}