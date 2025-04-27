/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.receiveLoanedLinen.vo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.ehis.lc.issueOfLinen.vo.IssueOfLinenVO;
import com.iba.ehis.lc.issueOfLinen.vo.RequestsListVO;
import com.iba.ehis.lc.returnofLinentoLaundry.vo.LinenRecordList;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.IBADateTime;

public class ReceiveLoanedLinenVO extends LcVO {

	private String loanRefNum;

	private IBADateTime loanDateFrom;

	private IBADateTime loanDateTo;

	private String sourceType;

	private String sourceCode;

	private String givenBy;

	private String loanedToSourceType;

	private String loanedToSourceCode;

	private String receivedBy;

	private String loanStatus;

	private String linenItem;

	private String reasonforLoan;

	private String shortDesc;

	private IBADateTime loanDate;

	private String receivedWriteOff;

	private Long receivedQty;

	private String receivedBackBy;

	private String givenBackBy;

	private String remarks;

	private Long loanQty;

	private String cancelledBy;

	private IBADateTime cancelledDate;

	private String cancelReason;

	private String requestStatus;

	private AutoGenerationList receiveLoanedLinenList;

	public ReceiveLoanedLinenVO() {
		receiveLoanedLinenList = new AutoGenerationList(
				ReceiveLoanedLinenList.class);
	}

	public String getGivenBy() {
		return givenBy;
	}

	public void setGivenBy(String givenBy) {
		this.givenBy = givenBy;
	}

	public String getLinenItem() {
		return linenItem;
	}

	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}

	public IBADateTime getLoanDateFrom() {
		return loanDateFrom;
	}

	public void setLoanDateFrom(IBADateTime loanDateFrom) {
		this.loanDateFrom = loanDateFrom;
	}

	public IBADateTime getLoanDateTo() {
		return loanDateTo;
	}

	public void setLoanDateTo(IBADateTime loanDateTo) {
		this.loanDateTo = loanDateTo;
	}

	public String getLoanedToSourceCode() {
		return loanedToSourceCode;
	}

	public void setLoanedToSourceCode(String loanedToSourceCode) {
		this.loanedToSourceCode = loanedToSourceCode;
	}

	public String getLoanedToSourceType() {
		return loanedToSourceType;
	}

	public void setLoanedToSourceType(String loanedToSourceType) {
		this.loanedToSourceType = loanedToSourceType;
	}

	public String getLoanRefNum() {
		return loanRefNum;
	}

	public void setLoanRefNum(String loanRefNum) {
		this.loanRefNum = loanRefNum;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public String getReasonforLoan() {
		return reasonforLoan;
	}

	public void setReasonforLoan(String reasonforLoan) {
		this.reasonforLoan = reasonforLoan;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
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

	public String getGivenBackBy() {
		return givenBackBy;
	}

	public void setGivenBackBy(String givenBackBy) {
		this.givenBackBy = givenBackBy;
	}

	public String getReceivedBackBy() {
		return receivedBackBy;
	}

	public void setReceivedBackBy(String receivedBackBy) {
		this.receivedBackBy = receivedBackBy;
	}

	public String getReceivedWriteOff() {
		return receivedWriteOff;
	}

	public void setReceivedWriteOff(String receivedWriteOff) {
		this.receivedWriteOff = receivedWriteOff;
	}

	public AutoGenerationList getReceiveLoanedLinenList() {
		return receiveLoanedLinenList;
	}

	public void setReceiveLoanedLinenList(
			AutoGenerationList receiveLoanedLinenList) {
		this.receiveLoanedLinenList = receiveLoanedLinenList;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(Long receivedQty) {
		this.receivedQty = receivedQty;
	}

	public IBADateTime getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(IBADateTime loanDate) {
		this.loanDate = loanDate;
	}

	public Long getLoanQty() {
		return loanQty;
	}

	public void setLoanQty(Long loanQty) {
		this.loanQty = loanQty;
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

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

}
