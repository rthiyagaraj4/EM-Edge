/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.cache.pojo.business;

import net.sf.ehcache.Cache;

import com.iba.framework.core.util.Constants;

/**
 * An organizational namespace for holding a collection of cache objects.
 * @author ParimalaK
 *
 */public class CacheRegion {

	private Cache globalCache = null;

	private Cache userSessionCache = null;

	private Cache patientCache = null;

	private String root = "";

	/**
	 * Creates a new CacheRegion.
	 *
	 */public CacheRegion() {

		globalCache = new Cache((root + Constants.GLOBAL_CACHE), 100, true,
				false, 5, 2);
		userSessionCache = new Cache((root + Constants.USER_SESSION_CACHE),
				100, true, false, 5, 2);
		patientCache = new Cache((root + Constants.PATIENT_CACHE), 100, true,
				false, 5, 2);
	}

	/**
	 * 
	 * @param root
	 */public CacheRegion(String root) {
		this.root = root;
	}

	/**
	 * 
	 * @return Cache
	 */public Cache getGlobalCache() {
		return globalCache;
	}

	/**
	 * 
	 * @return Cache
	 */public Cache getUserSessionCache() {
		return userSessionCache;
	}

	/**
	 * 
	 * @return Cache
	 */public Cache getPatientCache() {
		return patientCache;
	}

	/**
	 * Creates user session cache.
	 * @param sessionId
	 * @return Cache
	 */public Cache createSessionCache(String sessionId) {
		Cache userCache = new Cache(
				(root + Constants.USER_SESSION_CACHE + "-" + sessionId), 100,
				true, true, 50000, 2);
		return userCache;
	}

	/**
	 * Returns user session cache id.
	 * @param sessionId
	 * @return String
	 */public String getSessionCacheId(String sessionId) {

		return ((root + Constants.USER_SESSION_CACHE + "-" + sessionId));
	}

	/**
	 * 
	 * @param region
	 * @return String
	 */public String extractSessionId(String region) {
		return (region.substring(region.lastIndexOf("-") + 1));
	}
}
