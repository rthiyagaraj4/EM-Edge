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
 * This model class represents an appointment time
 * @author GRamamoorthy
 *
 */
public class AppointmentTime {

	private String appointmentDisplayValue = null;
	
	private String appointmentDataValue = null;

	/**
	 * Default constructor of the class
	 */
	public AppointmentTime(){
		// does nothing
	}
	
	/**
	 * Constructor taking appointment time as input variable
	 * @param appointmentDisplayValue
	 */
	public AppointmentTime(String appointmentDisplayValue){
		this.appointmentDisplayValue = appointmentDisplayValue;
	}
	
	/**
	 * 
	 * @param appointmentDisplayValue
	 * @param appointmentDataValue
	 */
	public AppointmentTime(String appointmentDisplayValue,String appointmentDataValue){
		this.appointmentDisplayValue = appointmentDisplayValue;
		this.appointmentDataValue = appointmentDataValue;
	}
	
	/**
	 * @return the appointmentTime
	 */
	public String getAppointmentTime() {
		return appointmentDisplayValue;
	}

	/**
	 * @param appointmentTime the appointmentTime to set
	 */
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentDisplayValue = appointmentTime;
	}

	/**
	 * This method checks for equality of this object with
	 * the given object
	 */
	public boolean equals(Object obj) {
		boolean equals = false;
		if(!(obj instanceof AppointmentTime)){
			return equals;
		}
		String tempAppointmentTime = ((AppointmentTime)obj).getAppointmentTime();
		String tempApptDataValue = ((AppointmentTime)obj).getAppointmentDataValue();
		if ((tempAppointmentTime != null && tempAppointmentTime
				.equalsIgnoreCase(this.appointmentDisplayValue))
				|| (tempApptDataValue != null && tempApptDataValue
						.equalsIgnoreCase(this.appointmentDisplayValue))) {
			equals = true;
		}
		return equals;
	}

	/**
	 * @return the appointmentDataValue
	 */
	public String getAppointmentDataValue() {
		return appointmentDataValue;
	}

	/**
	 * @param appointmentDataValue the appointmentDataValue to set
	 */
	public void setAppointmentDataValue(String appointmentDataValue) {
		this.appointmentDataValue = appointmentDataValue;
	}
	
	
	
}
