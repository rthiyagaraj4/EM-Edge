/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.sendLinenForMending.pojo.web;

import com.iba.ehis.core.pojo.business.AppDelegator;
import com.iba.ehis.core.pojo.web.AppForm;
import com.iba.ehis.core.vo.*;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.sendLinenForMending.vo.*;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.*;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.logging.pojo.business.Logger;
import com.iba.framework.lookup.pojo.business.LookupDelegate;
import com.iba.framework.lookup.vo.LookupVO;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.*;

public class SendLinenForMendingAction extends LcAction
{

    public SendLinenForMendingAction()
    {
    }

    protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)
        throws ApplicationException
    {
        DTO dto = new DTO();
        String target = null;
        IBALogger.getLogger().debug(getClass(), "RequestForMendingLinen---viewcode---->" + ((SendLinenForMendingMainVO)valueObject).getViewCode(), "");
        if(((SendLinenForMendingMainVO)valueObject).getViewCode().equals("placeLinenRequestFrame"))
        {
            target = "placeLinenRequest";
            if(((SendLinenForMendingMainVO)valueObject).getPlaceLinenRequestVO().getRequestNum() == null)
            {
                ((SendLinenForMendingMainVO)valueObject).setMode(0);
            } else
            {
                PlaceLinenMendingRequestVO placeLinenRequestVO = (PlaceLinenMendingRequestVO)((AppDelegator)getDelegator()).getTypeMaster(((SendLinenForMendingMainVO)valueObject).getPlaceLinenRequestVO()).getObject();
                ((SendLinenForMendingMainVO)valueObject).setPlaceLinenRequestVO(placeLinenRequestVO);
                ((SendLinenForMendingMainVO)valueObject).setMode(2);
            }
            ((SendLinenForMendingMainVO)valueObject).setPlaceLinenRequestVO(prePopulatePlaceLinenRequestTab(((SendLinenForMendingMainVO)valueObject).getPlaceLinenRequestVO(), request));
        } else
        if(((SendLinenForMendingMainVO)valueObject).getViewCode().equals("requestsListFrame"))
        {
            ((SendLinenForMendingMainVO)valueObject).setRequestsListVO(prePopulaterequestsList(((SendLinenForMendingMainVO)valueObject).getRequestsListVO(), request));
            target = "requestsList";
            if(((SendLinenForMendingMainVO)valueObject).getPlaceLinenRequestVO().getRequestNum() != null)
                ((SendLinenForMendingMainVO)valueObject).getRequestsListVO().setSentBy(((SendLinenForMendingMainVO)valueObject).getRequestsListVO().getSentBy());
        }
        dto.setTarget(target);
        dto.setObject((SendLinenForMendingMainVO)valueObject);
        return dto;
    }

    private MendingListVO prePopulaterequestsList(MendingListVO requestsListVO, HttpServletRequest request)
    {
        LookupVO lookUpVo = new LookupVO();
        requestsListVO = (MendingListVO)setDefaultSet(requestsListVO, request);
        requestsListVO.setSentBy(requestsListVO.getAddedById());
        return requestsListVO;
    }

    private PlaceLinenMendingRequestVO prePopulatePlaceLinenRequestTab(PlaceLinenMendingRequestVO placeLinenRequestVO, HttpServletRequest request)
    {
        LookupVO lookUpVo = new LookupVO();
        placeLinenRequestVO = (PlaceLinenMendingRequestVO)setDefaultSet(placeLinenRequestVO, request);
        return placeLinenRequestVO;
    }

    protected DTO doActionCreate(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)
        throws ApplicationException
    {
        DTO dto = null;
        if(((SendLinenForMendingMainVO)valueObject).getViewCode().equals("placeLinenRequestFrame"))
        {
            PlaceLinenMendingRequestVO placeLinenRequestVO = (PlaceLinenMendingRequestVO)setDefaultSet(((SendLinenForMendingMainVO)valueObject).getPlaceLinenRequestVO(), request);
            try
            {
                dto = ((AppDelegator)getDelegator()).createTypeMaster(placeLinenRequestVO);
            }
            catch(Exception e)
            {
                dto.setStatus(500);
            }
        } else
        {
            MendingListVO requestsListVO = (MendingListVO)setDefaultSet(((SendLinenForMendingMainVO)valueObject).getRequestsListVO(), request);
            try
            {
                dto = ((AppDelegator)getDelegator()).createTypeMaster(requestsListVO);
            }
            catch(Exception e)
            {
                dto.setStatus(500);
            }
        }
        if(dto.getStatus() == 400)
        {
            dto.setTarget("successCUD");
            dto.setMessageId("MESSAGE.OPERATION_SUCCESS");
        } else
        if(dto.getStatus() == 500)
        {
            dto.setTarget("successCUD");
            dto.setMessageId("MESSAGE.OPERATION_FAILURE");
        }
        return dto;
    }

    protected DTO doActionUpdate(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)
        throws ApplicationException
    {
        valueObject = setDefaultSet((AppVO)valueObject, request);
        SendLinenForMendingMainVO requestForLinenMainVO = (SendLinenForMendingMainVO)valueObject;
        DTO dto = ((AppDelegator)getDelegator()).updateTypeMaster(requestForLinenMainVO);
        dto.setObject((AppVO)valueObject);
        if(dto.getStatus() == 400)
        {
            dto.setTarget("successCUD");
            dto.setMessageId("MESSAGE.OPERATION_SUCCESS");
        } else
        if(dto.getStatus() == 500)
        {
            dto.setTarget("successCUD");
            dto.setMessageId("MESSAGE.OPERATION_FAILURE");
        }
        return dto;
    }

    protected DTO doActionQuery(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)
        throws ApplicationException
    {
        AppForm criteriaForm = new AppForm();
        DTO dto = new DTO();
        QueryCriteriaVO queryCriteriaVO = new QueryCriteriaVO();
        setDefaultSet(queryCriteriaVO, request);
        if(((SendLinenForMendingMainVO)valueObject).getCheckView() == null || ((SendLinenForMendingMainVO)valueObject).getCheckView().equals(""))
        {
            queryCriteriaVO.setPageAction("SendLinenForMendingPageAction");
            queryCriteriaVO.setQueryResultPage("SendLinenForMendingQueryResultPage");
            queryCriteriaVO.setFunctionId("ALL_LC_SEND_REQ_FOR_MENDING");
            queryCriteriaVO.setModuleId("LC");
            criteriaForm.setVo(queryCriteriaVO);
            request.setAttribute("QueryCriteriaForm", criteriaForm);
            dto.setTarget("mendingRequestCriteriaPage");
        } else
        {
            QueryResultVO qryResultVO = new QueryResultVO();
            IBALogger.getLogger().debug(getClass(), "getRequestStatus:" + ((SendLinenForMendingMainVO)valueObject).getPlaceLinenRequestVO().getRequestStatus().trim(), null);
            if(((SendLinenForMendingMainVO)valueObject).getPlaceLinenRequestVO().getRequestStatus().trim().equalsIgnoreCase("OS") || ((SendLinenForMendingMainVO)valueObject).getPlaceLinenRequestVO().getRequestStatus().trim().equalsIgnoreCase("CN"))
                qryResultVO.setFunctionId("mending");
            else
                qryResultVO.setFunctionId("requestForMending");
            qryResultVO.setModuleId("LC");
            QueryCriteriaVO criteriaVo = new QueryCriteriaVO();
            criteriaVo.setPageAction("SendLinenForMendingViewPageAction");
            QueryCriteriaItem linenItemCriteriaIetm = new QueryCriteriaItem();
            QueryCriteriaItem requestNumCriteriaIetm = new QueryCriteriaItem();
            QueryCriteriaItem operFacilityIdCriteriaIetm = new QueryCriteriaItem();
            linenItemCriteriaIetm.setItemValue(((SendLinenForMendingMainVO)valueObject).getPlaceLinenRequestVO().getLinenItem().trim());
            linenItemCriteriaIetm.setProperty("linenItem");
            requestNumCriteriaIetm.setItemValue(((SendLinenForMendingMainVO)valueObject).getPlaceLinenRequestVO().getRequestNum().trim());
            requestNumCriteriaIetm.setProperty("requestNo");
            try
            {
                IBALogger.getLogger().debug(getClass(), "FacilityId:--" + ((SendLinenForMendingMainVO)valueObject).getAddedFacilityId(), null);
                operFacilityIdCriteriaIetm.setItemValue(((SendLinenForMendingMainVO)valueObject).getPlaceLinenRequestVO().getAddedFacilityId());
                operFacilityIdCriteriaIetm.setProperty("operatingfacilityId");
            }
            catch(Exception exception) { }
            criteriaVo.getCriteriaItems().add(linenItemCriteriaIetm);
            criteriaVo.getCriteriaItems().add(requestNumCriteriaIetm);
            criteriaVo.getCriteriaItems().add(operFacilityIdCriteriaIetm);
            qryResultVO.setCriteriaVo(criteriaVo);
            Page page = new Page();
            page.setPagingEnabled(false);
            qryResultVO.setPage(page);
            request.setAttribute("QueryCriteriaForm", criteriaForm);
            valueObject = setDefaultSet((AppVO)valueObject, request);
            try
            {
                dto = ((AppDelegator)getDelegator()).queryTypeMaster(qryResultVO);
            }
            catch(ApplicationException e)
            {
                e.printStackTrace();
            }
            dto.setTarget("viewMending");
        }
        return dto;
    }

    public Object getReqNo(HttpServletRequest request)
    {
        LookupDelegate lookupDelegate = (LookupDelegate)getDelegatorById("lookupDelegator");
        LookupVO lookUpVo = new LookupVO();
        Map lookupParams = new HashMap();
        Page page = new Page();
        page.setPagingEnabled(false);
        lookUpVo.setQueryId("ehis.lc.sendLinenForMending.getReqNo");
        DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
        Map reqNoMap = ((LookupVO)dto.getObject()).getLookupResults();
        return reqNoMap;
    }

    public Object getStock(String linenItem, String facilityId, HttpServletRequest request)
    {
        LookupDelegate lookupDelegate = (LookupDelegate)getDelegatorById("lookupDelegator");
        LookupVO lookUpVo = new LookupVO();
        Map lookupParams = new HashMap();
        lookupParams.put("facilityId", facilityId);
        lookupParams.put("linenItem", linenItem);
        Page page = new Page();
        page.setPagingEnabled(false);
        lookUpVo.setLookupParameters(lookupParams);
        lookUpVo.setQueryId("ehis.lc.inUseQtyLaundryLookup");
        DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
        Map reqNoMap = ((LookupVO)dto.getObject()).getLookupResults();
        return reqNoMap;
    }
}
