/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.core.vo;

import com.iba.ehis.core.util.QueryCriteriaConstants;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.AutoGenerationList;

public class QueryCriteriaVO extends AppVO {

	// creationg the reference for AutoGenerationList
	private AutoGenerationList criteriaItems;

	// creationg the reference for QueryCriteriaItem
	private QueryCriteriaItem orderByOriginal;

	// creationg the reference for QueryCriteriaItem
	private QueryCriteriaItem orderBySelected;

	private String queryResultPage;

	private String moduleId;

	private String functionId;

	private String pageAction;
	
	
	private String queryCriteriaAction ;

	public String getPageAction() {
		return pageAction;
	}

	public void setPageAction(String pageAction) {
		this.pageAction = pageAction;
	}

	public String getQueryCriteriaAction() {
		return queryCriteriaAction;
	}

	public void setQueryCriteriaAction(String queryCriteriaAction) {
		this.queryCriteriaAction = queryCriteriaAction;
	}
	
	public QueryCriteriaVO() {

		criteriaItems = new AutoGenerationList(QueryCriteriaItem.class);

		/*
		 * setting the properties for the original criteria box
		 */
		orderByOriginal = new QueryCriteriaItem();
		orderByOriginal.setType(QueryCriteriaConstants.SELECT_ITEM); // setting
																		// the
																		// type
																		// as
																		// Select
		orderByOriginal.setProperty("vo.orderByOriginal.itemArr"); // setting
																	// the
																	// values
		orderByOriginal.setMultiple(true); // setting to select multiple values
		orderByOriginal.setLength(16); // setting the length

		/*
		 * setting the properties for the selected criteria box
		 */
		orderBySelected = new QueryCriteriaItem();
		orderBySelected.setType(QueryCriteriaConstants.SELECT_ITEM); // setting
																		// the
																		// type
																		// as
																		// Select
		orderBySelected.setProperty("vo.orderBySelected.itemArr"); // setting
																	// the
																	// values
		orderBySelected.setMultiple(true); // setting to select multiple values
		orderBySelected.setLength(16); // setting the length
	}

	/*
	 * Generated getters and setters of the reference variable
	 */

	public AutoGenerationList getCriteriaItems() {
		return criteriaItems;
	}

	public QueryCriteriaItem getOrderByOriginal() {
		return orderByOriginal;
	}

	public QueryCriteriaItem getOrderBySelected() {
		return orderBySelected;
	}

	public String getQueryResultPage() {
		return queryResultPage;
	}

	public void setQueryResultPage(String queryResultPage) {
		this.queryResultPage = queryResultPage;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	/*
	 * method for adding values from resource bundle to the orderByOriginal
	 * select box.
	 */
	public void addOrderByCol(String label, String value, String bundleName) {
		try {
			orderByOriginal.addOption(label, value, bundleName);
			orderByOriginal.setBundleName(bundleName);
		} catch (ApplicationException e) {

			e.printStackTrace();
		}
	}

}
