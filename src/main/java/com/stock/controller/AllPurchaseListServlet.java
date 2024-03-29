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
@WebServlet("/Allpurchaselist")
public class AllPurchaseListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		PuruchaseImpl pimpl =new PuruchaseImpl();
		List<Purchase> purchaseList=pimpl.viewpurchase();
		session.setAttribute("purchase", purchaseList);
		
		RequestDispatcher rd= req.getRequestDispatcher("purchaseList.jsp");
		
		rd.forward(req, resp);
	
	
	}
}
