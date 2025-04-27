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


import eCommon.SingleTabHandler.*;

public class RespgroupServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	Properties p;

	String resp_group_id;
	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;

		try
		{
			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");

			if ( operation.equals("insert") )  insertRespgroup(req, res);
			if ( operation.equals("modify"))    modifyRespgroup(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	private void insertRespgroup(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{  
			resp_group_id	=req.getParameter("resp_group_id");
			resp_group_id=resp_group_id.toUpperCase();

				HashMap tabdata=new HashMap();
				tabdata.put("resp_group_id",resp_group_id);
				tabdata.put("resp_group_name",req.getParameter("resp_group_name")== null ?"":req.getParameter("resp_group_name"));
				tabdata.put("eff_status",req.getParameter("eff_status")== null ?"D":req.getParameter("eff_status"));
				Timestamp  ts= new Timestamp(System.currentTimeMillis() );
				tabdata.put("added_by_id", p.getProperty( "login_user" )== null ?"": p.getProperty( "login_user" ));
				tabdata.put("added_date",ts);
				tabdata.put("added_at_ws_no",p.getProperty("client_ip_address")== null ?"": p.getProperty("client_ip_address"));
				tabdata.put("modified_by_id",p.getProperty( "login_user" )== null ?"": p.getProperty( "login_user"));
				tabdata.put("modified_date",ts);
				tabdata.put("modified_at_ws_no",p.getProperty("client_ip_address")== null ?"": p.getProperty("client_ip_address") );

				String dupflds[]={"resp_group_id"};
			out.println("C");

			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			
			Object argArray[] = new Object[4];
			String table_name="sm_resp_grp";
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
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
						}
						else
						{
						 error = (String) results.get("error") ;
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" ) );
						}

        	error = (String) results.get("error") ;
            tabdata.clear();
			results.clear();
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
						out.println( resp_group_id+ " "+(req.getParameter("resp_group_name")== null ?"":req.getParameter("resp_group_name"))+" "+(req.getParameter("eff_status")== null ?"D":req.getParameter("eff_status")) );
		}
	}


		private void modifyRespgroup(HttpServletRequest req, HttpServletResponse res)
		{
			try
			{ 
				resp_group_id	=req.getParameter("resp_group_id");
				resp_group_id=resp_group_id.toUpperCase();

				Timestamp  ts= new Timestamp(System.currentTimeMillis() );


				HashMap tabdata=new HashMap();
				tabdata.put("resp_group_name",req.getParameter("resp_group_name")== null ?"":req.getParameter("resp_group_name"));
				tabdata.put("eff_status",req.getParameter("eff_status")== null ?"D":req.getParameter("eff_status"));

				tabdata.put("added_by_id", p.getProperty( "login_user" )== null ?"": p.getProperty( "login_user" ));
				tabdata.put("modified_by_id", p.getProperty( "login_user" )== null ?"": p.getProperty( "login_user"));
				tabdata.put("modified_date",ts);
				tabdata.put("modified_at_ws_no",p.getProperty("client_ip_address")== null ?"": p.getProperty("client_ip_address"));

				HashMap condflds=new HashMap();
				condflds.put("resp_group_id",resp_group_id);

			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			Object argArray[] = new Object[4];
			String table_name="sm_resp_grp";
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
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
						}
						else
						{
						 error = (String) results.get("error") ;
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" ) );
						}
            tabdata.clear();
			condflds.clear();
			results.clear();

		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
				out.println( resp_group_id+ " "+(req.getParameter("resp_group_name")== null ?"":req.getParameter("resp_group_name"))+" "+(req.getParameter("eff_status")== null ?"D":req.getParameter("eff_status")) );
			}
	}
}
