/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * Utility Class to handle Date Conversions 
 * 
 * References JARS
 * 	1.joda-time-1.4.jar
 *  2.dwr2.0-rc1.jar
 *  3.spring-2.0.1.jar
 *  
 * References XML Configs
 * 	1. WEB-INF\dwr.xml 
 *  2. Entries in WEB-INF\web.xml to enable DWR
 * 
 * 
 * <BR>
 * Created on 12/09/2006
 * <UL>
 * <LI>Extensively uses JodaTime 1.4 package for DateTime Conversion and Formatting
 * <LI>Added the method convertDate (3 variants and JS)
 * <LI>Added the method validDate (3 variants and JS)
 * </UL>
 * 
 * <BR>
 * Modified on 18/09/2006 with the following changes
 * <UL>  
 * <LI>Moved all the Chronology creation logic to ChronologyFactory Class
 * <LI>Moved all the DateFormatter creation logic to FormatterFactory Class
 * <LI>Added DateFormatException to wrap the Exceptions
 * <LI>Added the method isAfter (3 variants and JS)
 * <LI>Added the method isBefore (3 variants and JS)
 * <LI>Added the method isBeforeNow (3 variants and JS)
 * <LI>Added the method isAfterNow (3 variants and JS)
 * </UL>
 * 
 * <BR>
 * Modified on 19/09/2006 to
 * <UL> 
 * <LI>Added the method isAfterNow (3 variants and JS)
 * </UL>
 * 
 * <BR>
 * Modified on 28/11/2006 to
 * <UL> 
 * <LI>Add all the method level comments
 * </UL>
 * 
 * <BR>
 * Modified on 07/12/2006 to
 * <UL> 
 * <LI>Removed the JSP/Servlet (HttpSession), EJB(Properties)  and JS variants for all methods
 * <LI>Added references, both XML files and jars
 * </UL>
 *  
 * <BR>
 * Modified on 08/12/2006 to handle null and empty string in a date argument
 * <UL> 
 * <LI> Added check for null in convertDate, validDate 
 * <LI> isBeforeNow and isAfterNow return false if date passed in is null
 * <LI> 
 * </UL>
 * 
 * <BR>
 * Modified on 11/12/2006 to handle null and empty string in a date argument
 * <UL> 
 * <LI> Added the methods to get parts of date (year, month, date, day and so on)
 * <LI> Added methods to plus and minus intervals 
 * </UL>
 * 
 * <BR>
 * Modified on 13/12/2006 to handle null and empty string in a date argument
 * <UL> 
 * <LI> Modified the method isBeforeNow to use isBefore to take care of locale 
 * <LI> Modified the method isAfterNow to use isAfter to take care of locale 
 * </UL>
 * 
 * <BR>
 * Modified on 18/12/2006 to handle equals in isBefore and isAfter
 *  
 * <BR>
 * Modified on 26/12/2006
 * <UL> 
 * <LI> Added methods secondsBetween, minutesBetween, hoursBetween, daysBetween, weeksBetween, monthsBetween, yearsBetween and durationBetween for date differences
 * <LI> Added method isLeapYear to check for Leap Years
 * <LI> Added method formatDate for date pattern conversions
 * <LI> Added method getDaysInMonth for getting maximum number of days in a given month 
 * </UL>
 * 
 * <BR>
 * Modified on 29/12/2006 
 * <UL> 
 * <LI> Added methods checkDate to pad zero for month and date
 * <LI> Added method checkDate to validDate method  
 * </UL>
 *
 * <BR>
 * Modified on 06/01/2009
 * <UL>
 * <LI> Will always use UTC as the standard to create a LocalDateTime and then work with MutableDateTime object
 * <LI> Changed file DateUtils.java, Added function createDateTime() and Changed the functions validDate() and convertDate() to use the createDateTime() with the UTC Timezone
 * </UL>
 *
 * </UL> 
 */

package com.ehis.util;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.Seconds;
import org.joda.time.Weeks;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.MutableDateTime;

/**
 * Utility Class to handle Date Conversions 
 * 
 * @author ChandrasekharM
 * 
 */


public class DateUtils {

	/**
	 * Method to convert date
	 *  
	 * @param date Date string to be formatted
	 * @param format Input and onput formats
	 * @param from From locale 
	 * @param to To locale
	 * @return Date String after conversion
	 *
	 * Changed on Tuesday, January 06, 2009 to call createDateTime()
	 * 
	 */
	public static String convertDate(String date, String format, String from, String to) {
		String retDate = "";

		//Added on 1/6/2009
		DateTimeZone zn = DateTimeZone.getDefault();		
		//Check if the date passed in is null or empty
		if (date != null && !date.equals("")){
			
			/* Commented on 1/6/2009
			// Build the From Chronology
			Chronology fromChronology = null;
			fromChronology = ChronologyFactory.getChronology(from);
			*/
	
			// Build the To Chronology
			Chronology toChronology = null;
			toChronology = ChronologyFactory.getChronology(to);
	
			// Create the DateFormatter for date parsing
			DateTimeFormatter fmt = FormatterFactory.getDateTimeFormatter(format);
	
			/* Commented on 1/6/2009
			// Create the DateTime Object here with thefrom Chronology
			DateTime dt = new DateTime(fmt.withChronology(fromChronology).parseDateTime(date));
			*/

			//Added on 1/6/2009
			DateTime dt = null;
			
			/* Commented on 1/6/2009
			// Convert the DateTime Object to the required chronology
			DateTime newDt = dt.withChronology(toChronology);
			*/
	
			// Check if the given date is valid in its format and locale
			try {
				//Added on 1/6/2009
				//Commented on 4/13/2009, force a conversion irrespective of from and to locales
				/*if(from.equalsIgnoreCase(to)){
					dt = createDateTime(date, format, from);
				}else{*/
					dt = createDateTime(date.trim(), format, from).withChronology(toChronology);
				//}

				if (validDate(date.trim(), format, from)) {
					// Format the date to the required format
					retDate = fmt.withZone(zn).print(dt);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return retDate;
	}	

	/**
	 * Method to get the current date
	 * 
	 * @param format Output format
	 * @param locale Output locale 
	 * @return Current Date as a string after conversion 
	 * 
	 */
	public static String getCurrentDate(String format, String locale) {
		String retDate = "";

		// Create the DateFormatter for date parsing
		DateTimeFormatter fmt = FormatterFactory.getDateTimeFormatter(format);

		/*
		 * Build the Chrnonlogy based on the Locale 
		 * th = BuddhistChronology 
		 * en = GregorianChronology
		 */
		Chronology currentChronology = null;
		currentChronology = ChronologyFactory.getChronology(locale);

		// Create a DateTime object with the current Chronology
		DateTime dt = new DateTime(currentChronology);

		// Format the DateTime Object to the format supplied
		retDate = fmt.print(dt);

		return retDate;
	}

	/**
	 * Method to check if the given date is valid in the supplied format and locale
	 * 
	 * @param date Date which should be validated
	 * @param format Applicable Date Format
	 * @param locale Applicable date locale
	 * @return true if the date is valid, false otherwise
	 * @throws Exception If unable to parse the date
	 *
	 * Changed on Tuesday, January 06, 2009 to call createDateTime()
	 *
	 */
	@SuppressWarnings("finally")
	public static boolean validDate(String date, String format, String locale) throws DateFormatException {
		boolean valid = false;
		
		//Check if the date passed in is null or empty		
		if (date != null && !date.equals("") && checkDate(date,format)){
			
			/* Commented on 1/6/2009
			// Create the DateFormatter object here to format the date
			DateTimeFormatter fmt = FormatterFactory.getDateTimeFormatter(format);
	
			// Create the curent chronology object based on the locale
			Chronology currentChronology = null;
			currentChronology = ChronologyFactory.getChronology(locale);
			*/
			
			try {
				/* Commented on 1/6/2009
				// Try parsing the input date string now
				DateTime dt = fmt.withChronology(currentChronology).parseDateTime(date);				
				*/
				DateTime dt = createDateTime(date, format, locale);
				valid = true;
			} catch (IllegalArgumentException exc) {
				exc.printStackTrace();
				throw new DateFormatException(exc.getMessage(), (Throwable) exc);
			} catch (UnsupportedOperationException exc) {
				exc.printStackTrace();
				throw new DateFormatException(exc.getMessage(), (Throwable) exc);
			}finally{
				return valid;
			}
			
		}
		return valid;
	}
	
	
	/**
	 * Method to check if a given date is before a particular date
	 * 
	 * @param fromDate Date to be checked 
	 * @param toDate Date against which isBefore is to be checked 
	 * @param format Format of the date
	 * @param locale Input locale
	 * @return True if fromDate isBefore toDate, False otherwise 
	 */
	@SuppressWarnings("finally")
	public static boolean isBefore(String fromDate, String toDate, String format, String locale) {
		boolean isBefore = false;
		try {
			if (validDate(fromDate, format, locale)
					&& validDate(toDate, format, locale)) {
				
				DateTime from = getDateTime(fromDate, format, locale);
				DateTime to = getDateTime(toDate, format, locale);
				
				isBefore = from.isBefore(to) || from.equals(to);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return isBefore;
		}		
	}	
	
	/**
	 * Method to check if given Date is before current date
	 *
	 * @param currDate Date to be checked
	 * @param format Date Format
	 * @param locale Date Locale
	 * @return True if isBeforeNow, False otherwise
	 *
	 */
	public static boolean isBeforeNow(String currDate, String format, String locale) {
		boolean isBeforeNow = false;
		
		//Check if the date passed in is null or empty
		if (currDate == null || currDate.equals(""))
			return false;
		
		isBeforeNow = isBefore(currDate,getCurrentDate(format,locale),format,locale);
		
		return isBeforeNow;
	}	
	
	/**
	 * Method to check if given Date is after current date
	 *
	 * @param currDate Date to be checked
	 * @param format Date Format
	 * @param locale Date Locale
	 * @return True if isAfterNow, False otherwise
	 */
	public static boolean isAfterNow(String currDate, String format, String locale) {
		boolean isAfterNow = false;
		
		//Check if the date passed in is null or empty
		if (currDate == null || currDate.equals(""))
			return false;
		
		isAfterNow = isAfter(currDate,getCurrentDate(format,locale),format,locale);
		
		return isAfterNow;
	}	
	
	/**
	 * Method to check if given Date is after a specific Date (fromDate after toDate)
	 *
	 * @param fromDate From Date
	 * @param toDate To Date
	 * @param format Date Format 
	 * @param locale Date Locale
	 * @return True, if is After False otherwise
	 */
	@SuppressWarnings("finally")
	public static boolean isAfter(String fromDate, String toDate, String format, String locale) {
		boolean isAfter = false;
		try {
			if (validDate(fromDate, format, locale)
					&& validDate(toDate, format, locale)) {
				DateTime from = getDateTime(fromDate, format, locale);
				DateTime to = getDateTime(toDate, format, locale);

				isAfter = from.isAfter(to) || from.equals(to);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return isAfter;
		}
		
		
	}
	
	/**
	 * Method for a Date range check
	 *
	 * @param fromDate From Date 
	 * @param toDate To Date
	 * @param currDate Date whioch is to be checked if in between from and to Dates
	 * @param format Date Format
	 * @param locale Date Locale
	 * @return True, if isBetween False otherwise
	 */
	@SuppressWarnings("finally")
	public static boolean isBetween(String fromDate, String toDate, String currDate, String format, String locale) {
		boolean isBetween = false;
		try {
			if (validDate(fromDate, format, locale)
					&& validDate(toDate, format, locale)
					&& validDate(currDate, format, locale)) {
				DateTime from = getDateTime(fromDate, format, locale);
				DateTime to = getDateTime(toDate, format, locale);
				DateTime curr = getDateTime(currDate, format, locale);
								
				isBetween = (to.isAfter(from) || to.equals(from)) && (to.isAfter(curr) || to.equals(curr))
						&& (from.isBefore(curr) || from.equals(curr));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return isBetween;
		}		
	}
	
	/**
	 * Private Utility method, to return a Joda DateTime Object 
	 *
	 * @param date Date String to be Converted
	 * @param format Input Format
	 * @param locale Input Locale
	 * @return Joda DateTime Object, after conversion
	 */
	private static DateTime getDateTime(String date, String format,String locale) {
		DateTime dt = null;
		
		//Commented on 4/13/2009, use the createDateTime here 
		/*
		Chronology chronology = ChronologyFactory.getChronology(locale);
		DateTimeFormatter fmt = FormatterFactory.getDateTimeFormatter(format);
		dt = fmt.withChronology(chronology).parseDateTime(date);
		*/
		try{
			dt = createDateTime(date,format,locale);
		}catch(Exception exc){
			exc.printStackTrace();
		}
		
		return dt;
	}
	
	/**
	 * Method for getting the day of month for a Date(1-31)
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support day should be uaed)
	 * @param locale Date Locale
	 * @return day of month (between 1 and 31), 0 for error 
	 */
	@SuppressWarnings("finally")
	public static int getDayOfMonth(String currDate, String format, String locale) {
		int dayOfMonth = 0;
		try {
			if (validDate(currDate, format, locale)) {
				DateTime date = getDateTime(currDate, format, locale);
				dayOfMonth = date.getDayOfMonth();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return dayOfMonth;
		}
	}
	
	/**
	 * Method for getting the day of the week for a Date (1-7) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for Day should be used)
	 * @param locale Date Locale
	 * @return day of week (between 1 and 7), 0 for error 
	 */
	@SuppressWarnings("finally")
	public static int getDayOfWeek(String currDate, String format, String locale) {
		int dayOfWeek = 0;
		try {
			if (validDate(currDate, format, locale)) {
				DateTime date = getDateTime(currDate, format, locale);
				dayOfWeek = date.getDayOfWeek();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return dayOfWeek;
		}		
	}
	
	/**
	 * Method for getting the day of the week as Long Text for a Date (Sunday - Saturday) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for Day should be used)
	 * @param locale Date Locale
	 * @return day of week (between Sunday and Saturday), empty for error 
	 */
	@SuppressWarnings("finally")
	public static String getDayOfWeekAsLongText(String currDate, String format, String locale) {
		String dayOfWeek = "";
		try {
			if (validDate(currDate, format, locale)) {
				DateTime date = getDateTime(currDate, format, locale);
				dayOfWeek = date.dayOfWeek().getAsText();				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return dayOfWeek;
		}
	}
	
	/**
	 * Method for getting the day of the week as Short Text for a Date (Sun - Sat) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for Day should be used)
	 * @param locale Date Locale
	 * @return day of week (between Sun and Sat), empty for error 
	 */
	@SuppressWarnings("finally")
	public static String getDayOfWeekAsShortText(String currDate, String format, String locale) {
		String dayOfWeek = "";
		try {
			if (validDate(currDate, format, locale)) {
				DateTime date = getDateTime(currDate, format, locale);
				dayOfWeek = date.dayOfWeek().getAsShortText();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return dayOfWeek;
		}		
	}
	
	/**
	 * Method for getting the month of the year for a Date (1-12) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for month should be used)
	 * @param locale Date Locale
	 * @return month of year (between 1 and 12), 0 for error 
	 */
	@SuppressWarnings("finally")
	public static int getMonthOfYear(String currDate, String format, String locale) {
		int monthOfYear = 0;
		try {
			if (validDate(currDate, format, locale)) {
				DateTime date = getDateTime(currDate, format, locale);
				monthOfYear = date.getMonthOfYear();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return monthOfYear;
		}
	}
	
	/**
	 * Method for getting the month of the year as Long Text for a Date (January - December) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for month should be used)
	 * @param locale Date Locale
	 * @return month of year (between January and December), empty for error 
	 */
	@SuppressWarnings("finally")
	public static String getMonthOfYearAsLongText(String currDate, String format, String locale) {
		String monthOfYear = "";
		try {
			if (validDate(currDate, format, locale)) {
				DateTime date = getDateTime(currDate, format, locale);
				monthOfYear = date.monthOfYear().getAsText();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return monthOfYear;
		}
	}
	
	/**
	 * Method for getting the month of the year as Short Text for a Date (Jan - Dec) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for month should be used)
	 * @param locale Date Locale
	 * @return month of year (between Jan and Dec), empty for error 
	 */
	@SuppressWarnings("finally")
	public static String getMonthOfYearAsShortText(String currDate, String format, String locale) {
		String monthOfYear = "";
		try {
			if (validDate(currDate, format, locale)) {
				DateTime date = getDateTime(currDate, format, locale);
				monthOfYear = date.monthOfYear().getAsShortText();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return monthOfYear;
		}
	}
	
	/**
	 * Method for getting year (yyyy) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for year should be used)
	 * @param locale Date Locale
	 * @return year (yyyy), 0 for error 
	 */
	@SuppressWarnings("finally")
	public static int getYear(String currDate, String format, String locale) {
		int year = 0;
		try {
			if (validDate(currDate, format, locale)) {
				DateTime date = getDateTime(currDate, format, locale);
				year = date.getYear();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return year;
		}
	}
	
	/**
	 * Method for getting hour of the day (1-24) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for hour should be used)
	 * @param locale Date Locale
	 * @return hour (1-24), 0 for error 
	 */
	@SuppressWarnings("finally")
	public static int getHourOfDay(String currDate, String format, String locale) {
		int hourOfDay = 0;
		try {
			if (validDate(currDate, format, locale)) {
				DateTime date = getDateTime(currDate, format, locale);
				hourOfDay = date.getHourOfDay();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return hourOfDay;
		}
	}
	
	/**
	 * Method for getting minute of the hour (1-60) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for minute should be used)
	 * @param locale Date Locale
	 * @return hour (1-60), 0 for error 
	 */
	@SuppressWarnings("finally")
	public static int getMinuteOfHour(String currDate, String format, String locale) {
		int minuteOfHour = 0;
		try {
			if (validDate(currDate, format, locale)) {
				DateTime date = getDateTime(currDate, format, locale);
				minuteOfHour = date.getMinuteOfHour();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return minuteOfHour;
		}
	}
	
	/**
	 * Method for reducing an interval from a date
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for minute should be used)
	 * @param locale Date Locale
	 * @param value Value for the interval
	 * @param interval String representing interval(Y year, M month, w weeks, d days, h hours, m minutes)
	 * @return String after reduction, emoty for error 
	 */
	@SuppressWarnings("finally")
	public static String minusDate(String currDate, String format, String locale, int value, String interval) {
		String changedDate  = "";
		try {
			if (validDate(currDate, format, locale)) {
				DateTime date = getDateTime(currDate, format, locale);
				DateTime temp = null;
				//Create the DateFormatter for date parsing
				DateTimeFormatter fmt = FormatterFactory.getDateTimeFormatter(format);
				if (interval.equals("Y")){
					temp = date.minusYears(value);
				}else if (interval.equals("M")){
					temp = date.minusMonths(value);
				}else if (interval.equals("w")){
					temp = date.minusWeeks(value);
				}else if (interval.equals("d")){
					temp = date.minusDays(value);
				}else if (interval.equals("h")){
					temp = date.minusHours(value);
				}else if (interval.equals("m")){
					temp = date.minusMinutes(value);
				}
				changedDate = fmt.print(temp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return changedDate;
		}
	}
	
	/**
	 * Method for adding up an interval to a date
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for minute should be used)
	 * @param locale Date Locale
	 * @param value Value for the interval
	 * @param interval String representing interval(Y year, M month, w weeks, d days, h hours, m minutes)
	 * @return String after reduction, emoty for error 
	 */
	@SuppressWarnings("finally")
	public static String plusDate(String currDate, String format, String locale, int value, String interval) {
		String changedDate  = "";
		try {
			if (validDate(currDate, format, locale)) {
				DateTime date = getDateTime(currDate, format, locale);
				DateTime temp = null;
				//Create the DateFormatter for date parsing
				DateTimeFormatter fmt = FormatterFactory.getDateTimeFormatter(format);
				if (interval.equals("Y")){
					temp = date.plusYears(value);
				}else if (interval.equals("M")){
					temp = date.plusMonths(value);
				}else if (interval.equals("w")){
					temp = date.plusWeeks(value);
				}else if (interval.equals("d")){
					temp = date.plusDays(value);
				}else if (interval.equals("h")){
					temp = date.plusHours(value);
				}else if (interval.equals("m")){
					temp = date.plusMinutes(value);
				}
				changedDate = fmt.print(temp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return changedDate;
		}
	}
	
	/**
	 * Method to get the number of days between two given dates 
	 * 
	 * @param fromDate The beginning date 
	 * @param toDate The end date
	 * @param format The date format 
	 * @param locale The date locale
	 * @return Days difference, (java.lang.Integer.MIN_VALUE -2147483648) if error
	 */
	@SuppressWarnings("finally")
	public static int daysBetween(String fromDate, String toDate, String format, String locale){
		int retDaysBetween = Integer.MIN_VALUE;
		try {
			if (validDate(fromDate,format,locale) && validDate(toDate,format,locale) ){
				retDaysBetween = Days.daysBetween(getDateTime(fromDate,format,locale),getDateTime(toDate,format,locale)).getDays();
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return retDaysBetween;
		}
	}
	
	/**
	 * Method to get the number of weeks between two given dates 
	 * 
	 * @param fromDate The beginning date 
	 * @param toDate The end date
	 * @param format The date format 
	 * @param locale The date locale
	 * @return Weeks difference, (java.lang.Integer.MIN_VALUE -2147483648) if error
	 */
	@SuppressWarnings("finally")
	public static int weeksBetween(String fromDate, String toDate, String format, String locale){
		int retWeeksBetween = Integer.MIN_VALUE;
		try {
			if (validDate(fromDate,format,locale) && validDate(toDate,format,locale) ){
				retWeeksBetween = Weeks.weeksBetween(getDateTime(fromDate,format,locale),getDateTime(toDate,format,locale)).getWeeks();
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return retWeeksBetween;
		}
	}
	
	/**
	 * Method to get the number of months between two given dates 
	 * 
	 * @param fromDate The beginning date 
	 * @param toDate The end date
	 * @param format The date format 
	 * @param locale The date locale
	 * @return Months difference, (java.lang.Integer.MIN_VALUE -2147483648) if error
	 */
	@SuppressWarnings("finally")
	public static int monthsBetween(String fromDate, String toDate, String format, String locale){
		int retMonthsBetween = Integer.MIN_VALUE;
		try {
			if (validDate(fromDate,format,locale) && validDate(toDate,format,locale) ){
				retMonthsBetween = Months.monthsBetween(getDateTime(fromDate,format,locale),getDateTime(toDate,format,locale)).getMonths();
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return retMonthsBetween;
		}
	}
	
	/**
	 * Method to get the number of years between two given dates 
	 * 
	 * @param fromDate The beginning date 
	 * @param toDate The end date
	 * @param format The date format 
	 * @param locale The date locale
	 * @return Years difference, (java.lang.Integer.MIN_VALUE -2147483648) if error
	 */
	@SuppressWarnings("finally")
	public static int yearsBetween(String fromDate, String toDate, String format, String locale){
		int retYearsBetween = Integer.MIN_VALUE;
		try {
			if (validDate(fromDate,format,locale) && validDate(toDate,format,locale) ){
				retYearsBetween = Years.yearsBetween(getDateTime(fromDate,format,locale),getDateTime(toDate,format,locale)).getYears();
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return retYearsBetween;
		}
	}
	
	/**
	 * Method to get the number of hours between two given dates 
	 * 
	 * @param fromDate The beginning date 
	 * @param toDate The end date
	 * @param format The date format 
	 * @param locale The date locale
	 * @return Hours difference, (java.lang.Integer.MIN_VALUE -2147483648) if error
	 */
	@SuppressWarnings("finally")
	public static int hoursBetween(String fromDate, String toDate, String format, String locale){
		int retHoursBetween = Integer.MIN_VALUE;
		try {
			if (validDate(fromDate,format,locale) && validDate(toDate,format,locale)){
				retHoursBetween = Hours.hoursBetween(getDateTime(fromDate,format,locale),getDateTime(toDate,format,locale)).getHours();
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return retHoursBetween;
		}		
	}
	
	/**
	 * Method to get the number of minutes between two given dates 
	 * 
	 * @param fromDate The beginning date 
	 * @param toDate The end date
	 * @param format The date format 
	 * @param locale The date locale
	 * @return Minutes difference, (java.lang.Integer.MIN_VALUE -2147483648) if error
	 */
	@SuppressWarnings("finally")
	public static int minutesBetween(String fromDate, String toDate, String format, String locale){
		int retMinutesBetween = Integer.MIN_VALUE;
		try {
			if (validDate(fromDate,format,locale) && validDate(toDate,format,locale) ){
				retMinutesBetween = Minutes.minutesBetween(getDateTime(fromDate,format,locale),getDateTime(toDate,format,locale)).getMinutes();
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return retMinutesBetween;
		}
	}
	
	/**
	 * Method to get the number of seconds between two given dates 
	 * 
	 * @param fromDate The beginning date 
	 * @param toDate The end date
	 * @param format The date format 
	 * @param locale The date locale
	 * @return Seconds difference, (java.lang.Integer.MIN_VALUE -2147483648) if error
	 */
	@SuppressWarnings("finally")
	public static int secondsBetween(String fromDate, String toDate, String format, String locale){
		int retSecondsBetween = Integer.MIN_VALUE;
		try {
			if (validDate(fromDate,format,locale) && validDate(toDate,format,locale) ){
				retSecondsBetween = Seconds.secondsBetween(getDateTime(fromDate,format,locale),getDateTime(toDate,format,locale)).getSeconds();
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return retSecondsBetween;
		}
	}
	
	/**
	 * Method to get the duration (with format) between two given dates 
	 * 
	 * @param fromDate The beginning date 
	 * @param toDate The end date
	 * @param format The date format 
	 * @param locale The date locale
	 * @return Duration difference, empty string if error
	 */
	@SuppressWarnings("finally")
	public static String durationBetween(String fromDate, String toDate, String format, String locale){
		String returnDuration = "";
		try {
			if (validDate(fromDate,format,locale) && validDate(toDate,format,locale) && isAfter(fromDate,toDate,format,locale) ){
				Period period = new Period(getDateTime(fromDate,format,locale),getDateTime(toDate,format,locale),PeriodTypeFactory.getPeriodType(format));
				PeriodFormatter pf = PeriodFormatterFactory.getFormatter(format);
				returnDuration = pf.print(period);
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return returnDuration;
		}
	}
	
	/**
	 * Method to get the days in a particular month
	 * @param date Date String to be parsed
	 * @param format Date input format
	 * @param locale Date input locale
	 * @return Maximim days in the given Dats's month, zero if an error occurs
	 */
	@SuppressWarnings("finally")
	public static int getDaysInMonth(String date, String format, String locale ){
		int retDays = 0;		
		try{
			if(validDate(date,format,locale)){
				DateTime dt = getDateTime(date,format,locale);
				retDays = dt.monthOfYear().getMaximumValue();
			}
		}catch(Exception exc){
			exc.printStackTrace();
		}finally{		
			return retDays;
		}
	}
	
	/**
	 * Method to check if a given year is a leap year
	 * @param date Date String from which the year will be taken 
	 * @param format Date input format
	 * @param locale Date input locale
	 * @return true if it is a leap year, false otherwise
	 */
	@SuppressWarnings("finally")
	public static boolean isLeapYear(String date, String format, String locale ){
		boolean isLeapYear = false;		
		try{
			if(validDate(date,format,locale)){
				DateTime dt = getDateTime(date,format,locale);
				isLeapYear = dt.yearOfCentury().isLeap();
			}
		}catch(Exception exc){
			exc.printStackTrace();
		}finally{		
			return isLeapYear;
		}
	}
	
	/**
	 * Method to convert date from one format to another 
	 * @param date Date string to be converted
	 * @param fromFormat Date input format
	 * @param toFormat Date output format
	 * @param locale Date input locale
	 * @return Date String converted to the output format, empty string if error 
	 */
	@SuppressWarnings("finally")
	public static String formatDate(String date, String fromFormat, String toFormat, String locale){
		String formatDate = "";		
		try{
			if(validDate(date,fromFormat,locale)){
				DateTime dt = getDateTime(date,fromFormat,locale);
				formatDate = FormatterFactory.getDateTimeFormatter(toFormat).print(dt);				
			}
		}catch(Exception exc){
			exc.printStackTrace();
		}finally{		
			return formatDate;
		}
	}
	
	/**
	 * Method to check the length / validity of the supplied date
	 * 
	 * @param date Date String to be checked
	 * @param format Date Input Format
	 * @return True if the date check passes, false otherwise 
	 */
	private static boolean checkDate(String date, String format){
		boolean retValue = false;
		
		if (format == null || format.equals(""))
			format = "DMY";
		
		if (format.equalsIgnoreCase("DMY")){
			if (date.length() == FormatterFactory.getFormat(format).length())
				retValue = true;
			else{
				String[] split = date.split("/");
				if (split.length == 3 && split[2].length() == 4)
					retValue = true;
			}
		}else if (format.equalsIgnoreCase("MY")){
			if (date.length() == FormatterFactory.getFormat(format).length())
				retValue = true;
			else{
				String[] split = date.split("/");
				if (split.length == 2 && split[1].length() == 4)
					retValue = true;
			}
		}else if (format.equalsIgnoreCase("MM")){
			if (date.length() == 1 || date.length() == FormatterFactory.getFormat(format).length())
				retValue = true;			
		}else if (format.equalsIgnoreCase("YY")){
			if (date.length() == FormatterFactory.getFormat(format).length())
				retValue = true;						
		}else if (format.equalsIgnoreCase("DMYHM")){
			if (date.length() == FormatterFactory.getFormat(format).length()){				
				retValue = true;
			}else{
				String[] split = date.split(" ");
				if (split.length == 2){
					retValue = true;
					String[] datePart = split[0].split("/");
					if (datePart.length == 3 && datePart[2].length() == 4)
						retValue = true;
				}					
			}
		}else if (format.equalsIgnoreCase("DMYHMS")){
			if (date.length() == FormatterFactory.getFormat(format).length())
				retValue = true;
			else{
				String[] split = date.split(" ");
				if (split.length == 2){
					retValue = true;
					String[] datePart = split[0].split("/");
					if (datePart.length == 3 && datePart[2].length() == 4)
						retValue = true;
				}
			}
		}else if (format.equalsIgnoreCase("DMYHMA")){
			if (date.length() == FormatterFactory.getFormat(format).length())
				retValue = true;
			else{
				String[] split = date.split(" ");
				if (split.length == 3){
					retValue = true;
					String[] datePart = split[0].split("/");
					if (datePart.length == 3 && datePart[2].length() == 4)
						retValue = true;
				}
			}
		}else if (format.equalsIgnoreCase("HM")){
			if (date.length() == FormatterFactory.getFormat(format).length())
				retValue = true;
		}		
		else if (format.equalsIgnoreCase("DMONYY")){
			if (date.length() == FormatterFactory.getFormat(format).length())
				retValue = true;
		}	
		return retValue;		
	}
	
	/**
	 * Method to create a DateTime Object, taking the DateTimeZone into consideration. If DST encountered, the date 
	 * will be transitioned to the nearest transition (either previous or next)
	 * @param dateTime - string to create DateTime
	 * @param format - date format
	 * @param locale - locale to be considered for Chronology
	 * @return - a well formed DateTime Object
	 * @throws Exception - if date construction is not possible in the normal flow.
	 */
	public static DateTime createDateTime(String dateTime, String format, String locale)throws Exception{
		DateTime retDateTime = null;		
		
		//Get the appropriate formatter 
		DateTimeFormatter fmt = FormatterFactory.getDateTimeFormatter(format);
		
		// Create the curent chronology object based on the locale
		Chronology currentChronology = null;
		currentChronology = ChronologyFactory.getChronology(locale);
		
		DateTimeZone zn = DateTimeZone.getDefault();
		MutableDateTime mdt = null;
		
		//6/29/2009 Added to check if MDT is parsed successfully
		boolean completeTry = false;
		
		try{
			if (!zn.isFixed()){		
				//Timezone is not fixed				
				//Commented on 4/13/2009, irrespective of whether date is in LocalDateTimeGap, do the necessary validation
				//if(zn.isLocalDateTimeGap(new LocalDateTime(fmt.withZone(DateTimeZone.UTC).parseDateTime(dateTime)))){
					//Date is in the gap							
					LocalDateTime dt = new LocalDateTime(fmt.withZone(DateTimeZone.UTC).parseDateTime(dateTime));
					mdt = new MutableDateTime(zn);											
					try{
						//Added on 4/13/2009 to force the chronology
						mdt.setChronology(currentChronology);
						
						mdt.setYear(dt.getYear());
						mdt.setMonthOfYear(dt.getMonthOfYear());
						mdt.setDayOfMonth(dt.getDayOfMonth());
						mdt.setHourOfDay(dt.getHourOfDay());
						mdt.setMinuteOfHour(dt.getMinuteOfHour());
						mdt.setSecondOfMinute(dt.getSecondOfMinute());
						mdt.setMillisOfSecond(dt.getMillisOfSecond());
						
						//6/29/2009 Set MDT parsed successfully
						completeTry = true;
					}catch(org.joda.time.IllegalFieldValueException exc){
						
					}catch(java.lang.IllegalArgumentException exc){					

						
					}finally{
						
						//6/29/2009 if MDT parsed successfully ignore transistions
						if(completeTry){
							return new DateTime(fmt.withChronology(currentChronology).parseDateTime(dateTime));
						}

						long millis = mdt.getMillis();
						long nextTransition = zn.nextTransition(millis);
						long previousTransition = zn.previousTransition(millis);
						long diffToPreviousTransition = millis - previousTransition;
						long diffToNextTransition = nextTransition - millis;
						if (diffToNextTransition < diffToPreviousTransition) {
							mdt.setDate(nextTransition);						
						}else{
							mdt.setDate(previousTransition);					
						}				
					}				
				/* Commented on 4/13/2009, irrespective of whether date is in LocalDateTimeGap, do the necessary validation
				}else{
					//Date is not in the GAP
					retDateTime = new DateTime(fmt.withChronology(currentChronology).parseDateTime(dateTime));
				}
				*/
			}else{
				//Timezone is fixed
				retDateTime = new DateTime(fmt.withChronology(currentChronology).parseDateTime(dateTime));
			}
		}catch(org.joda.time.IllegalFieldValueException exc){
			//Thai Leap year Falls here for Linux OS
			retDateTime = new DateTime(fmt.withChronology(currentChronology).parseDateTime(dateTime));
		}

		// Convert the DateTime Object to the required chronology only if we hit a GAP
		if (retDateTime == null )
			//Changed on 4/13/2009
			//retDateTime = mdt.toDateTime().withChronology(currentChronology).withZone(zn);	
			retDateTime = mdt.toDateTime();	
		
		return retDateTime;	
	}
}
