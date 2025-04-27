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
package eIP.advbedmgmt.common.bedlegend.dao;

import eIP.advbedmgmt.common.bedlegend.request.BedLegendRequest;
import eIP.advbedmgmt.common.bedlegend.response.BedLegendResponse;

/**
 * this is the DAO interface for bed legends
 * @author GRamamoorthy
 *
 */
public interface BedLegendDAO {

	/**
	 * this method gets the bed legend
	 * @param request
	 * @return
	 */
	public BedLegendResponse getBedLegend(BedLegendRequest request);
	
}
