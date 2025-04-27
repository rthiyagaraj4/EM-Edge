/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE; 

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;
import eCommon.SingleTabHandler.SingleTabHandlerManagerRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InjuryCategoryServlet extends HttpServlet
    implements SingleThreadModel
{

    PrintWriter out;
    String facilityId;
    HttpSession session;
    Properties p;
    String client_ip_address;
    boolean inserted;
    String mode;
    String eff_status;
	String oscc_yn;
    SimpleDateFormat dateFormat;

    public InjuryCategoryServlet()
    {
        inserted = false;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    static Class _mthclass$(String s)
    {
        try
        {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    public void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
		httpservletrequest.setCharacterEncoding("UTF-8");
		httpservletresponse.setContentType("text/html;charset=UTF-8");
        out = httpservletresponse.getWriter();
        try
        {
            session = httpservletrequest.getSession(true);
            facilityId = (String)session.getValue("facility_id");
            p = (Properties)session.getValue("jdbc");
            client_ip_address = p.getProperty("client_ip_address");
			oscc_yn = httpservletrequest.getParameter("oscc_yn");
            if(oscc_yn == null || oscc_yn.equals("") || oscc_yn == "")
                oscc_yn = "N";
			  
	    
	        eff_status = httpservletrequest.getParameter("eff_status");
            if(eff_status == null || eff_status.equals("") || eff_status == "")
                eff_status = "D";
            mode = httpservletrequest.getParameter("mode");
            mode = mode != null ? mode : "";
            if(mode.equalsIgnoreCase("INSERT"))
                insertInjuryCategoryCode(httpservletrequest, httpservletresponse);
            else
                modifyInjuryCategoryCode(httpservletrequest, httpservletresponse);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
    }

    private void insertInjuryCategoryCode(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
            String s = p.getProperty("login_user");
            String s1 = dateFormat.format(new java.util.Date());
            String s2 = s;
            String s3 = s1;
            String s4 = facilityId;
            String s5 = s4;
            String s6 = client_ip_address;
            String s7 = s6;
            Date date = Date.valueOf(s1);
            Date date1 = new Date(java.util.Date.parse(date.toLocaleString()) - (long)(date.getTimezoneOffset() * 60 * 1000));
            Date date2 = Date.valueOf(s3);
            Date date3 = new Date(java.util.Date.parse(date2.toLocaleString()) - (long)(date2.getTimezoneOffset() * 60 * 1000));
            java.util.HashMap hashmap = new HashMap();
            hashmap.put("INJ_CATEGORY_CODE", httpservletrequest.getParameter("inj_category_code")==null?"":httpservletrequest.getParameter("inj_category_code"));
            hashmap.put("LONG_DESC", httpservletrequest.getParameter("long_desc")==null?"":httpservletrequest.getParameter("long_desc"));
            hashmap.put("SHORT_DESC", 
httpservletrequest.getParameter("short_desc")==null?"":httpservletrequest.getParameter("short_desc"));
			hashmap.put("OSCC_YN", oscc_yn);
            hashmap.put("EFF_STATUS", eff_status);
            hashmap.put("ADDED_BY_ID", s);
            hashmap.put("ADDED_DATE", date1);
            hashmap.put("ADDED_AT_WS_NO", s6);
            hashmap.put("ADDED_FACILITY_ID", facilityId);
            hashmap.put("MODIFIED_BY_ID", s2);
            hashmap.put("MODIFIED_DATE", date3);
            hashmap.put("MODIFIED_FACILITY_ID", s5);
            hashmap.put("MODIFIED_AT_WS_NO", s7);
            String as[] = {
                "INJ_CATEGORY_CODE"
            };
            try
            {
			boolean local_ejbs = false;
			String tablename ="AE_INJURY_CATEGORY";

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = hashmap;
			argArray[2] = as;
			argArray[3] = tablename;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = hashmap.getClass();
			paramArray[2] = as.getClass();
			paramArray[3] = tablename.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;

			   if ( inserted )
			   {
					error_value= "1";
					
					httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );
			   }
			   else
			   {
					
					httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );
			   }
			   hashmap.clear();
			   results.clear();
            }
            catch(Exception exception1)
            {
                exception1.printStackTrace();
                String s8 = "Error From Servlet--Calling EJB:" + exception1;
                String s9 = "0";
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s8) + "&err_value=" + s9);
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            //out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
        }
    }

    private void modifyInjuryCategoryCode(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
            String s = p.getProperty("login_user");
            String s1 = dateFormat.format(new java.util.Date());
            String s2 = s;
            String s3 = s1;
            String s4 = facilityId;
            String s5 = s4;
            String s6 = client_ip_address;
            String s7 = s6;
            Date date2 = Date.valueOf(s3);
            Date date3 = new Date(java.util.Date.parse(date2.toLocaleString()) - (long)(date2.getTimezoneOffset() * 60 * 1000));
            java.util.HashMap hashmap = new HashMap();
            hashmap.put("LONG_DESC", httpservletrequest.getParameter("long_desc")==null?"":httpservletrequest.getParameter("long_desc"));
            hashmap.put("SHORT_DESC", 
httpservletrequest.getParameter("short_desc")==null?"":httpservletrequest.getParameter("short_desc"));
            hashmap.put("OSCC_YN", oscc_yn); 
	        hashmap.put("EFF_STATUS", eff_status);
            hashmap.put("MODIFIED_BY_ID", s2);
            hashmap.put("MODIFIED_DATE", date3);
            hashmap.put("MODIFIED_FACILITY_ID", s5);
            hashmap.put("MODIFIED_AT_WS_NO", s7);
            java.util.HashMap hashmap1 = new HashMap();
            hashmap1.put("INJ_CATEGORY_CODE", httpservletrequest.getParameter("inj_category_code")==null?"":httpservletrequest.getParameter("inj_category_code"));
            try
            {
			boolean local_ejbs = false;
			String tablename ="AE_INJURY_CATEGORY";

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = hashmap;
			argArray[2] = hashmap1;
			argArray[3] = tablename;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = hashmap.getClass();
			paramArray[2] = hashmap1.getClass();
			paramArray[3] = tablename.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;

			   if ( inserted )
			   {
					error_value= "1";
					httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );
			   }
			   else
			   {
					httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"  ) + "&err_value=" + error_value );
			   }
			   hashmap.clear();
			   hashmap1.clear();
			   results.clear();
            }
            catch(Exception exception1)
            {
               // out.println("From Servlet--Calling EJB:" + exception1);
                exception1.printStackTrace();
                String s8 = "Error ";
                String s9 = "0";
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s8) + "&err_value=" + s9);
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            //out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
        }
    }

    
}
