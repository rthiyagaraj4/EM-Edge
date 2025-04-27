/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA;

import javax.naming.*;
import javax.ejb.*;
import javax.rmi.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.rmi.*;
import java.sql.*;


import eOA.AppointmentSrlNo.* ;

public class AppointmentSrlNoServlet extends javax.servlet.http.HttpServlet	{
PrintWriter out;
java.util.Properties p;

String facilityId;
String client_ip_address ;


String next_srl_no ;
String max_srl_no;
String remark;


public void init(ServletConfig config) throws ServletException	{
	super.init(config);
}

public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException{


	HttpSession session = req.getSession(false);
	this.facilityId = (String)session.getValue("facility_id") ;


	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.client_ip_address = p.getProperty("client_ip_address");

	try {
		this.out = res.getWriter();
		String operation = req.getParameter("function_name");

		if ( operation.equals("insert") )
			insertAppointmentSrlNo(req, res);
		if ( operation.equals("modify"))
			modifyAppointmentSrlNo(req, res);

	}catch (Exception e)	{
		//out.println(e.toString());
		 e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}
}
public void doGet(HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException{

	try	{
		this.out = res.getWriter();
		res.setContentType("text/html;charset=UTF-8");
		out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/NamePrefix.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame'	src='../eCommon/jsp/commonToolbar.jsp?function_name=Name Prefix' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
	
	}	catch(Exception e)	{	
		//out.println(e.toString());
		 e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}
}


private void insertAppointmentSrlNo(HttpServletRequest req, HttpServletResponse res)	{
	try {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		next_srl_no = req.getParameter("next_srl_no");
		max_srl_no = req.getParameter("max_srl_no");
		remark=req.getParameter("remark");
		
		

	
		java.util.HashMap passObjects = new java.util.HashMap(); 

		passObjects.put("next_srl_no",next_srl_no);
		passObjects.put("max_srl_no",max_srl_no);
		passObjects.put("remark",remark);
		passObjects.put("facilityId",facilityId);
		passObjects.put("client_ip_address",client_ip_address);

		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AppointmentSrlNo",AppointmentSrlNoManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = passObjects;

		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = passObjects.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertAppointmentSrlNo",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);



		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;

		if ( inserted ){
			error_value = "1" ;
			out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");

		}else{
			error = (String) results.get("error") ;
			out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) +"\"</script>");

		}
		passObjects.clear();
		results.clear();

	} catch ( Exception e ) {
		//out.println(e.getMessage());
		//out.println(e.toString());
		 e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}
}


private void modifyAppointmentSrlNo(HttpServletRequest req, HttpServletResponse res)	{
	try {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		next_srl_no = req.getParameter("next_srl_no");
		max_srl_no = req.getParameter("max_srl_no");
		remark=req.getParameter("remark");

		


		java.util.HashMap passObjects = new java.util.HashMap(); 

		passObjects.put("next_srl_no",next_srl_no);
		passObjects.put("max_srl_no",max_srl_no);
		passObjects.put("remark",remark);
		passObjects.put("facilityId",facilityId);
		passObjects.put("client_ip_address",client_ip_address);


		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AppointmentSrlNo",AppointmentSrlNoManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = passObjects;


		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = passObjects.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateAppointmentSrlNo",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);



		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;

		if ( inserted ){
			error_value = "1" ;
			out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");

		}else{
			error = (String) results.get("error") ;
			out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) +"\"</script>");

		}
		passObjects.clear();
		results.clear();

	} catch ( Exception e ) {
		//out.println(e.getMessage());
		//out.println(e.toString());
		 e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}
}
}
