/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Aug 17, 2006
 */
package com.iba.framework.lookup.pojo.business;

import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.pojo.business.IFacade;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.Page;
import com.iba.framework.lookup.vo.LookupVO;

/**
 * @author Sabarinathan S
 * @version
 */
public interface Lookup extends IFacade {
	public DTO lookupByQuery(LookupVO lookupValue, Page page, String sessionId)
			throws ApplicationException;
}
