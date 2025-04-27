/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.lookup.vo;

import java.util.HashMap;
import java.util.Map;

import com.iba.framework.core.util.Page;
import com.iba.framework.core.vo.BaseVO;

/**
 * @author Sabarinathan S
 * 
 */
public class LookupVO extends BaseVO {

	private Map lookupParameters;

	private String queryId;
	
	private Class voType;  
	
	private Map lookupResults;
	
	private Page page;
	
	private String[] lookupResultHeaders;
	
	public LookupVO() {
		// TODO Auto-generated constructor stub
	}

	public LookupVO(Map lookupValues) {
		this.lookupParameters = lookupValues;
	}

	public Map getLookupParameters() {
		if(lookupParameters ==null)
			lookupParameters=new HashMap();
		return lookupParameters;
	}

	public void setLookupParameters(Map lookupValues) {
		this.lookupParameters = lookupValues;
	}

	public String getQueryId() {
		return queryId;
	}

	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}

	public Class getVoType() {
		return voType;
	}

	public void setVoType(Class voType) {
		this.voType = voType;
	}

	public Map getLookupResults() {
		return lookupResults;
	}

	public void setLookupResults(Map lookupResults) {
		this.lookupResults = lookupResults;
	}

	public Page getPage() {
		if(page ==null)	page= new Page();
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String[] getLookupResultHeaders() {
		return lookupResultHeaders;
	}

	public void setLookupResultHeaders(String[] lookupResultHeaders) {
		this.lookupResultHeaders = lookupResultHeaders;
	}
}
