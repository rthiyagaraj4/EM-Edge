/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.writeOffLinen.pojo.dao;

import com.iba.ehis.core.pojo.dao.AppDAOImpl;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.core.vo.AppVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DTO;
import com.iba.ehis.lc.writeOffLinen.util.WriteOffLinenAssembler;

public class WriteOffLinenDAOImpl extends AppDAOImpl {

	public DTO insertMasterType(AppVO appVo) throws AssemblerException,
			ApplicationException {
		DTO dto = new DTO();
		try {
			Object obj = ((WriteOffLinenAssembler) getAppAssembler())
					.convertVO2DO(appVo);
			super.create(obj);
			dto.setStatus(Constants.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			dto.setStatus(Constants.FAILED);
		}

		return dto;
	}
}
