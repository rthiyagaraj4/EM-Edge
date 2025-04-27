/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.receiveLinenAtLaundry.vo;

import java.util.Map;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.IBADateTime;

public class ReceiveLinenAtLaundryVO extends LcVO {

	private String receiptNum;

	private IBADateTime receivedDate;

	private String LinenItem;
	
	private String receivedBy;
	
	private String remarks;
	
	private Long receivedQty;

	public Long getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(Long receivedQty) {
		this.receivedQty = receivedQty;
	}

	public String getLinenItem() {
		return LinenItem;
	}

	public void setLinenItem(String linenItem) {
		LinenItem = linenItem;
	}

	public String getReceiptNum() {
		return receiptNum;
	}

	public void setReceiptNum(String receiptNum) {
		this.receiptNum = receiptNum;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public IBADateTime getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(IBADateTime receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	

}
