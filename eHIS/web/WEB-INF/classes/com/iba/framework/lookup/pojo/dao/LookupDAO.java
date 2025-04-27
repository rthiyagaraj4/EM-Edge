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
import com.iba.framework.core.pojo.dao.DAO;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.Page;
import com.iba.framework.lookup.vo.LookupVO;

public interface LookupDAO extends DAO
{

    public abstract DTO lookupByQuery(LookupVO lookupvo, Page page, String s)
        throws ApplicationException;
}
