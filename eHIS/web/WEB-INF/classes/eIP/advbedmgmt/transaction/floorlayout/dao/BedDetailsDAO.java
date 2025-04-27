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
package eIP.advbedmgmt.transaction.floorlayout.dao;

import eIP.advbedmgmt.transaction.floorlayout.request.BasicBedDetailsRequest;
import eIP.advbedmgmt.transaction.floorlayout.request.BedIconRequest;
import eIP.advbedmgmt.transaction.floorlayout.request.BedStatusRequest;
import eIP.advbedmgmt.transaction.floorlayout.response.BasicBedDetailsResponse;
import eIP.advbedmgmt.transaction.floorlayout.response.BedIconResponse;
import eIP.advbedmgmt.transaction.floorlayout.response.BedStatusResponse;

/**
 * This is the DAO interface for getting bed details to be shown in the
 * GBM main GUI
 * This interface has methods for individual steps in the GBM main GUI
 * The different steps are
 * 1. Basic bed details 
 * 2. Bed status
 * 3. Bed icon status 
 * @author GRamamoorthy
 *
 */
public interface BedDetailsDAO {

	/**
	 * This method gets the basic bed details the bed details will have room
	 * details (room number, room dimensions), bed details (bed number,
	 * occupying patient details, practitioner details) This will not contain
	 * the bed statuses
	 * @param request
	 * @return
	 */
	public BasicBedDetailsResponse getBasicBedDetails(
			BasicBedDetailsRequest request);
	
	
	/**
	 * This method gets the status of individual beds
	 * 
	 * @param request
	 * @return
	 */
	public BedStatusResponse getBedStatus(BedStatusRequest request);
	
	/**
	 * This method gets the icon section of individual beds
	 * @param request
	 * @return
	 */
	public BedIconResponse getBedIconSection(BedIconRequest request);
	
}
