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

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import portalrefimpl.common.response.BaseResponse;

/**
 * This response class is used in the practitioner schedule status
 * service
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "Practitioner")
public class PractitionerScheduleStatusResponse extends BaseResponse {

	/**
	 * Data members in this class
	 */
	private String practitionerId = null;
	
	private String practitionerName = null;
	
	private String preferredFromDate = null;
	
	private String preferredToDate = null;
	
	private List<ScheduleStatus> scheduleDateList = null;

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
	 * @return the preferredFromDate
	 */
	@XmlElement(name = "PreferredFromDate")
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
	@XmlElement(name = "PreferredToDate")
	public String getPreferredToDate() {
		return preferredToDate;
	}

	/**
	 * @param preferredToDate the preferredToDate to set
	 */
	public void setPreferredToDate(String preferredToDate) {
		this.preferredToDate = preferredToDate;
	}

	/**
	 * @return the scheduleDateList
	 */
	@XmlElementWrapper(name = "ScheduleStatusDetails")
	@XmlElement(name = "Schedule")
	public List<ScheduleStatus> getScheduleDateList() {
		return scheduleDateList;
	}

	/**
	 * @param scheduleDateList the scheduleDateList to set
	 */
	public void setScheduleDateList(List<ScheduleStatus> scheduleDateList) {
		this.scheduleDateList = scheduleDateList;
	}
	
}
