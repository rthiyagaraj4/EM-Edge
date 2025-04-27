/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.loanLinen.util;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.dobj.LcLoanDtls;
import com.iba.ehis.dobj.LcLoanDtlsId;
import com.iba.ehis.dobj.LcReason;
import com.iba.ehis.dobj.LcRequestHdr;
import com.iba.ehis.dobj.LcRequestHdrId;
import com.iba.ehis.lc.loanLinen.vo.LoanLinenMainVO;
import com.iba.ehis.lc.loanLinen.vo.LoanLinenVO;
import com.iba.ehis.lc.loanLinen.vo.LoanListVO;
import com.iba.ehis.lc.loanLinen.vo.ViewResultVO;
import com.iba.ehis.lc.requestForLinen.vo.LinenRequestList;
import com.iba.ehis.lc.requestForLinen.vo.PlaceLinenRequestVO;
import com.iba.ehis.lc.requestForLinen.vo.RequestForLinenMainVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DateUtil;
import com.iba.framework.logging.pojo.business.IBALogger;

public class LoanedLinenViewAssembler extends AppAssembler {

	public Object convertDO2VO(Object oDO) throws AssemblerException {

		LoanLinenMainVO mainVO = new LoanLinenMainVO();
		IBALogger.getLogger().debug(this.getClass(),
				"getStatus:" + oDO.getClass(), null);

		for (Iterator iter = ((List) oDO).iterator(); iter.hasNext();) {
			Object[] obj = (Object[]) iter.next();

			ViewResultVO loanListVO = new ViewResultVO();
			loanListVO.setLinenItem((String) obj[0]);
			loanListVO.setLoanedQty(((Long) obj[1]));
			try {
				if ((Long) obj[2] != null) {
					loanListVO.setReceivedQty((Long) obj[2]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			mainVO.getLoanListVO().getLoanLinenList().add(loanListVO);

		}

		return mainVO;
	}

	public Object convertVO2DO(Object vo) throws AssemblerException {
		LcLoanDtls lcLoanDtls = new LcLoanDtls();
		LcLoanDtlsId lcLoanDtlsId = new LcLoanDtlsId();
		LcReason lcReason = new LcReason();
		try {
			LoanLinenVO loanLinenVO = (LoanLinenVO) vo;

			lcLoanDtlsId.setOperatingFacilityId(loanLinenVO
					.getAddedFacilityId());
			lcLoanDtlsId.setLoanRefNum(loanLinenVO.getLoanRefNum());
			lcLoanDtls.setId(lcLoanDtlsId);
			lcLoanDtls.setSourceCode(loanLinenVO.getSourceCode());
			lcLoanDtls.setSourceType(loanLinenVO.getSourceType());
			lcLoanDtls.setLoanedToSourceCode(loanLinenVO
					.getLoanedToSourceCode());
			lcLoanDtls.setLoanedToSourceType(loanLinenVO
					.getLoanedToSourceType());
			lcLoanDtls.setLoanDate(loanLinenVO.getLoanDate());
			lcLoanDtls.setLinenItem(loanLinenVO.getLinenItem());
			lcLoanDtls.setReceivedBy(loanLinenVO.getReceivedBy());
			lcLoanDtls.setGivenBy(loanLinenVO.getGivenBy());
			lcLoanDtls.setLoanStatus(loanLinenVO.getRequestStatus());
			lcLoanDtls.setRemarks(loanLinenVO.getRemarks());
			lcLoanDtls.setLoanQty(loanLinenVO.getLoanedQty());
			lcLoanDtls.setReasonForLoan(loanLinenVO.getReasonCode());

			if (loanLinenVO.getCancelledDate() != null) {
				lcLoanDtls.setCancelledDate(loanLinenVO.getCancelledDate());
			} else {
				Date cancel = null;
				lcLoanDtls.setCancelledDate(cancel);
			}
			if (loanLinenVO.getCancelReason() != null) {
				lcLoanDtls.setCancelReason(loanLinenVO.getCancelReason());
			} else {
				lcLoanDtls.setCancelReason("");
			}
			if (loanLinenVO.getCancelledBy() != null) {
				lcLoanDtls.setCancelledBy(loanLinenVO.getCancelReason());
			} else {
				lcLoanDtls.setCancelledBy("");
			}

			lcLoanDtls.setAddedById(loanLinenVO.getAddedById());
			lcLoanDtls.setAddedDate(loanLinenVO.getAddedDate());
			lcLoanDtls.setAddedAtWsNo(loanLinenVO.getAddedAtWsNo());
			lcLoanDtls.setAddedFacilityId(loanLinenVO.getAddedFacilityId());
			lcLoanDtls.setModifiedAtWsNo(loanLinenVO.getModifiedAtWsNo());
			lcLoanDtls.setModifiedById(loanLinenVO.getModifiedById());
			lcLoanDtls.setModifiedDate(loanLinenVO.getModifiedDate());
			lcLoanDtls.setModifiedFacilityId(loanLinenVO
					.getModifiedFacilityId());

		} catch (Exception e) {
			// e.printStackTrace();

		}
		return lcLoanDtls;
	}

}
