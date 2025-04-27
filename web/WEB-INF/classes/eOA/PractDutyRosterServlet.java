/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA;


import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0165
import eOA.PractDutyRoster.* ;

public class PractDutyRosterServlet extends javax.servlet.http.HttpServlet	{
PrintWriter out;
java.util.Properties p;

String facilityId;
String client_ip_address ;


String ondutydate="" ;
String practid="" ;
String ccode="" ;
String resource2="";
String locations1="";
String resourced="";
String locale="";

public void init(ServletConfig config) throws ServletException	{
	super.init(config);
	}
public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{


	HttpSession session = req.getSession(false);
	this.facilityId = (String)session.getValue("facility_id") ;

	 locale=(String)session.getAttribute("LOCALE");


	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.client_ip_address = p.getProperty("client_ip_address");

	try {
		this.out = res.getWriter();
		String operation = req.getParameter("function_name");
		

		if ( operation.equals("insert") ){
			String dat = req.getParameter("on_duty_date");
			ondutydate = dat;
		
			insertPractDutyRoster(req, res);
		}else if(operation.equals("delete")){
			deletePractDutyRoster(req,res);
		}

	}
	catch (Exception e)	{
		//out.println(e.toString()+"here.........");
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		}
	}
private void insertPractDutyRoster(HttpServletRequest req, HttpServletResponse res)	{
	try {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		//Added by Kamatchi S for security issue against COMMON-ICN-0165
		req = new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//Added by Kamatchi S for security issue against COMMON-ICN-0165 END 
		locations1 = req.getParameter("carelocnk");
		practid = req.getParameter("practitioner_id");
		resource2 = req.getParameter("resourcek");
		ccode = req.getParameter("clinic_code");

		
		java.util.HashMap passObjects = new java.util.HashMap(); 

		passObjects.put("facilityId",facilityId);
		passObjects.put("locations1",locations1);
		passObjects.put("practid",practid);
		passObjects.put("resource2",resource2);
		passObjects.put("ccode",ccode);
		passObjects.put("ondutydate",ondutydate);
		passObjects.put("client_ip_address",client_ip_address);

		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PractDutyRoster",PractDutyRosterManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = passObjects;

		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = passObjects.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertPractDutyRoster",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "" ;
		if ( inserted )	{
			error_value = "1" ;
			out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");
		}else{
			error = (String) results.get("error") ;
			out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) +"\"</script>");
		}

		results.clear();
		passObjects.clear();

	} catch ( Exception e ) {
		//out.println(e.getMessage());
		//out.println(e.toString());
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		}
	}

	private void deletePractDutyRoster(HttpServletRequest req, HttpServletResponse res)	{
		try {
		
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		

		practid = req.getParameter("pract_id");
		if(practid==null) practid="";

		ccode = req.getParameter("location_code");
		if(ccode==null) ccode="";

		ondutydate =  req.getParameter("onduty_date");
		if(ondutydate==null) ondutydate="";


		locations1 = req.getParameter("locationd1");
		if(locations1==null) locations1="";

		resourced = req.getParameter("resourced");
		if(resourced==null) resourced="";

		
		java.util.HashMap passObjects = new java.util.HashMap(); 

		passObjects.put("facilityId",facilityId);
		passObjects.put("locations1",locations1);
		passObjects.put("practid",practid);
		passObjects.put("resourced",resourced);
		passObjects.put("ccode",ccode);
		passObjects.put("ondutydate",ondutydate);


		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PractDutyRoster",PractDutyRosterManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = passObjects;


		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = passObjects.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("deletePractDutyRoster",paramArray)).invoke(busObj,argArray);

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

		out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) +"\"</script>");

	} catch ( Exception e ) {
		//out.println(e.getMessage()+"here");
		//out.println(e.toString());
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}
	}
}
