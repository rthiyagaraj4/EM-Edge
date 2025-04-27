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

public class BlockingTypeServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	Properties p;
	String facilityId ;
	String client_ip_address ;
	String table_name;
	HttpSession session;
	String sStyle;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session				= req.getSession(false);
		this.p				= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId		= (String) session.getValue( "facility_id" ) ;
		
		client_ip_address	= p.getProperty("client_ip_address");
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		try
		{
			res.setContentType("text/html;charset=UTF-8");
			this.out		 = res.getWriter();
			String operation = req.getParameter("function_name");

			if ( operation.equals("insert"))    insertBlockingType(req, res);
			if ( operation.equals("modify"))    modifyBlockingType(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out		= res.getWriter();
			res.setContentType("text/html;charset=UTF-8");
			sStyle			=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='/eCIS/ip/js/NursUnitRoom.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/commonToolbar.jsp?function_name=Rooms For Nursing Unit' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
			doPost(req, res);
		}
		catch(Exception e)	{	}
	}

	private void insertBlockingType(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			Timestamp added_date = new Timestamp(System.currentTimeMillis() );

			HashMap tabdata = new HashMap();
			tabdata.put("blocking_type_code",checkForNull(req.getParameter("blocking_type_code")));
			tabdata.put("short_desc",checkForNull(req.getParameter("short_desc")));
			tabdata.put("long_desc",checkForNull(req.getParameter("long_desc")));

			tabdata.put("DFLT_MIN_BLOCK_PERIOD",checkForNull(req.getParameter("bed_block_period_max")));
			tabdata.put("DFLT_BLOCK_UNITS",checkForNull(req.getParameter("bed_block_period_max_type")));

			tabdata.put("override_yn",checkForNull(req.getParameter("override"),"N"));
			tabdata.put("eff_status",checkForNull(req.getParameter("eff_status"),"D"));
			tabdata.put("blocking_hours",checkForNull(req.getParameter("blocking_hours")));

			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id",facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",added_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"blocking_type_code"};

			table_name		   = "ip_blocking_type";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
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

			boolean inserted   = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error       = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted )
			{
				error_value = "1" ;
			}

			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			 tabdata.clear();
			 results.clear();
	   }
	   catch ( Exception e )
	   {
						e.printStackTrace();
	   }
	}

		private void modifyBlockingType(HttpServletRequest req, HttpServletResponse res)
		{
			try
			{
				//String addedById			 = p.getProperty( "login_user" ) ;
				String modifiedById			 = p.getProperty( "login_user" ) ;
				String addedFacilityId       = facilityId;
				String modifiedFacilityId    = addedFacilityId ;
				String addedAtWorkstation    = client_ip_address;
				String modifiedAtWorkstation = addedAtWorkstation ;

				Timestamp modified_date = new Timestamp(System.currentTimeMillis() );

				HashMap tabdata = new HashMap();

				tabdata.put("short_desc",checkForNull(req.getParameter("short_desc")));
				tabdata.put("long_desc",checkForNull(req.getParameter("long_desc")));
				tabdata.put("override_yn",checkForNull(req.getParameter("override"),"N"));
				tabdata.put("eff_status",checkForNull(req.getParameter("eff_status"),"D"));
				tabdata.put("blocking_hours",checkForNull(req.getParameter("blocking_hours")));

				tabdata.put("DFLT_MIN_BLOCK_PERIOD",checkForNull(req.getParameter("bed_block_period_max")));
				tabdata.put("DFLT_BLOCK_UNITS",checkForNull(req.getParameter("bed_block_period_max_type")));

				//tabdata.put("added_by_id",addedById);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",modified_date);
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

				HashMap condflds = new HashMap();
				condflds.put("blocking_type_code",checkForNull(req.getParameter("blocking_type_code")));

			table_name			= "ip_blocking_type";
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
			if ( inserted )
			{
			 error_value = "1" ;
			}
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );

			 tabdata.clear();
			 results.clear();
			 condflds.clear();
			}
			catch ( Exception e )
			{
				e.printStackTrace();
			}
	}
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
