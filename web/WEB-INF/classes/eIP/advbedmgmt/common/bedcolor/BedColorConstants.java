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
package eIP.advbedmgmt.common.bedcolor;

/**
 * This is the constants file for bed color sub module
 * @author GRamamoorthy
 *
 */
public class BedColorConstants {

	/**
	 * Constant denoting the column name to be used to get bed color data
	 * from result set
	 */
	public static final String BED_COLOR_COLUMN_IDENTIFIER = "BACKGNDCOLOR";
	
	public static final String BED_STATUS_COLUMN_IDENTIFIER = "STAT";

	public static final String BED_STATUS_TXT_COLOR_IDENTIFIER = "TEXTCOLOR"; //Added By Dharma on 16th Mar 2016
	
	/**
	 * Constant denoting the bc name used in the spring configuration file
	 */
	public static final String BED_COLOR_BC_NAME = "bedColor";
	
	
	/**
	 * Constants denoting the error codes while getting bed color
	 */
	/*public static final int BED_COLOR_SQLEXCEPTION_ERRORCODE = 501;
	
	public static final int BED_COLOR_NULLRESULTSET_ERRORCODE = 502;
	
	public static final int BED_COLOR_NODATA_ERRORCODE = 503;*/
	
}
