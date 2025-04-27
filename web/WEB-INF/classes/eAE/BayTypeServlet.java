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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import eCommon.XSSRequestWrapper;

public class BayTypeServlet extends HttpServlet {
	
	PrintWriter out;
    Properties p;
   	String BAY_TYPE_CODE = "";
	String short_desc = "";
	String long_desc = "";
	String effectiveStatus = "";
    String facilityId;
    String client_ip_address;
    HttpSession session;
    SimpleDateFormat dateFormat;
			
	boolean inserted		= false;
    public BayTypeServlet() {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void init(ServletConfig servletconfig) throws ServletException {
        super.init(servletconfig);
    }

    public synchronized void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) throws ServletException, IOException {
		httpservletrequest.setCharacterEncoding("UTF-8");
		httpservletresponse.setContentType("text/html;charset=UTF-8");
		
		httpservletrequest= new XSSRequestWrapper(httpservletrequest);
		httpservletresponse.addHeader("X-XSS-Protection", "1; mode=block");
		httpservletresponse.addHeader("X-Content-Type-Options", "nosniff");
		
        session = httpservletrequest.getSession(false);
        facilityId = (String)session.getValue("facility_id");
        p = (Properties)session.getValue("jdbc");
        client_ip_address = p.getProperty("client_ip_address");
        try {
            out = httpservletresponse.getWriter();
            BAY_TYPE_CODE = httpservletrequest.getParameter("bay_type_code");
			if(BAY_TYPE_CODE == null) BAY_TYPE_CODE = "";
            long_desc = httpservletrequest.getParameter("long_desc");
			if(long_desc == null) long_desc = "";
            short_desc = httpservletrequest.getParameter("short_desc");
			if(short_desc == null) short_desc = "";
            effectiveStatus = httpservletrequest.getParameter("eff_status");
            if(effectiveStatus == null)
                effectiveStatus = "D";
			
			
		
            String s = httpservletrequest.getParameter("function");
			
            if(s.equals("insert"))
                insertcomplaint(httpservletresponse);
            if(s.equals("modify"))
                modifycomplaint( httpservletresponse);
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
    }

    public void doGet(HttpServletResponse httpservletresponse) throws ServletException, IOException {
        try {
            out = httpservletresponse.getWriter();
            out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=Occupation' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
        }
        catch(Exception exception) { exception.printStackTrace(); }
    }

    private void modifycomplaint( HttpServletResponse httpservletresponse) {
        try {
			
            String s = p.getProperty("login_user");
            String s1 = dateFormat.format(new Date());
            String s2 = s;
            String s3 = s1;
            String s4 = facilityId;
            String s5 = s4;
            String s6 = client_ip_address;
            String s7 = s6;
            java.sql.Date date1 = java.sql.Date.valueOf(s3);
            java.util.HashMap hashmap = new HashMap();
         
            hashmap.put("EFF_STATUS", effectiveStatus);
            hashmap.put("long_desc", long_desc);
            hashmap.put("short_desc", short_desc);
            hashmap.put("added_by_id", s);
            hashmap.put("modified_by_id", s2);
            hashmap.put("modified_date", date1);
            hashmap.put("modified_facility_id", s5);
            hashmap.put("modified_at_ws_no", s7);
            java.util.HashMap hashmap1 = new HashMap();

            hashmap1.put("BAY_TYPE_CODE", BAY_TYPE_CODE);

			boolean local_ejbs = false;
			String tablename ="AE_BAY_TYPE";

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
		     			httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
						httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		     	   }

			hashmap.clear();
			hashmap1.clear();
			results.clear();
        }
        catch(Exception exception) {
			exception.printStackTrace();
          /*  out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            out.println("Values sent are : <br>");
            out.println(BAY_TYPE_CODE + " " + short_desc + " " + effectiveStatus);  */
        }
    }

    private void insertcomplaint(HttpServletResponse httpservletresponse) {
        try {
         
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
			java.util.HashMap hashmap = new HashMap();
            hashmap.put("BAY_TYPE_CODE", BAY_TYPE_CODE);
            hashmap.put("LONG_DESC", long_desc);
            hashmap.put("SHORT_DESC", short_desc);
            hashmap.put("EFF_STATUS", effectiveStatus);
            hashmap.put("added_by_id", s);
            hashmap.put("added_date", date);
            hashmap.put("added_facility_id", facilityId);
            hashmap.put("added_at_ws_no", s6);
            hashmap.put("modified_by_id", s2);
            hashmap.put("modified_date", date1);
            hashmap.put("modified_facility_id", s5);
            hashmap.put("modified_at_ws_no", s7);
            String as[] = {
                "BAY_TYPE_CODE"
            };
			boolean local_ejbs = false;
			String tablename ="AE_BAY_TYPE";

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
		     			httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   { 
						httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		     	   }
			hashmap.clear();
			results.clear();
        }
        catch(Exception exception) {
		/*	exception.printStackTrace();
            out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            out.println("Values sent are : <br>");
            out.println(BAY_TYPE_CODE + " " + short_desc + " " + effectiveStatus); */
			exception.printStackTrace();
        }  
    }

    
}
