/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.cache.vo;

import com.iba.framework.cache.util.CacheEnum;

public class PersistanceCacheDiagnostics {

	private CacheEnum collectionCache = null;

	private CacheEnum entityCache = null;

	private CacheEnum queryCache = null;

	private CacheEnum secondLevelCache = null;

	public CacheEnum getCollectionCache() {
		return collectionCache;
	}

	public void setCollectionCache(CacheEnum collectionCache) {
		this.collectionCache = collectionCache;
	}

	public CacheEnum getEntityCache() {
		return entityCache;
	}

	public void setEntityCache(CacheEnum entityCache) {
		this.entityCache = entityCache;
	}

	public CacheEnum getQueryCache() {
		return queryCache;
	}

	public void setQueryCache(CacheEnum queryCache) {
		this.queryCache = queryCache;
	}

	public CacheEnum getSecondLevelCache() {
		return secondLevelCache;
	}

	public void setSecondLevelCache(CacheEnum secondLevelCache) {
		this.secondLevelCache = secondLevelCache;
	}

}
