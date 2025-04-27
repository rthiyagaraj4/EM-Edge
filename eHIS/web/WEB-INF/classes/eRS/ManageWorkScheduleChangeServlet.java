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
import eRS.RSManageWorkScheduleChange.*;

public class ManageWorkScheduleChangeServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel{
	
	PrintWriter out;
	java.util.Properties properties;
 
	String facility_id = "";
	String added_by_id = "";
	String client_ip_address ;
 
	HttpSession session;
	String locale				="";


	public void init(ServletConfig config) throws ServletException{
		super.init(config);

	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException	{

		session = req.getSession(false);
		this.properties = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.facility_id = (String) session.getAttribute( "facility_id" ) ;
		client_ip_address = properties.getProperty("client_ip_address");
		locale=(String)session.getAttribute("LOCALE");
		

		try{
			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8"); 

			this.out = res.getWriter();
			insert(req);
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletResponse res) throws javax.servlet.ServletException,IOException{
 		try{
			this.out = res.getWriter();
			res.setContentType("text/html");
		
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
	}

	private void insert(HttpServletRequest req){

	   try{
			facility_id=(String)session.getAttribute("facility_id");
			added_by_id 	= properties.getProperty( "login_user" ) ;
			added_by_id 	= properties.getProperty( "login_user" ) ;
			String old_shift_vals=req.getParameter("old_shift");
			StringTokenizer stk = new StringTokenizer(old_shift_vals,"|");
			String old_shift =stk.nextToken();

			String new_shift  = req.getParameter("new_shift");
			String new_mnemonic  = req.getParameter("new_mnemonic");
			String new_shift_indicator = req.getParameter("new_shift_indicator");
			String new_productive_flag = req.getParameter("new_productive_flag");
			String new_shift_start_time  = req.getParameter("new_shift_start_time");
			String new_shift_end_time  = req.getParameter("new_shift_end_time");
			String p_facility_id  = req.getParameter("p_facility_id");
			String p_workplace_code = req.getParameter("p_workplace_code");
			String p_schedule_date  = req.getParameter("p_schedule_date");
			String p_role_type  = req.getParameter("p_role_type");
			String p_staff_id  = req.getParameter("p_staff_id");
			String p_staff_type  = req.getParameter("p_staff_type");
			String p_position_code  = req.getParameter("p_position_code");
			String p_requirement_id  = req.getParameter("p_requirement_id");
			String reason  = req.getParameter("reason");
			String remarks  = req.getParameter("remarks");
			
			StringBuffer ret_shift_vals=new StringBuffer();
			ret_shift_vals.append(old_shift_vals);
			ret_shift_vals.append("~");
			ret_shift_vals.append(new_shift);
			ret_shift_vals.append("|");
			ret_shift_vals.append(new_mnemonic);
			ret_shift_vals.append("|");
			ret_shift_vals.append(new_shift_indicator);
			ret_shift_vals.append("|");
			ret_shift_vals.append(new_productive_flag);
			
			
			HashMap tabData=new HashMap();
   			tabData.put("old_shift",old_shift);
			tabData.put("new_shift",new_shift);
			tabData.put("new_mnemonic",new_mnemonic);
			tabData.put("new_shift_start_time",new_shift_start_time);
			tabData.put("new_shift_end_time",new_shift_end_time);
			tabData.put("p_facility_id",p_facility_id);
			tabData.put("p_workplace_code",p_workplace_code);
			tabData.put("p_schedule_date",p_schedule_date);
			tabData.put("p_role_type",p_role_type);
			tabData.put("p_staff_id",p_staff_id);
			tabData.put("p_staff_type",p_staff_type);
			tabData.put("p_position_code",p_position_code);
			tabData.put("p_requirement_id",p_requirement_id);
			tabData.put("reason",reason);
			tabData.put("remarks",remarks);
			tabData.put("added_by_id", added_by_id);
			tabData.put("added_at_ws_no",  client_ip_address);
			tabData.put("added_facility_id",  facility_id);
			tabData.put("locale",locale);
			tabData.put("properties",properties);
			/*System.out.println("tabData in servlet 119---|"+tabData+"|---");
			System.out.println("locale  in servlet 120:--|"+locale+"|---");*/

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSManageWorkScheduleChange", eRS.RSManageWorkScheduleChange.RSManageWorkScheduleChangeLocalHome.class, local_ejbs);
			Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[1];
			aobj[0] = tabData;
			Class aclass[] = new Class[1];
			aclass[0] = tabData.getClass();
			HashMap map=(HashMap)obj1.getClass().getMethod("insert", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);
			//System.out.println("map in servlet 134-----|"+map+"|----");

			String result = ((Boolean)map.get("result")).toString();
			String err_num="";
			err_num=(String)map.get("message");
			/*System.out.println("result and err_num in manageworkschedulechangeservlet 139---->");  
			System.out.println("result----|"+result+"|----err_num---|"+err_num+"|----");*/
			if(result.equals("true")){
			
				out.println("<script>alert('"+err_num+"');</script>");
				out.println("<script>window.returnValue ='"+ret_shift_vals+"';</script>");
				out.println("<script>window.close();</script>");
			}
			else{
				out.println("<script>alert('"+err_num+"');</script>");
			}

		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
