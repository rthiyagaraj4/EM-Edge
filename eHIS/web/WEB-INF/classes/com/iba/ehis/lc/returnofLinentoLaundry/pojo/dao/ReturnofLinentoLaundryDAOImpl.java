/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.returnofLinentoLaundry.pojo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.dobj.LcLinenReturnDtl;
import com.iba.ehis.lc.core.pojo.dao.LcDAOImpl;
import com.iba.ehis.lc.returnofLinentoLaundry.util.ReturnofLinentoLaundryAssembler;
import com.iba.ehis.lc.returnofLinentoLaundry.vo.ReturnofLinentoLaundryVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DAOCommand;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.DateUtil;

public class ReturnofLinentoLaundryDAOImpl extends LcDAOImpl {

	public DTO getMasterType(AppVO appVo) throws ApplicationException,
			AssemblerException {
		DTO dto = new DTO();
		DAOCommand command = new DAOCommand();

		try {
			command.setObject(((ReturnofLinentoLaundryVO) appVo)
					.getReferenceNum());
			command.setEntityClass(LcLinenReturnDtl.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		DTO dto2 = (DTO) super.findById(command);
		try {
			dto.setObject(((ReturnofLinentoLaundryAssembler) getAppAssembler())
					.convertDO2VO(dto.getObject()));
		} catch (AssemblerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dto;
	}

	public DTO insertMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {

		DTO dto = new DTO();
		super.create(((ReturnofLinentoLaundryAssembler) getAppAssembler())
				.convertVO2DO1(appVo));
		List list = (List) ((ReturnofLinentoLaundryAssembler) getAppAssembler())
				.convertVO2DO(appVo);
		if (((List) list.get(0)).size() > 0)
			super.create(((List) list.get(0)).toArray());
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

}
