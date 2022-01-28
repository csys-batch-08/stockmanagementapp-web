package com.stock.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.impl.StockImpl;
import com.stock.model.Stock;


@WebServlet("/stockItemsadmin")
public class StockViewServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		StockImpl stock =new StockImpl();
		List<Stock> productsList=stock.showProducts();
		req.setAttribute("products", productsList);
		
		RequestDispatcher rd= req.getRequestDispatcher("stockItemsadmin.jsp");
		
		rd.forward(req, resp);
		
	}

	
	
	
}