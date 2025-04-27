/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.replatedeliveries.vo;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.IBADateTime;
import java.util.Date;
import java.util.*;

public class RepLateDeliveriesVO extends LcVO {
		
	private IBADate dateFrom;
	private IBADate dateTo;
	private String linenItem;
	private String sourceType;
	private String sourceCode;
	
	private Map SourceMap;

	public IBADate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(IBADate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public IBADate getDateTo() {
		return dateTo;
	}

	public void setDateTo(IBADate dateTo) {
		this.dateTo = dateTo;
	}

	public String getLinenItem() {
		return linenItem;
	}

	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}

	public Map getSourceMap() {
		return SourceMap;
	}

	public void setSourceMap(Map sourceMap) {
		SourceMap = sourceMap;
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
	
}
	
