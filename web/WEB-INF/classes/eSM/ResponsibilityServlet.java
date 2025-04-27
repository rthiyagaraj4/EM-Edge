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

import eSM.Responsibility.*;

public class ResponsibilityServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	Properties p;
	String facilityId ;
	String client_ip_address ;
	String locale;
	String resp_id;
	String desktop_code;

	HttpSession session;


	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");	
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";
		client_ip_address = p.getProperty("client_ip_address");


		try
		{
			res.setContentType("text/html");
			this.out = res.getWriter();
			String operation = req.getParameter("function");
			resp_id=req.getParameter("resp_id")== null ?"":req.getParameter("resp_id");
		   desktop_code=req.getParameter("desktop_code")== null ?"":req.getParameter("desktop_code");
	

			if ( operation.equals("insert") )		insertResponsibility(req, res);
			if ( operation.equals("modify"))		modifyResponsibility(req, res);

			
			out = null;

		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}



/***************************************************************************/

	private void insertResponsibility(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			String eff_date_from ="";
			String eff_date_to ="";
			HashMap tabdata=new HashMap();
			tabdata.put("resp_id",resp_id);
			tabdata.put("resp_name",req.getParameter("resp_name")== null ?"":req.getParameter("resp_name"));
			tabdata.put("menu_id",req.getParameter("menu_id")== null ?"":req.getParameter("menu_id"));
			tabdata.put("resp_group_id",req.getParameter("resp_group_id")== null ?"":req.getParameter("resp_group_id"));
			tabdata.put("desktop_code",desktop_code);

			tabdata.put("ora_role_id",req.getParameter("ora_role_id")== null ?"":req.getParameter("ora_role_id"));
			tabdata.put("remarks",req.getParameter("remarks")== null ?"":req.getParameter("remarks"));
		    eff_date_from = req.getParameter("eff_date_from1")== null ?"":req.getParameter("eff_date_from1");
            eff_date_from = DateUtils.convertDate(eff_date_from,"DMY",locale,"en");
			tabdata.put("eff_date_from",eff_date_from);
		    eff_date_to = req.getParameter("eff_date_to1")== null ?"":req.getParameter("eff_date_to1");
			eff_date_to = DateUtils.convertDate(eff_date_to,"DMY",locale,"en");
			tabdata.put("eff_date_to",eff_date_to);
	
			tabdata.put("eff_status",req.getParameter("eff_status")== null ?"D":req.getParameter("eff_status"));
			
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			
		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ResponsibilityManager",ResponsibilityHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		HashMap argMap=new HashMap();
		
		argMap.put("p",p);
		argMap.put("tabdata",tabdata);


		Object argArray[] = new Object[1];
		argArray[0] = argMap;
	
		
		Class [] paramArray = new Class[1];
		paramArray[0] = argMap.getClass();
		
	

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertSMResponsibility",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		tabdata.clear();
		argMap.clear();

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;
		results.clear();

	
		if ( inserted ){
			error_value = "1" ;
			if(desktop_code==null || desktop_code.equals("")){
				session.putValue(resp_id,"null");
			}else if(desktop_code!=null && !desktop_code.equals("")){
				session.putValue(resp_id,desktop_code);
			}
    	
		}

	
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );

	}
catch ( Exception e )
	{
		out.println(e.toString());
	}
}

/****************************************************************************/

private void modifyResponsibility(HttpServletRequest req, HttpServletResponse res)
{
	try
		{

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
		
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			HashMap tabdata=new HashMap();
			tabdata.put("resp_name",req.getParameter("resp_name")== null ?"":req.getParameter("resp_name"));
			tabdata.put("menu_id",req.getParameter("menu_id")== null ?"":req.getParameter("menu_id"));
			tabdata.put("resp_group_id",req.getParameter("resp_group_id1")== null ?"":req.getParameter("resp_group_id1"));
			tabdata.put("ora_role_id",req.getParameter("ora_role_id1")== null ?"":req.getParameter("ora_role_id1"));
			tabdata.put("desktop_code",desktop_code);

			tabdata.put("remarks",req.getParameter("remarks")== null ?"":req.getParameter("remarks"));
			tabdata.put("eff_date_from",DateUtils.convertDate(req.getParameter("eff_date_from1")== null ?"":req.getParameter("eff_date_from1"),"DMY",locale,"en"));
			tabdata.put("eff_date_to",DateUtils.convertDate(req.getParameter("eff_date_to1")== null ?"":req.getParameter("eff_date_to1"),"DMY",locale,"en"));
			tabdata.put("eff_status",req.getParameter("eff_status")== null ?"D":req.getParameter("eff_status"));
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("resp_id",resp_id);
			boolean local_ejbs = false;
			
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ResponsibilityManager",ResponsibilityHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			HashMap argMap=new HashMap();
			argMap.put("p",p);
			argMap.put("tabdata",tabdata);

			
			Object argArray[] = new Object[1];
			argArray[0] = argMap;
			
			
			Class [] paramArray = new Class[1];
			paramArray[0] = argMap.getClass();		

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateSMResponsibility",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			tabdata.clear();
			argMap.clear();


			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			results.clear();

			if ( inserted )
			{ 
				error_value = "1" ;
				if(desktop_code==null || desktop_code.equals("")){
					session.putValue(resp_id,"null");
				}else if(desktop_code!=null && !desktop_code.equals("")){
					session.putValue(resp_id,desktop_code);
				}
			}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );

		}
		catch ( Exception e )
		{
			out.println(e.toString());
		}
	}
}
