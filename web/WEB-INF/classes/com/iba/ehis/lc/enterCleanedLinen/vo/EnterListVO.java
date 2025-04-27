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
package com.iba.ehis.lc.enterCleanedLinen.vo;

import java.util.List;
import java.util.Map;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.IBADateTime;

/**
 * @author yadavK
 * 
 */
public class EnterListVO extends LcVO {

	private String linenItem;

	private Long pendingQuantity;

	private Long cleanedQuantity;

	private String qualityPassed;

	private String natureOfDefect;

	private String reasonForDefect;

	private IBADateTime cleaningDate;

	private String cleaningDoneBy;

	private String remark;

	public String getLinenItem() {
		return linenItem;
	}

	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getCleanedQuantity() {
		return cleanedQuantity;
	}

	public void setCleanedQuantity(Long cleanedQuantity) {
		this.cleanedQuantity = cleanedQuantity;
	}

	public IBADateTime getCleaningDate() {
		return cleaningDate;
	}

	public void setCleaningDate(IBADateTime cleaningDate) {
		this.cleaningDate = cleaningDate;
	}

	public String getCleaningDoneBy() {
		return cleaningDoneBy;
	}

	public void setCleaningDoneBy(String cleaningDoneBy) {
		this.cleaningDoneBy = cleaningDoneBy;
	}

	public String getNatureOfDefect() {
		return natureOfDefect;
	}

	public void setNatureOfDefect(String natureOfDefect) {
		this.natureOfDefect = natureOfDefect;
	}

	public Long getPendingQuantity() {
		return pendingQuantity;
	}

	public void setPendingQuantity(Long pendingQuantity) {
		this.pendingQuantity = pendingQuantity;
	}

	public String getQualityPassed() {
		if (qualityPassed == null)
			qualityPassed = "N";
		return qualityPassed;
	}

	public void setQualityPassed(String qualityPassed) {
		this.qualityPassed = qualityPassed;
	}

	public String getReasonForDefect() {
		return reasonForDefect;
	}

	public void setReasonForDefect(String reasonForDefect) {
		this.reasonForDefect = reasonForDefect;
	}

}
