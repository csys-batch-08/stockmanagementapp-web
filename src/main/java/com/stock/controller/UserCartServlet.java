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
import com.stock.model.Cart;
@WebServlet("/usercart")
public class UserCartServlet extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= req.getSession();
        CartImpl cartImpl=new CartImpl();
    	int userid=Integer.parseInt(session.getAttribute("userid").toString());
    	
		List<Cart> usercartview=cartImpl.viewcartuser(userid);
				
		session.setAttribute("userview", usercartview);
		
		RequestDispatcher rd=req.getRequestDispatcher("userCartView.jsp");
		
		rd.forward(req, resp);

}
}