/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.setupParameter.vo;

import java.util.Date;
import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.IBADateTime;

public class SetupParameterVO extends LcVO {

	/* Declaration of SetupParameterVO variables for the VO */

	private String laundryCode;
	private String operationFacilityid;

	private IBADateTime cutOffTimeForLinRecptFr;
	private IBADateTime cutOffTimeForLinRecptTo;

	private IBADateTime cutOffTimeForLinRecpt2Fr;
	private IBADateTime cutOffTimeForLinRecpt2To;

	private IBADateTime cutOffTimeForLinRecpt3Fr;
	private IBADateTime cutOffTimeForLinRecpt3To;
	private Long noOfcutOfTimings;

	private IBADateTime cutOffTimeForLinenDelv;

	private String dirtyLinenEntryByLaundry;

	private String confReqdForDirtyLinen;

	private String stdStockChk;

	   
	private IBADateTime cutOffTimeForLinenDelv2;
	
	   
	private IBADateTime cutOffTimeForLinenDelv3;
	
	
	private Long cutOfDaysForLinenDelv;
 	
	private Long cutOfDaysForLinenDelv2;
 	
	private Long cutOfDaysForLinenDelv3;

	/* Generated getter and setter metods of the above variables */
	public SetupParameterVO() {

	}

	public String getConfReqdForDirtyLinen() {
		if (confReqdForDirtyLinen == null)
			confReqdForDirtyLinen = "N";
		return confReqdForDirtyLinen;
	}

	public void setConfReqdForDirtyLinen(String confReqdForDirtyLinen) {
		this.confReqdForDirtyLinen = confReqdForDirtyLinen;
	}

	public IBADateTime getCutOffTimeForLinenDelv() {
		return cutOffTimeForLinenDelv;
	}

	public void setCutOffTimeForLinenDelv(IBADateTime cutOffTimeForLinenDelv) {
		this.cutOffTimeForLinenDelv = cutOffTimeForLinenDelv;
	}


	public String getDirtyLinenEntryByLaundry() {
		if (dirtyLinenEntryByLaundry == null)
			dirtyLinenEntryByLaundry = "N";
		return dirtyLinenEntryByLaundry;
	}

	public void setDirtyLinenEntryByLaundry(String dirtyLinenEntryByLaundry) {
		this.dirtyLinenEntryByLaundry = dirtyLinenEntryByLaundry;
	}

	public String getLaundryCode() {
		return laundryCode;
	}

	public void setLaundryCode(String laundryCode) {
		this.laundryCode = laundryCode;
	}

	public String getStdStockChk() {
		return stdStockChk;
	}

	public void setStdStockChk(String stdStockChk) {
		this.stdStockChk = stdStockChk;
	}

	public Long getCutOfDaysForLinenDelv() {
		return cutOfDaysForLinenDelv;
	}

	public void setCutOfDaysForLinenDelv(Long cutOfDaysForLinenDelv) {
		this.cutOfDaysForLinenDelv = cutOfDaysForLinenDelv;
	}

	public Long getCutOfDaysForLinenDelv2() {
		return cutOfDaysForLinenDelv2;
	}

	public void setCutOfDaysForLinenDelv2(Long cutOfDaysForLinenDelv2) {
		this.cutOfDaysForLinenDelv2 = cutOfDaysForLinenDelv2;
	}

	public Long getCutOfDaysForLinenDelv3() {
		return cutOfDaysForLinenDelv3;
	}

	public void setCutOfDaysForLinenDelv3(Long cutOfDaysForLinenDelv3) {
		this.cutOfDaysForLinenDelv3 = cutOfDaysForLinenDelv3;
	}

	public IBADateTime getCutOffTimeForLinenDelv2() {
		return cutOffTimeForLinenDelv2;
	}

	public void setCutOffTimeForLinenDelv2(IBADateTime cutOffTimeForLinenDelv2) {
		this.cutOffTimeForLinenDelv2 = cutOffTimeForLinenDelv2;
	}

	public IBADateTime getCutOffTimeForLinenDelv3() {
		return cutOffTimeForLinenDelv3;
	}

	public void setCutOffTimeForLinenDelv3(IBADateTime cutOffTimeForLinenDelv3) {
		this.cutOffTimeForLinenDelv3 = cutOffTimeForLinenDelv3;
	}

	
	public IBADateTime getCutOffTimeForLinRecpt2Fr() {
		return cutOffTimeForLinRecpt2Fr;
	}

	public void setCutOffTimeForLinRecpt2Fr(IBADateTime cutOffTimeForLinRecpt2Fr) {
		this.cutOffTimeForLinRecpt2Fr = cutOffTimeForLinRecpt2Fr;
	}

	public IBADateTime getCutOffTimeForLinRecpt2To() {
		return cutOffTimeForLinRecpt2To;
	}

	public void setCutOffTimeForLinRecpt2To(IBADateTime cutOffTimeForLinRecpt2To) {
		this.cutOffTimeForLinRecpt2To = cutOffTimeForLinRecpt2To;
	}

	public IBADateTime getCutOffTimeForLinRecpt3Fr() {
		return cutOffTimeForLinRecpt3Fr;
	}

	public void setCutOffTimeForLinRecpt3Fr(IBADateTime cutOffTimeForLinRecpt3Fr) {
		this.cutOffTimeForLinRecpt3Fr = cutOffTimeForLinRecpt3Fr;
	}

	public IBADateTime getCutOffTimeForLinRecpt3To() {
		return cutOffTimeForLinRecpt3To;
	}

	public void setCutOffTimeForLinRecpt3To(IBADateTime cutOffTimeForLinRecpt3To) {
		this.cutOffTimeForLinRecpt3To = cutOffTimeForLinRecpt3To;
	}

	public IBADateTime getCutOffTimeForLinRecptFr() {
		return cutOffTimeForLinRecptFr;
	}

	public void setCutOffTimeForLinRecptFr(IBADateTime cutOffTimeForLinRecptFr) {
		this.cutOffTimeForLinRecptFr = cutOffTimeForLinRecptFr;
	}

	public IBADateTime getCutOffTimeForLinRecptTo() {
		return cutOffTimeForLinRecptTo;
	}

	public void setCutOffTimeForLinRecptTo(IBADateTime cutOffTimeForLinRecptTo) {
		this.cutOffTimeForLinRecptTo = cutOffTimeForLinRecptTo;
	}

	public Long getNoOfcutOfTimings() {
		return noOfcutOfTimings;
	}

	public void setNoOfcutOfTimings(Long noOfcutOfTimings) {
		this.noOfcutOfTimings = noOfcutOfTimings;
	}

	public String getOperationFacilityid() {
		return operationFacilityid;
	}

	public void setOperationFacilityid(String operationFacilityid) {
		this.operationFacilityid = operationFacilityid;
	}

}
