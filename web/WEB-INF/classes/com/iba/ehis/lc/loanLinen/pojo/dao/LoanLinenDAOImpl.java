/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.loanLinen.pojo.dao;

import java.util.List;
import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.ehis.dobj.LcCleaningRequestDtl;
import com.iba.ehis.dobj.LcLoanDtls;
import com.iba.ehis.dobj.LcLoanDtlsId;
import com.iba.ehis.dobj.LcReason;
import com.iba.ehis.dobj.LcRequestHdr;
import com.iba.ehis.dobj.LcRequestHdrId;
import com.iba.ehis.lc.core.pojo.dao.LcDAOImpl;
import com.iba.ehis.lc.loanLinen.util.LoanedLinenAssembler;
import com.iba.ehis.lc.loanLinen.util.LoanedLinenViewAssembler;
import com.iba.ehis.lc.loanLinen.vo.LoanLinenMainVO;
import com.iba.ehis.lc.loanLinen.vo.LoanLinenVO;
import com.iba.ehis.lc.requestForLinen.util.RequestForLinenAssembler;
import com.iba.ehis.lc.requestForLinen.util.RequestForLinenViewAssembler;
import com.iba.ehis.lc.requestForLinen.vo.PlaceLinenRequestVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DAOCommand;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.DateUtil;

public class LoanLinenDAOImpl extends LcDAOImpl {

	public DTO getMasterType(AppVO appVo) throws ApplicationException,
			AssemblerException {
		DAOCommand command = new DAOCommand();
		try {
			command.setObject(((LoanLinenVO) appVo).getLoanRefNum());
			command.setEntityClass(LcLoanDtls.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// DTO dto = (DTO) super.findById(command);
		DTO dto = (DTO) super.findById(command);
		try {
			dto.setObject(((LoanedLinenAssembler) getAppAssembler())
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
		super.create(((LoanedLinenAssembler) getAppAssembler())
				.convertVO2DO(appVo));
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

	public DTO updateMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {
		DTO dto = new DTO();
		try {
			LoanLinenVO loanLinenVO = ((LoanLinenMainVO) appVo)
					.getLoanLinenVO();
			LcLoanDtls dtl = new LcLoanDtls();
			LcLoanDtlsId dtlId = new LcLoanDtlsId();
			dtlId.setLoanRefNum(loanLinenVO.getLoanRefNum().trim());
			dtlId.setOperatingFacilityId(((LoanLinenMainVO) appVo)
					.getAddedFacilityId());
			dtl.setId(dtlId);
			DAOCommand command = new DAOCommand();
			command.setEntityName("LcLoanDtls");
			command.setObject(dtl.getId());
			command.setEntityClass(LcLoanDtls.class);
			dto = (DTO) super.findById(command);
			LcLoanDtls lcLoanDtls = (LcLoanDtls) dto.getObject();
			if (((LoanLinenMainVO) appVo).getCheckView() == "cud") {
				lcLoanDtls.setReceivedQty(loanLinenVO.getReceivedQty());
				lcLoanDtls.setReceivedBackBy(loanLinenVO.getReceivedBackBy()
						.trim());
				lcLoanDtls.setGivenBackBy(loanLinenVO.getGivenBackBy().trim());
				lcLoanDtls.setReceivedWriteOff(loanLinenVO
						.getReceivedWriteOff().trim());
			} else {
				lcLoanDtls.setCancelledBy(loanLinenVO.getCancelledBy());
				lcLoanDtls.setLoanStatus(loanLinenVO.getRequestStatus());
				lcLoanDtls.setReasonForLoan(loanLinenVO.getCancelReason());
				lcLoanDtls.setCancelledDate(loanLinenVO.getCancelledDate());
			}
			super.update(dtl);
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

		DTO dto = super.queryMasterType(resultVo);

		return dto;
	}

}
