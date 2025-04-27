/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.issueLinenAfterMending.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iba.ehis.dobj.LcAgency;
import com.iba.ehis.dobj.LcMendingReceiptDtl;
import com.iba.ehis.dobj.LcMendingReceiptDtlId;
import com.iba.ehis.dobj.LcMendingReceiptHdr;
import com.iba.ehis.dobj.LcMendingReceiptHdrId;
import com.iba.ehis.dobj.LcMendingRequestDtl;
import com.iba.ehis.dobj.LcMendingRequestDtlId;
import com.iba.ehis.dobj.LcMendingRequestHdr;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.lc.issueLinenAfterMending.vo.IssueLinenAfterMendingVO;
import com.iba.ehis.lc.issueLinenAfterMending.vo.MendingIssueList;
import com.iba.ehis.lc.issueLinenAfterMending.vo.MendingListVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.DateUtil;
import com.iba.framework.core.util.IBADateTime;
import com.iba.framework.core.vo.UserPreferences;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;

public class IssueLinenAfterMendingAssembler extends AppAssembler {
	public static final Logger logger = LogFactory.getApplicationLogger();

	public Object convertDO2VO(Object dObj, Class classVO)
			throws AssemblerException {
		return convertDO2VO(dObj);
	}

	public Object convertVO2DO1(Object vo) throws AssemblerException {

		IssueLinenAfterMendingVO issueLinenAfterMendingVO = (IssueLinenAfterMendingVO) vo;
		LcMendingReceiptHdr lcMendingReceiptHdr = new LcMendingReceiptHdr();
		LcMendingReceiptHdrId lcMendingReceiptHdrId = new LcMendingReceiptHdrId();

		try {
			lcMendingReceiptHdr.setRequestNum((issueLinenAfterMendingVO
					.getRequestNum()).trim());
			lcMendingReceiptHdrId
					.setOperatingFacilityId(issueLinenAfterMendingVO
							.getAddedFacilityId());
			lcMendingReceiptHdrId.setReceiptNum((issueLinenAfterMendingVO
					.getReceiptNum()).trim());
			lcMendingReceiptHdr.setId(lcMendingReceiptHdrId);
			lcMendingReceiptHdr.setReceiptDate(issueLinenAfterMendingVO.getIssueDate());
			lcMendingReceiptHdr.setReceivedBy(issueLinenAfterMendingVO
					.getSentBy());
			lcMendingReceiptHdr.setAddedById(issueLinenAfterMendingVO
					.getAddedById());
			lcMendingReceiptHdr.setAddedDate(issueLinenAfterMendingVO
					.getAddedDate());
			lcMendingReceiptHdr.setAddedAtWsNo(issueLinenAfterMendingVO
					.getAddedAtWsNo());
			lcMendingReceiptHdr.setAddedFacilityId(issueLinenAfterMendingVO
					.getAddedFacilityId());
			lcMendingReceiptHdr.setModifiedAtWsNo(issueLinenAfterMendingVO
					.getModifiedAtWsNo());
			lcMendingReceiptHdr.setModifiedById(issueLinenAfterMendingVO
					.getModifiedById());
			lcMendingReceiptHdr.setModifiedDate(issueLinenAfterMendingVO
					.getModifiedDate());
			lcMendingReceiptHdr.setModifiedFacilityId(issueLinenAfterMendingVO
					.getModifiedFacilityId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lcMendingReceiptHdr;
	}

	public Object convertVO2DO(Object vo) throws AssemblerException {
		int index = 0;
		DTO dto = new DTO();
		List issueList = new ArrayList();
		List createList = new ArrayList();
		List updateList = new ArrayList();

		IssueLinenAfterMendingVO issueLinenAfterMendingVO = (IssueLinenAfterMendingVO) vo;
		for (Iterator iter = issueLinenAfterMendingVO.getLinenIssueList()
				.iterator(); iter.hasNext();) {
			LcMendingReceiptDtl lcMendingReceiptDtl = new LcMendingReceiptDtl();
			LcMendingReceiptDtlId lcMendingReceiptDtlId = new LcMendingReceiptDtlId();
			LcMendingReceiptHdr lcMendingReceiptHdr = new LcMendingReceiptHdr();
			LcMendingReceiptHdrId lcMendingReceiptHdrId = new LcMendingReceiptHdrId();
			MendingIssueList element = (MendingIssueList) iter.next();

			try {
				lcMendingReceiptHdrId.setReceiptNum((issueLinenAfterMendingVO
						.getReceiptNum()).trim());
				lcMendingReceiptHdrId
						.setOperatingFacilityId(issueLinenAfterMendingVO
								.getAddedFacilityId());
				lcMendingReceiptHdr.setId(lcMendingReceiptHdrId);
				lcMendingReceiptHdr.setRequestNum((issueLinenAfterMendingVO
						.getRequestNum()).trim());
				lcMendingReceiptHdr.setReceiptDate(issueLinenAfterMendingVO.getIssueDate());
				lcMendingReceiptHdr.setReceivedBy(issueLinenAfterMendingVO
						.getIssueBy());
				lcMendingReceiptDtlId
						.setLcMendingReceiptHdr(lcMendingReceiptHdr);
				lcMendingReceiptDtlId.setLinenItem((element.getLinenItem())
						.trim());
				lcMendingReceiptDtlId.setReceivedQty(element
						.getCurrentIssueQty());
				lcMendingReceiptDtlId.setRemarks(element.getRemark());
				lcMendingReceiptDtlId.setRequestNum((issueLinenAfterMendingVO
						.getRequestNum()).trim());
				lcMendingReceiptDtlId.setAddedById(issueLinenAfterMendingVO
						.getAddedById());
				lcMendingReceiptDtlId.setAddedDate(issueLinenAfterMendingVO
						.getAddedDate());
				lcMendingReceiptDtlId.setAddedAtWsNo(issueLinenAfterMendingVO
						.getAddedAtWsNo());
				lcMendingReceiptDtlId
						.setAddedFacilityId(issueLinenAfterMendingVO
								.getAddedFacilityId());
				lcMendingReceiptDtlId
						.setModifiedAtWsNo(issueLinenAfterMendingVO
								.getModifiedAtWsNo());
				lcMendingReceiptDtlId.setModifiedById(issueLinenAfterMendingVO
						.getModifiedById());
				lcMendingReceiptDtlId.setModifiedDate(issueLinenAfterMendingVO
						.getModifiedDate());
				lcMendingReceiptDtlId
						.setModifiedFacilityId(issueLinenAfterMendingVO
								.getModifiedFacilityId());
				lcMendingReceiptDtl.setId(lcMendingReceiptDtlId);
			} catch (Exception e) {
				e.printStackTrace();
			}

			createList.add(lcMendingReceiptDtl);
			// updateList.add(lcStdLinenStkDtl) ;
		}
		issueList.add(createList);
		// standardStockList.add(updateList);
		return issueList;
	}

	public Object convertDO2VO(Object oDO) throws AssemblerException {
		List requestsList = new ArrayList();

		for (Iterator iter = ((List) oDO).iterator(); iter.hasNext();) {

			LcMendingRequestDtl lcMendingRequestDtl = ((LcMendingRequestDtl) iter
					.next());
			MendingListVO requestsListVO = new MendingListVO();
			requestsListVO.setLinenItem(lcMendingRequestDtl.getId().getLcLinenItem().getLinenItem());
			requestsListVO.setShortDesc(lcMendingRequestDtl.getId().getLcLinenItem().getShortDesc());
			requestsListVO.setRequestedQty(lcMendingRequestDtl.getRequestedQty());
			requestsListVO.setRequestNo(lcMendingRequestDtl.getId().getLcMendingRequestHdr().getId().getRequestNum());
			IBADateTime dt1=new IBADateTime(lcMendingRequestDtl.getId().getLcMendingRequestHdr().getRequestDate());
			dt1.setPattern("dd/MM/yyyy HH:mm");
			requestsListVO.setRequestDate(dt1);
			requestsListVO.setSentBy(lcMendingRequestDtl.getId().getLcMendingRequestHdr().getSentBy());
			requestsListVO.setAgencyCode(lcMendingRequestDtl.getId().getLcMendingRequestHdr().getLcAgency().getAgencyCode());
			requestsListVO.setRequestStatus(lcMendingRequestDtl.getId().getLcMendingRequestHdr().getRequestStatus());
			requestsList.add(requestsListVO);

		}
		return requestsList;
	}

}
