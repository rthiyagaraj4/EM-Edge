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
package eIPAD.chartsummary.allergies.request;

/**
 * @author GaneshkumarC
 *
 */
public class EventTypeRequest {
	private String eventTypeIndicator;
    private String locale;
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

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
}
