/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.healthobject;
import java.util.*;
public class GraphXAxis implements java.io.Serializable{

	/**
	 * This class is used to hold X axis values for a graph. 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Date eventDateTime;
	
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
}
