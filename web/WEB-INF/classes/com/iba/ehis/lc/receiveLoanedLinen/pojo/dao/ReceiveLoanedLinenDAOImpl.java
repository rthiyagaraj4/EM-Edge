/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.receiveLoanedLinen.pojo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.iba.ehis.core.exception.DuplicateRecordException;

import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.ehis.dobj.LcCleaningRequestDtl;

import com.iba.ehis.dobj.LcLoanDtls;
import com.iba.ehis.dobj.LcLoanDtlsId;
import com.iba.ehis.dobj.LcRequestHdr;
import com.iba.ehis.dobj.LcRequestHdrId;

import com.iba.ehis.lc.core.pojo.dao.LcDAOImpl;
import com.iba.ehis.lc.issueOfLinen.util.IssueOfLinenAssembler;

import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.ehis.lc.receiveLoanedLinen.util.ReceiveLoanedLinenAssembler;
import com.iba.ehis.lc.receiveLoanedLinen.vo.ReceiveLoanedLinenMainVO;
import com.iba.ehis.lc.receiveLoanedLinen.vo.ReceiveLoanedLinenVO;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DAOCommand;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.DateUtil;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;

public class ReceiveLoanedLinenDAOImpl extends LcDAOImpl {

	public DTO getMasterType(AppVO appVo) throws ApplicationException,
			AssemblerException {
		DAOCommand command = new DAOCommand();
		try {
			command.setObject(((ReceiveLoanedLinenVO) appVo).getLoanRefNum());
			command.setEntityClass(LcLoanDtls.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DTO dto = (DTO) super.findById(command);
		try {
			dto.setObject(((ReceiveLoanedLinenAssembler) getAppAssembler())
					.convertDO2VO(dto.getObject()));
		} catch (AssemblerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dto;
	}

	public DTO insertMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {

		DTO dto = new DTO();
		super.create(((ReceiveLoanedLinenAssembler) getAppAssembler())
				.convertVO2DO1(appVo));
		List list = (List) ((ReceiveLoanedLinenAssembler) getAppAssembler())
				.convertVO2DO(appVo);
		if (((List) list.get(0)).size() > 0)
			super.create(((List) list.get(0)).toArray());
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

	public DTO updateMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {
		DTO dto = new DTO();
		try {
			ReceiveLoanedLinenVO receiveLoanedLinenVO = ((ReceiveLoanedLinenMainVO) appVo)
					.getReceiveLoanedLinenVO();
			LcLoanDtls lcLoanDtls = new LcLoanDtls();
			LcLoanDtlsId dtlId = new LcLoanDtlsId();
			dtlId.setLoanRefNum(receiveLoanedLinenVO.getLoanRefNum().trim());
			dtlId.setOperatingFacilityId(((ReceiveLoanedLinenMainVO) appVo)
					.getAddedFacilityId());
			lcLoanDtls.setId(dtlId);

			DAOCommand command = new DAOCommand();
			command.setEntityName("LcLoanDtls");
			command.setObject(lcLoanDtls.getId());
			command.setEntityClass(LcLoanDtls.class);
			dto = (DTO) super.findById(command);
			LcLoanDtls lcLoanDtls1 = (LcLoanDtls) dto.getObject();
			lcLoanDtls1.setReceivedQty(receiveLoanedLinenVO.getReceivedQty());
			lcLoanDtls1.setReceivedBackBy(receiveLoanedLinenVO
					.getReceivedBackBy().trim());
			lcLoanDtls1.setGivenBackBy(receiveLoanedLinenVO.getGivenBackBy()
					.trim());
			lcLoanDtls1.setReceivedWriteOff(receiveLoanedLinenVO
					.getReceivedWriteOff().trim());
			
			lcLoanDtls1.setLoanStatus(receiveLoanedLinenVO
					.getLoanStatus().trim());
		
			// lcLoanDtls.setCancelledDate(DateUtil.convertStringToDate("dd/MM/yyyy
			// HH:mm",loanLinenVO.getCancelledDate()));

			super.update(lcLoanDtls1);
			dto.setStatus(Constants.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			dto.setStatus(Constants.FAILED);
		}
		dto.setObject(appVo);
		return dto;
	}

	public DTO queryMasterType(QueryResultVO resultVo)
			throws ApplicationException {

		// resultVo.setFunctionId("LOAN_LINEN");
		// resultVo.setModuleId("LC");
		DTO dto = super.queryMasterType(resultVo);

		return dto;
	}

	
}
