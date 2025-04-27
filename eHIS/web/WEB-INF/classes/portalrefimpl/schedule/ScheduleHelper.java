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
package portalrefimpl.schedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import portalrefimpl.PortalHelper;
import portalrefimpl.schedule.createappointment.AppointmentTime;
import portalrefimpl.schedule.createappointment.AppointmentTimeRequest;
import portalrefimpl.schedule.createappointment.AppointmentTimeResponse;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;
import portalrefimpl.schedule.createappointment.response.PractitionerScheduleResponse;
import portalrefimpl.schedule.createappointment.response.Schedule;

/**
 * @author GRamamoorthy
 * 
 */
public class ScheduleHelper {

	/**
	 * 
	 */
	private static AppointmentTimeResponse appointmentFromTimeResponse = null;
	
	/**
	 * 
	 */
	private static AppointmentTimeResponse appointmentToTimeResponse = null;
	
	/**
	 * This method returns a list of appointment times given a request object
	 * containing the type of appointment
	 * 
	 * @param request
	 * @return
	 */
	public static AppointmentTimeResponse getBookApptTimeList(AppointmentTimeRequest request){
		AppointmentTimeResponse response = new AppointmentTimeResponse();
		List<AppointmentTime> timeList = new ArrayList<AppointmentTime>();
		response.setAppointmentTimeList(timeList);
		
		// as is, the request time type will not be considered now since
		// for both the start time and the to time, the same set of
		// times needs to be returned
		// however, in future if we have to accommodate enhancements, it is possible
		
		// based on the time type, read the time string from properties file 
		int timeType = request.getTimeType();
		String timeString = null;
		if(ScheduleConstants.BOOKAPPT_START_TIME_IDENTIFIER == timeType){
			timeString = PortalHelper.getConfigPropertyValue(ScheduleConstants.BOOKAPPT_START_TIME_PROP_KEY,true);
		}else if(ScheduleConstants.BOOKAPPT_TO_TIME_IDENTIFIER ==  timeType){
			timeString = PortalHelper.getConfigPropertyValue(ScheduleConstants.BOOKAPPT_START_TIME_PROP_KEY,true);
		}
		// safe check
		if(timeString == null || timeString.trim().equals("")){
			return response;
		}
		
		// using tokenizer to read the different time values which
		// are concatenated using delimiter
		StringTokenizer tokenizer = new StringTokenizer(timeString,
				ScheduleConstants.BOOKAPPT_TIME_DELIMITER);
		String timeToken = null;
		final int DISPLAY_DATA_TOKEN_COUNT = 2;
		String displayValue = null;
		String dataValue = null;
		AppointmentTime apptTime = null;
		// iterate through the tokens, form appointment time objects
		// and add it to list
		while(tokenizer.hasMoreTokens()){
			timeToken = tokenizer.nextToken();
			StringTokenizer displayDataTokenizer = new StringTokenizer(
					timeToken,
					ScheduleConstants.BOOKAPPT_DISPLAY_DATA_TIME_DELIMITER);
			if (DISPLAY_DATA_TOKEN_COUNT == displayDataTokenizer.countTokens()) {
				displayValue = displayDataTokenizer.nextToken();
				dataValue = displayDataTokenizer.nextToken();
				apptTime = new AppointmentTime(displayValue, dataValue);
			} else {
				// for safe keeps
				apptTime = new AppointmentTime(timeToken);
			}

			timeList.add(apptTime);
		}

		return response;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	public static AppointmentTimeResponse getAppointmentTimeResponse(
			AppointmentTimeRequest request) {
		AppointmentTimeResponse response = null;
		int timeType = request.getTimeType();
		if (ScheduleConstants.BOOKAPPT_START_TIME_IDENTIFIER == timeType) {
			if(appointmentFromTimeResponse == null){
				appointmentFromTimeResponse = getBookApptTimeList(request);	
			}
			response = appointmentFromTimeResponse;
		} else if (ScheduleConstants.BOOKAPPT_TO_TIME_IDENTIFIER == timeType) {
			if(appointmentToTimeResponse == null){
				appointmentToTimeResponse = getBookApptTimeList(request);	
			}
			response = appointmentToTimeResponse;
		}
		return response;
	}
	
	/**
	 * This method takes in a string representing a time value in the format HH.MM
	 * and converts it into a string in the format HH:MM
	 * @param selectedApptTime
	 * @return
	 */
	public static String getApptSelectedTimeInDisplayFormat(String selectedApptTime){
		StringBuffer displayBuffer = new StringBuffer(selectedApptTime);
		int dotIndex = selectedApptTime.indexOf(".");
		if(dotIndex > 0){
			displayBuffer.delete(0, displayBuffer.length());
			displayBuffer.append(selectedApptTime.substring(0, dotIndex));
			displayBuffer.append(":");
			displayBuffer.append(selectedApptTime.subSequence(dotIndex + 1,
					selectedApptTime.length()));
		}
		
		return displayBuffer.toString();
	}

	/**
	 * This is an utility method to be used in the practitioner schedule service
	 * while setting the data obtained from back end.
	 * 
	 * @param inputValue
	 * @return
	 */
	public static Date getDateInApplicationFormat(Date inputValue){
		Date returnValue = null;
		// safe check
		if(inputValue == null){
			return returnValue;
		}
		
		// logic is to convert the input date value to string value
		// using the simple date format object and then convert the
		// string value to a date object once again
		SimpleDateFormat formatter = new SimpleDateFormat(
				CreateAppointmentConstants.PRACTITIONER_SERVICE_PREFERRED_DATE_FORMAT);
		String formattedDateString = formatter.format(inputValue);
		try {
			returnValue = formatter.parse(formattedDateString);
		} catch (ParseException e) {
			returnValue = inputValue;
		}
		
		return returnValue;
	}
	
	
	/**
	 * This method helps return the practitioner schedule information
	 * in a map where the keys are the schedule dates and the value
	 * is the list of schedule objects which are used to retrieve
	 * the start and end time of individual schedules
	 * @param practitionerScheduleResponse
	 * @return
	 */
	public static Map<Date, List<Schedule>> getPractitionerScheduleForDisplay(
			PractitionerScheduleResponse practitionerScheduleResponse) {
		Map<Date, List<Schedule>> scheduleMap = new LinkedHashMap<Date, List<Schedule>>();
		// there is no need to perform safe checks on the response object
		// this method will be called with a proper response object only
		List<Schedule> scheduleList = practitionerScheduleResponse.getScheduleList();
		Date scheduleDate = null;
		List<Schedule> childScheduleList = null;
		Schedule scheduleObj = null;
		// iterate through the schedule list and populate the map
		for(Schedule schedule : scheduleList){
			scheduleDate = schedule.getScheduleDate();
			// this line depends on the date comparison which will be invoked
			// internally by the java API
			if(scheduleMap.containsKey(scheduleDate)){
				childScheduleList = scheduleMap.get(scheduleDate);
			}else{
				childScheduleList = new ArrayList<Schedule>();
				scheduleMap.put(scheduleDate, childScheduleList);
			}
			
			scheduleObj = new Schedule();
			scheduleObj.setStartTime(schedule.getStartTime());
			scheduleObj.setEndTime(schedule.getEndTime());
			scheduleObj.setScheduleDate(scheduleDate);
			
			childScheduleList.add(scheduleObj);
		}
		
		return scheduleMap;
	}
	
	/**
	 * This method formats the preferred date given as string
	 * based on the given display format and returns the same
	 * @param preferredDateStr
	 * @param dateFormat
	 * @param displayFormat
	 * @return
	 */
	public static String getPreferredDateInDisplayFormat(
			String preferredDateStr, String dateFormat, String displayFormat) {
		String displayStr = preferredDateStr;
		Date preferredDate = PortalHelper.getDateFromString(preferredDateStr,
				dateFormat);
		if (preferredDate != null) {
			SimpleDateFormat dateFormatter = null;
			try {
				dateFormatter = new SimpleDateFormat(displayFormat);
				displayStr = dateFormatter.format(preferredDate);
			} catch (Exception e) {
				// cannot do much
			}
		}

		return displayStr;
	}
	
	/**
	 * This method gets the end date in string format for time slot selection
	 * in book appointment functionality
	 * for time slot selection, the end date has to be 1 month ahead of the 
	 * from date
	 * @param preferredFromDateStr
	 * @return
	 */
	public static String getPreferredEndDateForTimeSlot(String preferredFromDateStr){
		String endDateStr = null;
		Date dateVal = PortalHelper.getDateFromString(preferredFromDateStr,
				CreateAppointmentConstants.PRACTITIONERSTATUS_DATEFORMAT);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(dateVal);
		endCalendar.add(Calendar.DATE,
				CreateAppointmentConstants.BOOKAPPT_PREFERREDENDDATE_RANGE);
		endDateStr = PortalHelper.getDateAsString(endCalendar.getTime(),
				CreateAppointmentConstants.PRACTITIONERSTATUS_DATEFORMAT);
		
		return endDateStr;
	}
}
