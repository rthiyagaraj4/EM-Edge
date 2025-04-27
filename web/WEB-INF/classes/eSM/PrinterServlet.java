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

public class PrinterServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	java.util.Properties p;

	String printerid; 
	String printername ;
	String queuename ;
	String reportservice;
	String facilityId ;
	String client_ip_address ;
	HttpSession session;


	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";
		client_ip_address = p.getProperty("client_ip_address");

		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			out = res.getWriter();
			String operation = req.getParameter("function");
			if(operation == null) operation="";
			if ( operation.equals("insert") )		insertPrinter(req, res);
			else		modifyPrinter(req, res);
		
			out = null;
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
	try	{
	out = res.getWriter();
	String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = req.getQueryString() ;
	String source = url + params ;
	res.setContentType("text/html;charset=UTF-8");
	out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link><script language='Javascript' src='../eSM/js/Printer.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame' src='" + source + "'  frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no'></frameset></html> ");
	}
	catch(Exception e)	{	}
	}



	private void insertPrinter(HttpServletRequest req, HttpServletResponse res)
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			printerid=req.getParameter("printer_id");
			printername= req.getParameter("printer_name");
			queuename= req.getParameter("queue_name");
			reportservice = req.getParameter("report_service");

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			Timestamp  ts= new Timestamp(System.currentTimeMillis() );

			HashMap tabdata=new HashMap();
			tabdata.put("printer_id",printerid);
			tabdata.put("printer_type",req.getParameter("printer_type"));
			tabdata.put("printer_name",printername);
			tabdata.put("queue_name",queuename);
			tabdata.put("eff_status",req.getParameter("eff_status")== null ?"D":req.getParameter("eff_status"));
			tabdata.put("report_service_id",reportservice);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",ts);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("added_facility_id",addedFacilityId);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",ts);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("modified_facility_id",modifiedFacilityId);

			String dupflds[]={"printer_id"};

			boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
					Object argArray[] = new Object[4];
					String table_name="sm_printer";
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
                 tabdata.clear();

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
			results.clear();
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );

	}
catch ( Exception e )
	{
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		out.println( "Values sent are : <br>" ) ;
		out.println( printerid + " "+printername + " "+queuename +" "+  (req.getParameter("eff_status")== null ?"D":req.getParameter("eff_status")) +" "+reportservice);
	}
}

private void modifyPrinter(HttpServletRequest req, HttpServletResponse res)
{
	PrintWriter out = null;
	try
		{
			out = res.getWriter();
			printerid=req.getParameter("printer_id");
			printername= req.getParameter("printer_name");
			queuename= req.getParameter("queue_name");
			reportservice = req.getParameter("report_service");

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			Timestamp  ts= new Timestamp(System.currentTimeMillis() );
			HashMap tabdata=new HashMap();
			tabdata.put("printer_type",req.getParameter("printer_type"));
			tabdata.put("printer_name",printername);
			tabdata.put("queue_name",queuename);
			tabdata.put("eff_status",req.getParameter("eff_status")== null ?"D":req.getParameter("eff_status"));
			tabdata.put("report_service_id",reportservice);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",ts);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("modified_facility_id",modifiedFacilityId);

			HashMap condflds=new HashMap();
			condflds.put("printer_id",printerid);

			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
					Object argArray[] = new Object[4];
					String table_name="sm_printer";
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
			tabdata.clear();
			condflds.clear();
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
			results.clear();
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( printerid + " "+printername + " "+queuename +" "+(req.getParameter("eff_status")== null ?"D":req.getParameter("eff_status")) +" "+reportservice);
		}
	}
}
