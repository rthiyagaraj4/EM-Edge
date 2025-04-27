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
package portalrefimpl.schedule.viewappointment.response;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author GRamamoorthy
 *
 */
public class AppointmentDetails {

	private Date appointmentDate = null;
	
	private String practitioner = null;
	
	private String apptSpeciality = null;
	
	private Date apptStartTime = null;
	
	private Date apptEndTime = null;
	
	/**
	 * 
	 */
	public AppointmentDetails() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the appointmentDate
	 */
	@XmlElement(name = "AppointmentDate")
	public Date getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * @param appointmentDate the appointmentDate to set
	 */
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAppointmentDateAsString(){
		String appointmentDateStr = "";
		final String formatStr = "yyyy-MM-dd";
		if(appointmentDate != null){
			SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);
			appointmentDateStr = dateFormat.format(appointmentDate);
		}
		
		return appointmentDateStr;
	}

	/**
	 * @return the practitioner
	 */
	@XmlElement(name = "Practitioner")
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
	@XmlElement(name = "Specialty")
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
	@XmlElement(name = "AppointmentStartTime")
	public Date getApptStartTime() {
		return apptStartTime;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getApptStartTimeAsString(){
		StringBuffer apptStartTimeBuffer = new StringBuffer();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(apptStartTime);
		
		DecimalFormat nft = new DecimalFormat("#00.###");
		
		apptStartTimeBuffer.append(nft.format(calendar.get(Calendar.HOUR_OF_DAY)));
		apptStartTimeBuffer.append(":");
		
		apptStartTimeBuffer.append(nft.format(calendar.get(Calendar.MINUTE)));
		return apptStartTimeBuffer.toString();
	}

	/**
	 * @param apptStartTime the apptStartTime to set
	 */
	public void setApptStartTime(Date apptStartTime) {
		this.apptStartTime = apptStartTime;
	}

	/**
	 * @return the apptEndTime
	 */
	@XmlElement(name = "AppointmentEndTime")
	public Date getApptEndTime() {
		return apptEndTime;
	}

	/**
	 * 
	 * @return
	 */
	public String getApptEndTimeAsString(){
		StringBuffer apptEndTimeBuffer = new StringBuffer();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(apptEndTime);
		
		DecimalFormat nft = new DecimalFormat("#00.###");
		
		apptEndTimeBuffer.append(nft.format(calendar.get(Calendar.HOUR_OF_DAY)));
		apptEndTimeBuffer.append(":");
		apptEndTimeBuffer.append(nft.format(calendar.get(Calendar.MINUTE)));
		return apptEndTimeBuffer.toString();
	}
	
	/**
	 * @param apptEndTime the apptEndTime to set
	 */
	public void setApptEndTime(Date apptEndTime) {
		this.apptEndTime = apptEndTime;
	}

	/**
	 * 
	 * @return
	 */
	public int getAppointmentDateAsInt(){
		int date = 0;
		if(appointmentDate != null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(appointmentDate);
			date = cal.get(Calendar.DATE);
		}
		
		return date;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAppointmentDay(){
		String day = "";
		if(appointmentDate != null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(appointmentDate);
			day = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
		}
		return day;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAppointmentMonthAndYear(){
		String val = "";
		if(appointmentDate != null){
			final String format = "MMM - yyyy";
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			val = dateFormat.format(appointmentDate);
		}
		
		return val;
	}

}
