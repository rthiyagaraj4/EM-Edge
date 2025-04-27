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
package eIP.advbedmgmt.transaction.rolebasedaccess.bc;

import eIP.advbedmgmt.transaction.rolebasedaccess.dao.TransactionListDAO;
import eIP.advbedmgmt.transaction.rolebasedaccess.dao.TransactionListDAOImpl;
import eIP.advbedmgmt.transaction.rolebasedaccess.request.TransactionListRequest;
import eIP.advbedmgmt.transaction.rolebasedaccess.response.TransactionListResponse;

/**
 * This is the BC layer class for getting transaction list
 * which a user can access
 * @author gramamoorthy
 *
 */
public class TransactionListBC {

	/**
	 * This method gets a list of transaction which a user can access
	 * in GBM module based on their role
	 * This method in turn delegates call to the DAO impl class
	 * @param request
	 * @return
	 */
	public TransactionListResponse getAccessibleTransactions(
			TransactionListRequest request) {
		TransactionListDAO daoInst = new TransactionListDAOImpl();
		TransactionListResponse response = daoInst.getAccessibleTransactions(request); 
		return response;
	}
	
}
