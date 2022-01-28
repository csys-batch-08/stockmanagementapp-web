package com.stock.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.impl.StockImpl;
import com.stock.model.Stock;
@WebServlet("/additemservlet")
public class AddItemServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String proname1=req.getParameter("proname1");
		
		
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		
		double price=Double.parseDouble(req.getParameter("amount"));
		
		
		Stock stock=new Stock(proname1,quantity,price);
		System.out.println(proname1+quantity+price);
		
		StockImpl sdao=new StockImpl();
		
		
		String productname=sdao.getProduct(proname1);
		
		if(productname==null) {
			
			sdao.insert(stock);	
			resp.sendRedirect("stockItemsadmin.jsp");
		}
		else {
			PrintWriter out=resp.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('This Product Already Added');");
			out.println("location='Additems.jsp';");
			out.println("</script>");
			
		}
		
		
		
		
	}
}
