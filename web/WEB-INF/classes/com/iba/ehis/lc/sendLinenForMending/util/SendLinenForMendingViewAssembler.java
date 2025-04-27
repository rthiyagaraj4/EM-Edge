/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.sendLinenForMending.util;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.dobj.LcAgency;
import com.iba.ehis.dobj.LcMendingRequestHdr;
import com.iba.ehis.dobj.LcMendingRequestHdrId;
import com.iba.ehis.dobj.LcReason;
import com.iba.ehis.dobj.LcRequestHdr;
import com.iba.ehis.dobj.LcRequestHdrId;
import com.iba.ehis.lc.requestForLinen.vo.LinenRequestList;
import com.iba.ehis.lc.requestForLinen.vo.PlaceLinenRequestVO;
import com.iba.ehis.lc.requestForLinen.vo.RequestForLinenMainVO;
import com.iba.ehis.lc.sendLinenForMending.vo.LinenMendingList;
import com.iba.ehis.lc.sendLinenForMending.vo.PlaceLinenMendingRequestVO;
import com.iba.ehis.lc.sendLinenForMending.vo.SendLinenForMendingMainVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DateUtil;
import com.iba.framework.logging.pojo.business.IBALogger;

public class SendLinenForMendingViewAssembler extends AppAssembler {

	public Object convertDO2VO(Object oDO) throws AssemblerException {

		SendLinenForMendingMainVO mainVO = new SendLinenForMendingMainVO();
		IBALogger.getLogger().debug(this.getClass(),
				"getRequestStatus:" + oDO.getClass(), null);

		for (Iterator iter = ((List) oDO).iterator(); iter.hasNext();) {
			Object[] obj = (Object[]) iter.next();

			LinenMendingList linenMendingList = new LinenMendingList();
			linenMendingList.setLinenItem((String) obj[0]);
			linenMendingList.setRemark(((String) obj[1]));
			try {
				if ((Long) obj[2] != null) {
					linenMendingList.setRequestedQty((Long) obj[2]);
				}
				if ((Long) obj[3] != null) {
					linenMendingList.setIssuedQty((Long) obj[3]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			mainVO.getRequestsListVO().getLinenRequest().add(linenMendingList);

		}

		return mainVO;
	}

	public Object convertVO2DO(Object vo) throws AssemblerException {
		LcMendingRequestHdr lcMendingRequestHdr = new LcMendingRequestHdr();
		LcMendingRequestHdrId lcMendingRequestHdrId = new LcMendingRequestHdrId();
		LcAgency lcAgency = new LcAgency();
		LcReason lcReason = new LcReason();
		try {
			SendLinenForMendingMainVO mainVO = ((SendLinenForMendingMainVO) vo);
			PlaceLinenMendingRequestVO placeLinenMendingRequestVO = mainVO
					.getPlaceLinenRequestVO();

			lcMendingRequestHdrId.setOperatingFacilityId(mainVO
					.getAddedFacilityId());
			lcMendingRequestHdrId.setRequestNum(placeLinenMendingRequestVO
					.getRequestNum());
			lcAgency.setAgencyCode(placeLinenMendingRequestVO.getAgencyCode());
			lcMendingRequestHdr.setLcAgency(lcAgency);
			lcMendingRequestHdr.setId(lcMendingRequestHdrId);

			lcMendingRequestHdr.setRequestDate( placeLinenMendingRequestVO
							.getRequestDate());

			lcMendingRequestHdr.setRequestStatus(placeLinenMendingRequestVO
					.getRequestStatus());
			lcMendingRequestHdr.setCancelledBy(placeLinenMendingRequestVO
					.getCancelledBy());

			if (placeLinenMendingRequestVO.getCancelledDate() != null) {
				lcMendingRequestHdr.setCancelledDate(placeLinenMendingRequestVO.getCancelledDate());
			} else {
				Date cancel = null;
				lcMendingRequestHdr.setCancelledDate(cancel);
			}
			if (placeLinenMendingRequestVO.getReasonCode() != null) {
				lcReason.setReasonCode(placeLinenMendingRequestVO
						.getReasonCode());
			} else {
				lcReason.setReasonCode("");
			}
			if (placeLinenMendingRequestVO.getReasonDesc() != null) {
				lcReason.setReasonDesc(placeLinenMendingRequestVO
						.getReasonDesc());
			} else {
				lcReason.setReasonDesc("");
			}

			lcMendingRequestHdr.setLcReason(lcReason);

			lcMendingRequestHdr.setAddedById(mainVO.getAddedById());
			lcMendingRequestHdr.setAddedDate(mainVO.getAddedDate());
			lcMendingRequestHdr.setAddedAtWsNo(mainVO.getAddedAtWsNo());
			lcMendingRequestHdr.setAddedFacilityId(mainVO.getAddedFacilityId());
			lcMendingRequestHdr.setModifiedAtWsNo(mainVO.getModifiedAtWsNo());
			lcMendingRequestHdr.setModifiedById(mainVO.getModifiedById());
			lcMendingRequestHdr.setModifiedDate(mainVO.getModifiedDate());
			lcMendingRequestHdr.setModifiedFacilityId(mainVO
					.getModifiedFacilityId());

		} catch (Exception e) {
			// e.printStackTrace();

		}
		return lcMendingRequestHdr;
	}

}
