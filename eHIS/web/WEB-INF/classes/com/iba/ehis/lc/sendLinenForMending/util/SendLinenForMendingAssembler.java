/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.sendLinenForMending.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.dobj.LcAgency;
import com.iba.ehis.dobj.LcLinenItem;
import com.iba.ehis.dobj.LcMendingRequestDtl;
import com.iba.ehis.dobj.LcMendingRequestDtlId;
import com.iba.ehis.dobj.LcMendingRequestHdr;
import com.iba.ehis.dobj.LcMendingRequestHdrId;
import com.iba.ehis.dobj.LcReason;
import com.iba.ehis.dobj.LcRequestDtl;
import com.iba.ehis.dobj.LcRequestDtlId;
import com.iba.ehis.dobj.LcRequestHdr;
import com.iba.ehis.dobj.LcRequestHdrId;
import com.iba.ehis.lc.requestForLinen.vo.LinenRequestList;
import com.iba.ehis.lc.requestForLinen.vo.PlaceLinenRequestVO;
import com.iba.ehis.lc.requestForLinen.vo.RequestsListVO;
import com.iba.ehis.lc.sendLinenForMending.vo.LinenMendingList;
import com.iba.ehis.lc.sendLinenForMending.vo.MendingListVO;
import com.iba.ehis.lc.sendLinenForMending.vo.PlaceLinenMendingRequestVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.DateUtil;
import com.iba.framework.core.util.IBADateTime;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.core.vo.UserPreferences;
import com.iba.framework.logging.pojo.business.IBALogger;

public class SendLinenForMendingAssembler extends AppAssembler {

	public Object convertVO2DO(BaseVO vo) throws AssemblerException {

		List LinenRequestList = new ArrayList();
		List createList = new ArrayList();

		PlaceLinenMendingRequestVO placeLinenMendingRequestVO = (PlaceLinenMendingRequestVO) vo;
		for (Iterator iter = placeLinenMendingRequestVO.getLinenMending()
				.iterator(); iter.hasNext();) {
			try {
				LcMendingRequestDtl lcMendingRequestDtl = new LcMendingRequestDtl();
				LcMendingRequestDtlId lcMendingRequestDtlId = new LcMendingRequestDtlId();
				LcMendingRequestHdr lcMendingRequestHdr = new LcMendingRequestHdr();
				LcMendingRequestHdrId lcMendingRequestHdrId = new LcMendingRequestHdrId();
				LcAgency lcAgency = new LcAgency();
				LcLinenItem lcLinenItem = new LcLinenItem();
				LinenMendingList element = (LinenMendingList) iter.next();

				lcMendingRequestHdrId
						.setOperatingFacilityId(placeLinenMendingRequestVO
								.getAddedFacilityId());
				lcMendingRequestHdrId.setRequestNum((placeLinenMendingRequestVO
						.getRequestNum()).trim());
				lcMendingRequestHdr.setId(lcMendingRequestHdrId);
				lcAgency.setAgencyCode(placeLinenMendingRequestVO
						.getAgencyCode());
				lcMendingRequestHdr.setLcAgency(lcAgency);
				lcMendingRequestHdr.setSentBy(placeLinenMendingRequestVO
						.getSentBy());
				lcMendingRequestHdr.setRequestDate(placeLinenMendingRequestVO.getRequestDate());
				lcMendingRequestDtlId
						.setLcMendingRequestHdr(lcMendingRequestHdr);
				lcLinenItem.setLinenItem(element.getLinenItem());
				lcMendingRequestDtlId.setLcLinenItem(lcLinenItem);
				lcMendingRequestDtl.setId(lcMendingRequestDtlId);
				lcMendingRequestDtl.setRequestedQty((Long) element
						.getRequestedQty());
				lcMendingRequestDtl.setRemarks(element.getRemark());

				lcMendingRequestDtl.setAddedById(placeLinenMendingRequestVO
						.getAddedById());
				lcMendingRequestDtl.setAddedDate(placeLinenMendingRequestVO
						.getAddedDate());
				lcMendingRequestDtl.setAddedAtWsNo(placeLinenMendingRequestVO
						.getAddedAtWsNo());
				lcMendingRequestDtl
						.setAddedFacilityId(placeLinenMendingRequestVO
								.getAddedFacilityId());
				lcMendingRequestDtl
						.setModifiedAtWsNo(placeLinenMendingRequestVO
								.getModifiedAtWsNo());
				lcMendingRequestDtl.setModifiedById(placeLinenMendingRequestVO
						.getModifiedById());
				lcMendingRequestDtl.setModifiedDate(placeLinenMendingRequestVO
						.getModifiedDate());
				lcMendingRequestDtl
						.setModifiedFacilityId(placeLinenMendingRequestVO
								.getModifiedFacilityId());
				createList.add(lcMendingRequestDtl);

			} catch (Exception e) {
				IBALogger.getLogger().debug(this.getClass(),
						"RequestForLinenAssembler---------->convertVO2DO ",
						null);
				e.printStackTrace();
			}
			// updateList.add(lcStdLinenStkDtl) ;
		}
		LinenRequestList.add(createList);
		// standardStockList.add(updateList);
		return LinenRequestList;
	}

	public Object convertVO2DO1(Object vo) throws AssemblerException {
		LcMendingRequestHdr lcMendingRequestHdr = new LcMendingRequestHdr();
		LcMendingRequestHdrId lcMendingRequestHdrId = new LcMendingRequestHdrId();
		LcAgency lcAgency = new LcAgency();
		LcReason lcReason = new LcReason();
		try {
			PlaceLinenMendingRequestVO placeLinenMendingRequestVO = (PlaceLinenMendingRequestVO) vo;

			lcMendingRequestHdrId
					.setOperatingFacilityId(placeLinenMendingRequestVO
							.getAddedFacilityId());
			lcMendingRequestHdrId.setRequestNum(placeLinenMendingRequestVO
					.getRequestNum());
			lcAgency.setAgencyCode(placeLinenMendingRequestVO.getAgencyCode());
			lcMendingRequestHdr.setLcAgency(lcAgency);
			lcMendingRequestHdr.setSentBy(placeLinenMendingRequestVO
					.getSentBy());
			lcMendingRequestHdr.setId(lcMendingRequestHdrId);
			lcMendingRequestHdr.setRequestDate(placeLinenMendingRequestVO
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

			lcMendingRequestHdr.setAddedById(placeLinenMendingRequestVO
					.getAddedById());
			lcMendingRequestHdr.setAddedDate(placeLinenMendingRequestVO
					.getAddedDate());
			lcMendingRequestHdr.setAddedAtWsNo(placeLinenMendingRequestVO
					.getAddedAtWsNo());
			lcMendingRequestHdr.setAddedFacilityId(placeLinenMendingRequestVO
					.getAddedFacilityId());
			lcMendingRequestHdr.setModifiedAtWsNo(placeLinenMendingRequestVO
					.getModifiedAtWsNo());
			lcMendingRequestHdr.setModifiedById(placeLinenMendingRequestVO
					.getModifiedById());
			lcMendingRequestHdr.setModifiedDate(placeLinenMendingRequestVO
					.getModifiedDate());
			lcMendingRequestHdr
					.setModifiedFacilityId(placeLinenMendingRequestVO
							.getModifiedFacilityId());

		} catch (Exception e) {
			// e.printStackTrace();

		}
		return lcMendingRequestHdr;
	}

	public Object convertDO2VO(Object oDO) throws AssemblerException {
		List requestsList = new ArrayList();
		UserPreferences userPrefs =new UserPreferences();
		String dtf=userPrefs.getDateFormat() ;
		String tm=userPrefs.getTimeFormat();
		String pattern=dtf+" "+tm;
		for (Iterator iter = ((List) oDO).iterator(); iter.hasNext();) {
			LcMendingRequestDtl lcMendingRequestDtl = ((LcMendingRequestDtl) iter
					.next());
			MendingListVO mendingListVO = new MendingListVO();
			mendingListVO.setLinenItem(lcMendingRequestDtl.getId()
					.getLcLinenItem().getLinenItem());
			try {
				if (lcMendingRequestDtl.getId().getLcLinenItem().getShortDesc() != null) {
					mendingListVO.setShortDesc(lcMendingRequestDtl.getId()
							.getLcLinenItem().getShortDesc());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			mendingListVO.setRequestNo(lcMendingRequestDtl.getId()
					.getLcMendingRequestHdr().getId().getRequestNum());
			mendingListVO
					.setRequestedQty(lcMendingRequestDtl.getRequestedQty());
			IBADateTime dt1=new IBADateTime(lcMendingRequestDtl.getId()
					.getLcMendingRequestHdr().getRequestDate());
			dt1.setPattern("dd/MM/yyyy HH:mm");
			mendingListVO.setRequestDate(dt1);
			mendingListVO.setSentBy(lcMendingRequestDtl.getId()
					.getLcMendingRequestHdr().getSentBy());
			mendingListVO.setRequestStatus(lcMendingRequestDtl.getId()
					.getLcMendingRequestHdr().getRequestStatus());
			try {
				if (lcMendingRequestDtl.getId().getLcMendingRequestHdr()
						.getLcReason().getReasonCode() != null) {
					mendingListVO.setReasonCode(lcMendingRequestDtl.getId()
							.getLcMendingRequestHdr().getLcReason()
							.getReasonCode());
				}
				if (lcMendingRequestDtl.getId().getLcMendingRequestHdr()
						.getCancelledBy() != null) {
					mendingListVO.setCancelledBy(lcMendingRequestDtl.getId()
							.getLcMendingRequestHdr().getCancelledBy());
				}
				if (lcMendingRequestDtl.getId().getLcMendingRequestHdr()
						.getCancelledDate() != null) {
					IBADateTime dt=new IBADateTime(lcMendingRequestDtl.getId()
							.getLcMendingRequestHdr()
							.getCancelledDate());
					dt.setPattern("dd/MM/yyyy HH:mm");
					mendingListVO.setCancelledDate(dt);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			requestsList.add(mendingListVO);

		}

		return requestsList;
	}

	public Object convertVO2DO(Object vo) throws AssemblerException {
		// TODO Auto-generated method stub
		return super.convertVO2DO(vo);
	}
}
