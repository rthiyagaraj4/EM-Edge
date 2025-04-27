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
 * This is the request class for the practitioner schedule status
 * service
 * This class extends the PractitionerStatusRequest
 * @author GRamamoorthy
 *
 */
public class PractitionerScheduleStatusRequest extends
		PractitionerStatusRequest {

	/**
	 * data members in this class
	 */
	private String preferredFromDate =  null;
	
	private String preferredToDate = null;

	/**
	 * @return the preferredFromDate
	 */
	public String getPreferredFromDate() {
		return preferredFromDate;
	}

	/**
	 * @param preferredFromDate the preferredFromDate to set
	 */
	public void setPreferredFromDate(String preferredFromDate) {
		this.preferredFromDate = preferredFromDate;
	}

	/**
	 * @return the preferredToDate
	 */
	public String getPreferredToDate() {
		return preferredToDate;
	}

	/**
	 * @param preferredToDate the preferredToDate to set
	 */
	public void setPreferredToDate(String preferredToDate) {
		this.preferredToDate = preferredToDate;
	}
	
}
