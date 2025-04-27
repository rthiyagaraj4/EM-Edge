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
package eIP.advbedmgmt.common.bedcolor.dao;

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
import eIP.advbedmgmt.common.bedcolor.BedColorConstants;
import eIP.advbedmgmt.common.bedcolor.BedColorResourceConstants;
import eIP.advbedmgmt.common.bedcolor.request.BedColorRequest;
import eIP.advbedmgmt.common.bedcolor.response.BedColorResponse;
import eIP.advbedmgmt.common.model.BedColor;
import eIP.advbedmgmt.common.model.BedStatusEnum;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;
import eIP.advbedmgmt.common.response.ErrorInfo;

/**
 * This is the DAO impl class for getting bed color
 * 
 * @author GRamamoorthy
 * 
 */
public class BedColorDAOImpl implements BedColorDAO {

	/**
	 * This method gets the bed color as per the request object
	 */
	public BedColorResponse getBedColor(BedColorRequest request) {
		BedColorResponse response = new BedColorResponse();
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
						.append("Could not get bed color. Cause = Could not get connection to database");
				loggerInst.fatal(logMessage.toString());
			}

			// get the error message from resource bundle through bundle manager
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE,
							CommonResourceConstants.COMMON_RESOURCES_FILE_CLASSPATH);
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
			// set data to prepared statement
			setDataToPreparedStatement(prepStmt, request);
			rs = prepStmt.executeQuery();
			// safe check
			if (rs == null) {
				// log and set error in response
				errorCode = ErrorConstants.BED_COLOR_NULLRESULTSET_ERRORCODE;// BedColorConstants.BED_COLOR_NULLRESULTSET_ERRORCODE;
				if (loggerInst != null) {
					logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER)
							.append(":");
					String message = BundleManager
							.getInstance()
							.getLogMessageFromBundle(
									errorCode,
									BedColorResourceConstants.RESOURCE_MESSAGE_FILE_PATH);
					logMessage.append(message);
					loggerInst.fatal(logMessage.toString());
				}

				errorMessage = BundleManager
						.getInstance()
						.getDisplayMessageFromBundle(
								errorCode,
								BedColorResourceConstants.RESOURCE_MESSAGE_FILE_PATH);
				errorInfo = new ErrorInfo(errorCode, errorMessage);
				response.addError(errorInfo);
				return response;
			}
			
			setDataInResponse(rs, prepStmt, response, request, loggerInst);
			
		} catch (SQLException e) {
			errorCode = ErrorConstants.BED_COLOR_SQLEXCEPTION_ERRORCODE;// BedColorConstants.BED_COLOR_SQLEXCEPTION_ERRORCODE;
			if (loggerInst != null) {
				logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(
						":");
				String message = BundleManager
						.getInstance()
						.getLogMessageFromBundle(
								errorCode,
								BedColorResourceConstants.RESOURCE_MESSAGE_FILE_PATH);
				message = MessageFormat.format(message, new Object[]{e.getMessage()});
				logMessage.append(message);
				loggerInst.fatal(logMessage.toString());
			}

			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							BedColorResourceConstants.RESOURCE_MESSAGE_FILE_PATH);
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			return response;

		} finally {
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
	 * This method gets the SQL query needed to get bed color
	 * 
	 * @param request
	 * @return
	 */
	private String getSQLQuery(BedColorRequest request) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder
				.append("select stat,backgndcolor,textcolor from GBM_COLOR_CONFIG where UPPER(stat) like UPPER(?)");

		return queryBuilder.toString();
	}

	/**
	 * This method sets data to prepared statement
	 * 
	 * @param prepStmt
	 * @param request
	 */
	private void setDataToPreparedStatement(PreparedStatement prepStmt,
			BedColorRequest request) throws SQLException {
		String bedStatus = request.getBedStatus();
		int index = 1;
		prepStmt.setString(index, bedStatus);
	}

	/**
	 * This method sets data to the response object
	 * 
	 * @param rs
	 * @param prepStmt
	 * @param request
	 */
	private void setDataInResponse(ResultSet rs, PreparedStatement prepStmt,
			BedColorResponse response, BedColorRequest request,
			Logger loggerInst) throws SQLException {
		List<BedColor> bedColorList = new ArrayList<BedColor>();
		BedColor bedColorInst = null;
		String bedColor = null;
		String bedStatusStr = null;
		String bedTextColor	= null;
		BedStatusEnum bedStatus = null;
		// iterate through result set and get data
		while (rs.next()) {
			bedColor = rs
					.getString(BedColorConstants.BED_COLOR_COLUMN_IDENTIFIER);
			bedStatusStr = rs.getString(BedColorConstants.BED_STATUS_COLUMN_IDENTIFIER);
			bedTextColor = rs.getString(BedColorConstants.BED_STATUS_TXT_COLOR_IDENTIFIER);
			try {
				bedStatus = BedStatusEnum.valueOf(bedStatusStr);
			} catch (Exception e) {
				bedStatus = BedStatusEnum.NOT_INITIALIZED;
			}
			bedColorInst = new BedColor(bedColor,bedStatus,bedTextColor);
			bedColorList.add(bedColorInst);
		}
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// safe check
		if (bedColorList.isEmpty()) {
			errorCode = ErrorConstants.BED_COLOR_NODATA_ERRORCODE;// BedColorConstants.BED_COLOR_NODATA_ERRORCODE;
			if (loggerInst != null) {
				StringBuilder logMessage = new StringBuilder();
				logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(
						":");
				String message = BundleManager
						.getInstance()
						.getLogMessageFromBundle(
								errorCode,
								BedColorResourceConstants.RESOURCE_MESSAGE_FILE_PATH);
				logMessage.append(message);
				loggerInst.fatal(logMessage.toString());
			}

			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							BedColorResourceConstants.RESOURCE_MESSAGE_FILE_PATH);
			errorInfo = new ErrorInfo(errorCode, errorMessage);
		}

		errorInfo = new ErrorInfo(errorCode, errorMessage);
		response.setColorList(bedColorList);
		response.addError(errorInfo);
	}

	/**
	 * This method gets a connection object
	 * 
	 * @return
	 */
	private Connection getConnection() {
		Connection conn = null;
		conn = ConnectionManager.getConnection(); 

/*		try {
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
		}
*/
		return conn;
	}

	private void returnConnection(Connection conn) {
		ConnectionManager.returnConnection(conn); 
		//conn = null;
	}

}
