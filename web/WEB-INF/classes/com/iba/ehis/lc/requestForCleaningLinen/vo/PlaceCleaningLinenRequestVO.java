/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.requestForCleaningLinen.vo;

import java.util.Map;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.IBADateTime;

public class PlaceCleaningLinenRequestVO extends LcVO {
	
	private String requestNum;

	private IBADateTime requestDate;
	
	private IBADateTime scheduleDate;

	private String sourceType;

	private String sourceCode;
	
	private String linenHandedOverBy;
	
	private String linenCollectedBy;
	
	private String requestStatus;
	
	private String linenItem;
	
	private String countConfirmedYn;
	
	private String category;
	private String requestedQty;
	private String remarks;
	
	
	private String cancelledBy;
	private IBADateTime cancelledDate;
	private String reasonCode;
	private String reasonDesc;

	private String flag;

	
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
		

	private AutoGenerationList cleanLinenRequest;

	public PlaceCleaningLinenRequestVO() {
		cleanLinenRequest = new AutoGenerationList(CleaningLinenRequestList.class);
	}
	
	public AutoGenerationList getCleanLinenRequest() {
		return cleanLinenRequest;
	}


	public void setCleanLinenRequest(AutoGenerationList cleanLinenRequest) {
		this.cleanLinenRequest = cleanLinenRequest;
	}

	public IBADateTime getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(IBADateTime requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestNum() {
		return requestNum;
	}

	public void setRequestNum(String requestNum) {
		this.requestNum = requestNum;
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

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getLinenItem() {
		return linenItem;
	}
	public String getCategory() {
		return category;
	}






	public void setCategory(String category) {
		this.category = category;
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






	public String getRemarks() {
		return remarks;
	}






	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}






	public String getRequestedQty() {
		return requestedQty;
	}






	public void setRequestedQty(String requestedQty) {
		this.requestedQty = requestedQty;
	}






	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
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

	public String getCountConfirmedYn() {
		return countConfirmedYn;
	}

	public void setCountConfirmedYn(String countConfirmedYn) {
		this.countConfirmedYn = countConfirmedYn;
	}
	public IBADateTime getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(IBADateTime scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

		
}
