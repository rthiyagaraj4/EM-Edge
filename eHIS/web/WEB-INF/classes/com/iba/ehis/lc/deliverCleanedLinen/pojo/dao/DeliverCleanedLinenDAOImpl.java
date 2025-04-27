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
package com.iba.ehis.lc.deliverCleanedLinen.pojo.dao;

import java.util.List;

import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.pojo.dao.AppDAOImpl;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.ehis.dobj.LcCleaningRequestHdr;
import com.iba.ehis.dobj.LcCleaningRequestHdrId;
import com.iba.ehis.lc.deliverCleanedLinen.util.DeliverCleanedLinenAssembler;
import com.iba.ehis.lc.deliverCleanedLinen.vo.DeliverCleanedLinenVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.DateUtil;

/**
 * @author yadavk
 * 
 */
public class DeliverCleanedLinenDAOImpl extends AppDAOImpl {
	public AppAssembler appAssembler = new AppAssembler();


	public DTO insertMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {

		DTO dto = new DTO();
		Object obj=((DeliverCleanedLinenAssembler) getAppAssembler()).convertVO2DO1(appVo);
		super.create(obj);
		try{ 
			DeliverCleanedLinenVO deliverCleanedLinenVO=((DeliverCleanedLinenVO)appVo);
			LcCleaningRequestHdr hdr=new LcCleaningRequestHdr();	
			LcCleaningRequestHdrId hdrId = new LcCleaningRequestHdrId(); 
			hdrId.setOperatingFacilityId(appVo.getAddedFacilityId());
			hdrId.setRequestNum(deliverCleanedLinenVO.getRequestNum().trim());
			hdr.setId(hdrId);
			hdr.setRequestDate(DateUtil.convertStringToDate("dd/MM/yyyy HH:mm",deliverCleanedLinenVO.getRequestDate()));
			hdr.setRequestStatus(deliverCleanedLinenVO.getRequestStatus().trim());
			hdr.setSourceCode(deliverCleanedLinenVO.getSourceCode().trim());
			hdr.setSourceType(deliverCleanedLinenVO.getSourceType().trim());
			hdr.setLinenCollectedBy(deliverCleanedLinenVO.getLinenCollectedBy().trim());
			hdr.setLinenHandedOverBy(deliverCleanedLinenVO.getLinenHandedOverBy().trim());
			 
			hdr.setAddedById(((DeliverCleanedLinenVO)appVo).getAddedById());
			hdr.setAddedDate(((DeliverCleanedLinenVO)appVo).getAddedDate());
			hdr.setAddedAtWsNo(((DeliverCleanedLinenVO)appVo).getAddedAtWsNo());
			hdr.setAddedFacilityId(((DeliverCleanedLinenVO)appVo).getAddedFacilityId());
			hdr.setModifiedAtWsNo(((DeliverCleanedLinenVO)appVo).getModifiedAtWsNo());
			hdr.setModifiedById(((DeliverCleanedLinenVO)appVo).getModifiedById());
			hdr.setModifiedDate(((DeliverCleanedLinenVO)appVo).getModifiedDate());
			hdr.setModifiedFacilityId(((DeliverCleanedLinenVO)appVo).getModifiedFacilityId());
			
			super.update(hdr);
		}catch(Exception e){e.printStackTrace();}
		List list = (List) ((DeliverCleanedLinenAssembler) getAppAssembler())
				.convertVO2DO(appVo);
		if (((List) list.get(0)).size() > 0)
			super.create(((List) list.get(0)).toArray());
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

	public DTO updateMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {
		DTO dto = new DTO();
		
		super.update(((DeliverCleanedLinenAssembler) getAppAssembler())
				.convertVO2DO1(appVo));
		List list = (List) ((DeliverCleanedLinenAssembler) getAppAssembler())
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
		if(resultVo.getFunctionId().equals("deliverCleaningLinen"))
		{
			dto = super.queryMasterType(resultVo);
		}
		else if(resultVo.getFunctionId().equals("deliverLinen"))
		{
		resultVo.setFunctionId("cleaningLinen");
		dto = super.queryMasterType(resultVo);
		}
		else 
			dto = super.queryMasterType(resultVo);
	
		return dto;
	}

}
