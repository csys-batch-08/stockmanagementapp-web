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

import com.stock.impl.PuruchaseImpl;
import com.stock.model.Purchase;
import com.stock.model.Stock;
@WebServlet("/admin")
public class AdminPurchaseServletView extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		PuruchaseImpl pimpl =new PuruchaseImpl();
		List<Purchase> purchaseList=pimpl.viewpurchase();
		session.setAttribute("purchase", purchaseList);
		
		RequestDispatcher rd= req.getRequestDispatcher("AdminPurchaseCheck.jsp");
		
		rd.forward(req, resp);

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
