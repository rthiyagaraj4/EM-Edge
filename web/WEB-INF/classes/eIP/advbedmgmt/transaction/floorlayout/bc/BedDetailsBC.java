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
package eIP.advbedmgmt.transaction.floorlayout.bc;

import eIP.advbedmgmt.transaction.floorlayout.dao.BedDetailsDAO;
import eIP.advbedmgmt.transaction.floorlayout.dao.BedDetailsDAOImpl;
import eIP.advbedmgmt.transaction.floorlayout.request.BasicBedDetailsRequest;
import eIP.advbedmgmt.transaction.floorlayout.request.BedIconRequest;
import eIP.advbedmgmt.transaction.floorlayout.request.BedStatusRequest;
import eIP.advbedmgmt.transaction.floorlayout.response.BasicBedDetailsResponse;
import eIP.advbedmgmt.transaction.floorlayout.response.BedIconResponse;
import eIP.advbedmgmt.transaction.floorlayout.response.BedStatusResponse;

/**
 * This is the business component class for getting bed details
 * @author gramamoorthy
 *
 */
public class BedDetailsBC {

	/**
	 * This method gets the basic bed details
	 * The basic bed details will contain bed number and bed dimensions 
	 * @param request
	 * @return
	 */
	public BasicBedDetailsResponse getBasicBedDetails(BasicBedDetailsRequest request){
		BedDetailsDAOImpl daoImpl = new BedDetailsDAOImpl();
		BasicBedDetailsResponse response = daoImpl.getBasicBedDetails(request);
		return response;
	}
	
	/**
	 * This method gets the bed status for all beds in a nursing unit
	 * @param request
	 * @return
	 */
	public BedStatusResponse getBedStatusDetails(BedStatusRequest request){
		BedDetailsDAO daoImpl = new BedDetailsDAOImpl();
		BedStatusResponse response = daoImpl.getBedStatus(request);
		return response;
	}
	
	
	/**
	 * This method gets the bed icon section data
	 * @param request
	 * @return
	 */
	public BedIconResponse getBedIconSectionDetails(BedIconRequest request){
		BedDetailsDAO dao = new BedDetailsDAOImpl();
		BedIconResponse response = dao.getBedIconSection(request);
		return response;
	}
	
	
}
