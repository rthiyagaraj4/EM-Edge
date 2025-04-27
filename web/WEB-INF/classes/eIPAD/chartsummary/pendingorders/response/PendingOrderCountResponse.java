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
package eIPAD.chartsummary.pendingorders.response;

import java.util.ArrayList;

import eIPAD.chartsummary.common.response.GenericResponse;
import eIPAD.chartsummary.pendingorders.healthobject.PendingOrderCountHO;

/**
 * @author SaraswathiR
 * 
 */
public class PendingOrderCountResponse extends GenericResponse {

	private int pendingOrdersTotalCount;
	private ArrayList<PendingOrderCountHO> pendingOrderCountList;

	/**
	 * @return the pendingOrderCountList
	 */
	public ArrayList<PendingOrderCountHO> getPendingOrderCountList() {
		return pendingOrderCountList;
	}

	/**
	 * @param pendingOrderCountList the pendingOrderCountList to set
	 */
	public void setPendingOrderCountList(
			ArrayList<PendingOrderCountHO> pendingOrderCountList) {
		this.pendingOrderCountList = pendingOrderCountList;
	}

	/**
	 * @return the pendingOrdersTotalCount
	 */
	public int getPendingOrdersTotalCount() {
		return pendingOrdersTotalCount;
	}

	/**
	 * @param pendingOrdersTotalCount the pendingOrdersTotalCount to set
	 */
	public void setPendingOrdersTotalCount(int pendingOrdersTotalCount) {
		this.pendingOrdersTotalCount = pendingOrdersTotalCount;
	}
}
