/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.issueLinenAfterMending.pojo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iba.ehis.core.pojo.business.AppDelegator;
import com.iba.ehis.core.pojo.web.AppForm;
import com.iba.ehis.core.util.AppConstants;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryCriteriaItem;
import com.iba.ehis.core.vo.QueryCriteriaVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.issueLinenAfterMending.vo.IssueLinenAfterMendingMainVO;
import com.iba.ehis.lc.issueLinenAfterMending.vo.IssueLinenAfterMendingVO;
import com.iba.ehis.lc.issueOfLinen.vo.IssueOfLinenMainVO;
import com.iba.ehis.lc.issueOfLinen.vo.IssueOfLinenVO;
import com.iba.ehis.lc.requestForCleaningLinen.vo.RequestForCleaningLinenMainVO;
import com.iba.ehis.lc.requestForLinen.vo.RequestsListVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.Page;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.lookup.pojo.business.LookupDelegate;
import com.iba.framework.lookup.vo.LookupVO;

public class IssueLinenAfterMendingAction extends LcAction {

	protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)throws ApplicationException {
		DTO dto = new DTO();
		setDefaultSet(((IssueLinenAfterMendingMainVO) valueObject).getIssueOfLinenVO(), request);
		
			((AppVO)dto.getObject()).setFunctionId(((IssueLinenAfterMendingVO)valueObject).getFunctionId());
			((AppVO)dto.getObject()).setModuleId(((IssueLinenAfterMendingVO)valueObject).getModuleId());
			 
		dto.setObject(valueObject);
		dto.setMode(Constants.CREATE);
		dto.setTarget("issueoflinenAfterMending");
		return dto;
	
	}


	protected DTO doActionCreate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {
			DTO dto = null;
			valueObject = setDefaultSet((AppVO) valueObject, request);
			IssueLinenAfterMendingVO issueLinenAfterMendingVO = (IssueLinenAfterMendingVO) setDefaultSet(((IssueLinenAfterMendingMainVO) valueObject).getIssueOfLinenVO(), request);
				try {
					dto = ((AppDelegator) getDelegator()).createTypeMaster(issueLinenAfterMendingVO);
					dto.setStatus(Constants.SUCCESS);
					dto.setMessageId(Constants.OPERATION_SUCCESS);
				} catch (Exception e) 
					{
					e.printStackTrace();
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

	protected DTO doActionUpdate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {

		valueObject = setDefaultSet((AppVO) valueObject, request);
		IssueLinenAfterMendingMainVO issueLinenAfterMendingMainVO=((IssueLinenAfterMendingMainVO) valueObject);
		DTO dto = ((AppDelegator) getDelegator())
				.updateTypeMaster(issueLinenAfterMendingMainVO);
		
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
		setDefaultSet((AppVO) valueObject, request);
		if (((IssueLinenAfterMendingMainVO) valueObject).getCheckView() == null
				|| ((IssueLinenAfterMendingMainVO) valueObject).getCheckView()
						.equals("")) {
			queryCriteriaVO.setFunctionId("ALL_LC_SEND_REQ_FOR_MENDING");
			queryCriteriaVO.setModuleId(AppConstants.LINEN);

			criteriaForm.setVo(queryCriteriaVO);
			request.setAttribute("QueryCriteriaForm", criteriaForm);
			dto.setTarget("issueOfLinenAfterMendingCriteriaPage");
		} else {
			QueryResultVO qryResultVO = new QueryResultVO();
			IBALogger.getLogger().debug(
					this.getClass(),
					"getRequestStatus:"
							+ ((IssueLinenAfterMendingMainVO) valueObject)
									.getIssueOfLinenVO().getRequestStatus()
									.trim(), null);
			if (((IssueLinenAfterMendingMainVO) valueObject)
					.getIssueOfLinenVO().getRequestStatus().trim()
					.equalsIgnoreCase("OS")
					|| ((IssueLinenAfterMendingMainVO) valueObject)
							.getIssueOfLinenVO().getRequestStatus().trim()
							.equalsIgnoreCase("CN")) {
				qryResultVO.setFunctionId("mending");
			} else {
				qryResultVO.setFunctionId("requestForMending");
			}
			qryResultVO.setModuleId(AppConstants.LINEN);
			QueryCriteriaVO criteriaVo = new QueryCriteriaVO();
			QueryCriteriaItem criteriaItemLinenItem = new QueryCriteriaItem();
			QueryCriteriaItem criteriaItemRequestNum = new QueryCriteriaItem(); 
			QueryCriteriaItem criteriaItemFacilityId = new QueryCriteriaItem();

			criteriaItemLinenItem
					.setItemValue(((IssueLinenAfterMendingMainVO) valueObject)
							.getIssueOfLinenVO().getLinenItem().trim());
			criteriaItemLinenItem.setProperty("linenItem");
			IBALogger.getLogger().debug(this.getClass(),"requestNo:----->"+((IssueLinenAfterMendingMainVO) valueObject)
					.getIssueOfLinenVO().getRequestNum(), null);
			criteriaItemRequestNum
					.setItemValue(((IssueLinenAfterMendingMainVO) valueObject)
							.getIssueOfLinenVO().getRequestNum());
			criteriaItemRequestNum.setProperty("requestNo");
			try {
				criteriaItemFacilityId
						.setItemValue(((IssueLinenAfterMendingMainVO) valueObject)
								.getIssueOfLinenVO().getAddedFacilityId().trim());
				criteriaItemFacilityId.setProperty("operatingFacilityId");
			} catch (Exception e) {e.printStackTrace();
			}

			criteriaVo.getCriteriaItems().add(criteriaItemLinenItem);
			criteriaVo.getCriteriaItems().add(criteriaItemRequestNum);
			criteriaVo.getCriteriaItems().add(criteriaItemFacilityId);

			qryResultVO.setCriteriaVo(criteriaVo);
			Page page = new Page();
			page.setPagingEnabled(false);
			qryResultVO.setPage(page);

			try {
				dto = ((AppDelegator) getDelegator())
						.queryTypeMaster(qryResultVO);
			} catch (ApplicationException e) {
				e.printStackTrace();
			}

			if (((IssueLinenAfterMendingMainVO) valueObject).getCheckView()
					.equals("view")) {
				dto.setTarget("issueViewRequest");
			} else {
				// AutoGenerationList autoGenerationList = new
				// AutoGenerationList(RequestsListVO.class).addAll((List)
				// dto.getObject());
				// ((IssueOfLinenMainVO)valueObject).getRequestsListVO().setLinenIssue(autoGenerationList);
			//	dto.setObject(valueObject);
				dto.setTarget("issueRequest");
			}

		}
		return dto;
	}

	
	public Object getIssueNo(String facilityId,String requestNum,HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Page page = new Page();
		page.setPagingEnabled(false);
		Map lookupParams = new HashMap();
		lookupParams.put("facilityId", facilityId); 
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.issueLinenAfterMending.getReceiptNo");
		
		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		

		return reqNoMap; 
	}
	public Object getSumIssuedQty(String facilityId, String requestNum, 
			HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Page page = new Page();
		page.setPagingEnabled(false);
		Map lookupParams = new HashMap();
		lookupParams.put("facilityId", facilityId);
		lookupParams.put("requestNum", requestNum);
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo
				.setQueryId("ehis.lc.issueOfLinenAfterMending.getSumOfRequestQty");
		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject()).getLookupResults();
		return reqNoMap;
	}

	public Object getSumReceivedQty(String facilityId,String requestNum, HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Page page = new Page();
		page.setPagingEnabled(false);
		Map lookupParams = new HashMap();
		lookupParams.put("facilityId", facilityId); 
		lookupParams.put("requestNum", requestNum);
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.issueOfLinenAfterMending.getSumOfReceivedQty");
		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject()).getLookupResults();
		return reqNoMap;
	}
	public Object getReceivedQty(String facilityId,String requestNum,String linenItem, HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Page page = new Page();
		page.setPagingEnabled(false);
		Map lookupParams = new HashMap();
		IBALogger.getLogger().debug(this.getClass(),"facilityId:---------->"+facilityId, null);
		IBALogger.getLogger().debug(this.getClass(),"requestNum:---------->"+requestNum, null);
		IBALogger.getLogger().debug(this.getClass(),"linenItem:---------->"+linenItem, null);
		lookupParams.put("facilityId", facilityId);
		lookupParams.put("requestNum", requestNum);
		lookupParams.put("linenItem", linenItem); 
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.issueOfLinenAfterMending.getReceivedQty");
		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId().toString());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject()).getLookupResults();
		return reqNoMap;
	}

	
	
}
