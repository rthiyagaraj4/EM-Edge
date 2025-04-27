/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.core.pojo.business;

import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.pojo.business.IFacade;
import com.iba.framework.core.util.DTO;

public interface AppIFacade extends IFacade {
	public DTO createMaster(AppVO appVo) throws ApplicationException;

	public DTO updateMaster(AppVO appVo) throws ApplicationException;

	public DTO queryMaster(QueryResultVO queryResultVo)
			throws ApplicationException;

	public DTO deleteMaster(AppVO appVo) throws ApplicationException;

	public DTO getMaster(AppVO appVo) throws ApplicationException;
}
