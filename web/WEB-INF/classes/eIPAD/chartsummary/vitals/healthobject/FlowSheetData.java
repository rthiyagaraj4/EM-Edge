/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.healthobject;

import java.util.Date;

public class FlowSheetData implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date eventDateTime;
	/**
	 * @return the eventDateTime 
	 */
	public Date getEventDateTime() {
		return eventDateTime;
	}
	/**
	 * @param eventDateTime the eventDateTime to set
	 */
	public void setEventDateTime(Date eventDateTime) {
		this.eventDateTime = eventDateTime;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Date)
		{
			Date oDate = (Date)obj;
			if(oDate.equals(this.eventDateTime))
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		return false;
	}
	public int hashCode() {
		return this.eventDateTime.hashCode();
	}
	
}
