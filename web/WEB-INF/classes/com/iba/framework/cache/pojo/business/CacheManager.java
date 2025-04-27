/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Jun 21, 2006
 */
package com.iba.framework.cache.pojo.business;

import com.iba.ehis.core.util.AppConstants;
import com.iba.framework.cache.exception.CacheException;
import com.iba.framework.core.exception.DataNotFoundException;
import com.iba.framework.core.util.ServiceLocator;

/**
 * A delegator class for the cache implementation which routes all the cache
 * related requests to the underlying implementation.
 * 
 * @author Parimala KV
 * 
 */
public class CacheManager {

	private Cache cache;

	private static Cache deprecateCache;

	private String cacheType = AppConstants.JBOSSCACHE;

	/**
	 * 
	 */
	public CacheManager() {
		this(AppConstants.JBOSSCACHE);
	}

	/**
	 * Constructor that accepts cachetype as an argument to invoke the
	 * respective implementation.
	 * 
	 * @param cacheType
	 */
	public CacheManager(String cacheType) {
		if ((!cacheType.equals(AppConstants.EHCACHE))
				&& (!cacheType.equals(AppConstants.JBOSSCACHE))) {
			try {
				throw new CacheException(
						"CacheManager New: Invalid CacheType Exception, Using default Cache");
			} catch (CacheException e) {
				cacheType = AppConstants.EHCACHE;
			}
		} else {
			this.cacheType = cacheType;
		}

		if (cacheType.equals(AppConstants.EHCACHE)) {
			cache = new EhCacheImpl();
		} else if (cacheType.equals(AppConstants.JBOSSCACHE)) {
			cache = new JBossCacheImpl();
		}
		cache.startService();
	}

	@Deprecated
	public static Cache getCache() {
		if (deprecateCache == null) {
			deprecateCache = new JBossCacheImpl();
			deprecateCache.startService();
		}
		return deprecateCache;

	}

	/**
	 * Checks whether a cached object exists or not.
	 * 
	 * @param region
	 * @param key
	 * @return boolean
	 */
	public boolean exists(String region, String key) {
		return cache.exists(region, key);
	}

	/**
	 * Checks whether a cached object exists or not.
	 * 
	 * @param region
	 * @param sessionid
	 * @param key
	 * @return boolean
	 */
	public boolean exists(String region, String sessionid, String key) {
		return cache.exists(region, sessionid, key);
	}

	/**
	 * Returns the cache type.
	 * 
	 * @return boolean
	 */
	public String getCacheType() {
		return cacheType;
	}

	/**
	 * Retrieves the specified object from Cache, using the specified key and
	 * region.
	 * 
	 * @param region
	 * @param key
	 * @return Object
	 * @throws DataNotFoundException
	 */
	public Object getObject(String region, String key)
			throws DataNotFoundException {
		return cache.getObject(region, key);
	}

	/**
	 * Retrieves the specified object from Cache, using the specified key and
	 * region and sessionid.
	 * 
	 * @param region
	 * @param sessionId
	 * @param key
	 * @return Object
	 * @throws DataNotFoundException
	 */
	public Object getObject(String region, String sessionId, String key)
			throws DataNotFoundException {
		return cache.getObject(region, sessionId, key);
	}

	/**
	 * Removes permanent cache regions (PATIENT_AREA and GLOBAL_AREA)
	 */
	public void invalidateOtherRegion() {
		cache.invalidateOtherRegion();

	}

	/**
	 * Removes the temporary cache regions (USER_SESSION_AREA)
	 */
	public void invalidateTemporaryRegion() {
		cache.invalidateTemporaryRegion();

	}

	/**
	 * Checks whether Cache is active.
	 * 
	 * @return boolean
	 */
	public boolean isRunning() {
		return cache.isRunning();
	}

	/**
	 * Inserts the specified object into the Cache, using the specified key and
	 * region.
	 * 
	 * @param region
	 * @param key
	 * @param object
	 */
	public void putObject(String region, String key, Object object) {
		cache.putObject(region, key, object);
	}

	/**
	 * Inserts the specified object into the Cache, using the specified
	 * key,region and sessionid.
	 * 
	 * @param region
	 * @param sessionid
	 * @param key
	 * @param object
	 */
	public void putObject(String region, String sessionid, String key,
			Object object) {
		cache.putObject(region, sessionid, key, object);
	}

	/**
	 * Removes object from Cache, using the specified key and region.
	 * 
	 * @param region
	 * @param key
	 */
	public void removeObject(String region, String key) {
		cache.removeObject(region, key);

	}

	/**
	 * Removes object from Cache, using the specified key and region and
	 * sessionid.
	 * 
	 * @param region
	 * @param sessionid
	 * @param key
	 */
	public void removeObject(String region, String sessionid, String key) {
		cache.removeObject(region, sessionid, key);

	}

	/**
	 * Checks whether cache is of type ehcache or jbosscache and throws cache
	 * exception if it not of these types.
	 * 
	 * @param cacheType
	 */
	public void setCacheType(String cacheType) {
		if ((!cacheType.equals(AppConstants.EHCACHE))
				|| (!cacheType.equals(AppConstants.JBOSSCACHE))) {
			try {
				throw new CacheException(
						"CacheManager New: Invalid CacheType Exception, Using default Cache");
			} catch (CacheException e) {
				cacheType = AppConstants.EHCACHE;
			}
		}
		if (cache == null) {
			if (cacheType.equals(AppConstants.EHCACHE)) {
				cache = new EhCacheImpl();
			} else if (cacheType.equals(AppConstants.JBOSSCACHE)) {
				cache = new JBossCacheImpl();
			} else {
				throw new CacheException(
						"Cache already initialized, cannot change the implementation @ the runtime");
			}

		}
		this.cacheType = cacheType;
	}

	/**
	 * Starts the cache service.
	 */
	public void startService() {
		cache.startService();

	}

	/**
	 * Stops the cache service.
	 */
	public void stopService() {
		cache.stopService();
	}

	/**
	 * @return CacheDiagnostics
	 */
	public com.iba.framework.cache.vo.CacheDiagnostics getCacheDiagnostics() {
		return cache.getCacheDiagnostics();
	}

/*	*//**
	 * @return PersistanceCacheDiagnostics
	 *//*
	public PersistanceCacheDiagnostics getPeristanceDiagnostics() {
		// PersistanceCacheReader pcReader =new PersistanceCacheReader();
		PersistanceCacheReader pcReader = (PersistanceCacheReader) (ServiceLocator
				.getInstance().getBean("PersistanceCacheReader"));
		return pcReader.getPeristanceDiagnostics();
	}*/

}
