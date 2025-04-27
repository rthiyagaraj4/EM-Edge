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
import java.util.* ;
import java.sql.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import javax.servlet.*;
import javax.servlet.http.*;
import  eCommon.SingleTableHandler.*;
import eRS.RSCancelSchedule.*;

public class CancelWorkScheduleServlet extends HttpServlet{
	private ServletConfig config = null;
	HttpSession session = null;
	Properties p = new Properties();
	String client_ip_address = "";
	String error_value ="";
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id= "";
	String modified_at_ws_no = "";
	String modified_facility_id= "";

	String facil_id="";
	String work_code="";        
	String rol_type="";
	String staf_id="";
	String sch_date="";
	String shft_code="";
	String select_yn=""; 

	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		this.config = config;
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{
		doPost(request,response);
	}
	/********************************************************************/

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{

		session = request.getSession(false);
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");		

		try{
			request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8"); 

			cancelSchedule(request, response);

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**********************************************************************/
	public void cancelSchedule(HttpServletRequest request,HttpServletResponse response)throws Exception{		
		try{

			String facility_id=request.getParameter( "facility_id" ) ;
			String frm_dt=request.getParameter( "frm_dt" ) ;
			String to_dt=request.getParameter( "to_dt" ) ;
			String workplace_code=request.getParameter( "workplace_code" ) ;
			String locn_type=request.getParameter( "locn_type" ) ;
			String position_code=request.getParameter( "position_code" ) ;
			String role_type=request.getParameter( "role_type" ) ;
			String staff_id=request.getParameter( "staff_id" ) ;
			String staff_type=request.getParameter( "staff_type" ) ;
			String reason_code=request.getParameter( "reason_code" ) ;
			String totalRecords;
			
			HashMap tabData = new HashMap();

			added_by_id 	= p.getProperty( "login_user" ) ;
			modified_by_id	= added_by_id ;
			added_at_ws_no	= client_ip_address;
			added_facility_id= facility_id;
			modified_at_ws_no= added_at_ws_no ;
			modified_facility_id = facility_id ;

			totalRecords=request.getParameter("totalRecords");
			int int_totalRecords = Integer.parseInt(totalRecords);
			int counter = 0;
			for(int i=0; i<int_totalRecords; i++){
				facil_id = request.getParameter("facility_id")==null ? "":request.getParameter("facility_id");
				work_code = request.getParameter("work_code"+i)==null ? "":request.getParameter("work_code"+i);
				rol_type = request.getParameter("rol_type"+i)==null ? "":request.getParameter("rol_type"+i);
				staf_id = request.getParameter("staf_id"+i)==null ? "":request.getParameter("staf_id"+i);
				sch_date = request.getParameter("sch_date"+i)==null ? "":request.getParameter("sch_date"+i);
				shft_code = request.getParameter("shft_code"+i)==null ? "":request.getParameter("shft_code"+i);
				select_yn = request.getParameter("select_yn"+i)==null ? "":request.getParameter("select_yn"+i);
				if(select_yn.equalsIgnoreCase("Y")){ 
					HashMap delData = new HashMap() ;
					delData.put(("facil_id"), (String)(facil_id )) ;
					delData.put(("work_code"), (String)(work_code)) ;
					delData.put(("rol_type"), (String)(rol_type)) ;
					delData.put(("staf_id"), (String)(staf_id)) ;
					delData.put(("sch_date"), (String)(sch_date)) ;
					delData.put(("shft_code"), (String)(shft_code)) ;
					tabData.put(String.valueOf(++counter),delData);
 
				}						
		}
			 tabData.put("facility_id",facility_id);
			 tabData.put("frm_dt",frm_dt);
			 tabData.put("to_dt",to_dt);
			 tabData.put("workplace_code",workplace_code);
			 tabData.put("locn_type",locn_type);
			 tabData.put("position_code",position_code);
			 tabData.put("role_type",role_type);
			 tabData.put("staff_id",staff_id);
			 tabData.put("staff_type",staff_type);
			 tabData.put("reason_code",reason_code);
			 tabData.put("added_by_id",added_by_id);
			 tabData.put("added_at_ws_no",added_at_ws_no);
			 tabData.put("added_facility_id",added_facility_id);
			 tabData.put("modified_by_id",modified_by_id);
			 tabData.put("modified_at_ws_no",modified_at_ws_no);
			 tabData.put("modified_facility_id",modified_facility_id);
			 tabData.put( "properties",	p) ;
			 tabData.put("recdelhandler",String.valueOf(counter));

			if(!(tabData.isEmpty())){

				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSCancelSchedule", eRS.RSCancelSchedule.RSCancelScheduleLocalHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[1];
				aobj[0] = tabData;
				Class aclass[] = new Class[1];
				aclass[0] = tabData.getClass();
				HashMap map=(HashMap)obj1.getClass().getMethod("delete", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);

				String result = ((Boolean)map.get("result")).toString();

				if(result.equals("true"))
					error_value = "APP-SM0002 Operation Completed Successfully...";
				else
					error_value = "Exception Occured... "+ (String)map.get("msgid");

				response.sendRedirect("../eCommon/jsp/error.jsp?err_num="+error_value+"&err_val=1" );			
			} 
		}catch(Exception e){
			e.printStackTrace();
		}		
	}				
}
