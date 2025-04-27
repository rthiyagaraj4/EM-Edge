/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.linenType.vo;

import com.iba.ehis.lc.core.vo.LcVO;

public class LinentypeVO extends LcVO {

	/* Declaration of mealclass variables for the VO */

	private String linenTypeCode;

	private String linenTypeDesc;

	private String effStatus;

	/* Generated getter and setter metods of the above variables */

	public String getEffStatus() {

		if (effStatus == null)
			effStatus = "D";
		return effStatus;
	}

	public void setEffStatus(String effStatus) {
		this.effStatus = effStatus;

	}

	public String getLinenTypeDesc() {
		return linenTypeDesc;
	}

	public void setLinenTypeDesc(String linenTypeDesc) {
		this.linenTypeDesc = linenTypeDesc;
	}

	public String getLinenTypeCode() {
		return linenTypeCode;
	}

	public void setLinenTypeCode(String linenTypeCode) {
		this.linenTypeCode = linenTypeCode;
	}

}
