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

import eCommon.SingleTabHandler.*;

public class FMParameterServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;	
	java.util.Properties p;

	String p_user_security_yn		= "";
	String p_print_tr_card_yn		= "";
	String p_fs_to_fs_locn_yn		= "";
	String p_auto_rec_ward_yn		= "";
	String p_auto_rec_clinic_yn		= "";
	String p_auto_rec_daycare_yn	= "";
	String p_auto_rec_procedure_yn	= "";
	String p_auto_rec_pract_yn		= "";
	String p_auto_rec_dept_yn		= "";
	String p_auto_rec_ext_yn		= "";
	String p_inactive_locn			= "";
	String p_lost_locn				= "";
	String p_fs_locn				= "";
	String p_narr_auto_track		= "";
	String p_narr_file_return		= "";
	String p_no_of_days				= "";
	String p_files_icd_yn			= "";
	String p_dflt_incomplete_fs_locn_code		= "";
	//String p_dflt_admission_fs_locn_code		= "";
	String p_no_days_check_book_inquiry		= "";
	String pull_list_gen_by_gender		= "";
	String p_link_bet_file_and_enctr_yn =""; //dm 14th June
	String accept_out_intransit_yn =""; 
	String autotrack_upon_confirm_pl_yn =""; // added to perform Auto Track out upon Confirming the Pulling List.
	String enable_Monitor_FDefFSL_yn = "";

	String facilityId ;
	String client_ip_address ;		
	String locale			= "" ;
	
	/*Below Line Added for this CRF [SKR-CRF-0012]*/
	String auto_check_patient_file_request="";
	
	String issue_file_refresh_interval	= "";/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 17th 2014*/
	
	HttpSession session;	

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";
		p = (Properties) session.getValue("jdbc");
		locale = p.getProperty("LOCALE");
		client_ip_address = p.getProperty("client_ip_address");

		try
		{
			this.out = res.getWriter();
			String operation = req.getParameter("functionval");
			

			if ( operation.equals("insert") )		insertFMParameter(req, res, locale);
			if ( operation.equals("modify"))		modifyFMParameter(req, res, locale);
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
	try	{
	this.out = res.getWriter();
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = req.getQueryString() ;
	String source = url + params ;
	out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eSM/js/SiteParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='" + source + "' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eSM/jsp/SiteBlank.jsp' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html>");
	}
	catch(Exception e)	
	{
		out.println("Exception in doGet method :"+e.toString());
		e.printStackTrace();
	}
	}

	private void insertFMParameter(HttpServletRequest req, HttpServletResponse res,String locale)
	{
		try
		{
			p_user_security_yn		= req.getParameter("security_appl_to_users_yn");
			p_print_tr_card_yn		= req.getParameter("print_tracer_card_yn");
			p_fs_to_fs_locn_yn		= req.getParameter("rest_movement_yn");
			p_auto_rec_ward_yn		= req.getParameter("nursing_unit_yn");
			p_auto_rec_clinic_yn	= req.getParameter("clinic_yn");
			p_auto_rec_daycare_yn	= req.getParameter("daycare_yn");
			p_auto_rec_procedure_yn	= req.getParameter("procedure_yn");
			p_auto_rec_pract_yn		= req.getParameter("practitioner_yn");
			p_auto_rec_dept_yn		= req.getParameter("department_yn");
			p_auto_rec_ext_yn		= req.getParameter("external_yn");
			p_inactive_locn			= req.getParameter("inactive_code");
			p_lost_locn				= req.getParameter("lost_code");
			p_fs_locn				= req.getParameter("mrd_code");
			p_narr_auto_track		= req.getParameter("auto_track_narr_code");
			p_narr_file_return		= req.getParameter("return_files_mr_code");
			p_no_of_days			= req.getParameter("no_of_days_notes_inquiry");
			p_files_icd_yn			= req.getParameter("return_of_files_yn");
			pull_list_gen_by_gender	= req.getParameter("pull_list_gen_by_gender");
			p_dflt_incomplete_fs_locn_code	= req.getParameter("dflt_incomplete_fs_locn_code");
			//p_dflt_admission_fs_locn_code	= req.getParameter("dflt_admission_fs_locn_code");
			p_no_days_check_book_inquiry	= req.getParameter("no_days_check_book_inquiry");
			p_link_bet_file_and_enctr_yn    = req.getParameter("link_bet_file_and_enctr_yn"); // dm from FMParamAddModify.jsp
			accept_out_intransit_yn    = req.getParameter("accept_out_intransit_yn"); 
			autotrack_upon_confirm_pl_yn    = req.getParameter("autotrack_upon_confirm_pl_yn"); 
			enable_Monitor_FDefFSL_yn     = req.getParameter("enable_Monitor_FDefFSL_yn"); 
			/*Below Line Added for this CRF [SKR-CRF-0012]*/
	        auto_check_patient_file_request=req.getParameter("auto_chk_patient_file_request"); 
	        issue_file_refresh_interval		= req.getParameter("issue_file_refresh_interval");/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 17th 2014*/

			if (p_user_security_yn==null)
				p_user_security_yn="N";
			if (p_print_tr_card_yn==null)
				p_print_tr_card_yn="N";
			if (p_fs_to_fs_locn_yn==null)
				p_fs_to_fs_locn_yn="N";
			if (p_auto_rec_ward_yn==null)
				p_auto_rec_ward_yn="N";
			if (p_auto_rec_clinic_yn==null)
				p_auto_rec_clinic_yn="N";
			if (p_auto_rec_daycare_yn==null)
				p_auto_rec_daycare_yn="N";
			if (p_auto_rec_procedure_yn==null)
				p_auto_rec_procedure_yn="N";
			if (p_auto_rec_pract_yn==null)
				p_auto_rec_pract_yn="N";
			if (p_auto_rec_dept_yn==null)
				p_auto_rec_dept_yn="N";
			if (p_auto_rec_ext_yn==null)
				p_auto_rec_ext_yn="N";
			if (p_files_icd_yn==null)
				p_files_icd_yn="N";
			if (p_no_of_days==null)
				p_no_of_days="";
			if (pull_list_gen_by_gender==null)
				pull_list_gen_by_gender="N";			
			if (p_link_bet_file_and_enctr_yn==null)
				p_link_bet_file_and_enctr_yn="N";	
			if(accept_out_intransit_yn==null)
				accept_out_intransit_yn="N";

			if(accept_out_intransit_yn==null)
				accept_out_intransit_yn="N";

			if(p_dflt_incomplete_fs_locn_code==null)
			p_dflt_incomplete_fs_locn_code="";
			
			if(autotrack_upon_confirm_pl_yn == null)
				autotrack_upon_confirm_pl_yn="N";
			
			if(enable_Monitor_FDefFSL_yn==null)
			enable_Monitor_FDefFSL_yn="N";
			
			/*Below Line Added for this CRF [SKR-CRF-0012]*/
	        if(auto_check_patient_file_request==null)
			auto_check_patient_file_request="N";
	        
	        /*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 17th 2014 Start*/
	        if(issue_file_refresh_interval==null)
	        	issue_file_refresh_interval="";
	        /*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 17th 2014 End*/
	       
			
			if (p_no_days_check_book_inquiry==null||p_no_days_check_book_inquiry=="")
				p_no_days_check_book_inquiry="0";

			String addedById = p.getProperty( "login_user" ) ;	
			String modifiedById = addedById ;	
			String addedFacilityId=facilityId;	
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			Timestamp  ts= new Timestamp(System.currentTimeMillis() );

			HashMap tabdata=new HashMap();

			tabdata.put("facility_id",addedFacilityId);
			tabdata.put("user_security_yn",p_user_security_yn);
			tabdata.put("print_tr_card_iss_from_mr_yn",p_print_tr_card_yn);
			tabdata.put("transfer_file_yn",p_fs_to_fs_locn_yn);
			tabdata.put("auto_rec_ward_yn",p_auto_rec_ward_yn);
			tabdata.put("auto_rec_clinic_yn",p_auto_rec_clinic_yn);
			tabdata.put("auto_rec_daycare_yn",p_auto_rec_daycare_yn);
			tabdata.put("auto_rec_procedure_yn",p_auto_rec_procedure_yn);
			tabdata.put("auto_rec_pract_yn",p_auto_rec_pract_yn);
			tabdata.put("auto_rec_dept_yn",p_auto_rec_dept_yn);
			tabdata.put("auto_rec_external_yn",p_auto_rec_ext_yn);
			tabdata.put("dflt_archive_fs_locn_code",p_inactive_locn);
			tabdata.put("dflt_lost_fs_locn_code",p_lost_locn);
			tabdata.put("dflt_fs_locn_code",p_fs_locn);
			tabdata.put("dflt_narr_code_for_auto_track",p_narr_auto_track);
			tabdata.put("dflt_narr_code_for_note_rtn",p_narr_file_return);
			tabdata.put("no_days_check_appt_inquiry",p_no_of_days);
			tabdata.put("files_icd_confirm_yn",p_files_icd_yn);
			tabdata.put("pull_list_gen_by_gender",pull_list_gen_by_gender);
			tabdata.put("dflt_incomplete_fs_locn_code",p_dflt_incomplete_fs_locn_code);
			//tabdata.put("dflt_admission_fs_locn_code",p_dflt_admission_fs_locn_code);
			tabdata.put("no_days_check_book_inquiry",p_no_days_check_book_inquiry);
			tabdata.put("LINK_BET_FILE_AND_ENCTR_YN",p_link_bet_file_and_enctr_yn);
			tabdata.put("accept_out_intransit_yn",accept_out_intransit_yn);
			tabdata.put("autotrack_upon_confirm_pl_yn",autotrack_upon_confirm_pl_yn);
			tabdata.put("mntr_fldfcy_inc_fslocn_ntdf_yn",enable_Monitor_FDefFSL_yn);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",ts);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("added_facility_id",addedFacilityId);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",ts);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("modified_facility_id",addedFacilityId );
			
			/*Below Line Added for this CRF [SKR-CRF-0012]*/			
			tabdata.put("auto_check_pat_file_request",auto_check_patient_file_request);
			tabdata.put("issue_file_refresh_interval",issue_file_refresh_interval);/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 17th 2014*/

			//tabdata.put("locale",locale );
//System.out.println("tabdata---->"+tabdata);
			String dupflds[]={"facility_id"};
			String table_name ="fm_parameter";
	try{
			boolean local_ejbs = false;
				if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
					
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
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
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			tabdata.clear();
	   
			if ( inserted )
			{
				 error_value = "1" ;
			}
			else
			{
				 error = (String) results.get("error") ;
			}
        	error = (String) results.get("error") ;
			results.clear();
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
		}
		catch (Exception e)
			{
				out.println("From Servlet--Calling EJB:"+e);
				e.printStackTrace();
			}
	}
	catch ( Exception e )
	{
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());		
	}
}

private void modifyFMParameter(HttpServletRequest req, HttpServletResponse res, String locale)
{
	try
		{
			p_user_security_yn		= req.getParameter("security_appl_to_users_yn");
			p_print_tr_card_yn		= req.getParameter("print_tracer_card_yn");
			p_fs_to_fs_locn_yn		= req.getParameter("rest_movement_yn");
			p_auto_rec_ward_yn		= req.getParameter("nursing_unit_yn");
			p_auto_rec_clinic_yn	= req.getParameter("clinic_yn");
			p_auto_rec_daycare_yn	= req.getParameter("daycare_yn");
			p_auto_rec_procedure_yn	= req.getParameter("procedure_yn");
			p_auto_rec_pract_yn		= req.getParameter("practitioner_yn");
			p_auto_rec_dept_yn		= req.getParameter("department_yn");
			p_auto_rec_ext_yn		= req.getParameter("external_yn");
			p_inactive_locn			= req.getParameter("inactive_code");
			p_lost_locn				= req.getParameter("lost_code");
			p_fs_locn				= req.getParameter("mrd_code");
			p_narr_auto_track		= req.getParameter("auto_track_narr_code");
			p_narr_file_return		= req.getParameter("return_files_mr_code");
			p_no_of_days			= req.getParameter("no_of_days_notes_inquiry");
			p_files_icd_yn			= req.getParameter("return_of_files_yn");
			pull_list_gen_by_gender	= req.getParameter("pull_list_gen_by_gender");
			p_dflt_incomplete_fs_locn_code	= req.getParameter("dflt_incomplete_fs_locn_code");
			//p_dflt_admission_fs_locn_code	= req.getParameter("dflt_admission_fs_locn_code");
			p_no_days_check_book_inquiry	= req.getParameter("no_days_check_book_inquiry");
			p_link_bet_file_and_enctr_yn    = req.getParameter("link_bet_file_and_enctr_yn"); //dm from FMParamAddModify.jsp
			accept_out_intransit_yn    = req.getParameter("accept_out_intransit_yn"); 
			autotrack_upon_confirm_pl_yn    = req.getParameter("autotrack_upon_confirm_pl_yn"); 
			enable_Monitor_FDefFSL_yn     = req.getParameter("enable_Monitor_FDefFSL_yn");
			
			/*Below Line Added for this CRF [SKR-CRF-0012]*/
	        auto_check_patient_file_request=req.getParameter("auto_chk_patient_file_request"); 
	        
	        issue_file_refresh_interval		= req.getParameter("issue_file_refresh_interval");/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 17th 2014*/
			
			if(p_dflt_incomplete_fs_locn_code==null)
			p_dflt_incomplete_fs_locn_code="";

			if (p_user_security_yn==null)
				p_user_security_yn="N";
			if (p_print_tr_card_yn==null)
				p_print_tr_card_yn="N";
			if (p_fs_to_fs_locn_yn==null)
				p_fs_to_fs_locn_yn="N";
			if (p_auto_rec_ward_yn==null)
				p_auto_rec_ward_yn="N";
			if (p_auto_rec_clinic_yn==null)
				p_auto_rec_clinic_yn="N";
			if (p_auto_rec_daycare_yn==null)
				p_auto_rec_daycare_yn="N";
			if (p_auto_rec_procedure_yn==null)
				p_auto_rec_procedure_yn="N";
			if (p_auto_rec_pract_yn==null)
				p_auto_rec_pract_yn="N";
			if (p_auto_rec_dept_yn==null)
				p_auto_rec_dept_yn="N";
			if (p_auto_rec_ext_yn==null)
				p_auto_rec_ext_yn="N";
			if (p_files_icd_yn==null)
				p_files_icd_yn="N";
			if (p_no_of_days==null)
				p_no_of_days="";
			if (pull_list_gen_by_gender==null)
				pull_list_gen_by_gender="N";
			if (p_link_bet_file_and_enctr_yn==null)
				p_link_bet_file_and_enctr_yn="N";
			if(accept_out_intransit_yn == null)
				accept_out_intransit_yn="N";

			if(autotrack_upon_confirm_pl_yn == null)
				autotrack_upon_confirm_pl_yn="N";

			if(enable_Monitor_FDefFSL_yn==null)
			enable_Monitor_FDefFSL_yn="N";
			/*Below Line Added for this CRF [SKR-CRF-0012]*/
			if(auto_check_patient_file_request==null)
			auto_check_patient_file_request="N";

			/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 17th 2014 Start*/
			if(issue_file_refresh_interval==null)
				issue_file_refresh_interval="";
			/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 17th 2014 End*/
			
			if (p_no_days_check_book_inquiry==null||p_no_days_check_book_inquiry=="")
				p_no_days_check_book_inquiry="0";

			String addedById = p.getProperty( "login_user" ) ;	
			String modifiedById = addedById ;	
			String addedFacilityId=facilityId;	
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			Timestamp  ts= new Timestamp(System.currentTimeMillis() );

			HashMap tabdata=new HashMap();

			tabdata.put("facility_id",addedFacilityId);
			tabdata.put("user_security_yn",p_user_security_yn);
			tabdata.put("print_tr_card_iss_from_mr_yn",p_print_tr_card_yn);
			tabdata.put("transfer_file_yn",p_fs_to_fs_locn_yn);
			tabdata.put("auto_rec_ward_yn",p_auto_rec_ward_yn);
			tabdata.put("auto_rec_clinic_yn",p_auto_rec_clinic_yn);
			tabdata.put("auto_rec_daycare_yn",p_auto_rec_daycare_yn);
			tabdata.put("auto_rec_procedure_yn",p_auto_rec_procedure_yn);
			tabdata.put("auto_rec_pract_yn",p_auto_rec_pract_yn);
			tabdata.put("auto_rec_dept_yn",p_auto_rec_dept_yn);
			tabdata.put("auto_rec_external_yn",p_auto_rec_ext_yn);
			tabdata.put("dflt_archive_fs_locn_code",p_inactive_locn);
			tabdata.put("dflt_lost_fs_locn_code",p_lost_locn);
			tabdata.put("dflt_fs_locn_code",p_fs_locn);
			tabdata.put("dflt_narr_code_for_auto_track",p_narr_auto_track);
			tabdata.put("dflt_narr_code_for_note_rtn",p_narr_file_return);
			tabdata.put("no_days_check_appt_inquiry",p_no_of_days);
			tabdata.put("files_icd_confirm_yn",p_files_icd_yn);
			tabdata.put("pull_list_gen_by_gender",pull_list_gen_by_gender);
			tabdata.put("dflt_incomplete_fs_locn_code",p_dflt_incomplete_fs_locn_code);
			//tabdata.put("dflt_admission_fs_locn_code",p_dflt_admission_fs_locn_code);
			tabdata.put("no_days_check_book_inquiry",p_no_days_check_book_inquiry);
			tabdata.put("LINK_BET_FILE_AND_ENCTR_YN",p_link_bet_file_and_enctr_yn);
			tabdata.put("accept_out_intransit_yn",accept_out_intransit_yn);
			tabdata.put("autotrack_upon_confirm_pl_yn",autotrack_upon_confirm_pl_yn);
			tabdata.put("mntr_fldfcy_inc_fslocn_ntdf_yn",enable_Monitor_FDefFSL_yn);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",ts);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("modified_facility_id",addedFacilityId );
			
			/*Below Line Added for this CRF [SKR-CRF-0012]*/
			tabdata.put("auto_check_pat_file_request",auto_check_patient_file_request);
			tabdata.put("issue_file_refresh_interval",issue_file_refresh_interval);/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 17th 2014*/
			
			//tabdata.put("locale",locale );

			HashMap condflds=new HashMap();
			condflds.put("facility_id",addedFacilityId);
			String table_name ="fm_parameter";

			boolean local_ejbs = false;
				if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
					
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
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
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			tabdata.clear();
			condflds.clear();

			if ( inserted )
			{
				 error_value = "1" ;
			}
			else
			{
				 error = (String) results.get("error") ;
			}

        	error = (String) results.get("error") ;
			results.clear();
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();
		out.println( p_user_security_yn+p_print_tr_card_yn+p_fs_to_fs_locn_yn+p_auto_rec_ward_yn+p_auto_rec_clinic_yn+p_auto_rec_pract_yn+	
		p_auto_rec_dept_yn+p_auto_rec_ext_yn+p_inactive_locn+p_lost_locn+p_fs_locn+p_narr_auto_track+p_narr_file_return+p_no_of_days+p_files_icd_yn);
		}
	}	
}
