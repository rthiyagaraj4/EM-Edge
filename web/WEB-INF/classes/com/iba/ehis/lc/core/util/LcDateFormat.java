/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package com.iba.ehis.lc.core.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.iba.framework.core.util.CalendarConstants;
import com.iba.framework.core.util.IBADate;
import com.iba.framework.core.util.IBADateTime;
import com.iba.framework.core.util.IBADateUtil;
import com.iba.framework.core.util.IBADateValidation;
import com.iba.framework.logging.pojo.business.IBALogger;

public class LcDateFormat {    
	private static Log log = LogFactory.getLog(LcDateFormat.class);

	public static IBADateTime getSevendaysBackDate(HttpServletRequest request) {
		IBADateTime date =null;
		IBALogger.getLogger().debug(LcDateFormat.class, "SessionId=============>"+request.getSession().getId(), null);
		java.util.Date localDate=new Date(); 
	    date = new IBADateTime(localDate);

			long seven = 1000 * 60 * 60 * 24 * 7;
			long dayInMsec = System.currentTimeMillis();

			IBADateTime date1 = new IBADateTime(new Date(dayInMsec - seven));

			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);

			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(date);

			cal1.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
			cal1.set(Calendar.MONTH, cal.get(Calendar.MONTH));
			cal1.set(Calendar.YEAR, cal.get(Calendar.YEAR));
			cal1.set(Calendar.HOUR, cal.get(Calendar.HOUR));
			cal1.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
			cal1.set(Calendar.SECOND, cal.get(Calendar.SECOND));

			date = new IBADateTime(cal1.getTime(), request.getSession().getId());
				
		return date;
	}

	public static IBADateTime convertDateFormat(IBADateTime obj,
			HttpServletRequest request) {
		IBADateTime date =null;
		if(request.getSession().getId()!=null){
		 date = new IBADateTime(request.getSession().getId());
		}

		if (obj != null) {
			Calendar cal = Calendar.getInstance();

			cal.setTime(date);
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(obj);
			cal.set(Calendar.DAY_OF_MONTH, cal1.get(Calendar.DAY_OF_MONTH));
			cal.set(Calendar.MONTH, cal1.get(Calendar.MONTH));
			cal.set(Calendar.YEAR, cal1.get(Calendar.YEAR));
			cal.set(Calendar.HOUR, cal1.get(Calendar.HOUR));
			cal.set(Calendar.MINUTE, cal1.get(Calendar.MINUTE));
			cal.set(Calendar.SECOND, cal1.get(Calendar.SECOND));
			date = new IBADateTime(cal.getTime(), request.getSession().getId());

		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			IBADateTime ibadt = new IBADateTime();
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(ibadt);
			cal.set(Calendar.DAY_OF_MONTH, cal1.get(Calendar.DAY_OF_MONTH));
			cal.set(Calendar.MONTH, cal1.get(Calendar.MONTH));
			cal.set(Calendar.YEAR, cal1.get(Calendar.YEAR));
			cal.set(Calendar.HOUR, cal1.get(Calendar.HOUR));
			cal.set(Calendar.MINUTE, cal1.get(Calendar.MINUTE));
			cal.set(Calendar.SECOND, cal1.get(Calendar.SECOND));
			date = new IBADateTime(cal.getTime(), request.getSession().getId());
		}
		return date;
	}

	public String convertToSimple(String oldDate, String pattern,
			HttpServletRequest request) {
		IBADate dt = new IBADateTime();
		IBADate dtNew = new IBADateTime();

		if (oldDate != null) {
			String mask = CalendarConstants.DATETIME_PATTERN;
			try {
				dt = IBADateUtil.convertStringToDate(IBADateTime.class,
						pattern, oldDate);
				Calendar cal1 = Calendar.getInstance();
				Calendar cal = Calendar.getInstance();
				cal1.setTime(dt);
				cal.set(Calendar.DAY_OF_MONTH, cal1.get(Calendar.DAY_OF_MONTH));
				cal.set(Calendar.MONTH, cal1.get(Calendar.MONTH));
				cal.set(Calendar.YEAR, cal1.get(Calendar.YEAR));
				cal.set(Calendar.HOUR, cal1.get(Calendar.HOUR));
				cal.set(Calendar.MINUTE, cal1.get(Calendar.MINUTE));
				cal.set(Calendar.SECOND, cal1.get(Calendar.SECOND));
				dtNew = new IBADateTime(cal.getTime());
				dtNew.setPattern(mask);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		String fdt = dtNew.toString();
		return fdt;
	}

	public String convertToPersonalise(String oldDate,
			HttpServletRequest request) {
		IBADate dt = new IBADateTime();
		IBADate dtNew = new IBADateTime();

		if (oldDate != null) {
			String mask = CalendarConstants.DATETIME_PATTERN;
			try {
				dt = IBADateUtil.convertStringToDate(IBADateTime.class, mask,
						oldDate);
				Calendar cal1 = Calendar.getInstance();
				Calendar cal = Calendar.getInstance();
				cal1.setTime(dt);
				cal.set(Calendar.DAY_OF_MONTH, cal1.get(Calendar.DAY_OF_MONTH));
				cal.set(Calendar.MONTH, cal1.get(Calendar.MONTH));
				cal.set(Calendar.YEAR, cal1.get(Calendar.YEAR));
				cal.set(Calendar.HOUR, cal1.get(Calendar.HOUR));
				cal.set(Calendar.MINUTE, cal1.get(Calendar.MINUTE));
				cal.set(Calendar.SECOND, cal1.get(Calendar.SECOND));
				dtNew = new IBADateTime(cal.getTime(), request.getSession()
						.getId());

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		String fdt = dtNew.toString();
		return fdt;
	}
	public static IBADateTime convertDateToIBADateTime(Date oldDate,
			String sessionId) {
		IBADateTime date =null;
		if(sessionId!=null){
		 date = new IBADateTime(sessionId);
		}

		if (oldDate != null) {
				try {
				Calendar cal1 = Calendar.getInstance();
				Calendar cal = Calendar.getInstance();
				cal1.setTime(oldDate);
				IBALogger.getLogger().debug(LcDateFormat.class, "SessionId======>>", sessionId);
				cal.set(Calendar.DAY_OF_MONTH, cal1.get(Calendar.DAY_OF_MONTH));
				cal.set(Calendar.MONTH, cal1.get(Calendar.MONTH));
				cal.set(Calendar.YEAR, cal1.get(Calendar.YEAR));
				cal.set(Calendar.HOUR, cal1.get(Calendar.HOUR));
				cal.set(Calendar.MINUTE, cal1.get(Calendar.MINUTE));
				cal.set(Calendar.SECOND, cal1.get(Calendar.SECOND));
				date = new IBADateTime(cal.getTime(), sessionId);

			} catch (Exception ex) {ex.printStackTrace();
			
			}
		}
		return date;
		
	}
	public static IBADateTime convertStringToIBADateTime(String strDate,String pattern,
			HttpServletRequest request) {
		IBADateTime date =null;
		if(request.getSession().getId()!=null){
		 date = new IBADateTime(request.getSession().getId());
		}
		IBADate dt = new IBADateTime();
		if (strDate !=null) {
			Calendar cal = Calendar.getInstance();
			try {
				dt = IBADateUtil.convertStringToDate(IBADateTime.class, pattern,
						strDate);
				cal.setTime(date);
				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(dt);
				cal.set(Calendar.DAY_OF_MONTH, cal1.get(Calendar.DAY_OF_MONTH));
				cal.set(Calendar.MONTH, cal1.get(Calendar.MONTH));
				cal.set(Calendar.YEAR, cal1.get(Calendar.YEAR));
				cal.set(Calendar.HOUR, cal1.get(Calendar.HOUR));
				cal.set(Calendar.MINUTE, cal1.get(Calendar.MINUTE));
				cal.set(Calendar.SECOND, cal1.get(Calendar.SECOND));
				date = new IBADateTime(cal.getTime(), request.getSession().getId());
				}catch(Exception s){s.printStackTrace();}

		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			IBADateTime ibadt = new IBADateTime();
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(ibadt);
			cal.set(Calendar.DAY_OF_MONTH, cal1.get(Calendar.DAY_OF_MONTH));
			cal.set(Calendar.MONTH, cal1.get(Calendar.MONTH));
			cal.set(Calendar.YEAR, cal1.get(Calendar.YEAR));
			cal.set(Calendar.HOUR, cal1.get(Calendar.HOUR));
			cal.set(Calendar.MINUTE, cal1.get(Calendar.MINUTE));
			cal.set(Calendar.SECOND, cal1.get(Calendar.SECOND));
			date = new IBADateTime(cal.getTime(), request.getSession().getId());
		}
		return date;
	}
	public static IBADateTime convertToIBADateTime(Date strDate,String pattern) 
	{
		IBADateTime date =null;
		IBADate dt = new IBADateTime();
		if (strDate !=null) {
			Calendar cal = Calendar.getInstance();
			try {
				String str = strDate.toString().substring(0,16);
				IBALogger.getLogger().debug(LcDateFormat.class, "==========================>"+str, null);
				dt = IBADateUtil.convertStringToDate(IBADateTime.class, pattern,str);
			
				cal.setTime(date);
				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(dt);
				cal.set(Calendar.DAY_OF_MONTH, cal1.get(Calendar.DAY_OF_MONTH));
				cal.set(Calendar.MONTH, cal1.get(Calendar.MONTH));
				cal.set(Calendar.YEAR, cal1.get(Calendar.YEAR));
				cal.set(Calendar.HOUR, cal1.get(Calendar.HOUR));
				cal.set(Calendar.MINUTE, cal1.get(Calendar.MINUTE));
				cal.set(Calendar.SECOND, cal1.get(Calendar.SECOND));
				date = new IBADateTime(cal.getTime());
				}catch(Exception s){s.printStackTrace();}

		} 
		return date;
	}
	public String  converteThaiToIBADateTime(String oldDate,String frm,String pattern)
			 {
		String ldate =null;
		IBADateValidation  ibaDateValidation=new IBADateValidation();
		if (oldDate != null) {
			try {
				 ldate = ibaDateValidation.convertDateJS(oldDate,frm,"en",pattern);
				} catch (Exception ex) {ex.printStackTrace();
			
			}
		}
		return ldate;
		
	}
	public String  converteIBADateTimeToThai(String oldDate,String frm,String to,String pattern)
	 {
String ldate =null;
IBADateValidation  ibaDateValidation=new IBADateValidation();
if (oldDate != null) {
	try {
		 ldate = ibaDateValidation.convertDateJS(oldDate,frm,to,pattern);
		} catch (Exception ex) {ex.printStackTrace();
	
	}
}
return ldate;

}
	
}
