/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.cache.vo;

/**
 * 
 * @author ParimalaK
 *
 */
public class CacheData {
	
	private String key;
	private Object valueObject;

	public CacheData() {
		super();

	}

	/**
	 * 
	 * @param key
	 * @param valueObject
	 */public CacheData(String key, Object valueObject) {
		super();
		this.key = key;
		this.valueObject = valueObject;
	}

	/**
	 * 
	 * @return String
	 */public String getKey() {
		return key;
	}

	/*/*
	 * 
	 */public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 
	 * @return Object
	 */public Object getValueObject() {
		return valueObject;
	}

	/**
	 * 
	 * @param valueObject
	 */public void setValueObject(String valueObject) {
		this.valueObject = valueObject;
	}
}
