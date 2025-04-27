/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.cache.vo;

public class PersistanceCache extends CacheObject {
	private long missCount;

	private long queryExecutionCount;

	private long queryExecutionAverageTime;

	public long getMissCount() {
		return missCount;
	}

	public void setMissCount(long missCount) {
		this.missCount = missCount;
	}

	public long getQueryExecutionAverageTime() {
		return queryExecutionAverageTime;
	}

	public void setQueryExecutionAverageTime(long queryExecutionAverageTime) {
		this.queryExecutionAverageTime = queryExecutionAverageTime;
	}

	public long getQueryExecutionCount() {
		return queryExecutionCount;
	}

	public void setQueryExecutionCount(long queryExecutionCount) {
		this.queryExecutionCount = queryExecutionCount;
	}

	public void setHits(long hits) {
		this.hits = hits;
	}

}
