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
package eIP.advbedmgmt.transaction.rolebasedaccess.dao;

import eIP.advbedmgmt.transaction.rolebasedaccess.request.TransactionListRequest;
import eIP.advbedmgmt.transaction.rolebasedaccess.response.TransactionListResponse;

/**
 * This is the DAO interface for getting transaction list
 * which a user can access
 * @author gramamoorthy
 *
 */
public interface TransactionListDAO {

	/**
	 * This method gets a list of transaction which a user can access
	 * in GBM module based on their role
	 * @param request
	 * @return
	 */
	public TransactionListResponse getAccessibleTransactions(TransactionListRequest request);
	
}
