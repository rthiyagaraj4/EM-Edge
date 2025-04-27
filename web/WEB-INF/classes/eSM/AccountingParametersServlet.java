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
import java.util.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class AccountingParametersServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{

	PrintWriter out;
	java.util.Properties p;

	String entity				;
	String client_ip_address 	;
	String no_acct_periods		;
	String start_fiscal_month	;
	String department_length	;
	String prefix_dept_by_facility;
	String currency_name		;
	String decimal_name			;


	Connection con ;
	PreparedStatement pstmt ;
	ResultSet rs ;	

	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
    	res.setContentType("text/html;charset=UTF-8");
		session 		= req.getSession(false) ;

		out = res.getWriter() ;
		p = ( java.util.Properties ) session.getValue( "jdbc" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		entity				= req.getParameter( "entity" ) ;
		no_acct_periods	= req.getParameter( "no_acct_periods" ) ;
		start_fiscal_month = req.getParameter( "start_fiscal_month" ) ;
		department_length	= req.getParameter( "department_length" ) ;
		prefix_dept_by_facility = req.getParameter( "prefix_dept_by_facility" ) ;
		currency_name		= req.getParameter( "currency_name" ) ;
		decimal_name		= req.getParameter( "decimal_name" ) ;
		if(no_acct_periods == null)		no_acct_periods = "";
		if(start_fiscal_month == null)	start_fiscal_month = "";
		if(department_length == null)	department_length = "";
		if(currency_name == null)		currency_name = "";
		if(decimal_name == null)		decimal_name = "";
		if(prefix_dept_by_facility == null) prefix_dept_by_facility = "N";

		insertUpdateOperValues( req, res );
	}

	private void insertUpdateOperValues(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			String addedById = p.getProperty( "login_user" ) ;
			Timestamp  tsTime = new Timestamp(System.currentTimeMillis() );
			boolean inserted = false;
			String error = "";
			String error_value = "";

			con = ConnectionManager.getConnection(req);
			int rec_count = 0;
			try
			{
				pstmt = con.prepareStatement("SELECT count(*) FROM SM_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = '"+entity+"' ");
				rs = pstmt.executeQuery();
				
				if(rs.next())
					rec_count = rs.getInt(1);

				if(rec_count == 0)
				{
					HashMap tabledata=new HashMap();
					tabledata.put("ACC_ENTITY_ID",entity);
					tabledata.put("ACCOUNTING_NAME_LONG",req.getParameter("entity_desc_long")== null ?"":req.getParameter("entity_desc_long"));
					tabledata.put("ACCOUNTING_NAME_SHORT",req.getParameter("entity_desc_short")== null ?"":req.getParameter("entity_desc_short"));
					tabledata.put("NUM_OF_ACC_PERIODS",req.getParameter("no_acct_periods")== null ?"":req.getParameter("no_acct_periods"));
					tabledata.put("START_FISCAL_MONTH",start_fiscal_month);
					tabledata.put("DEPT_CODE_LENGTH",department_length);
					tabledata.put("PREFIX_FACL_ID_FOR_INT_YN",prefix_dept_by_facility);
					tabledata.put("BASE_CURRENCY",currency_name);
					tabledata.put("BASE_CURRENCY_DEC",decimal_name);
					tabledata.put("NO_OF_DECIMAL",req.getParameter("no_of_decimals")== null ?"":req.getParameter("no_of_decimals"));
					tabledata.put("ADDED_BY_ID",addedById);
					tabledata.put("ADDED_DATE",tsTime);
					tabledata.put("ADDED_AT_WS_NO",client_ip_address);
					tabledata.put("MODIFIED_BY_ID",addedById);
					tabledata.put("MODIFIED_DATE",tsTime);
					tabledata.put("MODIFIED_AT_WS_NO",client_ip_address);
					String dupfields[]={"ACC_ENTITY_ID"};

					boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
					Object argArray[] = new Object[4];
					String table_name="SM_ACC_ENTITY_PARAM";
					argArray[0] = p;
					argArray[1] = tabledata;
					argArray[2] = dupfields;
					argArray[3] = table_name;
		
					Class [] paramArray = new Class[4];
					paramArray[0] = p.getClass();
					paramArray[1] = tabledata.getClass();
					paramArray[2] = dupfields.getClass();
					paramArray[3] = table_name.getClass();
		

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				error = (String) results.get("error") ;
				error_value = "0" ;
                tabledata.clear();
				results.clear();
				}
				else if(rec_count > 0)
				{
					HashMap tabledata=new HashMap();
					HashMap condfields = new HashMap();

					tabledata.put("NUM_OF_ACC_PERIODS",no_acct_periods);
					tabledata.put("ACCOUNTING_NAME_LONG",req.getParameter("entity_desc_long")== null ?"":req.getParameter("entity_desc_long"));
					tabledata.put("ACCOUNTING_NAME_SHORT",req.getParameter("entity_desc_short")== null ?"":req.getParameter("entity_desc_short"));
					tabledata.put("START_FISCAL_MONTH",start_fiscal_month);
					tabledata.put("DEPT_CODE_LENGTH",department_length);
					tabledata.put("PREFIX_FACL_ID_FOR_INT_YN",prefix_dept_by_facility);
					tabledata.put("BASE_CURRENCY",currency_name);
					tabledata.put("BASE_CURRENCY_DEC",decimal_name);
					tabledata.put("NO_OF_DECIMAL",req.getParameter("no_of_decimals")== null ?"":req.getParameter("no_of_decimals"));
					tabledata.put("MODIFIED_BY_ID",addedById);
					tabledata.put("MODIFIED_DATE",tsTime);
					tabledata.put("MODIFIED_AT_WS_NO",client_ip_address);

					condfields.put("ACC_ENTITY_ID",entity);
			
					boolean local_ejbs = false;
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
					Object argArray[] = new Object[4];
					String table_name="SM_ACC_ENTITY_PARAM";
					argArray[0] = p;
					argArray[1] = tabledata;
					argArray[2] = condfields;
					argArray[3] = table_name;

					Class [] paramArray = new Class[4];
					paramArray[0] = p.getClass();
					paramArray[1] = tabledata.getClass();
					paramArray[2] = condfields.getClass();
					paramArray[3] = table_name.getClass();
		

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
					error = (String) results.get("error") ;
					error_value = "0" ;
				    tabledata.clear();
					condfields.clear();
				    results.clear();

				}
				
			}
			catch(Exception e)
			{	
				out.println("Exception raised by Servlet :"+e.toString());
				out.println(" Values sent are : ACC_ENTITY_ID:"+entity+"   NUM_OF_ACC_PERIODS:"+no_acct_periods+"   START_FISCAL_MONTH:"+start_fiscal_month+"   DEPT_CODE_LENGTH:"+department_length+"   PREFIX_FACL_ID_FOR_INT_YN:"+prefix_dept_by_facility+"   BASE_CURRENCY:"+currency_name+"   BASE_CURRENCY_DEC:"+decimal_name+"   ADDED_BY:"+addedById+"   ADDED_DATE:"+tsTime+"   IP_ADDRESS:"+client_ip_address);	
			}
			finally
			{
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if( con != null ) ConnectionManager.returnConnection(con,req);
			}
			

			if ( inserted )
			{
				
				 error_value = "1" ;
			}
			else
			{
				 error_value = "0" ;
			}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
	}
	catch ( Exception e )
	{
		out.println( e.getMessage() );	}
	}
}
