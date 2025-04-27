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
import webbeans.eCommon.*;
import eFM.FMLostFoundFile.* ;

public class FMLostFoundFileServlet extends javax.servlet.http.HttpServlet	
{
	PrintWriter out;
	Properties p;

	String p_new_status			= "";
	String p_fs_location		= "";
	String p_updated_by			= "";
	String p_file_no			= "";
	String p_file_type_code		= "";
	String p_volume_no			= "";
	String p_doc_type_code		= "";
	String p_doc_folder_id		= "";
	String p_remarks			= "";
	String src_fs_locn_code		= "";
	String src_locn_identity	= "";
	String src_user_id			= "";
	String facilityId			= "";
	String src_mr_locn_yn		= "";
	String patient_id			= "";
	String error				= "";
	String changed_by			= "";
	String curr_facility_id		= "";
	String p_locn_code			= "";
	String client_ip_address	= "";
	String locale			= "" ;
	String NevertoArchive="";
	String archive_yn="";
	String db_archive_yn="";
    String login_user_id="";
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		HttpSession session = req.getSession(false);
		this.p = (Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		this.facilityId = (String)session.getValue("facility_id") ;
		this.client_ip_address = p.getProperty("client_ip_address");
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	    login_user_id		     =	(String) session.getValue("login_user");
		try 
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("functionval");
			if(operation.equals("modify"))
				modifyFMLostFoundFile(req, res, locale);
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
		catch(Exception e)	{ out.println("Exception in doGet method :"+e.toString());	}
	}

	private void modifyFMLostFoundFile(HttpServletRequest req, HttpServletResponse res, String locale)	
	{
		try 
		{
		
			res.setContentType("text/html");

			p_new_status		= req.getParameter("p_store_new_status");
			p_fs_location		= req.getParameter("p_store_fs_location");
			p_updated_by		= req.getParameter("p_store_updated_by");
			p_file_no			= req.getParameter("p_store_file_no");
			p_doc_type_code		= req.getParameter("p_store_doc_type_code");
			p_doc_folder_id		= req.getParameter("p_store_doc_folder_id");
			p_file_type_code	= req.getParameter("p_store_file_type_code");
			p_volume_no         = req.getParameter("p_store_volume_no");
			p_remarks			= req.getParameter("p_remarks");
			src_fs_locn_code	= req.getParameter("src_fs_locn_code");
			src_locn_identity	= req.getParameter("src_locn_identity");
			src_user_id			= req.getParameter("src_user_id");
			patient_id			= req.getParameter("patient_id");
				
			changed_by			= req.getParameter("appl_user_id");
			curr_facility_id	= req.getParameter("curr_facility_id");
			p_locn_code	= req.getParameter("src_locn_code");
			NevertoArchive	= req.getParameter("NevertoArchive");
			db_archive_yn	= req.getParameter("archive_yn");


			if(NevertoArchive.equals("NA"))
			{
				archive_yn="N";
			}
			else if (p_new_status.equals("R"))
			{
				archive_yn="Y";
			}
			else
			{
				archive_yn=db_archive_yn;
			}

			

			if(p_remarks == null || p_remarks.equals("null")) p_remarks = "";
			if(p_new_status == null || p_new_status.equals("null"))p_new_status = "";
			if(p_fs_location == null || p_fs_location.equals("null"))p_fs_location = "";
			if(p_updated_by == null || p_updated_by.equals("null"))p_updated_by = "";
			if(p_file_no == null || p_file_no.equals("null"))p_file_no = "";
			if(p_doc_type_code == null || p_doc_type_code.equals("null")) p_doc_type_code = "";
			if(p_doc_folder_id == null || p_doc_folder_id.equals("null"))p_doc_folder_id = "";
			if(p_file_type_code == null || p_file_type_code.equals("null"))p_file_type_code = "";
			if(p_volume_no == null || p_volume_no.equals("null"))p_volume_no = "";
			if(src_fs_locn_code == null || src_fs_locn_code.equals("null"))src_fs_locn_code = "";
			if(src_locn_identity == null || src_locn_identity.equals("null"))src_locn_identity = "";
			if(src_user_id == null || src_user_id.equals("null"))src_user_id = "";
			if(patient_id == null || patient_id.equals("null"))patient_id = "";
			if(changed_by == null || changed_by.equals("null")) changed_by = "";
			if(curr_facility_id == null || curr_facility_id.equals("null")) curr_facility_id = "";
			if(p_locn_code == null || p_locn_code.equals("null")) p_locn_code = "";
			
			if(src_locn_identity.equals("D")) src_mr_locn_yn = "Y";
			else src_mr_locn_yn = "N";

			Properties propData = new Properties();
			HashMap htRecord    = new HashMap();
			
			if(p_updated_by.equals(""))
			{
			p_updated_by=login_user_id;
			}
			propData.put("src_fs_locn_code"		, src_fs_locn_code);	
			propData.put("src_locn_identity"	, src_locn_identity);	 
			propData.put("src_user_id"			, src_user_id);
			propData.put("src_mr_locn_yn"		, src_mr_locn_yn);
			propData.put("patient_id"			, patient_id);
			propData.put("curr_facility_id"		, curr_facility_id);
			
			htRecord.put("p_new_status", p_new_status);
			htRecord.put("p_fs_location", p_fs_location);
			htRecord.put("p_updated_by", p_updated_by);
			htRecord.put("p_file_no", p_file_no);
			htRecord.put("p_remarks", p_remarks);
			htRecord.put("facilityId", facilityId);
			htRecord.put("changed_by", changed_by);
			htRecord.put("addedAtWorkstation", client_ip_address);
			htRecord.put("p_file_type_code", p_file_type_code);
			htRecord.put("p_volume_no", p_volume_no);
			htRecord.put("p_doc_folder_id", p_doc_folder_id);
			htRecord.put("p_doc_type_code", p_doc_type_code);
			htRecord.put("p_locn_code", p_locn_code);
			htRecord.put("locale", locale);
			htRecord.put("archive_yn", archive_yn);
			
			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FMLostFoundFile",LostFoundFileHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
			Object argArray[] = new Object[3];
			argArray[0] = p;
			argArray[1] = propData;
			argArray[2] = htRecord;

			Class [] paramArray = new Class[3];
			paramArray[0] = p.getClass();
			paramArray[1] = propData.getClass();
			paramArray[2] = htRecord.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertLostFoundFile",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error = (String) results.get("error") ;
			String error_value = "0" ;
			htRecord.clear();
			results.clear();

			if(inserted)
			{
				error_value = "1" ;
			}
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" +error_value );
			
		} 
		catch(Exception e) 
		{
			out.println(e.getMessage());
			out.println(e.toString());
		}
	}
}
