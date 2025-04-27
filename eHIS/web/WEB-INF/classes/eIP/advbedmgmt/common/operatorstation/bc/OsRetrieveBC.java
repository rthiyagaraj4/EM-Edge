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
package eIP.advbedmgmt.common.operatorstation.bc;

import eIP.advbedmgmt.common.operatorstation.dao.OsRetrieveDAO;
import eIP.advbedmgmt.common.operatorstation.dao.OsRetrieveDAOImpl;
import eIP.advbedmgmt.common.operatorstation.request.OsRetrieveRequest;
import eIP.advbedmgmt.common.operatorstation.response.OsRetrieveResponse;

/**
 * This is the BC layer class for Operator Station id retrieval
 * activities
 * @author GRamamoorthy
 *
 */
public class OsRetrieveBC {

	/**
	 * This method retrieves the Operator station id
	 * @param request
	 * @return
	 */
	public OsRetrieveResponse getOsIdForUser(OsRetrieveRequest request){
		OsRetrieveDAO daoInst = new OsRetrieveDAOImpl();
		return daoInst.getOSForUser(request);
	}
	
}

