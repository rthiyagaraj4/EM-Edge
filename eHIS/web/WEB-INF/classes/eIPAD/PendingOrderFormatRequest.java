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
package eIPAD;

import java.io.Serializable;

/**
 * @author GRamamoorthy
 *
 */
public class PendingOrderFormatRequest implements Serializable {

	/**
	 * Stores the orderId
	 */
	private String orderId = null;
	
	private String lineId = null;
	
	private String calledFrom = null;
	
	private String facilityId = null;
	
	private String languageId = null;
	
	
	/**
	 * default constructor of the class
	 */
	public PendingOrderFormatRequest() {
	}


	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}


	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	/**
	 * @return the lineId
	 */
	public String getLineId() {
		return lineId;
	}


	/**
	 * @param lineId the lineId to set
	 */
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}


	/**
	 * @return the calledFrom
	 */
	public String getCalledFrom() {
		return calledFrom;
	}


	/**
	 * @param calledFrom the calledFrom to set
	 */
	public void setCalledFrom(String calledFrom) {
		this.calledFrom = calledFrom;
	}


	/**
	 * @return the facilityId
	 */
	public String getFacilityId() {
		return facilityId;
	}


	/**
	 * @param facilityId the facilityId to set
	 */
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}


	/**
	 * @return the languageId
	 */
	public String getLanguageId() {
		return languageId;
	}


	/**
	 * @param languageId the languageId to set
	 */
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

}
