
﻿
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>                  
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<html>  
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eOA/js/OAResourceComponent.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"> </script>
		<script src='../../eOA/js/BookAppointment.js' language='javascript'></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>
 


<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	

	String clinic_type=checkForNull(request.getParameter("clinic_type"),"C");
	HashMap patInstructionsMap	=(HashMap)(session.getAttribute("patInstructionsMap")==null?new HashMap():session.getAttribute("patInstructionsMap"));
	HashMap prcInstructionMap	=(HashMap)(session.getAttribute("prcInstructionMap")==null?new HashMap():session.getAttribute("prcInstructionMap"));
	patInstructionsMap.clear();
	prcInstructionMap.clear();
	session.setAttribute("patInstructionsMap", patInstructionsMap);
	session.setAttribute("prcInstructionMap", prcInstructionMap);
	String facilityid=(String)session.getValue("facility_id");
	String Resource_type="";
	String sql5="";
	//venkat
	String dtl_msg_yn="";
	//venkat
	String res_type=checkForNull(request.getParameter("res_type"),"P");
	String or_catalogue_code=request.getParameter("or_catalogue_code");//From Schedule criteria order is selected
	if(or_catalogue_code ==null || or_catalogue_code.equals("null")) or_catalogue_code="";
	String from_page =checkForNull(request.getParameter("from_page"));
	String from_page1 =checkForNull(request.getParameter("from_page1"));
	String apptrefno=checkForNull(request.getParameter("apptrefno"));
	String canldapptrefno=checkForNull(request.getParameter("canldapptrefno"));
	int visit_ind_count=0;
	int clinicInstructionsCount=1;
	String upt_contact_dtls_mp_yn="";//added changes for HSA-CRF-0226 [IN:050599]

	String upd_pat_dtls_referral_yn = ""; //Added by Dharma  on Apr 13th 2016 against HSA-CRF-0303 [IN:054572]
	
	String max_slot_default_yn=""; //Added Senthil
	
	String clinicInsYN="N";
	String orderInsYN="N";
	String orderInsStandardYN="N";
	String multi_speciality_yn="N";//Added for the CRF - Bru-HIMS-CRF-0198
	String visit_type_ind=checkForNull(request.getParameter("visit_type_ind"));
	//String referral_id=request.getParameter("referral_id");
	//if(referral_id ==null) referral_id="";
	String spec_code="";
	String age_group_code="";
	String care_locn_ind_desc="";
	if(clinic_type.equals("C")){
		care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}else if(clinic_type.equals("E")){
		care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
	}else if(clinic_type.equals("D")){
		care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
	}
	String res_class_desc="";
	int visit_type_cnt=0;
	String cliniccode=checkForNull(request.getParameter("clinic_code"));
	if(res_type.equals("P")){
		res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	}else if(res_type.equals("E")){
		res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
	}else if(res_type.equals("R")){
	   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
	}else if(res_type.equals("O")){
		res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
	}
	String dttm="";
	String Forced=request.getParameter("Forced");
	if(Forced==null || Forced.equals("null"))
		Forced="N";
	//String globaluser = (String)p.getProperty("login_user");
	String Global=request.getParameter("Global");
	if(Global==null || Global.equals("null"))
		Global="N";
	String block_break_appt=request.getParameter("block_break_appt");
	if(block_break_appt==null || block_break_appt.equals("null"))
		block_break_appt="N";
	String order_id=request.getParameter("order_id");	
	if(order_id ==null || order_id.equals("null") )order_id ="";
	String order_line_num=request.getParameter("order_line_num");
	if(order_line_num ==null || order_line_num.equals("null")) order_line_num="";
	String order_catalog_code=request.getParameter("order_catalog_code");//From Pending order schedule
	if(order_catalog_code ==null || order_catalog_code.equals("null")) order_catalog_code="";
	String ca_mode=(String) session.getValue("CallMode1");
	if(ca_mode==null) ca_mode=""; 
	//MR by suman 
	String req_id=checkForNull(request.getParameter("req_id"));
	String create_wait_list_yn=checkForNull(request.getParameter("create_wait_list_yn"));
	//String create_wait_list_yn1="";
	String visit_flag_OP=checkForNull(request.getParameter("visit_flag_OP"),"N");
	String bl_operational			= (String)session.getValue("bl_operational"); 
	String capture_fin_dtls_yn=checkForNull(request.getParameter("capture_fin_dtls_yn"));
	String noshow_ctrl_by_splty_or_clinic=checkForNull(request.getParameter("noshow_ctrl_by_splty_or_clinic"));
	String min_ela_per_resc_noshow_in_day=checkForNull(request.getParameter("min_ela_per_resc_noshow_in_day"));
	String contact_num_reqd_yn= checkForNull(request.getParameter("contact_num_reqd_yn"),"N");
	//OPCheckout
	String from_facility_id= checkForNull(request.getParameter("from_facility_id"));
	String from_encounter_id= checkForNull(request.getParameter("from_encounter_id"));
	String no_of_noshow_appts_for_alert =checkForNull(request.getParameter("no_of_noshow_appts_for_alert"));
	String per_chk_for_no_show_alert    =checkForNull(request.getParameter("per_chk_for_no_show_alert"));
	String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");
	String MaxcancelAlert=request.getParameter("MaxcancelAlert")==null?"N":request.getParameter("MaxcancelAlert");//fix for regression issue
	if(rd_appt_yn.equals(""))rd_appt_yn="N";
	String referral_id="";
	try{
		if(!from_page.equals("modifyappt")){
			referral_id=checkForNull((String)session.getAttribute("referral_id_app"));
		}else{
			referral_id=checkForNull(request.getParameter("referral_id"));
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	//Changes for Rutnin CRF Starts
	String rule_appl_yn	=checkForNull(request.getParameter("rule_appl_yn"),"N");
	String rule_based_tr	=checkForNull(request.getParameter("rule_based_tr"),"N");
	String patient_id_temp	=checkForNull(request.getParameter("patient_id_temp"));
	String name_prefix_temp	=checkForNull(request.getParameter("name_prefix_temp"));
	String first_name_temp	=checkForNull(request.getParameter("first_name_temp"));
	String second_name_temp	=checkForNull(request.getParameter("second_name_temp"));
	String third_name_temp	=checkForNull(request.getParameter("third_name_temp"));
	String family_name_temp	=checkForNull(request.getParameter("family_name_temp"));
	String name_suffix_temp	=checkForNull(request.getParameter("name_suffix_temp"));
	
	String name_prefix_oth_lang_temp	=checkForNull(request.getParameter("name_prefix_oth_lang_temp"));
	String first_name_oth_lang_temp	=checkForNull(request.getParameter("first_name_oth_lang_temp"));
	String second_name_oth_lang_temp	=checkForNull(request.getParameter("second_name_oth_lang_temp"));
	String third_name_oth_lang_temp	=checkForNull(request.getParameter("third_name_oth_lang_temp"));
	String family_name_oth_lang_temp	=checkForNull(request.getParameter("family_name_oth_lang_temp"));
	String name_suffix_oth_lang_temp	=checkForNull(request.getParameter("name_suffix_oth_lang_temp"));
	String gender_temp		=checkForNull(request.getParameter("gender_temp"));
	String contact_no_temp	=checkForNull(request.getParameter("contact_no_temp"));
	String prefPractYN		=checkForNull(request.getParameter("prefPractYN"),"Y");
	String nationality_code_temp		=checkForNull(request.getParameter("nationality_code_temp"));
	String language_code_temp		=checkForNull(request.getParameter("language_code_temp"));
	String term_set_id			= checkForNull(request.getParameter("term_set_id"));
	String linking_code			= checkForNull(request.getParameter("linking_code")); 	
	String mob_num_req_yn	="";
	String nat_desc_temp	="";
	String lang_desc_temp	="";
	String ord_pract_id	="";

	Connection conn = null;
	Statement stmt=null;
	Statement stmt1_p =null;
	Statement stmtas=null;
	Statement stmtsrl=null;
	Statement stmtc=null;
	Statement stmt2=null;
	Statement stmt1=null;
	Statement stmt7=null;
	Statement stmtt=null;
	Statement stmtap=null;
	Statement stmtlen=null;
	Statement stmtdt=null;
	Statement stmt_visit_type=null;
	Statement stmt_service=null;
	ResultSet rsas=null;
	ResultSet rst=null;
	ResultSet rs=null;
	ResultSet rssrl=null;
	ResultSet rsc=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	ResultSet rs3=null;
	ResultSet rsap=null;
	ResultSet rslen=null;
	ResultSet rs32=null;
	ResultSet rs_nid=null;
	ResultSet rs_ser=null;
	ResultSet rs_p=null;
	ResultSet obc=null;
	ResultSet rsdt=null;
	ResultSet rs_service=null;
	PreparedStatement pstmt =null;
	String service_code="";
	String allow_referral_yn = "";
	String allow_non_referral_yn = "";
	String enableReferralID  = "";
	String readonlyReferralID = "";
	String break_flag = "N";
	String only_fv_allowed_flag = "N";
	String currentDate="";
	String locale ="";
	String email_appl_yn="";
	String email_appl_for_appt_wo_pid_yn="";
	String pat_email_appl_yn="";
	String send_email_yn="N";
	String or_install_yn="";
	String follow_visit_type_yn="Y";
	String or_appt_time="";
	String ENTITLEMENT_BY_PAT_CAT_YN="";
	String customer_id=(String)session.getValue("CUSTOMER_ID");
	String language_req_yn ="";
	String tempLangugaeID="";

	boolean isIncRemarksLengthAppl = false;//Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058
	
	boolean isOverBookingAppl = false;//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017

	boolean isSlotTimeAppl = false;//Added by Kamatchi S for NMC-JD-CRF-0104

	boolean isVIRTUAL_CONSULTATION = false;//Added by Kamatchi S for ML-MMOH-CRF-1930-US008

	try{
		conn = ConnectionManager.getConnection(request);
		isIncRemarksLengthAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OA","INCREASE_APPT_REMARKS_LENGTH");//Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058
		
		isVIRTUAL_CONSULTATION  = eCommon.Common.CommonBean.isSiteSpecific(conn,"OP","VIRTUAL_CONSULTATION");

		isOverBookingAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OA","SCH_APPT_OVER_BOOKING");//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017

		isSlotTimeAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OA","OR_CAT_SLOT_TIME_DEF");//Added by Kamatchi S for NMC-JD-CRF-0104
		Statement stmtn = conn.createStatement();
		stmtap=conn.createStatement();
		stmtas=conn.createStatement();
		stmt1=conn.createStatement();
		locale = (String)session.getAttribute("LOCALE");
		stmt=conn.createStatement();
		//String param_sql="select EMAIL_APPL_YN,EMAIL_APPL_FOR_APPT_WO_PID_YN,CONTACT_NUM_REQD_YN,SPLT_FUT_APPT_ALERT_YN,(select ENTITLEMENT_BY_PAT_CAT_YN from mp_param where module_id='MP')ENTITLEMENT_BY_PAT_CAT_YN ,(select ord_pract_id from or_order where order_id = '"+order_id+"' ) ord_pract_id , RULE_APPL_YN, MOB_NUM_REQ_YN,LANGUAGE_REQ_YN,max_slot_default_yn,upt_contact_dtls_mp_yn FROM oa_param where module_id='OA'";
		String param_sql="select EMAIL_APPL_YN,EMAIL_APPL_FOR_APPT_WO_PID_YN,CONTACT_NUM_REQD_YN,SPLT_FUT_APPT_ALERT_YN,(select ENTITLEMENT_BY_PAT_CAT_YN from mp_param where module_id='MP')ENTITLEMENT_BY_PAT_CAT_YN, (select upd_pat_dtls_referral_yn from mp_param where module_id='MP') upd_pat_dtls_referral_yn  ,(select ord_pract_id from or_order where order_id = '"+order_id+"' ) ord_pract_id , RULE_APPL_YN, MOB_NUM_REQ_YN,LANGUAGE_REQ_YN,max_slot_default_yn,upt_contact_dtls_mp_yn FROM oa_param where module_id='OA'";
		pstmt=conn.prepareStatement(param_sql);
		rs=pstmt.executeQuery() ;
		if(rs!=null && rs.next()){
			email_appl_yn=rs.getString("EMAIL_APPL_YN")==null?"N":rs.getString("EMAIL_APPL_YN");
			email_appl_for_appt_wo_pid_yn=rs.getString("EMAIL_APPL_FOR_APPT_WO_PID_YN")==null?"N":rs.getString("EMAIL_APPL_FOR_APPT_WO_PID_YN");
			contact_num_reqd_yn=rs.getString("CONTACT_NUM_REQD_YN")==null?"N":rs.getString("CONTACT_NUM_REQD_YN");
			ENTITLEMENT_BY_PAT_CAT_YN=rs.getString("ENTITLEMENT_BY_PAT_CAT_YN");
			rule_appl_yn = rs.getString("RULE_APPL_YN")==null?"N":rs.getString("RULE_APPL_YN");
			mob_num_req_yn=rs.getString("MOB_NUM_REQ_YN")==null?"N":rs.getString("MOB_NUM_REQ_YN");
			ord_pract_id=rs.getString("ord_pract_id")==null?"N":rs.getString("ord_pract_id");
			language_req_yn=rs.getString("LANGUAGE_REQ_YN")==null?"N":rs.getString("LANGUAGE_REQ_YN");
			  //below line was added by venkatesh.S(4008) on 16-Mar-2012 anaginst Bru-HIMS-CRF-168 [IN030287]_0A
			  dtl_msg_yn=rs.getString("SPLT_FUT_APPT_ALERT_YN")==null?"N":rs.getString("SPLT_FUT_APPT_ALERT_YN");
			 //end  Bru-HIMS-CRF-168 [IN030287]_0A
			 max_slot_default_yn=rs.getString("max_slot_default_yn")==null?"N":rs.getString("max_slot_default_yn");
			 /*Above line added by senthil*/
			 upt_contact_dtls_mp_yn=rs.getString("upt_contact_dtls_mp_yn")==null?"N":rs.getString("upt_contact_dtls_mp_yn");//added changes for HSA-CRF-0226 [IN:050599]
			  upd_pat_dtls_referral_yn=rs.getString("upd_pat_dtls_referral_yn")==null?"N":rs.getString("upd_pat_dtls_referral_yn");//Added by Dharma  on Apr 13th 2016 against HSA-CRF-0303 [IN:054572]
		}
		
		if(pstmt!=null){
			pstmt.close();
		}		
		if(from_page!=null && from_page.equals("modifyappt")){ 
			String appt_pat_ins="SELECT instruction_id,instruction_desc FROM oa_appt_pat_instructions WHERE facility_id = '"+facilityid+"' AND appt_ref_no = '"+apptrefno+"' ORDER BY display_order";
			String clinicInstr="SELECT a.instruction_id,a.display_order,a.default_linked_yn,b.instruction_desc FROM op_clinic_pat_instructions a, am_pat_instructions_lang_vw b  WHERE a.facility_id = '"+facilityid+"' AND a.clinic_code = '"+cliniccode+"' AND a.instruction_id = b.instruction_id AND b.language_id = '"+locale+"' AND a.instruction_id not in(SELECT  INSTRUCTION_ID FROM OA_APPT_PAT_INSTRUCTIONS WHERE facility_id = '"+facilityid+"' AND appt_ref_no='"+apptrefno+"') ORDER BY display_order";
			if(rs!=null)rs.close();
			rs=stmt.executeQuery(appt_pat_ins);
			HashMap patInstructionsMapResult=new java.util.HashMap();
			Integer tempInteger=null;
			while(rs!=null && rs.next()){
					String instructionID=rs.getString("instruction_id");
					String instructionDesc=rs.getString("instruction_desc");
					//String valueObject=instructionID+"|~"+instructionDesc+"|~Y";
					/*Above Line Commented by Senthil on 19-Oct-2011*/
					//String valueObject=instructionID+"==>"+instructionDesc+"==>Y";
					String valueObject=instructionID+"|~"+instructionDesc+"|~"+"Y";
					tempInteger=new Integer(clinicInstructionsCount);
					patInstructionsMapResult.put(tempInteger.toString(),valueObject);
					clinicInstructionsCount++;
			}
			if(rs!=null)rs.close();
			rs=stmt.executeQuery(clinicInstr);
			while(rs!=null && rs.next()){
				String instructionID=rs.getString("instruction_id");
				String instructionDesc=rs.getString("instruction_desc");
				//String default_linked_yn=rs.getString("DEFAULT_LINKED_YN");
				
				//String valueObject=instructionID+"|~"+instructionDesc+"|~"+"N";
				/*Above Line Commented by Senthil on 19-Oct-2011*/
				//String valueObject=instructionID+"==>"+instructionDesc+"==>"+"N";
				String valueObject=instructionID+"|~"+instructionDesc+"|~"+"N";
				tempInteger=new Integer(clinicInstructionsCount);
				patInstructionsMapResult.put(tempInteger.toString(),valueObject);
				clinicInstructionsCount++;
			}
			if(rs!=null)rs.close();
			if(clinicInstructionsCount > 1){
				clinicInsYN="Y";
				session.setAttribute("patInstructionsMap", patInstructionsMapResult);
			}
			String oa_apptSql="select order_id,patient_id,language_id from oa_appt where facility_id = '"+facilityid+"' AND appt_ref_no = '"+apptrefno+"'";
			if(rs!=null)rs.close();
			rs=stmt.executeQuery(oa_apptSql);
			String tempOrderID="";
			String tempPatientID="";
			
			if(rs!=null && rs.next()){
				tempOrderID=rs.getString("order_id")==null?"":rs.getString("order_id");
				tempPatientID=rs.getString("patient_id")==null?"":rs.getString("patient_id");
				tempLangugaeID=rs.getString("language_id")==null?"":rs.getString("language_id");
			}
			//Modified against PMG20089-CRF-0885.3 - Removed the OrderID Validations on Radiology Appointment without PatientID:
			/****Below "IF" Condition Description: 
			If it is Radiology appointment with patientid, OR If it is Normal appointment, 
			then it will check if orderid exists to show instructions button.
			If it is Radiology appointment without patientid, then it will show instructions button
			*****/
			//if(tempOrderID.equals("")){
			if( (("Y".equalsIgnoreCase(rd_appt_yn)) && (tempPatientID != "") && tempOrderID.equals("")) || ("N".equalsIgnoreCase(rd_appt_yn) && tempOrderID.equals("")) ){
			}else{
				int countProcInstructions=1;
				if(rs!=null)rs.close();
				String order_stand_ins="";
				String appt_prc_ins="SELECT instruction_desc FROM oa_appt_proc_instructions WHERE facility_id = '"+facilityid+"' AND appt_ref_no = '"+apptrefno+"'";
				rs=stmt.executeQuery(appt_prc_ins);
				if(rs!=null && rs.next()){
					order_stand_ins=rs.getString("INSTRUCTION_DESC")==null?"":rs.getString("INSTRUCTION_DESC");
					countProcInstructions++;
				}
				if(countProcInstructions>1){
					orderInsYN="Y";
					prcInstructionMap.put("prcIns",order_stand_ins);
					prcInstructionMap.put("patient_id",tempPatientID);
					prcInstructionMap.put("checked","Y");
					session.setAttribute("prcInstructionMap", prcInstructionMap);
				}
			}
		}else{//book appointment
		
			String order_stand_ins="";
			String clinicInsLinkSQL="Select a.INSTRUCTION_ID,a.DISPLAY_ORDER,a.DEFAULT_LINKED_YN,b.INSTRUCTION_DESC from op_clinic_pat_instructions a,am_pat_instructions_lang_vw b where a.facility_id=? and a.clinic_code=? and a.INSTRUCTION_ID =b.INSTRUCTION_ID and b.language_id=? order by DISPLAY_ORDER";
			String orderInsLinkSQL="select * from OR_ORDER_CATALOG_PREPS_INSTRN where ORDER_CATALOG_CODE=? and PAT_PREPS_OR_INSTRNS_IND in('IS','IM')";		
			if(rs!=null)rs.close();
			pstmt=conn.prepareStatement(clinicInsLinkSQL);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,cliniccode);
			pstmt.setString(3,locale);
			rs=pstmt.executeQuery();
			HashMap patInstructionsMapResult=new java.util.HashMap();
			Integer tempInteger=null;
			while(rs!=null && rs.next()){
					String instructionID=rs.getString("instruction_id");
					String instructionDesc=rs.getString("instruction_desc");
					String default_linked_yn=rs.getString("DEFAULT_LINKED_YN");
					//String valueObject=instructionID+"|~"+instructionDesc+"|~"+default_linked_yn;
					/*Above line Commented by Senthil on 19-Oct-2011*/
				    //String valueObject=instructionID+"==>"+instructionDesc+"==>"+default_linked_yn;
					String valueObject=instructionID+"|~"+instructionDesc+"|~"+default_linked_yn;
					tempInteger=new Integer(clinicInstructionsCount);
					patInstructionsMapResult.put(tempInteger.toString(),valueObject);
					clinicInstructionsCount++;
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(clinicInstructionsCount > 1){
				clinicInsYN="Y";
				session.setAttribute("patInstructionsMap", patInstructionsMapResult);
			}
			if(rs!=null)rs.close();
			if(order_catalog_code!=null && !order_catalog_code.equals("")){//from pending orders			
				orderInsLinkSQL="SELECT ORDER_LINE_FIELD_VALUE FROM or_order_line_field_values WHERE  order_line_field_mnemonic ='PATIENT_INSTRNS' and ORDER_ID=? and ORDER_LINE_NUM=?";
				pstmt=conn.prepareStatement(orderInsLinkSQL);
				pstmt.setString(1,order_id);
				pstmt.setString(2,order_line_num);
				rs=pstmt.executeQuery();
				if(rs!=null && rs.next()){
					order_stand_ins=rs.getString("ORDER_LINE_FIELD_VALUE");
					prcInstructionMap.put("prcIns",order_stand_ins);
					prcInstructionMap.put("checked","Y");
					session.setAttribute("prcInstructionMap", prcInstructionMap);
					orderInsYN="Y";
				}
				if(pstmt!=null){
					pstmt.close();
				}
			}else if(or_catalogue_code!=null && !or_catalogue_code.equals("")){
				pstmt=conn.prepareStatement(orderInsLinkSQL);
				pstmt.setString(1,or_catalogue_code);
				rs=pstmt.executeQuery();
				while(rs!=null && rs.next()){
	//	if(rs.getString("PAT_PREPS_OR_INSTRNS_IND").equals("IS")){
	//Above line commented and below line Added for this incident  [IN:043350]
	if(rs.getString("PAT_PREPS_OR_INSTRNS_IND").equals("IS") && !checkForNull(rs.getString("PAT_PREPS_OR_INSTRNS_TXT")).equals("")){ 
	
						orderInsStandardYN="Y";
						order_stand_ins=rs.getString("PAT_PREPS_OR_INSTRNS_TXT");
						prcInstructionMap.put("prcIns",order_stand_ins);
						prcInstructionMap.put("checked","Y");
						orderInsYN="Y";
						session.setAttribute("prcInstructionMap", prcInstructionMap);
					}else{
						orderInsYN="Y";
					}
					break;
				}
				if(pstmt!=null){
					pstmt.close();
				}
			}
			if(rule_appl_yn.equals("Y")){
				String lan_natSQL="select (select long_desc description from mp_country_lang_vw where COUNTRY_CODE='"+nationality_code_temp+"' and language_id='"+locale+"')country_desc,(Select LONG_DESC description from MP_LANGUAGE_LANG_VW where  MP_LANGUAGE_ID='"+language_code_temp+"' and language_id='"+locale+"')lang_desc from dual";
				if(rs!=null)rs.close();
				rs=stmt.executeQuery(lan_natSQL);
				if(rs!=null && rs.next()){
					nat_desc_temp=rs.getString("country_desc")==null?"":rs.getString("country_desc");
					lang_desc_temp=rs.getString("lang_desc")==null?"":rs.getString("lang_desc");
				}
			}
		}
		
		
%>
	<script language = 'javascript'> 
		var PSGCodeArray = new Array(); 
		var PSGYNArray = new Array(); 
		var NamePrefixArray = new Array(); 
		var PrefixSexArray = new Array();
	<%
	rs32 = stmtn.executeQuery("select name_prefix,prefix_sex from mp_name_prefix");
	int k =0;
	while(rs32!=null && rs32.next()){%>
		NamePrefixArray[<%=k%>]="<%=rs32.getString("name_prefix")%>"
		PrefixSexArray[<%=k%>]="<%=rs32.getString("prefix_sex")%>"
		<%k++;
	}%>
	</script>
 </head>
 <body onLoad="field();FocusFirstElement();validateFirstVisitDefault();checkMaxPatCnclReason();<%if(isSlotTimeAppl){%>slotTime();<%}%>" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onunload="clear_from_sess()">
<%
String book_appt_yn = request.getParameter("book_appt_yn");
if(book_appt_yn.equals("N")){%>
		<script>
		alert(getMessage('BKNG_NOT_ALLOWD','OA'));
		window.close();
		</script>
<%}
String book_appt_wo_pid_yn = checkForNull(request.getParameter("book_appt_wo_pid_yn"));
String book_appt_across_catg_yn = checkForNull(request.getParameter("book_appt_across_catg_yn"));
String alcn_criteria = request.getParameter("alcn_criteria");
if(alcn_criteria==null || alcn_criteria.equals("null")) alcn_criteria="";
StringBuffer sql_srl_no= new StringBuffer("");
String override_no_of_slots=checkForNull(request.getParameter("override_no_of_slots_yn"));
String visit_limit_rule=checkForNull(request.getParameter("visit_limit_rule"),"N");
String slot_appt_ctrl=checkForNull(request.getParameter("slot_appt_ctrl"));
String visit_flag="";
String patientid=request.getParameter("ca_patient_id");
if (patientid.equals(null)|| patientid.equals("null"))patientid ="";
//String clinicname=request.getParameter("clinic_name");
String clinicname="";
String obvisit_flag=request.getParameter("obvisit_flag");
if (obvisit_flag==null|| obvisit_flag.equals("null"))obvisit_flag="";
java.lang.StringBuffer strbfr_sql1=new java.lang.StringBuffer();
String visitcode="";
String visitdesc="";
String visitind="";
String NameDrvnLogic="";
String appt_sr_no="";
String practid="";
String practname="";
String enable_virtual_cons="D";//Added by kamatchi S for ML-MMOH-CRF-1930-US008
String apptdate="";
String fromtime="";
String totime="";
String overbookedyn="N";
String timetableyn="";
String starttime="";
String endtime="";
String wait_list_num="";

//String DMY = "dd/MM/yyyy";	
practid=checkForNull(request.getParameter("i_practitioner_id"));

//practname=checkForNull(request.getParameter("i_practitioner_name"));

//if(locale.equals("en")){
		//practname=java.net.URLDecoder.decode(practname);
//}
apptdate= checkForNull(request.getParameter("i_appt_date"));
fromtime=request.getParameter("i_from_time");
if(fromtime!=null){
	fromtime=fromtime.trim();
}
totime=request.getParameter("i_to_time");
if(totime!=null){
	totime=totime.trim();
}
overbookedyn=request.getParameter("i_over_booked");
if(Forced.equals("Y")) overbookedyn="N";
timetableyn=request.getParameter("i_time_table_type");
stmtsrl=conn.createStatement();
stmtlen=conn.createStatement();
//commented as part of PE and is combined with OA param query
/*String sql_mp_param="select ENTITLEMENT_BY_PAT_CAT_YN from mp_param where module_id='MP'";
rssrl=stmtsrl.executeQuery(sql_mp_param);
if(rssrl!=null){
	if(rssrl.next()){
					ENTITLEMENT_BY_PAT_CAT_YN=rssrl.getString("ENTITLEMENT_BY_PAT_CAT_YN");
	}
}*/
if(rssrl  !=null) rssrl.close();
String sql_wait_list_pass="SELECT DECODE(WAIT_LIST_PRIORITY,'U',1,'S',2,3) PRIORITY, MODIFIED_DATE, WAIT_LIST_NO FROM pr_wait_list WHERE PREFERRED_DATE_TIME=TO_DATE(?,'dd/mm/yyyy') AND LOCN_CODE =?  AND wait_list_status='O' AND ROWNUM='1' ORDER BY priority,modified_date";
pstmt=conn.prepareStatement(sql_wait_list_pass);
pstmt.setString(1,apptdate);
pstmt.setString(2,cliniccode);
rssrl=pstmt.executeQuery();
if(rssrl!=null){
	if(rssrl.next()){
		wait_list_num=rssrl.getString("WAIT_LIST_NO");
		if(wait_list_num ==null) wait_list_num="";
	}
}
if(pstmt!=null){
	pstmt.close();
}
if(rssrl  !=null) rssrl.close();
if (timetableyn.equals("3")){
	sql_srl_no.setLength(0);
	sql_srl_no.append(" select count(1) count from oa_clinic_break where facility_id =? and clinic_code =? and care_locn_type_ind=? and resource_class =? and day_no = (select day_no from sm_day_of_week where trim(day_of_week) = trim(to_char(to_date(?,'dd/mm/yyyy'),'DAY'))) and to_char(break_start_time,'hh24:mi') = ?");
	if(practid.equals("")){
		sql_srl_no.append(" and practitioner_id is null");
	}else{
		sql_srl_no.append(" and practitioner_id = ?");
	}
	pstmt=conn.prepareStatement(sql_srl_no.toString());
	pstmt.setString(1,facilityid);
	pstmt.setString(2,cliniccode);
	pstmt.setString(3,clinic_type);
	pstmt.setString(4,res_type);
	pstmt.setString(5,apptdate);
	pstmt.setString(6,totime);
	if(!practid.equals("")){
		pstmt.setString(7,practid);
	}
	rssrl=pstmt.executeQuery();
	sql_srl_no.setLength(0);
	if(rssrl!=null && rssrl.next()){
		if (rssrl.getInt("count")>0){
			break_flag = "Y";
		}
	}
	if(pstmt!=null){
		pstmt.close();
	}
}
if(rssrl !=null) rssrl.close();
if(rssrl !=null) rssrl.close();
if(! visit_limit_rule.equals("N")){
	// to be fired only when visit limit rule is either max or exact
	sql_srl_no.setLength(0);
	sql_srl_no.append(" select max_patients_per_day,max_first_visits,max_other_visits,nvl(total_first_visit,0)+nvl(total_first_visits_blocked,0) total_first_visit,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0)+nvl(total_other_visits_blocked,0) total_other_visits  from oa_clinic_schedule where facility_id =? and clinic_code =? and care_locn_type_ind=? and resource_class=? and CLINIC_DATE =to_date(?,'dd/mm/yyyy') ");
	if(practid.equals("")){
		sql_srl_no.append(" and practitioner_id is null");
	}else{
		sql_srl_no.append(" and practitioner_id = ?");
	}
	pstmt=conn.prepareStatement(sql_srl_no.toString());
	pstmt.setString(1,facilityid);
	pstmt.setString(2,cliniccode);
	pstmt.setString(3,clinic_type);
	pstmt.setString(4,res_type);
	pstmt.setString(5,apptdate);
	if(!practid.equals("")){
		pstmt.setString(6,practid);
	}
	rssrl=pstmt.executeQuery();
	sql_srl_no.setLength(0);
	if(rssrl!=null){
		if(rssrl.next()){
			if (rssrl.getInt("max_patients_per_day")==rssrl.getInt("max_first_visits"))
				only_fv_allowed_flag = "Y";
			else
				only_fv_allowed_flag = "N";
			 if (obvisit_flag.equals("")|| obvisit_flag.equals("N")){
				if (!(visit_limit_rule.equals("N"))){
					if (rssrl.getInt("max_first_visits")==rssrl.getInt("total_first_visit")&&rssrl.getInt("max_first_visits")>=0)
						visit_flag ="O";
					if (rssrl.getInt("max_other_visits")==rssrl.getInt("total_other_visits")&&rssrl.getInt("max_other_visits")>=0)
						visit_flag ="F";
					if (visit_limit_rule.equals("E")&&rssrl.getInt("max_first_visits")==0)
						visit_flag ="O";
					if (visit_limit_rule.equals("E")&&rssrl.getInt("max_other_visits")==0)
						visit_flag ="F";

				}
			}
		}
	}
	if(pstmt!=null){
		pstmt.close();
	}
}
pstmt=conn.prepareStatement("select speciality_code,service_code, allow_referral_yn, allow_non_referral_yn,age_group_code,long_desc,multi_speciality_yn from op_clinic_lang_vw  where facility_id=?  and clinic_code =? and language_id=?");
pstmt.setString(1,facilityid);
pstmt.setString(2,cliniccode);
pstmt.setString(3,locale);
rsas=pstmt.executeQuery();
if(rsas!=null && rsas.next()){
	clinicname=rsas.getString("long_desc");
	service_code=rsas.getString("service_code");
	allow_referral_yn = rsas.getString("allow_referral_yn");
	allow_non_referral_yn = rsas.getString("allow_non_referral_yn");
	spec_code=rsas.getString("SPECIALITY_CODE");
	multi_speciality_yn=rsas.getString("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF-0198
	age_group_code=rsas.getString("age_group_code");
	if(age_group_code==null) age_group_code="";
}
if(pstmt!=null){
	pstmt.close();
}
int nextno=0;
int maxno=0; 
if(rsas !=null) rsas.close();
pstmt=conn.prepareStatement("select next_srl_no,max_srl_no from oa_appt_srl_no where facility_id =?");
pstmt.setString(1,facilityid);
rsas=pstmt.executeQuery();

if(rsas!=null){
	if(rsas.next()){
		nextno=rsas.getInt("next_srl_no");
		maxno=rsas.getInt("max_srl_no");
	}else{%>
		<script>alert(getMessage('APPT_SRLNO_NOT_DEFINED','OA'));
		parent.window.close()
		</script>
	<%}
}
if(pstmt!=null){
	pstmt.close();
}

	if(maxno<nextno || maxno==nextno) {
	%>
		<script language='javascript'>
		var err_appt =getMessage("MAX_APPT_SRL_NO_EXCEEDED",'OA');
		alert(err_appt);
		parent.window.close();
		</script>
	<%}


	if (patientid.equals("")) {		
		if (allow_referral_yn.equals("Y") && allow_non_referral_yn.equals("Y"))
		{
			enableReferralID  = "";
			readonlyReferralID = "";			
		}
		else if (allow_referral_yn.equals("Y"))
		{
			enableReferralID  = "";
			readonlyReferralID = "";			
		}
		else if (allow_non_referral_yn.equals("Y"))
		{
			enableReferralID  = "disabled";
			readonlyReferralID = "readonly";			
		}
		else
		{
			enableReferralID  = "disabled";
			readonlyReferralID = "readonly";			
		}
	}
	
	if(from_page.equals("modifyappt")) {
		if(patientid.equals("") || patientid.equals("dummy_patinetID") || !allow_referral_yn.equals("Y") ){
			enableReferralID  = "disabled";
			readonlyReferralID = "readonly";		
		} else {
			readonlyReferralID = "";	
			enableReferralID = "";
		}

	}
//Bru-HIMS-CRF 169 changes start
	if(referral_id != null && !(referral_id.equals(""))){
		enableReferralID  = "disabled";
		readonlyReferralID = "readonly";		
	}
//Bru-HIMS-CRF 169 changes end	
	String pat_name_as_multipart_yn="";
	//String prefix="";
	//String suffix="";
	String srl_no="";
	String sys_date_time="";
	//stmt=conn.createStatement();
	if(rs !=null) rs.close();

	if(apptdate!=null && !(apptdate.equals(""))){
		stmtt=conn.createStatement();
		sql_srl_no.setLength(0);		
		//rst=stmtt.executeQuery("select to_char(start_time,'hh24:mi') start_time,to_char(end_time,'hh24:mi') end_time,srl_no from oa_clinic_schedule where clinic_code='"+cliniccode+"' and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_type+"' and trunc(clinic_date)=to_date('"+apptdate+"','DD/MM/YYYY') and facility_id='"+facilityid+"' and nvl(practitioner_id,'X')=nvl('"+practid+"','X')  and nvl(schedule_status,'X')!='B'");
		sql_srl_no.append("select to_char(start_time,'hh24:mi') start_time,to_char(end_time,'hh24:mi') end_time,srl_no from oa_clinic_schedule where clinic_code='"+cliniccode+"' and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_type+"' and trunc(clinic_date)=to_date('"+apptdate+"','DD/MM/YYYY') and facility_id='"+facilityid+"'   and nvl(schedule_status,'X')!='B'");
		if(practid.equals("")){
			sql_srl_no.append(" and practitioner_id is null");
		}else{
			sql_srl_no.append(" and practitioner_id = '"+practid+"'");
		}
		rst=stmtt.executeQuery(sql_srl_no.toString());
		sql_srl_no.setLength(0);
		if(rst != null && rst.next()){
			starttime=rst.getString("start_time");
			endtime=rst.getString("end_time");
			srl_no=rst.getString("srl_no");
			if (overbookedyn.equals("Y") && fromtime.equals("") &&totime.equals("")){
				fromtime=endtime;
				totime=endtime;
			}

			if(totime.equals("00:00"))
				totime = "23:59";
				
			obc =stmtt.executeQuery("select substr(to_date('"+apptdate+" "+totime+"','dd/mm/yyyy HH24:mi')- sysdate,0,1) diff, to_char(sysdate,'dd/mm/yyyy') toDate , to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time from dual");
			String obtm="";
			if(obc!=null && obc.next()){
				obtm=obc.getString("diff");
				currentDate=obc.getString("toDate");
				sys_date_time=obc.getString("sys_date_time");
			}
			
			//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017
			if(isOverBookingAppl)
			{
				if(obtm.equals("-") && !overbookedyn.equals("Y")){%>
					<script>
						alert(getMessage("FR_TIME_CAN_NOT_SYS_TIME","OA"));
						window.close();
					</script>
				<%}
			}else
			{
				if(obtm.equals("-")){%>
					<script>
						alert(getMessage("FR_TIME_CAN_NOT_SYS_TIME","OA"));
						window.close();
					</script>
				<%}
			}
		}
	}

		String ip_installed_yn = "";
		String rad_installed_yn = "";
		String rsapsql="select (select nvl(install_yn,'N') from sm_module where module_id = 'IP') ip_install_yn, (select to_char(sysdate,'dd/mm/yyyy') from dual) sysdt , (select to_char(sysdate,'hh24:mi') from dual) systm,(select to_char(sysdate,'dd/mm/yyyy') from dual) dttm ,(select nvl(operational_yn,'N') from sm_modules_facility where facility_id = ? and module_id = 'RD') rad_install_yn,(select OPERATIONAL_YN from sm_modules_facility where module_id='OR' and facility_id =?)or_install_yn,(select to_char(appt_time,'hh24:mi') from OR_ORDER_CATALOG where order_catalog_code = '"+or_catalogue_code+"') or_appt_time,(select FOLLOW_VISIT_TYPE_YN from OR_ORDER_CATALOG where order_catalog_code = '"+or_catalogue_code+"') follow_visit_type_yn  from dual ";
		pstmt=conn.prepareStatement(rsapsql.toString());
		pstmt.setString(1,facilityid);
		pstmt.setString(2,facilityid);
		rsap=pstmt.executeQuery();
		String str14="";
		if(rsap!=null && rsap.next()){
			ip_installed_yn = rsap.getString("ip_install_yn");
			if(ip_installed_yn==null || ip_installed_yn.equals(""))
				ip_installed_yn="N";

			or_install_yn= rsap.getString("or_install_yn")==null?"N":rsap.getString("or_install_yn");
			follow_visit_type_yn= rsap.getString("follow_visit_type_yn")==null?"Y":rsap.getString("follow_visit_type_yn");
			or_appt_time= rsap.getString("or_appt_time")==null?"":rsap.getString("or_appt_time");
			rad_installed_yn= rsap.getString("rad_install_yn");
			if(rad_installed_yn==null || rad_installed_yn.equals(""))
				rad_installed_yn="N";

			str14=rsap.getString("systm");
			dttm=rsap.getString("dttm");
		}else{
			ip_installed_yn = "N";
			rad_installed_yn= "N";
			str14=rsap.getString("systm");
			dttm=rsap.getString("dttm");
		}
		if(pstmt!=null){
			pstmt.close();
		}

	int ip_bkgs = 0;
	String vCallMD=(String) session.getValue("CallMode");
	String vCallMD1=(String) session.getValue("CallMode1");
	String patientid_CA=(String) session.getValue("patientid");

	String from_wait_list=(String) session.getValue("from_wait_list");
	if(from_wait_list ==null) from_wait_list="N";
	String waitListNo=(String) session.getValue("waitListNo");
	if(waitListNo ==null) waitListNo="";
	
	String wtListControl = checkForNull(request.getParameter("wtListControl"));
	//System.out.println("wtListControl AddModifyBookAppointment:"+wtListControl);
	//System.out.println("waitListNo AddModifyBookAppointment:"+request.getParameter("waitListNo"));
	if(wtListControl.equals("B")){
		from_wait_list = "Y";
		waitListNo = checkForNull(request.getParameter("waitListNo"));
		vCallMD="OP";
	}

	if(rs1 !=null)rs1.close();
	if(res_type.equals("P")){
		sql5  = "select pract_type res_type,AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1')practname,enable_virtual_cons from am_practitioner where practitioner_id= ? and practitioner_id is not null" ;
		pstmt=conn.prepareStatement(sql5);
		pstmt.setString(1,locale);
		pstmt.setString(2,practid);
	}else if(res_type.equals("R")){
		sql5  = "select room_type res_type,AM_GET_DESC.AM_FACILITY_ROOM(OPERATING_FACILITY_ID, room_num,?,'1')practname from am_facility_room where room_num =? and OPERATING_FACILITY_ID=? and room_num is not null";
		pstmt=conn.prepareStatement(sql5);
		pstmt.setString(1,locale);
		pstmt.setString(2,practid);
		pstmt.setString(3,facilityid);
	}else{
		sql5  = "select resource_type res_type,AM_GET_DESC.AM_RESOURCE(FACILITY_ID, RESOURCE_ID,?,'1')practname from am_resource where resource_id = ? and facility_id= ? and resource_Class=? and resource_id is not null" ;
		pstmt=conn.prepareStatement(sql5);
		pstmt.setString(1,locale);
		pstmt.setString(2,practid);
		pstmt.setString(3,facilityid);
		pstmt.setString(4,res_type);
	}
	rs1=pstmt.executeQuery();
	if(rs1!=null && rs1.next()){
		Resource_type = rs1.getString("res_type") ;
		practname = rs1.getString("practname") ;
		if(isVIRTUAL_CONSULTATION && res_type.equals("P")){
		enable_virtual_cons = rs1.getString("enable_virtual_cons") ;//Added by Kamatchi S for ML-MMOH-CRF-1930-US008
		}
	}
	if(pstmt!=null){
		pstmt.close();
	}
	if(rs1 !=null)rs1.close();	
	%>
		<center>
	    	<form name='Bkappt_form' id='Bkappt_form' action='../../servlet/eOA.BookAppointmentServlet' method='post' target='messageFrame'>

			
			<input type='hidden' name='name_drvn_logic' id='name_drvn_logic' value='<%=NameDrvnLogic%>'>
			<input type='hidden' name='appt_sr_no' id='appt_sr_no' value='<%= appt_sr_no%>'>
			<input type='hidden' name='time_table_type' id='time_table_type' value='<%= timetableyn%>'>
			<input type='hidden' name='overbooked' id='overbooked' value='<%=overbookedyn%>'>
			<input type='hidden' name='starttime' id='starttime' value='<%= starttime%>'>
			<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
			<input type='hidden' name='endtime' id='endtime' value='<%=endtime%>'>
			<input type='hidden' name='clinic_code' id='clinic_code' value='<%= cliniccode%>'>
			<input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=practid%>'>
			<input type='hidden' name='natcheck' id='natcheck' value=''>
			<input type='hidden' name='contactvals' id='contactvals' value=''>
			<input type='hidden' name='sec_value_count' id='sec_value_count' value=''>
			<input type='hidden' name='REC_VALUE' id='REC_VALUE' value=''>
			<input type='hidden' name='fromtimeh' id='fromtimeh' value='<%=fromtime%>'>
			<input type='hidden' name='clinic_name_sec' id='clinic_name_sec' value='<%=clinicname%>'>
			<input type='hidden' name='care_locn_desc_sec' id='care_locn_desc_sec' value='<%=care_locn_ind_desc%>'>
			<input type='hidden' name='res_pri_class_desc' id='res_pri_class_desc' value='<%=res_class_desc%>'>
			<input type='hidden' name='pract_name_pri' id='pract_name_pri' value='<%=practname%>'>
			<input type='hidden' name='totimeh' id='totimeh' value='<%=totime%>'>
			<input type='hidden' name='maxrecord' id='maxrecord' value=''>
			<input type='hidden' name='radbookings' id='radbookings' value=''>
			<input type='hidden' name='ipbookings' id='ipbookings' value='<%=ip_bkgs%>'>
			<input type='hidden' name='apptdate_time' id='apptdate_time' value='<%=apptdate%> <%=fromtime%>'>
			<input type='hidden' name='apptdate' id='apptdate' value='<%=apptdate%>'>		
			<input type='hidden' name='order_id' id='order_id' value='<%=order_id%>'>
			<input type='hidden' name='order_line_num' id='order_line_num' value='<%=order_line_num%>'>		
			<input type='hidden' name='order_catalog_code' id='order_catalog_code' value='<%=order_catalog_code%>'>
			<input type='hidden' name='from_page' id='from_page' value='<%=from_page%>'>
			<input type='hidden' name='from_page1' id='from_page1' value='<%=from_page1%>'>
			<input type='hidden' name='apptrefno' id='apptrefno' value='<%=apptrefno%>'>
			<input type='hidden' name='referral_id' id='referral_id' value='<%=referral_id%>'>
			<input type='hidden' name='allow_referral_yn' id='allow_referral_yn' value='<%=allow_referral_yn%>'>
			<input type='hidden' name='allow_non_referral_yn' id='allow_non_referral_yn' value='<%=allow_non_referral_yn%>'>
			<input type='hidden' name="CallingMode" id="CallingMode" value="<%=vCallMD%>">
			<input type="hidden" name="from_wait_list" id="from_wait_list" value ="<%=from_wait_list%>">
			<input type="hidden" name="waitListNo" id="waitListNo" value ="<%=waitListNo%>" >
			<input type="hidden" name="modify_from_time" id="modify_from_time" value ="<%=fromtime%>" >
			<input type="hidden" name="modify_to_time" id="modify_to_time" value ="<%=totime%>" >
			<input type="hidden" name="or_install_yn" id="or_install_yn" value ="<%=or_install_yn%>" >
			<input type="hidden" name="rd_appt_yn" id="rd_appt_yn" value ="<%=rd_appt_yn%>" >
			 <input type="hidden" name="multi_speciality_yn" id="multi_speciality_yn" value ="<%=multi_speciality_yn%>" > <!-- Added for the CRF - Bru-HIMS-CRF-0198 -->
			<input type="hidden" name="isVirtualCons" id="isVirtualCons" value ="<%=isVIRTUAL_CONSULTATION%>" ><!-- Added by Ajay Hatwate for ML-MMOH-CRF-1930 -->
			<input type="hidden" name="isVCEnbl" id="isVCEnbl" value ="D" ><!-- Added by Ajay Hatwate for ML-MMOH-CRF-1930 -->
			
			<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center' valign='top'><tr><td>

				
	<tr>
	<%
			String apptdate_display=DateUtils.convertDate(apptdate,"DMY","en",locale);
	%>
						<td  class='label' nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/>/<fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
			<!--<td  class='label' nowrap width='20%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>-->
					<td class='fields'  nowrap><b><%=apptdate_display%></b><input type='hidden' name='appt_date' id='appt_date' value="<%=apptdate%>" size='10' maxlength='10'>&nbsp;<input type='text' name='From_timeval' id='From_timeval' value="<%=fromtime%>" size='3' maxlength='5' onBlur='CheckTime(this,"FM")' onKeyUp="javascript:formatTimePerPatient(this)"> - <input type='text' name='To_timeval' id='To_timeval' value="<%=totime%>" size='3' maxlength='5' onBlur='CheckTime(this,"TO")' onKeyUp="javascript:formatTimePerPatient(this)"></td>
					<%if(rule_based_tr.equals("Y") && prefPractYN.equals("N")){%>
						<td class='label' ><fmt:message key="eOA.ReasonForOverride.label" bundle="${oa_labels}"/></td>
						<td class='fields' nowrap width='28%'><input type="text" name="pract_override_reason_desc" id="pract_override_reason_desc" onblur="reasonForOverride(this,pract_override_reason_desc,'<%=locale%>')" size='35' maxlength='30'  ><input type='hidden' name='pract_override_reason' id='pract_override_reason'></input><input type='button' class='button' value='?'  name='search_reason' id='search_reason' onClick="reasonForOverrideLookup(this,pract_override_reason_desc,'<%=locale%>');"><img id = 'reason_mand' src = '../../eCommon/images/mandatory.gif'></td>
					<%}else{%>
						<td class='label' colspan=6>&nbsp;</td>
					<%}%>
			<!--<td  class='fields'  nowrap width='30%'><b><%=care_locn_ind_desc%></b></td>-->
	</tr>
	<tr>
			<td  class='label' nowrap width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td  class='fields'  nowrap ><b><%=care_locn_ind_desc%></b><b>/<%=clinicname%></b>
			<input type='hidden' name='clinic_name' id='clinic_name' value='<%=clinicname%>' size='15' maxlength='4'  >
			</td>

			<td  class='label' nowrap width='25%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			<td  class='fields'  nowrap ><select name = 'sel_service_code' id = 'sel_service_code'><option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
			<%

			stmt_service=conn.createStatement();
			int serviceCount = 0;
			String service_sql="select service_code,short_desc from am_service_lang_vw where language_id='"+locale+"' and eff_status='E' and service_code in(select service_code from op_clinic where clinic_code ='"+cliniccode+"' and facility_id='"+facilityid+"' union SELECT b.service_code FROM OP_CLINIC_FOR_SERVICE b WHERE b.clinic_code ='"+cliniccode+"' AND b.facility_id='"+facilityid+"')";
			rs_service=stmt_service.executeQuery(service_sql);
			while(rs_service!=null && rs_service.next()){
				serviceCount++;
				%>
			<option value="<%=rs_service.getString("service_code")%>"><%=rs_service.getString("short_desc")%></option>
			<%}		 
				%>
				<script>
					if('<%=serviceCount%>' == 1)
					   document.forms[0].sel_service_code.options[1].selected = true;
					</script>
			</select>
			</td>			


	<!--<tr><td class='DEFAULTBLANKROW2PT'  colspan=4>&nbsp;</td></tr>-->
	<tr>
      		
			<td  class='label'  nowrap><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>

			<td class='fields' nowrap><select name='visit_type_short_desc' id='visit_type_short_desc' onChange="updContTabForVC(this);validateFirstVisit(this);setToTime('<%=timetableyn%>','<%=totime%>');" >
			<%
				long orApptTimeMin = 0;
				long difference = 0;
				long maxSlots = 0;
				double addSlotsMod = 0.0;
				// Added by Kamatchi S for NMC-JD-CRF-0104
				if(!or_appt_time.equals("") && isSlotTimeAppl)
				{
				if(or_appt_time.equals("00:00"))
					or_appt_time ="";
				}
			//Below Condition is modified by kamatchi S for NMC-JD-CRF-0104
			if((rd_appt_yn.equals("Y") && follow_visit_type_yn.equals("N") && !or_appt_time.equals("")) || (!or_appt_time.equals("") && isSlotTimeAppl)){
				String sample = "00:00";
				SimpleDateFormat format = new SimpleDateFormat("HH:mm");				
				java.util.Date date1 = format.parse(fromtime);
				java.util.Date date2 = format.parse(totime);	
				java.util.Date date3 = format.parse(or_appt_time);
				java.util.Date date4 = format.parse(sample);			
				 orApptTimeMin = ((date3.getTime() - date4.getTime())/(1000 * 60));
				 difference = ((date2.getTime() - date1.getTime())/(1000 * 60));
				 maxSlots = orApptTimeMin/difference;
				 addSlotsMod = orApptTimeMin%difference;			
				if(addSlotsMod > 0)
					maxSlots = maxSlots + 1;				
			} 
			String max_appt_slots="";
			stmt_visit_type=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			//Added by Kamatchi S for ML-MMOH-CRF-1930 US008
			if(isVIRTUAL_CONSULTATION && res_type.equals("P")){
				if(enable_virtual_cons.equals("E"))
					{
					strbfr_sql1=strbfr_sql1.append("select b.short_desc ,a.visit_type_code,b.visit_type_ind,nvl(a.MAX_APPT_SLOTS,NVL((select MAX_APPT_SLOTS from op_visit_type where facility_id=a.facility_id and visit_type_code=a.visit_type_code),1)) max_appt_slots ,nvl(a.MAX_APPT_DURATION,NVL((select MAX_APPT_DURATION from op_visit_type where facility_id=a.facility_id and visit_type_code=a.visit_type_code),1)) max_appt_dur, b.VIRTUAL_CONSULTATION from op_visit_type_for_clinic a, op_visit_type_lang_vw b where a.facility_id='"+facilityid+"' AND a.facility_id=b.facility_id  AND a.VISIT_TYPE_CODE=b.VISIT_TYPE_CODE   AND b.LANGUAGE_ID='"+locale+"' and a.eff_status='E' and a.clinic_code='"+cliniccode+"' and b.visit_type_ind != 'E' ");	
					}
				if(enable_virtual_cons.equals("D"))
					{
					strbfr_sql1=strbfr_sql1.append("select b.short_desc ,a.visit_type_code,b.visit_type_ind,nvl(a.MAX_APPT_SLOTS,NVL((select MAX_APPT_SLOTS from op_visit_type where facility_id=a.facility_id and visit_type_code=a.visit_type_code),1)) max_appt_slots ,nvl(a.MAX_APPT_DURATION,NVL((select MAX_APPT_DURATION from op_visit_type where facility_id=a.facility_id and visit_type_code=a.visit_type_code),1)) max_appt_dur, b.VIRTUAL_CONSULTATION from op_visit_type_for_clinic a, op_visit_type_lang_vw b where a.facility_id='"+facilityid+"' AND a.facility_id=b.facility_id  AND a.VISIT_TYPE_CODE=b.VISIT_TYPE_CODE   AND b.LANGUAGE_ID='"+locale+"' and a.eff_status='E' and a.clinic_code='"+cliniccode+"' and b.visit_type_ind != 'E' AND b.VIRTUAL_CONSULTATION='D' ");	
					}	
			
			}
			else{
			strbfr_sql1=strbfr_sql1.append("select b.short_desc ,a.visit_type_code,b.visit_type_ind,nvl(a.MAX_APPT_SLOTS,NVL((select MAX_APPT_SLOTS from op_visit_type where facility_id=a.facility_id and visit_type_code=a.visit_type_code),1)) max_appt_slots ,nvl(a.MAX_APPT_DURATION,NVL((select MAX_APPT_DURATION from op_visit_type where facility_id=a.facility_id and visit_type_code=a.visit_type_code),1)) max_appt_dur,b.VIRTUAL_CONSULTATION from op_visit_type_for_clinic a, op_visit_type_lang_vw b where a.facility_id='"+facilityid+"' AND a.facility_id=b.facility_id  AND a.VISIT_TYPE_CODE=b.VISIT_TYPE_CODE   AND b.LANGUAGE_ID='"+locale+"' and a.eff_status='E' and a.clinic_code='"+cliniccode+"' and b.visit_type_ind != 'E' ");
			}
			if(rd_appt_yn.equals("Y")){
				strbfr_sql1.append( " and b.rd_appl_yn = 'Y'");
			}else{
			if(Forced.equals("N")){
				if(visit_flag.equals("")){
					if(visit_flag_OP.equals("N") || visit_flag_OP.equals("")){
						if(!obvisit_flag.equals("")&&!obvisit_flag.equals("A")){
							if(obvisit_flag.equals("F")){
								strbfr_sql1.append(" and b.visit_type_ind = 'F'");
							}else if(obvisit_flag.equals("O")){
								strbfr_sql1.append( " and b.visit_type_ind != 'F'");
							}
						}
					}else{
						if(!vCallMD.equals("RSCAPPT"))
							strbfr_sql1.append( " and b.visit_type_ind != 'F'");
					}
				}else{
					if(visit_flag_OP.equals("N") || visit_flag_OP.equals("")){
						if(visit_flag.equals("F")){
							strbfr_sql1.append(" and b.visit_type_ind = 'F'");
						}else if(visit_flag.equals("O")){
							strbfr_sql1.append(" and b.visit_type_ind != 'F'");
						}
					 }else{
						 strbfr_sql1.append(" and b.visit_type_ind != 'F'");
					}
				}
			}
			}
			if(!from_page.equals("")){
				if(!visit_type_ind.equals("")){
					strbfr_sql1.append(" and a.visit_type_code = '"+visit_type_ind+"'");	
				}
			}
			strbfr_sql1.append(" order by b.short_desc");
			if(from_page.equals("modifyappt")){
				strbfr_sql1.setLength(0);
				strbfr_sql1.append("SELECT short_desc, a.visit_type_code, a.visit_type_ind,NVL (b.max_appt_slots, 1) max_appt_slots,NVL (b.max_appt_duration, 1) max_appt_dur FROM op_visit_type_lang_vw a, op_visit_type_for_clinic b WHERE a.visit_type_code = '"+visit_type_ind+"' AND a.visit_type_code = b.visit_type_code AND a.facility_id = b.facility_id AND a.facility_id = '"+facilityid+"' AND b.clinic_code = '"+cliniccode+"' AND a.language_id = '"+locale+"'");
			}
			rs1=stmt_visit_type.executeQuery(strbfr_sql1.toString());
			rs1.last();
			visit_type_cnt = rs1.getRow();
			rs1.beforeFirst();
			strbfr_sql1.setLength(0)	;
			
			if(visit_type_cnt > 1)
			{%>
			<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
			<%
			}
			while(rs1!=null && rs1.next()){
			visitcode=rs1.getString("visit_type_code");
			visitdesc=rs1.getString("short_desc");
			visitind=rs1.getString("visit_type_ind");
			 max_appt_slots=rs1.getString("max_appt_slots");
			
			if (max_appt_slots==null) max_appt_slots="";
			int max_dur = rs1.getInt("max_appt_dur");
			if(visit_type_cnt<1)
			{%>
			<option value='<%=visitcode%>~<%=visitind%>' selected><%=visitdesc%>
			
				<script language="JavaScript">
				vis_code_Array[<%=visit_ind_count%>]		= '<%=visitcode+"~"+visitind%>';	
				max_dur_Array[<%=visit_ind_count%>]			= '<%=max_dur%>';
				max_appt_slots_Array[<%=visit_ind_count%>]  = '<%=max_appt_slots%>';
				</script>
			<%}else {
			%>
			<option value='<%=visitcode%>~<%=visitind%>'><%=visitdesc%>
			
				<script language="JavaScript">
				vis_code_Array[<%=visit_ind_count%>]		= '<%=visitcode+"~"+visitind%>';	
				max_dur_Array[<%=visit_ind_count%>]			= '<%=max_dur%>';
				max_appt_slots_Array[<%=visit_ind_count%>]  = '<%=max_appt_slots%>';
				</script>




			<%}
			visit_ind_count++;
			}
			if(rs1 !=null)rs1.close();
				%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			<%if (timetableyn.equals("1")&& overbookedyn.equals("N")&& Forced.equals("N") ) {%>
				<input type="hidden" name="tmpCntrl" id="tmpCntrl">
				<select name='no_slots' id='no_slots' onchange ='return val_multi_slot(this)' >
					<%
			//Condition Modified by kamatchi S for NMC-JD-CRF-0104
			if((rd_appt_yn.equals("Y") && follow_visit_type_yn.equals("N") && !or_appt_time.equals("")) || (!or_appt_time.equals("") && isSlotTimeAppl)){
				max_appt_slots = Long.toString(maxSlots) ;
			}
				//Modified by kamatchi S for NMC-JD-CRF-0104
				if(visit_type_cnt<=1 || (!or_appt_time.equals("") && isSlotTimeAppl))
				{
				
				if(Integer.parseInt(max_appt_slots) >1)
				
				{
				
				%>
				<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
				<%
					int default_slot=Integer.parseInt(max_appt_slots); //Line Modified for CRF Bru-HIMS-CRF-279 [IN:033084]
					if(follow_visit_type_yn.equals("N")){
						default_slot=Integer.parseInt(max_appt_slots);
					}
				for(int m=1;m<=Integer.parseInt(max_appt_slots);m++){
					if(m==default_slot)
					{
					
					%>
						<option value='<%=m%>' selected><%=m%>
					<%}else
					{%>
					<option value='<%=m%>' ><%=m%>
				<%	}
				 }
				}else
				{%>
					<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> 
					<option value='<%=max_appt_slots%>' selected><%=max_appt_slots%>
				<%}
			 }else {%>
			<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
			<%}
			%>
			
			
		</select></td>
			<%}else{%>
				<input type='hidden' name='no_slots' id='no_slots' value="0" size='10' maxlength='10'></td>
			<%}		
			
		
		%>
			
					<!--<td  class='label' nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/>/<fmt:message key="Common.time.label" bundle="${common_labels}"/></td>


					<td class='fields'  nowrap><b><%=apptdate_display%></b><input type='hidden' name='appt_date' id='appt_date' value="<%=apptdate%>" size='10' maxlength='10'>&nbsp;<input type='text' name='From_timeval' id='From_timeval' value="<%=fromtime%>" size='3' maxlength='5' onBlur='CheckTime(this,"FM")' > - <input type='text' name='To_timeval' id='To_timeval' value="<%=totime%>" size='3' maxlength='5' onBlur='CheckTime(this,"TO")'></td>-->

			<td  class='label'nowrap ><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>

			<!--<td class='fields' nowrap><b><%=res_class_desc%></b></td>
			<td  class='label'nowrap ><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>-->
			<td class='fields' nowrap><b><%=res_class_desc%>/</b><b><%=practname%></b>
				<input type='hidden' name='pame' id='pame' value='<%=practname%>' size='15' maxlength='15'  > 
				<input type='hidden' name='practitioner_name' id='practitioner_name' value='<%=practname%>' size='15' maxlength='15'  > 
			</td>
	</tr>
	<!--<tr><td class='DEFAULTBLANKROW2PT'  colspan=4>&nbsp;</td></tr>-->
	<tr>
				<td  class="label" nowrap><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></td>

				<%if(create_wait_list_yn.equals("N")) {%>
					<td class="fields" nowrap ><input disabled type="text"  name="pref_date" id="pref_date" maxlength="10" size="10"   value='' onblur="validateDateTime1(this);prioritychk(this);" onclick="prioritychk(this);" ><img name="dob1" id="dob1" src="../../eCommon/images/CommonCalendar.gif" onclick="if (!document.getElementById('pref_date').disabled) { document.forms[0].pref_date.focus(); return showCalendar('pref_date'); }">
						
					<td  class="label" nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
						
					<td class="fields" nowrap colspan=1><select name = 'priorty' disabled><option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
					<option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
					<option value="S"><fmt:message key="Common.semiurgent.label" bundle="${common_labels}"/></option>
					<option value="N"><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option></select><img id='prior' src='../../eCommon/images/mandatory.gif' align='center'></img>
						
					<% if(overbookedyn.equals("Y")) {%>
					<b><fmt:message key="eOA.overbooking.label" bundle="${oa_labels}"/></b>
					<%}%>
						
					</td>


					<%}else {%>
						<td class="fields" nowrap ><input type="text"  name="pref_date" id="pref_date" maxlength="10" size="10"   value='' onblur="validateDateTime1(this);prioritychk(this);" onclick="prioritychk(this);" ><img name="dob1" id="dob1" src="../../eCommon/images/CommonCalendar.gif" onclick="if (!document.getElementById('pref_date').disabled) { document.forms[0].pref_date.focus(); return showCalendar('pref_date'); }"></td>
							
						
						<td class="label" nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>							 
					<td  class="fields" nowrap colspan=1><select name = 'priorty'><option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
					<option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
					<option value="S"><fmt:message key="Common.semiurgent.label" bundle="${common_labels}"/></option>
					<option value="N"><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option></select><img id='prior' src='../../eCommon/images/mandatory.gif' align='center'></img>
						
					<% if(overbookedyn.equals("Y")) {%>
					<b><fmt:message key="eOA.overbooking.label" bundle="${oa_labels}"/></b>
					<%}%>
						 </td>
					<%}%>
					</tr>
				<%
					String fromOrdPract = "";
					String fromOrdPractName = "";
					if(!or_catalogue_code.equals("")){
						if(res_type.equals("P")){
								fromOrdPract = practid;
								fromOrdPractName = practname;
							}else{
								fromOrdPract = "";
								fromOrdPractName = "";
							}		
					
						if(!order_id.equals("")){								
							String ordPractSql="select ord_pract_id,am_get_desc.am_practitioner(ord_pract_id,'"+localeName+"','1') practName from or_order where order_id = '"+order_id+"'";
							if(rs1!=null)rs1.close();
							rs1=stmt.executeQuery(ordPractSql);
							if(rs1!=null && rs1.next()){
								fromOrdPract=rs1.getString("ord_pract_id")==null?"":rs1.getString("ord_pract_id");
								fromOrdPractName=rs1.getString("practName")==null?"":rs1.getString("practName");										
							}
					    }
				%>
					<tr>
					 <td class='LABEL'> <fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/></td>
					 <td class='fields'><input type='text' name='ordPractDesc' id='ordPractDesc' value = '<%=fromOrdPractName%>' size=30' maxlength='30' onBlur="getValues(pract_button,this,ordPractId)"><input type='hidden' name='ordPractId' id='ordPractId' value='<%=fromOrdPract%>'><input type='button' class='button' readOnly name='pract_button' id='pract_button' value='?' onClick="getValues(this,ordPractDesc,ordPractId)";><img src='../../eCommon/images/mandatory.gif' align='center'></td>	
					</tr>
					<%}%>
			<input type='hidden' name='Forced' id='Forced' value='<%=Forced%>'>
			<input type='hidden' name='first_visit_flag' id='first_visit_flag' value='N'> 
			<input type='hidden' name='other_visit_flag' id='other_visit_flag' value='N'> 
			<input type='hidden' name='only_fv_allowed_flag' id='only_fv_allowed_flag' value='<%=only_fv_allowed_flag%>'> 
			<input type='hidden' name='slot_appt_ctrl' id='slot_appt_ctrl' value='<%=slot_appt_ctrl%>'>
			<input type='hidden' name='visit_limit_rule' id='visit_limit_rule' value='<%=visit_limit_rule%>'> 
			<input type='hidden' name='alcn_criteria' id='alcn_criteria' value='<%=alcn_criteria%>'>
			<input type='hidden' name='override_no_of_slots' id='override_no_of_slots' value='<%=override_no_of_slots%>'>
			<input type='hidden' name='capture_fin_dtls_yn' id='capture_fin_dtls_yn' value='<%=capture_fin_dtls_yn%>'>
			<input type='hidden' name='min_ela_per_resc_noshow_in_day' id='min_ela_per_resc_noshow_in_day' value='<%=min_ela_per_resc_noshow_in_day%>'>
			<input type='hidden' name='noshow_ctrl_by_splty_or_clinic' id='noshow_ctrl_by_splty_or_clinic' value='<%=noshow_ctrl_by_splty_or_clinic%>'>
			<input type="hidden" name='contact_num_reqd_yn' id='contact_num_reqd_yn' value='<%=contact_num_reqd_yn%>'>
			<input type="hidden" name='per_chk_for_no_show_alert' id='per_chk_for_no_show_alert' value='<%=per_chk_for_no_show_alert%>'>
			<input type="hidden" name='no_of_noshow_appts_for_alert' id='no_of_noshow_appts_for_alert' value='<%=no_of_noshow_appts_for_alert%>'>
			<input type="hidden" name='email_appl_yn' id='email_appl_yn' value='<%=email_appl_yn%>'>
			<input type="hidden" name='email_appl_for_appt_wo_pid_yn' id='email_appl_for_appt_wo_pid_yn' value='<%=email_appl_for_appt_wo_pid_yn%>'>
			<input type="hidden" name='pat_email_appl_yn' id='pat_email_appl_yn' value='<%=pat_email_appl_yn%>'>
			<input type='hidden' name='totime_value' id='totime_value' value='<%=totime%>'>
			<input type="hidden" name="res_class" id="res_class" value="<%=res_type%>">
			<input type="hidden" name="res_type" id="res_type" value="<%=Resource_type%>">
			<input type="hidden" name='SecResCheck' id='SecResCheck' value=''>
			<input type="hidden" name="pre_admit_order_catalog_code" id="pre_admit_order_catalog_code" value ="" >
			<input type="hidden" name="pre_admit_days" id="pre_admit_days" value ="" >
			<input type="hidden" name="or_order_date" id="or_order_date" value ="" >
			<input type='hidden' name='recurringDTTM' id='recurringDTTM' value='' >
			<input type='hidden' name='clinic_securityLevel' id='clinic_securityLevel' value="">
			<input type='hidden' name='patient_SecurityLevel' id='patient_SecurityLevel' value="">
			<input type="hidden" name='from_clear' id='from_clear' value=''>
			<input type='hidden' name='SecurityLevel' id='SecurityLevel' value="">
			<input type='hidden' name='text5' id='text5' value=''>
			<input type='hidden' name='text6' id='text6' value=''>
			<input type="hidden" name="sec_sel222" id="sec_sel222" value="">
			<input type='hidden' name='function' id='function' value='insert'>
			<input type='hidden' name='function_name' id='function_name' value='insert'>
			<input type='hidden' name='appt_ref_no' id='appt_ref_no' value=''>
			<input type='hidden' name='ref_priority' id='ref_priority' value=''>
			<input type='hidden' name='inpatient_yn' id='inpatient_yn' value='N'> 
			<input type='hidden' name='maxRecord1' id='maxRecord1' value=''> 
			<input type='hidden' name='last_encounter_id' id='last_encounter_id' value=''>
			<input type='hidden' name='last_service_encounter_id' id='last_service_encounter_id' value=''>
			<input type="hidden" name="sec_req" id="sec_req" value="">
			<input type="hidden" name="sec_sel" id="sec_sel" value="">
			<input type="hidden" name="sec_sel222_final" id="sec_sel222_final" value="">
			<input type="hidden" name="book_apt_acr_cat_yn" id="book_apt_acr_cat_yn" value="N">	
			<input type="hidden" name="chk_for_oth_appt" id="chk_for_oth_appt" value="">
			<input type="hidden" name="recurring_cur_select" id="recurring_cur_select" value="">
			<input type="hidden" name='recur_wo_sec_res' id='recur_wo_sec_res' value=''>
			<input type='Hidden' name='globalFlag' id='globalFlag' value=''>
			<input type='Hidden' name='order_wtlt_code' id='order_wtlt_code' value=''>
			<input type='hidden' name='no_show_date' id='no_show_date' value=''>
			<input type="hidden" name="recurringdays" id="recurringdays" value="">
			<input type="hidden" name='pat_category' id='pat_category' value=''>
			<input type='hidden' name='episode_type' id='episode_type' value=''>
			<input type='hidden' name='Function_id' id='Function_id' value=''>
			<input type='hidden' name='bl_future_admn_YN' id='bl_future_admn_YN' value=''>
			<input type='hidden' name='bl_operation' id='bl_operation' value=''>
			<input type='hidden' name='billing_mode' id='billing_mode' value='Add'>
			<input type='hidden' name='pkg_bill_type' id='pkg_bill_type' value=''>
			<input type='hidden' name='pkg_bill_no' id='pkg_bill_no' value=''>
			<input type='hidden' name='bl_success' id='bl_success' value='N'>
			<input type='hidden' name='package_flag' id='package_flag' value='N'>
			<input type='hidden' name='billing_group' id='billing_group' value=''>
			<input type='hidden' name='gen' id='gen' value=''>
			<input type='hidden' name='nationality_code' id='nationality_code' value=''>
			<input type='hidden' name='Global' id='Global' value='<%=Global%>'>
			<input type='hidden' name='facilityid' id='facilityid' value='<%=facilityid%>'>
			<input type='hidden' name='rule_appl_yn' id='rule_appl_yn' value='<%=rule_appl_yn%>'>
			<input type='hidden' name='rule_based_tr' id='rule_based_tr' value='<%=rule_based_tr%>'>
			<input type='hidden' name='patient_id_temp' id='patient_id_temp' value='<%=patient_id_temp%>'>
			<input type='hidden' name='name_prefix_temp' id='name_prefix_temp' value="<%=name_prefix_temp%>">
			<input type='hidden' name='first_name_temp' id='first_name_temp' value='<%=first_name_temp%>'>
			<input type='hidden' name='second_name_temp' id='second_name_temp' value='<%=second_name_temp%>'>
			<input type='hidden' name='third_name_temp' id='third_name_temp' value='<%=third_name_temp%>'>
			<input type='hidden' name='family_name_temp' id='family_name_temp' value='<%=family_name_temp%>'>
			<input type='hidden' name='name_suffix_temp' id='name_suffix_temp' value="<%=name_suffix_temp%>">
			<input type='hidden' name='name_prefix_oth_lang_temp' id='name_prefix_oth_lang_temp' value="<%=name_prefix_oth_lang_temp%>">
			<input type='hidden' name='first_name_oth_lang_temp' id='first_name_oth_lang_temp' value='<%=first_name_oth_lang_temp%>'>
			<input type='hidden' name='second_name_oth_lang_temp' id='second_name_oth_lang_temp' value='<%=second_name_oth_lang_temp%>'>
			<input type='hidden' name='third_name_oth_lang_temp' id='third_name_oth_lang_temp' value='<%=third_name_oth_lang_temp%>'>
			<input type='hidden' name='family_name_oth_lang_temp' id='family_name_oth_lang_temp' value='<%=family_name_oth_lang_temp%>'>
			<input type='hidden' name='name_suffix_oth_lang_temp' id='name_suffix_oth_lang_temp' value="<%=name_suffix_oth_lang_temp%>">
			<input type='hidden' name='gender_temp' id='gender_temp' value='<%=gender_temp%>'>
			<input type='hidden' name='contact_no_temp' id='contact_no_temp' value='<%=contact_no_temp%>'>
			<input type="hidden" name="mob_num_req_yn" id="mob_num_req_yn" value ="<%=mob_num_req_yn%>" >
			<input type="hidden" name="nationality_code_temp" id="nationality_code_temp" value ="<%=nationality_code_temp%>" >
			<input type="hidden" name="nat_desc_temp" id="nat_desc_temp" value ="<%=nat_desc_temp%>" >
			<input type="hidden" name="canldapptrefno" id="canldapptrefno" value ="<%=canldapptrefno%>" >
			<input type="hidden" name="tempLangugaeID" id="tempLangugaeID" value ="<%=tempLangugaeID%>" >
			<input type="hidden" name="isSlotTimeAppl" id="isSlotTimeAppl" value ="<%=isSlotTimeAppl%>" ><!--Added by Kamatchi S for NMC-JD-CRF-0104-->
			<input type="hidden" name="or_appt_time" id="or_appt_time" value ="<%=or_appt_time%>" ><!--Added by Kamatchi S for NMC-JD-CRF-0104-->

	</table>


    			<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>

		
         <tr>

		 <td class=SECONDSELECTED id='patientDet'  width='18%' align=center style='cursor:pointer;' nowrap onclick="javascript:dynFrameSize();callOnMouseClick1(this);patientDetClick();prioritychk(document.forms[0].pref_date)"><font color='black'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></font></td>


		 <td class=FIRSTNORMAL id='SecResource'  width='20%' align=center style='cursor:pointer;' nowrap onclick="callOnMouseClick(this);show_second1();prioritychk(document.forms[0].pref_date);" disabled><font color='black'><fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/></font></td>

		<%if(bl_operational.equals("Y") && capture_fin_dtls_yn.equals("Y")) {%>
		<td class=FIRSTNORMAL id='financial_dtl'  width='20%' align=center style='cursor:pointer;' nowrap onclick="callOnMouseClick2(this);call_billing_func();prioritychk(document.forms[0].pref_date);" ><font color='black'><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></font></td>
		<td colspan='1'  width='50%'>&nbsp;</td>
		<%}else {%>
		 <td colspan='2'  width='50%'>&nbsp;</td>
		 <%}%>
		 </tr>
	</table>

			
	  
    			<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
				
				<td class='COLUMNHEADER' colspan='4'><fmt:message key="Common.referral.label" bundle="${common_labels}"/></td>
				
				<tr>
				    <td class='label' nowrap width='20%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>


					<td   class='fields' colspan='2'><input type='text' name='source' id='source' value="<%=referral_id%>" size="14" maxlength="14" <%=readonlyReferralID%>  onblur = "if (document.forms[0].source.readOnly==false) 		{ChangeUpperCase(this);validpatient_refral(this,'nonmodel')}" ><input type='button' name='search1' id='search1' value='?'  class="BUTTON" onClick='OpenModel_refral()'  id='ref_ser_but' <%=enableReferralID%> >
					</td>

					<td>&nbsp;</td>
			</tr>



			</table>
 <div id='patDet' style='visibility:visible'>

	<table border='1' cellpadding='2' cellspacing='0' width='100%' align='center' >
	
			<td class='COLUMNHEADER' colspan='4'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
		
		 <tr>
			<td colspan='4' >	
                  			
				<jsp:include page="../../eMP/jsp/natAltIDComponent.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name ="patient_id" value= "" /> 				
				<jsp:param name ="bodyFrame" value= "parent.f_query_add_mod"  /> 	
				<jsp:param name ="submitFrame" value= "parent.messageFrame"  />		
				<jsp:param name ="op_call" value= "OA"  /> 					
				</jsp:include>	
		 <tr>

			<td  id='blink_text' nowrap>
			<font id='othApp'></font>
			</td>

			</tr>
	</table>
</div>

	<table border='0' cellpadding='2' cellspacing='0' width='100%' >
		
	
		<td class='COLUMNHEADER' colspan='4'><fmt:message key="Common.others.label" bundle="${common_labels}"/></td>

				
								
				


				<tr>
					<td class='label' width='18%'><fmt:message key="Common.ReasonForContact.label" bundle="${common_labels}"/>
</td>
					<td class='fields' nowrap width='28%'><input type="text" name="reason" id="reason" onblur="onblurcheck(this,reason,'<%=locale%>')" size='35' maxlength='30'  ><input type=hidden name='reason_for_contact' id='reason_for_contact'  size='30' maxlength='30' ></input><input type='button' class='button' value='?'  name='search_reason' id='search_reason' onClick="callReasonSearch(this,reason,'<%=locale%>');"  >
					<img id = 'reason_mand' src = '../../eCommon/images/mandatory.gif'>
					</td>	

					<td  class='label' width='23%' ><fmt:message key="Common.ReceivingDateTime.label" bundle="${common_labels}"/></td>
						
					<td class='fields' width='23%'><input type="text"  name="rec_date" id="rec_date" maxlength="16" size="13"   value='' onblur="validateDateTime(this)"><img  style="cursor:pointer" name= "dob1" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].rec_date.select();return showCalendar('rec_date',null,'hh:mm');" >						
							<input type="hidden" name="hddDTTM" id="hddDTTM" value="<%=dttm%>">
							<input type="hidden" name="hddDate" id="hddDate" value="">
							<input type="hidden" name="hddBDate" id="hddBDate" value="">
					</td>

				</tr>


				<tr>
                  <td  class='label'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
				
				  <td  class='fields'>
						<!--Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058 Start-->
						<% if(isIncRemarksLengthAppl){ %>
							<textarea name='remarks' rows="3" cols="80" maxlength="1000" onkeyup='return imposeMaxLength(this);' onblur='makeValidString(this);'></textarea>
						<% }else{ %><!--End-->
							<input type='text' name='remarks' id='remarks' value="" size='40' maxlength='60' onblur='makeValidString(this);' >
						<% } %> 
				  </td>

				  <td  class='label'  ><fmt:message key="Common.mode.label" bundle="${common_labels}"/></td>
					  
				   <td  class='fields'><select name='mode' id='mode' >
							<option value='E'><fmt:message key="Common.email.label" bundle="${common_labels}"/>
							<option value='T'><fmt:message key="Common.telephone.label" bundle="${common_labels}"/>
							<option value='F'><fmt:message key="Common.fax.label" bundle="${common_labels}"/>
							<option value='I' selected><fmt:message key="Common.InPerson.label" bundle="${common_labels}"/>
							<option value='W'><fmt:message key="Common.Web.label" bundle="${common_labels}"/>
							<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/>
							</select>

					</td>
				</tr>
				<%if(rule_appl_yn.equals("Y")){%>
				<tr>
					<td class="label"  nowrap><fmt:message key="Common.Language.label" bundle="${common_labels}"/></td>
					<td class='fields' ><input type='text' name='language_desc' id='language_desc' size='20' maxlength='20'  onblur='patientLanguage(this)'value="<%=lang_desc_temp%>"><input type='button' name='language_button' id='language_button' value='?' class='button' onclick='patientLanguageLookup(this);'><%if(language_req_yn.equals("Y")){%><img id = 'lang_mand' src = '../../eCommon/images/mandatory.gif'><%}%><input type='hidden' name='language_id' id='language_id' value="<%=language_code_temp%>"></td>
					<td class='label' colspan='2'>&nbsp;</td>
				</tr>
				<%}%>
				<%if(clinicInsYN.equals("Y") || orderInsYN.equals("Y")){%>
				<tr>
                  <td  class='label'><a href='javascript:PatInsModalWindow()'>Patient Instructions</a></td>	
				  <td  colspan=3></td>				  
				</tr>
				<%}%>
			</table>
	<input type='hidden' name="hddPat_id_new" id="hddPat_id_new" value="<%=patientid%>">

	<%	


	String vPat_id="";
	vPat_id=(String) session.getValue("Pat_id");
	if(vPat_id==null) vPat_id="";

	if(vPat_id.equals("N")){
		patientid=patientid;
	}else{
		patientid=vPat_id;
	}
				String ca_patient_id_new="";
				
		if(from_page.equals("")) {
				ca_patient_id_new=(String)(session.getValue("ca_patient_id_new")==null?"":session.getValue("ca_patient_id_new"));
				if(ca_patient_id_new.equals(null) ||ca_patient_id_new ==null) ca_patient_id_new="";			
	    }


	%>

	<input type='hidden' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value='<%=pat_name_as_multipart_yn%>'>

	<input type='hidden' name='practname' id='practname' value='<%=practname%>'>	
	<input type='hidden' name='pract_id' id='pract_id' value='<%=practid%>'>
	<input type='hidden' name='clinic_id' id='clinic_id' value='<%=cliniccode%>'>
	<input type='hidden' name='book_appt_wo_pid_yn' id='book_appt_wo_pid_yn' value='<%=book_appt_wo_pid_yn%>'>
	<input type='hidden' name='book_appt_across_catg_yn' id='book_appt_across_catg_yn' value='<%=book_appt_across_catg_yn%>'>
	<input type='hidden' name='speciality_code' id='speciality_code' value='<%=spec_code%>'>
	<input type='hidden' name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn' value='<%=ENTITLEMENT_BY_PAT_CAT_YN%>'>
	<input type="hidden" name="dtl_msg_yn" id="dtl_msg_yn" value="<%=dtl_msg_yn%>">
	<input type='hidden' name='service_code' id='service_code' value='<%=service_code%>'>
	<input type='hidden' name='obvisit_flag' id='obvisit_flag' value='<%=obvisit_flag%>'>
	<input type='hidden' name='break_flag' id='break_flag' value='<%=break_flag%>'> 
	<input type='hidden' name='ip_bkgs' id='ip_bkgs' value='<%=ip_bkgs%>'> 

	<input type='hidden' name="hddPat_id" id="hddPat_id" value="<%=patientid%>">
	<input type='hidden' name='ca_patient_id_new' id='ca_patient_id_new' value="<%=ca_patient_id_new%>">

	<input type="hidden" name="clinic_type" id="clinic_type" value="<%=clinic_type%>">
	<input type="hidden" name="age_group_code" id="age_group_code" value="<%=age_group_code%>">


	<input type='hidden' name='req_id' id='req_id' value='<%=req_id%>'> 
	
	<input type='hidden' name='bl_operational' id='bl_operational' value='<%=bl_operational%>'>




	    <input type='hidden' name='visit_type_ind' id='visit_type_ind' value='<%=visit_type_ind%>'>
	




	<input type='hidden' name="CallingMode1" id="CallingMode1" value="<%=ca_mode%>">
	<input type='hidden' name="patientid_CA" id="patientid_CA" value="<%=patientid_CA%>">
	<input type='hidden' name="CallingMode_CA" id="CallingMode_CA" value="<%=vCallMD1%>">
	<input type='hidden' name="sys_date" id="sys_date">
	<%String ref_id="";
		ref_id=(String) session.getValue("ref_id");
	if(ref_id==null) ref_id="N";%>
	<input type='hidden' name='hdd_referal' id='hdd_referal' value='<%=ref_id%>'>
	<input type='hidden' name='ServerTime' id='ServerTime' value='<%=str14%>' >
	<input type="hidden" name="Serverdate" id="Serverdate" value="<%=dttm%>">


	<input type='hidden' name='block_break_appt' id='block_break_appt' value="<%=block_break_appt%>">

	<input type="hidden" name="or_catalogue_code" id="or_catalogue_code" value ="<%=or_catalogue_code%>" >
	<input type="hidden" name="order_catalog_criteria" id="order_catalog_criteria" value ="<%=or_catalogue_code%>" >
	<input type='hidden' name='CurrentDate' id='CurrentDate' value='<%=currentDate%>'>
	<input type='hidden' name='ip_installed_yn' id='ip_installed_yn' value='<%=ip_installed_yn%>'>
	<input type='hidden' name='rad_installed_yn' id='rad_installed_yn' value='<%=rad_installed_yn%>'>
	<input type='hidden' name='sys_date_time' id='sys_date_time' value='<%=sys_date_time%>'>
	<input type='hidden' name='visit_type_cnt' id='visit_type_cnt' value='<%=visit_type_cnt%>'>
<input type="hidden" name='from_facility_id' id='from_facility_id' value='<%=from_facility_id%>'>
<input type="hidden" name='from_encounter_id' id='from_encounter_id' value='<%=from_encounter_id%>'>
<input type="hidden" name='wait_list_num' id='wait_list_num' value='<%=wait_list_num%>'>
<input type="hidden" name='send_email_yn' id='send_email_yn' value='<%=send_email_yn%>'>
<input type="hidden" name='clinicInsYN' id='clinicInsYN' value='<%=clinicInsYN%>'>
<input type="hidden" name='orderInsYN' id='orderInsYN' value='<%=orderInsYN%>'>
<input type="hidden" name='orderInsStandardYN' id='orderInsStandardYN' value='<%=orderInsStandardYN%>'>
<input type="hidden" name='patInsSelectYN' id='patInsSelectYN' value='N'>
<input type="hidden" name='procInsSelectYN' id='procInsSelectYN' value='N'>
<input type="hidden" name='referral_id_old' id='referral_id_old' value='<%=referral_id%>'>
<input type="hidden" name='entered' id='entered' value='N'>
<input type="hidden" name='customer_id' id='customer_id' value='<%=customer_id%>'>
<input type="hidden" name='term_set_id' id='term_set_id' value='<%=term_set_id%>'>
<input type="hidden" name='linking_code' id='linking_code' value='<%=linking_code%>'>
<input type="hidden" name='wtListControl' id='wtListControl' value='<%=wtListControl%>'>
<input type="hidden" name='slotsFromOrder' id='slotsFromOrder' value='<%=Long.toString(maxSlots)%>'>


<input type="hidden" name='follow_visit_type_yn' id='follow_visit_type_yn' value='<%=follow_visit_type_yn%>'>
<input type="hidden" name='visit_ind_count' id='visit_ind_count' value='<%=visit_ind_count%>'>
<input type="hidden" name='patCnclCount' id='patCnclCount' value='N'><!--Bru-HIMS CRF 169 changes -->
<input type="hidden" name='MaxcancelAlert' id='MaxcancelAlert' value='<%=MaxcancelAlert%>'><!--Fix for regression issue on Bru-HIMS CRF 169  -->
<input type="hidden" name='trans_exceed_reason_code' id='trans_exceed_reason_code' value=''>
<!--Below line added by senthil -->
<input type="hidden" name="max_slot_default_yn" id="max_slot_default_yn" value="<%=max_slot_default_yn%>">
<input type="hidden" name="upt_contact_dtls_mp_yn" id="upt_contact_dtls_mp_yn" value="<%=upt_contact_dtls_mp_yn%>"><!--added changes for HSA-CRF-0226 [IN:050599]-->
<input type="hidden" name="upd_pat_dtls_referral_yn" id="upd_pat_dtls_referral_yn" value="<%=upd_pat_dtls_referral_yn%>"><!--Added by Dharma  on Apr 13th 2016 against HSA-CRF-0303 [IN:054572]-->
<input type="hidden" name="isIncRemarksLengthAppl" id="isIncRemarksLengthAppl" value="<%=isIncRemarksLengthAppl%>">

	</script>
	<script>

		if(document.forms[0].from_wait_list.value=="Y")
		{
			
			
			document.forms[0].pref_date.disabled=true;
			document.forms[0].search1.disabled=true;
			document.forms[0].source.disabled=true;
			document.forms[0].priorty.disabled=true;
			document.getElementById('dob1').disabled=true;
			parent.frames[2].document.getElementById('ffgh').disabled=true;
			

			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()

			xmlStr ="<root><SEARCH wait_list_val=\""+document.forms[0].from_wait_list.value+"\" wait_list_num=\""+document.forms[0].waitListNo.value+"\" clinic_id=\""+document.forms[0].clinic_id.value+"\" prm_res_class=\""+document.getElementById('res_class').value+"\" alcn_criteria_pop=\""+document.getElementById('alcn_criteria').value+"\"  calledFor='WaitList'/></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../../eOA/jsp/BookAppointmentReferral.jsp",false)
					xmlHttp.send(xmlDoc)
					responseText=xmlHttp.responseText
					responseText = trimString(responseText)
					eval(responseText)

			if(document.getElementById('patient_id').value!=''){

					var HTMLVal = new String();
					parent.document.frames[0].document.forms[0].nationality_code1.disabled=false;


					var u=parent.document.frames[0].document.forms[0].visit_type_short_desc.value;
					if(u!=''){
						strVisitArray = u.split("~");
						var u1=strVisitArray[0];
						var u2=strVisitArray[1];
					}else{
						u2='';
					}
					
					/*
					var xmlDoc = ""
					var xmlHttp = new XMLHttpRequest()
					xmlStr ="<root><SEARCH step='P' pat_id=\""+document.getElementById('patient_id').value+"\" alcn_criteria_pop=\""+document.getElementById('alcn_criteria').value+"\" service_code=\""+document.getElementById('service_code').value+"\" clinic_code=\""+document.getElementById('clinic_code').value+"\" ip_installed_yn=\""+document.getElementById('ip_installed_yn').value+"\"					rad_installed_yn=\""+document.getElementById('rad_installed_yn').value+"\"					visit_type_cd=\""+u2+"\"age_group_code=\""+document.getElementById("age_group_code").value+"\"	/></root>"
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
					xmlHttp.open("POST","../../eOA/jsp/BookAppointmentValidations.jsp",false)
					xmlHttp.send(xmlDoc)
					responseText=xmlHttp.responseText
					responseText = trimString(responseText)
					eval(responseText) */

				/*	var HTML="<html><body><form name='bkapptval' id='bkapptval' method='post'  action='../../eOA/jsp/BookAppointmentValidations.jsp'><input type=hidden name='step' id='step' value='P'><input type=hidden name='alcn_criteria_pop' id='alcn_criteria_pop' value='"+document.getElementById('alcn_criteria').value+"'><input type=hidden name='service_code' id='service_code' value='"+document.getElementById('service_code').value+"'><input type=hidden name='clinic_code' id='clinic_code' value='"+document.getElementById('clinic_code').value+"'><input type=hidden name='ip_installed_yn' id='ip_installed_yn' value='"+document.getElementById('ip_installed_yn').value+"'><input type=hidden name='rad_installed_yn' id='rad_installed_yn' value='"+document.getElementById('rad_installed_yn').value+"'><input type=hidden name='visit_type_cd' id='visit_type_cd' value='"+u2+"'><input type=hidden name='age_group_code' id='age_group_code' value='"+document.getElementById("age_group_code").value+"'></form></body></html>";

					parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
					parent.messageFrame.document.bkapptval.submit();*/
				}
				
		}
	</script>

		<script>
		if(document.forms[0].CallingMode.value=='MR')
		{
			var req_id=document.forms[0].req_id.value;
		
				document.forms[0].pref_date.disabled=true;
				document.forms[0].search1.disabled=true;
				document.forms[0].source.disabled=true;
				document.forms[0].priorty.disabled=true;
				document.getElementById('dob1').disabled=true;
				parent.frames[2].document.getElementById('ffgh').disabled=true;
		
						var xmlDoc = ""
							var xmlHttp = new XMLHttpRequest()
							xmlStr ="<root><SEARCH steps='Mr_appt' req_id=\""+document.forms[0].req_id.value+"\"/></root>"
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
							xmlHttp.open("POST","../../eOA/jsp/getbookapptvalue.jsp",false)
							xmlHttp.send(xmlDoc)
							responseText=xmlHttp.responseText
							responseText = trimString(responseText)
							eval(responseText)
		
		
		
		}
		
		</script>

		<script>
			if(document.forms[0].CallingMode.value=='OP'){
				if(document.forms[0].hdd_referal.value!='N'){
					if(document.forms[0].source.disabled) 
						document.forms[0].source.disabled=false;

					document.forms[0].source.value=document.forms[0].hdd_referal.value;
					document.forms[0].source.focus();
					if(document.forms[0].search1.disabled) 
						document.forms[0].search1.disabled=false;
					document.getElementById('search1').focus();
					document.getElementById('search1').disabled=true;

				}
			}

		
		</script>


		<script>
				
			function blink_close()
			{
				document.getElementById('blink_text').style.visibility='hidden';
				setTimeout('blink_open()',1000);
			}
			
			function blink_open()
			{
				
			document.getElementById('blink_text').style.visibility='visible';
			setTimeout('blink_close()',1000);
		  }
		  /*if('<%=referral_id%>' !='')
		 {
			var obj=document.forms[0].source;			
			validpatient_refral(obj,'model1');
			
			if(document.getElementById('patient_id').value !="")
				validpatient('P');

		 }Commented for the CRF - Bru-HIMS-CRF-169*/
		</script>

		 </form>
		<script>
		//parent.document.getElementById('mainFrame').rows = '*,0,5%,0';
				parent.document.getElementById("f_query_add_mod").style.height='85vh'
				parent.document.getElementById("SecondaryFrame").style.height='0vh'
				parent.document.getElementById("ButtonFrame").style.height='5vh'
				parent.document.getElementById("messageFrame").style.height='0vh'
		</script>
			
			<%
			
	        if(stmt!=null) stmt.close();
			if(rs!=null) rs.close();
    		if(rs1!=null) rs1.close();
    		if(rs2!=null) rs2.close();
    		if(rs3!=null) rs3.close();
    		if(rsas!=null) rsas.close();
    		if(rsap!=null) rsap.close();
    		if(rsc!=null) rsc.close();
    		if(rst!=null) rst.close();
			if(rs_nid!=null) rs_nid.close();
			if(rs_ser!=null) rs_ser.close();
			if(rs_p!=null) rs_p.close();
			if(obc!=null) obc.close();
			if(stmtas !=null) stmtas.close();
			if (rsdt!=null) rsdt.close();
			if (rs_service!=null) rs_service.close();
			if (rs32 !=null) rs32.close();
			if (rslen !=null)	 rslen.close();
			if (rssrl !=null) rssrl.close();
			
			if(stmt1_p  !=null) stmt1_p.close();
    		if(stmtas !=null) stmtas.close();
			if(stmtsrl !=null) stmtsrl.close();
    		if(stmtap !=null) stmtap.close();
    		if(stmtc !=null) stmtc.close();
    		if(stmt7!=null) stmt7.close();
    		if(stmtt!=null) stmtt.close();
    		if(stmt1!=null) stmt1.close();
    		if(stmt2!=null) stmt2.close();
			if(stmtlen!=null) stmtlen.close();
			if(stmtdt!=null) stmtdt.close();
			if(stmtn !=null) stmtn.close();
			if(stmt_visit_type !=null) stmt_visit_type.close();
			if(stmt_service !=null) stmt_service.close();

			if(pstmt!=null){
				pstmt.close();
			}


	

///// ---
}catch(Exception e){
	//out.println(e);
	e.printStackTrace();
}finally{
    ConnectionManager.returnConnection(conn,request);
}

%>
<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

</body>
</html>

