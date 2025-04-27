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
package com.iba.ehis.core.pojo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iba.ehis.core.vo.QueryCriteriaVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.Page;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;

/**
 * @author yadavk
 * 
 */
public class QueryAction extends AppAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.core.pojo.web.BaseAction#doActionCreate(com.iba.framework.core.vo.BaseVO,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected DTO doActionCreate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response) {

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

		/*
		 * create the DTO object
		 */
		DTO dto = new DTO();

		PageForm pageForm = new PageForm();
		IBALogger.getLogger().debug(this.getClass(),
				"QueryAction-----------------", null);

		((QueryResultVO) pageForm.getVo())
				.setCriteriaVo((QueryCriteriaVO) valueObject);
		((QueryResultVO) pageForm.getVo()).setPage(new Page());
		pageForm.setMethod(Constants.QUERY); // setting the method as query
		request.setAttribute("PageForm", pageForm); // setting the pageform
													// attrinbute on request

		// Delegating the dto to pageAction
		dto.setObject(valueObject);
		dto.setTarget(((QueryCriteriaVO) valueObject).getPageAction());
		return dto;
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
