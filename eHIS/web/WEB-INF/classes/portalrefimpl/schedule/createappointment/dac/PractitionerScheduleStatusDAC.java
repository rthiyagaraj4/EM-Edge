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
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.createappointment.request.PractitionerScheduleStatusRequest;
import portalrefimpl.schedule.createappointment.response.PractitionerScheduleStatusResponse;
import portalrefimpl.schedule.createappointment.response.ScheduleStatus;
import portalrefimpl.schedule.createappointment.response.ScheduleStatusEnum;

/**
 * This is the DAC class for the practitioner schedule status service
 * @author GRamamoorthy
 *
 */
public class PractitionerScheduleStatusDAC {

	/**
	 * This method gets the schedule status over a date range
	 * for a practitioner
	 * @param practitionerScheduleStatusRequest
	 * @return
	 */
	public PractitionerScheduleStatusResponse getPractitionerScheduleStatus(
			PractitionerScheduleStatusRequest practitionerScheduleStatusRequest) {
		// initialize the response object
		PractitionerScheduleStatusResponse practitionerScheduleStatusResponse = new PractitionerScheduleStatusResponse();
		/*ErrorInfo errorInfo = new ErrorInfo();*/
		ErrorInfo errorInfo = null;
		/*practitionerScheduleStatusResponse.setErrorInfo(errorInfo);*/
		
		// some of the parameters in request object are also present in response
		// so initially set it in the response object by reading the request object
		String practitionerId = practitionerScheduleStatusRequest.getPractitionerId();
		practitionerScheduleStatusResponse.setPractitionerId(practitionerId);
		String preferredFromDateStr = practitionerScheduleStatusRequest.getPreferredFromDate();
		practitionerScheduleStatusResponse.setPreferredFromDate(preferredFromDateStr);
		String preferredToDateStr = practitionerScheduleStatusRequest.getPreferredToDate();
		practitionerScheduleStatusResponse.setPreferredToDate(preferredToDateStr);
		
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
			practitionerScheduleStatusResponse.addError(errorInfo);
			return practitionerScheduleStatusResponse;
		}
		// stored procedure needs to be executed now
		String sqlQuery = "{call oa_schedules.get_day_status( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		// instance of callable statement object which will help in executing
		// the stored procedure
		CallableStatement callStmt = null;
		// execute the statement and then call the method to populate 
		// date in the response object
		try {
			callStmt = conn.prepareCall(sqlQuery);
			populateDateInResponse(callStmt,
					practitionerScheduleStatusResponse,
					practitionerScheduleStatusRequest);
			// finally there is a need to set a positive response
			if(!practitionerScheduleStatusResponse.hasErrors()){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);
				practitionerScheduleStatusResponse.addError(errorInfo);
			}
		} catch (SQLException e) {
			int errorCode = CreateAppointmentConstants.PRACTITIONERTIMESLOT_SQLEXCEPTION_ERRORCODE;
			errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(errorCode);
			String errorMessage = MessageContainer.getInstance()
					.getDisplayMessage(
							CommonConstants.CREATE_APPOINTMENT_MODULE_NAME,
							errorCode);
			errorInfo.setErrorMessage(errorMessage);
			practitionerScheduleStatusResponse.addError(errorInfo);
		}
		
		return practitionerScheduleStatusResponse;
	}
	
	/**
	 * This method sets data to the callable statement, executes it 
	 * and then gets the data from it and populates it in the response object
	 * 
	 * @param callStmt
	 * @param response
	 * @throws SQLException
	 */
	private void populateDateInResponse(CallableStatement statement,
			PractitionerScheduleStatusResponse response,
			PractitionerScheduleStatusRequest request) throws SQLException {
		// main logic - date value is set to the statement object
		// starting from preferred date, the statement object is executed, 
		// data is obtained from statement, date is incremented by 1 more day
		// and again statement is executed - this is done for 1 month starting
		// from preferred date
		
		// get the data from the request object
		String facilityId = request.getFacilityId();
		String clinic_code = request.getClinicCode();
		String practitioner_id = request.getPractitionerId();
		String clinic_type = request.getClinicType();
		String res_type = request.getResourceType();
		String locale = request.getLocale();
		
		// the following code sets the data to the callable statement
		// and also registers the out parameter
		statement.setString( 1, facilityId);
		statement.setString( 3, clinic_code);
		statement.setString( 4, practitioner_id);
		statement.setString( 5, clinic_type);
		statement.setString( 6, res_type);
		
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
		statement.setString(34, locale);
		statement.registerOutParameter(35 ,Types.VARCHAR );
		statement.registerOutParameter(36 ,Types.VARCHAR );
		statement.registerOutParameter(37 ,Types.VARCHAR );
		statement.registerOutParameter(38 ,Types.VARCHAR );
		statement.registerOutParameter(39 ,Types.VARCHAR );
		statement.registerOutParameter(40 ,Types.VARCHAR );
		statement.registerOutParameter(41 ,Types.VARCHAR );
		
		// the  date 
		// preferred from date is the preferred date specified by user
		String dateStr = request.getPreferredFromDate();
		Date date = PortalHelper.getDateFromString(dateStr,
				CreateAppointmentConstants.PRACTITIONERSTATUS_DATEFORMAT);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		long calTimeMillis = calendar.getTimeInMillis();
		//date = "22/03/2013";
		String endDateStr = request.getPreferredToDate();
		Date endDate = PortalHelper.getDateFromString(endDateStr,
				CreateAppointmentConstants.PRACTITIONERSTATUS_DATEFORMAT);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);
		long endCalTimeMillis = endCalendar.getTimeInMillis();
		
		// temp vars
		String practitionerName = null;
		String timeSlotStatus = null;
		String perSlotStatus = null;
		
		List<ScheduleStatus> scheduleStatusList = new ArrayList<ScheduleStatus>();
		ScheduleStatus scheduleStatus = null;
		ScheduleStatusEnum scheduleStatusEnum = null;
		
		String runningDateStr = dateStr;
		// loop through and execute the statement
		while(endCalTimeMillis >= calTimeMillis){
			statement.setString(2, runningDateStr);
			statement.execute();
			// practitioner name need not be obtained everytime
			if(practitionerName == null){
				practitionerName = statement
						.getString(CreateAppointmentConstants.PRACTITIONER_NAME_INDEX);	
				response.setPractitionerName(practitionerName);
			}
			
			timeSlotStatus = statement
					.getString(CreateAppointmentConstants.TIMESLOT_STATUS_INDEX);
			// schedule status enum is calculated here
			scheduleStatusEnum = ScheduleStatusEnum.LEAVE;
			if(timeSlotStatus != null && !timeSlotStatus.trim().equals("")){
				StringTokenizer statusTokenizer = new StringTokenizer(
						timeSlotStatus,
						CreateAppointmentConstants.TOKEN_DELIMITER);
				int tokenCount = statusTokenizer.countTokens();
				if(tokenCount > 0){
					boolean isFree = false;
					while(statusTokenizer.hasMoreTokens()){
						perSlotStatus = statusTokenizer.nextToken();
						if (CreateAppointmentConstants.FREE_TIMESLOT_IDENTIFIER
								.equalsIgnoreCase(perSlotStatus)) {
							scheduleStatusEnum = ScheduleStatusEnum.FREE;
							isFree = true;
							break;
						}
					}	
					if(!isFree){
						scheduleStatusEnum = ScheduleStatusEnum.BLOCKED;
					}
				}
			}
			// initialize the schedule status object and add it to list
			scheduleStatus = new ScheduleStatus(runningDateStr,scheduleStatusEnum);
			scheduleStatusList.add(scheduleStatus);
			
			// need to update the calendar and running date str
			calendar.add(Calendar.DATE, 1);
			calTimeMillis = calendar.getTimeInMillis();
			runningDateStr = PortalHelper.getDateAsString(calendar.getTime(),
					CreateAppointmentConstants.PRACTITIONERSTATUS_DATEFORMAT);
		}
		// update the error code to success
		/*ErrorInfo errorInfo = response.getErrorInfo();
		errorInfo.setErrorCode(ErrorInfo.SUCCESS_CODE);*/
		response.setScheduleDateList(scheduleStatusList);
	}
	
	/**
	 * 
	 * @param args
	 */
	/*public static void main(String[] args){
		
		String facilityId = "HS";
		String date = "27/03/2013";
		date = "22/03/2013";
		date = "15/04/2013";
		date = "20/04/2013";
		date = "07/05/2013";
		String clinic_code = "AC4";
		//clinic_code = "";
		clinic_code = "1234";
		String practitioner_id = "AFNIZAR";
		//practitioner_id = "AKBARS";
		practitioner_id = "AFIDA";
		String clinic_type = "C";
		//clinic_type = "";
		String res_type = "P";
		// this is for calculating the end date
		Date dateVal = PortalHelper.getDateFromString(date, "dd/MM/yyyy");
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(dateVal);
		endCalendar.add(Calendar.DATE, CreateAppointmentConstants.BOOKAPPT_PREFERREDENDDATE_RANGE);
		String endDateStr = PortalHelper.getDateAsString(endCalendar.getTime(), "dd/MM/yyyy");
		
		
		PractitionerScheduleStatusRequest request = new PractitionerScheduleStatusRequest();
		request.setFacilityId(facilityId);
		request.setPractitionerId(practitioner_id);
		request.setClinicCode(clinic_code);
		request.setClinicType(clinic_type);
		request.setResourceType(res_type);
		request.setLocale(Locale.getDefault().getLanguage());
		request.setPreferredFromDate(date);
		request.setPreferredToDate(endDateStr);
		
		PractitionerScheduleStatusDAC dacInst = new PractitionerScheduleStatusDAC();
		PractitionerScheduleStatusResponse response = dacInst.getPractitionerScheduleStatus(request);
		
		// now print the results
		String xmlFileContent = "";
		if (response != null) {
			Writer writer = new StringWriter();
			try {
				JAXBContext jaxbContext = JAXBContext
						.newInstance(PractitionerScheduleStatusResponse.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(response, writer);
				xmlFileContent = writer.toString();
				//System.out.println(xmlFileContent);
			} catch (PropertyException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
	}*/
	
	
}
