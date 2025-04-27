/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS;

import java.io.* ;
import java.rmi.*;
import java.util.* ;
import java.sql.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import javax.servlet.*;
import javax.servlet.http.*;
import  eCommon.SingleTableHandler.*;
import  eRS.RSRecordStaffUnavailability.*;
public class RecordStaffUnavailabilityServlet extends HttpServlet{

	private ServletConfig config = null;
	PrintWriter out;
	HttpSession session = null;

	Properties p = new Properties();
	String client_ip_address = "";
	String error_value ="";
	String role_type = "";
	String staff_id = "";
	String leave_from_date = "";
	String leave_to_date = "";
	String user_id= "";
	String ws_no = "";
	String facility_id= "";
	String modified_by_id ="";
	String modified_at_ws_no = "";
	String modified_facility_id	= "";
	String reason="";
	String call_mode="";
	String err_num="";
	String locale ="";
	String checkAll ="";
	String cancelLeaveCheck = "";
	String cancelLeaveDate = "";
	String cancelLeaveReason = "";
	String record = "";
	boolean inserted= false;
	int updateCount = 0;
	String totalRows = "";
	int totalCount = 0;
	int checkedCount = 0;
	//String error_value ="";
	String 	error ="";
	String count = "";
	
	
	
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		this.config = config;
	}

	/**************************************************/

	public synchronized void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{

		this.out = response.getWriter();
		session = request.getSession(false);
		facility_id = (String)session.getAttribute("facility_id");
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		locale=(String)session.getAttribute("LOCALE");
		try{
			request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8"); 

			totalRows = request.getParameter("totalRows")==null?"":request.getParameter("totalRows");
			checkAll = request.getParameter("checkAll")==null?"":request.getParameter("checkAll");;
			

			if (totalRows != "")
			{
				totalCount = Integer.parseInt(totalRows);
			}
			else 
				totalCount = 0;
			if (checkAll.equals("Y"))
			{
					checkedCount++;
			}
			else
			{
			for (int i=0;i<totalCount ;i++ )
			{
				cancelLeaveCheck = request.getParameter("checkCancelLeave_"+i)==null?"N":"Y";
				if (cancelLeaveCheck.equals("Y"))
				{
					checkedCount++;
					break;
				}
			}
			}


			if (totalCount > 0 && checkedCount > 0)
			{
				updateCount = updateCancelledLeaveRecords(request,response);

			
			if (updateCount > 0)
			{
				error_value ="1";
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_DELETED","RS" ) ;
				error = (String) message.get("message");

			
				String lv_from_date	=request.getParameter("from_date")==null?"":request.getParameter("from_date");
			    String lv_to_date	=request.getParameter("to_date")==null?"":request.getParameter("to_date");
			    String lv_reason			=request.getParameter("reason")==null?"":request.getParameter("reason");
			   
				if ((!(lv_from_date.equals(""))) && (!(lv_to_date.equals(""))) && (!(lv_reason.equals(""))))
				{
					modify(request,response);
				}
				
				//response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg ) + "&err_value=" + error_value );
				else{
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(error, "UTF-8") + "&err_value=" + error_value);
				}

			}
			else{
				error_value ="0";
				java.util.Hashtable message = MessageManager.getMessage( locale, "TRANSACTION_FAILED","RS" ) ;
				error = (String) message.get("message");
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(error, "UTF-8") + "&err_value=" + error_value);
			
			}
			}
			else{
					modify(request,response);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//******************************************************************************

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	
	{
		try{
		this.out = response.getWriter();
		response.setContentType("text/html");
		doPost(request,response);
	}
	catch(Exception e){
		out.println("Exception in doGet()"+e);
	}
	}

	/**************************************************/
	public void modify(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		
		try{
			HashMap map=new HashMap();
			HashMap tabData		= new HashMap();
			HashMap sqlMap			= new HashMap();
			user_id			= p.getProperty( "login_user" ) ;
			ws_no	= client_ip_address;
			facility_id	= facility_id ;
			locale = locale ;

			role_type			=request.getParameter("role_type");
			staff_id				=request.getParameter("staff_id");
			leave_from_date			=request.getParameter("from_date");
			leave_to_date				=request.getParameter("to_date");
			reason					=request.getParameter("reason");
			call_mode=request.getParameter("call_mode");

		   	tabData.put( "role_type", role_type);
			tabData.put( "staff_id", staff_id);
			tabData.put( "leave_from_date", leave_from_date);
			tabData.put( "leave_to_date", leave_to_date);
			tabData.put( "reason_code", reason);
			tabData.put( "facility_id", facility_id);
			tabData.put( "user_id", user_id);
			tabData.put( "ws_no", ws_no);
			tabData.put("locale",locale);
			tabData.put( "properties",	p ) ;
			sqlMap.put( "InsertSQL", "sql_update");
			PreparedStatement pstmt_count				= null;
			Connection conn									= null;
			ResultSet rs_count 		= null;
			//Checking RS_STAFF_PROFILE Set up -- created --Dt:18/9/09
			try
			{
				conn = ConnectionManager.getConnection(request);
				String staffId = request.getParameter("staff_id");
				String roleType = request.getParameter("role_type");
				
				pstmt_count = conn.prepareStatement("SELECT COUNT(*) count FROM RS_STAFF_PROFILE WHERE ROLE_TYPE = ? AND STAFF_ID = ?");
				pstmt_count.setString(1,roleType);
				pstmt_count.setString(2,staffId);
				rs_count=pstmt_count.executeQuery();
				while (rs_count.next()) {
				count=rs_count.getString("count");
			    }
			 }catch (Exception e)
				{
					e.printStackTrace();
				}			
			
			if(count.equals("1")){
				//System.out.println("count--->" +count);
					
			
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSRecordStaffUnavailability", eRS.RSRecordStaffUnavailability.RSRecordStaffUnavailabilityLocalHome.class, local_ejbs);
			Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[1];
			aobj[0] = tabData;
			Class aclass[] = new Class[1];
			aclass[0] = tabData.getClass();
			map=(HashMap)obj1.getClass().getMethod("insert", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);
			
			//result = ((String)map.get("result")).toString();
			//String result = ((String)map.get("result")).toString();
			
			//inserted = (((Boolean)map.get("result")).booleanValue());
			
			if (map.get("result").toString().equals("true"))
				{
					error_value= "1";
					//System.out.println("error_value---->" +error_value);
				}
				else
				{
					error_value="0";
					//System.out.println("error_value---->" +error_value);
				}
			  err_num =(String)map.get("message"); 
			  //System.out.println("err_num------->" +err_num);
			}
			else if(count.equals("0")){
				//System.out.println("count- else-->" +count);//18:9:09
                      
				error_value="0";
				//err_num="Staff Profile is not defined for the selected staff";
				java.util.Hashtable message = MessageManager.getMessage( locale, "STAFF_PROFILE_MISSING","RS" ) ; //18:9:09--Message added
				err_num = (String) message.get("message");
			}


			if(call_mode.equals("M"))	{
				System.out.println("M");
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num="+err_num+"&err_value="+error_value );
			}
			else if(call_mode.equals("W")){
				String retVals=request.getParameter("total_string");
				//System.err.println("retVals in servlet 137--->"+retVals);
				out.println("<script>alert('"+err_num+"');</script>");
				out.println("<script>window.returnValue='"+retVals+"';</script>");
				out.println("<script>window.close();</script>");
			}

	}catch(Exception e){
		e.printStackTrace();
		}
	}

	
	private int updateCancelledLeaveRecords(HttpServletRequest request, HttpServletResponse response){
		PreparedStatement pstmt_del_leave				= null;
		Connection conn									= null;
		try{

			 conn = ConnectionManager.getConnection(request);
			int cancelRowCount = 0;
			String totalRows = request.getParameter("totalRows");
			String staffId = request.getParameter("staff_id");
			String roleType = request.getParameter("role_type");

			
			 modified_by_id 			= p.getProperty( "login_user" ) ;
			 modified_at_ws_no		= client_ip_address;
			 modified_facility_id	= facility_id ;
			if (!(totalRows == null))
			{
				cancelRowCount = Integer.parseInt(totalRows);
			}
			else
				cancelRowCount = 0;
			

			for (int i=0;i<cancelRowCount ;i++ )
			{
				cancelLeaveCheck = request.getParameter("checkCancelLeave_"+i);

			cancelLeaveCheck = request.getParameter("checkCancelLeave_"+i)==null?"N":"Y";

			if (cancelLeaveCheck.equals("Y"))
			{
				cancelLeaveDate = request.getParameter("date_"+i);
				cancelLeaveReason = request.getParameter("leaveReasonList_"+i);
			
				//pstmt_del_leave = conn.prepareStatement("DELETE FROM RS_STAFF_UNAVAILABILITY_LOG WHERE STAFF_ID = ? AND LEAVE_DATE = TO_DATE(?,'dd/mm/yyyy') AND REASON_CODE = ?");
				pstmt_del_leave = conn.prepareStatement("UPDATE RS_STAFF_UNAVAILABILITY_LOG SET CANCEL_REASON_CODE = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  WHERE STAFF_ID = ? AND ROLE_TYPE = ? AND  LEAVE_DATE = TO_DATE(?,'DD/MM/YYYY') ");

				pstmt_del_leave.setString(1,cancelLeaveReason);
				pstmt_del_leave.setString(2,modified_by_id);
				pstmt_del_leave.setString(3,modified_at_ws_no);
				pstmt_del_leave.setString(4,modified_facility_id);
				pstmt_del_leave.setString(5,staffId);
				pstmt_del_leave.setString(6,roleType);
				pstmt_del_leave.setString(7,cancelLeaveDate);
				
				
				//pstmt_del_leave.setString(3,cancelLeaveReason);
			
				updateCount = pstmt_del_leave.executeUpdate();

				
			}

		}
		}catch(Exception e){
			System.out.println("dey");
			updateCount = 0;
			e.printStackTrace();
		}finally
		{
			
			try
			{
				if(pstmt_del_leave != null)
				pstmt_del_leave.close();
				conn.commit();
				conn.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
		return updateCount;
	}//End of update



}

//DELETE FROM RS_STAFF_UNAVAILABILITY_LOG
