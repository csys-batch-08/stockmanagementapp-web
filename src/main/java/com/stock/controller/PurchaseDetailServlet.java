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

import com.stock.impl.CartImpl;
import com.stock.impl.StockImpl;
import com.stock.model.Stock;

@WebServlet("/purchase1")
public class PurchaseDetailServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CartImpl stock = new CartImpl();
		String cartId = req.getParameter("cartid");
		System.out.println(cartId);
		HttpSession session = req.getSession();
		int userid = Integer.parseInt(session.getAttribute("userid").toString());
        System.out.println(userid);
		int productId = Integer.parseInt(session.getAttribute("proid").toString());
		System.out.println(productId);
		int productqty = Integer.parseInt(session.getAttribute("proqty").toString());
		System.out.println(productqty);
		String prodname = (session.getAttribute("productname").toString());
		System.out.println(prodname);
		double price = Double.parseDouble(session.getAttribute("price").toString());
		System.out.println(price);
       
        
        req.setAttribute("productId", productId);
        req.setAttribute("userid", userid);
		req.setAttribute("productname", prodname);
		req.setAttribute("proqty", productqty);
		req.setAttribute("price", price);
        
		RequestDispatcher rd = req.getRequestDispatcher("purchase.jsp");

		rd.forward(req, resp);

	}

}
