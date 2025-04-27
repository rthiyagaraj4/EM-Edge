/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// Author :yadavK
// Source File Name:   EnterCleanedLinenDAOImpl.java
package com.iba.ehis.lc.enterCleanedLinen.pojo.dao;

import com.iba.framework.core.util.Constants;
import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.pojo.dao.AppDAOImpl;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.ehis.lc.enterCleanedLinen.util.EnterCleanedLinenAssembler;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DTO;
import java.util.List;

public class EnterCleanedLinenDAOImpl extends AppDAOImpl
{

    public EnterCleanedLinenDAOImpl()
    {
        appAssembler = new AppAssembler();
    }

    public DTO insertMasterType(AppVO appVo)
        throws DuplicateRecordException, AssemblerException, ApplicationException
    {
        DTO dto = new DTO();
        super.create(((EnterCleanedLinenAssembler)getAppAssembler()).convertVO2DO1(appVo));
        List list = (List)((EnterCleanedLinenAssembler)getAppAssembler()).convertVO2DO(appVo);
        if(((List)(List)list.get(0)).size() > 0)
            super.create(((List)(List)list.get(0)).toArray());
        dto.setStatus(Constants.SUCCESS);
        return dto;
    }

    public DTO updateMasterType(AppVO appVo)
        throws DuplicateRecordException, AssemblerException, ApplicationException
    {
        DTO dto = new DTO();
        super.update(((EnterCleanedLinenAssembler)getAppAssembler()).convertVO2DO1(appVo));
        List list = (List)((EnterCleanedLinenAssembler)getAppAssembler()).convertVO2DO(appVo);
        try
        {
            if(((List)(List)list.get(0)).size() > 0)
                super.update(((List)(List)list.get(0)).toArray());
            dto.setStatus(Constants.SUCCESS);
        }
        catch(Exception e)
        {
            dto.setStatus(Constants.FAILED);
        }
        return dto;
    }

    public DTO queryMasterType(QueryResultVO resultVo)
        throws ApplicationException
    {
        DTO dto = new DTO();
        dto = super.queryMasterType(resultVo);
        return dto;
    }

    public AppAssembler appAssembler;
}
