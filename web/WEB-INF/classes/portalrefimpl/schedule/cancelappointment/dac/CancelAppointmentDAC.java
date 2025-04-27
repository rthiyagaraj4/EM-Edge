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
package portalrefimpl.schedule.cancelappointment.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.ScheduleConstants;
import portalrefimpl.schedule.cancelappointment.request.CancelAppointmentRequest;
import portalrefimpl.schedule.cancelappointment.response.CancelAppointmentResponse;
import portalrefimpl.schedule.common.request.AppointmentType;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;

/**
 * This class is the DAC layer class for cancel appointment service
 * 
 * @author gramamoorthy
 *
 */
public class CancelAppointmentDAC {

	/**
	 * This method cancels an appointment represented in the
	 * cancel appointment request object
	 * This method will in turn execute a logic specifically
	 * for appointment booked in EM and for appointment request
	 * booked in portal
	 * @param cancelAppointmentRequest
	 * @return
	 */
	public CancelAppointmentResponse cancelAppointment(
			CancelAppointmentRequest cancelAppointmentRequest) {
		CancelAppointmentResponse cancelAppointmentResponse = new CancelAppointmentResponse();
		// code to execute depends on the appointment type set
		// in the request
		AppointmentType appointmentType = cancelAppointmentRequest
				.getAppointmentType();
		if(AppointmentType.Appointment == appointmentType){
			cancelAppointmentResponse = cancelEMAppointment(cancelAppointmentRequest);
		}else if(AppointmentType.Appointment_Request == appointmentType){
			cancelAppointmentResponse = cancelPortalAppointmentRequest(cancelAppointmentRequest);
		}
		
		return cancelAppointmentResponse;
	}
	
	/**
	 * This method cancels an appointment booked in EM
	 * @param cancelAppointmentRequest
	 * @return
	 */
	private CancelAppointmentResponse cancelEMAppointment(
			CancelAppointmentRequest cancelAppointmentRequest) {
		CancelAppointmentResponse cancelAppointmentResponse = new CancelAppointmentResponse();
		// get the values list - this will be given to the EJB
		List<Map<String, String>> valuesList = getValuesList(cancelAppointmentRequest);
		
		
		return cancelAppointmentResponse;
	}
	
	/**
	 * This method gets the values to be given to the appointment details EJB
	 * The values are obtained from the request object
	 * @param cancelAppointmentRequest
	 * @return
	 */
	private List<Map<String, String>> getValuesList(
			CancelAppointmentRequest cancelAppointmentRequest) {
		List<Map<String, String>> inputList = new ArrayList<Map<String,String>>();
		Map<String, String> dataMap = new HashMap<String, String>();
		String facilityId = cancelAppointmentRequest.getFacilityId();
		String apptRefNo = cancelAppointmentRequest.getAppointmentReferenceNumber();
		String visitIndicator = cancelAppointmentRequest.getVisitIndicator();
		String reasonForCancellation = cancelAppointmentRequest.getReasonForCancellation();
		String reasonForRevision = cancelAppointmentRequest.getReasonForRevision();
		String alcnCriteria = cancelAppointmentRequest.getAlcnCriteria();
		String patientCategory = cancelAppointmentRequest.getPatientCategory();
		String addedAtWorkStation = cancelAppointmentRequest.getAddedAtWorkStation();
		String forced = cancelAppointmentRequest.getForced();
		String referralValue = cancelAppointmentRequest.getReferralValue();
		String patientId = cancelAppointmentRequest.getPatientId();
		String episodeType = cancelAppointmentRequest.getEpisodeType();
		String apptDate = cancelAppointmentRequest.getAppointmentDate();
		String blOperational = cancelAppointmentRequest.getBlOperational();
		String captureFinanceDetailsYn = cancelAppointmentRequest.getCaptureFinancialDetailsYn();
		String sendEmailYn = cancelAppointmentRequest.getSendEmailYn();
		String operation = cancelAppointmentRequest.getOperation();
		
		
		dataMap.put("addedFacilityId",facilityId);
		dataMap.put("apptrefno",apptRefNo);
		dataMap.put("visitind",visitIndicator);
		dataMap.put("reasonforcancellation",reasonForCancellation);
		dataMap.put("reasonforrevision",reasonForRevision);
		dataMap.put("alcn_criteria",alcnCriteria);
		dataMap.put("pat_cat",patientCategory);
		dataMap.put("addedFacilityId",facilityId);
		dataMap.put("addedAtWorkstation",addedAtWorkStation);
		dataMap.put("Forced",forced);
		dataMap.put("referral_value",referralValue);
		dataMap.put("patientid",patientId);
		dataMap.put("episode_type",episodeType);
		dataMap.put("appt_date",apptDate);
		dataMap.put("bl_operational",blOperational);
		dataMap.put("capture_fin_dtls_yn",captureFinanceDetailsYn);
		dataMap.put("send_email_yn",sendEmailYn);
		dataMap.put("operation",operation);
		
		inputList.add(dataMap);
		
		return inputList;
	}
	
	
	/**
	 * This method performs the cancellation of an appointment
	 * request booked through Portal application
	 * @param cancelAppointmentRequest
	 * @return
	 */
	private CancelAppointmentResponse cancelPortalAppointmentRequest(
			CancelAppointmentRequest cancelAppointmentRequest) {
		// initialize the response
		CancelAppointmentResponse cancelAppointmentResponse = new CancelAppointmentResponse();
		ErrorInfo errorInfo = null;//new ErrorInfo();
		cancelAppointmentResponse.setErrorInfo(errorInfo);
		//errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// get the connection
		Connection connection = PortalHelper.getConnection(); 
		if(connection == null){
			errorCode = CommonConstants.DBCONNECTION_FAILURE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			cancelAppointmentResponse.addError(errorInfo);
			return cancelAppointmentResponse;
		}
		String apptRefNumber = cancelAppointmentRequest.getAppointmentReferenceNumber();
		// get the SQL query
		String query = getPortalAppointmentRequestCancellationQuery();
		PreparedStatement prepStmt = null;
		int resultCount = -1;
		// execute the query
		try {
			connection.setAutoCommit(false);
			prepStmt = connection.prepareStatement(query);
			setDataInPrepStmtForCancelApptRequest(prepStmt,
					cancelAppointmentRequest);
			resultCount = prepStmt.executeUpdate();
			// only one record should be updated - check it
			if(1 == resultCount){
				connection.commit();
				
			}else{
				// indicates failure
				errorCode = ScheduleConstants.CANCEL_APPTREQ_FAILURE_ERRORCODE;
				errorMessage = MessageContainer.getInstance().getDisplayMessage(
						CommonConstants.CANCEL_APPOINTMENT_MODULE_NAME, errorCode);
				errorMessage = MessageFormat.format(errorMessage,
						new Object[] { apptRefNumber });
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// cannot do much
					/*System.out.println(e1.getMessage());*/
				}
			}
		} catch (SQLException e) {
			/*// first rollback
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// cannot do much
				System.out.println(e1.getMessage());
			}*/
			// set the error info
			//e.printStackTrace();
			errorCode = ScheduleConstants.CANCEL_APPTREQ_SQLEXCEPTION_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.CANCEL_APPOINTMENT_MODULE_NAME, errorCode);
			errorMessage = MessageFormat.format(errorMessage,
					new Object[] { apptRefNumber });
		}finally{
			PortalHelper.closeResources(connection, prepStmt);
		}
		// set the error code and the error message to the error info object
		errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(errorCode);
		errorInfo.setErrorMessage(errorMessage);
		cancelAppointmentResponse.addError(errorInfo);
		
		return cancelAppointmentResponse;
	}
	
	/**
	 * This method returns the query needed for canceling
	 * an appointment request
	 * @return
	 */
	private String getPortalAppointmentRequestCancellationQuery(){
		StringBuffer queryBuffer = new StringBuffer();
		queryBuffer.append("update pr_wait_list set wait_list_status=?,reason_for_cancel=?,modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?,modified_facility_id=? where wait_list_no=? and web_req_yn = ? and patient_id = ?");
		return queryBuffer.toString();
	}
	
	/**
	 * This method sets data in the prepared statement object
	 * used to execute cancellation of appointment request
	 * @param prepStmt
	 * @param cancalAppointmentRequest
	 * @throws SQLException
	 */
	private void setDataInPrepStmtForCancelApptRequest(
			PreparedStatement prepStmt,
			CancelAppointmentRequest cancelAppointmentRequest)
			throws SQLException {
		// starting index
		int index = 1;
		// this is the value to be set to the wait list status column
		// the value indicates cancellation 
		final String WAIT_LIST_STATUS = "C";
		prepStmt.setString(index,WAIT_LIST_STATUS);
		index++;
		
		// reason for cancel
		String cancelReason = cancelAppointmentRequest.getReasonForCancellation();
		prepStmt.setString(index, cancelReason);
		index++;
		
		// modified by id
		prepStmt.setString(index,
				ScheduleConstants.APPOINTMENT_PORTAL_USER_ID);
		index++;
		
		// modified at work station number
		prepStmt.setString(index,
				ScheduleConstants.APPOINTMENT_PORTAL_SYSTEM_VALUE);
		index++;
		 
		// facility id
		String facilityId = cancelAppointmentRequest.getFacilityId();
		if(facilityId == null){
			facilityId = "";
		}
		prepStmt.setString(index, facilityId);
		index++;
		
		// wait list number
		String waitListNumber = cancelAppointmentRequest.getAppointmentReferenceNumber();
		if(waitListNumber == null){
			waitListNumber = "";
		}
		prepStmt.setString(index, waitListNumber);
		index++;
		
		// web request yn
		prepStmt.setString(index,
				CreateAppointmentConstants.APPOINTMENT_WEBREQUEST_PARAM_VALUE);
		index++;
		
		// patient id
		String patientId = cancelAppointmentRequest.getPatientId();
		prepStmt.setString(index,patientId);
	}

	public static void main(String[] args){
		// to test the cancel appointment request
		CancelAppointmentRequest request = new CancelAppointmentRequest();
		request.setAppointmentReferenceNumber("13396");
		request.setAppointmentReferenceNumber("13374");
		request.setAppointmentType(AppointmentType.Appointment_Request);
		request.setFacilityId("HS");
		request.setPatientId("DU00000692");
		CancelAppointmentDAC dacInst = new CancelAppointmentDAC();
		CancelAppointmentResponse response = dacInst.cancelAppointment(request);
		System.out.println(response.isSuccessful());
		//System.out.println(response.getErrorInfo().getErrorCode()+" ||| "+response.getErrorInfo().getErrorMessage());
	}
	
	
}
