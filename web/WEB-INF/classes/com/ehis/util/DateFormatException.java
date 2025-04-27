/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Exception Class thrown while parsing invalid date Strings
 * <BR>
 * Created on 12/09/2006
 * 
 */

package com.ehis.util;

/**
 * Exception Class thrown while parsing invalid date Strings
 * 
 * @author ChandrasekharM
 * 
 */
public class DateFormatException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7853396383619864840L;

	/**
	 * Default Constructor
	 */
	public DateFormatException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * One argument constructor
	 * @param message Exception Message
	 */
	public DateFormatException(String message) {
		super(message);		
	}

	/**
	 * One argument constructor 
	 * @param cause Wrapped up throwable object
	 */
	public DateFormatException(Throwable cause) {
		super(cause);		
	}

	/**
	 * Multiple argument constructor
	 * @param message Exception message 
	 * @param cause Wrapped up Throwable Object
	 */
	public DateFormatException(String message, Throwable cause) {
		super(message, cause);		
	}

}
