/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SpecialtyParamServlet extends HttpServlet 
{
		public  void init(ServletConfig config) throws ServletException
	{
			 super.init(config);
	}
/**
*	doPost	-	will be called when the method is of post
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	 {  request.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		//String mode = request.getParameter("mode") == null ? "" :  request.getParameter("mode");
		//if(mode.equals("insert"))
				insert(request,response, out);
		
	}
	private void insert(HttpServletRequest request,HttpServletResponse response, PrintWriter out)		
	 {

		java.util.Properties p;
		HttpSession session;
		Connection con = null;
		PreparedStatement pstmt;

		Hashtable	tabdata;
		String		errorMsg = "";
		String		errVal = "0";

		String facility_id				= "" ;
		String added_id					= "" ;
		String client_ip_address		= "" ;
		String module_id				= "" ;
		String contl_type				= "" ;
		String noofdays					= "" ;
		String locale					= "" ;
		String contl_days					= "" ;
		int inserted					=	0;
		
		session = request.getSession(false);
		p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		

		facility_id			= (String) session.getAttribute( "facility_id" ) ;
		client_ip_address	= p.getProperty("client_ip_address");
		locale = (String) p.getProperty("LOCALE");
		added_id =  (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		String delCaSpltyParam = "DELETE FROM CA_SPLTY_PARAM ";
		
		String insCaSpltyParam ="insert into CA_SPLTY_PARAM (module_id,contl_type          ,noofdays,contl_days,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values(?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";

		try
		{
			con = ConnectionManager.getConnection(request);

			module_id =  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
			contl_type =  request.getParameter("cntlType") == null ? "" : request.getParameter("cntlType");
			noofdays =  request.getParameter("noofDays") == null ? "" : request.getParameter("noofDays");
			contl_days =  request.getParameter("contl_days") == null ? "" : request.getParameter("contl_days");
			
			pstmt = con.prepareStatement(delCaSpltyParam);
			pstmt.executeUpdate();

			if(pstmt != null) pstmt.close();

			pstmt = con.prepareStatement(insCaSpltyParam);
			
			pstmt.setString(1,module_id);
			pstmt.setString(2,contl_type);
			pstmt.setString(3,noofdays);
			pstmt.setString(4,contl_days);
			pstmt.setString(5,added_id);
			pstmt.setString(6,client_ip_address);
			pstmt.setString(7,facility_id);
			pstmt.setString(8,added_id);
			pstmt.setString(9,client_ip_address);
			pstmt.setString(10,facility_id);

			inserted = pstmt.executeUpdate();

			if(inserted != 0)
			{
				con.commit();
				tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
				errorMsg= (String) tabdata.get("message");
				errVal = "1";
			}			
			
			if(pstmt != null) pstmt.close();

			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);

		}
		catch(Exception ee)
		{			
			try
			{
				con.rollback();
				tabdata = MessageManager.getMessage(locale,"FAILED_TRANSACTION","CA");
				errorMsg= (String) tabdata.get("message");
				errVal = "0";
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
			}
			catch (Exception e)
			{
			}		
			
			ee.printStackTrace();
		}
		finally
		{
			
			if(con != null)  ConnectionManager.returnConnection(con);
		}


	 }






}
