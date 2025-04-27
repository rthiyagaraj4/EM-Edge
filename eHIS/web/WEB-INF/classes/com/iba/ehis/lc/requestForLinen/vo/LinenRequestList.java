/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.requestForLinen.vo;

import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.IBADateTime;

public class LinenRequestList {

	private String linenItem;
	private String linenItemCode;
	private Long requestedQty;
	private Long issuedQty;
	private String sourceCode;
	private String requestNo;
	private IBADateTime requestDate;
	private String raisedBy;
	private String requestStatus;
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

	public String getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(String raisedBy) {
		this.raisedBy = raisedBy;
	}

	public IBADateTime getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(IBADateTime requestDate) {
		this.requestDate = requestDate;
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

	public Long getIssuedQty() {
		return issuedQty;
	}

	public void setIssuedQty(Long issuedQty) {
		this.issuedQty = issuedQty;
	}

	public String getLinenItemCode() {
		return linenItemCode;
	}

	public void setLinenItemCode(String linenItemCode) {
		this.linenItemCode = linenItemCode;
	}

	

}
