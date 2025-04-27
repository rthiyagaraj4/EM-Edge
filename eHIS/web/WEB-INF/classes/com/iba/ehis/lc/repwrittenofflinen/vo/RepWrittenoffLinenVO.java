/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.repwrittenofflinen.vo;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.IBADateTime;
import java.util.Date;
import java.util.*;

public class RepWrittenoffLinenVO extends LcVO {
	
	
	private String  sourceType;
	private String sourceCode;
	private IBADate fromDate;
	private IBADate toDate;
	private String linenItem;
	private String reasonforWriteOff;
	
	public IBADate getFromDate() {
		return fromDate;
	}
	public void setFromDate(IBADate fromDate) {
		this.fromDate = fromDate;
	}
	public String getLinenItem() {
		return linenItem;
	}
	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}
	public String getReasonforWriteOff() {
		return reasonforWriteOff;
	}
	public void setReasonforWriteOff(String reasonforWriteOff) {
		this.reasonforWriteOff = reasonforWriteOff;
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
	public IBADate getToDate() {
		return toDate;
	}
	public void setToDate(IBADate toDate) {
		this.toDate = toDate;
	}
		
	
}
	
