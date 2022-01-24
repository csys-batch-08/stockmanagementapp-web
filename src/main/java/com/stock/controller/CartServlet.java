package com.stock.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stock.exception.InsufficientQuantityException;
import com.stock.impl.CartImpl;
import com.stock.impl.StockImpl;
import com.stock.model.Cart;
import com.stock.model.Stock;
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
//		SimpleDateFormat sdf=new SimpleDateFormat();
		System.out.println("pothi");
		int userid=Integer.parseInt(session.getAttribute("user id").toString());
		System.out.println("pothi2");
		int productid=Integer.parseInt (session.getAttribute("product id").toString());
		System.out.println("pothi3");
		
		int currentqty=Integer.parseInt (session.getAttribute("currentqty").toString());
		
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		System.out.println("pothi4");
		double price=Double.parseDouble(session.getAttribute("price").toString());
		System.out.println("pothi5");
		int days=Integer.parseInt(req.getParameter("date"));

//		Date date=sdf.parse(req.getParameter("date"));
		//System.out.printf(userid,productid,quantity,price,date);
		Cart cart=new Cart(userid,productid,quantity,price,days);
		
		CartImpl ci=new CartImpl();
		try {
			if(currentqty>quantity) {
				
				ci.insert(cart);
//				Stock stock = new Stock(productid,quantity);
				StockImpl impl = new StockImpl();
				impl.updateQuantity(productid, quantity);
				resp.sendRedirect("cart.jsp");
				}
				else {
					
					throw new InsufficientQuantityException();
					
					
				}
		}catch(InsufficientQuantityException e) {
			session.setAttribute("qtyerror",e.getMessage());
		
			resp.sendRedirect("product.jsp");
			
		}
		
		
	}
}
