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
import java.util.HashMap;
import java.util.Map;

/**
 * This is the response class which will contain the 
 * number of pending results
 * @author GRamamoorthy
 *
 */
public class PendingResultsCountResponse implements Serializable {

	/**
	 * Stores the pending result count for all the categories.
	 * The different categories form the key of the map
	 * and the value is the count of results represented as Integer
	 */
	private Map<PendingResultCategory, Integer> pendingResultCountMap = new HashMap<PendingResultCategory, Integer>();
	
	
	private int defaultPendingResultTotalCount = 0;
	
	/**
	 * Default constructor of the class
	 */
	public PendingResultsCountResponse() {
	}

	/**
	 * @return the pendingResultCountMap
	 */
	public Map<PendingResultCategory, Integer> getPendingResultCountMap() {
		return pendingResultCountMap;
	}

	/**
	 * @param pendingResultCountMap the pendingResultCountMap to set
	 */
	public void setPendingResultCountMap(
			Map<PendingResultCategory, Integer> pendingResultCountMap) {
		this.pendingResultCountMap = pendingResultCountMap;
	}

}
