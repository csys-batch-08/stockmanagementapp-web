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
 * Servlet implementation class WalletServlet
 */
@WebServlet("/wallet")
public class WalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WalletServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("pothi");
		Double amount=Double.parseDouble(request.getParameter("amount"));
		System.out.println(amount);
		String password=request.getParameter("password");
		System.out.println(password);
		User wallet= new User(amount,password);
		UserImpl userwallet=new UserImpl();
		userwallet.wallet(wallet);
		
		response.sendRedirect("walletrecharge.jsp");
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
