package com.stock.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stock.impl.InvoiceImpl;

import com.stock.model.Invoice;

@WebServlet("/userinvoice")
public class UserInvoiceServlet extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession();
		int userid=Integer.parseInt(session.getAttribute("userid").toString());
		InvoiceImpl pimpl =new InvoiceImpl();
		
		List<Invoice> invoice=pimpl.showUserInvoice(userid);
		session.setAttribute("userinvoiceview", invoice);
		
		RequestDispatcher rd= req.getRequestDispatcher("userInvoice.jsp");
		
		rd.forward(req, resp);

		
	}
	

	
	
	
}
