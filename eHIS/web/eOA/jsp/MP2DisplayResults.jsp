<!DOCTYPE html>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<Script src="../../eOA/js/ChangeDateFor2Vw.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
  <!-- this line Added for this CRFBru-HIMS-CRF-191 [IN:030391]  -->
  <script language="javascript" src="../../eCommon/js/DateUtils.js"></script> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>     
<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>  
<%  
    // Modified for CRF - SRR -0425 -- Order Catalog. 
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		//String alcn_catg_code="";
		String blkStatus="";
		String blkRemark="";
		String book_appt_yn ="";                  
		String book_appt_wo_pid_yn="";            
		String obook_appt_yn ="";                  
		String book_appt_across_catg_yn  ="";     
		String tfr_appt_yn="";                    
		String tfr_appt_across_catg_yn="";        
		String canc_appt_yn  ="";  
		String alcn_crit="";
		String sql_access="";
		String curr_user_id=(String)session.getValue("login_user");
		String mode_find="";
		String current_date="";
		String current_time="";
		boolean allow_revise=true;
		int max_patient			=0;
		int total_booked		=0;
		String global_locn_yn="";
		PreparedStatement pstmt_label		= null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt_access		= null;
		CallableStatement cstmt = null;
		CallableStatement statement_bru = null;

		//this CRF Bru-HIMS-CRF-165.1 [IN:035659]	
		int groupCnt = 0;
		 int order_clinic_count=	0; 	
		 Statement stApptgroup=null;
		 ResultSet rsApptgroup=null;
		String groupApptYN = "N";
		int max_patients_per_slab = 0;
		 int group_check=0;
		//End Bru-HIMS-CRF-191 [IN:030391]
		
	//Below variable declare for this  [Bru-HIMS-CRF-177]	
	  String colour_indicator="";
	  /*Added by Thamizh selvi on 17th July 2018 against ML-MMOH-CRF-1058 Start*/
	  boolean isIncRemarksLengthAppl = false;
	  String apptRemarks = "";
	  /*End*/

	   //Added by Ashwini on 27-May-2020 for MOHE-CRF-0017
	   boolean isOverBookingAppl = false;
	   String time_elapsed_yn = "";
	   int sch_cnt = 0;

	   //Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
	   String schedule_extend_yn="N";

	   //Added by Ashwini on 24-Jun-2020 for PMG2020-MOHE-CRF-0001  
	   int future_slot_count = 0; 

	    //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
		 Boolean isSlotStartMidEndAppl = false;
		 String p_o_ext_slot_status = "";
		 String p_o_reserved_slot_dtls = "";
		 String p_o_appt_slot_dtls = "";
		 String p_o_block_slot_dtls = "";
		 String p_o_break_slot_dtls = "";
 
try{ 

		String locale = (String)session.getAttribute("LOCALE");
		String callingMode = request.getParameter("callingMode");
		if (callingMode==null) callingMode = "";
		String date=(String)request.getParameter("Date");
		String date1=(String)request.getParameter("Date1");
		mode_find=(String)request.getParameter("mode_find");
		if(mode_find==null) mode_find="";
		String pre_pat_alcn_catg_code = request.getParameter("pre_pat_alcn_catg_code");
		if( pre_pat_alcn_catg_code == null) pre_pat_alcn_catg_code="";
		String clinic_code=(String)request.getParameter("clinic_code1");
		String practitioner_id=(String)request.getParameter("practitioner_id1");
		String from_page=request.getParameter("from_page");
		if(from_page ==null) from_page="";
		String clinic_code2=(String)request.getParameter("clinic_code2");
		String practitioner_id2=(String)request.getParameter("practitioner_id2");

		String facilityid=(String)session.getValue("facility_id");
		String value12=(String)request.getParameter("value12");
		
		if( value12 == null || value12.equals("null")) value12="";
		String value13=(String)request.getParameter("value13");
		if( value13 == null || value13.equals("null"))  value13=""; 
		String old_clinic=(String)request.getParameter("old_clinic");
		if(old_clinic  == null || old_clinic.equals("null"))old_clinic="";

		String old_practitioner=(String)request.getParameter("old_practitioner");
		if(old_practitioner== null || old_practitioner.equals("null"))old_practitioner="";

		String old_from_time = request.getParameter("old_from_time");
		if( old_from_time == null) old_from_time="";

		String old_to_time = request.getParameter("old_to_time");
		if( old_to_time == null) old_to_time="";
			String create_wait_list_yn=request.getParameter("create_wait_list_yn");
			if(create_wait_list_yn ==null) create_wait_list_yn="";

		String old_date=(String)request.getParameter("old_date");
		if(old_date  == null || old_date.equals("null")) old_date="";

		String ca_mode=(String)request.getParameter("ca_mode");

		String ca_patient_id=request.getParameter("ca_patient_id");
		if(ca_patient_id==null) ca_patient_id="";


		String slot_appt_ctrl=request.getParameter("slot_appt_ctrl")==null?"":request.getParameter("slot_appt_ctrl");
		String visit_limit_rule=request.getParameter("visit_limit_rule")==null?"":request.getParameter("visit_limit_rule");
		String alcn_criteria=request.getParameter("alcn_criteria")==null?"":request.getParameter("alcn_criteria");
		String override_no_of_slots_yn=request.getParameter("override_no_of_slots_yn")==null?"":request.getParameter("override_no_of_slots_yn");
		String capture_fin_dtls_yn=request.getParameter("capture_fin_dtls_yn")==null?"N":request.getParameter("capture_fin_dtls_yn");
		String min_ela_per_resc_noshow_in_day=request.getParameter("min_ela_per_resc_noshow_in_day")==null?"":request.getParameter("min_ela_per_resc_noshow_in_day");
		String noshow_ctrl_by_splty_or_clinic=request.getParameter("noshow_ctrl_by_splty_or_clinic")==null?"":request.getParameter("noshow_ctrl_by_splty_or_clinic");
		String contact_num_reqd_yn=request.getParameter("contact_num_reqd_yn")==null?"N":request.getParameter("contact_num_reqd_yn");
		String no_of_noshow_appts_for_alert=request.getParameter("no_of_noshow_appts_for_alert")==null?"":request.getParameter("no_of_noshow_appts_for_alert");
		String per_chk_for_no_show_alert=request.getParameter("per_chk_for_no_show_alert")==null?"":request.getParameter("per_chk_for_no_show_alert");




			//MR by suman 
		String req_id=request.getParameter("req_id");
		if(req_id ==null) req_id="";
		
			String install_yn_val=request.getParameter("install_yn_val");
		if(install_yn_val ==null) install_yn_val="";

		String order_id=request.getParameter("order_id");
		if(order_id==null) order_id="";
		String order_line_num=request.getParameter("order_line_num");
		if(order_line_num == null) order_line_num="";
		String order_catalog_code=request.getParameter("order_catalog_code");
		if(order_catalog_code ==null) order_catalog_code="";

		String clinic_type1=request.getParameter("clinic_type1");
		String res_type1=request.getParameter("res_type1");
		String clinic_type2=request.getParameter("clinic_type2");
		String res_type2=request.getParameter("res_type2");

		String clinic_type3=request.getParameter("clinic_type3");
	
		String value_chk=request.getParameter("value_chk");
		//out.println("value_chk:"+value_chk);
		String res_type3=request.getParameter("res_type3");


		String or_catalogue_code=request.getParameter("or_catalogue_code");
		if(or_catalogue_code == null)  or_catalogue_code="";
		String oper_stn_id=request.getParameter("oper_stn_id");
		if(oper_stn_id == null ) oper_stn_id="";

		if (clinic_type1==null) clinic_type1 = "C";
		if (res_type1==null) res_type1 = "P";

		if (clinic_type2==null) clinic_type2 = "C";
		if (res_type2==null) res_type2 = "P";

		if (clinic_type3==null) clinic_type3 = "C";
		if (res_type3==null) res_type3 = "P";

		String visit_flag_OP=request.getParameter("visit_flag_OP");
		if(visit_flag_OP==null) visit_flag_OP="N";		

		String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");

//OPCheckout
		String from_facility_id= request.getParameter("from_facility_id");
		if(from_facility_id ==null) from_facility_id="";
		String from_encounter_id= request.getParameter("from_encounter_id");
		if(from_encounter_id ==null) from_encounter_id="";

		String P_O_CLINIC             ="";       
		String P_O_PRACTITIONER       ="";   

		//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017
		String P_O_CLINIC_CODE        ="";       
		String P_O_PRACTITIONER_CODE  ="";
		String P_O_SCH_END_TIME		  ="";
		
		String P_O_MAX_PAT            ="";       
		String P_O_MAX_OVER_BOOK      ="";       
		String P_O_BOOKED             ="";       
		String P_O_OVER_BOOKED        ="";       
		String P_O_OVER_BOOKING       ="N";       
		String P_O_TIME_TAB_TYPE     ="";        
		String P_O_STATUS             ="";       
		String P_O_FROM_TIME          ="";       
		String P_O_TO_TIME            ="";       
		String P_O_APPT_REF_NO        ="";       
		String P_O_PATIENT_NAME       ="";    
		String P_O_PATIENT_ID       =""; 

        String P_O_VISIT_TYPE_CODE   =""; //Added for this CRF Bru-CRF-177  
        String P_LAST_APPT_BOOKED   =""; //Added for this CRF Bru-CRF-177    		

		String P_O_AGE                ="";       
		String P_O_GENDER             ="";       
		String P_O_REASON_FOR_CON    ="";        
		String P_O_VISIT_TYPE         ="";       
		String P_O_CONTACT            ="";     
		String P_O_END_TIME= "";
		String P_O_VISIT_TYPE_IND     ="";
		String P_O_NO_OF_SLOTS= "";
		String FORCED_BOOK_APPT_YN="";
		String GLOBAL_BOOK_APPT_YN="";
		String P_O_MAX_FORCED_BOOK    ="";
		String P_O_FORCED_BOOK		  =""; 	
		String P_O_MAX_GLOBAL_BOOK    ="";
		String P_O_GLOBAL_BOOK		  =""; 	
		String P_O_MAX_SLOTS_FOR_FIRST_VISITS = "";
		String P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED="";
		String P_O_MAX_FIRST_VISITS = "";
		String P_O_TOTAL_FIRST_VISIT = "";
		String P_O_OBVISIT_FLAG = "N";
		String P_O_MAX_SLOTS_PER_DAY="";
		String P_O_MAX_OTHER_VISITS="";
		String P_O_TOTAL_OTHER_VISITS="";
		String clinic_name="";
		String pract_name="";

		String TOTAL_NORMAL_TFR="";
		String TOTAL_BULK_TFR="";
		String P_APPT_OTH_DTL       ="";

		Connection con = null;
		CallableStatement statement = null;
		ResultSet rs = null;
		ResultSet rs32= null;
		//Statement stmtsd=null;
		Statement stmt=null;
		//Statement stmtn=null;
		//String sql="";
		//String sys_date="";
		//String sys_time="";
		String P_O_Max_Forced= "";
		String P_O_Total_Forced= "";
		String P_O_Max_Global= "";
		String P_O_Total_Global= "";

		String total_booked1="";
		//String max_patients_per_day="";
		boolean normal_booking_allow_flag = true;
		String care_locn_ind_desc="";
		String P_O_pat_cat      ="";
		if(value_chk.equals("display0"))
		{
				if(clinic_type1.equals("C")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
		}else if(clinic_type1.equals("E")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
		}else if(clinic_type1.equals("D")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
		}

		
		}else
		{
			if(clinic_type2.equals("C")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
		}else if(clinic_type2.equals("E")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
		}else if(clinic_type2.equals("D")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
		}

			
		}
		String res_class_desc="";

	



		if(value_chk.equals("display0"))
		{
				if(res_type1.equals("P"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
				}else if(res_type1.equals("E"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
				}else if(res_type1.equals("R"))
				{
			   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
				}else if(res_type1.equals("O"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
				}

		}else
		{
			if(res_type2.equals("P"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
				}else if(res_type2.equals("E"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
				}else if(res_type2.equals("R"))
				{
			   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
				}else if(res_type2.equals("O"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
				}

			
		}
		String calling_mode=request.getParameter("callingMode");
		if(calling_mode==null) calling_mode="N";
		String 	ref_id=(String) session.getValue("ref_id");
		if(ref_id==null) ref_id="N";

try{
	con = ConnectionManager.getConnection(request);
	isIncRemarksLengthAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA","INCREASE_APPT_REMARKS_LENGTH");//Added by Thamizh selvi on 17th July 2018 against ML-MMOH-CRF-1058

	isOverBookingAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA","SCH_APPT_OVER_BOOKING");//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017

	isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1

	  /*Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659] */
    stApptgroup=con.createStatement();	
	//String oderclinicquery="select count(*) order_count_clinic from op_catalog_for_clinic a where a.facility_id='"+facilityid+"' AND a.CLINIC_CODE='"+clinic_code+"'";
	//rsApptgroup=stApptgroup.executeQuery(oderclinicquery);
	String oderclinicquery="select count(*) order_count_clinic from op_catalog_for_clinic a where a.facility_id=? AND a.CLINIC_CODE=?";
	pstmt = con.prepareStatement(oderclinicquery);
	pstmt.setString(1,facilityid);
	pstmt.setString(2,clinic_code);
	rsApptgroup = pstmt.executeQuery();
	if(rsApptgroup.next()) {
		order_clinic_count=rsApptgroup.getInt("order_count_clinic");
		
	}
	if(stApptgroup!=null) stApptgroup.close();
	if(rsApptgroup!=null) rsApptgroup.close();
 //End this CRF Bru-HIMS-CRF-165.1 [IN:035659]	
			//stmtsd=con.createStatement();
			//stmtn=con.createStatement();

	/*if (slot_appt_ctrl.equals("P")){

		if(value_chk.equals("display0")){
			alcn_crit="select nvl(max_patients_per_day,0) max_patients_per_day, nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked from oa_clinic_schedule  where facility_id='"+facilityid+"' and clinic_date =to_date('"+date+"','dd/mm/yyyy') and clinic_code='"+clinic_code+"'and Nvl(Practitioner_id,'X') =nvl('"+practitioner_id+"' ,'X') and care_locn_type_ind='"+clinic_type1+"' and resource_class='"+res_type1+"'";
		}else{
			alcn_crit="select nvl(max_patients_per_day,0) max_patients_per_day, nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked from oa_clinic_schedule  where facility_id='"+facilityid+"' and clinic_date =to_date('"+date1+"','dd/mm/yyyy') and clinic_code='"+clinic_code2+"'and Nvl(Practitioner_id,'X') =nvl('"+practitioner_id2+"' ,'X') and care_locn_type_ind='"+clinic_type2+"' and resource_class='"+res_type2+"'";
		}
		rs = stmtsd.executeQuery(alcn_crit);
		if(rs !=null){
			while ( rs.next() ){
					max_patients_per_day= rs.getString("max_patients_per_day");
					total_booked1		= rs.getString("total_booked");
			}
		
		}   
		
		if(rs !=null) rs.close();
		if (max_patients_per_day.equals(total_booked1))
			normal_booking_allow_flag=false;
	}
	*/
			//if(value_chk.equals("display0")){
				//sql_access="select book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,book_appt_across_catg_yn,tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,FORCED_BOOK_APPT_YN,GLOBAL_BOOK_APPT_YN,global_locn_yn from am_os_user_locn_access_vw  where facility_id=? and locn_code=?  and oper_stn_id=? and appl_user_id=? and (book_appt_yn='Y' or book_appt_wo_pid_yn='Y' or obook_appt_yn='Y' or book_appt_across_catg_yn='Y' or tfr_appt_yn='Y' or tfr_appt_across_catg_yn='Y' or canc_appt_yn='Y')";

			//}else{
				//sql_access="select book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,book_appt_across_catg_yn,tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,FORCED_BOOK_APPT_YN,GLOBAL_BOOK_APPT_YN,global_locn_yn,(select count(*) count_value from oa_group_hdr a ,oa_group_dtls b where eff_status='E' and LOCN_CODE='"+clinic_code+"' and a.GROUP_ID=b.GROUP_ID) groupCnt,(SELECT group_appt_yn FROM oa_param WHERE module_id = 'OA') group_appt_yn from am_os_user_locn_access_vw  where facility_id=? and locn_code=?  and oper_stn_id=? and appl_user_id=? and (book_appt_yn='Y' or book_appt_wo_pid_yn='Y' or obook_appt_yn='Y' or book_appt_across_catg_yn='Y' or tfr_appt_yn='Y' or tfr_appt_across_catg_yn='Y' or canc_appt_yn='Y')";
				sql_access="select book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,book_appt_across_catg_yn,tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,FORCED_BOOK_APPT_YN,GLOBAL_BOOK_APPT_YN,global_locn_yn,(select count(*) count_value from oa_group_hdr a ,oa_group_dtls b where eff_status='E' and LOCN_CODE=? and a.GROUP_ID=b.GROUP_ID) groupCnt,(SELECT group_appt_yn FROM oa_param WHERE module_id = 'OA') group_appt_yn from am_os_user_locn_access_vw  where facility_id=? and locn_code=?  and oper_stn_id=? and appl_user_id=? and (book_appt_yn='Y' or book_appt_wo_pid_yn='Y' or obook_appt_yn='Y' or book_appt_across_catg_yn='Y' or tfr_appt_yn='Y' or tfr_appt_across_catg_yn='Y' or canc_appt_yn='Y')";

			//}
	
				pstmt_access = con.prepareStatement(sql_access);

				pstmt_access.setString(1,clinic_code);
				pstmt_access.setString(2,facilityid);
				if(value_chk.equals("display0")){
					pstmt_access.setString(3,clinic_code);
				}else{
					pstmt_access.setString(3,clinic_code2);
				}
				pstmt_access.setString(4,oper_stn_id);
				pstmt_access.setString(5,curr_user_id);


			rs = pstmt_access.executeQuery();
		if(rs !=null)
		{
			while ( rs.next() )
			{
					book_appt_yn= rs.getString("book_appt_yn");
					book_appt_wo_pid_yn= rs.getString("book_appt_wo_pid_yn");
					obook_appt_yn= rs.getString("obook_appt_yn");
					book_appt_across_catg_yn= rs.getString("book_appt_across_catg_yn");
					tfr_appt_yn= rs.getString("tfr_appt_yn");
					tfr_appt_across_catg_yn= rs.getString("tfr_appt_across_catg_yn");
					canc_appt_yn= rs.getString("canc_appt_yn");
					FORCED_BOOK_APPT_YN= rs.getString("FORCED_BOOK_APPT_YN");
					GLOBAL_BOOK_APPT_YN = rs.getString("GLOBAL_BOOK_APPT_YN");					
					global_locn_yn= rs.getString("global_locn_yn");
					if(global_locn_yn==null)global_locn_yn="N";
					groupCnt = rs.getInt("groupCnt");
					groupApptYN = rs.getString("group_appt_yn")==null?"N":rs.getString("group_appt_yn");
			}
		}
			if(rs !=null) rs.close();

	StringBuffer sql_label=new StringBuffer();

	//if(value_chk.equals("display0")){

		sql_label.append("select OP_GET_DESC.OP_CLINIC(FACILITY_ID, CLINIC_CODE,?,'1') clinic_name, clinic_code, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, practitioner_id,?,'2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,?,'2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,?,'2'))  practitioner_name, practitioner_id, time_table_type, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, nvl(total_slots_booked,0) total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked,  to_char(start_time,'hh24:mi') start_time, to_char(end_time,'hh24:mi')end_time, nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked, nvl(max_slots_for_first_visit,0) max_slots_for_first_visit, nvl(total_first_visit,0) total_first_visit, nvl(max_other_visits,0) max_other_visits, nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits, nvl(max_first_visits,0) max_first_visits, nvl(max_slots_per_day,0) max_slots_per_day, nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING, nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING, nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED, nvl(total_first_visits_blocked,0) total_first_visits_blocked, nvl(total_other_visits_blocked,0) total_other_visits_blocked ,NVL(Schedule_status,'A') Schedulestatus,Remarks, to_char(sysdate,'dd/mm/yyyy') current_date,to_char(sysdate,'hh24:mi') current_time, TOTAL_NORMAL_TFR, TOTAL_BULK_TFR,nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked_count,max_patients_per_slab, schedule_extend_yn  from oa_clinic_schedule where facility_id=? and clinic_date  =to_date(?,'dd/mm/yyyy') and clinic_code=?  and care_locn_type_ind =? and resource_class=? and ");
		//Modified by Ashwini on 27-May-2020 for MOHE-CRF-0017


		if(value_chk.equals("display0")){
		
			if(practitioner_id.equals("")){
				sql_label.append(" practitioner_id is null ");
			}else{
				sql_label.append(" practitioner_id =? ");
			}
		}else{
			if(practitioner_id2.equals("")){
				sql_label.append(" practitioner_id is null ");
			}else{
				sql_label.append(" practitioner_id =? ");
			}
		}

	
	//}else{

		//sql_label.append("select OP_GET_DESC.OP_CLINIC(FACILITY_ID, CLINIC_CODE,?,'1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, practitioner_id,?,'2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,?,'2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,?,'2'))  practitioner_name, time_table_type, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, nvl(total_slots_booked,0) total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked,  to_char(start_time,'hh24:mi') start_time, to_char(end_time,'hh24:mi')end_time, nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked, nvl(max_slots_for_first_visit,0) max_slots_for_first_visit, nvl(total_first_visit,0) total_first_visit, nvl(max_other_visits,0) max_other_visits, nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits, nvl(max_first_visits,0) max_first_visits, nvl(max_slots_per_day,0) max_slots_per_day, nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING, nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING, nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED, nvl(total_first_visits_blocked,0) total_first_visits_blocked, nvl(total_other_visits_blocked,0) total_other_visits_blocked ,NVL(Schedule_status,'A') Schedulestatus,Remarks, to_char(sysdate,'dd/mm/yyyy') current_date,to_char(sysdate,'hh24:mi') current_time, TOTAL_NORMAL_TFR, TOTAL_BULK_TFR,nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked_count  from oa_clinic_schedule where facility_id=? and clinic_date  =to_date(?,'dd/mm/yyyy') and clinic_code=?  and care_locn_type_ind =? and resource_class=? and ");
		
		//if(practitioner_id2.equals("")){
			//sql_label.append(" practitioner_id is null ");
		//}else{
			//sql_label.append(" practitioner_id =? ");
		//}
			

	//}
		

		pstmt_label = con.prepareStatement(sql_label.toString());

		pstmt_label.setString(1,locale);
		pstmt_label.setString(2,locale);
		pstmt_label.setString(3,locale);
		pstmt_label.setString(4,locale);
		pstmt_label.setString(5,locale);
		pstmt_label.setString(6,facilityid);
		
		if(value_chk.equals("display0")){

			pstmt_label.setString(7,date);
			pstmt_label.setString(8,clinic_code);
			pstmt_label.setString(9,clinic_type1);
			pstmt_label.setString(10,res_type1);

			if(!practitioner_id.equals("")){
				pstmt_label.setString(11,practitioner_id);
			}
		}else{
			pstmt_label.setString(7,date1);
			pstmt_label.setString(8,clinic_code2);
			pstmt_label.setString(9,clinic_type2);
			pstmt_label.setString(10,res_type2);

			if(!practitioner_id2.equals("")){
				pstmt_label.setString(11,practitioner_id2);
			}
		}

		rs32 = pstmt_label.executeQuery();
	
		while ( rs32.next() )
		{
			P_O_CLINIC			= rs32.getString("clinic_name");
			P_O_PRACTITIONER 	= rs32.getString("practitioner_name");
			if( P_O_PRACTITIONER == null) P_O_PRACTITIONER="";
			
			//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017
			P_O_CLINIC_CODE 	= rs32.getString("clinic_code");
			if( P_O_CLINIC_CODE == null) P_O_CLINIC_CODE="";
			P_O_PRACTITIONER_CODE 	= rs32.getString("practitioner_id");
			if( P_O_PRACTITIONER_CODE == null) P_O_PRACTITIONER_CODE="";

			P_O_MAX_PAT 		= rs32.getString("max_patients_per_day");
			P_O_TIME_TAB_TYPE    = rs32.getString("time_table_type" );   
			P_O_MAX_OVER_BOOK   =rs32.getString("max_over_booking" );        if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";
			P_O_BOOKED                 	=rs32.getString("total_slots_booked" );   if( P_O_BOOKED ==null) P_O_BOOKED="";

			P_O_MAX_FORCED_BOOK  =rs32.getString("MAX_FORCED_IN_BOOKING");
			if(P_O_MAX_FORCED_BOOK==null)P_O_MAX_FORCED_BOOK="";
			P_O_FORCED_BOOK	=rs32.getString("TOTAL_FORCED_IN_BOOKED");
			if(P_O_FORCED_BOOK==null)P_O_FORCED_BOOK="";

			schedule_extend_yn=rs32.getString("schedule_extend_yn");
			if(schedule_extend_yn==null) schedule_extend_yn="N";

			P_O_MAX_GLOBAL_BOOK  =rs32.getString("MAX_GLOBAL_BOOKING");
			if(P_O_MAX_GLOBAL_BOOK==null)P_O_MAX_GLOBAL_BOOK="";
			P_O_GLOBAL_BOOK	=rs32.getString("TOTAL_GLOBAL_BOOKED");
			if(P_O_GLOBAL_BOOK==null)P_O_GLOBAL_BOOK="";
			blkStatus= rs32.getString("Schedulestatus");
			if(blkStatus ==null) blkStatus="";
			blkRemark=rs32.getString("Remarks");
			if(blkRemark ==null) blkRemark="";
			current_date=rs32.getString("current_date");
			if(current_date ==null) current_date="";
			current_time=rs32.getString("current_time");
			if(current_time ==null) current_time="";

			if (slot_appt_ctrl.equals("P")){
				total_booked1		= rs32.getString("total_booked_count");
				if (P_O_MAX_PAT.equals(total_booked1))
					normal_booking_allow_flag=false;
			}

			P_O_OVER_BOOKED        =rs32.getString( "total_slots_overbooked" );    if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";

			P_O_TO_TIME                  =rs32.getString("start_time" );	if(P_O_TO_TIME == null) P_O_TO_TIME="";
			P_O_SCH_END_TIME = rs32.getString("end_time"); if( P_O_SCH_END_TIME == null) P_O_SCH_END_TIME="";//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017
			P_O_MAX_SLOTS_FOR_FIRST_VISITS = rs32.getString("max_slots_for_first_visit"); if( P_O_MAX_SLOTS_FOR_FIRST_VISITS == null) P_O_MAX_SLOTS_FOR_FIRST_VISITS="";
			P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED= rs32.getString("total_first_visit_slots_booked"); if( P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED == null) P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED="";
			P_O_MAX_FIRST_VISITS = rs32.getString("max_first_visits"); if( P_O_MAX_FIRST_VISITS == null) P_O_MAX_FIRST_VISITS="";
			P_O_TOTAL_FIRST_VISIT = rs32.getString("total_first_visit"); if( P_O_TOTAL_FIRST_VISIT == null) P_O_TOTAL_FIRST_VISIT="";

			TOTAL_NORMAL_TFR=rs32.getString("TOTAL_NORMAL_TFR");
			if(TOTAL_NORMAL_TFR ==null) TOTAL_NORMAL_TFR="0";

			TOTAL_BULK_TFR=rs32.getString("TOTAL_BULK_TFR");
			if(TOTAL_BULK_TFR ==null) TOTAL_BULK_TFR="0";


			max_patients_per_slab = rs32.getInt("max_patients_per_slab"); 
			P_O_MAX_OTHER_VISITS = rs32.getString("max_other_visits"); 
			if( P_O_MAX_OTHER_VISITS == null) P_O_MAX_OTHER_VISITS="";
			P_O_TOTAL_OTHER_VISITS = rs32.getString("total_other_visits"); 
			if( P_O_TOTAL_OTHER_VISITS == null) P_O_TOTAL_OTHER_VISITS="";
			clinic_name	= rs32.getString("clinic_name");
			if(clinic_name ==null) clinic_name="";
			pract_name	= rs32.getString("practitioner_name");
			if(pract_name == null) pract_name="";
			P_O_MAX_SLOTS_PER_DAY= rs32.getString("max_slots_per_day"); 
			if( P_O_MAX_SLOTS_PER_DAY== null) P_O_MAX_SLOTS_PER_DAY="";
			if (P_O_TIME_TAB_TYPE.equals("1") && slot_appt_ctrl.equals("P"))
			P_O_BOOKED = 	String.valueOf(Integer.parseInt(P_O_TOTAL_FIRST_VISIT)+Integer.parseInt(P_O_TOTAL_OTHER_VISITS)+Integer.parseInt(rs32.getString("total_first_visits_blocked"))+Integer.parseInt(rs32.getString("total_other_visits_blocked")));
			P_O_TOTAL_FIRST_VISIT   = String.valueOf(Integer.parseInt(P_O_TOTAL_FIRST_VISIT)+Integer.parseInt(rs32.getString("total_first_visits_blocked")));
			P_O_TOTAL_OTHER_VISITS  = String.valueOf(Integer.parseInt(P_O_TOTAL_OTHER_VISITS)+Integer.parseInt(rs32.getString("total_other_visits_blocked")));
		
		//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017
		time_elapsed_yn = eOA.OACommonBean.getTimeElapsedYN(con,P_O_SCH_END_TIME,current_time);
		sch_cnt = eOA.OACommonBean.getScheduleCount(con,P_O_CLINIC_CODE,P_O_PRACTITIONER_CODE,facilityid,P_O_TO_TIME);
		
		if(isOverBookingAppl)
		{
			if(("1").equals(P_O_TIME_TAB_TYPE) || ("2").equals(P_O_TIME_TAB_TYPE))
			{
				if(!("Y").equals(P_O_OVER_BOOKING))
				{
					if(date.equals(current_date))
					{
						if(("Y").equals(time_elapsed_yn))
						{
							if(Integer.parseInt(P_O_OVER_BOOKED) < Integer.parseInt(P_O_MAX_OVER_BOOK))
							{
								P_O_OVER_BOOKING = "Y";
							}
						}else
						{
							if(sch_cnt > 0)
							{
								//Added by Ashwini on 24-Jun-2020 for PMG2020-MOHE-CRF-0001
								future_slot_count = eOA.OACommonBean.getFutureSlotCount(con,P_O_CLINIC_CODE,P_O_PRACTITIONER_CODE,facilityid,P_O_TO_TIME,P_O_SCH_END_TIME);
								
								if(future_slot_count == 0)
								{
									if(Integer.parseInt(P_O_OVER_BOOKED) < Integer.parseInt(P_O_MAX_OVER_BOOK))
									{
										P_O_OVER_BOOKING = "Y";
									}
								}
							}
						}
					}
				}
			}
		}
	
		if (!visit_limit_rule.equals("N"))
		{
				if(! P_O_MAX_FIRST_VISITS.equals("") &&  !P_O_TOTAL_FIRST_VISIT.equals("") && !P_O_MAX_OVER_BOOK.equals("") && !P_O_OVER_BOOKED.equals(""))
				{
					if (Integer.parseInt(P_O_MAX_FIRST_VISITS) <= Integer.parseInt(P_O_TOTAL_FIRST_VISIT)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED)&&Integer.parseInt(P_O_MAX_FIRST_VISITS)>0)
					{
						P_O_OVER_BOOKING         ="Y";
						P_O_OBVISIT_FLAG		 ="F";
					}
				}
				if(! P_O_MAX_OTHER_VISITS.equals("") &&  !P_O_TOTAL_OTHER_VISITS.equals("") && !P_O_MAX_OVER_BOOK.equals("") && !P_O_OVER_BOOKED.equals(""))
				{
						if (Integer.parseInt(P_O_MAX_OTHER_VISITS) <= Integer.parseInt(P_O_TOTAL_OTHER_VISITS)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED)&&Integer.parseInt(P_O_MAX_OTHER_VISITS)>0)
						{
							P_O_OVER_BOOKING         ="Y";
							if(P_O_OBVISIT_FLAG.equals("F"))
								P_O_OBVISIT_FLAG		 ="A";
							else
								P_O_OBVISIT_FLAG		 ="O";
						}
					}		
		}
		if(! P_O_MAX_PAT.equals("") &&  !P_O_BOOKED.equals("") && !P_O_MAX_OVER_BOOK.equals("") && !P_O_OVER_BOOKED.equals(""))
		{
		 	if (Integer.parseInt(P_O_MAX_PAT) == Integer.parseInt(P_O_BOOKED)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED))
			{
				P_O_OVER_BOOKING         ="Y";
				P_O_OBVISIT_FLAG		 ="A";
			}
		}



	}//end of while loop
	String  over_booked_label="";
over_booked_label=P_O_OVER_BOOKING;

if(blkStatus.equals("B")){
	P_O_OVER_BOOKING="N";
}
		if(rs32 !=null) rs32.close();
		%>
	<html>
		<head>		
	</head>
	<script src="../../eOP/js/ManageSPatQueue.js"></script>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<body onLoad=visiblelity() OnMouseDown="CodeArrest()"onKeyDown = 'lockKey()' onscroll="scrollheader();scrollTitle();">
<form name="multi_pract" id="multi_pract">
		<%
		if(P_O_MAX_PAT==null || P_O_MAX_PAT.equals(""))
			{
		if(P_O_PRACTITIONER==null) P_O_PRACTITIONER="";

%>


	<div id="labeldiv_one" style="visibility:visible;backgroundColor:white;overflow:scroll">
	<table cellspacing='0' width='100%' cellpadding='0' border='0'>
	<tr>
	<td class='label' nowrap><b><%=care_locn_ind_desc%>/<%=clinic_name%>
	&nbsp;&nbsp;&nbsp;&nbsp;<%=res_class_desc%>
	<%
	if(!pract_name.equals("")){
	%>
	/<%=pract_name%></b></td><td class='label'>&nbsp;</td>
	<%
	}else{
	%>
	<td class='label' colspan='4'>&nbsp;</td>
	<%
	}
	%>
	</tr>
	<tr><td class='label' colspan='5'></td></tr>
	<tr><td class='label' colspan='5'>&nbsp;</td></tr>
	<tr><td colspan=5 class='label' align='center'><b>
	<script>
	var error=getMessage("SCH_NOT_AVAILABLE_DAY","OA");
	alert(error);
	</script>
	</b></td></tr>
	<tr><td class='label' colspan='5'>&nbsp;</td></tr>
	<tr><td class='label' colspan='5'></td></tr>
	<tr><td class='label' colspan='5'></td></tr>
	<tr><td class='label' colspan='5'></td></tr>
	<tr><td class='label' colspan='5'></td></tr>
	</table>
		<input type='hidden' name='reason_for_revise' id='reason_for_revise'  value="<%=value12%>" >

	</div>
<%
}else{
if( P_O_CLINIC.length() !=0) { 

%>

<%
	String group_sql="";
	if(!alcn_criteria.equals("")){
		if(value_chk.equals("display0")){
			//group_sql="select alcn_criteria from oa_clinic_schedule where clinic_date=to_date('"+date+"','dd/mm/yyyy') and facility_id='"+facilityid+"' and clinic_code='"+clinic_code+"' and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X')";
			group_sql="select alcn_criteria from oa_clinic_schedule where clinic_date=to_date(?,'dd/mm/yyyy') and facility_id=? and clinic_code=? and nvl(practitioner_id,'X')=nvl(?,'X')";
		}else{
			//group_sql="select alcn_criteria from oa_clinic_schedule where clinic_date=to_date('"+date+"','dd/mm/yyyy') and facility_id='"+facilityid+"' and clinic_code='"+clinic_code2+"' and nvl(practitioner_id,'X')=nvl('"+practitioner_id2+"','X')";
			group_sql="select alcn_criteria from oa_clinic_schedule where clinic_date=to_date(?,'dd/mm/yyyy') and facility_id=? and clinic_code=? and nvl(practitioner_id,'X')=nvl(?,'X')";
		}
		//stmt=con.createStatement();
		//rs=stmt.executeQuery(group_sql);
		pstmt = con.prepareStatement(group_sql);
		pstmt.setString(1,date);
		pstmt.setString(2,facilityid);
		if(value_chk.equals("display0")){
		pstmt.setString(3,clinic_code);
		pstmt.setString(4,practitioner_id);
		}else{
		pstmt.setString(3,clinic_code2);
		pstmt.setString(4,practitioner_id2);
		}
		rs = pstmt.executeQuery();
		while(rs!=null && rs.next()){
			 alcn_criteria=rs.getString("alcn_criteria")==null?"":rs.getString("alcn_criteria");
		}
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
	}

 %>


		<div id="labeldiv2" style="visibility:visible;backgroundColor:white;overflow:scroll">
		<table cellspacing='0' width='112%' cellpadding='0' border='0'>
			<tr>
				<td class='label' nowrap  ><b><%=care_locn_ind_desc%>/<%=P_O_CLINIC %></td>

		<% if(value_chk.equals("display0"))
	            {
				if(!alcn_criteria.equals("")) {%>
				<td class='label' width='30%'><a href="javascript:allocationDetails('<%=clinic_code%>','<%=date%>','<%=practitioner_id%>')"><b><fmt:message key="eOA.Allocation.label" bundle="${oa_labels}"/></b>
				</a></td>
				<%}else{%>
				<td class='label' width='30%'>&nbsp;</td>
			<%}
				}
				else
            if(!alcn_criteria.equals("")) {%>
				<td class='label' width='30%'><a href="javascript:allocationDetails('<%=clinic_code2%>','<%=date%>','<%=practitioner_id2%>')"><b><fmt:message key="eOA.Allocation.label" bundle="${oa_labels}"/></b>
				</a></td>
				<%}else{%>
				<td class='label' width='30%'>&nbsp;</td>
			<%}
				%>
				
				<td class='label'>&nbsp;</td>
				<td  align="center" class='label' id='bli'  nowrap WIDTH='20%'>
				<%if(P_O_OVER_BOOKING.equals("Y") && global_locn_yn.equals("N")){
				if((calling_mode.equals("")) ||((calling_mode).equals("OP") && ref_id.equals("N")) || (calling_mode.equals("CA") || (calling_mode.equals("OR")) )){
				
					%><a href='javascript:moveNext_labels0()'><b><fmt:message key="eOA.overbooking.label" bundle="${oa_labels}"/></b></a><input type='hidden' name='dummy' id='dummy' ><%
				
					}
				}
				%>
	
			</td>
						
			</tr>
			<tr>
				
			<td class='label' nowrap colspan='2' ><b><%=res_class_desc%>
					<%if(! P_O_PRACTITIONER.equals("")){ %>
					/  <%=P_O_PRACTITIONER %>
				    <%}else{P_O_PRACTITIONER=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.Notidentified.label","oa_labels"); %>/ <%=P_O_PRACTITIONER %>
					<%}%></b>
		
				</td>
				<td class='label'>&nbsp;</td>
			</tr>	
			
		</table>
		<table width='112%' cellspacing='0' cellpadding='0' border='1'>
			<tr>
			<td class='label' width="2%">&nbsp;</td>
			<td class='label' align=middle>

			<%  if (P_O_TIME_TAB_TYPE.equals("1") && slot_appt_ctrl.equals("S")){%>
				<b><fmt:message key="Common.Slot.label" bundle="${common_labels}"/></b>
			<%}else{%>
				<b><fmt:message key="Common.patient.label" bundle="${common_labels}"/></b>
			<%}%>
			</td>	
			<td class='label' align=middle><b><fmt:message key="eOA.FV.label" bundle="${oa_labels}"/></b></td>
			<td class='label' align=middle><b><fmt:message key="eOA.OV.label" bundle="${oa_labels}"/></b></td>
			<td class='label' align=middle><b><fmt:message key="eOA.OB.label" bundle="${oa_labels}"/></b></td>
			<td class='label' align=middle><b><fmt:message key="eOA.Global.label" bundle="${oa_labels}"/></b></td>
			<td class='label' align=middle>
			<%if (!P_O_TIME_TAB_TYPE.equals("3")){%>		
				<b><fmt:message key="eOA.Forced.label" bundle="${oa_labels}"/></b>
			<%}else{%>
				&nbsp;
			<%}%>
			</td>
            <!--Below line Modified for this CRF ML-MMOH-CRF-0606--> 
			<!--Below line Modified for this CRF ML-MMOH-CRF-0609 by Mano-->
			<td class='label' align=middle><b><fmt:message key="eOA.NormalReschedule.label" bundle="${oa_labels}"/>&nbsp;<fmt:message key="Common.count.label" bundle="${common_labels}"/></b></td>
			<td class='label' align=middle><b><fmt:message key="eOA.BulkReschedule.label" bundle="${oa_labels}"/>&nbsp;<fmt:message key="Common.count.label" bundle="${common_labels}"/></b></td>
			<!--End this CRF ML-MMOH-CRF-0609-->
			<!--End this CRF ML-MMOH-CRF-0606-->
			</tr>

			<tr>
			<td class='label' width="2%"><b><fmt:message key="Common.maximum.label" bundle="${common_labels}"/></b></td>
			<td class='label' align=middle>
			<%if (P_O_TIME_TAB_TYPE.equals("1") && slot_appt_ctrl.equals("S")){%>
				<b><%=P_O_MAX_SLOTS_PER_DAY%></b>
			<%}else{%>
				<b><%=P_O_MAX_PAT%></b>
			<%}%>
					</td>	
			<td class='label' align=middle>
				<%if(P_O_MAX_FIRST_VISITS.equals("0")){%>
						&nbsp;
					<%}else{%>
						<b><%=P_O_MAX_FIRST_VISITS%></b>
					<%}%></td>
			<td class='label' align=middle>
						<%if(P_O_MAX_OTHER_VISITS.equals("0")){%>
						&nbsp;
					<%}else{%>
						<b><%=P_O_MAX_OTHER_VISITS%></b>
					<%}%>
			</td>
			<td class='label' align=middle><b><%=P_O_MAX_OVER_BOOK%></b></td>

			<td class='label' align=middle><b><%=P_O_MAX_GLOBAL_BOOK%></b> </td>
			<td class='label' align=middle>
			<%if (!P_O_TIME_TAB_TYPE.equals("3")){%>		
				<b><%=P_O_MAX_FORCED_BOOK%></b>
			<%}else{%>
				&nbsp;
			<%}%>
			</td>

			<td class='label' >&nbsp;</td>
			<td class='label' >&nbsp;</td>

			
			</tr>

			<tr>
			<td class='label' width="2%"><b><fmt:message key="Common.booked.label" bundle="${common_labels}"/></b></td>
			<td class='label' align=middle><b><%=P_O_BOOKED%></b></td>	
			<td class='label' align=middle><b><%=P_O_TOTAL_FIRST_VISIT%></b></td>
			<td class='label' align=middle><b><%=P_O_TOTAL_OTHER_VISITS%></b></td>
			<td class='label' align=middle><b><%=P_O_OVER_BOOKED%></b></td>
			<td class='label' align=middle><b><%=P_O_GLOBAL_BOOK%></b></td>
			<td class='label' align=middle>
			<%if (!P_O_TIME_TAB_TYPE.equals("3")){%>		
				<b><%=P_O_FORCED_BOOK%></b>
			<%}else{%>
				&nbsp;
			<%}%>
			</td>
			
			<td class='label' >&nbsp;</td>
			<td class='label' >&nbsp;</td>
			
			</tr>
		
			<!-- <tr> 
			<td colspan = '7' class='label'  align=center> </td>
			</tr> -->

		<!-- </table>
		<table width='100%' cellspacing='0' cellpadding='0' border='0'> -->
		<tr>
		<!--Below line Modified for this CRF ML-MMOH-CRF-0606-->		
		<td class='label' nowrap width='2%'>&nbsp;</td>
		<td class='label' >&nbsp;</td>
		<td class='label' >&nbsp;</td>
		<td class='label' >&nbsp;</td>
		<td class='label' >&nbsp;</td>
		<td class='label' >&nbsp;</td>
		<td class='label' >&nbsp;</td>
		<td class='label' align=middle><b><%=TOTAL_NORMAL_TFR%></b> </td>
		<td class='label' align=middle><b><%=TOTAL_BULK_TFR%></b> </td>
		
		</tr>
		
		</table></div>

		<br>
			
		<!-- <div id='header' style="visibility:visible;backgroundColor:white;overflow:scroll"> -->
	<table border="1" width="100%" cellspacing='0' cellpadding='0' id='results1'>
	<th align='left' width='9%' ><div  id='head1'  class='myClass' nowrap ><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></div></th>
	<th align='left' width='11%' ><div  id='head2'  class='myClass' nowrap ><fmt:message key="Common.totime.label" bundle="${common_labels}"/></div></th>
	<th align='left' width='22%'><div  id='head3'  class='myClass' nowrap ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></div></th>
	<th align='left' width='18%' ><div  id='head4'  class='myClass' nowrap ><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></div></th>
	
	<!--Below line added for this CRF GHL-CRF-0414 -->
	<th align='left' width='18%' ><div  id='head13'  class='myClass' nowrap ><fmt:message key="Common.Visit.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></div></th>
	<!--End GHL-CRF-0414 -->
	
	<th align='left' width='25%' ><div  id='head5'  class='myClass' nowrap ><fmt:message key="Common.ReasonForContact.label" bundle="${common_labels}"/></div></th>
	<th align='left' width='12%' ><div  id='head6'  class='myClass' nowrap ><fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/></div></th><!-- </table></div> -->
    	 <!--Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659]   -->
    <th align='left' width='12%'><div  id='head12'  class='myClass' nowrap ><fmt:message key="Common.Order.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Selection.label" bundle="${common_labels}"/></div></th>
  <!-- End this CRF Bru-HIMS-CRF-165.1 [IN:035659]  -->				
			<!--   <table border="1" width="100%" cellspacing='0' cellpadding='0' id='results'> -->
	<!--Added by Thamizh selvi on 17th July 2018 against ML-MMOH-CRF-1058 Start-->
	<% if(isIncRemarksLengthAppl){ %>
		<th align='left' width='12%'><div  id='head14'  class='myClass' nowrap ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></div></th>
	<% } %>
	<!--End-->
			<%}
		}
		%>
		



<% if(mode_find !=null && mode_find.equals("revise"))
{
	if(date !=null && date.equals(old_date))
	{
		allow_revise=true;
	}
	else
	{
		alcn_crit="";

		

	}//else
}//revise

	if(rs !=null) rs.close();

	//PreparedStatement pstmtststus=null;
	//ResultSet rsststus=null;
	

		/* Added for ML-BRU-CRF-0628.1 */
		if(isSlotStartMidEndAppl){
			cstmt = con.prepareCall("{call oa_external_slots_BRU(?,?,?,?,?,?,?,?,?)}");

			if(value_chk.equals("display0"))
			{
				cstmt.setString( 1, facilityid );
				cstmt.setString( 2, clinic_code );
				cstmt.setString( 3, practitioner_id );
				cstmt.setString( 4, date );
			}else
			{
				cstmt.setString( 1, facilityid );
				cstmt.setString( 2, clinic_code2 );
				cstmt.setString( 3, practitioner_id2 );
				cstmt.setString( 4, date1 );
			}
			cstmt.registerOutParameter( 5, Types.VARCHAR );
			cstmt.registerOutParameter( 6, Types.VARCHAR );
			cstmt.registerOutParameter( 7, Types.VARCHAR );
			cstmt.registerOutParameter( 8, Types.VARCHAR );
			cstmt.registerOutParameter( 9, Types.VARCHAR );

			cstmt.execute() ;

			p_o_ext_slot_status = cstmt.getString( 5 ); 
			if(p_o_ext_slot_status == null) p_o_ext_slot_status = "";
			
			p_o_reserved_slot_dtls = cstmt.getString( 6 );
			if(p_o_reserved_slot_dtls == null) p_o_reserved_slot_dtls = "";

			p_o_appt_slot_dtls = cstmt.getString( 7 );
			if(p_o_appt_slot_dtls == null) p_o_appt_slot_dtls = "";

			p_o_block_slot_dtls = cstmt.getString( 8 );
			if(p_o_block_slot_dtls == null) p_o_block_slot_dtls = "";

			p_o_break_slot_dtls = cstmt.getString( 9 );
			if(p_o_break_slot_dtls == null) p_o_break_slot_dtls = "";
		}
		
		if(isSlotStartMidEndAppl && P_O_TIME_TAB_TYPE.equals("2") && max_patients_per_slab != 1){

			System.err.println("Before execute oa_slabs_BRU---in Param---facilityid-->"+facilityid+"  clinic_code-->"+clinic_code+"  practitioner_id-->"+practitioner_id+"  date-->"+date);
			System.err.println("Before execute oa_slabs_BRU---in Param---facilityid-->"+facilityid+"  clinic_code2-->"+clinic_code2+"  practitioner_id2-->"+practitioner_id2+"  date1-->"+date1);

			statement_bru = con.prepareCall("{call oa_slabs_BRU(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			if(value_chk.equals("display0"))
			{
				statement_bru.setString( 1, facilityid );
				statement_bru.setString( 2, clinic_code );
				statement_bru.setString( 3, practitioner_id );
				statement_bru.setString( 4, date );
			}else
			{
				statement_bru.setString( 1, facilityid );
				statement_bru.setString( 2, clinic_code2 );
				statement_bru.setString( 3, practitioner_id2 );
				statement_bru.setString( 4, date1 );
			}

			statement_bru.registerOutParameter( 5, Types.CLOB );
			statement_bru.registerOutParameter( 6, Types.CLOB );
			statement_bru.registerOutParameter( 7, Types.CLOB );
			statement_bru.registerOutParameter( 8, Types.CLOB );
			statement_bru.registerOutParameter( 9, Types.CLOB );
			statement_bru.registerOutParameter(10, Types.CLOB );
			statement_bru.registerOutParameter(11, Types.CLOB );
			statement_bru.registerOutParameter(12, Types.CLOB );
			statement_bru.registerOutParameter(13, Types.CLOB );
			statement_bru.registerOutParameter(14, Types.CLOB );
			statement_bru.registerOutParameter(15, Types.CLOB );
			statement_bru.registerOutParameter(16, Types.CLOB );
			statement_bru.registerOutParameter(17, Types.CLOB );
			statement_bru.registerOutParameter(18, Types.CLOB );
			statement_bru.registerOutParameter(19, Types.CLOB );
			statement_bru.registerOutParameter(20, Types.CLOB );
			statement_bru.registerOutParameter(21, Types.CLOB );
			statement_bru.registerOutParameter(22, Types.CLOB );
			statement_bru.registerOutParameter(23, Types.CLOB );
			statement_bru.registerOutParameter(24, Types.CLOB );
			statement_bru.registerOutParameter(25, Types.CLOB );
			statement_bru.registerOutParameter(26, Types.CLOB );

			statement_bru.execute() ;

			P_O_CLINIC = P_O_CLINIC_CODE;

			P_O_PRACTITIONER = P_O_PRACTITIONER_CODE;

			P_O_END_TIME = P_O_SCH_END_TIME;

			P_O_Max_Forced = P_O_MAX_FORCED_BOOK;

			P_O_Total_Forced = P_O_FORCED_BOOK;

			P_O_Max_Global = P_O_MAX_GLOBAL_BOOK;
				
			P_O_Total_Global = P_O_GLOBAL_BOOK;

			P_O_STATUS = statement_bru.getString(6); 
			if( P_O_STATUS == null) P_O_STATUS="";

			P_O_APPT_REF_NO = statement_bru.getString(7); 
			if( P_O_APPT_REF_NO == null) P_O_APPT_REF_NO="";

			P_O_PATIENT_NAME = statement_bru.getString(8); 
			if( P_O_PATIENT_NAME == null) P_O_PATIENT_NAME="";

			P_O_AGE = statement_bru.getString(9); 
			if( P_O_AGE == null) P_O_AGE="";

			P_O_GENDER = statement_bru.getString(10); 
			if( P_O_GENDER == null) P_O_GENDER="";

			P_O_REASON_FOR_CON = statement_bru.getString(12); 
			if( P_O_REASON_FOR_CON == null) P_O_REASON_FOR_CON="";

			P_O_VISIT_TYPE = statement_bru.getString(17); 
			if( P_O_VISIT_TYPE == null) P_O_VISIT_TYPE="";

			P_O_CONTACT = statement_bru.getString(13); 
			if( P_O_CONTACT == null) P_O_CONTACT="";

			P_O_VISIT_TYPE_IND = statement_bru.getString(14); 
			if( P_O_VISIT_TYPE_IND == null) P_O_VISIT_TYPE_IND="";

			P_O_PATIENT_ID = statement_bru.getString(15); 
			if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";

			P_LAST_APPT_BOOKED = statement_bru.getString(16); 
			if( P_LAST_APPT_BOOKED == null) P_LAST_APPT_BOOKED="";

			P_O_VISIT_TYPE_CODE = statement_bru.getString(11); 
			if( P_O_VISIT_TYPE_CODE == null) P_O_VISIT_TYPE_CODE="";

			P_APPT_OTH_DTL = statement_bru.getString(22); 
			if( P_APPT_OTH_DTL == null) P_APPT_OTH_DTL="";

			P_O_pat_cat = statement_bru.getString(23); 
			if( P_O_pat_cat == null) P_O_pat_cat="";

			P_O_FROM_TIME = statement_bru.getString(24);     
			if(P_O_FROM_TIME == null) P_O_FROM_TIME="";

			P_O_TO_TIME = statement_bru.getString(25);	
			if(P_O_TO_TIME == null) P_O_TO_TIME="";

			P_O_NO_OF_SLOTS = statement_bru.getString(26); 
			if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";

		}else{
		/* End ML-BRU-CRF-0628.1 */
		
		System.err.println("Before execute get_day_status---in Param---facilityid-->"+facilityid+"  date-->"+date+"  clinic_code-->"+clinic_code+"  practitioner_id-->"+practitioner_id+"  clinic_type1-->"+clinic_type1+"  res_type1-->"+res_type1);
		System.err.println("Before execute get_day_status---in Param---facilityid-->"+facilityid+"  date1-->"+date1+"  clinic_code2-->"+clinic_code2+"  practitioner_id2-->"+practitioner_id2+"  clinic_type2-->"+clinic_type2+"  res_type2-->"+res_type2);

		statement=con.prepareCall("{call oa_schedules.get_day_status( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					
		statement.setString( 1, facilityid);
		if(value_chk.equals("display0"))
		{
			statement.setString( 2, date);
			statement.setString( 3, clinic_code);
			statement.setString( 4, practitioner_id);
			statement.setString( 5, clinic_type1);
			statement.setString( 6, res_type1);
		}else
		{
			statement.setString( 2, date1);
			statement.setString( 3, clinic_code2);
			statement.setString( 4, practitioner_id2);
			statement.setString( 5, clinic_type2);
			statement.setString( 6, res_type2);
		}

		statement.registerOutParameter(7, Types.VARCHAR );
		statement.registerOutParameter(8, Types.VARCHAR );
		
		/*
		statement.registerOutParameter(7, Types.CLOB );
		statement.registerOutParameter(8, Types.CLOB );
		*/
		statement.registerOutParameter(9, Types.INTEGER);
		statement.registerOutParameter(10, Types.INTEGER);
		statement.registerOutParameter(11, Types.INTEGER);
		statement.registerOutParameter(12, Types.INTEGER);

		statement.registerOutParameter(13, Types.VARCHAR );
		statement.registerOutParameter(14, Types.VARCHAR );
		statement.registerOutParameter(15, Types.VARCHAR );
		statement.registerOutParameter(16, Types.VARCHAR );
		statement.registerOutParameter(17, Types.VARCHAR );
		statement.registerOutParameter(18, Types.VARCHAR );
		statement.registerOutParameter(19, Types.VARCHAR );
		statement.registerOutParameter(20, Types.VARCHAR );
		statement.registerOutParameter(21, Types.VARCHAR );
		statement.registerOutParameter(22, Types.VARCHAR );
		statement.registerOutParameter(23, Types.VARCHAR );
		statement.registerOutParameter(24 ,Types.VARCHAR );
		statement.registerOutParameter(25 ,Types.VARCHAR );
		statement.registerOutParameter(26 ,Types.VARCHAR );
		statement.registerOutParameter(27 ,Types.VARCHAR );
		statement.registerOutParameter(28 ,Types.VARCHAR );
		statement.registerOutParameter(29 ,Types.VARCHAR );
		statement.registerOutParameter(30 ,Types.VARCHAR );
		statement.registerOutParameter(31 ,Types.VARCHAR );
		statement.registerOutParameter(32 ,Types.VARCHAR );
		statement.registerOutParameter(33 ,Types.VARCHAR );
		
		/*
		statement.registerOutParameter(13, Types.CLOB );
		statement.registerOutParameter(14, Types.CLOB );
		statement.registerOutParameter(15, Types.CLOB );
		statement.registerOutParameter(16, Types.CLOB );
		statement.registerOutParameter(17, Types.CLOB );
		statement.registerOutParameter(18, Types.CLOB );
		statement.registerOutParameter(19, Types.CLOB );
		statement.registerOutParameter(20, Types.CLOB );
		statement.registerOutParameter(21, Types.CLOB );
		statement.registerOutParameter(22, Types.CLOB );
		statement.registerOutParameter(23, Types.CLOB );
		statement.registerOutParameter(24 ,Types.CLOB );
		statement.registerOutParameter(25 ,Types.CLOB );
		statement.registerOutParameter(26 ,Types.CLOB );
		statement.registerOutParameter(27 ,Types.CLOB );
		statement.registerOutParameter(28 ,Types.INTEGER );
		statement.registerOutParameter(29 ,Types.INTEGER);
		statement.registerOutParameter(30 ,Types.INTEGER );
		statement.registerOutParameter(31 ,Types.INTEGER );
		statement.registerOutParameter(32 ,Types.CLOB );
		statement.registerOutParameter(33 ,Types.CLOB );	
		*/
		statement.setString( 34, locale);

		statement.registerOutParameter(35 ,Types.VARCHAR );
		statement.registerOutParameter(36 ,Types.VARCHAR );
		statement.registerOutParameter(37 ,Types.VARCHAR );
		statement.registerOutParameter(38 ,Types.VARCHAR );
		statement.registerOutParameter(39 ,Types.VARCHAR );
		statement.registerOutParameter(40 ,Types.VARCHAR );
		statement.registerOutParameter(41 ,Types.VARCHAR );
		/*
		statement.registerOutParameter(35 ,Types.CLOB );
		statement.registerOutParameter(36 ,Types.CLOB );
		statement.registerOutParameter(37 ,Types.CLOB );
		statement.registerOutParameter(38 ,Types.CLOB );
		statement.registerOutParameter(39 ,Types.CLOB );
		statement.registerOutParameter(40 ,Types.CLOB );
		*/

		statement.execute() ;

		System.err.println("After execute get_day_status---in Param---facilityid-->"+facilityid+"  date-->"+date+"  clinic_code-->"+clinic_code+"  practitioner_id-->"+practitioner_id+"  clinic_type1-->"+clinic_type1+"  res_type1-->"+res_type1);
		System.err.println("After execute get_day_status---in Param---facilityid-->"+facilityid+"  date1-->"+date1+"  clinic_code2-->"+clinic_code2+"  practitioner_id2-->"+practitioner_id2+"  clinic_type2-->"+clinic_type2+"  res_type2-->"+res_type2);

		P_O_CLINIC=statement.getString( 7 ); if(P_O_CLINIC == null) P_O_CLINIC="";
		P_O_PRACTITIONER=statement.getString( 8 ); if(P_O_PRACTITIONER == null) P_O_PRACTITIONER="";
		P_O_MAX_PAT=statement.getString( 9 ); if(P_O_MAX_PAT == null) P_O_MAX_PAT="";
		P_O_MAX_OVER_BOOK     =statement.getString( 10 );        if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";
		P_O_BOOKED                 =statement.getString(11 );   if( P_O_BOOKED ==null) P_O_BOOKED="";
		P_O_OVER_BOOKED        =statement.getString( 12 );    if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";
		P_O_OVER_BOOKING         =statement.getString( 13 );     if(P_O_OVER_BOOKING == null) P_O_OVER_BOOKING="";
		P_O_TIME_TAB_TYPE          =statement.getString( 14 );   
		P_O_STATUS                    =statement.getString(15);
		P_O_FROM_TIME            =statement.getString( 16 );     if(P_O_FROM_TIME == null) P_O_FROM_TIME="";
		P_O_TO_TIME                   =statement.getString( 17 );	if(P_O_TO_TIME == null) P_O_TO_TIME="";
		P_O_APPT_REF_NO         =statement.getString(18 );      if(P_O_APPT_REF_NO ==null) P_O_APPT_REF_NO="";
		P_O_PATIENT_NAME        =statement.getString( 19 );      if(P_O_PATIENT_NAME ==null) P_O_PATIENT_NAME="";
		P_O_AGE                       =statement.getString( 20 );		if(P_O_AGE ==null) P_O_AGE="";
		P_O_GENDER                    =statement.getString( 21 );	if(P_O_GENDER ==null) P_O_GENDER="";
		P_O_REASON_FOR_CON    =statement.getString( 22 );        if(P_O_REASON_FOR_CON ==null) P_O_REASON_FOR_CON="";
		P_O_VISIT_TYPE                =statement.getString( 23 );		if(P_O_VISIT_TYPE ==null) P_O_VISIT_TYPE="";
		P_O_CONTACT       =statement.getString( 24 );		if(P_O_CONTACT == null) P_O_CONTACT="";
		P_O_END_TIME = statement.getString(25); if( P_O_END_TIME == null) P_O_END_TIME="";
		P_O_VISIT_TYPE_IND = statement.getString(26); if( P_O_VISIT_TYPE_IND == null) P_O_VISIT_TYPE_IND="";
		P_O_NO_OF_SLOTS = statement.getString(27); if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";
		P_O_Max_Forced=statement.getString(28); if( P_O_Max_Forced == null) P_O_Max_Forced="";
		P_O_Total_Forced=statement.getString(29); if( P_O_Total_Forced == null) P_O_Total_Forced="";
		P_O_Max_Global=statement.getString(30); if( P_O_Max_Global == null) P_O_Max_Global="";
		P_O_Total_Global=statement.getString(31); if( P_O_Total_Global == null) P_O_Total_Global="";
		P_O_PATIENT_ID=statement.getString(32); if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";
		P_LAST_APPT_BOOKED= statement.getString(33);	if( P_LAST_APPT_BOOKED == null) P_LAST_APPT_BOOKED=""; //Added for this CRF Bru-CRF-177
		P_O_VISIT_TYPE_CODE = statement.getString(35);	if( P_O_VISIT_TYPE_CODE == null) P_O_VISIT_TYPE_CODE=""; //Added for this CRF Bru-CRF-177
		P_APPT_OTH_DTL= statement.getString(40); if( P_APPT_OTH_DTL == null) P_APPT_OTH_DTL="";
		P_O_pat_cat= statement.getString(41); if( P_O_pat_cat == null) P_O_pat_cat="";

		}

		System.err.println("P_O_CLINIC-------->"+P_O_CLINIC);
		System.err.println("P_O_PRACTITIONER-------->"+P_O_PRACTITIONER);
		System.err.println("P_O_MAX_PAT-------->"+P_O_MAX_PAT);
		System.err.println("P_O_MAX_OVER_BOOK-------->"+P_O_MAX_OVER_BOOK);
		System.err.println("P_O_BOOKED-------->"+P_O_BOOKED);
		System.err.println("P_O_OVER_BOOKED-------->"+P_O_OVER_BOOKED);
		System.err.println("P_O_OVER_BOOKING-------->"+P_O_OVER_BOOKING);
		System.err.println("P_O_TIME_TAB_TYPE-------->"+P_O_TIME_TAB_TYPE);
		System.err.println("P_O_STATUS-------->"+P_O_STATUS);
		System.err.println("P_O_FROM_TIME-------->"+P_O_FROM_TIME);
		System.err.println("P_O_TO_TIME-------->"+P_O_TO_TIME);
		System.err.println("P_O_APPT_REF_NO-------->"+P_O_APPT_REF_NO);
		System.err.println("P_O_PATIENT_NAME-------->"+P_O_PATIENT_NAME);
		System.err.println("P_O_AGE-------->"+P_O_AGE);
		System.err.println("P_O_GENDER-------->"+P_O_GENDER);
		System.err.println("P_O_REASON_FOR_CON-------->"+P_O_REASON_FOR_CON);
		System.err.println("P_O_VISIT_TYPE-------->"+P_O_VISIT_TYPE);
		System.err.println("P_O_CONTACT-------->"+P_O_CONTACT);	
		System.err.println("P_O_END_TIME-------->"+P_O_END_TIME);
		System.err.println("P_O_VISIT_TYPE_IND-------->"+P_O_VISIT_TYPE_IND);
		System.err.println("P_O_NO_OF_SLOTS-------->"+P_O_NO_OF_SLOTS);
		System.err.println("P_O_Max_Forced-------->"+P_O_Max_Forced);
		System.err.println("P_O_Total_Forced-------->"+P_O_Total_Forced);
		System.err.println("P_O_Max_Global-------->"+P_O_Max_Global);
		System.err.println("P_O_Total_Global-------->"+P_O_Total_Global);
		System.err.println("P_O_PATIENT_ID-------->"+P_O_PATIENT_ID);
		System.err.println("P_LAST_APPT_BOOKED-------->"+P_LAST_APPT_BOOKED);
		System.err.println("P_O_VISIT_TYPE_CODE-------->"+P_O_VISIT_TYPE_CODE);
		System.err.println("P_APPT_OTH_DTL-------->"+P_APPT_OTH_DTL);
		System.err.println("P_O_pat_cat-------->"+P_O_pat_cat);

		StringTokenizer token = new StringTokenizer(P_O_FROM_TIME, "|");
		int counter=token.countTokens();          
			
			String from_time[]=new String[counter];
			int track=0;
			while (token.hasMoreTokens())
				{
				from_time[track]=token.nextToken();
				track++;
				}
			
			token=null;
			track=0;
			token = new StringTokenizer(P_O_TO_TIME, "|");			
			String to_time[]=new String[counter];
			String end_time ="";
			int tot_token= token.countTokens();

			while (token.hasMoreTokens())
			{
				end_time=token.nextToken();

				if(schedule_extend_yn.equals("Y") && P_O_TIME_TAB_TYPE.equals("1")) { // to handle last slot for extended

					if (tot_token-track == 1) {					
						end_time="00:00";
					}
				}
				
				to_time[track]=end_time;

				track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_PATIENT_NAME, "|");
			String patient_name[]=new String[counter];
			while (token.hasMoreTokens())
				{
				patient_name[track]=token.nextToken();
				track++;
				}				
			
			token=null;
			track=0;
			token = new StringTokenizer(P_O_PATIENT_ID, "|");
			String patient_id[]=new String[counter];
			while (token.hasMoreTokens())
				{
				patient_id[track]=token.nextToken();
				track++;
				}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_REASON_FOR_CON, "|") ;
			String reason_for_contact[]=new String[counter];
			while (token.hasMoreTokens())
				{
				reason_for_contact[track]=token.nextToken();
				track++;
				}		
				
			token=null;
			track=0;
			token = new StringTokenizer(P_O_VISIT_TYPE, "|");		
			String visit_type[]=new String[counter];
			while (token.hasMoreTokens())
				{
				visit_type[track]=token.nextToken();
				track++;
				}	

			token=null;
			track=0;
			token = new StringTokenizer(P_O_APPT_REF_NO, "|");
			String o_appt_ref_no[]=new String[counter];
			while (token.hasMoreTokens())
			{
			o_appt_ref_no[track]=token.nextToken();
			track++;
			}		
			


			token=null;
			track=0;

			token = new StringTokenizer(P_APPT_OTH_DTL, "|");
			String appt_ot_dtl[]=new String[counter];
			
			while (token.hasMoreTokens())
			{
			appt_ot_dtl[track]=token.nextToken();
			track++;
			}

			token=null;
			track=0;

			token = new StringTokenizer(P_O_STATUS, "|");
			String status[]=new String[counter];
			String status1[]=new String[counter];
			while (token.hasMoreTokens())
			{
			status[track]=token.nextToken();
			status1[track]=status[track];
			track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_VISIT_TYPE_IND, "|");
			String visit_type_ind[]=new String[counter];
			while (token.hasMoreTokens())
			{
			visit_type_ind[track]=token.nextToken();
			track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_NO_OF_SLOTS, "|");
			String no_of_slots[]=new String[counter];
			while (token.hasMoreTokens())
			{
			no_of_slots[track]=token.nextToken();
			track++;
			}	

            //Added for this CRF Bru-CRF-177
			
			token=null;
			track=0;
			token = new StringTokenizer(P_LAST_APPT_BOOKED, "|");
			String last_appt_booked[]=new String[counter];
			while (token.hasMoreTokens())
			{
			last_appt_booked[track]=token.nextToken();
			track++;
			}
			
			token=null;
			track=0;
			
			token = new StringTokenizer(P_O_VISIT_TYPE_CODE, "|");			
			String visit_type_code[]=new String[counter];
			
			while (token.hasMoreTokens())
			{
				visit_type_code[track]=token.nextToken();
				track++;
			}

            //End Bru-CRF-177			

			token=null;
			track=0;
			token = new StringTokenizer(P_O_pat_cat, "|");
			String pat_cat[]=new String[counter];
			while (token.hasMoreTokens())
			{
				pat_cat[track]=token.nextToken();
				track++;
			}
	
	if(mode_find !=null && mode_find.equals("revise"))
	{
		if(date !=null && date.equals(old_date))
		{
			allow_revise=true;
		}
		else{
		if(max_patient!=0)
		{
			if(max_patient==total_booked)
			{
				if(tfr_appt_across_catg_yn!=null && tfr_appt_across_catg_yn.equalsIgnoreCase("N"))
				{
					allow_revise=false;
					%>	
					<script>alert(getMessage('APPT_CAN_NOT_TRANS_OTH_CAT','OA'));</script>
				<%}
				else{%>
					<script>alert(getMessage('APPT_TRANS_OTH_CAT','OA'));</script>
					<%allow_revise=true;
				}
			}
		}
		else
		{
		allow_revise=true;
		}
	}//END OF ELSE
}//END OF REVISE


if(allow_revise)
{%>
		
		<script>
	
function doDateCheckAlert(from,to) {
	var fromarray; var toarray;
	var fromdate = from ;
	var todate = to ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			fromarray[1]=fromarray[1]-1;
			toarray[1]=toarray[1]-1;
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) {
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}

		var u1;
		var u2;
		var value1;
		var value2;
		var value3;
		var value4;
		var value5;
		var value6;
		var value7;
		var value8;
		var value9;
		var value10;
		var value11;
		var sys_date;
		var sys_time;
		var value12;
		var value13;
		var value14;
		var value15;
	
	var clinic_code2;
	var practitioner_id2;
function row(Obj)
{
	u1=Obj.rowIndex;
	u1=u1-1;
}
		
function col(Obj)
{

	 u2=Obj.cellIndex;
}

function moveNext_results0(pVal){
	var latter=document.getElementById('results1').rows[u1].cells[2].innerText ;
	var old_clinic=document.forms[0].old_clinic.value;
	var old_practitioner=document.forms[0].old_practitioner.value;
	var value_chk=document.forms[0].value_chk.value;
	var appt_date="";

	var appt_refno = eval('document.forms[0].o_appt_ref_no'+u1).value;

	/* Added for ML-BRU-CRF-0628.1 */
	ext_slot=document.forms[0].p_o_ext_slot_status.value;
	var s_arr=ext_slot.split("|");
	if (s_arr[u1] =='Y' && appt_refno == "~") {
		alert(getMessage("BRU_HEALTH_SLOT_SELECTED","OA"));

	}else{
	
	if(value_chk =="display0"){
		value1=document.forms[0].clinic_code.value;
		value2=document.forms[0].clinic_name.value;
		value3=document.forms[0].pract_id.value;
		value4=document.forms[0].pract_name.value;
		value5=document.forms[0].appt_date.value;
		appt_date=document.forms[0].appt_date.value;
	}else{
		value1=document.forms[0].clinic_code2.value;
		value2=document.forms[0].clinic_name.value;
		value3=document.forms[0].practitioner_id2.value;
		value4=document.forms[0].pract_name.value;
		value5=document.forms[0].appt_date2.value;
		appt_date=document.forms[0].appt_date2.value;
	}
	value6= document.getElementById("results1").rows[u1+1].cells[u2].innerText;
	value7=document.getElementById("results1").rows[u1+1].cells[u2+1].innerText;
	value8=document.forms[0].over_booked.value;
	value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
	value10=document.forms[0].patient_id.value;
	value11=document.forms[0].elements[u1].value;
	value12=document.forms[0].reason_for_revise.value;
	value13=document.forms[0].ref_no.value;
	var  old_date=document.forms[0].old_date.value;
	if( old_date.length == 0) document.forms[0].old_date.value=value5;
	value14= document.forms[0].old_from_time.value;
	value15= document.forms[0].old_to_time.value;
	sys_date=document.forms[0].sys_date.value;
	sys_time=document.forms[0].sys_time.value;	
	fromtimeharray=sys_time.split(":");
	from_time=value6.split(":");
	to_displayed_time=value7.split(":");
	var fromhtm=new Date(1,1,1,fromtimeharray[0],fromtimeharray[1],0,0);
	var tohtm=new Date(1,1,1,from_time[0],from_time[1],0,0);
	var to_displayed=new Date(1,1,1,to_displayed_time[0],to_displayed_time[1],0,0);
	practitioner_id2=document.forms[0].practitioner_id2.value;
	clinic_code2=document.forms[0].clinic_code2.value;
	if(!pVal) pVal='NO';
	if(old_clinic.length == 0 || old_clinic ==null || old_clinic== "undefined")
	old_clinic =value1;
	if(old_practitioner.length == 0 || old_practitioner ==null || old_practitioner== "undefined")
	old_practitioner = value3;	
	if( old_clinic == value1){
		if(old_practitioner == value3){
			if(eval('document.forms[0].o_appt_ref_no'+u1).value == "~"){	
			//if(document.forms[0].elements(u1).value == "~"){	
				if(doDateCheckAlert(appt_date ,document.forms[0].sys_date.value)){
					if(value9 == "1"){
						if((Date.parse(fromhtm) >= Date.parse(to_displayed))){
							alert(getMessage("FR_TIME_CAN_NOT_SYS_TIME","OA"));
						}else{
							if(document.forms[0].r_appt_status.value == "Revise"){
								callBookAppointmentDetails_results0(pVal);
							}else{
								if(value12.length == 0){
									callBookAppointment_results0();
								}else{
									callBookAppointmentDetails_results0(pVal);
								}
							}			
						}			
					} // e.o.f value 9
					if(value9 == "2" || value9 == "3"){
						if((Date.parse(to_displayed)<Date.parse(fromhtm))){
							if(latter.length != 1){
								callBookAppointmentDetails2_results0();
							}else
								alert(getMessage('ST_TM_LESS_SY_TM','OA'));
						}else{
							if(document.forms[0].r_appt_status.value == "Revise"){
								callBookAppointmentDetails_results0(pVal);
							}else{	
								if(value12.length == 0)
									callBookAppointment_results0();
								else
									callBookAppointmentDetails_results0(pVal);
							}				
						}			
					} // e.o.f value 9
				}else{
					if( document.forms[0].r_appt_status.value == "Revise"){
						callBookAppointmentDetails_results0(pVal);
					}else{
						if(value12.length == 0){ 
							 callBookAppointment_results0();
						}
						else{ 
							callBookAppointmentDetails_results0(pVal);
					}
					}
				}		
		}  // e.o.outer if
	else
	{
		
		if( doDateCheckAlert(appt_date ,document.forms[0].sys_date.value))
		{
			
			if(value9 == "1")
				{
					if(( Date.parse(tohtm) < Date.parse(fromhtm) ))
					
					{	
						if(latter.length != 1)
						{
							callBookAppointmentDetails2_results0();
						}
						else
						alert(getMessage('FR_TIME_CAN_NOT_SYS_TIME','OA'));	
					}
					
					else
					{
						if( document.forms[0].r_appt_status.value == "Revise")
						{
						alert(getMessage('REVISION_NOT_ALLOWED','OA'));
						}
						else
						{
						callBookAppointmentDetails_results0(pVal);
						}					
					}
					
				}
		
			if(value9 == "2" || value9 == "3")
				{
					if(( Date.parse(to_displayed) < Date.parse(fromhtm) )  )
					{
					if(latter.length != 1)
							{
							callBookAppointmentDetails2_results0();
							}
						else
					alert(getMessage('ST_TM_LESS_SY_TM','OA'));
					}
					else
					{
						if( document.forms[0].r_appt_status.value == "Revise")
						{
						alert(getMessage('REVISION_NOT_ALLOWED','OA'));
						}
						else
						{
						callBookAppointmentDetails_results0(pVal);
						}					
					}
					
				}		
		
		}
		else
		{
				if( document.forms[0].r_appt_status.value == "Revise")
						{
						alert(getMessage('REVISION_NOT_ALLOWED','OA'));
						}
						else
						{
						callBookAppointmentDetails_results0(pVal);
						}							
		}
		
	}

}
	else
	alert(getMessage('REV_NOT_ALLOW_PRACT','OA'));


}
	else
	alert(getMessage('REV_NOT_ALLOW_CLINIC','OA'));

	}
}
	
	</script>





 
<%	

 /*Below Code Added for this CRF [Bru-HIMS-CRF-177] */  
 java.util.HashMap hm=eMP.ChangePatientDetails.getColorCode(con,facilityid); 			
		
int maxval=0; String appt_ref_assign_value="";
for (int maxchk = 0; maxchk < o_appt_ref_no.length; maxchk++) 
{
   appt_ref_assign_value=o_appt_ref_no[maxchk];   
   if(!appt_ref_assign_value.equals("~")){
       while(Integer.parseInt(appt_ref_assign_value)>maxval)
       { 
          maxval=Integer.parseInt(appt_ref_assign_value);
       }
   } 
}

// End [Bru-HIMS-CRF-177] 

String classValue="";
int slots = 0;
String same_appt = "N";
String pat_name = "";
for(int init=0;init<counter;init++)
{
	/*Added by Thamizh selvi on 11th July 2018 against ML-MMOH-CRF-1058 Start*/
	if(isIncRemarksLengthAppl && !o_appt_ref_no[init].equals(""))
		apptRemarks		= eOA.OACommonBean.getApptRemarks(con,facilityid,o_appt_ref_no[init]);	
	/*End*/
same_appt = "N";

if( !(no_of_slots[init].equals("~")) && (Integer.parseInt(no_of_slots[init]) > 1) ) 
{
	slots = Integer.parseInt(no_of_slots[init]);
	pat_name = patient_name[init];
}

if ( init % 2 == 0 )
		classValue = "OAQRYEVEN" ;
			else
		classValue = "OAQRYODD" ;
%>


<tr onClick='row(this)'>
<%

String u=from_time[init];
String z=status[init];
String z1=status1[init];

String reason ="";
String reason1=z.substring(0,2);
if( z.length() > 2)
	reason=z.substring(2,z.length());
else
	reason="";
z=reason1;
if( ! u .equals("~")) 
		{
		String chk_blank_row_patient=patient_name[init];
		if(z.equals("FL") || z.equals("OL") || z.equals("VL")||z.equals("VT")){		 
		
			if(!(mode_find.equals("revise")) || mode_find.equals("")){
				
					if(chk_blank_row_patient.equals("~")){ 
						if(book_appt_yn.equalsIgnoreCase("Y")){
						if(slots > 0)
							{%>
								<td width='9%' class="<%=classValue%>" onClick='col(this)'><%=u%><input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
								<%slots--;
								same_appt = "Y";
							}
							else
							{
                             if (z.equals("VT"))
							 {%>
								<td width='9%' class="<%=classValue%>" ><%=u%><input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
							 <%}
							 else
							{
								if (z.equals("FL")&&(!normal_booking_allow_flag)){%>
									<td width='9%' class="<%=classValue%>" onClick='col(this)'><%=u%></a> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
								<%}else{
									if(blkStatus.equals("B")){%>
										<td  width='9%'  class='OARED' title="<%=blkRemark%>"><%=u%></td>
									<%}else{
										if(P_O_TIME_TAB_TYPE.equals("2")&& groupApptYN.equals("Y") && groupCnt>0 && callingMode.equals("") && (from_page.equals("") || from_page.equals("schedule_appt"))){
											%>
										<td  width='9%' class="<%=classValue%>" onClick='col(this)'><a href= "javascript:GroupappointmentSelect('','<%=o_appt_ref_no[init]%>')"><%=u%></a> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
									<%
										}else{
										%>
										<td  width='9%' class="<%=classValue%>" onClick='col(this)'><a href= javascript:moveNext_results0('')><%=u%></a> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
									<%}}
								}

							 }

							}
						}
						else if(book_appt_yn!=null && book_appt_yn.equalsIgnoreCase("N")){
							if (z.equals("FL")&&(!normal_booking_allow_flag)){%>
								<td  width='9%' class="<%=classValue%>" onClick='col(this)'><%= u%><input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
							<%}else{
								if(blkStatus.equals("B")){%>
									<td  width='9%'  class='OARED' title="<%=blkRemark%>"><%=u%></td>
								<%}else{%>
									<td  width='9%' class="<%=classValue%>" onClick='col(this)'><a href= javascript:moveNext_results0('')><%=u%><input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
								<%}
							}
						}
					}
					else{
                    if(z.equals("VT"))
					{%>
					<td  width='9%' class="<%=classValue%>" onClick='col(this)'><%=u%> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
					<%}
					else
					{
					if (z.equals("FL")&&(!normal_booking_allow_flag)){%>
						<td  width='9%' class="<%=classValue%>" onClick='col(this)'><%= u%></a> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
					<%}else{
						if(blkStatus.equals("B")){%>
							<td  width='9%'  class='OARED' title="<%=blkRemark%>"><%=u%></td>
						<%}else{%>
							<%if(z1.equals("OL*F")){%>
									<td  width='9%'  class='OAFORCED' onClick='col(this)' Title='Forced Appointment'><a href= javascript:moveNext_results0('F')><%=u%></a> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' >  </td>
								<%}else if(z1.equals("OL*")){%>
									
									<td  width='9%'  class="<%=classValue%>" onClick='col(this)'><a href= javascript:moveNext_results0('NF')><%=u%></a> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>												
								<%}else if(z1.equals("OL*M")){%>	
									<td  width='9%'  class="<%=classValue%>" onClick='col(this)'><a href= javascript:moveNext_results0('M')><%=u%></a> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>															
								<%}else{%>	
									<%if(z.equals("VL")){%>
									<td  width='9%'  class="<%=classValue%>" onClick='col(this)'><a href= javascript:moveNext_results0('NF')><%=u%></a> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
								<%}else{%>							
									<td  width='9%'  class="<%=classValue%>" onClick='col(this)'><a href= javascript:moveNext_results0('')><%=u%></a> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>			
								<%}%>													
								<%}%>
						<%}
					}

					}
					pat_name = patient_name[init];
					slots--;
					}
			}
			else{
					if(chk_blank_row_patient.equals("~")){
						if (z.equals("FL")&&(!normal_booking_allow_flag)){%>
							<td  width='9%' class="<%=classValue%>" onClick='col(this)'><%= u%></a> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
						<%}else{
							if(blkStatus.equals("B")){%>
								<td  width='9%'  class='OARED' title="<%=blkRemark%>"><%=u%></td>
							<%}else{%>
								<td  width='9%' class="<%=classValue%>" onClick='col(this)'><a href= javascript:moveNext_results0('')><%= u%></a> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
							<%}
						}
					}
					else{%>
						<td width='9%' class="<%=classValue%>" ><%=u%><input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
					<%
					}
		   }
		}
		else if(z.equals("RN")){%>
		<td  width='9%' class='OABLOCK' title =<%=reason%>><%=u%> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
		<%}	

		else if(z.equals("BN")){%>
		<td  width='9%' class='OARED' title ="<%=reason%>"><%= u%> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
		<%}	

		else{%>
		<td width='9%' class="<%=classValue%>" onClick='col(this)'><%= u%> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
		<%}
		}
		else{%>
		<td  width='9%' class="<%=classValue%>">&nbsp; <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
		<%
		}

String u1=to_time[init];

//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
if(u1.equals("00:00")){
	u1 = "23:59";
}

if( ! u1 .equals("~")){
	if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT")){
		if(blkStatus.equals("B")){%>
			<td  width='11%' class="OARED" title="<%=blkRemark%>"><%= u1%></td>
		<%}else{%>
			<%if(z1.equals("OL*F")){%>
				<td  width='11%' class="OAFORCED" Title="Forced Appointment"><%=u1%></td>
			<%}else{%>
				<td  width='11%' class="<%=classValue%>"><%=u1%></td>
			<%}%>
		<%}%>
	<%}else{
		if (z.equals("RN")){%>
			<td  width='11%' class='OABLOCK' title ="<%=reason%>"><%= u1%></td>
		<%}else{%>
			<td  width='11%' class='OARED' title ="<%=reason%>"><%=u1%></td>
		<%}
	}
}else{%>
		<td  width='11%' class="<%=classValue%>">&nbsp;</td>
<%}



String u2=patient_name[init];
String pat_id=patient_id[init];
if(pat_id.equals("~"))
	pat_id="";
else
	pat_id=pat_id+" , ";

	if( ! u2 .equals("~")){
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT")){%>
			<td width='22%' class="<%=classValue%>" wrap><%=pat_id%>&nbsp;<%=u2%><% if(pat_cat[init].equals("V")){%><img src='../../eCommon/images/PI_VIP.gif'><%}%></td>
		<%}else{
			if(same_appt.equals("Y")){%>
				<td width='22%' class="<%=classValue%>">***</td>
			<%}else{%>
				<td width='22%' class='OARED' title ="<%=reason%>">&nbsp;</td>
			<%}
		}
	}else{
		if(same_appt.equals("Y")){%>
			<td width='22%'  class="<%=classValue%>"><%=pat_name%></td>
		<%}	else{
			if(z.equals("BN")){%>
				<td width='22%' class="<%=classValue%>"><fmt:message key="Common.block.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.reason.label" bundle="${common_labels}"/>:<b><%=reason%></b></td>
			<%}else{%>				 
				<td width='22%' class="<%=classValue%>">&nbsp;</td>
			<%}
			
		}
	}
		

	String u6=visit_type[init];
	if( ! u6 .equals("~"))
		{
			if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT")){
			
			// Below Line Added for this CRF [Bru-HIMS-CRF-177] 		
		   String retval=checkForNull(visit_type_code[init]);		   
		 
		   colour_indicator =(String)hm.get(retval);
			
			 //End [Bru-HIMS-CRF-177] 
			
			%>
				<td width='20%' class="<%=classValue%>" style="background-color:<%=colour_indicator%>;FONT-SIZE:8pt;"><%= u6%></td>
			<%}
			else{%>
			<td width='20%' class='OARED' title ="<%=reason%>">&nbsp;</td>
			<%}
			}
		else{%>
		
		<td width='20%'  class="<%=classValue%>">&nbsp;</td>
		<%}

/*Below line added for this CRF GH-CRF-0414*/
String visit_ind_code=checkForNull(visit_type_ind[init]);
String visit_type_indcator="";
	if( ! visit_ind_code.equals("~"))
		{
		  /*Below line added for this CRF GHL-CRF-0414*/            
			if(visit_ind_code.equals("F"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels");
			if(visit_ind_code.equals("L"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels");
			if(visit_ind_code.equals("R"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
			if(visit_ind_code.equals("E"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
			if(visit_ind_code.equals("S"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels");
			if(visit_ind_code.equals("C"))
			visit_type_indcator=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels");
	       //End GHL-CRF-0414 
		
		%>
			 <td width='20%' class="<%=classValue%>"><%=visit_type_indcator%></td>			
		<%}else{%>		
		       <td width='20%'  class="<%=classValue%>">&nbsp;</td>
		<%}
/*End GHL-CRF-0414*/

	String u5=reason_for_contact[init];
	if( ! u5 .equals("~"))
		{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT")){%>
		<td width='25%' class="<%=classValue%>"><%=u5%></td>
		<%}
		else{%>
		<td width='25%' class='OARED' title ="<%=reason%>">&nbsp;</td>
		<%}
		}
		else{%>
		<td width='25%' class="<%=classValue%>">&nbsp;</td>
		<%}

	String tmp_ref_no=o_appt_ref_no[init];
	String oth_dtls=appt_ot_dtl[init];

	int sec_cnt=0;
	if(tmp_ref_no.equals("~")) tmp_ref_no="";

	StringTokenizer tmp_oth_dtl = new StringTokenizer(oth_dtls, "*");
	while (tmp_oth_dtl.hasMoreTokens())	{
		sec_cnt=Integer.parseInt(tmp_oth_dtl.nextToken());
		tmp_oth_dtl.nextToken();
		tmp_oth_dtl.nextToken();		
	}
	


	/*if(!tmp_ref_no.equals("")){
		sql="select count(appt_ref_no) count from oa_resource_for_appt where appt_ref_no = '"+tmp_ref_no+"' and FACILITY_ID='"+facilityid+"'";
			out.println("sec cnt sql " + sql);
			
		rs=stmtsd.executeQuery(sql);
		if ( rs != null && rs.next()){	
			sec_cnt=rs.getInt("count");	
		}
	}
	if(rs !=null) rs.close();
	*/
	%>
	<td width='18%' class="<%=classValue%>">
	<%if(sec_cnt>0){%>
		<a href="javascript:show_Reference_details_results0('<%=tmp_ref_no%>','<%=facilityid%>')">
			<fmt:message key="Common.details.label" bundle="${common_labels}"/>
		</a>
	<%}%>&nbsp;</td>
	<!--Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659]  -->
	<td width='12%' class="<%=classValue%>" onClick='col(this)' ><%if(!tmp_ref_no.equals("") && order_clinic_count>0){%><a href="javascript:show_order_select('','<%=o_appt_ref_no[init]%>','<%=facilityid%>','<%=clinic_code%>','<%=z%>')">
			<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Order.label" bundle="${common_labels}"/>
		</a><%}else{ %>&nbsp;<%} %><input type='hidden'  name='order_appt_ref_no<%=init%>' id='order_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
	<!-- End this CRF Bru-HIMS-CRF-165.1 [IN:035659] -->

	<!--Added by Thamizh selvi on 17th July 2018 against ML-MMOH-CRF-1058 Start-->
	<% if(isIncRemarksLengthAppl){ %>
		<td width='12%' class="<%=classValue%>" onClick='col(this)' ><%if(!("").equals(apptRemarks)){%><a href="javascript:dispApptRemarks('<%=facilityid%>','<%=o_appt_ref_no[init]%>')">
		<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Detail.label" bundle="${common_labels}"/>
		</a><% }else{ %>&nbsp;<%} %></td>
	<% } %>
	<!--End-->
   
  </tr>
   <%}	%>

</table>



<input type='hidden' name='r_appt_status' id='r_appt_status' value='null' >
<input type='hidden' name='clinic_code' id='clinic_code' value='<%= clinic_code %>' >
<input type='hidden' name='clinic_name' id='clinic_name' value='<%=P_O_CLINIC %>' >
<input type='hidden' name='pract_id' id='pract_id' value='<%=practitioner_id %>' >
<input type="hidden" name="P_O_OBVISIT_FLAG" id="P_O_OBVISIT_FLAG" value="<%=P_O_OBVISIT_FLAG%>">

<input type='hidden' name='pract_name' id='pract_name' value='<%=P_O_PRACTITIONER %>' >
<input type='hidden' name='appt_date' id='appt_date' value='<%=date %>' >
	<input type='hidden' name='appt_date2' id='appt_date2' value='<%=date1%>' >

<input type='hidden' name='over_booked' id='over_booked' value='<%=P_O_OVER_BOOKING %>' >
	 <input type='hidden' name='over_booked_label' id='over_booked_label' value='<%=over_booked_label%>' >

<input type='hidden' name='P_O_TIME_TAB_TYPE' id='P_O_TIME_TAB_TYPE' value='<%=P_O_TIME_TAB_TYPE%>' >
<input type='hidden' name='patient_id' id='patient_id' value='null'>
<input type='hidden' name='sys_date' id='sys_date' value='<%=current_date%>' >
<input type='hidden' name='sys_time' id='sys_time' value='<%= current_time %>' >

<input type='hidden' name='ref_no' id='ref_no' value= '<%= value13%>' >

<input type='hidden' name='clinic_code2' id='clinic_code2' value='<%= clinic_code2 %>' >
<input type='hidden' name='practitioner_id2' id='practitioner_id2' value='<%=practitioner_id2 %>' >

<input type='hidden' name='old_clinic' id='old_clinic' value='<%=old_clinic%>' >
<input type='hidden' name='old_practitioner' id='old_practitioner' value='<%=old_practitioner %>' >

<input type='hidden' name='p_o_end_time' id='p_o_end_time' value ='<%=P_O_END_TIME%>' >
<input type='hidden' name='old_date' id='old_date' value='<%=old_date%>' >

<input type='hidden' name='old_from_time' id='old_from_time' value='<%=old_from_time%>' >
<input type='hidden' name='old_to_time' id='old_to_time' value='<%=old_to_time%>' >
<input type='hidden' name='book_appt_yn' id='book_appt_yn' value='<%=book_appt_yn%>' >
<input type='hidden' name='book_appt_wo_pid_yn' id='book_appt_wo_pid_yn' value='<%=book_appt_wo_pid_yn%>' >
<input type='hidden' name='obook_appt_yn' id='obook_appt_yn' value='<%=obook_appt_yn%>' >
<input type='hidden' name='book_appt_across_catg_yn' id='book_appt_across_catg_yn' value='<%=book_appt_across_catg_yn%>' >
<input type='hidden' name='tfr_appt_yn' id='tfr_appt_yn' value='<%=tfr_appt_yn%>' >
<input type='hidden' name='tfr_appt_across_catg_yn' id='tfr_appt_across_catg_yn' value='<%=tfr_appt_across_catg_yn%>' >
<input type='hidden' name='canc_appt_yn' id='canc_appt_yn' value='<%=canc_appt_yn%>' >
<input type='hidden' name='ca_mode' id='ca_mode' value='<%=ca_mode%>' >
<input type='hidden' name='ca_patient_id' id='ca_patient_id' value='<%=ca_patient_id%>' >
<input type='hidden' name='date1' id='date1' value='<%=date1%>' >
<input type="hidden" name="maxForced" id="maxForced" value="<%=P_O_Max_Forced%>">
<input type="hidden" name="totForced" id="totForced" value="<%=P_O_Total_Forced%>">
<input type="hidden" name="maxGlobal" id="maxGlobal" value="<%=P_O_Max_Global%>">
<input type="hidden" name="totGlobal" id="totGlobal" value="<%=P_O_Total_Global%>">

<input type="hidden" name="clinic_type1" id="clinic_type1" value="<%=clinic_type1%>">
<input type="hidden" name="res_type1" id="res_type1" value="<%=res_type1%>">
<input type="hidden" name="clinic_type2" id="clinic_type2" value="<%=clinic_type2%>">
<input type="hidden" name="res_type2" id="res_type2" value="<%=res_type2%>">
<input type="hidden" name="clinic_type3" id="clinic_type3" value="<%=clinic_type3%>">
<input type="hidden" name="res_type3" id="res_type3" value="<%=res_type3%>">
<input type="hidden" name="or_catalogue_code" id="or_catalogue_code" value="<%=or_catalogue_code%>">
<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
<input type="hidden" name="order_catalog_code" id="order_catalog_code" value="<%=order_catalog_code%>">
<input type="hidden" name="order_line_num" id="order_line_num" value="<%=order_line_num%>">
<input type="hidden" name="oper_stn_id" id="oper_stn_id" value="<%=oper_stn_id%>">
<input type="hidden" name="alcn_criteria" id="alcn_criteria" value="<%=alcn_criteria%>">
<input type="hidden" name="slot_appt_ctrl" id="slot_appt_ctrl" value="<%=slot_appt_ctrl%>">
<input type="hidden" name="visit_limit_rule" id="visit_limit_rule" value="<%=visit_limit_rule%>">
<input type="hidden" name="override_no_of_slots_yn" id="override_no_of_slots_yn" value="<%=override_no_of_slots_yn%>">
<input type="hidden" name="callingMode" id="callingMode" value="<%=callingMode%>">
<input type='hidden' name="req_id" id="req_id" value="<%=req_id%>">
<input type="hidden" name="install_yn_val" id="install_yn_val" value="<%=install_yn_val%>">
<input type="hidden" name="value_chk" id="value_chk" value="<%=value_chk%>">
<input type="hidden" name="P_O_MAX_PAT" id="P_O_MAX_PAT" value="<%=P_O_MAX_PAT%>">
<input type='hidden' name='reason_for_revise' id='reason_for_revise'  value="<%=value12%>" >
<input type='hidden' name='visit_flag_OP' id='visit_flag_OP'  value="<%=visit_flag_OP%>" >
<input type="hidden" name='capture_fin_dtls_yn' id='capture_fin_dtls_yn' value='<%=capture_fin_dtls_yn%>'>
<input type="hidden" name='from_page' id='from_page' value='<%=from_page%>'>
<input type="hidden" name="refID" id="refID" value="<%=ref_id%>">
<input type="hidden" name="ForcedAllowed" id="ForcedAllowed" value="<%=FORCED_BOOK_APPT_YN%>">
<input type="hidden" name="GlobalAllowed" id="GlobalAllowed" value="<%=GLOBAL_BOOK_APPT_YN%>">
<input type="hidden" name="create_wait_list_yn" id="create_wait_list_yn" value="<%=create_wait_list_yn%>">
<input type="hidden" name='min_ela_per_resc_noshow_in_day' id='min_ela_per_resc_noshow_in_day' value='<%=min_ela_per_resc_noshow_in_day%>'>
<input type="hidden" name='noshow_ctrl_by_splty_or_clinic' id='noshow_ctrl_by_splty_or_clinic' value='<%=noshow_ctrl_by_splty_or_clinic%>'>
<input type="hidden" name='contact_num_reqd_yn' id='contact_num_reqd_yn' value='<%=contact_num_reqd_yn%>'>
<input type="hidden" name='no_of_noshow_appts_for_alert' id='no_of_noshow_appts_for_alert' value='<%=no_of_noshow_appts_for_alert%>'>
<input type="hidden" name='per_chk_for_no_show_alert' id='per_chk_for_no_show_alert' value='<%=per_chk_for_no_show_alert%>'>
<input type="hidden" name="LocGlbChk" id="LocGlbChk" value="<%=global_locn_yn%>" >

<input type="hidden" name='from_facility_id' id='from_facility_id' value='<%=from_facility_id%>'>
<input type="hidden" name='from_encounter_id' id='from_encounter_id' value='<%=from_encounter_id%>'>
<input type="hidden" name='rd_appt_yn' id='rd_appt_yn' value='<%=rd_appt_yn%>'>
<input type="hidden" name='max_patients_per_slab' id='max_patients_per_slab' value='<%=max_patients_per_slab%>'>

<input type="hidden" name='isIncRemarksLengthAppl' id='isIncRemarksLengthAppl' value='<%=isIncRemarksLengthAppl%>'><!--Added by Thamizh selvi on 16th July 2018 against ML-MMOH-CRF-1184-->

<!-- Added for ML-BRU-CRF-0628.1 -->
<input type="hidden" name="p_o_ext_slot_status" id="p_o_ext_slot_status" value="<%=p_o_ext_slot_status%>">
<input type="hidden" name="p_o_reserved_slot_dtls" id="p_o_reserved_slot_dtls" value="<%=p_o_reserved_slot_dtls%>">
<input type="hidden" name="p_o_appt_slot_dtls" id="p_o_appt_slot_dtls" value="<%=p_o_appt_slot_dtls%>">
<input type="hidden" name="p_o_block_slot_dtls" id="p_o_block_slot_dtls" value="<%=p_o_block_slot_dtls%>">
<input type="hidden" name="p_o_break_slot_dtls" id="p_o_break_slot_dtls" value="<%=p_o_break_slot_dtls%>">
<input type="hidden" name="isSlotStartMidEndAppl" id="isSlotStartMidEndAppl" value="<%=isSlotStartMidEndAppl%>">
<!-- End ML-BRU-CRF-0628.1 -->

<%String calling_mode2=request.getParameter("callingMode");
if(calling_mode2==null) calling_mode2="N";%>
<input type="hidden" name="calling_mode" id="calling_mode" value="<%=calling_mode2%>">


<script>

/* Added for ML-BRU-CRF-0628.1 */
if (document.forms[0].isSlotStartMidEndAppl.value=='true'){

	var ext_slt=document.forms[0].p_o_ext_slot_status.value;
	var res_slt=document.forms[0].p_o_reserved_slot_dtls.value;
	var appt_slt=document.forms[0].p_o_appt_slot_dtls.value;
	var blk_slt=document.forms[0].p_o_block_slot_dtls.value;
	var brk_slt=document.forms[0].p_o_break_slot_dtls.value;
	var pract_id=document.forms[0].pract_id.value;
	var practitioner_id2=document.forms[0].practitioner_id2.value;

	var ext_slot_arr=ext_slt.split("|");
	var res_slot_arr=res_slt.split("|");
	var appt_slot_arr=appt_slt.split("|");
	var blk_slot_arr=blk_slt.split("|");
	var brk_slot_arr=brk_slt.split("|");

	for(var i=0;i<=ext_slot_arr.length;i++){
		
		if(ext_slot_arr[i]=='Y') {

			if(blk_slot_arr[i]=='N' && brk_slot_arr[i]=='N') {
				if(res_slot_arr[i] !='N'){
				
					document.getElementById("results1").rows[i+1].cells[0].style.backgroundColor = "Bisque";
					document.getElementById("results1").rows[i+1].cells[1].style.backgroundColor = "Bisque";
					document.getElementById("results1").rows[i+1].cells[0].style.Color = "Black";
					document.getElementById("results1").rows[i+1].cells[0].style.Color = "Black";
					document.getElementById("results1").rows[i+1].cells[2].style.backgroundColor = "Bisque";
					document.getElementById("results1").rows[i+1].cells[2].innerText = "BRU Health Reservation : "+res_slot_arr[i];

				}else {
					document.getElementById("results1").rows[i+1].cells[0].style.backgroundColor = "Bisque";
					document.getElementById("results1").rows[i+1].cells[0].style.backgroundColor = "Bisque";
				}
			}

			
		}
			
	}
}
/* End ML-BRU-CRF-0628.1 */
		
async function allocationDetails(clinicCode,clinicDate,practID){

		var dialogTop = "60" ;
		var dialogHeight= "20" ;
		var dialogWidth	= "40" ;
		var status = "no";
		var arguments	= "" ;
		var tit="locn_Srch";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var retVal = await window.showModalDialog("../../eOA/jsp/ClinicAllocationDetails.jsp?clinic_code="+clinicCode+"&clinic_date="+clinicDate+"&practitioner_id="+practID,arguments,features);	
}
	
</script>
<input type='hidden' name='pre_pat_alcn_catg_code' id='pre_pat_alcn_catg_code' value='<%=pre_pat_alcn_catg_code%>' >

	<% 
	}
	if (rs != null) rs.close();
	//if (stmtsd != null) stmtsd.close();
	if (statement != null) statement.close();
	//if (stmtn !=null) stmtn.close();
	if(pstmt_access !=null)pstmt_access.close();
	if(pstmt_label !=null)pstmt_label.close();
	if (cstmt != null) cstmt.close();
	if (statement_bru != null) statement_bru.close();

}catch(Exception e) {
	e.printStackTrace();
}
finally
{
	
	ConnectionManager.returnConnection(con,request);
}

} catch(Exception e){
	e.printStackTrace();
 }


%>
<script>
/*Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659]*/

async function show_order_select(pVal,refno,facilityid,cliniccode,apptstatus){ 
	 
	/*var latter=document.getElementById("results1").rows(u1).cells(3).innerText ; 
	value1=document.forms[0].clinic_code.value;
	value2=document.forms[0].clinic_name.value;
	value3=document.forms[0].pract_id.value;
	value4=document.forms[0].pract_name.value;*/
	value5=document.forms[0].appt_date.value;
	value6= document.getElementById("results1").rows[u1].cells[u2].innerText;	
	var s = value6.substr(0,5); 
	value6 = s;	
	value7=document.getElementById("results1").rows[u1+1].cells[0].innerText;	
	value8=document.forms[0].over_booked.value;
	value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
	value10=document.forms[0].patient_id.value;
	sys_date=document.forms[0].sys_date.value;
	sys_time=document.forms[0].sys_time.value;
	fromtimeharray=sys_time.split(":");
	from_time=value6.split(":");
	to_displayed_time=value7.split(":");
	var fromhtm=new Date(1,1,1,fromtimeharray[0],fromtimeharray[1],0,0);
	var tohtm=new Date(1,1,1,from_time[0],from_time[1],0,0);
	var to_displayed=new Date(1,1,1,to_displayed_time[0],to_displayed_time[1],0,0);
	//var  old_date=document.forms[0].old_date.value;
	//if( old_date.length == 0) document.forms[0].old_date.value=value5;
	
	var Mode="Record";	
	if(!pVal) pVal='NO';	
	if(refno != ""){
		if(DateCompare4(document.forms[0].appt_date ,document.forms[0].sys_date)){									
				if(( Date.parse(fromhtm) >= Date.parse(to_displayed))){					
					Mode="View";
				}else if(apptstatus=="VT"){
				   Mode="View";
				}
    
          }
	}


   
	var retVal		=    new String();
    var dialogHeight= "95vh";	
	var dialogWidth = "70vw";
	var dialogTop	= "70";
	var center		= "1";
	var status		= "no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments   = "" ;
	
	var getUrl = "../../eOR/jsp/ORApptRefCatalogAddModifyView.jsp?appt_ref_no="+refno+"&Mode="+Mode+"&facilityid="+facilityid+"&p_clinic_code="+cliniccode+"";
		
	retVal = await top.window.showModalDialog(getUrl,arguments,features);     
	if(retVal != null && retVal != ""){
	
	}	
	
}
//End this CRF Bru-HIMS-CRF-165.1 [IN:035659]

</script>
</form>
</body>
</html>
<!--Added for this CRF Bru-CRF-177 -->

<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}


%>

