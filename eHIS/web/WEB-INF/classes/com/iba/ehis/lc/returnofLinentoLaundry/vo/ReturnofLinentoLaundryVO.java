/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.returnofLinentoLaundry.vo;

import java.util.Map;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.ehis.lc.requestForLinen.vo.LinenRequestList;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.IBADateTime;

public class ReturnofLinentoLaundryVO extends LcVO {

	private String referenceNum;

	private IBADateTime requestDate;
	
	private IBADateTime addDate;

	private String sourceType;

	private String sourceCode;

	private String receivedBy;

	private String returnedBy;

	private String linenItem;

	private String remark;

	private AutoGenerationList linenRequest;

	public ReturnofLinentoLaundryVO() {
		linenRequest = new AutoGenerationList(LinenRecordList.class);
	}

	private Long returnedQty;

	public String getLinenItem() {
		return linenItem;
	}

	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public String getReferenceNum() {
		return referenceNum;
	}

	public void setReferenceNum(String referenceNum) {
		this.referenceNum = referenceNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public IBADateTime getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(IBADateTime requestDate) {
		this.requestDate = requestDate;
	}

	public String getReturnedBy() {
		return returnedBy;
	}

	public void setReturnedBy(String returnedBy) {
		this.returnedBy = returnedBy;
	}

	public Long getReturnedQty() {
		return returnedQty;
	}

	public void setReturnedQty(Long returnedQty) {
		this.returnedQty = returnedQty;
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

	public IBADateTime getAddDate() {
		return addDate;
	}

	public void setAddDate(IBADateTime addDate) {
		this.addDate = addDate;
	}

	
}
