/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Factory Class to retrieve Formatter based on a pattern string
 * <BR>
 * Created on 12/09/2006 
 * 
 * <BR>
 * Modified on 08/12/2006 to handle null and empty strings
 * <UL> 
 * <LI>Modified method getDateTimeFormatter use DMY if the input format string is null or empty 
 * </UL>
 * 
 */
package com.ehis.util;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormat;

/**
 * Factory Class to retrieve Formatter based on a pattern string
 * 
 * @author ChandrasekharM
 * 
 */

public class FormatterFactory {
	public static final String DMY = "dd/MM/yyyy";	
	public static final String MY = "MM/yyyy";
	public static final String MM = "MM";
	public static final String YY = "yyyy";
	public static final String DMYHM = "dd/MM/yyyy HH:mm";
	public static final String DMONYY = "dd-MMM-yy";
//	public static final String DMYHMA = "dd/MM/yyyy KK:mm aa";    Hour Range is 0 to 11
	public static final String DMYHMA = "dd/MM/yyyy hh:mm aa"; //Hour Range is 1 to 12
	public static final String DMYHMS = "dd/MM/yyyy HH:mm:ss";
	public static final String DMYHMSF = "dd/MM/yyyy HH:mm:ss.S";
	public static final String HM = "HH:mm";
	public static final String DEFAULT_FORMAT= "dd/MM/yyyy";
	
	public static final String DEFAULT_LOCALE = "en";
	
	
	/** 
	 * Method returns a DateFormatter to suit the input pattern
	 * @param format Date format pattern 
	 * @return A DateTimeFormatter object that understands the input pattern <br>
	 * 
	 * Currently the following formats are supported
	 * <UL>
	 * <LI>DMY - dd/MM/yyyy	
	 * <LI>MY - MM/yyyy
	 * <LI>MM - MM
	 * <LI>YY - yyyy
	 * <LI>DMYHM - dd/MM/yyyy HH:mm
	 * <LI>DMYHMS = dd/MM/yyyy HH:mm:SS
	 * <LI>DMYHMSF = dd/MM/yyyy HH:mm:SS.s
	 * <LI>HM - HH:mm
	 * <LI>DEFAULT_FORMAT - dd/MM/yyyy
	 * </UL>
	 * 
	 */
	public static DateTimeFormatter getDateTimeFormatter(String format){
		DateTimeFormatter fmt = null;
		
		/*
		 * If the input format string is null or empty 
		 * set it to DMY (the default format)
		 * 
		 */
		if (format == null || format.equals(""))
			format = "DMY";
		
		if (format.equalsIgnoreCase("DMY")){
			fmt = DateTimeFormat.forPattern(DMY);
		}else if (format.equalsIgnoreCase("MY")){
			fmt = DateTimeFormat.forPattern(MY);
		}else if (format.equalsIgnoreCase("MM")){
			fmt = DateTimeFormat.forPattern(MM);
		}else if (format.equalsIgnoreCase("YY")){
			fmt = DateTimeFormat.forPattern(YY);
		}else if (format.equalsIgnoreCase("DMYHM")){
			fmt = DateTimeFormat.forPattern(DMYHM);
		}else if (format.equalsIgnoreCase("DMYHMS")){
			fmt = DateTimeFormat.forPattern(DMYHMS);
		}else if (format.equalsIgnoreCase("HM")){
			fmt = DateTimeFormat.forPattern(HM);
		}else if (format.equalsIgnoreCase("DMYHMA")){
			fmt = DateTimeFormat.forPattern(DMYHMA);
		}else if (format.equalsIgnoreCase("DMYHMSF")){
			fmt = DateTimeFormat.forPattern(DMYHMSF);
		}else if (format.equalsIgnoreCase("DMONYY")){
			fmt = DateTimeFormat.forPattern(DMONYY);
		}else
			fmt = DateTimeFormat.forPattern(DEFAULT_FORMAT);		
		return fmt;
	}
	
	public static String getFormat(String format){
		String retFormat = "";
		
		if (format == null || format.equals(""))
			format = "DMY";
		
		if (format.equalsIgnoreCase("DMY")){
			retFormat = DMY;
		}else if (format.equalsIgnoreCase("MY")){
			retFormat = MY;
		}else if (format.equalsIgnoreCase("MM")){
			retFormat = MM;
		}else if (format.equalsIgnoreCase("YY")){
			retFormat = YY;
		}else if (format.equalsIgnoreCase("DMYHM")){
			retFormat = DMYHM;
		}else if (format.equalsIgnoreCase("DMYHMS")){
			retFormat = DMYHMS;
		}else if (format.equalsIgnoreCase("HM")){
			retFormat = HM;
		}else if (format.equalsIgnoreCase("DMYHMA")){
			retFormat = DMYHMA;
		}else if (format.equalsIgnoreCase("DMYHMSF")){
			retFormat = DMYHMSF;
		}else if (format.equalsIgnoreCase("DMONYY")){
			retFormat = DMONYY;
		}else
			retFormat = DEFAULT_FORMAT;	
		return retFormat; 
	}
}
