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
package com.iba.ehis.lc.linenType.pojo.dao;

import com.iba.ehis.core.pojo.dao.AppDAOImpl;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.util.VODOMapReader;
import com.iba.ehis.dobj.LcLinenType;
import com.iba.ehis.lc.linenType.vo.LinentypeVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DAOCommand;
import com.iba.framework.core.util.DTO;

/**
 * @author yadavk
 * 
 */
public class LinenTypeDAOImpl extends AppDAOImpl {
	public AppAssembler appAssembler = new AppAssembler();

	public DTO getMasterType(AppVO appVo) {
		DAOCommand command = new DAOCommand();
		try {
			LcLinenType linenType = new LcLinenType();
			linenType
					.setLinenTypeCode(((LinentypeVO) appVo).getLinenTypeCode());

			command.setObject(linenType.getLinenTypeCode());
			command.setEntityClass(LcLinenType.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		DTO dto = (DTO) super.findById(command);
		try {
			dto
					.setObject(appAssembler.getVO(dto.getObject(),
							VODOMapReader.getFqnVOClass(appVo.getModuleId(),
									appVo.getFunctionId())));
		} catch (AssemblerException e) {
			e.printStackTrace();
		}
		return dto;
	}

}
