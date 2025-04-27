/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.requestForCleaningLinen.vo;

import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.IBADateTime;

public class CleaningLinenRequestList {

	private String linenItem;
	private String category;
	
	private Long requestedQty;
	private Long deliveredQty;
	private String sourceCode;
	private String requestNo;
	private IBADateTime scheduleDeliveryDate;
	private String raisedBy;
	private String requestStatus;
	private String remark;
	
	private IBADateTime requestDate;
	private String confirm;
	private String countConfirmedBy;
    private IBADateTime countConfirmedDate;
	
	
	private int flag;



	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getLinenItem() {
		return linenItem;
	}

	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}

	public Long getRequestedQty() {
		return requestedQty;
	}

	public void setRequestedQty(Long requestedQty) {
		this.requestedQty = requestedQty;
	}

	public String getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(String raisedBy) {
		this.raisedBy = raisedBy;
	}
	
	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public IBADateTime getScheduleDeliveryDate() {
		return scheduleDeliveryDate;
	}

	public void setScheduleDeliveryDate(IBADateTime scheduleDeliveryDate) {
		this.scheduleDeliveryDate = scheduleDeliveryDate;
	}

	public Long getDeliveredQty() {
		return deliveredQty;
	}

	public void setDeliveredQty(Long deliveredQty) {
		this.deliveredQty = deliveredQty;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getCountConfirmedBy() {
		return countConfirmedBy;
	}

	public void setCountConfirmedBy(String countConfirmedBy) {
		this.countConfirmedBy = countConfirmedBy;
	}

	public IBADateTime getCountConfirmedDate() {
		return countConfirmedDate;
	}

	public void setCountConfirmedDate(IBADateTime countConfirmedDate) {
		this.countConfirmedDate = countConfirmedDate;
	}

	public IBADateTime getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(IBADateTime requestDate) {
		this.requestDate = requestDate;
	}

	

}
