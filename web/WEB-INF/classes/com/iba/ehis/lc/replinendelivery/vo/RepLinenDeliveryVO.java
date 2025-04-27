/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.replinendelivery.vo;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.IBADateTime;
import java.util.Date;
import java.util.*;

public class RepLinenDeliveryVO extends LcVO {
	
	private IBADate from;
	private IBADate to;
	private IBADate dateTo;
	private IBADate dateFrom;
	private String linenItem;
	private String sourceType;
	private String sourceCode;
	
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
	public IBADate getFrom() {
		return from;
	}
	public void setFrom(IBADate from) {
		this.from = from;
	}
	public String getLinenItem() {
		return linenItem;
	}
	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
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
	public IBADate getTo() {
		return to;
	}
	public void setTo(IBADate to) {
		this.to = to;
	}
}
	
