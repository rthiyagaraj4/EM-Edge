/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.core.vo;

import java.util.Date;

import com.iba.framework.core.vo.BaseVO;

public class AppVO extends BaseVO {
	private int mode;

	private String addedById;

	private Date addedDate;

	private String addedAtWsNo;

	private String addedFacilityId;

	private String modifiedById;

	private Date modifiedDate;

	private String modifiedAtWsNo;

	private String modifiedFacilityId;

	private String moduleId;

	private String functionId;

	public String getAddedAtWsNo() {
		return addedAtWsNo;
	}

	public void setAddedAtWsNo(String addedAtWsNo) {
		this.addedAtWsNo = addedAtWsNo;
	}

	public String getAddedById() {
		return addedById;
	}

	public void setAddedById(String addedById) {
		this.addedById = addedById;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public String getAddedFacilityId() {
		return addedFacilityId;
	}

	public void setAddedFacilityId(String addedFacilityId) {
		this.addedFacilityId = addedFacilityId;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public String getModifiedAtWsNo() {
		return modifiedAtWsNo;
	}

	public void setModifiedAtWsNo(String modifiedAtWsNo) {
		this.modifiedAtWsNo = modifiedAtWsNo;
	}

	public String getModifiedById() {
		return modifiedById;
	}

	public void setModifiedById(String modifiedById) {
		this.modifiedById = modifiedById;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedFacilityId() {
		return modifiedFacilityId;
	}

	public void setModifiedFacilityId(String modifiedFacilityId) {
		this.modifiedFacilityId = modifiedFacilityId;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
}
