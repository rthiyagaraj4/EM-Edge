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
package com.iba.framework.lookup.pojo.business;

import org.springframework.beans.factory.ObjectFactory;

import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.pojo.business.BaseFacade;
import com.iba.framework.core.util.DTO;
import com.iba.framework.core.util.Page;
import com.iba.framework.lookup.pojo.dao.LookupDAO;
import com.iba.framework.lookup.vo.LookupVO;

/**
 * @author Sabarinathan S
 * @spring.bean id="lookupFacade"
 * @spring.property name="objectFactory" ref="lookupDAOFactory"
 */
public class LookupFacade extends BaseFacade implements Lookup {
	private LookupDAO dao;

	private ObjectFactory objectFactory;

	public LookupDAO getDao() {
		return (LookupDAO) objectFactory.getObject();
	}

	public void setDao(LookupDAO dao) {
		this.dao = dao;
	}

	public DTO lookupByQuery(LookupVO lookupValue, Page page, String sessionId)
			throws ApplicationException {
		return getDao().lookupByQuery(lookupValue, page, sessionId);
	}

	public ObjectFactory getObjectFactory() {
		return objectFactory;
	}

	public void setObjectFactory(ObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}
}
