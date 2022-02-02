package com.stock.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stock.impl.UserImpl;
import com.stock.model.Cart;
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
		
		System.out.println("pothi");
		
	HttpSession session=request.getSession();
	int userid=Integer.parseInt(session.getAttribute("userid").toString());
	    UserImpl userwallet=new UserImpl();
		
		Double amount=Double.parseDouble(request.getParameter("amount"));
		System.out.println(amount);
		String password=request.getParameter("password");
		System.out.println(password);
		User wallet= new User(amount,password);
		
		userwallet.wallet(wallet);
		User walletamount=userwallet.walletAmount(userid);
		Double amount1=walletamount.getWallet();
		
		session.setAttribute("walletamount", amount1);
		response.sendRedirect("walletrecharge.jsp");
	
		
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
