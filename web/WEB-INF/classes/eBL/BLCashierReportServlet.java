/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;
import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;

//import oracle.aurora.jndi.sess_iiop.ServiceCtx ;

public class BLCashierReportServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		String login_user="";
		String facility_id = "";
		String cashcounter = "";
		String log_rep_success_mes="";
		String operator ="";
		java.util.Properties p = null;
		String locale ="";

		String login_time = "0";
		HttpSession session = req.getSession(false);

		//Parameters for the Cancel Amount, Actual, Discrepancy amount
		String report_id = "BLR00003";
		String module_id = "BL";
		out = res.getWriter();
        out.println("<html><head><script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script></head></html>");
		
		out.println("<html>");
		out.println("<head>");
		
		try
		{	
				facility_id = (String)session.getAttribute("facility_id");
				System.err.println("67,facility_id-->"+facility_id);
				p = (java.util.Properties) session.getAttribute("jdbc");				
				login_user = p.getProperty("login_user");
				System.err.println("70,login_user-->"+login_user);

				cashcounter = req.getParameter("cashcounter_code");
				operator = req.getParameter("operator_id");				
				System.err.println("75,operator-->"+operator);
				login_time = req.getParameter("login_time");
				locale = req.getParameter("locale");//NMC-JD-SCF-0046				
				
				log_rep_success_mes=req.getParameter("log_rep_success_mes");
				//logout_time = req.getParameter("logout_time");
				String temp_login_time = login_time.substring(0,10) + (login_time.substring(11));
				int intTempIndex = 0;
				
				while (true)
				{
					intTempIndex = temp_login_time.indexOf(":");
					if (intTempIndex <=0)
					{
						break;
					}
					temp_login_time = temp_login_time.substring(0,intTempIndex) + temp_login_time.substring(intTempIndex+1);
				}
				
				out.println("<script> alert('"+log_rep_success_mes+"'); parent.messageFrame.location.href='../eCommon/jsp/error.jsp';  parent.bl_cashier_report.location.href='../eBL/jsp/BLCashierReport.jsp';  </script>");			

				OnlineReport onlinereportParam = new OnlineReport(facility_id, module_id, report_id);
				onlinereportParam.addParameter("p_opr_facility_id",facility_id);
				//onlinereportParam.addParameter("p_facility_id",facility_id);
				onlinereportParam.addParameter("P_FACILITY_ID",facility_id);
				System.err.println("facility_id--"+facility_id);
				onlinereportParam.addParameter("p_operator",operator);
				System.err.println("operator--"+operator);
				onlinereportParam.addParameter("p_report_id",report_id);
				System.err.println("report_id--"+report_id);
				onlinereportParam.addParameter("p_cash_counter_code",cashcounter);
				System.err.println("cashcounter--"+cashcounter);
				//onlinereportParam.addParameter("p_cash_counter_user_id",login_user);
				onlinereportParam.addParameter("p_cash_counter_user_id",operator);
				System.err.println("p_cash_counter_user_id--"+operator);
				onlinereportParam.addParameter("p_login_date_time",temp_login_time);
				System.err.println("p_login_date_time--"+temp_login_time);
				onlinereportParam.addParameter("p_module",module_id);
				System.err.println("module_id--"+module_id);
				onlinereportParam.addParameter("p_language_id",locale);
				System.err.println("locale--"+locale);
				OnlineReports onlinereports = new OnlineReports();
				onlinereports.add(onlinereportParam);
				System.err.println("onlinereports-->"+onlinereportParam+"-->onlinereports-->"+onlinereports);
				String strResults =  onlinereports.execute(req, res);//NMC-JD-SCF-0046
				onlinereportParam = null;
				onlinereports = null; 
				System.err.println("BLCashierReportServlet.java ==strResults==>"+strResults);
				out.println("</head>");
				out.println("</html>");
		}
		catch(Exception e)
		{
			out.println("BLCashierReportServlet Error==="+e);
			e.printStackTrace();
		}
	}	
}
