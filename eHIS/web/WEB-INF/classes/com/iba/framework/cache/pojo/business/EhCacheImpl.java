/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.cache.pojo.business;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.iba.framework.cache.exception.CacheException;
import com.iba.framework.cache.exception.InvalidCacheRegionException;
import com.iba.framework.cache.exception.UnsupportedCacheObjectException;
import com.iba.framework.cache.util.CacheEnum;
import com.iba.framework.cache.util.CacheMessages;
import com.iba.framework.cache.vo.CacheAttribute;
import com.iba.framework.cache.vo.CacheDiagnostics;
import com.iba.framework.cache.vo.CacheObject;
import com.iba.framework.core.exception.DataNotFoundException;
import com.iba.framework.core.util.ApplicationPropertyReader;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.ErrorConstants;
import com.iba.framework.core.util.MessageConstants;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;

/**
 * Implementation of services defined by Cache interface specific to EhCache.  
 * @author Parimala
 * 
 */
class EhCacheImpl implements com.iba.framework.cache.pojo.business.Cache,
		Constants {
	static Logger logger = LogFactory.getApplicationLogger();

	private CacheRegion cacheRegion = new CacheRegion();

	private net.sf.ehcache.CacheManager ehCacheManager;

	boolean running = false;

	/**
	 * Creates a new EhCache instance and starts EhCache service.
	 */
	EhCacheImpl() {
		try {

			ehCacheManager = new net.sf.ehcache.CacheManager();
			EhCacheImpl.logger.info(EhCacheImpl.class,
					"Starting cache service...", null, null);

			ehCacheManager.addCache(cacheRegion.getGlobalCache());
			ehCacheManager.addCache(cacheRegion.getUserSessionCache());
			ehCacheManager.addCache(cacheRegion.getPatientCache());

			EhCacheImpl.logger.info(EhCacheImpl.class, "Cache started.", null,
					null);
		} catch (Exception e) {
			throw new CacheException(ErrorConstants.UNKNOWN_ERROR,
					CacheMessages.STARTUP_PROBLEM, e);
		}
	}

	/**
	 * Checks whether a given key exists.
	 * @param key
	 * @return
	 */
	protected boolean exists(String key) {
		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.cache.pojo.business.Cache#exists(java.lang.String,
	 *      java.lang.String)
	 */
	public boolean exists(String region, String key) {
		return ehCacheManager.getCache(region).isKeyInCache(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.cache.pojo.business.Cache#exists(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public boolean exists(String region, String sessionId, String key) {
		region = cacheRegion.getSessionCacheId(sessionId);
		return (this.exists(region, key));
	}

	/**
	 * This methods returnd Cache statistics.
	 */
	public CacheDiagnostics getCacheDiagnostics() {
		return getCacheStatistics(null, null);
	}

	/**
	 * This methods returnd Cache statistics.
	 */
	public CacheDiagnostics getCacheDiagnostics(String region, String key) {
		return getCacheStatistics(region, key);
	}

	/*
	 * This methods returnd Cache CacheDiagnostics.
	 * 
	 * @see com.iba.framework.cache.pojo.business.Cache#getCacheStatistics(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public CacheDiagnostics getCacheDiagnostics(String region,
			String sessionId, String key) {
		CacheDiagnostics cacheDiagnostics = null;
		if (sessionId != null) {
			sessionId = sessionId.trim();
			sessionId = (sessionId.equals("") ? null : sessionId);
			region = cacheRegion.getSessionCacheId(sessionId);
		}
		cacheDiagnostics = getCacheStatistics(region, key);
		return cacheDiagnostics;
	}

	/**
	 * Checks whether object is in Cache and returns object wrapped into CacheObject. 
	 * @param region
	 * @param sessionId
	 * @param key
	 * @param timerEnabled
	 * @return
	 * @throws DataNotFoundException
	 */
	private CacheObject getCacheObject(String region, String sessionId,
			String key, boolean timerEnabled) throws DataNotFoundException {
		CacheObject cachedObject = null;

		if (region.startsWith(Constants.USER_SESSION_CACHE)
				|| region.equals(Constants.PATIENT_CACHE)
				|| region.equals(Constants.GLOBAL_CACHE)) {

			if (region.equals(Constants.USER_SESSION_CACHE)) {
				region = cacheRegion.getSessionCacheId(sessionId);
			}
			net.sf.ehcache.Cache cache = ehCacheManager.getCache(region);

			if (cache.isKeyInCache(key)) {
				Element obj = (Element) cache.get(key);
				cachedObject = (CacheObject) obj.getValue();
			} else {
				throw new DataNotFoundException(
						Constants.DATA_NOT_FOUND,
						MessageFormat
								.format(
										MessageConstants.INVALID_KEY,
										new Object[] { region
												+ com.iba.framework.cache.pojo.business.Cache.DELIMITER
												+ key }));
			}
			if (timerEnabled && (cachedObject != null)) {
				cachedObject.setLastAccessedTime(System.currentTimeMillis());
			}
		} else {
			throw new InvalidCacheRegionException(ErrorConstants.DATA_ERROR,
					CacheMessages.INVALID_REGION);
		}

		return cachedObject;
	}

	
	/**
	 * Returns Cache  statistics. 
	 * @param region
	 * @param key
	 * @return
	 */private CacheDiagnostics getCacheStatistics(String region, String key) {

		String cacheNames[] = { region };

		if (region == null)
			cacheNames = ehCacheManager.getCacheNames();

		List userCacheList = new ArrayList();
		CacheEnum gcCacheEnum = new CacheEnum();
		CacheEnum pcCacheEnum = new CacheEnum();

		for (int i = 0; i < cacheNames.length; i++) {
			String currentCacheName = cacheNames[i];

			if (currentCacheName.startsWith(Constants.GLOBAL_CACHE)) {
				gcCacheEnum.setList(new ArrayList());
				gcCacheEnum.setTypeOfCache(currentCacheName);
				setCacheObjects(currentCacheName, gcCacheEnum, key);
			} else if (currentCacheName.startsWith(Constants.PATIENT_CACHE)) {
				pcCacheEnum.setTypeOfCache(currentCacheName);
				pcCacheEnum.setList(new ArrayList());
				setCacheObjects(currentCacheName, pcCacheEnum, key);
			} else if (currentCacheName
					.startsWith(Constants.USER_SESSION_CACHE)) {
				CacheEnum usCacheEnum = new CacheEnum();
				usCacheEnum.setTypeOfCache(currentCacheName);
				setCacheObjects(currentCacheName, usCacheEnum, key);
				userCacheList.add(usCacheEnum);
			}
		}

		CacheDiagnostics cacheDiagnostics = new CacheDiagnostics();
		cacheDiagnostics.setGlobalCache(gcCacheEnum);
		cacheDiagnostics.setPatientCache(pcCacheEnum);
		cacheDiagnostics.setUserSessionCache(userCacheList);

		return cacheDiagnostics;
	}

	/*
	 * Retrieves the specified object from Cache, using the specified key and
	 * region.
	 * 
	 */
	public Object getObject(String region, String key)
			throws DataNotFoundException {
		return getCacheObject(region, null, key, false).getObject();

	}

	/*
	 * Retrieves the specified object from Cache, using the specified key and
	 * region and sessionid.
	 * 
	 * @see com.iba.framework.cache.pojo.business.Cache#getObject(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public Object getObject(String region, String sessionId, String key)
			throws DataNotFoundException {
		return getCacheObject(region, sessionId, key, false).getObject();
	}

	/**
	 * Invalidation of cached object is done here based on last accessed time.
	 * @param oCacheObject
	 * @param region
	 * @param key
	 * @return
	 */
	private boolean invalidateObject(CacheObject oCacheObject, String region,
			String key) {
		long timeoutInterval = -1;

		if (oCacheObject.getTimeout() == Constants.TIMEOUT_NOT_SET) {
			if (region.startsWith(Constants.USER_SESSION_CACHE)) {
				timeoutInterval = ApplicationPropertyReader
						.getUserCacheTimeoutInMills();
			} else if (region.startsWith(Constants.PATIENT_CACHE)) {
				timeoutInterval = ApplicationPropertyReader
						.getPatientCacheTimeoutInMills();
			}
		} else {
			timeoutInterval = oCacheObject.getTimeout();
		}

		long elapsedTime = System.currentTimeMillis()
				- oCacheObject.getLastAccessedTime();

		List listKeys = ehCacheManager.getCache(region).getKeys();

		
		for (Iterator iter = listKeys.iterator(); iter.hasNext();) {
			EhCacheImpl.logger.debug(getClass(), iter.next().toString(), "");
		}

		
		if (elapsedTime >= timeoutInterval) {
			ehCacheManager.getCache(region).remove(key);

			
			for (Iterator iter = listKeys.iterator(); iter.hasNext();) {
				EhCacheImpl.logger
						.debug(getClass(), iter.next().toString(), "");
			}

			return true;
		}
		return false;
	}

	/*
	 * Invalidation of permanent cache region is done here.
	 * 
	 * @see com.iba.framework.cache.pojo.business.Cache#invalidateOtherRegion()
	 */
	public void invalidateOtherRegion() {
		List permanentRegions = new ArrayList(2);
		permanentRegions.add(Constants.PATIENT_CACHE);
		permanentRegions.add(Constants.GLOBAL_CACHE);
		try {
			String region = "";
			for (int i = 0; i < permanentRegions.size(); i++) {
				region = (String) permanentRegions.get(i);
				net.sf.ehcache.Cache cache = ehCacheManager.getCache(region);
				traverseNode(cache, region);
			}
		} catch (Exception e) {
			// TODO: error code
			throw new CacheException("",
					"Problem in invalidating the Permanent Cache regions.", e);
		}
	}

	/*
	 * Invalidation of Temporary cache region is done here.
	 * 
	 * @see com.iba.framework.cache.pojo.business.Cache#invalidateTemporaryRegion()
	 */
	public void invalidateTemporaryRegion() {
		try {
			String[] cacheNames = ehCacheManager.getCacheNames();
			for (int i = 0; i < cacheNames.length; i++) {
				String cacheName = cacheNames[i];
				if (cacheName.startsWith(Constants.USER_SESSION_CACHE)) {
					net.sf.ehcache.Cache userTempCache = ehCacheManager
							.getCache(cacheName);
					traverseNode(userTempCache, cacheName);
				}
			}
		} catch (Exception e) {
			// TODO: error code
			throw new CacheException("",
					"Problem in invalidating the temporary cache regions.", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.cache.pojo.business.Cache#isRunning()
	 */
	public boolean isRunning() {
		return running;
	}

	/*
	 * Inserts the specified object into the Cache, using the specified key and
	 * region.
	 * 
	 * @see com.iba.framework.cache.pojo.business.Cache#putObject(java.lang.String,
	 *      java.lang.String, java.lang.Object)
	 */
	public void putObject(String region, String key, Object object) {

		if (!(object instanceof Serializable)) {
			throw new UnsupportedCacheObjectException(
					ErrorConstants.DATA_ERROR,
					MessageFormat
							.format(
									CacheMessages.UNSERIALIZED_OBJECT,
									new Object[] { region
											+ com.iba.framework.cache.pojo.business.Cache.DELIMITER
											+ key }));
		}
		if (region.equals(Constants.PATIENT_CACHE)
				|| region.equals(Constants.GLOBAL_CACHE)||
				   region.equals(Constants.USER_SESSION_CACHE)) {

			Element cacheElement = new Element(
					(com.iba.framework.cache.pojo.business.Cache.DELIMITER + key),
					object);
			ehCacheManager.getCache(region).put(cacheElement);
		} else if (region.equals(Constants.PATIENT_CACHE)) {
			throw new InvalidCacheRegionException(ErrorConstants.DATA_ERROR,
					CacheMessages.US_WRITE_ERROR);

		} else {
			throw new InvalidCacheRegionException(ErrorConstants.DATA_ERROR,
					CacheMessages.INVALID_REGION);
		}
	}

	/*
	 * Inserts the specified object into the Cache, using the specified
	 * key,region and sessionid.
	 * 
	 * @see com.iba.framework.cache.pojo.business.Cache#putObject(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.Object)
	 */
	public void putObject(String region, String sessionId, String key,
			Object object) {

		if (!(object instanceof Serializable)) {
			throw new UnsupportedCacheObjectException(
					ErrorConstants.DATA_ERROR,
					MessageFormat
							.format(
									CacheMessages.UNSERIALIZED_OBJECT,
									new Object[] { region
											+ com.iba.framework.cache.pojo.business.Cache.DELIMITER
											+ key }));
		}
		if (region.equals(Constants.USER_SESSION_CACHE)) {
			region = cacheRegion.getSessionCacheId(sessionId);
			if (ehCacheManager.getCache(region) == null) {
				ehCacheManager.addCache(cacheRegion
						.createSessionCache(sessionId));
			}
			CacheObject cacheObject = new CacheObject(object);
			Element cacheElement = new Element(key, cacheObject);
			ehCacheManager.getCache(region).put(cacheElement);
		} else if (region.equals(Constants.PATIENT_CACHE)) {
			throw new InvalidCacheRegionException(ErrorConstants.DATA_ERROR,
					CacheMessages.US_WRITE_ERROR);

		} else {
			throw new InvalidCacheRegionException(ErrorConstants.DATA_ERROR,
					CacheMessages.INVALID_REGION);
		}
	}

	/*
	 * Removes object from Cache.
	 * 
	 * @see com.iba.framework.cache.pojo.business.Cache#removeObject(java.lang.String,
	 *      java.lang.String)
	 */
	public void removeObject(String region, String key) {
		ehCacheManager.getCache(region).remove(key);

	}

	/*
	 * Removes object from Cache for a specific region.
	 * 
	 * @see com.iba.framework.cache.pojo.business.Cache#removeObject(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public void removeObject(String region, String sessionId, String key) {
		region = cacheRegion.getSessionCacheId(sessionId);
		ehCacheManager.getCache(region).remove(key);

	}

	/**
	 * @param currentCacheName
	 * @param cacheEnum
	 * @param key
	 */
	private void setCacheObjects(String currentCacheName, CacheEnum cacheEnum,
			String key) {
		Cache cache = ehCacheManager.getCache(currentCacheName);

		List keyList = null;
		if (key == null)
			keyList = cache.getKeys();
		else {
			keyList = new ArrayList();
			keyList.add(key);
		}
		for (Iterator iter = keyList.iterator(); iter.hasNext();) {

			CacheAttribute attribute = new CacheAttribute();
			String contentKey = (String) iter.next();
			attribute.setCacheKey(contentKey);
			attribute.setCacheValue((CacheObject) ((Element) cache
					.get(contentKey)).getObjectValue());
			cacheEnum.addCacheItem(attribute);
		}
	}

	/**
	 * @param running
	 */
	private void setRunning(boolean running) {
		this.running = running;
	}

	/*
	 * Starts EhCache Cache Service
	 * 
	 * @see com.iba.framework.cache.pojo.business.Cache#startService()
	 */
	public void startService() {
		CacheManager.create();
		setRunning(true);
	}

	/*
	 * Stops EhCache Cache Service
	 * 
	 * @see com.iba.framework.cache.pojo.business.Cache#stopService()
	 */
	public void stopService() {
		ehCacheManager.shutdown();
		setRunning(false);
	}

	/**
	 * Method that traverses through the tree nodes to find  child nodes.
	 * @param tempCache
	 * @param region
	 */
	private void traverseNode(net.sf.ehcache.Cache tempCache, String region) {
		if (tempCache != null) {
			List keyList = tempCache.getKeys();
			StringBuffer invalidCacheContent = new StringBuffer();
			for (Iterator iter = keyList.iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				CacheObject oCacheObject = (CacheObject) tempCache.get(key)
						.getObjectValue();

				if (invalidateObject(oCacheObject, region, key)) {
					String nodeFqn = region + "/" + key;
					invalidCacheContent.append(nodeFqn + " is invalidated @ "
							+ new Timestamp(System.currentTimeMillis()) + ".");
				}
				EhCacheImpl.logger.info(getClass(), invalidCacheContent
						.toString(), "");
			}
		}
	}
}
