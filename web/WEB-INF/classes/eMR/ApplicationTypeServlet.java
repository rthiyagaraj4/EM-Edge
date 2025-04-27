/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eCommon.XSSRequestWrapper;

public class ApplicationTypeServlet extends HttpServlet
{

    PrintWriter out;
    Properties p;
    String High_Risk;
    String longDesc;
    String shortDesc;
    String effectiveStatus;
	String duration_days; // added by mujafar for ML-MMOH-CRF-0704
	String holiday_duration_applicable;
    String facilityId;
    String client_ip_address;

	//Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292
	String report_type; 

    HttpSession session;
    SimpleDateFormat dateFormat;

	public ApplicationTypeServlet()
    {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
    }

    public synchronized void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        session = httpservletrequest.getSession(false);
        facilityId = (String)session.getValue("facility_id");
        p = (Properties)session.getValue("jdbc");
        client_ip_address = p.getProperty("client_ip_address");
        try
        {
			httpservletrequest.setCharacterEncoding("UTF-8");
			httpservletresponse.setContentType("text/html;charset=UTF-8");
			
			httpservletrequest= new XSSRequestWrapper(httpservletrequest);
			httpservletresponse.addHeader("X-XSS-Protection", "1; mode=block");
			httpservletresponse.addHeader("X-Content-Type-Options", "nosniff");
			
            out = httpservletresponse.getWriter();
            String s = httpservletrequest.getParameter("function");
            if(s.equals("insert"))
                insertHighRisk(httpservletrequest, httpservletresponse);
            if(s.equals("modify"))
                modifyHighRisk(httpservletrequest, httpservletresponse);
        }
        catch(Exception exception)
        {
            //out.println(exception.toString());
			exception.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        try
        {
            out = httpservletresponse.getWriter();
			httpservletrequest.setCharacterEncoding("UTF-8");
			httpservletresponse.setContentType("text/html;charset=UTF-8");
			
			httpservletrequest= new XSSRequestWrapper(httpservletrequest);
			httpservletresponse.addHeader("X-XSS-Protection", "1; mode=block");
			httpservletresponse.addHeader("X-Content-Type-Options", "nosniff");
			
			out = httpservletresponse.getWriter();
            String s = httpservletrequest.getParameter("function");
            if(s.equals("insert"))
                insertHighRisk(httpservletrequest, httpservletresponse);
            if(s.equals("modify"))
                modifyHighRisk(httpservletrequest, httpservletresponse);
        }
        catch(Exception exception) { /* out.println(exception.toString()); */ exception.printStackTrace();}
    }

    private void modifyHighRisk(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
            High_Risk = httpservletrequest.getParameter("high_risk_code");
            longDesc = httpservletrequest.getParameter("long_desc");
            shortDesc = httpservletrequest.getParameter("short_desc");
            effectiveStatus = httpservletrequest.getParameter("eff_status");
			holiday_duration_applicable = httpservletrequest.getParameter("holiday_duration_applicable");
			if(holiday_duration_applicable.equals("true"))
			duration_days = httpservletrequest.getParameter("duration_days");
            if(effectiveStatus == null)
                effectiveStatus = "D";

			//Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292
			report_type = checkForNull(httpservletrequest.getParameter("report_type"));

            String s = p.getProperty("login_user");
            String s1 = dateFormat.format(new Date());
            String s2 = s;
            String s3 = s1;
            String s4 = facilityId;
            String s5 = s4;
            String s6 = client_ip_address;
            String s7 = s6;

			java.sql.Date date1 = java.sql.Date.valueOf(s3);
            
			HashMap hashtable = new HashMap();
            hashtable.put("long_desc", longDesc);
            hashtable.put("short_desc", shortDesc);
            hashtable.put("eff_status", effectiveStatus);
			if(holiday_duration_applicable.equals("true"))
			hashtable.put("holiday_duration",duration_days);
            hashtable.put("added_by_id", s);
            hashtable.put("modified_by_id", s2);
            hashtable.put("modified_date", date1);
            hashtable.put("modified_facility_id", s5);
            hashtable.put("modified_at_ws_no", s7);
			//Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292
			hashtable.put("report_type", report_type); 
  
			HashMap hashtable1 = new HashMap();
            hashtable1.put(" APPL_TYPE_CODE ", High_Risk);

			String tableName = "MR_APPL_TYPE";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = hashtable;
			argArray[2] = hashtable1;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = hashtable.getClass();
			paramArray[2] = hashtable1.getClass();
			paramArray[3] = tableName.getClass();

			HashMap hashtable2 = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			boolean flag = ((Boolean)hashtable2.get("status")).booleanValue();
            String s8 = (String)hashtable2.get("error");
            String s9 = "0";
            if(flag)
                s9 = "1";
            else
                s8 = (String)hashtable2.get("error");
            s8 = (String)hashtable2.get("error");
            httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s8,"UTF-8") + "&err_value=" + s9);

			if (hashtable2 != null) hashtable2.clear();		
			if (hashtable1 != null) hashtable1.clear();		
			if (hashtable != null) hashtable.clear();		

        }
        catch(Exception exception)
        {
          /*   out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            out.println("Values sent are : <br>");
			if(holiday_duration_applicable.equals("true"))
            out.println(High_Risk + " " + longDesc + " " + shortDesc + " " + effectiveStatus + " " + duration_days);
			else
			out.println(High_Risk + " " + longDesc + " " + shortDesc + " " + effectiveStatus);	 */
		
		exception.printStackTrace();
        }
    }

    private void insertHighRisk(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
            High_Risk = httpservletrequest.getParameter("high_risk_code");
            longDesc = httpservletrequest.getParameter("long_desc");
            shortDesc = httpservletrequest.getParameter("short_desc");
            effectiveStatus = httpservletrequest.getParameter("eff_status");
			holiday_duration_applicable = httpservletrequest.getParameter("holiday_duration_applicable");
			
			if(holiday_duration_applicable.equals("true"))
			duration_days = httpservletrequest.getParameter("duration_days");
            if(effectiveStatus == null)
                effectiveStatus = "D";

			//Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292
			report_type = checkForNull(httpservletrequest.getParameter("report_type"));

            String s = p.getProperty("login_user");
            String s1 = dateFormat.format(new Date());
            String s2 = s;
            String s3 = s1;
            String s4 = facilityId;
            String s5 = s4;
            String s6 = client_ip_address;
            String s7 = s6;
           
			java.sql.Date date = java.sql.Date.valueOf(s1);
            java.sql.Date date1 = java.sql.Date.valueOf(s3);
            
			HashMap hashtable = new HashMap();
            hashtable.put("APPL_TYPE_CODE", High_Risk);
            hashtable.put("long_desc", longDesc);
            hashtable.put("short_desc", shortDesc);
            hashtable.put("eff_status", effectiveStatus);
			if(holiday_duration_applicable.equals("true"))
			hashtable.put("holiday_duration",duration_days);
            hashtable.put("added_by_id", s);
            hashtable.put("added_date", date);
            hashtable.put("added_facility_id", facilityId);
            hashtable.put("added_at_ws_no", s6);
            hashtable.put("modified_by_id", s2);
            hashtable.put("modified_date", date1);
            hashtable.put("modified_facility_id", s5);
            hashtable.put("modified_at_ws_no", s7);
			//Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292
			hashtable.put("report_type", report_type); 
            
			String as[] = {"APPL_TYPE_CODE"};

			String tableName = "MR_APPL_TYPE";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = hashtable;
			argArray[2] = as;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = hashtable.getClass();
			paramArray[2] = as.getClass();
			paramArray[3] = tableName.getClass();

			HashMap hashtable1 = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			boolean flag = ((Boolean)hashtable1.get("status")).booleanValue();
            String s8 = (String)hashtable1.get("error");
            String s9 = "0";
            if(flag)
                s9 = "1";
            else
                s8 = (String)hashtable1.get("error");
            
			s8 = (String)hashtable1.get("error");
            httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s8,"UTF-8") + "&err_value=" + s9);

			if (hashtable1 != null) hashtable1.clear();		
			if (hashtable != null) hashtable.clear();		

        }
        catch(Exception exception)
        {
            /* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            out.println("Values sent are : <br>");
           
			if(holiday_duration_applicable.equals("true"))
            out.println(High_Risk + " " + longDesc + " " + shortDesc + " " + effectiveStatus + " " + duration_days);
			else
			out.println(High_Risk + " " + longDesc + " " + shortDesc + " " + effectiveStatus); */	
        exception.printStackTrace();
		}
    }

	public static String checkForNull(String inputString)
	{
		return( ( (inputString == null) || (inputString.equals("null") ) ) ? "" : inputString);
	}  
}
