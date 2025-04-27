/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.reason.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.vo.BaseVO;

public class ReasonsVO extends LcVO {
	private String reasonCode;

	private String reasonDesc;

	private String effStatus;

	private String actionType;

	private String activeYn;

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getActiveYn() {
		return activeYn;
	}

	public void setActiveYn(String activeYn) {
		this.activeYn = activeYn;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getReasonDesc() {
		return reasonDesc;
	}

	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
	}

	public String getEffStatus() {
		return effStatus;
	}

	public void setEffStatus(String effStatus) {
		this.effStatus = effStatus;
	};

}
