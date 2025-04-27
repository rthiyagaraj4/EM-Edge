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
package eAlert.src.alert.request;

/**
 * @author prasannar 
 *
 */
public class AlertsByFilterRequest extends BaseRequest{

	private String filterBy;
	
	private String filtered;

	/**
	 * @return the filterBy
	 */
	public String getFilterBy() {
		return filterBy;
	}

	/**
	 * @param filterBy the filterBy to set
	 */
	public void setFilterBy(String filterBy) {
		this.filterBy = filterBy;
	}

	public String getFiltered() {
		return filtered;
	}

	public void setFiltered(String filtered) {
		this.filtered = filtered;
	} 
}
