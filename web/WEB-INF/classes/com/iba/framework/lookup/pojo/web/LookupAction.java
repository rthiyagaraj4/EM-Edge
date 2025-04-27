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
package com.iba.framework.lookup.pojo.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iba.ehis.core.util.AppConstants;
import com.iba.framework.core.pojo.web.BaseAction;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.Page;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;
import com.iba.framework.lookup.pojo.business.LookupDelegate;
import com.iba.framework.lookup.vo.LookupVO;

/**
 * @author Sabarinathan S
 * 
 */
public class LookupAction extends BaseAction {
	public final static Logger logger = LogFactory.getApplicationLogger();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.core.pojo.BaseAction#doActionCreate(com.iba.framework.core.pojo.BaseVO,
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
	 * @see com.iba.framework.core.pojo.BaseAction#doPrePopulate(com.iba.framework.core.pojo.BaseVO,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iba.framework.core.pojo.BaseAction#doActionUpdate(com.iba.framework.core.pojo.BaseVO,
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
	 * @see com.iba.framework.core.pojo.BaseAction#doActionDelete(com.iba.framework.core.pojo.BaseVO,
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
	 * @see com.iba.framework.core.pojo.BaseAction#doActionQuery(com.iba.framework.core.pojo.BaseVO,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected DTO doActionQuery(BaseVO valueObject, HttpServletRequest request,
			HttpServletResponse response) {
		DTO dto = null;
		LookupVO lookupParams = (LookupVO) valueObject;
		if (lookupParams.getLookupParameters().get("searchBy") != null) {
			String searchText = (String) lookupParams.getLookupParameters()
					.get("searchText");

			IBALogger.getLogger().debug(
					this.getClass(),
					(lookupParams.getLookupParameters().get("searchCriteria"))
							.getClass()
							+ "", request.getSession().getId());

			int criteria = Integer.parseInt((String) lookupParams
					.getLookupParameters().get("searchCriteria"));
			if (criteria == AppConstants.STARTS_WITH) {
				searchText = searchText + "%";
			} else if (criteria == AppConstants.ENDS_WITH) {
				searchText = "%" + searchText;
			} else {
				searchText = "%" + searchText + "%";
			}
			String searchBy = (String) lookupParams.getLookupParameters().get(
					"searchBy");

			lookupParams.getLookupParameters().put(searchBy, searchText);
			/*
			 * if (searchBy.equals(AppConstants.searchByCode)) {
			 * lookupParams.getLookupParameters().put(
			 * AppConstants.searchByDesc, "%"); } else {
			 * lookupParams.getLookupParameters().put(
			 * AppConstants.searchByCode, "%"); }
			 */
		}
		dto = ((LookupDelegate) getDelegator()).lookupUpQuery(lookupParams,
				lookupParams.getPage(), request.getSession().getId());
		if (dto != null && dto.getException() != null)
			logger.error(LookupAction.class, dto.getException().getMessage(),
					dto.getException(), "");
		dto.setTarget("lookupQueryResultPage");
		return dto;
	}

	public Map doLookup(String queryId, String lookupValue,
			boolean enablePaging, HttpServletRequest request,
			HttpServletResponse response) {

		LookupVO lookupVo = new LookupVO();
		Map map = new HashMap();
		String[] strings = lookupValue.split(",");

		for (int i = 0; i < strings.length; i++) {
			if (strings[i] != null && !strings[i].equals("")) {
				String[] strings2 = strings[i].split("=");
				map.put(strings2[0], strings2[1]);
			}
		}
		map.put("searchBy", AppConstants.searchByDesc);
		map
				.put("searchCriteria", new Integer(AppConstants.CONTAINS)
						.toString());

		String searchText = (String) map.get("searchText");
		if (searchText.equals("**"))
			searchText = "";
		map.put("searchText", searchText);

		lookupVo.setLookupParameters(map);
		lookupVo.setPage((enablePaging == true ? new Page() : null));
		lookupVo.setQueryId(queryId);

		Map map1 = map;
		DTO dto = doActionQuery(lookupVo, request, response);

		Map dataSet = (Map) ((LookupVO) dto.getObject()).getLookupResults();
		if (dataSet.size() == 0) {
			lookupVo.getLookupParameters().remove("code");
			lookupVo.getLookupParameters().remove("description");
			lookupVo.getLookupParameters().put("searchBy",
					AppConstants.searchByCode);
			dto = doActionQuery(lookupVo, request, response);
			dataSet = (Map) ((LookupVO) dto.getObject()).getLookupResults();
		}

		return dataSet;
	}
}
