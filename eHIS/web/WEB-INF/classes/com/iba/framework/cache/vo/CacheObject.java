/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package com.iba.framework.cache.vo;

import java.io.Serializable;

import com.iba.framework.core.util.Constants;

/**
 * Wrapper class for the objects that will be stored into the cache. This object
 * is used by the cache implementations to track the creation time, last
 * accessed time, timeout etc.
 * 
 * @author sabarinathans
 * 
 */
public class CacheObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Object object;

	private long lastAccessedTime;

	private long creationTime;

	private int timeout = Constants.TIMEOUT_NOT_SET;

	protected long hits;

	private long fetchCount;

	private long loadCount;

	private long recreateCount;

	private long removeCount;

	private long updateCount;

	private long insertCount;

	private long optimisticFailureCountCount;

	/**
	 * Constructor for the CacheObject.
	 * 
	 */
	public CacheObject() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a new CacheObject which accepts a node as object and assigns it
	 * as a CacheObject.
	 * 
	 * @param oNode
	 */
	public CacheObject(Object oNode) {
		this.object = oNode;
		this.creationTime = System.currentTimeMillis();
		this.lastAccessedTime = creationTime;
	}

	/**
	 * 
	 * @return long
	 */
	public long getLastAccessedTime() {
		return lastAccessedTime;
	}

	/**
	 * 
	 * @param lastAccessedTime
	 */
	public void setLastAccessedTime(long lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
	}

	/**
	 * 
	 * @return Object
	 */
	public Object getObject() {
		hits++;
		return object;
	}

	/**
	 * 
	 * @param object
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * 
	 * @return long
	 */
	public long getCreationTime() {
		return creationTime;
	}

	/**
	 * 
	 * @param creationTime
	 */
	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * 
	 * @return int
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * 
	 * @param timeout
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	/**
	 * 
	 * @return long
	 */
	public long getHits() {
		return hits;
	}

	/**
	 * 
	 * @return long
	 */
	public long getFetchCount() {
		return fetchCount;
	}

	/**
	 * 
	 * @param fetchCount
	 */
	public void setFetchCount(long fetchCount) {
		this.fetchCount = fetchCount;
	}

	/**
	 * 
	 * @return long
	 */
	public long getLoadCount() {
		return loadCount;
	}

	/**
	 * 
	 * @param loadCount
	 */
	public void setLoadCount(long loadCount) {
		this.loadCount = loadCount;
	}

	/**
	 * 
	 * @return long
	 */
	public long getRecreateCount() {
		return recreateCount;
	}

	/**
	 * 
	 * @param recreateCount
	 */
	public void setRecreateCount(long recreateCount) {
		this.recreateCount = recreateCount;
	}

	/**
	 * 
	 * @return long
	 */
	public long getRemoveCount() {
		return removeCount;
	}

	/**
	 * 
	 * @param removeCount
	 */
	public void setRemoveCount(long removeCount) {
		this.removeCount = removeCount;
	}

	/**
	 * 
	 * @return long
	 */
	public long getUpdateCount() {
		return updateCount;
	}

	/**
	 * 
	 * @param updateCount
	 */
	public void setUpdateCount(long updateCount) {
		this.updateCount = updateCount;
	}

	/**
	 * 
	 * @return long
	 */
	public long getInsertCount() {
		return insertCount;
	}

	/**
	 * 
	 * @param insertCount
	 */
	public void setInsertCount(long insertCount) {
		this.insertCount = insertCount;
	}

	/**
	 * 
	 * @return long
	 */
	public long getOptimisticFailureCountCount() {
		return optimisticFailureCountCount;
	}

	/**
	 * 
	 * @param optimisticFailureCountCount
	 */
	public void setOptimisticFailureCountCount(long optimisticFailureCountCount) {
		this.optimisticFailureCountCount = optimisticFailureCountCount;
	}
}
