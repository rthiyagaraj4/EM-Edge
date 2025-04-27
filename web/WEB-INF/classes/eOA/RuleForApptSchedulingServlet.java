/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import eCommon.SingleTabHandler.*;

public class RuleForApptSchedulingServlet extends javax.servlet.http.HttpServlet{
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		System.out.println("doPost of RuleForApptSchedulingServlet");
		PrintWriter out;
		HttpSession session;
		session = req.getSession(false);
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		   /* CheckStyle Violation Commented by Munisekhar */ 
		//String facilityId = (String) session.getValue( "facility_id" ) ;
		//String client_ip_address = p.getProperty("client_ip_address");
		String description =req.getParameter("rule_desc")==null?"":req.getParameter("rule_desc").trim();
		String no_weeks_for_rule =req.getParameter("no_weeks_for_rule")==null?"":req.getParameter("no_weeks_for_rule").trim();
		String all_day_yn =req.getParameter("all_day_yn")==null?"":req.getParameter("all_day_yn").trim();
		String record_exists =req.getParameter("record_exists")==null?"":req.getParameter("record_exists").trim();
		System.out.println("description  ==>"+description);
		System.out.println("no_weeks_for_rule  ==>"+no_weeks_for_rule);
		System.out.println("all_day_yn  ==>"+all_day_yn);
		out = res.getWriter();
		try{
			HashMap tabdata=new HashMap();
			tabdata.put("description",description);
			tabdata.put("NO_WEEKS_FOR_RULE",no_weeks_for_rule);
			tabdata.put("ALL_DAY_YN",all_day_yn);			
			String hard_val="oa_rule_appt_schedule";

			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);



			java.util.HashMap results = null;
			if(record_exists.equals("N")){
				String dupflds[]={"description"};
				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = tabdata;
				argArray[2] = dupflds;
				argArray[3] = hard_val;


				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();
				paramArray[2] = dupflds.getClass();
			paramArray[3] = hard_val.getClass();
				results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			}else{
				HashMap dupflds=new HashMap();
				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = tabdata;
				argArray[2] = dupflds;
				argArray[3] = hard_val;


				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();
				paramArray[2] = dupflds.getClass();
				paramArray[3] = hard_val.getClass();
				results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			}

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted )
			{
			 error_value = "1" ;
				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");


			}
			else
			{
			 error = (String) results.get("error") ;
				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) +"\"</script>");

			}

			results.clear();
			tabdata.clear();
			//out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) +"\"</script>");
			//out.println("<script>location.href =\"../eCommon/jsp/error.jsp\"</script>");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
