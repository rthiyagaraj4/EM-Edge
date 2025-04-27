/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.deliverCleanedLinen.vo;

import com.iba.framework.core.util.IBADateTime;


public class LinenDeliverList {

	private String linenItem;
	private String category;
	private Long requestedQty;
	private Long deliveredQty;
	private Long currentdeliveredQty;
	private String schedDeliveryDate;
	private String lateDeliveryReason;
	private String remark;
	
	
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

	public Long getCurrentdeliveredQty() {
		return currentdeliveredQty;
	}

	public void setCurrentdeliveredQty(Long currentdeliveredQty) {
		this.currentdeliveredQty = currentdeliveredQty;
	}

	public Long getDeliveredQty() {
		return deliveredQty;
	}

	public void setDeliveredQty(Long deliveredQty) {
		this.deliveredQty = deliveredQty;
	}

	public String getLateDeliveryReason() {
		return lateDeliveryReason;
	}

	public void setLateDeliveryReason(String lateDeliveryReason) {
		this.lateDeliveryReason = lateDeliveryReason;
	}

	public String getSchedDeliveryDate() {
		return schedDeliveryDate;
	}

	public void setSchedDeliveryDate(String schedDeliveryDate) {
		this.schedDeliveryDate = schedDeliveryDate;
	}

	
	

}
