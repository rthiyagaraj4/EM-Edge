/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.schedule.viewupcomingappointment.request;

import portal.common.request.BaseRequest;

/**
 * This class is the request class for the view upcoming appointment details
 * service
 * This class extends the BaseRequest class.
 * @author vkodancha
 *
 */
public class UpcomingAppointmentDetailsRequest extends BaseRequest{
	
	// instance variables
	private String faciltiyId;
	private String dateFrom;
	private String dateTo;
	/**
	 * @return the faciltiyId
	 */
	public String getFaciltiyId() {
		return faciltiyId;
	}
	/**
	 * @param faciltiyId the faciltiyId to set
	 */
	public void setFaciltiyId(String faciltiyId) {
		this.faciltiyId = faciltiyId;
	}
	/**
	 * @return the dateFrom
	 */
	public String getDateFrom() {
		return dateFrom;
	}
	/**
	 * @param dateFrom the dateFrom to set
	 */
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	/**
	 * @return the dateTo
	 */
	public String getDateTo() {
		return dateTo;
	}
	/**
	 * @param dateTo the dateTo to set
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	/**
	 * To string over ridden for logging
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("faciltiyId : "+faciltiyId);
		sb.append("dateFrom : "+dateFrom);
		sb.append("dateTo : "+dateTo);
		return sb.toString();
	}
}
