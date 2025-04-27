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
package com.iba.ehis.lc.writeOffLinen.pojo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.iba.ehis.core.pojo.business.AppDelegator;
import com.iba.ehis.core.pojo.web.AppForm;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.writeOffLinen.vo.WriteOffLinenVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.Page;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.lookup.pojo.business.LookupDelegate;
import com.iba.framework.lookup.vo.LookupVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WriteOffLinenAction extends LcAction {

	protected DTO doActionCreate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {

		valueObject = setDefaultSet((AppVO) valueObject, request);
		DTO dto = ((AppDelegator) getDelegator())
				.createTypeMaster((WriteOffLinenVO) valueObject);

		if ((dto.getStatus() == Constants.SUCCESS)) {
			dto.setTarget("successCUD");
			dto.setMessageId(Constants.OPERATION_SUCCESS);
		} else if ((dto.getStatus() == Constants.FAILED)) {
			dto.setTarget("successCUD");
			dto.setMessageId(Constants.OPERATION_FAILURE);
		}
		return dto;
	}

	protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request,
			HttpServletResponse response) throws ApplicationException {

		DTO dto = new DTO();
		valueObject = setDefaultSet((AppVO) valueObject, request);
		if (((WriteOffLinenVO) valueObject).getSourceCode() == null) {
			dto.setMode(Constants.CREATE);
			dto.setObject(valueObject);
			dto.setTarget("createPageWriteOffLinen");
			dto.setStatus(Constants.SUCCESS);
		} else {
			dto = ((AppDelegator) getDelegator())
					.getTypeMaster((WriteOffLinenVO) valueObject);
			((AppVO) dto.getObject())
					.setFunctionId(((WriteOffLinenVO) valueObject)
							.getFunctionId());
			((AppVO) dto.getObject())
					.setModuleId(((WriteOffLinenVO) valueObject).getModuleId());
			IBALogger.getLogger().debug(this.getClass(),
					((WriteOffLinenVO) dto.getObject()).getSourceCode(),
					request.getSession().getId());
			dto.setMode(Constants.UPDATE);
			dto.setTarget("createPageWriteOffLinen");
		}

		return dto;
	}

	public Object getRefNum(String facilityId, HttpServletRequest request) {

		LookupVO lookUpVo = new LookupVO();
		Map lookupValueMap = new HashMap();

		lookupValueMap.put("facilityId", facilityId);
		lookUpVo.setLookupParameters(lookupValueMap);
		lookUpVo.setQueryId("ehis.lc.writeOffLinen.getRefNum");

		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		Page page = new Page();
		page.setPagingEnabled(false);

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map refNumMap = (Map) ((LookupVO) dto.getObject()).getLookupResults();

		return refNumMap;
	}

	public Object getExistQty(String facilityId, String sourceType,
			String sourceCode, String linenItem, HttpServletRequest request) {

		LookupVO lookUpVo = new LookupVO();
		Map lookupValueMap = new HashMap();

		lookupValueMap.put("facilityId", facilityId);
		lookupValueMap.put("sourceType", sourceType);
		lookupValueMap.put("sourceCode", sourceCode);
		lookupValueMap.put("linenItem", linenItem);

		IBALogger.getLogger().debug(this.getClass(),
				"sourceType---->" + lookupValueMap.get("sourceType"), "null");

		lookUpVo.setLookupParameters(lookupValueMap);

		lookUpVo.setQueryId("ehis.lc.writeOffLinen.getExistQty");

		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		Page page = new Page();
		page.setPagingEnabled(false);

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map existMap = (Map) ((LookupVO) dto.getObject()).getLookupResults();

		return existMap;
	}

	public Object getExistingQty(String facilityId, String linenItem,
			HttpServletRequest request) {

		LookupVO lookUpVo = new LookupVO();
		Map lookupValueMap = new HashMap();

		lookupValueMap.put("facilityId", facilityId);
		lookupValueMap.put("linenItem", linenItem);

		lookUpVo.setLookupParameters(lookupValueMap);

		lookUpVo.setQueryId("ehis.lc.writeOffLinen.getExistingQty");

		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		Page page = new Page();
		page.setPagingEnabled(false);

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map existingQtyMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();

		return existingQtyMap;
	}

	public Map getLoggedInUser(String user, String facilityId,
			HttpServletRequest request) {

		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();

		Map lookupParams = new HashMap();

		lookupParams.put("userId", user);
		lookupParams.put("facilityId", facilityId);

		Page page = new Page();
		page.setPagingEnabled(false);

		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.writeOffLinen.getLoggedInUser");
		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map lcUserMap = (Map) ((LookupVO) dto.getObject()).getLookupResults();
		IBALogger.getLogger().debug(this.getClass(),
				"writeoffLinen existing Qty---->" + lcUserMap, "null");
		return lcUserMap;
	}

}
