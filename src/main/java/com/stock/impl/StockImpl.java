package com.stock.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stock.dao.StockDao;
import com.stock.model.Stock;
import com.stock.util.ConnectionUtil;

public class StockImpl implements StockDao {

	public List<Stock> showProducts() {
		List<Stock> productsList = new ArrayList<Stock>();

		String prod = "select product_id,product_name,product_qty,price from stock ORDER BY product_id";
		Connection con=null;
		ResultSet rs = null;
		Statement stmt=null;
		try {
			con = ConnectionUtil.gbConnection();
			 stmt = con.createStatement();
			rs = stmt.executeQuery(prod);
			while (rs.next()) {

				Stock stock = new Stock(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("product_qty"), rs.getDouble("price"));
				productsList.add(stock);
				
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}finally {
			
			try {if(stmt!=null ) {
			       stmt.close();}
			if(rs!=null) {
				
				rs.close();
			}
			if(con!=null) {	
					con.close();
				}	}
					
				 catch (SQLException e) {
					
					e.printStackTrace();
				}
			}


		return productsList;
	}

	public List<Stock> serachProduct(String proName) {
		List<Stock> searchproducts = new ArrayList<Stock>();
		String pro = "select product_id,product_name,product_qty,price from stock where lower(product_name ) like  ?  ";
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		Connection con=null;
		try {

			 con = ConnectionUtil.gbConnection();

			 pstmt = con.prepareStatement(pro);

			pstmt.setString(1, proName + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {

				Stock stock = new Stock(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("product_qty"), rs.getDouble("price"));
				searchproducts.add(stock);
				
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			
			try {if(pstmt!=null ) {
			       pstmt.close();}
			if(rs!=null) {
				
				rs.close();
			}
			if(con!=null) {	
					con.close();
				}	}
					
				 catch (SQLException e) {
					
					e.printStackTrace();
				}
			}


		return searchproducts;
	}

	public String getProduct(String productName) {

		String check = "select product_name from stock where product_name=? ";

		Connection con = null;
		String proname = null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;

		try {
			con = ConnectionUtil.gbConnection();
		 pstmt = con.prepareStatement(check);

			pstmt.setString(1, productName);

		 rs = pstmt.executeQuery();

			if (rs.next()) {

				proname = rs.getString("product_name");
				
			}

		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {if(pstmt!=null ) {
			       pstmt.close();}
			if(rs!=null) {
				
				rs.close();
			}
			if(con!=null) {	
					con.close();
				}	}
					
				 catch (SQLException e) {
					
					e.printStackTrace();
				}
			}


		return proname;

	}

	public void insert(Stock pro) {

		String insertQuery = "insert into stock (product_name,product_qty ,price) values (?,?,?)";

		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			con = ConnectionUtil.gbConnection();
			 pstmt = con.prepareStatement(insertQuery);
		

			pstmt.setString(1, pro.getProductName());
			pstmt.setInt(2, pro.getQuantity());
			pstmt.setDouble(3, pro.getUnitPrice());
			int i = pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			
			try {if(pstmt!=null ) {
			       pstmt.close();}
			
			if(con!=null) {	
					con.close();
				}	}
					
				 catch (SQLException e) {
					
					e.printStackTrace();
				}
			}


	}

	public void Adminupdated(Stock pro1) {

		String updateQuery = "update stock set product_qty = product_qty + ? where product_name=?";
		PreparedStatement pstmt=null;
		Connection con=null;
		try {
			con = ConnectionUtil.gbConnection();
		   pstmt = con.prepareStatement(updateQuery);

			pstmt.setInt(1, pro1.getQuantity());
			pstmt.setString(2, pro1.getProductName());
			int i = pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			
			try {if(pstmt!=null ) {
			       pstmt.close();}
			
			if(con!=null) {	
					con.close();
				}	}
					
				 catch (SQLException e) {
					
					e.printStackTrace();
				}
			}

	}

	public void updateQuantity(int proid, int qty) {

		String updateQuery = "update stock set product_qty = product_qty - ? where product_id=?";
		PreparedStatement pstmt=null;
		Connection con=null;
		try {
			con = ConnectionUtil.gbConnection();
			 pstmt = con.prepareStatement(updateQuery);

			pstmt.setInt(1, qty);
			pstmt.setInt(2, proid);
			int i = pstmt.executeUpdate();
		
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			
			try {if(pstmt!=null ) {
			       pstmt.close();}
			
			if(con!=null) {	
					con.close();
				}	}
					
				 catch (SQLException e) {
					
					e.printStackTrace();
				}
			}

	}

	public void delete(Stock pro2) {

		String deleteQuery = "delete from stock where product_id=?";
		PreparedStatement pstmt=null;
		Connection con=null;
		try {
			con = ConnectionUtil.gbConnection();
			 pstmt = con.prepareStatement(deleteQuery);

			pstmt.setInt(1, pro2.getProductId());
			int i = pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {if(pstmt!=null ) {
			       pstmt.close();}
			
			if(con!=null) {	
					con.close();
				}	}
					
				 catch (SQLException e) {
					
					e.printStackTrace();
				}
			}

	}

	public List<Stock> validateProduct(String proName) {
		List<Stock> products = new ArrayList<Stock>();
		String validdateQuery = "select product_id,product_name,product_qty,price from stock where product_name=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			 con = ConnectionUtil.gbConnection();
			 pstmt = con.prepareStatement(validdateQuery);
			pstmt.setString(1, proName);
			 rs = pstmt.executeQuery();

			while (rs.next()) {

				Stock stock = new Stock(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("product_qty"), rs.getDouble("price"));
				products.add(stock);
				
					}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {if(pstmt!=null ) {
			       pstmt.close();}
			if(rs!=null) {
				
				rs.close();
			}
			if(con!=null) {	
					con.close();
				}	}
					
				 catch (SQLException e) {
					
					e.printStackTrace();
				}
			}

		return products;

	}

	public Stock validateProductId(int productId) {

		String validdateQuery = "select product_id,product_name,product_qty,price from stock where product_id=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			 con = ConnectionUtil.gbConnection();
			 pstmt = con.prepareStatement(validdateQuery);
			pstmt.setInt(1, productId);
			 rs = pstmt.executeQuery();
			if (rs.next()) {
				Stock stock = new Stock(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("product_qty"), rs.getDouble("price"));
				
				return stock;
				
				
			}

		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {if(pstmt!=null ) {
			       pstmt.close();}
			if(rs!=null) {
				
				rs.close();
			}
			if(con!=null) {	
					con.close();
				}	}
					
				 catch (SQLException e) {
					
					e.printStackTrace();
				}
			}

		return null;

	}

}
