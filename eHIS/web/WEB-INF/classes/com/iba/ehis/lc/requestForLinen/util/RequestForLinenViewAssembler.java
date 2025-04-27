/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Decompiled by DJ v3.6.6.79 Copyright 2004 Atanas Neshkov  Date: 9/7/2009 4:01:25 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   RequestForLinenViewAssembler.java

package com.iba.ehis.lc.requestForLinen.util;

import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.dobj.*;
import com.iba.ehis.lc.requestForLinen.vo.*;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.logging.pojo.business.Logger;
import java.util.Iterator;
import java.util.List;

public class RequestForLinenViewAssembler extends AppAssembler
{

    public RequestForLinenViewAssembler()
    {
    }

    public Object convertDO2VO(Object oDO)
        throws AssemblerException
    {
        RequestForLinenMainVO mainVO = new RequestForLinenMainVO();
        IBALogger.getLogger().debug(getClass(), "getRequestStatus:" + oDO.getClass(), null);
        LinenRequestList linenRequestList;
        for(Iterator iter = ((List)oDO).iterator(); iter.hasNext(); mainVO.getRequestsListVO().getLinenRequest().add(linenRequestList))
        {
            Object obj[] = (Object[])iter.next();
            linenRequestList = new LinenRequestList();
            linenRequestList.setLinenItem((String)obj[0]);
            linenRequestList.setRequestedQty((Long)obj[1]);
            try
            {
                if((String)obj[2] != null)
                    linenRequestList.setRemark((String)obj[2]);
                if((Long)obj[3] != null)
                    linenRequestList.setIssuedQty((Long)obj[3]);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        return mainVO;
    }

    public Object convertVO2DO(Object vo)
        throws AssemblerException
    {
        LcRequestHdr lcRequestHdr = new LcRequestHdr();
        LcRequestHdrId lcRequestHdrId = new LcRequestHdrId();
        LcReason lcReason = new LcReason();
        try
        {
            RequestForLinenMainVO mainVO = (RequestForLinenMainVO)vo;
            PlaceLinenRequestVO placeLinenRequestVO = mainVO.getPlaceLinenRequestVO();
            lcRequestHdrId.setOperatingFacilityId(mainVO.getAddedFacilityId());
            lcRequestHdrId.setRequestNum(placeLinenRequestVO.getRequestNum());
            lcRequestHdr.setId(lcRequestHdrId);
            lcRequestHdr.setSourceCode(placeLinenRequestVO.getSourceCode());
            lcRequestHdr.setSourceType(placeLinenRequestVO.getSourceType());
            lcRequestHdr.setRequestDate(placeLinenRequestVO.getRequestDate());
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
            lcRequestHdr.setAddedById(mainVO.getAddedById());
            lcRequestHdr.setAddedDate(mainVO.getAddedDate());
            lcRequestHdr.setAddedAtWsNo(mainVO.getAddedAtWsNo());
            lcRequestHdr.setAddedFacilityId(mainVO.getAddedFacilityId());
            lcRequestHdr.setModifiedAtWsNo(mainVO.getModifiedAtWsNo());
            lcRequestHdr.setModifiedById(mainVO.getModifiedById());
            lcRequestHdr.setModifiedDate(mainVO.getModifiedDate());
            lcRequestHdr.setModifiedFacilityId(mainVO.getModifiedFacilityId());
        }
        catch(Exception exception) { }
        return lcRequestHdr;
    }
}
