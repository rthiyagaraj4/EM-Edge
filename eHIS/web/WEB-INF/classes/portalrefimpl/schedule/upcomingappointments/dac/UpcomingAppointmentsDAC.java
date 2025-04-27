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
package portalrefimpl.schedule.upcomingappointments.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.ScheduleConstants;
import portalrefimpl.schedule.upcomingappointments.request.UpcomingAppointmentsRequest;
import portalrefimpl.schedule.upcomingappointments.response.UpcomingAppointmentDetails;
import portalrefimpl.schedule.upcomingappointments.response.UpcomingAppointmentsComparator;
import portalrefimpl.schedule.upcomingappointments.response.UpcomingAppointmentsResponse;

/**
 * @author SaraswathiR Data Access Component for getting upcoming appointments I
 * 
 */
public class UpcomingAppointmentsDAC {

	/**
	 * This method gets the upcoming appointments for a patient This method is
	 * modified to get the appointment requests booked through portal also this
	 * method will first try to get the appointments booked in EM if this fails,
	 * it will still proceed and get the appointment requests booked in portal
	 * if this also fails, then only a complete error code will be set to the
	 * response in any failure case, the error code will be still set but then
	 * the caller of the service needs to check the code and the data to handle
	 * 
	 * @param UpcomingAppointmentsRequest
	 * @return UpcomingAppointmentsResponse Returns the Response object
	 */
	public UpcomingAppointmentsResponse getUpcomingAppointmentDetails(
			UpcomingAppointmentsRequest upcomingAppointmentsRequest) {
		// initialize the response
		UpcomingAppointmentsResponse upcomingAppointmentsResponse = new UpcomingAppointmentsResponse();

		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		//errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
		/*upcomingAppointmentsResponse.setErrorInfo(errorInfo);*/

		Connection conn = PortalHelper.getConnection();
		// safe check for null connection
		if (conn == null) {
			errorCode = CommonConstants.DBCONNECTION_FAILURE_ERRORCODE;
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorMessage = MessageContainer
					.getInstance()
					.getDisplayMessage(
							CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			errorInfo.setErrorMessage(errorMessage);
			upcomingAppointmentsResponse.addError(errorInfo);
			return upcomingAppointmentsResponse;
		}

		// initialize prepared statement and result set
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		// get the SQL query
		String sqlQuery = getUpcomingAppointmentsQuery(upcomingAppointmentsRequest);

		try {
			prepStmt = conn.prepareStatement(sqlQuery);
			rs = prepStmt.executeQuery();
			// check the result set for null
			if (rs == null) {
				errorCode = ScheduleConstants.UPCOMING_APPTS_NULLRESULTSET_ERRORCODE;
				errorMessage = MessageContainer
						.getInstance()
						.getDisplayMessage(
								CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
								errorCode);
				/*errorInfo
						.setErrorCode(ScheduleConstants.APPOINTMENTS_RESULT_EMPTYDATA_CODE);*/
				/*String errorMessage = MessageContainer
						.getInstance()
						.getDisplayMessage(
								CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
								ScheduleConstants.APPOINTMENTS_RESULT_EMPTYDATA_CODE);*/
				/*String errorMessage = null;
				// form the error message
				ResourceBundle bundle = null;
				// try catch block is only for safety
				try {
					bundle = ResourceBundle.getBundle("portalrefimpl.schedule.upcomingappointments.resourcebundle.Messages");
					errorMessage = bundle.getString("DisplayMessage.AppointmentRetrieveIssue");
				} catch (Exception e) {
					// cannot do anything
					errorMessage = "Could not retrieve appointments.";
				}*/
				
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				
				upcomingAppointmentsResponse.addError(errorInfo);
				// return upcomingAppointmentsResponse;
			} else {
				getUpcomingAppointmentDetailsList(rs,
						upcomingAppointmentsResponse);
			}

			populateApptRequests(conn, upcomingAppointmentsResponse,
					upcomingAppointmentsRequest);
		} catch (SQLException e) {
			// form the error message
			/*ResourceBundle bundle = null;
			// try catch block is only for safety
			try {
				bundle = ResourceBundle.getBundle("portalrefimpl.schedule.upcomingappointments.resourcebundle.Messages");
				errorMessage = bundle.getString("DisplayMessage.AppointmentRetrieveIssue");
			} catch (Exception e1) {
				// cannot do anything
				errorMessage = "Could not retrieve appointments.";
			}*/
			errorCode = ScheduleConstants.UPCOMING_APPTS_SQLEXCEPTION_ERRORCODE;
			errorMessage = MessageContainer
					.getInstance()
					.getDisplayMessage(
							CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
							errorCode);
			// populate the error info that appointments could not
			// be retrieved
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			upcomingAppointmentsResponse.addError(errorInfo);
			// call the method to populate appointment requests
			populateApptRequests(conn, upcomingAppointmentsResponse,
					upcomingAppointmentsRequest);
			/*errorInfo
					.setErrorCode(ScheduleConstants.APPOINTMENTS_RESULT_EMPTYDATA_CODE);
			String errorMessage = MessageContainer
					.getInstance()
					.getDisplayMessage(
							CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
							ScheduleConstants.APPOINTMENTS_RESULT_EMPTYDATA_CODE);
			errorInfo.setErrorMessage(errorMessage);*/
		} finally {
			PortalHelper.closeResources(conn, prepStmt, rs);
		}
		
		// finally check and sort the data list in the response
		List<UpcomingAppointmentDetails> detailsList = upcomingAppointmentsResponse.getUpcomingAppointmentsList();
		Collections.sort(detailsList, new UpcomingAppointmentsComparator());

		return upcomingAppointmentsResponse;

	}

	/**
	 * This method forms the query for getting upcoming appointments data
	 */
	private String getUpcomingAppointmentsQuery(
			UpcomingAppointmentsRequest upcomingAppointmentsRequest) {

		String patientId = upcomingAppointmentsRequest.getPatientId();
		int startRecordNum = upcomingAppointmentsRequest.getStartRecordNum();
		int endRecordNum = upcomingAppointmentsRequest.getEndRecordNum();
		String facilityId = upcomingAppointmentsRequest.getFacilityId();
		String fromDate = upcomingAppointmentsRequest.getFromDate();
		String toDate = upcomingAppointmentsRequest.getToDate();

		StringBuilder query = new StringBuilder(
				"select APPT_REF_NO APPT_NUMBER, to_char(appt_date,'dd/mm/yyyy') APPT_DATE,");
		query.append("to_char(APPT_SLAB_FROM_TIME,'hh24:mi') APPT_FROM_TIME,");
		query.append("to_char(APPT_SLAB_TO_TIME,'hh24:mi') APPT_TO_TIME,");
		query.append("FACILITY_NAME,FACILITY_ID,CLINIC_CODE,PRACTITIONER_SHORT_NAME PRACTITIONER_NAME,SPECIALITY_DESC SPECIALITY,APPT_STATUS");
		query.append(" FROM oa_appt_vw WHERE appt_status='1' and patient_id='"
				+ patientId + "'");

		if (facilityId != null && !facilityId.trim().equals("")) {
			query.append(" and facility_id='" + facilityId + "'");
		}
		if (startRecordNum > 0) {
			query.append(" and rownum >= " + startRecordNum);
		}

		if (endRecordNum > 0) {
			query.append(" and rownum <= " + endRecordNum);
		}
		// if from date is given in the request it can be used, otherwise from
		// date is taken as system date
		if (fromDate != null && !fromDate.trim().equals("")) {
			query.append(" and appt_date >= to_date('" + fromDate
					+ "','dd/MM/yyyy')");
		} else {
			query.append(" and trunc(appt_date) >= trunc(sysdate) ");
		}
		if (toDate != null && !toDate.trim().equals("")) {
			query.append(" and appt_date <= to_date('" + toDate
					+ "','dd/MM/yyyy')");
		}
		query.append(" order by appt_date,APPT_SLAB_FROM_TIME");
		String queryString = query.toString();
		return queryString;
	}

	/**
	 * this method extracts the data from the db returned resultset and sets it
	 * to the response object
	 */
	private void getUpcomingAppointmentDetailsList(ResultSet rs,
			UpcomingAppointmentsResponse upcomingAppointmentsResponse) throws SQLException {
		List<UpcomingAppointmentDetails> upcomingAppointmentDetailsList = new ArrayList<UpcomingAppointmentDetails>();
		UpcomingAppointmentDetails upcomingAppointmentDetails = null;
		/*try {*/
		while (rs.next()) {
			upcomingAppointmentDetails = new UpcomingAppointmentDetails();
			upcomingAppointmentDetails.setAppointmentNumber(rs
					.getString("APPT_NUMBER"));
			upcomingAppointmentDetails.setAppointmentDate(rs
					.getString("APPT_DATE"));
			upcomingAppointmentDetails.setPractitionerName(rs
					.getString("PRACTITIONER_NAME"));
			upcomingAppointmentDetails.setApptSpeciality(rs
					.getString("SPECIALITY"));
			upcomingAppointmentDetails.setAppointmentStartTime(rs
					.getString("APPT_FROM_TIME"));
			upcomingAppointmentDetails.setAppointmentEndTime(rs
					.getString("APPT_TO_TIME"));
			upcomingAppointmentDetails.setLocationName(rs
					.getString("CLINIC_CODE"));
			upcomingAppointmentDetails.setFacilityName(rs
					.getString("FACILITY_NAME"));
			upcomingAppointmentDetails.setFacilityId(rs
					.getString("FACILITY_ID"));
			upcomingAppointmentDetails.setAppointmentStatus(rs
					.getString("Appt_status"));
			upcomingAppointmentDetailsList.add(upcomingAppointmentDetails);
		}
		/*} catch (SQLException e) {
			System.out.println(e.getMessage());
		}*/

		// check for empty list - if so, set error code appropriately
		if (upcomingAppointmentDetailsList.isEmpty()) {
			int errorCode = ScheduleConstants.UPCOMING_APPTS_NOTOBTAINED_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
							errorCode);
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			upcomingAppointmentsResponse.addError(errorInfo);
			
			/*ErrorInfo errorInfo = upcomingAppointmentsResponse.getErrorInfo();
			// error code should not be set to the response
			
			 * errorInfo
			 * .setErrorCode(ScheduleConstants.APPOINTMENTS_RESULT_EMPTYDATA_CODE
			 * );
			String errorMessage = MessageContainer
					.getInstance()
					.getDisplayMessage(
							CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
							ScheduleConstants.APPOINTMENTS_RESULT_EMPTYDATA_CODE);
			String errorMessage = null;
			// form the error message
			ResourceBundle bundle = null;
			// try catch block is only for safety
			try {
				bundle = ResourceBundle.getBundle("portalrefimpl.schedule.upcomingappointments.resourcebundle.Messages");
				errorMessage = bundle.getString("DisplayMessage.AppointmentRetrieveIssue");
				errorInfo.setErrorMessage(errorMessage);
			} catch (Exception e) {
				// cannot do anything
				errorMessage = "Could not retrieve appointments. ";
			}
			errorInfo.setErrorMessage(errorMessage);*/
		}else{
			// success case - still there is a need to set the errorinfo
			// object
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
			upcomingAppointmentsResponse.addError(errorInfo);
		}
		// finally set the data
		upcomingAppointmentsResponse
				.setUpcomingAppointmentsList(upcomingAppointmentDetailsList);
	}

	/**
	 * This method populates the appointment requests booked in Portal to the
	 * upcoming appointments response
	 * 
	 * @param conn
	 * @param upcomingApptResponse
	 */
	private void populateApptRequests(Connection conn,
			UpcomingAppointmentsResponse upcomingApptResponse,
			UpcomingAppointmentsRequest upcomingApptRequest) {
		// get the SQL query needed for getting data
		String query = getAppointmentRequestsQuery(upcomingApptRequest);

		/*ErrorInfo errorInfo = upcomingApptResponse.getErrorInfo();*/
		ErrorInfo errorInfo = null;
		int errorCode = ErrorInfo.SUCCESS_CODE;
		String errorMessage = null;
		// get the list from response object
		// data will be populated in this list
		List<UpcomingAppointmentDetails> upcomingApptsList = upcomingApptResponse
				.getUpcomingAppointmentsList();
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;
		UpcomingAppointmentDetails upcomingAppointmentDetails = null;
		try {
			preparedStmt = conn.prepareStatement(query);
			setDataInApptRequestPreparedStatement(preparedStmt,
					upcomingApptRequest);
			resultSet = preparedStmt.executeQuery();
			if (resultSet == null) {
				errorCode = ScheduleConstants.UPCOMING_APPTREQ_NULLRESULTSET_ERRORCODE;
				errorMessage = MessageContainer
						.getInstance()
						.getDisplayMessage(
								CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
								errorCode);
				
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(errorCode);
				errorInfo.setErrorMessage(errorMessage);
				
				upcomingApptResponse.addError(errorInfo);
				// set error in response after checking for null or empty list
				/*if ((ErrorInfo.SUCCESS_CODE == errorInfo.getErrorCode())
						&& (upcomingApptsList == null || upcomingApptsList
								.isEmpty())) {
					errorInfo
							.setErrorCode(ScheduleConstants.UPCOMING_APPTS_EMPTYDATA_CODE);
					errorMessage = MessageContainer
							.getInstance()
							.getDisplayMessage(
									CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
									ScheduleConstants.UPCOMING_APPTS_EMPTYDATA_CODE);
					errorInfo.setErrorMessage(errorMessage);
				}*/
			} else {
				/*boolean appointmentsFound = false;
				if (upcomingApptsList == null) {
					upcomingApptsList = new ArrayList<UpcomingAppointmentDetails>();
					upcomingApptResponse
							.setUpcomingAppointmentsList(upcomingApptsList);
				}else if(!upcomingApptsList.isEmpty()){
					appointmentsFound = true;
				}*/
				boolean apptRequestFound = false;
				// iterate through the result set and get data
				while (resultSet.next()) {
					upcomingAppointmentDetails = new UpcomingAppointmentDetails();
					upcomingAppointmentDetails.setAppointmentNumber(resultSet
							.getString("appt_number"));
					// resultSet.getString("practitionerId");
					upcomingAppointmentDetails.setPractitionerName(resultSet
							.getString("practitionername"));
					upcomingAppointmentDetails.setAppointmentDate(resultSet
							.getString("appt_date"));
					upcomingAppointmentDetails
							.setAppointmentStartTime(resultSet
									.getString("appt_from_time"));
					upcomingAppointmentDetails.setAppointmentEndTime(resultSet
							.getString("appt_to_time"));
					upcomingAppointmentDetails.setFacilityId(resultSet
							.getString("facility_id"));
					upcomingAppointmentDetails.setFacilityName(resultSet
							.getString("facilityName"));
					upcomingAppointmentDetails.setLocationName(resultSet
							.getString("locn_code"));
					upcomingAppointmentDetails.setApptSpeciality(resultSet
							.getString("specialty_code"));
					upcomingAppointmentDetails
							.setAppointmentStatus(ScheduleConstants.APPOINTMENT_REQUEST_STATUS_KEY);

					upcomingApptsList.add(upcomingAppointmentDetails);
					if (!apptRequestFound) {
						apptRequestFound = true;
					}
				}
				
				// appointment request is not found
				if(!apptRequestFound){
					errorCode = ScheduleConstants.UPCOMING_APPTREQ_NOTOBTAINED_ERRORCODE;
					errorMessage = MessageContainer.getInstance().getDisplayMessage(
							CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
							errorCode);
					errorInfo = new ErrorInfo();
					errorInfo.setErrorCode(errorCode);
					errorInfo.setErrorMessage(errorMessage);
					
					upcomingApptResponse.addError(errorInfo);
				}else{
					// success scenario - need to set an success error info object
					errorInfo = new ErrorInfo();
					errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
					upcomingApptResponse.addError(errorInfo);
				}
				
				// this is where if appointment requests are not found
				// error message will be set in the response
				/*if (!apptRequestFound) {
					// here both the error code and error message will
					// be set
					if (!appointmentsFound) {
						errorInfo
								.setErrorCode(ScheduleConstants.UPCOMING_APPTS_EMPTYDATA_CODE);
						errorMessage = MessageContainer
								.getInstance()
								.getDisplayMessage(
										CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
										ScheduleConstants.UPCOMING_APPTS_EMPTYDATA_CODE);
						errorInfo.setErrorMessage(errorMessage);
					} else {
						// form the error message
						ResourceBundle bundle = null;
						// try catch block is only for safety
						try {
							bundle = ResourceBundle.getBundle("portalrefimpl.schedule.upcomingappointments.resourcebundle.Messages");
							errorMessage = bundle.getString("DisplayMessage.AppointmentRequestRetrieveIssue");
						} catch (Exception e) {
							// cannot do anything
							errorMessage = "Could not retrieve appointment requests.";
						}
						errorMessage = "Appointments have been retrieved.\n " + errorMessage;
						errorInfo.setErrorMessage(errorMessage);
					}
				}else{
					if(!appointmentsFound){
						errorMessage = errorInfo.getErrorMessage();
						errorMessage += "\n Appointment requests have been retrieved.";
						errorInfo.setErrorMessage(errorMessage);
					}
				}*/
			}
		} catch (SQLException e) {
			// initialize the error
			errorCode = ScheduleConstants.UPCOMING_APPTREQ_SQLEXCEPTION_ERRORCODE;
			errorMessage = MessageContainer.getInstance().getDisplayMessage(
					CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
					errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			
			upcomingApptResponse.addError(errorInfo);
			
			//System.out.println(e.getMessage());
			/*if (upcomingApptsList == null || upcomingApptsList.isEmpty()) {
				errorInfo
						.setErrorCode(ScheduleConstants.UPCOMING_APPTS_EMPTYDATA_CODE);
				errorMessage = MessageContainer
						.getInstance()
						.getDisplayMessage(
								CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
								ScheduleConstants.UPCOMING_APPTS_EMPTYDATA_CODE);
			}else{
				// form the error message
				ResourceBundle bundle = null;
				// try catch block is only for safety
				try {
					bundle = ResourceBundle.getBundle("portalrefimpl.schedule.upcomingappointments.resourcebundle.Messages");
					errorMessage = bundle.getString("DisplayMessage.AppointmentRequestRetrieveIssue");
				} catch (Exception e1) {
					// cannot do anything
					errorMessage = "Could not retrieve appointment requests.";
				}
				errorMessage = "Appointments have been retrieved.\n "+ errorMessage;
			}
			errorInfo.setErrorMessage(errorMessage);*/
			
			
			/*if ((ErrorInfo.SUCCESS_CODE == errorInfo.getErrorCode())
					&& (upcomingApptsList == null || upcomingApptsList
							.isEmpty())) {
				errorInfo
						.setErrorCode(ScheduleConstants.APPOINTMENTS_RESULT_EMPTYDATA_CODE);
				String errorMessage = MessageContainer
						.getInstance()
						.getDisplayMessage(
								CommonConstants.UPCOMING_APPOINTMENTS_MODULE_NAME,
								ScheduleConstants.APPOINTMENTS_RESULT_EMPTYDATA_CODE);
				errorInfo.setErrorMessage(errorMessage);
			}*/
		} finally {
			PortalHelper.closeResources(resultSet, preparedStmt);
		}

	}

	/**
	 * This method gets an SQL query for getting the appointment request booked
	 * through portal
	 * 
	 * @return
	 */
	private String getAppointmentRequestsQuery(
			UpcomingAppointmentsRequest request) {
		StringBuffer queryBuffer = new StringBuffer();
		queryBuffer
				.append("select wait_list_no appt_number,resource_id practitionerId,");
		queryBuffer
				.append("(select short_name from am_practitioner_lang_vw where practitioner_id = resource_id and language_id = ?) practitionername,");
		queryBuffer
				.append("to_char(preferred_date_time,'dd/mm/yyyy') appt_date,");
		queryBuffer
				.append("to_char(pref_from_time,'hh24:mi') appt_from_time,to_char(pref_to_time,'hh24:mi') appt_to_time,");
		queryBuffer
				.append("facility_id,(select SM_FACILITY_PARAM.FACILITY_NAME from SM_FACILITY_PARAM where SM_FACILITY_PARAM.FACILITY_ID = p.facility_id) facilityName,");
		queryBuffer.append("locn_code,specialty_code ");
		queryBuffer.append("from pr_wait_list p ");
		queryBuffer.append("where web_req_yn = 'Y' and wait_list_status = 'O' and ");
		queryBuffer.append("patient_id = ? ");
		// first check for facility id
		String facilityId = request.getFacilityId();
		if (facilityId != null && !facilityId.trim().equals("")) {
			queryBuffer.append(" and facility_id=? ");
		}
		String preferredFromDate = request.getFromDate();
		// if from date is given in the request it can be used, otherwise from
		// date is taken as system date
		if (preferredFromDate != null && !preferredFromDate.trim().equals("")) {
			queryBuffer
					.append(" and pref_from_time > to_date(?,'dd/MM/yyyy hh24:mi') ");
		} else {
			queryBuffer.append(" and trunc(pref_from_time) >= trunc(sysdate) ");
		}
		// now comes the end date
		String preferredToDate = request.getToDate();
		if (preferredToDate != null && !preferredToDate.trim().equals("")) {
			queryBuffer.append(" and pref_to_time <= to_date(?,'dd/MM/yyyy hh24:mi') ");
		}

		queryBuffer
				.append(" order by preferred_date_time asc,pref_from_time asc ");

		return queryBuffer.toString();
	}

	/**
	 * This method sets data in the prepared statement used for getting
	 * appointment requests from portal
	 * 
	 * @param prepStmt
	 * @param request
	 * @throws SQLException
	 */
	private void setDataInApptRequestPreparedStatement(
			PreparedStatement prepStmt, UpcomingAppointmentsRequest request)
			throws SQLException {
		// var for storing the index at which data will be set to statement
		int index = 1;
		// first set locale
		String locale = request.getLocale();
		prepStmt.setString(index, locale);
		index++;
		// next patient id
		String patientId = request.getPatientId();
		prepStmt.setString(index, patientId);
		index++;
		// next facility id once again
		String facilityId = request.getFacilityId();
		if(facilityId != null && !facilityId.trim().equals("")){
			prepStmt.setString(index, facilityId);
			index++;	
		}
		
		// next preferred from time
		String preferredFromDate = request.getFromDate();
		if (preferredFromDate != null && !preferredFromDate.trim().equals("")) {
			prepStmt.setString(index, preferredFromDate);
			index++;
		}
		// next preferred to time
		String preferredToTime = request.getToDate();
		if (preferredToTime != null && !preferredToTime.trim().equals("")) {
			prepStmt.setString(index, preferredToTime);
		}
	}

	/*public static void main(String[] args){
		UpcomingAppointmentsRequest request = new UpcomingAppointmentsRequest();
		String patientId = "DU00000692";
		request.setPatientId(patientId);
		String facilityId = "HS";
		//request.setFacilityId(facilityId);
		request.setLocale(Locale.getDefault().getLanguage());
		//request.setFromDate("01/05/2013");
		request.setToDate("08/05/2013");
		
		UpcomingAppointmentsDAC dacInst = new UpcomingAppointmentsDAC();
		UpcomingAppointmentsResponse response = dacInst.getUpcomingAppointmentDetails(request);
		ErrorInfo errorInfo = response.getErrorInfo();
		System.out.println(errorInfo.getErrorCode()+"|||"+errorInfo.getErrorMessage());
		List<UpcomingAppointmentDetails> upcomingApptsList = response
				.getUpcomingAppointmentsList();
		if(upcomingApptsList != null && !upcomingApptsList.isEmpty()){
			for(UpcomingAppointmentDetails detail : upcomingApptsList){
				System.out.println("--------------------------------------------------------------------------------------------------");
				System.out.println(detail.getAppointmentNumber()+"|||"+detail.getAppointmentDate()+"|||"+detail.getAppointmentStartTime()+"|||"+detail.getAppointmentEndTime()+"|||"+detail.getApptSpeciality()+"|||"+detail.getFacilityName());
			}
		}
	}*/
}
