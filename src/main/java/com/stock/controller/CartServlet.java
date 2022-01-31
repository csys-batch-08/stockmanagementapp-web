package com.stock.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
		PrintWriter out=resp.getWriter();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 Date dt=null;
		try {
			dt = sdf.parse(req.getParameter("date"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int userid=Integer.parseInt(session.getAttribute("userid").toString());
		
		int productid=Integer.parseInt (session.getAttribute("productid").toString());
	   int currentqty=Integer.parseInt (session.getAttribute("proqty").toString());
		
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		double price=Double.parseDouble(session.getAttribute("unitprice").toString());
		
//		int days=Integer.parseInt(req.getParameter("date"));

		Cart cart=new Cart(userid,productid,quantity,price,dt);
		
		CartImpl ci=new CartImpl();
		try {
			if(currentqty>quantity) {
				
				ci.insert(cart);

				StockImpl impl = new StockImpl();
				impl.updateQuantity(productid, quantity);
				CartImpl cartImpl = new CartImpl();

				List<Cart> userview = cartImpl.allcart(userid);
			
				session.setAttribute("usercartview", userview);
				
			
				RequestDispatcher rd = req.getRequestDispatcher("usercart.jsp");
				
				rd.forward(req, resp);
				
				}
				else {
					
					throw new InsufficientQuantityException();
					
					
				}
		}catch(InsufficientQuantityException e) {

			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Insufficient Quantity');");
			out.println("location='product.jsp';");
			out.println("</script>");

			
			
			
		}
		
		
	}
}
