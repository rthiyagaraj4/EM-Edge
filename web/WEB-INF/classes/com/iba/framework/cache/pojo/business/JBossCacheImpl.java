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
import java.util.Map;
import java.util.Set;

import org.jboss.cache.ConfigureException;
import org.jboss.cache.DataNode;
import org.jboss.cache.Fqn;
import org.jboss.cache.PropertyConfigurator;
import org.jboss.cache.TreeNode;
import org.jboss.cache.aop.TreeCacheAop;

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
 * Implementation of services defined by Cache interface specific to JBossCache.  
 * @author S Sabarinathan
 * 
 */
class JBossCacheImpl implements Cache, Constants {
	
	final static String DELIMITER = "/";
	static Logger logger = LogFactory.getApplicationLogger();
	final static String ROOT = JBossCacheImpl.DELIMITER
			+ ApplicationPropertyReader.getApplicationName()
			+ JBossCacheImpl.DELIMITER;
	static boolean running = false;
	TreeCacheAop oTreecacheaop;

	/**
	 * Creates a new JBossCache instance and starts JBossCache service.
	 */
	public JBossCacheImpl() {
		try {
			oTreecacheaop = new TreeCacheAop();
			PropertyConfigurator config = new PropertyConfigurator();
			config.configure(oTreecacheaop, Constants.JBOSSCACHE_CONFIG_FILE);
			JBossCacheImpl.logger.info(JBossCacheImpl.class,
					"Starting cache service...", null, null);
			oTreecacheaop.startService();
			JBossCacheImpl.logger.info(JBossCacheImpl.class, "Cache started.",
					null, null);
			setRunning(true);
		} catch (ConfigureException ce) {
			throw new CacheException(ErrorConstants.LOAD_ERROR,
					CacheMessages.CONFIG_ERROR, ce);
		} catch (Exception e) {
			throw new CacheException(ErrorConstants.UNKNOWN_ERROR,
					CacheMessages.STARTUP_PROBLEM, e);
		}
	}

	/**
	 * Checks whether a given key exists in the given node.
	 * @param key
	 * @return
	 */private boolean exists(String key) {
		return oTreecacheaop.exists(key);
	}

	/**
	 * Checks whether a given key exists in the given region.
	 */
	 public boolean exists(String region, String key) {
		return this.exists(Cache.ROOT + region + Cache.DELIMITER + key);
	}

	/**
	 * Checks whether a given key exists in the given region for a particular sessionid.
	 * 
	 */public boolean exists(String region, String sessionid, String key) {
		return this.exists(Cache.ROOT + region + Cache.DELIMITER + sessionid
				+ Cache.DELIMITER + key);
	}

	/**
	 * 
	 */public CacheDiagnostics getCacheDiagnostics() {
		return getCacheStatistics(null, null);
	}

	/**
	 * 
	 */public CacheDiagnostics getCacheDiagnostics(String region, String key) {
		return getCacheStatistics(region, key);
	}

	/**
	 * 
	 */public CacheDiagnostics getCacheDiagnostics(String region,
			String sessionId, String key) {
		CacheDiagnostics cacheDiagnostics = null;
		if (sessionId != null) {
			sessionId = sessionId.trim();
			sessionId = (sessionId.equals("") ? null : sessionId);
			if (key == null) {
				key = "";
			}
			region = region + Cache.DELIMITER + sessionId + key;

		}
		cacheDiagnostics = getCacheStatistics(region, key);
		return cacheDiagnostics;
	}

	/**
	 * Checks whether object is in Cache and returns object wrapped into CacheObject. 
	 * @param region
	 * @param key
	 * @param timerEnabled
	 * @return
	 * @throws DataNotFoundException
	 */
	public CacheObject getCacheObject(String region, String key,
			boolean timerEnabled) throws DataNotFoundException {
		CacheObject cachedObject = null;
		try {
			if (region.startsWith(Constants.USER_SESSION_CACHE)
					|| region.equals(Constants.PATIENT_CACHE)
					|| region.equals(Constants.GLOBAL_CACHE)) {
				if (oTreecacheaop.exists(JBossCacheImpl.ROOT + region
						+ JBossCacheImpl.DELIMITER + key)) {
					cachedObject = (CacheObject) oTreecacheaop
							.getObject(JBossCacheImpl.ROOT + region
									+ JBossCacheImpl.DELIMITER + key);
				} else {
					throw new DataNotFoundException(Constants.DATA_NOT_FOUND,
							MessageFormat.format(MessageConstants.INVALID_KEY,
									new Object[] { region
											+ JBossCacheImpl.DELIMITER + key }));
				}
				if (timerEnabled && (cachedObject != null)) {
					cachedObject
							.setLastAccessedTime(System.currentTimeMillis());
				}
			} else {
				throw new InvalidCacheRegionException(
						ErrorConstants.DATA_ERROR, CacheMessages.INVALID_REGION);
			}
		} catch (org.jboss.cache.CacheException e) {
			throw new CacheException(ErrorConstants.DATA_ERROR, e);
		}
		return cachedObject;
	}

	/**
	 * Returns the CacheDiagnostics object associated with the cache.
	 * @param region
	 * @param key
	 * @return
	 */
	private CacheDiagnostics getCacheStatistics(String region, String key) {

		String cacheNames[] = { region };

		if (region == null) {
			String root = Cache.ROOT;
			cacheNames = new String[3];
			cacheNames[0] = (root + Constants.GLOBAL_CACHE);
			cacheNames[1] = (root + Constants.PATIENT_CACHE);
			cacheNames[2] = (root + Constants.USER_SESSION_CACHE);
		}

		List userCacheList = new ArrayList();
		CacheEnum gcCacheEnum = new CacheEnum();
		CacheEnum pcCacheEnum = new CacheEnum();

		for (int i = 0; i < cacheNames.length; i++) {
			if (cacheNames[i].endsWith(Constants.GLOBAL_CACHE)
					|| cacheNames[i].endsWith(Constants.PATIENT_CACHE)) {
				try {
					DataNode cacheKeys = oTreecacheaop.get(cacheNames[i]);
					if (cacheKeys != null) {
						Set cacheKeySet = cacheKeys.getChildren().keySet();
						for (Iterator iter = cacheKeySet.iterator(); iter
								.hasNext();) {
							Object cacheKey = iter.next();
							CacheAttribute cacheAttr = new CacheAttribute();
							cacheAttr.setCacheKey(cacheKey);
							cacheAttr.setCacheValue((CacheObject) cacheKeys
									.getChildren().get(cacheKey));
							if (cacheNames[i].endsWith(Constants.GLOBAL_CACHE)) {
								gcCacheEnum.addCacheItem(cacheAttr);
							} else {
								pcCacheEnum.addCacheItem(cacheAttr);
							}
						}
					}
				} catch (org.jboss.cache.CacheException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (cacheNames[i].endsWith(Constants.USER_SESSION_CACHE)) {
				DataNode cacheKeys = null;
				try {
					cacheKeys = oTreecacheaop.get(cacheNames[i]);
				} catch (org.jboss.cache.CacheException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Set cacheKeySet = cacheKeys.getChildren().keySet();
				for (Iterator iter = cacheKeySet.iterator(); iter.hasNext();) {

					String sessionId = (String) iter.next();
					TreeNode cacheSessionNode = (TreeNode) (cacheKeys
							.getChildren().get(sessionId));
					Map sessionDataMap = cacheSessionNode.getChildren();

					CacheEnum sessionEnum = new CacheEnum();
					sessionEnum.setTypeOfCache(Constants.USER_SESSION_CACHE);
					sessionEnum.setSessionId(sessionId);

					for (Iterator iterator = sessionDataMap.keySet().iterator(); iterator
							.hasNext();) {
						Map dataNode = ((TreeNode) sessionDataMap.get(iterator
								.next())).getData();

						CacheAttribute cacheAttr = new CacheAttribute();
						cacheAttr.setCacheKey(dataNode.get("name"));
						cacheAttr.setCacheValue((CacheObject) dataNode
								.get("__SERIALIZED__"));
						sessionEnum.addCacheItem(cacheAttr);
					}
					userCacheList.add(sessionEnum);
				}
			}
		}
		CacheDiagnostics cacheDiagnostics = new CacheDiagnostics();
		cacheDiagnostics.setGlobalCache(gcCacheEnum);
		cacheDiagnostics.setPatientCache(pcCacheEnum);
		cacheDiagnostics.setUserSessionCache(userCacheList);

		return cacheDiagnostics;
	}

	/**
	 * Retrieves the specified object from Cache, using the specified key and
	 * region.
	 */public Object getObject(String region, String key)
			throws DataNotFoundException {
		return getCacheObject(region, key, true).getObject();
	}

	/**
	 * Retrieves the specified object from Cache, using the specified key and
	 * region and sessionid.
	 * @param region
	 * @param key
	 * @return
	 * @throws DataNotFoundException
	 */
	 public Object getObject(String region, String sessionid, String key)
			throws DataNotFoundException {
		return getObject(region + Cache.DELIMITER + sessionid, key);
	}
	 /**
	 * Returns the created time of the Cached Object as TimeStamp.
	 * @param region
	 * @param key
	 * @return
	 * @throws DataNotFoundException
	 */
	public Timestamp getObjectCreationTime(String region, String key)
			throws DataNotFoundException {
		return new Timestamp(getCacheObject(region, key, false)
				.getCreationTime());
	}
	/**
	 * Returns the last accessed time of the Cached Object as TimeStamp.
	 * @param region
	 * @param key
	 * @return
	 * @throws DataNotFoundException
	 */
	public Timestamp getObjectLastAccessedTime(String region, String key)
			throws DataNotFoundException {
		return new Timestamp(getCacheObject(region, key, false)
				.getLastAccessedTime());
	}

	/**
	 * Invalidation of cached object is done here based on last accessed time.
	 * @param nodeFqn
	 * @param oCacheObject
	 * @param regionType
	 */
	private void invalidateObject(Fqn nodeFqn, CacheObject oCacheObject,
			String regionType) {
		JBossCacheImpl.logger
				.debug(JBossCacheImpl.class, nodeFqn + " last accessed time @ "
						+ new Timestamp(oCacheObject.getLastAccessedTime()),
						null, null);
		long timeoutInterval = -1;
		if (oCacheObject.getTimeout() == Constants.TIMEOUT_NOT_SET) {
			if (regionType.equals(Constants.USER_SESSION_CACHE)) {
				timeoutInterval = ApplicationPropertyReader
						.getUserCacheTimeoutInMills();
			} else if (regionType.equals(Constants.PATIENT_CACHE)) {
				timeoutInterval = ApplicationPropertyReader
						.getPatientCacheTimeoutInMills();
			}
		} else {
			timeoutInterval = oCacheObject.getTimeout();
		}
		long elapsedTime = System.currentTimeMillis()
				- oCacheObject.getLastAccessedTime();
		if (elapsedTime >= timeoutInterval) {
			try {
				JBossCacheImpl.logger.info(JBossCacheImpl.class, nodeFqn
						+ " is invalidated @ "
						+ new Timestamp(System.currentTimeMillis()) + ".",
						null, null);
				oTreecacheaop.remove(nodeFqn);
			} catch (org.jboss.cache.CacheException e) {
				// TODO: error code
				throw new CacheException("",
						"Problem in invalidating the node " + nodeFqn + "...",
						e);
			}
		}
	}

	/**
	 * Invalidation of permanent cache region is done here.
	 *  
	 */public void invalidateOtherRegion() {
		List permanentRegions = new ArrayList(2);
		permanentRegions.add(Constants.PATIENT_CACHE);
		permanentRegions.add(Constants.GLOBAL_CACHE);
		try {
			String PERMANENT_CACHE_NODE = "";
			Set childrenNames = null;
			for (int i = 0; i < permanentRegions.size(); i++) {
				PERMANENT_CACHE_NODE = JBossCacheImpl.ROOT
						+ permanentRegions.get(i);
				childrenNames = oTreecacheaop
						.getChildrenNames(PERMANENT_CACHE_NODE);
				if (childrenNames != null) {
					Iterator nodes = childrenNames.iterator();
					traverseNode(nodes, new Fqn(PERMANENT_CACHE_NODE),
							permanentRegions.get(i).toString());
				}
			}
		} catch (Exception e) {
			// TODO: error code
			throw new CacheException("",
					"Problem in invalidating the Permanent Cache regions.", e);
		}
	}

	/**
	 * Invalidation of Temporary cache region is done here.
	 */
	 public void invalidateTemporaryRegion() {
		try {
			String USER_SESSION_NODE = JBossCacheImpl.ROOT
					+ Constants.USER_SESSION_CACHE;
			Set childrenNames = oTreecacheaop
					.getChildrenNames(USER_SESSION_NODE);
			if (childrenNames != null) {
				Iterator nodes = childrenNames.iterator();
				traverseNode(nodes, new Fqn(USER_SESSION_NODE),
						Constants.USER_SESSION_CACHE);
			}
		} catch (Exception e) {
			// TODO: error code
			throw new CacheException("",
					"Problem in invalidating the temporary cache regions.", e);
		}
	}

	public boolean isRunning() {
		return JBossCacheImpl.running;
	}

	/**
	 * Inserts the specified object into the Cache, using the specified key and
	 * region.
	 * @param region
	 * @param key
	 * @param object 
	 * 
	 */public void putObject(String region, String key, Object object) {
		try {
			if (!(object instanceof Serializable)) {
				throw new UnsupportedCacheObjectException(
						ErrorConstants.DATA_ERROR, MessageFormat.format(
								CacheMessages.UNSERIALIZED_OBJECT,
								new Object[] { region
										+ JBossCacheImpl.DELIMITER + key }));
			}
			if (region.startsWith(Constants.USER_SESSION_CACHE)
					|| region.equals(Constants.PATIENT_CACHE)
					|| region.equals(Constants.GLOBAL_CACHE)) {
				// If exists remove the object and push it ( to avoid
				// IllegalStateException )
				if (oTreecacheaop.exists(JBossCacheImpl.ROOT + region
						+ JBossCacheImpl.DELIMITER + key)) {
					oTreecacheaop.remove(JBossCacheImpl.ROOT + region
							+ JBossCacheImpl.DELIMITER + key);
				}

				oTreecacheaop.putObject(JBossCacheImpl.ROOT + region
						+ JBossCacheImpl.DELIMITER + key, new CacheObject(
						object));
			} else {
				throw new InvalidCacheRegionException(
						ErrorConstants.DATA_ERROR, CacheMessages.INVALID_REGION);
			}
		} catch (org.jboss.cache.CacheException ce) {
			throw new CacheException(ErrorConstants.DATA_ERROR,
					CacheMessages.WRITE_ERROR, ce);
		}
	}

	/*
	 * 
	 * Inserts the specified object into the Cache, using the specified
	 * key,region and sessionid.
	 * @param region
	 * @param sessionid
	 * @param key
	 * @param object
	 */
	 public void putObject(String region, String sessionid, String key,
			Object object) {
		this.putObject(region + Cache.DELIMITER + sessionid, key, object);
	}

	/**
	 * Removes object from Cache.
	 * @param key
	 */
	public void removeObject(String key) {
		try {
			oTreecacheaop.remove(key);
		} catch (org.jboss.cache.CacheException e) {
			throw new CacheException(ErrorConstants.DATA_ERROR, MessageFormat
					.format(CacheMessages.REMOVAL_ERROR, new Object[] { key }),
					e);
		}
	}

	/*
	 * 
	 * Removes object from Cache for a specific region.
	 * @param region
	 * @param key
	 */
	public void removeObject(String region, String key) {
		this.removeObject(Cache.ROOT + region + Cache.DELIMITER + key);
	}

	/**
	 * Removes object from Cache.
	 * @param region
	 * @param sessionid
	 * @param key
	 */
	public void removeObject(String region, String sessionid, String key) {
		this.removeObject(Cache.ROOT + region + Cache.DELIMITER + sessionid
				+ Cache.DELIMITER + key);
	}

	/**
	 * @param running
	 */
	/**
	 * @param running
	 */
	public void setRunning(boolean running) {
		JBossCacheImpl.running = running;
	}

	/*
	 * Starts JBoss Cache Service.
	 * 
	 * @see com.iba.framework.cache.pojo.business.Cache#startService()
	 */
	public void startService() {
		try {
			JBossCacheImpl.logger.info(JBossCacheImpl.class,
					"Starting cache service...", null, null);
			oTreecacheaop.startService();
			JBossCacheImpl.logger.info(JBossCacheImpl.class, "Cache started.",
					null, null);
		} catch (Exception e) {
			throw new CacheException(ErrorConstants.LOAD_ERROR,
					CacheMessages.STARTUP_PROBLEM, e);
		}
	}

	/*
	 * Stops JBoss Cache Service
	 * 
	 * @see com.iba.framework.cache.pojo.business.Cache#stopService()
	 */
	public void stopService() {
		JBossCacheImpl.logger.info(getClass(), "Stopping cache service...",
				null, null);
		oTreecacheaop.stopService();
		setRunning(false);
		oTreecacheaop = null;

		JBossCacheImpl.logger.info(getClass(), "Cache service stopped.", null,
				null);
	}

	/**
	 * Method that traverses through the tree nodes to find  child nodes.
	 * @param nodes
	 * @param fqn
	 * @param regionType
	 */
	private void traverseNode(Iterator nodes, Fqn fqn, String regionType) {
		String nodeName = null;
		DataNode node = null;
		CacheObject oCacheObj = null;
		try {
			while (nodes.hasNext()) {
				nodeName = (String) nodes.next();
				node = (DataNode) oTreecacheaop.get(fqn
						+ JBossCacheImpl.DELIMITER + nodeName);
				if (node != null) {
					if (node.hasChildren()) {
						traverseNode(oTreecacheaop.getChildrenNames(
								node.getFqn()).iterator(), node.getFqn(),
								regionType);
					}
					if (node.getData() != null) {
						oCacheObj = (CacheObject) node.getData().get(
								"__SERIALIZED__");
						if (oCacheObj == null) {
							oTreecacheaop.remove(node.getFqn());
						}
					}
				}
				if (oCacheObj != null) {
					invalidateObject(node.getFqn(), oCacheObj, regionType);
				}
				oCacheObj = null;
			}
		} catch (org.jboss.cache.CacheException e) {
			// TODO: error code
			throw new CacheException("",
					"Problem in traversing cache nodes...", e);
		}
	}

}
