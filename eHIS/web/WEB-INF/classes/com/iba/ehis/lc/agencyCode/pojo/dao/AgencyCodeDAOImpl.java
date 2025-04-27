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
package com.iba.ehis.lc.agencyCode.pojo.dao;

import com.iba.ehis.core.pojo.dao.AppDAOImpl;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.util.VODOMapReader;
import com.iba.ehis.dobj.LcAgency;
import com.iba.ehis.lc.agencyCode.vo.AgencyCodeVO;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.DAOCommand;
import com.iba.framework.core.util.DTO;

/*******************************************************************************
 * @author yadavk
 * 
 */
public class AgencyCodeDAOImpl extends AppDAOImpl {
	public AppAssembler appAssembler = new AppAssembler();

	public DTO getMasterType(AppVO appVo) {
		DAOCommand command = new DAOCommand();
		try {
			LcAgency agencyCode = new LcAgency();
			agencyCode.setAgencyCode(((AgencyCodeVO) appVo).getAgencyCode());

			command.setObject(agencyCode.getAgencyCode());
			command.setEntityClass(LcAgency.class);
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
