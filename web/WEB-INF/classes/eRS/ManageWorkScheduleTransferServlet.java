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
import eRS.RSManageWorkScheduleTransfer.*;

public class ManageWorkScheduleTransferServlet extends HttpServlet
{
	Connection con = null;
	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
	private ServletConfig config=null;
	String client_ip_address = "";
	String error_value ="";
	boolean inserted= false;
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id= "";
	String modified_at_ws_no = "";
	String modified_facility_id= "";
	String locale= "";
	public void init(ServletConfig config)throws ServletException
	{
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
		locale=(String)session.getAttribute("LOCALE");
		added_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
		modified_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
		modified_facility_id = (this.added_facility_id==null)?"":this.added_facility_id;
		added_at_ws_no = (client_ip_address==null)?"":client_ip_address;
		modified_at_ws_no = (client_ip_address==null)?"":client_ip_address;
		
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
			HashMap transfer = new HashMap();
			ArrayList transfer_finalval = new ArrayList();
			String p_facility_id  = request.getParameter("p_facility_id");
			String p_schedule_date  = request.getParameter("p_schedule_date");
			String p_role_type  = request.getParameter("p_role_type");
			String p_staff_id  = request.getParameter("p_staff_id");
			String p_staff_type  = request.getParameter("p_staff_type");
			String p_position_code  = request.getParameter("p_position_code");
			String reason  = request.getParameter("reason");
			String remarks  = request.getParameter("remarks");
			String p_requirement_id  = request.getParameter("p_requirement_id");
			String p_workplace_code  = request.getParameter("transfer");
			String workplace_code  = request.getParameter("p_workplace_code");
			String shift_code = "";
			String shift_mnemonic = "";
			String shift_indicator = "";
			String productive_flag = "";
			String chk = "";
			StringBuffer shifts = new StringBuffer();
			int count  = Integer.parseInt(request.getParameter("count"));
			for(int i=1;i<=count;i++)
			{
				chk = request.getParameter("chk"+i)==null?"N":request.getParameter("chk"+i);
				shift_code = request.getParameter("sft_code"+i);
				shift_mnemonic = request.getParameter("shift_mnemonic"+i);
				shift_indicator = request.getParameter("shift_indicator"+i);
				productive_flag = request.getParameter("productive_flag"+i);
				if(chk.equals("Y"))
				{
					transfer.put("REASON_CODE",reason);
					transfer.put("REMARKS",remarks);
					transfer.put("REQUIREMENT_ID",p_requirement_id);
					transfer.put("POSITION_CODE",p_position_code);
					transfer.put("FACILITY_ID",p_facility_id);
					transfer.put("WORKPLACE_CODE",p_workplace_code);
					transfer.put("OLD_WORKPLACE_CODE",workplace_code);
					transfer.put("ROLE_TYPE",p_role_type);
					transfer.put("STAFF_ID",p_staff_id);
					transfer.put("STAFF_TYPE",p_staff_type);
					transfer.put("POSITION_CODE",p_position_code);
					transfer.put("SCHEDULE_DATE",p_schedule_date);
					transfer.put("SHIFT_CODE",shift_code);
					transfer.put("SHIFT_MNEMONIC",shift_mnemonic);
					transfer.put("SHIFT_INDICATOR",shift_indicator);
					transfer.put("PRODUCTIVE_FLAG",productive_flag);
					transfer.put("ADDED_BY_ID",added_by_id);
					transfer.put("ADDED_AT_WS_NO",added_at_ws_no);
					transfer.put("ADDED_FACILITY_ID",added_facility_id);
					transfer.put("MODIFIED_BY_ID",modified_by_id);
					transfer.put("MODIFIED_AT_WS_NO",modified_at_ws_no);
					transfer.put("MODIFIED_FACILITY_ID",modified_facility_id);
					transfer.put("locale",locale);
					transfer_finalval.add(transfer);
					if(i==1)
					{
						shifts.append(shift_code+"|"+shift_mnemonic+"|"+shift_indicator+"|"+productive_flag);
					}
					else
					{
						shifts.append("~"+shift_code+"|"+shift_mnemonic+"|"+shift_indicator+"|"+productive_flag);
					}
				}
			}
			String final_val_shifts = shifts.toString();
			try
			{
				con = ConnectionManager.getConnection(request);
				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSManageWorkScheduleTransfer", eRS.RSManageWorkScheduleTransfer.RSManageWorkScheduleTransferLocalHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[2];
				aobj[0] = prop;
				aobj[1] = transfer_finalval;
				Class aclass[] = new Class[2];
				aclass[0] = prop.getClass();
				aclass[1] = transfer_finalval.getClass();
				HashMap results=(HashMap)obj1.getClass().getMethod("create", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);

				inserted = (((Boolean)results.get("status")).booleanValue());
				String error = (String) results.get("error");
				Hashtable final_result = MessageManager.getMessage(locale,"RECORD_INSERTED","RS");
				String msgid= (String) final_result.get("message");
				//System.err.println("msgid  in manageworkscheduletransferservlet 163  {"+msgid+"}");
				if (inserted)
				{
					error_value= "1";
					out.println("<script>alert('"+msgid+"');</script>");
					out.println("<script>window.returnValue ='"+final_val_shifts+"';</script>");
					out.println("<script>window.close();</script>");
				}
				else
				{
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
				}
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
				String error = "Error ";
				String error_value = "0" ;
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			}
			finally
			{
				ConnectionManager.returnConnection(con,request);
			}		
		}
		catch ( Exception e )
		{
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
	}//end of insert
}
