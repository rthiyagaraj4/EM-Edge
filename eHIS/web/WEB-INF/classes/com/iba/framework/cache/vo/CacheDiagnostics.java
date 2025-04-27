/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.cache.vo;

import java.util.List;

import com.iba.framework.cache.util.CacheEnum;

/**
 * Provides a set of methods and properties of Cache regions.
 * 
 * @author Parimala
 * 
 */
public class CacheDiagnostics {

	private CacheEnum patientCache = null;

	private CacheEnum globalCache = null;

	private List userSessionCache = null;

	/**
	 * 
	 * @return CacheEnum
	 */
	public CacheEnum getGlobalCache() {
		return globalCache;
	}

	/**
	 * 
	 * @param globalCache
	 */
	public void setGlobalCache(CacheEnum globalCache) {
		this.globalCache = globalCache;
	}

	/**
	 * 
	 * @return CacheEnum
	 */
	public CacheEnum getPatientCache() {
		return patientCache;
	}

	/**
	 * 
	 * @param patientCache
	 */
	public void setPatientCache(CacheEnum patientCache) {
		this.patientCache = patientCache;
	}

	/**
	 * 
	 * @return List
	 */
	public List getUserSessionCache() {
		return userSessionCache;
	}

	/**
	 * 
	 * @param userSessionCache
	 */
	public void setUserSessionCache(List userSessionCache) {
		this.userSessionCache = userSessionCache;
	}
}
