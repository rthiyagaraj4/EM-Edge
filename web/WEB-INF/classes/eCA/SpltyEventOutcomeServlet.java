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
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eCA.SectionForNoteType.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

public class SpltyEventOutcomeServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
			insertOutcomeEvent(request,response, out);
		}
		catch(Exception e)
		{
			out.println("Exception in try of doPost() of SpltyEventOutcomeServlet.java "+e.toString());
			
			e.printStackTrace();
		}
	}

	private void insertOutcomeEvent(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
	{
		java.util.Properties p;

		String facilityId			= "" ;
		String client_ip_address	= "";
		String countOfRows			= "";
		String outcome_code			= "";
		String seq_num_text			= "";
		String module_id			= "";
		String event_id				= "";
		String close_episode		= "";
		Connection con				= null;
		PreparedStatement pstmt		= null;
		

		HttpSession session;

		//java.util.HashMap valueMap = new java.util.HashMap();
		
		session = request.getSession(false);
		
				p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		String	locale				= (String) p.getProperty("LOCALE");
				facilityId			= (String) session.getValue( "facility_id" ) ;
				client_ip_address	= (String) p.getProperty("client_ip_address");
		String	added_by_id			= (String) p.getProperty("login_user");
		String	error_value			= "0" ;

		try
		{

			countOfRows		= request.getParameter("countOfRows") == null ? "" : request.getParameter("countOfRows");
			module_id		= request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
			event_id		= request.getParameter("event_id") == null ? "" : request.getParameter("event_id");
			
			String strErrMsg ="";

			int i	= Integer.parseInt(countOfRows);
			int del	=	0;
			boolean bCommitFlag = true;

			String delete_query =" delete from CA_SPLTY_EVENT_OUTCOME where module_id =? and splty_event_code =? " ;
			String ins_query ="INSERT INTO  CA_SPLTY_EVENT_OUTCOME ( SPLTY_EVENT_CODE,OUTCOME_CODE,MODULE_ID,CLOSE_EPISODE_YN,ADDED_BY_ID,ADDED_DATE ,ADDED_AT_WS_NO ,ADDED_FACILITY_ID , MODIFIED_BY_ID , MODIFIED_DATE, MODIFIED_AT_WS_NO , MODIFIED_FACILITY_ID ) VALUES(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
			con = ConnectionManager.getConnection(request);
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(delete_query);
			pstmt.setString(1,module_id);
			pstmt.setString(2,event_id);
			del =pstmt.executeUpdate();

			if(pstmt != null) 
				pstmt.close();
			
			pstmt = con.prepareStatement(ins_query);
			for(int j=0;j<i;j++)
				{
					outcome_code = request.getParameter("outcome_code"+j) == null ? "" : request.getParameter("outcome_code"+j);
					seq_num_text = request.getParameter("seq_num_text"+j) == null ? "" : request.getParameter("seq_num_text"+j);
					close_episode = request.getParameter("close_episode"+j) == null ? "N" : request.getParameter("close_episode"+j);
					
					if(close_episode.equals(""))
					{
						close_episode="N";
					}
											
					pstmt.setString(1,event_id);
					pstmt.setString(2,outcome_code);
					pstmt.setString(3,module_id);
					pstmt.setString(4,close_episode); 
					pstmt.setString(5,added_by_id);
					pstmt.setString(6,client_ip_address);
					pstmt.setString(7,facilityId);
					pstmt.setString(8,added_by_id);
					pstmt.setString(9,client_ip_address);
					pstmt.setString(10,facilityId);
					pstmt.addBatch();
					
				}
					int [] nUpdCount = pstmt.executeBatch();
					

					if(pstmt != null) 
					pstmt.close();

				if(nUpdCount.length == -3 || nUpdCount.length < i)
					bCommitFlag = false;

				if(bCommitFlag)
				{
					con.commit();
					strErrMsg = getMessage(locale,"RECORD_INSERTED","CA");
					error_value = "1" ;
									
				}
				else
				{
					con.rollback();
					strErrMsg = getMessage(locale,"FAILED_TRANSACTION","CA");
				}
			
		
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode(strErrMsg,"UTF-8")+"&err_value=" + error_value);
				
		}
		catch(Exception e)
			{
				//out.println("Exception in try of SpltyEventOutcomeServlet.java"+e.toString());//common-icn-0181
			
				e.printStackTrace();
			}

		finally
			{
				if(con!=null)	ConnectionManager.returnConnection(con,request);
						
			} 

	}

private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}

};
