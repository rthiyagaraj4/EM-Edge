/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import eCommon.SingleTabHandler.*;

public class LodgerStayReasonServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;

	String reasonforstaycode;
	String longdesc ;
	String shortdesc ;
	String effstatus ;
	String client_ip_address ;
    String facilityId;
	String table_name;
	HttpSession session;

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);	
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session				= req.getSession(false);
		this.p				= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId		= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= p.getProperty("client_ip_address");

		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out		 = res.getWriter();
			String operation = req.getParameter("function_name");

			if (operation.equals("insert"))	insertLodgerStayReason(req, res);
			if (operation.equals("modify"))	modifyLodgerStayReason(req, res);
			out.println(operation);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void insertLodgerStayReason(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
		    facilityId					 = (String) session.getValue( "facility_id" ) ;
			reasonforstaycode			 = req.getParameter("reason_for_stay_code");
			longdesc				   	 = req.getParameter("long_desc");
			shortdesc					 = req.getParameter("short_desc");
			effstatus					 = req.getParameter("eff_status");
			if ( effstatus == null || effstatus.equals("null"))
				effstatus="D";
			String addedById			 = p.getProperty( "login_user" ) ;
			String modifiedById			 = addedById ;
			String addedFacilityId	     = facilityId;
			String modifiedFacilityId	 = addedFacilityId ;
			String addedAtWorkstation	 = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			Timestamp added_date		 = new Timestamp(System.currentTimeMillis() );
			Timestamp modified_date		 = new Timestamp(System.currentTimeMillis() );

			HashMap tabdata				 = new HashMap();

			tabdata.put("reason_for_stay_code",reasonforstaycode);
			tabdata.put("long_desc",longdesc);
			tabdata.put("short_desc",shortdesc);
			tabdata.put("eff_status",effstatus);

			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"reason_for_stay_code"};

			table_name					= "ip_reason_for_lodger_stay";
			boolean local_ejbs			= false;
			
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;


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

			boolean inserted    = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error		= (String) results.get("error") ;
			String error_value  = "0" ;

			if ( inserted )
			{
				 error_value	= "1" ;
			}
			else
			{
				 error			= (String) results.get("error") ;

			}
			error = (String) results.get("error") ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );

			tabdata.clear();
			results.clear();

		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	private void modifyLodgerStayReason(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{

			reasonforstaycode = req.getParameter("reason_for_stay_code");
			longdesc		  = req.getParameter("long_desc");
			shortdesc		  = req.getParameter("short_desc");
			effstatus		  = req.getParameter("eff_status");

			if ( effstatus == null || effstatus.equals("null"))
				effstatus="D";

			String addedById				= p.getProperty( "login_user" ) ;
			String addedDate				= dateFormat.format( new java.util.Date() ) ;
			String modifiedById				= addedById ;
			String modifiedDate				= addedDate ;
			String addedFacilityId			= facilityId;
			String modifiedFacilityId		= addedFacilityId ;
			String addedAtWorkstation		= client_ip_address;
			String modifiedAtWorkstation	= addedAtWorkstation ;
			java.sql.Date modified_date		= java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata = new HashMap();

			tabdata.put("long_desc",longdesc);
			tabdata.put("short_desc",shortdesc);
			tabdata.put("reason_for_stay_code",reasonforstaycode);
			tabdata.put("eff_status",effstatus);

			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds = new HashMap();
			condflds.put("reason_for_stay_code",reasonforstaycode);

			table_name			= "ip_reason_for_lodger_stay";
			boolean local_ejbs	= false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;

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
			  
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;

			tabdata.clear();
			condflds.clear();
			
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

			results.clear();
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
}
