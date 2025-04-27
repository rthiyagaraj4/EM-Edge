/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.requestForLinen.pojo.web;


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
import com.iba.ehis.lc.requestForLinen.vo.PlaceLinenRequestVO;
import com.iba.ehis.lc.requestForLinen.vo.RequestForLinenMainVO;
import com.iba.ehis.lc.requestForLinen.vo.RequestsListVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.Page;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.lookup.pojo.business.LookupDelegate;
import com.iba.framework.lookup.vo.LookupVO;

public class RequestForLinenAction extends LcAction {

	protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request,
			HttpServletResponse response) throws ApplicationException {
		DTO dto = new DTO();
		String target = null;
		(IBALogger.getLogger()).debug(this.getClass(),
				"RequestForLinen---viewcode---->"
						+ ((RequestForLinenMainVO) valueObject).getViewCode(),
				"");
		if (((RequestForLinenMainVO) valueObject).getViewCode().equals(
				LcConstants.PLACE_LINEN_REQUEST_TAB)) {
			target = "placeLinenRequest";

			if (((RequestForLinenMainVO) valueObject).getPlaceLinenRequestVO()
					.getRequestNum() == null) {
				((RequestForLinenMainVO) valueObject)
						.setMode(AppConstants.CREATE);

			} else {
				PlaceLinenRequestVO placeLinenRequestVO = (PlaceLinenRequestVO) (((AppDelegator) getDelegator())
						.getTypeMaster(((RequestForLinenMainVO) valueObject)
								.getPlaceLinenRequestVO())).getObject();
				((RequestForLinenMainVO) valueObject)
						.setPlaceLinenRequestVO(placeLinenRequestVO);
				((RequestForLinenMainVO) valueObject)
						.setMode(AppConstants.UPDATE);

			}
			((RequestForLinenMainVO) valueObject)
					.setPlaceLinenRequestVO(prePopulatePlaceLinenRequestTab(
							((RequestForLinenMainVO) valueObject)
									.getPlaceLinenRequestVO(), request));

		} else if (((RequestForLinenMainVO) valueObject).getViewCode().equals(
				LcConstants.REQUESTS_LIST_TAB)) {

			((RequestForLinenMainVO) valueObject)
					.setRequestsListVO(prePopulaterequestsList(
							((RequestForLinenMainVO) valueObject)
									.getRequestsListVO(), request));
			target = "requestsList";
			if (((RequestForLinenMainVO) valueObject).getPlaceLinenRequestVO()
					.getRequestNum() != null) {
				((RequestForLinenMainVO) valueObject).getRequestsListVO()
						.setSourceCode(
								((RequestForLinenMainVO) valueObject)
										.getRequestsListVO().getSourceCode());
			}
		}

		dto.setTarget(target);
		dto.setObject((RequestForLinenMainVO) valueObject);
		return dto;
	}

	private RequestsListVO prePopulaterequestsList(
			RequestsListVO requestsListVO, HttpServletRequest request) {
		LookupVO lookUpVo = new LookupVO();
		requestsListVO = (RequestsListVO) setDefaultSet(requestsListVO, request);
		requestsListVO.setRaisedBy(((AppVO) requestsListVO).getAddedById());
		return requestsListVO;
	}

	private PlaceLinenRequestVO prePopulatePlaceLinenRequestTab(
			PlaceLinenRequestVO placeLinenRequestVO, HttpServletRequest request) {
		LookupVO lookUpVo = new LookupVO();
		placeLinenRequestVO = (PlaceLinenRequestVO) setDefaultSet(
				placeLinenRequestVO, request);

		return placeLinenRequestVO;
	}

	protected DTO doActionCreate(BaseVO valueObject,
			HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException {
		DTO dto = null;
		if (((RequestForLinenMainVO) valueObject).getViewCode().equals(
				LcConstants.PLACE_LINEN_REQUEST_TAB)) {
			PlaceLinenRequestVO placeLinenRequestVO = (PlaceLinenRequestVO) setDefaultSet(
					((RequestForLinenMainVO) valueObject)
							.getPlaceLinenRequestVO(), request);
			try {
				dto = ((AppDelegator) getDelegator())
						.createTypeMaster(placeLinenRequestVO);
			} catch (Exception e) {
				dto.setStatus(Constants.FAILED);
			}

		} else {

			RequestsListVO requestsListVO = (RequestsListVO) setDefaultSet(
					((RequestForLinenMainVO) valueObject).getRequestsListVO(),
					request);
			try {
				dto = ((AppDelegator) getDelegator())
						.createTypeMaster(requestsListVO);
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
		RequestForLinenMainVO requestForLinenMainVO = ((RequestForLinenMainVO) valueObject);
		DTO dto = ((AppDelegator) getDelegator())
				.updateTypeMaster(requestForLinenMainVO);

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
		if (((RequestForLinenMainVO) valueObject).getCheckView() == null
				|| ((RequestForLinenMainVO) valueObject).getCheckView().equals(
						"")) {
			queryCriteriaVO.setPageAction("RequestForLinenPageAction");
			queryCriteriaVO
					.setQueryResultPage("RequestForLinenQueryResultPage");
			queryCriteriaVO
					.setFunctionId(((AppVO) valueObject).getFunctionId());
			queryCriteriaVO.setModuleId(AppConstants.LINEN);
			criteriaForm.setVo(queryCriteriaVO);
			request.setAttribute("QueryCriteriaForm", criteriaForm);
			dto.setTarget("requestForLinenCriteriaPage");
		} else {
			QueryResultVO qryResultVO = new QueryResultVO();
			IBALogger.getLogger().debug(this.getClass(), "getRequestStatus:"+((RequestForLinenMainVO)valueObject).getPlaceLinenRequestVO().getRequestStatus().trim(), null);
			if(((RequestForLinenMainVO)valueObject).getPlaceLinenRequestVO().getRequestStatus().trim().equalsIgnoreCase("OS")||((RequestForLinenMainVO)valueObject).getPlaceLinenRequestVO().getRequestStatus().trim().equalsIgnoreCase("CN"))
			{
				qryResultVO.setFunctionId("request");
			}
			else
			{
				qryResultVO.setFunctionId("requestForLinen");
			}
			qryResultVO.setModuleId(AppConstants.LINEN);
			QueryCriteriaVO criteriaVo = new QueryCriteriaVO();
			criteriaVo.setPageAction("RequestForLinenViewPageAction");
			QueryCriteriaItem linenItemCriteriaIetm = new QueryCriteriaItem();
			QueryCriteriaItem requestNumCriteriaIetm = new QueryCriteriaItem();
			QueryCriteriaItem operFacilityIdCriteriaIetm = new QueryCriteriaItem();
			
			linenItemCriteriaIetm.setItemValue(((RequestForLinenMainVO) valueObject).getPlaceLinenRequestVO().getLinenItem().trim());
			linenItemCriteriaIetm.setProperty("linenItem");
			
			requestNumCriteriaIetm.setItemValue(((RequestForLinenMainVO) valueObject).getPlaceLinenRequestVO().getRequestNum().trim());
			requestNumCriteriaIetm.setProperty("requestNo");
			try{
			operFacilityIdCriteriaIetm.setItemValue(((RequestForLinenMainVO) valueObject).getPlaceLinenRequestVO().getAddedFacilityId());
			operFacilityIdCriteriaIetm.setProperty("operatingfacilityId");
			}catch(Exception e){}
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
			dto.setTarget("viewRequest");
		}
		return dto;
	}
	public Object getReqNo(HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Map lookupParams = new HashMap();
		Page page = new Page();
		page.setPagingEnabled(false);
		lookUpVo.setQueryId("ehis.lc.requestForLinen.getReqNo");

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		

		return reqNoMap;
	}
	
	public Object getStock(String sourceType,String sourceCode,String linenItem,String facilityId,HttpServletRequest request) {
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
		lookUpVo.setQueryId("ehis.lc.stockLookup");

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		

		return reqNoMap;
	}
	public Object getStockParam(String facilityId,HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Map lookupParams = new HashMap();
		lookupParams.put("facilityId", facilityId);
		Page page = new Page();
		page.setPagingEnabled(false);
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.getstdStockChk");

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		

		return reqNoMap;
	}
	public Object getInUseQtyLookup(String sourceType,String sourceCode,String linenItem,String facilityId,HttpServletRequest request) {
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
		
}
