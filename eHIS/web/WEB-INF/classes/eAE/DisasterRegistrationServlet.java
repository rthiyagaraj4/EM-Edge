/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;

import eCommon.Common.CommonBean;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import blopin.*;
import blpatreg.*;
import eCommon.XSSRequestWrapper;

public class DisasterRegistrationServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel {

	PrintWriter out						= null ;
  	String pat_ser_grp_code				= "";
	String facility_id					= "";
	String male_adult_count				= "";
	String male_child_count				= "";
	String male_infant_count			= "";
	String female_adult_count			= "";
	String female_child_count			= "";
	String female_infant_count			= "";
	String unknown_adult_count			= "";
	String unknown_child_count			= "";
	String unknown_infant_count			= "";

	String male_adult_count_age_y		= "";
	String male_adult_count_age_m		= "0";
	String male_child_count_age_y		= "";
	String male_child_count_age_m		= "0";
	String male_infant_count_age_m		= "";
	String male_infant_count_age_d		= "";

	String female_adult_count_age_y		= "";
	String female_adult_count_age_m		= "0";
	String female_child_count_age_y		= "";
	String female_child_count_age_m		= "0";
	String female_infant_count_age_m	= "";
	String female_infant_count_age_d	= "";

	String unknown_adult_count_age_y	= "";
	String unknown_adult_count_age_m	= "0";
	String unknown_child_count_age_y	= "";
	String unknown_child_count_age_m	= "0";
	String unknown_infant_count_age_m	= "";
	String unknown_infant_count_age_d	= "";
		String	sStyle="";
	String visit_date					= "";
	String AddedFacilityID				= "";
	String AddedAtWsNo				    = "";
	String addedById					= "";
	String remarks						= "";
	String clinic_code					= "";
	String service_code					= "";
	String visit_type					= "";
	String arrival_mode					= "";
	String reasonforvisit				= "";
	String cancel						= "";
	String priority_zone				= "";
	String bl_interface_yn				= "";
	String bl_install_yn				= "";
	String billing_group                = "";
	String sex							= "";
	String Disaster_Reference		= "";
	String errors		= "";
	/*Added By Dharma Start*/
	String module_id					= "";
	String isVisitAdmTimeUpdate			= "Y";
	String isDowntimeRegnYn				= "N";
	String isDisasterRegnYn				= "N";
	/*Added By Dharma End*/

	String is_financial_captured		= "";

	HttpSession session				= null ;
	HttpServletResponse httpResponse	= null;
	//CallableStatement cs				= null;
	Connection con					= null;
	String V_NEXT_NUM ="";
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	int rs1 = 0;
	int no_pats = 0;
	int rsop = 0;
	boolean  result =false;
	String locale = "";
	Properties p = null;


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException  {

		this.httpResponse   = response;
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html;charset=UTF-8");
		request = new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		

		this.session        = request.getSession(false);
		facility_id         = (String)session.getValue("facility_id");
		this.out			= httpResponse.getWriter();
		module_id			= request.getParameter("module_id")==null?"AE":request.getParameter("module_id");

		priority_zone = request.getParameter("priority_zone")==null?"":request.getParameter("priority_zone");
		pat_ser_grp_code = request.getParameter("pat_ser_grp_code")==null?"":request.getParameter("pat_ser_grp_code");
		
		is_financial_captured = (request.getParameter("is_financial_captured")==null || request.getParameter("is_financial_captured").equals("")) ?"N":request.getParameter("is_financial_captured");


		male_adult_count = request.getParameter("adultmale");
		if((male_adult_count==null) || (male_adult_count.equals("null")) || (male_adult_count=="") || (male_adult_count.equals(""))) male_adult_count	= "0";

		male_child_count = request.getParameter("childmale");
		if((male_child_count==null) || (male_child_count.equals("null")) || (male_child_count=="") || (male_child_count.equals(""))) male_child_count	= "0";

		male_infant_count = request.getParameter("infantmale");
		if((male_infant_count==null) || (male_infant_count.equals("null")) || (male_infant_count=="") || (male_infant_count.equals(""))) male_infant_count	= "0";

		female_adult_count = request.getParameter("adultfemale");
		if((female_adult_count==null) || (female_adult_count.equals("null")) || (female_adult_count=="") || (female_adult_count.equals(""))) female_adult_count	= "0";

		female_child_count = request.getParameter("childfemale");
		if((female_child_count==null) || (female_child_count.equals("null")) || (female_child_count=="") || (female_child_count.equals(""))) female_child_count	= "0";

		female_infant_count = request.getParameter("infantfemale");
		if((female_infant_count==null) || (female_infant_count.equals("null")) || (female_infant_count=="") || (female_infant_count.equals(""))) female_infant_count	= "0";

		unknown_adult_count = request.getParameter("adultunknown");
		if((unknown_adult_count==null) || (unknown_adult_count.equals("null")) || (unknown_adult_count=="") || (unknown_adult_count.equals(""))) unknown_adult_count	= "0";

		unknown_child_count = request.getParameter("childunknown");
		if((unknown_child_count==null) || (unknown_child_count.equals("null")) || (unknown_child_count=="") || (unknown_child_count.equals(""))) unknown_child_count	= "0";

		unknown_infant_count = request.getParameter("infantunknown");
		if((unknown_infant_count==null) || (unknown_infant_count.equals("null")) || (unknown_infant_count=="") || (unknown_infant_count.equals(""))) unknown_infant_count	= "0";

		male_adult_count_age_y = request.getParameter("adultmaleage_y");
		if((male_adult_count_age_y==null) || (male_adult_count_age_y.equals("null")) || (male_adult_count_age_y=="") || (male_adult_count_age_y.equals(""))) male_adult_count_age_y	= "0";

		cancel = request.getParameter("cancel_mode");
		if((cancel==null) || (cancel.equals("null")) || (cancel=="") || (cancel.equals(""))) cancel	= "";

		male_child_count_age_y = request.getParameter("childmaleage_y");
	        if((male_child_count_age_y==null) || (male_child_count_age_y.equals("null")) || (male_child_count_age_y=="") || (male_child_count_age_y.equals(""))) male_child_count_age_y	= "0";

		male_child_count_age_m = request.getParameter("childmaleage_m");
		if((male_child_count_age_m==null) || (male_child_count_age_m.equals("null")) || (male_child_count_age_m=="") || (male_child_count_age_m.equals(""))) male_child_count_age_m	= "0";

		male_infant_count_age_m = request.getParameter("infantmaleage_m");
		if((male_infant_count_age_m==null) || (male_infant_count_age_m.equals("null")) || (male_infant_count_age_m=="") || (male_infant_count_age_m.equals(""))) male_infant_count_age_m	= "0";

		male_infant_count_age_d = request.getParameter("infantmaleage_d");
		if((male_infant_count_age_d==null) || (male_infant_count_age_d.equals("null")) || (male_infant_count_age_d=="") || (male_infant_count_age_d.equals(""))) male_infant_count_age_d	= "0";

		female_adult_count_age_y = request.getParameter("adultfemaleage_y");
		if((female_adult_count_age_y==null) || (female_adult_count_age_y.equals("null")) || (female_adult_count_age_y=="") || (female_adult_count_age_y.equals(""))) female_adult_count_age_y	= "0";

		female_child_count_age_y = request.getParameter("childfemaleage_y");
		if((female_child_count_age_y==null) || (female_child_count_age_y.equals("null")) || (female_child_count_age_y=="") || (female_child_count_age_y.equals(""))) female_child_count_age_y	= "0";

	/**
		female_child_count_age_m = request.getParameter("childfemaleage_y");
		if((female_child_count_age_m==null) || (female_child_count_age_m.equals("null")) || (female_child_count_age_m=="") || (female_child_count_age_m.equals(""))) female_child_count_age_m	= "0";
	**/
		female_infant_count_age_m = request.getParameter("infantfemaleage_m");
		if((female_infant_count_age_m==null) || (female_infant_count_age_m.equals("null")) || (female_infant_count_age_m=="") || (female_infant_count_age_m.equals(""))) female_infant_count_age_m	= "0";

		female_infant_count_age_d = request.getParameter("infantfemaleage_d");
		if((female_infant_count_age_d==null) || (female_infant_count_age_d.equals("null")) || (female_infant_count_age_d=="") || (female_infant_count_age_d.equals(""))) female_infant_count_age_d	= "0";

		unknown_adult_count_age_y = request.getParameter("adultunknownage_y");
		if((unknown_adult_count_age_y==null) || (unknown_adult_count_age_y.equals("null")) || (unknown_adult_count_age_y=="") || (unknown_adult_count_age_y.equals(""))) unknown_adult_count_age_y	= "0";

		unknown_child_count_age_y = request.getParameter("childunknownage_y");
	        if((unknown_child_count_age_y==null) || (unknown_child_count_age_y.equals("null")) || (unknown_child_count_age_y=="") || (unknown_child_count_age_y.equals(""))) unknown_child_count_age_y	= "0";

		unknown_child_count_age_m = request.getParameter("childunknownage_m");
	        if((unknown_child_count_age_m==null) || (unknown_child_count_age_m.equals("null")) || (unknown_child_count_age_m=="") || (unknown_child_count_age_m.equals(""))) unknown_child_count_age_m	= "0";

		unknown_infant_count_age_m = request.getParameter("infantunknownage_m");
		if((unknown_infant_count_age_m==null) || (unknown_infant_count_age_m.equals("null")) || (unknown_infant_count_age_m=="") || (unknown_infant_count_age_m.equals(""))) unknown_infant_count_age_m	= "0";

		unknown_infant_count_age_d = request.getParameter("infantunknownage_d");
		if((unknown_infant_count_age_d==null) || (unknown_infant_count_age_d.equals("null")) || (unknown_infant_count_age_d=="") || (unknown_infant_count_age_d.equals(""))) unknown_infant_count_age_d	= "0";

		clinic_code = request.getParameter("clinic_code");
		if((clinic_code==null) || (clinic_code.equals("null")) || (clinic_code=="") || (clinic_code.equals(""))) clinic_code	= "";

		Disaster_Reference = request.getParameter("Disaster_Reference");
		if((Disaster_Reference==null) || (Disaster_Reference.equals("null")) || (Disaster_Reference=="") || (Disaster_Reference.equals(""))) Disaster_Reference	= "";

		service_code =request.getParameter("service_code");
		if((service_code==null) || (service_code.equals("null")) || (service_code=="") || (service_code.equals(""))) service_code	= "";

		visit_type =request.getParameter("visit_type");
		if((visit_type==null) || (visit_type.equals("null")) || (visit_type=="") || (visit_type.equals(""))) visit_type	= "";

		arrival_mode =request.getParameter("arrival_mode");
		if((arrival_mode==null) || (arrival_mode.equals("null")) || (arrival_mode=="") || (arrival_mode.equals(""))) arrival_mode	= "";

		remarks =request.getParameter("remarks");
		if((remarks==null) || (remarks.equals("null")) || (remarks=="") || (remarks.equals(""))) remarks	= "";

		reasonforvisit =request.getParameter("reasonForVisit");
		if((reasonforvisit==null) || (reasonforvisit.equals("null")) || (reasonforvisit=="") || (reasonforvisit.equals(""))) reasonforvisit	= "";

		bl_interface_yn      = request.getParameter("bl_interface_yn");
		if((bl_interface_yn==null) || (bl_interface_yn.equals("null")) || (bl_interface_yn=="") || (bl_interface_yn.equals(""))) bl_interface_yn	= "";

		bl_install_yn      = request.getParameter("bl_install_yn");
		if((bl_install_yn==null) || (bl_install_yn.equals("null")) || (bl_install_yn=="") || (bl_install_yn.equals(""))) bl_install_yn	= "";

		sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		AddedFacilityID = this.facility_id;
		p = ( java.util.Properties ) session.getValue( "jdbc" ) ;
		locale		 =   p.getProperty("LOCALE");

		if(request.getParameter("client_ip_address") == null)
			this.AddedAtWsNo     =  p.getProperty("client_ip_address");
		else
			this.AddedAtWsNo     =request.getParameter("client_ip_address");

		this.addedById       = p.getProperty( "login_user" ) ;
		insertPatient(request,response);

	}

	private void insertPatient(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException 	{
		Statement stmt					 = null;
		PreparedStatement pstmtDate		 = null;
		ResultSet rsetDate 				 = null;
		PreparedStatement pstmtMPPat	 = null;
		PreparedStatement pstmtMPPatOth  = null;
		PreparedStatement pstmtMPPatAdd  = null;
		PreparedStatement pstmtMPPatRel  = null;
		PreparedStatement pstmtAEDisast  = null;
		CallableStatement csPat			 = null;
		int rsetAEDisast 	             = 0;
		int rsetMPPatRel	             = 0;
		int rsetMPPatAdd	             = 0;
		int rsetMPPatOth                 = 0;
		int rsetMPPat					 = 0;
		StringBuffer sb  				 = new StringBuffer("");
		sb  			                 = new StringBuffer();
		boolean bDaysrlFunction = false; 	

		String user_id = (String)session.getValue("login_user") ;
		try{
			con  = ConnectionManager.getConnection(request);
			result 				= false;
            if(pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();
			con.setAutoCommit(false);
			String PAT_NO_CTRL					= "";
			String P_CTRL_ID					= "";
			String P_SITE_OR_FACILITY			= "";
			String P_FACILITY_ID				= "";
			String P_START_PATIENT_ID			= "";
			String P_END_PATIENT_ID				= "";

			String P_PATIENT_ID					= "";
			String PAT_NAME						= "";
			String GEN_SLNO_YN					= "";

			String p_err_msg 					= "";


			long P_START_ENCOUNTER_ID			= 0;
			long P_END_ENCOUNTER_ID				= 0;


			int MALE_ADULT_CNT				= Integer.parseInt(male_adult_count) ;
			int MALE_CHILD_CNT				= Integer.parseInt(male_child_count) ;
			int MALE_INFANT_CNT				= Integer.parseInt(male_infant_count) ;
			int FEMALE_ADULT_CNT			= Integer.parseInt(female_adult_count) ;
			int FEMALE_CHILD_CNT			= Integer.parseInt(female_child_count) ;
			int FEMALE_INFANT_CNT			= Integer.parseInt(female_infant_count) ;
			int UNKNOWN_ADULT_CNT			= Integer.parseInt(unknown_adult_count) ;
			int UNKNOWN_CHILD_CNT			= Integer.parseInt(unknown_child_count) ;
			int UNKNOWN_INFANT_CNT			= Integer.parseInt(unknown_infant_count);

			StringBuffer P_patient_ids		= new StringBuffer();
			StringBuffer P_encounter_ids		= new StringBuffer();
			StringBuffer episode_ids = new StringBuffer();
			episode_ids.setLength(0);
			String P_encounter_id1			= "";
			String epsode_id1="";

			String P_FIRST_NAME				= "";
			String P_FAMILY_NAME			= "";
			String P_PATIENT_NAME			= "";

			String DATE_OF_BIRTH_MALE_ADULT			= "";
			String DATE_OF_BIRTH_FEMALE_ADULT		= "";
			String DATE_OF_BIRTH_UNKNOWN_ADULT		= "";
			String DATE_OF_BIRTH_MALE_CHILD			= "";
			String DATE_OF_BIRTH_FEMALE_CHILD		= "";
			String DATE_OF_BIRTH_UNKNOWN_CHILD		= "";
			String DATE_OF_BIRTH_MALE_INFANT		= "";
			String DATE_OF_BIRTH_FEMALE_INFANT		= "";
			String DATE_OF_BIRTH_UNKNOWN_INFANT		= "";

			String dflt_disaster_blng_grp_id		= "";
			String emer_blng_class_code				="";
			String settlement_ind					= "";
			String billing_class					= "";

			String SPECIALITY_CODE					= "";
			String VISIT_ADM_TYPE_IND				= "";
			String nationality_code					= "";
			String alt_id1_no                       = "";
			String rel_level_code				    = "";
			long  encounter_id						= 0 ;
			long epsode_id=0;

			int v_cnt1=0;
			int v_cnt2=0;
			int v_cnt3=0;
			int v_cnt4=0;
			int v_cnt5=0;
			int v_cnt6=0;
			int v_cnt7=0;
			int v_cnt8=0;
			int v_cnt9=0;
			pstmtDate =con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sys_date from dual");
			rsetDate = pstmtDate.executeQuery();
			if(rsetDate!=null && rsetDate.next())
				visit_date = rsetDate.getString("sys_date");
			if(rsetDate!=null) rsetDate.close();
			if(pstmtDate!=null) pstmtDate.close();

			
			/*Added By Dharma Start*/
			if(!module_id.equals("AE")){
				isVisitAdmTimeUpdate	= "N";
				isDowntimeRegnYn		= "Y";
				isDisasterRegnYn		= "N";
			}else{
				isDowntimeRegnYn		= "N";
				isDisasterRegnYn		= "Y";
				isVisitAdmTimeUpdate	= "Y";
			}

			if((bl_install_yn.equals("Y") && is_financial_captured.equals("Y")) || !clinic_code.equals("")){
				isVisitAdmTimeUpdate	= "Y";
			}
			/*Added By Dharma End*/




			csPat = con.prepareCall("{call generate_patient_id(?,?,?,?,?,?,?) }");

			//String sqlMPPat = "INSERT INTO mp_patient (patient_id, pat_ser_grp_code, regn_facility_id, emeg_regn_yn,      inhouse_birth_yn, suspend_yn, deceased_yn, citizen_yn, legal_yn,    pat_dtls_unknown_yn, sex, date_of_birth, active_yn,   calculated_age_yn, family_name, first_name, patient_name,nationality_code, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,regn_date,DISASTER_REGN_YN,pref_facility_id )  VALUES (?,?,?,'Y','N','N','N','Y','Y','Y',?,to_date(?,'dd/mm/yyyy'), 'Y','Y',?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),'Y',?)";
			
			String sqlMPPat = "INSERT INTO mp_patient (patient_id, pat_ser_grp_code, regn_facility_id, emeg_regn_yn,      inhouse_birth_yn, suspend_yn, deceased_yn, citizen_yn, legal_yn,    pat_dtls_unknown_yn, sex, date_of_birth, active_yn,   calculated_age_yn, family_name, first_name, patient_name,nationality_code, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,regn_date,DISASTER_REGN_YN,pref_facility_id,DOWNTIME_REGN_YN)  VALUES (?,?,?,'Y','N','N','N','Y','Y','Y',?,to_date(?,'dd/mm/yyyy'), 'Y','Y',?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),'"+isDisasterRegnYn+"',?,'"+isDowntimeRegnYn+"')";
			
			if(!isVisitAdmTimeUpdate.equals("Y")){
				sqlMPPat = "INSERT INTO mp_patient (patient_id, pat_ser_grp_code, regn_facility_id, emeg_regn_yn,      inhouse_birth_yn, suspend_yn, deceased_yn, citizen_yn, legal_yn,   pat_dtls_unknown_yn, sex, date_of_birth, active_yn,   calculated_age_yn, family_name, first_name, patient_name,nationality_code, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,DISASTER_REGN_YN,pref_facility_id,DOWNTIME_REGN_YN )  VALUES (?,?,?,'Y','N','N','N','Y','Y','Y',?,to_date(?,'dd/mm/yyyy'), 'Y','Y',?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,'"+isDisasterRegnYn+"',?,'"+isDowntimeRegnYn+"')";
			}
			System.err.println("sqlMPPat==>"+sqlMPPat);
			pstmtMPPat=con.prepareStatement(sqlMPPat);

			String sqlMPPatOth = "INSERT INTO MP_PAT_OTH_DTLS(PATIENT_ID,GENERAL_REMARKS,	REGN_COMPLETE_YN, LIVING_DEPENDENCY, LIVING_ARRANGEMENT,ADDED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID, MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)  VALUES (?,?,'Y','UN','U',?,SYSDATE,?,?,?,SYSDATE,?,?)";

			pstmtMPPatOth=con.prepareStatement(sqlMPPatOth);

			String sqlMPPatAdd = "INSERT INTO mp_pat_addresses (patient_id, added_by_id, added_date, added_at_ws_no,added_facility_id, modified_by_id, modified_date,modified_at_ws_no, modified_facility_id)  VALUES (?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

			pstmtMPPatAdd=con.prepareStatement(sqlMPPatAdd);

			String sqlMPPatRel = "INSERT INTO mp_pat_rel_contacts (patient_id, contact1_role, contact2_role, added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date,modified_at_ws_no,modified_facility_id) VALUES (?, 'NEXT', 'FRST',?,SYSDATE,?,?,?,SYSDATE,?,?)";

			pstmtMPPatRel=con.prepareStatement(sqlMPPatRel);
			try{
				String sql ="select CITIZEN_NATIONALITY_CODE from MP_PARAM";
				stmt = con.createStatement();
				rset = stmt.executeQuery(sql);
	 			if(rset!=null && rset.next())  {
					nationality_code = rset.getString("CITIZEN_NATIONALITY_CODE");
				}
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e){e.printStackTrace();}

			try{
				if (bl_install_yn.equals("Y") && is_financial_captured.equals("Y"))  {
					String sqlBL ="select DFLT_DISASTER_BLNG_GRP_ID, SETTLEMENT_IND,DFLT_PAT_REGN_BLNG_CLASS from bl_mp_param a, BL_BLNG_GRP b where a.DFLT_DISASTER_BLNG_GRP_ID=b.BLNG_GRP_ID";
					stmt = con.createStatement();
					rset = stmt.executeQuery(sqlBL);
	 				if(rset!=null && rset.next())   {
						dflt_disaster_blng_grp_id = rset.getString("DFLT_DISASTER_BLNG_GRP_ID");
						settlement_ind = rset.getString("SETTLEMENT_IND");
						emer_blng_class_code=rset.getString("DFLT_PAT_REGN_BLNG_CLASS");
						if(emer_blng_class_code == null) emer_blng_class_code="";
					}  else{
						MessageManager mm = new MessageManager();
		            	final java.util.Hashtable mesg = mm.getMessage(locale, "EM_BLNG_GRP_NOT_DEFINED", "MP") ;
                        mesg.clear();
					}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
				}
			}catch(Exception e){e.printStackTrace();}
			try{
				if (bl_install_yn.equals("Y") && is_financial_captured.equals("Y"))  {
					String sqlBLClass ="select blng_class_code from bl_op_clinic where facility_id='"+	facility_id +"' and clinic_code='"+clinic_code+"'";
					stmt = con.createStatement();
					rset = stmt.executeQuery(sqlBLClass);
	 				if(rset!=null && rset.next())   {
						billing_class = rset.getString("blng_class_code");
					}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
				}
			}catch(Exception e){
				e.printStackTrace();
				sb.append("Exception in calling Bill Procedure:"+e.toString());
            }
			try{
				String sqlFacility = "SELECT SITE_OR_FACILITY_ID FROM MP_PAT_SER_FACILITY WHERE PAT_SER_GRP_CODE =? AND USED_STATUS ='N'";
				pstmt = con.prepareStatement(sqlFacility);
				pstmt.setString(1,pat_ser_grp_code);
				rset = pstmt.executeQuery();
		       	        if (rset!=null && rset.next())  {
					P_FACILITY_ID = rset.getString("SITE_OR_FACILITY_ID");
					P_FACILITY_ID = (P_FACILITY_ID==null)?"":P_FACILITY_ID;
				}
				rset.close();
				pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
				sb.append("Exception in MP_PAT_SER_FACILITY:"+e.toString());
            }
			try{
				String sqlPatNoCtrl ="SELECT PAT_NO_CTRL FROM MP_PAT_SER_GRP WHERE PAT_SER_GRP_CODE=?";
		          	pstmt = con.prepareStatement(sqlPatNoCtrl);
				pstmt.setString(1,pat_ser_grp_code);
				rset = pstmt.executeQuery();

				if (rset!=null && rset.next()) {
					PAT_NO_CTRL = rset.getString("PAT_NO_CTRL");
					PAT_NO_CTRL = (PAT_NO_CTRL==null)?"":PAT_NO_CTRL;
				}
				rset.close();
				pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
				sb.append("Exception in PAT_NO_CTRL:"+e.toString());
            }
			if (PAT_NO_CTRL.equals("Z")) {
				try {
					stmt = con.createStatement();
					String sqlSite ="SELECT SITE_ID FROM SM_SITE_PARAM";
					rset = stmt.executeQuery(sqlSite);

					while(rset!=null && rset.next()) {
						P_CTRL_ID = rset.getString("SITE_ID");
					}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
			}catch(Exception e){
				e.printStackTrace();
				sb.append("Exception in SM_SITE_PARAM:"+e.toString());
            }

				P_SITE_OR_FACILITY ="S";
			}else if (PAT_NO_CTRL.equals("U")) {
				//P_CTRL_ID = P_FACILITY_ID;
				P_CTRL_ID =facility_id;
				P_SITE_OR_FACILITY ="F" ;
			}
			try {
				stmt = con.createStatement();
				/**	Modified against HSA-CRF-0153: Getting GenerateSlno Parameter **/
				String sqlPatName ="SELECT PAT_NAME_AS_MULTIPART_YN, GEN_SLNO_UNKNOWN_PAT_YN FROM MP_PARAM";
				rset = stmt.executeQuery(sqlPatName);

				while(rset!=null && rset.next())  {
					PAT_NAME = rset.getString("PAT_NAME_AS_MULTIPART_YN");
					GEN_SLNO_YN = rset.getString("GEN_SLNO_UNKNOWN_PAT_YN"); //Modified against HSA-CRF-0153
				}
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e){
				e.printStackTrace();
				sb.append("Exception in MP_PARAM:"+e.toString());
            }
			//Modified against HSA-CRF-0153 : Getting sitespecific parameter for the function UNKWN_PAT_DISP_FORMAT 
			bDaysrlFunction = CommonBean.isSiteSpecific(con, "MP","UNKWN_PAT_DISP_FORMAT");	

/* 6.


			if(!male_adult_count_age_y.equals("0") || !female_adult_count_age_y.equals("0") || !unknown_adult_count_age_y.equals("0") )
			{
			try{
				stmt = con.createStatement();
				String sql = "select CALCULATE_DATE_OF_BIRTH ("+male_adult_count_age_y+","+male_adult_count_age_m+",0) c1,CALCULATE_DATE_OF_BIRTH ("+female_adult_count_age_y+","+female_adult_count_age_m+",0) c2,CALCULATE_DATE_OF_BIRTH ("+unknown_adult_count_age_y+","+unknown_adult_count_age_m+",0) c3 from dual";
				rset = stmt.executeQuery(sql);
				if(rset!=null && rset.next())
				{
						DATE_OF_BIRTH_MALE_ADULT = rset.getString("c1");
						DATE_OF_BIRTH_FEMALE_ADULT = rset.getString("c2");
						DATE_OF_BIRTH_UNKNOWN_ADULT = rset.getString("c3");
				}

				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}  */
		/* Monday, May 31, 2010 PR_EXE venkat s 
			try{
				stmt = con.createStatement();
				String sql = "select CALCULATE_DATE_OF_BIRTH ("+female_adult_count_age_y+","+female_adult_count_age_m+",0) from dual";
				rset = stmt.executeQuery(sql);

	 			if(rset != null && rset.next())
					DATE_OF_BIRTH_FEMALE_ADULT = rset.getString(1);
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}

			try{
				stmt = con.createStatement();
			        String sql = "select CALCULATE_DATE_OF_BIRTH ("+unknown_adult_count_age_y+","+unknown_adult_count_age_m+",0) from dual";
				rset = stmt.executeQuery(sql);

	 			if(rset!=null && rset.next())
					DATE_OF_BIRTH_UNKNOWN_ADULT = rset.getString(1);
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
*/

/*
			if(!male_child_count_age_y.equals("0") || !female_child_count_age_y.equals("0") || !unknown_child_count_age_y.equals("0") )
			{
			try{
				stmt = con.createStatement();
				String sql = "select CALCULATE_DATE_OF_BIRTH ("+male_child_count_age_y+","+male_child_count_age_m+",0) c1,CALCULATE_DATE_OF_BIRTH ("+female_child_count_age_y+","+female_child_count_age_m+",0) c2,CALCULATE_DATE_OF_BIRTH ("+unknown_child_count_age_y+","+unknown_child_count_age_m+",0) c3 from dual";
				rset = stmt.executeQuery(sql);

				if(rset!=null && rset.next())
				{
						DATE_OF_BIRTH_MALE_CHILD = rset.getString("c1");
						DATE_OF_BIRTH_FEMALE_CHILD = rset.getString("c2");
						DATE_OF_BIRTH_UNKNOWN_CHILD = rset.getString("c3");
				}

				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			} */

	/**	   Monday, May 31, 2010 PR_EXE venkat S
	try{
				stmt = con.createStatement();
				String sql = "select CALCULATE_DATE_OF_BIRTH ("+female_child_count_age_y+","+female_child_count_age_m+",0) from dual";
				rset = stmt.executeQuery(sql);

	 			if(rset!=null && rset.next())
					DATE_OF_BIRTH_FEMALE_CHILD = rset.getString(1);
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}

			try{
				stmt = con.createStatement();
				String sql = "select CALCULATE_DATE_OF_BIRTH ("+unknown_child_count_age_y+","+unknown_child_count_age_m+",0) from dual";
				rset = stmt.executeQuery(sql);

			        if(rset!=null && rset.next())
					DATE_OF_BIRTH_UNKNOWN_CHILD = rset.getString(1);
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
**/
/**
			if(!male_infant_count_age_m.equals("0") || !male_infant_count_age_d.equals("0") || !female_infant_count_age_m.equals("0") || !female_infant_count_age_d.equals("0") || !unknown_infant_count_age_m.equals("0") || !unknown_infant_count_age_d.equals("0"))
			{
			try{
				stmt = con.createStatement();
				String sql = "select CALCULATE_DATE_OF_BIRTH (0,"+male_infant_count_age_m+","+male_infant_count_age_d+") c1, CALCULATE_DATE_OF_BIRTH (0,"+female_infant_count_age_m+","+female_infant_count_age_d+") c2,CALCULATE_DATE_OF_BIRTH (0,"+unknown_infant_count_age_m+","+unknown_infant_count_age_d+") c3 from dual";
				rset = stmt.executeQuery(sql);

	 			if(rset!=null && rset.next())
				{
					DATE_OF_BIRTH_MALE_INFANT = rset.getString("c1");
					DATE_OF_BIRTH_FEMALE_INFANT = rset.getString("c2");
					DATE_OF_BIRTH_UNKNOWN_INFANT = rset.getString("c3");
				}
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			}

*/

/** Monday, May 31, 2010 PE_EXE venkat S
			try{
				stmt = con.createStatement();
				String sql = "select CALCULATE_DATE_OF_BIRTH (0,"+female_infant_count_age_m+","+female_infant_count_age_d+") from dual";
				rset = stmt.executeQuery(sql);

	 			if(rset!=null && rset.next())
					DATE_OF_BIRTH_FEMALE_INFANT = rset.getString(1);
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}

			try{
				stmt = con.createStatement();
				String sql = "select CALCULATE_DATE_OF_BIRTH (0,"+unknown_infant_count_age_m+","+unknown_infant_count_age_d+") from dual";
				rset = stmt.executeQuery(sql);

	 			if(rset!=null && rset.next())
					DATE_OF_BIRTH_UNKNOWN_INFANT = rset.getString(1);

				 if(stmt!=null) stmt.close();
				 if(rset!=null) rset.close();
			}catch(Exception e){
				e.printStackTrace();
			}

**/
/// START (CALCULATE PATIENT'S DOB)
	StringBuffer whereBuffer  = new StringBuffer();
	StringBuffer sqlBuffer  = new StringBuffer();
	if(!male_adult_count_age_y.equals("0"))
	{
		whereBuffer.append("CALCULATE_DATE_OF_BIRTH ("+male_adult_count_age_y+","+male_adult_count_age_m+",0) MA_Y ");
    } 
	if(!female_adult_count_age_y.equals("0")){
		if(!male_adult_count_age_y.equals("0")){
			whereBuffer.append(",");}
			whereBuffer.append("CALCULATE_DATE_OF_BIRTH ("+female_adult_count_age_y+","+female_adult_count_age_m+",0) FA_Y ");
	} 
	if(!unknown_adult_count_age_y.equals("0")){
		if(!male_adult_count_age_y.equals("0") || !female_adult_count_age_y.equals("0")){
			whereBuffer.append(",");}
			whereBuffer.append("CALCULATE_DATE_OF_BIRTH ("+unknown_adult_count_age_y+","+unknown_adult_count_age_m+",0) UA_Y ");
	} 
	if(!male_child_count_age_y.equals("0")){
		if(!male_adult_count_age_y.equals("0") || !female_adult_count_age_y.equals("0") || !unknown_adult_count_age_y.equals("0")){
			whereBuffer.append(",");}
			whereBuffer.append("CALCULATE_DATE_OF_BIRTH ("+male_child_count_age_y+","+male_child_count_age_m+",0) MC_Y ");
	} 
	if(!female_child_count_age_y.equals("0")){
		if(!male_adult_count_age_y.equals("0") || !female_adult_count_age_y.equals("0") || !unknown_adult_count_age_y.equals("0") || !male_child_count_age_y.equals("0")){
			whereBuffer.append(","); }
			whereBuffer.append("CALCULATE_DATE_OF_BIRTH ("+female_child_count_age_y+","+female_child_count_age_m+",0) FC_Y ");
	}
	if(!unknown_child_count_age_y.equals("0")){
		if(!male_adult_count_age_y.equals("0") || !female_adult_count_age_y.equals("0") || !unknown_adult_count_age_y.equals("0") || !male_child_count_age_y.equals("0") || !female_child_count_age_y.equals("0") ){
			whereBuffer.append(",");}
			whereBuffer.append("CALCULATE_DATE_OF_BIRTH ("+unknown_child_count_age_y+","+unknown_child_count_age_m+",0) UC_Y ");
	} 
	if(!male_infant_count_age_m.equals("0") ||!male_infant_count_age_d.equals("0") ) {
		if(!male_adult_count_age_y.equals("0") || !female_adult_count_age_y.equals("0") || !unknown_adult_count_age_y.equals("0") || !male_child_count_age_y.equals("0") || !female_child_count_age_y.equals("0") || !unknown_child_count_age_y.equals("0")){
			whereBuffer.append(",");}
			whereBuffer.append("CALCULATE_DATE_OF_BIRTH (0,"+male_infant_count_age_m+","+male_infant_count_age_d+")MI_age ");
	} 
	if(!female_infant_count_age_m.equals("0") ||!female_infant_count_age_d.equals("0") ) {
		if(!male_adult_count_age_y.equals("0") || !female_adult_count_age_y.equals("0") || !unknown_adult_count_age_y.equals("0") || !male_child_count_age_y.equals("0") || !female_child_count_age_y.equals("0") || !unknown_child_count_age_y.equals("0") || !male_infant_count_age_m.equals("0") ||!male_infant_count_age_d.equals("0")){
			whereBuffer.append(",");}
			whereBuffer.append("CALCULATE_DATE_OF_BIRTH (0,"+female_infant_count_age_m+","+female_infant_count_age_d+") FI_age ");
	} 
	if(!unknown_infant_count_age_m.equals("0") ||!unknown_infant_count_age_d.equals("0") ) {
		if(!male_adult_count_age_y.equals("0") || !female_adult_count_age_y.equals("0") || !unknown_adult_count_age_y.equals("0") || !male_child_count_age_y.equals("0") || !female_child_count_age_y.equals("0") || !unknown_child_count_age_y.equals("0") || !male_infant_count_age_m.equals("0") ||!male_infant_count_age_d.equals("0") || !female_infant_count_age_m.equals("0") ||!female_infant_count_age_d.equals("0")){
			whereBuffer.append(",");}
			whereBuffer.append("CALCULATE_DATE_OF_BIRTH (0,"+unknown_infant_count_age_m+","+unknown_infant_count_age_d+")UI_age ");
	}
		 sqlBuffer.append("select "+whereBuffer.toString()+" from dual");
			try{
				stmt = con.createStatement();
				rset = stmt.executeQuery(sqlBuffer.toString());
				
			if(rset!=null && rset.next())
			{
					if(!male_adult_count_age_y.equals("0"))
					{
						DATE_OF_BIRTH_MALE_ADULT = rset.getString("MA_Y");
					} 
					if(!female_adult_count_age_y.equals("0")){
						DATE_OF_BIRTH_FEMALE_ADULT = rset.getString("FA_Y");
					} 
					if(!unknown_adult_count_age_y.equals("0")){
						DATE_OF_BIRTH_UNKNOWN_ADULT = rset.getString("UA_Y");
					} 
					if(!male_child_count_age_y.equals("0")){
						DATE_OF_BIRTH_MALE_CHILD = rset.getString("MC_Y");
					} 
					if(!female_child_count_age_y.equals("0")){
						DATE_OF_BIRTH_FEMALE_CHILD = rset.getString("FC_Y");
					}
					if(!unknown_child_count_age_y.equals("0")){
						DATE_OF_BIRTH_UNKNOWN_CHILD = rset.getString("UC_Y");
					} 
					if(!male_infant_count_age_m.equals("0") ||!male_infant_count_age_d.equals("0") ) {
						DATE_OF_BIRTH_MALE_INFANT = rset.getString("MI_age");
					} 
					if(!female_infant_count_age_m.equals("0") ||!female_infant_count_age_d.equals("0") ) {
						DATE_OF_BIRTH_FEMALE_INFANT = rset.getString("FI_age");

					} 
					if(!unknown_infant_count_age_m.equals("0") ||!unknown_infant_count_age_d.equals("0") ) {
						DATE_OF_BIRTH_UNKNOWN_INFANT = rset.getString("UI_age");
					}
			}

				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
				whereBuffer.setLength(0);
				sqlBuffer.setLength(0);

			}catch(Exception e){
				e.printStackTrace();
			}
// END (CALCULATE PATIENT'S DOB)
			if ((!facility_id.equals("null")) &&  (!clinic_code.equals("null"))) {
				try{
					String sqlSpec ="SELECT SPECIALITY_CODE FROM OP_CLINIC WHERE FACILITY_ID = ? AND CLINIC_CODE = ?";

					pstmt = con.prepareStatement(sqlSpec);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,clinic_code);
					rset = pstmt.executeQuery();

					if (rset!=null && rset.next()) {
						SPECIALITY_CODE = rset.getString("SPECIALITY_CODE");
						SPECIALITY_CODE = (SPECIALITY_CODE==null)?"":SPECIALITY_CODE;
					}
					rset.close();
					pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
				sb.append("Exception in OP_CLINIC:"+e.toString());
            }
			}
			if ((!facility_id.equals("null")) &&  (!visit_type.equals("null"))) {
				try{
					String sqlVisitType ="SELECT VISIT_TYPE_IND FROM OP_VISIT_TYPE WHERE FACILITY_ID = ? AND VISIT_TYPE_CODE = ? ";

					pstmt = con.prepareStatement(sqlVisitType);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,visit_type);
					rset = pstmt.executeQuery();

					 if (rset!=null && rset.next()) {
						VISIT_ADM_TYPE_IND = rset.getString("VISIT_TYPE_IND");
						VISIT_ADM_TYPE_IND = (VISIT_ADM_TYPE_IND==null)?"":VISIT_ADM_TYPE_IND;
					}
					rset.close();
					pstmt.close();
				}catch(Exception e){e.printStackTrace();}
			}
			long V_ENCOUNTER_ID = 0;
			v_cnt1 = 0 ;
			for(int i=0;MALE_INFANT_CNT>0;i++) {
				v_cnt1 = v_cnt1 + 1;
				try{
					sex ="M";
//ADDED FROM HERE
				 csPat.setString( 1 ,pat_ser_grp_code );
	             //csPat.setString( 2 ,P_FACILITY_ID );
				 csPat.setString( 2 ,P_CTRL_ID );
				 
	             csPat.setString( 3 ,alt_id1_no  );
	             csPat.setString( 4 ,rel_level_code );
	             csPat.setString( 5 ,sex );
	             csPat.registerOutParameter(6,Types.VARCHAR);
	             csPat.registerOutParameter(7,Types.VARCHAR);
/*System.out.println("pat_ser_grp_code: "+pat_ser_grp_code);
System.out.println("P_CTRL_ID "+P_CTRL_ID);
System.out.println("alt_id1_no: "+alt_id1_no);
System.out.println("rel_level_code: "+rel_level_code);
System.out.println("sex: "+sex);
*/



	             csPat.execute();



				 P_PATIENT_ID		   = csPat.getString(6);
				 p_err_msg		        = csPat.getString(7);




				 if (P_PATIENT_ID==null)
				 {
					 P_PATIENT_ID = "";
				 }
				 if (p_err_msg==null)
				 {
					 p_err_msg = "";
				 }
				if(!p_err_msg.equals(""))
				{
				java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_GEN_PAT_ID","MP");
				errors = ((String) message.get("message"));
				sb.append(errors+": ** PATIENT SERIES GROUP EXHAUSTED **");
				result = false;
				throw new Exception("");

				}
				else
				{
					result = true;
				}
				if(result)
				{
				if (P_patient_ids.toString().equals(""))  {
						P_patient_ids.append(P_PATIENT_ID);
					 } else {
						P_patient_ids.append(":");
						P_patient_ids.append(P_PATIENT_ID);
					 }
				}

			}catch(Exception e){
				e.printStackTrace();
            }

				if (PAT_NAME.equals("N"))  {
					P_FAMILY_NAME = "Unknown Infant Male";
					P_PATIENT_NAME =P_FAMILY_NAME;
				}else{
					P_FIRST_NAME = "Unknown Infant";
					P_FAMILY_NAME = " Male";
					P_PATIENT_NAME = P_FIRST_NAME + P_FAMILY_NAME;
				}

				/** Modified against HSA-CRF-0153**/ 
				// If DaySrlFunction is enabled in sm_function_control and GenerateSrlNo parameter is enabled, then it is generating DaySrlNo. 
				if("Y".equalsIgnoreCase(GEN_SLNO_YN) && bDaysrlFunction)
				{
					P_PATIENT_NAME  	= GetDaySrlNo(sex);
					P_FAMILY_NAME 		= P_PATIENT_NAME;
				}
				
				
				if(result) {
					try{
 						pstmtMPPat.setString(1, P_PATIENT_ID) ;
						pstmtMPPat.setString(2, pat_ser_grp_code) ;
						pstmtMPPat.setString(3, facility_id) ;
						pstmtMPPat.setString(4, sex) ;
						pstmtMPPat.setString(5, DATE_OF_BIRTH_MALE_INFANT) ;
						pstmtMPPat.setString(6, P_FAMILY_NAME) ;
						pstmtMPPat.setString(7, P_FIRST_NAME) ;
						pstmtMPPat.setString(8, P_PATIENT_NAME) ;
						pstmtMPPat.setString(9, nationality_code) ;
						pstmtMPPat.setString(10, addedById) ;
						pstmtMPPat.setString(11, AddedAtWsNo) ;
						pstmtMPPat.setString(12, facility_id) ;
						pstmtMPPat.setString(13, addedById) ;
						pstmtMPPat.setString(14, AddedAtWsNo) ;
						pstmtMPPat.setString(15, facility_id) ;
					
						if(isVisitAdmTimeUpdate.equals("Y")){
							pstmtMPPat.setString(16, visit_date) ;
							pstmtMPPat.setString(17, facility_id) ;
						}else{
							pstmtMPPat.setString(16, facility_id) ;
						}


						rsetMPPat =  pstmtMPPat.executeUpdate();
						if(rsetMPPat > 0)
							result	=	true;
						else
							result	=	false;
					}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPat:"+e.toString());
						result	=	false;
					}
				}
			        if(result) {
					try{
						pstmtMPPatOth.setString(1, P_PATIENT_ID) ;
						pstmtMPPatOth.setString(2, remarks) ;
						pstmtMPPatOth.setString(3, addedById) ;
						pstmtMPPatOth.setString(4, AddedAtWsNo) ;
						pstmtMPPatOth.setString(5, facility_id) ;
						pstmtMPPatOth.setString(6, addedById) ;
						pstmtMPPatOth.setString(7, AddedAtWsNo) ;
						pstmtMPPatOth.setString(8, facility_id) ;

						rsetMPPatOth =  pstmtMPPatOth.executeUpdate();
						if(rsetMPPatOth > 0)
							result	=	true;
						else
							result	=	false;
					}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPatOth:"+e.toString());
						result	=	false;
					}
				}
				if(result) {
					try{
						pstmtMPPatAdd.setString(1, P_PATIENT_ID) ;
						pstmtMPPatAdd.setString(2, addedById) ;
						pstmtMPPatAdd.setString(3, AddedAtWsNo) ;
						pstmtMPPatAdd.setString(4, facility_id) ;
						pstmtMPPatAdd.setString(5, addedById) ;
						pstmtMPPatAdd.setString(6, AddedAtWsNo) ;
						pstmtMPPatAdd.setString(7, facility_id) ;

						rsetMPPatAdd =  pstmtMPPatAdd.executeUpdate();
						if(rsetMPPatAdd > 0)
							result	=	true;
						else
							result	=	false;
					}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPatAdd:"+e.toString());
						result	=	false;
					}
				}
				if(result) {
					try{
						pstmtMPPatRel.setString(1, P_PATIENT_ID) ;
						pstmtMPPatRel.setString(2, addedById) ;
						pstmtMPPatRel.setString(3, AddedAtWsNo) ;
						pstmtMPPatRel.setString(4, facility_id) ;
						pstmtMPPatRel.setString(5, addedById) ;
						pstmtMPPatRel.setString(6, AddedAtWsNo) ;
						pstmtMPPatRel.setString(7, facility_id) ;

						rsetMPPatRel =  pstmtMPPatRel.executeUpdate();
						if(rsetMPPatRel > 0)
							result	=	true;
						else
							result	=	false;
					}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPatRel:"+e.toString());
						result	=	false;
					}
				}
		if(result)
		{
			if (bl_install_yn.equals("Y") && is_financial_captured.equals("Y"))
			{
			  try
	 		  {

                 billing_group         = 	 request.getParameter("billing_group");
				 Hashtable blTabdata   = new Hashtable();
				 String strMessage     = "";

				 blTabdata.put("calling_function_id","DISASTER_EMER_REGN");
				 blTabdata.put("pat_ser_grp_code",pat_ser_grp_code);
				 blTabdata.put("credit_auth_user_id","");
				 blTabdata.put("locale",locale);
				 blTabdata.put("patient_id_new", P_PATIENT_ID);
				 blTabdata.put("facility_id",facility_id);
				 blTabdata.put("operation_mode","I");
				 blTabdata.put("added_at_ws_no",AddedAtWsNo);
				 blTabdata.put("added_by_id",addedById);
				 //blTabdata.put("billing_group",billing_group);
				 blTabdata.put("billing_group",dflt_disaster_blng_grp_id);
				 blTabdata.put("dflt_pat_regn_blng_class",emer_blng_class_code);
		            blmpin.BLMPInterface blPatReg = new blmpin.BLMPInterface();
					Hashtable resultsBL = blPatReg.billPatientService(p,con,blTabdata);
					boolean boolRes = ((Boolean) (resultsBL.get("transaction_completed"))).booleanValue();

					if (boolRes == false)
					{
					  result = false;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 if (boolRes == true)
					 {
					  result = true;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 blTabdata.clear();
					 resultsBL.clear();
				     //sb.append("<br>End Update Billing ") ;

                 }catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in billing Bean BLMPInterface :"+e.toString());
					result	=	false;
				}
			}
		  }
		  if (result)
		  {
				MALE_INFANT_CNT--;

				if ( (!facility_id.equals("")) &&  (!visit_type.equals("null")) &&  (!P_PATIENT_ID.equals("")) && (!VISIT_ADM_TYPE_IND.equals("null")) &&  (!service_code.equals("")) &&  (!arrival_mode.equals("null")) &&  (!AddedAtWsNo.equals("")) &&  (!clinic_code.equals("")) &&  (!priority_zone.equals("")) && (!addedById.equals("")) &&  (!SPECIALITY_CODE.equals("")) &&  (!AddedFacilityID.equals("")) &&  (!reasonforvisit.equals("null")) ) {
					V_ENCOUNTER_ID = 0;

				        encounter_id = GENERATE_MULTIPLE_ATTENDANCE(
			                facility_id, P_PATIENT_ID, visit_type, VISIT_ADM_TYPE_IND,
			                clinic_code, service_code, SPECIALITY_CODE,
			                arrival_mode,reasonforvisit,priority_zone,addedById,
			                AddedAtWsNo, V_ENCOUNTER_ID);
						epsode_id=GET_EPISODE(facility_id,encounter_id);

						Long ep=new Long(epsode_id);

						epsode_id1=ep.toString();
						if(episode_ids.toString().equals("")){
							episode_ids.append(epsode_id1);
						}else
						{
							episode_ids.append(":");
							episode_ids.append(epsode_id1);
						}

					Long e = new Long(encounter_id);
					P_encounter_id1 =e.toString();
					if (P_encounter_ids.toString().equals("")) {
						P_encounter_ids.append(P_encounter_id1);
					} else {
						P_encounter_ids.append(":");
						P_encounter_ids.append(P_encounter_id1);
					}
					if (v_cnt1==1) {
						P_START_ENCOUNTER_ID = encounter_id;
					}
				        P_END_ENCOUNTER_ID = encounter_id;
				}//end of if
		     }else{
				 break;
			 }//end if
		}//end of for loop
			v_cnt2 = 0;
			for(int i=0;MALE_CHILD_CNT>0;i++) {
				v_cnt2 = v_cnt2 + 1;
				sex = "M";
				try{
//ADDED FROM HERE
				 csPat.setString( 1 ,pat_ser_grp_code );
	             //csPat.setString( 2 ,P_FACILITY_ID );
				  csPat.setString( 2 ,P_CTRL_ID );
	             csPat.setString( 3 ,alt_id1_no  );
	             csPat.setString( 4 ,rel_level_code );
	             csPat.setString( 5 ,sex );
	             csPat.registerOutParameter(6,Types.VARCHAR);
	             csPat.registerOutParameter(7,Types.VARCHAR);

	             csPat.execute();


				 P_PATIENT_ID		   = csPat.getString(6);
				 p_err_msg		        = csPat.getString(7);

				 if (P_PATIENT_ID==null)
				 {
					 P_PATIENT_ID = "";
				 }
				 if (p_err_msg==null)
				 {
					 p_err_msg = "";
				 }

				if(!p_err_msg.equals(""))
				{
				java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_GEN_PAT_ID","MP");
				errors = ((String) message.get("message"));
				sb.append(errors+": ** PATIENT SERIES GROUP EXHAUSTED **");
				result = false;
				throw new Exception("");
				}
				else
				{
					result = true;
				}
				if(result)
				{

				if (P_patient_ids.toString().equals(""))  {
						P_patient_ids.append(P_PATIENT_ID);
					 } else {
						P_patient_ids.append(":");
						P_patient_ids.append(P_PATIENT_ID);
					 }
				}
				}catch(Exception e){
					e.printStackTrace();
				}

				if (PAT_NAME.equals("N")) {
					P_FAMILY_NAME = "Unknown Child Male";
					P_PATIENT_NAME =P_FAMILY_NAME;
				}else{
					P_FIRST_NAME = "Unknown Child";
					P_FAMILY_NAME = " Male";
					P_PATIENT_NAME = P_FIRST_NAME + P_FAMILY_NAME;
				}

				/** Modified against HSA-CRF-0153**/
				if("Y".equalsIgnoreCase(GEN_SLNO_YN) && bDaysrlFunction)
				{
					P_PATIENT_NAME  	= GetDaySrlNo(sex);
					P_FAMILY_NAME 		= P_PATIENT_NAME;
				}
				
				if(result) {
					try{
						pstmtMPPat.setString(1, P_PATIENT_ID) ;
						pstmtMPPat.setString(2, pat_ser_grp_code) ;
						pstmtMPPat.setString(3, facility_id) ;
						pstmtMPPat.setString(4, sex) ;
						pstmtMPPat.setString(5, DATE_OF_BIRTH_MALE_CHILD) ;
						pstmtMPPat.setString(6, P_FAMILY_NAME) ;
						pstmtMPPat.setString(7, P_FIRST_NAME) ;
						pstmtMPPat.setString(8, P_PATIENT_NAME) ;
						pstmtMPPat.setString(9, nationality_code) ;
						pstmtMPPat.setString(10, addedById) ;
						pstmtMPPat.setString(11, AddedAtWsNo) ;
						pstmtMPPat.setString(12, facility_id) ;
						pstmtMPPat.setString(13, addedById) ;
						pstmtMPPat.setString(14, AddedAtWsNo) ;
						pstmtMPPat.setString(15, facility_id) ;
						if(isVisitAdmTimeUpdate.equals("Y")){
							pstmtMPPat.setString(16, visit_date) ;
							pstmtMPPat.setString(17, facility_id) ;
						}else{
							pstmtMPPat.setString(16, facility_id) ;
						}
						rsetMPPat =  pstmtMPPat.executeUpdate();
						if(rsetMPPat > 0)
							result	=	true;
						else
							result	=	false;
						}catch(Exception e){
							e.printStackTrace();
							sb.append("Exception in MPPat :"+e.toString());
							result	=	false;
						}
				}

				if(result){
					try{
						pstmtMPPatOth.setString(1, P_PATIENT_ID) ;
						pstmtMPPatOth.setString(2, remarks) ;
						pstmtMPPatOth.setString(3, addedById) ;
						pstmtMPPatOth.setString(4, AddedAtWsNo) ;
						pstmtMPPatOth.setString(5, facility_id) ;
						pstmtMPPatOth.setString(6, addedById) ;
						pstmtMPPatOth.setString(7, AddedAtWsNo) ;
						pstmtMPPatOth.setString(8, facility_id) ;

						rsetMPPatOth =  pstmtMPPatOth.executeUpdate();
						if(rsetMPPatOth > 0)
							result	=	true;
						else
							result	=	false;
						}catch(Exception e){
							e.printStackTrace();
							sb.append("Exception in MPPatOth :"+e.toString());
							result	=	false;
						}
				}
				if(result) {
					try{
						pstmtMPPatAdd.setString(1, P_PATIENT_ID) ;
						pstmtMPPatAdd.setString(2, addedById) ;
						pstmtMPPatAdd.setString(3, AddedAtWsNo) ;
						pstmtMPPatAdd.setString(4, facility_id) ;
						pstmtMPPatAdd.setString(5, addedById) ;
						pstmtMPPatAdd.setString(6, AddedAtWsNo) ;
						pstmtMPPatAdd.setString(7, facility_id) ;

						rsetMPPatAdd =  pstmtMPPatAdd.executeUpdate();
						if(rsetMPPatAdd > 0)
							result	=	true;
						else
							result	=	false;
						}catch(Exception e){
							e.printStackTrace();
							sb.append("Exception in MPPatAdd :"+e.toString());
							result	=	false;
						}
				}
				if(result) {
					try{
						pstmtMPPatRel.setString(1, P_PATIENT_ID) ;
						pstmtMPPatRel.setString(2, addedById) ;
						pstmtMPPatRel.setString(3, AddedAtWsNo) ;
						pstmtMPPatRel.setString(4, facility_id) ;
						pstmtMPPatRel.setString(5, addedById) ;
						pstmtMPPatRel.setString(6, AddedAtWsNo) ;
						pstmtMPPatRel.setString(7, facility_id) ;

						rsetMPPatRel =  pstmtMPPatRel.executeUpdate();
						if(rsetMPPatRel > 0)
							result	=	true;
						else
							result	=	false;
						}catch(Exception e){
							e.printStackTrace();
							sb.append("Exception in MPPatRel :"+e.toString());
							result	=	false;
						}
				}
				if(result)
		{
			if (bl_install_yn.equals("Y") && is_financial_captured.equals("Y"))
			{
			  try
	 		  {

                 billing_group         = 	 request.getParameter("billing_group");
				 Hashtable blTabdata = new Hashtable();
				 String strMessage = "";

				 blTabdata.put("calling_function_id","DISASTER_EMER_REGN");
				 blTabdata.put("pat_ser_grp_code",pat_ser_grp_code);
				 blTabdata.put("credit_auth_user_id","");
				 blTabdata.put("locale",locale);
				 blTabdata.put("patient_id_new", P_PATIENT_ID);
				 blTabdata.put("facility_id",facility_id);
				 blTabdata.put("operation_mode","I");
				 blTabdata.put("added_at_ws_no",AddedAtWsNo);
				 blTabdata.put("added_by_id",addedById);
				 //blTabdata.put("billing_group",billing_group);
				 blTabdata.put("billing_group",dflt_disaster_blng_grp_id);
				 blTabdata.put("dflt_pat_regn_blng_class",emer_blng_class_code);
		            blmpin.BLMPInterface blPatReg = new blmpin.BLMPInterface();
					Hashtable resultsBL = blPatReg.billPatientService(p,con,blTabdata);
					boolean boolRes = ((Boolean) (resultsBL.get("transaction_completed"))).booleanValue();

					if (boolRes == false)
					{
					  result = false;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 if (boolRes == true)
					 {
					  result = true;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 blTabdata.clear();
				     resultsBL.clear();
 				     //sb.append("<br>End Update Billing ") ;

                 }catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in billing Bean BLMPInterface :"+e.toString());
					result	=	false;
				}
			}
		  }
		  if(result){
				MALE_CHILD_CNT--;

				if ( (!facility_id.equals("")) &&  (!visit_type.equals("null")) &&  (!P_PATIENT_ID.equals("")) && (!VISIT_ADM_TYPE_IND.equals("null")) &&  (!service_code.equals("")) &&  (!arrival_mode.equals("null")) &&  (!AddedAtWsNo.equals("")) &&  (!clinic_code.equals("")) &&  (!priority_zone.equals("")) && (!addedById.equals("")) &&  (!SPECIALITY_CODE.equals("")) &&  (!AddedFacilityID.equals("")) &&  (!reasonforvisit.equals("null")) ) {
					V_ENCOUNTER_ID = 0;

				         encounter_id = GENERATE_MULTIPLE_ATTENDANCE(
					 facility_id, P_PATIENT_ID, visit_type, VISIT_ADM_TYPE_IND,
					 clinic_code, service_code, SPECIALITY_CODE,
					 arrival_mode,reasonforvisit,priority_zone,addedById,
					 AddedAtWsNo, V_ENCOUNTER_ID);
					epsode_id=GET_EPISODE(facility_id,encounter_id);

						Long ep=new Long(epsode_id);

						epsode_id1=ep.toString();
						if(episode_ids.toString().equals("")){
							episode_ids.append(epsode_id1);
						}else
						{
							episode_ids.append(":");
							episode_ids.append(epsode_id1);
						}

					Long e = new Long(encounter_id);
					P_encounter_id1 = e.toString();
					if (P_encounter_ids.toString().equals("")) {
						P_encounter_ids.append(P_encounter_id1);
					} else {
						P_encounter_ids.append(":");
						P_encounter_ids.append(P_encounter_id1);
					}
					if ((v_cnt1==0) && (v_cnt2==1)) {
						P_START_ENCOUNTER_ID = encounter_id;
					}

					P_END_ENCOUNTER_ID = encounter_id;
			        }//end of if
		       }else{
				   break;
			   }//end if
			}//end of for
			v_cnt3 =0;
			for(int i=0;MALE_ADULT_CNT>0;i++) {
				v_cnt3 = v_cnt3 + 1;
				sex="M";
				try{
					//ADDED FROM HERE

				 csPat.setString( 1 ,pat_ser_grp_code );
	             //csPat.setString( 2 ,P_FACILITY_ID );
				  csPat.setString( 2 ,P_CTRL_ID );
	             csPat.setString( 3 ,alt_id1_no  );
	             csPat.setString( 4 ,rel_level_code );
	             csPat.setString( 5 ,sex );
	             csPat.registerOutParameter(6,Types.VARCHAR);
	             csPat.registerOutParameter(7,Types.VARCHAR);

	             csPat.execute();


				 P_PATIENT_ID		   = csPat.getString(6);
				 p_err_msg		        = csPat.getString(7);


				 if (P_PATIENT_ID==null)
				 {
					 P_PATIENT_ID = "";
				 }
				 if (p_err_msg==null)
				 {
					 p_err_msg = "";
			 }

				if(!p_err_msg.equals(""))
				{
				java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_GEN_PAT_ID","MP");
				errors = ((String) message.get("message"));
				sb.append(errors+": ** PATIENT SERIES GROUP EXHAUSTED **");
				result = false;
			      throw new Exception("");

				}
				else
				{
				result = true;
				}


				if(result)
				{
					if (P_patient_ids.toString().equals(""))  {
							P_patient_ids.append(P_PATIENT_ID);
						 } else {
							P_patient_ids.append(":");
							P_patient_ids.append(P_PATIENT_ID);
						 }
				}
			}catch(Exception e){
					e.printStackTrace();

            }

				if (PAT_NAME.equals("N"))  {
					P_FAMILY_NAME = "Unknown Adult Male";
					P_PATIENT_NAME =P_FAMILY_NAME;
				}else{
					P_FIRST_NAME = "Unknown Adult";
					P_FAMILY_NAME = " Male";
					P_PATIENT_NAME = P_FIRST_NAME + P_FAMILY_NAME;
				}

				/** Modified against HSA-CRF-0153**/
				if("Y".equalsIgnoreCase(GEN_SLNO_YN) && bDaysrlFunction)
				{
					P_PATIENT_NAME  	= GetDaySrlNo(sex);
					P_FAMILY_NAME 		= P_PATIENT_NAME;
				}
				
			if(result) {
				try{
					pstmtMPPat.setString(1, P_PATIENT_ID) ;
					pstmtMPPat.setString(2, pat_ser_grp_code) ;
					pstmtMPPat.setString(3, facility_id) ;
					pstmtMPPat.setString(4, sex) ;
					pstmtMPPat.setString(5, DATE_OF_BIRTH_MALE_ADULT) ;
					pstmtMPPat.setString(6, P_FAMILY_NAME) ;
					pstmtMPPat.setString(7, P_FIRST_NAME) ;
					pstmtMPPat.setString(8, P_PATIENT_NAME) ;
					pstmtMPPat.setString(9, nationality_code) ;
					pstmtMPPat.setString(10, addedById) ;
					pstmtMPPat.setString(11, AddedAtWsNo) ;
					pstmtMPPat.setString(12, facility_id) ;
					pstmtMPPat.setString(13, addedById) ;
					pstmtMPPat.setString(14, AddedAtWsNo) ;
					pstmtMPPat.setString(15, facility_id) ;
					if(isVisitAdmTimeUpdate.equals("Y")){
						pstmtMPPat.setString(16, visit_date) ;
						pstmtMPPat.setString(17, facility_id) ;
					}else{
						pstmtMPPat.setString(16, facility_id) ;
					}
					rsetMPPat =  pstmtMPPat.executeUpdate();
						if(rsetMPPat > 0)
							result	=	true;
						else
							result	=	false;
					}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPat:"+e.toString());
						result	=	false;
					}
			}
			if(result)	{
				try{
					pstmtMPPatOth.setString(1, P_PATIENT_ID) ;
					pstmtMPPatOth.setString(2, remarks) ;
					pstmtMPPatOth.setString(3, addedById) ;
					pstmtMPPatOth.setString(4, AddedAtWsNo) ;
					pstmtMPPatOth.setString(5, facility_id) ;
					pstmtMPPatOth.setString(6, addedById) ;
					pstmtMPPatOth.setString(7, AddedAtWsNo) ;
					pstmtMPPatOth.setString(8, facility_id) ;

					rsetMPPatOth =  pstmtMPPatOth.executeUpdate();
					if(rsetMPPatOth > 0)
						result	=	true;
					else
						result	=	false;
					}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPatOth:"+e.toString());
						result	=	false;
					}
			}
			if(result) {
				try{
					pstmtMPPatAdd.setString(1, P_PATIENT_ID) ;
					pstmtMPPatAdd.setString(2, addedById) ;
					pstmtMPPatAdd.setString(3, AddedAtWsNo) ;
					pstmtMPPatAdd.setString(4, facility_id) ;
					pstmtMPPatAdd.setString(5, addedById) ;
					pstmtMPPatAdd.setString(6, AddedAtWsNo) ;
					pstmtMPPatAdd.setString(7, facility_id) ;

					rsetMPPatAdd =  pstmtMPPatAdd.executeUpdate();
					if(rsetMPPatAdd > 0)
						result	=	true;
					else
						result	=	false;
					}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPatAdd:"+e.toString());
						result	=	false;
					}
			}
			if(result) {
				try{
	 				pstmtMPPatRel.setString(1, P_PATIENT_ID) ;
					pstmtMPPatRel.setString(2, addedById) ;
					pstmtMPPatRel.setString(3, AddedAtWsNo) ;
					pstmtMPPatRel.setString(4, facility_id) ;
					pstmtMPPatRel.setString(5, addedById) ;
					pstmtMPPatRel.setString(6, AddedAtWsNo) ;
					pstmtMPPatRel.setString(7, facility_id) ;

					rsetMPPatRel =  pstmtMPPatRel.executeUpdate();
					if(rsetMPPatRel > 0)
						result	=	true;
					else
						result	=	false;
				}catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in MPPatRel:"+e.toString());
					result	=	false;
				}
			}

			if(result)
		{
			if (bl_install_yn.equals("Y") && is_financial_captured.equals("Y"))
			{
			  try
	 		  {

                 billing_group         = 	 request.getParameter("billing_group");
				 Hashtable blTabdata = new Hashtable();
				 String strMessage = "";

				 blTabdata.put("calling_function_id","DISASTER_EMER_REGN");
				 blTabdata.put("pat_ser_grp_code",pat_ser_grp_code);
				 blTabdata.put("credit_auth_user_id","");
				 blTabdata.put("locale",locale);
				 blTabdata.put("patient_id_new", P_PATIENT_ID);
				 blTabdata.put("facility_id",facility_id);
				 blTabdata.put("operation_mode","I");
				 blTabdata.put("added_at_ws_no",AddedAtWsNo);
				 blTabdata.put("added_by_id",addedById);
				 //blTabdata.put("billing_group",billing_group);
				 blTabdata.put("billing_group",dflt_disaster_blng_grp_id);
				 blTabdata.put("dflt_pat_regn_blng_class",emer_blng_class_code);
		            blmpin.BLMPInterface blPatReg = new blmpin.BLMPInterface();
					Hashtable resultsBL = blPatReg.billPatientService(p,con,blTabdata);
					boolean boolRes = ((Boolean) (resultsBL.get("transaction_completed"))).booleanValue();

					if (boolRes == false)
					{
					  result = false;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 if (boolRes == true)
					 {
					  result = true;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 blTabdata.clear();
				     resultsBL.clear();
 				     //sb.append("<br>End Update Billing ") ;

                 }catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in billing Bean BLMPInterface :"+e.toString());
					result	=	false;
				}
			}
		  }

		  if(result){
			MALE_ADULT_CNT--;

			if ( (!facility_id.equals("")) &&  (!visit_type.equals("null")) &&  (!P_PATIENT_ID.equals("")) && (!VISIT_ADM_TYPE_IND.equals("null")) &&  (!service_code.equals("")) &&  (!arrival_mode.equals("null")) &&  (!AddedAtWsNo.equals("")) &&  (!clinic_code.equals("")) &&  (!priority_zone.equals("")) && (!addedById.equals("")) &&  (!SPECIALITY_CODE.equals("")) &&  (!AddedFacilityID.equals("")) &&  (!reasonforvisit.equals("null")) ) {
				V_ENCOUNTER_ID = 0;

		  	        encounter_id = GENERATE_MULTIPLE_ATTENDANCE(
				facility_id, P_PATIENT_ID, visit_type, VISIT_ADM_TYPE_IND,
				clinic_code, service_code, SPECIALITY_CODE,
				arrival_mode,reasonforvisit,priority_zone,addedById,
				AddedAtWsNo, V_ENCOUNTER_ID);
					epsode_id=GET_EPISODE(facility_id,encounter_id);

						Long ep=new Long(epsode_id);

						epsode_id1=ep.toString();
						if(episode_ids.toString().equals("")){
							episode_ids.append(epsode_id1);
						}else
						{
							episode_ids.append(":");
							episode_ids.append(epsode_id1);
						}

				Long e = new Long(encounter_id);
				P_encounter_id1 = e.toString();
				if (P_encounter_ids.toString().equals(""))  {
					P_encounter_ids.append(P_encounter_id1);
				}  else  {
					P_encounter_ids.append(":");
					P_encounter_ids.append(P_encounter_id1);
				}
				if ((v_cnt1==0) && (v_cnt2==0) && (v_cnt3==1)) {
					P_START_ENCOUNTER_ID = encounter_id;
				}

				P_END_ENCOUNTER_ID = encounter_id;
			}//end of if
		  }else{
			  break;
		  }// end if

		}//end of for

		v_cnt4 =0;
		for(int i=0;FEMALE_ADULT_CNT>0;i++) {
			v_cnt4 = v_cnt4 + 1;
			sex="F";
			try{
				//ADDED FROM HERE
				 csPat.setString( 1 ,pat_ser_grp_code );
	            // csPat.setString( 2 ,P_FACILITY_ID );
				  csPat.setString( 2 ,P_CTRL_ID );
	             csPat.setString( 3 ,alt_id1_no  );
	             csPat.setString( 4 ,rel_level_code );
	             csPat.setString( 5 ,sex );
	             csPat.registerOutParameter(6,Types.VARCHAR);
	             csPat.registerOutParameter(7,Types.VARCHAR);

	             csPat.execute();


				 P_PATIENT_ID		   = csPat.getString(6);
				 p_err_msg		        = csPat.getString(7);

				 if (P_PATIENT_ID==null)
				 {
					 P_PATIENT_ID = "";
				 }
				 if (p_err_msg==null)
				 {
					 p_err_msg = "";
				 }

			if(!p_err_msg.equals(""))
				{
				java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_GEN_PAT_ID","MP");
				errors = ((String) message.get("message"));
				sb.append(errors+": ** PATIENT SERIES GROUP EXHAUSTED **");
				result = false;
			     throw new Exception("");

				}


				else
				{
					result = true;
				}
				if(result)
				{
					if (P_patient_ids.toString().equals(""))  {
							P_patient_ids.append(P_PATIENT_ID);
						 } else {
							P_patient_ids.append(":");
							P_patient_ids.append(P_PATIENT_ID);
						 }
				}
			}catch(Exception e){
				e.printStackTrace();
				//sb.append("Exception in PatNo:"+e.toString());
            }

			if (PAT_NAME.equals("N")) {
				P_FAMILY_NAME = "Unknown Adult Female";
				P_PATIENT_NAME =P_FAMILY_NAME;
			}else{
				P_FIRST_NAME = "Unknown Adult";
				P_FAMILY_NAME = " Female";
				P_PATIENT_NAME = P_FIRST_NAME + P_FAMILY_NAME;
			}
			
			/** Modified against HSA-CRF-0153**/
			if("Y".equalsIgnoreCase(GEN_SLNO_YN) && bDaysrlFunction)
			{
				P_PATIENT_NAME  	= GetDaySrlNo(sex);
				P_FAMILY_NAME 		= P_PATIENT_NAME;
			}
			
			if(result) {
				try{
					pstmtMPPat.setString(1, P_PATIENT_ID) ;
					pstmtMPPat.setString(2, pat_ser_grp_code) ;
					pstmtMPPat.setString(3, facility_id) ;
					pstmtMPPat.setString(4, sex) ;
					pstmtMPPat.setString(5, DATE_OF_BIRTH_FEMALE_ADULT) ;
					pstmtMPPat.setString(6, P_FAMILY_NAME) ;
					pstmtMPPat.setString(7, P_FIRST_NAME) ;
					pstmtMPPat.setString(8, P_PATIENT_NAME) ;
					pstmtMPPat.setString(9, nationality_code) ;
					pstmtMPPat.setString(10, addedById) ;
					pstmtMPPat.setString(11, AddedAtWsNo) ;
					pstmtMPPat.setString(12, facility_id) ;
					pstmtMPPat.setString(13, addedById) ;
					pstmtMPPat.setString(14, AddedAtWsNo) ;
					pstmtMPPat.setString(15, facility_id) ;
					if(isVisitAdmTimeUpdate.equals("Y")){
						pstmtMPPat.setString(16, visit_date) ;
						pstmtMPPat.setString(17, facility_id) ;
					}else{
						pstmtMPPat.setString(16, facility_id) ;
					}

					rsetMPPat =  pstmtMPPat.executeUpdate();
					if(rsetMPPat > 0)
						result	=	true;
					else
						result	=	false;
					}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPat:"+e.toString());
						result	=	false;
					}
			}
			if(result) {
				try{
					pstmtMPPatOth.setString(1, P_PATIENT_ID) ;
					pstmtMPPatOth.setString(2, remarks) ;
					pstmtMPPatOth.setString(3, addedById) ;
					pstmtMPPatOth.setString(4, AddedAtWsNo) ;
					pstmtMPPatOth.setString(5, facility_id) ;
					pstmtMPPatOth.setString(6, addedById) ;
					pstmtMPPatOth.setString(7, AddedAtWsNo) ;
					pstmtMPPatOth.setString(8, facility_id) ;

					rsetMPPatOth =  pstmtMPPatOth.executeUpdate();
					if(rsetMPPatOth > 0)
						result	=	true;
					else
					result	=	false;
					}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPatOth:"+e.toString());
						result	=	false;
					}
			}
			if(result) {
				try{
					pstmtMPPatAdd.setString(1, P_PATIENT_ID) ;
					pstmtMPPatAdd.setString(2, addedById) ;
					pstmtMPPatAdd.setString(3, AddedAtWsNo) ;
					pstmtMPPatAdd.setString(4, facility_id) ;
					pstmtMPPatAdd.setString(5, addedById) ;
					pstmtMPPatAdd.setString(6, AddedAtWsNo) ;
					pstmtMPPatAdd.setString(7, facility_id) ;

					rsetMPPatAdd =  pstmtMPPatAdd.executeUpdate();
					if(rsetMPPatAdd > 0)
						result	=	true;
					else
						result	=	false;
					}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPatAdd:"+e.toString());
						result	=	false;
					}
			}
			if(result)	 {
				try{
					pstmtMPPatRel.setString(1, P_PATIENT_ID) ;
					pstmtMPPatRel.setString(2, addedById) ;
					pstmtMPPatRel.setString(3, AddedAtWsNo) ;
					pstmtMPPatRel.setString(4, facility_id) ;
					pstmtMPPatRel.setString(5, addedById) ;
					pstmtMPPatRel.setString(6, AddedAtWsNo) ;
					pstmtMPPatRel.setString(7, facility_id) ;

					rsetMPPatRel =  pstmtMPPatRel.executeUpdate();
					if(rsetMPPatRel > 0)
						result	=	true;
					else
						result	=	false;
				}catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in MPPatRel:"+e.toString());
					result	=	false;
				}
			}

			if(result)
		{
			if (bl_install_yn.equals("Y") && is_financial_captured.equals("Y"))
			{
			  try
	 		  {

                 billing_group         = 	 request.getParameter("billing_group");
				 Hashtable blTabdata = new Hashtable();
				 String strMessage = "";

				 blTabdata.put("calling_function_id","DISASTER_EMER_REGN");
				 blTabdata.put("pat_ser_grp_code",pat_ser_grp_code);
				 blTabdata.put("credit_auth_user_id","");
				 blTabdata.put("locale",locale);
				 blTabdata.put("patient_id_new", P_PATIENT_ID);
				 blTabdata.put("facility_id",facility_id);
				 blTabdata.put("operation_mode","I");
				 blTabdata.put("added_at_ws_no",AddedAtWsNo);
				 blTabdata.put("added_by_id",addedById);
				 //blTabdata.put("billing_group",billing_group);
				 blTabdata.put("billing_group",dflt_disaster_blng_grp_id);
				 blTabdata.put("dflt_pat_regn_blng_class",emer_blng_class_code);
		            blmpin.BLMPInterface blPatReg = new blmpin.BLMPInterface();
					Hashtable resultsBL = blPatReg.billPatientService(p,con,blTabdata);
					boolean boolRes = ((Boolean) (resultsBL.get("transaction_completed"))).booleanValue();

					if (boolRes == false)
					{
					  result = false;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 if (boolRes == true)
					 {
					  result = true;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 blTabdata.clear();
				     resultsBL.clear();
 				     //sb.append("<br>End Update Billing ") ;

                 }catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in billing Bean BLMPInterface :"+e.toString());
					result	=	false;
				}
			}
		  }

		  if(result){

			FEMALE_ADULT_CNT--;

			if ( (!facility_id.equals("")) &&  (!visit_type.equals("null")) &&  (!P_PATIENT_ID.equals("")) && (!VISIT_ADM_TYPE_IND.equals("null")) &&  (!service_code.equals("")) &&  (!arrival_mode.equals("null")) &&  (!AddedAtWsNo.equals("")) &&  (!clinic_code.equals("")) &&  (!priority_zone.equals("")) && (!addedById.equals("")) &&  (!SPECIALITY_CODE.equals("")) &&  (!AddedFacilityID.equals("")) &&  (!reasonforvisit.equals("null")) ) {
				V_ENCOUNTER_ID = 0;

				encounter_id = GENERATE_MULTIPLE_ATTENDANCE(
				facility_id, P_PATIENT_ID, visit_type, VISIT_ADM_TYPE_IND,
				clinic_code, service_code, SPECIALITY_CODE,
				arrival_mode,reasonforvisit,priority_zone,addedById,
				AddedAtWsNo, V_ENCOUNTER_ID);
				epsode_id=GET_EPISODE(facility_id,encounter_id);

						Long ep=new Long(epsode_id);

						epsode_id1=ep.toString();
						if(episode_ids.toString().equals("")){
							episode_ids.append(epsode_id1);
						}else
						{
							episode_ids.append(":");
							episode_ids.append(epsode_id1);
						}

				Long e = new Long(encounter_id);
				P_encounter_id1 = e.toString();
				if (P_encounter_ids.toString().equals("")) {
					P_encounter_ids.append(P_encounter_id1);
				} else {
					P_encounter_ids.append(":");
					P_encounter_ids.append(P_encounter_id1);
				}
				if ((v_cnt1==0) && (v_cnt2==0) && (v_cnt3==0) && (v_cnt4==1)){
				P_START_ENCOUNTER_ID = encounter_id;
			 }

			 P_END_ENCOUNTER_ID = encounter_id;
		}//end of if
	  }else{
		  break;
			}// end of if
	}//end of for
	v_cnt5 = 0;
	for(int i=0;FEMALE_CHILD_CNT>0;i++) {
		v_cnt5 = v_cnt5 + 1;
		sex="F";
		try{
//ADDED FROM HERE
				 csPat.setString( 1 ,pat_ser_grp_code );
	             //csPat.setString( 2 ,P_FACILITY_ID );
				  csPat.setString( 2 ,P_CTRL_ID );
	             csPat.setString( 3 ,alt_id1_no  );
	             csPat.setString( 4 ,rel_level_code );
	             csPat.setString( 5 ,sex );
	             csPat.registerOutParameter(6,Types.VARCHAR);
	             csPat.registerOutParameter(7,Types.VARCHAR);

	             csPat.execute();


				 P_PATIENT_ID		   = csPat.getString(6);
				 p_err_msg		        = csPat.getString(7);


				 if (P_PATIENT_ID==null)
				 {
					 P_PATIENT_ID = "";
				 }
				 if (p_err_msg==null)
				 {
					 p_err_msg = "";
				 }

			if(!p_err_msg.equals(""))
				{
				java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_GEN_PAT_ID","MP");
				errors = ((String) message.get("message"));
				sb.append(errors+": ** PATIENT SERIES GROUP EXHAUSTED **");
				result = false;
			throw new Exception("");

				}
				else
				{
					result = true;
				}
				if(result)
				{
					if (P_patient_ids.toString().equals(""))  {
							P_patient_ids.append(P_PATIENT_ID);
						 } else {
							P_patient_ids.append(":");
							P_patient_ids.append(P_PATIENT_ID);
						 }
				}
			}catch(Exception e){
				e.printStackTrace();
            }

		if (PAT_NAME.equals("N")) {
			P_FAMILY_NAME = "Unknown Child Female";
			P_PATIENT_NAME =P_FAMILY_NAME;
		}else{
			P_FIRST_NAME = "Unknown Child";
			P_FAMILY_NAME = " Female";
			P_PATIENT_NAME = P_FIRST_NAME + P_FAMILY_NAME;
		}

		/** Modified against HSA-CRF-0153**/
		if("Y".equalsIgnoreCase(GEN_SLNO_YN) && bDaysrlFunction)
		{
			P_PATIENT_NAME  	= GetDaySrlNo(sex);
			P_FAMILY_NAME 		= P_PATIENT_NAME;
		}
		
	        if(result) {
			try{
				pstmtMPPat.setString(1, P_PATIENT_ID) ;
				pstmtMPPat.setString(2, pat_ser_grp_code) ;
				pstmtMPPat.setString(3, facility_id) ;
				pstmtMPPat.setString(4, sex) ;
				pstmtMPPat.setString(5, DATE_OF_BIRTH_FEMALE_CHILD) ;
				pstmtMPPat.setString(6, P_FAMILY_NAME) ;
				pstmtMPPat.setString(7, P_FIRST_NAME) ;
				pstmtMPPat.setString(8, P_PATIENT_NAME) ;
				pstmtMPPat.setString(9, nationality_code) ;
				pstmtMPPat.setString(10, addedById) ;
				pstmtMPPat.setString(11, AddedAtWsNo) ;
				pstmtMPPat.setString(12, facility_id) ;
				pstmtMPPat.setString(13, addedById) ;
				pstmtMPPat.setString(14, AddedAtWsNo) ;
				pstmtMPPat.setString(15, facility_id) ;
				if(isVisitAdmTimeUpdate.equals("Y")){
					pstmtMPPat.setString(16, visit_date) ;
					pstmtMPPat.setString(17, facility_id) ;
				}else{
					pstmtMPPat.setString(16, facility_id) ;
				}
				rsetMPPat =  pstmtMPPat.executeUpdate();
				if(rsetMPPat > 0)
					result	=	true;
				else
					result	=	false;
					}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPat:"+e.toString());
						result	=	false;
					}
		}
		if(result) {
			try{
				pstmtMPPatOth.setString(1, P_PATIENT_ID) ;
				pstmtMPPatOth.setString(2, remarks) ;
				pstmtMPPatOth.setString(3, addedById) ;
				pstmtMPPatOth.setString(4, AddedAtWsNo) ;
				pstmtMPPatOth.setString(5, facility_id) ;
				pstmtMPPatOth.setString(6, addedById) ;
				pstmtMPPatOth.setString(7, AddedAtWsNo) ;
				pstmtMPPatOth.setString(8, facility_id) ;

				rsetMPPatOth =  pstmtMPPatOth.executeUpdate();
				if(rsetMPPatOth > 0)
					result	=	true;
				else
					result	=	false;
				}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPatOth:"+e.toString());
						result	=	false;
				}
		}
		if(result) {
			try{
				pstmtMPPatAdd.setString(1, P_PATIENT_ID) ;
				pstmtMPPatAdd.setString(2, addedById) ;
				pstmtMPPatAdd.setString(3, AddedAtWsNo) ;
				pstmtMPPatAdd.setString(4, facility_id) ;
				pstmtMPPatAdd.setString(5, addedById) ;
				pstmtMPPatAdd.setString(6, AddedAtWsNo) ;
				pstmtMPPatAdd.setString(7, facility_id) ;

				rsetMPPatAdd =  pstmtMPPatAdd.executeUpdate();
				if(rsetMPPatAdd > 0)
					result	=	true;
				else
					result	=	false;
				}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPatAdd:"+e.toString());
						result	=	false;
				}
		}
		if(result) {
			try{
    				pstmtMPPatRel.setString(1, P_PATIENT_ID) ;
				pstmtMPPatRel.setString(2, addedById) ;
				pstmtMPPatRel.setString(3, AddedAtWsNo) ;
				pstmtMPPatRel.setString(4, facility_id) ;
				pstmtMPPatRel.setString(5, addedById) ;
				pstmtMPPatRel.setString(6, AddedAtWsNo) ;
				pstmtMPPatRel.setString(7, facility_id) ;

				rsetMPPatRel =  pstmtMPPatRel.executeUpdate();
				if(rsetMPPatRel > 0)
					result	=	true;
				else
					result	=	false;
			}catch(Exception e){
				e.printStackTrace();
				sb.append("Exception in MPPatRel:"+e.toString());
				result	=	false;
			}
		}

		if(result)
		{
			if (bl_install_yn.equals("Y") && is_financial_captured.equals("Y"))
			{
			  try
	 		  {

                 billing_group         = 	 request.getParameter("billing_group");
				 Hashtable blTabdata = new Hashtable();
				 String strMessage = "";

				 blTabdata.put("calling_function_id","DISASTER_EMER_REGN");
				 blTabdata.put("pat_ser_grp_code",pat_ser_grp_code);
				 blTabdata.put("credit_auth_user_id","");
				 blTabdata.put("locale",locale);
				 blTabdata.put("patient_id_new", P_PATIENT_ID);
				 blTabdata.put("facility_id",facility_id);
				 blTabdata.put("operation_mode","I");
				 blTabdata.put("added_at_ws_no",AddedAtWsNo);
				 blTabdata.put("added_by_id",addedById);
				 //blTabdata.put("billing_group",billing_group);
				 blTabdata.put("billing_group",dflt_disaster_blng_grp_id);
				 blTabdata.put("dflt_pat_regn_blng_class",emer_blng_class_code);
		            blmpin.BLMPInterface blPatReg = new blmpin.BLMPInterface();
					Hashtable resultsBL = blPatReg.billPatientService(p,con,blTabdata);
					boolean boolRes = ((Boolean) (resultsBL.get("transaction_completed"))).booleanValue();

					if (boolRes == false)
					{
					  result = false;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 if (boolRes == true)
					 {
					  result = true;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 blTabdata.clear();
				     resultsBL.clear();
 				     //sb.append("<br>End Update Billing ") ;

                 }catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in billing Bean BLMPInterface :"+e.toString());
					result	=	false;
				}
			}
		  }
	  if(result){

		FEMALE_CHILD_CNT--;
		if ( (!facility_id.equals("")) &&  (!visit_type.equals("null")) &&  (!P_PATIENT_ID.equals("")) && (!VISIT_ADM_TYPE_IND.equals("null")) &&  (!service_code.equals("")) &&  (!arrival_mode.equals("null")) &&  (!AddedAtWsNo.equals("")) &&  (!clinic_code.equals("")) &&  (!priority_zone.equals("")) && (!addedById.equals("")) &&  (!SPECIALITY_CODE.equals("")) &&  (!AddedFacilityID.equals("")) &&  (!reasonforvisit.equals("null")) ) {
			V_ENCOUNTER_ID = 0;
		        encounter_id = GENERATE_MULTIPLE_ATTENDANCE(
			facility_id, P_PATIENT_ID, visit_type, VISIT_ADM_TYPE_IND,
			clinic_code, service_code, SPECIALITY_CODE,
			arrival_mode,reasonforvisit,priority_zone,addedById,
			AddedAtWsNo, V_ENCOUNTER_ID);
				epsode_id=GET_EPISODE(facility_id,encounter_id);

						Long ep=new Long(epsode_id);

						epsode_id1=ep.toString();
						if(episode_ids.toString().equals("")){
							episode_ids.append(epsode_id1);
						}else
						{
							episode_ids.append(":");
							episode_ids.append(epsode_id1);
						}

			Long e = new Long(encounter_id);
			P_encounter_id1 = e.toString();
			if (P_encounter_ids.toString().equals("")) {
				P_encounter_ids.append(P_encounter_id1);
			} else {
				P_encounter_ids.append(":");
				P_encounter_ids.append(P_encounter_id1);
			}
			if ((v_cnt1==0) && (v_cnt2==0) && (v_cnt3==0) && (v_cnt4==0) && (v_cnt5==1)) {
				P_START_ENCOUNTER_ID = encounter_id;
			}
			P_END_ENCOUNTER_ID = encounter_id;
		}//end of if
	  }else{
		  break;
	  }//end if
	}//end of for
	v_cnt6 = 0;
	for(int i=0;FEMALE_INFANT_CNT>0;i++)  {
		v_cnt6 = v_cnt6 + 1;
		sex="F";
		try{
//ADDED FROM HERE
				 csPat.setString( 1 ,pat_ser_grp_code );
				 //csPat.setString( 2 ,P_FACILITY_ID );
				  csPat.setString( 2 ,P_CTRL_ID );
	             csPat.setString( 3 ,alt_id1_no  );
	             csPat.setString( 4 ,rel_level_code );
	             csPat.setString( 5 ,sex );
	             csPat.registerOutParameter(6,Types.VARCHAR);
	             csPat.registerOutParameter(7,Types.VARCHAR);

	             csPat.execute();


				 P_PATIENT_ID		   = csPat.getString(6);
				 p_err_msg		        = csPat.getString(7);

				 if (P_PATIENT_ID==null)
				 {
					 P_PATIENT_ID = "";
				 }
				 if (p_err_msg==null)
				 {
					 p_err_msg = "";
				 }
/*
				if  (!p_err_msg.equals(""))
				{
					sb.append("Error in Gen Patient Id" + MessageManager.getMessage(locale,"ERROR_GEN_PAT_ID","MP")) ;
					result = false;
					throw new Exception("");
				}
*/
						if(!p_err_msg.equals(""))
				{
				java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_GEN_PAT_ID","MP");
				errors = ((String) message.get("message"));
				sb.append(errors+": **PATIENT SERIES GROUP EXHAUSTED**");
				result = false;
				throw new Exception("");

				}
				else
				{
					result = true;
				}
				if(result)
				{
					if (P_patient_ids.toString().equals(""))  {
							P_patient_ids.append(P_PATIENT_ID);
						 } else {
							P_patient_ids.append(":");
							P_patient_ids.append(P_PATIENT_ID);
						 }
				}
			}catch(Exception e){
				e.printStackTrace();
            }

             if (PAT_NAME.equals("N"))
             {
				 P_FAMILY_NAME = "Unknown Infant Female";
                 P_PATIENT_NAME =P_FAMILY_NAME;
             }else{
			     P_FIRST_NAME = "Unknown Infant";
				 P_FAMILY_NAME = " Female";
				 P_PATIENT_NAME = P_FIRST_NAME + P_FAMILY_NAME;
			 }

             /** Modified against HSA-CRF-0153**/
             if("Y".equalsIgnoreCase(GEN_SLNO_YN) && bDaysrlFunction)
				{
            	 P_PATIENT_NAME  	= GetDaySrlNo(sex);
				 P_FAMILY_NAME 		= P_PATIENT_NAME;
				}
				
        if(result)
		{
           try{

						   pstmtMPPat.setString(1, P_PATIENT_ID) ;
						   pstmtMPPat.setString(2, pat_ser_grp_code) ;
						   pstmtMPPat.setString(3, facility_id) ;
						   pstmtMPPat.setString(4, sex) ;
						   pstmtMPPat.setString(5, DATE_OF_BIRTH_FEMALE_INFANT) ;
						   pstmtMPPat.setString(6, P_FAMILY_NAME) ;
						   pstmtMPPat.setString(7, P_FIRST_NAME) ;
                           pstmtMPPat.setString(8, P_PATIENT_NAME) ;
						   pstmtMPPat.setString(9, nationality_code) ;
						   pstmtMPPat.setString(10, addedById) ;
						   pstmtMPPat.setString(11, AddedAtWsNo) ;
                           pstmtMPPat.setString(12, facility_id) ;
						   pstmtMPPat.setString(13, addedById) ;
						   pstmtMPPat.setString(14, AddedAtWsNo) ;
                           pstmtMPPat.setString(15, facility_id) ;
						   if(isVisitAdmTimeUpdate.equals("Y")){
								pstmtMPPat.setString(16, visit_date) ;
								pstmtMPPat.setString(17, facility_id) ;
						   }else{
								pstmtMPPat.setString(16, facility_id) ;
						   }
						   rsetMPPat =  pstmtMPPat.executeUpdate();
							if(rsetMPPat > 0)
									result	=	true;
							else
									result	=	false;
					}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPat:"+e.toString());
						result	=	false;
					}
		}
         if(result)
		{
			 try{

						   pstmtMPPatOth.setString(1, P_PATIENT_ID) ;
						   pstmtMPPatOth.setString(2, remarks) ;
						   pstmtMPPatOth.setString(3, addedById) ;
						   pstmtMPPatOth.setString(4, AddedAtWsNo) ;
						   pstmtMPPatOth.setString(5, facility_id) ;
						   pstmtMPPatOth.setString(6, addedById) ;
						   pstmtMPPatOth.setString(7, AddedAtWsNo) ;
						   pstmtMPPatOth.setString(8, facility_id) ;

						   rsetMPPatOth =  pstmtMPPatOth.executeUpdate();
							if(rsetMPPatOth > 0)
									result	=	true;
							else
									result	=	false;
				}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPatOth:"+e.toString());
						result	=	false;
				}
		}
        if(result)
		{
			try{

						   pstmtMPPatAdd.setString(1, P_PATIENT_ID) ;
						   pstmtMPPatAdd.setString(2, addedById) ;
						   pstmtMPPatAdd.setString(3, AddedAtWsNo) ;
						   pstmtMPPatAdd.setString(4, facility_id) ;
						   pstmtMPPatAdd.setString(5, addedById) ;
						   pstmtMPPatAdd.setString(6, AddedAtWsNo) ;
						   pstmtMPPatAdd.setString(7, facility_id) ;

						   rsetMPPatAdd =  pstmtMPPatAdd.executeUpdate();
							if(rsetMPPatAdd > 0)
									result	=	true;
							else
									result	=	false;
				}catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in MPPatAdd:"+e.toString());
					result	=	false;
				}
        }
        if(result)
		{
			try{
						   pstmtMPPatRel.setString(1, P_PATIENT_ID) ;
						   pstmtMPPatRel.setString(2, addedById) ;
						   pstmtMPPatRel.setString(3, AddedAtWsNo) ;
						   pstmtMPPatRel.setString(4, facility_id) ;
						   pstmtMPPatRel.setString(5, addedById) ;
						   pstmtMPPatRel.setString(6, AddedAtWsNo) ;
						   pstmtMPPatRel.setString(7, facility_id) ;

						   rsetMPPatRel =  pstmtMPPatRel.executeUpdate();
							if(rsetMPPatRel > 0)
									result	=	true;
							else
									result	=	false;
				}catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in MPPatRel:"+e.toString());
					result	=	false;
				}
        }

		if(result)
		{
			if (bl_install_yn.equals("Y") && is_financial_captured.equals("Y"))
			{
			  try
	 		  {

                 billing_group         = 	 request.getParameter("billing_group");
				 Hashtable blTabdata = new Hashtable();
				 String strMessage = "";

				 blTabdata.put("calling_function_id","DISASTER_EMER_REGN");
				 blTabdata.put("pat_ser_grp_code",pat_ser_grp_code);
				 blTabdata.put("credit_auth_user_id","");
				 blTabdata.put("locale",locale);
				 blTabdata.put("patient_id_new", P_PATIENT_ID);
				 blTabdata.put("facility_id",facility_id);
				 blTabdata.put("operation_mode","I");
				 blTabdata.put("added_at_ws_no",AddedAtWsNo);
				 blTabdata.put("added_by_id",addedById);
				 //blTabdata.put("billing_group",billing_group);
				 blTabdata.put("billing_group",dflt_disaster_blng_grp_id);
				 blTabdata.put("dflt_pat_regn_blng_class",emer_blng_class_code);
		            blmpin.BLMPInterface blPatReg = new blmpin.BLMPInterface();
					Hashtable resultsBL = blPatReg.billPatientService(p,con,blTabdata);
					boolean boolRes = ((Boolean) (resultsBL.get("transaction_completed"))).booleanValue();

					if (boolRes == false)
					{
					  result = false;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 if (boolRes == true)
					 {
					  result = true;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 blTabdata.clear();
				     resultsBL.clear();
 				     //sb.append("<br>End Update Billing ") ;

                 }catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in billing Bean BLMPInterface :"+e.toString());
					result	=	false;
				}
			}
		  }

  if(result){
       FEMALE_INFANT_CNT--;

       if ( (!facility_id.equals("")) &&  (!visit_type.equals("null")) &&  (!P_PATIENT_ID.equals("")) && (!VISIT_ADM_TYPE_IND.equals("null")) &&  (!service_code.equals("")) &&  (!arrival_mode.equals("null")) &&  (!AddedAtWsNo.equals("")) &&  (!clinic_code.equals("")) &&  (!priority_zone.equals("")) && (!addedById.equals("")) &&  (!SPECIALITY_CODE.equals("")) &&  (!AddedFacilityID.equals("")) &&  (!reasonforvisit.equals("null")) )
		{
			  V_ENCOUNTER_ID = 0;

		    encounter_id = GENERATE_MULTIPLE_ATTENDANCE(
			facility_id, P_PATIENT_ID, visit_type, VISIT_ADM_TYPE_IND,
			clinic_code, service_code, SPECIALITY_CODE,
			arrival_mode,reasonforvisit,priority_zone,addedById,
			AddedAtWsNo, V_ENCOUNTER_ID);
			epsode_id=GET_EPISODE(facility_id,encounter_id);

						Long ep=new Long(epsode_id);

						epsode_id1=ep.toString();
						if(episode_ids.toString().equals("")){
							episode_ids.append(epsode_id1);
						}else
						{
							episode_ids.append(":");
							episode_ids.append(epsode_id1);
						}

			Long e = new Long(encounter_id);
			P_encounter_id1 = e.toString();
			if (P_encounter_ids.toString().equals(""))
			 {
				 P_encounter_ids.append(P_encounter_id1);
			 }
			 else
			 {
				 P_encounter_ids.append(":");
				 P_encounter_ids.append(P_encounter_id1);
			 }
			if ((v_cnt1==0) && (v_cnt2==0) && (v_cnt3==0) && (v_cnt4==0) && (v_cnt5==0) && (v_cnt6==1)){
				P_START_ENCOUNTER_ID = encounter_id;
			 }

			    P_END_ENCOUNTER_ID = encounter_id;
         }//end of if
      }else{
		  break;
	  }//end if
	}//end of for
    v_cnt7 = 0;
    for(int i=0;UNKNOWN_INFANT_CNT>0;i++)
	 	{
		   v_cnt7 = v_cnt7 + 1;
		   sex="U";
		      try{
//ADDED FROM HERE
				 csPat.setString( 1 ,pat_ser_grp_code );
	             //csPat.setString( 2 ,P_FACILITY_ID );
				  csPat.setString( 2 ,P_CTRL_ID );
	             csPat.setString( 3 ,alt_id1_no  );
	             csPat.setString( 4 ,rel_level_code );
	             csPat.setString( 5 ,sex );
	             csPat.registerOutParameter(6,Types.VARCHAR);
	             csPat.registerOutParameter(7,Types.VARCHAR);

	             csPat.execute();


				 P_PATIENT_ID		   = csPat.getString(6);
				 p_err_msg		        = csPat.getString(7);


				 if (P_PATIENT_ID==null)
				 {
					 P_PATIENT_ID = "";
				 }
				 if (p_err_msg==null)
				 {
					 p_err_msg = "";
				 }

/*				if  (!p_err_msg.equals(""))
				{
					sb.append("Error in Gen Patient Id" + MessageManager.getMessage(locale,"ERROR_GEN_PAT_ID","MP")) ;
					result = false;
					throw new Exception("");
				}
*/
				if(!p_err_msg.equals(""))
				{
				java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_GEN_PAT_ID","MP");
				errors = ((String) message.get("message"));
				sb.append(errors+": ** PATIENT SERIES GROUP EXHAUSTED **");
				result = false;
				throw new Exception("");

				}
				else
				{
					result = true;
				}
				if(result)
				{
					if (P_patient_ids.toString().equals(""))  {
							P_patient_ids.append(P_PATIENT_ID);
						 } else {
							P_patient_ids.append(":");
							P_patient_ids.append(P_PATIENT_ID);
						 }
				}
			}catch(Exception e){
					e.printStackTrace();
            }

             if (PAT_NAME.equals("N"))
             {
				 P_FAMILY_NAME = "Unknown Infant Unknown";
                 P_PATIENT_NAME =P_FAMILY_NAME;
             }else{
			     P_FIRST_NAME = "Unknown Infant";
				 P_FAMILY_NAME = " Unknown";
				 P_PATIENT_NAME = P_FIRST_NAME + P_FAMILY_NAME;
			 }

             /** Modified against HSA-CRF-0153**/
             if("Y".equalsIgnoreCase(GEN_SLNO_YN) && bDaysrlFunction)
				{
            	 P_PATIENT_NAME  	= GetDaySrlNo(sex);
 				 P_FAMILY_NAME 		= P_PATIENT_NAME;
				}
				
        if(result)
		{
           try{
						   pstmtMPPat.setString(1, P_PATIENT_ID) ;
						   pstmtMPPat.setString(2, pat_ser_grp_code) ;
						   pstmtMPPat.setString(3, facility_id) ;
						   pstmtMPPat.setString(4, sex) ;
						   pstmtMPPat.setString(5, DATE_OF_BIRTH_UNKNOWN_INFANT) ;
						   pstmtMPPat.setString(6, P_FAMILY_NAME) ;
						   pstmtMPPat.setString(7, P_FIRST_NAME) ;
                           pstmtMPPat.setString(8, P_PATIENT_NAME) ;
						   pstmtMPPat.setString(9, nationality_code) ;
						   pstmtMPPat.setString(10, addedById) ;
						   pstmtMPPat.setString(11, AddedAtWsNo) ;
                           pstmtMPPat.setString(12, facility_id) ;
						   pstmtMPPat.setString(13, addedById) ;
						   pstmtMPPat.setString(14, AddedAtWsNo) ;
                           pstmtMPPat.setString(15, facility_id) ;
						   if(isVisitAdmTimeUpdate.equals("Y")){
								pstmtMPPat.setString(16, visit_date) ;
								pstmtMPPat.setString(17, facility_id) ;
						   }else{
								pstmtMPPat.setString(16, facility_id) ;
						   }

						   rsetMPPat =  pstmtMPPat.executeUpdate();
							if(rsetMPPat > 0)
									result	=	true;
							else
									result	=	false;
					}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPat:"+e.toString());
						result	=	false;
					}
		}
         if(result)
		{
			 try{

     					   pstmtMPPatOth.setString(1, P_PATIENT_ID) ;
						   pstmtMPPatOth.setString(2, remarks) ;
						   pstmtMPPatOth.setString(3, addedById) ;
						   pstmtMPPatOth.setString(4, AddedAtWsNo) ;
						   pstmtMPPatOth.setString(5, facility_id) ;
						   pstmtMPPatOth.setString(6, addedById) ;
						   pstmtMPPatOth.setString(7, AddedAtWsNo) ;
						   pstmtMPPatOth.setString(8, facility_id) ;

						   rsetMPPatOth =  pstmtMPPatOth.executeUpdate();
							if(rsetMPPatOth > 0)
									result	=	true;
							else
									result	=	false;
				}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPatOth:"+e.toString());
						result	=	false;
				}
		}
        if(result)
		{
			try{
						   pstmtMPPatAdd.setString(1, P_PATIENT_ID) ;
						   pstmtMPPatAdd.setString(2, addedById) ;
						   pstmtMPPatAdd.setString(3, AddedAtWsNo) ;
						   pstmtMPPatAdd.setString(4, facility_id) ;
						   pstmtMPPatAdd.setString(5, addedById) ;
						   pstmtMPPatAdd.setString(6, AddedAtWsNo) ;
						   pstmtMPPatAdd.setString(7, facility_id) ;

						   rsetMPPatAdd =  pstmtMPPatAdd.executeUpdate();
							if(rsetMPPatAdd > 0)
									result	=	true;
							else
									result	=	false;
				}catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in MPPatAdd:"+e.toString());
					result	=	false;
				}
        }
        if(result)
		{
			try{
						   pstmtMPPatRel.setString(1, P_PATIENT_ID) ;
						   pstmtMPPatRel.setString(2, addedById) ;
						   pstmtMPPatRel.setString(3, AddedAtWsNo) ;
						   pstmtMPPatRel.setString(4, facility_id) ;
						   pstmtMPPatRel.setString(5, addedById) ;
						   pstmtMPPatRel.setString(6, AddedAtWsNo) ;
						   pstmtMPPatRel.setString(7, facility_id) ;

						   rsetMPPatRel =  pstmtMPPatRel.executeUpdate();
							if(rsetMPPatRel > 0)
									result	=	true;
							else
									result	=	false;
				}catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in MPPatRel:"+e.toString());
					result	=	false;
				}
        }
		if(result)
		{
			if (bl_install_yn.equals("Y") && is_financial_captured.equals("Y"))
			{
			  try
	 		  {

                 billing_group         = 	 request.getParameter("billing_group");
				 Hashtable blTabdata = new Hashtable();
				 String strMessage = "";

				 blTabdata.put("calling_function_id","DISASTER_EMER_REGN");
				 blTabdata.put("pat_ser_grp_code",pat_ser_grp_code);
				 blTabdata.put("credit_auth_user_id","");
				 blTabdata.put("locale",locale);
				 blTabdata.put("patient_id_new", P_PATIENT_ID);
				 blTabdata.put("facility_id",facility_id);
				 blTabdata.put("operation_mode","I");
				 blTabdata.put("added_at_ws_no",AddedAtWsNo);
				 blTabdata.put("added_by_id",addedById);
				 //blTabdata.put("billing_group",billing_group);
				 blTabdata.put("billing_group",dflt_disaster_blng_grp_id);
				 blTabdata.put("dflt_pat_regn_blng_class",emer_blng_class_code);
		            blmpin.BLMPInterface blPatReg = new blmpin.BLMPInterface();
					Hashtable resultsBL = blPatReg.billPatientService(p,con,blTabdata);
					boolean boolRes = ((Boolean) (resultsBL.get("transaction_completed"))).booleanValue();

					if (boolRes == false)
					{
					  result = false;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 if (boolRes == true)
					 {
					  result = true;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 blTabdata.clear();
				     resultsBL.clear();
 				     //sb.append("<br>End Update Billing ") ;

                 }catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in billing Bean BLMPInterface :"+e.toString());
					result	=	false;
				}
			}
		  }
  if(result){
       UNKNOWN_INFANT_CNT--;

       if ( (!facility_id.equals("")) &&  (!visit_type.equals("null")) &&  (!P_PATIENT_ID.equals("")) && (!VISIT_ADM_TYPE_IND.equals("null")) &&  (!service_code.equals("")) &&  (!arrival_mode.equals("null")) &&  (!AddedAtWsNo.equals("")) &&  (!clinic_code.equals("")) &&  (!priority_zone.equals("")) && (!addedById.equals("")) &&  (!SPECIALITY_CODE.equals("")) &&  (!AddedFacilityID.equals("")) &&  (!reasonforvisit.equals("null")) )
		{
			  V_ENCOUNTER_ID = 0;

		    encounter_id = GENERATE_MULTIPLE_ATTENDANCE(
			facility_id, P_PATIENT_ID, visit_type, VISIT_ADM_TYPE_IND,
			clinic_code, service_code, SPECIALITY_CODE,
			arrival_mode,reasonforvisit,priority_zone,addedById,
			AddedAtWsNo, V_ENCOUNTER_ID);
			epsode_id=GET_EPISODE(facility_id,encounter_id);

						Long ep=new Long(epsode_id);

						epsode_id1=ep.toString();
						if(episode_ids.toString().equals("")){
							episode_ids.append(epsode_id1);
						}else
						{
							episode_ids.append(":");
							episode_ids.append(epsode_id1);
						}

			Long e = new Long(encounter_id);
			P_encounter_id1 = e.toString();
            if (P_encounter_ids.toString().equals(""))
			 {
				 P_encounter_ids.append(P_encounter_id1);
			 }
			 else
			 {
				 P_encounter_ids.append(":");
				 P_encounter_ids.append(P_encounter_id1);
			 }
			if ((v_cnt1==0) && (v_cnt2==0) && (v_cnt3==0) && (v_cnt4==0) && (v_cnt5==0) && (v_cnt6==0) && (v_cnt7==1)) {
				P_START_ENCOUNTER_ID = encounter_id;
			 }

			    P_END_ENCOUNTER_ID = encounter_id;
         }//end of if
      }else{
		  break;
	  }// end if
	}//end of for
    v_cnt8 = 0;
    for(int i=0;UNKNOWN_CHILD_CNT>0;i++)
	 	{
		   v_cnt8 = v_cnt8 + 1;
		   sex="U";
		      try{
//ADDED FROM HERE
				 csPat.setString( 1 ,pat_ser_grp_code );
	             //csPat.setString( 2 ,P_FACILITY_ID );
				  csPat.setString( 2 ,P_CTRL_ID );
	             csPat.setString( 3 ,alt_id1_no  );
	             csPat.setString( 4 ,rel_level_code );
	             csPat.setString( 5 ,sex );
	             csPat.registerOutParameter(6,Types.VARCHAR);
	             csPat.registerOutParameter(7,Types.VARCHAR);

	             csPat.execute();


				 P_PATIENT_ID		   = csPat.getString(6);
				 p_err_msg		        = csPat.getString(7);


				 if (P_PATIENT_ID==null)
				 {
					 P_PATIENT_ID = "";
				 }
				 if (p_err_msg==null)
				 {
					 p_err_msg = "";
				 }
	/*			if  (!p_err_msg.equals(""))
				{
					sb.append("Error in Gen Patient Id" + MessageManager.getMessage(locale,"ERROR_GEN_PAT_ID","MP")) ;
					result = false;
					throw new Exception("");
				}
*/

				if(!p_err_msg.equals(""))
				{
				java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_GEN_PAT_ID","MP");
				errors = ((String) message.get("message"));
				sb.append(errors+": ** PATIENT SERIES GROUP EXHAUSTED **");
				result = false;
			throw new Exception("");

				}
				else
				{
					result = true;
				}
				if(result)
				{
					if (P_patient_ids.toString().equals(""))  {
							P_patient_ids.append(P_PATIENT_ID);
						 } else {
							P_patient_ids.append(":");
							P_patient_ids.append(P_PATIENT_ID);
						 }
				}

			}catch(Exception e){
				e.printStackTrace();
            }

             if (PAT_NAME.equals("N"))
             {
				 P_FAMILY_NAME = "Unknown Child Unknown";
                 P_PATIENT_NAME =P_FAMILY_NAME;
             }else{
			     P_FIRST_NAME = "Unknown Child";
				 P_FAMILY_NAME = " Unknown";
				 P_PATIENT_NAME = P_FIRST_NAME + P_FAMILY_NAME;
			 }

             /** Modified against HSA-CRF-0153**/
             if("Y".equalsIgnoreCase(GEN_SLNO_YN) && bDaysrlFunction)
				{
            	 	P_PATIENT_NAME  	= GetDaySrlNo(sex);
					P_FAMILY_NAME 		= P_PATIENT_NAME;
				}

        if(result)
		{
           try{

						   pstmtMPPat.setString(1, P_PATIENT_ID) ;
						   pstmtMPPat.setString(2, pat_ser_grp_code) ;
						   pstmtMPPat.setString(3, facility_id) ;
						   pstmtMPPat.setString(4, sex) ;
						   pstmtMPPat.setString(5, DATE_OF_BIRTH_UNKNOWN_CHILD) ;
						   pstmtMPPat.setString(6, P_FAMILY_NAME) ;
						   pstmtMPPat.setString(7, P_FIRST_NAME) ;
                           pstmtMPPat.setString(8, P_PATIENT_NAME) ;
						   pstmtMPPat.setString(9, nationality_code) ;
						   pstmtMPPat.setString(10, addedById) ;
						   pstmtMPPat.setString(11, AddedAtWsNo) ;
                           pstmtMPPat.setString(12, facility_id) ;
						   pstmtMPPat.setString(13, addedById) ;
						   pstmtMPPat.setString(14, AddedAtWsNo) ;
                           pstmtMPPat.setString(15, facility_id) ;
							if(isVisitAdmTimeUpdate.equals("Y")){
								pstmtMPPat.setString(16, visit_date) ;
								pstmtMPPat.setString(17, facility_id) ;
							}else{
								pstmtMPPat.setString(16, facility_id) ;
							}

						   rsetMPPat =  pstmtMPPat.executeUpdate();
							if(rsetMPPat > 0)
									result	=	true;
							else
									result	=	false;
					}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPat:"+e.toString());
						result	=	false;
					}
		}
         if(result)
		{
			 try{

	         			   pstmtMPPatOth.setString(1, P_PATIENT_ID) ;
						   pstmtMPPatOth.setString(2, remarks) ;
						   pstmtMPPatOth.setString(3, addedById) ;
						   pstmtMPPatOth.setString(4, AddedAtWsNo) ;
						   pstmtMPPatOth.setString(5, facility_id) ;
						   pstmtMPPatOth.setString(6, addedById) ;
						   pstmtMPPatOth.setString(7, AddedAtWsNo) ;
						   pstmtMPPatOth.setString(8, facility_id) ;

						   rsetMPPatOth =  pstmtMPPatOth.executeUpdate();
							if(rsetMPPatOth > 0)
									result	=	true;
							else
									result	=	false;
				}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPatOth:"+e.toString());
						result	=	false;
				}
		}
        if(result)
		{
			try{

						   pstmtMPPatAdd.setString(1, P_PATIENT_ID) ;
						   pstmtMPPatAdd.setString(2, addedById) ;
						   pstmtMPPatAdd.setString(3, AddedAtWsNo) ;
						   pstmtMPPatAdd.setString(4, facility_id) ;
						   pstmtMPPatAdd.setString(5, addedById) ;
						   pstmtMPPatAdd.setString(6, AddedAtWsNo) ;
						   pstmtMPPatAdd.setString(7, facility_id) ;

						   rsetMPPatAdd =  pstmtMPPatAdd.executeUpdate();
							if(rsetMPPatAdd > 0)
									result	=	true;
							else
									result	=	false;
				}catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in MPPatAdd:"+e.toString());
					result	=	false;
				}
        }
        if(result)
		{
			try{

						   pstmtMPPatRel.setString(1, P_PATIENT_ID) ;
						   pstmtMPPatRel.setString(2, addedById) ;
						   pstmtMPPatRel.setString(3, AddedAtWsNo) ;
						   pstmtMPPatRel.setString(4, facility_id) ;
						   pstmtMPPatRel.setString(5, addedById) ;
						   pstmtMPPatRel.setString(6, AddedAtWsNo) ;
						   pstmtMPPatRel.setString(7, facility_id) ;

						   rsetMPPatRel =  pstmtMPPatRel.executeUpdate();
							if(rsetMPPatRel > 0)
									result	=	true;
							else
									result	=	false;
			}catch(Exception e){
				e.printStackTrace();
				sb.append("Exception in MPPatRel:"+e.toString());
				result	=	false;
			}
        }

		if(result)
		{
			if (bl_install_yn.equals("Y") && is_financial_captured.equals("Y"))
			{
			  try
	 		  {

                 billing_group         = 	 request.getParameter("billing_group");
				 Hashtable blTabdata = new Hashtable();
				 String strMessage = "";

				 blTabdata.put("calling_function_id","DISASTER_EMER_REGN");
				 blTabdata.put("pat_ser_grp_code",pat_ser_grp_code);
				 blTabdata.put("credit_auth_user_id","");
				 blTabdata.put("locale",locale);
				 blTabdata.put("patient_id_new", P_PATIENT_ID);
				 blTabdata.put("facility_id",facility_id);
				 blTabdata.put("operation_mode","I");
				 blTabdata.put("added_at_ws_no",AddedAtWsNo);
				 blTabdata.put("added_by_id",addedById);
				 //blTabdata.put("billing_group",billing_group);
				 blTabdata.put("billing_group",dflt_disaster_blng_grp_id);
				 blTabdata.put("dflt_pat_regn_blng_class",emer_blng_class_code);
		            blmpin.BLMPInterface blPatReg = new blmpin.BLMPInterface();
					Hashtable resultsBL = blPatReg.billPatientService(p,con,blTabdata);
					boolean boolRes = ((Boolean) (resultsBL.get("transaction_completed"))).booleanValue();

					if (boolRes == false)
					{
					  result = false;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 if (boolRes == true)
					 {
					  result = true;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 blTabdata.clear();
				     resultsBL.clear();
 				     //sb.append("<br>End Update Billing ") ;

                 }catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in billing Bean BLMPInterface :"+e.toString());
					result	=	false;
				}
			}
		  }

	 if(result){

       UNKNOWN_CHILD_CNT--;

      if ( (!facility_id.equals("")) &&  (!visit_type.equals("null")) &&  (!P_PATIENT_ID.equals("")) && (!VISIT_ADM_TYPE_IND.equals("null")) &&  (!service_code.equals("")) &&  (!arrival_mode.equals("null")) &&  (!AddedAtWsNo.equals("")) &&  (!clinic_code.equals("")) &&  (!priority_zone.equals("")) && (!addedById.equals("")) &&  (!SPECIALITY_CODE.equals("")) &&  (!AddedFacilityID.equals("")) &&  (!reasonforvisit.equals("null")) )
		{
			  V_ENCOUNTER_ID = 0;

		    encounter_id = GENERATE_MULTIPLE_ATTENDANCE(
			facility_id, P_PATIENT_ID, visit_type, VISIT_ADM_TYPE_IND,
			clinic_code, service_code, SPECIALITY_CODE,
			arrival_mode,reasonforvisit,priority_zone,addedById,
			AddedAtWsNo, V_ENCOUNTER_ID);
			epsode_id=GET_EPISODE(facility_id,encounter_id);

						Long ep=new Long(epsode_id);

						epsode_id1=ep.toString();
						if(episode_ids.toString().equals("")){
							episode_ids.append(epsode_id1);
						}else
						{
							episode_ids.append(":");
							episode_ids.append(epsode_id1);
						}

			Long e = new Long(encounter_id);
			P_encounter_id1 = e.toString();

            if (P_encounter_ids.toString().equals(""))
			 {
				 P_encounter_ids.append(P_encounter_id1);
			 }
			 else
			 {
				 P_encounter_ids.append(":");
				 P_encounter_ids.append(P_encounter_id1);
			 }
			if ((v_cnt1==0) && (v_cnt2==0) && (v_cnt3==0) && (v_cnt4==0) && (v_cnt5==0) && (v_cnt6==0) && (v_cnt7==0) && (v_cnt8==1)) {
				P_START_ENCOUNTER_ID = encounter_id;
			 }

			    P_END_ENCOUNTER_ID = encounter_id;
         }//end of if
	 }else{
		 break;
	 }//end if
	}//end of for
    v_cnt9 = 0;
    for(int i=0;UNKNOWN_ADULT_CNT>0;i++)
	 	{
		   v_cnt9 = v_cnt9 + 1;
		   sex="U";
		      try{
//ADDED FROM HERE
				 csPat.setString( 1 ,pat_ser_grp_code );
	             //csPat.setString( 2 ,P_FACILITY_ID );
				  csPat.setString( 2 ,P_CTRL_ID );
	             csPat.setString( 3 ,alt_id1_no  );
	             csPat.setString( 4 ,rel_level_code );
	             csPat.setString( 5 ,sex );
	             csPat.registerOutParameter(6,Types.VARCHAR);
	             csPat.registerOutParameter(7,Types.VARCHAR);

	             csPat.execute();


				 P_PATIENT_ID		   = csPat.getString(6);
				 p_err_msg		        = csPat.getString(7);


				 if (P_PATIENT_ID==null)
				 {
					 P_PATIENT_ID = "";
				 }
				 if (p_err_msg==null)
				 {
					 p_err_msg = "";
				 }

	/*			if  (!p_err_msg.equals(""))
				{
					sb.append("Error in Gen Patient Id" + MessageManager.getMessage(locale,"ERROR_GEN_PAT_ID","MP")) ;
					result = false;
					throw new Exception("");
				}
*/
				if(!p_err_msg.equals(""))
				{
				java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_GEN_PAT_ID","MP");
				errors = ((String) message.get("message"));
				sb.append(errors+": **PATIENT SERIES GROUP EXHAUSTED **");
				result = false;
				throw new Exception("");

				}
				else
				{
					result = true;
				}
				if(result)
				{
					if (P_patient_ids.toString().equals(""))  {
							P_patient_ids.append(P_PATIENT_ID);
						 } else {
							P_patient_ids.append(":");
							P_patient_ids.append(P_PATIENT_ID);
						 }
				}
			}catch(Exception e){
				e.printStackTrace();
            }

             if (PAT_NAME.equals("N"))
             {
				 P_FAMILY_NAME = "Unknown Adult Unknown";
                 P_PATIENT_NAME =P_FAMILY_NAME;
             }else{
			     P_FIRST_NAME = "Unknown Adult";
				 P_FAMILY_NAME = " Unknown";
				 P_PATIENT_NAME = P_FIRST_NAME + P_FAMILY_NAME;
			 }


             /** Modified against HSA-CRF-0153**/
             if("Y".equalsIgnoreCase(GEN_SLNO_YN) && bDaysrlFunction)
				{
            	 	P_PATIENT_NAME  	= GetDaySrlNo(sex);
					P_FAMILY_NAME 		= P_PATIENT_NAME;
				}
				
        if(result)
		{
           try{

						   pstmtMPPat.setString(1, P_PATIENT_ID) ;
						   pstmtMPPat.setString(2, pat_ser_grp_code) ;
						   pstmtMPPat.setString(3, facility_id) ;
						   pstmtMPPat.setString(4, sex) ;
						   pstmtMPPat.setString(5, DATE_OF_BIRTH_UNKNOWN_ADULT) ;
						   pstmtMPPat.setString(6, P_FAMILY_NAME) ;
						   pstmtMPPat.setString(7, P_FIRST_NAME) ;
                           pstmtMPPat.setString(8, P_PATIENT_NAME) ;
						   pstmtMPPat.setString(9, nationality_code) ;
						   pstmtMPPat.setString(10, addedById) ;
						   pstmtMPPat.setString(11, AddedAtWsNo) ;
                           pstmtMPPat.setString(12, facility_id) ;
						   pstmtMPPat.setString(13, addedById) ;
						   pstmtMPPat.setString(14, AddedAtWsNo) ;
                           pstmtMPPat.setString(15, facility_id) ;
							if(isVisitAdmTimeUpdate.equals("Y")){
								pstmtMPPat.setString(16, visit_date) ;
								pstmtMPPat.setString(17, facility_id) ;
							}else{
								pstmtMPPat.setString(16, facility_id) ;
							}

						   rsetMPPat =  pstmtMPPat.executeUpdate();
							if(rsetMPPat > 0)
									result	=	true;
							else
									result	=	false;
					}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPat:"+e.toString());
						result	=	false;
					}
		}
         if(result)
		{
			 try{

						   pstmtMPPatOth.setString(1, P_PATIENT_ID) ;
						   pstmtMPPatOth.setString(2, remarks) ;
						   pstmtMPPatOth.setString(3, addedById) ;
						   pstmtMPPatOth.setString(4, AddedAtWsNo) ;
						   pstmtMPPatOth.setString(5, facility_id) ;
						   pstmtMPPatOth.setString(6, addedById) ;
						   pstmtMPPatOth.setString(7, AddedAtWsNo) ;
						   pstmtMPPatOth.setString(8, facility_id) ;

						   rsetMPPatOth =  pstmtMPPatOth.executeUpdate();
							if(rsetMPPatOth > 0)
									result	=	true;
							else
									result	=	false;
				}catch(Exception e){
						e.printStackTrace();
						sb.append("Exception in MPPatOth:"+e.toString());
						result	=	false;
				}
		}
        if(result)
		{
			try{
     					   pstmtMPPatAdd.setString(1, P_PATIENT_ID) ;
						   pstmtMPPatAdd.setString(2, addedById) ;
						   pstmtMPPatAdd.setString(3, AddedAtWsNo) ;
						   pstmtMPPatAdd.setString(4, facility_id) ;
						   pstmtMPPatAdd.setString(5, addedById) ;
						   pstmtMPPatAdd.setString(6, AddedAtWsNo) ;
						   pstmtMPPatAdd.setString(7, facility_id) ;

						   rsetMPPatAdd =  pstmtMPPatAdd.executeUpdate();
							if(rsetMPPatAdd > 0)
									result	=	true;
							else
									result	=	false;
				}catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in MPPatAdd:"+e.toString());
					result	=	false;
				}
        }
        if(result)
		{
			try{
        				   pstmtMPPatRel.setString(1, P_PATIENT_ID) ;
						   pstmtMPPatRel.setString(2, addedById) ;
						   pstmtMPPatRel.setString(3, AddedAtWsNo) ;
						   pstmtMPPatRel.setString(4, facility_id) ;
						   pstmtMPPatRel.setString(5, addedById) ;
						   pstmtMPPatRel.setString(6, AddedAtWsNo) ;
						   pstmtMPPatRel.setString(7, facility_id) ;

						   rsetMPPatRel =  pstmtMPPatRel.executeUpdate();
							if(rsetMPPatRel > 0)
									result	=	true;
							else
									result	=	false;
				}catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in MPPatRel:"+e.toString());
					result	=	false;
				}
        }

		if(result)
		{
			if (bl_install_yn.equals("Y") && is_financial_captured.equals("Y"))
			{
			  try
	 		  {

                 billing_group         = 	 request.getParameter("billing_group");
				 Hashtable blTabdata = new Hashtable();
				 String strMessage = "";

				 blTabdata.put("calling_function_id","DISASTER_EMER_REGN");
				 blTabdata.put("pat_ser_grp_code",pat_ser_grp_code);
				 blTabdata.put("credit_auth_user_id","");
				 blTabdata.put("locale",locale);
				 blTabdata.put("patient_id_new", P_PATIENT_ID);
				 blTabdata.put("facility_id",facility_id);
				 blTabdata.put("operation_mode","I");
				 blTabdata.put("added_at_ws_no",AddedAtWsNo);
				 blTabdata.put("added_by_id",addedById);
				 //blTabdata.put("billing_group",billing_group);
				 blTabdata.put("billing_group",dflt_disaster_blng_grp_id);
				 blTabdata.put("dflt_pat_regn_blng_class",emer_blng_class_code);
		            blmpin.BLMPInterface blPatReg = new blmpin.BLMPInterface();
					Hashtable resultsBL = blPatReg.billPatientService(p,con,blTabdata);
					boolean boolRes = ((Boolean) (resultsBL.get("transaction_completed"))).booleanValue();

					if (boolRes == false)
					{
					  result = false;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 if (boolRes == true)
					 {
					  result = true;
					  strMessage = (String) resultsBL.get("error");

					  if (strMessage != null)
					  {
					  sb.append(strMessage + " ");
					  }
					 }
					 blTabdata.clear();
					 resultsBL.clear();
 				     //sb.append("<br>End Update Billing ") ;

                 }catch(Exception e){
					e.printStackTrace();
					sb.append("Exception in billing Bean BLMPInterface :"+e.toString());
					result	=	false;
				}
			}
		  }
	 if(result){
       UNKNOWN_ADULT_CNT--;

       if ( (!facility_id.equals("")) &&  (!visit_type.equals("null")) &&  (!P_PATIENT_ID.equals("")) && (!VISIT_ADM_TYPE_IND.equals("null")) &&  (!service_code.equals("")) &&  (!arrival_mode.equals("null")) &&  (!AddedAtWsNo.equals("")) &&  (!clinic_code.equals("")) &&  (!priority_zone.equals("")) && (!addedById.equals("")) &&  (!SPECIALITY_CODE.equals("")) &&  (!AddedFacilityID.equals("")) &&  (!reasonforvisit.equals("null")) )
		{
			  V_ENCOUNTER_ID = 0;

		    encounter_id = GENERATE_MULTIPLE_ATTENDANCE(
			facility_id, P_PATIENT_ID, visit_type, VISIT_ADM_TYPE_IND,
			clinic_code, service_code, SPECIALITY_CODE,
			arrival_mode,reasonforvisit,priority_zone,addedById,
			AddedAtWsNo, V_ENCOUNTER_ID);
			epsode_id=GET_EPISODE(facility_id,encounter_id);

						Long ep=new Long(epsode_id);

						epsode_id1=ep.toString();
						if(episode_ids.toString().equals("")){
							episode_ids.append(epsode_id1);
						}else
						{
							episode_ids.append(":");
							episode_ids.append(epsode_id1);
						}

			Long e = new Long(encounter_id);
			P_encounter_id1 = e.toString();
			if (P_encounter_ids.toString().equals(""))
			 {
				 P_encounter_ids.append(P_encounter_id1);
			 }
			 else
			 {
				 P_encounter_ids.append(":");
				 P_encounter_ids.append(P_encounter_id1);
			 }
			if ((v_cnt1==0) && (v_cnt2==0) && (v_cnt3==0) && (v_cnt4==0) && (v_cnt5==0) && (v_cnt6==0) && (v_cnt7==0) && (v_cnt8==0) && (v_cnt9==1)){
				P_START_ENCOUNTER_ID = encounter_id;
             }

			    P_END_ENCOUNTER_ID = encounter_id;
         }//end of if
	 }else{
		 break;
	 }//end if
	}//end of for
          if(csPat != null)  csPat.close();
		  if(pstmtMPPat!=null) pstmtMPPat.close();
		  if(pstmtMPPatOth!=null) pstmtMPPatOth.close();
		  if(pstmtMPPatAdd!=null) pstmtMPPatAdd.close();
		  if(pstmtMPPatRel!=null) pstmtMPPatRel.close();
      	  StringBuffer messageText= new StringBuffer();
		  String p_passing_local_date   ="";
		  String p_language_id          ="";
		  StringBuffer sqlAEDisaster = new StringBuffer();
		  String start_encounter = "";
		  String end_encounter = "";
		  Long start_encunt = null;
		  Long end_encunt = null;

	  if(result){

		  P_END_PATIENT_ID = P_PATIENT_ID;

		   /**   Added New on May 16 2005  **/

		 start_encunt = new Long (P_START_ENCOUNTER_ID);
		 start_encounter = start_encunt.toString();
		 end_encunt = new Long (P_END_ENCOUNTER_ID);
		 end_encounter = end_encunt.toString();
         if (start_encounter.equals("0"))
         {
			 start_encounter = "";
         }
		 if (end_encounter.equals("0"))
         {
			 end_encounter = "";
         }

		  String patient_idss=P_patient_ids.toString();
   		  java.util.StringTokenizer ptoken1 = new java.util.StringTokenizer(patient_idss,":");
      		no_pats=ptoken1.countTokens();
			if (no_pats>=1)
			{
			    P_START_PATIENT_ID =	ptoken1.nextToken();
			}
		 try{
		 sqlAEDisaster.append("INSERT INTO AE_DISASTER_PAT_REGN ");
		 sqlAEDisaster.append("(FACILITY_ID,REGN_DATE_TIME,PAT_SER_GRP_CODE,");
		 sqlAEDisaster.append("PRIORITY_ZONE,REMARKS,NO_OF_ADULT_MALE,");
		 sqlAEDisaster.append("ADULT_MALE_AGE_IN_YRS,NO_OF_ADULT_FEMALE,");
		 sqlAEDisaster.append("ADULT_FEMALE_AGE_IN_YRS,");
		 sqlAEDisaster.append("NO_OF_ADULT_UNKNOWN,ADULT_UNKNOWN_AGE_IN_YRS,");
         sqlAEDisaster.append("NO_OF_CHILD_MALE,CHILD_MALE_AGE_IN_YRS,");
		 sqlAEDisaster.append("CHILD_MALE_AGE_IN_MTHS,NO_OF_CHILD_FEMALE,");
         sqlAEDisaster.append("CHILD_FEMALE_AGE_IN_YRS,CHILD_FEMALE_AGE_IN_MTHS,");
		 sqlAEDisaster.append("NO_OF_CHILD_UNKNOWN,CHILD_UNKNOWN_AGE_IN_YRS,");
         sqlAEDisaster.append("CHILD_UNKNOWN_AGE_IN_MTHS,");
         sqlAEDisaster.append("NO_OF_INFANT_MALE,");
         sqlAEDisaster.append("INFANT_MALE_AGE_IN_MTHS,");
         sqlAEDisaster.append("INFANT_MALE_AGE_IN_DAYS,");
         sqlAEDisaster.append("NO_OF_INFANT_FEMALE,");
         sqlAEDisaster.append("INFANT_FEMALE_AGE_IN_MTHS,");
         sqlAEDisaster.append("INFANT_FEMALE_AGE_IN_DAYS,");
         sqlAEDisaster.append("NO_OF_INFANT_UNKNOWN,");
         sqlAEDisaster.append("INFANT_UNKNOWN_AGE_IN_MTHS,");
         sqlAEDisaster.append("INFANT_UNKNOWN_AGE_IN_DAYS,");
		 sqlAEDisaster.append("FROM_PATIENT_ID,TO_PATIENT_ID,");
		 sqlAEDisaster.append("CLINIC_CODE,FROM_ENCOUNTER_ID,");
         sqlAEDisaster.append("TO_ENCOUNTER_ID,ADDED_BY_ID,");
         sqlAEDisaster.append("ADDED_DATE ,ADDED_AT_WS_NO,");
         sqlAEDisaster.append("ADDED_FACILITY_ID, ");
         sqlAEDisaster.append("DIS_REGN_REFERENCE,SERVICE_CODE,VISIT_TYPE_CODE,ARRIVAL_CODE) ");
		 sqlAEDisaster.append("  VALUES ");
		 sqlAEDisaster.append("(?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,");
		 sqlAEDisaster.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,");
		 sqlAEDisaster.append("?,?,?,?,SYSDATE,?,?,?,?,?,?) ");
		 pstmtAEDisast	= con.prepareStatement(sqlAEDisaster.toString());

		 pstmtAEDisast.setString(1, facility_id) ;
		 pstmtAEDisast.setString(2, visit_date) ;
		 pstmtAEDisast.setString(3, pat_ser_grp_code) ;
		 pstmtAEDisast.setString(4, priority_zone) ;
		 pstmtAEDisast.setString(5, remarks) ;
		 pstmtAEDisast.setString(6, male_adult_count) ;
		 pstmtAEDisast.setString(7, male_adult_count_age_y) ;
		 pstmtAEDisast.setString(8, female_adult_count) ;
		 pstmtAEDisast.setString(9, female_adult_count_age_y);
		 pstmtAEDisast.setString(10, unknown_adult_count) ;
		 pstmtAEDisast.setString(11, unknown_adult_count_age_y) ;
		 pstmtAEDisast.setString(12, male_child_count) ;
		 pstmtAEDisast.setString(13, male_child_count_age_y) ;
		 pstmtAEDisast.setString(14, male_child_count_age_m) ;
		 pstmtAEDisast.setString(15, female_child_count) ;
		 pstmtAEDisast.setString(16, female_child_count_age_y) ;
		 pstmtAEDisast.setString(17, female_child_count_age_m) ;
         pstmtAEDisast.setString(18, unknown_child_count) ;
		 pstmtAEDisast.setString(19, unknown_child_count_age_y) ;
		 pstmtAEDisast.setString(20, unknown_child_count_age_m) ;
		 pstmtAEDisast.setString(21, male_infant_count) ;
		 pstmtAEDisast.setString(22, male_infant_count_age_m) ;
		 pstmtAEDisast.setString(23, male_infant_count_age_d) ;
         pstmtAEDisast.setString(24, female_infant_count) ;
		 pstmtAEDisast.setString(25, female_infant_count_age_m) ;
         pstmtAEDisast.setString(26, female_infant_count_age_d) ;
         pstmtAEDisast.setString(27, unknown_infant_count) ;
		 pstmtAEDisast.setString(28, unknown_infant_count_age_m) ;
         pstmtAEDisast.setString(29, unknown_infant_count_age_d) ;
		 pstmtAEDisast.setString(30, P_START_PATIENT_ID) ;
		 pstmtAEDisast.setString(31, P_END_PATIENT_ID) ;
		 pstmtAEDisast.setString(32, clinic_code) ;
		 pstmtAEDisast.setString(33, start_encounter) ;
		 pstmtAEDisast.setString(34, end_encounter) ;
		 pstmtAEDisast.setString(35, addedById) ;
		 pstmtAEDisast.setString(36, AddedAtWsNo) ;
		 pstmtAEDisast.setString(37, facility_id) ;
		 pstmtAEDisast.setString(38, Disaster_Reference) ;
		 pstmtAEDisast.setString(39, service_code) ;
		 pstmtAEDisast.setString(40, visit_type) ;
		 pstmtAEDisast.setString(41, arrival_mode) ;


		 rsetAEDisast =  pstmtAEDisast.executeUpdate();
		 if(rsetAEDisast > 0)
				result	=	true;
		 else
				result	=	false;

		 if(pstmtAEDisast!=null) pstmtAEDisast.close();
		 if((sqlAEDisaster != null) && (sqlAEDisaster.length() > 0))
			{
				sqlAEDisaster.delete(0,sqlAEDisaster.length());
			}
		 }catch(Exception e){
			e.printStackTrace();
			sb.append("Exception in Disaster:"+e.toString());
			result	=	false;
		}

		 // if(cs != null) cs.close();
          if (bl_install_yn.equals("Y") && (!(cancel.equals("Cancel"))) && is_financial_captured.equals("Y"))
           {

			String credit_doc_ref_desc    ="";
			String credit_doc_date        ="";
			String cust_code              ="";
			String slmt_type_code         ="";
			String slmt_doc_ref_desc      ="";
			String slmt_doc_ref_date      ="";
			String slmt_doc_remarks       ="";
			String cash_set_type1         ="";
			String cash_insmt_ref1        ="";
			String cash_insmt_date1       ="";
			String cash_insmt_rmks1       ="";
			String cust_1                 ="";
			String credit_doc_ref1        ="";
			String credit_doc_date1       ="";
			String cust_2                 ="";
			String credit_doc_ref2        ="";
			String credit_doc_date2       ="";
			String cust_3                 ="";
			String policy_expiry_date     ="";
			String cash_set_type2         ="";
			String cash_insmt_ref2        ="";
			String cash_insmt_date2       ="";
			String cash_insmt_rmks2       ="";
			String credit_doc_ref3        ="";
			String credit_doc_date3       ="";
			String cred_start_dt1         ="";
			String cred_start_dt2	      ="";
			String cred_start_dt3	      ="";
			String gl_holder_name	      ="0";
			String gl_holder_reln	      ="0";
			String upd_user_flag          ="";
			String recordCnt              ="";
			String billing_mode           ="";
			String recordMode             ="";
			String policy_type            ="";
			String policy_no              ="";
			String non_insur_blng_grp     ="";
			String remarksBL              ="";
			String credit_auth_ref        ="";
			String cust_4                 ="";
			String patientID              ="";
		    String ENCOUNTER_ID1          ="";
			String episodeID              ="";
			String annual_income          ="";
			String family_asset           ="";
			String no_of_dependants       ="";

			Hashtable resultsBL            = null;
			java.sql.Date credit_doc_date_d			= null;
			java.sql.Date slmt_doc_ref_date_d		= null;
			java.sql.Date policy_expiry_date_d		= null;
			int reccnt				 = 0;
			java.text.SimpleDateFormat dateFormat	= new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
			String addedDate			            = dateFormat.format( new java.util.Date() ) ;
			java.sql.Date added_date                = java.sql.Date.valueOf( addedDate ) ;

			recordCnt			  =      request.getParameter("reccnt");
		    billing_mode		  =      request.getParameter("billing_mode");
    		bl_interface_yn       =      request.getParameter("bl_interface_yn");
			bl_install_yn         = 	 request.getParameter("bl_install_yn");
			billing_group         = 	 request.getParameter("billing_group");
			billing_class         = 	 request.getParameter("billing_class");
			cash_set_type1        = 	 request.getParameter("cash_set_type1");
			cash_insmt_ref1       = 	 request.getParameter("cash_insmt_ref1");
			cash_insmt_date1      = 	 request.getParameter("cash_insmt_date1");
			cash_insmt_rmks1      = 	 request.getParameter("cash_insmt_rmks1");
			cust_1                = 	 request.getParameter("cust_1");
			credit_doc_ref1       = 	 request.getParameter("credit_doc_ref1");
			credit_doc_date1      = 	 request.getParameter("credit_doc_date1");
			cust_2                = 	 request.getParameter("cust_2");
			credit_doc_ref2       = 	 request.getParameter("credit_doc_ref2");
			credit_doc_date2      = 	 request.getParameter("credit_doc_date2");
			cust_3                = 	 request.getParameter("cust_3");
			policy_expiry_date    = 	 request.getParameter("policy_expiry_date");
			cash_set_type2        = 	 request.getParameter("cash_set_type2");
			cash_insmt_ref2       = 	 request.getParameter("cash_insmt_ref2");
			cash_insmt_date2      = 	 request.getParameter("cash_insmt_date2");
			cash_insmt_rmks2      = 	 request.getParameter("cash_insmt_rmks2");
			credit_doc_ref3       = 	 request.getParameter("credit_doc_ref3");
			credit_doc_date3      = 	 request.getParameter("credit_doc_date3");
			cred_start_dt1        = 	 request.getParameter("cred_start_dt1");
			cred_start_dt2	      = 	 request.getParameter("cred_start_dt2");
			cred_start_dt3	      = 	 request.getParameter("cred_start_dt3");
			gl_holder_name	      = 	 request.getParameter("gl_holder_name");
			gl_holder_reln	      = 	 request.getParameter("gl_holder_reln");
			gl_holder_name	      = 	 request.getParameter("gl_holder_name");
			gl_holder_reln	      = 	 request.getParameter("gl_holder_reln");
			upd_user_flag         = 	 request.getParameter("upd_user_flag");
			policy_type           = 	 request.getParameter("policy_type");
            policy_no             = 	 request.getParameter("policy_no");
			non_insur_blng_grp    = 	 request.getParameter("non_insur_blng_grp");
			cust_4                = 	 request.getParameter("cust_4");
			remarksBL             = 	 request.getParameter("remarks");
			credit_auth_ref       = 	 request.getParameter("credit_auth_ref");
			annual_income         = 	 request.getParameter("annual_income");

			family_asset          = 	 request.getParameter("family_asset");
			no_of_dependants      = 	 request.getParameter("no_of_dependants");
			if (billing_mode==null) billing_mode="";
			if (credit_auth_ref==null) credit_auth_ref="";
			if (remarksBL==null) remarksBL="";
			if (cust_4==null) cust_4="";
			if(gl_holder_name	==null) gl_holder_name	="";
			if(gl_holder_name.equals("")) gl_holder_name	="0";
			if(no_of_dependants	==null) no_of_dependants	="";
			if(no_of_dependants.equals("")) no_of_dependants	="0";
			if(gl_holder_reln	==null) gl_holder_reln	="";
			if(gl_holder_name.equals("")) gl_holder_name	="0";
			if(non_insur_blng_grp	==null) non_insur_blng_grp	="";
			if(policy_type	==null) policy_type	="";
			if(policy_no	==null) policy_no	="";
			if (user_id == null) user_id ="";
			if (upd_user_flag==null) upd_user_flag = "";
			if(bl_interface_yn==null) bl_interface_yn="";
			if(billing_group == null) billing_group="";
			if(billing_class == null) billing_class="";
			if(cash_set_type1 == null) cash_set_type1="";
			if(cash_insmt_ref1 == null) cash_insmt_ref1="";
			if(cash_insmt_date1 == null) cash_insmt_date1="";
			if(cash_insmt_rmks1 == null) cash_insmt_rmks1="";
			if(cust_1 == null) cust_1="";
			if(credit_doc_ref1 == null) credit_doc_ref1="";
			if(credit_doc_date1 == null) credit_doc_date1="";
			if(cust_2 == null) cust_2="";
			if(credit_doc_ref2 == null) credit_doc_ref2="";
			if(credit_doc_date2 == null) credit_doc_date2="";
			if(cust_3 == null) cust_3="";
			if(policy_expiry_date == null) policy_expiry_date="";
			if(cash_set_type2 == null) cash_set_type2="";
			if(cash_insmt_ref2 == null) cash_insmt_ref2="";
			if(cash_insmt_date2 == null) cash_insmt_date2="";
			if(cash_insmt_rmks2 == null) cash_insmt_rmks2="";
			if(credit_doc_ref3 == null) credit_doc_ref3="";
			if(credit_doc_date3 == null) credit_doc_date3="";
			if(!(credit_doc_ref1.equals(""))) credit_doc_ref_desc=credit_doc_ref1;
			if(!(credit_doc_ref2.equals(""))) credit_doc_ref_desc=credit_doc_ref2;
			if(!(credit_doc_ref3.equals(""))) credit_doc_ref_desc=credit_doc_ref3;
			if(!(credit_doc_date1.equals(""))) credit_doc_date=credit_doc_date1;
			if(!(credit_doc_date2.equals(""))) credit_doc_date=credit_doc_date2;
			if(!(credit_doc_date3.equals(""))) credit_doc_date=credit_doc_date3;
			if(!(cust_1.equals(""))) cust_code=cust_1;
			if(!(cust_2.equals(""))) cust_code=cust_2;
			if(!(cust_3.equals(""))) cust_code=cust_3;
			if(!(cash_set_type1.equals(""))) slmt_type_code=cash_set_type1;
			if(!(cash_set_type2.equals(""))) slmt_type_code=cash_set_type2;
			if(!(cash_insmt_ref1.equals(""))) slmt_doc_ref_desc=cash_insmt_ref1;
			if(!(cash_insmt_ref2.equals(""))) slmt_doc_ref_desc=cash_insmt_ref2;
			if(!(cash_insmt_date1.equals(""))) slmt_doc_ref_date=cash_insmt_date1;
			if(!(cash_insmt_date2.equals(""))) slmt_doc_ref_date=cash_insmt_date2;
			if(!(cash_insmt_rmks1.equals(""))) slmt_doc_remarks=cash_insmt_rmks1;
			if(!(cash_insmt_rmks2.equals(""))) slmt_doc_remarks=cash_insmt_rmks2;

						if(credit_doc_date!=null && (!(credit_doc_date.equals("")))) {// added on 8/25/2003 for billing changes //Added for Billing
				StringTokenizer stoken = new StringTokenizer(credit_doc_date,"/");
				String dd = stoken.nextToken();
				String mm = stoken.nextToken();
				String yyyy = stoken.nextToken();
				credit_doc_date = yyyy+"-"+mm+"-"+dd;
			}

			if(slmt_doc_ref_date!=null && (!(slmt_doc_ref_date.equals("")))) {
			StringTokenizer stoken1 = new StringTokenizer(slmt_doc_ref_date,"/");
			String dd = stoken1.nextToken();
			String mm = stoken1.nextToken();
			String yyyy = stoken1.nextToken();
			slmt_doc_ref_date = yyyy+"-"+mm+"-"+dd;
			}
			if(policy_expiry_date!=null && (!(policy_expiry_date.equals("")))) {
			StringTokenizer stoken2 = new StringTokenizer(policy_expiry_date,"/");
			String dd = stoken2.nextToken();
			String mm = stoken2.nextToken();
			String yyyy = stoken2.nextToken();
			policy_expiry_date = yyyy+"-"+mm+"-"+dd;
			}
			if(!(credit_doc_date.equals(""))) {
			credit_doc_date_d = java.sql.Date.valueOf(credit_doc_date) ;
			}
			if(!(slmt_doc_ref_date.equals(""))) {
			slmt_doc_ref_date_d = java.sql.Date.valueOf(slmt_doc_ref_date) ;
			}
			if(!(policy_expiry_date.equals("")))	{
			policy_expiry_date_d = java.sql.Date.valueOf(policy_expiry_date) ;
			}
			if ((recordCnt==null)||(recordCnt.equals(""))) recordCnt="0";
			reccnt = Integer.parseInt(recordCnt);
			if (reccnt>0)  recordMode="U";	else recordMode="I";
			String patient_ids=P_patient_ids.toString();
			String  ENCOUNTER_ID11 = "";

			String P_encounter_ids1=P_encounter_ids.toString();
			String episode_ids1=episode_ids.toString();
			if(episode_ids1 == null) episode_ids1="";
			java.util.StringTokenizer ptoken = new java.util.StringTokenizer(patient_ids,":");
			int no_patients=ptoken.countTokens();
			java.util.StringTokenizer etoken = new java.util.StringTokenizer(P_encounter_ids1,":");
			java.util.StringTokenizer eptoken = new java.util.StringTokenizer(episode_ids1,":");
            Hashtable ae_values_add_visit    = new Hashtable();
			Hashtable blTabdata              = new Hashtable();
			Hashtable prencounter            = new Hashtable();
			Hashtable prencounterdetail      = new Hashtable();
			HashMap fin_dtls=(HashMap)session.getAttribute("financial_details");
			
			HashMap blmppareg=new HashMap();
			for(int i=0;i<no_patients;i++)
			{
			    patientID =	ptoken.nextToken();
				ENCOUNTER_ID11 =etoken.nextToken();
		        ENCOUNTER_ID1 =  eptoken.nextToken();
			    episodeID = ENCOUNTER_ID1;
				annual_income="0";
				family_asset="0";
				no_of_dependants="0";
				ae_values_add_visit.put("bl_interface_yn", bl_interface_yn);
				ae_values_add_visit.put("bl_install_yn", bl_install_yn);
				ae_values_add_visit.put("visit_charge_stage","");
				ae_values_add_visit.put("location_code",clinic_code);
				ae_values_add_visit.put("billing_group", billing_group);
				if(fin_dtls!=null)
				ae_values_add_visit.put("fin_dtls",(HashMap)fin_dtls);

				ae_values_add_visit.put("new_episode_yn_val","Y");
				ae_values_add_visit.put("new_episode_yn","Y");
				ae_values_add_visit.put("package_bill_doc_type","");
				ae_values_add_visit.put("package_bill_doc_num","0");
				ae_values_add_visit.put("episode_status","");
				ae_values_add_visit.put("episode_type","E");
				ae_values_add_visit.put("episode_visit_no","1");
				ae_values_add_visit.put("visit_type_ind",VISIT_ADM_TYPE_IND);
				ae_values_add_visit.put("service_code",service_code);
				ae_values_add_visit.put("recordMode","U");
				ae_values_add_visit.put("bill_type_code","");
				ae_values_add_visit.put("pkg_serv_code","");
				ae_values_add_visit.put("base_qty","0");
				ae_values_add_visit.put("base_rate","0");
				ae_values_add_visit.put("base_charge_amt","0");
				ae_values_add_visit.put("gross_charge_amt","0");
				ae_values_add_visit.put("disc_amt","0");
				ae_values_add_visit.put("net_charge_amt","0");
				ae_values_add_visit.put("pat_base_qty","0");
				ae_values_add_visit.put("pat_base_rate","0");
				ae_values_add_visit.put("pat_serv_qty","0");
				ae_values_add_visit.put("pat_base_charge_amt","0");
				ae_values_add_visit.put("pat_gross_charge_amt","0");
				ae_values_add_visit.put("pat_disc_amt","0");
				ae_values_add_visit.put("pat_net_charge_amt","0");
				ae_values_add_visit.put("cust_base_qty","0");
				ae_values_add_visit.put("cust_base_rate","0");
				ae_values_add_visit.put("cust_serv_qty","0");
				ae_values_add_visit.put("cust_base_charge_amt","0");
				ae_values_add_visit.put("cust_gross_charge_amt","0");
				ae_values_add_visit.put("cust_disc_amt","0");
				ae_values_add_visit.put("cust_net_charge_amt","0");
				ae_values_add_visit.put("pkg_ins_pat_ind","");
				ae_values_add_visit.put("split_yn","");
				ae_values_add_visit.put("pkg_bill_doc_type","");
				ae_values_add_visit.put("pkg_bill_doc_num","0");
				ae_values_add_visit.put("day_type_code","");
				ae_values_add_visit.put("time_type_code","");
				ae_values_add_visit.put("disc_perc","0");
				ae_values_add_visit.put("addl_fctr","1");
				ae_values_add_visit.put("upd_user_flag","");
                ae_values_add_visit.put("facility_id",facility_id);
				ae_values_add_visit.put("modified_facility_id",facility_id);
                ae_values_add_visit.put("operating_facility_id",facility_id);
				ae_values_add_visit.put("visit_type_code",visit_type);
				ae_values_add_visit.put("modified_date",(java.sql.Date)added_date);
				ae_values_add_visit.put("added_at_ws_no",AddedAtWsNo);
				ae_values_add_visit.put("added_by_id",addedById);
				ae_values_add_visit.put("added_facility_id", facility_id);
				ae_values_add_visit.put("modified_by_id",addedById);
				ae_values_add_visit.put("user_id",user_id);
				ae_values_add_visit.put("patient_id",patientID);
				ae_values_add_visit.put("episode_id",episodeID);
				ae_values_add_visit.put("encounterid",ENCOUNTER_ID11);
				ae_values_add_visit.put("episode","");
			    ae_values_add_visit.put("episode_type","E");

			   

                blTabdata = ae_values_add_visit;
				blTabdata.put("brought_dead_yn","N");
				blTabdata.put("episodeno",episodeID);
				blTabdata.put("module_id","AE");


				prencounter.put("facility_id",facility_id);
				prencounter.put("patient_id",patientID);
				prencounter.put("visit_adm_type",visit_type);
				prencounter.put("visit_adm_type_facility_id",facility_id);
				prencounter.put("assign_care_locn_type","C");
				prencounter.put("assign_care_locn_code",clinic_code);
                prencounter.put("appt_case_yn","W");
                prencounter.put("ancillary_yn","N");
                prencounter.put("op_episode_visit_num","1");
                prencounter.put("recall_yn","N");
                prencounter.put("mds_complete_yn","N");
                prencounter.put("backdated_yn","N");
                prencounter.put("visit_status","1");
                prencounter.put("added_by_id",addedById);
                prencounter.put("added_facility_id", facility_id);
                prencounter.put("added_at_ws_no",AddedAtWsNo);
                prencounter.put("modified_by_id",addedById);
                prencounter.put("modified_facility_id",facility_id);
                prencounter.put("modified_at_ws_no",AddedAtWsNo );

				prencounterdetail.put("operating_facility_id",facility_id);
				prencounterdetail.put("added_by_id",addedById);
				prencounterdetail.put("added_date",(java.sql.Date)added_date);
				prencounterdetail.put("added_facility_id", facility_id);
				prencounterdetail.put("added_at_ws_no",AddedAtWsNo);
				prencounterdetail.put("modified_by_id",addedById);
				prencounterdetail.put("modified_date",(java.sql.Date)added_date);
				prencounterdetail.put("modified_facility_id",facility_id);
				prencounterdetail.put("modified_at_ws_no",AddedAtWsNo );
               // code added for scrum date:Wednesday, February 03, 2010 incident:10638
				blmppareg.put("patient_id",patientID);
				blmppareg.put("strclientip",AddedAtWsNo);
				blmppareg.put("strloggeduser",addedById);
				blmppareg.put("facility_id",facility_id);
			    blmppareg.put("callFromAE","DR");
			    blmppareg.put("locale",locale);

				if(fin_dtls!=null)
				blmppareg.put("fin_dtls",(HashMap)fin_dtls);

				

				BLMPRegCharges   blmpreg=new BLMPRegCharges();
				resultsBL=blmpreg.billPatientRegCharges(con,blmppareg);
				
				boolean boolRes1 = ((Boolean)(resultsBL.get("transaction_completed"))).booleanValue();
			
				 String err1 = (String)resultsBL.get("error");
				 if(boolRes1 == true)
				{

				BLOPVisit  blopVisit = new BLOPVisit();
				resultsBL = blopVisit.billPatientService(p,con,blTabdata,prencounter,prencounterdetail);
				boolean boolRes = ((Boolean)(resultsBL.get("status"))).booleanValue();
			    String err = (String)resultsBL.get("error");
				if (boolRes == false)
				{
					result = false;
					sb.append("Exception Billing Procedure AT 3394 :"+err);
					break;
					//con.rollback();
				}
				else if(boolRes == true)
				{
					result	=	true;
					//con.commit();
				}
				}
				else
				{
					result = false;
					sb.append(err1);
					break;

				}

				// code end
			ae_values_add_visit.clear();
			blTabdata.clear();
			prencounter.clear();
			prencounterdetail.clear();
	             }//end of for loop
 		   }  //added new
	      } //end if



		   if(result)
		   {
           con.commit();
		   if (bl_install_yn.equals("Y") && is_financial_captured.equals("Y"))
		   {
			     session.removeAttribute("financial_details");   
			}

		   if(!(cancel.equals("Cancel")))
			{
			  if(no_pats==1)
			{
			MessageManager mm = new MessageManager();
			final java.util.Hashtable mesg = mm.getMessage(locale, "PAT_ID_ENC_ID_GENERATED1", "AE") ;
			String splChar1="!";
			String splChar2="$";
			int chrAt;
			String msg  = ((String) mesg.get("message"));
			messageText=messageText.append(msg);

			chrAt=msg.indexOf(splChar1);
			messageText.delete(chrAt,chrAt+1);
			messageText.append("<font size=4><b>");
            messageText=messageText.insert(chrAt,P_START_PATIENT_ID);
			messageText.append("</b></font>");

			msg=new String(messageText);
            chrAt=msg.indexOf(splChar2);
			messageText.delete(chrAt,chrAt+1);
			messageText.append("<font size=4><b>");
            messageText=messageText.insert(chrAt,start_encunt.toString());
			messageText.append("</b></font>");
			mesg.clear();
			} else if(no_pats>1)
			{
			MessageManager mm = new MessageManager();
			final java.util.Hashtable mesg = mm.getMessage(locale, "PAT_ID_ENC_ID_GENERATED", "AE") ;
			String splChar1="!";
			String splChar2="@";
			String splChar3="#";
			String splChar4="$";
			int chrAt;
			String msg  = ((String) mesg.get("message"));
			messageText=messageText.append(msg);

			chrAt=msg.indexOf(splChar1);
			messageText.delete(chrAt,chrAt+1);
			messageText.append("<font size=4><b>");
            messageText=messageText.insert(chrAt,P_START_PATIENT_ID);
			messageText.append("</b></font>");
			msg=new String(messageText);
            chrAt=msg.indexOf(splChar2);
			messageText.delete(chrAt,chrAt+1);
			messageText.append("<font size=4><b>");
            messageText=messageText.insert(chrAt,P_END_PATIENT_ID.toString());
			messageText.append("</b></font>");


			msg=new String(messageText);
			chrAt=msg.indexOf(splChar3);
			messageText.delete(chrAt,chrAt+1);
			messageText.append("<font size=4><b>");
            messageText.insert(chrAt,start_encunt.toString());
			messageText.append("</b></font>");

			msg=new String(messageText);
			chrAt=msg.indexOf(splChar4);
			messageText.delete(chrAt,chrAt+1);
			messageText.append("<font size=4><b>");
            messageText=messageText.insert(chrAt,P_END_ENCOUNTER_ID);
			messageText.append("</b></font>");

			mesg.clear();
			}else
			{
			MessageManager mm = new MessageManager();
			final java.util.Hashtable mesg = mm.getMessage(locale, "PAT_ID_GENERATED", "AE") ;
			String msg  = ((String) mesg.get("message"));
			messageText.append(msg);
			String splChar1="!";
			String splChar2="@";
			int chrAt;
            chrAt=msg.indexOf(splChar1);
			messageText.delete(chrAt,chrAt+1);
            messageText=messageText.insert(chrAt,P_START_PATIENT_ID);
            msg=new String(messageText);
			chrAt=msg.indexOf(splChar2);
			messageText.delete(chrAt,chrAt+1);
            messageText.insert(chrAt,P_END_PATIENT_ID);
			mesg.clear();
			}
		   }
		   // newly added 03.07.09-SRR20056-SCF-3308
		   else
			{
			   if(no_pats==1)
			{
			MessageManager mm = new MessageManager();
			final java.util.Hashtable mesg = mm.getMessage(locale, "PAT_ID_GENERATED1", "AE") ;
			String splChar1="!";
			int chrAt;
			String msg  = ((String) mesg.get("message"));
			messageText=messageText.append(msg);

			chrAt=msg.indexOf(splChar1);
			messageText.delete(chrAt,chrAt+1);
			messageText.append("<font size=4><b>");
            messageText=messageText.insert(chrAt,P_START_PATIENT_ID);
			messageText.append("</b></font>");
			mesg.clear();


			}  else if(no_pats>1)
			{
			MessageManager mm = new MessageManager();
			final java.util.Hashtable mesg = mm.getMessage(locale, "PAT_ID_GENERATED", "AE") ;
			String splChar1="!";
			String splChar2="@";
			int chrAt;
			String msg  = ((String) mesg.get("message"));
			messageText=messageText.append(msg);

			chrAt=msg.indexOf(splChar1);
			messageText.delete(chrAt,chrAt+1);
			messageText.append("<font size=4><b>");
            messageText=messageText.insert(chrAt,P_START_PATIENT_ID);
			messageText.append("</b></font>");
			msg=new String(messageText);
            chrAt=msg.indexOf(splChar2);
			messageText.delete(chrAt,chrAt+1);
			messageText.append("<font size=4><b>");
            messageText=messageText.insert(chrAt,P_END_PATIENT_ID.toString());
			messageText.append("</b></font>");
			mesg.clear();
			}else
			{
			MessageManager mm = new MessageManager();
			final java.util.Hashtable mesg = mm.getMessage(locale, "PAT_ID_GENERATED", "AE") ;
			String msg  = ((String) mesg.get("message"));
			messageText.append(msg);
			String splChar1="!";
			String splChar2="@";
			int chrAt;
            chrAt=msg.indexOf(splChar1);
			messageText.delete(chrAt,chrAt+1);
            messageText=messageText.insert(chrAt,P_START_PATIENT_ID);
            msg=new String(messageText);
			chrAt=msg.indexOf(splChar2);
			messageText.delete(chrAt,chrAt+1);
            messageText.insert(chrAt,P_END_PATIENT_ID);
			mesg.clear();
			}
			}
//	END- newly added 03.07.09-SRR20056-SCF-3308

			p_passing_local_date   = request.getParameter("p_passing_local_date")== null ?"":request.getParameter("p_passing_local_date");
			p_language_id          = request.getParameter("p_language_id")== null ?"":request.getParameter("p_language_id");
			P_patient_ids.append(":");
			String patient_ids=P_patient_ids.toString();

			if(no_pats==1)
			{

				String sqlString="SELECT DISTINCT report_id, SM_GET_DESC.SM_REPORT(module_id,report_id,'"+locale+"','1') report_desc, 1 no_of_copies, module_id, 1 orderby FROM ae_online_report_vw WHERE operating_facility_id = '"+facility_id+"' AND (CLINIC_CODE='"+clinic_code+"' or CLINIC_CODE='*All') AND (visit_type_code='"+visit_type+"' or visit_type_code='*A') AND print_yn = 'Y' AND report_id ='MPBWBLBL'";
				String reportParamNames = "p_patient_id,p_to_patient_id,p_language_id,p_passing_local_date";
				String reportParamValues = ""+P_START_PATIENT_ID+","+P_END_PATIENT_ID+","+p_language_id+","+p_passing_local_date+"";
				StringBuffer htmlFor1 = new StringBuffer();
				htmlFor1.append("<html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
				htmlFor1.append("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
				htmlFor1.append("</head><body class='message'><script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script> <script language = 'JavaScript'>");
				htmlFor1.append(" async function toCallInternalReport() {var dialogHeight    = '40vh' ;");
				htmlFor1.append("  var dialogWidth = '55vw' ;");
				htmlFor1.append("  var dialogTop = '65' ;");
				htmlFor1.append("  var arguments =   ''; ");
				// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
				htmlFor1.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=DISASTER_EMER_REGN&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
				htmlFor1.append("  var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ;");
				htmlFor1.append("  retVal =await window.showModalDialog(getUrl,arguments,features);}");
				htmlFor1.append("</script></body>");
				messageText.replace(0, messageText.length(), messageText.toString().replaceAll("[\r\n]", ""));
				out.println(htmlFor1.toString());
				out.println("<html><head></head><body><script language = 'javascript'>async function toCallInternalReport1(){ var let=await toCallInternalReport();var error =  '"+java.net.URLEncoder.encode(messageText.toString(), "UTF-8")+"'");
				out.println("parent.frames[1].location.reload();");
				out.println("document.location.href = '../eCommon/jsp/error.jsp?err_num='+error+'&err_value=0';}toCallInternalReport1()</script></body></html>");

			}  else if(no_pats>1)
			{
				String sqlString="SELECT DISTINCT report_id, SM_GET_DESC.SM_REPORT(module_id,report_id,'"+locale+"','1') report_desc, 1 no_of_copies, module_id, 1 orderby FROM ae_online_report_vw WHERE operating_facility_id = '"+facility_id+"' AND (CLINIC_CODE='"+clinic_code+"' or CLINIC_CODE='*All') AND (visit_type_code='"+visit_type+"' or visit_type_code='*A') AND print_yn = 'Y' AND report_id ='MPBWBLBL'";
				String reportParamNames = "p_patient_id,p_to_patient_id,p_language_id,p_passing_local_date,p_patient_ids,p_disRegPatFlag";
				String reportParamValues = ""+P_START_PATIENT_ID+","+P_END_PATIENT_ID+","+p_language_id+","+p_passing_local_date+","+patient_ids+",Y";
				StringBuffer htmlFor1 = new StringBuffer();
				htmlFor1.append("<html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
				htmlFor1.append("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
				htmlFor1.append("</head><body class='message'> <script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language = 'JavaScript'>");
				htmlFor1.append(" async function toCallInternalReport(){var dialogHeight    = '45vh' ;");
				htmlFor1.append("  var dialogWidth = '55vw' ;");
				htmlFor1.append("  var dialogTop = '65' ;");
				htmlFor1.append("  var arguments =   ''; ");
				// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
				htmlFor1.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=DISASTER_EMER_REGN&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
				htmlFor1.append("  var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ;");
				htmlFor1.append("  retVal =await window.showModalDialog(getUrl,arguments,features);}");
				htmlFor1.append("</script></body>");
				messageText.replace(0, messageText.length(), messageText.toString().replaceAll("[\r\n]", ""));
				out.println(htmlFor1.toString());
				out.println("<html><head></head><body><script language = 'javascript'> async function toCallInternalReport1(){ var let=await toCallInternalReport();var error =  '"+java.net.URLEncoder.encode(messageText.toString(), "UTF-8")+"'");
				out.println("parent.frames[1].location.reload();");
				out.println("document.location.href = '../eCommon/jsp/error.jsp?err_num='+error+'&err_value=0';}toCallInternalReport1()</script></body></html>");

			}

		   }
		   else
		   {
			 con.rollback();
             response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(sb.toString()));
		   }
		}
		catch (Exception e)
		{
			e.printStackTrace();
			out.println("Error in Update :" +e);
			response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(sb.toString()));
		}
		finally
			{
			 try
            {
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
				if(pstmt!=null) pstmt.close();
				if(con != null)  ConnectionManager.returnConnection(con,request);
                //if(cs != null)  cs.close();
            }
	            catch(Exception e){e.printStackTrace();}
			}
	}

 private long GENERATE_MULTIPLE_ATTENDANCE(String P_FACILITY_ID,String P_PATIENT_ID,String P_VISIT_TYPE,String  VISIT_ADM_TYPE_IND,String P_ASSIGN_CARE_LOCN_CODE,String P_SERVICE_CODE,String P_SPECIALTY_CODE,String P_ARRIVAL_CODE,String P_CONTACT_REASON_CODE,String P_PRIORITY_ZONE,String P_USER_ID,String P_WS_NO,long P_ENCOUNTER_ID)
	 {
              	CallableStatement cstmt	  = null;
				String  errmsg            = "";
				String  msgEncounter      = "";
				String  episode_visit_no  = "0001";

         try
		 {
			cstmt=con.prepareCall("{call PR_GENERATE_ENCOUNTER_ID(?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,"");
			cstmt.setString(2,episode_visit_no);
			cstmt.setString(3,P_FACILITY_ID);
			cstmt.setString(4,P_USER_ID);
			cstmt.setString(5,P_WS_NO);
			cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);

			cstmt.execute();

			errmsg=cstmt.getString(9);
			if(errmsg == null) errmsg="";
			msgEncounter=cstmt.getString(10);
			if(msgEncounter == null) msgEncounter="N";

			if(errmsg.equals(""))
			 {
				 if(msgEncounter.equals("Y"))
				 {
					  result=false;
				 }else
				 {
					P_ENCOUNTER_ID = Long.parseLong(cstmt.getString(8));
					V_NEXT_NUM     = cstmt.getString(8);
					result=true;
				 }
			 }else
			 {
				 result=false;
				 
			 }
			if(cstmt != null) cstmt.close(); cstmt=null;
		 }catch(Exception e)
		 {
 		     result=false;
			 e.printStackTrace();

		 }

		if(result)
		{
		    try{


			String sqlPREnc = "INSERT INTO pr_encounter (facility_id, encounter_id, patient_id, visit_adm_date_time,visit_adm_type, visit_adm_type_facility_id, visit_adm_type_ind,  assign_care_locn_type, assign_care_locn_code, contact_reason_code, op_episode_visit_num, recall_yn, mds_complete_yn, backdated_yn, visit_status,visit_status_set_on_date,visit_status_set_by_user ,service_code, new_op_episode_yn, ae_episode_yn, episode_id, ancillary_yn, booking_case_yn, patient_class, appt_case_yn, specialty_code, security_level, pat_curr_locn_type, pat_curr_locn_code, mlc_yn,added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,priority_zone,brought_dead_yn,disaster_yn) VALUES (?,TO_NUMBER (?),?, to_date(?,'dd/mm/yyyy hh24:mi:ss'),?, ?, ?,'C',?,?, 1, 'N','N', 'N', '01',to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,?, 'Y', 'Y', TO_NUMBER (SUBSTR (?, 1, 8)), 'N','N', 'EM', 'W',?,'0', 'C', ?, 'N',?, to_date(?,'dd/mm/yyyy hh24:mi:ss'), ?, ?,?, to_date(?,'dd/mm/yyyy hh24:mi:ss'), ?,?,?,'N','Y')";
			pstmt	= con.prepareStatement(sqlPREnc);
			pstmt.setString(1, P_FACILITY_ID) ;
			pstmt.setString(2, V_NEXT_NUM) ;
			pstmt.setString(3, P_PATIENT_ID) ;
			pstmt.setString(4, visit_date) ;// 4 date visit_date
			pstmt.setString(5, P_VISIT_TYPE) ;
			pstmt.setString(6, P_FACILITY_ID) ;
			pstmt.setString(7, VISIT_ADM_TYPE_IND) ;
			pstmt.setString(8, P_ASSIGN_CARE_LOCN_CODE) ;
			pstmt.setString(9, P_CONTACT_REASON_CODE) ;
			pstmt.setString(10, visit_date);//10 date
			pstmt.setString(11, P_USER_ID) ;
			pstmt.setString(12, P_SERVICE_CODE) ;
			pstmt.setString(13, V_NEXT_NUM) ;
			pstmt.setString(14, P_SPECIALTY_CODE) ;
			pstmt.setString(15, P_ASSIGN_CARE_LOCN_CODE) ;
			pstmt.setString(16, P_USER_ID) ;
			pstmt.setString(17, visit_date);//17 date
			pstmt.setString(18, P_WS_NO) ;
			pstmt.setString(19, P_FACILITY_ID) ;
			pstmt.setString(20, P_USER_ID) ;
			pstmt.setString(21, visit_date);//21 date
			pstmt.setString(22, P_WS_NO) ;
			pstmt.setString(23, P_FACILITY_ID) ;
			pstmt.setString(24, P_PRIORITY_ZONE) ;

			rs1 =  pstmt.executeUpdate();
			if(rs1 > 0)
				result	=	true;
			else
				result	=	false;
			if(pstmt!=null) pstmt.close();
			}catch(Exception e){
		      e.printStackTrace();
		      result	=	false;
	        }
		}
		if(result)
		{
		    try{
			String sqlPREncOth = "INSERT INTO pr_encounter_other_detail (operating_facility_id, encounter_id, arrival_code,  encounter_type, check_in_date_time, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id,modified_date, modified_at_ws_no, modified_facility_id) VALUES (?,TO_NUMBER (?),?,'A',TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?, TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?)";
			pstmt	= con.prepareStatement(sqlPREncOth);
			pstmt.setString(1, P_FACILITY_ID) ;
			pstmt.setString(2, V_NEXT_NUM) ;
			pstmt.setString(3, P_ARRIVAL_CODE) ;
			pstmt.setString(4, visit_date);// 4 date
			pstmt.setString(5, P_USER_ID) ;
			pstmt.setString(6, visit_date);// 6 date
			pstmt.setString(7, P_WS_NO) ;
			pstmt.setString(8, P_FACILITY_ID) ;
			pstmt.setString(9, P_USER_ID) ;
			pstmt.setString(10, visit_date);//10 date
			pstmt.setString(11, P_WS_NO) ;
			pstmt.setString(12, P_FACILITY_ID) ;
			rs1 =  pstmt.executeUpdate();
			if(rs1 > 0)		result	=	true;	else	result	=	false;
			if(pstmt!=null) pstmt.close();
			}catch(Exception e){
		      e.printStackTrace();
		      result	=	false;
	        }
        }
	// Newly added.. to insert into OP_LAST_VISIT_FOR_SERVICE
	if(result)
	{
	    try{
		StringBuffer OPVisitSer = new StringBuffer();
		OPVisitSer.append("insert into OP_LAST_VISIT_FOR_SERVICE ");
		OPVisitSer.append("(PATIENT_ID, OPERATING_FACILITY_ID,");
		OPVisitSer.append("SERVICE_CODE,ENCOUNTER_ID,");
		OPVisitSer.append("ADDED_BY_ID,ADDED_DATE,");
		OPVisitSer.append("ADDED_AT_WS_NO, ADDED_FACILITY_ID,");
		OPVisitSer.append("MODIFIED_BY_ID, MODIFIED_DATE,");
		OPVisitSer.append("MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, ");
		OPVisitSer.append("VISIT_ADM_DATE_TIME, ASSIGN_CARE_LOCN_CODE, ");
		OPVisitSer.append("PATIENT_CLASS)  ");
		OPVisitSer.append(" values(?,?,?,TO_NUMBER (?),?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?,");
		OPVisitSer.append("TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,'EM')");

		if(pstmt!=null) pstmt.close();
		pstmt	= con.prepareStatement(OPVisitSer.toString());

		pstmt.setString(1,P_PATIENT_ID) ;
		pstmt.setString(2,P_FACILITY_ID) ;
		pstmt.setString(3,P_SERVICE_CODE) ;
		pstmt.setString(4,V_NEXT_NUM) ;
		pstmt.setString(5,P_USER_ID) ;
		pstmt.setString(6, visit_date);// 6 date
		pstmt.setString(7,P_WS_NO) ;
		pstmt.setString(8,P_FACILITY_ID) ;
		pstmt.setString(9,P_USER_ID) ;
		pstmt.setString(10, visit_date);// 10 date
		pstmt.setString(11,P_WS_NO) ;
		pstmt.setString(12,P_FACILITY_ID) ;
		pstmt.setString(13, visit_date);// 13 date
		pstmt.setString(14,P_ASSIGN_CARE_LOCN_CODE) ;
		rsop =  pstmt.executeUpdate();
		if(rsop > 0)
			result	=	true;
		else
			result	=	false;

		if(pstmt!=null) pstmt.close();
		if((OPVisitSer != null) && (OPVisitSer.length() > 0))
		{
			OPVisitSer.delete(0,OPVisitSer.length());
		}
	}catch(Exception e){
	  e.printStackTrace();
	  result	=	false;
	}
  }

		if(result)
		{	try{   String sqlOPEpi = "INSERT INTO OP_EPISODE_FOR_SERVICE ( 		PATIENT_ID,OPERATING_FACILITY_ID,EPISODE_ID,		CLINIC_CODE,SERVICE_CODE,START_DATE_TIME,EPISODE_STATUS, LAST_ENCOUNTER_ID,LAST_VISIT_DATE,LAST_VISIT_NUM,AE_EPISODE_YN,		ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,		MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES (?,?,TO_NUMBER(SUBSTR(?,1,8)),?,?,SYSDATE,'01', TO_NUMBER(SUBSTR(?,1,12)), SYSDATE,1,'Y',?,SYSDATE,?,?,?, SYSDATE,?,?)";
                pstmt	= con.prepareStatement(sqlOPEpi);
                pstmt.setString(1, P_PATIENT_ID) ;
                pstmt.setString(2, P_FACILITY_ID) ;
				pstmt.setString(3, V_NEXT_NUM) ;
				pstmt.setString(4, P_ASSIGN_CARE_LOCN_CODE) ;
				pstmt.setString(5, P_SERVICE_CODE) ;
				pstmt.setString(6, V_NEXT_NUM) ;
				pstmt.setString(7, P_USER_ID) ;
				pstmt.setString(8, P_FACILITY_ID) ;
				pstmt.setString(9, P_WS_NO) ;
				pstmt.setString(10, P_USER_ID) ;
				pstmt.setString(11, P_FACILITY_ID) ;
				pstmt.setString(12, P_WS_NO) ;
				rs1 =  pstmt.executeUpdate();
				if(rs1 > 0)
				result	=	true; else 	result	=	false;
				if(pstmt!=null) pstmt.close();
			}catch(Exception e){
			  e.printStackTrace();
			  result	=	false;
			}
        }
		if(result)
		{	try{   String sqlOPPatQ = "INSERT INTO op_patient_queue (facility_id, queue_date, queue_shift, locn_type, locn_code,  queue_num, patient_id, practitioner_id, appt_or_walk_in_ind,encounter_id, check_in_date_time, queue_status, priority_zone,arrive_date_time,added_by_id, added_date, added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no,modified_facility_id,patient_class,pat_curr_locn_code, pat_curr_locn_type,episode_id, op_episode_visit_num,DISASTER_YN,SERVICE_CODE,VISIT_TYPE_CODE,VISIT_TYPE_IND,SPECIALITY_CODE,DIS_REGN_REFERENCE,DIS_REGN_REMARKS) VALUES  (?,SYSDATE,'*ALL','C',?,1,?,'*ALL','W',TO_NUMBER (?), SYSDATE,'01',?,SYSDATE,?,SYSDATE,?,?,?,SYSDATE,?,?,'EM',?,'C',?,'1','Y',?,?,?,?,?,?)";
	            pstmt	= con.prepareStatement(sqlOPPatQ);
                pstmt.setString(1, P_FACILITY_ID) ;
				pstmt.setString(2, P_ASSIGN_CARE_LOCN_CODE) ;
				pstmt.setString(3, P_PATIENT_ID) ;
				pstmt.setString(4, V_NEXT_NUM) ;
				pstmt.setString(5, P_PRIORITY_ZONE) ;
				pstmt.setString(6, P_USER_ID) ;
				pstmt.setString(7, P_WS_NO) ;
				pstmt.setString(8, P_FACILITY_ID) ;
				pstmt.setString(9, P_USER_ID) ;
				pstmt.setString(10, P_WS_NO) ;
				pstmt.setString(11, P_FACILITY_ID) ;
                pstmt.setString(12, P_ASSIGN_CARE_LOCN_CODE) ;
				pstmt.setString(13,((V_NEXT_NUM+"").substring(0,8)));
				pstmt.setString(14,service_code);
                pstmt.setString(15,P_VISIT_TYPE);
				pstmt.setString(16,VISIT_ADM_TYPE_IND);
                pstmt.setString(17,P_SPECIALTY_CODE);
                pstmt.setString(18,Disaster_Reference);
                pstmt.setString(19,remarks);

			    rs1 =  pstmt.executeUpdate();
				if(rs1 > 0)	result	=	true;	else	result	=	false;
				if(pstmt!=null) pstmt.close();
			}catch(Exception e){
			  e.printStackTrace();
			  result	=	false;
			}
        }
		if(result)
		 {	try{ String sqlAEEmerDet = "INSERT INTO ae_pat_emergency_detail (facility_id, encounter_id, recorded_date, ae_encounter_type, arrival_mode, burn_yn, trauma_yn, blunt_injury_yn, penetrating_injury_yn, tetanus_admin_yn, pregnant_yn, gd_for_age_yn, im_upto_date_yn, added_by_id,added_date, added_at_ws_no, added_facility_id, modified_by_id,modified_date, modified_at_ws_no, modified_facility_id,priority_zone,clinic_code,disaster_yn)  VALUES (?,TO_NUMBER (?), SYSDATE, 'A',?,'N','N','N','N','N','N','N','N',?,SYSDATE,?,?,?, SYSDATE,?,?,?,?,'Y')";
			   pstmt	= con.prepareStatement(sqlAEEmerDet);
			   pstmt.setString(1, P_FACILITY_ID) ;
    		   pstmt.setString(2, V_NEXT_NUM) ;
			   pstmt.setString(3, P_ARRIVAL_CODE) ;
			   pstmt.setString(4, P_USER_ID) ;
               pstmt.setString(5, P_WS_NO) ;
               pstmt.setString(6, P_FACILITY_ID) ;
               pstmt.setString(7, P_USER_ID);
               pstmt.setString(8, P_WS_NO) ;
               pstmt.setString(9, P_FACILITY_ID) ;
	    	   pstmt.setString(10, P_PRIORITY_ZONE) ;
		       pstmt.setString(11, P_ASSIGN_CARE_LOCN_CODE) ;
               rs1 =  pstmt.executeUpdate();
			   if(rs1 > 0)	result	=	true;   else	result	=	false;
				if(pstmt!=null) pstmt.close();
			}catch(Exception e){
			  e.printStackTrace();
			  result	=	false;
			}
        }
		if(result)
		{	try{       String sqlAEPatRel = "INSERT INTO ae_pat_related_contacts (facility_id, encounter_id, added_by_id, added_date,   added_at_ws_no, added_facility_id, modified_by_id,modified_date, modified_at_ws_no, modified_facility_id) VALUES (?, TO_NUMBER (?), ?, SYSDATE,?, ?, ?,SYSDATE, ?, ?)";
					   pstmt	= con.prepareStatement(sqlAEPatRel);
					   pstmt.setString(1, P_FACILITY_ID) ;
					   pstmt.setString(2, V_NEXT_NUM) ;
					   pstmt.setString(3, P_USER_ID);
					   pstmt.setString(4, P_WS_NO) ;
                       pstmt.setString(5, P_FACILITY_ID) ;
                       pstmt.setString(6, P_USER_ID);
                       pstmt.setString(7, P_WS_NO) ;
                       pstmt.setString(8, P_FACILITY_ID) ;
                       rs1 =  pstmt.executeUpdate();
                       if(rs1 > 0) result	=	true;	else	result	=	false;
					   if(pstmt!=null) pstmt.close();
			}catch(Exception e){
			  e.printStackTrace();
			  result	=	false;
			}
        }
return P_ENCOUNTER_ID;}

private long GET_EPISODE(String P_FACILITY_ID,long encounter_id)
{
	long eps_id=0;
		try
		{

			String ep_id="";
			String sqlepisode ="SELECT episode_id FROM PR_ENCOUNTER WHERE FACILITY_ID = ? and encounter_id=? ";
	    			pstmt = con.prepareStatement(sqlepisode);
					pstmt.setString(1, P_FACILITY_ID);
					pstmt.setLong(2,encounter_id);

					rset = pstmt.executeQuery();
				    if (rset!=null && rset.next())
					{
						ep_id= rset.getString("episode_id");
					}
				if(rset != null) rset.close();
				if(pstmt != null) pstmt.close();

				eps_id=Long.parseLong(ep_id);

         }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return eps_id;
  }

/** Modified against HSA-CRF-0153  Generating Day SrlNo: **/
private String GetDaySrlNo(String sex)
{
	String sPatName = "";
	
	//Invoke this Stored Proc for generating Serial Number and to get Patient Name
	CallableStatement callablestatement = null;
	try {
		callablestatement = con.prepareCall("{call MP_EMER_PAT_GEN_SLNO(?,?,?)}");
		callablestatement.setString(1, sex); //Gender
		callablestatement.setString(2, "Y"); //Indicator for generating Day Srl No.
		callablestatement.registerOutParameter(3, 12);
	    callablestatement.execute();
	    sPatName  = callablestatement.getString(3); //PatientName
		if(callablestatement != null) callablestatement.close(); //Modified for checkstyle
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		if(callablestatement != null)
			try {
				callablestatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
    
    return sPatName;
}


}
