/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Author: yadavK
// Source File Name:   IssueOfLinenAction.java

package com.iba.ehis.lc.issueOfLinen.pojo.web;

import com.iba.ehis.core.pojo.business.AppDelegator;
import com.iba.ehis.core.pojo.web.AppForm;
import com.iba.ehis.core.vo.*;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.issueOfLinen.vo.IssueOfLinenMainVO;
import com.iba.ehis.lc.issueOfLinen.vo.IssueOfLinenVO;
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

public class IssueOfLinenAction extends LcAction
{

    public IssueOfLinenAction()
    {
    }

    protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)
        throws ApplicationException
    {
        DTO dto = new DTO();
        setDefaultSet(((IssueOfLinenMainVO)valueObject).getIssueOfLinenVO(), request);
        ((AppVO)dto.getObject()).setFunctionId(((IssueOfLinenVO)valueObject).getFunctionId());
        ((AppVO)dto.getObject()).setModuleId(((IssueOfLinenVO)valueObject).getModuleId());
        dto.setObject(valueObject);
        dto.setMode(0);
        dto.setTarget("issueoflinen");
        return dto;
    }

    protected DTO doActionCreate(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)
        throws ApplicationException
    {
        DTO dto = null;
        IssueOfLinenVO issueOfLinenVO = (IssueOfLinenVO)setDefaultSet(((IssueOfLinenMainVO)valueObject).getIssueOfLinenVO(), request);
        try
        {
            dto = ((AppDelegator)getDelegator()).createTypeMaster(issueOfLinenVO);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            dto.setStatus(Constants.FAILED);
        }
        if(dto.getStatus() == Constants.SUCCESS)
        {
            dto.setTarget("successCUD");
            dto.setMessageId("MESSAGE.OPERATION_SUCCESS");
        } else
        if(dto.getStatus() == Constants.FAILED)
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
        IssueOfLinenMainVO issueOfLinenMainVO = (IssueOfLinenMainVO)valueObject;
        DTO dto = ((AppDelegator)getDelegator()).updateTypeMaster(issueOfLinenMainVO);
        if(dto.getStatus() == Constants.SUCCESS)
        {
            dto.setTarget("successCUD");
            dto.setMessageId("MESSAGE.OPERATION_SUCCESS");
        } else
        if(dto.getStatus() ==Constants.FAILED)
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
        setDefaultSet((AppVO)valueObject, request);
        if(((IssueOfLinenMainVO)valueObject).getCheckView() == null || ((IssueOfLinenMainVO)valueObject).getCheckView().equals(""))
        {
            queryCriteriaVO.setFunctionId(((AppVO)valueObject).getFunctionId());
            queryCriteriaVO.setModuleId("LC");
            criteriaForm.setVo(queryCriteriaVO);
            request.setAttribute("QueryCriteriaForm", criteriaForm);
            dto.setTarget("issueOfLinenCriteriaPage");
        } else
        {
            QueryResultVO qryResultVO = new QueryResultVO();
            IBALogger.getLogger().debug(getClass(), (new StringBuilder("getRequestStatus:")).append(((IssueOfLinenMainVO)valueObject).getIssueOfLinenVO().getRequestStatus().trim()).toString(), null);
            if(((IssueOfLinenMainVO)valueObject).getIssueOfLinenVO().getRequestStatus().trim().equalsIgnoreCase("OS") || ((IssueOfLinenMainVO)valueObject).getIssueOfLinenVO().getRequestStatus().trim().equalsIgnoreCase("CN"))
                qryResultVO.setFunctionId("request");
            else
                qryResultVO.setFunctionId("requestForLinen");
            qryResultVO.setModuleId("LC");
            QueryCriteriaVO criteriaVo = new QueryCriteriaVO();
            QueryCriteriaItem criteriaItemLinenItem = new QueryCriteriaItem();
            QueryCriteriaItem criteriaItemRequestNum = new QueryCriteriaItem();
            QueryCriteriaItem criteriaItemFacilityId = new QueryCriteriaItem();
            criteriaItemLinenItem.setItemValue(((IssueOfLinenMainVO)valueObject).getIssueOfLinenVO().getLinenItem().trim());
            criteriaItemLinenItem.setProperty("linenItem");
            criteriaItemRequestNum.setItemValue(((IssueOfLinenMainVO)valueObject).getIssueOfLinenVO().getRequestNum().trim());
            criteriaItemRequestNum.setProperty("requestNo");
            try
            {
                criteriaItemFacilityId.setItemValue(((IssueOfLinenMainVO)valueObject).getIssueOfLinenVO().getAddedFacilityId().trim());
                criteriaItemFacilityId.setProperty("operatingFacilityId");
            }
            catch(Exception exception) { }
            criteriaVo.getCriteriaItems().add(criteriaItemLinenItem);
            criteriaVo.getCriteriaItems().add(criteriaItemRequestNum);
            criteriaVo.getCriteriaItems().add(criteriaItemFacilityId);
            qryResultVO.setCriteriaVo(criteriaVo);
            Page page = new Page();
            page.setPagingEnabled(false);
            qryResultVO.setPage(page);
            try
            {
                dto = ((AppDelegator)getDelegator()).queryTypeMaster(qryResultVO);
            }
            catch(ApplicationException e)
            {
                e.printStackTrace();
            }
            if(((IssueOfLinenMainVO)valueObject).getCheckView().equals("view"))
            {
                dto.setTarget("issueViewRequest");
            } else
            {
                dto.setObject(valueObject);
                dto.setTarget("issueRequest");
            }
        }
        return dto;
    }

    public Object getIssueNo(String facilityId, String requestNum, HttpServletRequest request)
    {
        LookupDelegate lookupDelegate = (LookupDelegate)getDelegatorById("lookupDelegator");
        LookupVO lookUpVo = new LookupVO();
        Page page = new Page();
        page.setPagingEnabled(false);
        Map lookupParams = new HashMap();
        lookupParams.put("facilityId", facilityId);
        lookUpVo.setLookupParameters(lookupParams);
        lookUpVo.setQueryId("ehis.lc.issueOfLinen.getIssueNo");
        DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
        Map reqNoMap = ((LookupVO)dto.getObject()).getLookupResults();
        return reqNoMap;
    }

    public Object getSumIssuedQty(String facilityId, String requestNum, HttpServletRequest request)
    {
        LookupDelegate lookupDelegate = (LookupDelegate)getDelegatorById("lookupDelegator");
        LookupVO lookUpVo = new LookupVO();
        Page page = new Page();
        page.setPagingEnabled(false);
        Map lookupParams = new HashMap();
        lookupParams.put("facilityId", facilityId);
        lookupParams.put("requestNum", requestNum);
        lookUpVo.setLookupParameters(lookupParams);
        lookUpVo.setQueryId("ehis.lc.issueOfLinen.getSumOfIssuedQty");
        DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
        Map reqNoMap = ((LookupVO)dto.getObject()).getLookupResults();
        return reqNoMap;
    }

    public Object getSumRequestedQty(String facilityId, String requestNum, HttpServletRequest request)
    {
        LookupDelegate lookupDelegate = (LookupDelegate)getDelegatorById("lookupDelegator");
        LookupVO lookUpVo = new LookupVO();
        Page page = new Page();
        page.setPagingEnabled(false);
        Map lookupParams = new HashMap();
        lookupParams.put("facilityId", facilityId);
        lookupParams.put("requestNum", requestNum);
        lookUpVo.setLookupParameters(lookupParams);
        lookUpVo.setQueryId("ehis.lc.issueOfLinen.getSumOfRequestQty");
        DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
        Map reqNoMap = ((LookupVO)dto.getObject()).getLookupResults();
        return reqNoMap;
    }

    public Object getStockDetail(String language_Id, String facilityId, HttpServletRequest request)
    {
        LookupDelegate lookupDelegate = (LookupDelegate)getDelegatorById("lookupDelegator");
        LookupVO lookUpVo = new LookupVO();
        Page page = new Page();
        page.setPagingEnabled(false);
        Map lookupParams = new HashMap();
        lookupParams.put("language_Id", language_Id);
        lookupParams.put("facilityId", facilityId);
        lookUpVo.setLookupParameters(lookupParams);
        lookUpVo.setQueryId("ehis.lc.treeLookup");
        DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
        Map reqNoMap = ((LookupVO)dto.getObject()).getLookupResults();
        return reqNoMap;
    }

    public Object getInCleaningDetail(String language_Id, String facilityId, HttpServletRequest request)
    {
        LookupDelegate lookupDelegate = (LookupDelegate)getDelegatorById("lookupDelegator");
        LookupVO lookUpVo = new LookupVO();
        Page page = new Page();
        page.setPagingEnabled(false);
        Map lookupParams = new HashMap();
        lookupParams.put("language_Id", language_Id);
        lookupParams.put("facilityId", facilityId);
        lookUpVo.setLookupParameters(lookupParams);
        lookUpVo.setQueryId("ehis.lc.inCleaningLookup");
        DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
        Map reqNoMap = ((LookupVO)dto.getObject()).getLookupResults();
        return reqNoMap;
    }

    public Object getSourceStock(String language_Id, String facilityId, String sourceType, String source, HttpServletRequest request)
    {
        LookupDelegate lookupDelegate = (LookupDelegate)getDelegatorById("lookupDelegator");
        LookupVO lookUpVo = new LookupVO();
        Page page = new Page();
        page.setPagingEnabled(false);
        Map lookupParams = new HashMap();
        lookupParams.put("language_Id", language_Id);
        lookupParams.put("facilityId", facilityId);
        lookupParams.put("sourceType", sourceType);
        lookupParams.put("source", source);
        lookUpVo.setLookupParameters(lookupParams);
        lookUpVo.setQueryId("ehis.lc.inUseQuantity");
        DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
        Map reqNoMap = ((LookupVO)dto.getObject()).getLookupResults();
        return reqNoMap;
    }

    public Object getPendingCleaning(String language_Id, String facilityId, String sourceType, String source, HttpServletRequest request)
    {
        LookupDelegate lookupDelegate = (LookupDelegate)getDelegatorById("lookupDelegator");
        LookupVO lookUpVo = new LookupVO();
        Page page = new Page();
        page.setPagingEnabled(false);
        Map lookupParams = new HashMap();
        lookupParams.put("language_Id", language_Id);
        lookupParams.put("facilityId", facilityId);
        lookupParams.put("sourceType", sourceType);
        lookupParams.put("source", source);
        lookUpVo.setLookupParameters(lookupParams);
        lookUpVo.setQueryId("ehis.lc.pandingCleaninglookup");
        DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
        Map reqNoMap = ((LookupVO)dto.getObject()).getLookupResults();
        return reqNoMap;
    }

    public Object getPendingIssue(String language_Id, String facilityId, String sourceType, String source, HttpServletRequest request)
    {
        LookupDelegate lookupDelegate = (LookupDelegate)getDelegatorById("lookupDelegator");
        LookupVO lookUpVo = new LookupVO();
        Page page = new Page();
        page.setPagingEnabled(false);
        Map lookupParams = new HashMap();
        lookupParams.put("language_Id", language_Id);
        lookupParams.put("facilityId", facilityId);
        lookupParams.put("sourceType", sourceType);
        lookupParams.put("source", source);
        lookUpVo.setLookupParameters(lookupParams);
        lookUpVo.setQueryId("ehis.lc.pandingIssuelookup");
        DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
        Map reqNoMap = ((LookupVO)dto.getObject()).getLookupResults();
        return reqNoMap;
    }

    public Object getSourceDesc(String language_Id, String facilityId, String sourceType, String source, HttpServletRequest request)
    {
        LookupDelegate lookupDelegate = (LookupDelegate)getDelegatorById("lookupDelegator");
        LookupVO lookUpVo = new LookupVO();
        Page page = new Page();
        page.setPagingEnabled(false);
        Map lookupParams = new HashMap();
        lookupParams.put("facilityId", facilityId);
        lookupParams.put("code", source);
        lookupParams.put("languageId", language_Id);
        lookUpVo.setLookupParameters(lookupParams);
        if(sourceType.equalsIgnoreCase("W"))
            lookUpVo.setQueryId("ehis.lc.standardStock.nursingUnit");
        else
        if(sourceType.equalsIgnoreCase("C"))
            lookUpVo.setQueryId("ehis.lc.standardStock.clinic");
        else
        if(sourceType.equalsIgnoreCase("D"))
            lookUpVo.setQueryId("ehis.lc.standardStock.deptCode");
        else
        if(sourceType.equalsIgnoreCase("P"))
            lookUpVo.setQueryId("ehis.lc.patientlookup");
        DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
        Map reqNoMap = ((LookupVO)dto.getObject()).getLookupResults();
        return reqNoMap;
    }
}
