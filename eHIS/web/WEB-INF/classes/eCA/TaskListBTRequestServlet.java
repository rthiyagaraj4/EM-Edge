/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA ;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.XMLStringParser;

import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;

public class TaskListBTRequestServlet extends HttpServlet
{

	public void init(ServletConfig cfg) throws ServletException
	{
		super.init(cfg);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
    {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		java.io.PrintWriter out = response.getWriter();
		HttpSession session	=	null;
        session		=	request.getSession(true) ;

		try
        {
			requestAndPrint(request,response,session,out);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}

	private void requestAndPrint(HttpServletRequest request, HttpServletResponse response, HttpSession session, PrintWriter out)
	{
		String login_user	= "";
		String facility_id	= "";
		String patient_id	= "";
        String query		= "";
		String session_id	= "";
		String from_date	= "";
		String print_mode	= "";
		String specimen_no	= "";
		String unit_no		= "";
		String product_code	= "";
		String rowid		= "";

		XMLStringParser parser = new  XMLStringParser();

		Map hash = (Map) parser.parseXMLString( request ) ;
		hash = (Map) hash.get("SEARCH") ;

		patient_id		= (String) hash.get("patient_id");
		facility_id		= (String) hash.get("facility_id");
		specimen_no		= (String) hash.get("specimen_no");
		unit_no			= (String) hash.get("unit_no");
		product_code	= (String) hash.get("product_code");
		rowid			= (String) hash.get("rowid");
		print_mode		= (String) hash.get("print_mode");
		

		java.util.Properties p	= null;
		Connection con			= null;
		PreparedStatement pstmt = null;
				
		p			= (java.util.Properties) session.getValue( "jdbc" ) ;		
		login_user	= (String) p.getProperty( "login_user" ) ;
		String  language_id  = p.getProperty("LOCALE");

		try 
		{
			con = ConnectionManager.getConnection(request);
			
			if(print_mode.equals("REQUEST"))
			{
				pstmt = con.prepareStatement("update BT_UNIT_REQUEST_DTL set REQUEST_FOR_ISSUE_BY = ?, REQUEST_FOR_ISSUE_DATE = SYSDATE where rowid = ?");
						
				pstmt.setString(1,login_user);
				pstmt.setString(2,rowid);

				pstmt.executeUpdate();
				if(pstmt != null) pstmt.close();
			}
	
			session_id = getSessionId(con);
			from_date = getFormatDate(con);

			query = "INSERT INTO SY_PROG_PARAM(PGM_ID, SESSION_ID, PGM_DATE, PARAM1, PARAM2, PARAM3, PARAM4,PARAM5,PARAM6) VALUES(?,?,?,?,?,?,?,?,?)";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1,"BTRCOLRQ");
			pstmt.setString(2,session_id);
			pstmt.setString(3,from_date);
			pstmt.setString(4,facility_id);
			pstmt.setString(5,patient_id);
			pstmt.setString(6,specimen_no);
			pstmt.setString(7,unit_no);
			pstmt.setString(8,product_code);
			pstmt.setString(9,login_user);

			int count = pstmt.executeUpdate();
														
			if (count > 0 )
			{
				con.commit();
			}
			if(pstmt != null) pstmt.close();	
			
			try
			{
				String module_id = "BT";
				String report_id = "BTRCOLRQ";

				OnlineReport onlinereportParam = new OnlineReport(facility_id, module_id, report_id);

				onlinereportParam.addParameter("p_facility_id" , facility_id);
				onlinereportParam.addParameter("p_pgm_date", from_date);
				onlinereportParam.addParameter("p_pgm_id" , report_id);
				onlinereportParam.addParameter("p_session_id" , session_id);
				onlinereportParam.addParameter("p_language_id" , language_id);//Added on 8/20/2010 by Archana for IN023348
				OnlineReports onlinereports = new OnlineReports();
				onlinereports.add(onlinereportParam);

				onlinereports.execute(request, response);
				onlinereportParam = null;
				onlinereports = null;
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
			//out.println("<script>alert('Print Request sent to the server....')</script>");
		}
		catch(Exception e)
		{
			try
			{
				con.rollback();
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
			}
			e.printStackTrace();
			
		}
		finally
		{
			try
			{
				if(con != null) ConnectionManager.returnConnection(con,request);
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
			}
		}
				
	}

	private String getSessionId(Connection con)throws Exception
	{
		String session_id = "";
		PreparedStatement pstmt = con.prepareCall("select USERENV('SESSIONID') from dual");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			session_id = rs.getString(1);
		}
		rs.close();
		pstmt.close();

		return session_id;
	}
	
	private String getFormatDate(Connection con)throws Exception
	{
		String from_date = "";
		PreparedStatement pstmt = con.prepareCall("select to_char(SYSDATE,'DDMMYYHH24MISS') from dual");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			from_date = rs.getString(1);
		}
		rs.close();
		pstmt.close();
				
		return from_date;
	}
}
