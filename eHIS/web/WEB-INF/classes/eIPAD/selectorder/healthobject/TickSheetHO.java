/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.selectorder.healthobject;

public class TickSheetHO implements java.io.Serializable {
	private String tickSheetId;
	private String tickSheetDesc;
	private String orderCategory;
	private String sectionCode;
	private String sectionDesc;
	/**
	 * @return the tickSheetId
	 */
	public String getTickSheetId() {
		return tickSheetId;
	}
	/**
	 * @param tickSheetId the tickSheetId to set
	 */
	public void setTickSheetId(String tickSheetId) {
		this.tickSheetId = tickSheetId;
	}
	/**
	 * @return the tickSheetDesc
	 */
	public String getTickSheetDesc() {
		return tickSheetDesc;
	}
	/**
	 * @param tickSheetDesc the tickSheetDesc to set
	 */
	public void setTickSheetDesc(String tickSheetDesc) {
		this.tickSheetDesc = tickSheetDesc;
	}
	/**
	 * @return the orderCategory
	 */
	public String getOrderCategory() {
		return orderCategory;
	}
	/**
	 * @param orderCategory the orderCategory to set
	 */
	public void setOrderCategory(String orderCategory) {
		this.orderCategory = orderCategory;
	}
	/**
	 * @return the sectionCode
	 */
	public String getSectionCode() {
		return sectionCode;
	}
	/**
	 * @param sectionCode the sectionCode to set
	 */
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}
	/**
	 * @return the sectionDesc
	 */
	public String getSectionDesc() {
		return sectionDesc;
	}
	/**
	 * @param sectionDesc the sectionDesc to set
	 */
	public void setSectionDesc(String sectionDesc) {
		this.sectionDesc = sectionDesc;
	}
}
