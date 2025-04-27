/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Author: yadavK
// Source File Name:   RequestForLinenAssembler.java

package com.iba.ehis.lc.requestForLinen.util;

import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.dobj.*;
import com.iba.ehis.lc.requestForLinen.vo.*;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.*;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.core.vo.UserPreferences;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.logging.pojo.business.Logger;
import java.util.*;

public class RequestForLinenAssembler extends AppAssembler
{

    public RequestForLinenAssembler()
    {
    }

    public Object convertVO2DO(BaseVO vo)
        throws AssemblerException
    {
        int index = 0;
        DTO dto = new DTO();
        List LinenRequestList = new ArrayList();
        List createList = new ArrayList();
        List updateList = new ArrayList();
        PlaceLinenRequestVO placeLinenRequestVO = (PlaceLinenRequestVO)vo;
        for(Iterator iter = placeLinenRequestVO.getLinenRequest().iterator(); iter.hasNext();)
            try
            {
                LcRequestDtl lcRequestDtl = new LcRequestDtl();
                LcRequestDtlId lcRequestDtlId = new LcRequestDtlId();
                LcRequestHdr lcRequestHdr = new LcRequestHdr();
                LcRequestHdrId lcRequestHdrId = new LcRequestHdrId();
                LcLinenItem lcLinenItem = new LcLinenItem();
                LinenRequestList element = (LinenRequestList)iter.next();
                lcRequestHdrId.setOperatingFacilityId(placeLinenRequestVO.getAddedFacilityId());
                lcRequestHdrId.setRequestNum(placeLinenRequestVO.getRequestNum().trim());
                lcRequestHdr.setId(lcRequestHdrId);
                lcRequestHdr.setRaisedBy(placeLinenRequestVO.getRaisedBy());
                lcRequestHdr.setSourceCode(placeLinenRequestVO.getSourceCode());
                lcRequestHdr.setSourceType(placeLinenRequestVO.getSourceType());
                lcRequestHdr.setRequestDate(placeLinenRequestVO.getRequestDate());
                lcRequestDtlId.setLcRequestHdr(lcRequestHdr);
                lcLinenItem.setLinenItem(element.getLinenItem());
                lcRequestDtlId.setLcLinenItem(lcLinenItem);
                lcRequestDtl.setId(lcRequestDtlId);
                lcRequestDtl.setRequestedQty(element.getRequestedQty());
                lcRequestDtl.setRemarks(element.getRemark());
                lcRequestDtl.setAddedById(placeLinenRequestVO.getAddedById());
                lcRequestDtl.setAddedDate(placeLinenRequestVO.getAddedDate());
                lcRequestDtl.setAddedAtWsNo(placeLinenRequestVO.getAddedAtWsNo());
                lcRequestDtl.setAddedFacilityId(placeLinenRequestVO.getAddedFacilityId());
                lcRequestDtl.setModifiedAtWsNo(placeLinenRequestVO.getModifiedAtWsNo());
                lcRequestDtl.setModifiedById(placeLinenRequestVO.getModifiedById());
                lcRequestDtl.setModifiedDate(placeLinenRequestVO.getModifiedDate());
                lcRequestDtl.setModifiedFacilityId(placeLinenRequestVO.getModifiedFacilityId());
                createList.add(lcRequestDtl);
            }
            catch(Exception e)
            {
                IBALogger.getLogger().debug(getClass(), "RequestForLinenAssembler---------->convertVO2DO ", null);
                e.printStackTrace();
            }

        LinenRequestList.add(createList);
        return LinenRequestList;
    }

    public Object convertVO2DO1(Object vo)
        throws AssemblerException
    {
        LcRequestHdr lcRequestHdr = new LcRequestHdr();
        LcRequestHdrId lcRequestHdrId = new LcRequestHdrId();
        LcReason lcReason = new LcReason();
        try
        {
            PlaceLinenRequestVO placeLinenRequestVO = (PlaceLinenRequestVO)vo;
            lcRequestHdrId.setOperatingFacilityId(placeLinenRequestVO.getAddedFacilityId());
            lcRequestHdrId.setRequestNum(placeLinenRequestVO.getRequestNum());
            lcRequestHdr.setId(lcRequestHdrId);
            lcRequestHdr.setSourceCode(placeLinenRequestVO.getSourceCode());
            lcRequestHdr.setSourceType(placeLinenRequestVO.getSourceType());
            IBALogger.getLogger().debug(getClass(), "Request Date=======VO=======>" + placeLinenRequestVO.getRequestDate(), null);
            lcRequestHdr.setRequestDate(placeLinenRequestVO.getRequestDate());
            IBALogger.getLogger().debug(getClass(), "Request Date======DO========>" + lcRequestHdr.getRequestDate(), null);
            lcRequestHdr.setRaisedBy(placeLinenRequestVO.getRaisedBy());
            lcRequestHdr.setRequestStatus(placeLinenRequestVO.getRequestStatus());
            lcRequestHdr.setCancelledBy(placeLinenRequestVO.getCancelledBy());
            if(placeLinenRequestVO.getCancelledDate() != null)
            {
                lcRequestHdr.setCancelledDate(placeLinenRequestVO.getCancelledDate());
            } else
            {
                java.util.Date cancel = null;
                lcRequestHdr.setCancelledDate(cancel);
            }
            if(placeLinenRequestVO.getReasonCode() != null)
                lcReason.setReasonCode(placeLinenRequestVO.getReasonCode());
            else
                lcReason.setReasonCode("");
            if(placeLinenRequestVO.getReasonDesc() != null)
                lcReason.setReasonDesc(placeLinenRequestVO.getReasonDesc());
            else
                lcReason.setReasonDesc("");
            lcRequestHdr.setLcReason(lcReason);
            lcRequestHdr.setAddedById(placeLinenRequestVO.getAddedById());
            lcRequestHdr.setAddedDate(placeLinenRequestVO.getAddedDate());
            lcRequestHdr.setAddedAtWsNo(placeLinenRequestVO.getAddedAtWsNo());
            lcRequestHdr.setAddedFacilityId(placeLinenRequestVO.getAddedFacilityId());
            lcRequestHdr.setModifiedAtWsNo(placeLinenRequestVO.getModifiedAtWsNo());
            lcRequestHdr.setModifiedById(placeLinenRequestVO.getModifiedById());
            lcRequestHdr.setModifiedDate(placeLinenRequestVO.getModifiedDate());
            lcRequestHdr.setModifiedFacilityId(placeLinenRequestVO.getModifiedFacilityId());
        }
        catch(Exception exception) { }
        return lcRequestHdr;
    }

    public Object convertDO2VO(Object oDO)
        throws AssemblerException
    {
        List requestsList = new ArrayList();
        UserPreferences userPrefs = new UserPreferences();
        String dtf = userPrefs.getDateFormat();
        String tm = userPrefs.getTimeFormat();
        String pattern = dtf + " " + tm;
        RequestsListVO requestsListVO;
        for(Iterator iter = ((List)oDO).iterator(); iter.hasNext(); requestsList.add(requestsListVO))
        {
            LcRequestDtl lcRequestDtl = (LcRequestDtl)iter.next();
            requestsListVO = new RequestsListVO();
            requestsListVO.setLinenItem(lcRequestDtl.getId().getLcLinenItem().getLinenItem());
            try
            {
                if(lcRequestDtl.getId().getLcLinenItem().getShortDesc() != null)
                    requestsListVO.setShortDesc(lcRequestDtl.getId().getLcLinenItem().getShortDesc());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            requestsListVO.setSourceCode(lcRequestDtl.getId().getLcRequestHdr().getSourceCode());
            requestsListVO.setSourceType(lcRequestDtl.getId().getLcRequestHdr().getSourceType());
            requestsListVO.setRequestNo(lcRequestDtl.getId().getLcRequestHdr().getId().getRequestNum());
            requestsListVO.setRequestedQty(lcRequestDtl.getRequestedQty());
            IBADateTime dt = new IBADateTime(lcRequestDtl.getId().getLcRequestHdr().getRequestDate());
            dt.setPattern("dd/MM/yyyy HH:mm");
            requestsListVO.setRequestDate(dt);
            requestsListVO.setRaisedBy(lcRequestDtl.getId().getLcRequestHdr().getRaisedBy());
            requestsListVO.setRequestStatus(lcRequestDtl.getId().getLcRequestHdr().getRequestStatus());
            try
            {
                if(lcRequestDtl.getId().getLcRequestHdr().getLcReason().getReasonCode() != null)
                    requestsListVO.setReasonCode(lcRequestDtl.getId().getLcRequestHdr().getLcReason().getReasonCode());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            try
            {
                if(lcRequestDtl.getId().getLcRequestHdr().getCancelledBy() != null)
                    requestsListVO.setCancelledBy(lcRequestDtl.getId().getLcRequestHdr().getCancelledBy());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            try
            {
                if(lcRequestDtl.getId().getLcRequestHdr().getCancelledDate() != null)
                {
                    IBADateTime dt1 = new IBADateTime(lcRequestDtl.getId().getLcRequestHdr().getCancelledDate());
                    dt1.setPattern("dd/MM/yyyy HH:mm");
                    requestsListVO.setCancelledDate(dt1);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        return requestsList;
    }

    public Object convertVO2DO(Object vo)
        throws AssemblerException
    {
        return super.convertVO2DO(vo);
    }
}
