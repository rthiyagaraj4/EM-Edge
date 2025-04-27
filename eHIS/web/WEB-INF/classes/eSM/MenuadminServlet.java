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
import com.ehis.util.*;

import eSM.MenuAdmin.*;

public class MenuadminServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	Properties p; 
	String facilityId ;
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
		locale			=   p.getProperty("LOCALE");

		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");

			if ( operation.equals("insert") )  insertMenuadmin(req, res);
			if ( operation.equals("modify"))    modifyMenuadmin(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	private void insertMenuadmin(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
                String eff_date_from = "";
                String eff_date_to = "";
				HashMap tabdata=new HashMap();
				eff_date_from = req.getParameter("eff_date_from")== null ?"":req.getParameter("eff_date_from");
                eff_date_from = DateUtils.convertDate(eff_date_from,"DMY",locale,"en");
				eff_date_to = req.getParameter("eff_date_to")== null ?"":req.getParameter("eff_date_to");
                eff_date_to = DateUtils.convertDate(eff_date_to,"DMY",locale,"en");
				tabdata.put("menu_admin_id",req.getParameter("menu_admin_id")== null ?"":req.getParameter("menu_admin_id"));
				tabdata.put("resp_group_id",req.getParameter("resp_group_id")== null ?"":req.getParameter("resp_group_id"));
				tabdata.put("eff_date_from",eff_date_from);
				tabdata.put("eff_date_to",eff_date_to);
				tabdata.put("eff_status",req.getParameter("eff_status")== null ?"D":req.getParameter("eff_status"));
				tabdata.put("added_by_id",p.getProperty( "login_user" )== null ?"":p.getProperty( "login_user" ));
				tabdata.put("added_at_ws_no",p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address"));
				tabdata.put("modified_by_id", p.getProperty( "login_user" )== null ?"":p.getProperty( "login_user" ));
				tabdata.put("modified_at_ws_no",p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address"));

		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/MenuAdminManager",MenuAdminHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		HashMap argMap=new HashMap ();
		argMap.put("p",p);
		argMap.put("data",tabdata);
		Object argArray[] = new Object[1];
		argArray[0] =argMap ;
			
		Class [] paramArray = new Class[1];

		paramArray[0] = argMap.getClass();
		
		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertMenuAdmin",paramArray)).invoke(busObj,argArray);

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
						out.println( (req.getParameter("menu_admin_id")== null ?"":req.getParameter("menu_admin_id"))+ " "+(req.getParameter("resp_group_id")== null ?"":req.getParameter("resp_group_id"))+ " "+(req.getParameter("eff_date_from")== null ?"":req.getParameter("eff_date_from"))+" "+ " "+(req.getParameter("eff_date_to")== null ?"":req.getParameter("eff_date_to"))+" "+(req.getParameter("eff_status")== null ?"D":req.getParameter("eff_status")) );
		}
	}

/****************************************************************************/
private void modifyMenuadmin(HttpServletRequest req, HttpServletResponse res)
		{
			try
			{
				String eff_date_from = "";
                String eff_date_to = "";
				eff_date_from = req.getParameter("eff_date_from")== null ?"":req.getParameter("eff_date_from");
                eff_date_from = DateUtils.convertDate(eff_date_from,"DMY",locale,"en");
				eff_date_to = req.getParameter("eff_date_to")== null ?"":req.getParameter("eff_date_to");
                eff_date_to = DateUtils.convertDate(eff_date_to,"DMY",locale,"en");
				HashMap tabdata=new HashMap();
				tabdata.put("resp_group_id",req.getParameter("resp_group_id1")== null ?"":req.getParameter("resp_group_id1"));
				tabdata.put("eff_date_from",eff_date_from);
				tabdata.put("eff_date_to",eff_date_to);
				tabdata.put("eff_status",req.getParameter("eff_status")== null ?"D":req.getParameter("eff_status"));
				tabdata.put("modified_by_id", p.getProperty( "login_user" )== null ?"":p.getProperty( "login_user" ));
				tabdata.put("modified_at_ws_no",p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address") );
				tabdata.put("menu_admin_id",req.getParameter("menu_admin_id1")== null ?"":req.getParameter("menu_admin_id1") );

		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/MenuAdminManager",MenuAdminHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		HashMap argMap=new HashMap ();
		argMap.put("p",p);
		argMap.put("data",tabdata);
		
		Object argArray[] = new Object[1];
		argArray[0] =argMap ;
			
		Class [] paramArray = new Class[1];

		paramArray[0] = argMap.getClass();
		
		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateMenuAdmin",paramArray)).invoke(busObj,argArray);

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
				out.println( (req.getParameter("menu_admin_id1")== null ?"":req.getParameter("menu_admin_id1"))+ " "+(req.getParameter("resp_group_id1")== null ?"":req.getParameter("resp_group_id1"))+ " "+(req.getParameter("eff_date_from")== null ?"":req.getParameter("eff_date_from"))+" "+ " "+(req.getParameter("eff_date_to")== null ?"":req.getParameter("eff_date_to"))+" "+(req.getParameter("eff_status")== null ?"D":req.getParameter("eff_status")));
		}
	}
} 
