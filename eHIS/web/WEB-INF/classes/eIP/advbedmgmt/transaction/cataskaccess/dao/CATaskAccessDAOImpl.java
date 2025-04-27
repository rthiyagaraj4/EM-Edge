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
package eIP.advbedmgmt.transaction.cataskaccess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import org.apache.log4j.Logger;

import webbeans.eCommon.ConnectionManager;
import eIP.advbedmgmt.GBMConstants;
import eIP.advbedmgmt.common.CommonResourceConstants;
import eIP.advbedmgmt.common.ErrorConstants;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;
import eIP.advbedmgmt.common.response.ErrorInfo;
import eIP.advbedmgmt.transaction.cataskaccess.CATaskAccessConstants;
import eIP.advbedmgmt.transaction.cataskaccess.CATaskAccessResourceConstants;
import eIP.advbedmgmt.transaction.cataskaccess.request.CATaskAccessRequest;
import eIP.advbedmgmt.transaction.cataskaccess.response.CATaskAccessResponse;
import eIP.advbedmgmt.transaction.cataskaccess.response.CATaskAccessResult;

/**
 * This is the DAO class for checking if GBM submodule has access to a CA module
 * task
 * 
 * @author GRamamoorthy
 * 
 */
public class CATaskAccessDAOImpl implements CATaskAccessDAO {

	/**
	 * This method checks if GBM submodule has access to a CA module task This
	 * method takes as input the request object , checks the validity of the
	 * access against EM database and then returns the result in the response
	 * object
	 * 
	 * @param request
	 * @return
	 */
	public CATaskAccessResponse checkCATaskAccess(CATaskAccessRequest request) {
		// initialize the response and related object
		CATaskAccessResponse response = new CATaskAccessResponse();
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;

		// initialize the logger
		Logger loggerInst = Logger.getLogger("APPLICATION_LOG");
		StringBuilder logMessage = new StringBuilder();

		//final String bundleClassName = "eIP.resources.Messages";
		
		CATaskAccessResult taskResult = CATaskAccessResult.VALID_ACCESS;
		// get connection
		Connection conn = getConnection();
		// safe check
		if (conn == null) {
			errorCode = ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE;
			// logging done here
			logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(":");
			logMessage
					.append("Could not validate access to CA module. Cause = Could not get connection to database");
			if (loggerInst != null) {
				loggerInst.fatal(logMessage.toString());
			}

			// get the error message from resource bundle through bundle manager
			/*errorMessage = BundleManager
					.getInstance()
					.getMessageFromResourceBundle(
							"DisplayMessage.Common.DatabaseConnectionFailure",
							bundleClassName);*/
			
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
							CATaskAccessResourceConstants.DISPLAYMESSAGE_CONNECTION_FAILURE_KEY,
							CATaskAccessResourceConstants.RESOURCE_MESSAGES_FILE_PATH);
			/*String specificErrorMessage = BundleManager
					.getInstance()
					.getMessageFromResourceBundle(
							"DisplayMessage.CATaskAccess.ConnectionFailureErrorMessage",
							bundleClassName);*/
			
			specificErrorMessage = MessageFormat.format(specificErrorMessage,
					new Object[] { CATaskAccessConstants.CA_MODULE_KEYWORD });
			errorMessage = MessageFormat.format(errorMessage,
					new Object[] { specificErrorMessage });
			// form the error info object and set it to response
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			// set task result to response
			taskResult = CATaskAccessResult.INVALID_ACCESS;
			response.setAccessResult(taskResult);
			return response;
		}
		// get the SQL query
		String sqlQuery = getSQLQuery(request);
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			setDataToPreparedStatement(prepStmt, request);
			rs = prepStmt.executeQuery();
			// safe check
			if (rs == null) {
				// logging done here
				logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(
						":");
				logMessage
						.append("Could not validate access to CA module. Cause = Null Resultset.");
				if (loggerInst != null) {
					loggerInst.fatal(logMessage.toString());
				}
				// error info initialization
				errorCode = ErrorConstants.CA_TASKACCESS_NULL_RESULTSET_ERRORCODE;//CATaskAccessConstants.NULL_RESULTSET_ERRORCODE;
				// obtain the error message
				/*errorMessage = BundleManager
						.getInstance()
						.getMessageFromResourceBundle(
								"DisplayMessage.CATaskAccess.NullResultSetMessage",
								bundleClassName);*/
				errorMessage = BundleManager
						.getInstance()
						.getDisplayMessageFromBundle(
								errorCode,
								CATaskAccessResourceConstants.RESOURCE_MESSAGES_FILE_PATH);
				errorMessage = MessageFormat
						.format(errorMessage,
								new Object[] { CATaskAccessConstants.CA_MODULE_KEYWORD });
				// add error info to response
				errorInfo = new ErrorInfo(errorCode, errorMessage);
				response.addError(errorInfo);
				// set task result to response
				taskResult = CATaskAccessResult.INVALID_ACCESS;
				response.setAccessResult(taskResult);
				return response;
			}

			// set the data to response
			/*processDataToResponse(rs,response,bundleClassName);*/
			processDataToResponse(rs,response);
		} catch (SQLException e) {
			// logging done here
			logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(":");
			logMessage
					.append("Could not validate access to CA module. Cause = Could not get connection to database");
			if (loggerInst != null) {
				loggerInst.fatal(logMessage.toString());
			}

			// error info initialization
			errorCode = ErrorConstants.CA_TASKACCESS_SQLEXCEPTION_ERRORCODE;// CATaskAccessConstants.SQLEXCEPTION_ERRORCODE;
			// obtain the error message
			
			/*errorMessage = BundleManager
					.getInstance()
					.getMessageFromResourceBundle(
							"DisplayMessage.CATaskAccess.SQLExceptionMessage",
							bundleClassName);*/
			
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							CATaskAccessResourceConstants.RESOURCE_MESSAGES_FILE_PATH);
			errorMessage = MessageFormat.format(errorMessage, new Object[] {
					CATaskAccessConstants.CA_MODULE_KEYWORD, e.getMessage() });
			// add error info to response
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			// set task result to response
			taskResult = CATaskAccessResult.INVALID_ACCESS;
			response.setAccessResult(taskResult);
		} finally {
			if (prepStmt != null) {
				try {
					prepStmt.close();
				} catch (SQLException e) {
					// cannot do much
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// cannot do much
				}
			}

			ConnectionManager.returnConnection(conn);
			//conn = null;
		}

		return response;
	}

	/**
	 * This method gets the SQL query for checking the CA Task access
	 * 
	 * @param request
	 * @return
	 */
	private String getSQLQuery(CATaskAccessRequest request) {
		StringBuffer queryBuffer = new StringBuffer();
		queryBuffer.append("select PRIVILEGE_STATUS ");
		/*queryBuffer.append("select count(*) ")
				.append(CATaskAccessConstants.OUTPUT_COLUMN_KEYWORD);*/
		queryBuffer.append("from ca_appl_task_for_resp_reln ");
		queryBuffer.append("where facility_id = ? ");
		queryBuffer.append("and resp_id = ? ");
		queryBuffer.append("and appl_task_id = ? ");

		return queryBuffer.toString();
	}

	/**
	 * 
	 * @param prepStmt
	 * @param request
	 * @throws SQLException
	 */
	private void setDataToPreparedStatement(PreparedStatement prepStmt,
			CATaskAccessRequest request) throws SQLException {
		int index = 1;
		// set data to prepared statement
		// first facility id
		String facilityId = request.getFacilityId();
		prepStmt.setString(index, facilityId);
		index++;

		// next responsibility id
		String responsibilityId = request.getResponsibilityId();
		prepStmt.setString(index, responsibilityId);
		index++;

		// task id
		String taskId = request.getTaskId();
		prepStmt.setString(index, taskId);
	}

	/**
	 * This method processes the result set data to the response object
	 * 
	 * @param rs
	 * @param response
	 */
	private void processDataToResponse(ResultSet rs,
			CATaskAccessResponse response) throws SQLException {
			/*,String bundleClassName) throws SQLException {*/
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		CATaskAccessResult taskResult = CATaskAccessResult.VALID_ACCESS;
		/*int count = 0;*/
		String privilegeStatus = null;
		// check if resultset has data
		if (rs.next()) {
			//count = rs.getInt(CATaskAccessConstants.OUTPUT_COLUMN_KEYWORD);
			privilegeStatus = rs
					.getString(CATaskAccessConstants.PRIVILEGE_STATUS_COLUMN_KEYWORD);
		}

		/**
		 * The below code is not needed will be deleted after testing
		 */
		// count can have value 1 or 0 -
		// if it is 0 - indicates error
		/*if (count == 0) {
			errorCode = CATaskAccessConstants.INVALID_ACCESS_ERRORCODE;
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							CATaskAccessResourceConstants.RESOURCE_MESSAGES_FILE_PATH);
			errorMessage = MessageFormat.format(errorMessage,
					new Object[] { CATaskAccessConstants.CA_MODULE_KEYWORD });
			
			taskResult = CATaskAccessResult.INVALID_ACCESS;
		}*/
		
		// this is new logic - this considers 2 cases - privilege status itself
		// is not present or has value "X"
		if ((privilegeStatus == null || privilegeStatus.trim().equals(""))
				|| (!(CATaskAccessConstants.PRIVILEGE_STATUS_VALID_IDENTIFIER
						.equalsIgnoreCase(privilegeStatus)))) {
			errorCode = ErrorConstants.CA_TASKACCESS_INVALID_ACCESS_ERRORCODE;// CATaskAccessConstants.INVALID_ACCESS_ERRORCODE;
			
			/*errorMessage = BundleManager
					.getInstance()
					.getMessageFromResourceBundle(
							"DisplayMessage.CATaskAccess.InvalidAccessMessage",
							bundleClassName);*/
			
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							CATaskAccessResourceConstants.RESOURCE_MESSAGES_FILE_PATH);
			errorMessage = MessageFormat.format(errorMessage,
					new Object[] { CATaskAccessConstants.CA_MODULE_KEYWORD });
			
			taskResult = CATaskAccessResult.INVALID_ACCESS;
		}
		
		
		// initialize the errorinfo object and add it to the response
		errorInfo = new ErrorInfo(errorCode, errorMessage);
		response.addError(errorInfo);
		// set the task result to response
		response.setAccessResult(taskResult);
	}

	/**
	 * This method gets the connection
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
			//System.out.println("successful in getting connection");
		} catch (SQLException e) {
			System.out.println("Could not get connection - program terminates");
		}*/

		return conn;
	}

}
