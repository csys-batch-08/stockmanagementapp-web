package com.stock.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.impl.CartImpl;
import com.stock.model.Cart;
@WebServlet("/Admincart")
public class AdminCartServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        CartImpl cartImpl=new CartImpl();
		
		List<Cart> adminview=cartImpl.viewCart();
		req.setAttribute("admincart", adminview);
		
		RequestDispatcher rd=req.getRequestDispatcher("adminCart.jsp");
		
		rd.forward(req, resp);

	}
	
	
	
	
	
	
	
	
}
