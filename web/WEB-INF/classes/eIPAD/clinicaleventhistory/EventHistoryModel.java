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
package eIPAD.clinicaleventhistory;

import java.io.Serializable;

/**
 * This is a model class for storing details
 * about one event history record
 * @author GRamamoorthy 
 *
 */
public class EventHistoryModel implements Serializable {

	/**
	 * Stores the row id
	 */
	private String rowId = null;
	
	
	/**
	 * default constructor of the class
	 */
	public EventHistoryModel() {
	}


	/**
	 * @return the rowId
	 */
	public String getRowId() {
		return rowId;
	}


	/**
	 * @param rowId the rowId to set
	 */
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

}
