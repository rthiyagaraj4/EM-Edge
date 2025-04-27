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
package eIP.advbedmgmt.transaction.access;

/**
 * This is the constants file for the access module
 * 
 * @author gramamoorthy
 *
 */
public class AccessConstants {

	/**
	 * Constants denoting the keywords to be used in the SQL query
	 * for getting the access rights
	 */
	public static final String IP_BOOKING_KEYWORD = "IP_BOOKING";
	
	public static final String IP_BOOKING_FUNCTIONID_KEYWORD = "BOOKING";
	
	/**
	 * Constants denoting the request parameter to be used as input for
	 * getting the access rights
	 * menu id and function id needs to be passed to get access rights
	 * 
	 */
	public static final String MENUID_REQUEST_PARAMETER = "menuId";
	
	public static final String FUNCTIONID_REQUEST_PARAMETER = "functionId";
	
	/**
	 * Constant denoting the operation identifier to be used for getting
	 * access rights for create booking functionality
	 */
	public static final String CREATE_BOOKING_ACCESS_IDENTIFIER = "Create Booking";	
}
