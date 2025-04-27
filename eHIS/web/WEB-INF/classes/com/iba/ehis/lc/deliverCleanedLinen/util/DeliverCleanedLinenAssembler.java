/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.deliverCleanedLinen.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import com.iba.ehis.dobj.LcCleanedLinenDeliveryDtl;
import com.iba.ehis.dobj.LcCleanedLinenDeliveryDtlId;
import com.iba.ehis.dobj.LcCleanedLinenDeliveryHdr;
import com.iba.ehis.dobj.LcCleanedLinenDeliveryHdrId;
import com.iba.ehis.dobj.LcCleanedLinenHdr;
import com.iba.ehis.dobj.LcCleanedLinenHdrId;
import com.iba.ehis.dobj.LcCleaningRequestDtl;
import com.iba.ehis.dobj.LcIssueDtl;
import com.iba.ehis.dobj.LcIssueDtlId;
import com.iba.ehis.dobj.LcIssueHdr;
import com.iba.ehis.dobj.LcIssueHdrId;
import com.iba.ehis.dobj.LcLinenItem;
import com.iba.ehis.dobj.LcLinenType;
import com.iba.ehis.dobj.LcReason;
import com.iba.ehis.dobj.LcReasonActionType;
import com.iba.ehis.dobj.LcReasonDtl;
import com.iba.ehis.dobj.LcReasonDtlId;
import com.iba.ehis.dobj.LcRequestDtl;
import com.iba.ehis.dobj.LcStdLinenStkDtl;
import com.iba.ehis.dobj.LcStdLinenStkDtlId;
import com.iba.ehis.dobj.LcStdLinenStkHdr;
import com.iba.ehis.dobj.LcStdLinenStkHdrId;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.lc.deliverCleanedLinen.vo.DeliverCleanedLinenVO;
import com.iba.ehis.lc.deliverCleanedLinen.vo.DeliverListVO;
import com.iba.ehis.lc.deliverCleanedLinen.vo.LinenDeliverList;
import com.iba.ehis.lc.issueOfLinen.vo.IssueOfLinenVO;
import com.iba.ehis.lc.issueOfLinen.vo.LinenIssueList;
import com.iba.ehis.lc.linenItem.vo.LinenItemVO;
import com.iba.ehis.lc.linenType.vo.LinentypeVO;
import com.iba.ehis.lc.reason.vo.ReasonVO;
import com.iba.ehis.lc.reason.vo.ReasonsVO;
import com.iba.ehis.lc.requestForLinen.vo.RequestsListVO;
import com.iba.ehis.lc.standardStock.vo.StandardStockListVO;
import com.iba.ehis.lc.standardStock.vo.StandardStockVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.DateUtil;
import com.iba.framework.core.util.IBADateTime;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;

public class DeliverCleanedLinenAssembler extends AppAssembler {
	public static final Logger logger = LogFactory.getApplicationLogger();

	public Object convertDO2VO(Object dObj, Class classVO)
			throws AssemblerException {
		return convertDO2VO(dObj);
	}

	public Object convertVO2DO1(Object vo)
	throws AssemblerException {

		DeliverCleanedLinenVO deliverCleanedLinenVO = (DeliverCleanedLinenVO) vo;
		LcCleanedLinenDeliveryHdr lcCleanedLinenDeliveryHdr=new LcCleanedLinenDeliveryHdr();
		LcCleanedLinenDeliveryHdrId lcCleanedLinenDeliveryHdrId=new LcCleanedLinenDeliveryHdrId();
		
		try{
			lcCleanedLinenDeliveryHdr.setRequestNum((deliverCleanedLinenVO.getRequestNum()).trim());
			lcCleanedLinenDeliveryHdrId.setOperatingFacilityId(deliverCleanedLinenVO.getAddedFacilityId());
			lcCleanedLinenDeliveryHdrId.setDeliveryRefNum(deliverCleanedLinenVO.getDeliveryRefNum());
			lcCleanedLinenDeliveryHdr.setId(lcCleanedLinenDeliveryHdrId);
			lcCleanedLinenDeliveryHdr.setLinenCollectedBy(deliverCleanedLinenVO.getLinenCollectedBy());
			lcCleanedLinenDeliveryHdr.setLinenHandedOverBy(deliverCleanedLinenVO.getLinenHandedOverBy());
			
			lcCleanedLinenDeliveryHdr.setDeliveryDate(DateUtil.convertStringToDate("dd/MM/yyyy HH:mm",deliverCleanedLinenVO.getDeliveryDate()));
			
			lcCleanedLinenDeliveryHdr.setAddedById(deliverCleanedLinenVO.getAddedById());
			lcCleanedLinenDeliveryHdr.setAddedDate(deliverCleanedLinenVO.getAddedDate());
			lcCleanedLinenDeliveryHdr.setAddedAtWsNo(deliverCleanedLinenVO.getAddedAtWsNo());
			lcCleanedLinenDeliveryHdr.setAddedFacilityId(deliverCleanedLinenVO.getAddedFacilityId());
			lcCleanedLinenDeliveryHdr.setModifiedAtWsNo(deliverCleanedLinenVO.getModifiedAtWsNo());
			lcCleanedLinenDeliveryHdr.setModifiedById(deliverCleanedLinenVO.getModifiedById());
			lcCleanedLinenDeliveryHdr.setModifiedDate(deliverCleanedLinenVO.getModifiedDate());
			lcCleanedLinenDeliveryHdr.setModifiedFacilityId(deliverCleanedLinenVO.getModifiedFacilityId());
		}catch(Exception e )
		{
			e.printStackTrace();
		}
		return lcCleanedLinenDeliveryHdr;
}
	public Object convertVO2DO(Object vo)throws AssemblerException 
	{
		int index=0;
		DTO	dto=new DTO();
		List issueList = new ArrayList();
		List createList = new ArrayList() ;
		List updateList = new ArrayList() ;

		DeliverCleanedLinenVO deliverCleanedLinenVO = (DeliverCleanedLinenVO) vo;
		for (Iterator iter = deliverCleanedLinenVO.getLinenDeliverList().iterator(); iter.hasNext();)
		{
			LcCleanedLinenDeliveryDtl lcCleanedLinenDeliveryDtl =new LcCleanedLinenDeliveryDtl();
			LcCleanedLinenDeliveryDtlId lcCleanedLinenDeliveryDtlId=new LcCleanedLinenDeliveryDtlId();
			LcCleanedLinenDeliveryHdr lcCleanedLinenDeliveryHdr=new LcCleanedLinenDeliveryHdr();
			LcCleanedLinenDeliveryHdrId lcCleanedLinenDeliveryHdrId=new LcCleanedLinenDeliveryHdrId();
			LcLinenItem lcLinenItem=new LcLinenItem();
			LinenDeliverList element = (LinenDeliverList) iter.next();
			
			try{
				lcCleanedLinenDeliveryHdrId.setDeliveryRefNum((deliverCleanedLinenVO.getDeliveryRefNum()).trim());
				lcCleanedLinenDeliveryHdrId.setOperatingFacilityId(deliverCleanedLinenVO.getAddedFacilityId());
				lcCleanedLinenDeliveryHdr.setId(lcCleanedLinenDeliveryHdrId);
				lcCleanedLinenDeliveryDtlId.setLcCleanedLinenDeliveryHdr(lcCleanedLinenDeliveryHdr);
		
			lcLinenItem.setLinenItem((element.getLinenItem()).trim());
			lcCleanedLinenDeliveryDtlId.setLcLinenItem(lcLinenItem);
			lcCleanedLinenDeliveryDtl.setId(lcCleanedLinenDeliveryDtlId);
			IBALogger.getLogger().debug(this.getClass(),"deliveredQty:-"+element.getCurrentdeliveredQty(), null);
			lcCleanedLinenDeliveryDtl.setDeliveredQty(element.getCurrentdeliveredQty());
			lcCleanedLinenDeliveryDtl.setRemarks(element.getRemark());
			lcCleanedLinenDeliveryDtl.setRequestNum((deliverCleanedLinenVO.getRequestNum()).trim());
			lcCleanedLinenDeliveryDtl.setDeliveryDate(DateUtil.convertStringToDate("dd/MM/yyyy HH:mm",deliverCleanedLinenVO.getDeliveryDate()));
			lcCleanedLinenDeliveryDtl.setLateDeliveryReason(element.getLateDeliveryReason());
					
			lcCleanedLinenDeliveryDtl.setAddedById(deliverCleanedLinenVO.getAddedById());
			lcCleanedLinenDeliveryDtl.setAddedDate(deliverCleanedLinenVO.getAddedDate());
			lcCleanedLinenDeliveryDtl.setAddedAtWsNo(deliverCleanedLinenVO.getAddedAtWsNo());
			lcCleanedLinenDeliveryDtl.setAddedFacilityId(deliverCleanedLinenVO.getAddedFacilityId());
			lcCleanedLinenDeliveryDtl.setModifiedAtWsNo(deliverCleanedLinenVO.getModifiedAtWsNo());
			lcCleanedLinenDeliveryDtl.setModifiedById(deliverCleanedLinenVO.getModifiedById());
			lcCleanedLinenDeliveryDtl.setModifiedDate(deliverCleanedLinenVO.getModifiedDate());
			lcCleanedLinenDeliveryDtl.setModifiedFacilityId(deliverCleanedLinenVO.getModifiedFacilityId());
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		
				createList.add(lcCleanedLinenDeliveryDtl) ;
				
			}
		issueList.add(createList);
		return issueList;
	}

	

	
	public Object convertDO2VO(Object oDO) throws AssemblerException {
		List requestsList = new ArrayList();
		for (Iterator iter = ((List) oDO).iterator(); iter.hasNext();) {
			
			LcCleaningRequestDtl lcCleaningRequestDtl = ((LcCleaningRequestDtl) iter.next());
			DeliverListVO deliverListVO = new DeliverListVO();
			
			deliverListVO.setLinenItem(lcCleaningRequestDtl.getId().getLcLinenItem().getLinenItem());
			deliverListVO.setSourceCode(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getSourceCode());
			deliverListVO.setSourceType(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getSourceType());
			deliverListVO.setRequestNo(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getId().getRequestNum());
		
			deliverListVO.setRequestDate(DateUtil.getDateTime("dd/MM/yyyy HH:mm", lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getRequestDate()));
			
			deliverListVO.setLinenCollectedBy(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getLinenCollectedBy());
			deliverListVO.setLinenHandedOverBy(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getLinenHandedOverBy());
			deliverListVO.setRequestStatus(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getRequestStatus());
				
			deliverListVO.setDeliveryDate(DateUtil.getDateTime("dd/MM/yyyy HH:mm", lcCleaningRequestDtl.getSchdDeliveryDate()));
			deliverListVO.setRemarks(lcCleaningRequestDtl.getRemarks());
			deliverListVO.setRequestedQty(lcCleaningRequestDtl.getRequestedQty());
			deliverListVO.setLinenItem(lcCleaningRequestDtl.getId().getLcLinenItem().getLinenItem());
			deliverListVO.setLinenDesc(lcCleaningRequestDtl.getId().getLcLinenItem().getShortDesc());
			deliverListVO.setCategory(lcCleaningRequestDtl.getId().getCategory());
			try{
			if(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getCancelledBy()!=null)
			{
			deliverListVO.setCancelledBy(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getCancelledBy());
			}
			if(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getCancelledDate()!=null){
			deliverListVO.setCancelledDate(DateUtil.convertDateToString(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getCancelledDate()));
			}
			if(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getLcReason().getReasonCode()!=null)
			{
			deliverListVO.setReasonCode(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getLcReason().getReasonCode());
			deliverListVO.setReasonDesc(lcCleaningRequestDtl.getId().getLcCleaningRequestHdr().getLcReason().getReasonDesc());
			}
			}catch(Exception e){e.printStackTrace();}
			requestsList.add(deliverListVO);

		}
		return requestsList;
	}

	

}
