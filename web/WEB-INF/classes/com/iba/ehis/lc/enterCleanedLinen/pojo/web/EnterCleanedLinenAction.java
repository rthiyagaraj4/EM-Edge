/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Author: Yadavk
// Source File Name:   EnterCleanedLinenAction.java

package com.iba.ehis.lc.enterCleanedLinen.pojo.web;

import com.iba.ehis.core.pojo.business.AppDelegator;
import com.iba.ehis.core.pojo.web.AppForm;
import com.iba.ehis.core.vo.*;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.enterCleanedLinen.vo.EnterCleanedLinenVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.*;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.lookup.pojo.business.LookupDelegate;
import com.iba.framework.lookup.vo.LookupVO;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.*;
import com.iba.framework.core.util.Constants;

public class EnterCleanedLinenAction extends LcAction
{

    public EnterCleanedLinenAction()
    {
    }

    protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)
        throws ApplicationException
    {
        DTO dto = new DTO();
        setDefaultSet((EnterCleanedLinenVO)valueObject, request);
        dto.setObject(valueObject);
        dto.setMode(0);
        dto.setTarget("enterCleanedLinen");
        return dto;
    }

    protected DTO doActionCreate(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)
        throws ApplicationException
    {
        DTO dto = null;
        valueObject = setDefaultSet((AppVO)valueObject, request);
        EnterCleanedLinenVO enterCleanedLinenVO = (EnterCleanedLinenVO)valueObject;
        try
        {
            dto = ((AppDelegator)getDelegator()).createTypeMaster(enterCleanedLinenVO);
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
        EnterCleanedLinenVO enterCleanedLinenVO = (EnterCleanedLinenVO)valueObject;
        DTO dto = ((AppDelegator)getDelegator()).updateTypeMaster(enterCleanedLinenVO);
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

    protected DTO doActionQuery(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)
        throws ApplicationException
    {
        AppForm criteriaForm = new AppForm();
        DTO dto = new DTO();
        QueryCriteriaVO criteriaVo = new QueryCriteriaVO();
        QueryResultVO qryResultVO = new QueryResultVO();
        qryResultVO.setFunctionId("LC_ENTER_CLEAN_LINEN");
        qryResultVO.setModuleId("LC");
        criteriaVo.setPageAction("EnterCleanedLinenPageAction");
        QueryCriteriaItem viewCriteriaIetm = new QueryCriteriaItem();
        viewCriteriaIetm.setItemValue(((EnterCleanedLinenVO)valueObject).getLinenItem());
        viewCriteriaIetm.setProperty("linenItem");
        viewCriteriaIetm.setItemValue(((EnterCleanedLinenVO)valueObject).getAddedFacilityId());
        viewCriteriaIetm.setProperty("operatingFacilityId");
        criteriaVo.getCriteriaItems().add(viewCriteriaIetm);
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
        dto.setTarget("EnterCleanedLinenQueryResultPage");
        return dto;
    }

    public Object getReqNo(HttpServletRequest request)
    {
        LookupDelegate lookupDelegate = (LookupDelegate)getDelegatorById("lookupDelegator");
        LookupVO lookUpVo = new LookupVO();
        Page page = new Page();
        page.setPagingEnabled(false);
        lookUpVo.setQueryId("ehis.lc.enterCleanedLinen.getReqNo");
        DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
        Map reqNoMap = ((LookupVO)dto.getObject()).getLookupResults();
        return reqNoMap;
    }

    public Object getStockDetail(String language_Id, String linenItem, String facilityId, HttpServletRequest request)
    {
        LookupDelegate lookupDelegate = (LookupDelegate)getDelegatorById("lookupDelegator");
        LookupVO lookUpVo = new LookupVO();
        Map paramMap = new HashMap();
        paramMap.put("language_Id", language_Id);
        paramMap.put("linenItem", linenItem);
        paramMap.put("facilityId", facilityId);
        lookUpVo.setLookupParameters(paramMap);
        Page page = new Page();
        page.setPagingEnabled(false);
        lookUpVo.setQueryId("ehis.LC.enterCleanedLinen.getStockDetail");
        DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
        Map stockMap = ((LookupVO)dto.getObject()).getLookupResults();
        return stockMap;
    }

    public Object getNatureOfDefect(String language_Id, HttpServletRequest request)
    {
        LookupDelegate lookupDelegate = (LookupDelegate)getDelegatorById("lookupDelegator");
        LookupVO lookUpVo = new LookupVO();
        Map lookupValues = new HashMap();
        lookupValues.put("language_Id", language_Id);
        Page page = new Page();
        page.setPagingEnabled(false);
        lookUpVo.setLookupParameters(lookupValues);
        lookUpVo.setQueryId("ehis.lc.natureofdefectlookup");
        DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
        Map stockMap = ((LookupVO)dto.getObject()).getLookupResults();
        return stockMap;
    }

    public Object getReasonForDefect(String language_Id, HttpServletRequest request)
    {
        LookupDelegate lookupDelegate = (LookupDelegate)getDelegatorById("lookupDelegator");
        LookupVO lookUpVo = new LookupVO();
        Map lookupValues = new HashMap();
        lookupValues.put("language_Id", language_Id);
        Page page = new Page();
        page.setPagingEnabled(false);
        lookUpVo.setLookupParameters(lookupValues);
        lookUpVo.setQueryId("ehis.lc.qualityfailurelookup");
        DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
        Map stockMap = ((LookupVO)dto.getObject()).getLookupResults();
        return stockMap;
    }
}
