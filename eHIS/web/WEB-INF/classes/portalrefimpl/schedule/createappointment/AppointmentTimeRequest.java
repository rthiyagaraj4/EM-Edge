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


/**
 * @author GRamamoorthy
 *
 */
public class AppointmentTimeRequest {

	
	private int timeType = 0;

	/**
	 * Default constructor of the class
	 */
	public AppointmentTimeRequest() {
		// does nothing
	}
	
	/**
	 * @param timeType
	 */
	public AppointmentTimeRequest(int timeType) {
		this.timeType = timeType;
	}

	
	/**
	 * @return the timeType
	 */
	public int getTimeType() {
		return timeType;
	}

	/**
	 * @param timeType the timeType to set
	 */
	public void setTimeType(int timeType) {
		this.timeType = timeType;
	}
	
	
	
}
