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
import java.net.URLEncoder;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class DefaultOnlinePrintServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	String Report_Id;
	String Facility_Based_Yn;
	String Report_Group;
	String facilityId ;
    String Select_Yn; 
	HttpSession session;
	Connection con;
	Properties p;
	String locale;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	String      client_ip_address;
	boolean     inserted		= false;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{ 
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
	    this.p	= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address          = p.getProperty("client_ip_address");
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";
		locale = p.getProperty("LOCALE");	
		try
		{
			this.out = res.getWriter();

			modifyOnlineReport(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	private void modifyOnlineReport(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{ 
            String Module=req.getParameter("Module");
            String Function=req.getParameter("Function");
            String Report=req.getParameter("Report");
            String dflt_chk_yn=req.getParameter("dflt_chk_yn");
			String addedById			= p.getProperty( "login_user" ) ;
			String addedDate			= dateFormat.format( new java.util.Date() ) ;
			String modifiedById			= addedById ;
			String modifiedDate			= addedDate ;
			String addedFacilityId		= facilityId;
			String modifiedFacilityId	= addedFacilityId ;
			String addedAtWorkstation	=client_ip_address;
			String modifiedAtWorkstation= addedAtWorkstation ;
	
			HashMap tabdata             =new HashMap();
			tabdata.put("MODULE_ID",Module);
			tabdata.put("REPORT_ID",Report);
			tabdata.put("FUNCTION_ID",	Function);
			tabdata.put("DFLT_ONLINE_PRINT_YN",dflt_chk_yn);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",modifiedDate);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);  

			HashMap dupflds          = new HashMap();
			dupflds.put("MODULE_ID",Module);
			dupflds.put("REPORT_ID",Report);
			dupflds.put("FUNCTION_ID",Function);								
			String tabname            ="SM_DFLT_ONLINE_PRINT";
			boolean local_ejbs        = false;
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
		Object home               = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj             = (home.getClass().getMethod("create",null)).invoke(home,null);
		Object argArray[]         = new Object[4];
		argArray[0]               = p;
		argArray[1]               = tabdata;
		argArray[2]               = dupflds;
		argArray[3]               = tabname;
		Class [] paramArray       = new Class[4];
		paramArray[0]             = p.getClass();
		paramArray[1]             = tabdata.getClass();
		paramArray[2]             = dupflds.getClass();
		paramArray[3]             = tabname.getClass();	
		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
		inserted              = ( ((Boolean) results.get( "status" )).booleanValue() ) ;				
		String error          = (String) results.get("error") ;						
		String error_value    = "0" ;
			if ( inserted )
			 {
				error_value= "1";
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			 }
			else
			 {
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			 }
		  tabdata.clear();
		  results.clear();

		  
		                 			
		}
catch ( Exception e )
	{
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		out.println(e.toString());
		e.printStackTrace();
	}
       finally
			{
				if( con != null ) ConnectionManager.returnConnection(con,req);
			}      
					   
	}

}
	
        		
			



	
			

			
