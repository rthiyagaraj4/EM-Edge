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
package eIP.advbedmgmt.common.bedlegend;

/**
 * This is a constants file for bed legend sub module
 * @author GRamamoorthy
 *
 */
public class BedLegendConstants {

	/**
	 * Constants denoting the column names in the database table 
	 * to be used to retrieve bed legend information
	 */
	public static final String LEGEND_IDENTIFIER_COL_NAME = "STAT";
	
	public static final String LEGEND_COLOR_COL_NAME = "BACKGNDCOLOR";
	
	public static final String LEGEND_TEXT_COLOR_COL_NAME = "TEXTCOLOR";
	
	/**
	 * Constant denoting the bc layer class for legend
	 */
	public static final String LEGEND_BC_NAME = "bedLegend";
	
	/**
	 * Constant denoting the default room back ground color
	 */
	public static final String DEFAULT_ROOM_BACKGROUND_COLOR = "E7F3F2";
	
	/**
	 * Constant denoting the resource bundle key 
	 * for showing "discharge bill prepared" message on screen
	 */
	public static final String DISCHARGE_BILL_PREPARED_MESG_KEY = "DischargeBillPrepared";
	
	public static final String BEDLEGEND_LABELS_RESOURCE_CLASSNAME = "eIP.advbedmgmt.common.bedlegend.resourcebundle.Labels";
}
