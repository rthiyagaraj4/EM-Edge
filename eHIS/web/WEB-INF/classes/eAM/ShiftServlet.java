/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;
import java.sql.Connection;



public class ShiftServlet extends HttpServlet
{
	private ServletConfig config = null;
	HttpSession session = null;
	String facility_id = "";
	Properties p = new Properties();
	String client_ip_address = "";
	String locale="";
	Connection connection	= null;
	PreparedStatement stmt			= null;
	PreparedStatement pstmt			= null;
	Statement stmt1			= null;
	ResultSet rs			= null;
	String shift_indicator = "";
	String shift_code = "";
	String short_desc = "";
	String long_desc = "";
	String productive_flag = "";
	String shift_start_time = "";
	String shift_end_time = "";
	String appl_for_working_days = "";
	String appl_for_nonworking_days = "";
	String appl_for_holidays = "";
	String mnemonic_key = "";
	String eff_status = "";
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id = "";
	String modified_at_ws_no = "";
	String modified_facility_id = "";


	public void init(ServletConfig config)
		throws ServletException
	{
		super.init(config);
		this.config = config;
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException
	{
		doPost(request,response);
	}
	public synchronized void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException
	{
		session = request.getSession(false);
		this.facility_id = (String) session.getAttribute( "facility_id" ) ;
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		 locale= p.getProperty("LOCALE");

		try{
			response.setContentType("text/html");
			String operation = request.getParameter("operation_type");

			if ( operation.equals("insert") )   insertOperation(request, response);
			if ( operation.equals("modify"))    modifyOperation(request, response);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public void insertOperation(HttpServletRequest request,HttpServletResponse response)
	{
		try{



		session = request.getSession(false);
		facility_id = (String) session.getAttribute( "facility_id" ) ;
		p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		int res=0;
		connection = ConnectionManager.getConnection(request);
		stmt1=connection.createStatement();

		added_by_id 	= p.getProperty( "login_user" ) ;
		added_at_ws_no	= client_ip_address;
		added_facility_id		= facility_id;
		modified_by_id	= added_by_id ;
		modified_at_ws_no	= added_at_ws_no ;
		modified_facility_id 	= facility_id ;



		shift_indicator = request.getParameter("shift_indicator")==null ? "":request.getParameter("shift_indicator");
		shift_code = request.getParameter("shift_code")==null ? "":request.getParameter("shift_code");
		short_desc = request.getParameter("short_desc")==null ? "":request.getParameter("short_desc");
		long_desc = request.getParameter("long_desc")==null ? "":request.getParameter("long_desc");
		productive_flag = request.getParameter("productive_flag")==null ? "":request.getParameter("productive_flag");
		shift_start_time = request.getParameter("starthour")+":"+request.getParameter("startmin");
		shift_end_time = request.getParameter("endhour") + ":" + request.getParameter("endmin");
		appl_for_working_days = request.getParameter("appl_for_working_days")==null ? "N":request.getParameter("appl_for_working_days");
		appl_for_nonworking_days = request.getParameter("appl_for_nonworking_days")==null ? "N":request.getParameter("appl_for_nonworking_days");
		appl_for_holidays = request.getParameter("appl_for_holidays")==null ? "N":request.getParameter("appl_for_holidays");
		mnemonic_key = request.getParameter("mnemonic_key")== null ? "":request.getParameter("mnemonic_key");
		eff_status = request.getParameter("eff_status")==null ? "D": request.getParameter("eff_status");



		String sql1="SELECT SHIFT_CODE FROM am_shift  WHERE  SHIFT_CODE ='"+shift_code+"'  or  MNEMONIC_KEY='"+mnemonic_key+"'";
		rs=stmt1.executeQuery(sql1);
		if(rs!=null && rs.next())
		{
			String error_value1 = "0" ;
			Hashtable hashtable1 = MessageManager.getMessage(locale, "CODE_ALREADY_EXISTS","Common");
             error_value1 = (String)hashtable1.get("message");
			 hashtable1.clear();
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error_value1,"UTF-8" )+"&err_value=1");
		}else
		{
		
		String query = "insert into am_shift(shift_code,short_desc,long_desc,shift_indicator,productive_flag,shift_start_time,shift_end_time,appl_for_working_days,appl_for_nonworking_days,appl_for_holidays,mnemonic_key,eff_status,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values ('"+shift_code+"','"+short_desc+"','"+long_desc+"','"+shift_indicator+"','"+productive_flag+"',to_date('"+shift_start_time+"','hh24:mi'),to_date('"+shift_end_time+"','hh24:mi'),'"+appl_for_working_days+"','"+appl_for_nonworking_days+"','"+appl_for_holidays+"','"+mnemonic_key+"','"+eff_status+"','"+added_by_id+"',sysdate,'"+added_at_ws_no+"','"+added_facility_id+"','"+modified_by_id+"',sysdate,'"+modified_at_ws_no+"','"+modified_facility_id+"')";

		stmt = connection.prepareStatement( query );

	

		res= stmt.executeUpdate();

			String error_value = "0" ;
			
		if(res>0)
			{
			connection.commit();
			Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
              error_value = (String)hashtable1.get("message");
			  hashtable1.clear();
			}else
			{
			error_value = "Exception Occured... ";
			}
		response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error_value,"UTF-8" )+"&err_value=1");
	}
			if(stmt1 !=null) stmt1.close();
			if(rs !=null) rs.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}finally
		{
			if(connection !=null)
			{
				ConnectionManager.returnConnection(connection,p);
			}
		}
	}
	//End of Insert

	public void modifyOperation(HttpServletRequest request,HttpServletResponse response)
		throws Exception
	{
		try{
		session = request.getSession(false);
		facility_id = (String) session.getAttribute( "facility_id" ) ;
		p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		connection = ConnectionManager.getConnection(request);
		int res=0;	

		added_by_id 	= p.getProperty( "login_user" ) ;
		added_at_ws_no	= client_ip_address;
		added_facility_id		= facility_id;
		modified_by_id	= added_by_id ;
		modified_at_ws_no	= added_at_ws_no ;
		modified_facility_id 	= facility_id ;


		shift_indicator = request.getParameter("shift_indicator")==null ? "":request.getParameter("shift_indicator");
		shift_code = request.getParameter("shift_code")==null ? "":request.getParameter("shift_code");
		short_desc = request.getParameter("short_desc")==null ? "":request.getParameter("short_desc");
		long_desc = request.getParameter("long_desc")==null ? "":request.getParameter("long_desc");
		productive_flag = request.getParameter("productive_flag1")==null ? "":request.getParameter("productive_flag1");
		shift_start_time = request.getParameter("starthour")+":"+request.getParameter("startmin");
		shift_end_time = request.getParameter("endhour") + ":" + request.getParameter("endmin");
		appl_for_working_days = request.getParameter("appl_for_working_days")==null ? "N":request.getParameter("appl_for_working_days");
		appl_for_nonworking_days = request.getParameter("appl_for_nonworking_days")==null ? "N":request.getParameter("appl_for_nonworking_days");
		appl_for_holidays = request.getParameter("appl_for_holidays")==null ? "N":request.getParameter("appl_for_holidays");
		mnemonic_key = request.getParameter("mnemonic_key")== null ? "":request.getParameter("mnemonic_key");
		eff_status = request.getParameter("eff_status")==null ? "D": request.getParameter("eff_status");

		
		String query = "update am_shift set short_desc = '"+short_desc+"',long_desc='"+long_desc+"',productive_flag='"+productive_flag+"',shift_start_time=to_date('"+shift_start_time+"','hh24:mi'),shift_end_time=to_date('"+shift_end_time+"','hh24:mi'),appl_for_working_days='"+appl_for_working_days+"',appl_for_nonworking_days='"+appl_for_nonworking_days+"',appl_for_holidays='"+appl_for_holidays+"',mnemonic_key='"+mnemonic_key+"',eff_status='"+eff_status+"',added_by_id='"+added_by_id+"',added_date =sysdate,added_at_ws_no='"+added_at_ws_no+"',added_facility_id='"+added_facility_id+"',modified_by_id='"+modified_by_id+"',modified_date=sysdate,modified_at_ws_no='"+modified_at_ws_no+"',modified_facility_id='"+modified_facility_id+"' where shift_code ='"+shift_code+"' and shift_indicator='"+shift_indicator+"'";
		pstmt = connection.prepareStatement( query );
		res=pstmt.executeUpdate();

	String error_value = "0";
	
	if(res>0)
	{
		connection.commit();
		Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
              error_value = (String)hashtable1.get("message");
			  hashtable1.clear();
	}else	{
		error_value = "Exception Occured...";
			}

	
	response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error_value,"UTF-8" )+"&err_value=1" );


	if(pstmt !=null) pstmt.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			if(connection !=null)
			{
				ConnectionManager.returnConnection(connection,p);
			}
		}
	}


}
