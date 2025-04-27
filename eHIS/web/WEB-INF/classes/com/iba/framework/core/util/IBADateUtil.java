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
import java.util.GregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * IBADate Utility Class This is used to convert Strings to Dates and Timestamps
 * 
 * <p>
 * <a href="DateUtil.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * @version $Revision: 1.1 $ $IBADate: 2004/03/31 13:04:17 $
 */
public class IBADateUtil extends BaseUtil {
	private static Log log = LogFactory.getLog(IBADateUtil.class);

	/**
	 * This method attempts to convert an Oracle-formatted date in the form
	 * dd-MMM-yyyy to mm/dd/yyyy.
	 * 
	 * @param aDate
	 *            date from database as a string
	 * @return formatted string for the ui
	 */
	public static final String getDate(IBADate aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(aDate.getPattern());
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 * 
	 * @param type
	 *            TODO
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * 
	 * @return a converted IBADate object
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 */
	public static final IBADate convertStringToDate(Class type, String aMask,
			String strDate) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat(aMask);
		IBADate date = null;
		if (log.isDebugEnabled()) {
			log.debug("converting '" + strDate + "' to date with mask '"
					+ aMask + "'");
		}
		try {
			if (type.getName().equals(IBADate.class.getName()))
				date = new IBADate(df.parse(strDate));
			else if (type.getName().equals(IBADateTime.class.getName()))
				date = new IBADateTime(df.parse(strDate));
			date.setPattern(aMask);
		} catch (ParseException pe) {
			if (log.isDebugEnabled()) {
				log.debug("conversion failed, trying default date format["
						+ aMask + "]");
			}
			df = new SimpleDateFormat(aMask);

			date = new IBADate(df.parse(strDate));

			if (log.isDebugEnabled()) {
				log.debug("formatted date successfully!");
			}
		}

		return (date);
	}

	/**
	 * This method returns the current date time in the format: MM/dd/yyyy HH:MM
	 * a
	 * 
	 * @param theTime
	 *            the current time
	 * @return the current date/time
	 */
	public static String getTimeNow(IBADate theTime) {
		return getDateTime(new IBADateTime().getTimePattern(), theTime);
	}

	/**
	 * This method returns the current date in the format: MM/dd/yyyy
	 * 
	 * @return the current date
	 * @throws ParseException
	 */
	public static Calendar getToday() throws ParseException {
		IBADate today = new IBADate();
		SimpleDateFormat df = new SimpleDateFormat(today.getPattern());

		// This seems like quite a hack (date -> string -> date),
		// but it works ;-)
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		Class type = IBADate.class;
		cal.setTime(convertStringToDate(todayAsString, type));

		return cal;
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 * 
	 * @see java.text.SimpleDateFormat
	 */
	public static final String getDateTime(String aMask, IBADate aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			log.error("aDate is null!");
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	/**
	 * This method generates a string representation of a date based on the
	 * System Property 'dateFormat' in the format you specify on input
	 * 
	 * @param aDate
	 *            A date to convert
	 * @return a string representation of the date
	 */
	public static final String convertDateToString(IBADate aDate) {
		return getDateTime(aDate.getPattern(), aDate);
	}

	/**
	 * This method converts a String to a date using the datePattern
	 * 
	 * @param strDate
	 *            the date to convert (in format MM/dd/yyyy)
	 * @return a date object
	 * 
	 * @throws ParseException
	 */
	public static IBADate convertStringToDate(String strDate, Class type)
			throws ParseException {
		IBADate aDate = null;
		String datePattern = "";
		try {
			if (type.getName().equals(IBADate.class.getName())) {
				datePattern = new IBADate().getPattern();
			} else if (type.getName().equals(IBADateTime.class.getName())) {
				datePattern = new IBADateTime().getPattern();
			}
			if (log.isDebugEnabled()) {
				log.debug("converting date with pattern: " + datePattern);
			}

			aDate = convertStringToDate(type, datePattern, strDate);
		} catch (ParseException pe) {
			log.error("Could not convert '" + strDate
					+ "' to a date, throwing exception");
			pe.printStackTrace();
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return aDate;
	}
}
