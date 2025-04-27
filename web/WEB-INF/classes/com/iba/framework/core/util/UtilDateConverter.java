/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.framework.core.util;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This class is converts a java.util.Date to a String and a String to a
 * java.util.Date. It is used by BeanUtils when copying properties. Registered
 * for use in BaseManager.
 * 
 * <p>
 * <a href="DateConverter.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * @version $Revision: 1.1 $ $Date: 2004/03/31 13:04:17 $
 */
public class UtilDateConverter implements Converter {
	// ~ Instance fields
	// ========================================================

	private Log log = LogFactory.getLog(UtilDateConverter.class);

	// ~ Methods
	// ================================================================

	/**
	 * Convert a String to a Date and a Date to a String
	 * 
	 * @param type
	 *            the class type to output
	 * @param value
	 *            the object to convert
	 * @return object the converted object (Date or String)
	 */
	public Object convert(Class type, Object value) {

		System.out.println("entering convert method value is" + value
				+ "type is " + type);
		if (log.isDebugEnabled()) {
			// log.debug("entered 'convert' method...");
		}

		// for a null value, return null
		if (value == null) {
			return null;
		} else {
			if (value instanceof String) {
				log.debug("value (" + value + ") instance of String");

				try {
					if (StringUtils.isEmpty(value.toString())) {
						return null;
					}
					System.out.println("In String to Date");
					return DateUtil.convertStringToDate(value.toString());
				} catch (ParseException pe) {
					pe.printStackTrace();
				}
			} else if (value instanceof Date) {
				log.debug("value (" + value + ") instance of Date");
				System.out.println("I am waiting here");
				return DateUtil.convertDateToString((Date) value);
			}
		}

		throw new ConversionException("Could not convert "
				+ value.getClass().getName() + " to "

				+ type.getName() + "!");
	}
}
