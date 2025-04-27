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
 * This model class represents the response class
 * which will contain data for pending result for review
 * @author GRamamoorthy
 *
 */
public class PendingResultsResponse implements Serializable {

	/**
	 * Stores the complete pending results
	 */
	private Map<PatientDetail, PendingResultForPatient> pendingResultsMap = new HashMap<PatientDetail, PendingResultForPatient>();
	
	/**
	 * Stores the total number of pending results obtained
	 */
	private int totalRecords = 0;
	
	
	/**
	 * Default constructor of the class
	 */
	public PendingResultsResponse() {
	}


	/**
	 * @return the pendingResultsMap
	 */
	public Map<PatientDetail, PendingResultForPatient> getPendingResultsMap() {
		return pendingResultsMap;
	}


	/**
	 * @param pendingResultsMap the pendingResultsMap to set
	 */
	public void setPendingResultsMap(
			Map<PatientDetail, PendingResultForPatient> pendingResultsMap) {
		this.pendingResultsMap = pendingResultsMap;
	}


	/**
	 * @return the totalRecords
	 */
	public int getTotalRecords() {
		return totalRecords;
	}


	/**
	 * @param totalRecords the totalRecords to set
	 */
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

}
