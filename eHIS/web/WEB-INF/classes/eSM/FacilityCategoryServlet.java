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

public class FacilityCategoryServlet extends javax.servlet.http.HttpServlet
{
java.util.Properties p;
String operation ="";
String  ws_no             = "" ;
String uid                  = "";
String facilityId="";

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		HttpSession session = req.getSession(false);
		this.facilityId = (String)session.getValue("facility_id") ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;

		try
		{
			p                   = ( java.util.Properties ) session.getValue( "jdbc" ) ;
			ws_no                   = req.getRemoteAddr() ;
			uid = p.getProperty( "login_user" ) ;
			operation = req.getParameter("function_name");

			if ( operation.equals("insert") )
				insertFcilityCategory(req, res);
			if ( operation.equals("modify"))
				modifyFcilityCategory(req, res);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void insertFcilityCategory(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{

			HashMap tabdata=new HashMap();

			tabdata.put("facility_level_code",(req.getParameter("facility_category_code")==null?"":req.getParameter("facility_category_code")));
			tabdata.put("long_desc",(req.getParameter("long_desc")==null?"":req.getParameter("long_desc")));
			tabdata.put("short_desc",(req.getParameter("short_desc")==null?"":req.getParameter("short_desc")));
			tabdata.put("eff_status",(req.getParameter("eff_status")==null?"D":req.getParameter("eff_status")));

			tabdata.put("added_by_id",uid);
			tabdata.put("added_date",new java.sql.Date(System.currentTimeMillis()));
			tabdata.put("added_at_ws_no",ws_no);
			tabdata.put("added_facility_id",facilityId);
			tabdata.put("modified_by_id",uid);
			tabdata.put("modified_date",new java.sql.Date(System.currentTimeMillis()));
			tabdata.put("modified_at_ws_no",ws_no);
			tabdata.put("modified_facility_id",facilityId);

			String dupflds[]={"facility_level_code"};

		    boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[4];
				String table_name="SM_FACILITY_LEVEL";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =dupflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =dupflds.getClass();
					paramArray[3] =table_name.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);




			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;

			String error_value = "0" ;
            results.clear();
			if ( inserted ) error_value = "1" ;
		    {
		    }
			res.sendRedirect("../../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8"  ) + "&err_value=" + error_value );
			tabdata.clear();
		    } catch ( Exception e ) {

			e.printStackTrace();
		    }

	}

	private void modifyFcilityCategory(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
		    HashMap tabdata=new HashMap();
			tabdata.put("long_desc",(req.getParameter("long_desc")==null?"":req.getParameter("long_desc")));
			tabdata.put("short_desc",(req.getParameter("short_desc")==null?"":req.getParameter("short_desc")));
			tabdata.put("eff_status",(req.getParameter("eff_status")==null?"D":req.getParameter("eff_status")));

		    tabdata.put("modified_by_id",uid);
		    tabdata.put("modified_date",new java.sql.Date(System.currentTimeMillis()));
		    tabdata.put("modified_at_ws_no",ws_no);
		    tabdata.put("modified_facility_id",facilityId);

		    HashMap condflds=new HashMap();
			condflds.put("facility_level_code",(req.getParameter("facility_category_code")==null?"":req.getParameter("facility_category_code")));

			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			String table_name="SM_FACILITY_LEVEL";
			argArray[0] =p;
			argArray[1] =tabdata;
			argArray[2] =condflds;
			argArray[3] =table_name;

			Class [] paramArray = new Class[4];
			paramArray[0] =p.getClass();
			paramArray[1] =tabdata.getClass();
			paramArray[2] =condflds.getClass();
			paramArray[3] =table_name.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
            condflds.clear();
			results.clear();
			if ( inserted ) error_value = "1" ;
		    {
		    }
			res.sendRedirect("../../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8" ) + "&err_value=" + error_value );
			tabdata.clear();
		}
		catch ( Exception e ) {
		    e.printStackTrace();

		}
	    }
}
