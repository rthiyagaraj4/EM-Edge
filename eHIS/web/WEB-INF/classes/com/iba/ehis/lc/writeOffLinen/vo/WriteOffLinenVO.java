/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.writeOffLinen.vo;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.IBADateTime;

public class WriteOffLinenVO extends LcVO {

	/* Declaration of WriteOffLinenVO variables for the VO */

	private String sourceCode;

	private String SourceType;

	private String Source;

	private String linenItem;

	private String linenItemCode;

	private String linenTypeCode;

	private String refNum;

	private Long existingQty;

	private Long writeOffQty;
	
	private IBADateTime writeOffDate;

	private String reason;

	private String reasonCode;

	private String remarks;

	private IBADateTime date;
	
	private String operatingFacilityId;

	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Long getExistingQty() {
		return existingQty;
	}

	public void setExistingQty(Long existingQty) {
		this.existingQty = existingQty;
	}

	public String getLinenItem() {
		return linenItem;
	}

	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}

	public String getLinenTypeCode() {
		return linenTypeCode;
	}

	public void setLinenTypeCode(String linenTypeCode) {
		this.linenTypeCode = linenTypeCode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRefNum() {
		return refNum;
	}

	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public Long getWriteOffQty() {
		return writeOffQty;
	}

	public void setWriteOffQty(Long writeOffQty) {
		this.writeOffQty = writeOffQty;
	}

	public String getSourceType() {
		return SourceType;
	}

	public void setSourceType(String sourceType) {
		SourceType = sourceType;
	}

	public IBADateTime getDate() {
		return date;
	}

	public void setDate(IBADateTime date) {
		this.date = date;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getLinenItemCode() {
		return linenItemCode;
	}

	public void setLinenItemCode(String linenItemCode) {
		this.linenItemCode = linenItemCode;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getOperatingFacilityId() {
		return operatingFacilityId;
	}

	public void setOperatingFacilityId(String operatingFacilityId) {
		this.operatingFacilityId = operatingFacilityId;
	}

	public IBADateTime getWriteOffDate() {
		return writeOffDate;
	}

	public void setWriteOffDate(IBADateTime writeOffDate) {
		this.writeOffDate = writeOffDate;
	}

	/* Generated getter and setter metods of the above variables */

}
