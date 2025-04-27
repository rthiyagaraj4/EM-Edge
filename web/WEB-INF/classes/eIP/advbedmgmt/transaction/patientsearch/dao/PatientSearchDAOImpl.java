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
package eIP.advbedmgmt.transaction.patientsearch.dao;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Types;
import java.text.MessageFormat;

import org.apache.log4j.Logger;

import webbeans.eCommon.ConnectionManager;
import eIP.advbedmgmt.GBMConstants;
import eIP.advbedmgmt.common.CommonResourceConstants;
import eIP.advbedmgmt.common.ErrorConstants;
import eIP.advbedmgmt.common.PatientStatusConstants;
import eIP.advbedmgmt.common.PatientStatusEvaluator;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;
import eIP.advbedmgmt.common.response.ErrorInfo;
import eIP.advbedmgmt.transaction.patientsearch.PatientSearchConstants;
import eIP.advbedmgmt.transaction.patientsearch.PatientSearchResourceConstants;
import eIP.advbedmgmt.transaction.patientsearch.request.PatientSearchRequest;
import eIP.advbedmgmt.transaction.patientsearch.response.PatientSearchResponse;
import eIP.advbedmgmt.transaction.patientsearch.response.PatientStatus;

/**
 * This is the DAO layer class for the patient search sub module This class
 * retrieves data from back end database based on the input request object
 * 
 * @author gramamoorthy
 * 
 */
public class PatientSearchDAOImpl implements PatientSearchDAO{

	/**
	 * This method retrieves data from back end database based on the input
	 * request object The input object is not validated in this method - it is
	 * assumed that this object contains the required data
	 * 
	 * @param request
	 * @return
	 */
	public PatientSearchResponse getPatientNursingUnit(
			PatientSearchRequest request) {
		// initialize the response object
		PatientSearchResponse response = new PatientSearchResponse();
		ErrorInfo errorInfo = new ErrorInfo();
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		response.setPatientStatus(PatientStatus.INVALID_ADMISSION);
		
		// initialize the logger
		Logger loggerInst = Logger.getLogger("APPLICATION_LOG");
		StringBuilder logMessage = new StringBuilder();
		
		/*final String bundleClassName = "eIP.resources.Messages";*/

		// patient id is set to the response
		String patientId = request.getPatientId();
		response.setPatientId(patientId);
		// get connection
		Connection conn = getConnection();// ConnectionManager.getConnection();
		// safe handling
		if (conn == null) {
			errorCode = ErrorInfo.DATABASE_CONNECTION_FAILURE_CODE;
			// logging done here
			logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(":");
			logMessage.append("Could not get nursing unit for patient (id = "
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
			
			// code written to get the specific message for this
			// operation and then add it to the original message
			String specificErrorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							PatientSearchResourceConstants.DISPLAYMESSAGE_CONNECTION_FAILURE_KEY,
							PatientSearchResourceConstants.PATIENT_SEARCH_RESOURCE_MESSAGES_FILE_PATH);
			
			
			errorMessage = MessageFormat.format(errorMessage, new Object[]{specificErrorMessage});
			// form the error info object and set it to response
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
			return response;
		}

		String sqlQuery = getPatientSearchSQLQuery(request);
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			setDataInPreparedStatement(prepStmt, request);
			rs = prepStmt.executeQuery();
			// safe check
			if (rs == null) {
				errorCode = ErrorConstants.PATIENT_SEARCH_NULL_RESULTSET_ERROR_CODE;// PatientSearchConstants.PATIENT_SEARCH_NULL_RESULTSET_ERROR_CODE;
				// logging done here
				logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(
						":");
				logMessage.append("Could not get nursing unit for patient ")
						.append(patientId)
						.append(" . Cause = Null result set. ");
				if (loggerInst != null) {
					loggerInst.fatal(logMessage.toString());
				}

				// obtain the error message
				errorMessage = BundleManager
						.getInstance()
						.getDisplayMessageFromBundle(
								errorCode,
								PatientSearchResourceConstants.PATIENT_SEARCH_RESOURCE_MESSAGES_FILE_PATH);
				
				errorMessage = MessageFormat.format(errorMessage,
						new Object[] { patientId });
				errorInfo = new ErrorInfo(errorCode, errorMessage);
				response.addError(errorInfo);
				return response;
			}
			// call the method to set data to response
			setDataToResponse(conn,rs, response,request);

		} catch (SQLException e) {
			// logging done here
			logMessage.append(GBMConstants.GBM_MODULE_IDENTIFIER).append(":");
			logMessage.append("Could not get nursing unit for patient ")
					.append(patientId)
					.append(" . Cause = SQLException. Exception message = ")
					.append(e.getMessage());
			if (loggerInst != null) {
				loggerInst.fatal(logMessage.toString());
			}

			// error info initialization
			errorCode = ErrorConstants.PATIENT_SEARCH_SQLEXCEPTION_ERROR_CODE;// PatientSearchConstants.PATIENT_SEARCH_SQLEXCEPTION_ERROR_CODE;
			// obtain the error message
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							PatientSearchResourceConstants.PATIENT_SEARCH_RESOURCE_MESSAGES_FILE_PATH);
			errorMessage = MessageFormat.format(errorMessage, new Object[] {
					patientId, e.getMessage() });
			// add error info to response
			errorInfo = new ErrorInfo(errorCode, errorMessage);
			response.addError(errorInfo);
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
				ConnectionManager.returnConnection(conn);
			}
		}

		return response;
	}

	/**
	 * This method gets the connection
	 * 
	 * @return
	 */
	private Connection getConnection() {
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		
		return conn;
	}

	/**
	 * This method gets the SQL query for the patient search sub module
	 * 
	 * @param request
	 * @return
	 */
	private String getPatientSearchSQLQuery(PatientSearchRequest request) {
		StringBuffer queryBuff = new StringBuffer();
		// this SQL query does not consider disabled nursing units
		queryBuff.append("select a.adt_status,b.NURSING_UNIT_CODE,a.ENCOUNTER_ID,a.ROOM_NUM,a.BED_NUM ");
		queryBuff.append("from ip_open_encounter a, IP_NURSING_UNIT b "); 
		queryBuff.append("where a.patient_id = ?  and ");
		queryBuff.append("a.facility_id=? and ");
		queryBuff.append("a.facility_id = b.facility_id and ");
		queryBuff.append("a.NURSING_UNIT_CODE = b.NURSING_UNIT_CODE and ");
		queryBuff.append("b.eff_status=? ");

		return queryBuff.toString();
	}

	/**
	 * This method sets data to the prepared statement object before it is
	 * executed
	 * 
	 * @param request
	 * @throws SQLException
	 */
	private void setDataInPreparedStatement(PreparedStatement prepStmt,
			PatientSearchRequest request) throws SQLException {
		int index = 1;
		// set patient id first followed by facility id and enabled status
		String patientId = request.getPatientId();
		prepStmt.setString(index, patientId);
		index++;

		String facilityId = request.getFacilityId();
		prepStmt.setString(index, facilityId);
		index++;
		
		prepStmt.setString(index, PatientSearchConstants.ENABLED_NURSING_UNIT_KEY);
	}

	/**
	 * This method sets data to the response object
	 * @param conn
	 * @param rs
	 * @param response
	 */
	private void setDataToResponse(Connection conn, ResultSet rs,
			PatientSearchResponse response, PatientSearchRequest request)
			/*String bundleClassName)*/
			throws SQLException {
		// flag used to detect if data is obtained from result set
		// used to set error info object in the response
		boolean dataObtained = false;
		String admittedStatus = null;
		String nursingUnitCode = null;
		String roomNumber = null;
		String bedNumber = null;
		String encounterId = null;
		// we need to read only one record from result set - hence if condition
		// is good
		if (rs.next()) {
			admittedStatus = rs
					.getString(PatientSearchConstants.ADMITTED_STATUS_KEYWORD);
			nursingUnitCode = rs
					.getString(PatientSearchConstants.NURSING_UNIT_KEYWORD);
			// the admitted status has to have a value "01" - if so, then data
			// is obtained
			if (PatientStatusConstants.ADMITTED_STATUS_DEFAULT_VALUE
					.equals(admittedStatus)
					|| PatientStatusConstants.ADMISSION_INITIATED_STATUS_DEFAULT_VALUE
							.equals(admittedStatus)) {
				response.setNursingUnitCode(nursingUnitCode);
				dataObtained = true;
			} 
			
			// room number and bed number
			roomNumber = rs.getString(PatientSearchConstants.ROOM_NUMBER_KEYWORD);
			if(roomNumber == null){
				roomNumber = "";
			}
			
			bedNumber = rs.getString(PatientSearchConstants.BED_NUMBER_KEYWORD);
			if(bedNumber == null){
				bedNumber = "";
			}
			response.setRoomNumber(roomNumber);
			response.setBedNumber(bedNumber);
			
			encounterId = rs.getString(PatientSearchConstants.ENCOUNTERID_KEYWORD);
			if(encounterId == null){
				encounterId = "";
			}
			response.setEncounterId(encounterId);
		
		}

		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// data is obtained - still check if different patient statuses are obtained
		// fine
		if (!dataObtained) {
			// code to call the stored procedure which will get all the status
			dataObtained = checkPatientStatus(conn, response, request);
		}
		// still if data is not obtained then set suitable error code
		if (!dataObtained) {
			errorCode = ErrorConstants.PATIENT_SEARCH_DATA_NOT_OBTAINED_ERROR_CODE;// PatientSearchConstants.PATIENT_SEARCH_DATA_NOT_OBTAINED_ERROR_CODE;
			
			errorMessage = BundleManager
					.getInstance()
					.getDisplayMessageFromBundle(
							errorCode,
							PatientSearchResourceConstants.PATIENT_SEARCH_RESOURCE_MESSAGES_FILE_PATH);
			errorMessage = MessageFormat.format(errorMessage,
					new Object[] { response.getPatientId() });
		}else{
			// successful operation- set the patient status
			response.setPatientStatus(PatientStatus.VALID_ADMISSION);
		}
		
		ErrorInfo errorInfo = new ErrorInfo(errorCode, errorMessage);
		response.addError(errorInfo);

	}
	
	/**
	 * This method gets the different status of the patient
	 * and then checks if the patient has a valid admission
	 * The patient related data is already available in the request
	 * and response object
	 * Hence this method uses the response object to get the data
	 * 
	 * @param conn
	 * @return
	 */
	private boolean checkPatientStatus(Connection conn,
			PatientSearchResponse response, PatientSearchRequest request) {
		boolean statusObtained = false;
		
		// method vars
		CallableStatement callStmt = null;
		// facility is obtained from request
		// nursing unit from response
		String facilityId = request.getFacilityId();
		String nursingUnitCode = response.getNursingUnitCode();
		String encounterId = response.getEncounterId();
		String bedNumber = response.getBedNumber();
		
		final int ERROR_MSG_INDEX = 6;
		final int OP_INDEX = 5;
		
		final int OP_INDEX_POSITION = 1;
		final int OP_COUNT_POSITION = 1;
		
		Object dataValue = null;
		Object structObj = null;
		Struct structValue = null;
		Object[] structAttributes = null;
		
		final String OUTPUT_DBOBJ_NAME = "GBM_OUTPUT_BED_STATUSES_TAB";
		
		String spCallStmt = "{call GBM_GET_PATIENT_STATUS_PKG.GBM_GET_PATIENT_STATUS(?,?,?,?,?,?)}";
		try {
			callStmt = conn.prepareCall(spCallStmt);
			// setting the callable statement with data
			int index = 1;
			callStmt.setString(index, facilityId);
			index++;
			callStmt.setString(index, nursingUnitCode);
			index++;
			callStmt.setString(index, encounterId);
			index++;
			callStmt.setString(index, bedNumber);
			index++;
			callStmt.registerOutParameter(index, Types.ARRAY,
					OUTPUT_DBOBJ_NAME);
			index++;
			callStmt.registerOutParameter(index, Types.VARCHAR);
			
			callStmt.execute();
			// get the error message obtained during execution
			// if it is having value - return false
			String errorMessage = callStmt.getString(ERROR_MSG_INDEX);
			if(errorMessage != null && !errorMessage.trim().equals("")){
				return statusObtained;
			}
			
			// obtain the output data from the SP
			Object dataObj = callStmt.getObject(OP_INDEX);
			Array arrayObj = null;
			// need to check if the dataObj is an instance of Array
			// process only if it is Array instance
			if(dataObj instanceof Array){
				arrayObj = (Array) dataObj;
				// no need to check arrayObj for null
				dataValue = arrayObj.getArray(
						OP_INDEX_POSITION, OP_COUNT_POSITION);
				// safe check
				if(dataValue == null){
					return statusObtained;
				}		
				// data value has to an object[] with the Struct being the 
				// object at the first index
				if(dataValue instanceof Object[]){
					structObj = ((Object[])dataValue)[0];
					if(structObj instanceof Struct){
						structValue = (Struct)structObj;
						// now decipher the values stored in struct
						structAttributes = structValue.getAttributes();
						statusObtained = PatientStatusEvaluator
								.evaluateStructAttributes(structAttributes);
					}
				}
			}
			
		} catch (Exception e) {
			// cannot do much
			System.out.println(e.getMessage());
		}finally{
			if(callStmt != null){
				try {
					callStmt.close();
				} catch (SQLException e) {
					// cannot do much
				}
			}
		}
		
		return statusObtained;
	}
	
}
