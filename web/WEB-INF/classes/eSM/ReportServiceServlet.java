/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;

import eCommon.SingleTabHandler.*;

public class ReportServiceServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;

	String Report_Service_Id; 
	String Report_Service_Name ;
	String Remarks ;
	String effectiveStatus ;
	String app_server_ip ;
	String rep_cfg_key ;
	String facilityId ;
	String client_ip_address ;
	HttpSession session;


	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";
		client_ip_address = p.getProperty("client_ip_address");
		app_server_ip	= req.getParameter( "app_server_ip" ) ;
		rep_cfg_key	= req.getParameter( "rep_cfg_key" )==null?"":req.getParameter( "rep_cfg_key" ) ;

			if ( app_server_ip == null ) app_server_ip = "" ;
        out.println("<script src='../eCommon/js/common.js' language='javascript'></script>");
		try
		{
					

			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if ( operation.equals("insert") )		insertReportService(req, res);
			if ( operation.equals("modify"))		modifyReportService(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
		try	{
		this.out = res.getWriter();
        out.println("<script src='../eCommon/js/common.js' language='javascript'></script>");
 		String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = req.getQueryString() ;
		String source = url + params ;
		out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/ecis.css'></link><script language='javascript' src='../eSM/js/ReportService.js'></script><script language='javascript' src='../eCommon/js/common.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='" + source + "' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
	catch(Exception e)	{	}
	}

	private void insertReportService(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			Report_Service_Id=req.getParameter("Report_Service_Id");
			Report_Service_Name = req.getParameter("Report_Service_Name");
			Remarks = req.getParameter("Remarks");
			effectiveStatus = req.getParameter("eff_status");
			if ( effectiveStatus == null )
				effectiveStatus="D";

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			Timestamp  ts= new Timestamp(System.currentTimeMillis() );		
			HashMap tabdata=new HashMap();
			tabdata.put("Report_Service_Id",Report_Service_Id);
			tabdata.put("Report_Service_Name",Report_Service_Name);
			tabdata.put("Remarks",Remarks);
			tabdata.put("app_server_ip",app_server_ip);
			tabdata.put("rep_cfg_key",rep_cfg_key);
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",ts);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("added_facility_id",addedFacilityId);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",ts);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("modified_facility_id",modifiedFacilityId );

			String dupflds[]={"Report_Service_Id"};

			boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
					Object argArray[] = new Object[4];
					String table_name="Sm_Report_Service";
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
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
				 error_value = "1" ;
			}
			else
			{
				 error = (String) results.get("error") ;
			}

        	error = (String) results.get("error") ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
            tabdata.clear();
			results.clear();
	}
	catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( Report_Service_Id + " "+Report_Service_Name + " "+Remarks +" "+ effectiveStatus );
		}
}

private void modifyReportService(HttpServletRequest req, HttpServletResponse res)
{
	try
		{
			Report_Service_Id=req.getParameter("Report_Service_Id");
			Report_Service_Name = req.getParameter("Report_Service_Name");
			Remarks = req.getParameter("Remarks");
			effectiveStatus = req.getParameter("eff_status");
			if ( effectiveStatus == null )
				effectiveStatus="D";

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			Timestamp  ts= new Timestamp(System.currentTimeMillis() );	
			HashMap tabdata=new HashMap();
			tabdata.put("Report_Service_Name",Report_Service_Name);
			tabdata.put("Remarks",Remarks);
			tabdata.put("app_server_ip",app_server_ip);
			tabdata.put("rep_cfg_key",rep_cfg_key);
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",ts);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds=new HashMap();
			condflds.put("Report_Service_Id",Report_Service_Id);
	
			boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
					Object argArray[] = new Object[4];
					String table_name="Sm_Report_Service";
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
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
				 error_value = "1" ;
			}
			else
			{
				 error = (String) results.get("error") ;
			}

        	error = (String) results.get("error") ;
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
             tabdata.clear();
			 condflds.clear();
			 results.clear();
		}
		catch ( Exception e )
		{
			out.println("Exception raise by Servlet ...So Record Not Modified Foll: Error Received : "+e.toString());
			out.println( "Values sent are :" ) ;
			out.println( Report_Service_Id + " "+Report_Service_Name + " "+Remarks +" "+ effectiveStatus );
		}
	}
}
