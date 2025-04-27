<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,java.io.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//out.println("sStyle==>" +sStyle);%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<Script src="../../eOA/js/ChangeDate.js" language="JavaScript"></Script>
 <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
 <script language="javascript" src="../../eCommon/js/DateUtils.js"></script> 
<% 
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");

		Connection con = null;
		CallableStatement statement=null;
		CallableStatement statement_bru = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt_label		= null;
		PreparedStatement pstmt_access		= null;

		ResultSet rs = null; 
		ResultSet rs32= null;
		//Statement stmtsd=null;
		Statement stmt=null;
		PreparedStatement stmtps=null;
		Statement stmtn=null;
		ResultSet rsps=null;
		//Statement stmt_visit=null;
		//ResultSet rs_visit=null;
		String wrap_reqd="";
		wrap_reqd="nowrap";
		String temp=request.getQueryString();
		String curr_user_id=(String)session.getValue("login_user");
		String ref_id="";
		ref_id=(String) session.getValue("ref_id");
		if(ref_id==null) ref_id="N";
		String calling_mode=request.getParameter("callingMode");
	

		if(calling_mode==null) calling_mode="N";
		String blkStatus="";
		String blkRemark="";
		String book_appt_yn ="";                  
		String book_appt_wo_pid_yn="";            
		String obook_appt_yn ="";                 
		String book_appt_across_catg_yn  ="";     
		String tfr_appt_yn="";                    
		String tfr_appt_across_catg_yn="";        
		String canc_appt_yn  ="";  
		//String alcn_crit="";
		String sql_access="";
		String mode_find="";
		String inv_visit_mpq_from_ca_yn="";
		boolean allow_revise=true;
		int max_patient			=0;
		int total_booked		=0;
		String nowarp1 ="";
		//jit
		//String holdArr[]=new String[5];
		/*Above line commented and added for thic CRF GHL-CRF-0414*/
		String holdArr[]=new String[6];
		
		ArrayList arrLst=new ArrayList();
		String tmp_Hld_var="";
		String locale = (String)session.getAttribute("LOCALE");

		String TOTAL_NORMAL_TFR="";
		String TOTAL_BULK_TFR="";

		String global_locn_yn="";
		String param_alcn_check="";
		String today_date="";
		String wtListControl=request.getParameter("wtListControl")==null?"":request.getParameter("wtListControl");
		String waitListNo=request.getParameter("waitListNo")==null?"":request.getParameter("waitListNo");
		String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");
		String show_vip="N";
	//Below variable declare for this  [Bru-HIMS-CRF-177]
	//CheckStyle Violation Commented by Munisekhar
	//String colour_indicator="", visite_code="";
	  String colour_indicator="";
	  String max_patients_per_slab="";
	
	//Added for this CRF Bru-HIMS-CRF-191 [IN:030391]		
	 Statement stApptgroup=null;
	 ResultSet rsApptgroup=null;
	 String groupApptYN="";	
	 String entitlement_by_pat_cat_yn	= "";
	 int group_check=0;
	//End Bru-HIMS-CRF-191 [IN:030391]

		int order_clinic_count=	0; //this CRF Bru-HIMS-CRF-165.1 [IN:035659]	

	 boolean isIncRemarksLengthAppl = false;//Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058
	 String apptRemarks = "";
	 
	 boolean isVIPimgpatfrontappl = false;//Added by Mujafar against ML-MMOH-CRF-1070

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

//end
try
{
			con=ConnectionManager.getConnection(request);
              
            isIncRemarksLengthAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA","INCREASE_APPT_REMARKS_LENGTH");//Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058	
			
			isVIPimgpatfrontappl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA","VIP_IMG_PAT_NAME_FRONT_APPL");//Added by Mujafar against ML-MMOH-CRF-1070
			
			isOverBookingAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA","SCH_APPT_OVER_BOOKING");//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017

			isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1

			//stmtsd=con.createStatement();
			stmtn=con.createStatement();
			ResultSet rsCA = null;
			ResultSet rset = null;
			Statement stmt_ca = con.createStatement();
			stmt= con.createStatement();
			String date1="";
			String date=(String)request.getParameter("Date");
			
			String mod=(String)request.getParameter("mod");
			if(mod ==null) mod ="";
			String create_wait_list_yn=request.getParameter("create_wait_list_yn");
			if(create_wait_list_yn ==null) create_wait_list_yn="";
			String clinic_type=request.getParameter("clinic_type");
			String res_type=request.getParameter("res_type");
			String or_catalogue_code=request.getParameter("or_catalogue_code")==null?"":request.getParameter("or_catalogue_code");
			String order_line_num=request.getParameter("order_line_num");
			if(order_line_num ==null) order_line_num="";
			String order_id=request.getParameter("order_id");
			String fcid=(String)session.getValue("facility_id");
			if(order_id ==null) order_id="";
			String order_catalog_code=request.getParameter("order_catalog_code");
			if(order_catalog_code ==null) order_catalog_code="";
			if (clinic_type==null) clinic_type = "C";
			if (res_type==null) res_type = "P";

			String decide=(String)request.getParameter("decide");
				if(decide == null || decide.equals("null")) decide="";

			String currdate=(String)request.getParameter("currdate");
			//String inv_visit_frm_ca="SELECT INV_VISITREGN_MPQ_FROM_CA_YN FROM op_param WHERE OPERATING_FACILITY_ID='"+fcid+"'";
String clinic_code=(String)request.getParameter("clinic_code"); 

			 /*Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659] */
            stApptgroup=con.createStatement();	
			//String oderclinicquery="select count(*) order_count_clinic from op_catalog_for_clinic a where a.facility_id='"+fcid+"' AND a.CLINIC_CODE='"+clinic_code+"'";
			//rsApptgroup=stApptgroup.executeQuery(oderclinicquery);
			String oderclinicquery="select count(*) order_count_clinic from op_catalog_for_clinic a where a.facility_id=? AND a.CLINIC_CODE=?";
			if(stmtps != null) stmtps.close();
			stmtps = con.prepareStatement(oderclinicquery);
			stmtps.setString(1,fcid);
			stmtps.setString(2,clinic_code);
			rsApptgroup = stmtps.executeQuery();
			if(rsApptgroup.next()) {
				order_clinic_count=rsApptgroup.getInt("order_count_clinic");
				
			}
			if(stApptgroup!=null) stApptgroup.close();
			if(rsApptgroup!=null) rsApptgroup.close();
         //End this CRF Bru-HIMS-CRF-165.1 [IN:035659]		

			/*Below line code Added for this CRF  Bru-HIMS-CRF-191 [IN:030391]*/
			
		
			
			stApptgroup=con.createStatement();	
			//String groupApptquery="select count(*) count_value from oa_group_hdr a ,oa_group_dtls b where eff_status='E' and LOCN_CODE='"+clinic_code+"' and a.GROUP_ID=b.GROUP_ID";
			//rsApptgroup=stApptgroup.executeQuery(groupApptquery);
			String groupApptquery="select count(*) count_value from oa_group_hdr a ,oa_group_dtls b where eff_status='E' and LOCN_CODE=? and a.GROUP_ID=b.GROUP_ID";
			if(stmtps != null) stmtps.close();
			stmtps = con.prepareStatement(groupApptquery);
			stmtps.setString(1,clinic_code);
			rsApptgroup = stmtps.executeQuery();
			if(rsApptgroup.next()) {
				group_check=rsApptgroup.getInt("count_value");
				
			}
			System.out.println("group_check==>"+group_check);
			if(stApptgroup!=null) stApptgroup.close();
			if(rsApptgroup!=null) rsApptgroup.close();
			
			//End Bru-HIMS-CRF-191 [IN:030391]		
			

			String inv_visit_frm_ca="select (SELECT INV_VISITREGN_MPQ_FROM_CA_YN FROM op_param WHERE OPERATING_FACILITY_ID='"+fcid+"')INV_VISITREGN_MPQ_FROM_CA_YN ,(select to_char(sysdate,'dd/mm/yyyy') system_date from dual)system_date,ALCN_CRITERIA,group_appt_yn,(select ENTITLEMENT_BY_PAT_CAT_YN from mp_param where module_id='MP')ENTITLEMENT_BY_PAT_CAT_YN from oa_param where module_id='OA'";

			rset=stmtn.executeQuery(inv_visit_frm_ca);
			if(rset!=null && rset.next()){
				inv_visit_mpq_from_ca_yn=rset.getString("INV_VISITREGN_MPQ_FROM_CA_YN");
				today_date = rset.getString("system_date");
				param_alcn_check=rset.getString("ALCN_CRITERIA")==null?"":rset.getString("ALCN_CRITERIA");
				groupApptYN=rset.getString("group_appt_yn")==null?"":rset.getString("group_appt_yn");
				entitlement_by_pat_cat_yn	= rset.getString("entitlement_by_pat_cat_yn")==null?"":rset.getString("entitlement_by_pat_cat_yn");
			}
			if(rset!=null) rset.close();
			if(mod.equals("tfr"))
			{
				date = currdate;
				decide="Query";
			}	
			if(decide.equals("Query"))
	{
//date=DateUtils.convertDate(date,"DMY",locale,"en");
	}
			mode_find=(String)request.getParameter("mode_find");
			if(mode_find==null) mode_find="";
 String from_page=request.getParameter("from_page");
//out.println("from_page==>" +from_page);
if(from_page ==null) from_page="";

			//String inv_visit_mpq_from_ca_yn = request.getParameter("inv_visit_mpq_from_ca_yn")==null?"N":request.getParameter("inv_visit_mpq_from_ca_yn");

			String practitioner_id=(String)request.getParameter("practitioner_id");
				if( practitioner_id == null|| practitioner_id.equals("null")) practitioner_id="";
			String value12=(String)request.getParameter("value12");
				if( value12 == null || value12.equals("null")) value12="";
			String value13=(String)request.getParameter("value13");
			if( value13 == null || value13.equals("null"))  value13="";
			String facilityid=(String)session.getValue("facility_id");
			String pre_pat_alcn_catg_code = request.getParameter("pre_pat_alcn_catg_code");
			if( pre_pat_alcn_catg_code == null) pre_pat_alcn_catg_code="";

			String old_date=(String)request.getParameter("old_date");
				if(old_date  == null || old_date.equals("null")) old_date="";

			String old_from_time = request.getParameter("old_from_time");
				if( old_from_time == null) old_from_time="";

			String old_to_time = request.getParameter("old_to_time");
				if( old_to_time == null) old_to_time="";

			String ca_mode = request.getParameter("ca_mode");
			if(( ca_mode == null) || ca_mode.equals(""))  ca_mode="";
			String ca_patient_id=request.getParameter("ca_patient_id");
				if(ca_patient_id==null) ca_patient_id="";
//out.println("<script>alert('ca_mode :"+ca_mode+"')</script>");
//out.println("<script>alert('ca_patient_id :"+ca_patient_id+"')</script>");
			
			if(!ref_id.equals("N")){		
				session.putValue("ca_patient_id_new",ca_patient_id);
				String ca_patient_id_new=(String)session.getValue("ca_patient_id_new");
				if(ca_patient_id_new.equals(null) ||ca_patient_id_new ==null) ca_patient_id_new="";				
			}

			//Added by Suman
			String callingMode = request.getParameter("callingMode");
			if (callingMode==null) callingMode = "";
			
			String calling_mode_new=(String)session.getValue("callingMode_new");
			if(calling_mode_new ==null) calling_mode_new="";

			String oper_stn_id=request.getParameter("oper_stn_id");
			if(oper_stn_id == null) oper_stn_id="";
			if(oper_stn_id!=null && !oper_stn_id.equals("")){
				show_vip="Y";
			}
			String visit_limit_rule =request.getParameter("visit_limit_rule");
			if(visit_limit_rule == null) visit_limit_rule="";

			String slot_appt_ctrl   =request.getParameter("slot_appt_ctrl");
			if(slot_appt_ctrl == null) slot_appt_ctrl="";

			String alcn_criteria=request.getParameter("alcn_criteria");
			if(alcn_criteria == null || alcn_criteria.equals("null")) alcn_criteria="";	
			
			String override_no_of_slots_yn=request.getParameter("override_no_of_slots_yn");
			if(override_no_of_slots_yn ==null) override_no_of_slots_yn ="";
			
			String req_id=request.getParameter("req_id");
			if(req_id ==null) req_id="";

			String install_yn_val=request.getParameter("install_yn_val");
		if(install_yn_val ==null) install_yn_val="";

			String visit_flag_OP=request.getParameter("visit_flag_OP");
			if(visit_flag_OP==null) visit_flag_OP="N";	

			//Added by suman for getting the value from OP Checkout
		
	String from_facility_id= request.getParameter("from_facility_id");
		if(from_facility_id ==null) from_facility_id="";
		String from_encounter_id= request.getParameter("from_encounter_id");
		if(from_encounter_id ==null) from_encounter_id="";

 String no_of_noshow_appts_for_alert =  request.getParameter("no_of_noshow_appts_for_alert");
  if(no_of_noshow_appts_for_alert ==null) no_of_noshow_appts_for_alert="";

String per_chk_for_no_show_alert    =   request.getParameter("per_chk_for_no_show_alert");
 if(per_chk_for_no_show_alert ==null) per_chk_for_no_show_alert="";



			String capture_fin_dtls_yn=request.getParameter("capture_fin_dtls_yn");
					String contact_num_reqd_yn= request.getParameter("contact_num_reqd_yn");
		if(contact_num_reqd_yn ==null) contact_num_reqd_yn="N"; 
			 String noshow_ctrl_by_splty_or_clinic=request.getParameter("noshow_ctrl_by_splty_or_clinic");
			 if(noshow_ctrl_by_splty_or_clinic ==null) noshow_ctrl_by_splty_or_clinic="";
			 String min_ela_per_resc_noshow_in_day=request.getParameter("min_ela_per_resc_noshow_in_day");
			 if(min_ela_per_resc_noshow_in_day ==null) min_ela_per_resc_noshow_in_day="";
			String res_class_desc="";
	if(res_type.equals("P"))
	{
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	}else if(res_type.equals("E"))
	{
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
	}else if(res_type.equals("R"))
	{
   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
	}else if(res_type.equals("O"))
	{
res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
	}

	/*	if(res_type.equals("P")){
			res_class_desc="Practitioner";
		}else if(res_type.equals("E")){
			res_class_desc="Equipment";
		}else if(res_type.equals("R")){
			res_class_desc="Room";
		}else if(res_type.equals("O")){
			res_class_desc="Others";
		}else if(res_type.equals("B")){
			res_class_desc="Bed";
		}*/
		String care_locn_ind_desc="";
		if(clinic_type.equals("C")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
		}else if(clinic_type.equals("E")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
		}else if(clinic_type.equals("D")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
		}
			// End of the addition	

		String P_O_CLINIC             ="";       
		String P_O_PRACTITIONER       ="";       
		String P_O_MAX_PAT            ="";       
		String P_O_MAX_OVER_BOOK      ="";
		String P_O_MAX_FORCED_BOOK    ="";
		String P_O_FORCED_BOOK		  =""; 	
		String P_O_MAX_GLOBAL_BOOK    ="";
		String P_O_GLOBAL_BOOK		  =""; 	
		String P_O_BOOKED             ="";       
		String P_O_OVER_BOOKED        ="";       
		String P_O_OVER_BOOKING       ="N";       
		String P_O_TIME_TAB_TYPE     ="";        
		String P_O_END_TIME= "";
		String P_O_MAX_SLOTS_FOR_FIRST_VISITS = "";
		String P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED="";
		String P_O_MAX_FIRST_VISITS = "";
		String P_O_TOTAL_FIRST_VISIT = "";
		String P_O_OBVISIT_FLAG = "N";
		String P_O_MAX_SLOTS_PER_DAY="";
		String P_O_MAX_OTHER_VISITS="";
		String P_O_TOTAL_OTHER_VISITS="";
		String P_O_STATUS             ="";
		String P_O_FROM_TIME          ="";
		String P_O_TO_TIME            ="";
		String P_O_APPT_REF_NO        ="";
		String P_O_PATIENT_NAME       ="";
			String P_O_PATIENT_ID       ="";
			String P_LAST_APPT_BOOKED       ="";

			String P_O_VISIT_TYPE_CODE       ="";
			String P_O_REFERRAL_ID       ="";
			String P_O_CONTACT_REASON_CODE       ="";
			String P_O_ENCOUNTER_ID       ="";
			String P_O_SERVICE_CODE      ="";
			String P_O_pat_cat      ="";


			String P_O_VISIT_TYPE_IND     ="";
			String P_O_NO_OF_SLOTS= "";
			String P_O_Max_Forced= "";
			String P_O_Total_Forced= "";
			String P_O_Max_Global= "";
			String P_O_Total_Global= "";

			String sql="";
			String current_date="";
			String current_time="";
			String total_booked1="";
			//String max_patients_per_day="";

			String FORCED_BOOK_APPT_YN="";
			String GLOBAL_BOOK_APPT_YN="";
			PreparedStatement pstmtststus=null;
			ResultSet rsststus=null;
			Statement stmt_date= null;
			String P_APPT_OTH_DTL       ="";

			//ResultSet rs_date=null;
			//ResultSet rs_slot=null;
			//ResultSet rs_slab=null;
			//String sql2="";
			//String time_per_patient="";
			//int noslots =0;
			//int durtime=0;
			//int totaltm=0;
			//int max_pat_per_slab=0;
			//String inner_string = "";
			//String next_string = "";
			//String totm ="";
			//String totm1 = "";
			//String ftime2="";
			//String ttime2="";
			//int ftm1=0;
			//int ttm1=0;
			//int confirsttm=ftm1*60;
			//int totim = 0;
			//int totim1 =0;
			//int frmtime1 =0;
			//int mainfrmtm =0;
			//int totime1 = 0;
			//int maintotm = 0;
			//int dur = 0;
			//int dur1 = 0;
			//String COUNT_VAL="";
			//String sys_time="";
			//String sql1="";
			//String end_time_val="";
			String chk_frm_CA="";
			String clinic_type_frm_CA="";
			boolean normal_booking_allow_flag = true;
			String schedule_status="";

try{
	

		/*stmt_date=con.createStatement();

		rsCA = stmt_date.executeQuery("select to_char(sysdate,'dd/mm/yyyy') system_date from dual");

		if(rsCA !=null && rsCA.next())
		{
			today_date = rsCA.getString("system_date");
		}
		if(rsCA!=null)rsCA.close();		
		*/

		if(callingMode.equals("CA"))
		{
			//chk_frm_CA="select CARE_LOCN_TYPE_IND from op_clinic where clinic_code='"+clinic_code+"' and facility_id='"+facilityid+"'";
			//rsCA = stmt_ca.executeQuery(chk_frm_CA);
			chk_frm_CA="select CARE_LOCN_TYPE_IND from op_clinic where clinic_code=? and facility_id=? ";
			if(stmtps != null) stmtps.close();
			stmtps = con.prepareStatement(chk_frm_CA);
			stmtps.setString(1,clinic_code);
			stmtps.setString(2,facilityid);
			rsCA = stmtps.executeQuery();
			if(rsCA !=null && rsCA.next())
			{
				clinic_type_frm_CA=rsCA.getString("CARE_LOCN_TYPE_IND");
			}
			clinic_type=clinic_type_frm_CA;
		}
		//Allocation for the clinic
		
		/*String param_sql="select ALCN_CRITERIA from oa_param where module_id='OA'";
		if(rs!=null)rs.close();
		rs=stmt.executeQuery(param_sql);
		if(rs!=null && rs.next()){
			param_alcn_check=rs.getString("ALCN_CRITERIA")==null?"":rs.getString("ALCN_CRITERIA");
		}
		if(rs!=null)rs.close();
		*/
		if(!param_alcn_check.equals("")){
			StringBuffer clinic_alcn_sql=new StringBuffer();
			clinic_alcn_sql.append("select alcn_criteria from oa_clinic_schedule where CLINIC_CODE='"+clinic_code+"' AND ");
			if(practitioner_id.equals("")){
				clinic_alcn_sql.append("practitioner_id is null and");
			}else{
				clinic_alcn_sql.append("practitioner_id = '"+practitioner_id+"' and ");
			}
			clinic_alcn_sql.append("clinic_date=to_date('"+date+"','dd/mm/yyyy')");
			
			//NVL (practitioner_id, 'X') = NVL ('"+practitioner_id+"', NVL (practitioner_id, 'X')) and clinic_date=to_date('"+date+"','dd/mm/yyyy')";

		
			if(rs!=null)rs.close();
			rs=stmt.executeQuery(clinic_alcn_sql.toString());
			clinic_alcn_sql=null;
			if(rs!=null && rs.next()){
				alcn_criteria=rs.getString("alcn_criteria")==null?"":rs.getString("alcn_criteria");
			}
			if(rs!=null)rs.close();
		}else{
			alcn_criteria="";
		}
	
	/*if (slot_appt_ctrl.equals("P")){
		alcn_crit="select nvl(max_patients_per_day,0) max_patients_per_day, nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked from oa_clinic_schedule  where facility_id='"+facilityid+"' and clinic_date =to_date('"+date+"','dd/mm/yyyy') and clinic_code='"+clinic_code+"' and Nvl(Practitioner_id,'X') =nvl('"+practitioner_id+"' ,'X') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_type+"'";


		rs = stmtsd.executeQuery(alcn_crit);
		
		if(rs !=null){
			while ( rs.next() ){
					max_patients_per_day= rs.getString("max_patients_per_day");
					if(max_patients_per_day ==null) max_patients_per_day="";
					total_booked1		= rs.getString("total_booked");
					if(total_booked1==null) total_booked1="";

			}
		
		}  
		if(rs !=null) rs.close();

		if (max_patients_per_day.equals(total_booked1))
			normal_booking_allow_flag=false;
	}
	*/

			sql_access="select book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,book_appt_across_catg_yn,tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,FORCED_BOOK_APPT_YN,GLOBAL_BOOK_APPT_YN,global_locn_yn from am_os_user_locn_access_vw  where facility_id=? and locn_code=?  and oper_stn_id=? and appl_user_id=?  and (book_appt_yn='Y' or book_appt_wo_pid_yn='Y' or obook_appt_yn='Y' or book_appt_across_catg_yn='Y' or tfr_appt_yn='Y' or tfr_appt_across_catg_yn='Y' or canc_appt_yn='Y') ";

		
			
			pstmt_access = con.prepareStatement(sql_access);
			
			pstmt_access.setString(1,facilityid);
			pstmt_access.setString(2,clinic_code);
			pstmt_access.setString(3,oper_stn_id);
			pstmt_access.setString(4,curr_user_id);

			rs = pstmt_access.executeQuery();



			if(rs !=null){
			while ( rs.next() )
			{
						book_appt_yn= rs.getString("book_appt_yn");
						if(book_appt_yn ==null) book_appt_yn="";
						book_appt_wo_pid_yn= rs.getString("book_appt_wo_pid_yn");
						if(book_appt_wo_pid_yn==null) book_appt_wo_pid_yn="";
						obook_appt_yn= rs.getString("obook_appt_yn");
						if(obook_appt_yn ==null) obook_appt_yn="";
						book_appt_across_catg_yn= rs.getString("book_appt_across_catg_yn");
						if(book_appt_across_catg_yn ==null) book_appt_across_catg_yn="";
						tfr_appt_yn= rs.getString("tfr_appt_yn");
						if(tfr_appt_yn==null) tfr_appt_yn="";
						tfr_appt_across_catg_yn= rs.getString("tfr_appt_across_catg_yn");
						if(tfr_appt_across_catg_yn ==null) tfr_appt_across_catg_yn="";
						canc_appt_yn= rs.getString("canc_appt_yn");
						if(canc_appt_yn ==null) canc_appt_yn="";
						FORCED_BOOK_APPT_YN= rs.getString("FORCED_BOOK_APPT_YN");
						if(FORCED_BOOK_APPT_YN ==null) FORCED_BOOK_APPT_YN="";
						GLOBAL_BOOK_APPT_YN = rs.getString("GLOBAL_BOOK_APPT_YN");
						if(GLOBAL_BOOK_APPT_YN ==null) GLOBAL_BOOK_APPT_YN="";
						global_locn_yn= rs.getString("global_locn_yn");
						if(global_locn_yn ==null) global_locn_yn="N";
			}
			}
		if(rs !=null) rs.close();


	/*String sqlStat="SELECT NVL(Schedule_status,'A') Schedulestatus,Remarks FROM OA_CLINIC_SCHEDULE WHERE Facility_id=? AND clinic_date=TO_DATE(?,'dd/mm/yyyy') AND clinic_code=? AND nvl(practitioner_id,'x')=nvl(?,'x') and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_type+"'";

	pstmtststus=con.prepareStatement(sqlStat);
	pstmtststus.setString( 1, facilityid);
	pstmtststus.setString( 2, date);
	pstmtststus.setString( 3, clinic_code);
	pstmtststus.setString( 4, practitioner_id);

	rsststus = pstmtststus.executeQuery();
	if(rsststus !=null && rsststus.next())
	{
		blkStatus= rsststus.getString("Schedulestatus");
		blkRemark=rsststus.getString("Remarks");
	} */

//if(rsststus !=null) rsststus.close();




	StringBuffer  sql_label =new StringBuffer();
	
	//sql_label.append("select OP_GET_DESC.OP_CLINIC(FACILITY_ID, CLINIC_CODE,'"+locale+"','1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, practitioner_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2'))  practitioner_name, time_table_type, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, nvl(total_slots_booked,0) total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked,  to_char(start_time,'hh24:mi') start_time, to_char(end_time,'hh24:mi')end_time, nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked, nvl(max_slots_for_first_visit,0) max_slots_for_first_visit, nvl(total_first_visit,0) total_first_visit, nvl(max_other_visits,0) max_other_visits, nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits, nvl(max_first_visits,0) max_first_visits, nvl(max_slots_per_day,0) max_slots_per_day, nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING, nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING, nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED, nvl(total_first_visits_blocked,0) total_first_visits_blocked, nvl(total_other_visits_blocked,0) total_other_visits_blocked ,NVL(Schedule_status,'A') Schedulestatus,Remarks, to_char(sysdate,'dd/mm/yyyy') current_date,to_char(sysdate,'hh24:mi') current_time, TOTAL_NORMAL_TFR, TOTAL_BULK_TFR,nvl(schedule_status,'O') schedule_status,nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked_count  from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_date  =to_date('"+date+"','dd/mm/yyyy') and clinic_code='"+clinic_code+"'  and care_locn_type_ind ='"+clinic_type+"' and resource_class='"+res_type+"'");

	sql_label.append("select OP_GET_DESC.OP_CLINIC(FACILITY_ID, CLINIC_CODE,?,'1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, practitioner_id,?,'2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,?,'2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,?,'2'))  practitioner_name, time_table_type, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, nvl(total_slots_booked,0) total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked,  to_char(start_time,'hh24:mi') start_time, to_char(end_time,'hh24:mi')end_time, nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked, nvl(max_slots_for_first_visit,0) max_slots_for_first_visit, nvl(total_first_visit,0) total_first_visit, nvl(max_other_visits,0) max_other_visits, nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits, nvl(max_first_visits,0) max_first_visits, nvl(max_slots_per_day,0) max_slots_per_day, nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING, nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING, nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED, nvl(total_first_visits_blocked,0) total_first_visits_blocked, nvl(total_other_visits_blocked,0) total_other_visits_blocked ,NVL(Schedule_status,'A') Schedulestatus,Remarks, to_char(sysdate,'dd/mm/yyyy') current_date,to_char(sysdate,'hh24:mi') current_time, TOTAL_NORMAL_TFR, TOTAL_BULK_TFR,nvl(schedule_status,'O') schedule_status,nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked_count,max_patients_per_slab,SCHEDULE_EXTEND_YN  from oa_clinic_schedule where facility_id=? and clinic_date  =to_date(?,'dd/mm/yyyy') and clinic_code=?  and care_locn_type_ind =? and resource_class=? and ");
	
	if(practitioner_id.equals("")){
		sql_label.append("practitioner_id is null ");
	}else{
		sql_label.append("practitioner_id = ?");
	}
	

		pstmt_label = con.prepareStatement(sql_label.toString());

		pstmt_label.setString(1,locale);
		pstmt_label.setString(2,locale);
		pstmt_label.setString(3,locale);
		pstmt_label.setString(4,locale);
		pstmt_label.setString(5,locale);
		pstmt_label.setString(6,facilityid);
		pstmt_label.setString(7,date);
		pstmt_label.setString(8,clinic_code);
		pstmt_label.setString(9,clinic_type);
		pstmt_label.setString(10,res_type);
		if(!practitioner_id.equals("")){
			pstmt_label.setString(11,practitioner_id);
		}

		rs32 = pstmt_label.executeQuery();
		sql_label=null;

		if( rs32 !=null && rs32.next() ){

					P_O_CLINIC			= rs32.getString("clinic_name");
					P_O_PRACTITIONER 	= rs32.getString("practitioner_name");
					if( P_O_PRACTITIONER == null) P_O_PRACTITIONER=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.Notidentified.label","oa_labels");
					P_O_MAX_PAT 		= rs32.getString("max_patients_per_day");
					P_O_TIME_TAB_TYPE    = rs32.getString("time_table_type" );   
					P_O_MAX_OVER_BOOK   =rs32.getString("max_over_booking" );        
					if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";
					
					P_O_MAX_FORCED_BOOK  =rs32.getString("MAX_FORCED_IN_BOOKING");
					if(P_O_MAX_FORCED_BOOK==null)P_O_MAX_FORCED_BOOK="";
					P_O_FORCED_BOOK	=rs32.getString("TOTAL_FORCED_IN_BOOKED");
					if(P_O_FORCED_BOOK==null)P_O_FORCED_BOOK="";

					P_O_MAX_GLOBAL_BOOK  =rs32.getString("MAX_GLOBAL_BOOKING");
					if(P_O_MAX_GLOBAL_BOOK==null)P_O_MAX_GLOBAL_BOOK="";
					P_O_GLOBAL_BOOK	=rs32.getString("TOTAL_GLOBAL_BOOKED");
					if(P_O_GLOBAL_BOOK==null)P_O_GLOBAL_BOOK="";
					blkStatus= rs32.getString("Schedulestatus");
					if(blkStatus ==null) blkStatus="";
					blkRemark=rs32.getString("Remarks");
					if(blkRemark ==null) blkRemark="";

					P_O_BOOKED          =rs32.getString("total_slots_booked" );   
					if( P_O_BOOKED ==null) P_O_BOOKED="";
					P_O_OVER_BOOKED        =rs32.getString( "total_slots_overbooked" );    
					if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";
					P_O_TO_TIME                  =rs32.getString("start_time" );	
					if(P_O_TO_TIME == null) P_O_TO_TIME="";
					P_O_END_TIME = rs32.getString("end_time"); 
					if( P_O_END_TIME == null) P_O_END_TIME="";	

					TOTAL_NORMAL_TFR=rs32.getString("TOTAL_NORMAL_TFR");
					if(TOTAL_NORMAL_TFR ==null) TOTAL_NORMAL_TFR="0";

					TOTAL_BULK_TFR=rs32.getString("TOTAL_BULK_TFR");
					if(TOTAL_BULK_TFR ==null) TOTAL_BULK_TFR="0";

					

					P_O_MAX_SLOTS_FOR_FIRST_VISITS = rs32.getString("max_slots_for_first_visit"); 
					if( P_O_MAX_SLOTS_FOR_FIRST_VISITS == null) P_O_MAX_SLOTS_FOR_FIRST_VISITS="";
					P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED= rs32.getString("total_first_visit_slots_booked"); 
					if( P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED == null) P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED="";
					P_O_MAX_FIRST_VISITS = rs32.getString("max_first_visits"); 
					if( P_O_MAX_FIRST_VISITS == null) P_O_MAX_FIRST_VISITS="";
					P_O_TOTAL_FIRST_VISIT = rs32.getString("total_first_visit"); 
					if( P_O_TOTAL_FIRST_VISIT == null) P_O_TOTAL_FIRST_VISIT="";

					P_O_MAX_OTHER_VISITS = rs32.getString("max_other_visits"); 
					if( P_O_MAX_OTHER_VISITS == null) P_O_MAX_OTHER_VISITS="";
					P_O_TOTAL_OTHER_VISITS = rs32.getString("total_other_visits"); 
					if( P_O_TOTAL_OTHER_VISITS == null) P_O_TOTAL_OTHER_VISITS="";
					P_O_MAX_SLOTS_PER_DAY= rs32.getString("max_slots_per_day"); 
					if( P_O_MAX_SLOTS_PER_DAY== null) P_O_MAX_SLOTS_PER_DAY="";
					current_date=rs32.getString("current_date");
					if(current_date ==null) current_date="";
					current_time=rs32.getString("current_time");
					if(current_time ==null) current_time="";

					total_booked1		= rs32.getString("total_booked_count");					
					if(total_booked1==null) total_booked1="";
					
					max_patients_per_slab		= rs32.getString("max_patients_per_slab");
					if(max_patients_per_slab==null) max_patients_per_slab="";
			
					if (slot_appt_ctrl.equals("P")){

						if (P_O_MAX_PAT.equals(total_booked1))
							normal_booking_allow_flag=false;
					}

					if (P_O_TIME_TAB_TYPE.equals("1") && slot_appt_ctrl.equals("P"))

					P_O_BOOKED = String.valueOf(Integer.parseInt(P_O_TOTAL_FIRST_VISIT)+Integer.parseInt(P_O_TOTAL_OTHER_VISITS)+Integer.parseInt(rs32.getString("total_first_visits_blocked"))+Integer.parseInt(rs32.getString("total_other_visits_blocked")));

					P_O_TOTAL_FIRST_VISIT   = String.valueOf(Integer.parseInt(P_O_TOTAL_FIRST_VISIT)+Integer.parseInt(rs32.getString("total_first_visits_blocked")));
					P_O_TOTAL_OTHER_VISITS  = String.valueOf(Integer.parseInt(P_O_TOTAL_OTHER_VISITS)+Integer.parseInt(rs32.getString("total_other_visits_blocked")));

					schedule_status=rs32.getString("schedule_status");
					if(schedule_status ==null) schedule_status="";

					schedule_extend_yn=rs32.getString("schedule_extend_yn");
					if(schedule_extend_yn==null) schedule_extend_yn="N";

					

					
					

					
			
			// to be removed as there is no relation of Overbooking with time for a current day schedule

			/*if(P_O_TIME_TAB_TYPE.equals("1")){

					sql1="select count(1) count ,to_char(sysdate,'hh24:mi')sys_date from dual where sysdate > =to_date('"+date+" "+P_O_TO_TIME+"','dd/mm/yyyy hh24:mi')";
					rs_date=stmt_date.executeQuery(sql1);


						if(rs_date !=null && rs_date.next()){
							COUNT_VAL=rs_date.getString("count");
							sys_time=rs_date.getString("sys_date");
								
						}


					sql2= "select to_char(TIME_PER_PATIENT,'hh24:mi') TIME_PER_PATIENT from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_date  =to_date('"+date+"','dd/mm/yyyy') and clinic_code='"+clinic_code+"'  and Nvl(Practitioner_id,'X') =nvl('"+practitioner_id+"' ,'X') and care_locn_type_ind ='"+clinic_type+"' and resource_class='"+res_type+"'";

					
					rs_slot=stmt_date.executeQuery(sql2);
					if(rs_slot !=null  && rs_slot.next()){
						time_per_patient=rs_slot.getString("TIME_PER_PATIENT");
					}



						if (rs_slot !=null) rs_slot.close();

			}else {
					if(P_O_TIME_TAB_TYPE.equals("2"))		{
						if(rs_date !=null)rs_date.close();
						sql1="select count(1) count,to_char(sysdate,'hh24:mi')sys_date from dual where sysdate >=to_date('"+date+" "+P_O_END_TIME+"','dd/mm/yyyy hh24:mi')";
						rs_date=stmt_date.executeQuery(sql1);

						if(rs_date !=null && rs_date.next()){
							COUNT_VAL=rs_date.getString("count");
							sys_time=rs_date.getString("sys_date");
						}

						sql2= "select TO_CHAR (TIME_PER_SLAB, 'hh24:mi') TIME_PER_SLAB,MAX_PATIENTS_PER_SLAB from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_date  =to_date('"+date+"','dd/mm/yyyy') and clinic_code='"+clinic_code+"' and Nvl(Practitioner_id,'X') =nvl('"+practitioner_id+"' ,'X') and care_locn_type_ind ='"+clinic_type+"' and resource_class='"+res_type+"'";
						rs_slab=stmt_date.executeQuery(sql2);
						
						if(rs_slab !=null  && rs_slab.next()) 	{
							time_per_patient=rs_slab.getString("TIME_PER_SLAB");
							max_pat_per_slab=rs_slab.getInt("MAX_PATIENTS_PER_SLAB");
						}
						//out.println("sql2 :" +sql2);
						if(rs_slab !=null)rs_slab.close();
						sql2= "SELECT  to_char(SLOT_SLAB_END_TIME,'hh24:mi')  end_time FROM oa_clinic_schedule_slot_slab WHERE facility_id = '"+facilityid+"'  AND CLINIC_DATE = TO_DATE ('"+date+"', 'dd/mm/yyyy')  AND clinic_code = '"+clinic_code+"'  AND NVL (practitioner_id, 'X') = NVL ('"+practitioner_id+"', 'X') AND care_locn_type_ind = '"+clinic_type+"' AND resource_class ='"+res_type+"' AND to_char(SLOT_SLAB_END_TIME,'hh24:mi') <= to_char(sysdate,'hh24:mi')";
						rs_slab=stmt_date.executeQuery(sql2);
						//out.println("sql2 1:" +sql2);
						if(rs_slab !=null  )			{
							while ( rs_slab.next())				{
								end_time_val=rs_slab.getString("end_time");
							}

						}
							sys_time=end_time_val;

					}else{

						if(P_O_TIME_TAB_TYPE.equals("3")){
							String	et=P_O_END_TIME;
							boolean b=false,result=false;
							String from_time1="";
							String end_time1="";
							stmt=con.createStatement();
							String qry="SELECT to_char(APPT_SLAB_FROM_TIME,'hh24:mi') start_time,to_char(APPT_SLAB_TO_TIME,'hh24:mi') end_time,to_char(sysdate,'hh24:mi') FROM oa_appt WHERE facility_id = '"+facilityid+"'   AND appt_date = TO_DATE ('"+date+"', 'dd/mm/yyyy')   AND clinic_code = '"+clinic_code+"'   AND NVL (practitioner_id, 'X') = NVL ('"+practitioner_id+"', 'X')   AND care_locn_type_ind = '"+clinic_type+"'   AND resource_class = '"+res_type+"'   AND to_char(APPT_SLAB_FROM_TIME,'hh24:mi') >= to_char(sysdate,'hh24:mi')";
							rs=stmt.executeQuery(qry);
							b=rs.next();

				
							while(b){
								end_time1=rs.getString("end_time");
								b=rs.next();
								if (!b) break; 
								from_time1=rs.getString("start_time");
								if (end_time1.equals(from_time1)){
									result=true;
								}else{
									result=false;
									break;
								}
							}

							if (result && end_time1.equals(et) ) {
								P_O_OVER_BOOKING         ="Y";
								P_O_OBVISIT_FLAG		 ="F";
							}else{
							}
						}
					}
			}
		//sys_time="10:50";
		StringTokenizer duration = new StringTokenizer(sys_time, ":");
			if(duration.hasMoreTokens())
			{
				 inner_string = duration.nextToken();
				 next_string = duration.nextToken();
				
				 dur = Integer.parseInt(inner_string);
				 dur1 = Integer.parseInt(next_string);
					

				StringTokenizer duration2 = new StringTokenizer(P_O_END_TIME, ":");
				if(duration2.hasMoreTokens())
				{
					 totm = duration2.nextToken();
					 totm1 = duration2.nextToken();
					 totim = Integer.parseInt(totm);
					 totim1 = Integer.parseInt(totm1);


					 frmtime1 = dur*60;
					 mainfrmtm = frmtime1+dur1;
					 totime1 = totim*60;
					 maintotm = totime1+totim1;

					durtime = maintotm - mainfrmtm;

			
					StringTokenizer duration3 = new StringTokenizer(time_per_patient, ":");
					if(duration3.hasMoreTokens())
					{
						 ftime2=duration3.nextToken();
						 ttime2=duration3.nextToken();

						 ftm1=Integer.parseInt(ftime2);
						 ttm1=Integer.parseInt(ttime2);


						 confirsttm=ftm1*60;
						 totaltm = confirsttm + ttm1;


						 noslots = durtime/totaltm;

					}	
				}
			}
			int total_slots=0;
		 
		if(P_O_TIME_TAB_TYPE.equals("2")){
			total_slots = noslots*max_pat_per_slab;
		}
		*/

		// end the  removal part
		
		//Added by Ashwini on 27-May-2020 for MOHE-CRF-0017
		time_elapsed_yn = eOA.OACommonBean.getTimeElapsedYN(con,P_O_END_TIME,current_time);
		sch_cnt = eOA.OACommonBean.getScheduleCount(con,clinic_code,practitioner_id,facilityid,P_O_TO_TIME);
		
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
								future_slot_count = eOA.OACommonBean.getFutureSlotCount(con,clinic_code,practitioner_id,facilityid,P_O_TO_TIME,P_O_END_TIME);
								
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

		if (!visit_limit_rule.equals("N"))	{
						
				if(! P_O_MAX_FIRST_VISITS.equals("") &&  !P_O_TOTAL_FIRST_VISIT.equals("") && !P_O_MAX_OVER_BOOK.equals("") && !P_O_OVER_BOOKED.equals(""))	{

						if (Integer.parseInt(P_O_MAX_FIRST_VISITS) <= Integer.parseInt(P_O_TOTAL_FIRST_VISIT)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED)&&Integer.parseInt(P_O_MAX_FIRST_VISITS)>0){
								
								P_O_OVER_BOOKING         ="Y";
								P_O_OBVISIT_FLAG		 ="F";
						}
				}
						
				if(! P_O_MAX_OTHER_VISITS.equals("") &&  !P_O_TOTAL_OTHER_VISITS.equals("") && !P_O_MAX_OVER_BOOK.equals("") && !P_O_OVER_BOOKED.equals("")){
								
						if (Integer.parseInt(P_O_MAX_OTHER_VISITS) <= Integer.parseInt(P_O_TOTAL_OTHER_VISITS)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED)&&Integer.parseInt(P_O_MAX_OTHER_VISITS)>0){
									P_O_OVER_BOOKING         ="Y";
									if(P_O_OBVISIT_FLAG.equals("F"))
										P_O_OBVISIT_FLAG		 ="A";
									else
										P_O_OBVISIT_FLAG		 ="O";

						}
				}			
		}
				
		if(! P_O_MAX_PAT.equals("") &&  !P_O_BOOKED.equals("") && !P_O_MAX_OVER_BOOK.equals("") && !P_O_OVER_BOOKED.equals(""))	{
					
				if (Integer.parseInt(P_O_MAX_PAT) == Integer.parseInt(P_O_BOOKED)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED)){
							P_O_OVER_BOOKING         ="Y";
							P_O_OBVISIT_FLAG		 ="A";
				}

				// to be removed as there is no relation of Overbooking with time for a current day schedule
				/*if(COUNT_VAL.equals("1")){

						if(noslots == Integer.parseInt(P_O_BOOKED) &&  P_O_TIME_TAB_TYPE.equals("1") && Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED))	{

							P_O_OVER_BOOKING         ="Y";
							P_O_OBVISIT_FLAG		 ="A";
						}
						
						if(P_O_TIME_TAB_TYPE.equals("2") && total_slots == Integer.parseInt(P_O_BOOKED) && Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED) )	{
							P_O_OVER_BOOKING         ="Y";
							P_O_OBVISIT_FLAG		 ="A";
						}
						
				}*/

					
		}
}

String  over_booked_label="";
over_booked_label=P_O_OVER_BOOKING;

if(blkStatus.equals("B")){
	P_O_OVER_BOOKING="N";
}
	if(rs32 !=null) rs32.close();%>
		<html>
		<head>		
	</head>
			<script src="../../eOP/js/ManageSPatQueue.js"></script>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



				<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script>
	async function call_visit_regn(patient,q_appt_ref_no,referral_id,q_clinic_code,q_clinic_type,q_appt_time,q_visit_adm_type,q_practitioner_id,contact_reason_code,reason,service_code)
	{	
		if(referral_id == "~")
			referral_id='';
		if(service_code == 'null' || service_code == "~")
			service_code='';
			
		var dialogHeight= "46" ;
		var dialogWidth = "70" ;
		var dialogTop 	= "85";
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var retval=await  window.showModalDialog("../../eOP/jsp/VisitRegistration.jsp?menu_id=OP&module_id=OP&function_id=VISIT_REGISTRATION&function_name=Register Visit&function_type=F&access=NYNNN&patient="+patient+"&q_appt_ref_no="+q_appt_ref_no+"&referral_id="+referral_id+"&q_clinic_code="+q_clinic_code+"&q_locn_type="+q_clinic_type+"&q_visit_adm_type="+q_visit_adm_type+"&q_Appt_time="+q_appt_time+"&q_practitioner_id="+q_practitioner_id+"&contact_reason_code="+contact_reason_code+"&reason="+reason+"&call_from=CA&service_code="+service_code+"&resource_class="+document.forms[0].res_type.value,arguments,features);


		if(retval == 'Y')
			document.location.reload();
	}

	function call_patient_chart(encounter_id)
	{	
			var HTMLVal  = "<html>";
			HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '../../eCA/jsp/OpenChartWrapper.jsp' method='post' target='messageFrame' >";
			HTMLVal  += "<input type='hidden' name='encounter_id' id='encounter_id' value='" + encounter_id + "'>";
			HTMLVal  += "<input type='hidden' name='from_module' id='from_module' value='AE'>";
			HTMLVal  += "<input type='hidden' name='from_service_yn' id='from_service_yn' value='Y'>";
			HTMLVal  += "</form>";
			HTMLVal  += "</html>";
			//This is commented on 03/07/09 bcoz getting script errors from CA when we click on the patient_id hyperlink in schedule appointments
		 	/*parent.parent.parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);	
			parent.parent.parent.parent.messageFrame.document.OpenChartWrapperForm.submit();*/
			parent.parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);	
			parent.parent.parent.messageFrame.document.OpenChartWrapperForm.submit()
			
	}

</script>

<body onLoad='visiblelity()' OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onscroll="scrollheader();scrollTitle();">

<form name="single_pract" id="single_pract">
	<input type='hidden' name='help_function_id' id='help_function_id' value='SCHEDULE_APPOINTMENT'>	

	<%
	if(P_O_MAX_PAT==null || P_O_MAX_PAT.equals(""))
{
		date1=DateUtils.convertDate(date,"DMY","en",locale);
		%>
		<script>			
		var msg = getMessage('SCH_NOT_DEFINED_FOR_CLINIC','OA'); 
		alert(msg +' <%=date1%>');
		parent.frames[0].document.location.href='../../eCommon/html/blank.html';
		parent.frames[1].document.location.href='../../eCommon/html/blank.html';
		</script>
	<%if(decide!=null && decide.equals("Query"))
	{%>
		<script>
		parent.frames[0].document.location.href='../../eCommon/html/blank.html';
		</script>
	<%
	}
}else{
	if( P_O_CLINIC.length() !=0) {
	  
	/*Below line added for this CRF ML-MMOH-CRF-0606*/
	  String Tablewidth="100%";	  
	  if(mod!=null && mod.equals("tfr")) {
			Tablewidth="108%";
	  }	 
	//End this CRF ML-MMOH-CRF-0606
	
	%>


	<div id="labeldiv2" style="visibility:visible;backgroundColor:white;overflow:scroll">
	<!--
	<table width='100%' cellspacing='0' cellpadding='0' border='0'>
	-->
	<!--Above line commented and below line added for this CRF ML-MMOH-CRF-0606-->
	<table width='<%=Tablewidth%>' cellspacing='0' cellpadding='0' border='0'>
	<!--End this CRF ML-MMOH-CRF-0606-->
			
			<tr>
			<td  class='label' <%=wrap_reqd%> ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='fields' <%=wrap_reqd%> width='50%'><b><%=care_locn_ind_desc%>/<%=P_O_CLINIC %></b>
			</td>
			<%if(!alcn_criteria.equals("")){ %>
				<td class='label' width='30%'><a href="javascript:allocationDetails('<%=clinic_code%>','<%=date%>','<%=practitioner_id%>')"><b><fmt:message key="eOA.Allocation.label" bundle="${oa_labels}"/></b></a></td>
			<%}else{%>
				<td class='label' width='30%'>&nbsp;</td>
			<%}%>
			

			<td colspan = 1 class='label'  align=center >
					<%if(decide.equals("Query")){
			}else{
				if(mod!=null && mod.equals("tfr")){%>
				
					<%}else{
						if(P_O_OVER_BOOKING.equals("Y") && global_locn_yn.equals("N")){
							
							if((calling_mode.equals("")) || (((calling_mode).equals("OP") || (calling_mode).equals("OP_RV"))&& (ref_id.equals("N"))) || (calling_mode.equals("CA") || (calling_mode.equals("OR")))) {
								%>
						
							<a href='javascript:moveNextlabels()'>
							<b><fmt:message key="eOA.overbooking.label" bundle="${oa_labels}"/></b></a><input type='hidden' name='dummy' id='dummy' > <!--/td-->
					<% } %>	
						
				<%}else{%>
					
				<%}	
			}
		}
		%>
		&nbsp;</td>

			</tr>

			<tr>

			<td  class='label' <%=wrap_reqd%>><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
			<td  class='fields' <%=wrap_reqd%> width='50%'><b><%=res_class_desc%>/<%=P_O_PRACTITIONER %></b></td>

			<td class='label' width='30%'>&nbsp;</td>
			<td class='label'>&nbsp;</td>
			</tr>

	<tr><td class='DEFAULTBLANKROW2PT'  colspan=4>&nbsp;</td></tr>
	</table>		

	<!--
	<table width='100%' cellspacing='0' cellpadding='0' border='0'>
	-->
	<!--Above line commented and below line added for this CRF ML-MMOH-CRF-0606-->	
	<table width='<%=Tablewidth%>' cellspacing='0' cellpadding='0' border='0'>
	<!--End this CRF ML-MMOH-CRF-0606-->
	
	<tr>
	<td>
	
	<table width='100%' cellspacing='0' cellpadding='0' border='1'>

	<tr>
	
	<td class='label' width="2%">&nbsp;</td>
	<td class='label' align='middle'>
	<%if (P_O_TIME_TAB_TYPE.equals("1") && slot_appt_ctrl.equals("S")){%>
		<b><fmt:message key="Common.Slot.label" bundle="${common_labels}"/></b>
	<%}else{%>
		<b><fmt:message key="Common.patient.label" bundle="${common_labels}"/></b>
	<%}%>
	</td>	
	<td class='label' align='middle'  <%=wrap_reqd%>><b><fmt:message key="Common.firstvisit.label" bundle="${common_labels}"/></b></td>
	<td class='label' align='middle'  <%=wrap_reqd%>><b><fmt:message key="Common.othervisit.label" bundle="${common_labels}"/></b></td>
	<td class='label' align='middle'  <%=wrap_reqd%>><b><fmt:message key="eOA.overbooking.label" bundle="${oa_labels}"/></b></td>
	<td class='label' align='middle'  <%=wrap_reqd%>><b><fmt:message key="eOA.Global.label" bundle="${oa_labels}"/></b></td>
	<%if (!P_O_TIME_TAB_TYPE.equals("3")){%>
	<td class='label' align='middle'  <%=wrap_reqd%>>
		<b><fmt:message key="eOA.Forced.label" bundle="${oa_labels}"/></b>
	</td>
	<%}%>	
	<!--Below line Modified for this CRF ML-MMOH-CRF-0606-->	
    <!--Below line Modified for this CRF ML-MMOH-CRF-0609 by Mano-->
	<td class='label' align='middle'  <%=wrap_reqd%>><b><fmt:message key="eOA.NormalReschedule.label" bundle="${oa_labels}"/>&nbsp;<fmt:message key="Common.count.label" bundle="${common_labels}"/></b></td>
	<td class='label' align='middle'  <%=wrap_reqd%>><b><fmt:message  key="eOA.BulkReschedule.label" bundle="${oa_labels}"/>&nbsp;<fmt:message key="Common.count.label" bundle="${common_labels}"/></b></td>
	<!--End this CRF ML-MMOH-CRF-0609-->
	<!--End this CRF ML-MMOH-CRF-0606-->
	
	</tr>
	
	<tr>
	<td class='label' width="2%" <%=wrap_reqd%>><b><fmt:message key="Common.maximum.label" bundle="${common_labels}"/></b></td>
	<td class='label' align='middle' <%=wrap_reqd%>>
	<%if (P_O_TIME_TAB_TYPE.equals("1") && slot_appt_ctrl.equals("S")){%>
		<b><%=P_O_MAX_SLOTS_PER_DAY%></b>
	<%}else{%>
		<b><%=P_O_MAX_PAT%></b>
	<%}%>
	</td>	
	<td class='label' align='middle' <%=wrap_reqd%>>
		<%if(P_O_MAX_FIRST_VISITS.equals("0")){%>
				&nbsp;
			<%}else{%>
				<b><%=P_O_MAX_FIRST_VISITS%></b>
			<%}%></td>
	<td class='label' align='middle' <%=wrap_reqd%>>
				<%if(P_O_MAX_OTHER_VISITS.equals("0")){%>
				&nbsp;
			<%}else{%>
				<b><%=P_O_MAX_OTHER_VISITS%></b>
			<%}%>
	</td>
	<td class='label' align='middle' <%=wrap_reqd%>><b><%=P_O_MAX_OVER_BOOK%></b></td>

	<td class='label' align='middle' <%=wrap_reqd%>><b><%=P_O_MAX_GLOBAL_BOOK%></b> </td>
	<%if (!P_O_TIME_TAB_TYPE.equals("3")){%>
	<td class='label' align='middle' <%=wrap_reqd%>>
		<b><%=P_O_MAX_FORCED_BOOK%></b>
	</td>
	<%}%>	
		
	<td class='label' >&nbsp;</td>
	<td class='label' >&nbsp;</td>

	</tr>

	<tr>
	<td class='label' width="2%" <%=wrap_reqd%>><b><fmt:message key="Common.booked.label" bundle="${common_labels}"/></b></td>
	<td class='label' align='middle'><b><%=P_O_BOOKED%></b></td>	
	<td class='label' align='middle'><b><%=P_O_TOTAL_FIRST_VISIT%></b></td>
	<td class='label' align='middle'><b><%=P_O_TOTAL_OTHER_VISITS%></b></td>
	<td class='label' align='middle'><b><%=P_O_OVER_BOOKED%></b></td>
	<td class='label' align='middle'><b><%=P_O_GLOBAL_BOOK%></b></td>
	<%if (!P_O_TIME_TAB_TYPE.equals("3")){%>
	<td class='label' align='middle'>
		<b><%=P_O_FORCED_BOOK%></b>
	</td>
	<%}%>
		
	<td class='label' >&nbsp;</td>
	<td class='label' >&nbsp;</td>

	</tr>

	   
	 </tr> <!-- </table>
	<table width='80%' cellspacing='0' cellpadding='0' border='0'>  -->
	<tr>
	    <!--Below line Modified for this CRF ML-MMOH-CRF-0606-->
		<td class='label' nowrap width='2%'>&nbsp;</td>
		
		<td class='label' >&nbsp;</td>
		<td class='label' >&nbsp;</td>
		<td class='label' >&nbsp;</td>
		<td class='label' >&nbsp;</td>
		<td class='label' >&nbsp;</td>
		<%if (!P_O_TIME_TAB_TYPE.equals("3")){%>
			<td class='label' >&nbsp;</td>
		<%}%>
		 	
		<td class='label' ><b><%=TOTAL_NORMAL_TFR%></b></td>
		<td class='label' ><b><%=TOTAL_BULK_TFR%></b></td>
			
		<!-- <td colspan = '4' class='label'  align=center> </td> -->
		
		</tr>
		</table>
		</td>
		</tr>
		</table>
		</div>
	<!-- <div id='header' style="visibility:visible;backgroundColor:white;overflow:scroll"> -->
	<br>

	<table border="1" width="100%" cellspacing='0' cellpadding='0' id='results1'>
	<th align='left' width='4%'><div  id='head1'  class='myClass' nowrap ><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></div></th>
	<th align='left' width='4%'><div  id='head2'  class='myClass' nowrap ><fmt:message key="Common.totime.label" bundle="${common_labels}"/></div></th>
	<!--Added for the CRF Bru-HIMS-CRF-172  -->
	<th align='left' width='4%'><div  id='head11'  class='myClass' wrap ><fmt:message key="Common.isinpatient.label" bundle="${common_labels}"/></div></th>
	<th align='left' width='21%'><div  id='head3'  class='myClass' nowrap ><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></div></th>
	<th align='left' width='6%' ><div  id='head4'  class='myClass' nowrap ><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></div></th>
	<!--Below line added for this CRF GHL-CRF-0414 -->
	<th align='left' width='6%' ><div  id='head13'  class='myClass' nowrap ><fmt:message key="Common.Visit.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></div></th>
	<!--End GHL-CRF-0414 -->
	<th align='left' width='13%' ><div  id='head5'  class='myClass' nowrap ><fmt:message key="Common.ReasonForContact.label" bundle="${common_labels}"/></div></th>
	<th align='left' width='12%'><div  id='head6'  class='myClass' nowrap ><fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/></div></th>
	<th align='left' width='12%'><div  id='head7'  class='myClass' nowrap ><fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/></div></th>

   <!--Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659]   -->
    <th align='left' width='12%'><div  id='head12'  class='myClass' nowrap ><fmt:message key="Common.Order.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Selection.label" bundle="${common_labels}"/></div></th>
  <!-- End this CRF Bru-HIMS-CRF-165.1 [IN:035659]  -->

	<!--Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058 Start-->
	<% if(isIncRemarksLengthAppl){ %>
		<th align='left' width='12%'><div  id='head14'  class='myClass' nowrap ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></div></th>
	<% } %>
	<!--End-->
	<%
		
if(decide.equals("Query"))
{ 
nowarp1="nowrap";
%>
	<th align='left' width='11%' ><div  id='head8'  class='myClass' nowrap ><fmt:message key="eOA.ApptGivenBy.label" bundle="${oa_labels}"/></div></th>
	<th align='left' width='11%' ><div  id='head10'  class='myClass' nowrap ><fmt:message key="eAM.PatInstructions.label" bundle="${am_labels}"/></div></th>
	<th align='left' width='12%' ><div  id='head9'  class='myClass' nowrap ><fmt:message key="eOA.ApptGivenOn.label" bundle="${oa_labels}"/></div></th>	
<%
}

%>
<!-- </table></div>	<table border="1" width="100%" cellspacing='0' cellpadding='0' id='results'> -->
		
		
<%}
}
	System.err.println("<-------------------------------DisplayResults.jsp------------------------------->");
	System.err.println("Before execute oa_external_slots_BRU---in Param---facilityid-->"+facilityid+"  clinic_code-->"+clinic_code+"  practitioner_id-->"+practitioner_id+"  date-->"+date);

	/* Added for ML-BRU-CRF-0628.1 */
	if(isSlotStartMidEndAppl){
		cstmt = con.prepareCall("{call oa_external_slots_BRU(?,?,?,?,?,?,?,?,?)}");
		cstmt.setString( 1, facilityid );
		cstmt.setString( 2, clinic_code );
		cstmt.setString( 3, practitioner_id );
		cstmt.setString( 4, date );
		cstmt.registerOutParameter( 5, Types.VARCHAR );
		cstmt.registerOutParameter( 6, Types.VARCHAR );
		cstmt.registerOutParameter( 7, Types.VARCHAR );
		cstmt.registerOutParameter( 8, Types.VARCHAR );
		cstmt.registerOutParameter( 9, Types.VARCHAR );

		cstmt.execute() ;

		System.err.println("After execute oa_external_slots_BRU---in Param---facilityid-->"+facilityid+"  clinic_code-->"+clinic_code+"  practitioner_id-->"+practitioner_id+"  date-->"+date);

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

	if(isSlotStartMidEndAppl && P_O_TIME_TAB_TYPE.equals("2") && !max_patients_per_slab.equals("1")){
		
		System.err.println("Before execute oa_slabs_BRU---in Param---facilityid-->"+facilityid+"  clinic_code-->"+clinic_code+"  practitioner_id-->"+practitioner_id+"  date-->"+date);

		statement_bru = con.prepareCall("{call oa_slabs_BRU(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

		statement_bru.setString( 1, facilityid);
		statement_bru.setString( 2, clinic_code);
		statement_bru.setString( 3, practitioner_id);
		statement_bru.setString( 4, date);
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

		tmp_Hld_var = statement_bru.getString(9); 
		if( tmp_Hld_var == null) tmp_Hld_var="";
		holdArr[0]=tmp_Hld_var;

		tmp_Hld_var = statement_bru.getString(10); 
		if( tmp_Hld_var == null) tmp_Hld_var="";
		holdArr[1]=tmp_Hld_var;

		tmp_Hld_var = statement_bru.getString(12); 
		if( tmp_Hld_var == null) tmp_Hld_var="";
		holdArr[2]=tmp_Hld_var;

		tmp_Hld_var = statement_bru.getString(17); 
		if( tmp_Hld_var == null) tmp_Hld_var="";
		holdArr[3]=tmp_Hld_var;

		tmp_Hld_var = statement_bru.getString(13); 
		if( tmp_Hld_var == null) tmp_Hld_var="";
		holdArr[4]=tmp_Hld_var;

		P_O_VISIT_TYPE_IND = statement_bru.getString(14); 
		if( P_O_VISIT_TYPE_IND == null) P_O_VISIT_TYPE_IND="";
		holdArr[5]=P_O_VISIT_TYPE_IND;

		P_O_PATIENT_ID = statement_bru.getString(15); 
		if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";

		P_LAST_APPT_BOOKED = statement_bru.getString(16); 
		if( P_LAST_APPT_BOOKED == null) P_LAST_APPT_BOOKED="";

		P_O_VISIT_TYPE_CODE = statement_bru.getString(11); 
		if( P_O_VISIT_TYPE_CODE == null) P_O_VISIT_TYPE_CODE="";

		P_O_REFERRAL_ID = statement_bru.getString(18); 
		if( P_O_REFERRAL_ID == null) P_O_REFERRAL_ID="";

		P_O_CONTACT_REASON_CODE = statement_bru.getString(19); 
		if( P_O_CONTACT_REASON_CODE == null) P_O_CONTACT_REASON_CODE="";

		P_O_ENCOUNTER_ID = statement_bru.getString(20); 
		if( P_O_ENCOUNTER_ID == null) P_O_ENCOUNTER_ID="";

		P_O_SERVICE_CODE = statement_bru.getString(21); 
		if( P_O_SERVICE_CODE == null) P_O_SERVICE_CODE="";

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
	
	System.err.println("Before execute get_day_status---in Param---facilityid-->"+facilityid+"  date-->"+date+"  clinic_code-->"+clinic_code+"  practitioner_id-->"+practitioner_id+"  clinic_type-->"+clinic_type+"  res_type-->"+res_type);

	statement=con.prepareCall("{call oa_schedules.get_day_status( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");


	statement.setString( 1, facilityid);
	statement.setString( 2, date);
	statement.setString( 3, clinic_code);
	statement.setString( 4, practitioner_id);
	statement.setString( 5, clinic_type);
	statement.setString( 6, res_type);


	statement.registerOutParameter(7, Types.VARCHAR );
	statement.registerOutParameter(8, Types.VARCHAR );
	
	/*statement.registerOutParameter(7, Types.CLOB );
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
	
	/*statement.registerOutParameter(13, Types.CLOB );
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
	statement.setString(34, locale);

	statement.registerOutParameter(35 ,Types.VARCHAR );
	statement.registerOutParameter(36 ,Types.VARCHAR );
	statement.registerOutParameter(37 ,Types.VARCHAR );
	statement.registerOutParameter(38 ,Types.VARCHAR );
	statement.registerOutParameter(39 ,Types.VARCHAR );
	statement.registerOutParameter(40 ,Types.VARCHAR );
	statement.registerOutParameter(41 ,Types.VARCHAR );

	/*statement.registerOutParameter(35 ,Types.CLOB );
	statement.registerOutParameter(36 ,Types.CLOB );
	statement.registerOutParameter(37 ,Types.CLOB );
	statement.registerOutParameter(38 ,Types.CLOB );
	statement.registerOutParameter(39 ,Types.CLOB );
	statement.registerOutParameter(40 ,Types.CLOB );
	*/


	statement.execute() ;

	System.err.println("After execute get_day_status---in Param---facilityid-->"+facilityid+"  date-->"+date+"  clinic_code-->"+clinic_code+"  practitioner_id-->"+practitioner_id+"  clinic_type-->"+clinic_type+"  res_type-->"+res_type);

	System.err.println("<--------DisplayResults.jsp----1506---->");

	P_O_CLINIC=statement.getString( 7 ); 
	if(P_O_CLINIC == null) P_O_CLINIC="";

	P_O_PRACTITIONER=statement.getString( 8 ); 
	if(P_O_PRACTITIONER == null) P_O_PRACTITIONER="";

	P_O_MAX_PAT=statement.getString( 9 ); 
	if(P_O_MAX_PAT == null) P_O_MAX_PAT="";

	P_O_MAX_OVER_BOOK     =statement.getString( 10 );        
	if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";

	P_O_BOOKED                 =statement.getString(11 );   
	if( P_O_BOOKED ==null) P_O_BOOKED="";

	P_O_OVER_BOOKED        =statement.getString( 12 );    
	if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";

	P_O_OVER_BOOKING        =statement.getString( 13 );
	if(P_O_OVER_BOOKING == null) P_O_OVER_BOOKING="";

	P_O_TIME_TAB_TYPE          =statement.getString( 14 );
	if(P_O_TIME_TAB_TYPE == null) P_O_TIME_TAB_TYPE="";

	P_O_STATUS                    =statement.getString(15);
	if(P_O_STATUS == null) P_O_STATUS="";

	P_O_FROM_TIME            =statement.getString( 16 );     
	if(P_O_FROM_TIME == null) P_O_FROM_TIME="";

	P_O_TO_TIME              =statement.getString( 17 );	
	if(P_O_TO_TIME == null) P_O_TO_TIME="";

	P_O_APPT_REF_NO         =statement.getString(18 );     
	if(P_O_APPT_REF_NO ==null) P_O_APPT_REF_NO="";

	P_O_PATIENT_NAME        =statement.getString( 19 );     
	if(P_O_PATIENT_NAME ==null) P_O_PATIENT_NAME="";

	tmp_Hld_var                       =statement.getString( 20 );	
	if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[0]=tmp_Hld_var;

	tmp_Hld_var                    =statement.getString( 21 );
	if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[1]=tmp_Hld_var;

	tmp_Hld_var    =statement.getString( 22 );     
	if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[2]=tmp_Hld_var;

	tmp_Hld_var                =statement.getString( 23 );	
	if(tmp_Hld_var ==null) tmp_Hld_var="";
	holdArr[3]=tmp_Hld_var;

	tmp_Hld_var       =statement.getString( 24 );	
	if(tmp_Hld_var == null) tmp_Hld_var="";
	holdArr[4]=tmp_Hld_var;

	P_O_END_TIME = statement.getString(25); 
	if( P_O_END_TIME == null) P_O_END_TIME="";

	P_O_VISIT_TYPE_IND = statement.getString(26); 
	if( P_O_VISIT_TYPE_IND == null) P_O_VISIT_TYPE_IND="";
	holdArr[5]=P_O_VISIT_TYPE_IND; //Added for this CRF GHL-CRF-0414

	P_O_NO_OF_SLOTS = statement.getString(27); 
	if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";

	P_O_Max_Forced=statement.getString(28); 
	if( P_O_Max_Forced == null) P_O_Max_Forced="";

	P_O_Total_Forced=statement.getString(29); 
	if( P_O_Total_Forced == null) P_O_Total_Forced="";

	P_O_Max_Global=statement.getString(30);
	if( P_O_Max_Global == null) P_O_Max_Global="";

	P_O_Total_Global=statement.getString(31); 
	if( P_O_Total_Global == null) P_O_Total_Global="";

	P_O_PATIENT_ID=statement.getString(32); 
	if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";

	P_LAST_APPT_BOOKED=statement.getString(33); 
	if( P_LAST_APPT_BOOKED == null) P_LAST_APPT_BOOKED="";

	P_O_VISIT_TYPE_CODE = statement.getString(35);
	if( P_O_VISIT_TYPE_CODE == null) P_O_VISIT_TYPE_CODE="";

	P_O_REFERRAL_ID = statement.getString(36); 
	if( P_O_REFERRAL_ID == null) P_O_REFERRAL_ID="";

	P_O_CONTACT_REASON_CODE = statement.getString(37);
	if( P_O_CONTACT_REASON_CODE == null) P_O_CONTACT_REASON_CODE="";

	P_O_ENCOUNTER_ID = statement.getString(38); 
	if( P_O_ENCOUNTER_ID == null) P_O_ENCOUNTER_ID="";

	P_O_SERVICE_CODE = statement.getString(39); 
	if( P_O_SERVICE_CODE == null) P_O_SERVICE_CODE="";

	P_APPT_OTH_DTL= statement.getString(40); 
	if( P_APPT_OTH_DTL == null) P_APPT_OTH_DTL="";

	P_O_pat_cat= statement.getString(41); 
	if( P_O_pat_cat == null) P_O_pat_cat="";
	
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
	System.err.println("holdArr[0]-------->"+holdArr[0]);
	System.err.println("holdArr[1]-------->"+holdArr[1]);
	System.err.println("holdArr[2]-------->"+holdArr[2]);
	System.err.println("holdArr[3]-------->"+holdArr[3]);
	System.err.println("holdArr[4]-------->"+holdArr[4]);	
	System.err.println("P_O_END_TIME-------->"+P_O_END_TIME);
	System.err.println("holdArr[5]-------->"+holdArr[5]);
	System.err.println("P_O_NO_OF_SLOTS-------->"+P_O_NO_OF_SLOTS);
	System.err.println("P_O_Max_Forced-------->"+P_O_Max_Forced);
	System.err.println("P_O_Total_Forced-------->"+P_O_Total_Forced);
	System.err.println("P_O_Max_Global-------->"+P_O_Max_Global);
	System.err.println("P_O_Total_Global-------->"+P_O_Total_Global);
	System.err.println("P_O_PATIENT_ID-------->"+P_O_PATIENT_ID);
	System.err.println("P_LAST_APPT_BOOKED-------->"+P_LAST_APPT_BOOKED);
	System.err.println("P_O_VISIT_TYPE_CODE-------->"+P_O_VISIT_TYPE_CODE);
	System.err.println("P_O_REFERRAL_ID-------->"+P_O_REFERRAL_ID);
	System.err.println("P_O_CONTACT_REASON_CODE-------->"+P_O_CONTACT_REASON_CODE);
	System.err.println("P_O_ENCOUNTER_ID-------->"+P_O_ENCOUNTER_ID);
	System.err.println("P_O_SERVICE_CODE-------->"+P_O_SERVICE_CODE);
	System.err.println("P_APPT_OTH_DTL-------->"+P_APPT_OTH_DTL);
	System.err.println("P_O_pat_cat-------->"+P_O_pat_cat);

	System.err.println("<--------DisplayResults.jsp----1653---->");

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
			for(int ij=0;ij<holdArr.length;ij++){
				token=null;
				track=0;
				String popArr[]=new String[counter];
				token = new StringTokenizer(holdArr[ij], "|");

				while (token.hasMoreTokens()){
					popArr[track]=token.nextToken();
					track++;
				}
				 arrLst.add(popArr);				 
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
			token = new StringTokenizer(P_LAST_APPT_BOOKED, "|");
			String last_appt_booked[]=new String[counter];
			while (token.hasMoreTokens())
			{
			last_appt_booked[track]=token.nextToken();
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

			token=null;
			track=0;
			
			token = new StringTokenizer(P_O_VISIT_TYPE_CODE, "|");			
			String visit_type_code[]=new String[counter];
			
			while (token.hasMoreTokens())
			{
				visit_type_code[track]=token.nextToken();
				track++;
			}
			
			
			token=null;
			track=0;
			token = new StringTokenizer(P_O_REFERRAL_ID, "|");
			String referral_id[]=new String[counter];
			while (token.hasMoreTokens())
			{
				referral_id[track]=token.nextToken();
				track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_CONTACT_REASON_CODE, "|");
			String contact_reason_code[]=new String[counter];
			while (token.hasMoreTokens())
			{
				contact_reason_code[track]=token.nextToken();
				track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_ENCOUNTER_ID, "|");
			String encounter_id[]=new String[counter];
			while (token.hasMoreTokens())
			{
				encounter_id[track]=token.nextToken();
				track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_SERVICE_CODE, "|");
			String service_code[]=new String[counter];
			while (token.hasMoreTokens())
			{
				service_code[track]=token.nextToken();
				track++;
			}

			token=null;
			track=0;
			token = new StringTokenizer(P_O_pat_cat, "|");
			String pat_cat[]=new String[counter];
			while (token.hasMoreTokens())
			{
				pat_cat[track]=token.nextToken();
				track++;
			}

	if(mode_find !=null && mode_find.equals("revise")){
			if(date !=null && date.equals(old_date)){
				allow_revise=true;
			}
			else{
				if(max_patient!=0){
				if(max_patient==total_booked){
					if(tfr_appt_across_catg_yn!=null && tfr_appt_across_catg_yn.equalsIgnoreCase("N")){
					allow_revise=false;
					%>	
						<script>alert(getMessage('APPT_CAN_NOT_TRANS_OTH_CAT','OA'));</script>
					<%
					}
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
			}
		}		
		if(allow_revise){
%>
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
			else if(Date.parse(todt) >= Date.parse(fromdt)) { return true; } 
			
			
	}
return true;
}
</script>

<%
 /*Below Code Added for this CRF [Bru-HIMS-CRF-177] */  
        java.util.HashMap hm=eMP.ChangePatientDetails.getColorCode(con,facilityid); 
	//CheckStyle Violation Commented by Munisekhar	
//Statement stmt1=null;
//ResultSet color_ind_rs=null;	
//String colour_indicator_query=""; 
//String colour_indicator_code1="";
//String visite_code1=""; 
//String visitcode="";
				
		
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
		apptRemarks		= eOA.OACommonBean.getApptRemarks(con,fcid,o_appt_ref_no[init]);	
	/*End*/

	/*
	String encounter_id = "";	

	String sql_visit="select ENCOUNTER_ID from oa_appt where facility_id = '"+facilityid+"' and  appt_ref_no='"+o_appt_ref_no[init]+"'";

	stmt_visit = con.createStatement();
	rs_visit = stmt_visit.executeQuery(sql_visit);

	if(rs_visit!=null&&rs_visit.next())
	{
		encounter_id = rs_visit.getString("ENCOUNTER_ID");
	}	

	*/


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
if(last_appt_booked[init].equals("Y")){

classValue = "OA_EMERGENT" ;
}%>
	

<tr onClick='row(this)'>
<%
String u=from_time[init];
String z=status[init];
String z1=status1[init];

String visit_registered_yn="N";

if( z.equals("VT") || z.equals("VT*F"))
	visit_registered_yn="Y";
else
	visit_registered_yn="N";

String reason ="";
String reason1=z.substring(0,2);
if( z.length() > 2)
	reason=z.substring(2,z.length());
else
	reason="";
z=reason1;


String chk_blank_row_patient=patient_name[init];
/*
OL --BOOKED
VT --VISITED
VL --OVER-BOOKED
BN --Block
FL --FREE
*/
if(decide.equals("Query"))
{  
	if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")){
				if(chk_blank_row_patient.equals("~"))
					{ 
					if(slots > 0)
					 {%>
						<% if(blkStatus.equals("B")){%>
						
						<td width="4%" <%=nowarp1%> class="OARED" onClick='col(this)' title="<%=blkRemark%>"><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>

							<% } else { %>
						<td width="4%"  <%=nowarp1%> class="<%=classValue%>" onClick='col(this)'><%= u%> <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
							<% } %>
						<%
							slots--;
						same_appt = "Y";
							}
							else
							{
								if(blkStatus.equals("B")){%>
									
									<td width="4%"  <%=nowarp1%> class="OARED" onClick='col(this)' title="<%=blkRemark%>"><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
								<%}else{%>
										<td width="4%"  <%=nowarp1%> class="<%=classValue%>" onClick='col(this)'><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
								<%}
							}
					}
			else
					{

					{%>
					<%if(z1.equals("OL*F")){
						if(blkStatus.equals("B")){%>
									
						<td width="4%"  <%=nowarp1%> class="OARED" onClick='col(this)'><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>

						<%}else{%>
													
						<td width="4%"  <%=nowarp1%> class="OAFORCED" onClick='col(this)'><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>

						<%}%>

					<%}else{
						
							if(blkStatus.equals("B")){%>
								
								<td width="4%"  <%=nowarp1%> class="OARED" onClick='col(this)' title="<%=blkRemark%>"><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
							<%}else{%>
								<td width="4%"  <%=nowarp1%> class="<%=classValue%>" onClick='col(this)'><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
							<%}%>
					<%}%>
					<%pat_name = patient_name[init];
						slots--;
					}
					
					}


		}
	else if (z.equals("RN")){%>
	
		<td width="4%"  <%=nowarp1%> class='oablock'><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
	<%}else
			if (z.equals("VT")){%>
			
		<td width="4%"  <%=nowarp1%> class="<%=classValue%>"><%=u%> <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
	<%} else { %>
			
		<td width="4%"  <%=nowarp1%> class='oared'><%=u%> <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
			<% }

}
else
{
	if( ! u .equals("~")) //u represents from_time
	{
			if(z.equals("FL") || z.equals("OL") || z.equals("VL")||z.equals("VT"))
		{
			if(!(mode_find.equals("revise")) || mode_find.equals(""))
			{
				if(chk_blank_row_patient.equals("~"))
					{ 
						if(book_appt_yn.equalsIgnoreCase("Y"))
						{
							if(slots > 0)
							{%>
								<%if(blkStatus.equals("B")){%>
										
											<td width="5%" <%=nowarp1%> class='OARED' title="<%=blkRemark%>"><%=u%></td>

										<%}else{%>
								<td width="5%" <%=nowarp1%> class="<%=classValue%>" onClick='col(this)'><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
									<%}%>
								<%slots--;
								same_appt = "Y";
							}
							else
							{
					          if (z.equals("VT"))
								{%>
								<td width="5%" <%=nowarp1%>  class="<%=classValue%>"><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>

								<%}
							   else{
								    if (z.equals("FL")&&(!normal_booking_allow_flag)){%>
										<td width="5%" <%=nowarp1%> class="<%=classValue%>" onClick='col(this)'><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
									<%}
									else{
										if(blkStatus.equals("B")){%>
										
											<td width="5%" <%=nowarp1%> class='OARED' title="<%=blkRemark%>"><%=u%></td>
										<%}else{
										/*Below line Added for this CRF  Bru-HIMS-CRF-191 [IN:030391]*/										
										if(P_O_TIME_TAB_TYPE.equals("2") && groupApptYN.equals("Y") && group_check>0  && callingMode.equals("") && (from_page.equals("") || from_page.equals("schedule_appt"))){%>									
											<td width="5%" <%=nowarp1%> class="<%=classValue%>" onClick='col(this)'>
												<a href= "javascript:GroupappointmentSelect('','<%=o_appt_ref_no[init]%>')"><%=u%></a> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
										<%//End this CRF  Bru-HIMS-CRF-191 [IN:030391]
												}else{%>
											<td width="5%" <%=nowarp1%> class="<%=classValue%>" onClick='col(this)'>
												<a href= "javascript:moveNext_results('','<%=o_appt_ref_no[init]%>')"><%=u%></a> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
										<%}}
									}
								   
							   }
							}
						}
						else 
						{
							if(book_appt_yn!=null && book_appt_yn.equalsIgnoreCase("N"))
							{
								if (z.equals("FL")&&(!normal_booking_allow_flag)){%>
								   <td width="5%" <%=nowarp1%>  class="<%=classValue%>" onClick='col(this)'><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' >
									  </td>
								<%}else{
									if(blkStatus.equals("B")){%>
										
										<td width="5%" <%=nowarp1%> class='OARED' title="<%=blkRemark%>"><%=u%></td>
									<%}else{%>
										<td width="5%" <%=nowarp1%>  class="<%=classValue%>" onClick='col(this)'><a href= "javascript:moveNext_results('','<%=o_appt_ref_no[init]%>')"><%=u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
									<%}
								}
							}
						}
					}
					else
					{
                      if (z.equals("VT"))
						{%>
	  						<td width="5%" <%=nowarp1%> class="<%=classValue%>" onClick='col(this)'><a href= "javascript:moveNext_results('','<%=o_appt_ref_no[init]%>')"><%=u%></a><input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
						<%}
					  else
						{
							if (z.equals("FL")&&(!normal_booking_allow_flag)){%>
								<td width="5%" <%=nowarp1%> class="<%=classValue%>" onClick='col(this)'><%=u%>"<input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
							<%}else{
								if(blkStatus.equals("B")){%>
									
									<td width="5%" <%=nowarp1%> class='OARED' title="<%=blkRemark%>"><%=u%></td>
								<%}else{%>
									<%if(z1.equals("OL*F")){ %>
										
										<td width="5%" <%=nowarp1%> class='OAFORCED' onClick='col(this)' Title='Forced Appointment'><a href= "javascript:moveNext_results('F','<%=o_appt_ref_no[init]%>')"><%=u%></a> <input type='hidden' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
									<%}else if(z1.equals("OL*")){%>
																				
										
											<td width="5%" <%=nowarp1%> class="<%=classValue%>" onClick='col(this)'><a href= "javascript:moveNext_results('NF','<%=o_appt_ref_no[init]%>')"><%=u%></a> <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
									
										
																						
									<%}else if(z1.equals("OL*M")){%>	
										<td width=5% <%=nowarp1%> class="<%=classValue%>" onClick='col(this)'><a href= "javascript:moveNext_results('M','<%=o_appt_ref_no[init]%>')"><%=u%></a> <input type='hidden' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>															
									<%}else{%>
										<%if(z.equals("VL")){%>
											<td width="5%" <%=nowarp1%> class="<%=classValue%>" onClick='col(this)'><a href= "javascript:moveNext_results('NF','<%=o_appt_ref_no[init]%>')"><%=u%></a> <input type='hidden' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
										<%}else{%>
											<td width="5%" <%=nowarp1%> class="<%=classValue%>" onClick='col(this)'><a href= "javascript:moveNext_results('','<%=o_appt_ref_no[init]%>')"><%=u%></a> <input type='hidden' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
										<%}%>								
									<%}%>
								<%}
							}
						}
						pat_name = patient_name[init];
						slots--;

					}
			}
			else
			{
					if(chk_blank_row_patient.equals("~"))
					{
						if (z.equals("FL")&&(!normal_booking_allow_flag)){%>
							<td width="5%" <%=nowarp1%> class="<%=classValue%>" onClick='col(this)'><%= u%> <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
						<%}else{
							if(blkStatus.equals("B")){%>
								
								<td width="5%" <%=nowarp1%> class='OARED' title="<%=blkRemark%>"><%=u%></td>
							<%}else{%>
								<td width="5%" <%=nowarp1%> class="<%=classValue%>" onClick='col(this)'><a href= "javascript:moveNext_results('','<%=o_appt_ref_no[init]%>')"><%= u%></a> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
							<%}
						}
					}
					else
					{%>
						<td width="5%" <%=nowarp1%>  class="<%=classValue%>" ><%= u%><input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
					
					<%}
		   	}
		}
		else 
		{
			if(z.equals("RN"))
			{%>
				<td width="5%" <%=nowarp1%> class='oablock'>
			
					<%=u%>
				
				<input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
			<%}	
			else
			{
				if(z.equals("BN"))
				{%>
					
					<td width="5%" <%=nowarp1%>  class='oared'  title ="<%=reason%>">
				
						<%= u%> 
				
					<input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
				<%}	
				else
				{%>
					<td width="5%" <%=nowarp1%>  class="<%=classValue%>" onClick='col(this)'><%= u%> <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
				<%}
			}
		}
	}
	else
	{%>
		<td width="5%" <%=nowarp1%> class="<%=classValue%>">&nbsp; <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
	<%}
}
String u1=to_time[init];

//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
if(u1.equals("00:00")){
	u1 = "23:59";
}

if( ! u1 .equals("~"))
{
	if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT"))
	{
		if(blkStatus.equals("B")){%>
		
			<td width="5%" <%=nowarp1%> class="OARED" title="<%=blkRemark%>"><%=u1%></td>
		<%}else{%>
			<%if(z1.equals("OL*F")){%>
				<td width="5%" <%=nowarp1%> class="OAFORCED" Title="Forced Appointment"><%=u1%></td>
			<%}else{%>
			
					<td width="5%" <%=nowarp1%> class="<%=classValue%>"><%=u1%></td>
				

			<%}%>

		<%}%>
	<%}
	else
	if(z.equals("RN"))
	{%>
		<td width="5%" <%=nowarp1%> class='oablock'><%=u1%></td>
	<%}
	else
	if(z.equals("BN"))
	{%>
		
		<td width="5%" <%=nowarp1%> class='OARED'  title ="<%=reason%>"><%=u1%></td>
	<%}
}
else{%>
	<td width="5%" <%=nowarp1%> class="<%=classValue%>">&nbsp;</td>
<%}

String dispArr1[]=(String []) arrLst.get(0);
String dispArr2[]=(String []) arrLst.get(1);

String dispArr3[]=(String []) arrLst.get(2);
//String dispArr4[]=(String []) arrLst.get(3);
String dispArr4[]=(String []) arrLst.get(4);

String contact_reason = dispArr3[init];
String contact = dispArr4[init];
//String visit_type = dispArr4[init];

	

String u31=dispArr1[init];
String u32=dispArr2[init];



String u2=patient_name[init];
String pat_id=patient_id[init];
String pat_id_regn = "";
if(pat_id.equals("~"))
{
	pat_id="";
}
else
{
	pat_id_regn = pat_id;
	pat_id=pat_id+" , ";
}

webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
patdata.setFacility_id(fcid);

String isInpatient = patdata.CheckInPatient(con,patient_id[init],fcid);
if(isInpatient.equals("CURRENTLY_IN_PATIENT")) {
	%><td width="5%" <%=nowarp1%> class="<%=classValue%>"><center><img src='../../eCommon/images/inpatient.gif'><center></td><%
}
else
{%>
<td width="5%" <%=nowarp1%> class="<%=classValue%>">&nbsp</td>
<%
}

if(!decide.equals("Query"))
	{

	if( ! u2 .equals("~")){
		
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT")){
					
			%>
			<td width='27%' <%=nowarp1%> class="<%=classValue%>">
			<%
			if(inv_visit_mpq_from_ca_yn.equals("Y") && from_page.equals("ca_appt_dairy") && ca_patient_id.equals("") )
			{
				if(date.equals(today_date))
				{
					if(visit_registered_yn.equals("N"))
					{
					
					%>
						<a href="javascript:call_visit_regn('<%=pat_id_regn%>','<%=o_appt_ref_no[init]%>','<%=referral_id[init]%>','<%=clinic_code%>','<%=clinic_type%>','<%=u%>','<%=visit_type_code[init]%>','<%=practitioner_id%>','<%=contact_reason_code[init]%>','<%=contact_reason%>','<%=service_code[init]%>')">
								<%=pat_id%>			
						</a>
					<%
					}
					else if(visit_registered_yn.equals("Y"))
					{
					%>
						<a href="javascript:call_patient_chart('<%=encounter_id[init]%>')">
							<%=pat_id%>			
						</a>
					<%
					}
				}
				else
				{
					%>
						<%=pat_id%>
					<%
				}
			}
			else
			{
			%>
				<%=pat_id%>
			<%
			}
			%>
			
			
			&nbsp;<% if(isVIPimgpatfrontappl){if(pat_cat[init].equals("V") && show_vip.equals("Y")){%><img src='../../eCommon/images/PI_VIP.gif'><%}}%><%=u2%>&nbsp;,<%=u32%>&nbsp;,<%=u31%>
			
			<% if(!isVIPimgpatfrontappl){if(pat_cat[init].equals("V") && show_vip.equals("Y")){%><img src='../../eCommon/images/PI_VIP.gif'><%}}%>
			
			</td>
		<%}else	{
			if(same_appt.equals("Y")){%>
				<td width='27%' <%=nowarp1%> class="<%=classValue%>">***</td>
			<%}else{%>
				
				<td width='27%' <%=nowarp1%> class='OARED'>&nbsp;</td>
			<%}
		}
	}else{
		if(same_appt.equals("Y")){%>
			<td width='27%' <%=nowarp1%> class="<%=classValue%>"><%=pat_name%></td>
		<%}	else{
			if(z.equals("BN")){%>
				<td width='27%' class="<%=classValue%>"><fmt:message key="Common.blocked.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.reason.label" bundle="${common_labels}"/>:&nbsp;<b><%=reason%></b></td>
			<%}else{%>				 
				<td width='27%' class="<%=classValue%>">&nbsp;</td>
			<%}
			
		}
	}	
	}else
	{	 //Below code added for SKR-CRF-PAS-OA-002 [IN:028086] on 10.07.2011 by Suresh M
		String deceasedYN = "N";		
		if(!pat_id_regn.equals("")){
			sql="select deceased_yn from mp_patient where patient_id = ?";			
			stmtps=con.prepareStatement(sql);
			stmtps.setString(1,pat_id_regn);
			rsps=stmtps.executeQuery();
			if ( rsps != null && rsps.next()){	
					deceasedYN=rsps.getString("deceased_yn");									
			}
			if (stmtps !=null) stmtps.close();
			if (rsps !=null) rsps.close();			
		}
		// Ends SKR-CRF-PAS-OA-002 
		if( ! u2 .equals("~")){
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")||z.equals("VT")){%>			
			<td width='21%'  class="<%=classValue%>"><%=pat_id%>
			<% if(isVIPimgpatfrontappl){if(pat_cat[init].equals("V") && show_vip.equals("Y")){%><img src='../../eCommon/images/PI_VIP.gif'><%}}%>
			<%=u2%>,<%=u32%>,<%=u31%>&nbsp;<% if(deceasedYN.equals("Y") && !pat_id_regn.equals("")){%><div style ='BACKGROUND-COLOR:#D5D5D5; font-weight:bold; color:red'><fmt:message key="Common.deceased.label" bundle="${common_labels}"/></div><%}%>
			<% if(!isVIPimgpatfrontappl){if(pat_cat[init].equals("V") && show_vip.equals("Y")){%><img src='../../eCommon/images/PI_VIP.gif'><%}}%></td>
		<%}else	{
			if(same_appt.equals("Y")){%>
				<td width='21%'  class="<%=classValue%>">***</td>
			<%}else{%>
				
				<td width='21%'  class='OARED'>&nbsp;</td>
			<%}
		}
	}else{
		if(same_appt.equals("Y")){%>
			<td width='21%'  class="<%=classValue%>"><%=pat_name%></td>
		<%}	else{
			if(z.equals("BN")){%>
				<td width='21%' class="<%=classValue%>"><fmt:message key="Common.blocked.label" bundle="${common_labels}"/> <fmt:message key="Common.reason.label" bundle="${common_labels}"/>&nbsp;<b><%=reason%></b></td>
			<%}else{%>				 
				<td width='21%' class="<%=classValue%>">&nbsp;</td>
			<%}
			
		}
	}
	}
// code opt by Jith
for(int kkk=2;kkk<arrLst.size();kkk++){
	int kkk1=0;
	if(kkk==2){
		kkk1=3;
	}else if(kkk==3) {
		kkk1=2;
	}else{
		kkk1=kkk;
	}
	
	/*Above line commented and below line added for this CRF GHL-CRF-0414*/
	/*int kkk1=0;
	if(kkk==2){
		kkk1=3;
	}else if(kkk==3) {
		kkk1=4;
	}else if(kkk==4) {
		kkk1=2;
	}else{
		kkk1=kkk;
	}*/	
	//End GHL-CRF-0414
	
	String dispArr[]=(String []) arrLst.get(kkk1);

	String u3=dispArr[init];
	
	
if(!decide.equals("Query"))
	{
	if( ! u3 .equals("~"))	{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){
		  		
		//Below line added for this CRF GHL-CRF-0414
	    String visit_ind_code="",visit_type_indcator="";
		
		// Below "IF" conditions Added for this CRF [Bru-HIMS-CRF-177] 
		  if(kkk1==3){ 
		   String retval=checkForNull(visit_type_code[init]);		   
		 
		   colour_indicator =(String)hm.get(retval);
			
			   if(colour_indicator==null ||colour_indicator.equals("null"))colour_indicator="";	
             
                if(colour_indicator.equals("") && last_appt_booked[init].equals("Y")){
			      colour_indicator="ORANGE";
                  } 
				  
				 
           /*Below line added for this CRF GHL-CRF-0414*/
			//String visit_type_indcator="";
            visit_ind_code=checkForNull(visit_type_ind[init]);	
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
			             				
         /*Below line modified for this CRF End GHL-CRF-0414*/      	 
		%> 
		<td width='6%' <%=nowarp1%>  style="background-color:<%=colour_indicator%>;FONT-SIZE:8pt;" ><%= u3%>&nbsp;</td>
		<td width='6%' <%=nowarp1%>  class="<%=classValue%>"><%=visit_type_indcator%>&nbsp;</td>
		<% }if(kkk1==2){%>
		    <td width='12%' <%=nowarp1%> class="<%=classValue%>"><%= u3%>&nbsp;</td>
		<%}
		}else{%>			
			<td width='12%' class='OARED'>&nbsp;</td>
		<%}
		
	}else{
	      /*Below line modified with from 16 to 12 for this CRF End GHL-CRF-0414*/
		   %>
			<td width='12%' class="<%=classValue%>">&nbsp;</td>
	<%}
	}else {
		if( ! u3 .equals("~"))	{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){
		
		//Below line added for this CRF GHL-CRF-0414
	    String visit_ind_code="",visit_type_indcator="";
		
		 // Below "IF" conditions Added for this CRF [Bru-HIMS-CRF-177] 
		   if(kkk1==3){  
              String retval=checkForNull(visit_type_code[init]);		     
		       colour_indicator =(String)hm.get(retval);			  
			   if(colour_indicator==null ||colour_indicator.equals("null"))colour_indicator="";	
              			   
			 if(colour_indicator.equals("") && last_appt_booked[init].equals("Y")){
			    colour_indicator="ORANGE";
			   }
			   
			   
			 /*Below line added for this CRF GHL-CRF-0414*/
			//String visit_type_indcator="";
            visit_ind_code=checkForNull(visit_type_ind[init]);	
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
			
		/*Below line modified and with also changed from 12 to 6 for this CRF End GHL-CRF-0414*/	 
		%> 
		<td width='6%' <%=nowarp1%>  style="background-color:<%=colour_indicator%>;FONT-SIZE:8pt;"><%= u3%>&nbsp;</td>
		<td width='6%' <%=nowarp1%>  class="<%=classValue%>"><%=visit_type_indcator%>&nbsp;</td>
		<%}if(kkk1==2){%>
			<td width='12%'  class="<%=classValue%>"><%= u3%>&nbsp;</td>
		<%}
		}else{%>			
			<td width='12%' class='OARED'>&nbsp;</td>
		<%}
	}else{%>
			<td width='12%' class="<%=classValue%>">&nbsp;&nbsp;</td>
	<%}
	}%>
<%}
   if(!contact.equals("~")){%><td width='12%' class="<%=classValue%>"><%=contact%>&nbsp;</td><%
   }
// end JIth

String tmp_ref_no=o_appt_ref_no[init];
String oth_dtls=appt_ot_dtl[init];
int sec_cnt=0;
String showpatInstructionsYN="N";
String showprocInstructionsYN="N";

String showInstructionsYN="N";



StringTokenizer tmp_oth_dtl = new StringTokenizer(oth_dtls, "*");
while (tmp_oth_dtl.hasMoreTokens())	{
	sec_cnt=Integer.parseInt(tmp_oth_dtl.nextToken());
	if(!tmp_oth_dtl.nextToken().equals("0")){
		showpatInstructionsYN="Y";
	}else{
		showpatInstructionsYN="N";
	}

	if(!tmp_oth_dtl.nextToken().equals("0")){
		showprocInstructionsYN="Y";
	}else{
		showprocInstructionsYN="N";
	}
	
}
if(showpatInstructionsYN.equals("Y")){
	showInstructionsYN="Y";
}else{
	if(showprocInstructionsYN.equals("Y")){
		showInstructionsYN="Y";
	}
}
if(tmp_ref_no.equals("~")) tmp_ref_no="";

/*if(!tmp_ref_no.equals("")){
	sql="select count(appt_ref_no) count from oa_resource_for_appt where appt_ref_no = '"+tmp_ref_no+"' and FACILITY_ID='"+facilityid+"'";
		stmtps=con.prepareStatement(sql);
		rsps=stmtps.executeQuery();
		if ( rsps != null && rsps.next()){	
				sec_cnt=rsps.getInt("count");	
			
		}
}
if (stmtps !=null) stmtps.close();
if (rsps !=null) rsps.close();
*/
if(!decide.equals("Query"))
	{%>
<td width='15%' class="<%=classValue%>">
	<%if(sec_cnt>0){%>
		<a href="javascript:show_Reference_details_results('<%=tmp_ref_no%>','<%=facilityid%>')">
			<fmt:message key="Common.details.label" bundle="${common_labels}"/>
		</a>
	<%}%>&nbsp;</td>
	<!--Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659]  -->
	<td width='12%' class="<%=classValue%>" onClick='col(this)' ><%if(!tmp_ref_no.equals("") && order_clinic_count>0){%><a href="javascript:show_order_select('','<%=o_appt_ref_no[init]%>','<%=facilityid%>','<%=clinic_code%>','<%=z%>')">
			<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Order.label" bundle="${common_labels}"/>
		</a><%}else{ %>&nbsp;<%} %><input type='hidden'  name='order_appt_ref_no<%=init%>' id='order_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
	<!-- End this CRF Bru-HIMS-CRF-165.1 [IN:035659] -->
	<%/*Added by Thamizh selvi on 9th July 2018 against ML-MMOH-CRF-1058 Start*/
	if(isIncRemarksLengthAppl){ %>
		<td width='12%' class="<%=classValue%>" onClick='col(this)' ><%if(!("").equals(apptRemarks)){%><a href="javascript:dispApptRemarks('<%=facilityid%>','<%=o_appt_ref_no[init]%>')">
		<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Detail.label" bundle="${common_labels}"/>
		</a><%}else{ %>&nbsp;<%} %></td>
	<% } 
	/*End*/
	}else {%>
<td width='12%' class="<%=classValue%>">
	<%if(sec_cnt>0){%>
		<a href="javascript:show_Reference_details_results('<%=tmp_ref_no%>','<%=facilityid%>')">
			<fmt:message key="Common.details.label" bundle="${common_labels}"/>
		</a>
	<%}%>&nbsp;</td><!--Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659]  -->
	<td width='12%' class="<%=classValue%>">&nbsp;</td>
	<!-- End this CRF Bru-HIMS-CRF-165.1 [IN:035659] -->
	
<%}
//The following code is for "Appointment for a Resource" function
if(decide.equals("Query")){ 
	/*
	ResultSet qsRs=null;
	String sql4="select *  from oa_appt_pat_instructions where facility_id='"+facilityid+"' and appt_ref_no='"+o_appt_ref_no[init]+"'";

	qsRs = stmtsd.executeQuery(sql4);
	if ( qsRs != null ){
		if(qsRs!=null && qsRs.next()){	
			showInstructionsYN="Y";					
		}
	}
	if(qsRs !=null)qsRs.close();
	if(showInstructionsYN.equals("N")){
		sql4="select *  from oa_appt_proc_instructions where facility_id='"+facilityid+"' and appt_ref_no='"+o_appt_ref_no[init]+"'";
		qsRs = stmtsd.executeQuery(sql4);
		if ( qsRs != null ){
			if(qsRs!=null && qsRs.next()){	
				showInstructionsYN="Y";					
			}
		}
		if(qsRs !=null)qsRs.close();
	}
	*/
	%>
	<%
		if(!(o_appt_ref_no[init].equals("~"))){
		// Issue Fix Against Incident Number : 34667 Below local query Column Name Changed from modified_by_id to added_by_id
		sql="select added_by_id, to_char(modified_date,'dd/mm/yyyy hh24:mi') mod_date from oa_appt where facility_id = ? and  appt_ref_no=?";
		stmtps=con.prepareStatement(sql);
		stmtps.setString(1,facilityid);
		stmtps.setString(2,o_appt_ref_no[init]);
		rsps=stmtps.executeQuery();
		while(rsps.next()){
			String mod_date=rsps.getString("mod_date");
			mod_date=DateUtils.convertDate(mod_date,"DMYHM","en",locale);%>
			<td width='11%' class="<%=classValue%>"><%=rsps.getString("added_by_id")%></td><td width='11%' class="<%=classValue%>">&nbsp;<%if(showInstructionsYN.equals("Y")){%><a href="javascript:show_patinstructions('<%=o_appt_ref_no[init]%>')"><fmt:message key="Common.details.label" bundle="${common_labels}"/></a><%}%></td><td  class="<%=classValue%>" width='11%'><%=mod_date%></td>
		<%}	
	}else{%>
		<td  width='11%' class="<%=classValue%>">&nbsp;</td><td width='11%' class="<%=classValue%>">&nbsp;<%if(showInstructionsYN.equals("Y")){%><a href="javascript:show_patinstructions('<%=o_appt_ref_no[init]%>')"><fmt:message key="Common.details.label" bundle="${common_labels}"/></a><%}%></td><td width='11%'class="<%=classValue%>">&nbsp;</td>
	<%}

}
if (stmtps !=null) stmtps.close();
if (rsps !=null) rsps.close();
%>
</tr>
<%

}%>
</table>

	
<input type="hidden" name="p_o_obvisit_flag" id="p_o_obvisit_flag" value="<%=P_O_OBVISIT_FLAG%>">
<input type="hidden" name="oper_stn_id" id="oper_stn_id" value="<%=oper_stn_id%>">
	<input type='hidden' name='r_appt_status' id='r_appt_status' value='null' >
	<input type='hidden' name='clinic_code' id='clinic_code' value='<%= clinic_code %>' >
	<input type='hidden' name='clinic_name' id='clinic_name' value='<%=P_O_CLINIC %>' >
	<input type='hidden' name='pract_id' id='pract_id' value='<%=practitioner_id %>' >
	<input type='hidden' name='pract_name' id='pract_name' value='<%=P_O_PRACTITIONER %>' >
	<input type='hidden' name='appt_date' id='appt_date' value='<%=date %>' >
	<input type='hidden' name='over_booked' id='over_booked' value='<%=P_O_OVER_BOOKING%>' >
	<input type='hidden' name='over_booked_label' id='over_booked_label' value='<%=over_booked_label%>'>
	<input type='hidden' name='P_O_TIME_TAB_TYPE' id='P_O_TIME_TAB_TYPE' value='<%=P_O_TIME_TAB_TYPE%>' >
	<input type='hidden' name='max_patients_per_slab' id='max_patients_per_slab' value='<%=max_patients_per_slab%>' >
	<input type='hidden' name='sys_date' id='sys_date' value='<%=current_date%>' >
	<input type='hidden' name='sys_time' id='sys_time' value='<%= current_time %>' >
	<input type="hidden" name="alcn_criteria" id="alcn_criteria" value="<%=alcn_criteria%>">
	<input type="hidden" name="slot_appt_ctrl" id="slot_appt_ctrl" value="<%=slot_appt_ctrl%>">
	<input type="hidden" name="visit_limit_rule" id="visit_limit_rule" value="<%=visit_limit_rule%>">
	<input type="hidden" name="override_no_of_slots_yn" id="override_no_of_slots_yn" value="<%=override_no_of_slots_yn%>">
	<input type='hidden' name='reason_for_revise' id='reason_for_revise'  value='<%= value12%>' >
	<input type='hidden' name='ref_no' id='ref_no' value= '<%= value13%>' >
	<input type='hidden' name='old_date' id='old_date' value='<%=old_date%>' >
	<input type='hidden' name='p_o_end_time' id='p_o_end_time' value ='<%=P_O_END_TIME%>' >
	<input type='hidden' name='old_from_time' id='old_from_time' value='<%=old_from_time%>' >
	<input type='hidden' name='old_to_time' id='old_to_time' value='<%=old_to_time%>' >
	<input type='hidden' name='book_appt_yn' id='book_appt_yn' value='<%=book_appt_yn%>' >
	<input type='hidden' name='book_appt_wo_pid_yn' id='book_appt_wo_pid_yn' value='<%=book_appt_wo_pid_yn%>' >
	<input type='hidden' name='obook_appt_yn' id='obook_appt_yn' value='<%=obook_appt_yn%>' >
	<input type='hidden' name='book_appt_across_catg_yn' id='book_appt_across_catg_yn' value='<%=book_appt_across_catg_yn%>' >
	<input type='hidden' name='tfr_appt_yn' id='tfr_appt_yn' value='<%=tfr_appt_yn%>' >
	<input type='hidden' name='tfr_appt_across_catg_yn' id='tfr_appt_across_catg_yn' value='<%=tfr_appt_across_catg_yn%>' >
	<input type='hidden' name='canc_appt_yn' id='canc_appt_yn' value='<%=canc_appt_yn%>' >
	 <input type='hidden' name='pre_pat_alcn_catg_code' id='pre_pat_alcn_catg_code' value='<%=pre_pat_alcn_catg_code%>' >
	<input type='hidden' name='ca_mode' id='ca_mode' value='<%=ca_mode%>' >
	<input type='hidden' name='patient_id' id='patient_id' value='null' >
	<input type="hidden" name='ca_patient_id' id='ca_patient_id' value='<%=ca_patient_id%>' >
	<input type="hidden" name="maxForced" id="maxForced" value="<%=P_O_Max_Forced%>">
	<input type="hidden" name="totForced" id="totForced" value="<%=P_O_Total_Forced%>">
	<input type="hidden" name="maxGlobal" id="maxGlobal" value="<%=P_O_Max_Global%>">
	<input type="hidden" name="totGlobal" id="totGlobal" value="<%=P_O_Total_Global%>">
	<input type="hidden" name='callingMode' id='callingMode' value="<%=callingMode%>">
	<input type="hidden" name='calling_mode_new' id='calling_mode_new' value="<%=calling_mode_new%>">
	<input type="hidden" name='req_id' id='req_id' value="<%=req_id%>">
	<input type="hidden" name="install_yn_val" id="install_yn_val" value="<%=install_yn_val%>">
	<input type="hidden" name="create_wait_list_yn" id="create_wait_list_yn" value="<%=create_wait_list_yn%>">
	<input type="hidden" name='visit_flag_OP' id='visit_flag_OP' value='<%=visit_flag_OP%>'>
	<input type="hidden" name='capture_fin_dtls_yn' id='capture_fin_dtls_yn' value='<%=capture_fin_dtls_yn%>'>
<input type="hidden" name='contact_num_reqd_yn' id='contact_num_reqd_yn' value='<%=contact_num_reqd_yn%>'>
	<input type="hidden" name='page1' id='page1' value='<%=decide%>'>
<input type="hidden" name='from_page' id='from_page' value='<%=from_page%>'>
<input type="hidden" name='from_facility_id' id='from_facility_id' value='<%=from_facility_id%>'>
<input type="hidden" name='from_encounter_id' id='from_encounter_id' value='<%=from_encounter_id%>'>
<input type="hidden" name='no_of_noshow_appts_for_alert' id='no_of_noshow_appts_for_alert' value='<%=no_of_noshow_appts_for_alert%>'>
<input type="hidden" name='per_chk_for_no_show_alert' id='per_chk_for_no_show_alert' value='<%=per_chk_for_no_show_alert%>'>
<input type="hidden" name='isIncRemarksLengthAppl' id='isIncRemarksLengthAppl' value='<%=isIncRemarksLengthAppl%>'><!--Added by Thamizh selvi on 16th July 2018 against ML-MMOH-CRF-1184-->

<input type="hidden" name="refID" id="refID" value="<%=ref_id%>">
<input type="hidden" name='min_ela_per_resc_noshow_in_day' id='min_ela_per_resc_noshow_in_day' value='<%=min_ela_per_resc_noshow_in_day%>'>
<input type="hidden" name='noshow_ctrl_by_splty_or_clinic' id='noshow_ctrl_by_splty_or_clinic' value='<%=noshow_ctrl_by_splty_or_clinic%>'>
<%String calling_mode1=request.getParameter("callingMode");
if(calling_mode1==null) calling_mode1="N";
%>
	<input type="hidden" name="calling_mode" id="calling_mode" value="<%=calling_mode1%>">
	<input type="hidden" name="ForcedAllowed" id="ForcedAllowed" value="<%=FORCED_BOOK_APPT_YN%>">
	<input type="hidden" name="GlobalAllowed" id="GlobalAllowed" value="<%=GLOBAL_BOOK_APPT_YN%>">
	<input type="hidden" name="LocGlbChk" id="LocGlbChk" value="<%=global_locn_yn%>" >

	
	<input type="hidden" name="clinic_type" id="clinic_type" value="<%=clinic_type%>">
	<input type="hidden" name="res_type" id="res_type" value="<%=res_type%>">
	<input type="hidden" name="or_catalogue_code" id="or_catalogue_code" value="<%=or_catalogue_code%>">
	<input type="hidden" name="order_line_num" id="order_line_num" value="<%=order_line_num%>">	
	<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">	
	<input type="hidden" name="order_catalog_code" id="order_catalog_code" value="<%=order_catalog_code%>">
	<input type="hidden" name="hddUrl" id="hddUrl" value="<%=temp%>">
	<!-- Added for ML-BRU-CRF-0628.1 -->
	<input type="hidden" name="p_o_ext_slot_status" id="p_o_ext_slot_status" value="<%=p_o_ext_slot_status%>">
	<input type="hidden" name="p_o_reserved_slot_dtls" id="p_o_reserved_slot_dtls" value="<%=p_o_reserved_slot_dtls%>">
	<input type="hidden" name="p_o_appt_slot_dtls" id="p_o_appt_slot_dtls" value="<%=p_o_appt_slot_dtls%>">
	<input type="hidden" name="p_o_block_slot_dtls" id="p_o_block_slot_dtls" value="<%=p_o_block_slot_dtls%>">
	<input type="hidden" name="p_o_break_slot_dtls" id="p_o_break_slot_dtls" value="<%=p_o_break_slot_dtls%>">
	<input type="hidden" name="isSlotStartMidEndAppl" id="isSlotStartMidEndAppl" value="<%=isSlotStartMidEndAppl%>">
	<!-- End ML-BRU-CRF-0628.1 -->
	
<%String recall_time=(String) session.getValue("recall_time");
if(recall_time==null)
	recall_time="N";

%>

<input type="hidden" name="recall_time" id="recall_time" value="<%=recall_time%>">

<input type="hidden" name="wtListControl" id="wtListControl" value="<%=wtListControl%>">
<input type="hidden" name="waitListNo" id="waitListNo" value="<%=waitListNo%>">
<input type="hidden" name="rd_appt_yn" id="rd_appt_yn" value="<%=rd_appt_yn%>">

<!--Below line Added for this CRF Bru-HIMS-CRF-191 [IN:030391]  -->
<input type="hidden" name="groupApptYN" id="groupApptYN" value="<%=groupApptYN%>">
<input type="hidden" name="group_check" id="group_check" value="<%=group_check%>">
<input type="hidden" name="entitlement_by_pat_cat_yn" id="entitlement_by_pat_cat_yn" value="<%=entitlement_by_pat_cat_yn%>">

</form>
<script>
	
	/* Added for ML-BRU-CRF-0628.1 */
	if (document.forms[0].isSlotStartMidEndAppl.value=='true'){
	
		var ext_slt=document.forms[0].p_o_ext_slot_status.value;
		var res_slt=document.forms[0].p_o_reserved_slot_dtls.value;
		var appt_slt=document.forms[0].p_o_appt_slot_dtls.value;
		var blk_slt=document.forms[0].p_o_block_slot_dtls.value;
		var brk_slt=document.forms[0].p_o_break_slot_dtls.value;


		var ext_slot_arr=ext_slt.split("|");
		var res_slot_arr=res_slt.split("|");
		var appt_slot_arr=appt_slt.split("|");
		var blk_slot_arr=blk_slt.split("|");
		var brk_slot_arr=brk_slt.split("|");


		for(var i=0;i<=ext_slot_arr.length;i++){
			
			if(ext_slot_arr[i]=='Y') {

				if(blk_slot_arr[i]=='N' && brk_slot_arr[i]=='N') {
					if(res_slot_arr[i] !='N'){
					
						document.getElementById('results1').rows[i+1].cells[0].style.backgroundColor = "Bisque";
						document.getElementById('results1').rows[i+1].cells[1].style.backgroundColor = "Bisque";
						document.getElementById('results1').rows[i+1].cells[0].style.Color = "Black";
						document.getElementById('results1').rows[i+1].cells[1].style.Color = "Black";
						document.getElementById('results1').rows[i+1].cells[3].style.backgroundColor = "Bisque";
						document.getElementById('results1').rows[i+1].cells[3].innerText = "BRU Health Reservation : "+res_slot_arr[i];

					}else {
						
						document.getElementById('results1').rows[i+1].cells[0].style.backgroundColor = "Bisque";
						document.getElementById('results1').rows[i+1].cells[1].style.backgroundColor = "Bisque";
					}
				}

				
			}
				
		}
	}
	/* End ML-BRU-CRF-0628.1 */
	</script>

<%
}


	if (stmtps != null) stmtps.close();
	if (statement != null) statement.close();
	if (statement_bru != null) statement_bru.close();
	if (cstmt != null) cstmt.close();
	if (rs != null) rs.close();
	if (rsps != null) rsps.close();
	if(rsCA !=null)rsCA.close();
	if(rsps !=null)rsps.close();
	//if (stmtsd !=null) stmtsd.close();
	if (pstmtststus!=null) pstmtststus.close();
	//if (stmtsd !=null) stmtsd.close();
	if (rsststus!=null) rsststus.close();
	if(stmtn !=null)stmtn.close();
	if(stmt_ca !=null)stmt_ca.close();
	if(stmt !=null)stmt.close();
	if(stmt_date !=null)stmt_date.close();
	if(pstmt_access !=null)pstmt_access.close();
	if(pstmt_label !=null)pstmt_label.close();
	arrLst.clear();
}catch(Exception e) { 
	e.printStackTrace(); 
	//out.println("Exception here");
	//out.println("Exception in 3076 DisplayResults.jsp" + e.getMessage());
}

}
catch(Exception e){
	e.printStackTrace();
	//out.println("Exception here");
	//out.println("Exception in 3083 DisplayResults.jsp" + e.getMessage());
	
	%>
	<script>
		setTimeout('vv()',1000); 
		function vv()
		{ 
			parent.frames[0].document.getElementById('ss').style.visibility='hidden';		parent.frames[3].location.href='../../eCommon/html/blank.html';
		}
		var error = getMessage('SCH_NOT_AVAILABLE_DAY','OA');
		parent.parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+error ;
	</script>
<%}finally
{
	ConnectionManager.returnConnection(con,request);
}
%>

</body>
		
</html>

<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}


%>

