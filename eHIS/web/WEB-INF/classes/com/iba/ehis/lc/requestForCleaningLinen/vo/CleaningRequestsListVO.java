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
package com.iba.ehis.lc.requestForCleaningLinen.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;


import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.IBADateTime;

/**
 * @author YadavK
 * 
 */
public class CleaningRequestsListVO extends LcVO {

	
	private String sourceType;
	private String sourceCode;
	private String requestNo;
	private Long requestedQty;

	private String remarks;
	private IBADateTime requestDate;
	private String toDate;
	private String linenHandedOverBy;
	private String linenCollectedBy;
	private String requestStatus;
	private String linenItem;
	
	private String cancelledBy;
	private IBADateTime cancelledDate;
	private String reasonCode;
	private String reasonDesc;
	
	private String scheduleDeliveryDate;
	private String category;
    private String countConfirmedYn;
     private String countConfirmedBy;
     private IBADateTime countConfirmedDate;

	
	private AutoGenerationList linenRequest;
	
	public CleaningRequestsListVO() {
		linenRequest = new AutoGenerationList(CleaningLinenRequestList.class);
		}
	
	public IBADateTime getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(IBADateTime requestDate) {
		this.requestDate = requestDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
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
	
	public AutoGenerationList getLinenRequest() {
		return linenRequest;
	}

	public void setLinenRequest(AutoGenerationList linenRequest) {
		this.linenRequest = linenRequest;
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

	public String getLinenHandedOverBy() {
		return linenHandedOverBy;
	}

	public void setLinenHandedOverBy(String linenHandedOverBy) {
		this.linenHandedOverBy = linenHandedOverBy;
	}

	public String getLinenCollectedBy() {
		return linenCollectedBy;
	}

	public void setLinenCollectedBy(String linenCollectedBy) {
		this.linenCollectedBy = linenCollectedBy;
	}

	public String getCancelledBy() {
		return cancelledBy;
	}

	public void setCancelledBy(String cancelledBy) {
		this.cancelledBy = cancelledBy;
	}

	public IBADateTime getCancelledDate() {
		return cancelledDate;
	}

	public void setCancelledDate(IBADateTime cancelledDate) {
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

	public String getCountConfirmedYn() {
		return countConfirmedYn;
	}

	public void setCountConfirmedYn(String countConfirmedYn) {
		this.countConfirmedYn = countConfirmedYn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getScheduleDeliveryDate() {
		return scheduleDeliveryDate;
	}

	public void setScheduleDeliveryDate(String scheduleDeliveryDate) {
		this.scheduleDeliveryDate = scheduleDeliveryDate;
	}

	

	

}
