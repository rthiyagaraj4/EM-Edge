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
import java.util.Properties;
import java.util.HashMap;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import java.util.*;

import eCommon.SingleTabHandler.*;

public class ForeignCurrencyServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{

	PrintWriter	out;
	Properties	p;
	String		currency_code ;
	String		currency_name ;
	String		decimal_name ;
	String		conversion_rate ;
	String		conversion_operator ;
	String		no_decimal;
	String		long_desc ;
	String		short_desc ;
	String		acc_code1 ;
	String		acc_code2 ;
	String		ledger_grp ;
	String		ledger_line ;
	String		dept_code;
	String		prdt_grp ;
	String		prdt_line ;
	String		addedById	= "";
	Timestamp	added_date	= new Timestamp(System.currentTimeMillis() );
	HttpSession session;
	String		facilityId ;
	String		client_ip_address ;
	String		operation ;


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

	public synchronized void  doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();

		session				= req.getSession(false);
		this.p				= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId		= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= p.getProperty("client_ip_address");
		addedById			= p.getProperty( "login_user" ) ;

		currency_code		= checkForNull(req.getParameter("currency_code"));
		currency_name		= checkForNull(req.getParameter("currency_name"));
		decimal_name		= checkForNull(req.getParameter("decimal_name"));
		conversion_rate		= checkForNull(req.getParameter("conversion_rate"));
		conversion_operator	= checkForNull(req.getParameter("conversion_operator"));
		no_decimal			= checkForNull(req.getParameter("no_decimal"));
		long_desc			= checkForNull(req.getParameter("long_desc"));
		short_desc			= checkForNull(req.getParameter("short_desc"));
		acc_code1			= checkForNull(req.getParameter("acc_code1"));
		acc_code2			= checkForNull(req.getParameter("acc_code2"));
		ledger_grp			= checkForNull(req.getParameter("ledger_grp_code"));
		ledger_line			= checkForNull(req.getParameter("ledger_line_code"));
		dept_code			= checkForNull(req.getParameter("dept_code"));
		prdt_grp			= checkForNull(req.getParameter("prdt_grp_code"));
		prdt_line			= checkForNull(req.getParameter("prdt_line_code"));
		operation			= checkForNull(req.getParameter("operation"));
	
		try
		{
			if ( operation.equals("insert") )   insertForeignCurrency(res);	
			else if (operation.equals("modify")) updateForeignCurrency(res);				
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}

	private void insertForeignCurrency(HttpServletResponse res)
	{
		try
		{
			HashMap	tabdata		= new HashMap();

			tabdata.put("currency_code",currency_code);
			tabdata.put("long_desc",long_desc);
			tabdata.put("short_desc",short_desc);
			tabdata.put("conversion_rate",conversion_rate);
			tabdata.put("conversion_operator",conversion_operator);
			tabdata.put("currency_name_integer",currency_name);
			tabdata.put("currency_name_decimal",decimal_name);
			tabdata.put("num_of_decimal",no_decimal );
			tabdata.put("main_acc1_code",acc_code1 );
			tabdata.put("main_acc2_code",acc_code2 );
			tabdata.put("subledger_group_code",ledger_grp );
			tabdata.put("subledger_line_code",ledger_line );
			tabdata.put("dept_code",dept_code );
			tabdata.put("product_group_code",prdt_grp );
			tabdata.put("product_line_code",prdt_line );
			tabdata.put("status","" );
			tabdata.put("added_by_id",addedById );
			tabdata.put("added_date",added_date );
			tabdata.put("added_facility_id",facilityId );
			tabdata.put("added_at_ws_no",client_ip_address );
			tabdata.put("modified_by_id",addedById );
			tabdata.put("modified_date",added_date );
			tabdata.put("modified_facility_id",facilityId );	
			tabdata.put("modified_at_ws_no",client_ip_address );
		

		
			String dupflds[]={"currency_code"};
			
			String table_name	= "sy_foreign_currency";
			boolean local_ejbs = false;

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

			boolean inserted	= (((Boolean) results.get( "status" )).booleanValue()) ;
			String error		= (String) results.get("error") ;
			String error_value	= "0" ;

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
		
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
			
		}catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
	}


	private void updateForeignCurrency(HttpServletResponse res)
	{
		
		try
		{
			HashMap	tabdata		= new HashMap();

			tabdata.put("long_desc",long_desc);
			tabdata.put("short_desc",short_desc);
			tabdata.put("conversion_rate",conversion_rate);
			tabdata.put("conversion_operator",conversion_operator);
			tabdata.put("currency_name_integer",currency_name);
			tabdata.put("currency_name_decimal",decimal_name);
			tabdata.put("num_of_decimal",no_decimal );
			tabdata.put("main_acc1_code",acc_code1 );
			tabdata.put("main_acc2_code",acc_code2 );
			tabdata.put("subledger_group_code",ledger_grp );
			tabdata.put("subledger_line_code",ledger_line );
			tabdata.put("dept_code",dept_code );
			tabdata.put("product_group_code",prdt_grp );
			tabdata.put("product_line_code",prdt_line );
			tabdata.put("status","" );
			tabdata.put("modified_by_id",addedById );
			tabdata.put("modified_date",added_date );
			tabdata.put("modified_facility_id",facilityId );	
			tabdata.put("modified_at_ws_no",client_ip_address );

		
			HashMap condflds=new HashMap();
			condflds.put("currency_code",currency_code);

			
				
			String table_name	= "sy_foreign_currency";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
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

			boolean updated	= (((Boolean) results.get( "status" )).booleanValue()) ;
			String error		= (String) results.get("error") ;
			String error_value	= "0" ;

			
			if ( updated )
			{
				error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" ) );
			}

			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
			if ( condflds != null) condflds.clear();
		
		}catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();

		}
	}

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
}
