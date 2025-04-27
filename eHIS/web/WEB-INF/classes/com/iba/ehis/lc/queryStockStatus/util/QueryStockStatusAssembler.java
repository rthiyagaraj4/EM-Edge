/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// yadavk
// Source File Name:   QueryStockStatusAssembler.java

package com.iba.ehis.lc.queryStockStatus.util;

import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.dobj.*;
import com.iba.ehis.lc.queryStockStatus.vo.QueryStockStatusVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;
import java.util.*;

public class QueryStockStatusAssembler extends AppAssembler
{

    public QueryStockStatusAssembler()
    {
    }

    public Object convertDO2VO(Object dObj, Class classVO)
        throws AssemblerException
    {
        return convertDO2VO(dObj);
    }

    public Object convertDO2VO(Object oDO)
        throws AssemblerException
    {
        List requestsList = new ArrayList();
        QueryStockStatusVO queryStockStatusVO;
        for(Iterator iter = ((List)oDO).iterator(); iter.hasNext(); requestsList.add(queryStockStatusVO))
        {
            LcSourceStk lcSourceStk = (LcSourceStk)iter.next();
            queryStockStatusVO = new QueryStockStatusVO();
            //queryStockStatusVO.setLinenItem(lcSourceStk.getId().getLcLinenItem().getLinenItem());
            // changes for SCF 32276 - AMRI-SCF-0098
            queryStockStatusVO.setLinenItem(lcSourceStk.getId().getLcLinenItem().getShortDesc());
            // SCF 32276 changes end
            queryStockStatusVO.setSourceCode(lcSourceStk.getSourceCode());
            queryStockStatusVO.setInUseQty(lcSourceStk.getInUseQty());
            queryStockStatusVO.setLoanedQty(lcSourceStk.getLoanedQty());
            queryStockStatusVO.setSoiledQty(lcSourceStk.getSoiledQty());
        }

        return requestsList;
    }

    public static final Logger logger = LogFactory.getApplicationLogger();

}
