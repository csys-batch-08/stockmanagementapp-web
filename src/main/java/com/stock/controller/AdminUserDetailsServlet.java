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
@WebServlet("/adminuserview")
public class AdminUserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session=req.getSession();
		
		UserImpl userImpl =new UserImpl();
		List<User> adminuserDetails=userImpl.showuser();
		session.setAttribute("adminUserDetail", adminuserDetails);
        RequestDispatcher rd= req.getRequestDispatcher("adminUserView.jsp");
		
		rd.forward(req, resp);
	
	}

	
	
	
	
	
	
	
	
}
