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
package portalrefimpl.schedule.createappointment.appointmentrequest.handler;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.MessageFormat;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.ScheduleConstants;
import portalrefimpl.schedule.common.request.AppointmentRequest;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.createappointment.request.BookAppointmentRequest;
import portalrefimpl.schedule.createappointment.request.ExecutionStatus;
import portalrefimpl.schedule.createappointment.response.AppointmentResponse;
import portalrefimpl.schedule.createappointment.response.BookAppointmentResponse;

/**
 * This is the AppointmentHandler implementation for book appointment
 * functionality This class will take care of inserting appointment request
 * records into the database This class extends BaseAppointmentHandlerImpl class
 * and implements AppointmentHandler interface
 * 
 * @author GRamamoorthy
 * 
 */
public class BookAppointmentHandlerImpl extends BaseAppointmentHandlerImpl
		implements AppointmentHandler {

	/**
	 * This method inserts the appointment details into the PR_WAIT_LIST table
	 * The appointment request is basically a wait list in EM
	 */
	public AppointmentResponse performOperation(AppointmentRequest appointmentRequest) {
		// initialize the response
		BookAppointmentResponse appointmentResponse = new BookAppointmentResponse();

		// first check for the duplicate record
		//BaseResponse duplicateRecordResponse = checkDuplicateRecord(appointmentRequest);
		// if there is a failure, then return the response
		/*if(!duplicateRecordResponse.isSuccessful()){
			appointmentResponse.addAllErrors(duplicateRecordResponse.getErrors());
			return appointmentResponse;
		}*/
		
		
		/*ErrorInfo errorInfo = duplicateRecordResponse.getErrorInfo();
		if (ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()) {
			appointmentResponse.setErrorInfo(errorInfo);
			System.out.println("Duplicate record already exists - so terminating program");
			return appointmentResponse;
		}
		appointmentResponse.setErrorInfo(errorInfo);*/
		// safely cast the appointment request object to the book appointment request object
		BookAppointmentRequest bookAppointmentRequest = (BookAppointmentRequest) appointmentRequest;
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// duplicate check is fine - so proceed with insert of record
		Connection conn = PortalHelper.getConnection();
		if (conn == null) {
			errorCode = CommonConstants.DBCONNECTION_FAILURE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			appointmentResponse.addError(errorInfo);
			return appointmentResponse;
		}
		// check if the request has timed out and then return the response
		/*if(bookAppointmentRequest.isAbort()){
			errorCode = CreateAppointmentConstants.BOOKAPPOINTMENT_ABORT_INSERT_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			appointmentResponse.addError(errorInfo);
			return appointmentResponse;
		}*/
		
		String sqlQuery = getInsertAppointmentQuery();
		CallableStatement callStmt = null;
		String waitListNumberStr = null;
		String procExecuteMessage = null;
		final int PROCEDURE_EXEC_MESSAGE_INDEX = 24;
		final int WAIT_LIST_NUMBER_INDEX = 25;
		try {
			//conn.setAutoCommit(false);
			callStmt = conn.prepareCall(sqlQuery);
			// get the wait list sequence number
			//waitListNumberStr = getWaitListNumber(conn);
			
			setDataInPrepStatement(conn, callStmt, bookAppointmentRequest);
			int insertedRowCount = callStmt.executeUpdate();
			// one record is inserted so the row count should also be 1
			// if not it signifies error
			if(insertedRowCount == 1){
				// last check if request has timed out at the BC class level
				// if so, then we should not go ahead with commit - do rollback
				/*if(bookAppointmentRequest.isAbort()){
					conn.rollback();
					errorCode = CreateAppointmentConstants.BOOKAPPOINTMENT_ABORT_INSERT_ERRORCODE;
					errorMessage = MessageContainer.getInstance().getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME, errorCode);
					errorInfo = new ErrorInfo();
					errorInfo.setErrorCode(errorCode);
					errorInfo.setErrorMessage(errorMessage);
					appointmentResponse.addError(errorInfo);
					return appointmentResponse;
				}*/
				// now commit the changes
				//conn.commit();
				
				// wait list number
				waitListNumberStr = callStmt.getString(WAIT_LIST_NUMBER_INDEX);
				
				// now set positive response
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
				appointmentResponse.addError(errorInfo);
				// set the reference number as well
				appointmentResponse.setWaitListNumber(waitListNumberStr);
			}else{
				procExecuteMessage = callStmt.getString(PROCEDURE_EXEC_MESSAGE_INDEX);
				System.out.println("Error in inserting appointment request record. Error Message = "+procExecuteMessage);
				// insert failed
				errorCode = CreateAppointmentConstants.BOOKAPPOINTMENT_INSERT_ROW_ERRORCODE;
				errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(
								CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
								errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				appointmentResponse.addError(errorInfo);
			}
			// also set the state that commit is performed in the request object
			bookAppointmentRequest.setExecutionStatus(ExecutionStatus.COMPLETED);
		} catch (SQLException e) {
			//e.printStackTrace();
			errorCode = CreateAppointmentConstants.BOOKAPPOINTMENT_INSERT_ROW_SQLEXCEPTION_ERRORCODE;
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			String resourceMessage = MessageContainer.getInstance()
					.getResourceMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			resourceMessage = MessageFormat.format(resourceMessage, new Object[]{e.getMessage()});
			/*System.out.println(resourceMessage);*/
			/*try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}*/
			
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			appointmentResponse.addError(errorInfo);
			
		}finally{
			PortalHelper.closeResources(conn, callStmt);
		}
		
		/*errorInfo.setErrorCode(errorCode);
		errorInfo.setErrorMessage(errorMessage);*/

		return appointmentResponse;
	}

	/**
	 * This method forms and returns the SQL query required for inserting
	 * appointment records
	 * 
	 * @return
	 */
	private String getInsertAppointmentQuery() {
		StringBuffer queryBuffer = new StringBuffer();
		/*queryBuffer.append("Insert into PR_WAIT_LIST (");
		queryBuffer.append("FACILITY_ID,WAIT_LIST_NO,PREFERRED_DATE_TIME,");
		queryBuffer
				.append("WAIT_LIST_PRIORITY,SPECIALTY_CODE,CARE_LOCN_TYPE_IND,");
		queryBuffer.append("LOCN_CODE,RESOURCE_CLASS,RESOURCE_ID,PATIENT_ID,");
		queryBuffer.append("GENDER,CITIZEN_YN,LEGAL_YN,WAIT_LIST_STATUS,");
		queryBuffer
				.append("ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,");
		queryBuffer
				.append("MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,");
		queryBuffer
				.append("CANCELLED_WHEN_DEATH_YN,WEB_REQ_YN,PREF_FROM_TIME,PREF_TO_TIME");
		queryBuffer.append(" ) values ( ");
		queryBuffer
				.append("?,?,to_date(?,'DD/MM/YYYY'),?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,to_date(?,'DD/MM/YYYY HH24:mi'),to_date(?,'DD/MM/YYYY HH24:mi')");
		queryBuffer.append(" ) ");*/
		
		queryBuffer.append("{call PR_INSERT_WEBREQ_WAIT_LIST(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

		return queryBuffer.toString();
	}

	/**
	 * This method reads data from the request object and sets data in the
	 * prepared statement
	 * @param callStmt
	 * @param bookAppointmentRequest
	 * @throws SQLException
	 */
	private void setDataInPrepStatement(Connection conn,
			CallableStatement callStmt,
			BookAppointmentRequest bookAppointmentRequest) throws SQLException {
		int index = 1;

		// facility id
		String facilityId = bookAppointmentRequest.getFacilityId();
		callStmt.setString(index, facilityId);
		index++;

		// wait list number
		//waitListNumberStr = getWaitListNumber(conn);
		/*prepStmt.setString(index, waitListNumberStr);
		index++;*/

		// preferred date time
		String preferredDate = bookAppointmentRequest.getPreferredDate();
		callStmt.setString(index, preferredDate);
		index++;

		// wait list priority - N for portal
		callStmt.setString(index,
				CreateAppointmentConstants.APPOINTMENT_WAIT_LIST_PRIORITY_VALUE);
		index++;

		// speciality code
		String specialityCode = bookAppointmentRequest.getSpecialityId();
		callStmt.setString(index, specialityCode);
		index++;

		// location code
		String locationCode = bookAppointmentRequest.getLocationCode();
		if(locationCode == null){
			locationCode = "";
		}
		callStmt.setString(index, locationCode);
		index++;

		// resource class - it will always be "P" indicating practitioner
		callStmt.setString(
				index,
				CreateAppointmentConstants.PRACTITIONER_SERVICE_RESOURCECLASS_DEFAULT_VALUE);
		index++;

		// resource id - practitioner id
		String practitionerId = bookAppointmentRequest.getPractitionerId();
		callStmt.setString(index, practitionerId);
		index++;

		// patient id
		String patientId = bookAppointmentRequest.getPatientId();
		callStmt.setString(index, patientId);
		index++;

		String[] patientDetails = getPatientDetails(conn, patientId);
		// Gender - sex
		String gender = patientDetails[PATIENT_GENDER_INDEX];
		callStmt.setString(index, gender);
		index++;

		// citizen yn
		String citizenYn = patientDetails[PATIENT_CITIZEN_YN_INDEX];
		callStmt.setString(index, citizenYn);
		index++;

		// legal yn
		String legalYn = patientDetails[PATIENT_LEGAL_YN_INDEX];
		callStmt.setString(index, legalYn);
		index++;

		// wait list status
		callStmt.setString(index,
				CreateAppointmentConstants.APPOINTMENT_WAITLIST_STATUS_VALUE);
		index++;

		// added by id
		callStmt.setString(index,
				ScheduleConstants.APPOINTMENT_PORTAL_USER_ID);
		index++;

		// added work station number
		callStmt.setString(index,
				ScheduleConstants.APPOINTMENT_PORTAL_SYSTEM_VALUE);
		index++;

		// added facility id
		callStmt.setString(index, facilityId);
		index++;

		// modified id
		callStmt.setString(index,
				ScheduleConstants.APPOINTMENT_PORTAL_USER_ID);
		index++;

		// modified work station number
		callStmt.setString(index,
				ScheduleConstants.APPOINTMENT_PORTAL_SYSTEM_VALUE);
		index++;

		// modified facility id
		callStmt.setString(index, facilityId);
		index++;

		// care location type indicator - C for portal
		callStmt.setString(
				index,
				CreateAppointmentConstants.APPOINTMENT_CARE_LOCATION_TYPE_INDICATOR_VALUE);
		index++;
		
		// cancelled when death yn
		callStmt.setString(
				index,
				CreateAppointmentConstants.APPOINTMENT_CANCELLED_WHEN_DEATH_YN_VALUE);
		index++;

		// WEB_REQ_YN
		callStmt.setString(
				index,
				CreateAppointmentConstants.APPOINTMENT_WEBREQUEST_PARAM_VALUE);
		index++;

		// PREF_FROM_TIME
		// preferred from time will be in the format HH:MM
		String preferredFromTime = bookAppointmentRequest.getPreferredFromTime();
		//preferredFromTime = preferredDate + " " + preferredFromTime;
		callStmt.setString(index, preferredFromTime);
		index++;
		
		// PREF_TO_TIME
		// preferred to time will be in the format HH:MM
		String preferredToTime = bookAppointmentRequest.getPreferredToTime();
		//preferredToTime = preferredDate + " " + preferredToTime;
		callStmt.setString(index, preferredToTime);
		index++;
		
		callStmt.registerOutParameter(index, Types.VARCHAR);
		index++;
		
		callStmt.registerOutParameter(index, Types.VARCHAR);
		
		
	}

	/**
	 * This method gets the wait list sequence number to be used for inserting
	 * records into the pr wait list table
	 * 
	 * @return
	 */
	/*private String getWaitListNumber(Connection conn) throws SQLException {
		// long waitListNumber = -1;
		String sqlQuery = "SELECT PR_WAIT_LIST_NO_SEQ.NEXTVAL FROM DUAL";
		Statement stmt = null;
		Object waitListNumberObj = null;
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sqlQuery);
		if (rs != null && rs.next()) {
			waitListNumberObj = rs.getObject(1);
		}

		String waitListNumber = waitListNumberObj.toString();
		//System.out.println(waitListNumber);
		return waitListNumber;
	}
*/
	/**
	 * 
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	private String[] getPatientDetails(Connection conn, String patientId)
			throws SQLException {
		String[] patientDetails = new String[PATIENT_DETAILS_ELEMENTS];

		String sqlQuery = "select sex,citizen_yn,legal_yn from mp_patient where patient_id = ?";
		PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);
		prepStmt.setString(1, patientId);
		ResultSet rs = prepStmt.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				patientDetails[PATIENT_GENDER_INDEX] = rs.getString(1);
				patientDetails[PATIENT_CITIZEN_YN_INDEX] = rs.getString(2);
				patientDetails[PATIENT_LEGAL_YN_INDEX] = rs.getString(3);
			}
		}

		return patientDetails;
	}
	
	/*private BookAppointmentRequest getBookAppointmentRequest(){
		BookAppointmentRequest bookAppointmentRequest = new BookAppointmentRequest();
		bookAppointmentRequest.setFacilityId("HS");
		bookAppointmentRequest.setPatientId("HC00007128");
		bookAppointmentRequest.setPractitionerId("AZAMUDDIN");
		bookAppointmentRequest.setLocationCode("AC45");
		bookAppointmentRequest.setSpecialityId("22");
		bookAppointmentRequest.setPreferredDate("11/06/2013");
		bookAppointmentRequest.setPreferredFromTime("11/06/2013 11:30");
		bookAppointmentRequest.setPreferredToTime("11/06/2013 12:30");
		
		return bookAppointmentRequest;
	}

	public static void main(String[] args) {
		BookAppointmentHandlerImpl impl = new BookAppointmentHandlerImpl();
		Connection conn = PortalHelper.getConnection();
		String patientId = "HC00007128";
		BookAppointmentRequest bookAppointmentRequest = impl.getBookAppointmentRequest();
		BookAppointmentResponse bookAppointmentResponse = null;
		try {
			// impl.getWaitListNumber(conn);
			String[] patientDetails = impl.getPatientDetails(conn, patientId);
			System.out.println(patientDetails.length + ";"
					+ patientDetails[PATIENT_GENDER_INDEX] + ":"
					+ patientDetails[PATIENT_CITIZEN_YN_INDEX] + ":"
					+ patientDetails[PATIENT_LEGAL_YN_INDEX] + ":");
			bookAppointmentResponse = (BookAppointmentResponse) impl
					.performOperation(bookAppointmentRequest);
			System.out.println(bookAppointmentResponse.isSuccessful()+" || "+bookAppointmentResponse.getErrorMessage());
			System.out.println("error code from response="+bookAppointmentResponse.getErrorInfo().getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	

}
