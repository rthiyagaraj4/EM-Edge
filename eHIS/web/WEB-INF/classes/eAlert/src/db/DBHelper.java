/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 *   
 */
package eAlert.src.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author PrasannaR
 *
 */
public class DBHelper {

	
	/**
	 * This method gets a database connection given
	 * the inputs like class name, user name, password and the connection
	 * URL
	 * @return
	 */
	public static Connection getConnection(String className, String user,
			String password, String connectionURL) {
		Connection conn = null;
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		try {
			conn = DriverManager.getConnection(connectionURL, user, password);
		} catch (SQLException e) {
			//e.printStackTrace();
			return null;
		}

		return conn;
	}
	
	/**
	 * 
	 * @param conn
	 */
	public static void returnConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	/**
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void closeResources(Connection conn, Statement stmt, ResultSet rs ) {
		try {
			if(rs != null) {
				rs.close();
			} 
		} catch (Exception e) {
			System.out.println("Failed to close the ResultSet object");
		}
		closeResources(conn, stmt);
	}
	
	/**
	 * 
	 * @param conn
	 * @param stmt
	 */
	public static void closeResources(Connection conn, Statement stmt ) {
		try {
			if(stmt != null) {
				stmt.close();
			} 
		} catch (Exception e) {
			System.out.println("Failed to close the Statement object");
		}
		closeResources(conn);
	}
	
	/**
	 * 
	 * @param conn
	 */
	public static void closeResources(Connection conn) {
		
		try {
			if(conn != null) {
				conn.close();
			} 
		} catch (Exception e) {
			System.out.println("Failed to close the connection Object");
		}
	}
}
