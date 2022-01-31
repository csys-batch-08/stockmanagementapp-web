package com.stock.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.impl.StockImpl;
import com.stock.model.Stock;
@WebServlet("/searchitem")
public class SearchServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     
			String productName=req.getParameter("proname");
		StockImpl stock =new StockImpl();
		List<Stock> searchList=stock.serachProduct(productName);
		req.setAttribute("products", searchList);
		
		RequestDispatcher rd= req.getRequestDispatcher("stockItemsusers.jsp");
		
		rd.forward(req, resp);
		
	}

	
	
	
	
	
	
}
