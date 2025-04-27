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

import eFM.FMConfirmReceipt.* ;

public class FMConfirmReceiptFilesServlet extends HttpServlet implements SingleThreadModel
{
	HttpSession				session	=	null;
    java.io.PrintWriter		out		=	null;
    java.util.Properties	p		=	null;
	String locale			= "" ;

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
        throws javax.servlet.ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		session		=	request.getSession(false);
		p				=	(java.util.Properties) session.getValue( "jdbc" ) ;
		locale			=	 p.getProperty("LOCALE");
		try 
		{
			this.out = response.getWriter();
            confirmReceipt(request,response,locale);
		}
		catch(Exception e)
		{
			out.println("Exception@Servlet:1 : "+e);
			e.printStackTrace();
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
		catch(Exception e)	{	
			out.println("Exception in doGet method :"+e.toString());
			e.printStackTrace();
		}
	}
	private void confirmReceipt(HttpServletRequest request, HttpServletResponse response, String locale) throws ServletException, java.io.IOException
	{
		HashMap htconfirmReceipt  =	new java.util.HashMap();
		String login_facility_id    =	"";
		String login_user_id	    = "";
		String client_ip_address    = "";
	
		try
        {	
			login_facility_id	=	(String) session.getValue("facility_id");
			login_user_id		=	(String) session.getValue("login_user");
			client_ip_address   =	p.getProperty("client_ip_address");

			htconfirmReceipt.put ( "login_facility_id"  , login_facility_id );
			htconfirmReceipt.put ( "login_user_id"      , login_user_id	);
			htconfirmReceipt.put ( "addedAtWorkstation" , client_ip_address	);
			htconfirmReceipt.put ( "file_nos"			, request.getParameter("filenos")==null?"":request.getParameter("filenos"));
			htconfirmReceipt.put ( "volume_nos"			, request.getParameter("volumenos")==null?"":request.getParameter("volumenos"));
			htconfirmReceipt.put ( "issue_locns"		, request.getParameter("issue_locns")==null?"":request.getParameter("issue_locns"));
			htconfirmReceipt.put ( "rec_locn_code"		, request.getParameter("rec_locn_code")==null?"":request.getParameter("rec_locn_code"));
			htconfirmReceipt.put ( "rec_locn_iden"		, request.getParameter("rec_locn_iden")==null?"":request.getParameter("rec_locn_iden"));
			htconfirmReceipt.put ( "rec_user_id"		, request.getParameter("rec_user_id")==null?"":request.getParameter("rec_user_id"));
			htconfirmReceipt.put ( "file_type_appl_yn"	, request.getParameter("file_type_appl_yn")==null?"":request.getParameter("file_type_appl_yn"));
			htconfirmReceipt.put ( "sender_facility"	, request.getParameter("senderfacility")==null?"":request.getParameter("senderfacility"));
			htconfirmReceipt.put ( "locale",locale);
            //Added for this CRF HSA-CRF-0306.1			
			htconfirmReceipt.put ( "fs_curr_locn_id"	, request.getParameter("fs_curr_locn_id")==null?"":request.getParameter("fs_curr_locn_id"));
			htconfirmReceipt.put ( "patientid"	, request.getParameter("patientid")==null?"":request.getParameter("patientid")); 
		
			boolean inserted = false;
			String error_msg = "";

			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				
			Object home   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMConfirmReceipt",FMConfirmReceiptHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = htconfirmReceipt;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = htconfirmReceipt.getClass();
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("createConfirmReceipt",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			inserted	=	(((Boolean) results.get( "status" )).booleanValue()) ;
			error_msg	=	(String)	results.get("error") ;
			String error_value = "0" ;
			results.clear();
			htconfirmReceipt.clear();

			if(inserted) { error_value = "1"; }

			out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error_msg ,"UTF-8" )+"&err_value="+error_value+ "\"</script><body class='message'></html>");
				
		} 
		catch(Exception e)
		{
			out.println("Exception in Confirm Receipr File Servlet :"+e);
			out.println(e.toString());
			e.printStackTrace();
		} 
    } // end of method confirmReceipt
} // end of class FMConfirmReceiptFilesServlet 
