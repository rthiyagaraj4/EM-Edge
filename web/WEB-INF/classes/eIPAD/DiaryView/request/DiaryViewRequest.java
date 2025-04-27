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
package eIPAD.DiaryView.request;

import java.util.Date;

import eIPAD.chartsummary.common.request.GenericRequest;

/**
 * @author vchoughule 
 *
 */
public class DiaryViewRequest extends GenericRequest{
	private String practitionerId;
	private String startDate;
	private String endDate;
	private String patCategoryFilter;
	private String locale;
	/**
	 * @return the practitionerId
	 */
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
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the patCategoryFilter
	 */
	public String getPatCategoryFilter() {
		return patCategoryFilter;
	}
	/**
	 * @param patCategoryFilter the patCategoryFilter to set
	 */
	public void setPatCategoryFilter(String patCategoryFilter) {
		this.patCategoryFilter = patCategoryFilter;
	}
	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}
	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}
}
