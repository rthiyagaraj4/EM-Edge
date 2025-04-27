/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package com.iba.ehis.lc.issueLinenAfterMending.pojo.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.pojo.dao.AppDAOImpl;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.ehis.core.util.VODOMapReader;
import com.iba.ehis.dobj.LcCleaningRequestHdr;
import com.iba.ehis.dobj.LcCleaningRequestHdrId;
import com.iba.ehis.dobj.LcIssueDtl;
import com.iba.ehis.dobj.LcIssueHdr;
import com.iba.ehis.dobj.LcLinenItem;
import com.iba.ehis.dobj.LcLinenType;
import com.iba.ehis.dobj.LcMendingRequestHdr;
import com.iba.ehis.dobj.LcMendingRequestHdrId;
import com.iba.ehis.dobj.LcReason;
import com.iba.ehis.dobj.LcRequestDtl;
import com.iba.ehis.dobj.LcRequestHdr;
import com.iba.ehis.dobj.LcRequestHdrId;
import com.iba.ehis.lc.issueLinenAfterMending.util.IssueLinenAfterMendingAssembler;
import com.iba.ehis.lc.issueLinenAfterMending.vo.IssueLinenAfterMendingVO;
import com.iba.ehis.lc.issueOfLinen.util.IssueOfLinenAssembler;
import com.iba.ehis.lc.issueOfLinen.vo.IssueOfLinenMainVO;
import com.iba.ehis.lc.issueOfLinen.vo.IssueOfLinenVO;
import com.iba.ehis.lc.linenType.vo.LinentypeVO;
import com.iba.ehis.lc.requestForCleaningLinen.util.RequestForCleaningLinenAssembler;
import com.iba.ehis.lc.standardStock.util.StandardStockAssembler;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DAOCommand;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.DateUtil;

/**
 * @author yadavk
 * 
 */
public class IssueLinenAfterMendingDAOImpl extends AppDAOImpl {
	public AppAssembler appAssembler = new AppAssembler();


	public DTO insertMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {

		DTO dto = new DTO();
		Object obj=((IssueLinenAfterMendingAssembler) getAppAssembler()).convertVO2DO1(appVo);
		super.create(obj);
		try{ 
			
			
			DAOCommand command = new DAOCommand();
			command.setEntityName("LcMendingRequestHdr");	
			LcMendingRequestHdrId hdrId=new LcMendingRequestHdrId();
			hdrId.setOperatingFacilityId((((IssueLinenAfterMendingVO )appVo).getOperatingFacilityId()).trim());
			hdrId.setRequestNum((((IssueLinenAfterMendingVO )appVo).getRequestNum()).trim());
			command.setObject(hdrId);
			command.setEntityClass(LcMendingRequestHdr.class);
			dto = (DTO) super.findById(command );
			LcMendingRequestHdr lcMendingRequestHdr = (LcMendingRequestHdr) dto.getObject();
			lcMendingRequestHdr.setRequestStatus(((IssueLinenAfterMendingVO )appVo).getRequestStatus().trim());
			lcMendingRequestHdr.setId(hdrId);
			super.update(lcMendingRequestHdr);
		}catch(Exception e){e.printStackTrace();}
		
		List list = (List) ((IssueLinenAfterMendingAssembler) getAppAssembler())
				.convertVO2DO(appVo);
		if (((List) list.get(0)).size() > 0)
			super.create(((List) list.get(0)).toArray());
		DTO dto1=new DTO();
		dto1.setStatus(Constants.SUCCESS);
		dto1.setMessageId(Constants.OPERATION_SUCCESS);
		return dto1;
	}

	public DTO updateMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {
		DTO dto = new DTO();
		Object obj=((IssueLinenAfterMendingAssembler) getAppAssembler()).convertVO2DO1(appVo);
		super.update(obj);
		List list = (List) ((IssueLinenAfterMendingAssembler) getAppAssembler())
				.convertVO2DO(appVo);
		try {
			if (((List) list.get(0)).size() > 0)
				super.update(((List) list.get(0)).toArray());
			dto.setStatus(Constants.SUCCESS);
		} catch (Exception e) {
			dto.setStatus(Constants.FAILED);
		}
		return dto;
	}

	public DTO queryMasterType(QueryResultVO resultVo)
			throws ApplicationException {
		DTO dto=new DTO();
		
		if(resultVo.getFunctionId().equals("requestForMending"))
		{
			dto = super.queryMasterType(resultVo);
		}
		else if(resultVo.getFunctionId().equals("mending"))
		{
		resultVo.setFunctionId("mending");
		dto = super.queryMasterType(resultVo);
		}
		else
		{
				dto = super.queryMasterType(resultVo);
		}

		return dto;
	}

}
