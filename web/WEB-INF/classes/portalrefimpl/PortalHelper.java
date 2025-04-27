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
package portalrefimpl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import webbeans.eCommon.ConnectionManager;

/**
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
					.getResourceAsStream("./PortalRefConfig.properties");
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
		conn = ConnectionManager.getConnection();
		/*
		String className = getConfigPropertyValue(
				PortalConstants.DATABASE_CONNECTION_CLASS_KEY, true);// "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		String user = getConfigPropertyValue(PortalConstants.DATABASE_USER_KEY);// "IBAEHIS";
		String pass = getConfigPropertyValue(PortalConstants.DATABASE_PASSWORD_KEY);// "IBAEHIS";
		String connectionURL = getConfigPropertyValue(PortalConstants.DATABASE_CONNECTION_URL_KEY);
		try {
			conn = DriverManager.getConnection(connectionURL, user, pass);
		} catch (SQLException e) {
			//e.printStackTrace();
			return null;
		}
		*/

		return conn;
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
		ConnectionManager.returnConnection(conn);
		/*if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
	}
	
	/**
	 * 
	 * @param stmt
	 */
	public static void closeResources(Statement stmt){
		try {
			if(stmt != null) {
				stmt.close();
			} 
		} catch (Exception e) {
			System.out.println("Failed to close the Statement object");
		}
	}
	
	/**
	 * 
	 * @param rs
	 */
	public static void closeResources(ResultSet rs){
		try {
			if(rs != null) {
				rs.close();
			} 
		} catch (Exception e) {
			System.out.println("Failed to close the ResultSet object");
		}
	}
	
	/**
	 * 
	 * @param rs
	 * @param stmt
	 */
	public static void closeResources(ResultSet rs,Statement stmt){
		closeResources(rs);
		closeResources(stmt);
	}
	
	
	/**
	 * This method returns a date object given the date value in string
	 * and the format to be applied
	 * @param dateString
	 * @param format
	 * @return
	 */
	public static Date getDateFromString(String dateString,String format){
		Date dateObject = null;
		SimpleDateFormat dateFormatter = new SimpleDateFormat();
		if(format != null && !format.trim().equals("")){
			dateFormatter.applyPattern(format);
		}
		try {
			dateObject = dateFormatter.parse(dateString);
		} catch (ParseException e) {
			// nothing much to do here
		}
		
		return dateObject;
	}
	
	/**
	 * This method returns a string value representing the input date's value
	 * in the given format
	 * @param dateObject
	 * @param format
	 * @return
	 */
	public static String getDateAsString(Date dateObject,String format){
		String dateString = null;
		SimpleDateFormat dateFormatter = new SimpleDateFormat();
		if(format != null && !format.trim().equals("")){
			dateFormatter.applyPattern(format);
		}
		dateString = dateFormatter.format(dateObject);
		return dateString;
	}

	/**
	 * 
	 * @param propertyKey
	 * @param initialize
	 * @return
	 */
	public static String getConfigPropertyValue(String propertyKey,boolean initialize){
		String propertyValue = "";
		
		if(initialize || !isInitialized){
			initializeConfigProperties();
		}
		if(portalConfigProperties.containsKey(propertyKey)){
			propertyValue = portalConfigProperties.getProperty(propertyKey);
		}
		
		return propertyValue;
	}
	
	/**
	 * 
	 * @param propertyKey
	 * @return
	 */
	public static String getConfigPropertyValue(String propertyKey){
		return getConfigPropertyValue(propertyKey, false);
	}
	
	/**
	 * 
	 * @param stringValue
	 * @return
	 */
	public static int getIntegerValue(String stringValue,int defaultValue){
		int intValue = defaultValue;
		if(stringValue != null){
			int index = stringValue.indexOf(".");
			if(index > 0){
				stringValue = stringValue.substring(0, index);
			}
		}
		
		try {
			intValue = Integer.parseInt(stringValue);
		} catch (NumberFormatException e) {
			intValue = defaultValue;
		}
		return intValue;
	}
	
	/**
	 * 
	 * @param tagKey
	 * @return
	 */
	public static String getXMLStartTag(String tagKey){
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append(PortalConstants.OPEN_XML_TAG);
		xmlBuffer.append(tagKey);
		xmlBuffer.append(PortalConstants.XML_CLOSE_TAG);
		
		return xmlBuffer.toString();
	}
	
	/**
	 * 
	 * @param tagKey
	 * @return
	 */
	public static String getXMLEndTag(String tagKey){
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append(PortalConstants.CLOSE_XML_TAG);
		xmlBuffer.append(tagKey);
		xmlBuffer.append(PortalConstants.XML_CLOSE_TAG);
		
		return xmlBuffer.toString();
	}
	
	/**
	 * 
	 * @param tagKey
	 * @param value
	 * @return
	 */
	public static String getCompleteXMLTag(String tagKey,String value){
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append(getXMLStartTag(tagKey));
		if(value == null){
			value = "";
		}
		value = value.trim();
		// code modified to enclose the value inside chardata
		xmlBuffer.append(PortalConstants.CHARDATA_START_KEY);
		xmlBuffer.append(value);
		xmlBuffer.append(PortalConstants.CHARDATA_END_KEY);
		
		xmlBuffer.append(getXMLEndTag(tagKey));
		
		return xmlBuffer.toString();
	}
	
	
	/*public static void main(String[] args){
		MessageContainer messageContainer = MessageContainer.getInstance();
		String displayMessage = "";
		String message = "";
		try {
			displayMessage = messageContainer.getDisplayMessage(
					CommonConstants.DETAILED_TESTRESULT_MODULE_NAME,
					ResultConstants.SQLEXCEPTION_DETAILEDTESTRESULT_CODE);
			message = messageContainer.getResourceMessage(
					CommonConstants.DETAILED_TESTRESULT_MODULE_NAME,
					ResultConstants.DTLD_RESULT_EMPTYDATA_CODE);
			System.out.println(message);
			System.out.println(displayMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
	
}
