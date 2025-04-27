/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.receiveLinenAtLaundry.util;


import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.dobj.LcLaundryReceipts;
import com.iba.ehis.dobj.LcLaundryReceiptsId;
import com.iba.ehis.lc.receiveLinenAtLaundry.vo.ReceiveLinenAtLaundryVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DateUtil;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;

public class ReceiveLinenAtLaundryAssembler extends AppAssembler {

	public Object convertVO2DO(BaseVO vo) throws AssemblerException {

		
		ReceiveLinenAtLaundryVO receiveLinenAtLaundryVO = (ReceiveLinenAtLaundryVO) vo;
		LcLaundryReceipts lcLaundryReceipts = new LcLaundryReceipts();
		LcLaundryReceiptsId lcLaundryReceiptsId=new LcLaundryReceiptsId();
		
			try {
				
				lcLaundryReceiptsId.setOperatingFacilityId(((AppVO)receiveLinenAtLaundryVO).getAddedFacilityId());
				lcLaundryReceiptsId.setReceiptNum(receiveLinenAtLaundryVO.getReceiptNum());
				lcLaundryReceipts.setId(lcLaundryReceiptsId);
				lcLaundryReceipts.setLinenItem(receiveLinenAtLaundryVO.getLinenItem());
				lcLaundryReceipts.setReceivedDate(receiveLinenAtLaundryVO.getReceivedDate());
				lcLaundryReceipts.setReceivedQty(receiveLinenAtLaundryVO.getReceivedQty());
				lcLaundryReceipts.setReceivedBy(receiveLinenAtLaundryVO.getReceivedBy());
				lcLaundryReceipts.setRemarks(receiveLinenAtLaundryVO.getRemarks());

				lcLaundryReceipts.setAddedById(receiveLinenAtLaundryVO.getAddedById());
				lcLaundryReceipts.setAddedDate(receiveLinenAtLaundryVO.getAddedDate());
				lcLaundryReceipts
						.setAddedAtWsNo(receiveLinenAtLaundryVO.getAddedAtWsNo());
				lcLaundryReceipts.setAddedFacilityId(receiveLinenAtLaundryVO
						.getAddedFacilityId());
				lcLaundryReceipts.setModifiedAtWsNo(receiveLinenAtLaundryVO
						.getModifiedAtWsNo());
				lcLaundryReceipts.setModifiedById(receiveLinenAtLaundryVO
						.getModifiedById());
				lcLaundryReceipts.setModifiedDate(receiveLinenAtLaundryVO
						.getModifiedDate());
				lcLaundryReceipts.setModifiedFacilityId(receiveLinenAtLaundryVO
						.getModifiedFacilityId());
				} catch (Exception e) {
				IBALogger.getLogger().debug(this.getClass(),
						"RequestForLinenAssembler---------->convertVO2DO ",
						null);
				e.printStackTrace();
			}
			
		return lcLaundryReceipts;
	}

	

	public Object convertVO2DO(Object vo) throws AssemblerException {
		// TODO Auto-generated method stub
		return super.convertVO2DO(vo);
	}
}
