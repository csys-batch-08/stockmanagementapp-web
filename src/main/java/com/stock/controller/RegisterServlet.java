package com.stock.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.exception.EmailException;
import com.stock.impl.UserImpl;
import com.stock.model.User;

/**
 * Servlet implementation class user
 */
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userName=request.getParameter("userName");
		String address=request.getParameter("address");
		String mail=request.getParameter("email");
		long mobNum=Long.parseLong(request.getParameter("mobileNumber"));
		String pass=request.getParameter("password");
		
		
		User us=new User(userName,mail,address,pass,mobNum);
		
		UserImpl userDao=new UserImpl();
		int i=userDao.insert(us);
		PrintWriter out=response.getWriter();
		if(i>0) {
			response.sendRedirect("index.jsp");
		}
		else {
			try {
			throw new EmailException();
			}
			catch (EmailException e) {
				
				out.println("<script type=\"text/javascript\">");
				out.println("alert('This Email Already Used');");
				out.println("location='register.jsp';");
				out.println("</script>");
				
			}
		}
		
		
		
		
	
	}

}
