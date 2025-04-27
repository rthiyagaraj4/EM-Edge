/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class TransferPriorityServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{           
	PrintWriter out;
	Properties p;
	String client_ip_address ;
    String facilityId;
	HttpSession session;
    String error		= "";
    String table_name	= "";
    String error_value	= "";
    String locale		= "";

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session			  = req.getSession(false);
		this.p			  = (java.util.Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		this.facilityId	  = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		try
		{
			this.out		 = res.getWriter();
			String operation = req.getParameter("mode");
			if (operation.equals("insert"))	insertPriority(req, res);
			if (operation.equals("update"))	modifyPriority(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void insertPriority(HttpServletRequest req, HttpServletResponse res)
	{
		Connection conn = null;
		Statement stmt  = null;
		ResultSet rset  = null;
		try
		{
			String priority_code	= checkForNull(req.getParameter("priority_code"));
			String color_scheme		= checkForNull(req.getParameter("color_scheme"));

			int getclr				= 0;
			
			StringBuffer chkclr     = new StringBuffer(); 
			chkclr.append("select count(*) from IP_TRANSFER_PRIORITY where color_code_scheme ='"+color_scheme+"' AND priority_code != '"+priority_code+"' ");
			conn				    = ConnectionManager.getConnection(req); 
			stmt					= conn.createStatement();
			rset					= stmt.executeQuery(chkclr.toString());

			while(rset.next())
			{
				getclr		=  rset.getInt(1);
			}

			if(getclr > 0 )
				error_value = "1" ;
			else
				error_value = "0" ;
		
		if(!error_value.equals("1"))
		{
			String days_hours = req.getParameter("days_hours");
				if( days_hours == null) days_hours = "";

			String addedById 			 = p.getProperty( "login_user" ) ;
			String modifiedById			 = addedById ;
			String modifiedFacilityId	 =	facilityId;
			String addedAtWorkstation	 =	client_ip_address;
			String modifiedAtWorkstation =  addedAtWorkstation ;

			Timestamp modified_date		 = new Timestamp(System.currentTimeMillis() );

			HashMap tabdata			 = new HashMap();

			tabdata.put("facility_id",checkForNull(req.getParameter("facility_id")));
			tabdata.put("priority_code",priority_code);
			tabdata.put("long_desc",checkForNull(req.getParameter("long_desc")));
			tabdata.put("short_desc",checkForNull(req.getParameter("short_desc")));
			tabdata.put("expire_yn",checkForDefault(req.getParameter("exp_status"),"N"));
			tabdata.put("expiry_period",checkForNull(req.getParameter("exp_day")));
			tabdata.put("color_code_scheme",color_scheme);
			tabdata.put("expiry_period_unit",checkForNull(req.getParameter("days_hours")));
			tabdata.put("eff_status",checkForDefault(req.getParameter("eff_status"),"D"));
			
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",modified_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			
			String dupflds[]={"priority_code"};

			table_name			= "IP_TRANSFER_PRIORITY";
			boolean local_ejbs	= false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
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

			error = (String) results.get("error") ;
			error_value = "0" ;

			if ( inserted )
			{
				 error_value = "1" ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				error = (String) results.get("error") ;
				results.clear();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			results.clear();
			tabdata.clear();
		}
		else
		{

			java.util.Hashtable message = MessageManager.getMessage(locale,"COLOR_EXISTS","IP" ) ;
			error = (String) message.get("message") ;	
			//"IP...Colour Code Already Exists ....";
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=" + error_value );
			message.clear();
		}
	
	}catch ( Exception e )
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(rset!=null)    rset.close();
			if(stmt!=null) stmt.close();
			if(conn != null)  ConnectionManager.returnConnection(conn,req);
		}
			catch(Exception e){	e.printStackTrace();	}
		}
	}

//|||||||||||||||||||||||||||| UPDATE MODE ||||||||||||||||||||||||||||

private void modifyPriority(HttpServletRequest req, HttpServletResponse res)
{
	Connection conn = null;
	Statement stmt=null;
	ResultSet rset=null;
	try
	{
		String priority_code =checkForNull(req.getParameter("priority_code"));
		String color_scheme =checkForNull(req.getParameter("color_scheme"));
		String addedById 			= p.getProperty( "login_user" ) ;
		String modifiedById			= addedById ;
		String modifiedFacilityId	= facilityId;
		String addedAtWorkstation	= client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;

		Timestamp modified_date		= new Timestamp(System.currentTimeMillis() );
		
		StringBuffer chkclr			= new StringBuffer(); 
		chkclr.append(" select count(*) from IP_TRANSFER_PRIORITY where color_code_scheme ='"+color_scheme+"' AND priority_code != '"+priority_code+"' ");

		int getclr = 0;

		conn = ConnectionManager.getConnection(req); 
		stmt = conn.createStatement();
		rset = stmt.executeQuery(chkclr.toString());

		while(rset.next())
		{
			getclr =  rset.getInt(1);
		}
		if(stmt!=null) stmt.close();
		if(rset!=null) rset.close();
		if(getclr > 0 )
			error_value = "1" ;
		else
			error_value = "0" ;

		if(!error_value.equals("1"))
		{
			HashMap tabdata = new HashMap();
			tabdata.put("facility_id",checkForNull(req.getParameter("facility_id")));
			tabdata.put("priority_code", priority_code);
			tabdata.put("long_desc",checkForNull(req.getParameter("long_desc")));
			tabdata.put("short_desc",checkForNull(req.getParameter("short_desc")));
			tabdata.put("expire_yn",checkForDefault(req.getParameter("exp_status"),"N"));
			tabdata.put("expiry_period",checkForNull(req.getParameter("exp_day")));
			tabdata.put("color_code_scheme",color_scheme);
			tabdata.put("expiry_period_unit",checkForNull(req.getParameter("days_hours")));
			tabdata.put("eff_status",checkForDefault(req.getParameter("eff_status"),"D"));
			
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",modified_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
		
			HashMap hashtable1 = new HashMap();
			hashtable1.put("priority_code", priority_code);

			table_name			= "IP_TRANSFER_PRIORITY";
			boolean local_ejbs	= false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;

			Object home	  = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = hashtable1;
			argArray[3] = table_name;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = hashtable1.getClass();
			paramArray[3] = table_name.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted   = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error	   = (String) results.get("error") ;
			error_value = "0" ;
			
			tabdata.clear();
			hashtable1.clear();			
			
			if(inserted)
			{
				 error_value = "1" ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			results.clear();
		}
		else
		{
			error = "IP...Colour Code Already Exists ....";
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		}

	}catch ( Exception e )
	{
		e.printStackTrace();
	}
	finally
	{
		if(conn != null)  ConnectionManager.returnConnection(conn,req);
	}
}

	// Added by Sridhar R on 2 MARCH 2005.. thesse functions will chk for null value & return empty String...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForDefault(String inputString, String Default)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? Default : inputString);
	}
}

