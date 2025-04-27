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
package eIP.advbedmgmt.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import org.apache.log4j.Logger;

import webbeans.eCommon.ConnectionManager;
import eIP.advbedmgmt.GBMConstants;
import eIP.advbedmgmt.common.CommonResourceConstants;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;
import eIP.advbedmgmt.common.response.BaseResponse;
import eIP.advbedmgmt.common.response.ErrorInfo;

/**
 * This class is the base DAO implementation class
 * This class should be extended by specific DAO implementation class
 * This class will provide common functionalities to all
 * specific DAO implementation class
 * This is an abstract class
 * @author GRamamoorthy
 *
 */
public abstract class BaseDAOImpl {

	/**
	 * This method gets a connection object
	 * 
	 * @return
	 */
	protected Connection getConnection() {
		Connection conn = null;
		conn = ConnectionManager.getConnection();

		/*try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return conn;
		}
		String userName = "appluser";
		userName = "IBAEHIS";
		String password = "appluser";
		password = "IBAEHIS";
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@130.78.62.59:1521:srdv", userName,
					password);
			System.out.println("successful in getting connection");
		} catch (SQLException e) {
			System.out.println("Could not get connection - program terminates");
		}*/


		return conn;
	}
	
	/**
	 * This method handles the case of null connection
	 * @param baseResponse
	 */
	protected void handleNullConnection(BaseResponse response,Logger loggerInst){
		int errorCode = ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE;
		StringBuilder logMessage = new StringBuilder();
		if (loggerInst != null) {
			// logging done here
			logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(
					":");
			logMessage
					.append(getLogMessageForConnectionIssue());
			loggerInst.fatal(logMessage.toString());
		}

		// get the error message from resource bundle through bundle manager
		String errorMessage = BundleManager
				.getInstance()
				.getDisplayMessageFromBundle(
						ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE,
						CommonResourceConstants.COMMON_RESOURCES_FILE_CLASSPATH);
		
		String specificErrorMessage = getSpecMesgForConnectionIssue();
		errorMessage = MessageFormat.format(errorMessage, specificErrorMessage);
		
		// form the error info object and set it to response
		ErrorInfo errorInfo = new ErrorInfo(errorCode, errorMessage);
		response.addError(errorInfo);
	}
	
	/**
	 * This method is used for getting specific messages from
	 * extending classes to be used for logging in connection 
	 * failure scenario
	 * @return
	 */
	protected abstract String getLogMessageForConnectionIssue();
	
	/**
	 * This method is used to obtain the module specific error message
	 * in connection issue scenario
	 * This method should be implemented in child classes
	 * @return
	 */
	protected abstract String getSpecMesgForConnectionIssue();
	
	/**
	 * This method closes the result set, statement object and returns the 
	 * connection to pool
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	protected void closeResources(ResultSet rs,Statement stmt,Connection conn){
		closeResource(rs);
		closeResource(stmt);
		returnConnection(conn);
	}
	
	/**
	 * 
	 * @param rs
	 */
	protected void closeResource(ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// cannot do much
			}
		}
	}
	
	/**
	 * 
	 * @param stmt
	 */
	protected void closeResource(Statement stmt){
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// cannot do much
			}
		}
	}
	
	/**
	 * 
	 * @param stmt
	 * @param conn
	 */
	protected void closeResources(Statement stmt,Connection conn){
		closeResource(stmt);
		returnConnection(conn);
	}
	
	/**
	 * This method will return the connection to connection manager
	 * @param conn
	 */
	protected void returnConnection(Connection conn) {
		/*ConnectionManager.returnConnection(conn); */
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// cannot do much
			}
		}
		
		//conn = null;
	}
	
	
}
