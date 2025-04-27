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
 * @author GRamamoorthy 
 *
 */
public class EventHistoryType implements Serializable {

	/**
	 * Stores the history type value
	 */
	private String historyType = null;
	
	/**
	 * 
	 */
	public EventHistoryType() {
	}

	/**
	 * @return the historyType
	 */
	public String getHistoryType() {
		return historyType;
	}

	/**
	 * @param historyType the historyType to set
	 */
	public void setHistoryType(String historyType) {
		this.historyType = historyType;
	}

	/**
	 * 
	 */
	public boolean equals(Object obj) {
		boolean equals = false;
		if(!(obj instanceof EventHistoryType)){
			return equals;
		}
		String tempHistoryType = ((EventHistoryType)obj).getHistoryType();
		if(tempHistoryType != null && tempHistoryType.equals(this.historyType)){
			equals = true;
		}
		return equals;
	}

}
