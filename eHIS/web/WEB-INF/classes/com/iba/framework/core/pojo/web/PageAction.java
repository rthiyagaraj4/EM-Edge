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
package com.iba.framework.core.pojo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iba.ehis.core.vo.QueryCriteriaVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.vo.BaseVO;

/**
 * @author yadavk
 * 
 */
public class PageAction extends BaseAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.core.pojo.web.BaseAction#doActionCreate(com.iba.framework.core.vo.BaseVO,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected DTO doActionCreate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.core.pojo.web.BaseAction#doActionDelete(com.iba.framework.core.vo.BaseVO,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected DTO doActionDelete(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.core.pojo.web.BaseAction#doActionQuery(com.iba.framework.core.vo.BaseVO,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected DTO doActionQuery(BaseVO valueObject, HttpServletRequest request,
			HttpServletResponse response) {
		QueryResultVO queryResultVo = null;
		DTO dto = new DTO();
		if (valueObject instanceof QueryCriteriaVO) {
			queryResultVo = new QueryResultVO();
			queryResultVo.setCriteriaVo((QueryCriteriaVO) valueObject);
		} else if (valueObject instanceof QueryResultVO) {
			queryResultVo = (QueryResultVO) valueObject;
		}
		queryResultVo.setDataObjects((List) dto.getObject());
		queryResultVo.setPage(dto.getPage());
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.core.pojo.web.BaseAction#doActionUpdate(com.iba.framework.core.vo.BaseVO,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected DTO doActionUpdate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.core.pojo.web.BaseAction#doPrePopulate(com.iba.framework.core.vo.BaseVO,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
