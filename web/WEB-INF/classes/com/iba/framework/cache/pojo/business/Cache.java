/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
 * Created on Jan 3, 2006
 *
 */
package com.iba.framework.cache.pojo.business;

import com.iba.framework.cache.exception.CacheException;
import com.iba.framework.cache.vo.CacheDiagnostics;
import com.iba.framework.core.exception.DataNotFoundException;
import com.iba.framework.core.util.ApplicationPropertyReader;

/**
 * Provides a set of services that is offered by the cache implementation.
 * 
 * @author ParimalaK
 * 
 */

public interface Cache {
	String DELIMITER = "/";

	String ROOT = Cache.DELIMITER
			+ ApplicationPropertyReader.getApplicationName() + Cache.DELIMITER;

	/**
	 * Checks whether a cached object exists or not.
	 * 
	 * @param region
	 * @param key
	 * @return boolean
	 */
	public boolean exists(String region, String key);

	/**
	 * @param region
	 * @param sessionid
	 * @param key
	 * @return boolean
	 */
	public boolean exists(String region, String sessionid, String key);

	/**
	 * @return CacheDiagnostics
	 */
	public CacheDiagnostics getCacheDiagnostics();

	/**
	 * @param region
	 * @param key
	 * @return CacheDiagnostics
	 */
	public CacheDiagnostics getCacheDiagnostics(String region, String key);

	/**
	 * 
	 * @param region
	 * @param sessionId
	 * @param key
	 * @return CacheDiagnostics
	 */
	public CacheDiagnostics getCacheDiagnostics(String region,
			String sessionId, String key);

	/**
	 * Retrieves the specified object from Cache, using the specified key and
	 * region.
	 * 
	 * @param region
	 * @param key
	 * @return Object
	 */
	public Object getObject(String region, String key)
			throws DataNotFoundException;

	/**
	 * Retrieves the specified object from Cache, using the specified key and
	 * region and sessionid.
	 * 
	 * @param region
	 * @param sessionid
	 * @param key
	 * @return Object
	 * @throws CacheException
	 */
	public Object getObject(String region, String sessionid, String key)
			throws DataNotFoundException;

	/**
	 * Removes all other cache regions (PATIENT_AREA and GLOBAL_AREA)
	 */
	public void invalidateOtherRegion();

	/**
	 * Removes the temporary cache regions (USER_SESSION_AREA)
	 */
	public void invalidateTemporaryRegion();

	/**
	 * Checks whether Cache is active.
	 * 
	 * @return boolean
	 */
	public boolean isRunning();

	/**
	 * Inserts the specified object into the Cache, using the specified key and
	 * region.
	 * 
	 * @param region
	 * @param key
	 * @param object
	 */
	public void putObject(String region, String key, Object object);

	/**
	 * Inserts the specified object into the Cache, using the specified
	 * key,region and sessionid.Session id is used to store data that is
	 * relevant to a single session.
	 * 
	 * @param region
	 * @param sessionid
	 * @param key
	 * @param object
	 */
	public void putObject(String region, String sessionid, String key,
			Object object);

	/**
	 * Removes object from Cache, using the specified key and region.
	 * 
	 * @param region
	 * @param key
	 */
	public void removeObject(String region, String key);

	/**
	 * Removes object from Cache, using the specified key and region and
	 * sessionid.
	 * 
	 * @param region
	 * @param sessionid
	 * @param key
	 */
	public void removeObject(String region, String sessionid, String key);

	/**
	 * Starts the cache service
	 */
	public void startService();

	/**
	 * Interface to stop the cache service
	 */
	public void stopService();

}
