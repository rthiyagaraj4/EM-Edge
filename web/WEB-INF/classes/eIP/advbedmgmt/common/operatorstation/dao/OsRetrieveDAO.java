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
package eIP.advbedmgmt.common.operatorstation.dao;

import eIP.advbedmgmt.common.operatorstation.request.OsRetrieveRequest;
import eIP.advbedmgmt.common.operatorstation.response.OsRetrieveResponse;

/**
 * This is the interface for retrieving Operator station related data
 * 
 * @author GRamamoorthy
 *
 */
public interface OsRetrieveDAO {

	/**
	 * This method retrieves Operator station id for a user
	 * @param request
	 * @return
	 */
	public OsRetrieveResponse getOSForUser(OsRetrieveRequest request);
	
}
