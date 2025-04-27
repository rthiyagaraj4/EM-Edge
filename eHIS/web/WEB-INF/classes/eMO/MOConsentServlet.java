/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMO;

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

public class MOConsentServlet extends HttpServlet {
    PrintWriter out;
    //String mysql;
    Properties p;
   	String BODY_COND_CODE = "";
	String short_desc = "";
	String long_desc = "";
	String effectiveStatus = "";
    String facilityId;
    String client_ip_address;
    HttpSession session;
    SimpleDateFormat dateFormat;
    public MOConsentServlet() {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void init(ServletConfig servletconfig) throws ServletException {
        super.init(servletconfig);
    }

    public synchronized void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) throws ServletException, IOException {

		httpservletrequest.setCharacterEncoding("UTF-8");
        session = httpservletrequest.getSession(false);
        facilityId = (String)session.getValue("facility_id");
        p = (Properties)session.getValue("jdbc");
        client_ip_address = p.getProperty("client_ip_address");
        try {
        httpservletresponse.setContentType("text/html;charset=UTF-8");
        out = httpservletresponse.getWriter();

		BODY_COND_CODE = httpservletrequest.getParameter("service_code");
		if(BODY_COND_CODE == null) BODY_COND_CODE = "";

		long_desc = httpservletrequest.getParameter("long_desc");
		if(long_desc == null) long_desc = "";

		short_desc = httpservletrequest.getParameter("terms_desc");
		if(short_desc == null) short_desc = "";

		effectiveStatus = httpservletrequest.getParameter("eff_status");
		if(effectiveStatus == null)
		effectiveStatus = "D";

		String s = httpservletrequest.getParameter("function");
		if(s.equals("insert"))
		insertcomplaint(httpservletresponse);
		if(s.equals("modify"))
		modifycomplaint(httpservletresponse);
		}
        catch(Exception exception) {
            out.println(exception.toString());
        }
    }

    public void doGet(HttpServletResponse httpservletresponse) throws ServletException, IOException {
        try {
            out = httpservletresponse.getWriter();
            httpservletresponse.setContentType("text/html;charset=UTF-8");
            out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=Occupation' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
        }
        catch(Exception exception) { }
    }

    private void modifycomplaint(HttpServletResponse httpservletresponse) {
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
            HashMap hashtable = new HashMap();
            hashtable.put("EFF_STATUS", effectiveStatus);
            hashtable.put("TITLE", long_desc);
            hashtable.put("DESCRIPTION", short_desc);
            hashtable.put("added_by_id", s);
            hashtable.put("modified_by_id", s2);
            hashtable.put("modified_date", date1);
            hashtable.put("modified_facility_id", s5);
            hashtable.put("modified_at_ws_no", s7);
            HashMap hashtable1 = new HashMap();
            hashtable1.put("CONSENT_FORM_CODE", BODY_COND_CODE);
           
		    String tabname="mo_consent_form";
		    boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = hashtable;
			argArray[2] = hashtable1;
			argArray[3] = tabname;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = hashtable.getClass();
			paramArray[2] = hashtable1.getClass();
			paramArray[3] = tabname.getClass();
              
	     	java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
		    boolean flag = ((Boolean)results.get("status")).booleanValue();
            String s8 = (String)results.get("error");
            
            if(flag) {
                String s11 = "1";
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s8,"UTF-8") + "&err_value=" + s11);
            } else {
                String s9 = (String)results.get("error");
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s9,"UTF-8"));
            }
            argArray = null;
		    paramArray = null;
		    hashtable1.clear();
		    hashtable.clear();
			results.clear();
		}
        catch(Exception exception) {
            out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            out.println("Values sent are : <br>");
            out.println(BODY_COND_CODE + " " + short_desc + " " + effectiveStatus);
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
            HashMap hashtable = new HashMap();
            hashtable.put("CONSENT_FORM_CODE", BODY_COND_CODE);
            hashtable.put("TITLE", long_desc);
            hashtable.put("DESCRIPTION", short_desc);
            hashtable.put("EFF_STATUS", effectiveStatus);
            hashtable.put("added_by_id", s);
            hashtable.put("added_date", date);
            hashtable.put("added_facility_id", facilityId);
            hashtable.put("added_at_ws_no", s6);
            hashtable.put("modified_by_id", s2);
            hashtable.put("modified_date", date1);
            hashtable.put("modified_facility_id", s5);
            hashtable.put("modified_at_ws_no", s7);
            String as[] = {
                "CONSENT_FORM_CODE"
            };

		String tabname="mo_consent_form";
		boolean local_ejbs = false;

		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
        
		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = hashtable;
		argArray[2] =  as;
		argArray[3] = tabname;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = hashtable.getClass();
		paramArray[2] =  as.getClass();
		paramArray[3] = tabname.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
        boolean flag = ((Boolean)results.get("status")).booleanValue();
        String s8 = (String)results.get("error");
        if(flag) {
        String s11 = "1";
        httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s8,"UTF-8") + "&err_value=" + s11);
        } else {
          String s9 = (String)results.get("error");
          httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s9,"UTF-8"));
         }

			argArray = null;
		    paramArray = null;
		    hashtable.clear();
			results.clear();
        }
        catch(Exception exception) {
            out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            out.println("Values sent are : <br>");
            out.println(BODY_COND_CODE + " " + short_desc + " " + effectiveStatus);
        }
    }

   
}
