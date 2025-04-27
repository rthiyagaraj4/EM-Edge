/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.repqualityfailures.vo;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.IBADateTime;
import java.util.Date;
import java.util.*;
 
public class RepQualityFailuresVO extends LcVO {

	private IBADate dateFrom;
	private IBADate dateTo;
	private String linenItem;
	private String natureOfDefect;
	private String reasonForDefect;

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
	public String getNatureOfDefect() {
		return natureOfDefect;
	}

	public void setNatureOfDefect(String natureOfDefect) {
		this.natureOfDefect = natureOfDefect;
	}

	public String getReasonForDefect() {
		return reasonForDefect;
	}

	public void setReasonForDefect(String reasonForDefect) {
		this.reasonForDefect = reasonForDefect;
	}

	public String getLinenItem() {
		return linenItem;
	}

	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}
	
}
	
