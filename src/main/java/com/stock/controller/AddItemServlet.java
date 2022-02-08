package com.stock.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stock.impl.StockImpl;
import com.stock.model.Stock;

@WebServlet("/additemservlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String proname1 = req.getParameter("proname1");

			int quantity = Integer.parseInt(req.getParameter("quantity"));

			double price = Double.parseDouble(req.getParameter("amount"));

			Stock stock = new Stock(proname1, quantity, price);

			StockImpl sdao = new StockImpl();

			String productname = sdao.getProduct(proname1);

			if (productname == null) {

				sdao.insert(stock);

				resp.sendRedirect("stockItemsAdmin.jsp");
			} else {
				PrintWriter out = resp.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('This Product Already Added');");
				out.println("location='addItem.jsp';");
				out.println("</script>");

			}

		} catch (IOException | NumberFormatException e ) {
			e.printStackTrace();
		}
	}
}
