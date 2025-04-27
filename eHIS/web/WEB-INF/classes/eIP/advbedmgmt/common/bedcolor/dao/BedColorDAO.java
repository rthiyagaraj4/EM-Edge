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
package eIP.advbedmgmt.common.bedcolor.dao;

import eIP.advbedmgmt.common.bedcolor.request.BedColorRequest;
import eIP.advbedmgmt.common.bedcolor.response.BedColorResponse;

/**
 * This interface is for retrieving bed color
 * @author GRamamoorthy
 *
 */
public interface BedColorDAO {

	/**
	 * This method gets the bed color as per the request object
	 * @param request
	 * @return
	 */
	public BedColorResponse getBedColor(BedColorRequest request);
	
}
