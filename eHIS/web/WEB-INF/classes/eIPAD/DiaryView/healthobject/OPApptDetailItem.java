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
package eIPAD.DiaryView.healthobject;

/**
 * @author vchoughule 
 *
 */
public class OPApptDetailItem extends AppointmentDetailItem {
	 String visitType; // it is first visit or follow up(type_code)
	 String visitDesc;
	 String timeTableType;
	/**
	 * @return the visitType
	 */
	public String getVisitType() {
		return visitType;
	}
	/**
	 * @param visitType the visitType to set
	 */
	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}
	/**
	 * @return the visitDesc
	 */
	public String getVisitDesc() {
		return visitDesc;
	}
	/**
	 * @param visitDesc the visitDesc to set
	 */
	public void setVisitDesc(String visitDesc) {
		this.visitDesc = visitDesc;
	}
	/**
	 * @return the timeTableType
	 */
	public String getTimeTableType() {
		return timeTableType;
	}
	/**
	 * @param timeTableType the timeTableType to set
	 */
	public void setTimeTableType(String timeTableType) {
		this.timeTableType = timeTableType;
	}

}
