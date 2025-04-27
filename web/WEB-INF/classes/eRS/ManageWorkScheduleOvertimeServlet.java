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
import eCommon.Common.*;
import webbeans.eCommon.*;

import eRS.RSManageWorkScheduleOvertime.*;


public class ManageWorkScheduleOvertimeServlet extends HttpServlet
{
	private ServletConfig config = null;
	PrintWriter out = null;
	HttpSession session = null;
	Properties prop = new Properties();
	String client_ip_address = "";
	boolean inserted= false;

	String p_facility_id  = "";
	String p_workplace_code = "";
	String p_schedule_date  = "";
	String p_role_type  = "";
	String p_staff_type ="";
	String p_staff_id  = "";
	String p_position_code  = "";
	String shift = "";
	String shift_mnemonic = "";
	String reason  = "";
	String remarks  = "";
	String over_time_durn1  = "";
	String over_time_durn2  = "";
	String over_time_durn  = "";
	String shift_start_time ="";
	String shift_end_time ="";
	String p_requirement_id  = "";
	String shift_end_date_time = "";
	String shift_start_date_time = "";
	String actual_end_date_time = "";

	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id= "";
	String modified_at_ws_no = "";
	String modified_facility_id= "";
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		this.out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); 

		session = request.getSession(false);
		this.prop = (java.util.Properties)session.getAttribute("jdbc");
		this.added_facility_id = (String)session.getAttribute("facility_id");
		client_ip_address = this.prop.getProperty("client_ip_address");
		added_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
		modified_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
		modified_facility_id = (this.added_facility_id==null)?"":this.added_facility_id;
		added_at_ws_no = (client_ip_address==null)?"":client_ip_address;
		modified_at_ws_no = (client_ip_address==null)?"":client_ip_address;
		try
		{
			String operation = request.getParameter("mode");
			if (operation.equals("insert")) insertOperation(request);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public synchronized void doGet(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = response.getWriter();
			response.setContentType("text/html");
			doPost(request,response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void insertOperation(HttpServletRequest request)
     throws Exception
	{
				
		try{

			HashMap tabData = new HashMap();
			p_facility_id  = request.getParameter("p_facility_id");
			p_workplace_code = request.getParameter("p_workplace_code");
			p_schedule_date  = request.getParameter("p_schedule_date");
			p_role_type  = request.getParameter("p_role_type");
			p_staff_type  = request.getParameter("p_staff_type");
			p_staff_id  = request.getParameter("p_staff_id");
			p_position_code  = request.getParameter("p_position_code");
			shift  = request.getParameter("shift");
			shift_mnemonic  = request.getParameter("shift_mnemonic");
			reason  = request.getParameter("reason");
			remarks  = request.getParameter("remarks");
			over_time_durn1 = request.getParameter("over_time_durn1");
			over_time_durn2 = request.getParameter("over_time_durn2");
			over_time_durn = over_time_durn1+ ":" + over_time_durn2 ;
			p_requirement_id  = request.getParameter("p_requirement_id");
			shift_end_time = request.getParameter("end_time1");
			shift_start_time = request.getParameter("start_time1");
			shift_end_date_time = request.getParameter("shift_end_date_time");
			shift_start_date_time = request.getParameter("shift_start_date_time");
			actual_end_date_time = request.getParameter("actual_end_date_time");

			tabData.put("REASON_CODE",reason);
			tabData.put("REMARKS",remarks);
			tabData.put("DATE_FROM",p_schedule_date);
			tabData.put("DATE_TO",p_schedule_date);
			tabData.put("FACILITY_ID",p_facility_id);
			tabData.put("WORKPLACE_CODE",p_workplace_code);
			tabData.put("REQUIREMENT_ID",p_requirement_id);
			tabData.put("STAFF_ID",p_staff_id);
			tabData.put("STAFF_TYPE",p_staff_type);
			tabData.put("ROLE_TYPE",p_role_type);
			tabData.put("POSITION_CODE",p_position_code);
			tabData.put("SHIFT",shift);
			tabData.put("SHIFT_MNEMONIC",shift_mnemonic);
			tabData.put("OVER_TIME_DURN",over_time_durn);
			tabData.put("OVER_TIME_DURN1",over_time_durn1);
			tabData.put("OVER_TIME_DURN2",over_time_durn2);
			tabData.put("SHIFT_START_TIME",shift_start_time);
			tabData.put("SHIFT_END_TIME",shift_end_time);
			tabData.put("SHIFT_END_DATE_TIME",shift_end_date_time);
			tabData.put("SHIFT_START_DATE_TIME",shift_start_date_time);
			tabData.put("ACTUAL_END_DATE_TIME",actual_end_date_time);
			tabData.put("ADDED_BY_ID",added_by_id);
			tabData.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabData.put("ADDED_AT_WS_NO",added_at_ws_no);
			tabData.put("ADDED_FACILITY_ID",added_facility_id);
			tabData.put("MODIFIED_BY_ID",modified_by_id);
			tabData.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabData.put("MODIFIED_AT_WS_NO",modified_at_ws_no);
			tabData.put("MODIFIED_FACILITY_ID",modified_facility_id);
			try{

				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSManageWorkScheduleOvertime", eRS.RSManageWorkScheduleOvertime.RSManageWorkScheduleOvertimeLocalHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[2];
				aobj[0] = prop;
				aobj[1] = tabData;
				Class aclass[] = new Class[2];
				aclass[0] = prop.getClass();
				aclass[1] = tabData.getClass();
				HashMap results=(HashMap)obj1.getClass().getMethod("insert", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);

				inserted = (((Boolean)results.get("status")).booleanValue());

				if ( inserted ){
					out.println("<script>alert('APP-SM0001 Operation Completed Successfully ....');</script>");
					out.println("<script>window.close();</script>");
				}
				else{
					out.println("<script>alert('APP-OP0062 Error While Updating);</script>");
				}
			}
			catch(Exception exp){
						  exp.printStackTrace();
				}
		}
		catch ( Exception e ){
				e.printStackTrace();
				out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
	}//end of insert
}
