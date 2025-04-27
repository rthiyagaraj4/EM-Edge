/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.receiveLoanedLinen.pojo.web;

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
import com.iba.ehis.lc.receiveLoanedLinen.vo.ReceiveLoanedLinenMainVO;
import com.iba.ehis.lc.receiveLoanedLinen.vo.ReceiveLoanedLinenVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.Page;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.lookup.pojo.business.LookupDelegate;
import com.iba.framework.lookup.vo.LookupVO;

public class ReceiveLoanedLinenAction extends LcAction {

	protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request,
			HttpServletResponse response) throws ApplicationException {

		DTO lookUpDTO = new DTO();
		LookupVO lookUpVo = new LookupVO();
		Map lookupMap = new HashMap();
		List options = new ArrayList();
		Map selectValMap = new HashMap();

		valueObject = setDefaultSet((AppVO) valueObject, request);
		lookupMap.put("facilityId", ((AppVO) valueObject).getAddedFacilityId());
		lookupMap.put("language_Id", request.getSession().getAttribute("LOCALE"));
		lookUpVo.setLookupParameters(lookupMap);
		
		lookUpVo.setQueryId("ehis.lc.loanLinen.getLoanReason");
		lookUpDTO = ((LookupDelegate) getDelegatorById("lookupDelegator"))
				.lookupUpQuery(lookUpVo, null, request.getSession().getId());
		selectValMap = ((Map) (((LookupVO) lookUpDTO.getObject())
				.getLookupResults()));
		options.add(0, selectValMap);

		lookUpDTO.setTarget("receiveLoanedLinen");
		lookUpDTO.setObject((ReceiveLoanedLinenMainVO) valueObject);
		return lookUpDTO;
	}

	protected DTO doActionUpdate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {

		valueObject = setDefaultSet((AppVO) valueObject, request);
		ReceiveLoanedLinenMainVO receiveLoanedLinenMainVO = ((ReceiveLoanedLinenMainVO) valueObject);
		DTO dto = ((AppDelegator) getDelegator())
				.updateTypeMaster(receiveLoanedLinenMainVO);
		if ((dto.getStatus() == Constants.SUCCESS)) {
			dto.setTarget("successCUD");
			dto.setMessageId(Constants.OPERATION_SUCCESS);
		} else if ((dto.getStatus() == Constants.FAILED)) {
			dto.setTarget("successCUD");
			dto.setMessageId(Constants.OPERATION_FAILURE);
		}

		return dto;
	}

	protected DTO doActionQuery(BaseVO valueObject, HttpServletRequest request,
			HttpServletResponse response) throws ApplicationException {
		AppForm criteriaForm = new AppForm();
		DTO dto = new DTO();
		QueryCriteriaVO queryCriteriaVO = new QueryCriteriaVO();
		setDefaultSet((AppVO) queryCriteriaVO, request);
		if (((ReceiveLoanedLinenMainVO) valueObject).getCheckView().equals(
				"receive")) {
			
			dto.setObject(valueObject);
			dto.setTarget("receiveLoanedLinenRequest");
		} else if (((ReceiveLoanedLinenMainVO) valueObject).getCheckView() == null
				|| ((ReceiveLoanedLinenMainVO) valueObject).getCheckView()
						.equals("")) {
			queryCriteriaVO.setPageAction("LoanLinenPageAction");
			queryCriteriaVO.setQueryResultPage("LoanLinenQueryResultPage");
			queryCriteriaVO
					.setFunctionId(((AppVO) valueObject).getFunctionId());
			queryCriteriaVO.setModuleId(AppConstants.LINEN);
			criteriaForm.setVo(queryCriteriaVO);
			request.setAttribute("QueryCriteriaForm", criteriaForm);
			dto.setTarget("loanLinenCriteriaPage");
		} else {
			QueryResultVO qryResultVO = new QueryResultVO();
			
				qryResultVO.setFunctionId("loan");
		
			qryResultVO.setModuleId(AppConstants.LINEN);
			QueryCriteriaVO criteriaVo = new QueryCriteriaVO();
			criteriaVo.setPageAction("LoanLinenViewPageAction");

			QueryCriteriaItem linenItemCriteriaIetm = new QueryCriteriaItem();
			QueryCriteriaItem requestNumCriteriaIetm = new QueryCriteriaItem();
			QueryCriteriaItem operFacilityIdCriteriaIetm = new QueryCriteriaItem();

			linenItemCriteriaIetm
					.setItemValue(((ReceiveLoanedLinenMainVO) valueObject)
							.getReceiveLoanedLinenVO().getLinenItem().trim());
			linenItemCriteriaIetm.setProperty("linenItem");

			requestNumCriteriaIetm
					.setItemValue(((ReceiveLoanedLinenMainVO) valueObject)
							.getReceiveLoanedLinenVO().getLoanRefNum().trim());
			requestNumCriteriaIetm.setProperty("loanRefNum");
			try {
				operFacilityIdCriteriaIetm
						.setItemValue(((ReceiveLoanedLinenMainVO) valueObject)
								.getReceiveLoanedLinenVO().getAddedFacilityId());
				operFacilityIdCriteriaIetm.setProperty("operatingfacilityId");
			} catch (Exception e) {
			}

			criteriaVo.getCriteriaItems().add(linenItemCriteriaIetm);
			criteriaVo.getCriteriaItems().add(requestNumCriteriaIetm);
			criteriaVo.getCriteriaItems().add(operFacilityIdCriteriaIetm);

			qryResultVO.setCriteriaVo(criteriaVo);
			Page page = new Page();
			page.setPagingEnabled(false);
			qryResultVO.setPage(page);
			request.setAttribute("QueryCriteriaForm", criteriaForm);
			valueObject = setDefaultSet((AppVO) valueObject, request);
			try {
				dto = ((AppDelegator) getDelegator())
						.queryTypeMaster(qryResultVO);
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
			dto.setTarget("receiveLoanedLinenViewRequest");
		}
		return dto;
	}

	public Object getLoanRefNum(HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Map lookupParams = new HashMap();
		Page page = new Page();
		page.setPagingEnabled(false);
		lookUpVo.setQueryId("ehis.lc.loanLinen.getLoanRefNum");

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject()).getLookupResults();

		return reqNoMap;
	}

	public Object getLoan(String languageId,HttpServletRequest request) {

		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Map lookupParams = new HashMap();
		Page page = new Page();
		lookupParams.put("language_Id", languageId);
	    lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.loanLinen.getLoanReason");
		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject()).getLookupResults();

		return reqNoMap;
	}
	  public Map getLinenItem(String languageId, String linenCode, HttpServletRequest request)
	    {
	        DTO dto = new DTO();
	        Map ValueMap = new HashMap();
	        Map existingRec = new HashMap();
	        LookupVO lookUpVo = new LookupVO();
	        IBALogger.getLogger().debug(getClass(), "StandardStockAction----1----->", null);
	        ValueMap.put("languageId", languageId);
	        ValueMap.put("code", linenCode);
	        lookUpVo.setLookupParameters(ValueMap);
	        lookUpVo.setQueryId("ehis.lc.standardStock.linenItem");
	        try
	        {
	            dto = ((LookupDelegate)getDelegatorById("lookupDelegator")).lookupUpQuery(lookUpVo, null, request.getSession().getId());
	            existingRec = ((LookupVO)dto.getObject()).getLookupResults();
	        }
	        catch(Exception e)
	        {
	            String message = e.getMessage();
	            dto.setMessageId(message);
	            dto.setTarget("successCUD");
	            dto.setMessageId("APP_404");
	        }
	        IBALogger.getLogger().debug(getClass(), (new StringBuilder("StandardStockAction-----getLinen----->")).append(existingRec).toString(), null);
	        return existingRec;
	    }


}
