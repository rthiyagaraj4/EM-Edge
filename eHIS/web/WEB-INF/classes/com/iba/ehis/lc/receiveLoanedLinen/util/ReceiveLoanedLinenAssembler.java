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

import org.apache.commons.beanutils.converters.LongArrayConverter;

import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.dobj.LcLoanDtls;
import com.iba.ehis.dobj.LcLoanDtlsId;
import com.iba.ehis.dobj.LcRequestDtl;
import com.iba.ehis.lc.core.util.LcDateFormat;
import com.iba.ehis.lc.receiveLoanedLinen.vo.ReceiveLoanedLinenMainVO;
import com.iba.ehis.lc.receiveLoanedLinen.vo.ReceiveLoanedLinenList;
import com.iba.ehis.lc.receiveLoanedLinen.vo.ReceiveLoanedLinenVO;
import com.iba.ehis.lc.requestForLinen.vo.RequestsListVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.DateUtil;
import com.iba.framework.core.util.IBADateTime;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.core.vo.UserPreferences;
import com.iba.framework.logging.pojo.business.IBALogger;

public class ReceiveLoanedLinenAssembler extends AppAssembler {

	public Object convertDO2VO(Object dObj, Class classVO)
			throws AssemblerException {
		return convertDO2VO(dObj);
	}

	public Object convertVO2DO1(Object vo) throws AssemblerException {
		LcLoanDtls lcLoanDtls = new LcLoanDtls();
		LcLoanDtlsId lcLoanDtlsId = new LcLoanDtlsId();

		try {
			ReceiveLoanedLinenMainVO receiveLoanedLinenMainVO = (ReceiveLoanedLinenMainVO) vo;

			lcLoanDtls.getId().setOperatingFacilityId(
					receiveLoanedLinenMainVO.getAddedFacilityId());
			lcLoanDtls.getId().setLoanRefNum(
					receiveLoanedLinenMainVO.getReceiveLoanedLinenVO()
							.getLoanRefNum());
			lcLoanDtls.setId(lcLoanDtlsId);
			lcLoanDtls.setLoanQty(receiveLoanedLinenMainVO.getReceiveLoanedLinenVO().getReceivedQty());
			IBALogger.getLogger().debug(this.getClass(),"Loaned Qty ::::::::-"+lcLoanDtls.getLoanQty(),null);
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

			lcLoanDtls.setLoanDate(receiveLoanedLinenMainVO.getReceiveLoanedLinenVO().getLoanDate());

			lcLoanDtls.setGivenBackBy(receiveLoanedLinenMainVO
					.getReceiveLoanedLinenVO().getGivenBackBy());
			lcLoanDtls.setReceivedWriteOff(receiveLoanedLinenMainVO
					.getReceiveLoanedLinenVO().getReceivedWriteOff());
			lcLoanDtls.setReceivedQty(receiveLoanedLinenMainVO
					.getReceiveLoanedLinenVO().getReceivedQty());

			lcLoanDtls.setAddedById(receiveLoanedLinenMainVO.getAddedById());
			lcLoanDtls.setAddedDate(receiveLoanedLinenMainVO.getAddedDate());
			lcLoanDtls
					.setAddedAtWsNo(receiveLoanedLinenMainVO.getAddedAtWsNo());
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

		return lcLoanDtls;
	}

	public Object convertDO2VO(Object oDO) throws AssemblerException {
		List receiveLoanedLinenList1 = new ArrayList();
		UserPreferences userPrefs =new UserPreferences();
		String dtf=userPrefs.getDateFormat() ;
		String tm=userPrefs.getTimeFormat();
		String pattern=dtf+" "+tm;
		for (Iterator iter = ((List) oDO).iterator(); iter.hasNext();) {
			LcLoanDtlsId lcLoanDtlsId = new LcLoanDtlsId();

			ReceiveLoanedLinenVO receiveLoanedLinenVO = new ReceiveLoanedLinenVO();

			LcLoanDtls lcLoanDtls = ((LcLoanDtls) iter.next());

			receiveLoanedLinenVO.setLoanedToSourceCode(lcLoanDtls
					.getLoanedToSourceCode());
			receiveLoanedLinenVO.setLoanRefNum(lcLoanDtls.getId()
					.getLoanRefNum());
			IBADateTime dt=new IBADateTime(lcLoanDtls.getLoanDate());
			dt.setPattern("dd/MM/yyyy HH:mm");
			receiveLoanedLinenVO.setLoanDate(dt);
			receiveLoanedLinenVO.setGivenBy(lcLoanDtls.getGivenBy());
			receiveLoanedLinenVO.setReceivedBy(lcLoanDtls.getReceivedBy());
			receiveLoanedLinenVO.setLinenItem(lcLoanDtls.getLinenItem());
			receiveLoanedLinenVO
					.setReasonforLoan(lcLoanDtls.getReasonForLoan());
			receiveLoanedLinenVO.setLoanStatus(lcLoanDtls.getLoanStatus());
			receiveLoanedLinenVO.setSourceCode(lcLoanDtls.getSourceCode());
			receiveLoanedLinenVO.setSourceType(lcLoanDtls.getSourceType());
			receiveLoanedLinenVO.setLoanedToSourceType(lcLoanDtls
					.getLoanedToSourceType());
			receiveLoanedLinenVO.setRemarks(lcLoanDtls.getRemarks());
			receiveLoanedLinenVO.setLoanQty(lcLoanDtls.getLoanQty());
			receiveLoanedLinenVO.setReceivedQty(lcLoanDtls.getReceivedQty());
			

			receiveLoanedLinenList1.add(receiveLoanedLinenVO);

		}

		return receiveLoanedLinenList1;
	}

}
