/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.lookup.pojo.dao;

import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.pojo.dao.DAOImpl;
import com.iba.framework.core.util.*;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;
import com.iba.framework.lookup.vo.LookupVO;
import java.util.*;
import org.apache.commons.collections.map.LinkedMap;

// Referenced classes of package com.iba.framework.lookup.pojo.dao:
//            LookupDAO

public class LookupDAOImpl extends DAOImpl
    implements LookupDAO
{

    public LookupDAOImpl()
    {
    }

    public DTO lookupByQuery(LookupVO lookupVO, Page page, String sessionId)
        throws ApplicationException
    {
        NamedQuery query = new NamedQuery();
        query.setQueryID(lookupVO.getQueryId());
        query.setDataMap(lookupVO.getLookupParameters());
        if(page == null)
        {
            page = new Page();
            page.setPagingEnabled(false);
        }
        query.setPage(page);
        String orderBy = lookupVO.getLookupParameters().get("searchBy") != null ? (String)lookupVO.getLookupParameters().get("searchBy") : "";
        if(orderBy.equals("code"))
            orderBy = "1,2";
        else
            orderBy = "2,1";
        query.setOrderByClause(orderBy);
        DAOCommand command = new DAOCommand();
        command.setObject(query);
        DTO dto = (DTO)findByQuery(command);
        Iterator iterator = ((List)dto.getObject()).iterator();
        Map keyValueMap = new LinkedMap();
        while(iterator.hasNext()) 
        {
            Object record[] = (Object[])iterator.next();
            if(record.length == 2)
                keyValueMap.put(record[0], record[1]);
            else
                keyValueMap.put(record[0], ((Object) (record)));
        }
        lookupVO.setLookupResults(keyValueMap);
        dto.setObject(lookupVO);
        return dto;
    }

    public static final Logger logger = LogFactory.getApplicationLogger();

}
