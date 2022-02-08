package com.stock.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stock.exception.InvalidUserException;
import com.stock.impl.UserImpl;
import com.stock.logger.Logger;
import com.stock.model.User;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          HttpSession session = request.getSession();
        String mail = request.getParameter("email");
		String pass = request.getParameter("password");
		User us = new User(mail, pass);
        UserImpl userDao = new UserImpl();
		User userDetails = userDao.validateUser(us);
		try {

			if (userDetails == null) {
				throw new InvalidUserException();
			}
			session.setAttribute("userid", userDetails.getUserId());
			session.setAttribute("walletamount", userDetails.getWallet());
			if (userDetails.getRole().equals("admin")) {

				response.sendRedirect("stockItemsadmin");

			} else {
				response.sendRedirect("stockItemsUser");
			}
		} catch (InvalidUserException e) {
			try {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invalid email id or password');");
			out.println("location='index.jsp';");
			out.println("</script>");
			}
			catch(IOException er) {
				Logger.printStackTrace(er);
				Logger.runTimeException(er.getMessage());
			}
		}catch(IOException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}

	}
}
