/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Utility Class to handle Chronology Creation
 * <BR>
 * Created on 12/09/2006
 * 
 * Currently the following Chronologies and locales are supported
 * 
 * th = BuddhistChronology
 * en = GregorianChronology
 * 
 * <BR>
 * Modified on 08/12/2006 to handle null and empty strings
 * <UL> 
 * <LI>Modified method getChronology to return GregorianChronology if the input locale string is null or empty 
 * </UL>
 *  
 */

package com.ehis.util;

import org.joda.time.Chronology;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.IslamicChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.chrono.StrictChronology;

/**
 * Factory Class to retrieve Chronology based on a locale string
 * 
 * @author ChandrasekharM
 * 
 */
public class ChronologyFactory {
	
	public static final String english_locale="en";
	public static final String thai_locale="th";
	public static final String arabic_locale="ar";
	public static final String russian_locale="ru";
	
	
	/**
	 * @param locale the input locale
	 * @return Chronology appropriate to the input locale <br>
	 * 
	 * The following are the supported locales and the corresponding chronologies
	 * <UL>
	 * <LI>en - GregorianChronology
	 * <LI>th - BuddhistChronology	 
	 * </UL> 
	 */
	public static Chronology getChronology(String locale){
		Chronology chrononlogy = null;
		
		/*
		 * If the locale is null or empty string, set it to en
		 * so that GregorianChronology is returned
		*/
		
		if(locale == null || locale.equals(""))
			locale = english_locale;
		
		if(locale.equalsIgnoreCase(english_locale))
			chrononlogy = GregorianChronology.getInstance();
		else if (locale.equalsIgnoreCase(thai_locale))
			chrononlogy = BuddhistChronology.getInstance();
		else if (locale.equalsIgnoreCase(arabic_locale))
			chrononlogy = GregorianChronology.getInstance();
			//chrononlogy = IslamicChronology.getInstance();
		else if (locale.equalsIgnoreCase(russian_locale))
			chrononlogy = GregorianChronology.getInstance();
		
		return chrononlogy;
		
	}
	
}
