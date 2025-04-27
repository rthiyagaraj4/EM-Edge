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
import eSM.MenuHeader.*;
import com.ehis.util.*;

public class MenuHeaderServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	Properties p;
	String  menuid ;
	String menuname;
	String rootmenu;
	String remarks;
	String resp_group_id;
	String facilityId ;
	String client_ip_address ;
	String locale ;
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
		locale = p.getProperty("LOCALE");	
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if ( operation.equals("insert"))	insertMenuHeader(req, res);
			if ( operation.equals("modify"))	modifyMenuHeader(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		try	{
			this.out = res.getWriter();
			res.setContentType("text/html;charset=UTF-8");

			String url = "../eCommon/jsp/commonToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eSM/js/SiteParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='" + source + "' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eSM/jsp/siteblank.jsp' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html>");
			}
		catch(Exception e)	{	}
		}

/**************************************************************************/
	private void insertMenuHeader(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			String from_date ="";
			String to_date ="";

			HashMap tabdata=new HashMap();
			tabdata.put("menu_id",req.getParameter("menuid")== null ?"":req.getParameter("menuid"));
			tabdata.put("menu_name",req.getParameter("menuname")== null ?"":req.getParameter("menuname"));
			tabdata.put("root_menu_yn",req.getParameter("rootmenu")== null ?"N":req.getParameter("rootmenu"));
			tabdata.put("resp_group_id",req.getParameter("resp_group_id1")== null ?"":req.getParameter("resp_group_id1"));
			tabdata.put("adhoc_menu_yn",req.getParameter("adhocmenu")== null ?"N":req.getParameter("adhocmenu"));
            from_date = req.getParameter("from_date")== null ?"":req.getParameter("from_date");
			from_date = DateUtils.convertDate(from_date,"DMY",locale,"en");
			tabdata.put("adhoc_menu_eff_from",from_date);
            to_date = req.getParameter("to_date")== null ?"":req.getParameter("to_date");
			to_date = DateUtils.convertDate(to_date,"DMY",locale,"en");
			tabdata.put("adhoc_menu_eff_to",to_date);
			tabdata.put("remarks",req.getParameter("remarks")== null ?"":req.getParameter("remarks"));
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("dev_tool",req.getParameter("tool_used")== null ?"":req.getParameter("tool_used"));
	
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/MenuHeaderManager",MenuHeaderHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			HashMap argMap=new HashMap();
			argMap.put("p",p);
			argMap.put("tabdata",tabdata);
			
					
			Object argArray[] = new Object[1];
			argArray[0] = argMap;

			Class [] paramArray = new Class[1];
			paramArray[0] = argMap.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertMenuHeader",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted ) error_value = "1" ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			tabdata.clear();
			argMap.clear();
			results.clear();
		}
		catch ( Exception e )
			{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( menuid + " "+menuname +" "+rootmenu+" "+remarks+" "+ resp_group_id );
			}
		}
/**************************************************************************/
		private void modifyMenuHeader(HttpServletRequest req, HttpServletResponse res)
		{
			try
				{
				if(rootmenu==null)	rootmenu="N";
				String addedById = p.getProperty( "login_user" ) ;
				String modifiedById = addedById ;
				String addedAtWorkstation=client_ip_address;
				String modifiedAtWorkstation = addedAtWorkstation ;
			    String from_date             = "";
			    String to_date               = "";

				Timestamp  ts= new Timestamp(System.currentTimeMillis() );

				HashMap tabdata=new HashMap();
				tabdata.put("menu_id",req.getParameter("menuid")== null ?"":req.getParameter("menuid"));
				tabdata.put("menu_name",req.getParameter("menuname")== null ?"":req.getParameter("menuname"));
				tabdata.put("root_menu_yn",req.getParameter("rootmenu")== null ?"N":req.getParameter("rootmenu"));
				tabdata.put("resp_group_id",req.getParameter("resp_group_id1")== null ?"":req.getParameter("resp_group_id1"));
				tabdata.put("adhoc_menu_yn",req.getParameter("adhocmenu")== null ?"N":req.getParameter("adhocmenu"));
				from_date = req.getParameter("from_date")== null ?"":req.getParameter("from_date");
				from_date = DateUtils.convertDate(from_date,"DMY",locale,"en");
				tabdata.put("adhoc_menu_eff_from",from_date);
				to_date = req.getParameter("to_date")== null ?"":req.getParameter("to_date");
				to_date = DateUtils.convertDate(to_date,"DMY",locale,"en");
			    tabdata.put("adhoc_menu_eff_to",to_date);
				tabdata.put("remarks",req.getParameter("remarks"));
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",ts);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
				tabdata.put("dev_tool",req.getParameter("tool_used")== null ?"":req.getParameter("tool_used"));

				boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/MenuHeaderManager",MenuHeaderHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		HashMap argMap=new HashMap();
		argMap.put("p",p);
		argMap.put("tabdata",tabdata);
		
		Object argArray[] = new Object[1];
		
		argArray[0] = argMap;
		Class [] paramArray = new Class[1];
		paramArray[0] = argMap.getClass();
	
		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateMenuHeader",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;

				if ( inserted ) error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
				tabdata.clear();
				argMap.clear();
				results.clear();

			}
			catch ( Exception e )
			{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( menuid + " "+menuname +" "+rootmenu+" "+remarks+" "+ resp_group_id );
			}
		}
	} 
