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

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This model class stores a schedule for a practitioner
 * This class is used in the practitioner schedule service
 * response class
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "Schedule")
public class Schedule {

	private Date scheduleDate = null;
	
	/**
	 * 
	 */
	private String startTime = null;
	
	/**
	 * 
	 */
	private String endTime = null;

	/**
	 * @return the fromTime
	 */
	@XmlElement(name = "StartTime")
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param fromTime the fromTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the toTime
	 */
	@XmlElement(name = "EndTime")
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param toTime the toTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * 
	 */
	public void printResult(){
		System.out.println("schedule date="+scheduleDate);
		System.out.println("start time="+startTime);
		System.out.println("end time="+endTime);
	}

	/**
	 * @return the scheduleDate
	 */
	@XmlElement(name = "ScheduleDate")
	public Date getScheduleDate() {
		return scheduleDate;
	}

	/**
	 * @param scheduleDate the scheduleDate to set
	 */
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	
}
