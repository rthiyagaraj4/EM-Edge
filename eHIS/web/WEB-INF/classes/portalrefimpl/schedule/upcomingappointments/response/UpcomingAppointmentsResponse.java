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
package portalrefimpl.schedule.upcomingappointments.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import portalrefimpl.common.model.Facility;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.common.response.ErrorInfo;

/**
 * This class represents the response object which will be sent from the view
 * upcoming appointment details service.
 * 
 * This contains the data which will be sent back from the DAC to all the
 * preceding layers until the UI
 * 
 * @author SaraswathiR
 * 
 */

@XmlRootElement(name = "UpcomingAppointments")
public class UpcomingAppointmentsResponse extends BaseResponse {

	private List<UpcomingAppointmentDetails> upcomingAppointmentsList = null;

	/**
	 * Default constructor
	 */
	public UpcomingAppointmentsResponse() {
	}

	/**
	 * @return the upcomingAppointmentsList
	 */
	@XmlElementWrapper(name = "AppointmentDetails")
	@XmlElement(name = "AppointmentDetail")
	public List<UpcomingAppointmentDetails> getUpcomingAppointmentsList() {
		return upcomingAppointmentsList;
	}

	/**
	 * @param upcomingAppointmentsList
	 *            the upcomingAppointmentsList to set
	 */
	public void setUpcomingAppointmentsList(List<UpcomingAppointmentDetails> upcomingAppointmentsList) {
		this.upcomingAppointmentsList = upcomingAppointmentsList;
	}

	/**
	 * Method to get the facility object list from the upcoming appointment list
	 */
	public List<Facility> getUpcomingAppointmentsFacilityList() {
		List<Facility> upcomingAppointmentsFacilityList = new ArrayList<Facility>();
		List<UpcomingAppointmentDetails> upcomingAppointmentsList = getUpcomingAppointmentsList();

		for (UpcomingAppointmentDetails d : upcomingAppointmentsList) {
			Facility facility = new Facility();
			facility.setFacilityId(d.getFacilityId());
			facility.setFacilityName(d.getFacilityName());
			if(!upcomingAppointmentsFacilityList.contains(facility)){
				upcomingAppointmentsFacilityList.add(facility);	
			}
		}

		return upcomingAppointmentsFacilityList;

	}

	/**
	 * This method returns a boolean flag indicating the success
	 * state of this response
	 * Difference from the super class implementation is that
	 * there is no check for the number of error info object
	 * in the errors list - in this response, there would
	 * be an error info object for the appointments in EM
	 * and for the appointment requests in portal
	 */
	public boolean isSuccessful() {
		boolean isSuccessful = false;
		// just for safety
		if(errors == null || errors.isEmpty()){
			return isSuccessful;
		}
		// iterate through the errors and check
		// even if one of the error info objects
		// is successful, then the whole response
		// is successful
		for(ErrorInfo errorInfo : errors){
			if(ErrorInfo.SUCCESS_CODE == errorInfo.getErrorCode()){
				isSuccessful = true;
				break;
			}
		}
		
		return isSuccessful;
	}

	/**
	 * This method does not consider the error codes
	 * for not getting appointments and appointment request
	 */
	/*protected boolean shouldConsiderErrorObject(ErrorInfo errorInfo) {
		boolean shouldConsider = true;
		int errorCode = errorInfo.getErrorCode();
		if(ScheduleConstants.UPCOMING_APPTS_NULLRESULTSET_ERRORCODE != errorCode  ||
			ScheduleConstants.UPCOMING_APPTS_SQLEXCEPTION_ERRORCODE != errorCode  ||	
			ScheduleConstants.UPCOMING_APPTS_NOTOBTAINED_ERRORCODE != errorCode   || 
			ScheduleConstants.UPCOMING_APPTREQ_NULLRESULTSET_ERRORCODE != errorCode ||
			ScheduleConstants.UPCOMING_APPTREQ_SQLEXCEPTION_ERRORCODE != errorCode  ||
			ScheduleConstants.UPCOMING_APPTREQ_NOTOBTAINED_ERRORCODE != errorCode   ||
			ErrorInfo.SUCCESS_CODE != errorCode){
			shouldConsider = false;
		}
		
		return shouldConsider;
	}*/

}
