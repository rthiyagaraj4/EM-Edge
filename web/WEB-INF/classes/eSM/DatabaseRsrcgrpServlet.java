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

import webbeans.eCommon.*;

import eSM.DBResourceGroup.*;

public class DatabaseRsrcgrpServlet extends javax.servlet.http.HttpServlet{

PrintWriter out;
Properties p;
String ora_pwd_reuse_time;
String ora_pwd_reuse_max;
String p_change_type;
String facility_id;

Connection con ;

public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		 req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session		= req.getSession(false);
		this.p			  		= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facility_id  		= (String) session.getValue( "facility_id" ) ;
	try {
			con=ConnectionManager.getConnection(req);
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");

		ora_pwd_reuse_time		=	req.getParameter("ORA_PWD_REUSE_TIME");
		if(ora_pwd_reuse_time == null ) ora_pwd_reuse_time = "";

		ora_pwd_reuse_max		=	req.getParameter("ora_pwd_reuse_max");
		if(ora_pwd_reuse_max == null ) ora_pwd_reuse_max = "";

		p_change_type			= req.getParameter("change_type");
		if (p_change_type == null){ p_change_type=""; }

		if ( operation.equals("insert") )  insertDBrsrcGrp(req, res);
		if ( operation.equals("modify"))   modifyDBrsrcGrp(req, res);
		if ( operation.equals("delete"))   deleteDBRsrcgrp(req, res);


		}catch (Exception e)
			{
				out.println(e.toString());
			}
		finally
			{
				  ConnectionManager.returnConnection(con,req);
			}
    }//E.O.DOPost
private void insertDBrsrcGrp(HttpServletRequest req, HttpServletResponse res)
{
	try {

		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/DatabaseRsrcgrpManager",DatabaseRsrcgrpHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		if (p_change_type.equals("D")) 
		{
			ora_pwd_reuse_max = "";
		}
		else if (p_change_type.equals("C"))
		{
			ora_pwd_reuse_max=ora_pwd_reuse_time;
			ora_pwd_reuse_time = "";
		}

		HashMap argMap=new HashMap ();
		argMap.put("p",p);
		argMap.put("ora_rsrc_group_id",req.getParameter("ORA_RSRC_GROUP_ID")== null ?"":req.getParameter("ORA_RSRC_GROUP_ID"));
		argMap.put("ora_rsrc_group_name",req.getParameter("ORA_RSRC_GROUP_NAME")== null ?"":req.getParameter("ORA_RSRC_GROUP_NAME"));
		argMap.put("ora_pwd_grace_time",req.getParameter("ORA_PWD_GRACE_TIME")== null ?"":req.getParameter("ORA_PWD_GRACE_TIME"));
		argMap.put("ora_pwd_life_time",req.getParameter("ORA_PWD_LIFE_TIME")== null ?"":req.getParameter("ORA_PWD_LIFE_TIME"));
		argMap.put("ora_pwd_reuse_time",ora_pwd_reuse_time);
		argMap.put("ora_pwd_reuse_max",ora_pwd_reuse_max);
		argMap.put("ora_failed_login_attempts",req.getParameter("ORA_FAILED_LOGIN_ATTEMPTS")== null ?"":req.getParameter("ORA_FAILED_LOGIN_ATTEMPTS"));
		argMap.put("ora_pwd_lock_time",req.getParameter("ORA_PWD_LOCK_TIME")== null ?"":req.getParameter("ORA_PWD_LOCK_TIME"));
		argMap.put("ora_idle_time",req.getParameter("ORA_IDLE_TIME")== null ?"":req.getParameter("ORA_IDLE_TIME"));
		argMap.put("ora_sessions_per_user",req.getParameter("ORA_SESSIONS_PER_USER")== null ?"":req.getParameter("ORA_SESSIONS_PER_USER"));
		argMap.put("ora_connect_time",req.getParameter("ORA_CONNECT_TIME")== null ?"":req.getParameter("ORA_CONNECT_TIME"));
		argMap.put("ora_private_sga",req.getParameter("ORA_PRIVATE_SGA")== null ?"":req.getParameter("ORA_PRIVATE_SGA"));
		argMap.put("ora_private_sga_unit",req.getParameter("SGA")== null ?"":req.getParameter("SGA"));
		argMap.put("ora_cpu_per_session",req.getParameter("ORA_CPU_PER_SESSION")== null ?"":req.getParameter("ORA_CPU_PER_SESSION"));
		argMap.put("ora_cpu_per_call",req.getParameter("ORA_CPU_PER_CALL")== null ?"":req.getParameter("ORA_CPU_PER_CALL"));
		argMap.put("ora_ir_per_session",req.getParameter("ORA_IR_PER_SESSION")== null ?"":req.getParameter("ORA_IR_PER_SESSION"));
		argMap.put("ora_ir_per_call",req.getParameter("ORA_IR_PER_CALL")== null ?"":req.getParameter("ORA_IR_PER_CALL"));
		argMap.put("password_expiry_alert_days",req.getParameter("password_expiry_alert_days")== null ?"":req.getParameter("password_expiry_alert_days"));//Maheshwaran added for the MMS-CRF-0149
		argMap.put("facility_id",facility_id);
		argMap.put("client_ip_address",p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address"));

		Object argArray[] = new Object[1];
		argArray[0] =argMap ;
			
		Class [] paramArray = new Class[1];

		paramArray[0] = argMap.getClass();

		java.util.HashMap results= (java.util.HashMap)(busObj.getClass().getMethod("insertDBRsrcgrp",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		
		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;

		if ( inserted ) error_value = "1" ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
        argMap.clear();
        results.clear();

		} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;

			}
	}//E.O.InsertMethod

private void modifyDBrsrcGrp(HttpServletRequest req, HttpServletResponse res)
{
	try {

		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/DatabaseRsrcgrpManager",DatabaseRsrcgrpHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		if (p_change_type.equals("D")) 
		{
			ora_pwd_reuse_max = "";
		}
		else if (p_change_type.equals("C"))
		{
			ora_pwd_reuse_max = ora_pwd_reuse_time;
			ora_pwd_reuse_time = "";
		}


		HashMap argMap=new HashMap ();
		argMap.put("p",p);
		argMap.put("ora_rsrc_group_id",req.getParameter("ORA_RSRC_GROUP_ID")== null ?"":req.getParameter("ORA_RSRC_GROUP_ID"));
		argMap.put("ora_rsrc_group_name",req.getParameter("ORA_RSRC_GROUP_NAME")== null ?"":req.getParameter("ORA_RSRC_GROUP_NAME"));
		argMap.put("ora_pwd_grace_time",req.getParameter("ORA_PWD_GRACE_TIME")== null ?"":req.getParameter("ORA_PWD_GRACE_TIME"));
		argMap.put("ora_pwd_life_time",req.getParameter("ORA_PWD_LIFE_TIME")== null ?"":req.getParameter("ORA_PWD_LIFE_TIME"));
		argMap.put("ora_pwd_reuse_time",ora_pwd_reuse_time);
		argMap.put("ora_pwd_reuse_max",ora_pwd_reuse_max);
		argMap.put("ora_failed_login_attempts",req.getParameter("ORA_FAILED_LOGIN_ATTEMPTS")== null ?"":req.getParameter("ORA_FAILED_LOGIN_ATTEMPTS"));
		argMap.put("ora_pwd_lock_time",req.getParameter("ORA_PWD_LOCK_TIME")== null ?"":req.getParameter("ORA_PWD_LOCK_TIME"));
		argMap.put("ora_idle_time",req.getParameter("ORA_IDLE_TIME")== null ?"":req.getParameter("ORA_IDLE_TIME"));
		argMap.put("ora_sessions_per_user",req.getParameter("ORA_SESSIONS_PER_USER")== null ?"":req.getParameter("ORA_SESSIONS_PER_USER"));
		argMap.put("ora_connect_time",req.getParameter("ORA_CONNECT_TIME")== null ?"":req.getParameter("ORA_CONNECT_TIME"));
		argMap.put("ora_private_sga",req.getParameter("ORA_PRIVATE_SGA")== null ?"":req.getParameter("ORA_PRIVATE_SGA"));
		argMap.put("ora_private_sga_unit",req.getParameter("SGA")== null ?"":req.getParameter("SGA"));
		argMap.put("ora_cpu_per_session",req.getParameter("ORA_CPU_PER_SESSION")== null ?"":req.getParameter("ORA_CPU_PER_SESSION"));
		argMap.put("ora_cpu_per_call",req.getParameter("ORA_CPU_PER_CALL")== null ?"":req.getParameter("ORA_CPU_PER_CALL"));
		argMap.put("ora_ir_per_session",req.getParameter("ORA_IR_PER_SESSION")== null ?"":req.getParameter("ORA_IR_PER_SESSION"));
		argMap.put("ora_ir_per_call",req.getParameter("ORA_IR_PER_CALL")== null ?"":req.getParameter("ORA_IR_PER_CALL"));
		argMap.put("password_expiry_alert_days",req.getParameter("password_expiry_alert_days")== null ?"":req.getParameter("password_expiry_alert_days"));//Maheshwaran added for the MMS-CRF-0149
		argMap.put("facility_id",facility_id);
		argMap.put("client_ip_address",p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address"));

		
		Object argArray[] = new Object[1];
		argArray[0] =argMap ;
			
		Class [] paramArray = new Class[1];

		paramArray[0] = argMap.getClass();

		java.util.HashMap results= (java.util.HashMap)(busObj.getClass().getMethod("updateDBRsrcgrp",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted ) error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
        argMap.clear();
        results.clear();

		} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;

			}
	}//E.O.ModifyMethod


private void deleteDBRsrcgrp(HttpServletRequest req, HttpServletResponse res)
{
	try {

		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/DatabaseRsrcgrpManager",DatabaseRsrcgrpHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		HashMap argMap=new HashMap ();
		
		argMap.put("p",p);
		argMap.put("ora_rsrc_group_id",req.getParameter("ORA_RSRC_GROUP_ID")== null ?"":req.getParameter("ORA_RSRC_GROUP_ID"));
	
		Object argArray[] = new Object[1];
		argArray[0] =argMap ;
			
		Class [] paramArray = new Class[1];

		paramArray[0] = argMap.getClass();
		

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("deleteDBRsrcgrp",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		
		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;

		if ( inserted ) error_value = "1" ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
        argMap.clear();
        results.clear();

		} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;

			}
			finally
			{
				  ConnectionManager.returnConnection(con,req);
			}
	}//E.O.Delete Method


}//E.O.Class 
