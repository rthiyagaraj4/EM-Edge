/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.core.pojo.dao;

import java.io.Serializable;

import com.iba.ehis.core.exception.DuplicateRecordException;
import com.iba.framework.core.exception.ApplicationException;
import com.iba.framework.core.util.DAOCommand;

public interface CRUDDAO extends DAO {
	public Object findByQuery(DAOCommand daoCommand)
			throws ApplicationException;

	public Object findById(DAOCommand daoCommand) throws ApplicationException;

	public Serializable create(Object transientInstance)
			throws DuplicateRecordException, ApplicationException;

	public void update(Object transientInstance) throws ApplicationException;

	public void delete(Object transientInstance) throws ApplicationException;
}
