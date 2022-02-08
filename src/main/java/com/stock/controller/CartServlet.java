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

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)  {
		try {	
			
	    HttpSession session=req.getSession();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 Date dt=null;
		
			dt = sdf.parse(req.getParameter("date"));
		
		int userid=Integer.parseInt(session.getAttribute("userid").toString());
		
		int productid=Integer.parseInt (session.getAttribute("productid").toString());
	   int currentqty=Integer.parseInt (session.getAttribute("proqty").toString());
		
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		double price=Double.parseDouble(session.getAttribute("unitprice").toString());
       Cart cart=new Cart(userid,productid,quantity,price,dt);
		
		CartImpl ci=new CartImpl();
		
			if(currentqty <= quantity) {
				
				throw new InsufficientQuantityException();
				
				
			}
			ci.insert(cart);

			StockImpl impl = new StockImpl();
			impl.updateQuantity(productid, quantity);
			CartImpl cartImpl = new CartImpl();

			List<Cart> userview = cartImpl.allcart(userid);

			session.setAttribute("usercartview", userview);
			

			RequestDispatcher rd = req.getRequestDispatcher("userCart.jsp");
			
			rd.forward(req, resp);
		}catch(InsufficientQuantityException e) {
			PrintWriter out=null;
			try {
				out = resp.getWriter();
			} catch (IOException e1) {
			
				e1.printStackTrace();
			}
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Insufficient Quantity');");
			out.println("location='product.jsp';");
			out.println("</script>");

			
			
			
		} catch (ParseException | IOException e1) {
			e1.getMessage();
		} catch ( ServletException e) {
			
			e.getMessage();
		} 		
	}
}
