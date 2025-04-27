/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.core.util;

public class Page {
	private int pageNo = 1;

	private boolean nextPage;

	private boolean previousPage;

	private boolean lastPage;

	private int pageSize;

	private boolean pagingEnabled = true;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public boolean isFirstPage() {
		return pageNo == 1;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public boolean hasNextPage() {
		return nextPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public void setNextPage(boolean nextPage) {
		this.nextPage = nextPage;
	}

	public void setPreviousPage(boolean previousPage) {
		this.previousPage = previousPage;
	}

	public boolean hasPreviousPage() {
		return pageNo > 1;
	}

	public int getNextPageNumber() {
		return pageNo + 1;
	}

	public int getPreviousPageNumber() {
		return pageNo - 1;
	}

	public int getPageSize() {
		if (pageSize == 0)
			return ApplicationPropertyReader.getPageSize();
		else
			return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isPagingEnabled() {
		return this.pagingEnabled;
	}

	public void setPagingEnabled(boolean pagingEnabled) {
		this.pagingEnabled = pagingEnabled;
	}

	public boolean getNextPage() {
		return hasNextPage();
	}

	public boolean getPreviousPage() {
		return hasPreviousPage();
	}
}
