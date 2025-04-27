/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.issueOfLinen.vo;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.IBADateTime;

public class IssueOfLinenVO extends LcVO {
	
	/* Declaration of mealclass variables for the VO  */
	
	private String requestNum;
	private String issueNum;

	private IBADateTime requestDate;
	private String requestStatus;
	private IBADateTime issueDate;
	
	private String linenItem;
	private String linenDesc;
	
	private String sourceType;
	private String sourceDesc;
	private String sourceCode;
	
	private String raisedBy;
	private String issueBy;
	private String requestedQty;
		
	

	private AutoGenerationList linenIssueList;

	
	/* Generated getter and setter metods of the above variables */
	
	
	public AutoGenerationList getLinenIssueList() {
		return linenIssueList;
	}



	public void setLinenIssueList(AutoGenerationList linenIssueList) {
		this.linenIssueList = linenIssueList;
	}



	public IssueOfLinenVO() {
		linenIssueList = new AutoGenerationList(LinenIssueList.class);
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



	public String getIssueNum() {
		return issueNum;
	}



	public void setIssueNum(String issueNum) {
		this.issueNum = issueNum;
	}



	public String getRequestStatus() {
		return requestStatus;
	}



	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}



	public String getSourceDesc() {
		return sourceDesc;
	}



	public void setSourceDesc(String sourceDesc) {
		this.sourceDesc = sourceDesc;
	}



	public String getLinenDesc() {
		return linenDesc;
	}



	public void setLinenDesc(String linenDesc) {
		this.linenDesc = linenDesc;
	}

}
