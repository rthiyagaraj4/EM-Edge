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
import javax.servlet.*;
import javax.servlet.http.*;
//import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

public class PatProfileContentServlet extends javax.servlet.http.HttpServlet
{
    
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }
	
public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}
    public  void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
    {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");	
		PrintWriter out = null;
		HttpSession session;
		session = request.getSession(false);

		String content_id			= "";
		String content_sys_def_desc = "";
		String content_user_def_desc= "";
		String order_seq_no			= "";
		String include_yn			= "";
		String strSql = "";
		String strSql1 = "";
		String error_value="";
		String error="";
		int rowCount = 1;
		Connection con				= null;
		PreparedStatement pstmt		= null;	
		PreparedStatement pstmt1		= null;	
		ResultSet oRs = null;
		Properties p;

		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");

		//this.out = response.getWriter();

		try
        {
			out = response.getWriter();
			con = ConnectionManager.getConnection(request);
			con.setAutoCommit(false);

			strSql	="select content_id, CONTENT_SYS_DEF_DESC,CONTENT_USER_DEF_DESC,ORDER_SEQ_NO,INCLUDE_YN  from ca_patient_profile_content";
			pstmt = con.prepareStatement(strSql);
			oRs =	pstmt.executeQuery();

			
			strSql1 = "update ca_patient_profile_content set content_sys_def_desc=?,content_user_def_desc=?,order_seq_no=?,include_yn=? 	where content_id=?";
			pstmt1 = con.prepareStatement(strSql1);
			
			while (oRs.next())
			{
				// update the records
				
				content_id				= oRs.getString("content_id").trim();
				content_sys_def_desc	= request.getParameter("content_sys_def_desc"+content_id);
				content_user_def_desc	= request.getParameter("content_user_def_desc"+content_id);
				include_yn				= request.getParameter("include_yn"+content_id)==null?"N":"Y";
				order_seq_no			= request.getParameter("order_seq_no"+rowCount);
				
				//strSql = "update ca_patient_profile_content set content_sys_def_desc=?,content_user_def_desc=?,order_seq_no=?,include_yn=? 	where content_id=?";

				/*pstmt = con.prepareStatement(strSql);
				pstmt.setString(1,content_sys_def_desc);
				pstmt.setString(2,content_user_def_desc);
				pstmt.setString(3,order_seq_no);
				pstmt.setString(4,include_yn);
				pstmt.setString(5,content_id);*/
				pstmt1.setString(1,content_sys_def_desc);
				pstmt1.setString(2,content_user_def_desc);
				pstmt1.setString(3,order_seq_no);
				pstmt1.setString(4,include_yn);
				pstmt1.setString(5,content_id);
				pstmt1.executeUpdate();
				rowCount++;
			}//while

			if(oRs !=null) oRs.close();
			if(pstmt1 !=null) pstmt1.close();
			if(pstmt !=null) pstmt.close();


			con.commit();
			error = getMessage(locale, "RECORD_INSERTED","CA");
			error_value = "1" ;		response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8"));
		
		}//try2
		catch(Exception e)
		{
			error_value	= "0" ;
			error = getMessage(locale, "FAILED_TRANSACTION","CA");
			try
			{
				out.println("Error : " +e);
				con.rollback();
			}//try3
			catch(Exception ee){
				//out.println("Exception in try3 of PatProfileContentServlet......"+e);//common-icn-0181
				ee.printStackTrace();
			}
		}
		finally
		{
			try
			{
				
				if(con!=null) ConnectionManager.returnConnection(con, request);
				//	response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );			    
			}//try4
			catch(Exception e){ 
				//out.println("in finally"+e.toString()); //common-icn-0181
				e.printStackTrace();
			}
		}

	}
	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
}
