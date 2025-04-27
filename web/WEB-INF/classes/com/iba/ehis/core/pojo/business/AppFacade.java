/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.core.pojo.business;

import org.springframework.dao.DataIntegrityViolationException;

import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.pojo.dao.AppDAO;
import com.iba.ehis.core.util.AppConstants;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.pojo.business.BaseFacade;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.logging.pojo.business.IBALogger;

public class AppFacade extends BaseFacade implements AppIFacade {

	private AppDAO masterDAO;

	public DTO createMaster(AppVO appVo) throws ApplicationException {

		DTO dto = null;
		try {
			dto = masterDAO.insertMasterType(appVo);
			IBALogger.getLogger().debug(this.getClass(),
					"HIHIHIHIHIHIHIHIHIHIHIH7", null);
		} catch (DuplicateRecordException e) {
			dto = new DTO();
			dto.setMessageId(e.getErrorCode());
			dto.setException(e);
		} catch (DataIntegrityViolationException e) {
			dto = new DTO();
			dto.setException(new DuplicateRecordException(
					AppConstants.DUPLICATE_RECORD, e.getMessage()));
		}
		if (dto.getException() == null) {
			dto.setStatus(Constants.SUCCESS);

		} else {
			dto.setStatus(Constants.FAILED);

		}
		return dto;
	}

	public DTO updateMaster(AppVO appVo) throws ApplicationException {
		DTO dto = null;
		try {
			dto = masterDAO.updateMasterType(appVo);

		} catch (DuplicateRecordException e) {
			dto = new DTO();
			dto.setMessageId(e.getErrorCode());
			dto.setException(e);
		} catch (DataIntegrityViolationException e) {
			dto = new DTO();
			dto.setException(new DuplicateRecordException(
					AppConstants.DUPLICATE_RECORD, e.getMessage()));
		}
		if (dto.getException() == null) {
			dto.setStatus(Constants.SUCCESS);

		} else {
			dto.setStatus(Constants.FAILED);
		}
		return (dto == null ? new DTO() : dto);
	}

	public DTO deleteMaster(AppVO appVo) throws ApplicationException {
		DTO dto = null;
		dto = masterDAO.deleteMasterType(appVo);
		dto.setStatus(Constants.SUCCESS);
		return (dto == null ? new DTO() : dto);
	}

	public DTO queryMaster(QueryResultVO queryResultVo)
			throws ApplicationException {
		return masterDAO.queryMasterType(queryResultVo);
	}

	public DTO getMaster(AppVO appVo) throws ApplicationException {

		return masterDAO.getMasterType(appVo);
	}

	public AppDAO getMasterDAO() {
		return masterDAO;
	}

	public void setMasterDAO(AppDAO masterDAO) {
		this.masterDAO = masterDAO;
	}
}
