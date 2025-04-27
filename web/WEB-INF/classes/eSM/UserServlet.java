/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import eSM.SMUser.*;
import com.ehis.util.*;

public class UserServlet extends javax.servlet.http.HttpServlet{

	PrintWriter out;
	java.util.Properties p;
	String client_ip_address ;
	String locale;
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
	
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		try {
			this.out = res.getWriter();
			String operation = req.getParameter("function");
		if ( operation.equals("insert") )
			insertSMUser(req, res);
		if ( operation.equals("modify"))
				modifySMUser(req, res);
		
		out = null;
		}
	catch (Exception e)	{
		out.println("####exception1="+e.toString());
		}
    }



private void modifySMUser(HttpServletRequest req, HttpServletResponse res)	{
	try {
		String gr_fromdate=null;
		String gr_todate=null;
		locale=p.getProperty("LOCALE");
		String from_date=req.getParameter("eff_date_from")== null ?"":req.getParameter("eff_date_from");
		String to_date=req.getParameter("eff_date_to")== null ?"":req.getParameter("eff_date_to");
		if(!(from_date.equals("")||from_date==null))
		gr_fromdate=DateUtils.convertDate(from_date,"DMY",locale,"en");
		if(!(to_date.equals("")||to_date==null))
		gr_todate=DateUtils.convertDate(to_date,"DMY",locale,"en");
		String fromdate="";
		if(!(gr_fromdate==null||gr_fromdate.equals(""))){
		StringTokenizer str=new StringTokenizer(gr_fromdate,"/");
		String day=str.nextToken();
		String month=str.nextToken();		
		String year=str.nextToken();
		fromdate=year+"-"+month+"-"+day;
		}
		String todate="";
		if(!(gr_todate==null||gr_todate.equals(""))){
		StringTokenizer str1=new StringTokenizer(gr_todate,"/");
		String day1=str1.nextToken();
		String month1=str1.nextToken();		
		String year1=str1.nextToken();
		todate=year1+"-"+month1+"-"+day1;
		}


		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SMUserManager",SMUserManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		HashMap argMap=new HashMap ();
		argMap.put("p",p);
		argMap.put("resource_status",req.getParameter("resource_status"));
		argMap.put("response_status",req.getParameter("response_status")); //Added by Suji Keerthi for MMS-MD-SCF-0173 
		argMap.put("password_status",req.getParameter("password_status"));
		argMap.put("appl_user_id",req.getParameter("appl_user_id"));
		argMap.put("appl_user_name",req.getParameter("appl_user_name"));
		argMap.put("LANGUAGE_ID",req.getParameter("language")== null ?"":req.getParameter("language"));
		argMap.put("appl_user_password",req.getParameter("appl_user_password"));
		argMap.put("rep_facility_id",req.getParameter("rep_facility_id2")== null ?"":req.getParameter("rep_facility_id2"));
		argMap.put("contact_tel_no",req.getParameter("contact_tel_no"));
		argMap.put("contact_fax_no",req.getParameter("contact_fax_no"));
		argMap.put("email_id",req.getParameter("email_id"));
		argMap.put("resp_group_id",req.getParameter("resp_group_id1")== null ?"":req.getParameter("resp_group_id1"));
		argMap.put("responsibility_group",req.getParameter("responsibility_group1")== null ?"":req.getParameter("responsibility_group1")); //Added by Suji Keerthi for MMS-MD-SCF-0173
		argMap.put("employee_no",req.getParameter("employee_no"));
		argMap.put("effectiveDateFrom",fromdate);
		argMap.put("effectiveDateTo",todate);
		argMap.put("effectiveStatus",req.getParameter("eff_status")== null ?"D":req.getParameter("eff_status"));
		argMap.put("funcroleid",req.getParameter("pract_name1"));
		argMap.put("func_id",req.getParameter("func_id"));
		argMap.put("funcrole",req.getParameter("role_type1"));
		argMap.put("modifiedAtWorkstation",client_ip_address);
		argMap.put("first_login_yn",req.getParameter("first_login_yn"));//Maheshwaran added for the MMS-QH-CRF-0149
		argMap.put("case_sensitive_password_yn",req.getParameter("case_sensitive_password_yn"));//Maheshwaran added for the MMS-QH-CRF-0149
		//Added by Maheshwaran K for the Password Validation as on 11/07/2012
		//Start
		argMap.put("password_value_Y",req.getParameter("password_value_Y")== null ?"N":req.getParameter("password_value_Y"));
		argMap.put("unlock_yn",req.getParameter("unlock_yn")== null ?"N":req.getParameter("unlock_yn"));
		argMap.put("ws_no",req.getParameter("ws_no"));
		//end
		argMap.put("appl_pin_no",req.getParameter("appl_pin_no")== null ?"":req.getParameter("appl_pin_no"));
		//argMap.put("responsibility_grp",req.getParameter("responsibility_group")== null ?"":req.getParameter("responsibility_group")); //Commented by Suji Keerthi for MMS-MD-SCF-0173
		argMap.put("reports_home_dir",req.getParameter("rpt_output_dir")== null ?"":req.getParameter("rpt_output_dir"));
		argMap.put("long_name",req.getParameter("long_name")== null ?"":req.getParameter("long_name"));
		argMap.put("active_dir_id",req.getParameter("active_dir_id")== null ?"":req.getParameter("active_dir_id"));
		
		argMap.put("link_ad_user",req.getParameter("link_ad_user")== null ?"N":req.getParameter("link_ad_user"));//Added by Kamatchi S for ML-MMOH-CRF-1844
		argMap.put("curr_effstatus",req.getParameter("curr_effstatus")== null ?"":req.getParameter("curr_effstatus"));//Added by Ashwini on 20-Jul-2020 for AMS-SCF-0888
		argMap.put("enable_date_time",new  java.sql.Timestamp(System.currentTimeMillis()));//Added by Kamatchi S for ML-BRU-CRF-0594
		Object argArray[] = new Object[1];
		argArray[0] =argMap ;
			
		Class [] paramArray = new Class[1];
		paramArray[0] = argMap.getClass();
		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateSMUser",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		argMap.clear();

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;
		results.clear();

		if ( inserted ) error_value = "1" ;
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );

		} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			}
	}
private void insertSMUser(HttpServletRequest req, HttpServletResponse res)	{
	try {
		String gr_fromdate=null;
		String gr_todate=null;
		locale=p.getProperty("LOCALE");
		String from_date=req.getParameter("eff_date_from")== null ?"":req.getParameter("eff_date_from");
		String to_date=req.getParameter("eff_date_to")== null ?"":req.getParameter("eff_date_to");
		if(!(from_date.equals("")||from_date==null))
		gr_fromdate=DateUtils.convertDate(from_date,"DMY",locale,"en");
		if(!(to_date.equals("")||to_date==null))
		gr_todate=DateUtils.convertDate(to_date,"DMY",locale,"en");

		String fromdate="";
		if(!(gr_fromdate==null||gr_fromdate.equals(""))){
		StringTokenizer str=new StringTokenizer(gr_fromdate, "/");
		String day=str.nextToken();
		String month=str.nextToken();		
		String year=str.nextToken();
		fromdate=year+"-"+month+"-"+day;
		}

		String todate="";
		if(!(gr_todate==null||gr_todate.equals(""))){
		StringTokenizer str1=new StringTokenizer(gr_todate, "/");
		String day1=str1.nextToken();
		String month1=str1.nextToken();		
		String year1=str1.nextToken();
		todate=year1+"-"+month1+"-"+day1;
		}

		boolean local_ejbs = false;
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SMUserManager",SMUserManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		HashMap argMap=new HashMap ();
		argMap.put("p",p);
		argMap.put("appl_user_id",req.getParameter("appl_user_id"));
		argMap.put("appl_user_name",req.getParameter("appl_user_name"));
		argMap.put("appl_user_password",req.getParameter("appl_user_password"));
		argMap.put("rep_facility_id",req.getParameter("rep_facility_id")== null ?"":req.getParameter("rep_facility_id"));
		argMap.put("contact_tel_no",req.getParameter("contact_tel_no"));
		argMap.put("contact_fax_no",req.getParameter("contact_fax_no"));
		argMap.put("LANGUAGE_ID",req.getParameter("language")== null ?"":req.getParameter("language"));
		argMap.put("email_id",req.getParameter("email_id"));
		argMap.put("resp_group_id",req.getParameter("resp_group_id")== null ?"":req.getParameter("resp_group_id"));
		argMap.put("responsibility_group",req.getParameter("responsibility_group")== null ?"":req.getParameter("responsibility_group")); //Added by Suji Keerthi for MMS-MD-SCF-0173
		argMap.put("employee_no",req.getParameter("employee_no"));
		argMap.put("effectiveDateFrom",fromdate);
		argMap.put("effectiveDateTo",todate);
		argMap.put("effectiveStatus",req.getParameter("eff_status")== null ?"D":req.getParameter("eff_status"));
		argMap.put("funcroleid",req.getParameter("pract_name"));
		argMap.put("func_id",req.getParameter("func_id"));
		argMap.put("funcrole",req.getParameter("role_type"));
		argMap.put("addedAtWorkstation",client_ip_address);
		argMap.put("appl_pin_no",req.getParameter("appl_pin_no")== null ?"":req.getParameter("appl_pin_no"));
		//argMap.put("responsibility_grp",req.getParameter("responsibility_group")== null ?"":req.getParameter("responsibility_group")); //Commented by Suji Keerthi for MMS-MD-SCF-0173
		argMap.put("reports_home_dir",req.getParameter("rpt_output_dir")== null ?"":req.getParameter("rpt_output_dir"));
		argMap.put("long_name",req.getParameter("long_name")== null ?"":req.getParameter("long_name"));
		argMap.put("active_dir_id",req.getParameter("active_dir_id")== null ?"":req.getParameter("active_dir_id"));
		
		argMap.put("link_ad_user",req.getParameter("link_ad_user")== null ?"N":req.getParameter("link_ad_user"));//Added by Kamatchi S for ML-MMOH-CRF-1844
		argMap.put("case_sensitive_password_yn",req.getParameter("case_sensitive_password_yn"));//Maheshwaran added for the MMS-QH-CRF-0149
		Object argArray[] = new Object[1];
		argArray[0] =argMap ;
			
		Class [] paramArray = new Class[1];

		paramArray[0] = argMap.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertSMUser",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		argMap.clear();

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;
		results.clear();
		
		if(error.contains("ORA-01920") && (req.getParameter("appl_user_id")).equals("APPLUSER"))
		{
			error = "ORA-01920: user name APPLUSER conflicts with another user or role name";
		}
		
		if ( inserted ) error_value = "1" ;
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );

	} catch ( Exception e ) {
		System.err.println("####exception2="+e.getMessage());
		System.err.println("####exception3="+e.toString());
		}


	}
}
