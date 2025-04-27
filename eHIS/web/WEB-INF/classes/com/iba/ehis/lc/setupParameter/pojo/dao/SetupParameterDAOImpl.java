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
package com.iba.ehis.lc.setupParameter.pojo.dao;

import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.pojo.dao.AppDAOImpl;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.core.vo.AppVO;

import com.iba.ehis.dobj.LcParamForFacility;

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
public class SetupParameterDAOImpl extends AppDAOImpl {
	public AppAssembler appAssembler = new AppAssembler();

	public DTO getMasterType(AppVO appVo) {

		DTO dto = new DTO();
		DAOCommand command = new DAOCommand();
		try {
			command.setObject(appVo.getAddedFacilityId());
			command.setEntityClass(LcParamForFacility.class);
			dto = (DTO) super.findById(command);
			dto.setObject(getAppAssembler().convertDO2VO(dto.getObject()));
		} catch (AssemblerException e) {
			IBALogger.getLogger().debug(this.getClass(),
					"SetupParameterDAOImpl--------exception--------->", null);

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}

	public DTO insertMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {
		LcParamForFacility lcParamForFacility=new LcParamForFacility();
		IBALogger.getLogger().debug(this.getClass(),
				"SetupParameterDAOImpl--------b4Assembler-------->", null);
		lcParamForFacility =(LcParamForFacility)getAppAssembler().convertVO2DO(appVo);
		IBALogger.getLogger().debug(this.getClass(),
				"SetupParameterDAOImpl--------After Assembler-------->"+lcParamForFacility.getOperatingFacilityId(), null);
		super.create(lcParamForFacility);
		DTO dto = new DTO();
		dto.setObject(appVo);
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

	public DTO updateMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {
		super.update(getAppAssembler().convertVO2DO(appVo));
		DTO dto = new DTO();
		dto.setObject(appVo);
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

}
