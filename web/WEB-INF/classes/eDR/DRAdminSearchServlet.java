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
	Function Name	   : DR Admin Search
	Function ID		   :

*/

package eDR;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;

public class DRAdminSearchServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;
		
	Connection con						= null;
	Statement stmt						= null;
	PreparedStatement pstmt				= null;
	CallableStatement csstmt			= null;
	ResultSet messageResultset          = null;
	ResultSet rs						= null;

	String mode							= "";
	String p_enabled					= "";
	String sqlupdate					= "";
	String p_proc_status				= "";
	String order_by_for_process_cycle   = "";
	String facilityId				= "";
	String modifiedById				= "";
	String client_ip_address		= "";
	StringBuffer InsertSQL				= null;

	//int rsupdatectl						= 0;
	
	boolean update_table				= true;
	String sStyle;
    
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
			con		= ConnectionManager.getConnection(req);
			stmt	= con.createStatement();			
			this.out					= res.getWriter();

			mode						= req.getParameter("mode");
			p_proc_status				= req.getParameter("p_proc_status_update");
			order_by_for_process_cycle	= req.getParameter("order_by_for_process_cycle");
						
			HttpSession session;
			session = req.getSession(false);
			 p = (java.util.Properties) session.getValue("jdbc");
			 sStyle	=
        	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			this.facilityId			= (String) session.getValue("facility_id" ) ;
			this.client_ip_address	= p.getProperty("client_ip_address");	
			modifiedById				= p.getProperty( "login_user" ) ;			
			if(p_enabled == null)
			{
				p_enabled = "D";
			}
			if(p_proc_status !=null && p_proc_status.equals("N"))
			{
				update_table = false;
			}
			else
			{
				update_table = true;
			}
			//assigning N to check box variables
			if(mode != null && mode.equals("modify"))
			{
				modifyDRAdminSearchServlet(res);
			}
			
            
			if(rs != null) rs.close();
			if(messageResultset != null) messageResultset.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();

		}catch(Exception e){out.println("Exception in doPost method :"+ e.toString());e.printStackTrace();}
		finally
		{
			ConnectionManager.returnConnection(con,req);
		}
	}//do post
	private synchronized void modifyDRAdminSearchServlet(HttpServletResponse res)
	{
		try
		{
			String locale = p.getProperty("LOCALE");			

			int rsupdatectl						= 0;

			sqlupdate	= "";

			InsertSQL	= new StringBuffer();
						
			con.setAutoCommit(false);
			
			if(update_table == true)
			{				
				String job_queue	= "";
				String proc_one		= "select Check_For_Dr_Jobs_In_Job_Queue() check_queue FROM DUAL";
				
				rs = stmt.executeQuery(proc_one);
				if(rs != null && rs.next())
				{
					job_queue=rs.getString("check_queue");
				} if(rs != null) rs.close();
			    
				if(job_queue.equals("N"))
				{
					
					sqlupdate	= "update dr_process_ctl set proc_status = ? , MODIFIED_BY_ID = ? , MODIFIED_DATE = SYSDATE ,MODIFIED_AT_WS_NO = ? ,MODIFIED_FACILITY_ID = ? ";
					pstmt		= con.prepareStatement(sqlupdate);
					pstmt.setString(1,p_proc_status);
					pstmt.setString(2,modifiedById);
					pstmt.setString(3,client_ip_address);
					pstmt.setString(4,facilityId);

					rsupdatectl	= pstmt.executeUpdate();
					

					if(pstmt != null) pstmt.close();
					
					sqlupdate	= "";

					sqlupdate	= "select count(1) from dr_process_log where proc_id = (select proc_id from dr_process_ctl)";
					rs = stmt.executeQuery(sqlupdate);
					rs.next();
					int count = rs.getInt(1);
					if(rs !=null) rs.close();
                    
					if(count == 0)
					{
						
						InsertSQL.append("insert into dr_process_log (proc_id,search_submit_date,search_submit_by_id,search_schedule_date,search_start_date,search_end_date,search_status,merge_submit_date,merge_submit_by_id,merge_schedule_date,merge_start_date,merge_end_date,merge_status,proc_status,initiating_function_id,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,search_facility_id,search_type,search_ws_no,merge_facility_id,merge_ws_no) (select proc_id,search_submit_date,search_submit_by_id,search_schedule_date,search_start_date,search_end_date,search_status,merge_submit_date,merge_submit_by_id,merge_schedule_date,merge_start_date,merge_end_date,merge_status,proc_status,initiating_function_id,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,search_facility_id,search_type,search_ws_no,merge_facility_id,merge_ws_no from dr_process_ctl)");
						
						pstmt		= con.prepareStatement(InsertSQL.toString());
						pstmt.executeUpdate();

						if(pstmt != null) pstmt.close();

						if((InsertSQL != null) && (InsertSQL.length() > 0))
						{
							InsertSQL.delete(0,InsertSQL.length());
						}

					}
					    			
						sqlupdate = "delete from dr_job_control where status is null" ;
					    stmt.executeUpdate(sqlupdate);

						csstmt = con.prepareCall("{call Truncate_DR_Dup_Tables()}");						
						csstmt.execute(); 	
					   
					    /*
						sqlupdate = "truncate table dr_dup_group_dtls " ; 						
						stmt.executeUpdate(sqlupdate); 
						
						sqlupdate = "truncate table dr_dup_group_hdr ";							
						stmt.executeUpdate(sqlupdate);
						*/
						

					
				}
			}
			else
			{
				sqlupdate = "";
				sqlupdate = "update dr_process_ctl set order_by_for_process_cycle = '"+order_by_for_process_cycle+"' , MODIFIED_BY_ID = '"+modifiedById+"' , MODIFIED_DATE = SYSDATE ,MODIFIED_AT_WS_NO = '"+client_ip_address+"' ,MODIFIED_FACILITY_ID = '"+facilityId+"' " ;
				
				rsupdatectl = stmt.executeUpdate(sqlupdate);		
				
				
			}
			if(rsupdatectl > 0)
			{
				con.commit();
				
		/*		String message   = "";
				String msg		 = "select GET_ERROR_MESSAGE('RECORD_MODIFIED') from dual ";
				messageResultset = stmt.executeQuery(msg);

				if(messageResultset!=null)
				{
					if(messageResultset.next())
					{
						message=messageResultset.getString(1);
					}
				} if(messageResultset != null) messageResultset.close();   */

				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_MODIFIED", "SM");
				String error = ((String) message.get("message"));

				if(update_table == true)
				{
					
					out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link></head><body class='message'>") ;
					out.println("<script>alert('"+error+"');</script>");
					out.println("<script> parent.location.href='../eCommon/jsp/dmenu.jsp';</script>");
					out.println("<script> location.href='../eCommon/jsp/error.jsp?err_num=&err_value=1';</script>");
					out.println("</body></html>");
				}
				else
				{
					
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8" ) + "&err_value=1 " );
				}
			}
			else
			{
				con.rollback();
			/*	String message1 = "";
				String msg1="select GET_ERROR_MESSAGE('SEARCH_MERGE_JOB_EXISTS') from dual ";
				messageResultset=stmt.executeQuery(msg1);
				if(messageResultset!=null)
				{
					if(messageResultset.next())
					{
						message1=messageResultset.getString(1);
					}
				}   */

				java.util.Hashtable message = MessageManager.getMessage(locale, "SEARCH_MERGE_JOB_EXISTS", "DR");
				String error = ((String) message.get("message"));

				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=0 " );
			}

			//if(messageResultset!=null)	messageResultset.close();
			if(stmt!=null)	stmt.close();
			if(pstmt!=null)	pstmt.close();
			if(csstmt!=null) csstmt.close();
			
		}catch(Exception e)
		{
			out.println("<h3> Exception raise by Servlet in modifyDRAdminSearchServlet method ...So Record Not modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
	}//method
}//class
