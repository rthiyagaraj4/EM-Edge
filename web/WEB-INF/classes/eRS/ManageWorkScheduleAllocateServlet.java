/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;
import webbeans.eCommon.*;
import eRS.RSManageWorkScheduleAllocate.*;

public class ManageWorkScheduleAllocateServlet extends HttpServlet{
	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
	private ServletConfig config=null;
	String client_ip_address = "";
	String error_value ="0";
	boolean inserted= false;
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id= "";
	String modified_at_ws_no = "";
	String modified_facility_id= "";
	String locale				="";

	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		this.config = config;
	}
	//end of init()
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
		locale=(String)session.getAttribute("LOCALE");
		
		

		try
		{
			String operation = request.getParameter("mode");
			if (operation.equals("insert")) insertOperation(request, response);
		}
		catch(Exception e)
		{
			out.println("Exception in try of doPost()"+e);
		}
	}
	//end of doPost()
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
			out.println("Exception in doGet()"+e);
		}
	}//end of doGet()
//***********Start of Insert************************
	public void insertOperation(HttpServletRequest request,HttpServletResponse response)throws Exception
	{
		try
		{
			HashMap allocate = new HashMap();
			String p_facility_id  = request.getParameter("p_facility_id");
			String p_workplace_code = request.getParameter("p_workplace_code");
			String p_schedule_date  = request.getParameter("p_schedule_date");
			String p_role_type  = request.getParameter("p_role_type");
			String p_staff_id  = request.getParameter("p_staff_id");
			String p_staff_type  = request.getParameter("p_staff_type");
			String p_position_code  = request.getParameter("p_position_code");
			String reason  = request.getParameter("reason");
			String remarks  = request.getParameter("remarks");
			String p_requirement_id  = request.getParameter("p_requirement_id");
			String shift_code  = request.getParameter("shift");
			String mnemonic  = request.getParameter("mnemonic");
			
			//System.err.println("mnemonic--------->"+mnemonic);

			String shift_start_time  = request.getParameter("shift_start_time");
			String shift_end_time  = request.getParameter("shift_end_time");
			String shift_indicator  = request.getParameter("shift_indicator");
			String productive_flag  = request.getParameter("productive_flag");
			String shifts=shift_code+"|"+mnemonic+"|"+shift_indicator+"|"+productive_flag;
			System.out.println("p_facility_id--|"+p_facility_id+"|--p_workplace_code--|"+p_workplace_code+"|--p_schedule_date--|"+p_schedule_date+"|--p_role_type--|"+p_role_type+"|--p_staff_id--|"+p_staff_id+"|--p_staff_type--|"+p_staff_type+"|--p_position_code--|"+p_position_code+"|--reason--|"+reason+"|--remarks--|"+remarks+"|--p_requirement_id--|"+p_requirement_id+"|--shift_code--|"+shift_code+"|--mnemonic--|"+mnemonic+"|--shift_start_time--|"+shift_start_time+"|--shift_end_time--|"+shift_end_time+"|--shift_indicator--|"+shift_indicator+"|--productive_flag--|"+productive_flag+"|--shifts--|"+shifts+"|---");
			allocate.put("REASON_CODE",reason);
			allocate.put("REMARKS",remarks);
			allocate.put("SCHEDULE_DATE",p_schedule_date);
			allocate.put("ROLE_TYPE",p_role_type);
			allocate.put("FACILITY_ID",p_facility_id);
			allocate.put("WORKPLACE_CODE",p_workplace_code);
			allocate.put("WORKPLACE_CODE",p_workplace_code);
			allocate.put("REQUIREMENT_ID",p_requirement_id);
			allocate.put("STAFF_ID",p_staff_id);
			allocate.put("STAFF_TYPE",p_staff_type);
			allocate.put("POSITION_CODE",p_position_code);
			allocate.put("SHIFT_CODE",shift_code);
			allocate.put("SHIFT_MNEMONIC",mnemonic);
			allocate.put("SHIFT_START_TIME",shift_start_time);
			allocate.put("SHIFT_END_TIME",shift_end_time);
			allocate.put("ADDED_BY_ID",added_by_id);
			allocate.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			allocate.put("ADDED_AT_WS_NO",added_at_ws_no);
			allocate.put("ADDED_FACILITY_ID",added_facility_id);
			allocate.put("MODIFIED_BY_ID",modified_by_id);
			allocate.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			allocate.put("MODIFIED_AT_WS_NO",modified_at_ws_no);
			allocate.put("MODIFIED_FACILITY_ID",modified_facility_id);
			allocate.put("locale",locale);
			
			try
			{
				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSManageWorkScheduleAllocate", eRS.RSManageWorkScheduleAllocate.RSManageWorkScheduleAllocateLocalHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[2];
				aobj[0] = prop;
				aobj[1] = allocate;
				Class aclass[] = new Class[2];
				aclass[0] = prop.getClass();
				aclass[1] = allocate.getClass();
				HashMap results=(HashMap)obj1.getClass().getMethod("insert", aclass).invoke(obj1, aobj);
				
				//obj1.getClass().getMethod("remove", null).invoke(obj1, null);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);
				inserted = (((Boolean)results.get("status")).booleanValue());
				System.out.println("inserted ----->"+inserted);
				String msgid= (String) results.get("message");
				System.out.println("msgid ------>"+msgid);
				if ( inserted )
				{
					
					error_value= "1";
					out.println("<script>alert('"+msgid+"');</script>");
					out.println("<script>window.returnValue ='"+shifts+"';</script>");
					out.println("<script>window.close();</script>");
				}
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
				String error = "Error ";
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			}
		}
		catch ( Exception e )
		{
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
	}//end of insert
}
