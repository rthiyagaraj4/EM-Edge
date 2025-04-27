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
package eIPAD.chartsummary.allergies.response;
import eIPAD.chartsummary.allergies.healthobject.*;
import eIPAD.chartsummary.common.response.*;
import java.util.*;

/**
 * @author GaneshkumarC 
 *
 */
public class EventTypeResponse extends GenericResponse {
	private List<EventType> lstEventTypeDetails;
    private boolean bServletException = false;
    private String exceptionMessage;
	/**
	 * @return the lstEventTypeDetails
	 */
	public List<EventType> getLstEventTypeDetails() {
		return lstEventTypeDetails;
	}

	/**
	 * @param lstEventTypeDetails the lstEventTypeDetails to set
	 */
	public void setLstEventTypeDetails(List<EventType> lstEventTypeDetails) {
		this.lstEventTypeDetails = lstEventTypeDetails;
	}

	/**
	 * @return the bServletException
	 */
	public boolean isbServletException() {
		return bServletException;
	}

	/**
	 * @param bServletException the bServletException to set
	 */
	public void setbServletException(boolean bServletException) {
		this.bServletException = bServletException;
	}

	/**
	 * @return the exceptionMessage
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	/**
	 * @param exceptionMessage the exceptionMessage to set
	 */
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
}
