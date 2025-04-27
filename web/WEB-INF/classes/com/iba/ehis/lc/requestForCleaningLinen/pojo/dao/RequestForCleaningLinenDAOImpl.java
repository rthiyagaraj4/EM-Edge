/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.requestForCleaningLinen.pojo.dao;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.ehis.dobj.LcCleaningRequestDtl;
import com.iba.ehis.dobj.LcCleaningRequestDtlId;
import com.iba.ehis.dobj.LcCleaningRequestHdr;
import com.iba.ehis.dobj.LcCleaningRequestHdrId;
import com.iba.ehis.dobj.LcLinenItem;
import com.iba.ehis.dobj.LcReason;
import com.iba.ehis.lc.core.pojo.dao.LcDAOImpl;
import com.iba.ehis.lc.issueOfLinen.vo.IssueOfLinenVO;
import com.iba.ehis.lc.requestForCleaningLinen.util.RequestForCleaningLinenAssembler;
import com.iba.ehis.lc.requestForCleaningLinen.vo.CleaningLinenRequestList;
import com.iba.ehis.lc.requestForCleaningLinen.vo.PlaceCleaningLinenRequestVO;
import com.iba.ehis.lc.requestForCleaningLinen.vo.RequestForCleaningLinenMainVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DAOCommand;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.DateUtil;

public class RequestForCleaningLinenDAOImpl extends LcDAOImpl {

	public DTO getMasterType(AppVO appVo) throws ApplicationException,
			AssemblerException {
		DAOCommand command = new DAOCommand();
		try {
			command.setObject(((PlaceCleaningLinenRequestVO) appVo).getRequestNum());
			command.setEntityClass(LcCleaningRequestDtl.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// DTO dto = (DTO) super.findById(command);
		DTO dto = (DTO) super.findById(command);
		try {
			dto.setObject(((RequestForCleaningLinenAssembler) getAppAssembler()).convertDO2VO(dto.getObject()));
		} catch (AssemblerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dto;
	}

	public DTO insertMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {

		DTO dto = new DTO();
		super.create(((RequestForCleaningLinenAssembler) getAppAssembler()).convertVO2DO1(appVo));
		List list = (List) ((RequestForCleaningLinenAssembler) getAppAssembler()).convertVO2DO(appVo);
		if (((List) list.get(0)).size() > 0)
			super.create(((List) list.get(0)).toArray());
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}
	  
public DTO updateMasterType(AppVO appVo) throws DuplicateRecordException,
	AssemblerException, ApplicationException {
DTO dto = new DTO();
List createList = new ArrayList();
RequestForCleaningLinenMainVO requestForCleaningLinenMainVO = (RequestForCleaningLinenMainVO) appVo;
PlaceCleaningLinenRequestVO placeCleaningLinenRequestVO=requestForCleaningLinenMainVO.getPlaceCleaningLinenRequestVO();
if(requestForCleaningLinenMainVO.getViewCode().equals("pending"))
{
	for (Iterator iter = placeCleaningLinenRequestVO.getCleanLinenRequest().iterator(); iter
	.hasNext();) 
	{
	try {
		LcCleaningRequestDtl lcCleaningRequestDtl = new LcCleaningRequestDtl();
		LcCleaningRequestDtlId lcCleaningRequestDtlId = new LcCleaningRequestDtlId();
		LcCleaningRequestHdr cleaningRequestHdr=new LcCleaningRequestHdr();
		LcCleaningRequestHdrId lcCleaningRequestHdrId=new LcCleaningRequestHdrId();
		LcLinenItem lcLinenItem=new LcLinenItem();
		CleaningLinenRequestList element = (CleaningLinenRequestList) iter.next();

		lcCleaningRequestHdrId.setOperatingFacilityId(requestForCleaningLinenMainVO.getAddedFacilityId().trim());
		lcCleaningRequestHdrId.setRequestNum(element.getRequestNo().trim());
		cleaningRequestHdr.setRequestDate(element.getRequestDate());
		cleaningRequestHdr.setId(lcCleaningRequestHdrId);
		lcCleaningRequestDtlId.setLcCleaningRequestHdr(cleaningRequestHdr);
		lcCleaningRequestDtlId.setCategory(element.getCategory());
		lcLinenItem.setLinenItem(element.getLinenItem().trim());
		lcCleaningRequestDtlId.setLcLinenItem(lcLinenItem);
		lcCleaningRequestDtl.setId(lcCleaningRequestDtlId);
		lcCleaningRequestDtl.setRequestDate(element.getRequestDate());
		lcCleaningRequestDtl.setRemarks(element.getRemark());
		lcCleaningRequestDtl.setRequestedQty((Long) element.getRequestedQty());	
		lcCleaningRequestDtl.setCountConfirmedYn(element.getConfirm().trim());
		lcCleaningRequestDtl.setCountConfirmedBy(element.getCountConfirmedBy().trim());
		lcCleaningRequestDtl.setCountConfirmedDate(element.getCountConfirmedDate());
		lcCleaningRequestDtl.setSchdDeliveryDate(element.getScheduleDeliveryDate());
		lcCleaningRequestDtl.setAddedById(requestForCleaningLinenMainVO.getAddedById());
		lcCleaningRequestDtl.setAddedDate(requestForCleaningLinenMainVO.getAddedDate());
		lcCleaningRequestDtl.setAddedAtWsNo(requestForCleaningLinenMainVO.getAddedAtWsNo());
		lcCleaningRequestDtl.setAddedFacilityId(requestForCleaningLinenMainVO.getAddedFacilityId());
		lcCleaningRequestDtl.setModifiedAtWsNo(requestForCleaningLinenMainVO.getModifiedAtWsNo());			
		lcCleaningRequestDtl.setModifiedById(requestForCleaningLinenMainVO.getModifiedById());
		lcCleaningRequestDtl.setModifiedDate(requestForCleaningLinenMainVO.getModifiedDate());
		lcCleaningRequestDtl.setModifiedFacilityId(requestForCleaningLinenMainVO.getModifiedFacilityId());
		createList.add(lcCleaningRequestDtl);
		} catch (Exception e) {e.printStackTrace();}
	
	}
	
		super.update(((List) createList).toArray());
		dto.setStatus(Constants.SUCCESS);
		return dto;
}else{
try {
LcCleaningRequestHdr hdr = (LcCleaningRequestHdr) ((RequestForCleaningLinenAssembler) getAppAssembler()).convertVO2DO1(appVo);
DAOCommand command = new DAOCommand();
command.setEntityName("LcCleaningRequestHdr");	
LcCleaningRequestHdrId hdrId = new LcCleaningRequestHdrId(); 
hdrId.setOperatingFacilityId((hdr.getId().getOperatingFacilityId()).trim());
hdrId.setRequestNum((hdr.getId().getRequestNum()).trim());
command.setObject(hdrId);
command.setEntityClass(LcCleaningRequestHdr.class);
dto = (DTO) super.findById(command );
LcCleaningRequestHdr lcCleaningRequestHdr = (LcCleaningRequestHdr) dto.getObject();
lcCleaningRequestHdr.setCancelledBy(hdr.getCancelledBy());
LcReason lcReason=new LcReason();
lcReason.setReasonCode(hdr.getLcReason().getReasonCode());
lcReason.setReasonDesc(hdr.getLcReason().getReasonDesc());
lcCleaningRequestHdr.setLcReason(lcReason);
lcCleaningRequestHdr.setRequestStatus(hdr.getRequestStatus());
lcCleaningRequestHdr.setCancelledDate(hdr.getCancelledDate());
super.update(lcCleaningRequestHdr);
dto = new DTO();
		dto.setStatus(Constants.SUCCESS);
} catch (Exception e) {
	e.printStackTrace();
	dto.setStatus(Constants.FAILED);
}
}
return dto;
}
public DTO queryMasterType(QueryResultVO resultVo)throws ApplicationException {
	
		
		DTO dto = super.queryMasterType(resultVo);
		
		return dto;
	}

}
