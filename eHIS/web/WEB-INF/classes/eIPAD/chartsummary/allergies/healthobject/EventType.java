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
package eIPAD.chartsummary.allergies.healthobject;

/**
 * @author GaneshkumarC 
 *
 */
public class EventType implements java.io.Serializable {
	private String eventTypeDescription;
	private String eventTypeCode;
	private String eventTypeIndicator;
	/**
	 * @return the eventTypeDescription
	 */
	public String getEventTypeDescription() {
		return eventTypeDescription;
	}
	/**
	 * @param eventTypeDescription the eventTypeDescription to set
	 */
	public void setEventTypeDescription(String eventTypeDescription) {
		this.eventTypeDescription = eventTypeDescription;
	}
	/**
	 * @return the eventTypeCode
	 */
	public String getEventTypeCode() {
		return eventTypeCode;
	}
	/**
	 * @param eventTypeCode the eventTypeCode to set
	 */
	public void setEventTypeCode(String eventTypeCode) {
		this.eventTypeCode = eventTypeCode;
	}
	/**
	 * @return the eventTypeIndicator
	 */
	public String getEventTypeIndicator() {
		return eventTypeIndicator;
	}
	/**
	 * @param eventTypeIndicator the eventTypeIndicator to set
	 */
	public void setEventTypeIndicator(String eventTypeIndicator) {
		this.eventTypeIndicator = eventTypeIndicator;
	}
	
}
