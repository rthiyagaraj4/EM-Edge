/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.standardStock.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.dobj.LcLinenItem;
import com.iba.ehis.dobj.LcStdLinenStkDtl;
import com.iba.ehis.dobj.LcStdLinenStkDtlId;
import com.iba.ehis.dobj.LcStdLinenStkHdr;
import com.iba.ehis.dobj.LcStdLinenStkHdrId;
import com.iba.ehis.lc.standardStock.vo.StandardStockListVO;
import com.iba.ehis.lc.standardStock.vo.StandardStockVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DTO;
import com.iba.framework.logging.pojo.business.IBALogger;

public class StandardStockAssembler extends AppAssembler {
	// public Object convertDO2VO(Object dObj, Class classVO) throws
	// AssemblerException{
	// return convertDO2VO(dObj);
	// }
	public Object convertVO2DO1(Object vo) throws AssemblerException {

		StandardStockVO standardStockVO = (StandardStockVO) vo;
		LcStdLinenStkHdr lcStdLinenStkHdr = new LcStdLinenStkHdr();
		LcStdLinenStkHdrId lcStdLinenStkHdrId = new LcStdLinenStkHdrId();
		lcStdLinenStkHdrId.setOperatingFacilityId(standardStockVO
				.getAddedFacilityId());
		lcStdLinenStkHdrId.setSourceCode(standardStockVO.getSourceCode());
		lcStdLinenStkHdrId.setSourceType(standardStockVO.getSourceType());
		lcStdLinenStkHdr.setId(lcStdLinenStkHdrId);

		lcStdLinenStkHdr.setAddedById(standardStockVO.getAddedById());
		lcStdLinenStkHdr.setAddedDate(standardStockVO.getAddedDate());
		lcStdLinenStkHdr.setAddedAtWsNo(standardStockVO.getAddedAtWsNo());
		lcStdLinenStkHdr.setAddedFacilityId(standardStockVO
				.getAddedFacilityId());
		lcStdLinenStkHdr.setModifiedAtWsNo(standardStockVO.getModifiedAtWsNo());
		lcStdLinenStkHdr.setModifiedById(standardStockVO.getModifiedById());
		lcStdLinenStkHdr.setModifiedDate(standardStockVO.getModifiedDate());
		lcStdLinenStkHdr.setModifiedFacilityId(standardStockVO
				.getModifiedFacilityId());
		return lcStdLinenStkHdr;
	}

	public Object convertVO2DO(Object vo) throws AssemblerException {
		int index = 0;
		DTO dto = new DTO();
		List standardStockList = new ArrayList();
		List createList = new ArrayList();
		List updateList = new ArrayList();

		StandardStockVO standardStockVO = (StandardStockVO) vo;
		for (Iterator iter = standardStockVO.getStockList().iterator(); iter
				.hasNext();) {
			LcLinenItem lcLinenItem = new LcLinenItem();
			LcStdLinenStkDtl lcStdLinenStkDtl = new LcStdLinenStkDtl();
			LcStdLinenStkDtlId lcStdLinenStkDtlId = new LcStdLinenStkDtlId();
			LcStdLinenStkHdr lcStdLinenStkHdr = new LcStdLinenStkHdr();
			LcStdLinenStkHdrId lcStdLinenStkHdrId = new LcStdLinenStkHdrId();
			StandardStockListVO element = (StandardStockListVO) iter.next();
			lcStdLinenStkHdrId.setOperatingFacilityId(standardStockVO
					.getAddedFacilityId());
			lcStdLinenStkHdrId.setSourceCode(standardStockVO.getSourceCode());
			lcStdLinenStkHdrId.setSourceType(standardStockVO.getSourceType());
			lcStdLinenStkHdr.setId(lcStdLinenStkHdrId);
			lcStdLinenStkDtlId.setLcStdLinenStkHdr(lcStdLinenStkHdr);
			lcLinenItem.setLinenItem(element.getLinenItem());
			lcStdLinenStkDtlId.setLcLinenItem(lcLinenItem);

			lcStdLinenStkDtl.setId(lcStdLinenStkDtlId);
			lcStdLinenStkDtl.setStdQty(element.getStdQty());

			lcStdLinenStkDtl.setAddedById(standardStockVO.getAddedById());
			lcStdLinenStkDtl.setAddedDate(standardStockVO.getAddedDate());
			lcStdLinenStkDtl.setAddedAtWsNo(standardStockVO.getAddedAtWsNo());
			lcStdLinenStkDtl.setAddedFacilityId(standardStockVO
					.getAddedFacilityId());
			lcStdLinenStkDtl.setModifiedAtWsNo(standardStockVO
					.getModifiedAtWsNo());
			lcStdLinenStkDtl.setModifiedById(standardStockVO.getModifiedById());
			lcStdLinenStkDtl.setModifiedDate(standardStockVO.getModifiedDate());
			lcStdLinenStkDtl.setModifiedFacilityId(standardStockVO
					.getModifiedFacilityId());

			createList.add(lcStdLinenStkDtl);
			// updateList.add(lcStdLinenStkDtl) ;
		}
		standardStockList.add(createList);
		// standardStockList.add(updateList);
		return standardStockList;
	}

	public Object convertDO2VO(Object oDO) throws AssemblerException {
		if (!(oDO instanceof List)) {
			LcStdLinenStkDtl lcStdLinenStkDtlDO = (LcStdLinenStkDtl) oDO;
			StandardStockVO standardStockVO = new StandardStockVO();

			try {

				standardStockVO.setLinenItem(lcStdLinenStkDtlDO.getId()
						.getLcLinenItem().getLinenItem());
				standardStockVO.setSourceCode(lcStdLinenStkDtlDO.getId()
						.getLcStdLinenStkHdr().getId().getSourceCode());
				standardStockVO.setSourceType(lcStdLinenStkDtlDO.getId()
						.getLcStdLinenStkHdr().getId().getSourceType());
				standardStockVO.setStdQty(lcStdLinenStkDtlDO.getStdQty());
				standardStockVO.setAddedById(lcStdLinenStkDtlDO.getAddedById());
				standardStockVO.setAddedDate(lcStdLinenStkDtlDO.getAddedDate());
				standardStockVO.setAddedAtWsNo(lcStdLinenStkDtlDO
						.getAddedAtWsNo());
				standardStockVO.setAddedFacilityId(lcStdLinenStkDtlDO
						.getAddedFacilityId());
				standardStockVO.setModifiedAtWsNo(lcStdLinenStkDtlDO
						.getModifiedAtWsNo());
				standardStockVO.setModifiedById(lcStdLinenStkDtlDO
						.getModifiedById());
				standardStockVO.setModifiedDate(lcStdLinenStkDtlDO
						.getModifiedDate());
				standardStockVO.setModifiedFacilityId(lcStdLinenStkDtlDO
						.getModifiedFacilityId());

			} catch (Exception e) {
				// TODO: handle exception
				IBALogger.getLogger().debug(this.getClass(),
						"StandardStockAssembler---------->convertDO2VO ", null);
				e.printStackTrace();
			}
			return standardStockVO;
		} else
			return oDO;
	}

	public StandardStockVO ConvertDataToVo(Object record[])
			throws AssemblerException {
		IBALogger.getLogger().debug(this.getClass(),
				"StandardStockAssembler---------->ConvertDataToVo ", null);
		StandardStockVO standardStockVO = new StandardStockVO();
		standardStockVO.setLinenItem((String) record[0]);
		standardStockVO.setSourceCode((String) record[1]);
		standardStockVO.setSourceType((String) record[2]);
		standardStockVO.setStdQty((Long) record[3]);

		return standardStockVO;
	}

}
