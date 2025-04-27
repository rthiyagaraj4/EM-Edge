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
package com.iba.ehis.lc.reason.pojo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.pojo.dao.AppDAOImpl;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.ehis.dobj.LcReason;
import com.iba.ehis.lc.reason.util.ReasonAssembler;
import com.iba.ehis.lc.reason.vo.ReasonVO;
import com.iba.ehis.lc.standardStock.util.StandardStockAssembler;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DAOCommand;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.NamedQuery;
import com.iba.framework.core.util.Page;
import com.iba.framework.logging.pojo.business.IBALogger;

/**
 * @author yadavk
 * 
 */
public class ReasonDAOImpl extends AppDAOImpl {

	public DTO getMasterType(AppVO appVo) {
		(IBALogger.getLogger()).debug(this.getClass(),
				"ReasonDAOImpl-------->", null);
		DAOCommand command = new DAOCommand();
		try {
			LcReason lcReason = new LcReason();
			lcReason.setReasonCode(((ReasonVO) appVo).getReasonCode());
			command.setObject(lcReason.getReasonCode());
			(IBALogger.getLogger()).debug(this.getClass(),
					"ReasonDAOImpl-------->" + command.getObject(), null);

			command.setEntityClass(LcReason.class);
			(IBALogger.getLogger()).debug(this.getClass(),
					"ReasonDAOImpl--------->" + command.getEntityClass(), null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DTO dto = (DTO) super.findById(command);
		try {
			dto.setObject(((ReasonAssembler) getAppAssembler())
					.convertDO2VO(dto.getObject()));
		} catch (AssemblerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}

	public DTO insertMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {

		DTO dto = new DTO();
		super
				.create(((ReasonAssembler) getAppAssembler())
						.convertVO2DO1(appVo));
		List list = (List) ((ReasonAssembler) getAppAssembler())
				.convertVO2DO(appVo);
		if (((List) list.get(0)).size() > 0)
			super.create(((List) list.get(0)).toArray());

		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

	public DTO updateMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {

		DTO dto = new DTO();
		NamedQuery namedQuery = new NamedQuery();
		HashMap dataMap = new HashMap();
		dataMap.put("reasonCode", ((ReasonVO) appVo).getReasonCode());
		dataMap.put("reasonDesc", ((ReasonVO) appVo).getReasonDesc());
		dataMap.put("effStatus", ((ReasonVO) appVo).getEffStatus());

		namedQuery.setDataMap(dataMap);
		namedQuery.setQueryID("ehis.lc.reason.getData");
		Page page = new Page();
		page.setPagingEnabled(false);
		namedQuery.setPage(page);
		try {
			super.update(((ReasonAssembler) getAppAssembler())
					.convertVO2DO1(appVo));
			dto = (DTO) findByQuery(new DAOCommand(namedQuery, null));
			super.delete(((List) dto.getObject()).toArray());
			List list = (List) ((ReasonAssembler) getAppAssembler())
					.convertVO2DO(appVo);
			if (((List) list.get(0)).size() > 0)
				super.create(((List) list.get(0)).toArray());
		} catch (Exception e) {
			dto.setStatus(Constants.FAILED);
		}
		dto.setStatus(Constants.SUCCESS);
		dto.setObject(appVo);
		return dto;
	}

}
