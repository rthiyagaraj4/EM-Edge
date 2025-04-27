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
import java.util.*;
import java.text.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class FMDocumentFolderServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	HttpSession session;
	String locale			= "" ;

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
	
	String facility_id				= "";
	String doc_folder_id			= "";
	String doc_folder_name			= "";
	String eff_status				= "";
	String client_ip_address		= "";
	String operation				= "";
	String patient_period_specific	= "";
	String patient_id				= "";
	String from_period				= "";
	String to_period				= "";

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session				= req.getSession(false);
		this.p				= (java.util.Properties) session.getValue("jdbc");
		locale = p.getProperty("LOCALE");
		this.facility_id	= (String) session.getValue("facility_id");
		client_ip_address	= p.getProperty("client_ip_address");

		doc_folder_id			= req.getParameter("doc_folder_id");
		doc_folder_name			= req.getParameter("doc_folder_name");
		patient_period_specific = req.getParameter("doc_folder_type");
		patient_id				= req.getParameter("patient_id");
		from_period				= req.getParameter("from");
		to_period				= req.getParameter("to");
		eff_status				= req.getParameter("eff_status");

		if(doc_folder_id == null || doc_folder_id.equals("null"))
			doc_folder_id = "";
		if(doc_folder_name == null || doc_folder_name.equals("null"))
			doc_folder_name = "";
		if(patient_period_specific == null || patient_period_specific.equals("null"))
			patient_period_specific = "";
		if(patient_id == null || patient_id.equals("null"))
			patient_id = "";
		if(from_period == null || from_period.equals("null"))
			from_period = "";
		if(to_period == null || to_period.equals("null"))
			to_period = "";
		if(eff_status == null || eff_status.equals("null"))
			eff_status = "D";

		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			operation = req.getParameter("operation");
			if(operation == null || operation.equals("null"))
				operation = "";
			if(operation.equals("create")) insertDocumentFolder(req,res,locale);
			else if(operation.equals("modify")) updateDocumentFolder(req,res,locale);
		}
		catch(Exception e)
		{
			out.println("Exception :"+e.toString());
		}
	}
	public void insertDocumentFolder(HttpServletRequest req, HttpServletResponse res, String locale)
	{
		try
		{
			String addedById				= p.getProperty("login_user");
			String addedDate				= dateFormat.format(new java.util.Date());
			String modifiedById				= addedById;
			String modifiedDate				= addedDate;
	        String addedFacilityId			= facility_id;
		    String modifiedFacilityId		= addedFacilityId;
			String addedAtWorkstation		= client_ip_address;
	        String modifiedAtWorkstation	= addedAtWorkstation;
			
			java.sql.Date added_date	= java.sql.Date.valueOf(addedDate);
			java.sql.Date modified_date = java.sql.Date.valueOf(modifiedDate);
			
			java.sql.Date fromPeriod = null;
			java.sql.Date toPeriod   = null;

			HashMap tabdata = new HashMap();

			if(!from_period.equals(""))
			{
				StringTokenizer st1 = new StringTokenizer(from_period,"/");
				String d11="";
				String d21="";
				String d31="";
				while(st1.hasMoreTokens())
				{
					d11=st1.nextToken();
					d21=st1.nextToken();
					d31=st1.nextToken();
				}
				String s1=d31+"-"+d21+"-"+d11;
				fromPeriod = java.sql.Date.valueOf(s1);
				tabdata.put("FROM_PERIOD", fromPeriod);
			}
			else
			{
				tabdata.put("FROM_PERIOD", from_period);
			}

			if(!to_period.equals(""))
			{
				StringTokenizer st1 = new StringTokenizer(to_period,"/");
				String d11="";
				String d21="";
				String d31="";
				while(st1.hasMoreTokens())
				{
					d11=st1.nextToken();
					d21=st1.nextToken();
					d31=st1.nextToken();
				}
				String s1=d31+"-"+d21+"-"+d11;
				toPeriod = java.sql.Date.valueOf(s1);
				tabdata.put("TO_PERIOD", toPeriod);
			}
			else
			{
				tabdata.put("TO_PERIOD", to_period);
			}

			tabdata.put("FACILITY_ID",				facility_id);
			tabdata.put("DOC_FOLDER_ID",			doc_folder_id);
			tabdata.put("DOC_FOLDER_NAME",			doc_folder_name);
			tabdata.put("PATIENT_PERIOD_SPECIFIC",	patient_period_specific);
			tabdata.put("PATIENT_ID",				patient_id);
			tabdata.put("EFF_STATUS",				eff_status);

			tabdata.put("ADDED_BY_ID",			addedById);
			tabdata.put("ADDED_DATE",			added_date);
			tabdata.put("ADDED_AT_WS_NO",		addedAtWorkstation);
	        tabdata.put("ADDED_FACILITY_ID",	facility_id);
			tabdata.put("MODIFIED_BY_ID",		modifiedById);
		    tabdata.put("MODIFIED_DATE",		modified_date);
			tabdata.put("MODIFIED_AT_WS_NO",	modifiedAtWorkstation);
			tabdata.put("MODIFIED_FACILITY_ID",	modifiedFacilityId);
			tabdata.put("locale",	locale);
			
		
			String dupflds[] = {"FACILITY_ID","DOC_FOLDER_ID"};
			String table_name ="FM_DOC_FOLDER";


		boolean local_ejbs = false;
				if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
					
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
				Object argArray[] = new Object[4];
					argArray[0] = p;
					argArray[1] = tabdata;
					argArray[2] = dupflds;
					argArray[3] = table_name;
					
					
				Class [] paramArray = new Class[4];
					paramArray[0] = p.getClass();
					paramArray[1] = tabdata.getClass();
					paramArray[2] = dupflds.getClass();
					paramArray[3] = table_name.getClass();
					
					
					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted	= (((Boolean) results.get("status")).booleanValue());
			String error		= (String) results.get("error");
			String error_value	= "0";
			tabdata.clear();			
			results.clear();
			if(inserted)
   		        error_value= "1";
		    res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value);
		}
		catch(Exception e)
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Inserted foll: Error Received : "+e.toString());
		}
	}
	public void updateDocumentFolder(HttpServletRequest req,HttpServletResponse res, String locale)
	{
		try
		{
			String addedById				= p.getProperty("login_user");
			String addedDate				= dateFormat.format(new java.util.Date());
			String modifiedById				= addedById;
			String modifiedDate				= addedDate;
	        String addedFacilityId			= facility_id;
		    String modifiedFacilityId		= addedFacilityId;
			String addedAtWorkstation		= client_ip_address;
	        String modifiedAtWorkstation	= addedAtWorkstation;			
			
			java.sql.Date modified_date = java.sql.Date.valueOf(modifiedDate);
			
			java.sql.Date fromPeriod = null;
			java.sql.Date toPeriod   = null;

			HashMap tabdata = new HashMap();

			if(!from_period.equals(""))
			{
				StringTokenizer st1 = new StringTokenizer(from_period,"/");
				String d11="";
				String d21="";
				String d31="";
				while(st1.hasMoreTokens())
				{
					d11=st1.nextToken();
					d21=st1.nextToken();
					d31=st1.nextToken();
				}
				String s1=d31+"-"+d21+"-"+d11;
				fromPeriod = java.sql.Date.valueOf(s1);
				tabdata.put("FROM_PERIOD", fromPeriod);
			}
			else
			{
				tabdata.put("FROM_PERIOD", from_period);
			}

			if(!to_period.equals(""))
			{
				StringTokenizer st1 = new StringTokenizer(to_period,"/");
				String d11="";
				String d21="";
				String d31="";
				while(st1.hasMoreTokens())
				{
					d11=st1.nextToken();
					d21=st1.nextToken();
					d31=st1.nextToken();
				}
				String s1=d31+"-"+d21+"-"+d11;
				toPeriod = java.sql.Date.valueOf(s1);
				tabdata.put("TO_PERIOD", toPeriod);
			}
			else
			{
				tabdata.put("TO_PERIOD", to_period);
			}
			
			tabdata.put("FACILITY_ID",				facility_id);
			tabdata.put("DOC_FOLDER_ID",			doc_folder_id);
			tabdata.put("DOC_FOLDER_NAME",			doc_folder_name);
			tabdata.put("PATIENT_PERIOD_SPECIFIC",	patient_period_specific);
			tabdata.put("PATIENT_ID",				patient_id);
			tabdata.put("EFF_STATUS",				eff_status);
			
			tabdata.put("MODIFIED_BY_ID",		modifiedById);
		    tabdata.put("MODIFIED_DATE",		modified_date);
			tabdata.put("MODIFIED_AT_WS_NO",	modifiedAtWorkstation);
			tabdata.put("MODIFIED_FACILITY_ID",	modifiedFacilityId);
			tabdata.put("locale",	locale);

			HashMap condflds = new HashMap();
			condflds.put("FACILITY_ID",		facility_id);
			condflds.put("DOC_FOLDER_ID",	doc_folder_id);
			String table_name ="FM_DOC_FOLDER";

			boolean local_ejbs = false;
				if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
					
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
				Object argArray[] = new Object[4];
					argArray[0] = p;
					argArray[1] = tabdata;
					argArray[2] = condflds;
					argArray[3] = table_name;
					
					
				Class [] paramArray = new Class[4];
					paramArray[0] = p.getClass();
					paramArray[1] = tabdata.getClass();
					paramArray[2] = condflds.getClass();
					paramArray[3] = table_name.getClass();
					
					
					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted				  = (((Boolean) results.get("status")).booleanValue());
			
			String error		= (String) results.get("error");
			String error_value	= "0";
			tabdata.clear();
			condflds.clear();
			results.clear();
			if(inserted)
				error_value = "1";
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value);
		}
		catch(Exception e)
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified : Error Received : "+e.toString());
		}
	}
}
