/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.core.vo;

import java.util.List;

import com.iba.framework.core.util.Page;

public class QueryResultVO extends AppVO {
	private Page page;

	private List dataObjects;

	private QueryCriteriaVO criteriaVo;

	private int dataObjectsSize;

	public QueryResultVO() {
		dataObjects = new java.util.ArrayList();
	}

	public List getDataObjects() {

		return dataObjects;
	}

	public void setDataObjects(List dataObjects) {

		this.dataObjects = dataObjects;
	}

	public Page getPage() {
		if (page == null)
			page = new Page();
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public QueryCriteriaVO getCriteriaVo() {
		if (criteriaVo == null)
			setCriteriaVo(new QueryCriteriaVO());
		return criteriaVo;
	}

	public void setCriteriaVo(QueryCriteriaVO criteriaVo) {
		this.criteriaVo = criteriaVo;
	}

	public int getDataObjectsSize() {
		return dataObjects.size();
	}
}
