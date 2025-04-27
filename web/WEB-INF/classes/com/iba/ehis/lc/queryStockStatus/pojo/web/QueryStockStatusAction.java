/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// yadavK
// Source File Name:   QueryStockStatusAction.java

package com.iba.ehis.lc.queryStockStatus.pojo.web;

import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.ehis.lc.core.pojo.web.LcAction;
import com.iba.ehis.lc.queryStockStatus.vo.QueryStockStatusVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.Page;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.lookup.pojo.business.LookupDelegate;
import com.iba.framework.lookup.vo.LookupVO;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.*;

public class QueryStockStatusAction extends LcAction
{

    public QueryStockStatusAction()
    {
    }

    protected DTO doPrePopulate(BaseVO valueObject, HttpServletRequest request, HttpServletResponse response)
        throws ApplicationException
    {
        String id = request.getParameter("function_Id");
        DTO dto = new DTO();
        QueryResultVO resultVo = new QueryResultVO();
        QueryStockStatusVO stockVO = new QueryStockStatusVO();
        try
        {
            if(id.equals("Source"))
                dto.setTarget("querySourceQueryCriteria");
            else
            if(id.equals("LinenItem"))
                dto.setTarget("queryLinenItemQueryCriteria");
        }
        catch(Exception ex1)
        {
            ex1.printStackTrace();
        }
        return dto;
    }

    public Object getLaundryRec(String linenItem, String facilityId, HttpServletRequest request, HttpServletResponse response)
    {
        LookupDelegate lookupDelegate = (LookupDelegate)getDelegatorById("lookupDelegator");
        LookupVO lookUpVo = new LookupVO();
        Map lookupParMap = new HashMap();
        Map reqNoMap = new HashMap();
        lookupParMap.put("linenItem", linenItem);
        lookupParMap.put("facilityId", facilityId);
        lookUpVo.setLookupParameters(lookupParMap);
        Page page = new Page();
        page.setPagingEnabled(false);
        lookUpVo.setQueryId("ehis.lc.laundryLevelStock");
        try
        {
            DTO dto = lookupDelegate.lookupUpQuery(lookUpVo, page, request.getSession().getId());
            reqNoMap = ((LookupVO)dto.getObject()).getLookupResults();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return reqNoMap;
    }
 // changes for SCF 32276 - AMRI-SCF-0098. The below function is added to get the source description for the given source code
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
