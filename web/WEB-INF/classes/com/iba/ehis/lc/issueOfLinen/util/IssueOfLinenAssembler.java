/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Decompiler options: packimports(3) 
// Source File Name:   IssueOfLinenAssembler.java

package com.iba.ehis.lc.issueOfLinen.util;

import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.dobj.*;
import com.iba.ehis.lc.issueOfLinen.vo.IssueOfLinenVO;
import com.iba.ehis.lc.issueOfLinen.vo.LinenIssueList;
import com.iba.ehis.lc.requestForLinen.vo.RequestsListVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.*;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;
import java.util.*;

public class IssueOfLinenAssembler extends AppAssembler
{

    public IssueOfLinenAssembler()
    {
    }

    public Object convertDO2VO(Object dObj, Class classVO)
        throws AssemblerException
    {
        return convertDO2VO(dObj);
    }

    public Object convertVO2DO1(Object vo)
        throws AssemblerException
    {
        IssueOfLinenVO issueOfLinenVO = (IssueOfLinenVO)vo;
        LcIssueHdr lcIssueHdr = new LcIssueHdr();
        LcIssueHdrId lcIssueHdrId = new LcIssueHdrId();
        try
        {
            lcIssueHdr.setRequestNum(issueOfLinenVO.getRequestNum().trim());
            lcIssueHdrId.setOperatingFacilityId(issueOfLinenVO.getAddedFacilityId());
            lcIssueHdrId.setIssueNum(issueOfLinenVO.getIssueNum().trim());
            lcIssueHdr.setId(lcIssueHdrId);
            lcIssueHdr.setIssueDate(issueOfLinenVO.getIssueDate());
            lcIssueHdr.setIssuedBy(issueOfLinenVO.getIssueBy());
            lcIssueHdr.setAddedById(issueOfLinenVO.getAddedById());
            lcIssueHdr.setAddedDate(issueOfLinenVO.getAddedDate());
            lcIssueHdr.setAddedAtWsNo(issueOfLinenVO.getAddedAtWsNo());
            lcIssueHdr.setAddedFacilityId(issueOfLinenVO.getAddedFacilityId());
            lcIssueHdr.setModifiedAtWsNo(issueOfLinenVO.getModifiedAtWsNo());
            lcIssueHdr.setModifiedById(issueOfLinenVO.getModifiedById());
            lcIssueHdr.setModifiedDate(issueOfLinenVO.getModifiedDate());
            lcIssueHdr.setModifiedFacilityId(issueOfLinenVO.getModifiedFacilityId());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return lcIssueHdr;
    }

    public Object convertVO2DO(Object vo)
        throws AssemblerException
    {
        List issueList = new ArrayList();
        List createList = new ArrayList();
        IssueOfLinenVO issueOfLinenVO = (IssueOfLinenVO)vo;
        LcIssueDtl lcIssueDtl;
        for(Iterator iter = issueOfLinenVO.getLinenIssueList().iterator(); iter.hasNext(); createList.add(lcIssueDtl))
        {
            lcIssueDtl = new LcIssueDtl();
            LcIssueDtlId lcIssueDtlId = new LcIssueDtlId();
            LcIssueHdr lcIssueHdr = new LcIssueHdr();
            LcIssueHdrId lcIssueHdrId = new LcIssueHdrId();
            LcLinenItem lcLinenItem = new LcLinenItem();
            LinenIssueList element = (LinenIssueList)iter.next();
            try
            {
                lcIssueHdrId.setIssueNum(issueOfLinenVO.getIssueNum().trim());
                lcIssueHdrId.setOperatingFacilityId(issueOfLinenVO.getAddedFacilityId());
                lcIssueHdr.setId(lcIssueHdrId);
                lcIssueHdr.setRequestNum(issueOfLinenVO.getRequestNum().trim());
                lcIssueHdr.setIssueDate(issueOfLinenVO.getIssueDate());
				lcIssueHdr.setIssuedBy(issueOfLinenVO.getIssueBy());
                lcIssueDtlId.setLcIssueHdr(lcIssueHdr);
                lcLinenItem.setLinenItem(element.getLinenItem().trim());
                lcIssueDtlId.setLcLinenItem(lcLinenItem);
                lcIssueDtl.setId(lcIssueDtlId);
                lcIssueDtl.setIssuedQty(element.getCurrentIssueQty());
                lcIssueDtl.setRemarks(element.getRemark());
                lcIssueDtl.setRequestNum(issueOfLinenVO.getRequestNum().trim());
                lcIssueDtl.setAddedById(issueOfLinenVO.getAddedById());
                lcIssueDtl.setAddedDate(issueOfLinenVO.getAddedDate());
                lcIssueDtl.setAddedAtWsNo(issueOfLinenVO.getAddedAtWsNo());
                lcIssueDtl.setAddedFacilityId(issueOfLinenVO.getAddedFacilityId());
                lcIssueDtl.setModifiedAtWsNo(issueOfLinenVO.getModifiedAtWsNo());
                lcIssueDtl.setModifiedById(issueOfLinenVO.getModifiedById());
                lcIssueDtl.setModifiedDate(issueOfLinenVO.getModifiedDate());
                lcIssueDtl.setModifiedFacilityId(issueOfLinenVO.getModifiedFacilityId());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        issueList.add(createList);
        return issueList;
    }

    public Object convertDO2VO(Object oDO)
        throws AssemblerException
    {
        List requestsList = new ArrayList();
        RequestsListVO requestsListVO;
        for(Iterator iter = ((List)oDO).iterator(); iter.hasNext(); requestsList.add(requestsListVO))
        {
            LcRequestDtl lcRequestDtl = (LcRequestDtl)iter.next();
            requestsListVO = new RequestsListVO();
            requestsListVO.setLinenItem(lcRequestDtl.getId().getLcLinenItem().getLinenItem());
            requestsListVO.setShortDesc(lcRequestDtl.getId().getLcLinenItem().getShortDesc());
            requestsListVO.setSourceCode(lcRequestDtl.getId().getLcRequestHdr().getSourceCode());
            requestsListVO.setSourceType(lcRequestDtl.getId().getLcRequestHdr().getSourceType());
            requestsListVO.setRequestedQty(lcRequestDtl.getRequestedQty());
            requestsListVO.setRequestNo(lcRequestDtl.getId().getLcRequestHdr().getId().getRequestNum());
            IBADateTime reqDate = new IBADateTime(lcRequestDtl.getId().getLcRequestHdr().getRequestDate());
            reqDate.setPattern("dd/MM/yyyy HH:mm");
            requestsListVO.setRequestDate(reqDate);
            requestsListVO.setRaisedBy(lcRequestDtl.getId().getLcRequestHdr().getRaisedBy());
            requestsListVO.setRequestStatus(lcRequestDtl.getId().getLcRequestHdr().getRequestStatus());
        }

        return requestsList;
    }

    public static final Logger logger = LogFactory.getApplicationLogger();

}
