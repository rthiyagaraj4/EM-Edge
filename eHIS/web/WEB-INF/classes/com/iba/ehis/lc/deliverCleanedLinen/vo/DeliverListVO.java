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
package com.iba.ehis.lc.deliverCleanedLinen.vo;

import java.util.List;
import java.util.Map;


import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.IBADateTime;

/**
 * @author ParimalaK
 * 
 */
public class DeliverListVO extends LcVO {

	
	private String sourceType;
	private String sourceCode;
	private String requestNo;
	private Long requestedQty;
	private String deliveryDate;
	private String remarks;
	private String requestDate;
	private String category;
	
	
	private String requestStatus;
	private String linenItem;
	private String linenDesc;
	
	private String linenHandedOverBy;
	private String linenCollectedBy;
	
	private String cancelledBy;
	private String cancelledDate;
	private String reasonCode;
	private String reasonDesc;
	private AutoGenerationList linenIssue;
	

	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	
	public String getLinenItem() {
		return linenItem;
	}
	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
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
	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	
	public DeliverListVO() {
		linenIssue = new AutoGenerationList(LinenDeliverList.class);
	}
	
	public AutoGenerationList getLinenIssue() {
		return linenIssue;
	}
	public void setLinenIssue(AutoGenerationList linenIssue) {
		this.linenIssue = linenIssue;
	}
	public String getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getRequestedQty() {
		return requestedQty;
	}
	public void setRequestedQty(Long requestedQty) {
		this.requestedQty = requestedQty;
	}
	public String getLinenCollectedBy() {
		return linenCollectedBy;
	}
	public void setLinenCollectedBy(String linenCollectedBy) {
		this.linenCollectedBy = linenCollectedBy;
	}
	public String getLinenHandedOverBy() {
		return linenHandedOverBy;
	}
	public void setLinenHandedOverBy(String linenHandedOverBy) {
		this.linenHandedOverBy = linenHandedOverBy;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getCancelledBy() {
		return cancelledBy;
	}
	public void setCancelledBy(String cancelledBy) {
		this.cancelledBy = cancelledBy;
	}
	public String getCancelledDate() {
		return cancelledDate;
	}
	public void setCancelledDate(String cancelledDate) {
		this.cancelledDate = cancelledDate;
	}
	public String getReasonCode() {
		return reasonCode;
	}
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	public String getReasonDesc() {
		return reasonDesc;
	}
	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLinenDesc() {
		return linenDesc;
	}
	public void setLinenDesc(String linenDesc) {
		this.linenDesc = linenDesc;
	}

	

}
