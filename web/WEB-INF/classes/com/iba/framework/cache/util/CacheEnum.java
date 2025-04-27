/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.cache.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.iba.framework.cache.exception.CacheException;
import com.iba.framework.core.util.Constants;

/**
 * A Cache enumerator class that provides utility functions.
 * It uses the Iterator interface.
 * @author Parimala
 *
 */public class CacheEnum {

	private List list;

	private String sessionId;

	private String typeOfCache;

	/**
	 * 
	 * @return list
	 */
	public List getList() {
		return list;
	}

	/**
	 * 
	 * @param list
	 */
	public void setList(List list) {
		this.list = list;
	}

	/*
	 * Returns an Iterator of the list.
	 */
	public Iterator getIterator() {
		if (list == null) {
			list = new ArrayList();
		}
		if (list != null) {
			return list.iterator();
		}
		return null;
	}

	public boolean addCacheItem(Object object) {
		if (list == null) {
			list = new ArrayList();

		}
		if (list.add(object)) {
			return true;
		}
		return false;
	}

	public String getTypeOfCache() {
		return typeOfCache;
	}

	public void setTypeOfCache(String typeOfCache) {
		this.typeOfCache = typeOfCache;
	}

	/**
	 * Checks whether the cachetype comes under an user session cache region.
	 * @return String
	 */public String getSessionId() {
		if (!getTypeOfCache().equals(Constants.USER_SESSION_CACHE)) {
			// TODO Seperate this message in the messages
			sessionId = " This is not an user session ";
		}
		return sessionId;
	}

	/**
	 * Throws cache exception if cachetype does not come under an user session cache region.
	 * @param sessionId
	 */public void setSessionId(String sessionId) {
		if (!getTypeOfCache().equals(Constants.USER_SESSION_CACHE)) {
			// TODO Message handeling
			throw new CacheException("This is not a session cache");
		}
		this.sessionId = sessionId;
	}

}
