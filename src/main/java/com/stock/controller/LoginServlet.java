package com.stock.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stock.exception.InvalidUserException;
import com.stock.impl.UserImpl;
import com.stock.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		
		String mail = request.getParameter("email");
		String pass = request.getParameter("password");
		
		User us = new User(mail, pass);

		UserImpl userDao = new UserImpl();
		User userDetails = userDao.validateUser(us);
		try {

			if (userDetails != null) {
				session.setAttribute("userid", userDetails.getUserId());
				session.setAttribute("walletamount", userDetails.getWallet());
				if (userDetails.getRole().equals("admin")) {

					response.sendRedirect("stockItemsadmin");

				} else {
					response.sendRedirect("stockItemsUser");
				}
			} else {
				throw new InvalidUserException();
			}
		} catch (InvalidUserException e) {

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invalid email id or password');");
			out.println("location='index.jsp';");
			out.println("</script>");

		}

	}
}
