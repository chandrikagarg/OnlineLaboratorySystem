package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
	
	private static final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String PASSWORD = "chandrikagarg";
	private static final String USERNAME = "system";

	// get a database connection
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DRIVERNAME);
			
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("connection establisted");
		} catch (ClassNotFoundException ex) {

			System.out.println("connection not establisted" + ex);
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e1) {
			System.out.println(e1);
		}
		return connection;
	}

	// close database connection
	public static void closeConnection(Connection con) {

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
	}

	// close statements
	public static void closeStatement(Statement smt) {

		if (smt != null) {
			try {
				smt.close();
			} catch (SQLException e) {
				System.out.println(e);
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
	}
	
	public static void closePreparedStatement(PreparedStatement pst) {

		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				System.out.println(e);
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
	}
	public static void closeResultSet(ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println(e);
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
	}

}
