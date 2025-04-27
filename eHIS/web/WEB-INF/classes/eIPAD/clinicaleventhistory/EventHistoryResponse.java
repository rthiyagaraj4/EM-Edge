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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GRamamoorthy 
 *
 */
public class EventHistoryResponse implements Serializable {

	
	private Map<EventHistoryType, List<EventHistoryRecord>> historyRecordMap = new HashMap<EventHistoryType, List<EventHistoryRecord>>();
	
	/**
	 * Stores the list of history records which will be shown in the GUI
	 */
	private List<EventHistoryRecord> historyRecordList = new ArrayList<EventHistoryRecord>();
	
	/**
	 * 
	 */
	public EventHistoryResponse() {
	}

	/**
	 * @return the historyRecordMap
	 */
	public Map<EventHistoryType, List<EventHistoryRecord>> getHistoryRecordMap() {
		return historyRecordMap;
	}

	/**
	 * @param historyRecordMap the historyRecordMap to set
	 */
	public void setHistoryRecordMap(
			Map<EventHistoryType, List<EventHistoryRecord>> historyRecordMap) {
		this.historyRecordMap = historyRecordMap;
	}

	/**
	 * @return the historyRecordList
	 */
	public List<EventHistoryRecord> getHistoryRecordList() {
		return historyRecordList;
	}

	/**
	 * @param historyRecordList the historyRecordList to set
	 */
	public void setHistoryRecordList(List<EventHistoryRecord> historyRecordList) {
		this.historyRecordList = historyRecordList;
	}

	

}
