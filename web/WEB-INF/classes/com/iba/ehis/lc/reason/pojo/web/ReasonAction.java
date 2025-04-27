/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Decompiled by DJ v3.6.6.79 Copyright 2004 Atanas Neshkov  Date: 9/7/2009 2:04:52 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ReasonAction.java

package com.iba.ehis.lc.reason.pojo.web;

import com.iba.ehis.core.pojo.business.AppDelegator;
import com.iba.ehis.core.pojo.web.AppForm;
import com.iba.ehis.core.vo.*;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.reason.vo.ReasonVO;
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

public class ReasonAction extends LcAction
{

    public ReasonAction()
    {
    }

    protected DTO doActionCreate(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)
        throws ApplicationException
    {
        DTO dto = new DTO();
        valueObject = setDefaultSet((AppVO)valueObject, request);
        try
        {
            dto = ((AppDelegator)getDelegator()).createTypeMaster((ReasonVO)valueObject);
        }
        catch(Exception e)
        {
            String message = e.getMessage();
            dto.setMessageId(message);
            dto.setTarget("successCUD");
            dto.setMessageId(Constants.INPUT_ERROR);
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

    protected DTO doActionDelete(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)
        throws ApplicationException
    {
        valueObject = setDefaultSet((AppVO)valueObject, request);
        IBALogger.getLogger().debug(getClass(), "ReasonAction-----1----->doActionDelete()", null);
        DTO dto = ((AppDelegator)getDelegator()).deleteTypeMaster((ReasonVO)valueObject);
        IBALogger.getLogger().debug(getClass(), "ReasonAction-----2----->doActionDelete() ", null);
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
    {
        DTO dto = null;
        dto = loadCriteria(valueObject, request);
        return dto;
    }

    protected DTO doActionUpdate(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)
        throws ApplicationException
    {
        valueObject = setDefaultSet((AppVO)valueObject, request);
        DTO dto = new DTO();
        try
        {
            dto = ((AppDelegator)getDelegator()).updateTypeMaster((ReasonVO)valueObject);
        }
        catch(Exception e)
        {
            String message = e.getMessage();
            dto.setMessageId(message);
            dto.setTarget("successCUD");
            dto.setMessageId(Constants.INPUT_ERROR);
        }
        if(dto.getStatus() ==Constants.SUCCESS)
        {
            valueObject = setDefaultSet((AppVO)valueObject, request);
            dto.setObject(valueObject);
            dto.setTarget("successCUD");
            dto.setMessageId("MESSAGE.OPERATION_SUCCESS");
        } else
        if(dto.getStatus() == Constants.SUCCESS)
        {
            valueObject = setDefaultSet((AppVO)valueObject, request);
            dto.setObject(valueObject);
            dto.setTarget("successCUD");
            dto.setMessageId("MESSAGE.OPERATION_FAILURE");
        }
        return dto;
    }

    protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)
        throws ApplicationException
    {
        IBALogger.getLogger().debug(getClass(), "ReasonAction---------->doPrePopulate ", null);
        DTO dto = new DTO();
        if(((ReasonVO)valueObject).getReasonCode() == null)
        {
            dto.setMode(0);
            dto.setObject(valueObject);
            dto.setTarget("createPageReason");
            dto.setStatus(400);
        } else
        {
            IBALogger.getLogger().debug(getClass(), "ReasonAction---------->doPrePopulate ----else", null);
            valueObject = setDefaultSet((AppVO)valueObject, request);
            dto.setObject(valueObject);
            ((AppVO)dto.getObject()).setFunctionId(((ReasonVO)valueObject).getFunctionId());
            ((AppVO)dto.getObject()).setModuleId(((ReasonVO)valueObject).getModuleId());
            dto.setMode(2);
            dto.setTarget("createPageReason");
        }
        return dto;
    }

    private DTO loadCriteria(BaseVO valueObject, HttpServletRequest request)
    {
        valueObject = setDefaultSet((AppVO)valueObject, request);
        IBALogger.getLogger().debug(getClass(), "..............loadCriteria..........", null);
        DTO dto = new DTO();
        QueryCriteriaVO queryCriteriaVO = new QueryCriteriaVO();
        setDefaultSet(queryCriteriaVO, request);
        QueryCriteriaItem criteriaItemReasonCode = new QueryCriteriaItem();
        criteriaItemReasonCode.setBundleName("lcLabels");
        criteriaItemReasonCode.setLabelKey("com.iba.ehis.lc.Code");
        criteriaItemReasonCode.setProperty("reasonCode");
        criteriaItemReasonCode.setLength(15);
        criteriaItemReasonCode.setSize(15);
        criteriaItemReasonCode.setType(1);
        queryCriteriaVO.getCriteriaItems().add(criteriaItemReasonCode);
        QueryCriteriaItem criteriaItemReasonDesc = new QueryCriteriaItem();
        criteriaItemReasonDesc.setBundleName("lcLabels");
        criteriaItemReasonDesc.setLabelKey("com.iba.ehis.lc.description");
        criteriaItemReasonDesc.setProperty("activeYn");
        criteriaItemReasonDesc.setLength(15);
        criteriaItemReasonDesc.setSize(15);
        criteriaItemReasonDesc.setType(1);
        queryCriteriaVO.getCriteriaItems().add(criteriaItemReasonDesc);
        QueryCriteriaItem criteriaItemEffStatus = new QueryCriteriaItem();
        criteriaItemEffStatus.setBundleName("lcLabels");
        criteriaItemEffStatus.setLabelKey("com.iba.ehis.lc.nature");
        criteriaItemEffStatus.setProperty("effStatus");
        criteriaItemEffStatus.setLength(5);
        criteriaItemEffStatus.setSize(5);
        criteriaItemEffStatus.setType(2);
        queryCriteriaVO.getCriteriaItems().add(criteriaItemEffStatus);
        try
        {
            criteriaItemEffStatus.addOption("com.iba.ehis.lc.statusB", "", "lcLabels");
            criteriaItemEffStatus.addOption("com.iba.ehis.lc.statusY", "E", "lcLabels");
            criteriaItemEffStatus.addOption("com.iba.ehis.lc.statusN", "D", "lcLabels");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        queryCriteriaVO.addOrderByCol("com.iba.ehis.lc.Code", "1", "lcLabels");
        queryCriteriaVO.addOrderByCol("com.iba.ehis.lc.description", "2", "lcLabels");
        queryCriteriaVO.addOrderByCol("com.iba.ehis.lc.nature", "3", "lcLabels");
        queryCriteriaVO.setPageAction("ReasonPageAction");
        queryCriteriaVO.setQueryResultPage("ReasonQueryResultPage");
        valueObject = setDefaultSet((AppVO)valueObject, request);
        queryCriteriaVO.setFunctionId(((ReasonVO)valueObject).getFunctionId());
        queryCriteriaVO.setModuleId(((ReasonVO)valueObject).getModuleId());
        AppForm criteriaForm = new AppForm();
        criteriaForm.setVo(queryCriteriaVO);
        request.setAttribute("QueryCriteriaForm", criteriaForm);
        dto.setTarget("queryCriteriaPage");
        return dto;
    }

    public Map getAction(int pageNo, String languageId, HttpServletRequest request)
    {
        DTO dto = new DTO();
        Map ValueMap = new HashMap();
        Map existingRec = new HashMap();
        LookupVO lookUpVo = new LookupVO();
        IBALogger.getLogger().debug(getClass(), "ReasonAction-------->", null);
        ValueMap.put("languageId", languageId);
        lookUpVo.setLookupParameters(ValueMap);
        lookUpVo.setQueryId("ehis.lc.reason.getActionType");
        Page page = new Page();
        page.setPageNo(pageNo);
        try
        {
            dto = ((LookupDelegate)getDelegatorById("lookupDelegator")).lookupUpQuery(lookUpVo, page, request.getSession().getId());
            existingRec = ((LookupVO)dto.getObject()).getLookupResults();
        }
        catch(Exception e)
        {
            String message = e.getMessage();
            dto.setMessageId(message);
            dto.setTarget("successCUD");
            dto.setMessageId(Constants.DATA_NOT_FOUND);
        }
        IBALogger.getLogger().debug(getClass(), (new StringBuilder("ReasonAction-----getRecord----->")).append(existingRec).toString(), null);
        return existingRec;
    }

    public Map getCheck(int pageNo, String code, String languageId, HttpServletRequest request)
    {
        DTO dto = new DTO();
        Map ValueMap = new HashMap();
        Map existingRec = new HashMap();
        LookupVO lookUpVo = new LookupVO();
        IBALogger.getLogger().debug(getClass(), (new StringBuilder("ReasonAction----Rcode----->")).append(code).toString(), null);
        ValueMap.put("reasonCode", code);
        ValueMap.put("languageId", languageId);
        lookUpVo.setLookupParameters(ValueMap);
        lookUpVo.setQueryId("ehis.lc.reason.getallAction");
        Page page = new Page();
        page.setPageNo(pageNo);
        try
        {
            dto = ((LookupDelegate)getDelegatorById("lookupDelegator")).lookupUpQuery(lookUpVo, page, request.getSession().getId());
            existingRec = ((LookupVO)dto.getObject()).getLookupResults();
        }
        catch(Exception e)
        {
            String message = e.getMessage();
            dto.setMessageId(message);
            dto.setTarget("successCUD");
            dto.setMessageId(Constants.DATA_NOT_FOUND);
        }
        IBALogger.getLogger().debug(getClass(), (new StringBuilder("ReasonAction-----getRecord----->")).append(existingRec).toString(), null);
        return existingRec;
    }
    public Map getActionTypeDesc(String languageId,String code, HttpServletRequest request)
    {
        DTO dto = new DTO();
        Map ValueMap = new HashMap();
        Map existingRec = new HashMap();
        LookupVO lookUpVo = new LookupVO();
        ValueMap.put("languageId", languageId);
        ValueMap.put("code", code);
        lookUpVo.setLookupParameters(ValueMap);
        lookUpVo.setQueryId("ehis.lc.reason.getActionType");
         
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
            dto.setMessageId(Constants.DATA_NOT_FOUND);
        }
        IBALogger.getLogger().debug(getClass(), (new StringBuilder("ReasonAction-----getActionTypeDesc----->")).append(existingRec).toString(), null);
        return existingRec;
    }
}
