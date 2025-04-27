/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.enterCleanedLinen.vo;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.IBADateTime;

public class EnterCleanedLinenVO extends LcVO {

	/* Declaration of DeliverCleanedLinen variables for the VO */

	private String remark;

	private String linenItem;

	private IBADateTime cleaningDate;

	private String cleaningDoneBy;

	private String cleaningRefNo;

	private AutoGenerationList linenEnterList;

	/* Generated getter and setter metods of the above variables */

	public EnterCleanedLinenVO() {

		linenEnterList = new AutoGenerationList(EnterListVO.class);
	}

	public String getLinenItem() {
		return linenItem;
	}

	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}

	public AutoGenerationList getLinenEnterList() {
		return linenEnterList;
	}

	public void setLinenEnterList(AutoGenerationList linenEnterList) {
		this.linenEnterList = linenEnterList;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCleaningRefNo() {
		return cleaningRefNo;
	}

	public void setCleaningRefNo(String cleaningRefNo) {
		this.cleaningRefNo = cleaningRefNo;
	}

}
