package com.stock.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stock.impl.InvoiceImpl;
import com.stock.model.Invoice;

/**
 * Servlet implementation class InvoiceServlet
 */
@WebServlet("/invoice")
public class InvoiceServlet extends HttpServlet {

    
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		System.out.println("invoice");
		int orderid=Integer.parseInt(session.getAttribute("orderid").toString());
		System.out.println(orderid);
		System.out.println("invoice orderid");
		int deliverydate=Integer.parseInt(request.getParameter("deliveryDate"));
		System.out.println(deliverydate);
		System.out.println("invoice date");
	
		int userid = Integer.parseInt(session.getAttribute("users_id").toString());
		
	
		Invoice invoice=new Invoice(orderid,deliverydate,userid);	
		InvoiceImpl impl=new InvoiceImpl();
	impl.insert(invoice);
		
		response.sendRedirect("invoice.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
}