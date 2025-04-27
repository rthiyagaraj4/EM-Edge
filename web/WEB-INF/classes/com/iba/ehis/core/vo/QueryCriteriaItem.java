/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.core.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.iba.ehis.core.util.QueryCriteriaConstants;
import com.iba.framework.core.exception.ApplicationException;

public class QueryCriteriaItem {
	private String labelKey;

	private List options;

	private int type;

	private int size;

	private int length;

	private String bundleName;

	private Object itemValue;

	private boolean multiple = false;

	private String property = "";

	private String[] itemArr = null;

	private Map selectValMap;

	public boolean isMultiple() {
		return multiple;
	}

	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}

	public QueryCriteriaItem() {
		options = new ArrayList();
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getBundleName() {
		return bundleName;
	}

	public void setBundleName(String bundleName) {
		this.bundleName = bundleName;
	}

	public List getOptions() {
		return options;
	}

	public void addOption(String label, String value, String bundle)
			throws ApplicationException {
		if (getType() == QueryCriteriaConstants.SELECT_ITEM) {
			options.add(new LabelValueBean(label, value));
		} else
			throw new ApplicationException(
					"Doesn't allow Options Collection to this Element");
	}

	public void setOptions(List options) throws ApplicationException {
		if (getType() == QueryCriteriaConstants.SELECT_ITEM) {
			this.options = options;
		} else
			throw new ApplicationException(
					"Doesn't allow Options Collection to this Element");
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Object getItemValue() {
		return itemValue;
	}

	public void setItemValue(Object itemValue) {
		this.itemValue = itemValue;
	}

	public String[] getItemArr() {
		return itemArr;
	}

	public void setItemArr(String[] itemArr) {
		this.itemArr = itemArr;
		String itemVal = "";
		for (int i = 0; i < itemArr.length; i++) {
			itemVal += itemArr[i] + ", ";
		}

		int ind = itemVal.lastIndexOf(",");
		itemVal = itemVal.substring(0, ind);
		setItemValue(itemVal);
	}

	public Map getSelectValMap() {
		return selectValMap;
	}

	public void setSelectValMap(Map selectValMap) {
		this.selectValMap = selectValMap;
	}
}
