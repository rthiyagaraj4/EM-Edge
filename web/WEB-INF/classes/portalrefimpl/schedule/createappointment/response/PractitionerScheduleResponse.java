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
 * This is the response class for the practitioner schedule web service
 * @author GRamamoorthy
 *
 */
@XmlRootElement(name = "Practitioner")
public class PractitionerScheduleResponse extends BaseResponse {

	/**
	 * data members in this class
	 */
	private String practitionerId = null;
	
	private List<Schedule> scheduleList = null;

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
	 * @return the scheduleList
	 */
	@XmlElementWrapper(name = "ScheduleDetails")
	@XmlElement(name = "Schedule")
	public List<Schedule> getScheduleList() {
		return scheduleList;
	}

	/**
	 * @param scheduleList the scheduleList to set
	 */
	public void setScheduleList(List<Schedule> scheduleList) {
		this.scheduleList = scheduleList;
	}
	
	/**
	 * 
	 */
	public void printResult(){
		System.out.println("Printing the practitioner schedule");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Practitioner Id="+practitionerId);
		if(scheduleList == null || scheduleList.isEmpty()){
			System.out.println("No schedule available for practitioner");
			return;
		}
		
		System.out.println("Printing the schedule - totally "+scheduleList.size()+" records");
		for(Schedule schedule : scheduleList){
			System.out.println("-------------------------------------------");
			schedule.printResult();
			System.out.println("-------------------------------------------");
		}
	}
	
}
