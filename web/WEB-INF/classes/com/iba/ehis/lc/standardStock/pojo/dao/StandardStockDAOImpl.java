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
package com.iba.ehis.lc.standardStock.pojo.dao;

import java.util.List;

import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.pojo.dao.AppDAOImpl;
import com.iba.ehis.core.vo.AppVO;

import com.iba.ehis.dobj.LcStdLinenStkDtl;
import com.iba.ehis.lc.standardStock.util.StandardStockAssembler;
import com.iba.ehis.lc.standardStock.vo.StandardStockVO;
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
public class StandardStockDAOImpl extends AppDAOImpl {

	public DTO getMasterType(AppVO appVo) {
		(IBALogger.getLogger()).debug(this.getClass(),
				"StandardStockDAOImpl-------->", null);
		DAOCommand command = new DAOCommand();
		DTO dto = new DTO();
		StandardStockVO standardStockVO = (StandardStockVO) appVo;
		try {

			command.setObject(standardStockVO.getSourceCode());
			(IBALogger.getLogger()).debug(this.getClass(),
					"StandardStockDAOImpl-----1--->" + command.getObject(),
					null);

			command.setEntityClass(LcStdLinenStkDtl.class);
			(IBALogger.getLogger()).debug(this.getClass(),
					"StandardStockDAOImpl-----2---->"
							+ command.getEntityClass(), null);
			dto = (DTO) super.findById(command);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			dto.setObject(((StandardStockAssembler) getAppAssembler())
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
		super.CreateOrUpdate(((StandardStockAssembler) getAppAssembler())
				.convertVO2DO1(appVo));
		List list = (List) ((StandardStockAssembler) getAppAssembler())
				.convertVO2DO(appVo);
		if (((List) list.get(0)).size() > 0)
			super.CreateOrUpdate(((List) list.get(0)).toArray());
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

	public DTO updateMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {
		DTO dto = new DTO();
		super.update(((StandardStockAssembler) getAppAssembler())
				.convertVO2DO1(appVo));
		List list = (List) ((StandardStockAssembler) getAppAssembler())
				.convertVO2DO(appVo);
		try {
			if (((List) list.get(0)).size() > 0)
				super.update(((List) list.get(0)).toArray());
			dto.setStatus(Constants.SUCCESS);
		} catch (Exception e) {
			dto.setStatus(Constants.FAILED);
		}
		return dto;
	}

}
