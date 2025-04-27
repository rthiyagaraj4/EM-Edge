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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This model class stores the status of a scheduled date for a practitioner
 * This model class is used in the response object of practitioner schedule
 * status service
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "Schedule")
public class ScheduleStatus {

	/**
	 * data members in this class
	 */
	private String scheduleDate = null;
	
	private ScheduleStatusEnum status = null;
	
	/**
	 * Default constructor of the class
	 */
	public ScheduleStatus(){
		
	}
	
	/**
	 * @param scheduleDate
	 * @param status
	 */
	public ScheduleStatus(String scheduleDate, ScheduleStatusEnum status) {
		this.scheduleDate = scheduleDate;
		this.status = status;
	}
	
	/**
	 * @return the scheduleDate
	 */
	@XmlElement(name = "ScheduleDate")
	public String getScheduleDate() {
		return scheduleDate;
	}

	/**
	 * @param scheduleDate the scheduleDate to set
	 */
	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	/**
	 * @return the status
	 */
	@XmlElement(name = "Status")
	public ScheduleStatusEnum getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(ScheduleStatusEnum status) {
		this.status = status;
	}
	
	
}
