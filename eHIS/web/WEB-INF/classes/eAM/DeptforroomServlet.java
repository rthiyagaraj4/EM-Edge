/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 *		FileName : DeptforroomServlet.java
 *		Version	 : 3
 *		Date	 : 15-2-05	
**/


package eAM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eAM.Deptforroom.* ;

public class DeptforroomServlet extends javax.servlet.http.HttpServlet	
{
	PrintWriter out;
	
	java.util.Properties p;
	//String facilityId;
	String room;
	String department;
	String service;
	String client_ip_address ;
	//java.util.Hashtable env;
	
	String facility="";

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		HttpSession session = req.getSession(false);
		//this.facilityId = (String)session.getValue("facility_id") ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");

		try 
		{
			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if ( operation.equals("insert") )  insertDeptforroom(req, res);
			if ( operation.equals("modify"))  modifyDeptforroom(req, res);

		}catch (Exception e)	
		{
			out.println(e.toString());
		}
	}


	/*public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		try 
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='/eCIS/mp/js/NamePrefix.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame'	src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=Name Prefix' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{	}
	}*/


	private void modifyDeptforroom(HttpServletRequest req, HttpServletResponse res)	
	{
		try{

		try 
		{

			res.setContentType("text/html");
			room = req.getParameter("room");
			department = req.getParameter("department");
			service = req.getParameter("service");
			facility = req.getParameter("facility");
	
			HashMap hashdata=new HashMap();
			hashdata.put("service",service);
			hashdata.put("room",room);
			hashdata.put("addedAtWorkstation",client_ip_address);
			hashdata.put("facilityId",facility);
			hashdata.put("addedFacilityId",facility);
			hashdata.put("department",department);
			//Approach via the ServiceLocator and Reflection
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/Deptforroom",DeptforroomManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			Object argArray[] = new Object[1];
			
			HashMap hashmap=new HashMap();
			hashmap.put("p",p);
			hashmap.put("hashdata",hashdata);
		
			argArray[0] = hashmap;
			
			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateDeptRoom",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			hashdata.clear();
			hashmap.clear();
			String error = (String) results.get("error") ;

			if ( inserted )
			{
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) );
			}
			else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error ,"UTF-8" ) );
			}results.clear();

		} catch ( Exception e ) 
		{
				out.println(e.getMessage());
				out.println(e.toString());
				e.printStackTrace();
	   }
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}
	


	private void insertDeptforroom(HttpServletRequest req, HttpServletResponse res)	
	{
		try
		{
			res.setContentType("text/html");
			room = req.getParameter("room");
			department = req.getParameter("department");
			service = req.getParameter("service");
			facility = req.getParameter("facility");
		
		
			HashMap hashdata=new HashMap();
			hashdata.put("facilityId",facility);
			hashdata.put("room",room);
			hashdata.put("department",department);
			hashdata.put("service",service);
			hashdata.put("addedAtWorkstation",client_ip_address);
			hashdata.put("addedFacilityId",facility);

		//Approach via the ServiceLocator and Reflection
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/Deptforroom",DeptforroomManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			Object argArray[] = new Object[1];
			HashMap hashmap=new HashMap();
			hashmap.put("p",p);
			hashmap.put("hashdata",hashdata);
		
			argArray[0] = hashmap;
						
			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertDeptRoom",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			 boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			 hashdata.clear();
			hashmap.clear();
			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if(inserted)
			{
				 error_value = "1" ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
			}
			else
			{
				error = (String) results.get("error") ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8"  ) );
			}results.clear();

		} catch ( Exception e )
		{
			out.println(e.getMessage());
			out.println(e.toString());
			e.printStackTrace();
	   }
	}

}
