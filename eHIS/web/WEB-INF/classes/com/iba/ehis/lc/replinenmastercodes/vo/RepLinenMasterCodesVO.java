/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.replinenmastercodes.vo;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.IBADateTime;
import java.util.*;

public class RepLinenMasterCodesVO extends LcVO {
	
	private String repNames;
	private String agencyCodeFrom;
	private String agencyCodeTo;
	private String reasonCodeFrom;
	private String reasonCodeTo;
	private String actionTypeCodeFrom;
	private String actionTypeCodeTo;
	private String active;
	private String sourceType;
	private String sourceCodeFrom;
	private String sourceCodeTo;
	private String linenTypeFrom;
	private String linenTypeTo;
	private String linenItemFrom;
	private String linenItemTo;
	private String groupBy;
	private String laundryFrom;
	private String laundryTo;
	private String overRide;
	private String effStatus;
	private String repId;
	
	public String getActionTypeCodeFrom() {
		return actionTypeCodeFrom;
	}
	public void setActionTypeCodeFrom(String actionTypeCodeFrom) {
		this.actionTypeCodeFrom = actionTypeCodeFrom;
	}
	public String getActionTypeCodeTo() {
		return actionTypeCodeTo;
	}
	public void setActionTypeCodeTo(String actionTypeCodeTo) {
		this.actionTypeCodeTo = actionTypeCodeTo;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getAgencyCodeFrom() {
		return agencyCodeFrom;
	}
	public void setAgencyCodeFrom(String agencyCodeFrom) {
		this.agencyCodeFrom = agencyCodeFrom;
	}
	public String getAgencyCodeTo() {
		return agencyCodeTo;
	}
	public void setAgencyCodeTo(String agencyCodeTo) {
		this.agencyCodeTo = agencyCodeTo;
	}
	public String getEffStatus() {
		return effStatus;
	}
	public void setEffStatus(String effStatus) {
		this.effStatus = effStatus;
	}
	public String getGroupBy() {
		return groupBy;
	}
	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}
	public String getLaundryFrom() {
		return laundryFrom;
	}
	public void setLaundryFrom(String laundryFrom) {
		this.laundryFrom = laundryFrom;
	}
	public String getLaundryTo() {
		return laundryTo;
	}
	public void setLaundryTo(String laundryTo) {
		this.laundryTo = laundryTo;
	}
	public String getLinenItemFrom() {
		return linenItemFrom;
	}
	public void setLinenItemFrom(String linenItemFrom) {
		this.linenItemFrom = linenItemFrom;
	}
	public String getLinenItemTo() {
		return linenItemTo;
	}
	public void setLinenItemTo(String linenItemTo) {
		this.linenItemTo = linenItemTo;
	}
	public String getOverRide() {
		return overRide;
	}
	public void setOverRide(String overRide) {
		this.overRide = overRide;
	}
	public String getReasonCodeFrom() {
		return reasonCodeFrom;
	}
	public void setReasonCodeFrom(String reasonCodeFrom) {
		this.reasonCodeFrom = reasonCodeFrom;
	}
	public String getReasonCodeTo() {
		return reasonCodeTo;
	}
	public void setReasonCodeTo(String reasonCodeTo) {
		this.reasonCodeTo = reasonCodeTo;
	}
	public String getRepNames() {
		return repNames;
	}
	public void setRepNames(String repNames) {
		this.repNames = repNames;
	}
	public String getSourceCodeFrom() {
		return sourceCodeFrom;
	}
	public void setSourceCodeFrom(String sourceCodeFrom) {
		this.sourceCodeFrom = sourceCodeFrom;
	}
	public String getSourceCodeTo() {
		return sourceCodeTo;
	}
	public void setSourceCodeTo(String sourceCodeTo) {
		this.sourceCodeTo = sourceCodeTo;
	}
	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
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
	public String getRepId() {
		return repId;
	}
	public void setRepId(String repId) {
		this.repId = repId;
	}
	
}
	
