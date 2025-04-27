/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.standardStock.vo;

import java.util.List;
import java.util.Map;

import com.iba.ehis.core.vo.QueryCriteriaVO;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.Page;

public class StandardStockVO extends LcVO {

	/* Declaration of WardsForKitchen variables for the VO */

	private AutoGenerationList stockList;

	private boolean flag;

	private Long stdQty;

	private String operatingFacilityId;

	private String sourceType;

	private String sourceCode;

	private String linenItem;

	/* Generated getter and setter metods of the above variables */

	public String getLinenItem() {
		return linenItem;
	}

	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}

	public String getOperatingFacilityId() {
		return operatingFacilityId;
	}

	public void setOperatingFacilityId(String operatingFacilityId) {
		this.operatingFacilityId = operatingFacilityId;
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

	public Long getStdQty() {
		return stdQty;
	}

	public void setStdQty(Long stdQty) {
		this.stdQty = stdQty;
	}

	public StandardStockVO() {

		stockList = new AutoGenerationList(StandardStockListVO.class);
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public AutoGenerationList getStockList() {
		return stockList;
	}

	public void setStockList(AutoGenerationList stockList) {
		this.stockList = stockList;
	}

}
