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
import java.util.Set;

import org.jboss.cache.ConfigureException;
import org.jboss.cache.DataNode;
import org.jboss.cache.Fqn;
import org.jboss.cache.PropertyConfigurator;
import org.jboss.cache.aop.TreeCacheAop;

import com.iba.framework.cache.exception.CacheException;
import com.iba.framework.cache.exception.InvalidCacheRegionException;
import com.iba.framework.cache.exception.UnsupportedCacheObjectException;
import com.iba.framework.cache.util.CacheMessages;
import com.iba.framework.cache.vo.CacheObject;
import com.iba.framework.core.exception.DataNotFoundException;
import com.iba.framework.core.util.ApplicationPropertyReader;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.ErrorConstants;
import com.iba.framework.core.util.MessageConstants;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;

/**
 * @author S Sabarinathan
 * 
 */
public abstract class JBossCache implements Constants {
	static Logger logger = LogFactory.getApplicationLogger();

	static TreeCacheAop oTreecacheaop;

	static boolean running = false;

	final static String DELIMITER = "/";

	final static String ROOT = DELIMITER
			+ ApplicationPropertyReader.getApplicationName() + DELIMITER;

	protected JBossCache() {
		try {
			oTreecacheaop = new TreeCacheAop();
			PropertyConfigurator config = new PropertyConfigurator();
			config.configure(oTreecacheaop, Constants.JBOSSCACHE_CONFIG_FILE);
			logger.info(JBossCache.class, "Starting cache service...", null,
					null);
			oTreecacheaop.startService();
			logger.info(JBossCache.class, "Cache started.", null, null);
			setRunning(true);
		} catch (ConfigureException ce) {
			throw new CacheException(ErrorConstants.LOAD_ERROR,
					CacheMessages.CONFIG_ERROR, ce);
		} catch (Exception e) {
			throw new CacheException(ErrorConstants.UNKNOWN_ERROR,
					CacheMessages.STARTUP_PROBLEM, e);
		}
	}

	protected CacheObject getCacheObject(String region, String key,
			boolean timerEnabled) throws DataNotFoundException {
		CacheObject cachedObject = null;
		try {
			if (region.startsWith(Constants.USER_SESSION_CACHE)
					|| region.equals(Constants.PATIENT_CACHE)
					|| region.equals(Constants.GLOBAL_CACHE)) {
				if (oTreecacheaop.exists(ROOT + region + DELIMITER + key))
					cachedObject = (CacheObject) oTreecacheaop.getObject(ROOT
							+ region + DELIMITER + key);
				else
					throw new DataNotFoundException(Constants.DATA_NOT_FOUND,
							MessageFormat.format(MessageConstants.INVALID_KEY,
									new Object[] { region + DELIMITER + key }));
				if (timerEnabled && cachedObject != null)
					cachedObject
							.setLastAccessedTime(System.currentTimeMillis());
			} else
				throw new InvalidCacheRegionException(
						ErrorConstants.DATA_ERROR, CacheMessages.INVALID_REGION);
		} catch (org.jboss.cache.CacheException e) {
			throw new CacheException(ErrorConstants.DATA_ERROR, e);
		}
		return cachedObject;
	}

	protected void putObject(String region, String key, Object object) {
		try {
			if (!(object instanceof Serializable)) {
				throw new UnsupportedCacheObjectException(
						ErrorConstants.DATA_ERROR, MessageFormat.format(
								CacheMessages.UNSERIALIZED_OBJECT,
								new Object[] { region + DELIMITER + key }));
			}
			if (region.startsWith(Constants.USER_SESSION_CACHE)
					|| region.equals(Constants.PATIENT_CACHE)
					|| region.equals(Constants.GLOBAL_CACHE)) {
				// If exists remove the object and push it ( to avoid
				// IllegalStateException )
				if (oTreecacheaop.exists(ROOT + region + DELIMITER + key))
					oTreecacheaop.remove(ROOT + region + DELIMITER + key);
				oTreecacheaop.putObject(ROOT + region + DELIMITER + key,
						new CacheObject(object));
			} else
				throw new InvalidCacheRegionException(
						ErrorConstants.DATA_ERROR, CacheMessages.INVALID_REGION);
		} catch (org.jboss.cache.CacheException ce) {
			throw new CacheException(ErrorConstants.DATA_ERROR,
					CacheMessages.WRITE_ERROR, ce);
		}
	}

	protected void stopService() {
		oTreecacheaop.stopService();
		setRunning(false);
		oTreecacheaop = null;
	}

	public void removeObject(String key) {
		try {
			oTreecacheaop.remove(key);
		} catch (org.jboss.cache.CacheException e) {
			throw new CacheException(ErrorConstants.DATA_ERROR, MessageFormat
					.format(CacheMessages.REMOVAL_ERROR, new Object[] { key }),
					e);
		}
	}

	protected void invalidateTemporaryRegion() {
		try {
			String USER_SESSION_NODE = ROOT + Constants.USER_SESSION_CACHE;
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

	protected void invalidateOtherRegion() {
		List permanentRegions = new ArrayList(2);
		permanentRegions.add(Constants.PATIENT_CACHE);
		permanentRegions.add(Constants.GLOBAL_CACHE);
		try {
			String PERMANENT_CACHE_NODE = "";
			Set childrenNames = null;
			for (int i = 0; i < permanentRegions.size(); i++) {
				PERMANENT_CACHE_NODE = ROOT + permanentRegions.get(i);
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

	public void startService() {
		try {
			logger.info(JBossCache.class, "Starting cache service...", null,
					null);
			oTreecacheaop.startService();
			logger.info(JBossCache.class, "Cache started.", null, null);
		} catch (Exception e) {
			throw new CacheException(ErrorConstants.LOAD_ERROR,
					CacheMessages.STARTUP_PROBLEM, e);
		}
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		JBossCache.running = running;
	}

	private void traverseNode(Iterator nodes, Fqn fqn, String regionType) {
		String nodeName = null;
		DataNode node = null;
		CacheObject oCacheObj = null;
		try {
			while (nodes.hasNext()) {
				nodeName = (String) nodes.next();
				node = (DataNode) oTreecacheaop.get(fqn + DELIMITER + nodeName);
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

	private void invalidateObject(Fqn nodeFqn, CacheObject oCacheObject,
			String regionType) {
		logger
				.debug(JBossCache.class, nodeFqn + " last accessed time @ "
						+ new Timestamp(oCacheObject.getLastAccessedTime()),
						null, null);
		long timeoutInterval = -1;
		if (oCacheObject.getTimeout() == Constants.TIMEOUT_NOT_SET) {
			if (regionType.equals(Constants.USER_SESSION_CACHE))
				timeoutInterval = ApplicationPropertyReader
						.getUserCacheTimeoutInMills();
			else if (regionType.equals(Constants.PATIENT_CACHE))
				timeoutInterval = ApplicationPropertyReader
						.getPatientCacheTimeoutInMills();
		} else
			timeoutInterval = oCacheObject.getTimeout();
		long elapsedTime = System.currentTimeMillis()
				- oCacheObject.getLastAccessedTime();
		if (elapsedTime >= timeoutInterval) {
			try {
				logger.info(JBossCache.class, nodeFqn + " is invalidated @ "
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

	protected boolean exists(String key) {
		return oTreecacheaop.exists(key);
	}
}
