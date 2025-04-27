/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Author:Yadav kar
// Source File Name:   LodgeComplaintAssembler.java

package com.iba.ehis.lc.lodgeComplaint.util;

import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.dobj.*;
import com.iba.ehis.lc.lodgeComplaint.vo.LodgeComplaintList;
import com.iba.ehis.lc.lodgeComplaint.vo.LodgeComplaintVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.*;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import java.util.*;

public class LodgeComplaintAssembler extends AppAssembler
{

    public LodgeComplaintAssembler()
    {
    }

    public Object convertVO2DO(BaseVO vo)
        throws AssemblerException
    {
        List complaintList = new ArrayList();
        List createList = new ArrayList();
        LodgeComplaintVO lodgeComplaintVO = (LodgeComplaintVO)vo;
        for(Iterator iter = lodgeComplaintVO.getComplaintList().iterator(); iter.hasNext();)
            try
            {
                LcComplaintDtl lcComplaintDtl = new LcComplaintDtl();
                LcComplaintDtlId lcComplaintDtlId = new LcComplaintDtlId();
                LcComplaintHdr lcComplaintHdr = new LcComplaintHdr();
                LcComplaintHdrId lcComplaintHdrId = new LcComplaintHdrId();
                LcReason lcReason = new LcReason();
                LodgeComplaintList element = (LodgeComplaintList)iter.next();
                lcComplaintHdrId.setComplaintNum(lodgeComplaintVO.getComplaintNum());
                lcComplaintHdrId.setOperatingFacilityId(lodgeComplaintVO.getAddedFacilityId());
                lcComplaintHdr.setId(lcComplaintHdrId);
                lcComplaintHdr.setComplaintActivity(lodgeComplaintVO.getComplaintActivity());
                lcComplaintHdr.setComplaintAgnSourceCode(lodgeComplaintVO.getComplaintAgainstSource());
                lcComplaintHdr.setComplaintAgnSourceType(lodgeComplaintVO.getComplaintAgainstSourceType());
                lcComplaintHdr.setComplaintBy(lodgeComplaintVO.getComplaintBy());
                lcComplaintHdr.setComplaintDate(lodgeComplaintVO.getComplaintDate());
                lcComplaintHdr.setComplaintSourceCode(lodgeComplaintVO.getComplaintSource());
                lcComplaintHdr.setComplaintSourceType(lodgeComplaintVO.getComplaintSourceType());
                lcReason.setReasonCode(lodgeComplaintVO.getComplaint());
                lcReason.setReasonDesc(lodgeComplaintVO.getComplaintDesc());
                lcComplaintHdr.setLcReason(lcReason);
                lcComplaintDtlId.setLcComplaintHdr(lcComplaintHdr);
                lcComplaintDtlId.setRefRequestNum(element.getReferenceRequestNum());
                lcComplaintDtl.setId(lcComplaintDtlId);
                lcComplaintDtl.setLinenItem(element.getLinenItem());
                lcComplaintDtl.setQty(element.getQuantity());
                lcComplaintDtl.setRefRequestDate(element.getReferenceRequestDate());
                lcComplaintDtl.setAddedById(lodgeComplaintVO.getAddedById());
                lcComplaintDtl.setAddedDate(lodgeComplaintVO.getAddedDate());
                lcComplaintDtl.setAddedAtWsNo(lodgeComplaintVO.getAddedAtWsNo());
                lcComplaintDtl.setAddedFacilityId(lodgeComplaintVO.getAddedFacilityId());
                lcComplaintDtl.setModifiedAtWsNo(lodgeComplaintVO.getModifiedAtWsNo());
                lcComplaintDtl.setModifiedById(lodgeComplaintVO.getModifiedById());
                lcComplaintDtl.setModifiedDate(lodgeComplaintVO.getModifiedDate());
                lcComplaintDtl.setModifiedFacilityId(lodgeComplaintVO.getModifiedFacilityId());
                createList.add(lcComplaintDtl);
            }
            catch(Exception e)
            {
                IBALogger.getLogger().debug(getClass(), "RequestForLinenAssembler---------->convertVO2DO ", null);
                e.printStackTrace();
            }

        complaintList.add(createList);
        return complaintList;
    }

    public Object convertVO2DO1(Object vo)
        throws AssemblerException
    {
        LodgeComplaintVO lodgeComplaintVO = (LodgeComplaintVO)vo;
        LcComplaintHdr lcComplaintHdr = new LcComplaintHdr();
        LcComplaintHdrId lcComplaintHdrId = new LcComplaintHdrId();
        LcReason lcReason = new LcReason();
        try
        {
            lcComplaintHdrId.setComplaintNum(lodgeComplaintVO.getComplaintNum());
            lcComplaintHdrId.setOperatingFacilityId(lodgeComplaintVO.getAddedFacilityId());
            lcComplaintHdr.setId(lcComplaintHdrId);
            lcComplaintHdr.setComplaintActivity(lodgeComplaintVO.getComplaintActivity());
            lcComplaintHdr.setComplaintAgnSourceCode(lodgeComplaintVO.getComplaintAgainstSource());
            lcComplaintHdr.setComplaintAgnSourceType(lodgeComplaintVO.getComplaintAgainstSourceType());
            lcComplaintHdr.setComplaintBy(lodgeComplaintVO.getComplaintBy());
            lcComplaintHdr.setComplaintDate(lodgeComplaintVO.getComplaintDate());
            lcComplaintHdr.setComplaintSourceCode(lodgeComplaintVO.getComplaintSource());
            lcComplaintHdr.setComplaintSourceType(lodgeComplaintVO.getComplaintSourceType());
            lcReason.setReasonCode(lodgeComplaintVO.getComplaint());
            lcReason.setReasonDesc(lodgeComplaintVO.getComplaintDesc());
            lcComplaintHdr.setLcReason(lcReason);
            lcComplaintHdr.setAddedById(lodgeComplaintVO.getAddedById());
            lcComplaintHdr.setAddedDate(lodgeComplaintVO.getAddedDate());
            lcComplaintHdr.setAddedAtWsNo(lodgeComplaintVO.getAddedAtWsNo());
            lcComplaintHdr.setAddedFacilityId(lodgeComplaintVO.getAddedFacilityId());
            lcComplaintHdr.setModifiedAtWsNo(lodgeComplaintVO.getModifiedAtWsNo());
            lcComplaintHdr.setModifiedById(lodgeComplaintVO.getModifiedById());
            lcComplaintHdr.setModifiedDate(lodgeComplaintVO.getModifiedDate());
            lcComplaintHdr.setModifiedFacilityId(lodgeComplaintVO.getModifiedFacilityId());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return lcComplaintHdr;
    }

    public Object convertVO2DO(Object vo)
        throws AssemblerException
    {
        return super.convertVO2DO(vo);
    }
}
