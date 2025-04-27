/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.lodgeComplaint.vo;

import com.iba.framework.core.util.IBADateTime;

public class LodgeComplaintList {

	private String linenItem;

	private String referenceRequestNum;

	private String complaintNo;

	private IBADateTime referenceRequestDate;

	private Long quantity;

	public String getComplaintNo() {
		return complaintNo;
	}

	public void setComplaintNo(String complaintNo) {
		this.complaintNo = complaintNo;
	}

	public String getLinenItem() {
		return linenItem;
	}

	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public IBADateTime getReferenceRequestDate() {
		return referenceRequestDate;
	}

	public void setReferenceRequestDate(IBADateTime referenceRequestDate) {
		this.referenceRequestDate = referenceRequestDate;
	}

	public String getReferenceRequestNum() {
		return referenceRequestNum;
	}

	public void setReferenceRequestNum(String referenceRequestNum) {
		this.referenceRequestNum = referenceRequestNum;
	}

}
