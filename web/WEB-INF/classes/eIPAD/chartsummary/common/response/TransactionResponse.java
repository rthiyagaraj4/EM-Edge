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
package eIPAD.chartsummary.common.response;

import java.util.ArrayList;

/**
 * @author SaraswathiR 
 *
 */
public class TransactionResponse {
	
	final public static int SUCCESS = 1;
	final public static int FAILURE = -1;
	ArrayList<ErrorInfo> errorsList = new ArrayList<ErrorInfo>();
	private int transactionResult;

	/**
	 * @return the transactionResult
	 */
	public int getTransactionResult() {
		return transactionResult;
	}
	/**
	 * @param transactionResult the transactionResult to set
	 */
	public void setTransactionResult(int transactionResult) {
		this.transactionResult = transactionResult;
	}
	/**
	 * @return the errorsList
	 */
	public ArrayList<ErrorInfo> getErrorsList() {
		return errorsList;
	}
	/**
	 * @param errorsList the errorsList to set
	 */
	public void setErrorsList(ArrayList<ErrorInfo> errorsList) {
		this.errorsList = errorsList;
	}

	

}
