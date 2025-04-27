/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.loanLinen.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.dobj.LcLinenItem;
import com.iba.ehis.dobj.LcLoanDtls;
import com.iba.ehis.dobj.LcLoanDtlsId;
import com.iba.ehis.dobj.LcReason;
import com.iba.ehis.dobj.LcRequestDtl;
import com.iba.ehis.dobj.LcRequestDtlId;
import com.iba.ehis.dobj.LcRequestHdr;
import com.iba.ehis.dobj.LcRequestHdrId;
import com.iba.ehis.lc.core.util.LcDateFormat;
import com.iba.ehis.lc.loanLinen.vo.LoanLinenVO;
import com.iba.ehis.lc.loanLinen.vo.LoanListVO;
import com.iba.ehis.lc.requestForLinen.vo.LinenRequestList;
import com.iba.ehis.lc.requestForLinen.vo.PlaceLinenRequestVO;
import com.iba.ehis.lc.requestForLinen.vo.RequestsListVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.DateUtil;
import com.iba.framework.core.util.IBADateTime;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.core.vo.UserPreferences;
import com.iba.framework.logging.pojo.business.IBALogger;

public class LoanedLinenAssembler extends AppAssembler {

	public Object convertVO2DO(Object vo) throws AssemblerException {
		LcLoanDtls lcLoanDtls = new LcLoanDtls();
		LcLoanDtlsId lcLoanDtlsId = new LcLoanDtlsId();
		LcReason lcReason = new LcReason();
		try {
			LoanLinenVO loanLinenVO = (LoanLinenVO) vo;

			lcLoanDtlsId.setOperatingFacilityId(loanLinenVO.getAddedFacilityId());
			lcLoanDtlsId.setLoanRefNum(loanLinenVO.getLoanRefNum());
			lcLoanDtls.setId(lcLoanDtlsId);
			lcLoanDtls.setSourceCode(loanLinenVO.getSourceCode());
			lcLoanDtls.setSourceType(loanLinenVO.getSourceType());
			lcLoanDtls.setLoanedToSourceCode(loanLinenVO.getLoanedToSourceCode());
			lcLoanDtls.setLoanedToSourceType(loanLinenVO.getLoanedToSourceType());
			lcLoanDtls.setLoanDate(loanLinenVO.getLoanDate());
			lcLoanDtls.setLinenItem(loanLinenVO.getLinenItem());
			lcLoanDtls.setReceivedBy(loanLinenVO.getReceivedBy());
			lcLoanDtls.setGivenBy(loanLinenVO.getGivenBy());
			lcLoanDtls.setLoanStatus(loanLinenVO.getRequestStatus());
			lcLoanDtls.setCancelledBy(loanLinenVO.getCancelledBy());
			lcLoanDtls.setRemarks(loanLinenVO.getRemarks());
			lcLoanDtls.setLoanQty(loanLinenVO.getLoanedQty());

			if (loanLinenVO.getCancelledDate() != null) {
				lcLoanDtls.setCancelledDate(loanLinenVO.getCancelledDate());
			} else {
				Date cancel = null;
				lcLoanDtls.setCancelledDate(cancel);
			}
			if (loanLinenVO.getReasonCode() != null) {
				lcReason.setReasonCode(loanLinenVO.getReasonCode());
			} else {
				lcReason.setReasonCode("");
			}
			if (loanLinenVO.getReasonDesc() != null) {
				lcReason.setReasonDesc(loanLinenVO.getReasonDesc());
			} else {
				lcReason.setReasonDesc("");
			}

			lcLoanDtls.setReasonForLoan(loanLinenVO.getReasonCode());
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

	public Object convertDO2VO(Object oDO) throws AssemblerException {
		List requestsList = new ArrayList();
		UserPreferences userPrefs =new UserPreferences();
		String dtf=userPrefs.getDateFormat() ;
		String tm=userPrefs.getTimeFormat();
		String pattern=dtf+" "+tm;
		for (Iterator iter = ((List) oDO).iterator(); iter.hasNext();) {
			LcLoanDtls lcLoanDtls = ((LcLoanDtls) iter.next());

			LoanListVO loanListVO = new LoanListVO();
			loanListVO.setLinenItem(lcLoanDtls.getLinenItem());
			loanListVO.setSourceCode(lcLoanDtls.getSourceCode());
			loanListVO.setSourceType(lcLoanDtls.getSourceType());
			loanListVO
					.setLoanedToSourceCode(lcLoanDtls.getLoanedToSourceCode());
			loanListVO
					.setLoanedToSourceType(lcLoanDtls.getLoanedToSourceType());
			loanListVO.setLoanRefNum(lcLoanDtls.getId().getLoanRefNum());
			loanListVO.setLoanStatus(lcLoanDtls.getLoanStatus());
			loanListVO.setLoanedQty(lcLoanDtls.getLoanQty());
			loanListVO.setReceivedQty(lcLoanDtls.getReceivedQty());
			IBALogger.getLogger().debug(this.getClass(),"DO-VO========>load Date::"+lcLoanDtls.getLoanDate(),null);
			IBADateTime dt1=new IBADateTime(lcLoanDtls.getLoanDate());
			dt1.setPattern("dd/MM/yyyy HH:mm");
			loanListVO.setLoanDate(dt1);
			IBALogger.getLogger().debug(this.getClass(),"DO-VO========>load Date::"+loanListVO.getLoanDate(),null);
			loanListVO.setGivenBy(lcLoanDtls.getGivenBy());
			loanListVO.setReceivedBy(lcLoanDtls.getReceivedBy());
			loanListVO.setRemarks(lcLoanDtls.getRemarks());
			try {
				if (lcLoanDtls.getReasonForLoan() != null) {
					loanListVO.setReasonCode(lcLoanDtls.getReasonForLoan());
				}
				if (lcLoanDtls.getCancelledBy() != null) {
					loanListVO.setCancelledBy(lcLoanDtls.getCancelledBy());
				}
				if (lcLoanDtls.getCancelledDate() != null) {
					IBADateTime dt2=new IBADateTime(lcLoanDtls
							.getCancelledDate());
					dt2.setPattern("dd/MM/yyyy HH:mm");
					loanListVO
							.setCancelledDate(dt2);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			requestsList.add(loanListVO);

		}

		return requestsList;
	}

}
