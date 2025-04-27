/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// yadavK
// Source File Name:   QueryLinenStockStatusAssembler.java

package com.iba.ehis.lc.queryStockStatus.util;

import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.lc.queryStockStatus.vo.QueryStockStatusVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;
import java.util.*;

public class QueryLinenStockStatusAssembler extends AppAssembler
{

    public QueryLinenStockStatusAssembler()
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
        for(Iterator iter = ((List)oDO).iterator(); iter.hasNext();)
            try
            {
                Object obj[] = (Object[])iter.next();
                QueryStockStatusVO queryStockStatusVO = new QueryStockStatusVO();
                queryStockStatusVO.setLinenItem((String)obj[0]);
                queryStockStatusVO.setSourceCode((String)obj[1]);
                queryStockStatusVO.setInUseQty((Long)obj[2]);
                queryStockStatusVO.setLoanedQty((Long)obj[3]);
                queryStockStatusVO.setSoiledQty((Long)obj[4]);
                // changes for SCF 32276 - AMRI-SCF-0098
                queryStockStatusVO.setSourceType((String)obj[5]);
                // SCF 32276 changes end
                requestsList.add(queryStockStatusVO);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        return requestsList;
    }

    public static final Logger logger = LogFactory.getApplicationLogger();

}
