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
package portalrefimpl.schedule.createappointment;

import java.util.List;

/**
 * @author GRamamoorthy
 *
 */
public class AppointmentTimeResponse {

	private List<AppointmentTime> appointmentTimeList = null;

	/**
	 * @return the appointmentTimeList
	 */
	public List<AppointmentTime> getAppointmentTimeList() {
		return appointmentTimeList;
	}

	/**
	 * @param appointmentTimeList the appointmentTimeList to set
	 */
	public void setAppointmentTimeList(List<AppointmentTime> appointmentTimeList) {
		this.appointmentTimeList = appointmentTimeList;
	}
	
	/**
	 * 
	 * @param appointmentTime
	 * @return
	 */
	public boolean containsAppointmentTime(String appointmentTime){
		boolean contains = false;
		if(appointmentTimeList != null && !appointmentTimeList.isEmpty()){
			if (appointmentTimeList.contains(new AppointmentTime(
					appointmentTime, appointmentTime))) {
				contains = true;
			}
		}
		
		return contains;
	}
	
	/**
	 * 
	 * @param appointmentTime
	 * @return
	 */
	public int getAppointmentTimeIndex(String appointmentTime){
		int index = -1;
		if(appointmentTimeList != null && !appointmentTimeList.isEmpty()){
			index = appointmentTimeList.indexOf(new AppointmentTime(
					appointmentTime, appointmentTime));
		}
		
		return index;
	}
	
}
