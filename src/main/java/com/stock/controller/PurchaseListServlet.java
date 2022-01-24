package com.stock.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stock.exception.InsufficientBalances;
import com.stock.exception.InsufficientQuantityException;
import com.stock.impl.CartImpl;
import com.stock.impl.PuruchaseImpl;
import com.stock.model.Cart;
import com.stock.model.Purchase;

/**
 * Servlet implementation class PurchaseList
 */
@WebServlet("/purchase")
public class PurchaseListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchaseListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession();

		System.out.println("pothi");
		int productid = Integer.parseInt(session.getAttribute("product id").toString());
		System.out.println(productid);

		int userid = Integer.parseInt(session.getAttribute("user id").toString());
		System.out.println(userid);

		String prodname = (session.getAttribute("productname").toString());
		System.out.println(prodname);
		int quantity = Integer.parseInt(session.getAttribute("quantity").toString());
		System.out.println(quantity);
		double totalprice = Double.parseDouble(session.getAttribute("price").toString());
		System.out.println(totalprice);
		Purchase purchase = new Purchase(productid, userid, prodname, quantity, totalprice);

		PuruchaseImpl pimpl = new PuruchaseImpl();
		int i=pimpl.insert(purchase);
		try {
		if(i==5) {
			
			throw new InsufficientBalances();
		
		}
		
		else {
			Cart cart = new Cart(productid, userid);
			CartImpl cimpl = new CartImpl();
			cimpl.delete(cart);
		}

		response.sendRedirect("userpurchaselist.jsp");

	}catch( InsufficientBalances e) {
		
		session.setAttribute("low bal",e.getMessage());
		
		response.sendRedirect("purchase.jsp");
	
	}

	

	}
}
