/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;
import java.net.*;

//import eRS.RSManageWorkScheduleCancelLeave.*;

public class ManageWorkScheduleCancelLeaveServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel{
	PrintWriter out;
	java.util.Properties properties;

	String facility_id;
	String user_id="";
	String workplace_code="";

	String client_ip_address;
	String locale					="";

	int size=1;

	HttpSession session;

	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException	{

		session = request.getSession(false);
		this.properties = (java.util.Properties) session.getAttribute("jdbc") ;
		this.facility_id = (String) session.getAttribute("facility_id") ;
		client_ip_address = properties.getProperty("client_ip_address");
		locale=(String)session.getAttribute("LOCALE");
		user_id			= properties.getProperty( "login_user" ) ;
	
		try{
			request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8"); 
			this.out = response.getWriter();
			
			delete(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
			out.println("Exception in doPost() of ManageWorkScheduleCancelLeaveServlet.java"+e);
		}
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
    try
	{
		this.out = response.getWriter();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		doPost(request,response);
	}
	catch(Exception e){
		out.println("Exception in doGet() of ManageWorkScheduleCancelLeaveServlet.java"+e);
	}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response){
			
			Connection conn = ConnectionManager.getConnection(request);
			PreparedStatement pstmt_del_leave				= null;
			//PreparedStatement pstmt_del_leave_act_log		= null;
			PreparedStatement pstmt_del_leave_act_log_dtl		= null;

			
			PreparedStatement pstmt_act_log_prv	= null;
			PreparedStatement pstmt_del_leave_act_log_seqno	= null;
			
			
			ResultSet		  rset_del_leave_act_log_seqno			= null;
			ResultSet		  rset_act_log_prv			= null;
		try{
			

			String role_type=request.getParameter("role_type")==null?"":request.getParameter("role_type");
			String staff_id =request.getParameter("staff_id")==null?"":request.getParameter("staff_id");
			String date =request.getParameter("date")==null?"":request.getParameter("date");
			//String leave_from_date =request.getParameter("cancel_leave_period_from_txt")==null?"":request.getParameter("cancel_leave_period_from_txt");
			//String leave_to_date =request.getParameter("cancel_leave_period_to_txt")==null?"":request.getParameter("cancel_leave_period_to_txt");
			String reason =request.getParameter("cancel_leave_reason")==null?"":request.getParameter("cancel_leave_reason");
			//String shift_mnemonic =request.getParameter("p_shift_mnemonic")==null?"":request.getParameter("p_shift_mnemonic");
			
			//String shift_code =request.getParameter("p_shift_code")==null?"":request.getParameter("p_shift_code");
			//String position_code =request.getParameter("position_code")==null?"":request.getParameter("position_code");

			
			//String shift_start_time="";
			//String shift_end_time="";
			//String actual_end_time="";
			//String staff_type="";
			//String locn_type="";
			//String requirement_id="";
			//String schedule_type="";
			//String workplace_code="";
			//int		seq_no=0;
			

			
		//	pstmt_del_leave = conn.prepareStatement("DELETE FROM RS_STAFF_UNAVAILABILITY_LOG WHERE role_type = ? AND staff_id = ? AND TO_CHAR(leave_date,'dd/mm/yyyy') = TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy')");
			pstmt_del_leave = conn.prepareStatement("UPDATE RS_STAFF_UNAVAILABILITY_LOG SET CANCEL_REASON_CODE = ? WHERE role_type = ? AND staff_id = ? AND TO_CHAR(leave_date,'dd/mm/yyyy') = TO_CHAR(TO_DATE(?,'dd/mm/yyyy'),'dd/mm/yyyy')");
			pstmt_del_leave.setString(1,reason);
			pstmt_del_leave.setString(2,role_type);
			pstmt_del_leave.setString(3,staff_id);
			pstmt_del_leave.setString(4,date);
			
			int del_leave_count		= pstmt_del_leave.executeUpdate();
			
			if(del_leave_count>0)
			{

/*

			pstmt_del_leave_act_log_seqno = conn.prepareStatement("select to_char(rs_activity_log_seq.nextval) from dual");
			rset_del_leave_act_log_seqno=pstmt_del_leave_act_log_seqno.executeQuery();
		
				if(rset_del_leave_act_log_seqno!=null){
				 while(rset_del_leave_act_log_seqno.next()){
					 seq_no=Integer.parseInt(rset_del_leave_act_log_seqno.getString(1));
				 }
				}
			pstmt_del_leave_act_log = conn.prepareStatement("insert into rs_activity_log(activity_log_id,activity_type,reason_code,remarks,date_from,date_to,locn_type,facility_id,workplace_code,requirement_id,role_type,staff_type,staff_id,position_code,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values("+seq_no+",'CL',?,null,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),null,?,null,null,?,null,?,null,?,sysdate,?,?,?,sysdate,?,?)");
			
			pstmt_del_leave_act_log.setString(1,reason);
			pstmt_del_leave_act_log.setString(2,date);
			pstmt_del_leave_act_log.setString(3,date);
			pstmt_del_leave_act_log.setString(4,facility_id);
			pstmt_del_leave_act_log.setString(5,role_type);
			pstmt_del_leave_act_log.setString(6,staff_id);
			pstmt_del_leave_act_log.setString(7,user_id);
			pstmt_del_leave_act_log.setString(8,client_ip_address);
			pstmt_del_leave_act_log.setString(9,facility_id);
			pstmt_del_leave_act_log.setString(10,user_id);
			pstmt_del_leave_act_log.setString(11,client_ip_address);
			pstmt_del_leave_act_log.setString(12,facility_id);

			
			int leave_act_log		= pstmt_del_leave_act_log.executeUpdate();
			
			if(leave_act_log>0)
			{	
			int cnt=0;
			
			pstmt_act_log_prv = conn.prepareStatement("select to_char(shift_start_time,'dd/mm/yyyy') shift_start_time,to_char(shift_end_time,'dd/mm/yyyy') shift_end_time,to_char(actual_end_time,'dd/mm/yyyy') actual_end_time,requirement_id,staff_type,locn_type,schedule_type,workplace_code from rs_activity_log_dtl where role_type = ? and staff_id = ? and activity_type='LV' and trim(SCHEDULE_DATE) = to_date(?,'dd/mm/yyyy') AND ROWNUM<2");
			
			
			pstmt_act_log_prv.setString(1,role_type);
			pstmt_act_log_prv.setString(2,staff_id);
			pstmt_act_log_prv.setString(3,date);
		
	
		

			rset_act_log_prv = pstmt_act_log_prv.executeQuery();

			if(rset_act_log_prv!=null){
				 while(rset_act_log_prv.next()){
					shift_start_time=rset_act_log_prv.getString("shift_start_time");
					shift_end_time=rset_act_log_prv.getString("shift_end_time");
					actual_end_time=rset_act_log_prv.getString("actual_end_time");
					requirement_id=rset_act_log_prv.getString("requirement_id");
					staff_type=rset_act_log_prv.getString("staff_type");
					locn_type=rset_act_log_prv.getString("locn_type");
				    schedule_type=rset_act_log_prv.getString("schedule_type");
					workplace_code=rset_act_log_prv.getString("workplace_code");
					
				}
			}
			
		
			int i=1;
			pstmt_del_leave_act_log_dtl = conn.prepareStatement("insert into rs_activity_log_dtl(activity_log_id,serial_num,activity_type,facility_id,workplace_code,role_type,staff_id,schedule_date,shift_code,shift_mnemonic,shift_start_time,shift_end_time,	over_time_durn,actual_end_time,schedule_type,requirement_id,	staff_type,position_code,locn_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values	("+seq_no+","+i+",'CL',?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,to_date(sysdate,'dd/mm/yyyy hh:mm'),?,?,?,to_date(sysdate,'dd/mm/yyyy hh:mm'),?,?)");
			
				
				pstmt_del_leave_act_log_dtl.setString(1,facility_id);
				pstmt_del_leave_act_log_dtl.setString(2,workplace_code);
				pstmt_del_leave_act_log_dtl.setString(3,role_type);
				pstmt_del_leave_act_log_dtl.setString(4,staff_id);
				pstmt_del_leave_act_log_dtl.setString(5,date);
				pstmt_del_leave_act_log_dtl.setString(6,"L");
				pstmt_del_leave_act_log_dtl.setString(7,"B");
				pstmt_del_leave_act_log_dtl.setString(8,shift_start_time);
				pstmt_del_leave_act_log_dtl.setString(9,shift_end_time);
				pstmt_del_leave_act_log_dtl.setString(10,"");
				pstmt_del_leave_act_log_dtl.setString(11,actual_end_time);
				pstmt_del_leave_act_log_dtl.setString(12,schedule_type);
				pstmt_del_leave_act_log_dtl.setString(13,requirement_id);
				pstmt_del_leave_act_log_dtl.setString(14,staff_type);
				pstmt_del_leave_act_log_dtl.setString(15,position_code);
				pstmt_del_leave_act_log_dtl.setString(16,locn_type);
				pstmt_del_leave_act_log_dtl.setString(17,user_id);
			
				pstmt_del_leave_act_log_dtl.setString(18,client_ip_address);
				pstmt_del_leave_act_log_dtl.setString(19,facility_id);
				pstmt_del_leave_act_log_dtl.setString(20,user_id);

				pstmt_del_leave_act_log_dtl.setString(21,client_ip_address);
				pstmt_del_leave_act_log_dtl.setString(22,facility_id);

			
			
			
			int rowsInserted_dtl	= pstmt_del_leave_act_log_dtl.executeUpdate();

System.out.println("rowsInserted_dtl"+rowsInserted_dtl);
			   			

			
			}	*/
			conn.commit();
			
	
			
				
			}
			else
			{
				out.println("Exception in delete() of ManageWorkScheduleCancelLeaveServlet.java");	
				conn.rollback();
				
			}
				  
			    		
		
			if(pstmt_del_leave != null)
				pstmt_del_leave.close();
					
			if(pstmt_del_leave_act_log_seqno != null)
				pstmt_del_leave_act_log_seqno.close();
		
			if(rset_del_leave_act_log_seqno != null)
				rset_del_leave_act_log_seqno.close();			
			
			if(pstmt_act_log_prv != null)
				pstmt_act_log_prv.close();
			
			if(rset_act_log_prv != null)
				rset_act_log_prv.close();

			if(pstmt_del_leave_act_log_dtl != null)
				pstmt_del_leave_act_log_dtl.close();


			
		conn.close();

		}catch(Exception e){
			System.err.println("Exception in delete() of ManageWorkScheduleCancelLeaveServlet.java"+e);
			e.printStackTrace();
		}finally
		{
		try
		{
			conn.close();
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp");
	
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		}
	}//End of delete
}
