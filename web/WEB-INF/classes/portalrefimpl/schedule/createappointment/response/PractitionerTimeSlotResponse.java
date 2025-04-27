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
package portalrefimpl.schedule.createappointment.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import portalrefimpl.PortalHelper;
import portalrefimpl.common.response.BaseResponse;
import portalrefimpl.schedule.createappointment.CreateAppointmentConstants;

/**
 * This is the response class for the practitioner time slot
 * service
 * This class extends BaseResponse class
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "Practitioner")
public class PractitionerTimeSlotResponse extends BaseResponse {

	/**
	 * Data members in this class
	 */
	private String practitionerId = null;
	
	private String practitionerName = null;
	
	private Date preferredDate = null;
	
	private List<TimeSlot> timeSlots = null;

	/**
	 * @return the practitionerId
	 */
	@XmlElement(name = "PractitionerId")
	public String getPractitionerId() {
		return practitionerId;
	}

	/**
	 * @param practitionerId the practitionerId to set
	 */
	public void setPractitionerId(String practitionerId) {
		this.practitionerId = practitionerId;
	}

	/**
	 * @return the practitionerName
	 */
	@XmlElement(name = "PractitionerName")
	public String getPractitionerName() {
		return practitionerName;
	}

	/**
	 * @param practitionerName the practitionerName to set
	 */
	public void setPractitionerName(String practitionerName) {
		this.practitionerName = practitionerName;
	}

	/**
	 * @return the preferredDate
	 */
	@XmlElement(name = "PreferredDate")
	public Date getPreferredDate() {
		return preferredDate;
	}

	/**
	 * @param preferredDate the preferredDate to set
	 */
	public void setPreferredDate(Date preferredDate) {
		this.preferredDate = preferredDate;
	}

	/**
	 * @return the timeSlots
	 */
	@XmlElementWrapper(name = "TimeSlots")
	@XmlElement(name = "TimeSlot")
	public List<TimeSlot> getTimeSlots() {
		return timeSlots;
	}

	/**
	 * @param timeSlots the timeSlots to set
	 */
	public void setTimeSlots(List<TimeSlot> timeSlots) {
		this.timeSlots = timeSlots;
	}

	/**
	 * Helper method to get those time slots whose start time
	 * fall in the morning period - that is from 00:00 hrs till 11:59 AM
	 * @return
	 */
	public List<List<TimeSlot>> getMorningAndEveningTimeSlots(){
		// list which will contain morning and evening time slots
		// morning and evening time slots will be stored in separate lists 
		List<List<TimeSlot>> morningAndEveningTimeSlots = new ArrayList<List<TimeSlot>>();
		List<TimeSlot> morningTimeSlots = new ArrayList<TimeSlot>();
		List<TimeSlot> eveningTimeSlots = new ArrayList<TimeSlot>();
		morningAndEveningTimeSlots.add(morningTimeSlots);
		morningAndEveningTimeSlots.add(eveningTimeSlots);
		
		// first a simple check
		if(timeSlots == null || timeSlots.isEmpty()){
			return morningAndEveningTimeSlots;
		}
		
		// iterate through the list of time slots and arrange it as per morning
		// and evening times - the start time of the time slot is only considered
		// if the start time falls within morning range (00:00 - 11:59 AM), then
		// it will be added to morning time slots
		// same with evening time slots where the time range is (12:00 PM - 23:59 PM)
		String startTime = null;
		int hrIndex = -1;
		String hrStr = null;
		int hrValue = -1;
		for(TimeSlot timeSlot : timeSlots){
			startTime = timeSlot.getStartTime();
			hrIndex = startTime
					.indexOf(CreateAppointmentConstants.TIMESLOT_HOUR_DELIMITER);
			// signifies invalid entry - just ignore
			if(hrIndex <= 0){
				continue;
			}
			hrStr = startTime.substring(0, hrIndex);
			hrValue = PortalHelper.getIntegerValue(hrStr, -1);
			if(hrValue < 0){
				continue;
			}
			// this signifies morning time
			if(hrValue >= 0 && hrValue <= 11){
				morningTimeSlots.add(timeSlot);
			}else{
				eveningTimeSlots.add(timeSlot);
			}
		}
		
		return morningAndEveningTimeSlots;
	}
	
	
	
}
