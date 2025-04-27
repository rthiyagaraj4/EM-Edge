/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HTTPTransactionsHelper
{
	private static final long serialVersionUID = 1L;
	
	public HTTPTransactionsHelper() {

	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response,
								Map<String, String> reqParams) throws Exception {
		String protocolLinkID = reqParams.get("PROTOCOL_LINK_ID");
		
		if("CC01".equals(protocolLinkID)) {
			CreditCardTransactions ccTransactions = new CreditCardTransactions();
			ccTransactions.processCC01Transaction(reqParams);
		}
	}
}
