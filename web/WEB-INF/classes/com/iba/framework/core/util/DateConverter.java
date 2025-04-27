/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Created on Sep 15, 2006
 */
package com.iba.framework.core.util;

import org.apache.commons.beanutils.Converter;

/**
 * @author Sabarinathan S
 * @version
 */
public interface DateConverter extends Converter {
	public Object convert(Class type, Object value, String pattern);
}
