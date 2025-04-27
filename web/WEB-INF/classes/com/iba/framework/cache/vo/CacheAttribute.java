/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.cache.vo;

import java.util.Date;

import com.iba.framework.core.util.IBADateTime;

/**
 * Used to mark properties and methods that can be cached.
 * 
 * @author Parimala
 * 
 */
public class CacheAttribute {

	private Object cacheKey;

	private CacheObject cacheValue;

	/**
	 * 
	 * @return Object
	 */
	public Object getCacheKey() {
		return cacheKey;
	}

	/**
	 * 
	 * @param cacheKey
	 */
	public void setCacheKey(Object cacheKey) {
		this.cacheKey = cacheKey;
	}

	/**
	 * 
	 * @return Object
	 */
	public Object getCacheValue() {
		return cacheValue.getObject();
	}

	/**
	 * 
	 * @param cacheValue
	 */
	public void setCacheValue(CacheObject cacheValue) {
		this.cacheValue = cacheValue;
	}

	/**
	 * Returns time for the cached object's creation in IBADateTime.
	 * 
	 * @param region
	 * @param key
	 * @return IBADateTime
	 */
	public IBADateTime getCreatedTime(String region, String key) {
		return new IBADateTime(new Date(cacheValue.getCreationTime()));
	}

	/**
	 * Returns the number of cache attribute hits.
	 * 
	 * @return long
	 */
	public long getHits() {
		return cacheValue.getHits();
	}

	/**
	 * Returns the time for the cached object's last accessed time in
	 * IBADateTime.
	 * 
	 * @return IBADateTime
	 */
	public IBADateTime getLastAccessedTime() {
		return new IBADateTime(new Date(cacheValue.getLastAccessedTime()));
	}

}
