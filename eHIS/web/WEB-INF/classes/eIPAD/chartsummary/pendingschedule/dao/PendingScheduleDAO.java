/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.pendingschedule.dao;

import eIPAD.chartsummary.pendingschedule.request.PendingScheduleRequest;
import eIPAD.chartsummary.pendingschedule.response.PendingScheduleResponse;

/**
 * @author SaraswathiR 
 *
 */
public interface PendingScheduleDAO {

	public PendingScheduleResponse getPendingSchedule(PendingScheduleRequest request);
}
