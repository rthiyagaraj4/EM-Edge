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
package eIPAD.clinicaleventhistory.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eIPAD.IPADConstants;

/**
 * @author GRamamoorthy
 *
 */
public class EncounterPeriodServlet extends HttpServlet implements Servlet {

	public static final String DATE_FORMAT_STRING = "d-MMM-yyyy HH.m";
	
	/**
	 * 
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		String timePeriod = req.getParameter("timeperiod");
		String dateType = req.getParameter("datetype");
		
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_STRING);
		Calendar cal = Calendar.getInstance();
		String dateAsString = "";
		
		if("To".equals(dateType)){
			dateAsString = formatter.format(cal.getTime());
		}else{
			if(IPADConstants.LAST_ONE_DAY.equals(timePeriod)){
				cal.add(Calendar.DATE, -1);
			}else if(IPADConstants.LAST_THREE_DAYS.equals(timePeriod)){
				cal.add(Calendar.DATE, -3);
			}else if(IPADConstants.LAST_ONE_WEEK.equals(timePeriod)){
				cal.add(Calendar.WEEK_OF_YEAR, -1);
			}else if(IPADConstants.LAST_ONE_MONTH.equals(timePeriod)){
				cal.add(Calendar.MONTH, -1);
			}else if(IPADConstants.LAST_ONE_YEAR.equals(timePeriod)){
				cal.add(Calendar.YEAR, -1);
			}else if(IPADConstants.LAST_TWO_YEARS.equals(timePeriod)){
				cal.add(Calendar.YEAR, -2);
			}
			dateAsString = formatter.format(cal.getTime());
		}
		
		resp.getWriter().write(dateAsString);
	}

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	
	
}
