/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Feb 24, 2006
 */
package com.iba.framework.core.util;

import java.util.Map;

/**
 * @author Parimala K V
 * 
 * <p>
 * <b>It provides necessary data to build queries based on single table.</b>
 * </p>
 * <br>
 * 
 * <pre>
 * pojo - pojo instance
 * criteria - search criteria based on STARTS_WITH/ENDS_WITH/CONTAINS/NONE. 
 * 			  Default is NONE.
 * searchBy - holds where clause fields. It must be a POJO property. 
 * 			  If the list has more than one element,then the logical condition 
 * 			  is determined based on the logicalCondition field.
 * orderBy  - holds the order by fields.
 * logicalCondition - determines the logical condition - allowed values are OR / AND. 
 * 			   Default is AND.
 * comparisonOperator - determines the type of expression. Default is EQUAL.
 * </pre>
 */
public class NamedQuery {
	Page page;

	private String queryID;

	private Map dataMap;

	private boolean functionOrProcedure = false;

	private String orderByClause;

	private String queryRegionName = "";

	public String getQueryRegionName() {
		return queryRegionName;
	}

	public void setQueryRegionName(String queryRegionName) {
		this.queryRegionName = queryRegionName;
	}

	public NamedQuery() {
		page = new Page();
	}

	/**
	 * @return Returns the functionOrProcedure.
	 */
	public boolean isFunctionOrProcedure() {
		return functionOrProcedure;
	}

	/**
	 * @param functionOrProcedure
	 *            The functionOrProcedure to set.
	 */
	public void setFunctionOrProcedure(boolean functionOrProcedure) {
		this.functionOrProcedure = functionOrProcedure;
		if (page != null)
			page.setPagingEnabled(!functionOrProcedure);
	}

	/**
	 * @return Returns the page.
	 */
	public Page getPage() {
		return page;
	}

	/**
	 * @param page
	 *            The page to set.
	 */
	public void setPage(Page page) {
		this.page = page;
	}

	public Map getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map dataMap) {
		this.dataMap = dataMap;
	}

	public String getQueryID() {
		return queryID;
	}

	public void setQueryID(String queryID) {
		this.queryID = queryID;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

}
