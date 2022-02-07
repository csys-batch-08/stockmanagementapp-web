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
@WebServlet("/userpurchaselist")
public class UserPurchaseServletView extends HttpServlet {

	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		int userid=Integer.parseInt(session.getAttribute("userid").toString());
		PuruchaseImpl pimpl =new PuruchaseImpl();
		List<Purchase> purchaseList=pimpl.userPurchase(userid);
		
		session.setAttribute("userpurchase", purchaseList);
		
		RequestDispatcher rd= req.getRequestDispatcher("userPurchaseList.jsp");
		
		rd.forward(req, resp);

		
	}
	

	
	
	
}
