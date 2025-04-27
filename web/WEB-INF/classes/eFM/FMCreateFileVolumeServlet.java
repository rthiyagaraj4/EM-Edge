/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*****  by - Meghanath. *****/
package eFM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;


public class FMCreateFileVolumeServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	Properties p;
	
	String file_no = "",p_file_no = "",file_type_code = "",p_file_type_code = "";
	String patient_id = "";
	
	String new_volume_no			= "";
	String volume_no				= "";
	String facility_id				= "";
	String iss_date_time			= "";
	String curr_file_status			= "";
	String curr_fs_locn_code		= "";
	String curr_fs_locn_identity	= "";
	String curr_holder_user_id		= "";
	String narration_code			= "";
	String last_movement_date_time  = "";
	String return_date_time			= "";
	String prev_facility_id			= "";
	String prev_fs_locn_code		= "";
	String mr_locn_yn				= "";
	String remarks					= "";
	String req_remarks				= "";
	String curr_locn_id			    = "";
	String prev_locn_id			    = "";
	String nia_return_date		    = "";
	String perm_fs_locn_code	    = "";
	String req_practitioner_id	    = "";
	String terminal_digit		    = "";

	String client_ip_address	= "";
	String file_type_appl_yn	= "";
	String criteria				= "";
	String mysql				= "";
	String table_name			= "";
	String locale			= "" ;
    String curr_facility_id="";
	HttpSession session;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		Connection con			= null;
		Statement stmt			= null;
		ResultSet rst			= null;
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");

		session						= req.getSession(false);
		this.p							= (Properties) session.getValue("jdbc") ;
		locale = p.getProperty("LOCALE");
		this.facility_id				= (String) session.getValue("facility_id") ;
		this.client_ip_address	= p.getProperty("client_ip_address");
		
		this.out = res.getWriter();
		try
		{	
			table_name			= "FM_CURR_LOCN";

			patient_id			= checkForNull(req.getParameter("patient_id"));
			p_file_no			= checkForNull(req.getParameter("p_file_no"));
			p_file_type_code	= checkForNull(req.getParameter("p_file_type_code"));
			volume_no			= checkForNull(req.getParameter("volume_no"));
			new_volume_no		= checkForNull(req.getParameter("new_volume_number"));
			file_type_appl_yn	= checkForNull(req.getParameter("file_type_appl_yn"));
						
			if(file_type_appl_yn.equals("Y")) 
			{
				criteria = " AND file_type_code = '"+p_file_type_code+"' ";
			}

			mysql = "SELECT file_no,file_type_code,curr_facility_id,to_char(iss_date_time,'dd/mm/yyyy hh24:mi') iss_date_time,curr_file_status,curr_fs_locn_code,curr_fs_locn_identity,curr_holder_user_id,narration_code,to_char(last_movement_date_time,'dd/mm/yyyy hh24:mi')  last_movement_date_time,to_char(return_date_time,'dd/mm/yyyy hh24:mi')  return_date_time,prev_facility_id,prev_fs_locn_code,mr_locn_yn,remarks,req_remarks,curr_locn_id,prev_locn_id,to_char(nia_return_date,'dd/mm/yyyy hh24:mi') nia_return_date,perm_fs_locn_code,req_practitioner_id,perm_fs_locn_code,terminal_digit FROM fm_curr_locn WHERE facility_id = '"+facility_id+"' AND patient_id = '"+patient_id+"' AND file_no = '"+p_file_no+"'  "+criteria+" AND volume_no = '"+volume_no+"' "; 
			
			con	 = ConnectionManager.getConnection(req);
			stmt = con.createStatement();
			rst  = stmt.executeQuery(mysql);
	
			while(rst != null && rst.next())
			{
				file_no					= checkForNull(rst.getString("file_no"));
				file_type_code			= checkForNull(rst.getString("file_type_code"));
				iss_date_time			= checkForNull(rst.getString("iss_date_time"));
				curr_file_status		= checkForNull(rst.getString("curr_file_status"));
				curr_fs_locn_code		= checkForNull(rst.getString("curr_fs_locn_code"));
				curr_fs_locn_identity	= checkForNull(rst.getString("curr_fs_locn_identity"));
				curr_holder_user_id		= checkForNull(rst.getString("curr_holder_user_id"));
				narration_code			= checkForNull(rst.getString("narration_code"));
				last_movement_date_time = checkForNull(rst.getString("last_movement_date_time"));
				return_date_time		= checkForNull(rst.getString("return_date_time"));
				prev_facility_id		= checkForNull(rst.getString("prev_facility_id"));
				curr_facility_id		= checkForNull(rst.getString("curr_facility_id"));
				prev_fs_locn_code		= checkForNull(rst.getString("prev_fs_locn_code"));
				mr_locn_yn				= checkForNull(rst.getString("mr_locn_yn"));
				remarks					= checkForNull(rst.getString("remarks"));
				req_remarks				= checkForNull(rst.getString("req_remarks"));
				curr_locn_id			= checkForNull(rst.getString("curr_locn_id"));
				prev_locn_id			= checkForNull(rst.getString("prev_locn_id"));
				nia_return_date			= checkForNull(rst.getString("nia_return_date"));
				perm_fs_locn_code		= checkForNull(rst.getString("perm_fs_locn_code"));
				req_practitioner_id		= checkForNull(rst.getString("req_practitioner_id"));
				terminal_digit			= checkForNull(rst.getString("terminal_digit"));
			}
				
			modifyFMFileVolume(req, res, locale);
			insertFMFileVolume(req, res, locale);
			
			if(rst   != null) rst.close();
			if(stmt != null) stmt.close();

		}catch(Exception e2)
		{
			out.println("Excwption in doPost e2 :"+e2.toString());
			e2.printStackTrace();
		}
		finally
		{
				ConnectionManager.returnConnection(con,req);
		}
	}

	void modifyFMFileVolume(HttpServletRequest req, HttpServletResponse res, String locale)
	{
		try
		{
			String addedById				= p.getProperty("login_user");
			String modifiedById				= addedById;
			String addedFacilityId			= facility_id;
			String modifiedFacilityId		= addedFacilityId;
			String addedAtWorkstation		= client_ip_address;
			String modifiedAtWorkstation	= addedAtWorkstation;

			HashMap tabdata	= new HashMap();
			
			tabdata.put("VOLUME_STATUS"         , "I");
			tabdata.put("MODIFIED_BY_ID"		, modifiedById);
			tabdata.put("MODIFIED_DATE"			, new java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID"	, modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO"		, modifiedAtWorkstation);
		//	tabdata.put("language_id"		, locale);
						
			HashMap condflds = new HashMap();

			condflds.put("FACILITY_ID"	, facility_id);
			condflds.put("PATIENT_ID"	, patient_id);
			condflds.put("FILE_NO"		, file_no);
			condflds.put("VOLUME_NO"	, volume_no);

			if(file_type_appl_yn.equals("Y"))
			{
				condflds.put("FILE_TYPE_CODE"	, file_type_code);
			}
			
			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			
			Object home   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];

			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = table_name;
					
			Class [] paramArray = new Class[4];

			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = table_name.getClass();
						
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = (((Boolean) results.get("status")).booleanValue()) ;
			String error	 = (String) results.get("error") ;		
			String error_value = "0";
			tabdata.clear();
			condflds.clear();
			results.clear();

			if(inserted)
			{
				error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			}	
			else
			{				
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(error,"UTF-8" ) );
			}
		} catch(Exception e){
			out.println("Exception raised in modifyFMFileVolume method :"+e.toString());
			e.printStackTrace();
		}
	}

    void insertFMFileVolume(HttpServletRequest req, HttpServletResponse res, String locale)
	{
		try
		{
			String addedById				= p.getProperty("login_user");
			String modifiedById				= addedById;
			String addedFacilityId			= facility_id;
			String modifiedFacilityId		= addedFacilityId;
			String addedAtWorkstation		= client_ip_address;
			String modifiedAtWorkstation	= addedAtWorkstation;

			HashMap tabdata = new HashMap();
			
		if(curr_file_status.equals("O") && !curr_facility_id.equals(facility_id))
			{
			iss_date_time="";
			}
			
		
			if(iss_date_time != null && !iss_date_time.equals(""))
			{
				Timestamp iss_datetime = StringTODate(iss_date_time);
				tabdata.put("ISS_DATE_TIME", iss_datetime); 
			}
			else 
			{
				tabdata.put("ISS_DATE_TIME", iss_date_time); 
			}
			
			if(last_movement_date_time != null && !last_movement_date_time.equals(""))
			{
				Timestamp last_movementdatetime = StringTODate(last_movement_date_time);
				tabdata.put("LAST_MOVEMENT_DATE_TIME", last_movementdatetime); 
			}
			else
			{
				tabdata.put("LAST_MOVEMENT_DATE_TIME", last_movement_date_time); 
			}
			
			if(return_date_time != null && !return_date_time.equals(""))
			{
				Timestamp return_datetime = StringTODate(return_date_time);
				if(curr_file_status.equals("O") && curr_facility_id.equals(facility_id))
			{
				tabdata.put("RETURN_DATE_TIME", return_datetime); 
			}else{
               
			  tabdata.put("RETURN_DATE_TIME","");
			  }
			
			}
			else
			{
				tabdata.put("RETURN_DATE_TIME", return_date_time); 
			}
			if(nia_return_date != null && !nia_return_date.equals(""))
			{
				Timestamp nia_returndate = StringTODate(nia_return_date);
				tabdata.put("NIA_RETURN_DATE", nia_returndate); 
			}
			else
			{
				tabdata.put("NIA_RETURN_DATE", nia_return_date); 
			}

			tabdata.put("FACILITY_ID"			, facility_id);
			tabdata.put("PATIENT_ID"			, patient_id);
			tabdata.put("FILE_NO"				, file_no);
			tabdata.put("FILE_TYPE_CODE"		, file_type_code);
			tabdata.put("VOLUME_NO"				, new_volume_no);
			tabdata.put("VOLUME_STATUS"			, "A");
			if(curr_file_status.equals("O") && curr_facility_id.equals(facility_id))
			{
			tabdata.put("CURR_FILE_STATUS"		, curr_file_status);
			}else{
			tabdata.put("CURR_FILE_STATUS"		, "I");
			}
			if(curr_file_status.equals("O") && curr_facility_id.equals(facility_id))
			{
			tabdata.put("CURR_FS_LOCN_CODE"		, curr_fs_locn_code);
			}else{
			tabdata.put("CURR_FS_LOCN_CODE"		, perm_fs_locn_code);
			}
			tabdata.put("CURR_FS_LOCN_IDENTITY"	, curr_fs_locn_identity);
			tabdata.put("CURR_HOLDER_USER_ID"	, curr_holder_user_id);
			tabdata.put("NARRATION_CODE"		, narration_code);
			tabdata.put("PREV_FACILITY_ID"		, prev_facility_id);
			//tabdata.put("PREV_FS_LOCN_CODE"		, prev_fs_locn_code);
			tabdata.put("PREV_FS_LOCN_CODE"		, "");
			tabdata.put("MR_LOCN_YN"			, mr_locn_yn);
			tabdata.put("REMARKS"				, remarks);
			tabdata.put("REQ_REMARKS"			, req_remarks);
			tabdata.put("CURR_LOCN_ID"			, curr_locn_id);
			tabdata.put("PREV_LOCN_ID"			, prev_locn_id);
			tabdata.put("PERM_FS_LOCN_CODE"		, perm_fs_locn_code);
			tabdata.put("REQ_PRACTITIONER_ID"	, req_practitioner_id);
			tabdata.put("TERMINAL_DIGIT"		, terminal_digit);
			
			tabdata.put("ADDED_BY_ID"			, addedById);
			tabdata.put("ADDED_DATE"			, new java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID"		, facility_id);
			if(curr_file_status.equals("O") && curr_facility_id.equals(facility_id))
			{
			tabdata.put("CURR_FACILITY_ID"	,curr_facility_id);
			}else{
               tabdata.put("CURR_FACILITY_ID"	, facility_id);
            }
			tabdata.put("ADDED_AT_WS_NO"		, addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID"		, modifiedById);
			tabdata.put("MODIFIED_DATE"			, new java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID"	, modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO"		, modifiedAtWorkstation );
			//tabdata.put("language_id"		, locale );

			String dupflds[] = null;

			if(file_type_appl_yn.equals("N"))
			{
				dupflds = new String[3];

				dupflds[0] = "FACILITY_ID";
				dupflds[1] = "FILE_NO";
				dupflds[2] = "VOLUME_NO";
			}
			else if(file_type_appl_yn.equals("Y"))
			{
				dupflds = new String[4];

				dupflds[0] = "FACILITY_ID";
				dupflds[1] = "FILE_NO";
				dupflds[2] = "VOLUME_NO";
				dupflds[3] = "FILE_TYPE_CODE";
			}
						
			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			
			Object home   = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
									
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = table_name;
					
			Class [] paramArray = new Class[4];
						
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = table_name.getClass();
						
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = (((Boolean) results.get( "status" )).booleanValue()) ;
			String error = (String) results.get("error") ;		
			String error_value ="0";
			tabdata.clear();
			results.clear();
			if ( inserted )
			{
				error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			}	
			else
			{				
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) );
			}
		} catch(Exception e){
			out.println("Exception raise in insertFMFileVolume method :"+e.toString());
			e.printStackTrace();
		}
	}
	public static Timestamp StringTODate(String StrDate)
	{
		String strEndTime = StrDate.substring(StrDate.indexOf(" "),StrDate.length());
		StrDate = StrDate.substring(0,StrDate.indexOf(" "));
			
		StringTokenizer token = new StringTokenizer(StrDate,"/");
		String array[] = new String[3] ;
		for( int b=0;b<3;b++ )
		{        
			if(token.hasMoreTokens()) 
			{
				array[b] = token.nextToken();
			}
		}
		StrDate = array[2] + "-" + array[1] + "-" + array[0];
		StrDate = StrDate+strEndTime+":00";
		Timestamp convertedDate = Timestamp.valueOf(StrDate);
		return convertedDate;
	}
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
}
