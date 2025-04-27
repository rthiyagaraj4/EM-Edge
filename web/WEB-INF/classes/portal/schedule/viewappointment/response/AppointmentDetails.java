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
package portal.schedule.viewappointment.response;


/**
 * This class is contains appointment 
 * information of a given appointment
 * @author vkodancha
 *
 */
public class AppointmentDetails {

	private String appointmentDate;
	
	private String practitioner;
	
	private String apptSpeciality;
	
	private String apptStartTime;
	
	private String apptEndTime;
	
	private String apptNumber;
	
	/**
	 * 
	 */
	public AppointmentDetails() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the appointmentDate
	 */
	public String getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * @param appointmentDate the appointmentDate to set
	 */
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	

	/**
	 * @return the practitioner
	 */
	public String getPractitioner() {
		return practitioner;
	}

	/**
	 * @param practitioner the practitioner to set
	 */
	public void setPractitioner(String practitioner) {
		this.practitioner = practitioner;
	}

	/**
	 * @return the apptSpeciality
	 */
	public String getApptSpeciality() {
		return apptSpeciality;
	}

	/**
	 * @param apptSpeciality the apptSpeciality to set
	 */
	public void setApptSpeciality(String apptSpeciality) {
		this.apptSpeciality = apptSpeciality;
	}

	/**
	 * @return the apptStartTime
	 */
	public String getApptStartTime() {
		return apptStartTime;
	}
	

	/**
	 * @param apptStartTime the apptStartTime to set
	 */
	public void setApptStartTime(String apptStartTime) {
		this.apptStartTime = apptStartTime;
	}

	/**
	 * @return the apptEndTime
	 */
	public String getApptEndTime() {
		return apptEndTime;
	}

	
	
	/**
	 * @param apptEndTime the apptEndTime to set
	 */
	public void setApptEndTime(String apptEndTime) {
		this.apptEndTime = apptEndTime;
	}

	/**
	 * @return the apptNumber
	 */
	public String getApptNumber() {
		return apptNumber;
	}

	/**
	 * @param apptNumber the apptNumber to set
	 */
	public void setApptNumber(String apptNumber) {
		this.apptNumber = apptNumber;
	}

}
