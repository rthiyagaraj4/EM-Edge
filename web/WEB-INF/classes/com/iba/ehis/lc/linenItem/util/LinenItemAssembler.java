/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.linenItem.util;

import java.util.List;
import com.iba.ehis.dobj.LcLinenItem;
import com.iba.ehis.dobj.LcLinenType;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.lc.linenItem.vo.LinenItemVO;
import com.iba.ehis.lc.linenType.vo.LinentypeVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.logging.pojo.business.IBALogger;
import com.iba.framework.logging.pojo.business.LogFactory;
import com.iba.framework.logging.pojo.business.Logger;

public class LinenItemAssembler extends AppAssembler {
	public static final Logger logger = LogFactory.getApplicationLogger();

	public Object convertDO2VO(Object dObj, Class classVO)
			throws AssemblerException {
		return convertDO2VO(dObj);
	}

	public Object convertVO2DO(Object vo) throws AssemblerException {
		// TODO Auto-generated method stub
		LcLinenItem lcLinenItem = new LcLinenItem();
		LcLinenType linenType = new LcLinenType();
		LinenItemVO linenItemVO = (LinenItemVO) vo;

		try {
			IBALogger
					.getLogger()
					.debug(
							this.getClass(),
							"LinenItemAssembler ------------------>convertVO2DO ",
							null);

			lcLinenItem.setLinenItem(linenItemVO.getLinenItem());

			linenType.setLinenTypeCode(linenItemVO.getLinenType()
					.getLinenTypeCode());
			lcLinenItem.setLcLinenType(linenType);
			lcLinenItem.setLongDesc(linenItemVO.getLongDesc());
			lcLinenItem.setShortDesc(linenItemVO.getShortDesc());
			lcLinenItem.setDisposableItem(linenItemVO.getDisposable());
			lcLinenItem.setWashingInstructions(linenItemVO
					.getWashingInstructions());
			lcLinenItem.setEffStatus(linenItemVO.getEffStatus());
			lcLinenItem.setAddedById(linenItemVO.getAddedById());
			lcLinenItem.setAddedDate(linenItemVO.getAddedDate());
			lcLinenItem.setAddedAtWsNo(linenItemVO.getAddedAtWsNo());
			lcLinenItem.setAddedFacilityId(linenItemVO.getAddedFacilityId());
			lcLinenItem.setModifiedAtWsNo(linenItemVO.getModifiedAtWsNo());
			lcLinenItem.setModifiedById(linenItemVO.getModifiedById());
			lcLinenItem.setModifiedDate(linenItemVO.getModifiedDate());
			lcLinenItem.setModifiedFacilityId(linenItemVO
					.getModifiedFacilityId());

		} catch (Exception e) {
			// TODO: handle exception
			IBALogger.getLogger().debug(this.getClass(),
					"LinenItemAssembler ----EXCEPTION---------->convertVO2DO ",
					null);
			e.printStackTrace();
		}
		return lcLinenItem;
	}

	public Object convertDO2VO(Object oDO) throws AssemblerException {
		if (!(oDO instanceof List)) {
			LcLinenItem lcLinenItem = (LcLinenItem) oDO;
			LinenItemVO linenItemVO = new LinenItemVO();
			try {
				IBALogger.getLogger().debug(this.getClass(),
						"LinenItemAssembler ------------------>convertDO2VO",
						null);

				LinentypeVO linentypeVO = new LinentypeVO();

				linentypeVO.setLinenTypeCode(lcLinenItem.getLcLinenType()
						.getLinenTypeCode());
				linenItemVO.setLinenType(linentypeVO);
				linenItemVO.setLinenItem(lcLinenItem.getLinenItem());
				linenItemVO.setLongDesc(lcLinenItem.getLongDesc());
				linenItemVO.setShortDesc(lcLinenItem.getShortDesc());
				linenItemVO.setDisposable(lcLinenItem.getDisposableItem());
				linenItemVO.setWashingInstructions(lcLinenItem
						.getWashingInstructions());
				linenItemVO.setEffStatus(lcLinenItem.getEffStatus());
				linenItemVO.setAddedById(lcLinenItem.getAddedById());
				linenItemVO.setAddedDate(lcLinenItem.getAddedDate());
				linenItemVO.setAddedAtWsNo(lcLinenItem.getAddedAtWsNo());
				linenItemVO
						.setAddedFacilityId(lcLinenItem.getAddedFacilityId());
				linenItemVO.setModifiedAtWsNo(lcLinenItem.getModifiedAtWsNo());
				linenItemVO.setModifiedById(lcLinenItem.getModifiedById());
				linenItemVO.setModifiedDate(lcLinenItem.getModifiedDate());
				linenItemVO.setModifiedFacilityId(lcLinenItem
						.getModifiedFacilityId());

				IBALogger.getLogger().debug(
						this.getClass(),
						"LinenItemAssembler --------->"
								+ linenItemVO.getLinenItem(), null);
			} catch (Exception e) {
				// TODO: handle exception
				IBALogger
						.getLogger()
						.debug(
								this.getClass(),
								"LinenItemAssembler ---------EXCEPTION---------->convertDO2VO ",
								null);
				e.printStackTrace();
			}
			return linenItemVO;
		} else
			return oDO;

	}

	public LinenItemVO ConvertDataToVo(Object record[])
			throws AssemblerException {
		IBALogger.getLogger().debug(this.getClass(),
				"LinenItemAssembler ------------------>convertDATA2VO ", null);
		LinenItemVO linenItemVO = new LinenItemVO();
		linenItemVO.setLinenItem((String) record[0]);
		LinentypeVO linentypeVO = new LinentypeVO();
		linentypeVO.setLinenTypeCode((String) record[1]);
		linenItemVO.setLinenType(linentypeVO);

		linenItemVO.setLongDesc((String) record[2]);
		linenItemVO.setShortDesc((String) record[3]);
		linenItemVO.setDisposable((String) record[4]);
		linenItemVO.setEffStatus((String) record[5]);
		return linenItemVO;
	}

}
