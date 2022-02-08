package com.stock.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stock.impl.UserImpl;

import com.stock.model.User;


@WebServlet("/wallet")
public class WalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public WalletServlet() {
        super();

    }


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	HttpSession session=request.getSession();
	try {
	int userid=Integer.parseInt(session.getAttribute("userid").toString());
	    UserImpl userwallet=new UserImpl();
		
		Double amount=Double.parseDouble(request.getParameter("amount"));
		
		String password=request.getParameter("password");
		
		User wallet= new User(amount,password);
		
		userwallet.wallet(wallet);
		User walletamount=userwallet.walletAmount(userid);
		Double amount1=walletamount.getWallet();
		
		session.setAttribute("walletamount", amount1);
		response.sendRedirect("walletRecharge.jsp");
	}
	catch (IOException | NumberFormatException e ) {
		e.printStackTrace();
	}	
		
		
	}

	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
