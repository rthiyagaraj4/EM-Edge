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
import java.util.ArrayList;
import java.util.List;

/**
 * @author GRamamoorthy 
 *
 */
public class EventHistoryRecordResponse implements Serializable {

	/**
	 * Stores the list of event history records
	 */
	private List<EventHistoryModel> eventHistoryModelList = new ArrayList<EventHistoryModel>();
	
	/**
	 * default constructor of the class
	 */
	public EventHistoryRecordResponse() {
	}

	/**
	 * @return the eventHistoryModelList
	 */
	public List<EventHistoryModel> getEventHistoryModelList() {
		return eventHistoryModelList;
	}

	/**
	 * @param eventHistoryModelList the eventHistoryModelList to set
	 */
	public void setEventHistoryModelList(
			List<EventHistoryModel> eventHistoryModelList) {
		this.eventHistoryModelList = eventHistoryModelList;
	}

}
