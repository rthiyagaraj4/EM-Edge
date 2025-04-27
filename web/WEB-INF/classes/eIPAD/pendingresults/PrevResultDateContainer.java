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
package eIPAD.pendingresults;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GRamamoorthy
 *
 */
public class PrevResultDateContainer implements Serializable {

	private Date dateValue = null;
	
	private String dateString = null;
	
	/**
	 * Default constructor of the class
	 */
	public PrevResultDateContainer() {
	}

	/**
	 * @return the dateValue
	 */
	public Date getDateValue() {
		return dateValue;
	}

	/**
	 * @param dateValue the dateValue to set
	 */
	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}

	/**
	 * @return the dateString
	 */
	public String getDateString() {
		return dateString;
	}

	/**
	 * @param dateString the dateString to set
	 */
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

}
