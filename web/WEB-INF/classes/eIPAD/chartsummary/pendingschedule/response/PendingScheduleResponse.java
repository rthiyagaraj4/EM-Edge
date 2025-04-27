/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.pendingschedule.response;

import java.util.ArrayList;

import eIPAD.chartsummary.common.response.GenericResponse;
import eIPAD.chartsummary.pendingschedule.healthobject.PendingScheduleHO;
/**
 * @author SaraswathiR 
 *
 */

public class PendingScheduleResponse extends GenericResponse{

	private ArrayList<PendingScheduleHO> PendingSchedules;

	/**
	 * @return the pendingSchedules
	 */
	public ArrayList<PendingScheduleHO> getPendingSchedules() {
		return PendingSchedules;
	}

	/**
	 * @param pendingSchedules the pendingSchedules to set
	 */
	public void setPendingSchedules(ArrayList<PendingScheduleHO> pendingSchedules) {
		PendingSchedules = pendingSchedules;
	}
	
	

}
