/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.*;
import javax.rmi.*;
import eFM.FMReturnToMRD.*;

public class FMReturnToMRDServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;

	String facility_id			=	"";
	String client_ip_address	=	"";
	String error_value			=	"0";
	String locale			= "" ;

	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session				=	req.getSession(false);
		this.p				=	(java.util.Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		this.facility_id	=	checkForNull((String) session.getValue("facility_id"));		
		p					=	(Properties) session.getValue("jdbc");
		client_ip_address	=	checkForNull(p.getProperty("client_ip_address"));
		String login_user	=	checkForNull(p.getProperty("login_user"));
		
		try
		{
			this.out = res.getWriter();

			HashMap hashmap = new HashMap();

			String error_msg			= "";
			
			hashmap.put("facility_id"			,facility_id);
			hashmap.put("valid_records"			,checkForNull(req.getParameter("valid_records")));
			hashmap.put("date_time"				,checkForNull(req.getParameter("date_time")));
			hashmap.put("transport_mode"		,checkForNull(req.getParameter("transport_mode")));
			hashmap.put("transport_mode_desc"	,checkForNull(req.getParameter("transport_mode_desc")));
			hashmap.put("patient_id"	,checkForNull(req.getParameter("patient_id")));
			hashmap.put("client_ip_address"		,client_ip_address);
			hashmap.put("login_user"			,login_user);
			hashmap.put("locale"			,locale);

			boolean inserted			= false;
			
			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMReturnToMRD",FMReturnToMRDHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = hashmap;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = hashmap.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("returnFileToMRD",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			inserted	=	(((Boolean) results.get("status")).booleanValue()) ;
			error_msg	=	(String) results.get("error") ;
			hashmap.clear();
			results.clear();

			if(inserted) error_value = "1" ;

			res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+ java.net.URLEncoder.encode( error_msg,"UTF-8" )+"&err_value="+error_value );
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
		try	
		{
			this.out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eSM/js/SiteParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='" + source + "' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eSM/jsp/SiteBlank.jsp' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html>");
		}
		catch(Exception e)	{ out.println("Wxception in doGet Method :"+e.toString());	}
	}

	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
}

