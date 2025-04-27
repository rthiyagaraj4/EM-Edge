/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Last Modified Date Time 9/22/2005 11:18 AM *****/
package eMP;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;
import eCommon.SingleTabHandler.SingleTabHandlerManagerRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FileTypeServlet extends HttpServlet
{
	String p_outpatient_chk = "";	
	String p_inpatient_chk  = "";
	String p_daycare_chk    = "";
	String p_emergency_chk  = "";
	  
    PrintWriter out;
    Properties p;
    String facilityid;
    String filetypecode;
    String longDesc;
    String shortDesc;
    String effectiveStatus;
    String facilityId;
    String client_ip_address;
    
    HttpSession session;
    SimpleDateFormat dateFormat;

    public FileTypeServlet()
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
		this.facilityId = (String) session.getValue("facility_id" ) ;

        p = (Properties)session.getValue("jdbc");
        client_ip_address = p.getProperty("client_ip_address");
        try
        {
			httpservletrequest.setCharacterEncoding("UTF-8");
			httpservletresponse.setContentType("text/html;charset=UTF-8");
            out = httpservletresponse.getWriter();
            String s = httpservletrequest.getParameter("function");
			
           
			if(s.equals("insert"))
                insertFileType(httpservletrequest, httpservletresponse);
            if(s.equals("modify"))
                modifyFileType(httpservletrequest, httpservletresponse);
				
        }
        catch(Exception exception)
        {
            out.println(exception.toString());
        }
    }

private void insertFileType(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
            facilityid = httpservletrequest.getParameter("facility_id");
            filetypecode = httpservletrequest.getParameter("file_type_code");
            longDesc = httpservletrequest.getParameter("file_type_long_desc");
            shortDesc = httpservletrequest.getParameter("file_type_short_desc");
            effectiveStatus = httpservletrequest.getParameter("eff_status");

            p_outpatient_chk 	= httpservletrequest.getParameter("outpatient_chk")==null?"N":httpservletrequest.getParameter("outpatient_chk");
            p_inpatient_chk		= httpservletrequest.getParameter("inpatient_chk")==null?"N":httpservletrequest.getParameter("inpatient_chk");
            p_daycare_chk		= httpservletrequest.getParameter("daycare_chk")==null ? "N":httpservletrequest.getParameter("daycare_chk");
            p_emergency_chk		= httpservletrequest.getParameter("emergency_chk")==null?"N":httpservletrequest.getParameter("emergency_chk");

			if(effectiveStatus == null)
                effectiveStatus = "D";

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
            hashtable.put("facility_id",	facilityid);
            hashtable.put("file_type_code", filetypecode);
            hashtable.put("long_desc",		longDesc);
            hashtable.put("short_desc",		shortDesc);
            hashtable.put("eff_status",		effectiveStatus);

            hashtable.put("APPL_TO_OP",		p_outpatient_chk);
            hashtable.put("APPL_TO_IP",		p_inpatient_chk);
            hashtable.put("APPL_TO_EM",		p_emergency_chk);
            hashtable.put("APPL_TO_DC",		p_daycare_chk);

            hashtable.put("added_by_id", s);
            hashtable.put("added_date", date);
            hashtable.put("added_facility_id", facilityId);
            hashtable.put("added_at_ws_no", s6);
            hashtable.put("modified_by_id", s2);
            hashtable.put("modified_date", date1);
            hashtable.put("modified_facility_id", s5);
            hashtable.put("modified_at_ws_no", s7);
            String condflds[] = {
                "facility_id", "file_type_code"
            };
            boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = hashtable;
			argArray[2] = condflds;
			argArray[3] = "MR_FILE_TYPE";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = hashtable.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
            boolean flag = ((Boolean)results.get("status")).booleanValue();
            String s8 = (String)results.get("error");
			 String s9 = (String)results.get("error");
			hashtable.clear();
			results.clear();
            if(flag)
            {
                String s11 = "1";
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s8, "UTF-8") + "&err_value=" + s11);
            } else
            {
               
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s9, "UTF-8"));
            }
			
        }
        catch(Exception exception)
        {
           // out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
           // out.println("Values sent are : <br>");
           // out.println(facilityid + " " + filetypecode + "  " + longDesc + " " + shortDesc + " " + effectiveStatus);
        	exception.printStackTrace(); // modified by lakshmanan for security issue ID 169515941 on 21-08-2023
        }
    }


    private void modifyFileType(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
      try
        {
            facilityid = httpservletrequest.getParameter("facility_id");
            filetypecode = httpservletrequest.getParameter("file_type_code");
            longDesc = httpservletrequest.getParameter("file_type_long_desc");
            shortDesc = httpservletrequest.getParameter("file_type_short_desc");
            effectiveStatus = httpservletrequest.getParameter("eff_status");
			
			p_outpatient_chk 	= httpservletrequest.getParameter("outpatient_chk")==null?"N":httpservletrequest.getParameter("outpatient_chk");
            p_inpatient_chk		= httpservletrequest.getParameter("inpatient_chk")==null?"N":httpservletrequest.getParameter("inpatient_chk");
            p_daycare_chk		= httpservletrequest.getParameter("daycare_chk")==null ? "N":httpservletrequest.getParameter("daycare_chk");
            p_emergency_chk		= httpservletrequest.getParameter("emergency_chk")==null?"N":httpservletrequest.getParameter("emergency_chk");

			if(effectiveStatus == null)
                effectiveStatus = "D";
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
			
			hashtable.put("APPL_TO_OP",		p_outpatient_chk);
            hashtable.put("APPL_TO_IP",		p_inpatient_chk);
            hashtable.put("APPL_TO_EM",		p_emergency_chk);
            hashtable.put("APPL_TO_DC",		p_daycare_chk);

            hashtable.put("added_by_id", s);
            hashtable.put("modified_by_id", s2);
            hashtable.put("modified_date", date1);
            hashtable.put("modified_facility_id", s5);
            hashtable.put("modified_at_ws_no", s7);
            HashMap hashtable1 = new HashMap();
            hashtable1.put("facility_id", facilityid);
            hashtable1.put("file_type_code", filetypecode);
            
			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = hashtable;
			argArray[2] = hashtable1;
			argArray[3] = "MR_FILE_TYPE";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = hashtable.getClass();
			paramArray[2] = hashtable1.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
            boolean flag = ((Boolean)results.get("status")).booleanValue();
            String s8 = (String)results.get("error");
			 String s9 = (String)results.get("error");
			hashtable.clear();
			hashtable1.clear();
			results.clear();
            if(flag)
            {
                String s11 = "1";
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +  java.net.URLEncoder.encode(s8, "UTF-8") + "&err_value=" + s11);
            } else
            {
               
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s9, "UTF-8"));
            }
			
        }
        catch(Exception exception)
        {
          //  out.println("<h3> Exception raise by Servlet ... Record Not Modified </h3> Foll: Error Received : " + exception.toString());
          //  out.println("Values sent are : <br>");
          //  out.println(facilityid + " " + filetypecode + "  " + longDesc + " " + shortDesc + " " + effectiveStatus);
			exception.printStackTrace(); // modified by lakshmanan for security issue ID 169515941 on 21-08-2023
        }
    }

 boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				return true;
		else
				return false;
	}	
}
