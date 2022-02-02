package com.stock.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.impl.StockImpl;
import com.stock.model.Stock;

/**
 * Servlet implementation class DeleteItemServlet
 */
@WebServlet("/Deleteitemservlet")

public class DeleteItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productid=Integer.parseInt(request.getParameter("proid"));
		
		Stock stock=new Stock(productid);
		StockImpl sdao=new StockImpl();
		sdao.delete(stock);
		response.sendRedirect("stockItemsadmin.jsp");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
