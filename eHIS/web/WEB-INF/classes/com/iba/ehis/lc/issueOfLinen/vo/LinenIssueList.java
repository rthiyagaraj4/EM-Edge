/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.issueOfLinen.vo;

import com.iba.framework.core.util.IBADate;

public class LinenIssueList {

	private String linenItem;
	private Long requestedQty;
	private Long issueQty;
	private Long currentIssueQty;
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

	

	public Long getCurrentIssueQty() {
		return currentIssueQty;
	}

	public void setCurrentIssueQty(Long currentIssueQty) {
		this.currentIssueQty = currentIssueQty;
	}

	public Long getIssueQty() {
		return issueQty;
	}

	public void setIssueQty(Long issueQty) {
		this.issueQty = issueQty;
	}

	
	

}
