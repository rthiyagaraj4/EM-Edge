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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eAlert.src.config.AlertConstants;
import eAlert.src.config.ConfigHelper;

/**
 * @author PrasannaR
 *
 */
public class ConnectionHelper {

	
	/**
	 * This method gets the connection for the RuleLibrary project
	 * All classes needing database connections can make use
	 * of this method to get connection
	 * This method reads the properties from the RuleConfig.properties
	 * file to get the data needed for getting connection
	 * This method in turn calls the DatabaseHelper class present
	 * in the common project to get the connection
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		String className = null;
		/*className = RulesHelper.getConfigPropertyValue(
				RulesConstant.DATABASE_CONNECTION_CLASS_KEY, true);// "oracle.jdbc.driver.OracleDriver";
*/		className = ConfigHelper.getConfigPropertyValue(
		AlertConstants.DATABASE_CONNECTION_CLASS_KEY, true);
		
		String user = null;
		/*user = RulesHelper.getConfigPropertyValue(RulesConstant.DATABASE_USER_KEY);// "IBAEHIS";
*/		user = ConfigHelper.getConfigPropertyValue(AlertConstants.DATABASE_USER_KEY);
		String pass = null;
		/*pass = RulesHelper.getConfigPropertyValue(RulesConstant.DATABASE_PASSWORD_KEY);// "IBAEHIS";
*/		pass = ConfigHelper.getConfigPropertyValue(AlertConstants.DATABASE_PASSWORD_KEY);
		String connectionURL = null;
		/*connectionURL = RulesHelper.getConfigPropertyValue(RulesConstant.DATABASE_CONNECTION_URL_KEY);*/
		connectionURL = ConfigHelper.getConfigPropertyValue(AlertConstants.DATABASE_CONNECTION_URL_KEY);
		conn = DBHelper.getConnection(className, user, pass,
				connectionURL);
		
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
