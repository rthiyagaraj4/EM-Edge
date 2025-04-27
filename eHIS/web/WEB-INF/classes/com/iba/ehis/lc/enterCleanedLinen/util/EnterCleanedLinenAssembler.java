/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.enterCleanedLinen.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.iba.ehis.dobj.LcCleanedLinenDtl;
import com.iba.ehis.dobj.LcCleanedLinenDtlId;
import com.iba.ehis.dobj.LcCleanedLinenHdr;
import com.iba.ehis.dobj.LcCleanedLinenHdrId;
import com.iba.ehis.dobj.LcLinenItem;
import com.iba.ehis.dobj.LcReason;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.lc.enterCleanedLinen.vo.EnterCleanedLinenVO;
import com.iba.ehis.lc.enterCleanedLinen.vo.EnterListVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.DateUtil;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;

public class EnterCleanedLinenAssembler extends AppAssembler {
	public static final Logger logger = LogFactory.getApplicationLogger();

	public Object convertDO2VO(Object dObj, Class classVO)
			throws AssemblerException {
		return convertDO2VO(dObj);
	}

	public Object convertVO2DO1(Object vo) throws AssemblerException {

		EnterCleanedLinenVO enterCleanedLinenVO = (EnterCleanedLinenVO) vo;
		LcCleanedLinenHdr cleanedLinenHdr = new LcCleanedLinenHdr();
		LcCleanedLinenHdrId cleanedLinenHdrId = new LcCleanedLinenHdrId();
		try {
			cleanedLinenHdr.setRemarks(enterCleanedLinenVO.getRemark());
			cleanedLinenHdr.setCleaningDoneBy(enterCleanedLinenVO
					.getCleaningDoneBy());
			cleanedLinenHdr.setCleaningDate(enterCleanedLinenVO.getCleaningDate());
			cleanedLinenHdrId.setCleaningRefNum(enterCleanedLinenVO
					.getCleaningRefNo());
			cleanedLinenHdrId.setOperatingFacilityId(enterCleanedLinenVO
					.getAddedFacilityId());
			cleanedLinenHdr.setId(cleanedLinenHdrId);
			cleanedLinenHdr.setAddedById(enterCleanedLinenVO.getAddedById());
			cleanedLinenHdr.setAddedDate(enterCleanedLinenVO.getAddedDate());
			cleanedLinenHdr
					.setAddedAtWsNo(enterCleanedLinenVO.getAddedAtWsNo());
			cleanedLinenHdr.setAddedFacilityId(enterCleanedLinenVO
					.getAddedFacilityId());
			cleanedLinenHdr.setModifiedAtWsNo(enterCleanedLinenVO
					.getModifiedAtWsNo());
			cleanedLinenHdr.setModifiedById(enterCleanedLinenVO
					.getModifiedById());
			cleanedLinenHdr.setModifiedDate(enterCleanedLinenVO
					.getModifiedDate());
			cleanedLinenHdr.setModifiedFacilityId(enterCleanedLinenVO
					.getModifiedFacilityId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cleanedLinenHdr;
	}

	public Object convertVO2DO(Object vo) throws AssemblerException {
		int index = 0;
		DTO dto = new DTO();
		List issueList = new ArrayList();
		List createList = new ArrayList();
		List updateList = new ArrayList();

		EnterCleanedLinenVO enterCleanedLinenVO = (EnterCleanedLinenVO) vo;
		for (Iterator iter = enterCleanedLinenVO.getLinenEnterList().iterator(); iter
				.hasNext();) {
			LcCleanedLinenDtl cleanedLinenDtl = new LcCleanedLinenDtl();
			LcCleanedLinenDtlId lcCleanedLinenDtlid = new LcCleanedLinenDtlId();
			LcLinenItem lcLinenItem = new LcLinenItem();
			LcReason lcReason = new LcReason();
			LcCleanedLinenHdr cleanedLinenHdr = new LcCleanedLinenHdr();
			LcCleanedLinenHdrId cleanedLinenHdrId = new LcCleanedLinenHdrId();
			EnterListVO element = (EnterListVO) iter.next();

			try {
				cleanedLinenDtl.setCleanedQty((Long) element
						.getCleanedQuantity());
				lcLinenItem.setLinenItem(element.getLinenItem());

				cleanedLinenHdrId.setCleaningRefNum(enterCleanedLinenVO
						.getCleaningRefNo());
				cleanedLinenHdrId.setOperatingFacilityId(enterCleanedLinenVO
						.getAddedFacilityId());
				cleanedLinenHdr.setId(cleanedLinenHdrId);

				lcCleanedLinenDtlid.setLcCleanedLinenHdr(cleanedLinenHdr);
				lcCleanedLinenDtlid.setLcLinenItem(lcLinenItem);
				cleanedLinenDtl.setId(lcCleanedLinenDtlid);
				cleanedLinenDtl.setQualityPassed(element.getQualityPassed());

				if (element.getNatureOfDefect() != null) {
					lcReason.setReasonCode(element.getNatureOfDefect());
					cleanedLinenDtl.setLcReasonByNatureOfDefect(lcReason);
				}
				if (element.getReasonForDefect() != null) {
					lcReason.setReasonCode(element.getReasonForDefect());
					cleanedLinenDtl.setLcReasonByReasonForDefect(lcReason);
				}

				cleanedLinenDtl
						.setAddedById(enterCleanedLinenVO.getAddedById());
				cleanedLinenDtl
						.setAddedDate(enterCleanedLinenVO.getAddedDate());
				cleanedLinenDtl.setAddedAtWsNo(enterCleanedLinenVO
						.getAddedAtWsNo());
				cleanedLinenDtl.setAddedFacilityId(enterCleanedLinenVO
						.getAddedFacilityId());
				cleanedLinenDtl.setModifiedAtWsNo(enterCleanedLinenVO
						.getModifiedAtWsNo());
				cleanedLinenDtl.setModifiedById(enterCleanedLinenVO
						.getModifiedById());
				cleanedLinenDtl.setModifiedDate(enterCleanedLinenVO
						.getModifiedDate());
				cleanedLinenDtl.setModifiedFacilityId(enterCleanedLinenVO
						.getModifiedFacilityId());
			} catch (Exception e) {
				e.printStackTrace();
			}

			createList.add(cleanedLinenDtl);

		}
		issueList.add(createList);
		return issueList;
	}

}
