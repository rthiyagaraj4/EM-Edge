/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package com.iba.ehis.core.pojo.dao;

import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.pojo.dao.DAO;
import com.iba.framework.core.util.DTO;

public interface AppDAO extends DAO {
	public DTO insertMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException;

	public DTO updateMasterType(AppVO appVo) throws ApplicationException,
			AssemblerException;

	public DTO queryMasterType(QueryResultVO queryResultVo)
			throws ApplicationException, AssemblerException;

	public DTO deleteMasterType(AppVO appVo) throws ApplicationException,
			AssemblerException;

	public DTO getMasterType(AppVO appVo) throws ApplicationException,
			AssemblerException;

}
