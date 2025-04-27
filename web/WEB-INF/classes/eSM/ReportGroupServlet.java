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

public class ReportGroupServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;

	String id;
	String longDesc ; 
	String shortDesc ;
	String reportService;
	String no_of_copies;
	int  noofcopies;
	String effectiveStatus ;

	String facilityId ;
	String client_ip_address ;
	HttpSession session;


	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";
		client_ip_address = p.getProperty("client_ip_address");

		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if ( operation.equals("insert") )		insertReportGroup(req, res);
			if ( operation.equals("modify"))		modifyReportGroup(req, res);
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
		String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = req.getQueryString() ;
		String source = url + params ;
		res.setContentType("text/html;charset=UTF-8");
		out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/ecis.css'></link><script language='javascript' src='../eSM/js/ReportGroup.js'></script><script language='javascript' src='../eCommon/js/common.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame' src='" + source + "' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
	catch(Exception e)	{	}
	}



	private void insertReportGroup(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			id=req.getParameter("id");
			longDesc = req.getParameter("long_desc");
			shortDesc = req.getParameter("short_desc");
			no_of_copies=req.getParameter("Dflt_No_Of_Copies");
			effectiveStatus = req.getParameter("eff_status");
			reportService="";

			if ( !no_of_copies.equals( "" ) )	noofcopies= Integer.parseInt( no_of_copies) ;

			if ( effectiveStatus == null )		effectiveStatus="D";

			id = req.getParameter("id");

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			Timestamp  ts= new Timestamp(System.currentTimeMillis() );	
			HashMap tabdata=new HashMap();
			String dft_print_id=req.getParameter("Dflt_Printer_Id");
			if(dft_print_id==null)
				dft_print_id="";
			tabdata.put("report_group_id",id);
			tabdata.put("report_service_id",reportService);
			tabdata.put("Dflt_Printer_Id",dft_print_id);
			tabdata.put("Dflt_No_Of_Copies",no_of_copies);
			tabdata.put("long_desc",longDesc);
			tabdata.put("short_desc",shortDesc);
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",ts);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("added_facility_id",addedFacilityId);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",ts);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("modified_facility_id",modifiedFacilityId );

			String dupflds[]={"report_group_id"};
	
			boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
					Object argArray[] = new Object[4];
					String table_name="sm_report_group";
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
			out.println( id + " "+longDesc + " "+shortDesc +" "+effectiveStatus );
		}
}

private void modifyReportGroup(HttpServletRequest req, HttpServletResponse res)
{
	try
			{
				id = req.getParameter("id");
				longDesc = req.getParameter("long_desc");
				shortDesc = req.getParameter("short_desc");
				no_of_copies=req.getParameter("Dflt_No_Of_Copies");

				effectiveStatus = req.getParameter("eff_status");
				reportService="";

				if ( effectiveStatus == null )
						effectiveStatus="D";

				if ( !no_of_copies.equals( "" ) )
								noofcopies= Integer.parseInt( no_of_copies) ;

				String addedById = p.getProperty( "login_user" ) ;
				String modifiedById = addedById ;
				String addedAtWorkstation=client_ip_address;
				String modifiedAtWorkstation = addedAtWorkstation ;

				Timestamp  ts= new Timestamp(System.currentTimeMillis() );	
				HashMap tabdata=new HashMap();
				String dft_print_id=req.getParameter("Dflt_Printer_Id");
					if(dft_print_id==null)
				dft_print_id="";
				tabdata.put("report_service_id",reportService);
				tabdata.put("Dflt_Printer_Id",dft_print_id);
				tabdata.put("Dflt_No_Of_Copies",no_of_copies);
				tabdata.put("long_desc",longDesc);
				tabdata.put("short_desc",shortDesc);
				tabdata.put("eff_status",effectiveStatus);

				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",ts);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

				HashMap condflds=new HashMap();
				condflds.put("report_group_id",id);
		
				boolean local_ejbs = false;
			
						if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

						Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
						Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
						Object argArray[] = new Object[4];
						String table_name="sm_report_group";
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
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
				 tabdata.clear();
				 condflds.clear();
				 results.clear();
			}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( id + " "+longDesc + " "+shortDesc +" "+effectiveStatus );
		}
	}
}
