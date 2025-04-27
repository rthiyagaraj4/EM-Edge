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
package eIP.advbedmgmt.transaction.access.dao;

import eIP.advbedmgmt.transaction.access.request.AccessRequest;
import eIP.advbedmgmt.transaction.access.response.AccessResponse;

/**
 * This is the DAO interface for getting access rights for CRUD
 * operations in bed manager GUI
 * @author GRamamoorthy
 *
 */
public interface AccessDAO {

	/**
	 * This method returns the access rights for CRUD
	 * operations in bed manager GUI
	 * @param accessRequest
	 * @return
	 */
	public AccessResponse getAccess(AccessRequest accessRequest);	


}
