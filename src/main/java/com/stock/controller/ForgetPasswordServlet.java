package com.stock.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.impl.UserImpl;
import com.stock.model.User;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/forgetpassword")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ForgetPasswordServlet() {
        super();

    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pass=request.getParameter("pass");
		try{
		long mobnum=Long.parseLong(request.getParameter("mobnum"));
		
		User user=new User(pass,mobnum);
		UserImpl uimpl=new UserImpl();
		uimpl.updated(user);
		}catch ( NumberFormatException  e) {
			e.getMessage();
		}
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
