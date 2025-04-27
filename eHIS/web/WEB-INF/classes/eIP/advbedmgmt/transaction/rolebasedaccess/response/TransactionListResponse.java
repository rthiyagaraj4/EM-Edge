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
package eIP.advbedmgmt.transaction.rolebasedaccess.response;

import java.util.ArrayList;
import java.util.List;

import eIP.advbedmgmt.common.response.BaseResponse;

/**
 * This is the response class for getting transaction list for a user
 * @author gramamoorthy
 *
 */
public class TransactionListResponse extends BaseResponse {

	private List<Transaction> transactionList = new ArrayList<Transaction>();

	/**
	 * @return the transactionList
	 */
	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	/**
	 * @param transactionList the transactionList to set
	 */
	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}
	
}
