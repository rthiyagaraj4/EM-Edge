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

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.IslamicChronology;
import org.joda.time.chrono.JulianChronology;

public class UserDateTimeZone {
	/*
	 * Constructor
	 */
	public UserDateTimeZone() {
	}

	/*
	 * DateTime Based on Chronology
	 */
	public Date getDateTimeFromCalendar(Date dateTime, int calendar) {

		/*
		 * Convert to Joda Calendar
		 */
		DateTime calendarTime = new DateTime(dateTime);

		switch (calendar) {

		/*
		 * GregorianChronology
		 */
		case 0:
			calendarTime = calendarTime.withChronology(GregorianChronology
					.getInstance());
			break;
		/*
		 * BuddhistChronology
		 */
		case 1:
			calendarTime = calendarTime.withChronology(BuddhistChronology
					.getInstance());
			break;
		/*
		 * CopticChronology
		 */
		case 2:
			calendarTime = calendarTime.withChronology(CopticChronology
					.getInstance());
			break;
		/*
		 * IslamicChronology
		 */
		case 3:
			calendarTime = calendarTime.withChronology(IslamicChronology
					.getInstance());
			break;

		/*
		 * JulianChronology
		 */
		case 4:
			calendarTime = calendarTime.withChronology(JulianChronology
					.getInstance());
			break;

		/*
		 * ISOChronology
		 */
		default:
			calendarTime = calendarTime.withChronology(ISOChronology
					.getInstance());
			break;

		}

		/* Convert JODA DateTime to java.util.Date */
		int day = calendarTime.getDayOfMonth();
		int month = calendarTime.getMonthOfYear();
		int year = calendarTime.getYear();
		int hour = calendarTime.getHourOfDay();
		int min = calendarTime.getMinuteOfHour();
		int sec = calendarTime.getSecondOfDay();

		try {

			Calendar calc = Calendar.getInstance();
			calc.set(year, month - 1, day + 1, hour, min, sec);

			dateTime = calc.getTime();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("The date according to  new Calendar is" + dateTime);

		return dateTime;
	}

	/*
	 * Get Server Date Time
	 * 
	 */
	public Date getServerDateTime() {
		/*
		 * Get the server TimeZoneId From Cache
		 * 
		 */
		String serverZoneId = "Europe/London";

		/*
		 * Get the server DateFormat From Cache
		 */

		String serverDateFormat = "M/d/yyyy";

		/*
		 * Get the server TimeFormat From Cache
		 */

		String serverTimeFormat = "hh:mm:ss";

		/*
		 * Get server date and time
		 */

		Date date = new Date();

		/*
		 * Get calendar from cache
		 * 
		 */
		int chosenCalendar = Constants.ISO_CHRONOLOGY;
		date = getDateTimeFromCalendar(date, chosenCalendar);

		System.out
				.println("Server Date Time according to asia/Calcutta Zone and Tomcat Server Time... .."
						+ date);

		/*
		 * Convert java.util.Date to JODA date
		 */
		DateTime dateTime = new DateTime(date);

		/*
		 * Return Date
		 */
		Date serverDateTime = null;

		/*
		 * DateTime in Server Zone
		 */
		dateTime = dateTime.withZone(DateTimeZone.forID(serverZoneId));

		/* Convert JODA DateTime to java.util.Date */
		int day = dateTime.getDayOfMonth();
		int month = dateTime.getMonthOfYear();
		int year = dateTime.getYear();
		int hour = dateTime.getHourOfDay();
		int min = dateTime.getMinuteOfHour();
		int sec = dateTime.getSecondOfMinute();

		try {
			Calendar calendar = Calendar.getInstance();
			calendar.set(year, month - 1, day, hour, min, sec);
			serverDateTime = calendar.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Converted to Europe/London Server Time  "
				+ serverDateTime);

		/*
		 * UnComment to get the Asia/Calcutta time
		 * 
		 * String clientZoneId = "Asia/Calcutta"; serverTime =
		 * serverTime.withZone(DateTimeZone.forID(clientZoneId));
		 * System.out.println("joda client datetime" + serverTime);
		 */

		return serverDateTime;
	}

	/*
	 * The Client Time is returned based on System Settings The HashMap
	 * attribute is a temporary arrangement,the values will be fetched from the
	 * cache
	 * 
	 * 
	 */

	public String getClientDateTime(Date dateTime) {

		/*
		 * Get calendar from cache
		 * 
		 */
		int chosenCalendar = Constants.ISO_CHRONOLOGY;
		dateTime = getDateTimeFromCalendar(dateTime, chosenCalendar);
		/*
		 * Get ClientDateFormat from cache
		 * 
		 */
		String clientDateFormat = "M/d/yyyy";

		/*
		 * Get ClientTimeFormat from cache
		 * 
		 */
		String clientTimeFormat = "hh:mm:ss";

		/*
		 * Get ClientTimeZoneId from cache
		 * 
		 */
		String zoneId = "Asia/Calcutta";

		/*
		 * Parser
		 */
		String dateTimeParser = "";

		Date clientDateTime = null;

		/*
		 * Convert java.util.Date to JODA Date
		 */
		DateTime jodaTime = new DateTime(dateTime);

		/*
		 * Convert Server Time to Client Time
		 */
		DateTime zoneTime = jodaTime.withZone(DateTimeZone.forID(zoneId));

		/* Convert JODA DateTime to java.util.Date */
		int day = zoneTime.getDayOfMonth();
		int month = zoneTime.getMonthOfYear();
		int year = zoneTime.getYear();
		int hour = zoneTime.getHourOfDay();
		int min = zoneTime.getMinuteOfHour();
		int sec = zoneTime.getSecondOfMinute();

		try {
			Calendar calendar = Calendar.getInstance();
			calendar.set(year, month - 1, day, hour, min, sec);
			clientDateTime = calendar.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				clientDateFormat + " " + clientTimeFormat);

		String returnClientDateTime = simpleDateFormat.format(clientDateTime);

		System.out.println("returnClientDateTime ....." + returnClientDateTime);

		return returnClientDateTime;
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
	public Date convertStringToDate(String strDate) throws ParseException {
		/*
		 * Get ClientTimeFormat from cache
		 * 
		 */
		String timePattern = "MM/dd/yyyy hh:mm:ss";

		Date aDate = null;

		try {

			aDate = convertStringToDate(timePattern, strDate);

			System.out.println("String Date " + strDate);
		} catch (ParseException pe) {

			pe.printStackTrace();
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return aDate;
	}

	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @see java.text.SimpleDateFormat
	 * @throws ParseException
	 */
	public Date convertStringToDate(String aMask, String strDate)
			throws ParseException {
		String dateTimePattern = "M/d/yyyy HH:mm";

		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(aMask);

		try {
			System.out.println("From Date util DAte String:" + strDate
					+ ". aMask:" + aMask);
			date = df.parse(strDate);
			System.out.println("From Date util DAte object:" + date.toString());
		} catch (ParseException pe) {

			df = new SimpleDateFormat(dateTimePattern);

			try {
				date = df.parse(strDate);
			} catch (ParseException pe2) {
				throw new ParseException(pe2.getMessage(), pe2.getErrorOffset());
			}

		}

		return (date);
	}

	public static void main(String args[]) {
		UserDateTimeZone user = new UserDateTimeZone();

		Date d = new Date();
		System.out.println("Server Date..." + d);
		user.getDateTimeFromCalendar(d, Constants.BUDDHIST_CHRONOLOGY);
		user.getServerDateTime();
		user.getClientDateTime(d);
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.set(1979, 2, 21, 19, 22, 3);
			Date clientDateTime = calendar.getTime();
			user.getClientDateTime(clientDateTime);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
