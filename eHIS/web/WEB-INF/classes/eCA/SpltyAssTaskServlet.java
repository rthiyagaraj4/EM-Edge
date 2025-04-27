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
public class  SpltyAssTaskServlet extends HttpServlet 
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
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	 {  request.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		String mode = request.getParameter("mode") == null ? "" :  request.getParameter("mode");
		if(mode.equals("insert"))
				insert(request,response, out);
		if(mode.equals("modify"))
				modify(request,response,out);
		if(mode.equals("delete"))
				delete(request,response,out);
}

  void insert(HttpServletRequest request,HttpServletResponse response, PrintWriter out)		
	 {
			String client_ip_addr;
			String facilityId;
			String addedId;
			HttpSession session; 
			Properties p;
			Hashtable tabdata;
			PreparedStatement ps;
			Connection con = null;
			ResultSet rs=null;
			String errVal = "0";
			session = request.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			facilityId = (String) session.getValue( "facility_id" ) ;
			client_ip_addr=	p.getProperty("client_ip_address");
			addedId =  (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;   
			String module = "";
			String event_id="";
			String category="";
			String taskType="";
			String taskTypeCode="";
			String  errorMsg = "";
			String counter="0";
			try{
					con = ConnectionManager.getConnection(request);
					module =  request.getParameter("module") == null ? "" : request.getParameter("module");
					event_id =  request.getParameter("event_id") == null ? "" : request.getParameter("event_id");
					category =  request.getParameter("category") == null ? "" : request.getParameter("category");
					taskType =  request.getParameter("taskType") == null ? "" : request.getParameter("taskType");
					taskTypeCode =  request.getParameter("taskTypeCode") == null ? "" : request.getParameter("taskTypeCode");
					ps = con.prepareStatement("select count(*) count from CA_PAT_SPLTY_ASS_TASK where MODULE_ID=? and EVENT_CODE=? and CATEGORY=? and ASS_TYPE=? and ASS_ACTION_CODE=?");
					ps.setString(1,module.trim());
					ps.setString(2,event_id.trim());
					ps.setString(3,category.trim());
					ps.setString(4,taskType.trim());
					ps.setString(5,taskTypeCode.trim());
					rs = ps.executeQuery();
					while(rs.next())
				   {
					counter =rs.getString("count");
				   }
					if(ps != null)ps.close();
				    if(rs != null)rs.close();

				  if(Integer.parseInt(counter) == 0)
				   {
					ps = con.prepareStatement("Insert into CA_PAT_SPLTY_ASS_TASK ( MODULE_ID,EVENT_CODE,CATEGORY,ASS_TYPE,ASS_ACTION_CODE,ADDED_BY_ID,ADDED_DATE ,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,sysdate,?,?,?,sysdate,? ,?)");
					ps.setString(1,module.trim());
					ps.setString(2,event_id.trim());
					ps.setString(3,category.trim());
					ps.setString(4,taskType.trim());
					ps.setString(5,taskTypeCode.trim());
					ps.setString(6,addedId);
					ps.setString(7,client_ip_addr);
					ps.setString(8,facilityId);
					ps.setString(9,addedId);
					ps.setString(10,client_ip_addr);
					ps.setString(11,facilityId);
					int inserted = ps.executeUpdate();
					if(ps != null)ps.close();
					if(rs != null)rs.close();
					if(inserted != 0)
					{
						con.commit();
						tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
						errorMsg= (String) tabdata.get("message");
						errVal = "1";
					}
				   }
				  else
				  {	con.rollback();
						tabdata = MessageManager.getMessage(locale, "DUPLICATE_CODE_EXISTS","Common");
						errorMsg= (String) tabdata.get("message");
						errVal = "0";
					}
				  
						response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
						if(rs != null) rs.close();
						if(ps != null) ps.close();
			}
			catch(Exception ee)
			{
				//out.println("Exception raise by Specialty Event Servlet ...So Record Not inserted  : "+ee.toString());//common-icn-0181
				ee.printStackTrace();
			}
			finally
			{
				if(con != null) ConnectionManager.returnConnection(con);
			}
	}	

	 /**
*	modify	-	will be called when the mode value is modify
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
	void modify(HttpServletRequest request,HttpServletResponse response,PrintWriter out)
	 {
			String client_ip_addr;
			String facilityId;
			String addedId;
			HttpSession session; 
			Properties p;
			Hashtable tabdata;
			PreparedStatement ps;
			Connection con = null;
			ResultSet rs=null;
			String errVal = "0";
			session = request.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			facilityId = (String) session.getValue( "facility_id" ) ;
			client_ip_addr=	p.getProperty("client_ip_address");
			addedId =  (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;   
			String module = "";
			String event_id="";
			String category="";
			String taskType="";
			String taskTypeCode="";
			String  errorMsg = "";
			try{
					con = ConnectionManager.getConnection(request);
					module =  request.getParameter("module") == null ? "" : request.getParameter("module");
					event_id =  request.getParameter("event_id") == null ? "" : request.getParameter("event_id");
					category =  request.getParameter("category") == null ? "" : request.getParameter("category");
					taskType =  request.getParameter("taskType") == null ? "" : request.getParameter("taskType");
					taskTypeCode =  request.getParameter("taskTypeCode") == null ? "" : request.getParameter("taskTypeCode");
									
					ps = con.prepareStatement("Update CA_PAT_SPLTY_ASS_TASK set CATEGORY =?, ASS_TYPE =?, ASS_ACTION_CODE =? where  MODULE_ID =? and  EVENT_CODE=?");
					ps.setString(1,category.trim());
					ps.setString(2,taskType.trim());
					ps.setString(3,taskTypeCode.trim());
					ps.setString(4,module.trim());
					ps.setString(5,event_id.trim());
					int updated = ps.executeUpdate();
					if(updated != 0)
					{
						con.commit();
						tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
						errorMsg= (String) tabdata.get("message");
						errVal = "1";
						out.println("<script>parent.f_query_add_mod.document.specialityeventaddmodifyForm.code.disabled=true;</script>");
						out.println("<script>parent.f_query_add_mod.document.specialityeventaddmodifyForm.autoCloseType.disabled=true;</script>");
				 
					}		
				   else
				   {
					  	 con.rollback(); 
						 tabdata = MessageManager.getMessage(locale, "DUPLICATE_SEQUENCE_NUMBER","CA");
						 errorMsg= (String) tabdata.get("message");
						 errVal = "0";
				         out.println("<script>parent.f_query_add_mod.document.specialityeventaddmodifyForm.code.disabled=true;</script>");
						 out.println("<script>parent.f_query_add_mod.document.specialityeventaddmodifyForm.autoCloseType.disabled=true;</script>");
				  }
				
					//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
					out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg)+"'</script>");
				
					if(rs != null) rs.close();
					if(ps != null) ps.close();
					
			}
			catch(Exception ee)
			{
				//out.println("Exception raise by Specialty Event Servlet ...So Record Not inserted  : "+ee.toString());//common-icn-
				ee.printStackTrace();
			}
			finally
			{
				if(con != null) ConnectionManager.returnConnection(con);
			}
			
		}

	 /**
*	delete	-	will be called when the mode value is delete
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
	 void delete(HttpServletRequest request,HttpServletResponse response, PrintWriter out)	
	 {
			String client_ip_addr;
			String facilityId;
			String addedId;
			HttpSession session; 
			Properties p;
			Hashtable tabdata;
			PreparedStatement ps;
			Connection con = null;
			ResultSet rs=null;
			String errVal = "0";
			String  errorMsg = "";
			String module = "";
			String event_id="";
			String category="";
			String taskType="";
			String taskTypeCode="";
			session = request.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			facilityId = (String) session.getValue( "facility_id" ) ;
			client_ip_addr=	p.getProperty("client_ip_address");
			addedId =  (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;   
				try{
						con = ConnectionManager.getConnection(request);
						module =  request.getParameter("module") == null ? "" : request.getParameter("module");
					    event_id =  request.getParameter("event_id") == null ? "" : request.getParameter("event_id");
					    category =  request.getParameter("category") == null ? "" : request.getParameter("category");
					    taskType =  request.getParameter("taskType") == null ? "" : request.getParameter("taskType");
					    taskTypeCode =  request.getParameter("taskTypeCode") == null ? "" : request.getParameter("taskTypeCode");
					 	ps = con.prepareStatement("delete from CA_PAT_SPLTY_ASS_TASK where MODULE_ID = ? and EVENT_CODE=? and CATEGORY=? and ASS_TYPE=? and ASS_ACTION_CODE=?");
						ps.setString(1,module.trim());
						ps.setString(2,event_id.trim());
						ps.setString(3,category.trim());
						ps.setString(4,taskType.trim());
						ps.setString(5,taskTypeCode.trim());
						int deleted = ps.executeUpdate();
						if(deleted != 0)
					    {
						  con.commit();
						  tabdata = MessageManager.getMessage(locale,"RECORD_DELETED","CA");
						  errorMsg= (String) tabdata.get("message");
						  errVal = "1";
					    }
						else
						{
						 try
					    {
							con.rollback();
					    }
					    catch(Exception e)
					    {
					     e.printStackTrace();
					    }
						tabdata = MessageManager.getMessage(locale,"NO_RECORD_FOUND_FOR_CRITERIA","Common");
						errorMsg= (String) tabdata.get("message");
						errVal = "0";
						}
			         response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
				    if(rs != null) rs.close();
				    if(ps != null) ps.close();

			}
			catch(Exception ee)
			{
				out.println("Exception raise by Specialty Event Servlet ...So Record Not inserted  : "+ee.toString());
				ee.printStackTrace();
			}
			finally
			{
				if(con != null) ConnectionManager.returnConnection(con);
			}
		}
}

