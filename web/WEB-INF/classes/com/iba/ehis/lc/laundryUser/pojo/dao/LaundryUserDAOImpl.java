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
package com.iba.ehis.lc.laundryUser.pojo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.pojo.dao.AppDAOImpl;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.ehis.dobj.LcUsers;
import com.iba.ehis.dobj.LcUsersId;
import com.iba.ehis.lc.laundryUser.util.LaundryUserAssembler;
import com.iba.ehis.lc.laundryUser.vo.LaundryUserVO;
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
public class LaundryUserDAOImpl extends AppDAOImpl {

	public DTO getMasterType(AppVO appVo) {

		DTO dto = new DTO();
		DAOCommand command = new DAOCommand();
		try {
			LcUsersId id = new LcUsersId();
			LcUsers lcUsers = new LcUsers();
			id.setLaundryUserId(((LaundryUserVO) appVo).getUser());
			id.setOperatingFacilityId(appVo.getAddedFacilityId());
			lcUsers.setId(id);
			command.setObject(lcUsers.getId());
			command.setEntityClass(LcUsers.class);
			dto = (DTO) super.findById(command);
			dto.setObject(((LaundryUserAssembler) getAppAssembler())
					.convertDO2VO(dto.getObject()));
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

		DTO dto = new DTO();
		super.create(((LaundryUserAssembler) getAppAssembler())
				.convertVO2DO(appVo));

		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

	public DTO updateMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {

		DTO dto = new DTO();
		super.update(((LaundryUserAssembler) getAppAssembler())
				.convertVO2DO(appVo));
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

	public DTO deleteMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {

		DTO dto = new DTO();
		super.delete(((LaundryUserAssembler) getAppAssembler())
				.convertVO2DO(appVo));
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

}
