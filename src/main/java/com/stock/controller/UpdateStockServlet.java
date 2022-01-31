package com.stock.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stock.impl.StockImpl;
import com.stock.model.Stock;

/**
 * Servlet implementation class UpdateStockServlet
 */
@WebServlet("/updateitemservlet")

public class UpdateStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		String proname=request.getParameter("proname");
		System.out.println("pothi2");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		System.out.println("pothi3");
//		double unit_price=0;
		System.out.println(quantity);
		System.out.println(proname);
		Stock stock=new Stock(proname,quantity);
		StockImpl sdao=new StockImpl();
		sdao.Adminupdated(stock);
	
		List<Stock> productsList=sdao.showProducts();
		session.setAttribute("products", productsList);
		response.sendRedirect("stockItemsadmin.jsp");
	}



}
