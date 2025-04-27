/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.issueOfLinen.pojo.dao;

import java.util.List;

import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.pojo.dao.AppDAOImpl;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.ehis.dobj.LcRequestHdr;
import com.iba.ehis.dobj.LcRequestHdrId;
import com.iba.ehis.lc.issueOfLinen.util.IssueOfLinenAssembler;
import com.iba.ehis.lc.issueOfLinen.vo.IssueOfLinenVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.framework.logging.pojo.business.IBALogger;

/**
 * @author yadavk
 * 
 */
public class IssueOfLinenDAOImpl extends AppDAOImpl {
	public AppAssembler appAssembler = new AppAssembler();


	public DTO insertMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {

		DTO dto = new DTO();
		Object obj=((IssueOfLinenAssembler) getAppAssembler()).convertVO2DO1(appVo);
		super.CreateOrUpdate(obj);
	
		
		try{ 

			LcRequestHdr hdr=new LcRequestHdr();
			LcRequestHdrId hdrId=new LcRequestHdrId();
			hdrId.setOperatingFacilityId(((IssueOfLinenVO)appVo).getAddedFacilityId().trim());
			hdrId.setRequestNum(((IssueOfLinenVO)appVo).getRequestNum().trim());
			hdr.setSourceType(((IssueOfLinenVO)appVo).getSourceType().trim());
			hdr.setSourceCode(((IssueOfLinenVO)appVo).getSourceCode().trim());
			hdr.setRaisedBy(((IssueOfLinenVO)appVo).getRaisedBy().trim());
			hdr.setRequestStatus(((IssueOfLinenVO)appVo).getRequestStatus().trim());
			
			hdr.setRequestDate(((IssueOfLinenVO)appVo).getRequestDate());
		
			hdr.setAddedById(((IssueOfLinenVO)appVo).getAddedById());
			hdr.setAddedDate(((IssueOfLinenVO)appVo).getAddedDate());
			hdr.setAddedAtWsNo(((IssueOfLinenVO)appVo).getAddedAtWsNo());
			hdr.setAddedFacilityId(((IssueOfLinenVO)appVo).getAddedFacilityId());
			hdr.setModifiedAtWsNo(((IssueOfLinenVO)appVo).getModifiedAtWsNo());
			hdr.setModifiedById(((IssueOfLinenVO)appVo).getModifiedById());
			hdr.setModifiedDate(((IssueOfLinenVO)appVo).getModifiedDate());
			hdr.setModifiedFacilityId(((IssueOfLinenVO)appVo).getModifiedFacilityId());
			hdr.setId(hdrId);
			super.update(hdr);
		}catch(Exception e){e.printStackTrace();}
		List list = (List) ((IssueOfLinenAssembler) getAppAssembler()).convertVO2DO(appVo);
		IBALogger.getLogger().debug(this.getClass(),"Status==============>"+((IssueOfLinenVO)appVo).getRequestStatus().trim(), null);
		try {
		if (((List) list.get(0)).size() > 0){
			
			super.CreateOrUpdate(((List) list.get(0)).toArray());
			dto.setStatus(Constants.SUCCESS);
			
			}
			} catch (Exception e) {
				dto.setStatus(Constants.FAILED);
			}
		return dto;
	}

	public DTO updateMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {
		DTO dto = new DTO();
		Object obj=((IssueOfLinenAssembler) getAppAssembler()).convertVO2DO1(appVo);
		super.update(obj);
		List list = (List) ((IssueOfLinenAssembler) getAppAssembler()).convertVO2DO(appVo);
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
		
		if(resultVo.getFunctionId().equals("requestForLinen"))
		{
			dto = super.queryMasterType(resultVo);
		}
		else if(resultVo.getFunctionId().equals("request"))
		{
		resultVo.setFunctionId("request");
		dto = super.queryMasterType(resultVo);
		}
		else
		{
		 IBALogger.getLogger().debug(this.getClass(),"FunctionId:----"+resultVo.getFunctionId(),null);
		 dto = super.queryMasterType(resultVo);
		}

		return dto;
	}

}
