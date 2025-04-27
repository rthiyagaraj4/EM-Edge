/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.replinentypes.vo;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.IBADateTime;
import java.util.Date;
import java.util.*;
public class RepLinenTypesVO extends LcVO {

	private String linenTypeFrom;
	private String linenTypeTo;
	private String effStatus;
	
	public String getEffStatus() {
		return effStatus;
	}
	public void setEffStatus(String effStatus) {
		this.effStatus = effStatus;
	}
	public String getLinenTypeFrom() {
		return linenTypeFrom;
	}
	public void setLinenTypeFrom(String linenTypeFrom) {
		this.linenTypeFrom = linenTypeFrom;
	}
	public String getLinenTypeTo() {
		return linenTypeTo;
	}
	public void setLinenTypeTo(String linenTypeTo) {
		this.linenTypeTo = linenTypeTo;
	}
		
}
	
