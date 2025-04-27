/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED */
/***************************************************************************/
/*	Filename		:	GenerateWorkScheduleServlet.java
*	Purpose 		:	This servlet is used to take all the request parameters and
*						put in a Hashtable which will be further given as an argument to the
*						EJB - 
*	Created By		:	Suresh.S
*	Created On		:	17 Dec 2004
*/

package eRS;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;
import eRS.RSGenerateWorkSchedule.*;

public class GenerateWorkScheduleServlet extends HttpServlet{ 

	private ServletConfig config	= null;
	HttpSession session				= null;
	Properties p							= new Properties();
	String client_ip_address		= "";
	String error_value					="";
	String error_num					= "";
	String facility_id						="";
	String user_id				= "";
	String ws_no			= "";
	String locale				="";

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy HH:mm" ) ;	

	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		this.config = config;
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{
		doPost(request,response);
	}

	public synchronized void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{

		session = request.getSession(false);
		this.facility_id = (String)session.getAttribute("facility_id");
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");	
		locale=(String)session.getAttribute("LOCALE");

		try{
			request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8"); 
			insert(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
/***************************************************************************/
	public void insert(HttpServletRequest request,HttpServletResponse response)throws Exception{
		try{

			HashMap tabData = new HashMap();
			HashMap insertData = new HashMap();
					
			user_id 			= p.getProperty( "login_user" ) ;
			ws_no			= client_ip_address;

			String wrkPlace_code= request.getParameter("wrkplace_code")==null ? "":request.getParameter("wrkplace_code");
			String frm_dt		= request.getParameter("frm_dt")==null ? "":request.getParameter("frm_dt");
			String to_dt		= request.getParameter("to_dt")==null ? "":request.getParameter("to_dt");
			String locn_type	= request.getParameter("locn_type")==null ? "":request.getParameter("locn_type");
			String totalrecs	= request.getParameter("totalrecs");
			String added_date = dateFormat.format( new java.util.Date() ) ;

			int count=0;

			facility_id		 = request.getParameter("facility_id")==null ? "":request.getParameter("facility_id");
			int int_total_records = Integer.parseInt(totalrecs);
				
			for(int i=0; i<int_total_records; i++){
				String select_yn = request.getParameter("select"+i)==null ? "N":request.getParameter("select"+i);
				
				if(select_yn.equalsIgnoreCase("Y")){
					insertData	= new HashMap();
					String role_type=request.getParameter("role_type"+i)==null ? "":request.getParameter("role_type"+i);
					String staffID=request.getParameter("staffID"+i)==null ? "":request.getParameter("staffID"+i);
					String staff_eff_dt_frm=request.getParameter("frm_dt"+i)==null ? "":request.getParameter("frm_dt"+i);
					String staff_eff_dt_to=request.getParameter("to_dt"+i)==null ? "":request.getParameter("to_dt"+i);
					String staff_type=request.getParameter("staff_type"+i)==null ? "":request.getParameter("staff_type"+i);
					String position_code=request.getParameter("position_code"+i)==null ? "":request.getParameter("position_code"+i);
				/*	if(staff_eff_dt_to.equals(""))
						staff_eff_dt_to="31/12/2100";*/
					insertData.put("locn_type",locn_type); 
					insertData.put("role_type",role_type); 
					insertData.put("staff_id",staffID);
					insertData.put("staff_eff_dt_frm",staff_eff_dt_frm); 
					insertData.put("staff_eff_dt_to",staff_eff_dt_to); 
					insertData.put("staff_type",staff_type); 
					insertData.put("position_code",position_code); 
					tabData.put( ("InsertData"+count++), insertData);
				}
			}
			tabData.put("facility_id",facility_id);
			tabData.put("workplace_code",wrkPlace_code); 
			tabData.put("frm_dt",frm_dt); 
			tabData.put("to_dt",to_dt); 
			tabData.put("user_id",user_id); 
			tabData.put("added_date",added_date); 
			tabData.put("ws_no",ws_no); 	
			tabData.put("locale",locale); 	
			tabData.put("properties", p);		
			tabData.put("totalRecords", String.valueOf(count));

		/*	RSGenerateWorkScheduleHome home = null;
			RSGenerateWorkScheduleRemote remote = null;
			InitialContext context = new InitialContext() ;
			Object object = context.lookup("java:comp/env/ejb/eRS/RSGenerateWorkSchedule");
			home = (RSGenerateWorkScheduleHome) PortableRemoteObject.narrow( object, RSGenerateWorkScheduleHome.class ) ;
			remote = home.create() ;
			HashMap map = remote.insert(tabData) ;
		*/
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSGenerateWorkSchedule", eRS.RSGenerateWorkSchedule.RSGenerateWorkScheduleLocalHome.class, local_ejbs);
			Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[1];
			aobj[0] = tabData;
			Class aclass[] = new Class[1];
			aclass[0] = tabData.getClass();
			HashMap map=(HashMap)obj1.getClass().getMethod("insert", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);

			String result = ((Boolean)map.get("result")).toString();
			if(result.equals("true"))
				error_value="1";
			else
				error_value="0";
			error_num =(String)map.get("message");
			response.sendRedirect("../eCommon/jsp/error.jsp?err_num="+error_num+"&err_val="+error_value);
		}catch(Exception e){
			e.printStackTrace();
		}
	}//end of insert
}// end of class
