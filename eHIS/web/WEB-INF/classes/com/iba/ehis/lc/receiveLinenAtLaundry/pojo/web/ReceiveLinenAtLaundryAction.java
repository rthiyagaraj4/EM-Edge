/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.receiveLinenAtLaundry.pojo.web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.iba.ehis.core.pojo.business.AppDelegator;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.receiveLinenAtLaundry.vo.ReceiveLinenAtLaundryVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.Page;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.lookup.pojo.business.LookupDelegate;
import com.iba.framework.lookup.vo.LookupVO;

public class ReceiveLinenAtLaundryAction extends LcAction {

	protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request,
			HttpServletResponse response) throws ApplicationException {
		DTO dto = new DTO();
		valueObject = setDefaultSet((AppVO) valueObject, request);
		IBALogger.getLogger().debug(this.getClass(),
				"ReceiveLinenAtLaundry---------->", null);
		dto.setMode(Constants.CREATE);
		dto.setObject((ReceiveLinenAtLaundryVO) valueObject);
		dto.setTarget("createReceiveLinenAtLaundry");
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

	protected DTO doActionCreate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {
		DTO dto = null;
		valueObject = setDefaultSet((AppVO) valueObject, request);
		dto = ((AppDelegator) getDelegator())
				.createTypeMaster((ReceiveLinenAtLaundryVO) valueObject);

		if ((dto.getStatus() == Constants.SUCCESS)) {
			dto.setTarget("successCUD");
			dto.setMessageId(Constants.OPERATION_SUCCESS);
		} else if ((dto.getStatus() == Constants.FAILED)) {
			dto.setTarget("successCUD");
			dto.setMessageId(Constants.OPERATION_FAILURE);
		}
		return dto;
	}

	protected DTO doActionUpdate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {

		valueObject = setDefaultSet((AppVO) valueObject, request);
		ReceiveLinenAtLaundryVO receiveLinenAtLaundryVO = ((ReceiveLinenAtLaundryVO) valueObject);
		DTO dto = ((AppDelegator) getDelegator())
				.updateTypeMaster(receiveLinenAtLaundryVO);

		if ((dto.getStatus() == Constants.SUCCESS)) {
			dto.setTarget("successCUD");
			dto.setMessageId(Constants.OPERATION_SUCCESS);
		} else if ((dto.getStatus() == Constants.FAILED)) {
			dto.setTarget("successCUD");

			dto.setMessageId(Constants.OPERATION_FAILURE);
		}

		return dto;
	}

	public Object receiptNo(String FacilityId, HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Map lookupParams = new HashMap();
		lookupParams.put("facilityId", FacilityId);
		Page page = new Page();
		page.setPagingEnabled(false);
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.receivelinenAtlaundry.getReceiptNum");
		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject()).getLookupResults();
		IBALogger.getLogger().debug(this.getClass(),
				"ReceiveLinenAtLaundry---------->" + reqNoMap, null);

		return reqNoMap;
	}

		

}
