/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Oct 17, 2006
 */
package com.iba.framework.core.pojo.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.iba.framework.core.util.ServiceLocator;

/**
 * @author Sabarinathan S
 * @version
 */
public class MessageReader {
	public String getMessage(HttpServletRequest request, String messageKey) {
		return ServiceLocator.getInstance().getMessage(messageKey, null,
				(Locale)request.getSession().getAttribute(org.apache.struts.Globals.LOCALE_KEY));
	}
}
