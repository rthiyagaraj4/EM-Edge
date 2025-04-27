/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.receiveLoanedLinen.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.dobj.LcLoanDtls;
import com.iba.ehis.dobj.LcLoanDtlsId;
import com.iba.ehis.lc.receiveLoanedLinen.vo.ReceiveLoanedLinenMainVO;
import com.iba.ehis.lc.receiveLoanedLinen.vo.ReceiveLoanedLinenList;
import com.iba.ehis.lc.receiveLoanedLinen.vo.ReceiveLoanedLinenList;
import com.iba.ehis.lc.receiveLoanedLinen.vo.ReceiveLoanedLinenVO;
import com.iba.ehis.lc.requestForCleaningLinen.vo.RequestForCleaningLinenMainVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.DateUtil;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;

public class ReceiveLoanedLinenViewAssembler extends AppAssembler {

	public Object convertDO2VO(Object oDO) throws AssemblerException {

		ReceiveLoanedLinenMainVO mainVO = new ReceiveLoanedLinenMainVO();
		for (Iterator iter = ((List) oDO).iterator(); iter.hasNext();) {
			Object[] obj = (Object[]) iter.next();
			ReceiveLoanedLinenList receiveLoanedLinenList = new ReceiveLoanedLinenList();
			receiveLoanedLinenList.setLinenItem((String) obj[0]);
			receiveLoanedLinenList.setLoanedQty(((Long) obj[1]));
			receiveLoanedLinenList.setReceivedQty((Long) obj[2]);

			mainVO.getReceiveLoanedLinenVO().getReceiveLoanedLinenList().add(
					receiveLoanedLinenList);
		}
		return mainVO;
	}

	public Object convertVO2DO(Object vo) throws AssemblerException {
		int index = 0;
		DTO dto = new DTO();
		List receiveLoanedLinenList = new ArrayList();
		List createList = new ArrayList();
		List updateList = new ArrayList();

		ReceiveLoanedLinenVO receiveLoanedLinenVO = (ReceiveLoanedLinenVO) vo;

		for (Iterator iter = receiveLoanedLinenVO.getReceiveLoanedLinenList()
				.iterator(); iter.hasNext();) {
			LcLoanDtls lcLoanDtls = new LcLoanDtls();
			LcLoanDtlsId lcLoanDtlsId = new LcLoanDtlsId();
			ReceiveLoanedLinenList element = (ReceiveLoanedLinenList) iter
					.next();
			ReceiveLoanedLinenMainVO receiveLoanedLinenMainVO = new ReceiveLoanedLinenMainVO();

			try {
				lcLoanDtls.getId().setLoanRefNum(
						receiveLoanedLinenMainVO.getReceiveLoanedLinenVO()
								.getLoanRefNum().trim());
				lcLoanDtls.getId().setOperatingFacilityId(
						receiveLoanedLinenMainVO.getAddedFacilityId());
				lcLoanDtls.setId(lcLoanDtlsId);
				lcLoanDtls.setLinenItem(receiveLoanedLinenMainVO
						.getReceiveLoanedLinenVO().getLinenItem());

				lcLoanDtls.setSourceCode(receiveLoanedLinenMainVO
						.getReceiveLoanedLinenVO().getSourceCode());
				lcLoanDtls.setSourceType(receiveLoanedLinenMainVO
						.getReceiveLoanedLinenVO().getSourceType());
				lcLoanDtls.setLoanedToSourceType(receiveLoanedLinenMainVO
						.getReceiveLoanedLinenVO().getLoanedToSourceType());
				lcLoanDtls.setLoanedToSourceCode(receiveLoanedLinenMainVO
						.getReceiveLoanedLinenVO().getLoanedToSourceCode());
				lcLoanDtls.setGivenBy(receiveLoanedLinenMainVO
						.getReceiveLoanedLinenVO().getGivenBy());
				lcLoanDtls.setReceivedBy(receiveLoanedLinenMainVO
						.getReceiveLoanedLinenVO().getReceivedBy());
				lcLoanDtls.setReasonForLoan(receiveLoanedLinenMainVO
						.getReceiveLoanedLinenVO().getReasonforLoan());
				lcLoanDtls.setRemarks(receiveLoanedLinenMainVO
						.getReceiveLoanedLinenVO().getRemarks());

				lcLoanDtls.setLoanDate(receiveLoanedLinenMainVO
						.getReceiveLoanedLinenVO().getLoanDate());

				lcLoanDtls.getId().setLoanRefNum(
						receiveLoanedLinenMainVO.getReceiveLoanedLinenVO()
								.getLoanRefNum().trim());
				lcLoanDtls.setId(lcLoanDtlsId);

				lcLoanDtls
						.setAddedById(receiveLoanedLinenMainVO.getAddedById());
				lcLoanDtls
						.setAddedDate(receiveLoanedLinenMainVO.getAddedDate());
				lcLoanDtls.setAddedAtWsNo(receiveLoanedLinenMainVO
						.getAddedAtWsNo());
				lcLoanDtls.setAddedFacilityId(receiveLoanedLinenMainVO
						.getAddedFacilityId());
				lcLoanDtls.setModifiedAtWsNo(receiveLoanedLinenMainVO
						.getModifiedAtWsNo());
				lcLoanDtls.setModifiedById(receiveLoanedLinenMainVO
						.getModifiedById());
				lcLoanDtls.setModifiedDate(receiveLoanedLinenMainVO
						.getModifiedDate());
				lcLoanDtls.setModifiedFacilityId(receiveLoanedLinenMainVO
						.getModifiedFacilityId());

			} catch (Exception e) {
				e.printStackTrace();
			}

			createList.add(lcLoanDtls);
			// updateList.add(lcStdLinenStkDtl) ;
		}

		receiveLoanedLinenList.add(createList);
		// standardStockList.add(updateList);
		return receiveLoanedLinenList;
	}

}
