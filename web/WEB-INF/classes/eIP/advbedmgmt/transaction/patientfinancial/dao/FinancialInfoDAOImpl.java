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
package eIP.advbedmgmt.transaction.patientfinancial.dao;

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
import eIP.advbedmgmt.transaction.patientfinancial.FinancialInfoConstants;
import eIP.advbedmgmt.transaction.patientfinancial.FinancialInfoResourceConstants;
import eIP.advbedmgmt.transaction.patientfinancial.request.FinancialInfoRequest;
import eIP.advbedmgmt.transaction.patientfinancial.response.FinancialInfoResponse;

/**
 * This is the DAO class for getting meta data needed for obtaining patient
 * financial information
 * 
 * @author GRamamoorthy
 * 
 */
public class FinancialInfoDAOImpl implements FinancialInfoDAO {

	/**
	 * This method gets meta data needed for obtaining patient financial
	 * information
	 * 
	 * @param request
	 * @return
	 */
	public FinancialInfoResponse getPatientFinancialInfo(
			FinancialInfoRequest request) {
		// initialize the response class
		FinancialInfoResponse response = new FinancialInfoResponse();
		ErrorInfo errorInfo = null;// new ErrorInfo();
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;

		// initialize the logger
		Logger loggerInst = Logger.getLogger("APPLICATION_LOG");
		StringBuilder logMessage = new StringBuilder();
		
		/*final String bundleClassName = "eIP.resources.Messages";*/

		// there is no need to validate the request object here
		// get data from the request object
		String patientId = request.getPatientId();
		// initially only set patient id and encounter id from
		// request to response
		response.setPatientId(patientId);
		response.setEncounterId(request.getEncounterId());
		
		// get connection
		Connection conn = getConnection();
		// safe check
		if (conn == null) {
			errorCode = ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE;
			// logging done here
			logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(":");
			logMessage
					.append("Could not get encounter visit number for patient "
							+ patientId
							+ " ). Cause = Could not get connection to database");
			if (loggerInst != null) {
				loggerInst.fatal(logMessage.toString());
			}

			// get the error message from resource bundle through bundle manager
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE,
							CommonResourceConstants.COMMON_RESOURCES_FILE_CLASSPATH);
			
			/*errorMessage = BundleManager
					.getInstance()
					.getMessageFromResourceBundle(
							"DisplayMessage.Common.DatabaseConnectionFailure",
							bundleClassName);*/
			
			// code written to get the specific message for this
			// operation and then add it to the original message
			String specificErrorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							FinancialInfoResourceConstants.DISPLAYMESSAGE_CONNECTION_FAILURE_KEY,
							FinancialInfoResourceConstants.FINANCIAL_INFO_RESOURCE_MESSAGES_FILE_PATH);
			
			/*String specificErrorMessage = BundleManager
					.getInstance()
					.getMessageFromResourceBundle(
							"DisplayMessage.PatientFinancial.ConnectionFailureErrorMessage",
							bundleClassName);*/
			
			errorMessage = MessageFormat.format(errorMessage, new Object[]{specificErrorMessage});
			// form the error info object and set it to response
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			return response;
		}

		// get the sql query
		String sqlQuery = getSQLQuery(request);
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			setDataInPreparedStatement(prepStmt, request);
			rs = prepStmt.executeQuery();
			// safe check
			if(rs == null){
				// logging done here
				logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(":");
				logMessage.append("Could not get encounter visit number for patient ")
						.append(patientId)
						.append(" . Cause = Null Resultset");
				if (loggerInst != null) {
					loggerInst.fatal(logMessage.toString());
				}

				// error info initialization
				errorCode = ErrorConstants.FINANCIAL_INFO_NULL_RESULTSET_ERRORCODE;// FinancialInfoConstants.NULL_RESULTSET_ERRORCODE;
				// obtain the error message
				/*errorMessage = BundleManager
						.getInstance()
						.getMessageFromResourceBundle(
								"DisplayMessage.PatientFinancial.NullResultsetErrorMessage",
								bundleClassName);*/
				
				errorMessage = BundleManager
						.getInstance()
						.getDisplayMessageFromBundle(
								errorCode,
								FinancialInfoResourceConstants.FINANCIAL_INFO_RESOURCE_MESSAGES_FILE_PATH);
				// add error info to response
				errorInfo = new ErrorInfo(errorCode, errorMessage);
				response.addError(errorInfo);
				return response;
			}
			
			String encounterVisitNum = null;
			// evaluate the result set and set data to response
			if(rs.next()){
				// get the encounter visit num value and set it to response
				encounterVisitNum = rs.getString(FinancialInfoConstants.ENCOUNTER_VISIT_NUM_KEY);
			}
			// code modified to consider encounter visit num as empty
			// if the value is not obtained from back end
			if(encounterVisitNum == null){
				encounterVisitNum = "";
			}
			response.setEncounterVisitNum(encounterVisitNum);
			// set success error info to response
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			
			// the else loop was originally coded to raise an error when
			// encounter visit num is not obtained
			// however existing EM implementation passes empty
			// encounter visit num to show patient financials
			/*else{
				// implies visit num is not obtained - set error in response
				// logging done here
				logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(":");
				logMessage.append("Could not get encounter visit number for patient ")
						.append(patientId)
						.append(" . Cause = No data");
				if (loggerInst != null) {
					loggerInst.fatal(logMessage.toString());
				}

				// error info initialization
				errorCode = FinancialInfoConstants.NO_DATA_ERRORCODE;
				// obtain the error message
				errorMessage = BundleManager
						.getInstance()
						.getDisplayMessageFromBundle(
								errorCode,
								FinancialInfoResourceConstants.FINANCIAL_INFO_RESOURCE_MESSAGES_FILE_PATH);
				// add error info to response
				errorInfo = new ErrorInfo(errorCode, errorMessage);
				response.addError(errorInfo);
			}*/
			
		} catch (SQLException e) {
			// logging done here
			logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(":");
			logMessage.append("Could not get encounter visit number for patient ")
					.append(patientId)
					.append(" . Cause = SQLException. Exception message = ")
					.append(e.getMessage());
			if (loggerInst != null) {
				loggerInst.fatal(logMessage.toString());
			}

			// error info initialization
			errorCode = ErrorConstants.FINANCIAL_INFO_SQLEXCEPTION_ERRORCODE;// FinancialInfoConstants.SQLEXCEPTION_ERRORCODE;
			// obtain the error message
			/*errorMessage = BundleManager
					.getInstance()
					.getMessageFromResourceBundle(
							"DisplayMessage.PatientFinancial.SQLExceptionErrorMessage",
							bundleClassName);*/
			
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							FinancialInfoResourceConstants.FINANCIAL_INFO_RESOURCE_MESSAGES_FILE_PATH);
			errorMessage = MessageFormat.format(errorMessage, new Object[] {
					patientId, e.getMessage() });
			// add error info to response
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
		} finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// nothing much can be done
				}
			}
			if(prepStmt != null){
				try {
					prepStmt.close();
				} catch (SQLException e) {
					// nothing much can be done
				}
			}
			
			if(conn != null){
				ConnectionManager.returnConnection(conn);
				//conn = null;
			}
		}

		return response;
	}

	/**
	 * This method retrieves the SQL query to get the financial info
	 * 
	 * @param request
	 * @return
	 */
	private String getSQLQuery(FinancialInfoRequest request) {
		StringBuffer queryBuff = new StringBuffer();
		queryBuff.append("select OP_EPISODE_VISIT_NUM from PR_ENCOUNTER ");
		queryBuff
				.append("where facility_id = ? and patient_id = ? and encounter_id = ? ");

		return queryBuff.toString();
	}

	/**
	 * This method sets data into the prepared statement object this is needed
	 * before the prepared statement is executed
	 * 
	 * @param prepStmt
	 * @param request
	 */
	private void setDataInPreparedStatement(PreparedStatement prepStmt,
			FinancialInfoRequest request) throws SQLException {
		int index = 1;
		// get data from request and set it to prepared statement
		// also no need to validate the data from request

		// first it is facility id
		String facilityId = request.getFacilityId();
		prepStmt.setString(index, facilityId);
		index++;

		// next patient id
		String patientId = request.getPatientId();
		prepStmt.setString(index, patientId);
		index++;

		// last encounter id
		String encounterId = request.getEncounterId();
		prepStmt.setString(index, encounterId);
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
			System.out.println("successful in getting connection");
		} catch (SQLException e) {
			System.out.println("Could not get connection - program terminates");
		}*/

		return conn;
	}

}
