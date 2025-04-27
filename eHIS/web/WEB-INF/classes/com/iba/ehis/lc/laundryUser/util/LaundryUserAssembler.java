/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.laundryUser.util;

import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.dobj.LcUsers;
import com.iba.ehis.dobj.LcUsersId;
import com.iba.ehis.lc.laundryUser.vo.LaundryUserVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DTO;
import com.iba.framework.logging.pojo.business.IBALogger;

public class LaundryUserAssembler extends AppAssembler {
	public Object convertVO2DO(Object vo) throws AssemblerException {
		DTO dto = new DTO();

		LaundryUserVO laundryUserVO = (LaundryUserVO) vo;
		LcUsers lcUsersDo = new LcUsers();
		LcUsersId lcUsersIdDo = new LcUsersId();

		lcUsersIdDo.setLaundryUserId(laundryUserVO.getUser());
		lcUsersIdDo.setOperatingFacilityId(laundryUserVO.getAddedFacilityId());
		lcUsersDo.setId(lcUsersIdDo);
		lcUsersDo.setOverrideWardConf(laundryUserVO.getOverRideWardConf());

		lcUsersDo.setAddedById(laundryUserVO.getAddedById());
		lcUsersDo.setAddedDate(laundryUserVO.getAddedDate());
		lcUsersDo.setAddedAtWsNo(laundryUserVO.getAddedAtWsNo());
		lcUsersDo.setAddedFacilityId(laundryUserVO.getAddedFacilityId());
		lcUsersDo.setModifiedAtWsNo(laundryUserVO.getModifiedAtWsNo());
		lcUsersDo.setModifiedById(laundryUserVO.getModifiedById());
		lcUsersDo.setModifiedDate(laundryUserVO.getModifiedDate());
		lcUsersDo.setModifiedFacilityId(laundryUserVO.getModifiedFacilityId());

		return lcUsersDo;
	}

	public Object convertDO2VO(Object oDO, String sessionId)
			throws AssemblerException {

		LcUsers lcUsersDo = new LcUsers();
		LaundryUserVO laundryUserVO = new LaundryUserVO();
		try {

			laundryUserVO.setOverRideWardConf(lcUsersDo.getOverrideWardConf());
			laundryUserVO.setUser(lcUsersDo.getId().getLaundryUserId());
			laundryUserVO.setAddedById(lcUsersDo.getAddedById());
			laundryUserVO.setAddedDate(lcUsersDo.getAddedDate());
			laundryUserVO.setAddedAtWsNo(lcUsersDo.getAddedAtWsNo());
			laundryUserVO.setAddedFacilityId(lcUsersDo.getId()
					.getOperatingFacilityId());
			laundryUserVO.setModifiedAtWsNo(lcUsersDo.getModifiedAtWsNo());
			laundryUserVO.setModifiedById(lcUsersDo.getModifiedById());
			laundryUserVO.setModifiedDate(lcUsersDo.getModifiedDate());
			laundryUserVO.setModifiedFacilityId(lcUsersDo.getId()
					.getOperatingFacilityId());

		} catch (Exception e) {
			// TODO: handle exception
			IBALogger.getLogger().debug(this.getClass(),
					"LaundryUserAssembler---------->convertDO2VO ", null);
			e.printStackTrace();
		}
		return laundryUserVO;

	}

}
