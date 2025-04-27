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
public class  SpecialityTasksForEventsServlet extends HttpServlet 
{
	/**
*	init	-	will initialise the servlet
*	@param	config - this is ServletConfig
*/
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
			insertSpltyTasksForEvent(request,response, out);
		}
		catch(Exception e)
		{
			out.println("Exception in try of doPost() of SpecialityTasksForEventsServlet.java "+e.toString());
			
			e.printStackTrace();
		}
	}
  
private void insertSpltyTasksForEvent(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
	{
		java.util.Properties p;
		
		String facilityId			= "" ;
		String client_ip_address	= "";
		String module			= "";
		String code			= "";
		String note_seq_num			= "";
		String event_id			= "";
		String no_of_trans			= "";
		String countOfRows			= "";
        String errMsg="";
		String error_value="0";
		String sec_hdg_code="";
		Hashtable tabdata;
		Connection con				= null;
		PreparedStatement pstmt		= null;
		//ResultSet rs				= null;
		HttpSession session;

		//java.util.HashMap valueMap = new java.util.HashMap();
		
		session = request.getSession(false);
		
		p						= (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale			= (String) p.getProperty("LOCALE");
		facilityId				= (String) session.getValue( "facility_id" ) ;
		client_ip_address		= (String) p.getProperty("client_ip_address");
		String added_by_id		= (String) p.getProperty("login_user");
		boolean  inser_flag=true; 

		try
		{
			module		= request.getParameter("module") == null ? "" : request.getParameter("module");
			code		= request.getParameter("code") == null ? "" : request.getParameter("code");
			event_id		= request.getParameter("event_id") == null ? "" : request.getParameter("event_id");
			no_of_trans		= request.getParameter("no_of_trans") == null ? "" : request.getParameter("no_of_trans");
			countOfRows		= request.getParameter("countOfRows") == null ? "" : request.getParameter("countOfRows");
			
													
			int i = Integer.parseInt(countOfRows);
			String  insert_query="Insert into CA_SPLTY_TASKS_FOR_EVENTS ( MODULE_ID,SPLTY_EVENT_CODE,SPLTY_TASK_CODE,HEADER_SPLTY_TASK_CODE,ORDER_SEQ_NO,NUMB_OF_TRANS_ALLOWED,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID ) values	 (?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			String  delete_query="Delete  from CA_SPLTY_TASKS_FOR_EVENTS where SPLTY_EVENT_CODE =? and  MODULE_ID=?";
			con = ConnectionManager.getConnection(request);
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(delete_query);
			pstmt.setString(1,event_id.trim());
			pstmt.setString(2,module.trim());
			int delRec =pstmt.executeUpdate();
			delRec = delRec;			 
			
			if(pstmt != null) 
			pstmt.close();
			pstmt = con.prepareStatement(insert_query);
			for(int j=0;j<i;j++)
			{
				sec_hdg_code = request.getParameter("splty_task_code"+j) == null ? "" : request.getParameter("splty_task_code"+j);
				
				note_seq_num = request.getParameter("seq_num_text"+j) == null ? "" : request.getParameter("seq_num_text"+j);
				 
			
				    pstmt.setString(1,module.trim());
					pstmt.setString(2,event_id.trim());
					pstmt.setString(3,sec_hdg_code.trim());
					pstmt.setString(4,code.trim());
					pstmt.setString(5,note_seq_num.trim());
					pstmt.setString(6,no_of_trans.trim());
					pstmt.setString(7,added_by_id);
					pstmt.setString(8,client_ip_address);
					pstmt.setString(9,facilityId);
					pstmt.setString(10,added_by_id);
					pstmt.setString(11,client_ip_address);
					pstmt.setString(12,facilityId);
					pstmt.addBatch();
			
			}
			   int [] insertCount = pstmt.executeBatch();
			   if(insertCount.length == -3 || insertCount.length < i)
					inser_flag = false;

				if(inser_flag)
				{
					con.commit();
					tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
					errMsg= (String) tabdata.get("message");
					error_value = "1" ;
									
				}
				else
				{
					con.rollback();
					tabdata = MessageManager.getMessage(locale,"FAILED_TRANSACTION","CA");
					errMsg= (String) tabdata.get("message");
					
				}
				if(con!=null)
				ConnectionManager.returnConnection(con,p);
			if(pstmt != null) 
			pstmt.close();
				
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errMsg ,"UTF-8") + "&err_value=" + error_value );
		}
		catch(Exception e)
		{
			//out.println("Exception in try of SpecialityTasksForEventsServlet.java"+e.toString());//common-icn-0181
			
			e.printStackTrace();
		}
		

	}

}

