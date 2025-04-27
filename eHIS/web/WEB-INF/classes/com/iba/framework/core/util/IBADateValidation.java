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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.IslamicChronology;
import org.joda.time.chrono.JulianChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import com.iba.framework.core.util.CalendarConstants;
import com.iba.framework.logging.pojo.business.IBALogger;

/**
 * 
 * <br>
 * IBADateValidation Utility provides methods to validate date based on the
 * locale chosen. Currently the validation methods have been tested with respect
 * Buddhist and Gregorian Calendar but can be extended to other calendars also.
 * <br>
 * 
 * <br>
 * 
 * @version 0.2 <br>
 *          <br>
 * @author Swetha Tarachandra
 */

/*
 * <br> Last modified on : November 7 2006 <br> <br> The return type of methods
 * which are invoked via DWR was changed from Date to String representing the
 * format dd/MM/yyyy and dd/MM/yyyy HH:mm <br> <br> Documentation added
 * 
 * <br> Last modified on :November 9 2006 <br>
 * 
 * <br> Tested IBADateValidation utility with the latest version of joda(1.4)
 * Last modified on : November 26 2006
 */
public class IBADateValidation {
	/**
	 * Default Constructor
	 */
	public IBADateValidation() {
	}

	/**
	 * The convertDate method converts date from one era to another era based on
	 * the locales' passed as input.
	 * 
	 * @param date :
	 *            The input Date representing a java.util.Date that needs to be
	 *            converted.
	 * @param fromLocale :
	 *            The locale,in which the input Date has be defined.
	 * @param toLocale :
	 *            The locale, to which the input Date will be converted to.
	 * @param pattern :
	 *            The input date is evaluated as well as converted to the
	 *            required era based on the pattern entered. The default pattern
	 *            is dd/MM/yyyy.
	 * @return : The input date is converted and returned in java.util.Date
	 *         format.If the fromLocale or toLocale values are empty,a null
	 *         value is returned
	 * 
	 */
	public static Date convertDate(Date date, String fromLocale,
			String toLocale, String pattern) {

		/**
		 * The Chronology the date object is currently representing.
		 */
		Chronology fromChronology = null;
		/**
		 * The Chronology to be converted to.
		 */
		Chronology toChronology = null;

		/**
		 * Format the Date Pattern.If the input pattern is null,then set the
		 * default pattern as dd/MM/yyyy
		 */
		if (pattern.equals(null) || pattern.equals("")) {
			pattern = CalendarConstants.DATE_PATTERN;
		}

		/**
		 * Set the Chronology instance
		 */
		if (!(fromLocale.equals("")) && (!(toLocale.equals("")))) {
			fromChronology = instance(fromLocale);
			toChronology = instance(toLocale);
		} else {
			return null;
		}

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String convertedDate = simpleDateFormat.format(date);

		
		/**
		 * Set the DateTime based on the fromChronology
		 */
		DateTime fromDate = new DateTime(fromChronology);
		DateTimeFormatter dateTimeFormatter = DateTimeFormat
				.forPattern(pattern);
		DateTime dateTimeWithFormat = new DateTime(dateTimeFormatter
				.withChronology(fromChronology).parseDateTime(convertedDate));

		/**
		 * Get the DateTime based on the toChronology
		 */
		DateTime toDate = dateTimeWithFormat.withChronology(toChronology);

		/**
		 * Convert Joda Date to Util Date
		 */
		date = convertJodaToUtil(toDate);
		/**
		 * Return Converted Date in java.util
		 */

		return date;
	}

	/**
	 * The convertDateJS method converts date from one era to another era based
	 * on the locales' passed as input. This method will be invoked via the DWR.
	 * 
	 * @param date :
	 *            The input Date representing a java.lang.String that needs to
	 *            be converted.
	 * @param fromLocale :
	 *            The locale,in which the input Date has be defined.
	 * @param toLocale :
	 *            The locale, to which the input Date will be converted to.
	 * @param pattern :
	 *            The input date is evaluated as well as converted to the
	 *            required era based on the pattern entered. The default pattern
	 *            is dd/MM/yyyy.
	 * @return : The input date is converted and returned in java.lang.String
	 *         format.
	 * 
	 */
	public String convertDateJS(String date, String fromLocale,
			String toLocale, String pattern) {
		
	//	pattern = pattern.equals("") ? pattern = "dd/MM/yyyy" : pattern;
					
		IBALogger.getLogger().debug(this.getClass(),"pattern11111111--->"+pattern ,null);
		IBALogger.getLogger().debug(this.getClass(),"IBADateTimeValidation-pattern.indexOf('H')-->"+pattern.indexOf('H') ,null);
		
		if (pattern.indexOf('H') != -1) {
			
			IBALogger.getLogger().debug(this.getClass(),"IBADateTimeValidation-if-->"+pattern ,null);
			
			pattern = "dd/MM/yyyy HH:mm";
		}else{
			IBALogger.getLogger().debug(this.getClass(),"IBADateTimeValidation-else-->"+pattern ,null);
			pattern = "dd/MM/yyyy";
		}
		
		IBALogger.getLogger().debug(this.getClass(),"pattern222222--->"+pattern ,null);
		
		try {
			return convertDateToString(convertDate(convertStringToDate(date, pattern), fromLocale, toLocale, pattern), pattern);
		} catch (ParseException e) {
			return null;
		} catch (NullPointerException ex) {
			return null;
		}

	}

	/**
	 * The convertStringToDate method converts String to Date.
	 * 
	 * @param date :
	 *            The String representing a Date value
	 * @exception :
	 *                Throws Incorrect Date message,if a invalid Date is set.
	 * @return : The String is parsed to java.util.Date
	 * @throws ParseException
	 */
	private Date convertStringToDate(String date, String pattern)
			throws ParseException {

		Date convertedDate = null;

	//	pattern = (pattern.equals("")) ? CalendarConstants.DATE_PATTERN	: pattern;
		
		IBALogger.getLogger().debug(this.getClass(),"pattern---convertStringToDate11---->"+pattern,null);
		
		if (pattern.indexOf('H') != -1) {
			pattern = "dd/MM/yyyy HH:mm";
		}else{
			pattern = "dd/MM/yyyy";
		}
		
		IBALogger.getLogger().debug(this.getClass(),"pattern---convertStringToDate22---->"+pattern,null);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		simpleDateFormat.setLenient(false);
		convertedDate = simpleDateFormat.parse(date);

		return convertedDate;
	}

	/**
	 * The convertStringToDateTime method converts String to Date Time.
	 * 
	 * @param date :
	 *            The String representing a Date and Time value
	 * @exception :
	 *                Throws Incorrect Date message,if a invalid Date and Time
	 *                is set.
	 * @return : The String is parsed to java.util.Date
	 */
	private Date convertStringToDateTime(String date, String pattern)
			throws ParseException {

		Date convertedDate = null;
		pattern = (pattern.equals("")) ? CalendarConstants.DATETIME_PATTERN
				: pattern;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		simpleDateFormat.setLenient(false);

		convertedDate = simpleDateFormat.parse(date);
		return convertedDate;
	}

	/**
	 * The getCurrentDate method gets the current Date based on the locale
	 * passed.
	 * 
	 * @param locale :
	 *            The locale,based on which calendar will be chosen from which
	 *            the current Date has to be retrieved.
	 * @param pattern :
	 *            The pattern in which the current Date should be displayed The
	 *            default pattern is dd/MM/yyyy.
	 * @return : The current Date based on the locale.
	 */
	public static Date getCurrentDate(String locale, String pattern) {
		try {
			Date date = new Date();
			date = convertDate(date, CalendarConstants.LOCALE_EN, locale,
					pattern);
			return date;
		} catch (NullPointerException e) {
			return null;
		}
	}

	/**
	 * The getCurrentDateJS method gets the current Date based on the locale
	 * passed. This method is to be invoked via the DWR.
	 * 
	 * @param locale :
	 *            The locale,based on which calendar will be chosen from which
	 *            the current Date has to be retrieved.
	 * 
	 * @param pattern :
	 *            The pattern in which the current Date should be displayed The
	 *            default pattern is dd/MM/yyyy.
	 * 
	 * @return : The current Date based on the locale.
	 */
	public String getCurrentDateJS(String locale, String pattern) {
		try {
			Date date = new Date();

			pattern = pattern.equals("") ? CalendarConstants.DATE_PATTERN
					: pattern;

			return convertDateToString(convertDate(date,
					CalendarConstants.LOCALE_EN, locale, pattern), pattern);
		} catch (NullPointerException e) {
			return null;
		}

	}

	/**
	 * The validateDate method validates the input Date based on the locale
	 * 
	 * @param inputDate :
	 *            The input Date which has to be validated.
	 * @param locale :
	 *            The locale,the input Date is representing
	 * @return : A boolean true - if its a valid Date false- if its an invalid
	 *         Date
	 * 
	 */
	public static boolean validateDate(Date inputDate, String locale) {
		boolean flag = false;
		try {
			Chronology currentChronology = null;

			currentChronology = instance(locale);

			DateTimeFormatter fmt = DateTimeFormat
					.forPattern(CalendarConstants.DATE_PATTERN);

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					CalendarConstants.DATE_PATTERN);

			String convertedDate = simpleDateFormat.format(inputDate);

			DateTime dateTime = fmt.withChronology(currentChronology)
					.parseDateTime(convertedDate);

			flag = true;
		} catch (org.joda.time.IllegalFieldValueException e) {
			flag = false;
		} catch (java.lang.IllegalArgumentException ex) {
			flag = false;
		} catch (NullPointerException exx) {
			flag = false;
		}

		return flag;
	}

	/**
	 * The validateDateTime method validates the input Date and Time based on
	 * the locale
	 * 
	 * @param inputDate :
	 *            The input Date and Time which has to be validated.
	 * @param locale :
	 *            The locale,the input Date and Time is representing
	 * @return : A boolean true - if its a valid Date and Time false- if its an
	 *         invalid Date and Time
	 * 
	 */
	public static boolean validateDateTime(Date inputDate, String locale) {
		Chronology currentChronology = null;

		currentChronology = instance(locale);

		DateTimeFormatter fmt = DateTimeFormat
				.forPattern(CalendarConstants.DATETIME_PATTERN);

		boolean flag = false;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				CalendarConstants.DATETIME_PATTERN);

		String convertedDate = simpleDateFormat.format(inputDate);

		try {
			DateTime dateTime = fmt.withChronology(currentChronology)
					.parseDateTime(convertedDate);
			flag = true;
		} catch (org.joda.time.IllegalFieldValueException e) {
			flag = false;
		} catch (java.lang.IllegalArgumentException ex) {
			flag = false;
		} catch (NullPointerException e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * The validateDateJS method validates the input Date based on the locale
	 * This method will be invoked via the DWR.
	 * 
	 * @param date :
	 *            The input String representing a Date value which has to be
	 *            validated.
	 * @param locale :
	 *            The locale,the input Date is representing
	 * @return : A boolean true - if its a valid Date false- if its an invalid
	 *         Date
	 * 
	 */
	public boolean validateDateJS(String date, String locale) {
		boolean bool = false;
		try {
			bool = validateDate(convertStringToDate(date, ""), locale);
		} catch (ParseException e) {

			return false;
		} catch (NullPointerException ex) {

			return false;
		}
		return bool;
	}

	/**
	 * The validateDateTimeJS method validates the input Date based on the
	 * locale This method will be invoked via the DWR.
	 * 
	 * @param date :
	 *            The input String representing a Date value which has to be
	 *            validated.
	 * @param locale :
	 *            The locale,the input Date is representing
	 * @return boolean : true - if its a valid Date false- if its an invalid
	 *         Date
	 * 
	 */
	public boolean validateDateTimeJS(String date, String locale) {
		boolean bool = false;
		try {
			bool = validateDateTime(convertStringToDateTime(date, ""), locale);
		} catch (ParseException e) {
			return false;
		} catch (NullPointerException ex) {
			return false;
		}
		return bool;
	}

	private static Date setDate(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);

		return cal.getTime();
	}

	private static Date setDateTime(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(date);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * The isDateGreaterThan method is used to check if the fromDate is greater
	 * than the toDate.
	 * 
	 * @param fromDate :
	 *            The date input representing the from Date.
	 * @param toDate :
	 *            The date input representing the to Date.
	 * @param locale :
	 *            The locale, based on which the checking needs to be done
	 * @return boolean : true - if its a valid Date false - if its a inValid
	 *         Date
	 */
	public static boolean isDateGreaterThan(Date fromDate, Date toDate,
			String locale) {
		try {

			boolean flag = false;
			if (!(locale.equals(CalendarConstants.LOCALE_EN))) {
				fromDate = convertDate(fromDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATE_PATTERN);
				toDate = convertDate(toDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATE_PATTERN);
			}

			if ((setDate(fromDate)).after((setDate(toDate)))
					&& (!((setDate(fromDate)).toString())
							.equals(((setDate(toDate)).toString())))) {
				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * The isDateTimeGreaterThan method is used to check if the fromDateTime is
	 * greater than the toDateTime.
	 * 
	 * @param fromDate :
	 *            The date and time input representing the from Date.
	 * @param toDate :
	 *            The date and time input representing the to Date.
	 * @param locale :
	 *            The locale, based on which the checking needs to be done
	 * @return boolean : true - if its a valid Date false - if its a inValid
	 *         Date
	 */
	public static boolean isDateTimeGreaterThan(Date fromDate, Date toDate,
			String locale) {
		boolean flag = false;
		try {

			if (!(locale.equals(CalendarConstants.LOCALE_EN))) {
				fromDate = convertDate(fromDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATETIME_PATTERN);
				toDate = convertDate(toDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATETIME_PATTERN);
			}

			if ((setDateTime(fromDate)).after((setDateTime(toDate)))
					&& (!((setDateTime(fromDate)).toString())
							.equals(((setDateTime(toDate)).toString())))) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * The isDateGreaterThanJS method is used to check if the fromDate is
	 * greater than the toDate. This method will be invoked via the DWR.
	 * 
	 * @param fromDate :
	 *            The String representing a date value for fromDate.
	 * @param toDate :
	 *            The String representing a date value for toDate.
	 * @param locale :
	 *            The locale, based on which the checking needs to be done
	 * @return boolean : true - if its a valid Date false - if its a inValid
	 *         Date
	 */
	public boolean isDateGreaterThanJS(String fromDate, String toDate,
			String locale) {
		try {
			return isDateGreaterThan(convertStringToDate(fromDate, ""),
					convertStringToDate(toDate, ""), locale);
		} catch (ParseException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * The isDateTimeGreaterThanJS method is used to check if the fromDate is
	 * greater than the toDate. This method will be invoked via the DWR.
	 * 
	 * @param fromDate :
	 *            The String representing a date value for fromDate.
	 * @param toDate :
	 *            The String representing a date value for toDate.
	 * @param locale :
	 *            The locale, based on which the checking needs to be done
	 * @return boolean : true - if its a valid Date false - if its a inValid
	 *         Date
	 */
	public boolean isDateTimeGreaterThanJS(String fromDate, String toDate,
			String locale) {
		try {

			return isDateTimeGreaterThan(convertStringToDateTime(fromDate, ""),
					convertStringToDateTime(toDate, ""), locale);
		} catch (ParseException e) {
			return false;
		} catch (NullPointerException ex) {
			return false;
		}
	}

	/**
	 * The isDateEqual method,checks if the fromDate is Equal to toDate based on
	 * the locale.
	 * 
	 * @param fromDate :
	 *            The input Date representing the from Date.
	 * @param toDate :
	 *            The input Date representing the to Date.
	 * @param locale :
	 *            The locale,the input dates are representing.
	 * @return boolean : true - if the dates are equal. false - if the dates are
	 *         not equal.
	 */
	public static boolean isDateEqual(Date fromDate, Date toDate, String locale) {
		boolean flag = false;
		try {

			if (!(locale.equals(CalendarConstants.LOCALE_EN))) {

				fromDate = convertDate(fromDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATE_PATTERN);
				toDate = convertDate(toDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATE_PATTERN);
			}
			if ((setDate(toDate).toString()).equals(setDate(fromDate)
					.toString())) {
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * The isDateTimeEqual method,checks if the fromDateTime is Equal to
	 * toDateTime based on the locale.
	 * 
	 * @param fromDate :
	 *            The input Date and Time representing the from DateTime.
	 * @param toDate :
	 *            The input Date and Time representing the to DateTime.
	 * @param locale :
	 *            The locale,the input date and Time are representing.
	 * @return boolean : true - if the date and time are equal. false - if the
	 *         date and time are not equal.
	 */
	public static boolean isDateTimeEqual(Date fromDate, Date toDate,
			String locale) {
		boolean flag = false;
		try {
			if (!(locale.equals(CalendarConstants.LOCALE_EN))) {
				fromDate = convertDate(fromDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATETIME_PATTERN);
				toDate = convertDate(toDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATETIME_PATTERN);
			}

			if (setDateTime(toDate).toString().equals(
					setDateTime(fromDate).toString())) {
				flag = true;
			} else
				flag = false;
			return flag;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * The isDateTimeEqualJS method,checks if the fromDate is Equal to toDate
	 * based on the locale. This method is to be invoked via DWR.
	 * 
	 * @param fromDate :
	 *            The input String representing a Date Time value for fromDate.
	 * @param toDate :
	 *            The input String representing a Date Time value for toDate.
	 * @param locale :
	 *            The locale,the input dates are representing.
	 * @return boolean : true - if the date and time are equal. false - if the
	 *         date and time are not equal.
	 */
	public boolean isDateTimeEqualJS(String fromDate, String toDate,
			String locale) {
		try {
			return isDateTimeEqual(convertStringToDateTime(toDate, ""),
					convertStringToDateTime(fromDate, ""), locale);
		} catch (ParseException e) {
			return false;
		} catch (NullPointerException ex) {
			return false;
		}
	}

	/**
	 * The isDateEqualJS method,checks if the fromDate is Equal to toDate based
	 * on the locale. This method is to be invoked via DWR.
	 * 
	 * @param fromDate :
	 *            The input String representing a Date value for fromDate.
	 * @param toDate :
	 *            The input String representing a Date value for toDate.
	 * @param locale :
	 *            The locale,the input dates are representing.
	 * @return boolean : true - if the dates' are equal. false - if the dates'
	 *         are not equal.
	 */
	public boolean isDateEqualJS(String fromDate, String toDate, String locale) {
		try {
			return isDateEqual(convertStringToDate(toDate, ""),
					convertStringToDate(fromDate, ""), locale);
		} catch (ParseException e) {
			return false;
		} catch (NullPointerException ex) {
			return false;
		}
	}

	/**
	 * The isDateLesser method is used to check if the fromDate is lesser than
	 * to toDate based on the locale.
	 * 
	 * @param fromDate :
	 *            The input Date representing the fromDate.
	 * @param toDate :
	 *            The input Date representing the toDate.
	 * @param locale :
	 *            The locale,the input dates are representing.
	 * @return boolean : true - if the fromDate is lesser than the toDate. false -
	 *         if the fromDate isn't lesser than the toDate.
	 */
	public static boolean isDateLesser(Date fromDate, Date toDate, String locale) {
		boolean flag = false;
		try {
			if (!(locale.equals(CalendarConstants.LOCALE_EN))) {
				fromDate = convertDate(fromDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATETIME_PATTERN);
				toDate = convertDate(toDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATETIME_PATTERN);
			}
			if (setDate(toDate).after(setDate(fromDate))) {
				flag = true;
			} else
				flag = false;
			return flag;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * The isDateTimeLesser method is used to check if the fromDateTime is
	 * lesser than to toDateTime based on the locale.
	 * 
	 * @param fromDate :
	 *            The input Date representing the fromDate.
	 * @param toDate :
	 *            The input Date representing the toDate.
	 * @param locale :
	 *            The locale,the input dates are representing.
	 * @return boolean : true - if the fromDate is lesser than the toDate. false -
	 *         if the fromDate isn't lesser than the toDate.
	 */
	public static boolean isDateTimeLesser(Date fromDate, Date toDate,
			String locale) {
		boolean flag = false;
		try {
			if (!(locale.equals(CalendarConstants.LOCALE_EN))) {
				fromDate = convertDate(fromDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATETIME_PATTERN);
				toDate = convertDate(toDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATETIME_PATTERN);
			}

			if ((setDateTime(fromDate)).before((setDateTime(toDate)))
					&& (!((setDateTime(fromDate)).toString())
							.equals(((setDateTime(toDate)).toString())))) {

				flag = true;
			} else {
				flag = false;
			}

			return flag;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * The isDateLesserJS method is used to check if the fromDate is lesser than
	 * to toDate based on the locale. This method will be invoked via the DWR.
	 * 
	 * @param fromDate :
	 *            The input String representing the fromDate value.
	 * @param toDate :
	 *            The input String representing the toDate value.
	 * @param locale :
	 *            The locale,the input dates are representing.
	 * @return boolean : true - if the fromDate is lesser than the toDate. false -
	 *         if the fromDate isn't lesser than the toDate.
	 */
	public boolean isDateLesserJS(String fromDate, String toDate, String locale) {
		try {
			return isDateLesser(convertStringToDate(fromDate, ""),
					convertStringToDate(toDate, ""), locale);
		} catch (ParseException e) {
			return false;

		} catch (NullPointerException ex) {
			return false;

		}
	}

	/**
	 * The isDateTimeLesserJS method is used to check if the fromDateTime is
	 * lesser than to toDate based on the locale. This method will be invoked
	 * via the DWR.
	 * 
	 * @param fromDate :
	 *            The input String representing the fromDateTime value.
	 * @param toDate :
	 *            The input String representing the toDateTime value.
	 * @param locale :
	 *            The locale,the input dates are representing.
	 * @return boolean : true - if the fromDateTime is lesser than the toDate.
	 *         false - if the fromDateTime isn't lesser than the toDate.
	 */
	public boolean isDateTimeLesserJS(String fromDate, String toDate,
			String locale) {
		try {
			return isDateTimeLesser(convertStringToDateTime(fromDate, ""),
					convertStringToDateTime(toDate, ""), locale);
		} catch (ParseException e) {
			return false;
		} catch (NullPointerException ex) {
			return false;
		}
	}

	/**
	 * The method instance is used to set an instance of the respective
	 * Chronology based on the locale. If the locale is en,an instance of the
	 * Gregarion Calendar will be created. If the locale is th,an instance of
	 * the Buddist Calendar will be created.
	 * 
	 * @param locale :
	 *            The locale,based on which the Calendar instance will created.
	 * @return Chronology : The Calendar instance which is created based on the
	 *         locale.
	 */
	private static Chronology instance(String locale) {
		Chronology chrono = null;
		int calendar = CalendarConstants.ISO_CHRONOLOGY;
		if (locale.equals(CalendarConstants.LOCALE_THAI)) {
			calendar = CalendarConstants.BUDDHIST_CHRONOLOGY;
		} else {
			calendar = CalendarConstants.GREGORIAN_CHRONOLOGY;
		}
		switch (calendar) {
		/**
		 * GregorianChronology
		 */
		case 1:
			chrono = GregorianChronology.getInstance();
			break;
		/**
		 * BuddhistChronology
		 */
		case 2:
			chrono = BuddhistChronology.getInstance();
			break;
		/**
		 * CopticChronology
		 */
		case 3:
			chrono = CopticChronology.getInstance();
			break;
		/**
		 * IslamicChronology
		 */
		case 4:
			chrono = IslamicChronology.getInstance();
			break;
		/**
		 * JulianChronology
		 */
		case 5:
			chrono = JulianChronology.getInstance();
			break;
		/**
		 * ISOChronology
		 */
		default:
			chrono = ISOChronology.getInstance();
			break;
		}
		return chrono;
	}

	/**
	 * The isCurrentDate method is used to check if the input Date is the
	 * current Date
	 * 
	 * @param inputDate :
	 *            The input Date which needs to be checked if its the current
	 *            Date.
	 * @param locale :
	 *            The locale representing the input Date.
	 * @return boolean : true - if the current Date and the input Date is same
	 *         false - if the current Date and the input Date isn't same
	 */
	public static boolean isCurrentDate(Date inputDate, String locale) {
		boolean compareVal = false;
		try {
			Date currentDate = new Date();

			if (!(locale.equals(CalendarConstants.LOCALE_EN))) {
				inputDate = convertDate(inputDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATE_PATTERN);

			}

			compareVal = isDateEqual(currentDate, inputDate,
					CalendarConstants.LOCALE_EN);
			return compareVal;
		} catch (NullPointerException e) {
			return false;
		}
	}
	
	/**
	 * The isCurrentDateTime method is used to check if the input Date Time is
	 * the current Date Time
	 * 
	 * @param inputDate :
	 *            The input Date which needs to be checked if its the current
	 *            Date and Time.
	 * @param locale :
	 *            The locale representing the input Date and Time.
	 * @return boolean : true - if the current DateTime and the input DateTime
	 *         is same false - if the current DateTime and the input DateTime
	 *         isn't same
	 */
	public static boolean isCurrentDateTime(Date inputDate, String locale) {
		boolean compareVal = false;
		try {
			Date currentDate = new Date();
			if (!(locale.equals(CalendarConstants.LOCALE_EN))) {
				inputDate = convertDate(inputDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATETIME_PATTERN);
			}

			compareVal = isDateTimeEqual(currentDate, inputDate,
					CalendarConstants.LOCALE_EN);

			return compareVal;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * The isCurrentDateJS method is used to check if the input Date is the
	 * current Date. This method is invoked via DWR.
	 * 
	 * @param inputDate :
	 *            The input String representing a Date value which needs to be
	 *            checked if its the current Date and Time.
	 * @param locale :
	 *            The locale based on which the input Date was chosen from the
	 *            calendar.
	 * @return boolean : true - if the current DateTime and the input DateTime
	 *         is same false - if the current DateTime and the input DateTime
	 *         isn't same
	 */
	public boolean isCurrentDateJS(String inputDate, String locale) {
		try {

			return isCurrentDate(convertStringToDate(inputDate, ""), locale);
		} catch (ParseException e) {
			return false;

		} catch (NullPointerException ex) {
			return false;

		}
	}

	/**
	 * The isCurrentDateTimeJS method is used to check if the input Date Time is
	 * the current Date Time. This method is invoked via DWR.
	 * 
	 * @param inputDate :
	 *            The input String representing a Date Time value which needs to
	 *            be checked if its the current Date and Time.
	 * @param locale :
	 *            The locale based on which the input Date and Time was chosen
	 *            from the calendar.
	 * @return boolean : true - if the current DateTime and the input DateTime
	 *         is same false - if the current DateTime and the input DateTime
	 *         isn't same
	 */
	public boolean isCurrentDateTimeJS(String inputDate, String locale) {
		try {
			return isCurrentDateTime(convertStringToDateTime(inputDate, ""),
					locale);
		} catch (ParseException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * The isCurrentDateGreaterThan method is used to check if the current Date
	 * is greater than input Date
	 * 
	 * @param inputDate :
	 *            The inputDate ,which has to checked if its greater than the
	 *            current Date
	 * @param locale :
	 *            The locale based on which the input Date was chosen from the
	 *            calendar.
	 * @return boolean : true - if Current Date is greater than the Input Date.
	 *         flase - if Current Date isn't greater than the Input Date.
	 */
	public static boolean isCurrentDateGreaterThan(Date inputDate, String locale) {
		boolean compareVal = false;

		try {
			Date currentDate = new Date();

			if (!(locale.equals(CalendarConstants.LOCALE_EN))) {
				inputDate = convertDate(inputDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATE_PATTERN);
			}

			compareVal = isDateGreaterThan(currentDate, inputDate, locale);
			return compareVal;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * The isCurrentDateTimeGreaterThan method is used to check if the current
	 * Date Time is greater than input Date Time
	 * 
	 * @param inputDate :
	 *            The inputDateTime ,which has to checked if its greater than
	 *            the current Date Time
	 * @param locale :
	 *            The locale based on which the input Date Time was chosen from
	 *            the calendar.
	 * @return boolean : true - if Current Date Time is greater than the Input
	 *         Date Time. flase - if Current Date Time isn't greater than the
	 *         Input Date Time.
	 */
	public static boolean isCurrentDateTimeGreaterThan(Date inputDate,
			String locale) {
		boolean compareVal = false;
		try {
			Date currentDate = new Date();
			if (!(locale.equals(CalendarConstants.LOCALE_EN))) {
				inputDate = convertDate(inputDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATETIME_PATTERN);
			}
			compareVal = isDateTimeGreaterThan(currentDate, inputDate, locale);
			return compareVal;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * The isCurrentDateGreaterThanJS method is used to check if the current
	 * Date is greater than input Date This method is used to invoke via the DWR
	 * 
	 * @param inputDate :
	 *            The String ,representing a Date value,which has to checked if
	 *            its greater than the current Date.
	 * @param locale :
	 *            The locale based on which the input Date was chosen from the
	 *            calendar.
	 * @return boolean : true - if Current Date is greater than the Input Date.
	 *         flase - if Current Date isn't greater than the Input Date.
	 */
	public boolean isCurrentDateGreaterThanJS(String inputDate, String locale) {
		try {
			return isCurrentDateGreaterThan(convertStringToDate(inputDate, ""),
					locale);
		} catch (ParseException e) {
			return false;

		} catch (NullPointerException ex) {
			return false;

		}
	}

	/**
	 * The isCurrentDateTimeGreaterThanJS method is used to check if the current
	 * Date Time is greater than input Date Time This method is used to invoke
	 * via the DWR
	 * 
	 * @param inputDate :
	 *            The String ,representing a Date value, which has to checked if
	 *            its greater than the current Date Time.
	 * @param locale :
	 *            The locale based on which the input Date time was chosen from
	 *            the calendar.
	 * @return boolean : true - if Current Date Time is greater than the Input
	 *         Date. flase - if Current Date Time isn't greater than the Input
	 *         Date.
	 */
	public boolean isCurrentDateTimeGreaterThanJS(String inputDate,
			String locale) {
		try {
			return isCurrentDateTimeGreaterThan(convertStringToDateTime(
					inputDate, ""), locale);
		} catch (ParseException e) {
			return false;
		} catch (NullPointerException ex) {
			return false;
		}
	}

	/**
	 * The isCurrentDateLesserThan method is used to check if the current Date
	 * is lesser than input Date
	 * 
	 * @param inputDate :
	 *            The input Date ,which will be checked if it is lesser than
	 *            Current Date
	 * @param locale :
	 *            The locale,based on which the input Date Calendar was chosen.
	 * @return boolean : true - if the current date is lesser than the input
	 *         date. false - if the current date isn't lesser than the input
	 *         date.
	 */
	public static boolean isCurrentDateLesserThan(Date inputDate, String locale) {
		boolean compareVal = false;
		try {
			Date currentDate = new Date();
			if (!(locale.equals(CalendarConstants.LOCALE_EN))) {
				inputDate = convertDate(inputDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATE_PATTERN);
			}
			compareVal = isDateLesser(currentDate, inputDate, locale);
			return compareVal;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * The isCurrentDateTimeLesserThan method is used to check if the current
	 * Date and Time is lesser than input Date and Time
	 * 
	 * @param inputDate :
	 *            The input Date and Time ,which will be checked if it is lesser
	 *            than Current Date and Time
	 * @param locale :
	 *            The locale,based on which the input Date Calendar was chosen.
	 * @return boolean : true - if the current date and time is lesser than the
	 *         input date and time. false - if the current date and time isn't
	 *         lesser than the input date and time.
	 */
	public static boolean isCurrentDateTimeLesserThan(Date inputDate,
			String locale) {
		boolean compareVal = false;
		try {
			Date currentDate = new Date();
			if (!(locale.equals(CalendarConstants.LOCALE_EN))) {
				inputDate = convertDate(inputDate, locale,
						CalendarConstants.LOCALE_EN,
						CalendarConstants.DATETIME_PATTERN);
			}
			compareVal = isDateTimeLesser(currentDate, inputDate, locale);
			return compareVal;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * The isCurrentDateLesserThanJS method is used to check if the current Date
	 * is lesser than input Date This method will be invoked via the DWR.
	 * 
	 * @param inputDate :
	 *            The String ,representing the input Date and Time value,which
	 *            will be checked if it is lesser than Current Date and Time
	 * @param locale :
	 *            The locale,based on which the input Date Calendar was chosen.
	 * @return boolean : true - if the current date and time is lesser than the
	 *         input date and time. false - if the current date and time isn't
	 *         lesser than the input date and time.
	 */
	public boolean isCurrentDateLesserThanJS(String inputDate, String locale) {
		try {
			return isCurrentDateLesserThan(convertStringToDate(inputDate, ""),
					locale);
		} catch (ParseException e) {
			return false;
		} catch (NullPointerException ex) {
			return false;
		}
	}

	/**
	 * The isCurrentDateTimeLesserThanJS method is used to check if the current
	 * Date and Time is lesser than input Date and Time This method will be
	 * invoked via the DWR.
	 * 
	 * @param inputDate :
	 *            The String ,representing the input Date and Time value,which
	 *            will be checked if it is lesser than Current Date and Time
	 * @param locale :
	 *            The locale,based on which the input Date Calendar was chosen.
	 * @return boolean : true - if the current date and time is lesser than the
	 *         input date and time. false - if the current date and time isn't
	 *         lesser than the input date and time.
	 */
	public boolean isCurrentDateTimeLesserThanJS(String inputDate, String locale) {
		try {
			return isCurrentDateTimeLesserThan(convertStringToDateTime(
					inputDate, ""), locale);
		} catch (ParseException e) {
			return false;
		} catch (NullPointerException ex) {
			return false;
		}
	}

	/**
	 * The method validateInputDate is used to check if the input Date is in
	 * between from and to date range
	 * 
	 * @param fromDate :
	 *            The input Date representing the from Date.
	 * @param toDate :
	 *            The input Date representing the to Date.
	 * @param inputDate :
	 *            The input Date which needs to checked if it is in between the
	 *            from and the to date range.
	 * @param locale :
	 *            The locale based on which the calendar was chosen.
	 * @return boolean : true - if the input date is in between the from Date
	 *         and the to Date range. false - if the input date isn't between
	 *         the from Date and the to Date range.
	 */
	public static boolean validateInputDate(Date fromDate, Date toDate,
			Date inputDate, String locale) {

		boolean flag = false;

		boolean returnedFromFlag = false;

		boolean returnedToFlag = false;

		boolean returnedEqual = false;

		try {

			fromDate = convertDate(fromDate, locale,
					CalendarConstants.LOCALE_EN, CalendarConstants.DATE_PATTERN);

			toDate = convertDate(toDate, locale, CalendarConstants.LOCALE_EN,
					CalendarConstants.DATE_PATTERN);

			inputDate = convertDate(inputDate, locale,
					CalendarConstants.LOCALE_EN, CalendarConstants.DATE_PATTERN);

			returnedFromFlag = isDateGreaterThan(fromDate, inputDate, locale);

			returnedToFlag = isDateGreaterThan(inputDate, toDate, locale);

			if (returnedFromFlag == false && returnedToFlag == false) {
				flag = true;
			} else if (returnedFromFlag == true && returnedToFlag == true) {
				flag = true;
			} else if (returnedFromFlag == true && returnedToFlag == false) {
				flag = false;
			} else if (returnedFromFlag == false && returnedToFlag == true) {
				flag = false;
			}

			if (isDateEqual(fromDate, inputDate, locale) == true
					|| isDateEqual(inputDate, toDate, locale) == true) {
				returnedEqual = true;
			}
			if (flag || returnedEqual) {
				flag = true;
			}

			return flag;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * The method validateInputDateTime is used to check if the input Date and
	 * Time is in between from and to date range
	 * 
	 * @param fromDate :
	 *            The input Date and Time representing the from Date and Time.
	 * @param toDate :
	 *            The input Date and Time representing the to Date and Time.
	 * @param inputDate :
	 *            The input Date and Time which needs to checked if it is in
	 *            between the from and the to date and time range.
	 * @param locale :
	 *            The locale based on which the calendar was chosen.
	 * @return boolean : true - if the input date and time is in between the
	 *         from Date Time and the to Date Time range. false - if the input
	 *         date isn't between the from Date Time and the to Date Time range.
	 */
	public static boolean validateInputDateTime(Date fromDate, Date toDate,
			Date inputDate, String locale) {

		boolean flag = false;

		boolean returnedFromFlag = false;

		boolean returnedToFlag = false;

		boolean returnedEqual = false;
		try {

			fromDate = convertDate(fromDate, locale,
					CalendarConstants.LOCALE_EN,
					CalendarConstants.DATETIME_PATTERN);

			toDate = convertDate(toDate, locale, CalendarConstants.LOCALE_EN,
					CalendarConstants.DATETIME_PATTERN);

			inputDate = convertDate(inputDate, locale,
					CalendarConstants.LOCALE_EN,
					CalendarConstants.DATETIME_PATTERN);

			returnedFromFlag = isDateTimeGreaterThan(fromDate, inputDate,
					locale);
			returnedToFlag = isDateTimeGreaterThan(inputDate, toDate, locale);

			if (returnedFromFlag == false && returnedToFlag == false) {
				flag = true;
			} else if (returnedFromFlag == true && returnedToFlag == true) {
				flag = true;
			} else if (returnedFromFlag == true && returnedToFlag == false) {
				flag = false;
			} else if (returnedFromFlag == false && returnedToFlag == true) {
				flag = false;
			}

			if (isDateTimeEqual(fromDate, inputDate, locale) == true
					|| isDateTimeEqual(inputDate, toDate, locale) == true) {
				returnedEqual = true;
			}

			if (flag || returnedEqual) {
				flag = true;
			}

			return flag;
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * The method validateInputDate is used to check if the input Date is in
	 * between from and to date range. This method is invoked via the DWR.
	 * 
	 * 
	 * @param fromDate :
	 *            The String ,representing the from Date .
	 * @param toDate :
	 *            The String ,representing the to Date .
	 * @param inputDate :
	 *            The String ,representing the input Date, which needs to
	 *            checked if it is in between the from and the todate range.
	 * @param locale :
	 *            The locale based on which the calendar was chosen.
	 * @return boolean : true - if the input date is in between the from Date
	 *         and the to Date range. false - if the input date isn't between
	 *         the from Date and the to Date range.
	 */
	public boolean validateInputDateJS(String fromDate, String toDate,
			String inputDate, String locale) {
		try {
			return validateInputDate(convertStringToDate(fromDate, ""),
					convertStringToDate(toDate, ""), convertStringToDate(
							inputDate, ""), locale);
		} catch (ParseException e) {
			return false;
		} catch (NullPointerException ex) {
			return false;
		}
	}

	/**
	 * The method validateInputDateTime is used to check if the input Date and
	 * Time is in between from and to date range. This method is invoked via the
	 * DWR.
	 * 
	 * 
	 * @param fromDate :
	 *            The String ,representing the from Date and Time.
	 * @param toDate :
	 *            The String ,representing the to Date and Time.
	 * @param inputDate :
	 *            The String ,representing the input Date and Time, which needs
	 *            to checked if it is in between the from and the to date and
	 *            time range.
	 * @param locale :
	 *            The locale based on which the calendar was chosen.
	 * @return boolean : true - if the input date and time is in between the
	 *         from Date Time and the to Date Time range. false - if the input
	 *         date isn't between the from Date Time and the to Date Time range.
	 */
	public boolean validateInputDateTimeJS(String fromDate, String toDate,
			String inputDate, String locale) {
		try {
			return validateInputDateTime(convertStringToDateTime(fromDate, ""),
					convertStringToDateTime(toDate, ""),
					convertStringToDateTime(inputDate, ""), locale);
		} catch (ParseException e) {
			return false;
		} catch (NullPointerException ex) {
			return false;
		}
	}

	/**
	 * This method is used to convert a Date object to String
	 * 
	 * @param date :
	 *            The date which will be formatted to a String.
	 * @return String : The formatted String of the Date.
	 */
	private String convertDateToString(Date date, String pattern) {
		String convertedString = "";
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			convertedString = simpleDateFormat.format(date);
		} catch (Exception e) {
			return null;
		}
		return convertedString;
	}

	/**
	 * This method is used to convert a DateTime object to String
	 * 
	 * @param date :
	 *            The date and time which will be formatted to a String.
	 * @return String : The formatted String of the Date Time.
	 */
	private String convertDateTimeToString(Date date) {
		String convertedString = "";
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					CalendarConstants.DATETIME_PATTERN);
			convertedString = simpleDateFormat.format(date);
		} catch (Exception e) {
			return null;
		}
		return convertedString;
	}

	/**
	 * The convertJodaToUtil method is used convert a joda Date java.util Date
	 * 
	 * @param dateTime :
	 *            The Date to be converted from joda Date java.util Date
	 * @return Date : java.util.Date
	 */
	private static Date convertJodaToUtil(DateTime dateTime) {
		Date date = null;
		/* Convert JODA DateTime to java.util.Date */
		int toDay = dateTime.getDayOfMonth();
		int toMonth = dateTime.getMonthOfYear();
		int toYear = dateTime.getYear();
		int toHour = dateTime.getHourOfDay();
		int toMin = dateTime.getMinuteOfHour();
		int toSec = dateTime.getSecondOfMinute();
		Calendar currentCalendar = null;
		try {
			currentCalendar = Calendar.getInstance();
			currentCalendar.set(toYear, toMonth - 1, toDay, toHour, toMin,
					toSec);
			date = currentCalendar.getTime();
		} catch (Exception e) {
			return null;
		}
		return date;
	}
}
