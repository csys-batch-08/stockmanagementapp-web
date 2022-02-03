package com.stock.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stock.exception.InsufficientBalances;
import com.stock.exception.InsufficientQuantityException;
import com.stock.impl.CartImpl;
import com.stock.impl.PuruchaseImpl;
import com.stock.model.Cart;
import com.stock.model.Purchase;

/**
 * Servlet implementation class PurchaseList
 */
@WebServlet("/purchase")
public class PurchaseListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchaseListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		int productid = Integer.parseInt(session.getAttribute("proid").toString());

		int userid = Integer.parseInt(session.getAttribute("userid").toString());

		String prodname = (session.getAttribute("productname").toString());

		int quantity = Integer.parseInt(session.getAttribute("proqty").toString());

		double totalprice = Double.parseDouble(session.getAttribute("price").toString());

		Purchase purchase = new Purchase(productid, userid, prodname, quantity, totalprice);

		PuruchaseImpl pimpl = new PuruchaseImpl();
		int i = pimpl.insert(purchase);
		try {
			if (i == 5) {

				throw new InsufficientBalances();

			}

			else {
				Cart cart = new Cart(productid, userid);
				CartImpl cimpl = new CartImpl();
				cimpl.delete(cart);

				List<Purchase> userpurchase = pimpl.userPurchase(userid);

				session.setAttribute("userpurchase", userpurchase);

			}

			response.sendRedirect("userpurchaselist.jsp");

		} catch (InsufficientBalances e) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('InsufficientBalances');");
			out.println("location='walletrecharge.jsp';");
			out.println("</script>");

		}

	}
}
