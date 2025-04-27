/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//Maheshwaran K created this file for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eCommon.SingleTabHandler.*;

import eCommon.XSSRequestWrapper;

public class NotifiableSetupServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;
	String notify_code;
	String longDesc ;
	String shortDesc ;
	String default_note_type;
	String email_applicable;
	String effectiveStatus ;
	String facilityId ;
	String client_ip_address ;

	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
	//System.out.println("doPost called===========================");
		session = req.getSession(false);
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		try
		{			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
			
			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if ( operation.equals("insert") )   insertNotificationSetup(req, res);
			if ( operation.equals("modify"))    modifyNotificationSetup(req, res);
		}
		catch(Exception e)
		{
			/* out.println(e.toString()); */
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
	//System.out.println("doGet called===========================");
		try
		{
			this.out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			String operation = req.getParameter("function");

			if ( operation.equals("insert") )   insertNotificationSetup(req, res);
			if ( operation.equals("modify"))    modifyNotificationSetup(req, res);
		}
		catch(Exception e)	{	/* out.println(e.toString()); */e.printStackTrace();	}
	}

	private void modifyNotificationSetup(HttpServletRequest req, HttpServletResponse res)
	{
	  //System.out.println("modifyNotificationSetup==================================");
		try
		{
			notify_code =req.getParameter("notify_code");
			longDesc = req.getParameter("long_desc");
			shortDesc = req.getParameter("short_desc");
			default_note_type = req.getParameter("default_note_type");
			email_applicable = req.getParameter("email_applicable");
			effectiveStatus = req.getParameter("eff_status");
			if ( email_applicable == null )
				email_applicable="N";

			if ( effectiveStatus == null )
				effectiveStatus="D";
			/* System.out.println("notify_code ==="+notify_code);
			System.out.println("longDesc ==="+longDesc);
			System.out.println("shortDesc ==="+shortDesc);
			System.out.println("default_note_type ==="+default_note_type);
			System.out.println("email_applicable ==="+email_applicable);
			System.out.println("effectiveStatus ==="+effectiveStatus); */
			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();
			tabdata.put("long_desc",longDesc);
			tabdata.put("short_desc",shortDesc);
			tabdata.put("default_note_type",default_note_type);
			tabdata.put("email_applicable",email_applicable);
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("added_by_id",addedById);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
//System.out.println("1111111111111111111");
			HashMap condflds=new HashMap();
			condflds.put("NOTIFICATION_CODE",notify_code);
					//System.out.println("22222222222222");	
			String tableName = "MR_NOTIFICATION_SETUP";
			boolean local_ejbs = false;
//System.out.println("333333333333333333");
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tableName.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			
			//System.out.println("inserted =============="+inserted);
			String error = (String) results.get("error") ;
			//System.out.println("error =============="+error);
			String error_value = "0" ;
			if ( inserted )
				error_value = "1" ;
			else
				error = (String) results.get("error") ;

			error = (String) results.get("error") ;			
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
			if ( condflds != null) condflds.clear();
		}
		catch ( Exception e )
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( notify_code + " "+longDesc + " "+shortDesc + " " +default_note_type+" "+email_applicable+" "+ effectiveStatus ); */
			
			e.printStackTrace();
		}
	
	
	
	}
	
	private void insertNotificationSetup(HttpServletRequest req, HttpServletResponse res)
	{
	/*System.out.println("insertNotificationSetup=================================="); */
		try
		{  
			notify_code =req.getParameter("notify_code");
			longDesc = req.getParameter("long_desc");
			shortDesc = req.getParameter("short_desc");
			default_note_type = req.getParameter("default_note_type");
			email_applicable = req.getParameter("email_applicable");
			effectiveStatus = req.getParameter("eff_status");
			if ( email_applicable == null )
				email_applicable="N";
			
			
			if ( effectiveStatus == null )
				effectiveStatus="D";
			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;

			String modifiedById = addedById ;
			String modifiedDate = addedDate ;

			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();
			tabdata.put("NOTIFICATION_CODE",notify_code);
			tabdata.put("long_desc",longDesc);
			tabdata.put("short_desc",shortDesc);
			tabdata.put("default_note_type",default_note_type);
			tabdata.put("email_applicable",email_applicable);
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"NOTIFICATION_CODE"};

			String tableName = "MR_NOTIFICATION_SETUP";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tableName.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted )
				error_value = "1" ;
			else
				error = (String) results.get("error") ;

			error = (String) results.get("error") ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
		}catch ( Exception e )
		{ 
			/*out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( notify_code + " "+longDesc + " "+shortDesc + " " +default_note_type+" "+email_applicable+" "+ effectiveStatus ); */
			
			e.printStackTrace();
		}
	}
}
