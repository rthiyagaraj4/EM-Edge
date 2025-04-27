/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;

import eFM.FMCancelRequest.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FMCancelRequestServlet extends HttpServlet implements SingleThreadModel
{
	String locale			= "" ;

    public FMCancelRequestServlet()
    {
        session = null;
        out		= null;
        p		= null;
    }
    public void init(ServletConfig servletconfig) throws ServletException
    {
        super.init(servletconfig);
    }
    public synchronized void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
		httpservletrequest.setCharacterEncoding("UTF-8");
		httpservletresponse.setContentType("text/html;charset=UTF-8");
        try
        {
            out = httpservletresponse.getWriter();
            cancelRequest(httpservletrequest, httpservletresponse);
        }catch(Exception e1){out.println("Exception in doPost e1 :"+ e1); }
    }
    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        try
        {
            out = httpservletresponse.getWriter();
			httpservletrequest.setCharacterEncoding("UTF-8");
			httpservletresponse.setContentType("text/html;charset=UTF-8");
            out.println("<html><head>");
            out.println("<link rel='stylesheet' type='text/css' href='../eCommon/html/IeStyle.css'></link>");
            out.println("<body class='MESSAGE'>");
        } catch(Exception e2){out.println("Exception in doGet e2 :"+ e2); }
    }

    private void cancelRequest(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        httpservletresponse.setContentType("text/html");
        HashMap hashmap = new HashMap();
        
		try
        {
            session					=		httpservletrequest.getSession(false);
            p							=		(Properties)session.getValue("jdbc");
			locale						=		p.getProperty("LOCALE");
            String facility_id		=		(String)session.getValue("facility_id");
            String login_user		=		(String)session.getValue("login_user");
            String client_ip_address	= p.getProperty("client_ip_address");
          			
			hashmap.put("login_facility_id"		, facility_id);
			hashmap.put("login_user_id"			, login_user);
			hashmap.put("addedAtWorkstation"	, client_ip_address);
			hashmap.put("file_nos"				, httpservletrequest.getParameter("filenos") == null?"":httpservletrequest.getParameter("filenos"));
			hashmap.put("volume_nos"			,  httpservletrequest.getParameter("volumenos") == null?"":httpservletrequest.getParameter("volumenos"));
			hashmap.put("req"					, httpservletrequest.getParameter("req") == null?"":httpservletrequest.getParameter("req"));
			hashmap.put("remarks"				, httpservletrequest.getParameter("remarks") == null?"":httpservletrequest.getParameter("remarks"));
			hashmap.put("locale"	, locale);

			boolean flag = false;
			String error = "";
		
			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			
			Object home		= com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMCancelRequest",FMCancelRequestHome.class,local_ejbs);
			Object busObj	= (home.getClass().getMethod("create",null)).invoke(home,null);
				
			Object argArray[]	= new Object[2];
			argArray[0]			= p;
			argArray[1]			= hashmap;
			
			Class [] paramArray = new Class[2];
			paramArray[0]		= p.getClass();
			paramArray[1]		= hashmap.getClass();
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("createCancelRequest",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			flag  = ((Boolean)results.get("status")).booleanValue();
			error = (String)results.get("error");
			results.clear();
			hashmap.clear();
		
			String status = "0";

			if(flag)
				status = "1";
			out.println(" Error message " + error);
			httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&err_value=" + status);
        }
        catch(Exception e3)
        {
            out.println("Exception in cancelRequest e3 :"+ e3.toString());
        }
    }

    HttpSession session;
    PrintWriter out;
    Properties p;
}
