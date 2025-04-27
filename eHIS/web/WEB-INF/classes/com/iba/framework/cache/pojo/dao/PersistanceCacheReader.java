/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.cache.pojo.dao;

import java.util.ArrayList;

import org.hibernate.stat.CollectionStatistics;
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.QueryStatistics;
import org.hibernate.stat.Statistics;

import com.iba.framework.cache.util.CacheEnum;
import com.iba.framework.cache.vo.CacheAttribute;
import com.iba.framework.cache.vo.CacheObject;
import com.iba.framework.cache.vo.PersistanceCache;
import com.iba.framework.cache.vo.PersistanceCacheDiagnostics;
import com.iba.framework.core.pojo.dao.AbstractDAO;
import com.iba.framework.logging.pojo.business.IBALogger;

/**
 * @author ParimalaK This class reads all the persistence cache statistics
 */

public class PersistanceCacheReader extends AbstractDAO {

	/**
	 * This method gets the query,collection and entity cache statistics and
	 * store in cache object
	 * 
	 * @return diagnostics
	 */
	public PersistanceCacheDiagnostics getPeristanceDiagnostics() {
		PersistanceCacheDiagnostics diagnostics = new PersistanceCacheDiagnostics();
		Statistics stats = getOrmTemplate().getSessionFactory().getStatistics();
		IBALogger.getLogger().debug(getClass(),
				"Getting statistics from sessionFactory", null);
		ArrayList cRoleNames = new ArrayList();
		ArrayList eNames = new ArrayList();
		ArrayList tempCollectionRoleNames = new ArrayList();
		ArrayList tempEntityNames = new ArrayList();
		String collectionRoleNames[] = stats.getCollectionRoleNames();
		for (int i = 0; i < collectionRoleNames.length; i++) {
			cRoleNames.add(collectionRoleNames[i]);

		}
		String entityNames[] = stats.getEntityNames();
		for (int i = 0; i < entityNames.length; i++) {
			eNames.add(entityNames[i]);

		}

		String regionNames[] = stats.getSecondLevelCacheRegionNames();

		CacheEnum collectionCacheEnum = new CacheEnum();
		CacheEnum entityCacheEnum = new CacheEnum();
		CacheEnum queryCacheEnum = new CacheEnum();

		for (int i = 0; i < regionNames.length; i++) {

			if (!cRoleNames.isEmpty() && cRoleNames.contains(regionNames[i])) {
				tempCollectionRoleNames.add(regionNames[i]);
			}
			if (!eNames.isEmpty() && eNames.contains(regionNames[i])) {
				tempEntityNames.add(regionNames[i]);
			}
			if ((tempCollectionRoleNames != null)
					&& cRoleNames.contains(regionNames[i])) {
				CacheObject cacheObj = new CacheObject();
				CollectionStatistics collectionStatistics = stats
						.getCollectionStatistics(regionNames[i]);
				IBALogger.getLogger().debug(getClass(),
						"Getting Collection statistics from statistics", null);
				cacheObj.setFetchCount(collectionStatistics.getFetchCount());
				cacheObj.setLoadCount(collectionStatistics.getLoadCount());
				cacheObj.setRecreateCount(collectionStatistics
						.getRecreateCount());
				cacheObj.setRemoveCount(collectionStatistics.getRemoveCount());
				cacheObj.setUpdateCount(collectionStatistics.getUpdateCount());
				CacheAttribute cacheAttr = new CacheAttribute();
				cacheAttr.setCacheKey(regionNames[i]);
				cacheAttr.setCacheValue((cacheObj));
				collectionCacheEnum.addCacheItem(cacheAttr);
			} else if ((tempEntityNames != null)
					&& eNames.contains(regionNames[i])) {
				CacheObject cacheObj = new CacheObject();
				EntityStatistics entityStatistics = stats
						.getEntityStatistics(regionNames[i]);
				IBALogger.getLogger().debug(getClass(),
						"Getting Entity names from statistics", null);
				cacheObj.setFetchCount(entityStatistics.getFetchCount());
				cacheObj.setLoadCount(entityStatistics.getLoadCount());
				cacheObj.setInsertCount(entityStatistics.getInsertCount());
				cacheObj.setRemoveCount(entityStatistics.getDeleteCount());
				cacheObj.setUpdateCount(entityStatistics.getUpdateCount());
				cacheObj.setOptimisticFailureCountCount(entityStatistics
						.getOptimisticFailureCount());
				CacheAttribute cacheAttr = new CacheAttribute();
				cacheAttr.setCacheKey(regionNames[i]);
				cacheAttr.setCacheValue((cacheObj));
				entityCacheEnum.addCacheItem(cacheAttr);
			} else if (cRoleNames.contains(regionNames[i])) {
				CacheObject cacheObj = new CacheObject();
				CollectionStatistics collectionStatistics = stats
						.getCollectionStatistics(regionNames[i]);
				IBALogger.getLogger().debug(getClass(),
						"Getting Collection statistics from statistics", null);
				cacheObj.setFetchCount(collectionStatistics.getFetchCount());
				cacheObj.setLoadCount(collectionStatistics.getLoadCount());
				cacheObj.setRecreateCount(collectionStatistics
						.getRecreateCount());
				cacheObj.setRemoveCount(collectionStatistics.getRemoveCount());
				cacheObj.setUpdateCount(collectionStatistics.getUpdateCount());
				CacheAttribute cacheAttr = new CacheAttribute();
				cacheAttr.setCacheKey(regionNames[i]);
				cacheAttr.setCacheValue((cacheObj));
				collectionCacheEnum.addCacheItem(cacheAttr);
			} else if (eNames.contains(regionNames[i])) {
				CacheObject cacheObj = new CacheObject();
				EntityStatistics entityStatistics = stats
						.getEntityStatistics(regionNames[i]);
				IBALogger.getLogger().debug(getClass(),
						"Getting EntityStatistics from statistics", null);
				cacheObj.setFetchCount(entityStatistics.getFetchCount());
				cacheObj.setLoadCount(entityStatistics.getLoadCount());
				cacheObj.setInsertCount(entityStatistics.getInsertCount());
				cacheObj.setRemoveCount(entityStatistics.getDeleteCount());
				cacheObj.setUpdateCount(entityStatistics.getUpdateCount());
				cacheObj.setOptimisticFailureCountCount(entityStatistics
						.getOptimisticFailureCount());
				CacheAttribute cacheAttr = new CacheAttribute();
				cacheAttr.setCacheKey(regionNames[i]);
				cacheAttr.setCacheValue((cacheObj));
				entityCacheEnum.addCacheItem(cacheAttr);
			} else if (!(regionNames[i].toString()
					.equals("org.hibernate.cache.StandardQueryCache"))
					&& !(regionNames[i].toString()
							.equals("org.hibernate.cache.UpdateTimestampsCache"))) {
				PersistanceCache persiatanceCacheObj = new PersistanceCache();
				QueryStatistics queryStats = stats
						.getQueryStatistics(regionNames[i]);
				IBALogger.getLogger().debug(getClass(),
						"Getting QueryStatistics from statistics", null);
				persiatanceCacheObj
						.setMissCount(queryStats.getCacheMissCount());
				persiatanceCacheObj.setHits(queryStats.getCacheHitCount());
				persiatanceCacheObj.setQueryExecutionCount(queryStats
						.getExecutionCount());
				persiatanceCacheObj.setQueryExecutionAverageTime(queryStats
						.getExecutionAvgTime());
				CacheAttribute cacheAttr = new CacheAttribute();
				cacheAttr.setCacheKey(regionNames[i]);
				cacheAttr.setCacheValue((persiatanceCacheObj));
				queryCacheEnum.addCacheItem(cacheAttr);
			}

		}

		diagnostics.setCollectionCache(collectionCacheEnum);
		diagnostics.setEntityCache(entityCacheEnum);
		diagnostics.setQueryCache(queryCacheEnum);

		return diagnostics;
	}
}
