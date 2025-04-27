/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import eFM.FMUserAccess.* ;

public class FMUserAccessServlet extends javax.servlet.http.HttpServlet	
{
	PrintWriter out;	
	Properties p;

	String appl_user_id;					         
	String fs_locn_code;          
	String assign_fs_locn;          
	String change_fs_locn;          
	String req_yn;          
	String req_across_facilities_yn; 
	String manual_request_yn;
	String cancel_request_yn;
	String iss_yn;    
	String iss_across_facilities_yn	; 
	String CREATE_FILE_VOLUME_YN;
	String change_return_date_yn;    
	String deficiency_check_yn;    
	String file_lost_found_yn;    
	String track_out_to_opd_yn;   
	String track_out_to_ipw_yn;   
	String receive_file_yn;
	String return_file_yn;
	String confirm_receipt_file_yn;
	String transfer_file_yn;
	String access_all,locn_identity,all_fs_locn_codes;
	String facilityId;
	String client_ip_address ;
	String locale			= "" ;

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
			throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession(false);
		this.p = (Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		this.facilityId = (String)session.getValue("facility_id") ;
		this.client_ip_address = p.getProperty("client_ip_address");

		try 
		{
			this.out = res.getWriter();
			String operation = req.getParameter("mode");		
			if(operation.equals("insert")) insertUserAccess(req, res, locale);
			if(operation.equals("modify")) modifyUserAccess(req, res, locale);
			if(operation.equals("delete")) deleteUserAccess(req, res, locale);
		}
		catch (Exception e)	
		{
			out.println(e.toString());
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link></head><frameset rows='60,*,50'><frame name='commontoolbarFrame'	src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=Name Prefix' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{	
		out.println("Exception in doGet method :"+e.toString());
		}
	}
	private void modifyUserAccess(HttpServletRequest req, HttpServletResponse res, String locale)	
	{
		try 
		{
			HashMap htUserAccess	  =	new java.util.HashMap();

			appl_user_id	= req.getParameter("user");
			fs_locn_code	= req.getParameter("storage_location");
			assign_fs_locn  = req.getParameter("assign_fs_locn");

			if(assign_fs_locn==null || assign_fs_locn.equals("null") || assign_fs_locn.equals(""))
				assign_fs_locn="N";
			change_fs_locn = req.getParameter("change_fs_locn");
			if(change_fs_locn==null || change_fs_locn.equals("null") || change_fs_locn.equals(""))
				change_fs_locn="N";
			change_return_date_yn = req.getParameter("change_return_date_yn");
			if(change_return_date_yn==null || change_return_date_yn.equals("null") || change_return_date_yn.equals(""))
				change_return_date_yn="N";
			deficiency_check_yn = req.getParameter("deficiency_check_yn");
			if(deficiency_check_yn==null || deficiency_check_yn.equals("null") || deficiency_check_yn.equals(""))
				deficiency_check_yn="N";
			file_lost_found_yn = req.getParameter("file_lost_found_yn");
			if(file_lost_found_yn==null || file_lost_found_yn.equals("null") || file_lost_found_yn.equals(""))
				file_lost_found_yn="N";
			track_out_to_opd_yn = req.getParameter("track_out_to_opd_yn");
			if(track_out_to_opd_yn==null || track_out_to_opd_yn.equals("null") || track_out_to_opd_yn.equals(""))
				track_out_to_opd_yn="N";
			track_out_to_ipw_yn = req.getParameter("track_out_to_ipw_yn");
			if(track_out_to_ipw_yn==null || track_out_to_ipw_yn.equals("null") || track_out_to_ipw_yn.equals(""))
				track_out_to_ipw_yn="N";
			req_yn = req.getParameter("req_yn");
			if(req_yn==null || req_yn.equals("null") || req_yn.equals(""))
				req_yn="N";
			req_across_facilities_yn = req.getParameter("req_across_facilities_yn");
			if(req_across_facilities_yn==null || req_across_facilities_yn.equals("null") || req_across_facilities_yn.equals(""))
				req_across_facilities_yn="N";
			manual_request_yn = req.getParameter("manual_request_yn");
			if(manual_request_yn==null || manual_request_yn.equals("null") || manual_request_yn.equals(""))
				manual_request_yn="N";
			cancel_request_yn = req.getParameter("cancel_request_yn");
			if(cancel_request_yn==null || cancel_request_yn.equals("null") || cancel_request_yn.equals(""))
				cancel_request_yn="N";
			iss_yn = req.getParameter("iss_yn");
			if(iss_yn==null || iss_yn.equals("null") || iss_yn.equals(""))
				iss_yn="N";
			iss_across_facilities_yn = req.getParameter("iss_across_facilities_yn");
			if(iss_across_facilities_yn==null || iss_across_facilities_yn.equals("null") || iss_across_facilities_yn.equals(""))
				iss_across_facilities_yn="N";

			CREATE_FILE_VOLUME_YN = req.getParameter("CREATE_FILE_VOLUME_YN");
			if(CREATE_FILE_VOLUME_YN==null || CREATE_FILE_VOLUME_YN.equals("null") || CREATE_FILE_VOLUME_YN.equals(""))
				CREATE_FILE_VOLUME_YN="N";

			receive_file_yn = req.getParameter("receive_file_yn");
			if(receive_file_yn==null || receive_file_yn.equals("null") || receive_file_yn.equals(""))
				receive_file_yn="N";

			return_file_yn = req.getParameter("return_file_yn");
			if(return_file_yn==null || return_file_yn.equals("null") || return_file_yn.equals(""))
				return_file_yn="N";

			confirm_receipt_file_yn = req.getParameter("confirm_receipt_yn");
			if(confirm_receipt_file_yn==null || confirm_receipt_file_yn.equals("null") || confirm_receipt_file_yn.equals(""))
				confirm_receipt_file_yn="N";

			transfer_file_yn = req.getParameter("transfer_file_yn");
			if(transfer_file_yn==null || transfer_file_yn.equals("null") || transfer_file_yn.equals(""))
				transfer_file_yn="N";

			locn_identity = req.getParameter("locn_identity");
			if(locn_identity==null || locn_identity.equals("null") || locn_identity.equals(""))
				locn_identity="N";

			all_fs_locn_codes = req.getParameter("all_fs_locn_codes");
			if(all_fs_locn_codes==null || all_fs_locn_codes.equals("null") || all_fs_locn_codes.equals(""))
				all_fs_locn_codes="";

				
			htUserAccess.put ( "facilityId", facilityId );
			htUserAccess.put ( "appl_user_id", appl_user_id );
			htUserAccess.put ( "fs_locn_code", fs_locn_code );
			htUserAccess.put ( "assign_fs_locn", assign_fs_locn );
			htUserAccess.put ( "change_fs_locn", change_fs_locn );
			htUserAccess.put ( "req_yn", req_yn );
			htUserAccess.put ( "req_across_facilities_yn", req_across_facilities_yn );
			htUserAccess.put ( "manual_request_yn", manual_request_yn );
			htUserAccess.put ( "cancel_request_yn", cancel_request_yn );
			htUserAccess.put ( "iss_yn", iss_yn );
			htUserAccess.put ( "iss_across_facilities_yn", iss_across_facilities_yn );
			htUserAccess.put ( "CREATE_FILE_VOLUME_YN", CREATE_FILE_VOLUME_YN );
			htUserAccess.put ( "change_return_date_yn", change_return_date_yn );
			htUserAccess.put ( "deficiency_check_yn", deficiency_check_yn );
			htUserAccess.put ( "file_lost_found_yn", file_lost_found_yn );
			htUserAccess.put ( "track_out_to_opd_yn", track_out_to_opd_yn );
			htUserAccess.put ( "track_out_to_ipw_yn", track_out_to_ipw_yn );
			htUserAccess.put ( "receive_file_yn", receive_file_yn );
			htUserAccess.put ( "return_file_yn", return_file_yn );
			htUserAccess.put ( "confirm_receipt_file_yn", confirm_receipt_file_yn );
			htUserAccess.put ( "transfer_file_yn", transfer_file_yn );
			htUserAccess.put ( "locn_identity", locn_identity );
			htUserAccess.put ( "all_fs_locn_codes", all_fs_locn_codes );
			htUserAccess.put ( "addedAtWorkstation", client_ip_address );
			htUserAccess.put ( "locale", locale );
		

			boolean inserted = false;			
		
			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/UserAccessManager",UserAccessManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = htUserAccess;
			
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = htUserAccess.getClass();
			
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateUserAccess",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			inserted	=	(((Boolean) results.get( "status" )).booleanValue()) ;
			
			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			
			String error = (String) results.get("error") ;	
			String error_value = "0" ;
			htUserAccess.clear();
			results.clear();	  

			if (inserted)
			{
				error_value = "1" ;
			}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value="+error_value );
		}
		catch ( Exception e ) 
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println(  appl_user_id+ " "+fs_locn_code);
		}
	}
	private void insertUserAccess(HttpServletRequest req, HttpServletResponse res, String locale)	
	{
		try 
		{
			HashMap insUserAccess	  =	new java.util.HashMap();
			
			appl_user_id	= req.getParameter("user");
			fs_locn_code	= req.getParameter("storage_location");
			assign_fs_locn	= req.getParameter("assign_fs_locn");
			access_all		= req.getParameter("access_all");

			if(access_all==null || access_all.equals("null") || access_all.equals(""))
				access_all="N";
			if(assign_fs_locn==null || assign_fs_locn.equals("null") || assign_fs_locn.equals(""))
				assign_fs_locn="N";
			change_fs_locn = req.getParameter("change_fs_locn");
			if(change_fs_locn==null || change_fs_locn.equals("null") || change_fs_locn.equals(""))
				change_fs_locn="N";
			change_return_date_yn = req.getParameter("change_return_date_yn");
			if(change_return_date_yn==null || change_return_date_yn.equals("null") || change_return_date_yn.equals(""))
				change_return_date_yn="N";
			deficiency_check_yn = req.getParameter("deficiency_check_yn");
			if(deficiency_check_yn==null || deficiency_check_yn.equals("null") || deficiency_check_yn.equals(""))
				deficiency_check_yn="N";
			file_lost_found_yn = req.getParameter("file_lost_found_yn");
			if(file_lost_found_yn==null || file_lost_found_yn.equals("null") || file_lost_found_yn.equals(""))
				file_lost_found_yn="N";
			track_out_to_opd_yn = req.getParameter("track_out_to_opd_yn");
			if(track_out_to_opd_yn==null || track_out_to_opd_yn.equals("null") || track_out_to_opd_yn.equals(""))
				track_out_to_opd_yn="N";
			track_out_to_ipw_yn = req.getParameter("track_out_to_ipw_yn");
			if(track_out_to_ipw_yn==null || track_out_to_ipw_yn.equals("null") || track_out_to_ipw_yn.equals(""))
				track_out_to_ipw_yn="N";
			req_yn = req.getParameter("req_yn");
			if(req_yn==null || req_yn.equals("null") || req_yn.equals(""))
				req_yn="N";
			req_across_facilities_yn = req.getParameter("req_across_facilities_yn");
			if(req_across_facilities_yn==null || req_across_facilities_yn.equals("null") || req_across_facilities_yn.equals(""))
				req_across_facilities_yn="N";
			manual_request_yn = req.getParameter("manual_request_yn");
			if(manual_request_yn==null || manual_request_yn.equals("null") || manual_request_yn.equals(""))
				manual_request_yn="N";
			cancel_request_yn = req.getParameter("cancel_request_yn");
			if(cancel_request_yn==null || cancel_request_yn.equals("null") || cancel_request_yn.equals(""))
				cancel_request_yn="N";
			iss_yn = req.getParameter("iss_yn");
			if(iss_yn==null || iss_yn.equals("null") || iss_yn.equals(""))
				iss_yn="N";
			iss_across_facilities_yn = req.getParameter("iss_across_facilities_yn");
			if(iss_across_facilities_yn==null || iss_across_facilities_yn.equals("null") || iss_across_facilities_yn.equals(""))
				iss_across_facilities_yn="N";

			CREATE_FILE_VOLUME_YN = req.getParameter("CREATE_FILE_VOLUME_YN");
			if(CREATE_FILE_VOLUME_YN==null || CREATE_FILE_VOLUME_YN.equals("null") || CREATE_FILE_VOLUME_YN.equals(""))
				CREATE_FILE_VOLUME_YN="N";

			receive_file_yn = req.getParameter("receive_file_yn");
			if(receive_file_yn==null || receive_file_yn.equals("null") || receive_file_yn.equals(""))
				receive_file_yn="N";

			return_file_yn = req.getParameter("return_file_yn");
			if(return_file_yn==null || return_file_yn.equals("null") || return_file_yn.equals(""))
				return_file_yn="N";

			confirm_receipt_file_yn = req.getParameter("confirm_receipt_yn");
			if(confirm_receipt_file_yn==null || confirm_receipt_file_yn.equals("null") || confirm_receipt_file_yn.equals(""))
				confirm_receipt_file_yn="N";

			transfer_file_yn = req.getParameter("transfer_file_yn");
			if(transfer_file_yn==null || transfer_file_yn.equals("null") || transfer_file_yn.equals(""))
				transfer_file_yn="N";

			locn_identity = req.getParameter("locn_identity");
			if(locn_identity==null || locn_identity.equals("null") || locn_identity.equals(""))
				locn_identity="N";

			all_fs_locn_codes = req.getParameter("all_fs_locn_codes");
			if(all_fs_locn_codes==null || all_fs_locn_codes.equals("null") || all_fs_locn_codes.equals(""))
				all_fs_locn_codes="";	
		
			insUserAccess.put ( "facilityId", facilityId );
			insUserAccess.put ( "appl_user_id", appl_user_id );
			insUserAccess.put ( "fs_locn_code", fs_locn_code );
			insUserAccess.put ( "access_all", access_all );
			insUserAccess.put ( "assign_fs_locn", assign_fs_locn );
			insUserAccess.put ( "change_fs_locn", change_fs_locn );
			insUserAccess.put ( "req_yn", req_yn );
			insUserAccess.put ( "req_across_facilities_yn", req_across_facilities_yn );
			insUserAccess.put ( "manual_request_yn", manual_request_yn );
			insUserAccess.put ( "cancel_request_yn", cancel_request_yn );				
			insUserAccess.put ( "iss_yn", iss_yn );
			insUserAccess.put ( "iss_across_facilities_yn", iss_across_facilities_yn );				
			insUserAccess.put ( "CREATE_FILE_VOLUME_YN", CREATE_FILE_VOLUME_YN );
			insUserAccess.put ( "change_return_date_yn", change_return_date_yn );
			insUserAccess.put ( "deficiency_check_yn", deficiency_check_yn );
			insUserAccess.put ( "file_lost_found_yn", file_lost_found_yn );
			insUserAccess.put ( "track_out_to_opd_yn", track_out_to_opd_yn );
			insUserAccess.put ( "track_out_to_ipw_yn", track_out_to_ipw_yn );
			insUserAccess.put ( "receive_file_yn", receive_file_yn );
			insUserAccess.put ( "return_file_yn", return_file_yn );
			insUserAccess.put ( "confirm_receipt_file_yn", confirm_receipt_file_yn );
			insUserAccess.put ( "transfer_file_yn", transfer_file_yn );
			insUserAccess.put ( "locn_identity", locn_identity );
			insUserAccess.put ( "all_fs_locn_codes", all_fs_locn_codes );
			insUserAccess.put ( "addedAtWorkstation", client_ip_address );
			insUserAccess.put ( "locale", locale );
			
			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
						
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/UserAccessManager",UserAccessManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = insUserAccess;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = insUserAccess.getClass();
						
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertUserAccess",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			insUserAccess.clear();
			results.clear();

			if (inserted)
			{
				error_value = "1";
			}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" +error_value );
		}
		catch ( Exception e ) 
		{
			out.println(e.getMessage());
			out.println(e.toString());
		}
	}
	private void deleteUserAccess(HttpServletRequest req, HttpServletResponse res, String locale)	
	{
		try
		{
			res.setContentType("text/html");
			HashMap delUserAccess	  =	new java.util.HashMap();
			appl_user_id=req.getParameter("user");
			fs_locn_code = req.getParameter("storage_location");
			
			delUserAccess.put ( "facilityId", facilityId );
			delUserAccess.put ( "appl_user_id", appl_user_id );
			delUserAccess.put ( "fs_locn_code", fs_locn_code );				
			delUserAccess.put ( "locale", locale );				
				
			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/UserAccessManager",UserAccessManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = delUserAccess;
			
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = delUserAccess.getClass();
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("deleteUserAccess",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			delUserAccess.clear();
			results.clear();

			if (inserted)
			{
				error_value = "1";
			}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value="+error_value );
		}
		catch ( Exception e ) 
		{
			out.println(e.getMessage());
			out.println(e.toString());
		}
	}
}
