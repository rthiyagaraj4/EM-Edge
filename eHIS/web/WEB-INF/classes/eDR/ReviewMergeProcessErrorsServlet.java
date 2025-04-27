/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
	Developed By       :  NANDA KUMAR R.
	Module Name 	   :  eCIS/dr
	Function Name	   :  Review Merge Process Errors
	Function ID		   :

*/

package eDR;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;

public class ReviewMergeProcessErrorsServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;
	
	HttpSession session	=null;
	Connection con						= null;
	Statement stmt						= null;
	PreparedStatement pstmt				= null;
	ResultSet rs						= null;
	ResultSet messageResultset          = null;
	String facilityId				= "";
	String modifiedById				= "";
	String client_ip_address		= "";
	String mode							= "";
	String p_update_string				= "";
	String dupgroupid					= "";
	
	StringBuffer UpdateSqlBuffer	= null;

	int rsupdatehdr	= 0;

	public void init(ServletConfig config) throws ServletException
	{
			super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			session					= req.getSession(false);
			con		= ConnectionManager.getConnection(req);
			stmt	= con.createStatement();			
			this.p					= (Properties) session.getValue("jdbc"); 
			this.out	= res.getWriter();
			
			mode						= req.getParameter("mode");
			p_update_string				= req.getParameter("update_string");
			this.facilityId			= (String) session.getValue("facility_id" ) ;
			this.client_ip_address	= p.getProperty("client_ip_address");	
			modifiedById				= p.getProperty( "login_user" ) ;				
			if(mode.equals("update"))			updateReviewMergeProcessErrorsServlet(res);

			if(rs!=null) 	rs.close();
			if(messageResultset!=null) 	messageResultset.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
		}catch(Exception e){out.println("Exception in doPost method :"+ e.toString());}
		finally
		{
			ConnectionManager.returnConnection(con,req);
		}
	}//do post
	private synchronized void updateReviewMergeProcessErrorsServlet(HttpServletResponse res)
	{
		try
		{
			String locale = p.getProperty("LOCALE");
			

			UpdateSqlBuffer = new StringBuffer();

			con.setAutoCommit(false);

			StringTokenizer token	= new StringTokenizer(p_update_string,"`");
		//	String p_message_code	= "RECORD_MODIFIED";
			
			UpdateSqlBuffer.append("UPDATE dr_dup_group_hdr SET group_status = 'I', marked_for_merge_yn = 'N' ,modified_by_id = '"+modifiedById+"',modified_date = sysdate, modified_at_ws_no = '"+client_ip_address+"', modified_facility_id = '"+facilityId+"' where dup_group_id = ?");
			pstmt = con.prepareStatement(UpdateSqlBuffer.toString());

			while(token.hasMoreTokens())
			{
				dupgroupid = token.nextToken();
				
				pstmt.setString(1,dupgroupid);
				rsupdatehdr = pstmt.executeUpdate();

				if((UpdateSqlBuffer != null) && (UpdateSqlBuffer.length() > 0))
				{
					UpdateSqlBuffer.delete(0,UpdateSqlBuffer.length());
				}
			} 

			if(rsupdatehdr > 0 )
			{
				con.commit();

			/*	String code     = "";
				String message	= "";
				String msg		= "";

				msg = "SELECT message_id, message_text_sysdef from sm_message WHERE message_ref =  '"+p_message_code+"'";
				messageResultset = stmt.executeQuery(msg);
				if(messageResultset != null && messageResultset.next())
				{
					code	= messageResultset.getString("message_id");
					message = messageResultset.getString("message_text_sysdef");
				} if(messageResultset != null) messageResultset.close();   */

				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_MODIFIED", "SM");
				String error = ((String) message.get("message"));

				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8" ) + "&err_value=1 " );
			}
			else
			{
				con.rollback();

		/*		String code		= "";
				String message	= "";
				String msg		= "";

				msg = "SELECT message_id, message_text_sysdef FROM sm_message WHERE message_ref = '"+p_message_code+"'";
				messageResultset = stmt.executeQuery(msg);
				if(messageResultset != null)
				{
					if(messageResultset.next())
					{
						code	= messageResultset.getString("message_id");
						message = messageResultset.getString("message_text_sysdef");
					}
				} if(messageResultset != null) messageResultset.close();
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(""+code+" "+message+"" ) + "&err_value=0 " );   */
			
			}
			if(pstmt != null) pstmt.close();
			if(stmt != null) stmt.close();
		}catch(Exception e)
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not modified </h3> Foll: Error Received : "+e.toString());
		}
	}//method
}//class
