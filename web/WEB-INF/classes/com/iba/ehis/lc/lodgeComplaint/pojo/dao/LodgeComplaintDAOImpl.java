/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.lodgeComplaint.pojo.dao;

import java.util.List;
import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.ehis.lc.core.pojo.dao.LcDAOImpl;
import com.iba.ehis.lc.lodgeComplaint.util.LodgeComplaintAssembler;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;

public class LodgeComplaintDAOImpl extends LcDAOImpl {

	public DTO insertMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {

		DTO dto = new DTO();
		super.create(((LodgeComplaintAssembler) getAppAssembler())
				.convertVO2DO1(appVo));
		List list = (List) ((LodgeComplaintAssembler) getAppAssembler())
				.convertVO2DO(appVo);
		if (((List) list.get(0)).size() > 0)
			super.create(((List) list.get(0)).toArray());
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

	public DTO queryMasterType(QueryResultVO resultVo)
			throws ApplicationException {

		DTO dto = super.queryMasterType(resultVo);

		return dto;
	}

}
