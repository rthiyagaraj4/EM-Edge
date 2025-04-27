/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// 
// aUTHOR: Yadav K
// Source File Name:   ReturnofLinentoLaundryAssembler.java

package com.iba.ehis.lc.returnofLinentoLaundry.util;

import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.dobj.*;
import com.iba.ehis.lc.returnofLinentoLaundry.vo.LinenRecordList;
import com.iba.ehis.lc.returnofLinentoLaundry.vo.ReturnofLinentoLaundryVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.AutoGenerationList;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.logging.pojo.business.Logger;
import java.util.*;

public class ReturnofLinentoLaundryAssembler extends AppAssembler
{

    public ReturnofLinentoLaundryAssembler()
    {
    }

    public Object convertVO2DO(BaseVO vo)
        throws AssemblerException
    {
        int index = 0;
        DTO dto = new DTO();
        List createList = new ArrayList();
        List LinenRequestList = new ArrayList();
        List updateList = new ArrayList();
        ReturnofLinentoLaundryVO returnofLinentoLaundryVO = (ReturnofLinentoLaundryVO)vo;
        for(Iterator iter = returnofLinentoLaundryVO.getLinenRequest().iterator(); iter.hasNext();)
            try
            {
                LcLinenReturnDtl lcLinenReturnDtl = new LcLinenReturnDtl();
                LcLinenReturnDtlId lcLinenReturnDtlId = new LcLinenReturnDtlId();
                LcLinenReturnHdr lcLinenReturnHdr = new LcLinenReturnHdr();
                LcLinenReturnHdrId lcLinenReturnHdrId = new LcLinenReturnHdrId();
                LcLinenItem lcLinenItem = new LcLinenItem();
                LinenRecordList element = (LinenRecordList)iter.next();
                lcLinenReturnHdrId.setOperatingFacilityId(returnofLinentoLaundryVO.getAddedFacilityId());
                lcLinenReturnHdrId.setRefNum(returnofLinentoLaundryVO.getReferenceNum().trim());
                lcLinenReturnHdr.setId(lcLinenReturnHdrId);
                lcLinenReturnDtlId.setLcLinenReturnHdr(lcLinenReturnHdr);
                lcLinenReturnDtl.setId(lcLinenReturnDtlId);
                IBALogger.getLogger().debug(getClass(), lcLinenReturnHdr.getId().getOperatingFacilityId() + "****lcLinenReturnHdr.getAddedFacilityId()****", null);
                lcLinenReturnHdr.setSourceCode(returnofLinentoLaundryVO.getSourceCode());
                lcLinenReturnHdr.setSourceType(returnofLinentoLaundryVO.getSourceType());
                lcLinenReturnHdr.setRefDate(returnofLinentoLaundryVO.getRequestDate());
                lcLinenReturnDtlId.setLcLinenReturnHdr(lcLinenReturnHdr);
                lcLinenReturnDtlId.setLinenItem(element.getLinenItem());
                lcLinenReturnDtl.setId(lcLinenReturnDtlId);
                lcLinenReturnDtl.setReturnedQty(element.getReturnedQty());
                lcLinenReturnDtl.setRemarks(element.getRemark());
                lcLinenReturnDtl.setAddedById(returnofLinentoLaundryVO.getAddedById());
                lcLinenReturnDtl.setAddedDate(returnofLinentoLaundryVO.getAddedDate());
                lcLinenReturnDtl.setAddedAtWsNo(returnofLinentoLaundryVO.getAddedAtWsNo());
                lcLinenReturnDtl.setAddedFacilityId(returnofLinentoLaundryVO.getAddedFacilityId());
                lcLinenReturnDtl.setModifiedAtWsNo(returnofLinentoLaundryVO.getModifiedAtWsNo());
                lcLinenReturnDtl.setModifiedById(returnofLinentoLaundryVO.getModifiedById());
                lcLinenReturnDtl.setModifiedDate(returnofLinentoLaundryVO.getModifiedDate());
                lcLinenReturnDtl.setModifiedFacilityId(returnofLinentoLaundryVO.getModifiedFacilityId());
                createList.add(lcLinenReturnDtl);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        IBALogger.getLogger().debug(getClass(), createList.getClass() + "createList---------->convertVO2DO ", null);
        LinenRequestList.add(createList);
        return LinenRequestList;
    }

    public Object convertVO2DO1(Object vo)
        throws AssemblerException
    {
        LcLinenReturnDtl lcLinenReturnDtl = new LcLinenReturnDtl();
        LcLinenReturnDtlId lcLinenReturnDtlId = new LcLinenReturnDtlId();
        LcLinenReturnHdr lcLinenReturnHdr = new LcLinenReturnHdr();
        LcLinenReturnHdrId lcLinenReturnHdrId = new LcLinenReturnHdrId();
        try
        {
            ReturnofLinentoLaundryVO returnofLinentoLaundryVO = (ReturnofLinentoLaundryVO)vo;
            lcLinenReturnHdrId.setOperatingFacilityId(returnofLinentoLaundryVO.getAddedFacilityId());
            lcLinenReturnHdrId.setRefNum(returnofLinentoLaundryVO.getReferenceNum());
            lcLinenReturnHdr.setId(lcLinenReturnHdrId);
            lcLinenReturnDtlId.setLcLinenReturnHdr(lcLinenReturnHdr);
            lcLinenReturnDtl.setId(lcLinenReturnDtlId);
            lcLinenReturnHdr.setSourceCode(returnofLinentoLaundryVO.getSourceCode());
            lcLinenReturnHdr.setSourceType(returnofLinentoLaundryVO.getSourceType());
            lcLinenReturnHdr.setRefDate(returnofLinentoLaundryVO.getRequestDate());
            lcLinenReturnHdr.setReturnedBy(returnofLinentoLaundryVO.getReturnedBy());
            lcLinenReturnHdr.setReceivedBy(returnofLinentoLaundryVO.getReceivedBy());
            lcLinenReturnHdr.setAddedById(returnofLinentoLaundryVO.getAddedById());
            lcLinenReturnHdr.setAddedDate(returnofLinentoLaundryVO.getAddedDate());
            lcLinenReturnHdr.setAddedAtWsNo(returnofLinentoLaundryVO.getAddedAtWsNo());
            lcLinenReturnHdr.setAddedFacilityId(returnofLinentoLaundryVO.getAddedFacilityId());
            lcLinenReturnHdr.setModifiedAtWsNo(returnofLinentoLaundryVO.getModifiedAtWsNo());
            lcLinenReturnHdr.setModifiedById(returnofLinentoLaundryVO.getModifiedById());
            lcLinenReturnHdr.setModifiedDate(returnofLinentoLaundryVO.getModifiedDate());
            lcLinenReturnHdr.setModifiedFacilityId(returnofLinentoLaundryVO.getModifiedFacilityId());
        }
        catch(Exception exception) { }
        return lcLinenReturnHdr;
    }
}
