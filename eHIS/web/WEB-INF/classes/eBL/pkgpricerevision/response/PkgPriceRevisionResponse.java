/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL.pkgpricerevision.response;

import java.util.List;

import eBL.pkgpricerevision.request.PackagePriceBean;

/**
 * This is used as Response Object in Price Discount Revision
 * @author Rajesh V
 *
 */
public class PkgPriceRevisionResponse {
	
	private boolean status = false;
	private String nextYN = "";
	private String prevYN = "";
	private String traversal = "";
	private String jobNumber = "";
	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	private int totalCount = 0;
	private int rowsInserted = 0;
	public int getRowsInserted() {
		return rowsInserted;
	}

	public void setRowsInserted(int rowsInserted) {
		this.rowsInserted = rowsInserted;
	}

	private String sessionId = "";
	private String pgmDate = "";
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getPgmDate() {
		return pgmDate;
	}

	public void setPgmDate(String pgmDate) {
		this.pgmDate = pgmDate;
	}

	private List<String> error = null;
	
	public List<String> getError() {
		return error;
	}

	public void setError(List<String> error) {
		this.error = error;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	private List<PackagePriceBean> priceList = null;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getNextYN() {
		return nextYN;
	}

	public void setNextYN(String nextYN) {
		this.nextYN = nextYN;
	}

	public String getPrevYN() {
		return prevYN;
	}

	public void setPrevYN(String prevYN) {
		this.prevYN = prevYN;
	}

	public String getTraversal() {
		return traversal;
	}

	public void setTraversal(String traversal) {
		this.traversal = traversal;
	}

	public List<PackagePriceBean> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<PackagePriceBean> priceList) {
		this.priceList = priceList;
	}
	
	
}
