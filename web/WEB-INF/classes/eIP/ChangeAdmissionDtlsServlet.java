/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*******
Developed On 05/03/2009
Version 10.x
********/

package eIP;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import java.util.Hashtable;
import java.util.HashMap;
import javax.servlet.http.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eIP.IPChangeAdmissionDetails.* ;

public class ChangeAdmissionDtlsServlet extends javax.servlet.http.HttpServlet{

	
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public  void doGet(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		doPost(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		java.util.Properties p				= null;
		PrintWriter	out						= null;
		Connection con	 					= null;
		PreparedStatement pstmt				= null;	
		ResultSet rset						= null;
		HttpSession session					= null;
		boolean proceed						= true;
		String sStyle						=	"";
		String facilityId					=	"";
		String login_User					=	"";
		String client_ip_address			=	"" ;
		  /* CheckStyle Violation Commented by Munisekhar */ 
		//String frm_specialty_code			=	"";   
		String frm_nursing_unit_code		=	"";  
		/* CheckStyle Violation Commented by Munisekhar */ 
		//String frm_service_code				=	"";
		//String frm_subservice_code			=	"";
		//String frm_bed_class_code			=	"";
		//String frm_bed_type_code			=	"";
		String frm_bed_no					=	"";
		String frm_room_no					=	"";
		String to_admission_approval_details	=	""; //Added by Suji Keerthi for MMS-DM-CRF-0191 US002
		  /* CheckStyle Violation Commented by Munisekhar */ 
		//String frm_admission_type			=	"";
		//String frm_exp_discharge_dtTime		=	"";
		//String frm_admit_practitioner_id	=	"";
		//String frm_practitioner_id			=	"";
		//String frm_ot_date_time				=	"";
		//String frm_exp_days_stay			=	"";
		//String frm_revision_reason_code		=	"";
		//String frm_ambulatory_status		=	"";
		/**To Vairables Declaration*/
		String to_specialty_code			=	"";
		String to_nursing_unit_code			=	"";
		String to_service_code				=	"";
		String to_subservice_code			=	"";
		String to_bed_class_code			=	"";
		String to_bed_type_code				=	"";
		String to_bed_no					=	"";
		String to_room_no					=	"";
		String to_admission_type			=	"";
		String to_exp_discharge_dtTime		=	"";
		String to_admit_practitioner_id		=	"";
		String to_practitioner_id			=	"";
		String to_ot_date_time				=	"";
     	/* CheckStyle Violation Commented by Munisekhar */	
		//String to_exp_days_stay				=	"";
		String to_revision_reason_code		=	"";
		String to_ambulatory_status			=	"";

	/*Common Vairables Declaration*/
		String age							=	"";
		String patient_gender				=	"";
		String date_of_birth				=	"";
		String res_area_code				=	"";
		String res_town_code				=	"";
		String res_town_desc				=	"";
		String patient_id					=	"";
		String encounter_id					=	"";
		String referral_id					=	"";
		String referral_id_old				=	"";
		String gender						=	"";
		String bl_Instal					=	"";
		  /* CheckStyle Violation Commented by Munisekhar */ 
		//String bl_Operatoal					=	"";
		String bl_interfaced_yn				=	"";
		String patient_class				=	"";
		String adt_status					=	"";
		String admison_dtTime				=	"";
		String locale						=	"";
		String checkForBilling				=	"";
		String error_val					=	"";
		String tfr_req_status				=	"";
		String admission_remarks			=	"";
		String customer_id					= "";
		HashMap hashData					=	new HashMap();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");

		out									= res.getWriter();
		session								= req.getSession(false);
		p									= (java.util.Properties) session.getValue( "jdbc" ) ;
		locale								= p.getProperty("LOCALE");	
		sStyle								=
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		facilityId							= (String)session.getValue("facility_id") ;
		if(facilityId == null || facilityId.equals("") || facilityId=="")
			facilityId = "";
		client_ip_address					= p.getProperty("client_ip_address");
		login_User							= p.getProperty( "login_user" ) ;

/*Getting Data From Form*/
		try{
				con										= ConnectionManager.getConnection(req);
				patient_id								=	checkForNull(req.getParameter("patient_id"));          
				encounter_id							=	checkForNull(req.getParameter("encounter_id"));        
				referral_id								=	checkForNull(req.getParameter("referral_id"));     
				referral_id_old							=	checkForNull(req.getParameter("referral_id_old"));
				gender									=	checkForNull(req.getParameter("gender"));   
				bl_Instal								=	checkForNull(req.getParameter("bl_instal"));           
				bl_interfaced_yn						=	checkForNull(req.getParameter("bl_interfaced_yn"));    patient_class							=	checkForNull(req.getParameter("patient_class"));       adt_status								=	checkForNull(req.getParameter("adt_status"));         
				admison_dtTime							=	checkForNull(req.getParameter("admission_date_time")); 
				checkForBilling							=	checkForNull(req.getParameter("checkForBilling"));  
				admison_dtTime							=	DateUtils.convertDate(admison_dtTime,"DMYHM",locale,"en");//Date Conversion For Admission Date Time  //				
				//frm_specialty_code						=	checkForNull(req.getParameter("frm_specialty_code"));             	
				frm_nursing_unit_code					=	checkForNull(req.getParameter("frm_nursing_unit_code"));     
				frm_bed_no								=	checkForNull(req.getParameter("frm_bed_no"));          
				frm_room_no								=	checkForNull(req.getParameter("frm_room_no"));    
				to_admission_approval_details			=	checkForNull(req.getParameter("admission_approval_details")); //Added by Suji Keerthi for MMS-DM-CRF-0191 US002    
				to_specialty_code						=	checkForNull(req.getParameter("Splcode"));             
				to_nursing_unit_code					=	checkForNull(req.getParameter("nursing_unit"));        
				to_service_code							=	checkForNull(req.getParameter("service"));             
				to_subservice_code						=	checkForNull(req.getParameter("sub_service"));         
				to_bed_class_code						=	checkForNull(req.getParameter("Bedcode"));             
				to_bed_type_code						=	checkForNull(req.getParameter("bed_type"));            
				to_bed_no								=	checkForNull(req.getParameter("bed_no"));              
				to_room_no								=	checkForNull(req.getParameter("room_no"));   
				to_ambulatory_status					=	checkForNull(req.getParameter("ambulatory_status"));   
				to_admission_type						=  checkForNull(req.getParameter("visit_adm_type"));  
				to_exp_discharge_dtTime					=	checkForNull(req.getParameter("expecteddischargedate"));  
				to_exp_discharge_dtTime					=	DateUtils.convertDate(to_exp_discharge_dtTime,"DMYHM",locale,"en");  //Date Convertion For Expectd Disch
				to_ot_date_time							=	checkForNull(req.getParameter("ot_date_time"));
				to_ot_date_time							=	DateUtils.convertDate(to_ot_date_time,"DMYHM",locale,"en"); //Date Conversion For OTDate
				to_admit_practitioner_id				=	checkForNull(req.getParameter("practid"));             
				to_practitioner_id						=	checkForNull(req.getParameter("att_practid"));    
				to_revision_reason_code					=	checkForNull(req.getParameter("revision_resn_code"));  
				tfr_req_status							=	checkForNull(req.getParameter("tfr_req_status"));  
				admission_remarks						=	checkForNull(req.getParameter("admission_remarks"));  
				customer_id								=	checkForNull(req.getParameter("customer_id"));
				hashData.put("facilityId",facilityId);
				hashData.put("client_ip_address",client_ip_address);
				hashData.put("login_User",login_User);
				hashData.put("locale",locale);
				hashData.put("patient_id",patient_id);
				hashData.put("encounter_id",encounter_id);
				hashData.put("referral_id",referral_id);
				hashData.put("referral_id_old",referral_id_old);
				hashData.put("Gender",gender);
				hashData.put("bl_Operational",bl_Instal);
				hashData.put("bl_interfaced_yn",bl_interfaced_yn);
				hashData.put("patient_class",patient_class);
				hashData.put("adt_status",adt_status);
				hashData.put("admission_date_time",admison_dtTime);
				hashData.put("checkForBilling",checkForBilling);
				hashData.put("frm_nursing_unit_code",frm_nursing_unit_code);
				hashData.put("frm_bed_no",frm_bed_no);
				hashData.put("frm_room_no",frm_room_no);
				hashData.put("to_admission_approval_details",to_admission_approval_details); //Added by Suji Keerthi for MMS-DM-CRF-0191 US002
				hashData.put("to_specialty_code",to_specialty_code);
				hashData.put("to_nursing_unit_code",to_nursing_unit_code);
				hashData.put("to_service_code",to_service_code);
				hashData.put("to_subservice_code",to_subservice_code);
				hashData.put("to_bed_class_code",to_bed_class_code);
				hashData.put("to_bed_type_code",to_bed_type_code);
				hashData.put("to_bed_no",to_bed_no);
				hashData.put("to_room_no",to_room_no);
				hashData.put("to_ambulatory_status",to_ambulatory_status);
				hashData.put("to_admission_type",to_admission_type);
				hashData.put("to_exp_discharge_date_time",to_exp_discharge_dtTime);
				hashData.put("to_ot_date_time",to_ot_date_time);
				hashData.put("to_admit_practitioner_id",to_admit_practitioner_id);
				hashData.put("to_practitioner_id",to_practitioner_id);
				hashData.put("to_revision_reason_code",to_revision_reason_code);
				hashData.put("tfr_req_status",tfr_req_status);
				hashData.put("admission_remarks",admission_remarks);
				hashData.put("customer_id",customer_id);
				try{
					StringBuffer ageSql = new StringBuffer();
					ageSql.append("select res_area_code, res_town_code, res_town_desc, to_char(date_of_birth,'dd/mm/rrrr') date_of_birth , sex, get_age(date_of_birth) age from MP_PATIENT where patient_id = '"+patient_id+"'");
					pstmt = con.prepareStatement(ageSql.toString());
					rset = pstmt.executeQuery();
					if (rset != null && rset.next()){
						age						= checkForNull(rset.getString("age"));
						patient_gender			= checkForNull(rset.getString("sex"));
						date_of_birth			= checkForNull(rset.getString("date_of_birth"));
						res_area_code			= checkForNull(rset.getString("res_area_code"));
						res_town_code			= checkForNull(rset.getString("res_town_code"));
						res_town_desc			= checkForNull(rset.getString("res_town_desc"));
					}
				}catch(Exception getAge){
					proceed = false;
					getAge.printStackTrace();
				}
				hashData.put("age",age);
				hashData.put("patient_gender",patient_gender);
				hashData.put("date_of_birth",date_of_birth);
				hashData.put("res_area_code",res_area_code);
				hashData.put("res_town_code",res_town_code);
				hashData.put("res_town_desc",res_town_desc);
				//java.util.Hashtable checkValid =   ValidateIPAdmitPatient(	p, facilityId,admison_dtTime,to_specialty_code, to_nursing_unit_code, to_room_no,to_bed_no,frm_bed_no, to_bed_class_code,to_admit_practitioner_id, to_practitioner_id, req,patient_id,patient_gender, date_of_birth,age, res_area_code, res_town_code, res_town_desc,encounter_id );
				java.util.Hashtable checkValid =   ValidateIPAdmitPatient(	p, req,hashData);
				boolean retval				   =((Boolean)checkValid.get("status")).booleanValue();
				String error				   = (String) checkValid.get("error") ;
				String blocked_yn			   =(String)checkValid.get("blocked_yn");
				hashData.put("blocked_yn",blocked_yn);
				if(retval){
				   IPReviseAdmitPatient(req, res, p, hashData);
				}else{
					if(checkForBilling.equals("Y")){
						error_val="1";
					}
					out.println("<script> parent.frames[3].location.href =\"../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="+error_val+"\" </script>");
				}
				checkValid.clear();
				hashData.clear();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rset != null) rset.close();
				if(pstmt != null) pstmt.close();
				if(con != null)  ConnectionManager.returnConnection(con,req);
			}catch(Exception ex){}
		}
	}


	private void IPReviseAdmitPatient(HttpServletRequest req, HttpServletResponse res,java.util.Properties p,HashMap hashVal )throws java.io.IOException{
		
		PrintWriter	out						= null;
		out									= res.getWriter();
		String checkForBilling				=	"";
		String error_val					=	"";
		boolean proceed						= true;
		checkForBilling						= (String)hashVal.get("checkForBilling");
		if(proceed){
				try{
					
					boolean local_ejbs = false;
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/IPChangeAdmissionDetails",IPChangeAdmissionDetailsHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					Object argArray[] = new Object[2];
					argArray[0] = p;
					//argArray[1] = TabData;
					argArray[1] = hashVal;
					
					Class [] paramArray = new Class[2];
					paramArray[0] = p.getClass();
					//paramArray[1] = TabData.getClass();
					paramArray[1] = hashVal.getClass();
						
					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateAdmissionDetails",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

					boolean result		=	 (((Boolean) results.get( "status" )).booleanValue() );
					String error			=	(String)results.get("error");
					results.clear();
					if(result){
					out.println("<script>alert('"+error+"');</script>");
					//out.println("<script>parent.document.getElementById('dialog_tag').close();</script>");
					out.println("<script>if(top.window.document.getElementById('dialog-body')){");
					 out.println("parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();}");
					 out.println("else {");
					 out.println("parent.document.getElementById('dialog_tag').close();} </script> ");
					}else{

				if(checkForBilling.equals("Y")){
						error_val="1";
					}
					out.println("<script>parent.frames[3].location.href =\"../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="+error_val+"\"</script>");
				}
				hashVal.clear();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}


	private java.util.Hashtable ValidateIPAdmitPatient	(java.util.Properties p,HttpServletRequest req,HashMap hashValue){
		
		Connection con	 			= null;
		ResultSet srs				= null;
		PreparedStatement pstmt		= null ;
		ResultSet rset				= null;
		PreparedStatement pstmt1	= null ;
		ResultSet rset1				= null;
		String facilityId			= "";
		String locale				= "";
		String admissiondate		= "";
		String speciality			= "";
		String nursingunit			= "";
		String roomno				= "";
		String bedno				= "";
		String frm_bed_no			= "";
		String bedclass				= "";
		String practitioner			= "";
		String attd_practitioner	= "";
		String patientid			= "";
		String patientgender		= "";
		String dateofbirth			= "";
		String age					= "";
		String res_area_code		= "";
		String res_town_code		= "";
		String res_town_desc		= "";
		String encounter_id			= "";
		String p_adm_deposit_YN		= "";
		String p_Unprcs_Servc_YN	= "";
		String login_User			= "";
		String nursingunittype		= "";
		String L_current_gender		= "*";
		String blocked_yn			= "";
		String appl_patient_class	= "";
		String pseudo_bed_yn		= "";
		String p_service_charge_YN	= "";
		String bl_Instal			= "";
		facilityId					= (String)hashValue.get("facilityId");
		admissiondate				= (String)hashValue.get("admission_date_time");
		speciality					= (String)hashValue.get("to_specialty_code");
		nursingunit					= (String)hashValue.get("to_nursing_unit_code");
		roomno						= (String)hashValue.get("to_room_no");
		bedno						= (String)hashValue.get("to_bed_no");
		frm_bed_no					= (String)hashValue.get("frm_bed_no");
		bedclass					= (String)hashValue.get("to_bed_class_code");
		practitioner				= (String)hashValue.get("to_admit_practitioner_id");
		attd_practitioner			= (String)hashValue.get("to_practitioner_id");
		patientid					= (String)hashValue.get("patient_id");
		patientgender				= (String)hashValue.get("patient_gender");
		dateofbirth					= (String)hashValue.get("date_of_birth");
		age							= (String)hashValue.get("age");
		res_area_code				= (String)hashValue.get("res_area_code");
		res_town_code				= (String)hashValue.get("res_town_code");
		res_town_desc				= (String)hashValue.get("res_town_desc");
		encounter_id				= (String)hashValue.get("encounter_id");
		locale						= (String)hashValue.get("locale");
		login_User					= (String)hashValue.get("login_User");
		bl_Instal					= (String)hashValue.get("bl_Operational");
		java.util.Hashtable results = new java.util.Hashtable() ;
		boolean result				= true ;
		StringBuffer sb				= new StringBuffer("");
		StringBuffer sql			= new StringBuffer("");
//		String fid="";
		
		try{
			con = ConnectionManager.getConnection(req);
			/*if(sql.length() > 0) sql.delete(0,sql.length());

			// Condition check if the patient to be admitted is already an inpatient or not ...
			sql.append(" select count(1) from IP_OPEN_ENCOUNTER where patient_id = '"+patientid+"' ");
			pstmt1 = con.prepareStatement(sql.toString());
			rset1 = pstmt1.executeQuery();
			if(rset1!=null && rset1.next()){
				if(rset1.getInt(1) != 0){
					result = false;
					java.util.Hashtable message =MessageManager.getMessage(locale,"CURRENTLY_IN_PATIENT","IP");
					sb.append( (String) message.get("message")) ;
					message.clear();
				}else
					result=true;
		}
			if(rset1!=null) rset1.close();
			if(pstmt1!=null) pstmt1.close();*/

			/*
			start 
			*/
//				if(result){
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("SELECT * FROM IP_PATIENT_LAST_ENCOUNTER WHERE  PATIENT_ID='"+patientid+"' AND  DISCHARGE_DATE_TIME >= To_Date('"+admissiondate+"','dd/mm/yyyy hh24:mi')");
					if(pstmt1!=null) pstmt1.close();
					if(rset1!=null) rset1.close();


					pstmt1 = con.prepareStatement(sql.toString());
					rset1	  = pstmt1.executeQuery();
					if(rset1.next()){
						result = false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"ADM_DT_GR_LST_DIS_DT","IP");
						sb.append( (String) message.get("message")) ;
						message.clear();
					}else
						result = true;
					if(rset1!=null) rset1.close();
					if(pstmt1!=null) pstmt1.close();
//			}

			/*
			end 
			*/
			// validations for RoomNo...IF bed is assigned then room cannot be blank..,
			if(result){
				if(!bedno.equals("") && roomno.equals("")){
					java.util.Hashtable room_message = MessageManager.getMessage(locale,"ROOM_CANT_BE_BLANK","IP");
					sb.append( (String) room_message.get("message"));
					room_message.clear();
					result = false;
				}//Bed Validation Ends
			}
			if(result){
				if(!nursingunit.equals("")){
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("select locn_code from am_os_user_locn_access_vw where facility_id = '"+facilityId+"' and oper_stn_id = (select oper_stn_id from am_user_for_oper_stn where facility_id='"+facilityId+"' and appl_user_id ='"+login_User+"' and trunc(sysdate) between eff_date_from and nvl(eff_date_to,trunc(sysdate))) and APPL_USER_ID = '"+login_User+"' and locn_type = 'N' AND (revise_admission_yn='Y'  or ADMIT_PATIENT_WITH_BED_YN = 'Y') and LOCN_CODE = '"+nursingunit+"' ");
					if(pstmt!=null) pstmt.close();
					if(rset!=null) rset.close();
					pstmt = con.prepareStatement(sql.toString());
					srs	  = pstmt.executeQuery();
					if(!srs.next()){
						result = false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"NURS_UNIT_NOT_DEFINED","IP");
						sb.append( (String) message.get("message")) ;
						message.clear();
					}
					if(srs!=null) srs.close();
				}//Nursing Unit Validation Ends
			}
			if(result){

				//Check for Valid nursing Unit -  Practitioner Admission Rights
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" Select '1' from IP_NURSING_UNIT_FOR_PRACT where facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunit +"' and practitioner_id='"+practitioner+"' ");
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
				pstmt=con.prepareStatement(sql.toString());
				srs = pstmt.executeQuery();
					if(!srs.next()){
						result = false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"PRACT_ADMN_RIGHTS_DENIED","IP" );
						sb.append( (String) message.get("message")) ;
						message.clear();
					}
				if(srs!=null) srs.close();
			}
			if(result){
				if(!attd_practitioner.equals("")){
					//Check for Valid nursing Unit -  Practitioner Admission Rights
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" Select '1' from IP_NURSING_UNIT_FOR_PRACT where facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunit +"' and practitioner_id='"+attd_practitioner+"' ");
					if(pstmt!=null) pstmt.close();
					if(rset!=null) rset.close();
					pstmt=con.prepareStatement(sql.toString());
					srs = pstmt.executeQuery();
					if(!srs.next()){
						result = false;
						java.util.Hashtable message = MessageManager.getMessage( locale,"PRACT_ADMN_RIGHTS_DENIED","IP" ) ;
						sb.append( (String) message.get("message")) ;
						message.clear();
					}
					if(srs!=null) srs.close();
				}
			}
			if(result){
				//Check for Valid nursing Unit - Speciality Admission Rights
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" Select '1' from ip_nurs_unit_for_specialty a, am_speciality b where a.facility_id='"+facilityId+"' and a.nursing_unit_code='"+nursingunit+"' and a.specialty_code = b.speciality_code and b.eff_status = 'E' and a.specialty_code='"+speciality+"' ");
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
				pstmt=con.prepareStatement(sql.toString());
				srs = pstmt.executeQuery();
				if(!srs.next()){
					result = false;
					java.util.Hashtable message = MessageManager.getMessage( locale,"SPLTY_ADMN_RIGHTS_DENIED","IP" ) ;
					sb.append( (String) message.get("message")) ;
					message.clear();
				}
				if(srs!=null) srs.close();
			}
				//Checking for valid age group and gender
	if(result){
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" SELECT age_group_code, locn_type, appl_patient_class FROM IP_NURSING_UNIT WHERE facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunit+"' ");
				if(rset!=null) rset.close(); if(pstmt!=null) pstmt.close();
				pstmt=con.prepareStatement(sql.toString());
				srs = pstmt.executeQuery();
					if (srs.next()){
							String agegrpcode = checkForNull(srs.getString(1));
							nursingunittype = checkForNull(srs.getString(2));
							appl_patient_class = checkForNull(srs.getString("appl_patient_class"));
								if(!agegrpcode.equals("")){
										StringBuffer ageGrpCodesql = new StringBuffer();
										ageGrpCodesql.append(" Select '1' from am_age_group Where age_group_code='"+agegrpcode+"'  And NVL(GENDER,'"+patientgender+"')= '"+patientgender+"' AND  trunc(SYSDATE)- to_date('"+dateofbirth+"','dd/mm/rrrr') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE ");
										if(pstmt!=null) pstmt.close();
										if(rset!=null) rset.close();
										pstmt=con.prepareStatement(ageGrpCodesql.toString());
										srs = pstmt.executeQuery();
										if(!srs.next()){
											result = false;
											java.util.Hashtable message = MessageManager.getMessage( locale, "AGE_GENDER_NOT_ALLOWED","IP" ) ;
											sb.append( (String) message.get("message")) ;
											message.clear();
										}
							}
					}
			if(srs!=null) srs.close();
		}
		/*Checking For  for valid Bed*/
			if(result){
				if (!(bedno.equals("") || bedno == null )){
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" Select pseudo_bed_yn, occupying_patient_id, bed_type_code, bed_class_code, sex_spec_ind, room_no, specialty_code from IP_NURSING_UNIT_BED where facility_id='"+facilityId+"' and nursing_unit_code='"+nursingunit+"' And bed_no='"+bedno+"' ");
					if(rset!=null) rset.close(); if(pstmt!=null) pstmt.close();
					pstmt=con.prepareStatement(sql.toString());
					srs = pstmt.executeQuery();
						if(!srs.next()){
						result = false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"INVALID_BED","Common");
						sb.append((String) message.get("message"));
						message.clear();
					}else{
						pseudo_bed_yn = checkForNull(srs.getString("pseudo_bed_yn"),"N");
						String occupyingpatientid = checkForNull(srs.getString("Occupying_Patient_Id"));
						String tabbedclasscode = checkForNull(srs.getString("bed_class_code"));
						String sex_spec_ind = checkForNull(srs.getString("sex_spec_ind"));
						String splty_code = checkForNull(srs.getString("specialty_code"));
						if ((!occupyingpatientid.equals(""))&&(!frm_bed_no.equals(bedno))){
							result = false;
							java.util.Hashtable message = MessageManager.getMessage( locale, "OCCUPIED_BED","IP");
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
						else if(!tabbedclasscode.equals(bedclass)){
							result = false;
							java.util.Hashtable message = MessageManager.getMessage( locale, "INVALID_BED_CLASS","IP");
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}else if ((!sex_spec_ind.equals("")) && (!patientgender.equals(sex_spec_ind))){
							result = false;
							java.util.Hashtable message = MessageManager.getMessage( locale, "AGE_GENDER_NOT_ALLOWED","IP" ) ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
						else if (!splty_code.equals("") && !splty_code.equals(speciality)){ //Added for specialty to bed validation
							result = false;
							java.util.Hashtable message = MessageManager.getMessage( locale, "BED_SPLTY_INVALID","IP");
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
						//Modified by Rajan for gender specific bed
				}
					if(srs!=null) srs.close();
		}
	}
/*Checking for Blocked/Booked beds*/
			if(result){
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" Select booking_type, override_yn, patient_id from IP_BED_BOOKING WHERE facility_id='"+facilityId+"' and req_nursing_unit_code='"+nursingunit+"' "+
				" and req_bed_no='"+bedno+"' and booking_status='0' AND sysdate between blocked_from_date_time and blocked_until_date_time ");
				if(rset!=null) rset.close(); if(pstmt!=null) pstmt.close();
				pstmt=con.prepareStatement(sql.toString());
				srs = pstmt.executeQuery();
				if (srs.next()){
					String bookingtype = checkForNull(srs.getString(1));
					String overrideyn  = checkForNull(srs.getString(2));
					if(overrideyn.equals("") || overrideyn == null) overrideyn = "N";
					String patID  = checkForNull(srs.getString(3));
					if(overrideyn.equals("Y")){
						blocked_yn  = "Y";
						if((!patID.equals("")) && (patID.equals(patientid))){
							result = true;
						}else{
							if (bookingtype.equals("L")){
								result = true;
								java.util.Hashtable message = MessageManager.getMessage(locale,"OVERRIDEABLE_BKG","IP");
								sb.append( (String) message.get("message")) ;
								message.clear();
							}else{
								result = true;
								java.util.Hashtable message = MessageManager.getMessage( locale, "OVERRIDEABLE_BLOCKING","IP");
								sb.append( (String) message.get("message") ) ;
								message.clear();
							}
						}
					}
					else if(overrideyn.equals("N")){
						if((!patID.equals("")) && (patID.equals(patientid))){
							result = true;
						}
						else if (bookingtype.equals("L")){
							result = false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"NON_OVERRIDEABLE_BKG","IP");
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}else{
							result = false;
							java.util.Hashtable message = MessageManager.getMessage(locale,"BLOCKED_BED","IP");
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
					}
				}
				if(srs!=null) srs.close();
			}
/*Checking for same sex in the room*/
	if(result){
		if (!(roomno.equals("") || roomno == null )){
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" select a.occ_male_bed_count, a.occ_female_bed_count, a.occ_unknown_bed_count from ip_nursing_unit_room a, ip_nursing_unit b where a.facility_id='"+facilityId+"' and   a. nursing_unit_code='"+nursingunit+"' and  a.room_no='"+roomno+"' and  b.facility_id=a.facility_id and  b.nursing_unit_code=a.nursing_unit_code and b.check_same_sex_in_room_yn='Y' ");
					if(rset!=null) rset.close(); if(pstmt!=null) pstmt.close();
					pstmt=con.prepareStatement(sql.toString());
					srs = pstmt.executeQuery();
					if(srs.next()){
						int malebedcount  = srs.getInt(1);
						int femalebedcount = srs.getInt(2);
						int unknownbedcount = srs.getInt(3);
						if(malebedcount > 0)    L_current_gender = "M";
						else if(femalebedcount > 0) L_current_gender = "F";
						else if(unknownbedcount > 0) L_current_gender = "U";					
						if (!L_current_gender.equals("*") && !L_current_gender.equals(patientgender)){
							result = false;
							java.util.Hashtable message = MessageManager.getMessage( locale, "IN_ROOM_ONLY_SAME_GENDER","IP" ) ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
					}
					if(srs!=null) srs.close();
				}
			}
/*Check for multi-user having access to change bed classs & bed type*/		
			if(result)
			{
	

				if(bl_Instal.equals("Y")) {

					

				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("Select BL_IP_DETAILS.BL_CHECK_SERVICE_EXISTS(?,?,'I',?)p_service_charge_YN from dual");
				if(rset!=null) rset.close(); if(pstmt!=null) pstmt.close();
				
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1,facilityId);
				pstmt.setString(2,patientid);
				pstmt.setString(3,encounter_id);
				srs = pstmt.executeQuery();
				if(srs != null && srs.next())
					p_service_charge_YN = checkForNull(srs.getString("p_service_charge_YN"));
				if(p_service_charge_YN.equals("Y"))
				{
					java.util.Hashtable message = MessageManager.getMessage( locale, "SERVICE_CHARGE_EXISTS","IP" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
				}
				else
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("Select  BL_IP_DETAILS.BL_CHECK_UNPROCESSED_EXISTS (?,?,'I',?) P_UNPROCESSED_SERVICE_YN  from dual");
					if(rset!=null) rset.close(); if(pstmt!=null) pstmt.close();
					
					pstmt=con.prepareStatement(sql.toString());
					pstmt.setString(1,facilityId);
					pstmt.setString(2,patientid);
					pstmt.setString(3,encounter_id);
					srs = pstmt.executeQuery();
					if(srs != null && srs.next())
						p_Unprcs_Servc_YN = checkForNull(srs.getString("P_UNPROCESSED_SERVICE_YN"));
					if(p_Unprcs_Servc_YN.equals("Y"))
					{
						java.util.Hashtable message = MessageManager.getMessage( locale, "UNPROCESSED_SERVICE_EXISTS","IP" ) ;
						sb.append( (String) message.get("message") ) ;
						message.clear();
					}
					else
					{
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append("Select  bl_ip_details.BL_CHECK_ADM_DEPOSIT_EXISTS(?,?) P_ADM_DEPOSIT_YN  from dual");
						if(rset!=null) rset.close(); if(pstmt!=null) pstmt.close();
						
						pstmt=con.prepareStatement(sql.toString());
						pstmt.setString(1,facilityId);
						pstmt.setString(2,encounter_id);
						srs = pstmt.executeQuery();
						if(srs != null && srs.next())
							p_adm_deposit_YN = checkForNull(srs.getString("P_ADM_DEPOSIT_YN"));
						if(p_adm_deposit_YN.equals("Y"))
						{
							java.util.Hashtable message = MessageManager.getMessage( locale, "DEPOSIT_EXISTS","IP" ) ;
							sb.append( (String) message.get("message") ) ;
							message.clear();
						}
					}
				}

				if(srs!=null) srs.close();
			}
			}
			
/*
			if(result)
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" SELECT Count(1) FROM IP_NURS_UNIT_FOR_SPECIALTY WHERE FACILITY_ID = '"+facilityId+"' AND NURSING_UNIT_CODE= '"+nursingunit+"' AND SPECIALTY_CODE = '"+speciality+"' ");
				if(rset!=null) rset.close(); 
				if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(sql.toString());
				srs	  = pstmt.executeQuery();
				if(srs.next())
				{
					int nurSpclCount  = srs.getInt(1);
					if (nurSpclCount == 0)
					{
						result = false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"IN_ROOM_ONLY_SAME_GENDER","IP");
						sb.append((String)message.get("message"));
						message.clear();
					}
				}
				if(srs!=null) srs.close();
				if(pstmt != null)     pstmt.close() ;
			}
*/
				if(pstmt != null)     pstmt.close() ;
				if(rset != null)      rset.close();
				if(pstmt1 != null)    pstmt1.close() ;
				if(rset1 != null)     rset1.close();
				if(srs != null)       srs.close();
		}catch(Exception e){
			result  = false;
			e.printStackTrace() ;
		}finally{
				try{
				if(pstmt != null)     pstmt.close() ;
				if(rset != null)      rset.close();
				if(pstmt1 != null)    pstmt1.close() ;
				if(rset1 != null)     rset1.close();
				if(srs != null)       srs.close();
				if(con != null)  ConnectionManager.returnConnection(con,req);
			}catch(Exception ex){}
			//if(con != null)	ConnectionManager.returnConnection(con,p);

		}
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		results.put( "blocked_yn", blocked_yn ) ;
		return results ;
}



	private String checkForNull(String inputString){
		return (inputString==null)	?	""	:	inputString;
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
		/*
		TabData.put("frm_specialty_code"		 , checkForNull(req.getParameter("frm_specialty_code")));
		TabData.put("frm_service_code"		,  checkForNull(req.getParameter("frm_service_code")));
		TabData.put("frm_subservice_code"	 ,	checkForNull(req.getParameter("frm_subservice_code")));
		TabData.put("frm_bed_class_code"		 ,	checkForNull(req.getParameter("frm_bed_class_code")));
		TabData.put("frm_bed_type_code"		 ,	checkForNull(req.getParameter("frm_bed_type_code")));
		TabData.put("frm_ambulatory_status"	 ,	checkForNull(req.getParameter("frm_ambulatory_status_code")));
		TabData.put("frm_admission_type"		 ,	checkForNull(req.getParameter("frm_admission_type")));
		TabData.put("frm_exp_discharge_date_time",checkForNull(req.getParameter("frm_exp_discharge_date_time")));
		TabData.put("frm_ot_date_time"			,	checkForNull(req.getParameter("frm_ot_date_time")));
		TabData.put("frm_practitioner_id"		 ,	checkForNull(req.getParameter("frm_practitioner_id")));
		TabData.put("frm_admit_practitioner_id" ,checkForNull(req.getParameter("frm_admit_practitioner_id")));
		TabData.put("frm_revision_reason_code"	 ,	checkForNull(req.getParameter("frm_revision_reason_code")));*/

		/*		frm_service_code					=	checkForNull(req.getParameter("frm_service_code"));               
				frm_subservice_code			=	checkForNull(req.getParameter("frm_subservice_code"));          
				frm_bed_class_code				=	checkForNull(req.getParameter("frm_bed_class_code"));           
				frm_bed_type_code				=	checkForNull(req.getParameter("frm_bed_type_code"));           
				frm_ambulatory_status			=	checkForNull(req.getParameter("frm_ambulatory_status_code"));			
				frm_admission_type				=	checkForNull(req.getParameter("frm_admission_type"));
				frm_exp_discharge_dtTime	=	checkForNull(req.getParameter("frm_exp_discharge_date_time"));
				frm_ot_date_time					=	checkForNull(req.getParameter("frm_ot_date_time"));              
				frm_admit_practitioner_id	=	checkForNull(req.getParameter("frm_admit_practitioner_id"));            	
				frm_practitioner_id				=	checkForNull(req.getParameter("frm_practitioner_id")); 
				frm_revision_reason_code	= checkForNull(req.getParameter("frm_revision_reason_code"));*/
				
