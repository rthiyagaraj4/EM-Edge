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
package portalrefimpl.schedule.rescheduleappointment.dac;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.MessageFormat;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.ScheduleConstants;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.rescheduleappointment.RescheduleRequestConstants;
import portalrefimpl.schedule.rescheduleappointment.request.RescheduleAppointmentRequest;
import portalrefimpl.schedule.rescheduleappointment.response.RescheduleAppointmentResponse;

/**
 * This is the DAC layer class for reschedule appointment service
 * @author GRamamoorthy
 *
 */
public class RescheduleAppointmentDAC {

	/**
	 * This method reschedules an appointment which is referred in the reschedule appointment
	 * request object
	 * This method returns an instance of reschedule appointment response object
	 * @param request
	 * @return
	 */
	public RescheduleAppointmentResponse rescheduleAppointmentRequest(RescheduleAppointmentRequest request){
		RescheduleAppointmentResponse response = new RescheduleAppointmentResponse();
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		
		// get the connection
		Connection conn = PortalHelper.getConnection();
		if(conn == null){
			errorCode = CommonConstants.DBCONNECTION_FAILURE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			response.addError(errorCode, errorMessage);
			return response;
		}
		
		String apptReqRefNumberFromRequest = request.getAppointmentReferenceNumber();
		
		final int ERRORMESSAGE_INDEX = 15;
		final int APPT_REQ_REF_NUMBER_INDEX = 16;
		String spText = getSQLQuery(request);
		CallableStatement callStmt = null;
		int resultSize = 0;
		// vars to store the output obtained from sp execution
		String executionErrorMessage = null;
		String apptReqRefNumber = null;
		try {
			callStmt = conn.prepareCall(spText);
			setDataInCallableStatement(request,callStmt);
			resultSize = callStmt.executeUpdate();
			
			executionErrorMessage = callStmt.getString(ERRORMESSAGE_INDEX);
			apptReqRefNumber = callStmt.getString(APPT_REQ_REF_NUMBER_INDEX);
			
			// this indicates error scenario
			if (resultSize == 0
					|| (executionErrorMessage != null && !executionErrorMessage
							.trim().equals(""))) {
				errorCode = RescheduleRequestConstants.RESCHEDULE_APPT_FAILURE_ERRORCODE;
				errorMessage = MessageContainer
						.getInstance()
						.getDisplayMessage(
								CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
								errorCode);
				errorMessage = MessageFormat
						.format(errorMessage,
								new Object[] { apptReqRefNumberFromRequest });
			}else{
				response.setAppointmentReferenceNumber(apptReqRefNumber);
			}
			
		} catch (SQLException e) {
			errorCode = RescheduleRequestConstants.RESCHEDULE_APPT_SQLEXCEPTION_ERRORCODE;
			errorMessage = MessageContainer
					.getInstance()
					.getDisplayMessage(
							CommonConstants.RESCHEDULE_APPOINTMENTREQUEST_MODULE_NAME,
							errorCode);
			errorMessage = MessageFormat
					.format(errorMessage,
							new Object[] { apptReqRefNumberFromRequest });
		}finally{
			PortalHelper.closeResources(conn, callStmt);
		}
		
		response.addError(errorCode, errorMessage);
		
		
		return response;
	}
	
	/**
	 * This method gets the SQL query needed for rescheduling appointment request
	 * @param request
	 * @return
	 */
	private String getSQLQuery(RescheduleAppointmentRequest request){
		StringBuilder builder = new StringBuilder();
		// the sp to call is the SQL query
		builder.append("{call PR_UPDATE_WEBREQ_WAIT_LIST(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		
		return builder.toString();
	}
	
	/**
	 * This method gets data from the request object and sets data in the 
	 * callable statement
	 * @param request
	 * @param callStmt
	 * @throws SQLException
	 */
	private void setDataInCallableStatement(
			RescheduleAppointmentRequest request, CallableStatement callStmt)
			throws SQLException {
		// get data from the request and set it to the callable statement
		String waitListNo = request.getAppointmentReferenceNumber();
		String facilityId = request.getFacilityId();
		String preferredDate = request.getPreferredDate();
		String preferredFromTime = request.getPreferredFromTime();
		String preferredToTime = request.getPreferredToTime(); 
		String careLocationType = request.getCareLocationTypeIndicator();
		String locationCode = request.getLocationCode();
		String patientId = request.getPatientId();
		String resourceId = request.getPractitionerId();
		String modifiedById = ScheduleConstants.APPOINTMENT_PORTAL_USER_ID;
		String modifiedAtWorkStation = ScheduleConstants.APPOINTMENT_PORTAL_SYSTEM_VALUE;
		String modifiedFacilityId = request.getModifiedFacilityId();
		String webRequestYn = CreateAppointmentConstants.APPOINTMENT_WEBREQUEST_PARAM_VALUE;
		String modifyReasonCode = request.getModifyReasonCode();
		
		int index = 1;
		callStmt.setString(index, waitListNo);
		index++;
		
		callStmt.setString(index, facilityId);
		index++;
		
		callStmt.setString(index, preferredDate);
		index++;
		
		callStmt.setString(index, locationCode);
		index++;
				
		callStmt.setString(index, resourceId);
		index++;
		
		callStmt.setString(index, patientId);
		index++;
		
		callStmt.setString(index, modifiedById);
		index++;
		
		callStmt.setString(index, modifiedAtWorkStation);
		index++;
		
		callStmt.setString(index, modifiedFacilityId);
		index++;
		
		callStmt.setString(index, careLocationType);
		index++;
		
		callStmt.setString(index, webRequestYn);
		index++;
		
		callStmt.setString(index, preferredFromTime);
		index++;
		
		callStmt.setString(index, preferredToTime);
		index++;
		
		callStmt.setString(index, modifyReasonCode);
		index++;
		
		callStmt.registerOutParameter(index, Types.VARCHAR);
		index++;
		
		callStmt.registerOutParameter(index, Types.VARCHAR);
		
	}
	
	/*public static void main(String[] args){
		RescheduleAppointmentRequest request = new RescheduleAppointmentRequest();
		String waitListNo = "13734";
		String facilityId = "HS";
		String preferredDate = "19/06/2013";
		String preferredFromTime = "19/06/2013 12:00";
		String preferredToTime = "19/06/2013 12:20"; 
		String careLocationType = "C";
		String locationCode = "1234";
		String patientId = "HC00007128";
		String resourceId = "AFIDA";
		String modifiedById = "PortalUser";
		String modifiedAtWorkStation = "PortalSystem";
		String modifiedFacilityId = "HS";
		String webRequestYn = "Y";
		
		request.setAppointmentReferenceNumber(waitListNo);
		request.setFacilityId(facilityId);
		request.setPreferredDate(preferredDate);
		request.setPreferredFromTime(preferredFromTime);
		request.setPreferredToTime(preferredToTime);
		request.setCareLocationTypeIndicator(careLocationType);
		request.setLocationCode(locationCode);
		request.setPatientId(patientId);
		request.setPractitionerId(resourceId);
		request.setModifiedById(modifiedById);
		request.setModifiedWorkStationNumber(modifiedAtWorkStation);
		request.setModifiedFacilityId(modifiedFacilityId);
		request.setWebRequestYn(webRequestYn);
		
		request.setLocale(Locale.getDefault().getLanguage());
		request.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		
		RescheduleAppointmentDAC dacInst = new RescheduleAppointmentDAC();
		RescheduleAppointmentResponse response = dacInst.rescheduleAppointmentRequest(request);
		if(response.isSuccessful()){
			System.out.println("successfully updated the appointment request "+response.getAppointmentReferenceNumber());
		}else{
			System.out.println("failure in updating the appointment request");
		}
		
	}*/
	
}
