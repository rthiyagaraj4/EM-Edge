/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.writeOffLinen.util;

import com.iba.ehis.dobj.LcWriteOff;
import com.iba.ehis.dobj.LcLinenType;
import com.iba.ehis.dobj.LcLinenItem;
import com.iba.ehis.dobj.LcReason;
import com.iba.ehis.dobj.LcWriteOffId;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.lc.writeOffLinen.vo.WriteOffLinenVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DateUtil;
import com.iba.framework.core.util.IBADateTime;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;

public class WriteOffLinenAssembler extends AppAssembler {

	public static final Logger logger = LogFactory.getApplicationLogger();

	public Object convertVO2DO(Object vo) throws AssemblerException {

		LcWriteOff lcWriteOff = new LcWriteOff();
		LcLinenType linenType = new LcLinenType();
		LcLinenItem linenItem = new LcLinenItem();
		LcReason reason = new LcReason();
		LcWriteOffId id = new LcWriteOffId();
		WriteOffLinenVO writeOffLinenVO = (WriteOffLinenVO) vo;
		try {
			// linenItem.setLinenItem(writeOffLinenVO.getLinenItem());
			linenItem.setLinenItem(writeOffLinenVO.getLinenItemCode());
			lcWriteOff.setLcLinenItem(linenItem);

			reason.setReasonDesc(writeOffLinenVO.getReason());
			reason.setReasonCode(writeOffLinenVO.getReasonCode());
			lcWriteOff.setLcReason(reason);
			IBALogger.getLogger().debug(this.getClass(),"writeOffLinenVO.getDate()"+new IBADateTime(writeOffLinenVO.getDate()),null);
			lcWriteOff.setWriteOffDate(writeOffLinenVO.getDate());
			IBALogger.getLogger().debug(this.getClass(),"writeOffLinenVO.getDate()"+lcWriteOff.getWriteOffDate(),null);
			id.setWriteOffRefNum(writeOffLinenVO.getRefNum());
			id.setOperatingFacilityId(writeOffLinenVO.getOperatingFacilityId());
			lcWriteOff.setId(id);

			lcWriteOff.setLinenType(writeOffLinenVO.getLinenTypeCode());
			lcWriteOff.setSourceType(writeOffLinenVO.getSourceType());
			lcWriteOff.setSourceCode(writeOffLinenVO.getSourceCode());
			lcWriteOff.setWriteOffQty(writeOffLinenVO.getWriteOffQty());
			lcWriteOff.setRemarks(writeOffLinenVO.getRemarks());
			lcWriteOff.setAddedById(writeOffLinenVO.getAddedById());
			lcWriteOff.setAddedDate(writeOffLinenVO.getAddedDate());
			lcWriteOff.setAddedAtWsNo(writeOffLinenVO.getAddedAtWsNo());
			lcWriteOff.setAddedFacilityId(writeOffLinenVO.getAddedFacilityId());
			lcWriteOff.setModifiedAtWsNo(writeOffLinenVO.getModifiedAtWsNo());
			lcWriteOff.setModifiedById(writeOffLinenVO.getModifiedById());
			lcWriteOff.setModifiedDate(writeOffLinenVO.getModifiedDate());
			lcWriteOff.setModifiedFacilityId(writeOffLinenVO
					.getModifiedFacilityId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lcWriteOff;
	}
}
