/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;
import eFM.FMFileDeficiencyMonitoring.* ;

//public class  extends javax.servlet.http.HttpServlet	

public class FMFileDeficiencyMonitoringServlet extends HttpServlet implements SingleThreadModel
{
	HttpSession				session	=	null;
    java.io.PrintWriter		out		=	null;
    java.util.Properties	p		=	null;

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
        throws javax.servlet.ServletException,IOException
	{
		try 
		{
			this.out = response.getWriter();
            insertDeficiency(request,response);
		}
		catch(Exception e)
		{
			out.println("Exception@Servlet:1 : "+e);
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
			out.println ("<html><head>");
			out.println ("<link rel='stylesheet' type='text/css' href='../eCommon/html/IeStyle.css'></link>");
			out.println ("<body class='MESSAGE'>");
		}
		catch(Exception e)
		{
			out.println("Exception in doGet Method :"+e.toString());	
		}
	}
		
	private void insertDeficiency(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
	{
		
		response.setContentType("text/html");

		webbeans.eFM.FileDeficiencyMonitoring fileDeficiency = null;

		HashMap htDeficiency	  =	new java.util.HashMap();

		String curr_facility_id	  =	"";
		String login_user_id	  = "";
		String client_ip_address  = "";
		String locale			= "" ;

		try
        {	
			session				=	request.getSession(false);
			p					=	(java.util.Properties) session.getValue( "jdbc" ) ;
			locale = p.getProperty("LOCALE");
			curr_facility_id	=	(String) session.getValue("facility_id");
			login_user_id		=	(String) session.getValue("login_user");
			client_ip_address   =	p.getProperty("client_ip_address");

			fileDeficiency		= (webbeans.eFM.FileDeficiencyMonitoring) session.getValue("recordSetDeficiency");

			htDeficiency.put("curr_facility_id"		,curr_facility_id );
			htDeficiency.put("login_user_id"		,login_user_id	);
			htDeficiency.put("addedAtWorkstation"	,client_ip_address);
			htDeficiency.put("locale"	,locale	);
			
			boolean inserted = false;
			String error_msg = "";				

			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			
			Object home   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMFileDeficiencyMonitoring",FMFileDeficiencyMonitoringHome.class,local_ejbs);
			
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[3];
			argArray[0] = p;
			argArray[1] = htDeficiency;
			argArray[2] = fileDeficiency;
			
			
			Class [] paramArray = new Class[3];
			paramArray[0] = p.getClass();
			paramArray[1] = htDeficiency.getClass();
			paramArray[2] = fileDeficiency.getClass();
						
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("createDeficiency",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			inserted	=	(((Boolean) results.get( "status" )).booleanValue()) ;
			error_msg	=	(String)	results.get("error") ;
			String error_value = "0" ;
			fileDeficiency = null;
			htDeficiency.clear();
			results.clear();
			session.removeAttribute("recordSetDeficiency");
			
			if(inserted)
			{
				error_value = "1";		
			}
			response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error_msg,"UTF-8" )+ "&err_value=" + error_value );
		} 
		catch(Exception e)
		{
			out.println("Exception@Insert:1 : "+e);
			out.println(e.toString());
		} 
    } // end of method insertDeficiency
} // end of class FMFileDeficiencyMonitoringServlet 
