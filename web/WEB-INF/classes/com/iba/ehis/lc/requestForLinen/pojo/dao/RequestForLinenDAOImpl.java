/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.requestForLinen.pojo.dao;



import java.util.List;
import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.ehis.dobj.LcCleaningRequestDtl;
import com.iba.ehis.dobj.LcReason;
import com.iba.ehis.dobj.LcRequestHdr;
import com.iba.ehis.dobj.LcRequestHdrId;
import com.iba.ehis.lc.core.pojo.dao.LcDAOImpl;
import com.iba.ehis.lc.requestForLinen.util.RequestForLinenAssembler;
import com.iba.ehis.lc.requestForLinen.util.RequestForLinenViewAssembler;
import com.iba.ehis.lc.requestForLinen.vo.PlaceLinenRequestVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DAOCommand;
import com.iba.framework.core.util.DTO;



public class RequestForLinenDAOImpl extends LcDAOImpl {

	public DTO getMasterType(AppVO appVo) throws ApplicationException,
			AssemblerException {
		DAOCommand command = new DAOCommand();
		try {
			command.setObject(((PlaceLinenRequestVO) appVo).getRequestNum());
			command.setEntityClass(LcCleaningRequestDtl.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// DTO dto = (DTO) super.findById(command);
		DTO dto = (DTO) super.findById(command);
		try {
			dto.setObject(((RequestForLinenAssembler) getAppAssembler()).convertDO2VO(dto.getObject()));
		} catch (AssemblerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dto;
	}

	public DTO insertMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {

		DTO dto = new DTO();
		super.create(((RequestForLinenAssembler) getAppAssembler()).convertVO2DO1(appVo));
		List list = (List) ((RequestForLinenAssembler) getAppAssembler()).convertVO2DO(appVo);
		if (((List) list.get(0)).size() > 0)
			super.create(((List) list.get(0)).toArray());
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}
	  
	public DTO updateMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {
		DTO dto = new DTO();
	try {
		LcRequestHdr hdr = (LcRequestHdr) ((RequestForLinenViewAssembler) getAppAssembler()).convertVO2DO(appVo);
		DAOCommand command = new DAOCommand();
		command.setEntityName("LcRequestHdr");	
		LcRequestHdrId hdrId = new LcRequestHdrId(); 
		hdrId.setOperatingFacilityId((hdr.getId().getOperatingFacilityId()).trim());
		hdrId.setRequestNum((hdr.getId().getRequestNum()).trim());
		command.setObject(hdrId);
		command.setEntityClass(LcRequestHdr.class);
		dto = (DTO) super.findById(command );
		LcRequestHdr hdRequestHdr = (LcRequestHdr) dto.getObject();
		hdRequestHdr.setCancelledBy(hdr.getCancelledBy());
		LcReason lcReason=new LcReason();
		lcReason.setReasonCode(hdr.getLcReason().getReasonCode());
		lcReason.setReasonDesc(hdr.getLcReason().getReasonDesc());
		hdRequestHdr.setRequestStatus(hdr.getRequestStatus());
		hdRequestHdr.setLcReason(lcReason);	
		hdRequestHdr.setCancelledDate(hdr.getCancelledDate());
			
		super.update(hdRequestHdr);
	 		dto.setStatus(Constants.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			dto.setStatus(Constants.FAILED);
		}
		dto.setObject(appVo);
		return dto;
	}
public DTO queryMasterType(QueryResultVO resultVo)throws ApplicationException {
	
		
		DTO dto = super.queryMasterType(resultVo);
		
		return dto;
	}

}
