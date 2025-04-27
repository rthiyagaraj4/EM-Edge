/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMP;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;
import eCommon.SingleTabHandler.SingleTabHandlerManagerRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import eCommon.XSSRequestWrapper;

public class EthnicSubGroupServlet extends HttpServlet
{

    public EthnicSubGroupServlet()
    {
        //dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
    }

    public synchronized void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
		httpservletrequest.setCharacterEncoding("UTF-8");
		httpservletresponse.setContentType("text/html;charset=UTF-8");       
		HttpSession httpsession = httpservletrequest.getSession(false);
        p = (Properties)httpsession.getValue("jdbc");
        facilityId = (String)httpsession.getValue("facility_id");
        client_ip_address = p.getProperty("client_ip_address");
       
        try
        {
            out = httpservletresponse.getWriter();
            String mode = httpservletrequest.getParameter("mode");
            if(mode.equals("insert"))
                insertEthnicSubGroup(httpservletrequest, httpservletresponse);
            if(mode.equals("modify"))
                modifyEthnicSubGroup(httpservletrequest, httpservletresponse);
        }
        catch(Exception exception)
        {
          //  out.println(exception.toString());
        	exception.printStackTrace(); // Added by lakshmanan for security issue ID 174114361 on 05-09-2023
        }
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        try
        {
			httpservletrequest.setCharacterEncoding("UTF-8");
		    httpservletrequest = new XSSRequestWrapper(httpservletrequest);
			httpservletresponse.setContentType("text/html;charset=UTF-8");
	        httpservletresponse.addHeader("X-XSS-Protection", "1; mode=block");
	        httpservletresponse.addHeader("X-Content-Type-Options", "nosniff");
			out = httpservletresponse.getWriter();

            String codeToolbar = "../eCommon/jsp/MstCodeToolbar.jsp?";
            String queryString = httpservletrequest.getQueryString();
            String s2 = codeToolbar + queryString;
            out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/EthnicSubGroup.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'\tsrc='" + s2 + "' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
        }
        catch(Exception exception) { }
    }

    private void modifyEthnicSubGroup(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
            ethnicgroupcode = httpservletrequest.getParameter("ETHNIC_GROUP_CODE");
            longDesc = httpservletrequest.getParameter("LONG_DESC");
            shortDesc = httpservletrequest.getParameter("SHORT_DESC");
			racecode = httpservletrequest.getParameter("RACE_CODE");
            effectiveStatus = httpservletrequest.getParameter("EFF_STATUS");
            if(effectiveStatus == null) effectiveStatus = "D";
            String s = p.getProperty("login_user");
            String s2 = s;
            String s4 = facilityId;
            String s5 = client_ip_address;
            String s6 = s5;
			
			HashMap hashtable = new HashMap();
            hashtable.put("LONG_DESC", longDesc);
            hashtable.put("SHORT_DESC", shortDesc);
			hashtable.put("RACE_CODE", racecode);
            hashtable.put("EFF_STATUS", effectiveStatus);
            hashtable.put("modified_by_id", s2);
            hashtable.put("modified_date", new Timestamp(System.currentTimeMillis()));
            hashtable.put("modified_facility_id", s4);
            hashtable.put("modified_at_ws_no", s6);
            HashMap hashtable1 = new HashMap();
            hashtable1.put("ETHNIC_GROUP_CODE", ethnicgroupcode);

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = hashtable;
			argArray[2] = hashtable1;
			argArray[3] = "MP_ETHNIC_GROUP";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = hashtable.getClass();
			paramArray[2] = hashtable1.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap hashtable2 = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

            boolean flag = ((Boolean)hashtable2.get("status")).booleanValue();
            String s7 = (String)hashtable2.get("error");
			String s8 = (String)hashtable2.get("error");
			hashtable.clear();
			hashtable1.clear();
			hashtable2.clear();
            if(flag)
            {
                String s10 = "1";
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s7, "UTF-8") + "&err_value=" + s10);
            } else
            {
                
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s8, "UTF-8"));
            }

			
        }
        catch(Exception exception)
        {
           // out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
           // out.println("Values sent are : <br>");
           // out.println(ethnicgroupcode + " " + longDesc + " " + shortDesc + " " + effectiveDateFrom + " " + effectiveDateTo + " " + effectiveStatus);
        	exception.printStackTrace(); // Added by lakshmanan for security issue ID 169521308 on 05-09-2023
        }
    }

    private void insertEthnicSubGroup(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
            ethnicgroupcode = httpservletrequest.getParameter("ETHNIC_GROUP_CODE");
            longDesc = httpservletrequest.getParameter("LONG_DESC");
            shortDesc = httpservletrequest.getParameter("SHORT_DESC");
			racecode = httpservletrequest.getParameter("RACE_CODE");
            effectiveStatus = httpservletrequest.getParameter("EFF_STATUS");
            if(effectiveStatus == null)
                effectiveStatus = "D";
            String s = p.getProperty("login_user");
            String s2 = s;
            String s4 = facilityId;
            String s5 = s4;
            String s6 = client_ip_address;
            String s7 = s6;
			
			HashMap hashtable = new HashMap();
            hashtable.put("ETHNIC_GROUP_CODE", ethnicgroupcode);
            hashtable.put("LONG_DESC", longDesc);
            hashtable.put("SHORT_DESC", shortDesc);
            hashtable.put("RACE_CODE", racecode);
            hashtable.put("EFF_STATUS", effectiveStatus);
            hashtable.put("added_by_id", s);
            hashtable.put("added_date", new Timestamp(System.currentTimeMillis()));
            hashtable.put("added_facility_id", facilityId);
            hashtable.put("added_at_ws_no", s6);
            hashtable.put("modified_by_id", s2);
            hashtable.put("modified_date", new Timestamp(System.currentTimeMillis()));
            hashtable.put("modified_facility_id", s5);
            hashtable.put("modified_at_ws_no", s7);
            String as[] = {
                "ETHNIC_GROUP_CODE"
            };

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = hashtable;
			argArray[2] = as;
			argArray[3] = "MP_ETHNIC_GROUP";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = hashtable.getClass();
			paramArray[2] = as.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap hashtable1 = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);			
            boolean flag = ((Boolean)hashtable1.get("status")).booleanValue();
            String s8 = (String)hashtable1.get("error");
			 String s9 = (String)hashtable1.get("error");
			hashtable.clear();
			hashtable1.clear();
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
          //  out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : " + exception.toString());
        	exception.printStackTrace(); // Added by lakshmanan for security issue ID 169521308 on 05-09-2023
        }
    }

	boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				return true;
		else
				return false;
	}

    PrintWriter out;
 	Properties p;
 
	String ethnicgroupcode;
    String longDesc;
    String shortDesc;
    String racecode;
    String effectiveDateFrom;
    String effectiveDateTo;
    String effectiveStatus;
    String facilityId;
    String client_ip_address;
}
