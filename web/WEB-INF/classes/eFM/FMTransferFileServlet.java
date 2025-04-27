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

import eFM.FMTransferFile.* ;

public class FMTransferFileServlet extends HttpServlet implements SingleThreadModel
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
		try 
		{
			this.out = response.getWriter();
			transferFile(request,response, locale);
		}catch(Exception e1){out.println("Exception in doPost method :"+e1);}
    }
	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
		try	
		{
			this.out = res.getWriter();
			out.println ("<html><head>");
			out.println ("<link rel='stylesheet' type='text/css' href='../eCommon/html/IeStyle.css'></link>");
			out.println ("<body class='MESSAGE'>");
		}catch(Exception e2){out.println("Exception in doGet method :"+e2);}
	}
	private void transferFile(HttpServletRequest request, HttpServletResponse response, String locale) throws ServletException, java.io.IOException
	{
			
		response.setContentType("text/html");
		HashMap httransferFiles	= new java.util.HashMap();

		String login_facility_id		= "";
		String login_user_id			= "";
		String client_ip_address		= "";
							
		try
        {		
			session				=	request.getSession(false);
			p					=	(java.util.Properties) session.getValue( "jdbc" ) ;
			locale = p.getProperty("LOCALE");
			login_facility_id	=	(String) session.getValue("facility_id");
			login_user_id		=	(String) session.getValue("login_user");
			client_ip_address   =	p.getProperty("client_ip_address");
		
			httransferFiles.put ( "login_facility_id",		login_facility_id);
			httransferFiles.put ( "login_user_id",			login_user_id);
			httransferFiles.put ( "addedAtWorkstation",		client_ip_address);
			httransferFiles.put ( "transfer_file_nos",		request.getParameter("FileList")== null ? "" :request.getParameter("FileList") );
			httransferFiles.put ( "from_locn_code",			request.getParameter("FromLocnCode")== null ? "" :request.getParameter("FromLocnCode") );
			httransferFiles.put ( "transfer_user_id",		request.getParameter("TransferUserId")== null ? "" :request.getParameter("TransferUserId") );
			httransferFiles.put ( "p_iss_remarks",			request.getParameter("iss_remarks")== null ? "" :request.getParameter("iss_remarks") );
			httransferFiles.put ( "file_transport_mode",	request.getParameter("resultPage_carried_by_name")== null ? "" :request.getParameter("resultPage_carried_by_name") );
			httransferFiles.put ( "carried_by_name",		request.getParameter("resultPage_file_trans_mode")== null ? "" :request.getParameter("resultPage_file_trans_mode") );
			httransferFiles.put ( "p_file_type_appl_yn",	request.getParameter("file_type_appl_yn")== null ? "" :request.getParameter("file_type_appl_yn") );
			httransferFiles.put ( "auto_rec_ward_yn",	request.getParameter("auto_rec_ward_yn")== null ? "" :request.getParameter("auto_rec_ward_yn") );
			httransferFiles.put ( "auto_rec_clinic_yn",	request.getParameter("auto_rec_clinic_yn")== null ? "" :request.getParameter("auto_rec_clinic_yn") );
			httransferFiles.put ( "auto_rec_pract_yn",	request.getParameter("auto_rec_pract_yn")== null ? "" :request.getParameter("auto_rec_pract_yn") );
		    httransferFiles.put ( "auto_rec_dept_yn",	request.getParameter("auto_rec_dept_yn")== null ? "" :request.getParameter("auto_rec_dept_yn") );
			httransferFiles.put ( "locale",			locale);
			
			//Added for this CRF HSA-CRF-0306.1			
			httransferFiles.put("isCurrentFsLocation",	request.getParameter("isCurrentFsLocation")== null ? "" :request.getParameter("isCurrentFsLocation"));
			httransferFiles.put("noofdhtoreturn",	request.getParameter("noofdhtoreturn")== null ? "0" :request.getParameter("noofdhtoreturn"));
			httransferFiles.put("duration_type",	request.getParameter("duration_type")== null ? "" :request.getParameter("duration_type"));
			httransferFiles.put("fslocn_return_criteria",	request.getParameter("fslocn_return_criteria")== null ? "" :request.getParameter("fslocn_return_criteria"));
			httransferFiles.put("permanent_file_area_yn",	request.getParameter("permanent_file_area_yn")== null ? "" :request.getParameter("permanent_file_area_yn"));
			httransferFiles.put("current_date",	request.getParameter("sys_date")== null ? "" :request.getParameter("sys_date")); //Added for HSA-CRF-0306.1 linked incident
			
			httransferFiles.put("patientClass",	request.getParameter("patientClass")== null ? "" :request.getParameter("patientClass"));
			httransferFiles.put("assigncarecode",	request.getParameter("assigncarecode")== null ? "" :request.getParameter("assigncarecode"));
			httransferFiles.put("dischargedatetime",	request.getParameter("dischargedatetime")== null ? "" :request.getParameter("dischargedatetime"));

			boolean inserted			= false;
			String error_msg			= "";
			
			boolean local_ejbs = true;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			
			Object home   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMTransferFile",FMTransferFileHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = httransferFiles;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = httransferFiles.getClass();
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("createTransferFile",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
			inserted	=	(((Boolean) results.get("status")).booleanValue());
			error_msg	=	(String) results.get("error");
				
			String error_value = "0" ;
			httransferFiles.clear();
			results.clear();

			if(inserted) error_value = "1";
			response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error_msg,"UTF-8" )+"&err_value=" + error_value);
		}catch(Exception e3){out.println("Exception in transferFile method in Servlet :"+e3);} 
	} // end of method transferFile
} // end of class FMTransferFileServlet 
