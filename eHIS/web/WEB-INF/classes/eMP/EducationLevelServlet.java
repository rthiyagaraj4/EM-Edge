/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/***** Last Modified Date 9/22/2005 12:23 PM *******/
package eMP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;

import eCommon.SingleTabHandler.*; 

import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0187

public class EducationLevelServlet extends javax.servlet.http.HttpServlet	{

PrintWriter out;
java.util.Properties p;

String educationLevelCode;
String longDesc ;
String shortDesc ;
String facilityId ;
String effectiveDateFrom ;
String effectiveDateTo ;
String effectiveStatus ;

String client_ip_address ;

HttpSession session;

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException	
{

	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	//Added by Kamatchi S for security issue against COMMON-ICN-0187
	req = new XSSRequestWrapper(req);
	res.addHeader("X-XSS-Protection", "1; mode=block");
	res.addHeader("X-Content-Type-Options", "nosniff");
	//Added by Kamatchi S for security issue against COMMON-ICN-0187 END
	session = req.getSession(false);
	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.facilityId = (String) session.getValue( "facility_id" ) ;
	if(facilityId==null) facilityId="";
	client_ip_address = p.getProperty("client_ip_address");

	try 
	{
		this.out = res.getWriter();
		String operation = req.getParameter("function");

		if(operation.equals("insert")) insertEducationLevel(req, res);
		if(operation.equals("modify")) modifyEducationLevel(req, res);
	}
	catch (Exception e)	{
		//out.println(e.toString());
		e.printStackTrace();
		}
	}

private void modifyEducationLevel(HttpServletRequest req, HttpServletResponse res)	{
	
	try {
	educationLevelCode = req.getParameter("educ_level_code");
	if(educationLevelCode== null ) educationLevelCode="";
	longDesc = req.getParameter("long_desc");
	if(longDesc== null ) longDesc="";
	shortDesc = req.getParameter("short_desc");
	if(shortDesc== null ) shortDesc="";
	effectiveDateFrom = req.getParameter("eff_date_from");
	effectiveDateTo = req.getParameter("eff_date_to");
	effectiveStatus = req.getParameter("eff_status");
	
	if ( effectiveStatus == null )
		effectiveStatus="D";

	
	String addedById = p.getProperty( "login_user" ) ;
	String modifiedById = addedById ;
	String addedFacilityId=facilityId;
	String modifiedFacilityId = addedFacilityId ;
	String addedAtWorkstation=client_ip_address;
	String modifiedAtWorkstation = addedAtWorkstation ;

	java.sql.Date effective_date_from =null;
	java.sql.Date effective_date_to =null;

	if ( (effectiveDateFrom != null) && (!effectiveDateFrom.equals("")) )
			effective_date_from = java.sql.Date.valueOf( effectiveDateFrom ) ;

	if ( (effectiveDateTo != null) && (!effectiveDateTo.equals("")) )
		effective_date_to = java.sql.Date.valueOf( effectiveDateTo ) ;

	HashMap tabdata=new HashMap();
	tabdata.put("long_desc",longDesc);
	tabdata.put("short_desc",shortDesc);

	if(effective_date_from ==null)
			tabdata.put("eff_date_from","null");
	else
			tabdata.put("eff_date_from",effective_date_from);

	if(effective_date_to ==null)
			tabdata.put("eff_date_to","null");
	else
			tabdata.put("eff_date_to",effective_date_to);
			
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("added_by_id",addedById);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			
				HashMap condflds=new HashMap();
				condflds.put("educ_level_code",educationLevelCode);
				
			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = "mp_education_level";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			argArray = null;
			paramArray = null;
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
						String error_value = "0" ;
						tabdata.clear();
						condflds.clear();
						results.clear();
						if ( inserted )
						{
						 error_value = "1" ;
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
						}
						else
						{
						 
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8") );
						}
			
		}
		catch ( Exception e )
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( educationLevelCode + " "+longDesc + " "+shortDesc +" "+ effectiveStatus ); */
			e.printStackTrace();
		}
	
	}
private void insertEducationLevel(HttpServletRequest req, HttpServletResponse res)	
	{
	try {
	educationLevelCode = req.getParameter("educ_level_code");
	if(educationLevelCode== null ) educationLevelCode="";
	longDesc = req.getParameter("long_desc");
	if(longDesc== null ) longDesc="";
	shortDesc = req.getParameter("short_desc");
	if(shortDesc== null ) shortDesc="";
	effectiveDateFrom = req.getParameter("eff_date_from");
	effectiveDateTo = req.getParameter("eff_date_to");
	effectiveStatus = req.getParameter("eff_status");

	if ( effectiveStatus == null )
			effectiveStatus="D";

	
			
	String addedById = p.getProperty( "login_user" ) ;
	String modifiedById = addedById ;
	String addedFacilityId=facilityId;
	String modifiedFacilityId = addedFacilityId ;
	String addedAtWorkstation=client_ip_address;
	String modifiedAtWorkstation = addedAtWorkstation ;

	java.sql.Date effective_date_from =null;
	java.sql.Date effective_date_to =null;

			if ( (effectiveDateFrom != null) && (!effectiveDateFrom.equals("")) )
					effective_date_from = java.sql.Date.valueOf( effectiveDateFrom ) ;

			if ( (effectiveDateTo != null) && (!effectiveDateTo.equals("")) )
					effective_date_to = java.sql.Date.valueOf( effectiveDateTo ) ;

				HashMap tabdata=new HashMap();

				tabdata.put("educ_level_code",educationLevelCode);
				tabdata.put("long_desc",longDesc);
				tabdata.put("short_desc",shortDesc);
				tabdata.put("eff_status",effectiveStatus);

				if(effective_date_from ==null)
						tabdata.put("eff_date_from","null");
				else
						tabdata.put("eff_date_from",effective_date_from);

				if(effective_date_to ==null)
						tabdata.put("eff_date_to","null");
				else
						tabdata.put("eff_date_to",effective_date_to);

				tabdata.put("added_by_id",addedById);
				tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("added_facility_id", facilityId);
				tabdata.put("added_at_ws_no",addedAtWorkstation);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

				String dupflds[]={"educ_level_code"};

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = "mp_education_level";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			argArray = null;
			paramArray = null;
			tabdata.clear();			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

						String error = (String) results.get("error") ;
									String error_value = "0" ;
									results.clear();
									if ( inserted )
									{
									 error_value = "1" ;
									 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
									}
									else
									{
									
									 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8") );
									}
					}
					catch ( Exception e )
					{
						e.printStackTrace();
						/* out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
						out.println( "Values sent are : <br>" ) ;
						out.println( educationLevelCode+ " "+longDesc + " "+shortDesc +" "+ effectiveStatus ); */
		}
	}
	
	boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
		else
			return false;
	}
}
