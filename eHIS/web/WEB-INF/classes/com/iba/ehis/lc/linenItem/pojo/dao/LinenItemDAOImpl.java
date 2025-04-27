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
package com.iba.ehis.lc.linenItem.pojo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.pojo.dao.AppDAOImpl;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.ehis.core.util.VODOMapReader;
import com.iba.ehis.dobj.LcLinenItem;
import com.iba.ehis.lc.laundryUser.util.LaundryUserAssembler;
import com.iba.ehis.lc.linenItem.util.LinenItemAssembler;
import com.iba.ehis.lc.linenItem.vo.LinenItemVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DAOCommand;
import com.iba.framework.core.util.DTO;
import com.iba.framework.logging.pojo.business.IBALogger;

/**
 * @author yadavk
 * 
 */
public class LinenItemDAOImpl extends AppDAOImpl {
	public AppAssembler appAssembler = new AppAssembler();

	public DTO getMasterType(AppVO appVo) {
		DAOCommand command = new DAOCommand();
		try {
			LcLinenItem linenItem = new LcLinenItem();
			linenItem.setLinenItem(((LinenItemVO) appVo).getLinenItem());

			command.setObject(linenItem.getLinenItem());
			command.setEntityClass(LcLinenItem.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		DTO dto = (DTO) super.findById(command);
		try {
			dto.setObject(((LinenItemAssembler) getAppAssembler())
					.convertDO2VO(dto.getObject()));
		} catch (AssemblerException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public DTO deleteMasterType(AppVO appVo) throws AssemblerException,
			ApplicationException {

		DTO dto = new DTO();
		try {
			super.delete(((LinenItemAssembler) getAppAssembler())
					.convertVO2DO(appVo));
		} catch (Exception e) {
			dto.setStatus(Constants.FAILED);
		}
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

	public DTO updateMasterType(AppVO appVo) throws AssemblerException,
			ApplicationException {

		DTO dto = new DTO();
		try {
			super.update(((LinenItemAssembler) getAppAssembler())
					.convertVO2DO(appVo));
		} catch (Exception e) {
			dto.setStatus(Constants.FAILED);
		}
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

	public DTO insertMasterType(AppVO appVo) throws AssemblerException,
			ApplicationException {

		DTO dto = new DTO();
		try {
			super.create(((LinenItemAssembler) getAppAssembler())
					.convertVO2DO(appVo));
		} catch (Exception e) {
			dto.setStatus(Constants.FAILED);
		}
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}
}
