/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.reason.vo;

import java.util.List;
import java.util.Map;

import com.iba.ehis.core.vo.QueryCriteriaVO;
import com.iba.ehis.dobj.LcReasonDtl;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.Page;

public class ReasonVO extends LcVO {

	/* Declaration of Reason variables for the VO */

	private AutoGenerationList actionTypeList;

	private String actionType;

	private String activeYn;

	private String reasonCode;

	private String reasonDesc;

	private String effStatus;

	private Map Code;

	private Map Desc;

	/* Generated getter and setter metods of the above variables */
	public ReasonVO() {
		actionTypeList = new AutoGenerationList(ReasonsVO.class);
	}

	public AutoGenerationList getActionTypeList() {
		return actionTypeList;
	}

	public void setActionTypeList(AutoGenerationList actionTypeList) {
		this.actionTypeList = actionTypeList;
	}

	public Map getCode() {
		return Code;
	}

	public void setCode(Map code) {
		Code = code;
	}

	public Map getDesc() {
		return Desc;
	}

	public void setDesc(Map desc) {
		Desc = desc;
	}

	public String getEffStatus() {
		if (effStatus == null)
			effStatus = "D";
		return effStatus;
	}

	public void setEffStatus(String effStatus) {
		this.effStatus = effStatus;
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

}
