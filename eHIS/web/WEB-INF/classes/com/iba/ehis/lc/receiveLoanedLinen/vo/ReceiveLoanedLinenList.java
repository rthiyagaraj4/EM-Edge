/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.receiveLoanedLinen.vo;

import com.iba.ehis.lc.core.vo.LcVO;

public class ReceiveLoanedLinenList extends LcVO {

	private String linenItem;

	private Long loanedQty;

	private Long receivedQty;

	public String getLinenItem() {
		return linenItem;
	}

	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}

	public Long getLoanedQty() {
		return loanedQty;
	}

	public void setLoanedQty(Long loanedQty) {
		this.loanedQty = loanedQty;
	}

	public Long getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(Long receivedQty) {
		this.receivedQty = receivedQty;
	}

}
