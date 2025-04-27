/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Aug 17, 2006
 */
package com.iba.framework.core.vo;

/**
 * @author Sabarinathan S
 * @version
 */
public class PageVO extends BaseVO {
	private int windowSize;

	private int pageNo;

	private boolean paging;

	public boolean isPaging() {
		return paging;
	}

	public void setPaging(boolean disablePaging) {
		this.paging = disablePaging;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getWindowSize() {
		return windowSize;
	}

	public void setWindowSize(int windowSize) {
		this.windowSize = windowSize;
	}
}
