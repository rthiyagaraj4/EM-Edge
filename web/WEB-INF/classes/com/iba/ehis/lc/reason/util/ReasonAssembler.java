/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.reason.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.core.util.AppConstants;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.dobj.LcReason;
import com.iba.ehis.dobj.LcReasonActionType;
import com.iba.ehis.dobj.LcReasonDtl;
import com.iba.ehis.dobj.LcReasonDtlId;
import com.iba.ehis.lc.reason.vo.ReasonVO;
import com.iba.ehis.lc.reason.vo.ReasonsVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;

public class ReasonAssembler extends AppAssembler {
	public static final Logger logger = LogFactory.getApplicationLogger();

	public Object convertVO2DO1(Object vo) throws AssemblerException {

		LcReason lcReasonDo = new LcReason();
		lcReasonDo.setReasonCode(((ReasonVO) vo).getReasonCode());
		lcReasonDo.setReasonDesc(((ReasonVO) vo).getReasonDesc());
		lcReasonDo.setEffStatus(((ReasonVO) vo).getEffStatus());
		lcReasonDo.setAddedById(((ReasonVO) vo).getAddedById());
		lcReasonDo.setAddedDate(((ReasonVO) vo).getAddedDate());
		lcReasonDo.setAddedAtWsNo(((ReasonVO) vo).getAddedAtWsNo());
		lcReasonDo.setAddedFacilityId(((ReasonVO) vo).getAddedFacilityId());
		lcReasonDo.setModifiedAtWsNo(((ReasonVO) vo).getModifiedAtWsNo());
		lcReasonDo.setModifiedById(((ReasonVO) vo).getModifiedById());
		lcReasonDo.setModifiedDate(((ReasonVO) vo).getModifiedDate());
		lcReasonDo.setModifiedFacilityId(((ReasonVO) vo)
				.getModifiedFacilityId());
		return lcReasonDo;
	}

	public Object convertVO2DO(Object vo) throws AssemblerException {
		int index = 0;
		List reasonList = new ArrayList();
		List createList = new ArrayList();

		ReasonVO reasonVO = (ReasonVO) vo;

		for (index = 1; index < reasonVO.getActionTypeList().size(); index++) {
			LcReasonDtl lcReasonDtl = new LcReasonDtl();
			LcReasonDtlId lcReasonDtlId = new LcReasonDtlId();
			LcReasonActionType lcReasonActionType = new LcReasonActionType();
			LcReason lcReasonDo = new LcReason();

			lcReasonDo.setReasonCode(reasonVO.getReasonCode());
			lcReasonDo.setReasonDesc(((ReasonVO) vo).getReasonDesc());
			lcReasonDtlId.setLcReason(lcReasonDo);

			lcReasonActionType.setActionTypeCode(((ReasonsVO) reasonVO
					.getActionTypeList().get(index)).getActionType());
			lcReasonDtlId.setLcReasonActionType(lcReasonActionType);
			lcReasonDtl.setId(lcReasonDtlId);

			lcReasonDtl.setActiveYn(((ReasonsVO) reasonVO.getActionTypeList()
					.get(index)).getActiveYn());
			lcReasonDtl.setEffStatus(reasonVO.getEffStatus());
			lcReasonDtl.setAddedById(reasonVO.getAddedById());
			lcReasonDtl.setAddedDate(reasonVO.getAddedDate());
			lcReasonDtl.setAddedAtWsNo(reasonVO.getAddedAtWsNo());
			lcReasonDtl.setAddedFacilityId(reasonVO.getAddedFacilityId());
			lcReasonDtl.setModifiedAtWsNo(reasonVO.getModifiedAtWsNo());
			lcReasonDtl.setModifiedById(reasonVO.getModifiedById());
			lcReasonDtl.setModifiedDate(reasonVO.getModifiedDate());
			lcReasonDtl.setModifiedFacilityId(reasonVO.getModifiedFacilityId());
			createList.add(lcReasonDtl);

		}
		reasonList.add(createList);
		return reasonList;
	}

	public Object convertDO2VO(Object oDO) throws AssemblerException {

		List reasonList = new ArrayList();
		if (oDO instanceof List) {

			for (Iterator iter = ((List) oDO).iterator(); iter.hasNext();) {
				Object[] obj = (Object[]) iter.next();
				ReasonVO reasonVO = new ReasonVO();
				IBALogger.getLogger().debug(
						this.getClass(),
						"convertDO2VO--11------>"
								+ ((LcReasonDtl) obj[0]).getId()
										.getLcReasonActionType()
										.getActionTypeCode(), null);
				reasonVO.setReasonCode(((LcReason) obj[1]).getReasonCode());
				reasonVO.setReasonDesc(((LcReason) obj[1]).getReasonDesc());
				reasonVO.setEffStatus(((LcReason) obj[1]).getEffStatus());
				reasonVO.setActionType(((LcReasonDtl) obj[0]).getId()
						.getLcReasonActionType().getActionTypeCode());
				reasonVO.setActiveYn(((LcReasonDtl) obj[0]).getActiveYn());

				reasonList.add(reasonVO);
			}
			return reasonList;
		} else {
			return null;
		}

	}
}
