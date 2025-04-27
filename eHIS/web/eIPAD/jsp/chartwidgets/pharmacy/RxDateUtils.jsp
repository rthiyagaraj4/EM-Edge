<!DOCTYPE html>
<%--
Copyright 1999-2015,Computer Sciences Corporation. All rights reserved. 
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="com.ehis.util.*" contentType="text/plain"%>
<%!
	/**
	 * Method to convert date
	 *  
	 * @param date Date string to be formatted
	 * @param format Input and onput formats
	 * @param from From locale 
	 * @param to To locale
	 * @return Date String after conversion
	 * 
	 */
	public static String convertDate(String date, String format, String from, String to) {
		return DateUtils.convertDate(date,format, from,to);
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
		return DateUtils.getCurrentDate(format, locale) ;
	}
	
	/**
	 * Method to check if the given date is valid in the supplied format and locale
	 * 
	 * @param date Date which should be validated
	 * @param format Applicable Date Format
	 * @param locale Applicable date locale
	 * @return true if the date is valid, false otherwise
	 * @throws DateFormatException If unable to parse the date
	 */
	public static boolean validDate(String date, String format, String locale){
		boolean validDate = false;
		try{
			validDate = DateUtils.validDate(date, format, locale);
		}catch(Exception exc){
			exc.printStackTrace();
		}
		return validDate;
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
	public static boolean isBefore(String fromDate, String toDate, String format, String locale) {		
		return  DateUtils.isBefore(fromDate, toDate, format, locale);
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
		return DateUtils.isBeforeNow(currDate, format, locale);
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
		return DateUtils.isAfterNow(currDate, format, locale);
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
	public static boolean isAfter(String fromDate, String toDate, String format, String locale) {
		return DateUtils.isAfter(fromDate, toDate, format, locale);
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
	public static boolean isBetween(String fromDate, String toDate, String currDate, String format, String locale) {
		return DateUtils.isBetween(fromDate, toDate, currDate, format, locale);
	}
	
	/**
	 * Method for getting the day of month for a Date(1-31)
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support day should be uaed)
	 * @param locale Date Locale
	 * @return day of month (between 1 and 31), 0 for error 
	 */
	public static int getDayOfMonth(String currDate, String format, String locale) {
		return DateUtils.getDayOfMonth(currDate, format, locale);
	}
	
	/**
	 * Method for getting the day of the week for a Date (1-7) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for Day should be used)
	 * @param locale Date Locale
	 * @return day of week (between 1 and 7), 0 for error 
	 */
	public static int getDayOfWeek(String currDate, String format, String locale) {
		return  DateUtils.getDayOfWeek(currDate,  format,  locale) ;
	}
	
	/**
	 * Method for getting the day of the week as Long Text for a Date (Sunday - Saturday) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for Day should be used)
	 * @param locale Date Locale
	 * @return day of week (between Sunday and Saturday), empty for error 
	 */
	public static String getDayOfWeekAsLongText(String currDate, String format, String locale) {
		return DateUtils.getDayOfWeekAsLongText(currDate, format, locale);
	}
	
	/**
	 * Method for getting the day of the week as Short Text for a Date (Sun - Sat) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for Day should be used)
	 * @param locale Date Locale
	 * @return day of week (between Sun and Sat), empty for error 
	 */
	public static String getDayOfWeekAsShortText(String currDate, String format, String locale) {
		return DateUtils.getDayOfWeekAsShortText( currDate, format, locale);
	}
	
	/**
	 * Method for getting the month of the year for a Date (1-12) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for month should be used)
	 * @param locale Date Locale
	 * @return month of year (between 1 and 12), 0 for error 
	 */
	public static int getMonthOfYear(String currDate, String format, String locale) {
		return DateUtils.getMonthOfYear(currDate, format, locale);
	}
	
	/**
	 * Method for getting the month of the year as Long Text for a Date (January - December) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for month should be used)
	 * @param locale Date Locale
	 * @return month of year (between January and December), empty for error 
	 */
	public static String getMonthOfYearAsLongText(String currDate, String format, String locale) {
		return DateUtils.getMonthOfYearAsLongText(currDate, format, locale);
	}
	
	/**
	 * Method for getting the month of the year as Short Text for a Date (Jan - Dec) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for month should be used)
	 * @param locale Date Locale
	 * @return month of year (between Jan and Dec), empty for error 
	 */
	public static String getMonthOfYearAsShortText(String currDate, String format, String locale) {
		return DateUtils.getMonthOfYearAsShortText(currDate, format, locale);
	}
	
	
	/**
	 * Method for getting year (yyyy) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for year should be used)
	 * @param locale Date Locale
	 * @return year (yyyy), 0 for error 
	 */
	 public static int getYear(String currDate, String format, String locale) {
		return DateUtils.getYear(currDate, format, locale);
	}
	
	/**
	 * Method for getting hour of the day (1-24) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for hour should be used)
	 * @param locale Date Locale
	 * @return hour (1-24), 0 for error 
	 */
	public static int getHourOfDay(String currDate, String format, String locale) {
		return DateUtils.getHourOfDay(currDate, format, locale); 
	}
	
	/**
	 * Method for getting minute of the hour (1-60) 
	 *
	 * @param currDate the input Date string 
	 * @param format Date Format (appropriate format with support for minute should be used)
	 * @param locale Date Locale
	 * @return hour (1-60), 0 for error 
	 */
	public static int getMinuteOfHour(String currDate, String format, String locale) {
		return DateUtils.getMinuteOfHour(currDate, format, locale);
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
	 public static String minusDate(String currDate, String format, String locale, int value, String interval) {
		return DateUtils.minusDate(currDate, format, locale, value, interval);
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
	public static String plusDate(String currDate, String format, String locale, int value, String interval) {
		return DateUtils.plusDate(currDate, format, locale, value, interval); 
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
	public static int daysBetween(String fromDate, String toDate, String format, String locale){
		return DateUtils.daysBetween(fromDate,toDate,format,locale);
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
	public static int weeksBetween(String fromDate, String toDate, String format, String locale){
		return DateUtils.weeksBetween(fromDate,toDate,format,locale);
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
	public static int monthsBetween(String fromDate, String toDate, String format, String locale){
		return DateUtils.monthsBetween(fromDate,toDate,format,locale);
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
	public static int yearsBetween(String fromDate, String toDate, String format, String locale){
		return DateUtils.yearsBetween(fromDate,toDate,format,locale);
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
	public static int hoursBetween(String fromDate, String toDate, String format, String locale){
		return DateUtils.hoursBetween(fromDate,toDate,format,locale);
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
	public static int minutesBetween(String fromDate, String toDate, String format, String locale){
		return DateUtils.minutesBetween(fromDate,toDate,format,locale);
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
	public static int secondsBetween(String fromDate, String toDate, String format, String locale){
		return DateUtils.secondsBetween(fromDate,toDate,format,locale);
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
	public static String durationBetween(String fromDate, String toDate, String format, String locale){
		return DateUtils.durationBetween(fromDate,toDate,format,locale);
	}	
	
	/**
	 * Method to get the days in a particular month
	 * @param date Date String to be parsed
	 * @param format Date input format
	 * @param locale Date input locale
	 * @return Maximim days in the given Dats's month, zero if an error occurs
	 */
	public static int getDaysInMonth(String date, String format, String locale ){
		return DateUtils.getDaysInMonth(date,format,locale);
	}
	
	/**
	 * Method to check if a given year is a leap year
	 * @param date Date String from which the year will be taken 
	 * @param format Date input format
	 * @param locale Date input locale
	 * @return true if it is a leap year, false otherwise
	 */
	public static boolean isLeapYear(String date, String format, String locale ){
		return DateUtils.isLeapYear(date,format,locale);
	}
	
	/**
	 * Method to convert date from one format to another 
	 * @param date Date string to be converted
	 * @param fromFormat Date input format
	 * @param toFormat Date output format
	 * @param locale Date input locale
	 * @return Date String converted to the output format, empty string if error 
	 */
	public static String formatDate(String date, String fromFormat, String toFormat, String locale){
		return DateUtils.formatDate(date, fromFormat, toFormat, locale);
	}
%>
<%
	String methodName = request.getParameter("methodName");
	methodName = (methodName==null)?"":methodName;
	methodName = methodName.toUpperCase();
	String format = request.getParameter("format");
	format = (format==null)?"":format;
	String fromLocale = request.getParameter("fromLocale");
	fromLocale = (fromLocale==null)?"":fromLocale;
	String toLocale = request.getParameter("toLocale");
	toLocale = (toLocale==null)?"":toLocale;
	String date = request.getParameter("date");
	date = (date==null)?"":date;
	String fromDate = request.getParameter("fromDate");
	fromDate = (fromDate==null)?"":fromDate;
	String toDate = request.getParameter("toDate");
	toDate = (toDate==null)?"":toDate;
	String currDate = request.getParameter("currDate");
	currDate = (currDate==null)?"":currDate;
	String locale = request.getParameter("locale");
	locale = (locale==null)?"":locale;

	String value = request.getParameter("value");
	value = (value==null)?"":value;
	int val = 0;
	if (!value.equals("")) val = Integer.parseInt(value);
	String interval = request.getParameter("interval");
	interval = (interval==null)?"":interval;

	String fromFormat = request.getParameter("fromFormat");
	fromFormat = (fromFormat==null)?"":fromFormat;
	String toFormat = request.getParameter("toFormat");
	toFormat = (toFormat==null)?"":toFormat;
	
	if(methodName.equals("VALIDDATE")){
		 out.print(validDate(date, format, locale));
	}else if(methodName.equals("ISBEFORE")){
		out.print(isBefore(fromDate, toDate, format, locale));
	}else if(methodName.equals("ISAFTER")){
		out.print(isAfter(fromDate, toDate, format, locale));
	}else if(methodName.equals("DAYSBETWEEN")){
		out.print(daysBetween(fromDate,toDate,format,locale));
	}else if(methodName.equals("HOURSBETWEEN")){
		out.print(hoursBetween(fromDate,toDate,format,locale));
	}else if(methodName.equals("MINUTESBETWEEN")){
		out.print(minutesBetween(fromDate,toDate,format,locale));
	}	
%>
