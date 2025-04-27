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
package portalrefimpl.schedule.createappointment.request;


/**
 * This is the request class for the practitioner time slot
 * service
 * This class extends PractitionerStatusRequest class
 * @author GRamamoorthy
 *
 */
public class PractitionerTimeSlotRequest extends PractitionerStatusRequest {

	/**
	 * Data members
	 */
	private String preferredDate = null;
	
	private String preferredStartTime = null;
	
	private String preferredEndTime = null;

	/**
	 * @return the preferredDate
	 */
	public String getPreferredDate() {
		return preferredDate;
	}

	/**
	 * @param preferredDate the preferredDate to set
	 */
	public void setPreferredDate(String preferredDate) {
		this.preferredDate = preferredDate;
	}

	/**
	 * @return the preferredStartTime
	 */
	public String getPreferredStartTime() {
		return preferredStartTime;
	}

	/**
	 * @param preferredStartTime the preferredStartTime to set
	 */
	public void setPreferredStartTime(String preferredStartTime) {
		this.preferredStartTime = preferredStartTime;
	}

	/**
	 * @return the preferredEndTime
	 */
	public String getPreferredEndTime() {
		return preferredEndTime;
	}

	/**
	 * @param preferredEndTime the preferredEndTime to set
	 */
	public void setPreferredEndTime(String preferredEndTime) {
		this.preferredEndTime = preferredEndTime;
	}

	
	
}
