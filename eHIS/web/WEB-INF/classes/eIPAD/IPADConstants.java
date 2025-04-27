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
package eIPAD;

/**
 * This is a constants file where all types of public constants
 * related to iPAD functionalities can be stored and utilized
 * across other classes
 * @author GRamamoorthy 
 *
 */
public class IPADConstants {

	/**
	 * Constant to denote the in patient keyword used in eHIS
	 */
	public static final String INPATIENT_KEYWORD = "IP";
	
	/**
	 * Constant to denote the out patient keyword used in eHIS
	 */
	public static final String OUTPATIENT_KEYWORD = "OP";
	
	/**
	 * Constant to denote the day care patient keyword used in eHIS
	 */
	public static final String DAYCAREPATIENT_KEYWORD = "DC";
	
	/**
	 * Constant to denote the emergency patient keyword used in eHIS
	 */
	public static final String EMERGENCYPATIENT_KEYWORD = "EM";
	
	/**
	 * Constant to denote the locale being using in version 1
	 * in this version, the locale is only "en"
	 */
	public static final String LOCALE = "en";
	
	/**
	 * Constant to denote the out patient episode key value
	 */
	public static final String OUTPATIENT_EPISODE_KEY = "O";
	
	/**
	 * Constant to denote the in patient episode key value
	 */
	public static final String INPATIENT_EPISODE_KEY = "I";
	
	/**
	 * Constant to denote the day care patient episode key value
	 */
	public static final String DAYCARE_EPISODE_KEY = "D";
	
	/**
	 * Constant to denote the emergency patient episode key value
	 */
	public static final String EMERGENCY_EPISODE_KEY = "E";
	
	/**
	 * Constant to denote the external episode key value
	 */
	public static final String EXTERNAL_EPISODE_KEY = "X";
	
	/**
	 * Constants to denote the different time periods utilized in iPAD application
	 */
	public static final String LAST_ONE_DAY = "LOD";
	
	public static final String LAST_THREE_DAYS = "LTD";
	
	public static final String LAST_ONE_WEEK = "LOW";
	
	public static final String LAST_ONE_MONTH = "LOM";
	
	public static final String LAST_ONE_YEAR = "LOY";
	
	/**
	 * Only for test purpose
	 */
	public static final String LAST_TWO_YEARS = "LTY";
	
	/**
	 * constant to denote "/"
	 */
	public static final String SLASH_IDENTIFIER = "/";
	
	/**
	 * Constant to denote the string "Y" which is used
	 * to identify years
	 */
	public static final String YEAR_IDENTIFIER = "Y";
	
	/**
	 * Constant to render the html when 'no records are found'. 
	 * 
	 */
	public static final String NORECORDS_HTML = "<table style = 'height:100px;width:100%'><tr style = 'height:100%;width:100%'><td style = 'height:100%;width:100%' align = 'center' valign = 'top'><span style = 'font-name:Arial;font-size:12pt'>No Records Found</span></td></tr> </table>";
	
	/**
	 * Constant to render the html when 'no records are found' for the widgets. 
	 * 
	 */
	public static final String NORECORDS_FOR_WIDGETS = "<tr class='trDummyRow'><td  style = 'width:7%' align='center' valign = 'center' colspan = '2'><span style = 'font-name:arial;font-size:12pt'>No Records Found</span></td></tr>"; 
}
