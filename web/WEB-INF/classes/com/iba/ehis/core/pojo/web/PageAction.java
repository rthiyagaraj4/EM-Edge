/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.core.pojo.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iba.ehis.core.pojo.business.AppDelegator;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryCriteriaItem;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;

/**
 * @author yadavk
 * 
 */
public class PageAction extends AppAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.core.pojo.web.BaseAction#doActionCreate(com.iba.framework.core.vo.BaseVO,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected DTO doActionCreate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {
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
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {
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
			HttpServletResponse response)throws ApplicationException {
		setDefaultSet((AppVO) valueObject, request);
		
		/* Generating the where clause for the Query  */
		
		QueryResultVO resultVo = (QueryResultVO) valueObject;
		
		/* loop to navigate on CriteriaItems */
		
		for (int i = 0; i < ((resultVo.getCriteriaVo()).getCriteriaItems()).size(); i++)
		{
			/* checking for where clause */
		
			(IBALogger.getLogger()).debug(this.getClass(),"Entered Where Clause", "");
			
			QueryCriteriaItem criteriaIterm = (QueryCriteriaItem) ((resultVo.getCriteriaVo()).getCriteriaItems()).get(i);
			
			/* Logger prints its contents on the log file   */
			
			(IBALogger.getLogger()).debug(this.getClass(), criteriaIterm.toString(), "");

			(IBALogger.getLogger()).debug(this.getClass(), criteriaIterm.getProperty(), "");

		}

		valueObject = setDefaultSet((AppVO) valueObject, request);
		
		DTO dto;
		
		/* Invoking the  delegator's queryTypeMaster() method by passing valueobject  */
		IBALogger.getLogger().debug(this.getClass(), "PageAction----before------------->",null);
		
		//System.out.println("getDelegator::"+getDelegator());
		
		dto = ((AppDelegator) getDelegator()).queryTypeMaster((QueryResultVO) valueObject);

		IBALogger.getLogger().debug(this.getClass(), "PageAction------after----------->",null);
		
		/* setting the resulto on on dataObjects  */
			
		Object dataObj = dto.getObject();
		
		if(!dataObj.equals(null)){
			if (dataObj instanceof List) {
				List dObj = (List) dataObj;
				((QueryResultVO) valueObject).setDataObjects(dObj);
			}else{
				dto = ((AppDelegator) getDelegator()).queryTypeMaster((QueryResultVO) valueObject);
				((QueryResultVO) valueObject).setDataObjects((List)dto.getObject());
			}
		}
		
		/* setting the valueobject to dto */
		dto.setObject(valueObject);
		
			
		/* setting the target for dto to the result page */
			
		dto.setTarget(resultVo.getCriteriaVo().getQueryResultPage());
		(IBALogger.getLogger()).debug(this.getClass(), "setResult Page in PageAction: --  "+resultVo.getCriteriaVo().getQueryResultPage(),"");
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
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {
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
			HttpServletResponse response) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}
}

