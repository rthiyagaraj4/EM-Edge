/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.core.pojo.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;

import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.ehis.core.util.AppAssembler;
import com.iba.ehis.core.util.VODOMapReader;
import com.iba.ehis.core.vo.AppVO;
import com.iba.ehis.core.vo.QueryCriteriaItem;
import com.iba.ehis.core.vo.QueryResultVO;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.exception.AssemblerException;
import com.iba.framework.core.pojo.dao.DAOImpl;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.DAOCommand;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.NamedQuery;
import com.iba.framework.core.vo.BaseVO;
import com.iba.framework.logging.pojo.business.IBALogger;

public class AppDAOImpl extends DAOImpl implements AppDAO {

	private AppAssembler appAssembler = null;

	public AppAssembler getAppAssembler() {
		if (appAssembler == null) {
			setAppAssembler(new AppAssembler());
		}
		return appAssembler;
	}

	public void setAppAssembler(AppAssembler appAssembler) {
		IBALogger.getLogger().debug(
				this.getClass(),
				"Wiring Assembler to " + this.getClass() + ", Assembler  is :"
						+ appAssembler.getClass(), null);
		this.appAssembler = appAssembler;
	}

	public DTO getMasterType(AppVO appVo) throws ApplicationException,
			AssemblerException {
		// TODO Auto-generated method stub
		return null;
	}

	public DTO insertMasterType(AppVO appVo) throws DuplicateRecordException,
			AssemblerException, ApplicationException {

		Object doObject = getAppAssembler().convertVO2DO(
				(BaseVO) appVo,
				VODOMapReader.getFqnDOClass(appVo.getModuleId(), appVo
						.getFunctionId()));
		if (doObject instanceof List) {
			super.create(((List) doObject).toArray());
		} else
			super.create(doObject);
		DTO dto = new DTO();
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

	public DTO updateMasterType(AppVO appVo) throws AssemblerException,
			ApplicationException {
		Object doObject = getAppAssembler().convertVO2DO(
				appVo,
				VODOMapReader.getFqnDOClass(appVo.getModuleId(), appVo
						.getFunctionId()));
		if (doObject instanceof List) {
			super.update(((List) doObject).toArray());
		} else
			super.update(doObject);

		DTO dto = new DTO();
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

	public DTO deleteMasterType(AppVO appVo) throws ApplicationException,
			AssemblerException {

		// super.delete(getAppAssembler().convertVO2DO(appVo,
		// VODOMapReader.getFqnDOClass(appVo.getModuleId(),
		// appVo.getFunctionId())));
		Object doObject = getAppAssembler().convertVO2DO(
				appVo,
				VODOMapReader.getFqnDOClass(appVo.getModuleId(), appVo
						.getFunctionId()));
		if (doObject instanceof List) {
			super.delete(((List) doObject).toArray());
		} else
			super.delete(doObject);

		DTO dto = new DTO();
		dto.setStatus(Constants.SUCCESS);
		return dto;
	}

	public DTO queryMasterType(QueryResultVO resultVo)
			throws ApplicationException {
		NamedQuery namedQuery = new NamedQuery();
		namedQuery.setQueryID(VODOMapReader.getQueryId(resultVo.getModuleId(),
				resultVo.getFunctionId()));
		HashMap dataMap = new HashMap();

		if (resultVo.getCriteriaVo() != null) {
			for (int i = 0; i < ((resultVo.getCriteriaVo()).getCriteriaItems())
					.size(); i++) {
				(IBALogger.getLogger()).debug(this.getClass(),
						"Entered Where Clause", "");
				QueryCriteriaItem criteriaIterm = (QueryCriteriaItem) ((resultVo
						.getCriteriaVo()).getCriteriaItems()).get(i);
				(IBALogger.getLogger()).debug(this.getClass(), criteriaIterm
						.toString(), "");

				(IBALogger.getLogger()).debug(this.getClass(), (criteriaIterm
						.getProperty()
						+ "::" + criteriaIterm.getItemValue()), "");
				dataMap.put(criteriaIterm.getProperty(), ((criteriaIterm
						.getItemValue() == null ? "%" : criteriaIterm
						.getItemValue()) + "%"));
				dataMap.put("operatingFacilityId", resultVo.getAddedFacilityId());			// Added by Subhani 8/27/2012 for the issue 33532
			}
		}

		if (resultVo.getCriteriaVo() != null) {
			namedQuery.setOrderByClause((String) ((resultVo.getCriteriaVo())
					.getOrderBySelected().getItemValue()));
		}

		namedQuery.setPage(resultVo.getPage());
		namedQuery.setDataMap(dataMap);

		DTO dto = (DTO) super.findByQuery(new DAOCommand(namedQuery, null));

		Object voObject = getAppAssembler().convertDO2VO(dto.getObject());
		if (voObject != null)
			dto.setObject(voObject);
		return dto;
	}

	public long getIncrementID(String property, String tableName)
			throws ApplicationException, AssemblerException {
		Long id = new Long(0);
		try {
			Session session = (getOrmTemplate().getSessionFactory())
					.getCurrentSession();
			Query query = null;
			query = session.createQuery("select Max(tableName." + property
					+ ") from " + tableName + " tableName");
			query.setCacheable(true);
			query.setCacheMode(CacheMode.NORMAL);
			List list = query.list();
			if (list.get(0) == null) {
				return 0;
			} else {
				id = (Long) list.get(0);
			}
		} catch (Exception re) {
			throw new ApplicationException("No Data", re);
		}
		return id.longValue();
	}

}
