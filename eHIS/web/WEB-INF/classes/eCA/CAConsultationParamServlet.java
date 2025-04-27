/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        	Review			Date 		Description							
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created
21/07/2016		IN052254		Ramesh G										MMS-QH-CRF-0204			
--------------------------------------------------------------------------------------------------------------------
*/
package eCA;


import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.Date.*;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class CAConsultationParamServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException	
    {
	   super.init(config);
    }
		public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws javax.servlet.ServletException,IOException
	{

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out			= null;		
		String client_ip_address	= "";
		String locale				= "";
		String mode					= "";

		String added_by_id = "";
		String added_at_ws_no = "";
		String added_facility_id = "";
		String modified_by_id = "";
		String modified_at_ws_no = "";
		String modified_facility_id = "";
		String errorMsg				= "";
		String error_value			= "";
		//String error = "";
		String max_consultation_practitioner = "";
		String back_date_consultation = "";
		String max_consultation_speciality = "";
		String amend_consultation_list = "";
		String min_duration_recquired = "";

		String reg_consult = "";
		String ref_consult = "";

		String mngPatQueue = "";
		String CAPatByLocn = "";
		
		String mngType = "";
		String CAType = "";

		String caRestUnBilled = ""; //IN052254
		String ae_curr_emr_patient = "";
		String ae_curr_emr_patient_chart_type = "";
		String ae_ca_patlist_by_locn = "";
		String ae_patlist_by_locn_chart_type = "";

		String sql = "";

		boolean bUpdated			= true;

		HttpSession session = request.getSession(false);
		
		Hashtable htResMesg = new Hashtable();
		Properties p;

		p				= (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address				= (String) p.getProperty("client_ip_address");
		locale							= (String) p.getProperty("LOCALE");
	    added_facility_id				= (String) session.getValue( "facility_id" ) ;
		

		PreparedStatement pstmt = null ;
		Connection con = null ;
		ResultSet rs = null;

		modified_by_id      = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
		modified_facility_id = (added_facility_id==null)?"":added_facility_id;
		modified_at_ws_no   = (client_ip_address==null)?"":client_ip_address;
		added_by_id = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
		added_facility_id = (added_facility_id == null)?"":added_facility_id; 
		added_at_ws_no = (client_ip_address == null)?"":client_ip_address;

		max_consultation_practitioner = request.getParameter("max_consultation_practitioner")==null?"":request.getParameter("max_consultation_practitioner");
		back_date_consultation = request.getParameter("back_date_consultation")==null?"":request.getParameter("back_date_consultation");
		max_consultation_speciality = request.getParameter("max_consultation_speciality")==null?"":request.getParameter("max_consultation_speciality");
		amend_consultation_list = request.getParameter("amend_consultation_list")==null?"":request.getParameter("amend_consultation_list");
		min_duration_recquired = request.getParameter("min_duration_recquired")==null?"":request.getParameter("min_duration_recquired");
		mode = request.getParameter("mode")==null?"":request.getParameter("mode");


		max_consultation_practitioner		        =(max_consultation_practitioner.equals(""))?"":max_consultation_practitioner;
		back_date_consultation		        =(back_date_consultation.equals(""))?"":back_date_consultation;
		max_consultation_speciality		        =(max_consultation_speciality.equals(""))?"":max_consultation_speciality;
		amend_consultation_list		        =(amend_consultation_list.equals(""))?"":amend_consultation_list;
		min_duration_recquired		        =(min_duration_recquired.equals(""))?"":min_duration_recquired;
	
		reg_consult = request.getParameter("reg_consult")==null?"":request.getParameter("reg_consult");
		ref_consult = request.getParameter("ref_consult")==null?"":request.getParameter("ref_consult");

		mngPatQueue = request.getParameter("managePatQueue")==null?"":request.getParameter("managePatQueue");
		CAPatByLocn = request.getParameter("CAPatByLocn")==null?"":request.getParameter("CAPatByLocn");
		mngType = request.getParameter("mngType")==null?"":request.getParameter("mngType");
		CAType = request.getParameter("CAType")==null?"":request.getParameter("CAType");		
		caRestUnBilled = request.getParameter("caRestUnBilled")==null?"N":request.getParameter("caRestUnBilled");		 //IN052254
		ae_curr_emr_patient = request.getParameter("aemanagePatQueue")==null?"N":request.getParameter("aemanagePatQueue");
		ae_curr_emr_patient_chart_type = request.getParameter("aemngType")==null?"N":request.getParameter("aemngType");
		ae_ca_patlist_by_locn = request.getParameter("aeCAPatByLocn")==null?"N":request.getParameter("aeCAPatByLocn");
		ae_patlist_by_locn_chart_type = request.getParameter("aeCAType")==null?"N":request.getParameter("aeCAType");
		try 
		{

			if(mode.equals("insert"))
			{
				//IN052254 Start.
		        //sql = "INSERT INTO CA_CONS_PARAM (MAX_CONS_PER_PRACT,MAX_CONS_PER_SPLTY,CONS_BACK_DATE,AMD_CONS_LIST,MIN_CONS_DURATION,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,MAX_REGULAR_CONS,MAX_REFERRAL_CONS,mng_pat_queue,ca_patlist_by_locn,ca_patlist_by_locn_chart_type,MNG_PAT_QUEUE_chart_type)values (?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?)";
				//sql = "INSERT INTO CA_CONS_PARAM (MAX_CONS_PER_PRACT,MAX_CONS_PER_SPLTY,CONS_BACK_DATE,AMD_CONS_LIST,MIN_CONS_DURATION,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,MAX_REGULAR_CONS,MAX_REFERRAL_CONS,mng_pat_queue,ca_patlist_by_locn,ca_patlist_by_locn_chart_type,MNG_PAT_QUEUE_chart_type,CA_REST_UNBILLED_PATIENT)values (?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?)";//Commented for IN065070
				//IN052254 End.
				sql = "INSERT INTO CA_CONS_PARAM (MAX_CONS_PER_PRACT,MAX_CONS_PER_SPLTY,CONS_BACK_DATE,AMD_CONS_LIST,MIN_CONS_DURATION,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,MAX_REGULAR_CONS,MAX_REFERRAL_CONS,mng_pat_queue,ca_patlist_by_locn,ca_patlist_by_locn_chart_type,MNG_PAT_QUEUE_chart_type,CA_REST_UNBILLED_PATIENT,AE_CURR_EMR_PATIENT,AE_CURR_EMR_PATIENT_CHART_TYPE,AE_CA_PATLIST_BY_LOCN,AE_PATLIST_BY_LOCN_CHART_TYPE)values (?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?)";//Modified for IN065070
			}else if(mode.equals("modify")){
				//IN052254 Start.
				//sql = "update CA_CONS_PARAM set MAX_CONS_PER_PRACT = ? ,MAX_CONS_PER_SPLTY = ? ,CONS_BACK_DATE = ?,AMD_CONS_LIST = ?,MIN_CONS_DURATION = ?,ADDED_BY_ID = ?, ADDED_DATE = sysdate, ADDED_AT_WS_NO = ?, ADDED_FACILITY_ID = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?,MAX_REGULAR_CONS = ? ,MAX_REFERRAL_CONS = ?,mng_pat_queue = ?,ca_patlist_by_locn = ?,ca_patlist_by_locn_chart_type = ?,MNG_PAT_QUEUE_chart_type = ?";
				//sql = "update CA_CONS_PARAM set MAX_CONS_PER_PRACT = ? ,MAX_CONS_PER_SPLTY = ? ,CONS_BACK_DATE = ?,AMD_CONS_LIST = ?,MIN_CONS_DURATION = ?,ADDED_BY_ID = ?, ADDED_DATE = sysdate, ADDED_AT_WS_NO = ?, ADDED_FACILITY_ID = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?,MAX_REGULAR_CONS = ? ,MAX_REFERRAL_CONS = ?,mng_pat_queue = ?,ca_patlist_by_locn = ?,ca_patlist_by_locn_chart_type = ?,MNG_PAT_QUEUE_chart_type = ?,CA_REST_UNBILLED_PATIENT=?";//Commented for IN065070
				//IN052254 End.
				sql = "update CA_CONS_PARAM set MAX_CONS_PER_PRACT = ? ,MAX_CONS_PER_SPLTY = ? ,CONS_BACK_DATE = ?,AMD_CONS_LIST = ?,MIN_CONS_DURATION = ?,ADDED_BY_ID = ?, ADDED_DATE = sysdate, ADDED_AT_WS_NO = ?, ADDED_FACILITY_ID = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?,MAX_REGULAR_CONS = ? ,MAX_REFERRAL_CONS = ?,mng_pat_queue = ?,ca_patlist_by_locn = ?,ca_patlist_by_locn_chart_type = ?,MNG_PAT_QUEUE_chart_type = ?,CA_REST_UNBILLED_PATIENT=?,AE_CURR_EMR_PATIENT=?,AE_CURR_EMR_PATIENT_CHART_TYPE=?,AE_CA_PATLIST_BY_LOCN=?,AE_PATLIST_BY_LOCN_CHART_TYPE=?"; //Modified for IN065070
			 }
				out = response.getWriter();
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(sql) ;

	  
				 pstmt.setString(1, max_consultation_practitioner);
				 pstmt.setString(2, max_consultation_speciality);
				 pstmt.setString(3, back_date_consultation);			 
				 pstmt.setString(4, amend_consultation_list);
				 pstmt.setString(5, min_duration_recquired);
				 pstmt.setString(6, added_by_id);
				 pstmt.setString(7, client_ip_address);
				 pstmt.setString(8, added_facility_id);
				 pstmt.setString(9, added_by_id);
				 pstmt.setString(10, client_ip_address);
				 pstmt.setString(11, added_facility_id);
				 pstmt.setString(12, reg_consult );
				 pstmt.setString(13, ref_consult );
				 pstmt.setString(14, mngPatQueue );
				 pstmt.setString(15, CAPatByLocn );
				 pstmt.setString(16, CAType );
				 pstmt.setString(17, mngType );
				 pstmt.setString(18, caRestUnBilled ); //IN052254
				 pstmt.setString(19, ae_curr_emr_patient );//IN065070
				 pstmt.setString(20, ae_curr_emr_patient_chart_type );//IN065070
				 pstmt.setString(21, ae_ca_patlist_by_locn );//IN065070
				 pstmt.setString(22, ae_patlist_by_locn_chart_type );//IN065070
				 pstmt.executeUpdate();
			  
				if(pstmt!=null) pstmt.close();
			                   
				if(bUpdated)
				{	
					con.commit();
					htResMesg = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
					error_value = "1" ;
				}
				else
				{
					con.rollback();
					htResMesg = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
					error_value = "0";
				}
				
				errorMsg = (String)htResMesg.get("message");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) + "&err_value=" + error_value );
		}
		catch ( Exception e ) 
		{
			//out.println("Exception"+e.toString());//common-icn-0181
			e.printStackTrace(System.err);
		}
		finally
		{
 			try
			{
				if(rs != null) rs.close();
				if(pstmt!=null) pstmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace(System.err);
			}
			
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException 
	{
		doPost(request,response);
	}
}
