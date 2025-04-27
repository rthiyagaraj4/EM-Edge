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
package eIP.advbedmgmt.common.bedlegend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import webbeans.eCommon.ConnectionManager;
import eIP.advbedmgmt.GBMConstants;
import eIP.advbedmgmt.common.CommonResourceConstants;
import eIP.advbedmgmt.common.ErrorConstants;
import eIP.advbedmgmt.common.bedlegend.BedLegendConstants;
import eIP.advbedmgmt.common.bedlegend.BedLegendResourceConstants;
import eIP.advbedmgmt.common.bedlegend.request.BedLegendRequest;
import eIP.advbedmgmt.common.bedlegend.response.BedLegendResponse;
import eIP.advbedmgmt.common.model.BedLegend;
import eIP.advbedmgmt.common.model.BedStatusEnum;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;
import eIP.advbedmgmt.common.response.ErrorInfo;

/**
 * This is the DAO impl class for bed legend
 * 
 * @author GRamamoorthy
 * 
 */
public class BedLegendDAOImpl implements BedLegendDAO {

	/**
	 * This method gets the bed legend
	 */
	public BedLegendResponse getBedLegend(BedLegendRequest request) {
		BedLegendResponse response = new BedLegendResponse();
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;

		// initialize the logger
		Logger loggerInst = Logger.getLogger("APPLICATION_LOG");
		StringBuilder logMessage = new StringBuilder();
		Connection conn = getConnection();

		// safe check
		if (conn == null) {
			errorCode = ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE;

			if (loggerInst != null) {
				// logging done here
				logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(
						":");
				logMessage
						.append("Could not get bed legend. Cause = Could not get connection to database");
				loggerInst.fatal(logMessage.toString());
			}

			// get the error message from resource bundle through bundle manager
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE,
							CommonResourceConstants.COMMON_RESOURCES_FILE_CLASSPATH);
			// code written to get the specific message for this
			// operation and then add it to the original message
			String specificErrorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							BedLegendResourceConstants.DISPLAY_CONNECTION_ERROR_KEY,
							BedLegendResourceConstants.RESOURCE_MESSAGE_FILE_PATH);
			
			errorMessage = MessageFormat.format(errorMessage,
					specificErrorMessage);
			
			// form the error info object and set it to response
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			return response;
		}
		
		String sqlQuery = getSQLQuery(request);
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			rs = prepStmt.executeQuery();
			
			// safe check - flag error
			if(rs == null){
				// log and set error in response
				errorCode = ErrorConstants.BED_LEGEND_NULL_RESULTSET_ERROR_CODE;
				if (loggerInst != null) {
					logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER)
							.append(":");
					String message = BundleManager
							.getInstance()
							.getLogMessageFromBundle(
									errorCode,
									BedLegendResourceConstants.RESOURCE_MESSAGE_FILE_PATH);
					logMessage.append(message);
					loggerInst.fatal(logMessage.toString());
				}

				errorMessage = BundleManager
						.getInstance()
						.getDisplayMessageFromBundle(
								errorCode,
								BedLegendResourceConstants.RESOURCE_MESSAGE_FILE_PATH);
				errorInfo = new ErrorInfo(errorCode, errorMessage);
				response.addError(errorInfo);
				return response;
			}
			
			setDataInResponse(response, rs);
			
		} catch (SQLException e) {
			// error condition - handle it
			errorCode = ErrorConstants.BED_LEGEND_SQLEXCEPTION_ERROR_CODE;
			if (loggerInst != null) {
				logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(
						":");
				String message = BundleManager
						.getInstance()
						.getLogMessageFromBundle(
								errorCode,
								BedLegendResourceConstants.RESOURCE_MESSAGE_FILE_PATH);
				message = MessageFormat.format(message, new Object[]{e.getMessage()});
				logMessage.append(message);
				loggerInst.fatal(logMessage.toString());
			}

			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							BedLegendResourceConstants.RESOURCE_MESSAGE_FILE_PATH);
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			return response;
		}finally{
			// release resources
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// cannot do much
				}
			}
			if (prepStmt != null) {
				try {
					prepStmt.close();
				} catch (SQLException e) {
					// cannot do much
				}
			}
			if (conn != null) {
				returnConnection(conn);
			}
		}

		return response;
	}

	/**
	 * This method gets a connection object
	 * 
	 * @return
	 */
	private Connection getConnection() {
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
	 * This method gets the SQL query for getting bed legend
	 * @return
	 */
	private String getSQLQuery(BedLegendRequest request){
		StringBuffer queryBuff = new StringBuffer();
		queryBuff.append("select stat,backgndcolor,textcolor from GBM_COLOR_CONFIG order by stat asc");
		
		return queryBuff.toString();
	}
	
	/**
	 * This method will retrieve data from resultset and set it in response object 
	 * @param response
	 * @param rs
	 * @throws SQLException
	 */
	private void setDataInResponse(BedLegendResponse response, ResultSet rs)
			throws SQLException {
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		
		String legendIdentifier = null;
		String legendColor = null;
		String textColor = null;
		List<BedLegend> bedLegendList = new ArrayList<BedLegend>();
		BedLegend bedLegend = null;
		BedStatusEnum legendEnum = null;
		// iterate through result set and get data
		while(rs.next()){
			legendEnum = BedStatusEnum.NOT_INITIALIZED;
			
			legendIdentifier = rs.getString(BedLegendConstants.LEGEND_IDENTIFIER_COL_NAME);
			try {
				legendEnum = BedStatusEnum.valueOf(legendIdentifier);
			} catch (Exception e) {
				// not much can be done
				legendEnum = BedStatusEnum.NOT_INITIALIZED;
			}
			
			legendColor = rs.getString(BedLegendConstants.LEGEND_COLOR_COL_NAME);
			textColor = rs.getString(BedLegendConstants.LEGEND_TEXT_COLOR_COL_NAME);
			bedLegend = new BedLegend(legendEnum,legendColor, textColor);
			
			bedLegendList.add(bedLegend);
		}
		
		response.setLegends(bedLegendList);
		// last validation - check for empty data
		if(bedLegendList.isEmpty()){
			errorCode = ErrorConstants.BED_LEGEND_DATA_NOT_OBTAINED_ERROR_CODE;
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							BedLegendResourceConstants.RESOURCE_MESSAGE_FILE_PATH);
		}
		// initialize errorinfo and add it to response
		errorInfo = new ErrorInfo(errorCode, errorMessage);
		response.addError(errorInfo);
	}
	

	/**
	 * This method will return the connection to connection manager
	 * @param conn
	 */
	private void returnConnection(Connection conn) {
		ConnectionManager.returnConnection(conn); 
		/*if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// cannot do much
			}
		}*/
		
		//conn = null;
	}
	
}
