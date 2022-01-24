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
 * Servlet implementation class UpdateStockServlet
 */
@WebServlet("/updateitemservlet")

public class UpdateStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
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
		response.sendRedirect("stockItemsadmin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
