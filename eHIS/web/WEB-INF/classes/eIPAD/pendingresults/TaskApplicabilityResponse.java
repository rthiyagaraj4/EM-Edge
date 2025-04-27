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

/**
 * @author GRamamoorthy
 *
 */
public class TaskApplicabilityResponse implements Serializable {

	/**
	 * Stores the menu value
	 */
	private String menuValue = null;
	
	/**
	 * 
	 */
	public TaskApplicabilityResponse() {
	}

	/**
	 * @return the menuValue
	 */
	public String getMenuValue() {
		return menuValue;
	}

	/**
	 * @param menuValue the menuValue to set
	 */
	public void setMenuValue(String menuValue) {
		this.menuValue = menuValue;
	}

}
