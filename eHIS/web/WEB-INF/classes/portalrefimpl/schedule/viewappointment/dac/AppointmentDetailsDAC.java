/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portalrefimpl.schedule.viewappointment.dac;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.viewappointment.request.AppointmentDetailsRequest;
import portalrefimpl.schedule.viewappointment.response.AppointmentDetails;
import portalrefimpl.schedule.viewappointment.response.AppointmentDetailsResponse;
import portalrefimpl.schedule.viewappointment.svc.AppointmentDetailConstant;


/**
 * This is the DAC layer class for getting the appointment details
 * This class will return a list of future appointments given
 * a request
 * @author GRamamoorthy
 *
 */
public class AppointmentDetailsDAC {

	/**
	 * Default constructor of the class
	 */
	public AppointmentDetailsDAC() {
	}

	/**
	 * This method gets the appointment details and is the main method
	 * in this class
	 * @param request
	 * @return
	 */
	public AppointmentDetailsResponse getAppointmentDetails(AppointmentDetailsRequest request){
		// initialize the response object
		AppointmentDetailsResponse response = new AppointmentDetailsResponse();
		/*ErrorInfo errorInfo = new ErrorInfo();*/
		ErrorInfo errorInfo = null;
		/*response.setErrorInfo(errorInfo);*/
		
		int errorCode = ErrorInfo.SUCCESS_CODE; 
		String errorMessage = null;
		/*errorInfo.setErrorCode(errorCode);
		errorInfo.setErrorMessage(errorMessage);*/
		// get the connection object
		Connection conn = PortalHelper.getConnection();
		if(conn == null){
			errorCode = CommonConstants.DBCONNECTION_FAILURE_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			return response;
		}
		List<AppointmentDetails> appointmentDetailsList = new ArrayList<AppointmentDetails>();
		
		String patientId = request.getPatientId();
		int recordCount = request.getRecordCount();
		String query = "select APPT_DATE,PRACTITIONER_ID,APPT_SLAB_FROM_TIME,APPT_SLAB_TO_TIME,SPECIALITY_DESC from OA_APPT_PATIENT_VW where APPT_DATE > SYSDATE and PATIENT_ID= '"+patientId+"' and rownum <= "+recordCount;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs == null){
				errorCode = AppointmentDetailConstant.APPOINTMENTDETAILS_NULLRESULTSET_ERRORCODE;
				errorMessage = MessageContainer.getInstance().getDisplayMessage(
						CommonConstants.COMMON_MODULE_NAME, errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				response.addError(errorInfo);
				return response;
			}
			appointmentDetailsList = getAppointmentDetailsList(rs);
			// set the list of appointment details to the response
			response.setAppointmentDetailsList(appointmentDetailsList);
			if(appointmentDetailsList.isEmpty()){
				errorCode = AppointmentDetailConstant.APPOINTMENTDETAILS_RECORDSNOTFOUND_ERRORCODE;
				errorMessage = MessageContainer.getInstance().getDisplayMessage(
						CommonConstants.VIEWAPPTDETAILS_MODULE_NAME, errorCode);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				response.addError(errorInfo);
			}else{
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
				response.addError(errorInfo);
			}
		} catch (SQLException e) {
			errorCode = AppointmentDetailConstant.APPOINTMENTDETAILS_SQLEXCEPTION_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.COMMON_MODULE_NAME, errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
		}finally{
			PortalHelper.closeResources(conn, stmt, rs);
		}
		//appointmentDetailsList = getAppointmentDetailsList(conn,request);
		
		return response;
	}
	
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	/*private List<AppointmentDetails> getAppointmentDetailsList(Connection conn,
			AppointmentDetailsRequest request) {
		List<AppointmentDetails> appointmentDetailsList = new ArrayList<AppointmentDetails>();
	

		String patientId = request.getPatientId();
		int recordCount = request.getRecordCount();
		String query = "select APPT_DATE,PRACTITIONER_ID,APPT_SLAB_FROM_TIME,APPT_SLAB_TO_TIME from oa_appt where APPT_DATE > SYSDATE and PATIENT_ID = '"+patientId+"'";
		query = "select APPT_DATE,PRACTITIONER_ID,APPT_SLAB_FROM_TIME,APPT_SLAB_TO_TIME,SPECIALITY_DESC from OA_APPT_PATIENT_VW where APPT_DATE > SYSDATE and PATIENT_ID= '"+patientId+"' and rownum <= "+recordCount;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs != null){
				appointmentDetailsList = getAppointmentDetailsList(rs);
			}
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}finally{
			PortalHelper.closeResources(conn, stmt, rs);
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// cannot do much
				}
			}
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// cannot do much
				}
			}
			conn = null;
		}
		
		return appointmentDetailsList;
	}*/

	/**
	 * This method gets the appointment details as a list by iterating through
	 * the given result set
	 * @param rs
	 * @return
	 */
	private List<AppointmentDetails> getAppointmentDetailsList(ResultSet rs) throws SQLException{
		List<AppointmentDetails> appointmentDetailsList = new ArrayList<AppointmentDetails>();
		AppointmentDetails appointmentDetails = null;
		
		String practId = null;
		String speciality = null;
		Date apptDate = null;
		Timestamp toTime = null;
		Calendar fromCalendar = Calendar.getInstance();
		Calendar toCalendar = Calendar.getInstance();
		Calendar fromTimeCalendar = Calendar.getInstance();
		Calendar toTimeCalendar = Calendar.getInstance();
		int fromTimeHrs = 0;
		int fromTimeMin = 0;
		int toTimeHrs = 0;
		int toTimeMin = 0;
		Timestamp fromTimeStamp = null;
		
		while(rs.next()){
			appointmentDetails = new AppointmentDetails();
			apptDate = rs.getDate("APPT_DATE");
			appointmentDetails.setAppointmentDate(apptDate);
			
			fromCalendar.setTime(apptDate);
			toCalendar.setTime(apptDate);
			
			practId = rs.getString("PRACTITIONER_ID");
			appointmentDetails.setPractitioner(practId);
			
			speciality = rs.getString("SPECIALITY_DESC");
			appointmentDetails.setApptSpeciality(speciality);
			
			fromTimeStamp = rs.getTimestamp("APPT_SLAB_FROM_TIME");
			fromTimeCalendar.setTime(fromTimeStamp);
			fromTimeHrs = fromTimeCalendar.get(Calendar.HOUR_OF_DAY);
			fromTimeMin = fromTimeCalendar.get(Calendar.MINUTE);
			
			fromCalendar.set(Calendar.HOUR_OF_DAY, fromTimeHrs);
			fromCalendar.set(Calendar.MINUTE, fromTimeMin);
			appointmentDetails.setApptStartTime(fromCalendar.getTime());
							
			toTime = rs.getTimestamp("APPT_SLAB_TO_TIME");
			toTimeCalendar.setTime(toTime);
			toTimeHrs = toTimeCalendar.get(Calendar.HOUR_OF_DAY);
			toTimeMin = toTimeCalendar.get(Calendar.MINUTE);
			
			toCalendar.set(Calendar.HOUR_OF_DAY, toTimeHrs);
			toCalendar.set(Calendar.MINUTE, toTimeMin);
			appointmentDetails.setApptEndTime(toCalendar.getTime());
			
			appointmentDetailsList.add(appointmentDetails);
		}
		
		return appointmentDetailsList;
	}

	/*public static void main(String[] args){
		AppointmentDetailsDAC mainClass = new AppointmentDetailsDAC();
		
		AppointmentDetailsRequest request = new AppointmentDetailsRequest();
		PatientInfo patientInfo = new PatientInfo();
		String patientId = "HC00009253";
		patientInfo.setPatientId(patientId);
		request.setPatientInfo(patientInfo);
		
		List<AppointmentDetails> appointmentDetailsList = mainClass.getAppointmentDetailsList(request);
		System.out.println("done");
	}*/
	
}
