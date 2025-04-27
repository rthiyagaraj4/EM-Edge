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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.common.request.AppointmentRequest;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.createappointment.response.AppointmentResponse;


/**
 * This is the abstract implementation for the appointment handler
 * This class will contain common functionality of checking if an appointment
 * request already exists for the same practitioner, same date and times
 * This class will be extended by the handler implementation for book appointment
 * and reschedule appointment only
 * @author GRamamoorthy
 *
 */
public abstract class BaseAppointmentHandlerImpl implements AppointmentHandler {

	protected static final int PATIENT_DETAILS_ELEMENTS = 3;
	
	protected static final int PATIENT_GENDER_INDEX = 0;
	
	protected static final int PATIENT_CITIZEN_YN_INDEX = 1;
	
	protected static final int PATIENT_LEGAL_YN_INDEX = 2;
	
	
	/**
	 * This method checks if there is a duplicate record 
	 * for the data represented by the appointment request object
	 * This method will be used in book appointment and reschedule appointment flow
	 * 
	 * @param appointmentRequest
	 * @return
	 */
	protected AppointmentResponse checkDuplicateRecord(AppointmentRequest appointmentRequest){
		// initialize the response object
		AppointmentResponse response = new AppointmentResponse();
		ErrorInfo errorInfo = null;
		/*response.setErrorInfo(errorInfo);*/
		
		int errorCode = -1;
		String errorMessage = null;
		// get the connection
		Connection conn = PortalHelper.getConnection();
		if(conn == null){
			errorCode = CommonConstants.DBCONNECTION_FAILURE_ERRORCODE;
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			return response;
		}
		// SQL query
		String sqlQuery = "select count(*) from pr_wait_list where facility_id = ? and resource_id = ? and preferred_date_time = to_date(?,'DD/MM/YYYY') and pref_from_time = to_date(?,'DD/MM/YYYY HH24:mi') and pref_to_time = to_date(?,'DD/MM/YYYY HH24:mi') and web_req_yn = ? and wait_list_status = ?";
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			setDataInPreparedStatement(prepStmt,appointmentRequest);
			rs = prepStmt.executeQuery();
			if(rs == null){
				errorCode = CreateAppointmentConstants.APPOINTMENT_COMMON_RESULTSET_NULL_ERRORCODE;
				errorMessage = MessageContainer.getInstance()
						.getDisplayMessage(CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
								errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				response.addError(errorInfo);
				return response;
			}
			
			if(rs.next()){
				// get the row count - if it is more than 0, it indicates a duplicate
				// record
				int rowCount = rs.getInt(1);
				if(rowCount > 0){
					errorCode = CreateAppointmentConstants.APPOINTMENT_COMMON_DUPLICATE_RECORD_ERRORCODE;
					errorMessage = MessageContainer.getInstance()
							.getDisplayMessage(CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
									errorCode);
					errorInfo = new ErrorInfo();
					errorInfo.setErrorCode(errorCode);
					errorInfo.setErrorMessage(errorMessage);
				}else if(rowCount == 0){
					errorInfo = new ErrorInfo();
					// this indicates success scenario
					errorCode = ErrorInfo.SUCCESS_CODE;
					errorInfo.setErrorCode(errorCode);
				}
				response.addError(errorInfo);
			}
		} catch (SQLException e) {
			errorCode = CreateAppointmentConstants.APPOINTMENT_COMMON_DUPLICATE_RECORD_ERRORCODE;
			errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
		}finally{
			PortalHelper.closeResources(conn, prepStmt, rs);
		}
		
		
		return response;
	}

	/**
	 * This method sets data in the prepared statement object
	 * by reading data from the request object
	 * @param prepStmt
	 * @param appointmentRequest
	 * @throws SQLException
	 */
	private void setDataInPreparedStatement(PreparedStatement prepStmt,
			AppointmentRequest appointmentRequest) throws SQLException {
		String facilityId = appointmentRequest.getFacilityId();
		String practitionerId = appointmentRequest.getPractitionerId();
		String preferredDate = appointmentRequest.getPreferredDate();
		// preferred from and to time will be in the format "dd/MM/yyyy HH:mm"
		String preferredFromTime = appointmentRequest.getPreferredFromTime();
		String preferredToTime = appointmentRequest.getPreferredToTime();

		// now set data to prepared statement
		int index = 1;
		// first facility id
		prepStmt.setString(index, facilityId);
		index++;
		
		// practitioner id
		prepStmt.setString(index, practitionerId);
		index++;
		
		// preferred date
		prepStmt.setString(index, preferredDate);
		index++;
		
		// preferred from time
		prepStmt.setString(index, preferredFromTime);
		index++;
		
		// preferred to time
		prepStmt.setString(index, preferredToTime);
		index++;
		
		// web request parameter
		String webRequest = CreateAppointmentConstants.APPOINTMENT_WEBREQUEST_PARAM_VALUE;
		prepStmt.setString(index, webRequest);
		index++;
		
		// wait list status
		String waitListStatus = CreateAppointmentConstants.APPOINTMENT_WAITLIST_STATUS_VALUE;
		prepStmt.setString(index,waitListStatus);
	}
	
}
