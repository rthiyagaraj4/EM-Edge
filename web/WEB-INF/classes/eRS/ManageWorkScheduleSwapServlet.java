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
import eRS.RSManageWorkScheduleSwap.*;

public class ManageWorkScheduleSwapServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel{
//public class ManageWorkScheduleSwapServlet extends HttpServlet{

	PrintWriter out;
	java.util.Properties properties;
 
	String facility_id = "";
	String added_by_id = "";
	String client_ip_address ;
	String locale				="";
 
	HttpSession session;

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
			String p_facility_id  = req.getParameter("p_facility_id");
			String p_workplace_code = req.getParameter("p_workplace_code");
			String p_schedule_date  = req.getParameter("p_schedule_date");
			String p_role_type  = req.getParameter("p_role_type");
			String p_staff_id  = req.getParameter("p_staff_id");
			String p_staff_type  = req.getParameter("p_staff_type");
			String p_position_code  = req.getParameter("p_position_code");
			String p_requirement_id  = req.getParameter("p_requirement_id");
			String staff1_shift_code  = req.getParameter("staff1_shift_code");
			String new_workplace_code  = req.getParameter("new_workplace_code");
			String new_staff_id  = req.getParameter("new_staff_id");
			String staff2_shift_code  = req.getParameter("staff2_shift_code");

			String old_shift_indicator = req.getParameter("old_shift_indicator");
			String old_productive_flag = req.getParameter("old_productive_flag");
			String old_mnemonic_key = req.getParameter("old_mnemonic_key");
			String new_shift_indicator = req.getParameter("new_shift_indicator");
			String new_productive_flag = req.getParameter("new_productive_flag");
			String new_mnemonic_key = req.getParameter("new_mnemonic_key");
			String reason  = req.getParameter("reason");
			String remarks  = req.getParameter("remarks");
			String flag="A";
			StringBuffer ret_shift_vals=new StringBuffer();
			if(p_workplace_code.equals(new_workplace_code))
		   {
			flag="W";
			ret_shift_vals.append(flag);
			ret_shift_vals.append("~");
			ret_shift_vals.append(p_role_type);
			ret_shift_vals.append("~");
			ret_shift_vals.append(p_staff_id);
			ret_shift_vals.append("~");
			ret_shift_vals.append(staff1_shift_code);
			ret_shift_vals.append("|");
			ret_shift_vals.append(old_mnemonic_key);
			ret_shift_vals.append("|");
			ret_shift_vals.append(old_shift_indicator);
			ret_shift_vals.append("|");
			ret_shift_vals.append(old_productive_flag);
			ret_shift_vals.append("~");
			ret_shift_vals.append(p_role_type);
			ret_shift_vals.append("~");
			ret_shift_vals.append(new_staff_id);
			ret_shift_vals.append("~");
			ret_shift_vals.append(staff2_shift_code);
			ret_shift_vals.append("|");
			ret_shift_vals.append(new_mnemonic_key);
			ret_shift_vals.append("|");
			ret_shift_vals.append(new_shift_indicator);
			ret_shift_vals.append("|");
			ret_shift_vals.append(new_productive_flag);

		   }
		   else{
			ret_shift_vals.append(flag);
			ret_shift_vals.append("~");
			ret_shift_vals.append(staff1_shift_code);
			ret_shift_vals.append("|");
			ret_shift_vals.append(old_mnemonic_key);
			ret_shift_vals.append("|");
			ret_shift_vals.append(old_shift_indicator);
			ret_shift_vals.append("|");
			ret_shift_vals.append(old_productive_flag);
			ret_shift_vals.append("~");
			ret_shift_vals.append(staff2_shift_code);
			ret_shift_vals.append("|");
			ret_shift_vals.append(new_mnemonic_key);
			ret_shift_vals.append("|");
			ret_shift_vals.append(new_shift_indicator);
			ret_shift_vals.append("|");
			ret_shift_vals.append(new_productive_flag);
		   }
		
			HashMap tabData=new HashMap();
   			tabData.put("staff1_shift_code",staff1_shift_code);
			tabData.put("old_mnemonic_key",old_mnemonic_key);
			tabData.put("p_facility_id",p_facility_id);
			tabData.put("p_workplace_code",p_workplace_code);
			tabData.put("p_schedule_date",p_schedule_date);
			tabData.put("p_role_type",p_role_type);
			tabData.put("p_staff_id",p_staff_id);
			tabData.put("p_staff_type",p_staff_type);
			tabData.put("p_position_code",p_position_code);
			tabData.put("p_requirement_id",p_requirement_id);
			tabData.put("new_workplace_code",new_workplace_code);
			tabData.put("new_staff_id",new_staff_id);
			tabData.put("staff2_shift_code",staff2_shift_code);
			tabData.put("new_mnemonic_key",new_mnemonic_key);

			tabData.put("reason",reason);
			tabData.put("remarks",remarks);
			tabData.put("added_by_id", added_by_id);
			tabData.put("added_at_ws_no",  client_ip_address);
			tabData.put("added_facility_id",  facility_id);
			tabData.put("locale",  locale);
			tabData.put("properties",properties);
			System.out.println("tabData in servlet 161----|"+tabData+"|-----locale in servlet 159----|"+locale+"|----");

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSManageWorkScheduleSwap", eRS.RSManageWorkScheduleSwap.RSManageWorkScheduleSwapLocalHome.class, local_ejbs);
			Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[1];
			aobj[0] = tabData;
			Class aclass[] = new Class[1];
			aclass[0] = tabData.getClass();
			HashMap map=(HashMap)obj1.getClass().getMethod("insert", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);
			System.out.println("Map in servlet 173----|"+map+"|----");

			String result = ((Boolean)map.get("result")).toString();
			String err_num="";
			err_num=(String)map.get("message");
			System.out.println("result in servlet 177----|"+result+"|-----err_num in servlet 179-----|"+err_num+"|----");
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
