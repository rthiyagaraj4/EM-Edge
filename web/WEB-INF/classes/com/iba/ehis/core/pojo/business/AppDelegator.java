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
import com.iba.ehis.core.util.AppConstants;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.pojo.business.BaseBusinessDelegate;
import com.iba.framework.core.util.DTO;
import com.iba.framework.logging.pojo.business.IBALogger;

public class AppDelegator extends BaseBusinessDelegate {

	public DTO createTypeMaster(AppVO appVo) throws ApplicationException {
		DTO dto = null;

		try {
			dto = ((AppIFacade) getFacade()).createMaster(appVo);
			dto.setStatus(AppConstants.SUCCESS);
		} catch (ApplicationException e) {
			dto = new DTO();
			dto.setException(e);
			e.printStackTrace();
		} catch (DataIntegrityViolationException e) {
			dto = new DTO();
			dto.setException(new DuplicateRecordException(
					AppConstants.DUPLICATE_RECORD, e.getMessage()));
			dto.setStatus(AppConstants.FAILED);
		}
		return dto;
	}

	public DTO updateTypeMaster(AppVO appVo) throws ApplicationException {
		DTO dto = null;
		try {
			dto = ((AppIFacade) getFacade()).updateMaster(appVo);
		} catch (ApplicationException e) {
			dto = new DTO();
			dto.setException(e);
			e.printStackTrace();
		} catch (DataIntegrityViolationException e) {
			dto = new DTO();
			dto.setException(new DuplicateRecordException(
					AppConstants.DUPLICATE_RECORD, e.getMessage()));
			dto.setStatus(AppConstants.FAILED);
		}
		return dto;
	}

	public DTO deleteTypeMaster(AppVO appVo) throws ApplicationException {
		DTO dto = null;
		try {
			dto = ((AppIFacade) getFacade()).deleteMaster(appVo);
		} catch (DataIntegrityViolationException e) {
			dto = new DTO();
			dto.setException(e);
			IBALogger.getLogger().debug(this.getClass(),
					"Exception in AppDelegator" + e, null);
			e.printStackTrace();
			dto.setStatus(AppConstants.FAILED);
		}
		return dto;
	}

	public DTO getTypeMaster(AppVO appVo) throws ApplicationException {
		DTO dto = null;

		dto = ((AppIFacade) getFacade()).getMaster(appVo);

		return dto;
	}

	public DTO queryTypeMaster(QueryResultVO queryResultVo)
			throws ApplicationException {
		DTO dto = null;

		dto = ((AppIFacade) getFacade()).queryMaster(queryResultVo);

		return dto;
	}

}
