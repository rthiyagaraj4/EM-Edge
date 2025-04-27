/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.requestForCleaningLinen.pojo.web;

import java.util.HashMap;
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
import com.iba.ehis.lc.core.util.LcConstants;
import com.iba.ehis.lc.core.util.LcDateFormat;
import com.iba.ehis.lc.requestForCleaningLinen.vo.PendingCountConfirmVO;
import com.iba.ehis.lc.requestForCleaningLinen.vo.RequestForCleaningLinenMainVO;
import com.iba.ehis.lc.requestForCleaningLinen.vo.PlaceCleaningLinenRequestVO;
import com.iba.ehis.lc.requestForCleaningLinen.vo.CleaningRequestsListVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.Page;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.lookup.pojo.business.LookupDelegate;
import com.iba.framework.lookup.vo.LookupVO;

public class RequestForCleaningLinenAction extends LcAction {

	protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request,
			HttpServletResponse response) throws ApplicationException {
		DTO dto = new DTO();
		String target = null;
		(IBALogger.getLogger()).debug(this.getClass(),
				"RequestForCleaningLinen---viewcode---->"
						+ ((RequestForCleaningLinenMainVO) valueObject).getViewCode(),
				"");
		if (((RequestForCleaningLinenMainVO) valueObject).getViewCode().equals(
				LcConstants.PLACE_CLEANING_LINEN_REQUEST_TAB)) {
			target = "placeCleaningLinenRequest";

			if (((RequestForCleaningLinenMainVO) valueObject).getPlaceCleaningLinenRequestVO()
					.getRequestNum() == null) {
				((RequestForCleaningLinenMainVO) valueObject)
						.setMode(AppConstants.CREATE);

			} else {
				PlaceCleaningLinenRequestVO placeLinenRequestVO = (PlaceCleaningLinenRequestVO) (((AppDelegator) getDelegator())
						.getTypeMaster(((RequestForCleaningLinenMainVO) valueObject)
								.getPlaceCleaningLinenRequestVO())).getObject();
				((RequestForCleaningLinenMainVO) valueObject)
						.setPlaceCleaningLinenRequestVO(placeLinenRequestVO);
				((RequestForCleaningLinenMainVO) valueObject)
						.setMode(AppConstants.UPDATE);

			}
			((RequestForCleaningLinenMainVO) valueObject)
					.setPlaceCleaningLinenRequestVO(prePopulatePlaceLinenRequestTab(
							((RequestForCleaningLinenMainVO) valueObject)
									.getPlaceCleaningLinenRequestVO(), request));

		} else if (((RequestForCleaningLinenMainVO) valueObject).getViewCode().equals(
				LcConstants.CLEANING_REQUESTS_LIST_TAB)) {

			((RequestForCleaningLinenMainVO) valueObject)
					.setCleaningRequestsListVO(prePopulateCleaningRequestsList(
							((RequestForCleaningLinenMainVO) valueObject)
									.getCleaningRequestsListVO(), request));
			target = "cleaningRequestsList";
			if (((RequestForCleaningLinenMainVO) valueObject).getCleaningRequestsListVO()
					.getRequestNo() != null) {
				((RequestForCleaningLinenMainVO) valueObject).getCleaningRequestsListVO()
						.setSourceCode(
								((RequestForCleaningLinenMainVO) valueObject)
										.getCleaningRequestsListVO().getSourceCode());
			}
		}
		else if (((RequestForCleaningLinenMainVO) valueObject).getViewCode().equals(
				LcConstants.PENDING_COUNT_TAB)) {

			((RequestForCleaningLinenMainVO) valueObject)
					.setPendingCountConfirmVO(prePopulatePendingCountConfirmTab(
							((RequestForCleaningLinenMainVO) valueObject)
									.getPendingCountConfirmVO(), request));
			target = "pendingCountConfirm";
			if (((RequestForCleaningLinenMainVO) valueObject).getPendingCountConfirmVO()
					.getSourceCode() != null) {
				((RequestForCleaningLinenMainVO) valueObject).getPendingCountConfirmVO()
						.setSourceCode(
								((RequestForCleaningLinenMainVO) valueObject)
										.getPendingCountConfirmVO().getSourceCode());
			}
		}

		dto.setTarget(target);
		dto.setObject((RequestForCleaningLinenMainVO) valueObject);
		return dto;
	}

	private CleaningRequestsListVO prePopulateCleaningRequestsList(
			CleaningRequestsListVO cleaningRequestsListVO, HttpServletRequest request) {
		LookupVO lookUpVo = new LookupVO();
		cleaningRequestsListVO = (CleaningRequestsListVO) setDefaultSet(cleaningRequestsListVO, request);
		cleaningRequestsListVO.setLinenCollectedBy(((AppVO) cleaningRequestsListVO).getAddedById());
		
		return cleaningRequestsListVO;
	}

	private PlaceCleaningLinenRequestVO prePopulatePlaceLinenRequestTab(
			PlaceCleaningLinenRequestVO placeLinenCleaningRequestVO, HttpServletRequest request) {
		LookupVO lookUpVo = new LookupVO();
		placeLinenCleaningRequestVO = (PlaceCleaningLinenRequestVO) setDefaultSet(
				placeLinenCleaningRequestVO, request);
		placeLinenCleaningRequestVO.setRequestDate(LcDateFormat.convertDateFormat(null, request));

		return placeLinenCleaningRequestVO;
	}
	
	private PendingCountConfirmVO prePopulatePendingCountConfirmTab(
			PendingCountConfirmVO pendingCountConfirmVO, HttpServletRequest request) {
		LookupVO lookUpVo = new LookupVO();
		pendingCountConfirmVO = (PendingCountConfirmVO) setDefaultSet(pendingCountConfirmVO, request);

		return pendingCountConfirmVO;
	}

	protected DTO doActionCreate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {
		DTO dto = null;
		(IBALogger.getLogger()).debug(this.getClass(),
				"RequestForCleaningLinen---viewcode---->"
						+ ((RequestForCleaningLinenMainVO) valueObject).getViewCode(),
				"");
		if (((RequestForCleaningLinenMainVO) valueObject).getViewCode().equals(
				LcConstants.PLACE_CLEANING_LINEN_REQUEST_TAB)) {
			RequestForCleaningLinenMainVO requestForCleaningLinenMainVO =  (RequestForCleaningLinenMainVO)setDefaultSet(
					((RequestForCleaningLinenMainVO) valueObject), request);			
			try {
				dto = ((AppDelegator) getDelegator())
						.createTypeMaster(requestForCleaningLinenMainVO);
				dto.setObject((AppVO)valueObject);
			} catch (Exception e) {
				dto.setStatus(Constants.FAILED);
			}

		}
		else if(((RequestForCleaningLinenMainVO) valueObject).getViewCode().equals(
				LcConstants.PENDING_COUNT_TAB)) {

			PendingCountConfirmVO pendingCountConfirmVO = (PendingCountConfirmVO) setDefaultSet(
					((RequestForCleaningLinenMainVO) valueObject).getPendingCountConfirmVO(),
					request);
			try {
				dto = ((AppDelegator) getDelegator())
						.createTypeMaster(pendingCountConfirmVO);
				dto.setObject((AppVO)valueObject);
			} catch (Exception e) {
				dto.setStatus(Constants.FAILED);
			}

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
		RequestForCleaningLinenMainVO requestForLinenMainVO = ((RequestForCleaningLinenMainVO) valueObject);
		DTO dto = ((AppDelegator) getDelegator())
				.updateTypeMaster(requestForLinenMainVO);
		dto.setObject((AppVO)valueObject);
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
		valueObject = setDefaultSet((AppVO) valueObject, request);
		
		if (((RequestForCleaningLinenMainVO) valueObject).getCheckView() == null
				|| ((RequestForCleaningLinenMainVO) valueObject).getCheckView().equals(
						"")) {
			queryCriteriaVO.setPageAction("RequestForCleaningLinenPageAction");
			queryCriteriaVO
					.setQueryResultPage("RequestForCleaningLinenQueryResultPage");
			queryCriteriaVO
					.setFunctionId("LC_REQ_FOR_CLEANING_LINEN");
			queryCriteriaVO.setModuleId(AppConstants.LINEN);
			criteriaForm.setVo(queryCriteriaVO);
			request.setAttribute("QueryCriteriaForm", criteriaForm);
			dto.setTarget("requestForCleaningLinenCriteriaPage");
			
		}else if (((RequestForCleaningLinenMainVO) valueObject).getCheckView() =="pendingCount" 	|| ((RequestForCleaningLinenMainVO) valueObject).getCheckView().equals(
		"pendingCount")) 
		{
			
		QueryCriteriaItem criteriaItemCategory = new QueryCriteriaItem();
		criteriaItemCategory.setItemValue("D");
		criteriaItemCategory.setProperty("category");
		queryCriteriaVO.getCriteriaItems().add(criteriaItemCategory);
		queryCriteriaVO.setPageAction("PendingCountPageAction");
		queryCriteriaVO.setQueryResultPage("PendingCountQueryResultPage");
		queryCriteriaVO.setFunctionId("LC_REQ_FOR_CLEANING_LINEN");
		queryCriteriaVO.setModuleId(AppConstants.LINEN);
		criteriaForm.setVo(queryCriteriaVO);
		request.setAttribute("QueryCriteriaForm", criteriaForm);
		dto.setTarget("pendingCountCriteriaPage");
	
		}
		else 
			{
			QueryResultVO qryResultVO = new QueryResultVO();
			IBALogger.getLogger().debug(this.getClass(), "getRequestStatus:"+((RequestForCleaningLinenMainVO) valueObject)
					.getPlaceCleaningLinenRequestVO().getRequestStatus().trim(), null);
			if(((RequestForCleaningLinenMainVO) valueObject)
					.getPlaceCleaningLinenRequestVO().getRequestStatus().trim().equalsIgnoreCase("OS")||((RequestForCleaningLinenMainVO) valueObject)
					.getPlaceCleaningLinenRequestVO().getRequestStatus().trim().equalsIgnoreCase("CN"))
			{
				qryResultVO.setFunctionId("cleaningLinen");
				((AppVO) valueObject).setFunctionId("cleaningLinen");
			}
			else
			{
			qryResultVO.setFunctionId("requestForCleaningLinen");
			((AppVO) valueObject).setFunctionId("requestForCleaningLinen");
			}
						
			qryResultVO.setModuleId(AppConstants.LINEN);
			QueryCriteriaVO criteriaVo = new QueryCriteriaVO();
			criteriaVo.setPageAction("RequestForCleaningLinenViewPageAction");
			
			QueryCriteriaItem criteriaItemLinenItem = new QueryCriteriaItem();
			QueryCriteriaItem criteriaItemRequestNum = new QueryCriteriaItem();
			QueryCriteriaItem criteriaItemFacilityId = new QueryCriteriaItem();
			try{		
			criteriaItemLinenItem.setItemValue(((RequestForCleaningLinenMainVO) valueObject)
					.getPlaceCleaningLinenRequestVO().getLinenItem().trim());
			criteriaItemLinenItem.setProperty("linenItem");
			
			criteriaItemRequestNum.setItemValue(((RequestForCleaningLinenMainVO) valueObject)
					.getPlaceCleaningLinenRequestVO().getRequestNum().trim());
			criteriaItemRequestNum.setProperty("requestNo");
			
			criteriaItemFacilityId.setItemValue(((RequestForCleaningLinenMainVO) valueObject)
					.getPlaceCleaningLinenRequestVO().getAddedFacilityId().trim());
			criteriaItemFacilityId.setProperty("operatingFacilityId");
			}catch(Exception e){}
			
			criteriaVo.getCriteriaItems().add(criteriaItemLinenItem);
			criteriaVo.getCriteriaItems().add(criteriaItemRequestNum); 
			criteriaVo.getCriteriaItems().add(criteriaItemFacilityId); 
						
			qryResultVO.setCriteriaVo(criteriaVo);
			Page page = new Page();
			page.setPagingEnabled(false);
			qryResultVO.setPage(page);
			request.setAttribute("QueryCriteriaForm", criteriaForm);
			
			try {
				dto = ((AppDelegator) getDelegator())
						.queryTypeMaster(qryResultVO);
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
			dto.setTarget("ViewCleaningRequest");
		}
		return dto;
	}
	
	public Object getReqNo(String facilityId,HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Page page = new Page();
		page.setPagingEnabled(false);
		Map lookupParams = new HashMap();
		lookupParams.put("facility",facilityId);
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.requestForCleaningLinen.getReqNo");

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		return reqNoMap;
	}
	
	public Map getLcUser(String facilityId,String user,HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Map lookupParams = new HashMap();
		lookupParams.put("facility",facilityId);
		lookupParams.put("laundryUserId",user);
		Page page = new Page();
		page.setPagingEnabled(false);
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.getLcUser");

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map lcUserMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		return lcUserMap;
	}
	
	public Object getLinenReqNo(String facilityId,HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Map lookupParams = new HashMap();
		lookupParams.put("facilityId", facilityId);
		Page page = new Page();
		page.setPagingEnabled(false);
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.requestForLinen.getReqNo");

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		return reqNoMap;
	}
	
	public Map getIssueDetail(String litem,String rno,String facilityId,HttpServletRequest request,HttpServletResponse reaponse)
	{
		DTO dto=new DTO(); 
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Map lookupParams = new HashMap();
		lookupParams.put("linenItem",litem);
		lookupParams.put("requestNo",rno);
		lookupParams.put("facilityId",facilityId);
		Page page = new Page();
		page.setPagingEnabled(false);
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.issueOfLinen.getIssueQty");

		 dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map lcUserMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		

		return lcUserMap;
	}
	
	public Map getStockParam(String facilityId,HttpServletRequest request,HttpServletResponse reaponse){
		
		DTO dto=new DTO(); 
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Map lookupParams = new HashMap();
		lookupParams.put("facilityId",facilityId);
		Page page = new Page();
		page.setPagingEnabled(false);
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.issueOfLinen.getStockParam");

		 dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map lcUserMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
	
		return lcUserMap;
	}
	
	public Map getScheduleDate(String facilityId,HttpServletRequest request,HttpServletResponse reaponse){
		DTO dto=new DTO(); 
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Map lookupParams = new HashMap();
		lookupParams.put("facilityId",facilityId);
		Page page = new Page();
		page.setPagingEnabled(false);
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.requestForCleaningLinen.getscheduleDate");

		 dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map lcUserMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		
 
		return lcUserMap;
	}

	public Object getOverRideWardConf(String facilityId, HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Page page = new Page();
		page.setPagingEnabled(false);
		Map lookupValues = new HashMap();
		lookupValues.put("facilityId", facilityId);
		lookUpVo.setLookupParameters(lookupValues);
		lookUpVo.setQueryId("ehis.lc.requestForCleaningLinen.getOverRideConf");

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		

		return reqNoMap;
	}
	
	public Object getDirtyLinenParam(String facilityId, HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Page page = new Page();
		page.setPagingEnabled(false);
		Map lookupValues = new HashMap();
		lookupValues.put("facilityId", facilityId);
		lookUpVo.setLookupParameters(lookupValues);
		lookUpVo.setQueryId("ehis.lc.requestForCleaningLinen.getDirtyLinenConf");

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		

		return reqNoMap;
	}
	
	public Map getLoggedInUser(String locale,String user,HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Map lookupParams = new HashMap();
		lookupParams.put("userId",user);
		lookupParams.put("language_Id",locale);
		Page page = new Page();
		page.setPagingEnabled(false);
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.getLoggedInUser");
		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
		Map lcUserMap = (Map) ((LookupVO) dto.getObject()).getLookupResults();
		return lcUserMap;
	}
	
	public Object getSumIssuedQty(String facilityId,String requestNum,HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Page page = new Page();
		page.setPagingEnabled(false); 
		Map lookupParams = new HashMap();
		lookupParams.put("facilityId", facilityId);
		lookupParams.put("requestNum", requestNum);
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.issueOfLinenAfterMending.getSumOfReceivedQty");
		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		return reqNoMap;
	}
	
	public Object getSrcStock(String sourceType,String sourceCode,String linenItem,String facilityId,HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Map lookupParams = new HashMap();
		lookupParams.put("facilityId", facilityId);
		lookupParams.put("sourceType", sourceType);
		lookupParams.put("sourceCode", sourceCode);
		lookupParams.put("linenItem", linenItem);
		Page page = new Page();
		page.setPagingEnabled(false);
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.inUseQtyLookup");

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		

		return reqNoMap;
	}
	public Object getDeltime(String facilityId,HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Map lookupParams = new HashMap();
		lookupParams.put("facilityId", facilityId);
		Page page = new Page();
		page.setPagingEnabled(false);
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.setUpparam.getAllTimes");

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		

		return reqNoMap;
	}
}
