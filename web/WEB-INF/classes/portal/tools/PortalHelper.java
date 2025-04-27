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
package portal.tools;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * This class loads all the configuration information 
 * from portalconfig.properties to property files
 * All information from the configuration files are retrieved in web services using this class
 * @author GRamamoorthy
 *
 */
public class PortalHelper {

	private static Properties portalConfigProperties = new Properties();

	private static boolean isInitialized = false;
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String getWebServiceURL(String key){
		String url = "";
		if(!isInitialized){
			initializeConfigProperties();
		}
		if(portalConfigProperties.containsKey(key)){
			url = portalConfigProperties.getProperty(key);
		}
		return url;
	}
	
	/**
	 * 
	 */
	private static void initializeConfigProperties(){
		try {
			InputStream is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("PortalConfig.properties");
			portalConfigProperties.load(is);
			isInitialized = true;
		} catch (Exception e) {
			/**
			 * TODO
			 * need to log
			 */
			return;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		String className = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
//		String user = "IBAEHIS";
//		String pass = "IBAEHIS";
		String user = "appluser";
		String pass = "appluser";
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@20.201.206.23:1521:xe", user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return conn;
	}
	
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
