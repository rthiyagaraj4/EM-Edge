/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.returnofLinentoLaundry.pojo.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iba.ehis.core.pojo.business.AppDelegator;
import com.iba.ehis.core.pojo.web.AppForm;
import com.iba.ehis.core.util.AppConstants;
import com.iba.ehis.core.util.QueryCriteriaConstants;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryCriteriaItem;
import com.iba.ehis.core.vo.QueryCriteriaVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.core.util.LcConstants;
import com.iba.ehis.lc.requestForCleaningLinen.vo.PendingCountConfirmVO;
import com.iba.ehis.lc.requestForCleaningLinen.vo.RequestForCleaningLinenMainVO;
import com.iba.ehis.lc.returnofLinentoLaundry.vo.ReturnofLinentoLaundryVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.Page;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.lookup.pojo.business.LookupDelegate;
import com.iba.framework.lookup.vo.LookupVO;

public class ReturnofLinentoLaundryAction extends LcAction {

	protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request,
			HttpServletResponse response) throws ApplicationException {
		DTO dto = new DTO();

		dto.setTarget("returnofLinentoLaundry");
		dto.setObject((ReturnofLinentoLaundryVO) valueObject);
		return dto;
	}

	protected DTO doActionCreate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {
		DTO dto = new DTO();

		ReturnofLinentoLaundryVO returnofLinentoLaundryVO = (ReturnofLinentoLaundryVO) setDefaultSet(
				((ReturnofLinentoLaundryVO) valueObject), request);
		try {
			dto = ((AppDelegator) getDelegator())
					.createTypeMaster(returnofLinentoLaundryVO);
		} catch (Exception e) {
			dto.setStatus(Constants.FAILED);
		}

		if ((dto.getStatus() == Constants.SUCCESS)) {
			dto.setTarget("successCUD");
			dto.setMessageId(Constants.OPERATION_SUCCESS);
		} else if ((dto.getStatus() == Constants.FAILED)) {
			dto.setTarget("successCUD");

			dto.setMessageId(Constants.OPERATION_FAILURE);
		}

		return dto;
	}

	public Object getRefNum(HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Map lookupParams = new HashMap();
		Page page = new Page();
		page.setPagingEnabled(false);
		lookUpVo.setQueryId("ehis.lc.retunoflinentolaundry.getRefNum");

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject()).getLookupResults();

		return reqNoMap;
	}

	public Object getAvailQty(String facility_id, String sourceType,
			String sourceCode, String linenItemCode, HttpServletRequest request) {
		String facility = facility_id;
		String sourType = sourceType;
		String source = sourceCode;
		String linenItem = linenItemCode;

		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Map lookupParMap = new HashMap();

		lookupParMap.put("linenItem", linenItem);
		lookupParMap.put("sourType", sourType);
		lookupParMap.put("source", source);
		lookupParMap.put("facility", facility);
		lookUpVo.setLookupParameters(lookupParMap);

		Page page = new Page();
		page.setPagingEnabled(false);
		lookUpVo
				.setQueryId("ehis.lc.returnofLinenItemtoLaundry.getAvailbleStock");

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map availQtyMap = (Map) ((LookupVO) dto.getObject()).getLookupResults();

		if (availQtyMap.size() == 0) {
			IBALogger
					.getLogger()
					.debug(
							this.getClass(),
							availQtyMap.size()
									+ "availQtyMap---------->availQtyMap.size() ",
							null);

			availQtyMap.put(null, null);
			return availQtyMap;
		} else {
			return availQtyMap;
		}
	}

}
