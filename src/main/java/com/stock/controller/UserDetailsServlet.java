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

import com.stock.impl.UserImpl;
import com.stock.model.User;
@WebServlet("/userview")
public class UserDetailsServlet extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=req.getSession();
		int userid=Integer.parseInt(session.getAttribute("userid").toString());
		UserImpl userImpl =new UserImpl();
		List<User> userDetails=userImpl.userview(userid);
		session.setAttribute("userDetail", userDetails);
        RequestDispatcher rd= req.getRequestDispatcher("userview.jsp");
		
		rd.forward(req, resp);
	
	}
	
	
	
	
}