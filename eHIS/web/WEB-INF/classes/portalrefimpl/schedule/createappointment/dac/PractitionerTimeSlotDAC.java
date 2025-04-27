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
package portalrefimpl.schedule.createappointment.dac;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.createappointment.request.PractitionerTimeSlotRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerTimeSlotResponse;
import portalrefimpl.schedule.createappointment.response.TimeSlot;
import portalrefimpl.schedule.createappointment.response.TimeSlotStatus;

/**
 * This is the DAC class for the practitioner time slot service
 * 
 * @author GRamamoorthy
 *
 */
public class PractitionerTimeSlotDAC {
	

	/**
	 * This is the main method in this class
	 * This method gets the time slot information for a practitioner
	 * This method takes the PractitionerTimeSlotRequest object as input
	 * @param practitionerTimeSlotRequest
	 * @return
	 */
	public PractitionerTimeSlotResponse getPractitionerTimeSlot(
			PractitionerTimeSlotRequest practitionerTimeSlotRequest) {
		// initialize the practitioner time slot response object
		PractitionerTimeSlotResponse practitionerTimeSlotResponse = new PractitionerTimeSlotResponse();
		ErrorInfo errorInfo = null;
		/*ErrorInfo errorInfo = new ErrorInfo();*/
		/*practitionerTimeSlotResponse.setErrorInfo(errorInfo);*/
		// stored procedure needs to be executed now
		String sqlQuery = "{call oa_schedules.get_day_status( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; 
		
		// initially set the practitioner id and the preferred date to the 
		// response object from the request
		String practitionerId = practitionerTimeSlotRequest.getPractitionerId();
		practitionerTimeSlotResponse.setPractitionerId(practitionerId);
		String preferredDateStr = practitionerTimeSlotRequest.getPreferredDate();
		Date preferredDate = PortalHelper
				.getDateFromString(
						preferredDateStr,
						CreateAppointmentConstants.PRACTITIONER_SERVICE_PREFERRED_DATE_FORMAT);
		practitionerTimeSlotResponse.setPreferredDate(preferredDate);
		
		// get the connection and initialize statements
		Connection conn = PortalHelper.getConnection();
		// safe check
		if(conn == null){
			int errorCode = CommonConstants.DBCONNECTION_FAILURE_ERRORCODE;
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(CommonConstants.COMMON_MODULE_NAME,
							errorCode);
			errorInfo.setErrorMessage(errorMessage);
			practitionerTimeSlotResponse.addError(errorInfo);
			return practitionerTimeSlotResponse;
		}
		// instance of callable statement object which will help in executing
		// the stored procedure
		CallableStatement callStmt = null;
		// execute the statement and then call the method to populate 
		// date in the response object
		try {
			callStmt = conn.prepareCall(sqlQuery);
			setDataInCallableStatement(callStmt,practitionerTimeSlotRequest);
			callStmt.execute();
			populateDataInPractitionerTimeSlotResponse(callStmt,
					practitionerTimeSlotResponse);
			filterApptRequestsFromResponse(conn, practitionerTimeSlotRequest,
					practitionerTimeSlotResponse);
			// finally there is a need to set positive response
			if(!practitionerTimeSlotResponse.hasErrors()){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
				practitionerTimeSlotResponse.addError(errorInfo);
			}
		} catch (SQLException e) {
			errorInfo = new ErrorInfo();
			int errorCode = CreateAppointmentConstants.PRACTITIONERTIMESLOT_SQLEXCEPTION_ERRORCODE;
			errorInfo.setErrorCode(errorCode);
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo.setErrorMessage(errorMessage);
			practitionerTimeSlotResponse.addError(errorInfo);
		}
		
		return practitionerTimeSlotResponse;
	}
	
	/**
	 * This method sets the inputs to the callable statement
	 * based on the request object
	 * This method also registers the out parameters 
	 * @param callStmt
	 * @param practitionerTimeSlotRequest
	 * @throws SQLException
	 */
	private void setDataInCallableStatement(CallableStatement statement,
			PractitionerTimeSlotRequest practitionerTimeSlotRequest)
			throws SQLException {
		
		String facilityId = practitionerTimeSlotRequest.getFacilityId();
		String date = practitionerTimeSlotRequest.getPreferredDate();
		String clinic_code = practitionerTimeSlotRequest.getClinicCode();
		String practitioner_id = practitionerTimeSlotRequest.getPractitionerId();
		String clinic_type = practitionerTimeSlotRequest.getClinicType();
		String res_type = practitionerTimeSlotRequest.getResourceType();
		String locale = practitionerTimeSlotRequest.getLocale();
		
		// now set the inputs 
		statement.setString( 1, facilityId);
		statement.setString( 2, date);
		statement.setString( 3, clinic_code);
		statement.setString( 4, practitioner_id);
		statement.setString( 5, clinic_type);
		statement.setString( 6, res_type);

		// register the out parameter
		statement.registerOutParameter(7, Types.VARCHAR );
		statement.registerOutParameter(8, Types.VARCHAR );
		statement.registerOutParameter(9, Types.INTEGER);
		statement.registerOutParameter(10, Types.INTEGER);
		statement.registerOutParameter(11, Types.INTEGER);
		statement.registerOutParameter(12, Types.INTEGER);
		statement.registerOutParameter(13, Types.VARCHAR );
		statement.registerOutParameter(14, Types.VARCHAR );
		statement.registerOutParameter(15, Types.VARCHAR );
		statement.registerOutParameter(16, Types.VARCHAR );
		statement.registerOutParameter(17, Types.VARCHAR );
		statement.registerOutParameter(18, Types.VARCHAR );
		statement.registerOutParameter(19, Types.VARCHAR );
		statement.registerOutParameter(20, Types.VARCHAR );
		statement.registerOutParameter(21, Types.VARCHAR );
		statement.registerOutParameter(22, Types.VARCHAR );
		statement.registerOutParameter(23, Types.VARCHAR );
		statement.registerOutParameter(24 ,Types.VARCHAR );
		statement.registerOutParameter(25 ,Types.VARCHAR );
		statement.registerOutParameter(26 ,Types.VARCHAR );
		statement.registerOutParameter(27 ,Types.VARCHAR );
		statement.registerOutParameter(28 ,Types.VARCHAR );
		statement.registerOutParameter(29 ,Types.VARCHAR );
		statement.registerOutParameter(30 ,Types.VARCHAR );
		statement.registerOutParameter(31 ,Types.VARCHAR );
		statement.registerOutParameter(32 ,Types.VARCHAR );
		statement.registerOutParameter(33 ,Types.VARCHAR );	
		// set the input for locale
		// this is done here since the callable statement
		// has to be set in order
		statement.setString(34, locale);
		// register some more outputs
		statement.registerOutParameter(35 ,Types.VARCHAR );
		statement.registerOutParameter(36 ,Types.VARCHAR );
		statement.registerOutParameter(37 ,Types.VARCHAR );
		statement.registerOutParameter(38 ,Types.VARCHAR );
		statement.registerOutParameter(39 ,Types.VARCHAR );
		statement.registerOutParameter(40 ,Types.VARCHAR );
		statement.registerOutParameter(41 ,Types.VARCHAR );
		
	}
	
	/**
	 * This method populates the data obtained from the callable statement
	 * into the practitioner time slot response
	 * @param statement
	 * @param practitionerTimeSlotResponse
	 * @throws SQLException
	 */
	private void populateDataInPractitionerTimeSlotResponse(
			CallableStatement statement,
			PractitionerTimeSlotResponse practitionerTimeSlotResponse)
			throws SQLException {
		String practitionerName = statement
				.getString(CreateAppointmentConstants.PRACTITIONER_NAME_INDEX);
		practitionerTimeSlotResponse.setPractitionerName(practitionerName);
		// get the max patients value
		// this value will enable us to create as many timeslot objects
		String maxPatientsStr = statement
				.getString(CreateAppointmentConstants.MAXPATIENTS_INDEX);
		int maxPatients = PortalHelper.getIntegerValue(maxPatientsStr, 0);
		// get the status of the time slots
		String status = statement.getString(CreateAppointmentConstants.TIMESLOT_STATUS_INDEX);
		String fromTime = statement.getString(CreateAppointmentConstants.FROMTIME_INDEX);
		String toTime = statement.getString(CreateAppointmentConstants.TOTIME_INDEX);
		
		// get the error info object so that if any error is detected
		// then the same can be set to the object and code returned from
		// this method
		/*ErrorInfo errorInfo = practitionerTimeSlotResponse.getErrorInfo();*/
		ErrorInfo errorInfo = null;
		// status, from time or to time cannot be null or empty
		if ((status == null || status.trim().equals(""))
				|| (fromTime == null || fromTime.trim().equals(""))
				|| (toTime == null || toTime.trim().equals(""))) {
			int errorCode = CreateAppointmentConstants.PRACTITIONERTIMESLOT_DATANOTVALID_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			practitionerTimeSlotResponse.addError(errorInfo);
			return;
		}
		
		StringTokenizer statusTokenizer = new StringTokenizer(status,
				CreateAppointmentConstants.TOKEN_DELIMITER);
		int statusTokenCount = statusTokenizer.countTokens();
		
		StringTokenizer fromTimeTokenizer = new StringTokenizer(fromTime,
				CreateAppointmentConstants.TOKEN_DELIMITER);
		int fromTimeTokenCount = fromTimeTokenizer.countTokens();
		
		StringTokenizer toTimeTokenizer = new StringTokenizer(toTime,
				CreateAppointmentConstants.TOKEN_DELIMITER);
		int toTimeTokenCount = toTimeTokenizer.countTokens();
		
		// just a small validation 
		// such a scenario is a rare occurrence - but still
		// this code handles this
		if (maxPatients != statusTokenCount
				|| maxPatients != fromTimeTokenCount
				|| maxPatients != toTimeTokenCount) {
			int errorCode = CreateAppointmentConstants.PRACTITIONERTIMESLOT_DATANOTVALID_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			practitionerTimeSlotResponse.addError(errorInfo);
			return;
		}
		// initialize the time slot list - this will be set to response
		List<TimeSlot> timeSlotList = new ArrayList<TimeSlot>();
		TimeSlot timeSlot = null;
		String statusVal = null;
		String fromTimeVal = null;
		String toTimeVal = null;
		// iterate as per the number of patients and form
		// time slots
		for(int count=0;count<maxPatients;count++){
			statusVal = statusTokenizer.nextToken();
			// status is found here
			// only free slots are to be considered
			// if the status is not a free slot then we have to 
			// ignore this slot
			if(!CreateAppointmentConstants.FREE_TIMESLOT_IDENTIFIER.equalsIgnoreCase(statusVal)){
				// move the from time and to time tokens one step
				fromTimeTokenizer.nextToken();
				toTimeTokenizer.nextToken();
				continue;
			}
			fromTimeVal = fromTimeTokenizer.nextToken();
			toTimeVal = toTimeTokenizer.nextToken();
			// initialize the time slot object and set the data
			timeSlot = new TimeSlot();
			timeSlot.setStartTime(fromTimeVal);
			timeSlot.setEndTime(toTimeVal);
			timeSlot.setSlotStatus(TimeSlotStatus.FREESLOT);
			timeSlotList.add(timeSlot);
		}
		// finally set success code to the error info object
		// indicating getting the records is a success
		/*errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);*/
		practitionerTimeSlotResponse.setTimeSlots(timeSlotList);
		
	}
	
	/**
	 * This method will those time slots which are already booked
	 * as appointment requests
	 * 
	 * @param conn
	 * @param request
	 * @param response
	 * @throws SQLException
	 */
	private void filterApptRequestsFromResponse(Connection conn,
			PractitionerTimeSlotRequest request,
			PractitionerTimeSlotResponse response) throws SQLException {
		// inspect the response - if it is already erroneous then
		// no need to filter
		if(response.hasErrors() && !response.isSuccessful()){
			return;
		}
		/*ErrorInfo errorInfo = response.getErrorInfo();
		if(ErrorInfo.SUCCESS_CODE != errorInfo.getErrorCode()){
			return;
		}*/
		
		String sqlQuery = getFilterApptRequestsQuery();
		PreparedStatement preparedStmt = null;
		preparedStmt = conn.prepareStatement(sqlQuery);
		setDataInPrepStmtForFilteringApptRequests(preparedStmt,request);
		ResultSet resultSet = preparedStmt.executeQuery();
		// nothing much to do - just return
		if(resultSet == null){
			return;
		}
		// this list is used to store the booked time slots
		List<TimeSlot> bookedTimeSlotList = new ArrayList<TimeSlot>();
		Date preferredStartTimeObj = null;
		Date preferredEndTimeObj = null;
		String preferredStartTimeStr = null;
		String preferredEndTimeStr = null;
		final String TIME_FORMAT = "HH:mm";
		TimeSlot timeSlot = null;
		// iterate through the result set and get the data
		// this data basically the time slots booked as appointment requests
		while(resultSet.next()){
			preferredStartTimeObj = resultSet.getTimestamp("pref_from_time");
			preferredEndTimeObj = resultSet.getTimestamp("pref_to_time");
			
			preferredStartTimeStr = PortalHelper.getDateAsString(
					preferredStartTimeObj, TIME_FORMAT);
			preferredEndTimeStr = PortalHelper.getDateAsString(
					preferredEndTimeObj, TIME_FORMAT);
			
			timeSlot = new TimeSlot();
			timeSlot.setStartTime(preferredStartTimeStr);
			timeSlot.setEndTime(preferredEndTimeStr);
			bookedTimeSlotList.add(timeSlot);
		}
		// no data to filter - just return
		if(bookedTimeSlotList.isEmpty()){
			return;
		}
		// this is the actual data obtained from back end
		// this list is filtered by referring the to be filtered list
		List<TimeSlot> actualTimeSlotList = response.getTimeSlots();
		// iterate through the booked time slot list
		// and check if each object is present in the actual time slot as well
		// if so, remove that object from the actual time slot list
		for(TimeSlot slot : bookedTimeSlotList){
			if(actualTimeSlotList.contains(slot)){
				actualTimeSlotList.remove(slot);
			}
		}
		ErrorInfo errorInfo = null;
		// final check if the actual time slot list is emptied
		if(actualTimeSlotList.isEmpty()){
			int errorCode = CreateAppointmentConstants.PRACTITIONERTIMESLOT_EMPTYDATA_ERRORCODE;
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			errorInfo.setErrorMessage(errorMessage);
			response.addError(errorInfo);
			/*return;*/
		}
	}
	
	/**
	 * This method gets the SQL query needed for filtering
	 * the appointment requests
	 * @return
	 */
	private String getFilterApptRequestsQuery(){
		StringBuffer queryBuffer = new StringBuffer();
		queryBuffer.append("select preferred_date_time,pref_from_time,pref_to_time from pr_wait_list ");
		queryBuffer.append(" where web_req_yn = ? ");
		queryBuffer.append(" and preferred_date_time = to_date(?,'dd/mm/yyyy') ");
		queryBuffer.append(" and wait_list_status = ? ");
		queryBuffer.append(" order by preferred_date_time asc, pref_from_time asc ");
		return queryBuffer.toString();
	}
	
	/**
	 * This method sets the data in the prepared statement object
	 * by referring data from the request object
	 * this method is used in filtering the appointment requests
	 * @param preparedStmt
	 * @param request
	 * @throws SQLException
	 */
	private void setDataInPrepStmtForFilteringApptRequests(
			PreparedStatement preparedStmt, PractitionerTimeSlotRequest request)
			throws SQLException {
		int index = 1;
		preparedStmt.setString(index,
				CreateAppointmentConstants.APPOINTMENT_WEBREQUEST_PARAM_VALUE);
		index++;
		
		String preferredDate = request.getPreferredDate();
		if(preferredDate == null){
			preferredDate = "";
		}
		preparedStmt.setString(index, preferredDate);
		index++;
		
		preparedStmt.setString(index,
				CreateAppointmentConstants.APPOINTMENT_WAITLIST_STATUS_VALUE);
	}
	
	
	/**
	 * This is only for test purpose
	 * @param args
	 */
	/*public static void main(String[] args){
		
		String facilityId = "HS";
		String date = "27/03/2013";
		date = "22/03/2013";
		date = "03/04/2013";
		date = "15/04/2013";
		date = "07/05/2013";
		date = "15/05/2013";
		String clinic_code = "AC4";
		clinic_code = "355";
		clinic_code = "1234";
		//clinic_code = "";
		String practitioner_id = "AFNIZAR";
		practitioner_id = "AKBARS";
		practitioner_id = "299355";
		practitioner_id = "AFIDA";
		String clinic_type = "C";
		String res_type = "P";
		String locale = "en";
		
		PractitionerTimeSlotRequest request = new PractitionerTimeSlotRequest();
		request.setClinicCode(clinic_code);
		request.setClinicType(clinic_type);
		request.setFacilityId(facilityId);
		request.setLocale(locale);
		request.setPractitionerId(practitioner_id);
		request.setPreferredDate(date);
		request.setResourceType(res_type);
		
		PractitionerTimeSlotDAC dacInst = new PractitionerTimeSlotDAC();
		PractitionerTimeSlotResponse response = dacInst.getPractitionerTimeSlot(request);
		
		// now print the results
		String xmlFileContent = "";
		if (response != null) {
			Writer writer = new StringWriter();
			try {
				JAXBContext jaxbContext = JAXBContext
						.newInstance(PractitionerTimeSlotResponse.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(response, writer);
				xmlFileContent = writer.toString();
				System.out.println(xmlFileContent);
			} catch (PropertyException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
			
		}
	}*/
	
	
}
