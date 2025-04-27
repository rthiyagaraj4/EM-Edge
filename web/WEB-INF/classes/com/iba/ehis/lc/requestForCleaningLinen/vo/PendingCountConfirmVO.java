/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.requestForCleaningLinen.vo;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.IBADateTime;

public class PendingCountConfirmVO extends LcVO {
	private String sourceType;
	private String sourceCode;
	private IBADateTime requestDate;
	private IBADateTime toDate;
	private String linenItem;
	private String linenHandedOverBy;
	private String linenCollectedBy;
	private String remarks;
	private String confirm;
	
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
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
	public String getLinenItem() {
		return linenItem;
	}
	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public IBADateTime getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(IBADateTime requestDate) {
		this.requestDate = requestDate;
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
	public IBADateTime getToDate() {
		return toDate;
	}
	public void setToDate(IBADateTime toDate) {
		this.toDate = toDate;
	}

}
