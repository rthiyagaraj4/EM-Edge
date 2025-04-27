/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.requestForCleaningLinen.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.dobj.LcCleaningRequestDtl;
import com.iba.ehis.dobj.LcCleaningRequestDtlId;
import com.iba.ehis.dobj.LcCleaningRequestHdr;
import com.iba.ehis.dobj.LcCleaningRequestHdrId;
import com.iba.ehis.dobj.LcLinenItem;
import com.iba.ehis.dobj.LcReason;
import com.iba.ehis.lc.requestForCleaningLinen.vo.CleaningLinenRequestList;
import com.iba.ehis.lc.requestForCleaningLinen.vo.CleaningRequestsListVO;
import com.iba.ehis.lc.requestForCleaningLinen.vo.PlaceCleaningLinenRequestVO;
import com.iba.ehis.lc.requestForCleaningLinen.vo.RequestForCleaningLinenMainVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DateUtil;
import com.iba.framework.core.util.IBADateTime;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.core.vo.UserPreferences;
import com.iba.framework.logging.pojo.business.IBALogger;

public class RequestForCleaningLinenAssembler extends AppAssembler {

	public Object convertVO2DO(BaseVO vo) throws AssemblerException {

		List CleaningLinenRequestList = new ArrayList();
		List createList = new ArrayList();


		RequestForCleaningLinenMainVO requestForCleaningLinenMainVO = (RequestForCleaningLinenMainVO) vo;
		PlaceCleaningLinenRequestVO placeCleaningLinenRequestVO=requestForCleaningLinenMainVO.getPlaceCleaningLinenRequestVO();
		for (Iterator iter = placeCleaningLinenRequestVO.getCleanLinenRequest().iterator(); iter
				.hasNext();) {
			try {
				LcCleaningRequestDtl lcCleaningRequestDtl = new LcCleaningRequestDtl();
				LcCleaningRequestDtlId lcCleaningRequestDtlId = new LcCleaningRequestDtlId();
				LcCleaningRequestHdr cleaningRequestHdr=new LcCleaningRequestHdr();
				LcCleaningRequestHdrId lcCleaningRequestHdrId=new LcCleaningRequestHdrId();
				LcLinenItem lcLinenItem=new LcLinenItem();
				CleaningLinenRequestList element = (CleaningLinenRequestList) iter.next();

				lcCleaningRequestHdrId.setOperatingFacilityId(requestForCleaningLinenMainVO.getAddedFacilityId());
				lcCleaningRequestHdrId.setRequestNum((placeCleaningLinenRequestVO.getRequestNum()).trim());
				cleaningRequestHdr.setId(lcCleaningRequestHdrId);
				cleaningRequestHdr.setLinenHandedOverBy(placeCleaningLinenRequestVO.getLinenHandedOverBy());

				cleaningRequestHdr.setSourceCode(placeCleaningLinenRequestVO.getSourceCode());
				cleaningRequestHdr.setSourceType(placeCleaningLinenRequestVO.getSourceType());
				cleaningRequestHdr.setRequestDate(placeCleaningLinenRequestVO.getRequestDate());
				lcCleaningRequestDtlId.setLcCleaningRequestHdr(cleaningRequestHdr);
				lcCleaningRequestDtlId.setCategory(element.getCategory());
				lcLinenItem.setLinenItem(element.getLinenItem());
				lcCleaningRequestDtlId.setLcLinenItem(lcLinenItem);
				lcCleaningRequestDtl.setId(lcCleaningRequestDtlId);
				lcCleaningRequestDtl.setRequestDate(placeCleaningLinenRequestVO.getRequestDate());
				lcCleaningRequestDtl.setRequestedQty((Long) element.getRequestedQty());
				lcCleaningRequestDtl.setRemarks(element.getRemark());
				lcCleaningRequestDtl.setSchdDeliveryDate(element.getScheduleDeliveryDate());
				
				lcCleaningRequestDtl.setCountConfirmedYn(placeCleaningLinenRequestVO.getCountConfirmedYn());
				lcCleaningRequestDtl.setAddedById(requestForCleaningLinenMainVO.getAddedById());
				lcCleaningRequestDtl.setAddedDate(requestForCleaningLinenMainVO.getAddedDate());
				lcCleaningRequestDtl.setAddedAtWsNo(requestForCleaningLinenMainVO.getAddedAtWsNo());
				lcCleaningRequestDtl.setAddedFacilityId(requestForCleaningLinenMainVO.getAddedFacilityId());
				lcCleaningRequestDtl.setModifiedAtWsNo(requestForCleaningLinenMainVO.getModifiedAtWsNo());			
				lcCleaningRequestDtl.setModifiedById(requestForCleaningLinenMainVO.getModifiedById());
				lcCleaningRequestDtl.setModifiedDate(requestForCleaningLinenMainVO.getModifiedDate());
				lcCleaningRequestDtl.setModifiedFacilityId(requestForCleaningLinenMainVO.getModifiedFacilityId());
				createList.add(lcCleaningRequestDtl);

			} catch (Exception e) {
				IBALogger.getLogger().debug(this.getClass(),
						"RequestForCleaningLinenAssembler---------->convertVO2DO ",
						null);
				e.printStackTrace();
			}
			
		}
		CleaningLinenRequestList.add(createList);
		return CleaningLinenRequestList;
	}

public Object convertVO2DO1(Object vo) throws AssemblerException {
		LcCleaningRequestHdr lcCleaningRequestHdr = new LcCleaningRequestHdr();
		LcCleaningRequestHdrId cleaningRequestHdrId=new LcCleaningRequestHdrId();
		LcReason lcReason = new LcReason();
		try {
			RequestForCleaningLinenMainVO requestForCleaningLinenMainVO = (RequestForCleaningLinenMainVO) vo;
			PlaceCleaningLinenRequestVO placeCleaningLinenRequestVO=(PlaceCleaningLinenRequestVO)requestForCleaningLinenMainVO.getPlaceCleaningLinenRequestVO();
			
			cleaningRequestHdrId.setOperatingFacilityId(requestForCleaningLinenMainVO.getAddedFacilityId());
			cleaningRequestHdrId.setRequestNum(placeCleaningLinenRequestVO.getRequestNum());
			lcCleaningRequestHdr.setId(cleaningRequestHdrId);
			lcCleaningRequestHdr.setSourceCode(placeCleaningLinenRequestVO.getSourceCode());
			lcCleaningRequestHdr.setSourceType(placeCleaningLinenRequestVO.getSourceType());

			lcCleaningRequestHdr.setRequestDate(placeCleaningLinenRequestVO.getRequestDate());
			lcCleaningRequestHdr.setLinenHandedOverBy(placeCleaningLinenRequestVO.getLinenHandedOverBy());
			lcCleaningRequestHdr.setLinenCollectedBy(placeCleaningLinenRequestVO.getLinenCollectedBy());
			lcCleaningRequestHdr.setRequestStatus(placeCleaningLinenRequestVO.getRequestStatus());
			lcCleaningRequestHdr.setCancelledBy(placeCleaningLinenRequestVO.getCancelledBy());

			if (placeCleaningLinenRequestVO.getCancelledDate() != null) {
				lcCleaningRequestHdr.setCancelledDate(placeCleaningLinenRequestVO.getCancelledDate());
			} else {
				Date cancel = null;
				lcCleaningRequestHdr.setCancelledDate(cancel);
			}
			if (placeCleaningLinenRequestVO.getReasonCode() != null) {
				lcReason.setReasonCode(placeCleaningLinenRequestVO.getReasonCode());
			} else {
				lcReason.setReasonCode("");
			}
			if (placeCleaningLinenRequestVO.getReasonCode() != null) {
				lcReason.setReasonDesc(placeCleaningLinenRequestVO.getReasonDesc());
			} else {
				lcReason.setReasonDesc("");
			}

			lcCleaningRequestHdr.setLcReason(lcReason);

			lcCleaningRequestHdr.setAddedById(requestForCleaningLinenMainVO.getAddedById());
			lcCleaningRequestHdr.setAddedDate(requestForCleaningLinenMainVO.getAddedDate());
			lcCleaningRequestHdr.setAddedAtWsNo(requestForCleaningLinenMainVO.getAddedAtWsNo());
			lcCleaningRequestHdr.setAddedFacilityId(requestForCleaningLinenMainVO.getAddedFacilityId());
			lcCleaningRequestHdr.setModifiedAtWsNo(requestForCleaningLinenMainVO.getModifiedAtWsNo());
			lcCleaningRequestHdr.setModifiedById(requestForCleaningLinenMainVO.getModifiedById());
			lcCleaningRequestHdr.setModifiedDate(requestForCleaningLinenMainVO.getModifiedDate());
			lcCleaningRequestHdr.setModifiedFacilityId(requestForCleaningLinenMainVO.getModifiedFacilityId());

		} catch (Exception e) {
			 e.printStackTrace();
		}
		return lcCleaningRequestHdr;
	}

public Object convertDO2VO(Object oDO) throws AssemblerException {
		List requestsList = new ArrayList();
		UserPreferences userPrefs =new UserPreferences();
		String dtf=userPrefs.getDateFormat() ;
		String tm=userPrefs.getTimeFormat();
		String pattern=dtf+" "+tm;
		for (Iterator iter = ((List) oDO).iterator(); iter.hasNext();) {
			
			LcCleaningRequestDtl lcCleaningRequestDtl = ((LcCleaningRequestDtl) iter.next());
			CleaningRequestsListVO cleaningRequestsListVO = new CleaningRequestsListVO();
			cleaningRequestsListVO.setLinenItem(lcCleaningRequestDtl.getId().getLcLinenItem()
					.getLinenItem());
			cleaningRequestsListVO.setSourceCode(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr()
					.getSourceCode());
			cleaningRequestsListVO.setSourceType(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr()
					.getSourceType());
			cleaningRequestsListVO.setRequestNo(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr()
					.getId().getRequestNum());
			IBADateTime dt1=new IBADateTime(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr()
					.getRequestDate());
			dt1.setPattern("dd/MM/yyyy HH:mm");
			cleaningRequestsListVO.setRequestDate(dt1);
			cleaningRequestsListVO.setRequestedQty(lcCleaningRequestDtl.getRequestedQty());
			cleaningRequestsListVO.setRemarks(lcCleaningRequestDtl.getRemarks());
			cleaningRequestsListVO.setLinenCollectedBy(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr()
					.getLinenCollectedBy());
			cleaningRequestsListVO.setLinenHandedOverBy(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr()
					.getLinenHandedOverBy());
			cleaningRequestsListVO.setRequestStatus(lcCleaningRequestDtl.getId()
					.getLcCleaningRequestHdr().getRequestStatus());
			cleaningRequestsListVO.setCategory(lcCleaningRequestDtl.getId().getCategory());
			IBALogger.getLogger().debug(this.getClass(),"category:====>"+lcCleaningRequestDtl.getId().getCategory(),null);
		try{	if(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getCancelledBy()!=null)
			{
			cleaningRequestsListVO.setCancelledBy(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getCancelledBy());
			}
			if(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getCancelledDate()!=null)
			{
				IBADateTime dt2=new IBADateTime(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getCancelledDate());
				dt2.setPattern(pattern);
			cleaningRequestsListVO.setCancelledDate(dt2);
			}
			if(lcCleaningRequestDtl.getCountConfirmedBy()!=null)
			{
				cleaningRequestsListVO.setCancelledBy(lcCleaningRequestDtl.getCountConfirmedBy());
			}
			if(lcCleaningRequestDtl.getCountConfirmedDate()!=null)
			{
				IBADateTime dt3=new IBADateTime(lcCleaningRequestDtl.getCountConfirmedDate());
				dt3.setPattern("dd/MM/yyyy HH:mm");
			cleaningRequestsListVO.setCountConfirmedDate(dt3);
			}
			if(lcCleaningRequestDtl.getCountConfirmedYn()!=null)
			{
				cleaningRequestsListVO.setCountConfirmedYn(lcCleaningRequestDtl.getCountConfirmedYn());
			}
			if(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getLcReason().getReasonCode()!=null)
			{
			cleaningRequestsListVO.setReasonCode(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getLcReason().getReasonCode());
			cleaningRequestsListVO.setReasonDesc(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getLcReason().getReasonDesc());
			}
			
		}catch(Exception e){}
			requestsList.add(cleaningRequestsListVO);
		}
		return requestsList;
	}

public Object convertVO2DO(Object vo) throws AssemblerException {
		// TODO Auto-generated method stub
		return super.convertVO2DO(vo);
	}
}
