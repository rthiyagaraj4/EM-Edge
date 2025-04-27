/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.linenItem.vo;

import java.util.Map;

import com.iba.ehis.lc.core.vo.LcVO;
import com.iba.ehis.lc.linenType.vo.LinentypeVO;

public class LinenItemVO extends LcVO {

	/* Declaration of mealclass variables for the VO */

	private String linenItem;

	private String longDesc;

	private String shortDesc;

	private LinentypeVO linenType;

	private String washingInstructions;

	private String disposable;

	private String effStatus;
	
	private String locale;

	private Map linenMap;

	/* Generated getter and setter metods of the above variables */
	public LinenItemVO() {
		linenType = new LinentypeVO();
	}

	public String getDisposable() {
		if (disposable == null)
			disposable = "N";
		return disposable;
	}

	public void setDisposable(String disposable) {
		this.disposable = disposable;
	}

	public String getLinenItem() {
		return linenItem;
	}

	public void setLinenItem(String linenItem) {
		this.linenItem = linenItem;
	}

	public LinentypeVO getLinenType() {
		return linenType;
	}

	public void setLinenType(LinentypeVO linenType) {
		this.linenType = linenType;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getWashingInstructions() {
		return washingInstructions;
	}

	public void setWashingInstructions(String washingInstructions) {
		this.washingInstructions = washingInstructions;
	}

	public Map getLinenMap() {
		return linenMap;
	}

	public void setLinenMap(Map linenMap) {
		this.linenMap = linenMap;
	}

	public String getEffStatus() {
		if (effStatus == null)
			effStatus = "D";
		return effStatus;
	}

	public void setEffStatus(String effStatus) {
		this.effStatus = effStatus;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

}
