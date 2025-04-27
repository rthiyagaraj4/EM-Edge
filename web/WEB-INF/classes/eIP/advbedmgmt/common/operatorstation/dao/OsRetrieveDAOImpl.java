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
package eIP.advbedmgmt.common.operatorstation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import org.apache.log4j.Logger;

import eIP.advbedmgmt.GBMConstants;
import eIP.advbedmgmt.common.ErrorConstants;
import eIP.advbedmgmt.common.dao.BaseDAOImpl;
import eIP.advbedmgmt.common.operatorstation.OsRetrieveConstants;
import eIP.advbedmgmt.common.operatorstation.OsRetrieveResourceConstants;
import eIP.advbedmgmt.common.operatorstation.request.OsRetrieveRequest;
import eIP.advbedmgmt.common.operatorstation.response.OsRetrieveResponse;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;
import eIP.advbedmgmt.common.response.ErrorInfo;

/**
 * This is the DAO impl class for operator station related functionalities
 * @author GRamamoorthy
 *
 */
public class OsRetrieveDAOImpl extends BaseDAOImpl implements OsRetrieveDAO {

	/**
	 * This method retrieves Operator station id for a user
	 * @param request
	 * @return
	 */
	public OsRetrieveResponse getOSForUser(OsRetrieveRequest request) {
		// initialize the response
		OsRetrieveResponse response = new OsRetrieveResponse();
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		
		// initialize logger
		Logger loggerInst = Logger.getLogger("APPLICATION_LOG");
		StringBuilder logMessage = new StringBuilder();
		
		Connection conn = getConnection();
		if(conn == null){
			handleNullConnection(response, loggerInst);
			return response;
		}
		
		String sqlQuery = getOsRetrieveSQLQuery(request);
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		String osId = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			setDataInPSForOSRetrieval(prepStmt, request);
			
			rs = prepStmt.executeQuery();
			// safe check
			if(rs == null){
				// error handling
				errorCode = ErrorConstants.OS_RETR_NULL_RS_CODE;
				// log message
				if (loggerInst != null) {
					logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(
							":");
					String resourceMessage = BundleManager
							.getInstance()
							.getLogMessageFromBundle(
									errorCode,
									OsRetrieveResourceConstants.OS_RETR_RESOURCE_MESSAGE_FILE_PATH);
					logMessage.append(resourceMessage);
					loggerInst.fatal(logMessage.toString());
				}
				
				// error object init
				errorMessage = BundleManager
						.getInstance()
						.getDisplayMessageFromBundle(
								errorCode,
								OsRetrieveResourceConstants.OS_RETR_RESOURCE_MESSAGE_FILE_PATH);
				errorInfo = new ErrorInfo(errorCode, errorMessage);
				response.addError(errorInfo);
				return response;
			}
			
			if(rs.next()){
				osId = rs.getString(OsRetrieveConstants.OS_DB_COL_NAME);
				response.setOsId(osId);
			}else{
				// error handling
				errorCode = ErrorConstants.OS_RETR_NO_DATA_CODE;
				// log message
				if (loggerInst != null) {
					logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(
							":");
					String resourceMessage = BundleManager
							.getInstance()
							.getLogMessageFromBundle(
									errorCode,
									OsRetrieveResourceConstants.OS_RETR_RESOURCE_MESSAGE_FILE_PATH);
					logMessage.append(resourceMessage);
					loggerInst.fatal(logMessage.toString());
				}
				
				// error object init
				errorMessage = BundleManager
						.getInstance()
						.getDisplayMessageFromBundle(
								errorCode,
								OsRetrieveResourceConstants.OS_RETR_RESOURCE_MESSAGE_FILE_PATH);
			}
			
			// add error object
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			
		} catch (SQLException e) {
			// error handling
			errorCode = ErrorConstants.OS_RETR_SQLEXCEPTION_CODE;
			
			// log message
			if (loggerInst != null) {
				logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(
						":");
				String resourceMessage = BundleManager
						.getInstance()
						.getLogMessageFromBundle(
								errorCode,
								OsRetrieveResourceConstants.OS_RETR_RESOURCE_MESSAGE_FILE_PATH);
				resourceMessage = MessageFormat.format(resourceMessage,
						new Object[] { e.getMessage() });
				logMessage.append(resourceMessage);
				loggerInst.fatal(logMessage.toString());
			}
			
			// error object init
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							OsRetrieveResourceConstants.OS_RETR_RESOURCE_MESSAGE_FILE_PATH);
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			
		}finally{
			//closeResources(rs, prepStmt, conn); 

			/*Added for CheckStyle*/
			if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// cannot do much
			}
				}
			if(prepStmt != null){
			try {
				prepStmt.close();
			} catch (SQLException e) {
				// cannot do much
			}
		}
			if (conn != null) {
				returnConnection(conn);
			}
			/*Added for CheckStyle*/
           
		}
		
		
		return response;
	}

	/**
	 * This method returns the message for logging purpose
	 * when connection is not obtained
	 * @return
	 */
	protected String getLogMessageForConnectionIssue() {
		String message = BundleManager
				.getInstance()
				.getMessageFromResourceBundle(
						OsRetrieveResourceConstants.CONNECTION_ISSUE_KEY,
						OsRetrieveResourceConstants.OS_RETR_RESOURCE_MESSAGE_FILE_PATH);
		return message;
	}

	/**
	 * This method returns the message for display purpose
	 * when connection is not obtained
	 * @return
	 */
	protected String getSpecMesgForConnectionIssue() {
		String message = BundleManager
				.getInstance()
				.getMessageFromResourceBundle(
						OsRetrieveResourceConstants.DISPLAY_CONNECTION_ISSUE_KEY,
						OsRetrieveResourceConstants.OS_RETR_RESOURCE_MESSAGE_FILE_PATH);
		return message;
	}
	
	/**
	 * this method returns the SQL query used to retrieve operator station id
	 * @param request
	 * @return
	 */
	private String getOsRetrieveSQLQuery(OsRetrieveRequest request){
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT OPER_STN_ID FROM AM_USER_FOR_OPER_STN ");
		queryBuilder.append("WHERE FACILITY_ID = ? AND APPL_USER_ID = ? AND ");
		queryBuilder.append("TRUNC(SYSDATE) BETWEEN EFF_DATE_FROM AND NVL(EFF_DATE_TO,TRUNC(SYSDATE))");
		
		return queryBuilder.toString();
	}
	

	/**
	 * this method binds data to the prepared statement
	 * @param prepStmt
	 * @param request
	 * @throws SQLException
	 */
	private void setDataInPSForOSRetrieval(PreparedStatement prepStmt,
			OsRetrieveRequest request) throws SQLException {
		int index = 1;
		
		String facilityId = request.getFacilityId();
		prepStmt.setString(index, facilityId);
		index++;
		
		String userId = request.getUserId();
		prepStmt.setString(index, userId);
		
	}
	
	
}
