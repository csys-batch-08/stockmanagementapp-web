package com.stock.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.stock.logger.Logger;

public class ConnectionUtil {

	public static Connection gbConnection() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");

		return con;

	}

	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) {

		try {
			if (rs != null) {

				rs.close();
			}

			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException |NullPointerException e) {

		Logger.printStackTrace(e);
		Logger.runTimeException(e.getMessage());
	

	}}
}
