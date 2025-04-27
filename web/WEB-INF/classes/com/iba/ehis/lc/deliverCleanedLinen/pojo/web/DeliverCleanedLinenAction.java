/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.deliverCleanedLinen.pojo.web;

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
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryCriteriaItem;
import com.iba.ehis.core.vo.QueryCriteriaVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.deliverCleanedLinen.vo.DeliverCleanedLinenMainVO;
import com.iba.ehis.lc.deliverCleanedLinen.vo.DeliverCleanedLinenVO;
import com.iba.ehis.lc.issueOfLinen.vo.IssueOfLinenMainVO;
import com.iba.ehis.lc.requestForCleaningLinen.vo.RequestForCleaningLinenMainVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.Page;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.lookup.pojo.business.LookupDelegate;
import com.iba.framework.lookup.vo.LookupVO;

public class DeliverCleanedLinenAction extends LcAction {

	protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)throws ApplicationException {
		DTO dto = new DTO();
		setDefaultSet(((DeliverCleanedLinenMainVO) valueObject).getDeliverCleanedLinenVO(), request);
		
		//	((AppVO)dto.getObject()).setFunctionId(((DeliverCleanedLinenMainVO)valueObject).getFunctionId());
		//	((AppVO)dto.getObject()).setModuleId(((DeliverCleanedLinenMainVO)valueObject).getModuleId());
			 
		dto.setObject(valueObject);
		dto.setMode(Constants.CREATE);
			dto.setTarget("deliverCleanedLinen");
		return dto;
	
	}

	protected DTO doActionCreate(BaseVO valueObject,
				HttpServletRequest request, HttpServletResponse response)
				throws ApplicationException {
			DTO dto = null;
			DeliverCleanedLinenVO deliverCleanedLinenVO = (DeliverCleanedLinenVO) setDefaultSet(((DeliverCleanedLinenMainVO) valueObject).getDeliverCleanedLinenVO(), request);
					try {
						dto = ((AppDelegator) getDelegator()).createTypeMaster(deliverCleanedLinenVO);
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
			DeliverCleanedLinenMainVO deliverCleanedLinenMainVO=((DeliverCleanedLinenMainVO) valueObject);
			DTO dto = ((AppDelegator) getDelegator())
					.updateTypeMaster(deliverCleanedLinenMainVO);
			
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
				
		if (((DeliverCleanedLinenMainVO) valueObject).getCheckView() == null || ((DeliverCleanedLinenMainVO) valueObject).getCheckView().equals(
						"")) {
			queryCriteriaVO.setPageAction("DeliverCleanedLinenPageAction");
			queryCriteriaVO
					.setQueryResultPage("DeliverCleanedLinenQueryResultPage");
			queryCriteriaVO
					.setFunctionId("LC_REQ_FOR_CLEANING_LINEN");
			queryCriteriaVO.setModuleId(AppConstants.LINEN);
			criteriaForm.setVo(queryCriteriaVO);
			request.setAttribute("QueryCriteriaForm", criteriaForm);
			dto.setTarget("deliverCleanedLinenCriteriaPage");
			}
		else 
			{
			QueryResultVO qryResultVO = new QueryResultVO();
			IBALogger.getLogger().debug(this.getClass(), "getRequestStatus:"+((DeliverCleanedLinenMainVO) valueObject)
					.getDeliverCleanedLinenVO().getRequestStatus().trim(), null);
			if(((DeliverCleanedLinenMainVO) valueObject)
					.getDeliverCleanedLinenVO().getRequestStatus().trim().equalsIgnoreCase("OS")||((DeliverCleanedLinenMainVO) valueObject)
					.getDeliverCleanedLinenVO().getRequestStatus().trim().equalsIgnoreCase("CN"))
			{
				IBALogger.getLogger().debug(this.getClass(),"Inside:----functionId---->cleaningLinen",null);
				qryResultVO.setFunctionId("cleaningLinen");
				queryCriteriaVO.setFunctionId("cleaningLinen");
				
			}
			else
			{
			IBALogger.getLogger().debug(this.getClass(),"Inside:----functionId---->deliverCleaningLinen",null);
			qryResultVO.setFunctionId("deliverCleaningLinen");
			((AppVO) valueObject).setFunctionId("deliverCleaningLinen");
			}
			
			
			qryResultVO.setModuleId(AppConstants.LINEN);
			QueryCriteriaVO criteriaVo = new QueryCriteriaVO();
			criteriaVo.setPageAction("DeliverCleanedLinenViewPageAction");
		
			QueryCriteriaItem criteriaItemLinenItem = new QueryCriteriaItem();
			QueryCriteriaItem criteriaItemRequestNum = new QueryCriteriaItem();
			QueryCriteriaItem criteriaItemFacilityId = new QueryCriteriaItem();
			try{		
			criteriaItemLinenItem.setItemValue(((DeliverCleanedLinenMainVO) valueObject)
					.getDeliverCleanedLinenVO().getLinenItem().trim());
			criteriaItemLinenItem.setProperty("linenItem");
			
			criteriaItemRequestNum.setItemValue(((DeliverCleanedLinenMainVO) valueObject)
					.getDeliverCleanedLinenVO().getRequestNum().trim());
			criteriaItemRequestNum.setProperty("requestNo");
			
			criteriaItemFacilityId.setItemValue(((AppVO) valueObject).getAddedFacilityId().trim());
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
			if(((DeliverCleanedLinenMainVO)valueObject).getCheckView().equals("deliver"))
			{
				dto.setTarget("deliverViewRequest");
								
			}
			else
			{
				dto.setObject(valueObject);
				dto.setTarget("deliverRequest");
			}
		}
		return dto;
	}
	public Object getLateDeliveryReason(String language_Id,HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Page page = new Page();
		page.setPagingEnabled(false);
		Map lookupParams = new HashMap();
		lookupParams.put("language_Id", language_Id); 
		lookUpVo.setQueryId("ehis.lc.lateDeliverylookup");

		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reasonMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		return reasonMap;
	} 
	public Object getDeliveryNo(String facilityId,String requestNum,HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Page page = new Page();
		page.setPagingEnabled(false);
		Map lookupParams = new HashMap();
		lookupParams.put("facilityId", facilityId); 
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.deliverCleanedLinen.getDeliveryRefNo");
		
		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		

		return reqNoMap; 
	}
	public Object getSumdeliveredQty(String facilityId,String requestNum,HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Page page = new Page();
		page.setPagingEnabled(false); 
		Map lookupParams = new HashMap();
		lookupParams.put("facilityId", facilityId);
		lookupParams.put("requestNum", requestNum);
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.deliverCleanedLinen.getSumOfDeliveredQty");
		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		return reqNoMap;
	}
	public Object getSumRequestedQty(String facilityId,String requestNum,HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Page page = new Page();
		page.setPagingEnabled(false);
		Map lookupParams = new HashMap();
		lookupParams.put("facilityId", facilityId);
		lookupParams.put("requestNum", requestNum);
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.deliverCleanedLinen.getSumOfRequestQty");
		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map reqNoMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		return reqNoMap;
	}
	public Map getDeliveredQty(String litem,String rno,String facilityId,HttpServletRequest request)
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
		lookUpVo.setQueryId("ehis.lc.deliverCleanedLinen.getDeliveredQty");

		 dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map lcUserMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		

		return lcUserMap;
	}
	public Object getScheduleDate(String facilityId,String requestNum,String category,String linenItem,HttpServletRequest request) {
		LookupDelegate lookupDelegate = ((LookupDelegate) getDelegatorById("lookupDelegator"));
		LookupVO lookUpVo = new LookupVO();
		Page page = new Page();
		page.setPagingEnabled(false);
		Map lookupParams = new HashMap();
		lookupParams.put("facilityId", facilityId);
		lookupParams.put("requestNum", requestNum);
		lookupParams.put("category", category);
		lookupParams.put("linenItem", linenItem);
		lookUpVo.setLookupParameters(lookupParams);
		lookUpVo.setQueryId("ehis.lc.deliverCleanedLinen.getScheduleDate");
		DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request
				.getSession().getId());
		Map dateMap = (Map) ((LookupVO) dto.getObject())
				.getLookupResults();
		return dateMap;
	}
}
