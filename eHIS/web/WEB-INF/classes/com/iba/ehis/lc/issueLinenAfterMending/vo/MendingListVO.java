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
package com.iba.ehis.lc.issueLinenAfterMending.vo;

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
public class MendingListVO extends LcVO {

	private String raisedBy;

	private String agencyCode;

	private String requestNo;

	private Long requestedQty;

	private Long issuedQty;

	private String remarks;

	private IBADateTime requestDate;

	private String toDate;

	private String sentBy;

	private String requestStatus;

	private String linenItem;

	private String shortDesc;

	private AutoGenerationList linenIssue;

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

	public String getSentBy() {
		return sentBy;
	}

	public void setSentBy(String sentBy) {
		this.sentBy = sentBy;
	}

	public MendingListVO() {
		linenIssue = new AutoGenerationList(MendingIssueList.class);
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

	public Long getIssuedQty() {
		return issuedQty;
	}

	public void setIssuedQty(Long issuedQty) {
		this.issuedQty = issuedQty;
	}

	public Long getRequestedQty() {
		return requestedQty;
	}

	public void setRequestedQty(Long requestedQty) {
		this.requestedQty = requestedQty;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public String getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(String raisedBy) {
		this.raisedBy = raisedBy;
	}

}
