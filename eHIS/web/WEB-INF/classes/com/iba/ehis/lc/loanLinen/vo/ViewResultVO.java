/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.loanLinen.vo;

import com.iba.ehis.lc.core.vo.LcVO;

public class ViewResultVO extends LcVO {

	private String linenItem;

	private Long loanedQty;

	private Long receivedQty;

	private String remark;

	public String getLinenItem() {
		return linenItem;
	}

	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
