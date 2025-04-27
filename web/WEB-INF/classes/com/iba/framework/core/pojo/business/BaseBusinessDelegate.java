/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on May 19, 2006
 */
package com.iba.framework.core.pojo.business;

import com.iba.framework.core.exception.ServiceLocatorException;
import com.iba.framework.core.util.ServiceLocator;

/**
 * @author S Sabarinathan
 * 
 */
public class BaseBusinessDelegate {
	private String beanId;

	private IFacade facade;

	public BaseBusinessDelegate() {

	}

	/**
	 * 
	 * @param beanId
	 * @throws ServiceLocatorException
	 */
	public BaseBusinessDelegate(String beanId) throws ServiceLocatorException {
		this.beanId = beanId;
		facade = (IFacade) getServiceLocator().getBean(beanId);
	}

	public ServiceLocator getServiceLocator() throws ServiceLocatorException {
		return ServiceLocator.getInstance();
	}

	/**
	 * @return Returns the beanId.
	 */
	public String getBeanId() {
		return beanId;
	}

	/**
	 * @param beanId
	 *            The beanId to set.
	 */
	public void setBeanId(String serviceId) {
		this.beanId = serviceId;
	}

	/**
	 * @return Returns the facade.
	 */
	public IFacade getFacade() {
		return facade;
	}

	/**
	 * @param facade
	 *            The facade to set.
	 */
	public void setFacade(IFacade facade) {
		this.facade = facade;
	}
}
