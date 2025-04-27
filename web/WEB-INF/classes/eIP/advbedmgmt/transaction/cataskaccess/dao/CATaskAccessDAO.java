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
package eIP.advbedmgmt.transaction.cataskaccess.dao;

import eIP.advbedmgmt.transaction.cataskaccess.request.CATaskAccessRequest;
import eIP.advbedmgmt.transaction.cataskaccess.response.CATaskAccessResponse;

/**
 * This is the DAO interface for checking if GBM submodule has access to a CA module
 * task
 * @author GRamamoorthy
 *
 */
public interface CATaskAccessDAO {

	
	/**
	 * This method checks if GBM submodule has access to a CA module task This
	 * method takes as input the request object , checks the validity of the
	 * access against EM database and then returns the result in the response
	 * object
	 * 
	 * @param request
	 * @return
	 */
	public CATaskAccessResponse checkCATaskAccess(CATaskAccessRequest request);	

}
