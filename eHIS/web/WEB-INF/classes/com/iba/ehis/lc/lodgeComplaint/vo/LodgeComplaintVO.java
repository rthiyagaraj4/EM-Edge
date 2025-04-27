/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.lodgeComplaint.vo;

import java.util.Map;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.IBADateTime;

public class LodgeComplaintVO extends LcVO {

	private String complaintNum;

	private IBADateTime complaintDate;

	private String complaintSource;

	private String complaintSourceType;

	private String complaintAgainstSource;
 
	private String complaintAgainstSourceType;

	private String complaintActivity;

	private Map complaintActivityMap;

	private String complaint;

	private String complaintDesc;

	private String complaintBy;
	
	private String locale;

	private AutoGenerationList complaintList;

	public LodgeComplaintVO() {
		complaintList = new AutoGenerationList(LodgeComplaintList.class);
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getComplaintActivity() {
		return complaintActivity;
	}

	public void setComplaintActivity(String complaintActivity) {
		this.complaintActivity = complaintActivity;
	}

	public String getComplaintAgainstSource() {
		return complaintAgainstSource;
	}

	public void setComplaintAgainstSource(String complaintAgainstSource) {
		this.complaintAgainstSource = complaintAgainstSource;
	}

	public String getComplaintAgainstSourceType() {
		return complaintAgainstSourceType;
	}

	public void setComplaintAgainstSourceType(String complaintAgainstSourceType) {
		this.complaintAgainstSourceType = complaintAgainstSourceType;
	}

	public String getComplaintBy() {
		return complaintBy;
	}

	public void setComplaintBy(String complaintBy) {
		this.complaintBy = complaintBy;
	}

	public IBADateTime getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(IBADateTime complaintDate) {
		this.complaintDate = complaintDate;
	}

	public AutoGenerationList getComplaintList() {
		return complaintList;
	}

	public void setComplaintList(AutoGenerationList complaintList) {
		this.complaintList = complaintList;
	}

	public String getComplaintNum() {
		return complaintNum;
	}

	public void setComplaintNum(String complaintNum) {
		this.complaintNum = complaintNum;
	}

	public String getComplaintSource() {
		return complaintSource;
	}

	public void setComplaintSource(String complaintSource) {
		this.complaintSource = complaintSource;
	}

	public String getComplaintSourceType() {
		return complaintSourceType;
	}

	public void setComplaintSourceType(String complaintSourceType) {
		this.complaintSourceType = complaintSourceType;
	}

	public Map getComplaintActivityMap() {
		return complaintActivityMap;
	}

	public void setComplaintActivityMap(Map complaintActivityMap) {
		this.complaintActivityMap = complaintActivityMap;
	}

	public String getComplaintDesc() {
		return complaintDesc;
	}

	public void setComplaintDesc(String complaintDesc) {
		this.complaintDesc = complaintDesc;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

}
