package com.stock.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/purchase1")
public class PurchaseDetailServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
		HttpSession session = req.getSession();
		int userid = Integer.parseInt(session.getAttribute("userid").toString());
        
		int productId = Integer.parseInt(session.getAttribute("proid").toString());
		
		int productqty = Integer.parseInt(session.getAttribute("proqty").toString());
		
		String prodname = (session.getAttribute("productname").toString());
		
		double price = Double.parseDouble(session.getAttribute("price").toString());
		
       
        
        req.setAttribute("productId", productId);
        req.setAttribute("userid", userid);
		req.setAttribute("productname", prodname);
		req.setAttribute("proqty", productqty);
		req.setAttribute("price", price);
        
		RequestDispatcher rd = req.getRequestDispatcher("purchase.jsp");

		rd.forward(req, resp);

	}

}
