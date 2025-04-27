/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.issueLinenAfterMending.vo;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.IBADateTime;

public class IssueLinenAfterMendingVO extends LcVO {

	/* Declaration of mealclass variables for the VO */

	private String requestNum;

	private String receiptNum;

	private String agencyCode;

	private IBADateTime requestDate;

	private String requestStatus;

	private IBADateTime issueDate;

	private String linenItem;

	private String linenDesc;

	private String sentBy;

	private String issueBy;

	private String requestedQty;

	private String operatingFacilityId;

	private AutoGenerationList linenIssueList;

	/* Generated getter and setter metods of the above variables */

	public AutoGenerationList getLinenIssueList() {
		return linenIssueList;
	}

	public void setLinenIssueList(AutoGenerationList linenIssueList) {
		this.linenIssueList = linenIssueList;
	}

	public IssueLinenAfterMendingVO() {
		linenIssueList = new AutoGenerationList(MendingIssueList.class);
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

	public IBADateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(IBADateTime issueDate) {
		this.issueDate = issueDate;
	}

	public String getIssueBy() {
		return issueBy;
	}

	public void setIssueBy(String issueBy) {
		this.issueBy = issueBy;
	}

	public String getLinenItem() {
		return linenItem;
	}

	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}

	public String getRequestedQty() {
		return requestedQty;
	}

	public void setRequestedQty(String requestedQty) {
		this.requestedQty = requestedQty;
	}

	public String getReceiptNum() {
		return receiptNum;
	}

	public void setReceiptNum(String receiptNum) {
		this.receiptNum = receiptNum;
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

	public String getLinenDesc() {
		return linenDesc;
	}

	public void setLinenDesc(String linenDesc) {
		this.linenDesc = linenDesc;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public String getOperatingFacilityId() {
		return operatingFacilityId;
	}

	public void setOperatingFacilityId(String operatingFacilityId) {
		this.operatingFacilityId = operatingFacilityId;
	}

}
