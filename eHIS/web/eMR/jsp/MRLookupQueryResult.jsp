<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eIP/jsp/ForSplChars.jsp" %>
<jsp:useBean id="cancelBedDetail" class="webbeans.eCommon.RecordSet" scope="session"/> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale					= (String)session.getAttribute("LOCALE");
	Connection con					= null;
	
	
	
	ResultSet rs					= null;

	Statement paramstmt				= null;
	ResultSet paramrs				= null; 
	PreparedStatement pstmt			= null;



			
	 
	
	String ward_return			= "";


	
	String chc_for_pen_orders_bfr_dis_adv ="";
    String dis_adv_allow_yn               ="";
	String chc_for_pen_orders_bfr_dischrg ="";
	String chk_pen_ward_rtn_bfr_dis_adv	  =""; //Added by Sangeetha on 9-Nov-16 for GHL-CRF-412.2
    String dischrg_allow_yn               ="";
    int result_count=0;
		
	String tfr_req_stat				= "";	
	String facility_id				= "";
	String login_user				= "";
	String oper_stn_id				= "";
	String show_bed_yn				= "";
	String wherecondn				= "";
	String wc_for_bed_ref			= "";
	String function_name			= "";
	String fam_name_search			= "";
	String pat_check_in_allowed_yn	= "N";
	String setup_bl_dtls_in_ip_yn	= "N";
	String routine_tfr_yn			= "";
	String req_stat_tout			= "";
	String priotity_status			= "";
	String date_of_birth_converted  = "";
	String cutt_of_time				= "";
	String req_no					= "";
	String perm_fs_locn				= "";
	

	String bl_operational			= (String)session.getAttribute("bl_operational");
	facility_id						= (String)session.getAttribute("facility_id");
	login_user						= (String)session.getAttribute("login_user");
	oper_stn_id						= checkForNull(request.getParameter("opst"));
	show_bed_yn						= checkForNull(request.getParameter("show_bed_yn"));
	wherecondn						= checkForNull(request.getParameter("wherecondn"));
	//out.println("wherecondn::"+wherecondn);
	function_name					= checkForNull(request.getParameter("function_name"));
	routine_tfr_yn					= checkForNull(request.getParameter("routine_tfr_yn"));
	String discharge_type			= checkForNull(request.getParameter("discharge_type"));
	String discharge_status			= checkForNull(request.getParameter("discharge_status"));
	String ServiceCode				= checkForNull(request.getParameter("ServiceCode"));
	String SubServiceCode			= checkForNull(request.getParameter("SubServiceCode")); 
	int change_admission_dtls		= 0;
	String pat_class = checkForNull(request.getParameter("pat_class")); 
	System.out.println("pat_class value::"+pat_class);

	String disc_from_date			= checkForNull(request.getParameter("disc_from_date"));
		if(!disc_from_date.equals(""))
			disc_from_date			= DateUtils.convertDate(disc_from_date,"DMY",locale,"en"); 
	String disc_to_date				= checkForNull(request.getParameter("disc_to_date"));
		if(!disc_to_date.equals(""))
			disc_to_date			= DateUtils.convertDate(disc_to_date,"DMY",locale,"en"); 
	// added for assign bed on 3/8/2005 by Sridhar R 
	String chg_nurs_unit_in_assign_bed_yn		= checkForNull(request.getParameter("chg_nurs_unit_in_assign_bed_yn"),"N");
	String bl_interfaced_yn			= "";
	String Lodger_Max_RefNo			= "";
	String Lodger_Next_RefNo		= "";
	String Lodger_Period			= "";
	String Acc_Period				= "";
	String Acc_Period_unit			= "";
	String deactivate_pseudo_bed_yn	= "";
	String cancel_reason_code		= "";
	String cancellation_date_time	= "";
	String cancelled_by_id			= "";
	String contact_reason			= "";
	String modified_By_rslt			= "";
	String reason_for_modification  = "";
	String reserve_bed_on_tfr_yn    = "";
	String res_reserve_bed_intraward_yn    = "";//Maheshwaran
	String bed_block_period_max    = "";
	String bed_block_period_max_type= "";


	String discharge_date_time_display = "&nbsp;";
	
	String discharge_date_time_display_report=""; //Added this line for this incident [40702]

	int IP_param_No_Acc_Persons		= 0;
	int bed_block_period_dis		= 0;
	int dis_date_chk_days			= 0;
	int dflt_blk_prd_for_tfr_out	= 0;
	int bed_block_period_normal		= 0;
	String status_value				= "";	
	String status_value_converted   = "";
	String call_func				= "";	
	String confirmIP				= checkForNull(request.getParameter("confirmIP"));
	String p_service_type			= checkForNull(request.getParameter("p_service_type"));
	String targetURL				= checkForNull(request.getParameter("targetURL"));
	String color_code_scheme		= "";
		if (show_bed_yn==null) show_bed_yn = "Y";
	String clinic_list				= checkForNull(request.getParameter("clinic_list"), "1");
		if(clinic_list.length() == 0) clinic_list="('')";
	String call_function			=	checkForNull(request.getParameter("param"));

	String pend_order_status="";

	/*
		Vairable Added :
			On:10/28/2010,For:FD-PMG20089-CRF-0862,By:Chiranjeevi.C
	*/
	String exclude_nda_pats			=	checkForNull(request.getParameter("exclude_nda_pats"),"N");


	//10/16/2008 5089_MF-CRF-0017 enhancement startcall_function put request scope
	request.setAttribute("call_function",call_function);

	String paramsValue				=	checkForNull((String) session.getAttribute("paramsValue"));
	String menu_id					=	checkForNull(request.getParameter("menu_id"));

	String allow_discharge_date		= checkForNull(request.getParameter("allow_discharge_date"));
	String max_disch_period_for_dc_str	= checkForNull(request.getParameter("max_disch_period_for_dc"));
	String patientName			= checkForNull(request.getParameter("patientName"));
	//String patientName				=  java.net.URLDecoder.decode(patientName1,"UTF-8");
	String asgn_bed_mark_arvl		= "";
	String link_font_color          = "";
	String sys_dt_time				= "";

	String function_id				= checkForNull(request.getParameter("function_id"));
	String allow_late_discharge_reason="";
	String disch_reason_mand_yn="";
	String transfer_wo_delink_yn="";//Added for the CRF HSA-CRf-0035

	int max_disch_period_for_dc		= 0;

	String deceased_date_time		= "";
	String maternal_death_yn		= "";
	String indicator				= "";
	String age						= "";
	int n_Age						= 0;
	String allow_multiple_bed_for_resv_yn		= "";
	int  max_disch_period_for_predc				= 0;
	String  allow_discharge_date_predc			= "";
	String  discharge_checklist_app_yn			= "";
	String  dis_date_chk_days_unit				= "";
	String  diag_update_period_max_unit			= "";
	String  serverdate				= "";
	String  patient_file_no						= "";
	String  pat_ser_grp_code					= "";

	if(! max_disch_period_for_dc_str.equals(""))
		max_disch_period_for_dc		= Integer.parseInt(max_disch_period_for_dc_str);
	if(pat_class.equals("IP")||pat_class.equals("DC"))
	{
			try
			{
				// Following Code is to Check the Module with Billing Interface 
				con							= ConnectionManager.getConnection(request);
				paramstmt					= con.createStatement();
				String bed_class_allowed    = "";

				String mp_param_table		= "";
				String mp_param_colns		= "";
				String mp_param_criteria	= "";
				String mother_cut_off_age	= "";
				String mother_max_age		= "";
				String mo_install_sql		= "";
				String mo_install_yn		= "";
				String pre_disch_appl_yn	= "";//Added for the CRF -KDAH-CRF-0104  by Dharma
				String pre_dis_initiate_yn	= "";//Added for the CRF -KDAH-CRF-0104  by Dharma
				String weight_on_admn_mandatory	= ""; //Added by Dharma on Oct27th against HSA-CRF-0181 [IN:049541] 

				
				
				
				
				
				paramrs = paramstmt.executeQuery(" SELECT weight_on_admn_mandatory,pre_disch_appl_yn,bl_interfaced_yn, setup_bl_dtls_in_ip_yn, pat_check_in_allowed_yn, discharge_checklist_app_yn, diag_update_period_max_unit,	TO_CHAR (SYSDATE, 'dd/mm/rrrr hh24:mi') serverdate,priority_applicable_yn, change_bed_class_yn, bed_block_period_dis, dis_date_chk_days, deactivate_pseudo_bed_yn,       dflt_blk_prd_for_tfr_out, bed_block_period_normal, lodger_max_srl_no, lodger_next_srl_no, max_stay_of_lodger_after_disc, dflt_gate_pass_period, dflt_gate_pass_unit, max_allowed_accom_pers,change_admission_dtls, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') sys_dt_time, reserve_bed_on_tfr_yn,RES_RESERVE_BED_INTRAWARD_YN,bed_block_period_max, bed_block_period_max_type, allow_multiple_bed_for_resv_yn, dis_date_chk_days, ALLOW_LATE_DISCHARGE_REASON, DISCH_REASON_MAND_YN, transfer_wo_delink_yn,dis_date_chk_days_unit,CHK_FOR_PEN_ORDERS_BFR_DIS_ADV,DIS_ADV_ALLOW_YN,CHK_FOR_PEN_ORDERS_BFR_DIS,DIS_ALLOW_YN,CHK_PEN_WARD_RTN_BFR_DIS_ADV, max_disch_period_for_dc,TO_CHAR (SYSDATE - DECODE (dis_date_chk_days_unit, 'H', dis_date_chk_days / 24, dis_date_chk_days),'dd/mm/rrrr hh24:mi') allow_discharge_date"+mp_param_colns+" "+mo_install_sql+" FROM IP_PARAM "+mp_param_table+" WHERE facility_id='"+facility_id+"' "+mp_param_criteria+" ");  // "CHK_PEN_WARD_RTN_BFR_DIS_ADV" Added by Sangeetha on 9-Nov-16 for GHL-CRF-412.2
			

				while(paramrs.next()){
						Lodger_Max_RefNo				= checkForNull(paramrs.getString("lodger_max_srl_no"));
						Lodger_Next_RefNo				= checkForNull(paramrs.getString("lodger_next_srl_no"));
						Lodger_Period					= checkForNull(paramrs.getString("max_stay_of_lodger_after_disc"));
						Acc_Period						= checkForNull(paramrs.getString("dflt_gate_pass_period"));
						Acc_Period_unit					= checkForNull(paramrs.getString("dflt_gate_pass_unit"));
						IP_param_No_Acc_Persons			= paramrs.getInt("max_allowed_accom_pers");
						bl_interfaced_yn				= checkForNull(paramrs.getString("bl_interfaced_yn"));
						setup_bl_dtls_in_ip_yn			= checkForNull(paramrs.getString("setup_bl_dtls_in_ip_yn"));
						pat_check_in_allowed_yn	        = checkForNull(paramrs.getString("pat_check_in_allowed_yn"));
						priotity_status					= checkForNull(paramrs.getString("priority_applicable_yn"));
						bed_class_allowed				= checkForNull(paramrs.getString("change_bed_class_yn"));
						deactivate_pseudo_bed_yn		= checkForNull(paramrs.getString("deactivate_pseudo_bed_yn"));
						bed_block_period_dis			= paramrs.getInt("bed_block_period_dis");
						dis_date_chk_days				= paramrs.getInt("dis_date_chk_days");
						dflt_blk_prd_for_tfr_out		= paramrs.getInt("dflt_blk_prd_for_tfr_out");
						bed_block_period_normal	        = paramrs.getInt("bed_block_period_normal");
						change_admission_dtls			= paramrs.getInt("change_admission_dtls");
						sys_dt_time						= paramrs.getString("sys_dt_time");
						reserve_bed_on_tfr_yn			= checkForNull(paramrs.getString("reserve_bed_on_tfr_yn"));
						res_reserve_bed_intraward_yn	= checkForNull(paramrs.getString("RES_RESERVE_BED_INTRAWARD_YN"));
						
						bed_block_period_max			= checkForNull(paramrs.getString("bed_block_period_max"));
						bed_block_period_max_type		= checkForNull(paramrs.getString("bed_block_period_max_type"));
						allow_multiple_bed_for_resv_yn	= checkForNull(paramrs.getString("allow_multiple_bed_for_resv_yn"),"N");
						max_disch_period_for_predc		= paramrs.getInt("max_disch_period_for_dc");
						allow_discharge_date_predc		= checkForNull(paramrs.getString("allow_discharge_date"));
						discharge_checklist_app_yn		= checkForNull(paramrs.getString("discharge_checklist_app_yn"));
						dis_date_chk_days_unit			= checkForNull(paramrs.getString("dis_date_chk_days_unit"));
						diag_update_period_max_unit		= checkForNull(paramrs.getString("diag_update_period_max_unit"));
						serverdate						= checkForNull(paramrs.getString("serverdate"));
					// Below code added by venkatesh on 09/November/2011 against the KDAH-CRF-0041
						chc_for_pen_orders_bfr_dis_adv=checkForNull(paramrs.getString("CHK_FOR_PEN_ORDERS_BFR_DIS_ADV"));
						dis_adv_allow_yn=checkForNull(paramrs.getString("DIS_ADV_ALLOW_YN"));

						chk_pen_ward_rtn_bfr_dis_adv=checkForNull(paramrs.getString("CHK_PEN_WARD_RTN_BFR_DIS_ADV")); //Added by Sangeetha on 9-Nov-16 for GHL-CRF-412.2
							
						// venkatesh KDAH-CRF-0041 END
						
						chc_for_pen_orders_bfr_dischrg =checkForNull(paramrs.getString("CHK_FOR_PEN_ORDERS_BFR_DIS"));
						dischrg_allow_yn  =checkForNull(paramrs.getString("DIS_ALLOW_YN"));

						allow_late_discharge_reason=checkForNull(paramrs.getString("allow_late_discharge_reason"));
						disch_reason_mand_yn=checkForNull(paramrs.getString("disch_reason_mand_yn"));
						transfer_wo_delink_yn=checkForNull(paramrs.getString("transfer_wo_delink_yn"));//Added for the CRF HSA-CRF-0035
						
						if(call_function.equals("PrepareDischargeAdvice")){
							mother_cut_off_age			= checkForNull(paramrs.getString("mother_cut_off_age"));
							mother_max_age				= checkForNull(paramrs.getString("mother_max_age"));
						}
						if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
							mo_install_yn				=  checkForNull(paramrs.getString("mo_install_yn"),"N");
						pre_disch_appl_yn	= checkForNull(paramrs.getString("pre_disch_appl_yn"));//Added for the CRF -KDAH-CRF-0104  by Dharma
						weight_on_admn_mandatory = checkForNull(paramrs.getString("weight_on_admn_mandatory"));//Added by Dharma on Oct27th against HSA-CRF-0181 [IN:049541] 
						
				}	

				if(paramrs != null)			paramrs.close();
				if(paramstmt != null)		paramstmt.close();
				//Added by kishore on 5/15/2004
				%>
				<html>
			<head>
				<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
				<script src='../../eCommon/js/dchk.js' language='javascript'></script>
				<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
				<script src='../../eCommon/js/common.js' language='javascript'></script>
				<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
				<Script src="../../eIP/js/IPLookup.js" language="JavaScript"></Script>
				<script src="../../eMR/js/MRPatientMovementHistory.js" language="JavaScript" ></script>
			<script>
			
				</script>
				<%
				try
				{

					String nurs_unit_code		= "";
					StringBuffer where_criteria = new StringBuffer();
					StringBuffer where_criteria_count = new StringBuffer();
					StringBuffer sql			= new StringBuffer();
					String class_val			= "QRYODDSMALL";
					String bl_install_yn		=	checkForNull(request.getParameter("bl_install_yn"));
					String bedBlock_normal		=	checkForNull(request.getParameter("bedBlock_normal"));
					String max_blk_type			=	checkForNull(request.getParameter("max_blk_type"));
					String whereClause			=	checkForNull(request.getParameter("whereclause"));
					String whereClauseCount		=	checkForNull(request.getParameter("whereclausecount"));
					String from					=	checkForNull(request.getParameter("from"));
					String to					=	checkForNull(request.getParameter("to"));
					String soundex_type			=	checkForNull(request.getParameter("soundex"));
					String no_of_days			=	checkForNull(request.getParameter("no_of_days"));
					String nursing_unit_code	=	checkForNull(request.getParameter("nursing_unit"));
					String from_nursing_unit	=	checkForNull(request.getParameter("from_nursing_unit"));
					String to_nursing_unit_code	=	checkForNull(request.getParameter("to_nursing_unit"));
					String to_Splcode			=	checkForNull(request.getParameter("to_Splcode"));
					String speciality_code		=	checkForNull(request.getParameter("Splcode"));
					String from_Splcode			=	checkForNull(request.getParameter("from_Splcode"));
					String encounter_id			=	checkForNull(request.getParameter("encounter_id"));
					
					String practitioner_id		=	checkForNull(request.getParameter("practid"));
					String from_practid			=	checkForNull(request.getParameter("from_practid"));
					String from_date			=	checkForNull(request.getParameter("from_date"));
					if(!from_date.equals(""))
						from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 
					String to_date				=	checkForNull(request.getParameter("to_date"));
					if(!to_date.equals(""))
						to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 
					String chk_in_lodger_min_date= checkForNull(request.getParameter("chk_in_lodger_min_date"));
					String patient_id			=	checkForNull(request.getParameter("patient_id"));
					String gender				=	checkForNull(request.getParameter("gender"));
					String Modified_By				=	checkForNull(request.getParameter("user_name"));
					String modified_date_from	=	checkForNull(request.getParameter("modified_from_date"));
					if(!modified_date_from.equals(""))
						modified_date_from = DateUtils.convertDate(modified_date_from,"DMY",locale,"en"); 
					String modified_date_to		=	checkForNull(request.getParameter("modified_to_date"));
					if(!modified_date_to.equals(""))
						modified_date_to = DateUtils.convertDate(modified_date_to,"DMY",locale,"en"); 
					
					String name_prefix			=	checkForNull(request.getParameter("name_prefix"));
					String name_suffix			=	checkForNull(request.getParameter("name_suffix"));
					String first_name			=	checkForNull(request.getParameter("first_name"));
					String second_name			=	checkForNull(request.getParameter("second_name"));
					String third_name			=	checkForNull(request.getParameter("third_name"));
					String family_name			=	checkForNull(request.getParameter("family_name"));
					//Added by kumar on 18/03/2003 for Malaysia Enhancements
					String searchby				=	checkForNull(request.getParameter("searchby"), "S");
					String pat_name_as_multipart_yn = checkForNull(request.getParameter("pat_name_as_multipart_yn"));
					String patient_name			= "";
					String nursing_unit_short_desc= "";
					String service_short_desc	= "";
					String subservice_short_desc="";
					String bed_no				= "";
					int baby_count				= 0;
					String room_no				= "";
					String bed_class_short_desc	= "";
					String bed_type_short_desc	= "";
					String to_nursing_unit_short_desc = "";
					String to_bed_class_short_desc = "";
					String to_bed_type_short_desc = "";
					String blocked_bedno		= "";
					String specialty_short_desc	= "";
					String referral_id			= "";
					String practitioner_name	= "";
					String prev_val				= "";
					String prev_val2			= "";
					String Sex					= "";
					String admission_date_time	= "";
					String adm_date_display		= "";
					String discharge_date_time	= "";
					String adt_status			= "";
					String patient_status		= "";
					String ip_leave_status		= "";
					String leave_exp_dt			= "";
					String leave_exp_dt_flag	= "N";
					String date_of_birth		= "";
					String priority				= "";
					String priority_code		= "";
					String pat_dtls_unknown_yn	= "";
					String contact1_name		= "";
					String contact2_name		= "";


					//Added by Devang for Spl. chars
					name_prefix				= singleToDoubleQuotes(name_prefix);
					name_suffix				= singleToDoubleQuotes(name_suffix);
					nursing_unit_code		= singleToDoubleQuotes(nursing_unit_code);
					from_nursing_unit		= singleToDoubleQuotes(from_nursing_unit);
					from_Splcode			= singleToDoubleQuotes(from_Splcode);
					speciality_code			= singleToDoubleQuotes(speciality_code);
					to_nursing_unit_code	= singleToDoubleQuotes(to_nursing_unit_code);
					to_Splcode				= singleToDoubleQuotes(to_Splcode);
					from_practid			= singleToDoubleQuotes(from_practid);
					practitioner_id			= singleToDoubleQuotes(practitioner_id);
					String jsp_name			= checkForNull(request.getParameter("jsp_name"));
					//out.println("jsp_name:"+jsp_name);
					String called_from		= checkForNull(request.getParameter("called_from"));
					String win_height		= checkForNull(request.getParameter("win_height"));
					String dialogTop		= checkForNull(request.getParameter("dialogTop"));
					String win_width		= checkForNull(request.getParameter("win_width"));
					String modal			= checkForNull(request.getParameter("modal"));
					//out.println("modal:"+modal);
					String module			= checkForNull(request.getParameter("module"));
					String model_window		= checkForNull(request.getParameter("model_window"));
				//	String function_id		= checkForNull(request.getParameter("function_id"));


					String prog_id			= checkForNull(request.getParameter("prog_id"));
					String p_practitioner_id= checkForNull(request.getParameter("practitioner_id"));
					call_func				= checkForNull(request.getParameter("call_function"));
					String Disc_Chk			= checkForNull(request.getParameter("Disc_Chk"));
					String bed_class_code	= checkForNull(request.getParameter("Bedcode"));
					String bed_type_code	= checkForNull(request.getParameter("bed_type_code"));
					String cancelled_id		= checkForNull(request.getParameter("cancel_pract_id")); 
					String cancel_reason_desc		= "";
					String discharge_type_desc		= "";
					String discharge_status_desc	= "";
					String location_desc	= "";
					String patient_class	= "";
					//out.println("whereClause::"+whereClause);
						 



					
					%>
					</head>
					<body onMouseDown='CodeArrest()' onKeyDown='lockKey()' >
					<form name='iplookupqueryresult' id='iplookupqueryresult'>
					
					<%
					if(whereClause.equals(""))
					{
						
								where_criteria.append(" where a.facility_id='");
								where_criteria.append(facility_id);
								where_criteria.append("' ");
							
							
							
							
						

					

						
						if(!wherecondn.equals(""))
						{
							
								if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
								{
										where_criteria.append(" and a.nursing_unit_code='"+nursing_unit_code+"' ");
									
								}
								else
								{
										where_criteria.append(" and exists (Select locn_code from AM_OS_USER_LOCN_ACCESS_VW b where b.facility_id = a.facility_id and b.locn_code = a.nursing_unit_code and b.locn_type = 'N' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+login_user+"' ");

																		
											where_criteria.append(" and b.");
											where_criteria.append(wherecondn);
											where_criteria.append("='Y' )"); 

								}
							
							
						}
						else
						{				
							if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
							{
									where_criteria.append(" and a.nursing_unit_code='");
									where_criteria.append(nursing_unit_code);
									where_criteria.append("' ");
								
							}
						}
						
						
							if(speciality_code!=null && !speciality_code.equals(""))
							{
									where_criteria.append(" and specialty_code='");
									where_criteria.append(speciality_code);
									where_criteria.append("' ");
							}

							if(practitioner_id!=null && !practitioner_id.equals(""))
							{
									if(!no_of_days.equals(""))
									{
										where_criteria.append(" and practitioner_id='");
										where_criteria.append(practitioner_id);
										where_criteria.append("' ");
									}
									
										where_criteria.append(" and attend_practitioner_id='");
										where_criteria.append(practitioner_id);
										where_criteria.append("' ");
									
									
							}
					
							if(from_date!=null && !from_date.equals(""))
							{
									where_criteria.append(" and trunc(admission_date_time) >= to_date('");
									where_criteria.append(from_date);
									where_criteria.append("' , 'dd/mm/rrrr') ");
								
							}	
							if(to_date!=null && !to_date.equals(""))
							{
									where_criteria.append(" and trunc(admission_date_time) <= to_date('");
									where_criteria.append(to_date);
									where_criteria.append("' , 'dd/mm/rrrr') ");
								
							}
								
							
						

						
							if(patient_id!=null && !patient_id.equals("")){
								
									where_criteria.append(" and a.patient_id like '");
									where_criteria.append(patient_id);
									where_criteria.append("%' ");
								
							}

							if(encounter_id != null && !encounter_id.equals(""))
							{
									where_criteria.append(" and a.encounter_id='");
									where_criteria.append(encounter_id);
									where_criteria.append("' ");
								
							}	

							if(gender!=null && !gender.equals(""))
							{
									where_criteria.append(" and b.sex='");
									where_criteria.append(gender);
									where_criteria.append("' ");
								
							}

							if(name_prefix!=null && !name_prefix.equals(""))
							{
								where_criteria.append(" and name_prefix='");
								where_criteria.append(name_prefix);
								where_criteria.append("' ");
							}

							if(name_suffix!=null && !name_suffix.equals(""))
							{
								where_criteria.append(" and name_suffix='");
								where_criteria.append(name_suffix);
								where_criteria.append("' ");
							}
								
								if (pat_name_as_multipart_yn.equals("Y"))
								{
									if(first_name!=null && !first_name.equals(""))
									{
										where_criteria.append(" and upper(first_name) like upper('");
										where_criteria.append(first_name);
										where_criteria.append("') || '%' ");
									}

									if(second_name!=null && !second_name.equals(""))
									{
										where_criteria.append(" and upper(second_name) like upper('" );
										where_criteria.append(second_name);
										where_criteria.append("') || '%' ");
									}

									if(third_name!=null && !third_name.equals(""))
									{
										where_criteria.append(" and upper(third_name) like upper('");
										where_criteria.append(third_name);
										where_criteria.append("') || '%' ");
									}

									if(family_name!=null && !family_name.equals(""))
									{
										where_criteria.append(" and upper(family_name) like upper('" );
										where_criteria.append(family_name);
										where_criteria.append("') || '%' ");
									}
								}
								else
								{	
									if (searchby.equals("C"))
									{
										if(!family_name.equals(""))
										{
											where_criteria.append(" and upper(family_name) like '%' || upper('");
											where_criteria.append(family_name);
											where_criteria.append("') || '%' ");
										}
									}
									else if (searchby.equals("E"))
									{
										if(!family_name.equals(""))
										{
											where_criteria.append(" and upper(family_name) like '%' || upper('");
											where_criteria.append(family_name);
											where_criteria.append("') ");			  						}
									}
									else
									{
										if(!family_name.equals(""))
										{
											where_criteria.append(" and upper(family_name) like upper('");
											where_criteria.append(family_name);
											where_criteria.append("') || '%' ");
										}
									}
								}
							
						
						
						if( p_practitioner_id!=null && !p_practitioner_id.equals(""))
						{
							where_criteria.append(" and (practitioner_id ='");
							where_criteria.append( p_practitioner_id);
							where_criteria.append("'  ");
							where_criteria.append(" or encounter_id in ");
							where_criteria.append("(select encounter_id  ");
							where_criteria.append(" from PR_ENCOUNTER_PRACT ");
							where_criteria.append(" where operating_facility_Id= '");
							where_criteria.append(facility_id);
							where_criteria.append("'  ");
							where_criteria.append(" and practitioner_id= '");
							where_criteria.append(p_practitioner_id);
							where_criteria.append("' )) ");
						}
								

						if( clinic_list.length() >= 4)
						{
							where_criteria.append(" and nursing_unit_code in ");
							where_criteria.append(clinic_list);
							where_criteria.append("");
						}

						
						
					}//E.O BUILDING WHERE-CLAUSE
					else
					{
						where_criteria.append( whereClause) ;
						where_criteria_count.append( whereClauseCount) ;
					}
					int start = 0 ;
					int end = 0 ;
					int i=1;
					
					if (from.equals(""))
						start = 1 ;
					else
						start = Integer.parseInt( from ) ;
					
					if (to.equals(""))
						end = 12 ;
					else
						end = Integer.parseInt( to ) ;
					// The SQL below is constructed to count the number of record returned for the given criteria. The corresponding tables are used for the respective functions.
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" select count(*) ");
					sql.append(" FROM IP_OPEN_ENCOUNTER a, MP_PATIENT b "+where_criteria.toString() );
					sql.append(" and a.patient_id = b.patient_id");
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append(" select a.cnt+b.cnt from (select count(1) cnt from IP_PATIENT_LAST_ENCOUNTER_VW a "+where_criteria.toString()+" and trunc(discharge_date_time) >= trunc(sysdate-"+no_of_days+") ) a, (select count(1) cnt from IP_OPEN_ENCOUNTER_VW a "+where_criteria.toString()+" ) b");

					if(rs!=null)	rs.close();
					
							if(!no_of_days.equals(""))
							{
								if(sql.length() > 0) sql.delete(0,sql.length());
								sql.append(" select room_no, IP_GET_DESC.IP_BED_CLASS(bed_class_code,'"+locale+"','2') bed_class_short_desc, IP_GET_DESC.IP_BED_TYPE(bed_type_code,'"+locale+"','2') bed_type_short_desc, to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,null discharge_date_time,null deceased_date_time, gender, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') specialty_short_desc, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc, am_get_desc.AM_SUBSERVICE(SERVICE_CODE, SUBSERVICE_CODE,'"+locale+"','2') subservice_short_desc, nursing_unit_code, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_short_name, encounter_id, patient_id, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name, IP_GET_DESC.IP_NURSING_UNIT(facility_id,nursing_unit_code,'"+locale+"','2') nursing_unit_short_desc, bed_no, practitioner_id, 0 baby_count, IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, NURSING_UNIT_CODE,'"+locale+"','2') location_desc,null maternal_death_yn,null indicator, 'IP' patient_class,a.pat_ser_grp_code,to_char(a.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, get_age(a.date_of_birth) age  from IP_OPEN_ENCOUNTER_VW a "+where_criteria.toString()+" UNION ALL select room_no, IP_GET_DESC.IP_BED_CLASS(bed_class_code,'"+locale+"','2') bed_class_short_desc, IP_GET_DESC.IP_BED_TYPE(bed_type_code,'"+locale+"','2') bed_type_short_desc, to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, to_char(discharge_date_time,'dd/mm/rrrr hh24:mi') discharge_date_time,to_char(deceased_date_time,'dd/mm/rrrr hh24:mi') deceased_date_time, gender, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') specialty_short_desc, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc, am_get_desc.AM_SUBSERVICE(SERVICE_CODE, SUBSERVICE_CODE,'"+locale+"','2') subservice_short_desc, nursing_unit_code, AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1') practitioner_short_name, encounter_id, patient_id, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name, IP_GET_DESC.IP_NURSING_UNIT(facility_id,nursing_unit_code,'"+locale+"','2') nursing_unit_short_desc, bed_no, practitioner_id, 0 baby_count, IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, NURSING_UNIT_CODE,'"+locale+"','2') location_desc,case when a.discharge_type_code is not null then (select maternal_death_yn from ip_discharge_type where discharge_type_code = a.discharge_type_code ) end maternal_death_yn, case when 	a.discharge_type_code is not null then (select indicator from ip_discharge_type  where discharge_type_code = a.discharge_type_code ) end indicator, 'IP' patient_class ,a.pat_ser_grp_code,to_char(a.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, get_age(a.date_of_birth) age from IP_PATIENT_LAST_ENCOUNTER_VW a"+where_criteria.toString()+" and trunc(discharge_date_time) >= trunc(sysdate-"+no_of_days+") order by specialty_short_desc, practitioner_short_name, admission_date_time, encounter_id");
							}
							else
							{
							
									String order_by = "";
									
									if(sql.length() > 0) sql.delete(0,sql.length());
								
									sql.append(" select a.pre_dis_initiate_yn,a.room_num room_no, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2)bed_type_short_desc, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,TO_CHAR (a.admission_date_time,'rrrrmmdd hh24:mi') admission_date_time1 ,b.sex gender, am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc, a.nursing_unit_code, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_short_name, a.encounter_id, a.patient_id, to_char(b.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, get_age(b.date_of_birth) age , decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc, a.bed_num bed_no, a.blocked_bed_no, a.attend_practitioner_id practitioner_id, a.oth_adt_status, a.ip_leave_status, a.leave_expiry_date_time, decode(sign(( a.leave_expiry_date_time - sysdate)),-1,'Y','N') leave_flag, DECODE (a.pat_curr_locn_type, 'N', ip_get_desc.ip_nursing_unit (a.facility_id, a.pat_curr_locn_code, '"+locale+"', 2 ),'C', op_get_desc.op_clinic (a.facility_id, a.pat_curr_locn_code, '"+locale+"', '2' ), 'E', op_get_desc.op_clinic (a.facility_id, a.pat_curr_locn_code,'"+locale+"','2' ),'Y', op_get_desc.op_clinic (a.facility_id,  a.pat_curr_locn_code, '"+locale+"', '2'  ),  'O', (SELECT short_desc  FROM ot_oper_room_lang_vw   WHERE oper_room_code = a.pat_curr_locn_code  AND language_id ='"+locale+"'),'W', (SELECT short_desc   FROM rd_clinic_lang_vw  WHERE clinic_code = a.pat_curr_locn_code  AND language_id = '"+locale+"'),  'R', (SELECT short_desc  FROM am_facility_room_lang_vw   WHERE room_num = a.pat_curr_locn_code  AND language_id = '"+locale+"')) location_desc, a.patient_class,b.pat_dtls_unknown_yn,b.pat_ser_grp_code");

									
									

									
									sql.append(" from IP_OPEN_ENCOUNTER a, MP_PATIENT b");

									

									
									sql.append(" "+where_criteria.toString()+" AND a.patient_id = b.patient_id ");
												
										sql.append(" and a.patient_class in('"+pat_class+"') ")	;	
											

										

										order_by = " order by specialty_short_desc, practitioner_short_name, admission_date_time1 DESC ";
									
									
										sql.append(order_by); 
								
							}
						
					
				
		//out.println("sql.toString()-->"+sql.toString());
					int maxRecords=0;
			
					pstmt = con.prepareStatement(sql.toString());
					rs= pstmt.executeQuery();
					

						out.println("<table align='right' style='display:none' id='navigate_table'><tr><td aling ='right'>");
						if ( !(start <= 1) ){
								out.println("<A HREF='../jsp/MRLookupQueryResult.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&pat_class="+pat_class+"&param="+call_function+"&no_of_days="+no_of_days+"&modal="+modal+"&from="+(start-12)+"&to="+(end-12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&whereclausecount="+URLEncoder.encode(where_criteria_count.toString())+"&targetURL="+targetURL+"&confirmIP="+URLEncoder.encode(confirmIP)+"&called_from="+URLEncoder.encode(called_from)+"&menu_id="+URLEncoder.encode(menu_id)+"&disc_from_date="+URLEncoder.encode(disc_from_date)+"&chg_nurs_unit_in_assign_bed_yn="+chg_nurs_unit_in_assign_bed_yn+"&disc_to_date="+URLEncoder.encode(disc_to_date)+"&function_name="+URLEncoder.encode(function_name)+"&call_function="+URLEncoder.encode(call_func)+"&opst="+URLEncoder.encode(oper_stn_id)+"&function_id="+URLEncoder.encode(function_id)+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
						}
								out.println("<A  HREF='../jsp/MRLookupQueryResult.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&pat_class="+pat_class+"&param="+call_function+"&no_of_days="+no_of_days+"&modal="+modal+"&from="+(start+12)+"&to="+(end+12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&whereclausecount="+URLEncoder.encode(where_criteria_count.toString())+"&targetURL="+targetURL+"&confirmIP="+URLEncoder.encode(confirmIP)+"&called_from="+URLEncoder.encode(called_from)+"&menu_id="+URLEncoder.encode(menu_id)+"&disc_from_date="+URLEncoder.encode(disc_from_date)+"&chg_nurs_unit_in_assign_bed_yn="+chg_nurs_unit_in_assign_bed_yn+"&disc_to_date="+URLEncoder.encode(disc_to_date)+"&function_name="+URLEncoder.encode(function_name)+"&call_function="+ URLEncoder.encode(call_func) +"&opst="+URLEncoder.encode(oper_stn_id)+"&function_id="+URLEncoder.encode(function_id)+"'"+" text-decoration='none' style='display:none' id='next'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
								out.println("</td></tr></table></p>");
								out.println("<br><br>");				
					out.println(" <table cellspacing=0 cellpadding=0 align='center' width='130%' border='1' cellpadding=0 cellspacing=0>");
				
					out.println("<thead id='table_header' style='display:none'>");
								
								out.println("<tr>");
								out.println("<th>&nbsp;</th>");
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AdmissionDateTime.label","common_labels")+"&nbsp;"+"</th>");
								
							
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"&nbsp;"+"</th>");
							
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"&nbsp;"+"</th>");
								
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"&nbsp;"+"</th>");
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"&nbsp;"+"</th>");
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"&nbsp;"+"</th>");
								
								
								if (!show_bed_yn.equals("N")){ 
											out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+"&nbsp;"+"</th>");
												out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")+"&nbsp;"+"</th>");
										
												out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"&nbsp;"+"</th>");
												
												out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")+"&nbsp;"+"</th>");
											
								}
							
								
								
									out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.currentlocation.label","common_labels")+"&nbsp;"+"</th>");
							
								
								out.println("</tr>");
					out.println("</thead>");
				
							int initCount				= 1 ;
							int z						= 0 ;
							int records_to_show			= 12 ;
					if(rs!=null)
					{
						if ( start != 0 )
						{
							for( int j=1; j<start; i++,j++ )
							{
								rs.next() ;
							}
							initCount+=start;
							--initCount;
						}
									
						while (rs!=null && (z < records_to_show) && rs.next() )
						{
							
								if(maxRecords==0){%>
								<SCRIPT LANGUAGE="JavaScript">				
										document.getElementById("navigate_table").style.display="inline";
										document.getElementById("table_header").style.display="";		
								</SCRIPT>
							<%}//Added by kishore on 5/15/2004
								z++;
							admission_date_time=rs.getString("admission_date_time");
							if(admission_date_time == null) admission_date_time="&nbsp;";
							if(!admission_date_time.equals("&nbsp;")){
								adm_date_display = DateUtils.convertDate(admission_date_time,"DMYHM","en",locale); 
							}
							n_Age = 0;
							
							if ( !no_of_days.equals(""))
							{
								discharge_date_time=rs.getString("discharge_date_time");
								
							discharge_date_time_display_report=checkForNull(discharge_date_time);					
								
								if(discharge_date_time == null) discharge_date_time="&nbsp;";
								bed_no = rs.getString("bed_no");
								if(bed_no == null) bed_no="&nbsp;";
								
							}
							specialty_short_desc=rs.getString("specialty_short_desc");
							if(specialty_short_desc == null) specialty_short_desc="&nbsp;";
							encounter_id=rs.getString("encounter_id");
							if(encounter_id == null) encounter_id="";
							
							if(referral_id == null) referral_id="";

							
							
							
							Sex =rs.getString("gender");
							
							if(Sex == null )
								Sex="";
							else if (Sex.equals("M"))
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
							else if (Sex.equals("F"))
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
							else 
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

							patient_id = rs.getString("patient_id");
								if( patient_id == null) patient_id="";
							

							patient_name=rs.getString("patient_name");
							if ((patient_name == null) || (patient_name.equals("null"))) 
								patient_name="";
									nurs_unit_code =rs.getString("nursing_unit_code");
									if( nurs_unit_code == null) nurs_unit_code="";
								
								nursing_unit_short_desc=rs.getString("nursing_unit_short_desc");
									if(nursing_unit_short_desc== null) nursing_unit_short_desc="&nbsp;";

								  location_desc = rs.getString("location_desc");
									if(location_desc == null) location_desc = "&nbsp;";
								
								
								bed_no = rs.getString("bed_no");
								
								if( bed_no == null){ bed_no="&nbsp;";}

									if(bed_no == null) bed_no="&nbsp;";
								
								room_no = rs.getString("room_no");
									if( room_no == null) room_no="&nbsp;";

								bed_class_short_desc = rs.getString("bed_class_short_desc");
									if( bed_class_short_desc == null) bed_class_short_desc="&nbsp;";
								bed_type_short_desc = rs.getString("bed_type_short_desc");
									if( bed_type_short_desc == null) bed_type_short_desc="&nbsp;";
							
								practitioner_id=rs.getString("practitioner_id");
									if(practitioner_id == null) practitioner_id="";
							
							practitioner_name=rs.getString("practitioner_short_name");
								if((practitioner_name == null) || (practitioner_name.equals("null"))) 	practitioner_name="";

						 
								patient_class = rs.getString("patient_class");
									if((patient_class == null) || (patient_class.equals("null")))
										patient_class="";
							
								if(class_val.equals("QRYEVENSMALL"))
									class_val = "QRYODDSMALL";
								else
									class_val = "QRYEVENSMALL";
							
							out.println("<tr>");

							if(!(jsp_name.equals("") && modal.equals("") ) )
							{
								if(!prev_val.equals(specialty_short_desc) || !prev_val2.equals(practitioner_name) )
								{
									String disp_value = specialty_short_desc;
									if (!practitioner_name.equals(""))
										disp_value = disp_value+"/"+practitioner_name;

										
										out.println("<td class='CAGROUPHEADING' colspan='12' align='left'>"+disp_value+"</td></tr><tr>");
									
								}

								out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap> ");

								if(!call_function.equals("IPList"))
								{	
									out.print("<a href=\"javascript:closeWin('"+encounter_id+"','"+patient_id+"','N')\">+</a></td>");
								}
								
									discharge_date_time_display = "&nbsp;";
										if(!(discharge_date_time==null || discharge_date_time.equals("&nbsp;")))
											discharge_date_time_display = DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);
									
										out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+adm_date_display+"</td>");
										if(bed_no.equals("&nbsp;"))
										{
												
													out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+"" +"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','')\">"+encounter_id+"</a></td>");
										}
												
													if(pend_order_status.equals("Y")){
														result_count=1;
													}else{
														result_count=0;
													}

													out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+bed_no+"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','"+n_Age+"','','','"+discharge_date_time_display+"','"+maternal_death_yn+"','"+indicator+"','"+req_no+"','"+perm_fs_locn+"','','','','"+result_count+"','"+facility_id+"')\">"+encounter_id+"</a></td>");


												
												//10/16/2008 5089_MF-CRF-0017 enhance ment start
											
										
										
									
									
									
							}
							else
							{
								
								
								if(!prev_val.equals(specialty_short_desc) || !prev_val2.equals(practitioner_name) )
								{
									if ( !no_of_days.equals("") )		
									{ 
										String prac = rs.getString("practitioner_short_name");
										if(prac == null) prac = "";
										String disp_value = specialty_short_desc;
										if (!practitioner_name.equals(""))
											disp_value = disp_value+"/"+practitioner_name;
										String cols = "";
										
										
											cols = "13";
										

										if(bed_no.equals("")) bed_no="&nbsp;";
											out.println("<td class='CAGROUPHEADING' colspan='"+cols+"' align='left' nowrap>"+specialty_short_desc+"/"+prac+"</td></tr><tr>");
									}									
									else if ( !no_of_days.equals(""))		
									{
										
										String disp_value = specialty_short_desc;
										if (!practitioner_name.equals(""))
										disp_value = disp_value+"/"+practitioner_name;
										out.println("<td class='CAGROUPHEADING' colspan='10' align='left' nowrap>"+disp_value+"</td></tr><tr>");
									}
									else
									{
										out.println("<td class='CAGROUPHEADING' colspan='8' align='left' nowrap>"+specialty_short_desc+"/"+practitioner_name+"</td></tr><tr>");
									
									}
								}

									out.println("<td nowrap class='"+class_val+"'> ");
									String changeCallFunc = "";
									if( !no_of_days.equals("") && discharge_date_time != "&nbsp;")
										changeCallFunc = "Y";
									else
										changeCallFunc = "N";

									out.print("<a href=\"javascript:closeWin2('"+encounter_id+"','"+patient_id+"','"+changeCallFunc+"')\">");								
									out.print("+</a></td>" );
									out.println("<td nowrap class='"+class_val+"' nowrap>"+adm_date_display+"</td>");

								 discharge_date_time_display = "&nbsp;";
								if(!(discharge_date_time==null || discharge_date_time.equals("&nbsp;") || discharge_date_time.equals("")))
									discharge_date_time_display = DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);

								if (   !no_of_days.equals("") )	
								{
									
									out.println("<td nowrap class='"+class_val+"'>"+discharge_date_time_display+"</td>");
								}
									out.println("<td nowrap class='"+class_val+"'>"+encounter_id+"</td>");	
								
							}
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' >"+patient_id+"</td>");
							
							if ((patient_name.trim()).equals(""))
								patient_name = "&nbsp;";
							out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+patient_name+"</td>");
							
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+Sex+"</td>");
							out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+nursing_unit_short_desc+"</td>");
							
							if (!show_bed_yn.equals("N"))
							{
									out.println("<td style='background-color:"+color_code_scheme+"' nowrap class='"+class_val+"'>"+bed_class_short_desc+"</td>");
									out.println("<td style='background-color:"+color_code_scheme+"' nowrap class='"+class_val+"'>"+bed_type_short_desc+"</td>");
								
							}

							
							if (!show_bed_yn.equals("N"))
							{
									if(bed_no == null) bed_no  = "&nbsp;";
									out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+bed_no+"</td>");
								
								out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+room_no+"</td>");
								
							}
								out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+location_desc+"</td>");
							
							out.println("</tr>");
							prev_val  = specialty_short_desc;
							prev_val2 = practitioner_name;
							i++;
							maxRecords++;
						}//End of While
					}
				out.println("</table>");
				if(maxRecords<12 || !(rs.next())){ %>	
					<SCRIPT LANGUAGE="JavaScript">
						document.getElementById("next").style.display="none";
					</SCRIPT>
				<%}else{  %>	
					<SCRIPT LANGUAGE="JavaScript">
						document.getElementById("next").style.display="inline";
					</SCRIPT>			
				<%}
				if(maxRecords==0){%>
					<SCRIPT LANGUAGE="JavaScript">
						alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
					</SCRIPT>
				<%}
					
				%>
					<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >
					
					<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >
					<input type='hidden' name='called_from' id='called_from' value="<%=called_from%>" >
					<input type='hidden' name='win_height' id='win_height' value="<%=win_height%>" >
					<input type='hidden' name='win_width' id='win_width' value="<%=win_width%>" >
					<input type='hidden' name='dialogTop' id='dialogTop' value="<%=dialogTop%>" >
					<input type='hidden' name='modal' id='modal' value="<%=modal%>" >
					<input type='hidden' name='module' id='module' value="<%=module%>" >
					<input type='hidden' name='model_window' id='model_window' value="<%=model_window%>" >
					<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>" >
					<input type='hidden' name='function_name' id='function_name' value="<%=function_name%>" >
					<input type='hidden' name='routine_tfr_yn' id='routine_tfr_yn' value="<%=routine_tfr_yn%>" >
					<input type='hidden' name='no_of_days' id='no_of_days' value="<%=no_of_days%>" >
					<input type='hidden' name='prog_id' id='prog_id' value="<%=prog_id%>" >
					<input type='hidden' name='bl_install' id='bl_install' value="<%=bl_operational%>" >
					<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=p_practitioner_id%>" >
					<input type='hidden' name='total_count' id='total_count' value="<%=(i-1)%>" >
					<input type='hidden' name='targetURL' id='targetURL' value="<%=targetURL%>" >
					<input type='hidden' name='IPParamValue' id='IPParamValue' value="" >
					<input type='hidden' name='leave_exp_dt_flag' id='leave_exp_dt_flag' value="<%=leave_exp_dt_flag%>" >
					<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>" >
					<input type='hidden' name='bed_block_period_max' id='bed_block_period_max' value="<%=bed_block_period_max%>" >
					<input type='hidden' name='bl_install_yn' id='bl_install_yn' value="<%=bl_install_yn%>" >
					<input type='hidden' name='bl_interfaced_yn' id='bl_interfaced_yn' value="<%=bl_interfaced_yn%>" >
					<input type='hidden' name='bedBlock_normal' id='bedBlock_normal' value="<%=bedBlock_normal%>" >
					<input type='hidden' name='max_blk_type' id='max_blk_type' value="<%=max_blk_type%>" >
					<input type='hidden' name='oper_stn_id' id='oper_stn_id' value="<%=oper_stn_id%>" >
					<input type='hidden' name='setup_bl_dtls_in_ip_yn' id='setup_bl_dtls_in_ip_yn' value="<%=setup_bl_dtls_in_ip_yn%>" >
					<input type='hidden' name='allow_discharge_date' id='allow_discharge_date' value="<%=allow_discharge_date%>" >
					<input type='hidden' name='max_disch_period_for_dc' id='max_disch_period_for_dc' value="<%=max_disch_period_for_predc%>" >
					<input type='hidden' name='sStyle' id='sStyle' value="<%=sStyle%>" >
					<input type='hidden' name='chg_nurs_unit_in_assign_bed_yn' id='chg_nurs_unit_in_assign_bed_yn' value="<%=chg_nurs_unit_in_assign_bed_yn%>" >
					<input type='hidden' name='sys_dt_time' id='sys_dt_time' value="<%=sys_dt_time%>" >
					<input type='hidden' name='confirmIP' id='confirmIP' value="<%=confirmIP%>" >
					<input type='hidden' name='p_service_type' id='p_service_type' value="<%=p_service_type%>" >
					<input type='hidden' name='pat_check_in_allowed_yn' id='pat_check_in_allowed_yn' value="<%=pat_check_in_allowed_yn%>" >
					<input type='hidden' name='priotity_status' id='priotity_status' value="<%=priotity_status%>" >
					<input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value="<%=bed_class_allowed%>" >
					<input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value="<%=deactivate_pseudo_bed_yn%>" >
					<input type='hidden' name='dflt_blk_prd_for_tfr_out' id='dflt_blk_prd_for_tfr_out' value="<%=dflt_blk_prd_for_tfr_out%>" >
					<input type='hidden' name='bed_block_period_normal' id='bed_block_period_normal' value="<%=bed_block_period_normal%>" >
					<input type='hidden' name='change_adm_dtls_duration' id='change_adm_dtls_duration' value="<%=change_admission_dtls%>" >
					<input type='hidden' name='reserve_bed_on_tfr_yn' id='reserve_bed_on_tfr_yn' value="<%=reserve_bed_on_tfr_yn%>" >
					<input type='hidden' name='bed_block_period_max_type' id='bed_block_period_max_type' value="<%=bed_block_period_max_type%>" >
					<input type='hidden' name='allow_multiple_bed_for_resv_yn' id='allow_multiple_bed_for_resv_yn' value="<%=allow_multiple_bed_for_resv_yn%>" >
					<!-- venkat crf 41-->
				
					<input type='hidden' name='result_count' id='result_count' value="<%=result_count%>" >
					<input type='hidden' name='chc_for_pen_orders_bfr_dis_adv' id='chc_for_pen_orders_bfr_dis_adv' value="<%= chc_for_pen_orders_bfr_dis_adv%>">
					<input type='hidden' name='dis_adv_allow_yn' id='dis_adv_allow_yn' value='<%=dis_adv_allow_yn%>'>
		<!-- venkat crf 41-->
					<input type='hidden' name='chc_for_pen_orders_bfr_dischrg' id='chc_for_pen_orders_bfr_dischrg' value="<%= chc_for_pen_orders_bfr_dischrg%>">
					<input type='hidden' name='dischrg_allow_yn' id='dischrg_allow_yn' value='<%=dischrg_allow_yn%>'>

					<input type='hidden' name='allow_late_discharge_reason' id='allow_late_discharge_reason' value='<%=allow_late_discharge_reason%>'>
					<input type='hidden' name='disch_reason_mand_yn' id='disch_reason_mand_yn' value='<%=disch_reason_mand_yn%>'>
					<input type='hidden' name='transfer_wo_delink_yn' id='transfer_wo_delink_yn' value='<%=transfer_wo_delink_yn%>'><!-- Added for the CRF HSA-CRF 0035 -->

					<input type='hidden' name='CancelledReason' id='CancelledReason' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforRejection.label","common_labels")%>" >
					<input type='hidden' name='CancelledBy' id='CancelledBy' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.RejectedBy.label","ip_labels")%>" >
					<input type='hidden' name='CancelledDate' id='CancelledDate' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.RejectedDate.label","ip_labels")%>" >
					<input type='hidden' name='bed_no' id='bed_no' value="<%=bed_no%>" >
					<!-- 10/17/2008-->
					<input type='hidden' name='assign_bed' id='assign_bed' value=" " >
				
					<!-- 10/17/2008    end-->
		<!-- 0-7/09/2009    end-->
						<input type='hidden' name='deceased_date_time' id='deceased_date_time' value="<%=deceased_date_time%>" >
					<input type='hidden' name='maternal_death_yn' id='maternal_death_yn' value="<%=maternal_death_yn%> " >
					<input type='hidden' name='indicator' id='indicator' value="<%=indicator%>" >
					<input type='hidden' name='discharge_date_time' id='discharge_date_time' value="<%=discharge_date_time_display%>" >
					<input type='hidden' name='age' id='age' value="<%=age%>" >
					<input type='hidden' name='pre_disch_appl_yn' id='pre_disch_appl_yn' value="<%=pre_disch_appl_yn%>" ><!-- Added for the CRF -KDAH-CRF-0104  by Dharma    end-->
					<input type='hidden' name='weight_on_admn_mandatory' id='weight_on_admn_mandatory' value="<%=weight_on_admn_mandatory%>" > <!-- Added by Dharma on Oct27th against HSA-CRF-0181 [IN:049541] -->
					<input type='hidden' name='restriction_for_wardReturn' id='restriction_for_wardReturn' value="<%=chk_pen_ward_rtn_bfr_dis_adv%>" > <!-- Added by Sangeetha on 09-Nov-2016 against GHL-CRF-412.2 -->

				

					</form>


					<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
						<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
							<tr><td width='100%' id='column'></td></tr>
						</table>
					</div>

					</body>
					<% 

					
					
					
					if(rs != null)				rs.close();
					
					if(paramstmt != null)		paramstmt.close();
					if(paramrs != null)			paramrs.close();

				}catch(Exception e)
				{
					//out.println("Exception @tryCatch : "+e.getMessage());
					e.printStackTrace();
				}
				finally
				{
						out.print("<script>if(parent.frames[1].document.forms[0]!= null)");
						out.print("if(parent.frames[1].document.forms[0].search)");
						out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
					
				}

				
				
				
				if(rs != null)				rs.close();
				if(paramstmt != null)		paramstmt.close();
				if(paramrs != null)			paramrs.close();
			}
			
			catch(Exception e)
			{ 
				//out.println("Error in MRLookupQueryResult : "+e.toString());	
				e.printStackTrace();
			}
			finally
			{
				ConnectionManager.returnConnection(con,request);
			}
	}
	else
	if(pat_class.equals("OP")||pat_class.equals("EM"))
	{ 
		
		try
			{
				// Following Code is to Check the Module with Billing Interface 
				con							= ConnectionManager.getConnection(request);
				paramstmt					= con.createStatement();
				String bed_class_allowed    = "";

				String mp_param_table		= "";
				String mp_param_colns		= "";
				String mp_param_criteria	= "";
				String mother_cut_off_age	= "";
				String mother_max_age		= "";
				String mo_install_sql		= "";
				String mo_install_yn		= "";
				String pre_disch_appl_yn	= "";//Added for the CRF -KDAH-CRF-0104  by Dharma
				String pre_dis_initiate_yn	= "";//Added for the CRF -KDAH-CRF-0104  by Dharma
				String weight_on_admn_mandatory	= ""; //Added by Dharma on Oct27th against HSA-CRF-0181 [IN:049541] 

				
				
				
				
				
				paramrs = paramstmt.executeQuery(" SELECT weight_on_admn_mandatory,pre_disch_appl_yn,bl_interfaced_yn, setup_bl_dtls_in_ip_yn, pat_check_in_allowed_yn, discharge_checklist_app_yn, diag_update_period_max_unit,	TO_CHAR (SYSDATE, 'dd/mm/rrrr hh24:mi') serverdate,priority_applicable_yn, change_bed_class_yn, bed_block_period_dis, dis_date_chk_days, deactivate_pseudo_bed_yn,       dflt_blk_prd_for_tfr_out, bed_block_period_normal, lodger_max_srl_no, lodger_next_srl_no, max_stay_of_lodger_after_disc, dflt_gate_pass_period, dflt_gate_pass_unit, max_allowed_accom_pers,change_admission_dtls, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') sys_dt_time, reserve_bed_on_tfr_yn,RES_RESERVE_BED_INTRAWARD_YN,bed_block_period_max, bed_block_period_max_type, allow_multiple_bed_for_resv_yn, dis_date_chk_days, ALLOW_LATE_DISCHARGE_REASON, DISCH_REASON_MAND_YN, transfer_wo_delink_yn,dis_date_chk_days_unit,CHK_FOR_PEN_ORDERS_BFR_DIS_ADV,DIS_ADV_ALLOW_YN,CHK_FOR_PEN_ORDERS_BFR_DIS,DIS_ALLOW_YN,CHK_PEN_WARD_RTN_BFR_DIS_ADV, max_disch_period_for_dc,TO_CHAR (SYSDATE - DECODE (dis_date_chk_days_unit, 'H', dis_date_chk_days / 24, dis_date_chk_days),'dd/mm/rrrr hh24:mi') allow_discharge_date"+mp_param_colns+" "+mo_install_sql+" FROM IP_PARAM "+mp_param_table+" WHERE facility_id='"+facility_id+"' "+mp_param_criteria+" ");  // "CHK_PEN_WARD_RTN_BFR_DIS_ADV" Added by Sangeetha on 9-Nov-16 for GHL-CRF-412.2
			

				while(paramrs.next()){
						Lodger_Max_RefNo				= checkForNull(paramrs.getString("lodger_max_srl_no"));
						Lodger_Next_RefNo				= checkForNull(paramrs.getString("lodger_next_srl_no"));
						Lodger_Period					= checkForNull(paramrs.getString("max_stay_of_lodger_after_disc"));
						Acc_Period						= checkForNull(paramrs.getString("dflt_gate_pass_period"));
						Acc_Period_unit					= checkForNull(paramrs.getString("dflt_gate_pass_unit"));
						IP_param_No_Acc_Persons			= paramrs.getInt("max_allowed_accom_pers");
						bl_interfaced_yn				= checkForNull(paramrs.getString("bl_interfaced_yn"));
						setup_bl_dtls_in_ip_yn			= checkForNull(paramrs.getString("setup_bl_dtls_in_ip_yn"));
						pat_check_in_allowed_yn	        = checkForNull(paramrs.getString("pat_check_in_allowed_yn"));
						priotity_status					= checkForNull(paramrs.getString("priority_applicable_yn"));
						bed_class_allowed				= checkForNull(paramrs.getString("change_bed_class_yn"));
						deactivate_pseudo_bed_yn		= checkForNull(paramrs.getString("deactivate_pseudo_bed_yn"));
						bed_block_period_dis			= paramrs.getInt("bed_block_period_dis");
						dis_date_chk_days				= paramrs.getInt("dis_date_chk_days");
						dflt_blk_prd_for_tfr_out		= paramrs.getInt("dflt_blk_prd_for_tfr_out");
						bed_block_period_normal	        = paramrs.getInt("bed_block_period_normal");
						change_admission_dtls			= paramrs.getInt("change_admission_dtls");
						sys_dt_time						= paramrs.getString("sys_dt_time");
						reserve_bed_on_tfr_yn			= checkForNull(paramrs.getString("reserve_bed_on_tfr_yn"));
						res_reserve_bed_intraward_yn	= checkForNull(paramrs.getString("RES_RESERVE_BED_INTRAWARD_YN"));
						
						bed_block_period_max			= checkForNull(paramrs.getString("bed_block_period_max"));
						bed_block_period_max_type		= checkForNull(paramrs.getString("bed_block_period_max_type"));
						allow_multiple_bed_for_resv_yn	= checkForNull(paramrs.getString("allow_multiple_bed_for_resv_yn"),"N");
						max_disch_period_for_predc		= paramrs.getInt("max_disch_period_for_dc");
						allow_discharge_date_predc		= checkForNull(paramrs.getString("allow_discharge_date"));
						discharge_checklist_app_yn		= checkForNull(paramrs.getString("discharge_checklist_app_yn"));
						dis_date_chk_days_unit			= checkForNull(paramrs.getString("dis_date_chk_days_unit"));
						diag_update_period_max_unit		= checkForNull(paramrs.getString("diag_update_period_max_unit"));
						serverdate						= checkForNull(paramrs.getString("serverdate"));
					// Below code added by venkatesh on 09/November/2011 against the KDAH-CRF-0041
						chc_for_pen_orders_bfr_dis_adv=checkForNull(paramrs.getString("CHK_FOR_PEN_ORDERS_BFR_DIS_ADV"));
						dis_adv_allow_yn=checkForNull(paramrs.getString("DIS_ADV_ALLOW_YN"));

						chk_pen_ward_rtn_bfr_dis_adv=checkForNull(paramrs.getString("CHK_PEN_WARD_RTN_BFR_DIS_ADV")); //Added by Sangeetha on 9-Nov-16 for GHL-CRF-412.2
							
						// venkatesh KDAH-CRF-0041 END
						
						chc_for_pen_orders_bfr_dischrg =checkForNull(paramrs.getString("CHK_FOR_PEN_ORDERS_BFR_DIS"));
						dischrg_allow_yn  =checkForNull(paramrs.getString("DIS_ALLOW_YN"));

						allow_late_discharge_reason=checkForNull(paramrs.getString("allow_late_discharge_reason"));
						disch_reason_mand_yn=checkForNull(paramrs.getString("disch_reason_mand_yn"));
						transfer_wo_delink_yn=checkForNull(paramrs.getString("transfer_wo_delink_yn"));//Added for the CRF HSA-CRF-0035
						
						if(call_function.equals("PrepareDischargeAdvice")){
							mother_cut_off_age			= checkForNull(paramrs.getString("mother_cut_off_age"));
							mother_max_age				= checkForNull(paramrs.getString("mother_max_age"));
						}
						if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
							mo_install_yn				=  checkForNull(paramrs.getString("mo_install_yn"),"N");
						pre_disch_appl_yn	= checkForNull(paramrs.getString("pre_disch_appl_yn"));//Added for the CRF -KDAH-CRF-0104  by Dharma
						weight_on_admn_mandatory = checkForNull(paramrs.getString("weight_on_admn_mandatory"));//Added by Dharma on Oct27th against HSA-CRF-0181 [IN:049541] 
						
				}	

				if(paramrs != null)			paramrs.close();
				if(paramstmt != null)		paramstmt.close();
				//Added by kishore on 5/15/2004
				%>
				<html>
			<head>
				<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
				<script src='../../eCommon/js/dchk.js' language='javascript'></script>
				<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
				<script src='../../eCommon/js/common.js' language='javascript'></script>
				<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
				<Script src="../../eIP/js/IPLookup.js" language="JavaScript"></Script>
				<script src="../../eMR/js/MRPatientMovementHistory.js" language="JavaScript" ></script> 
			<script>
			
				</script>
				<%
				try
				{

					String nurs_unit_code		= "";
					StringBuffer where_criteria = new StringBuffer();
					StringBuffer where_criteria_count = new StringBuffer();
					StringBuffer sql			= new StringBuffer();
					String class_val			= "QRYODDSMALL";
					String bl_install_yn		=	checkForNull(request.getParameter("bl_install_yn"));
					String bedBlock_normal		=	checkForNull(request.getParameter("bedBlock_normal"));
					String max_blk_type			=	checkForNull(request.getParameter("max_blk_type"));
					String whereClause			=	checkForNull(request.getParameter("whereclause"));
					String whereClauseCount		=	checkForNull(request.getParameter("whereclausecount"));
					String from					=	checkForNull(request.getParameter("from"));
					String to					=	checkForNull(request.getParameter("to"));
					String Qloc1			=	checkForNull(request.getParameter("Qloc1"));
					String Qloctype			=	checkForNull(request.getParameter("Qloctype")); // Qloc
					String Qloc			=	checkForNull(request.getParameter("Qloc"));
					String no_of_days			=	checkForNull(request.getParameter("no_of_days"));
					String nursing_unit_code	=	checkForNull(request.getParameter("nursing_unit"));
					String from_nursing_unit	=	checkForNull(request.getParameter("from_nursing_unit"));
					String to_nursing_unit_code	=	checkForNull(request.getParameter("to_nursing_unit"));
					String to_Splcode			=	checkForNull(request.getParameter("to_Splcode"));
					String speciality_code		=	checkForNull(request.getParameter("speciality_code")); // practid_desc
					String from_Splcode			=	checkForNull(request.getParameter("from_Splcode"));
					String encounter_id			=	checkForNull(request.getParameter("encounter_id1"));
					
					String practitioner_id		=	checkForNull(request.getParameter("practid1")); 
					String from_practid			=	checkForNull(request.getParameter("from_practid"));
					String from_date			=	checkForNull(request.getParameter("from_date1"));
					if(!from_date.equals(""))
						from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 
					String to_date				=	checkForNull(request.getParameter("to_date1"));
					if(!to_date.equals(""))
						to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 
					String chk_in_lodger_min_date= checkForNull(request.getParameter("chk_in_lodger_min_date"));
					String patient_id			=	checkForNull(request.getParameter("patient_id"));
					String gender				=	checkForNull(request.getParameter("gender"));
					String Modified_By				=	checkForNull(request.getParameter("user_name"));
					String modified_date_from	=	checkForNull(request.getParameter("modified_from_date"));
					if(!modified_date_from.equals(""))
						modified_date_from = DateUtils.convertDate(modified_date_from,"DMY",locale,"en"); 
					String modified_date_to		=	checkForNull(request.getParameter("modified_to_date"));
					if(!modified_date_to.equals(""))
						modified_date_to = DateUtils.convertDate(modified_date_to,"DMY",locale,"en"); 
					
					String name_prefix			=	checkForNull(request.getParameter("name_prefix"));
					String name_suffix			=	checkForNull(request.getParameter("name_suffix"));
					String first_name			=	checkForNull(request.getParameter("first_name"));
					String second_name			=	checkForNull(request.getParameter("second_name"));
					String third_name			=	checkForNull(request.getParameter("third_name"));
					String family_name			=	checkForNull(request.getParameter("family_name"));
					//Added by kumar on 18/03/2003 for Malaysia Enhancements
					String searchby				=	checkForNull(request.getParameter("`"), "S");
					String pat_name_as_multipart_yn = checkForNull(request.getParameter("pat_name_as_multipart_yn"));
					String patient_name			= "";
					String nursing_unit_short_desc= "";
					String service_short_desc	= "";
					String subservice_short_desc="";
					String bed_no				= "";
					int baby_count				= 0;
					String room_no				= "";
					String bed_class_short_desc	= "";
					String bed_type_short_desc	= "";
					String to_nursing_unit_short_desc = "";
					String to_bed_class_short_desc = "";
					String to_bed_type_short_desc = "";
					String blocked_bedno		= "";
					String specialty_short_desc	= "";
					String referral_id			= "";
					String practitioner_name	= "";
					String prev_val				= "";
					String prev_val2			= "";
					String Sex					= "";
					String visit_adm_date_time	= "";
					String adm_date_display		= "";
					String discharge_date_time	= "";
					String adt_status			= "";
					String patient_status		= "";
					String ip_leave_status		= "";
					String leave_exp_dt			= "";
					String leave_exp_dt_flag	= "N";
					String date_of_birth		= "";
					String priority				= "";
					String priority_code		= "";
					String pat_dtls_unknown_yn	= "";
					String contact1_name		= "";
					String contact2_name		= "";


					//Added by Devang for Spl. chars
					name_prefix				= singleToDoubleQuotes(name_prefix);
					name_suffix				= singleToDoubleQuotes(name_suffix);
					nursing_unit_code		= singleToDoubleQuotes(nursing_unit_code);
					from_nursing_unit		= singleToDoubleQuotes(from_nursing_unit);
					from_Splcode			= singleToDoubleQuotes(from_Splcode);
					speciality_code			= singleToDoubleQuotes(speciality_code);
					to_nursing_unit_code	= singleToDoubleQuotes(to_nursing_unit_code);
					to_Splcode				= singleToDoubleQuotes(to_Splcode);
					from_practid			= singleToDoubleQuotes(from_practid);
					practitioner_id			= singleToDoubleQuotes(practitioner_id);
					String jsp_name			= checkForNull(request.getParameter("jsp_name"));
					//out.println("jsp_name:"+jsp_name);
					String called_from		= checkForNull(request.getParameter("called_from"));
					String win_height		= checkForNull(request.getParameter("win_height"));
					String dialogTop		= checkForNull(request.getParameter("dialogTop"));
					String win_width		= checkForNull(request.getParameter("win_width"));
					String modal			= checkForNull(request.getParameter("modal"));
					//out.println("modal:"+modal);
					String module			= checkForNull(request.getParameter("module"));
					String model_window		= checkForNull(request.getParameter("model_window"));
				//	String function_id		= checkForNull(request.getParameter("function_id"));


					String prog_id			= checkForNull(request.getParameter("prog_id"));
					String p_practitioner_id= checkForNull(request.getParameter("practitioner_id"));
					call_func				= checkForNull(request.getParameter("call_function"));
					String Disc_Chk			= checkForNull(request.getParameter("Disc_Chk"));
					String bed_class_code	= checkForNull(request.getParameter("Bedcode"));
					String bed_type_code	= checkForNull(request.getParameter("bed_type_code"));
					String cancelled_id		= checkForNull(request.getParameter("cancel_pract_id")); 
					String cancel_reason_desc		= "";
					String discharge_type_desc		= "";
					String discharge_status_desc	= "";
					String location_desc	= "";
					String location_type = "";
					String patient_class	= "";
					//out.println("whereClause::"+whereClause);
						 



					
					%>
					</head>
					<body onMouseDown='CodeArrest()' onKeyDown='lockKey()' >
					<form name='iplookupqueryresult' id='iplookupqueryresult'>
					
					<%
					if(whereClause.equals(""))
					{
						
								where_criteria.append(" where a.facility_id='");
								where_criteria.append(facility_id);
								where_criteria.append("' ");
							
							
							
							
						

					

						
						/*if(!wherecondn.equals(""))
						{
							
								if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
								{
										where_criteria.append(" and a.nursing_unit_code='"+nursing_unit_code+"' ");
									
								}
								else
								{
										where_criteria.append(" and exists (Select locn_code from AM_OS_USER_LOCN_ACCESS_VW b where b.facility_id = a.facility_id and b.locn_code = a.nursing_unit_code and b.locn_type = 'N' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+login_user+"' ");

																		
											where_criteria.append(" and b.");
											where_criteria.append(wherecondn);
											where_criteria.append("='Y' )"); 

								}
							
							
						}*/
						//else
						//{				
							if(Qloc!=null && !Qloc.equals(""))
							{
									where_criteria.append(" and a.ASSIGN_CARE_LOCN_CODE='");
									where_criteria.append(Qloc);
									where_criteria.append("' ");
								
							}
						//}
						
						
							if(speciality_code!=null && !speciality_code.equals(""))
							{
									where_criteria.append(" and specialty_code='");
									where_criteria.append(speciality_code);
									where_criteria.append("' ");
							}

							if(practitioner_id!=null && !practitioner_id.equals(""))
							{
									
									
										where_criteria.append(" and a.attend_practitioner_id='");
										where_criteria.append(practitioner_id);
										where_criteria.append("' ");
									
									
							}
					
							if(from_date!=null && !from_date.equals(""))
							{
									where_criteria.append(" and trunc(a.VISIT_ADM_DATE_TIME) >= to_date('");
									where_criteria.append(from_date);
									where_criteria.append("' , 'dd/mm/rrrr') ");
								
							}	
							if(to_date!=null && !to_date.equals(""))
							{
									where_criteria.append(" and trunc(a.VISIT_ADM_DATE_TIME) <= to_date('");
									where_criteria.append(to_date);
									where_criteria.append("' , 'dd/mm/rrrr') ");
								
							}
								
							
						

						
							if(patient_id!=null && !patient_id.equals("")){
								
									where_criteria.append(" and a.patient_id like '");
									where_criteria.append(patient_id);
									where_criteria.append("%' ");
								
							}

							if(encounter_id != null && !encounter_id.equals(""))
							{
									where_criteria.append(" and a.encounter_id='");
									where_criteria.append(encounter_id);
									where_criteria.append("' ");
								
							}	

							

							

							
								
								
						
						
					
								

						if( clinic_list.length() >= 4)
						{
							where_criteria.append(" and nursing_unit_code in ");
							where_criteria.append(clinic_list);
							where_criteria.append("");
						}

						
						
					}//E.O BUILDING WHERE-CLAUSE
					else
					{
						where_criteria.append( whereClause) ;
						where_criteria_count.append( whereClauseCount) ;
					}
					int start = 0 ;
					int end = 0 ;
					int i=1;
					
					if (from.equals(""))
						start = 1 ;
					else
						start = Integer.parseInt( from ) ;
					
					if (to.equals(""))
						end = 12 ;
					else
						end = Integer.parseInt( to ) ;
					

					
					
							
							
									String order_by = "";
									
									if(sql.length() > 0) sql.delete(0,sql.length());
								
									//sql.append(" select a.pre_dis_initiate_yn,a.room_num room_no, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2)bed_type_short_desc, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, b.sex gender, am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc, a.nursing_unit_code, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_short_name, a.encounter_id, a.patient_id, to_char(b.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, get_age(b.date_of_birth) age , decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc, a.bed_num bed_no, a.blocked_bed_no, a.attend_practitioner_id practitioner_id, a.oth_adt_status, a.ip_leave_status, a.leave_expiry_date_time, decode(sign(( a.leave_expiry_date_time - sysdate)),-1,'Y','N') leave_flag, DECODE (a.pat_curr_locn_type, 'N', ip_get_desc.ip_nursing_unit (a.facility_id, a.pat_curr_locn_code, '"+locale+"', 2 ), 'R', a.pat_curr_locn_code, op_get_desc.op_clinic (a.facility_id, a.pat_curr_locn_code, '"+locale+"', 1)) location_desc, a.patient_class,b.pat_dtls_unknown_yn,b.pat_ser_grp_code");
									
									
									sql.append("SELECT TO_CHAR (a.visit_adm_date_time, 'dd/mm/rrrr hh24:mi') visit_date_time,TO_CHAR (a.visit_adm_date_time, 'rrrrmmdd hh24:mi') visit_date_time1,a.encounter_id, b.patient_id, b.patient_name, DECODE (sex, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender,DECODE (assign_care_locn_type,'C', 'Clinic','E', 'Procedure Unit')location_type,DECODE(a.assign_care_locn_type,'C', op_get_desc.op_clinic (a.facility_id, assign_care_locn_code,'"+locale+"','1'), 'E', op_get_desc.op_clinic (a.facility_id,assign_care_locn_code,'"+locale+"','1')) location_desc,am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc,am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_short_name ");
									
									
									
									

									
									

									
									sql.append("  from  pr_encounter a, mp_patient b ");

									

									
									sql.append(" "+where_criteria.toString()+" AND a.patient_id = b.patient_id ");
												
										sql.append(" and a.patient_class in('"+pat_class+"') and visit_status != '09' AND discharge_date_time IS NULL  ")	;	
											

										

										order_by = " order by specialty_short_desc, practitioner_short_name, visit_date_time1 DESC ";
									
									
										sql.append(order_by); 
								
							
						
					
				
			//out.println("sql.toString()-->"+sql.toString());
					int maxRecords=0;
			
					pstmt = con.prepareStatement(sql.toString());
					rs= pstmt.executeQuery();
					

						out.println("<table align='right' style='display:none' id='navigate_table'><tr><td align ='right'>");
						if ( !(start <= 1) ){
								out.println("<A HREF='../jsp/MRLookupQueryResult.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&pat_class="+pat_class+"&param="+call_function+"&no_of_days="+no_of_days+"&modal="+modal+"&from="+(start-12)+"&to="+(end-12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&whereclausecount="+URLEncoder.encode(where_criteria_count.toString())+"&targetURL="+targetURL+"&confirmIP="+URLEncoder.encode(confirmIP)+"&called_from="+URLEncoder.encode(called_from)+"&menu_id="+URLEncoder.encode(menu_id)+"&disc_from_date="+URLEncoder.encode(disc_from_date)+"&chg_nurs_unit_in_assign_bed_yn="+chg_nurs_unit_in_assign_bed_yn+"&disc_to_date="+URLEncoder.encode(disc_to_date)+"&function_name="+URLEncoder.encode(function_name)+"&call_function="+URLEncoder.encode(call_func)+"&opst="+URLEncoder.encode(oper_stn_id)+"&function_id="+URLEncoder.encode(function_id)+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
						}
								out.println("<A  HREF='../jsp/MRLookupQueryResult.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&pat_class="+pat_class+"&param="+call_function+"&no_of_days="+no_of_days+"&modal="+modal+"&from="+(start+12)+"&to="+(end+12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&whereclausecount="+URLEncoder.encode(where_criteria_count.toString())+"&targetURL="+targetURL+"&confirmIP="+URLEncoder.encode(confirmIP)+"&called_from="+URLEncoder.encode(called_from)+"&menu_id="+URLEncoder.encode(menu_id)+"&disc_from_date="+URLEncoder.encode(disc_from_date)+"&chg_nurs_unit_in_assign_bed_yn="+chg_nurs_unit_in_assign_bed_yn+"&disc_to_date="+URLEncoder.encode(disc_to_date)+"&function_name="+URLEncoder.encode(function_name)+"&call_function="+ URLEncoder.encode(call_func) +"&opst="+URLEncoder.encode(oper_stn_id)+"&function_id="+URLEncoder.encode(function_id)+"'"+" text-decoration='none' style='display:none' id='next'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
								out.println("</td></tr></table></p>");
								out.println("<br><br>");				
					out.println(" <table cellspacing=0 cellpadding=0 align='center' width='130%' border='1' cellpadding=0 cellspacing=0>");
				
					out.println("<thead id='table_header' style='display:none'>");
								
								out.println("<tr>");
								out.println("<th>&nbsp;</th>");
			out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitDate.label","common_labels")+"/"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</th>");
								
							
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"&nbsp;"+"</th>");
							
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"&nbsp;"+"</th>");
								
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"&nbsp;"+"</th>");
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"&nbsp;"+"</th>");
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels")+"&nbsp;"+"</th>");
								out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"&nbsp;"+"</th>");
								
							
								
								out.println("</tr>");
					out.println("</thead>");
				
							int initCount				= 1 ;
							int z						= 0 ;
							int records_to_show			= 12 ;
					if(rs!=null)
					{
						if ( start != 0 )
						{
							for( int j=1; j<start; i++,j++ )
							{
								rs.next() ;
							}
							initCount+=start;
							--initCount;
						}
									
						while (rs!=null && (z < records_to_show) && rs.next() )
						{
							
								if(maxRecords==0){%>
								<SCRIPT LANGUAGE="JavaScript">				
										document.getElementById("navigate_table").style.display="inline";
										document.getElementById("table_header").style.display="";		
								</SCRIPT>
							<%}//Added by kishore on 5/15/2004
								z++;
							visit_adm_date_time=rs.getString("visit_date_time");
							if(visit_adm_date_time == null) visit_adm_date_time="&nbsp;";
							if(!visit_adm_date_time.equals("&nbsp;")){
								adm_date_display = DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale); 
							}
							n_Age = 0;
							
							
							
							encounter_id=rs.getString("encounter_id");
							if(encounter_id == null) encounter_id="";
							
							if(referral_id == null) referral_id="";

							
							
							
							Sex =rs.getString("gender");
							
							if(Sex == null )
								Sex="";
							else if (Sex.equals("Male"))
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
							else if (Sex.equals("Female"))
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
							else 
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

							patient_id = rs.getString("patient_id");
								if( patient_id == null) patient_id="";
							

							patient_name=rs.getString("patient_name");
							if ((patient_name == null) || (patient_name.equals("null"))) 
								patient_name="";
									

								  location_desc = rs.getString("location_desc");
									if(location_desc == null) location_desc = "&nbsp;";
								
								
								location_type = rs.getString("location_type");
									if(location_type == null) location_type = "&nbsp;";  // specialty_short_desc
								
								specialty_short_desc = rs.getString("specialty_short_desc");
									if(specialty_short_desc == null) specialty_short_desc = "&nbsp;";
									
								practitioner_name=rs.getString("practitioner_short_name");
								if((practitioner_name == null) || (practitioner_name.equals("null"))) 	practitioner_name="";
							

						 
								
							
								if(class_val.equals("QRYEVENSMALL"))
									class_val = "QRYODDSMALL";
								else
									class_val = "QRYEVENSMALL";
							
							out.println("<tr>");

							if(!(jsp_name.equals("") && modal.equals("") ) )
							{
								if(!prev_val.equals(specialty_short_desc) || !prev_val2.equals(practitioner_name) )
								{
									String disp_value = specialty_short_desc;
									if (!practitioner_name.equals(""))
										disp_value = disp_value+"/"+practitioner_name;

										
										out.println("<td class='CAGROUPHEADING' colspan='12' align='left'>"+disp_value+"</td></tr><tr>");
									
								}

								out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap> ");

								if(!call_function.equals("IPList"))
								{	
									out.print("<a href=\"javascript:closeWin('"+encounter_id+"','"+patient_id+"','N')\">+</a></td>");
								}
								
									discharge_date_time_display = "&nbsp;";
										if(!(discharge_date_time==null || discharge_date_time.equals("&nbsp;")))
											discharge_date_time_display = DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);
									
										out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+adm_date_display+"</td>");
										if(bed_no.equals("&nbsp;"))
										{
												
													out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+"" +"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','')\">"+encounter_id+"</a></td>");
										}
												
													if(pend_order_status.equals("Y")){
														result_count=1;
													}else{
														result_count=0;
													}

													out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+bed_no+"','"+patient_class+"','"+color_code_scheme+"','"+status_value+"','"+tfr_req_stat+"','"+n_Age+"','','','"+discharge_date_time_display+"','"+maternal_death_yn+"','"+indicator+"','"+req_no+"','"+perm_fs_locn+"','','','','"+result_count+"','"+facility_id+"')\">"+encounter_id+"</a></td>");


												
												//10/16/2008 5089_MF-CRF-0017 enhance ment start
											
										
										
									
									
									
							}
							else
							{
								
								
								if(!prev_val.equals(specialty_short_desc) || !prev_val2.equals(practitioner_name) )
								{
									if ( !no_of_days.equals("") )		
									{ 
										String prac = rs.getString("practitioner_short_name");
										if(prac == null) prac = "";
										String disp_value = specialty_short_desc;
										if (!practitioner_name.equals(""))
											disp_value = disp_value+"/"+practitioner_name;
										String cols = "";
										
										
											cols = "13";
										

										if(bed_no.equals("")) bed_no="&nbsp;";
											out.println("<td class='CAGROUPHEADING' colspan='"+cols+"' align='left' nowrap>"+specialty_short_desc+"/"+prac+"</td></tr><tr>");
									}									
									else if ( !no_of_days.equals(""))		
									{
										
										String disp_value = specialty_short_desc;
										if (!practitioner_name.equals(""))
										disp_value = disp_value+"/"+practitioner_name;
										out.println("<td class='CAGROUPHEADING' colspan='10' align='left' nowrap>"+disp_value+"</td></tr><tr>");
									}
									else
									{
										out.println("<td class='CAGROUPHEADING' colspan='8' align='left' nowrap>"+specialty_short_desc+"/"+practitioner_name+"</td></tr><tr>");
									
									}
								}

									out.println("<td nowrap class='"+class_val+"'> ");
									String changeCallFunc = "";
									if( !no_of_days.equals("") && discharge_date_time != "&nbsp;")
										changeCallFunc = "Y";
									else
										changeCallFunc = "N";

									out.print("<a href=\"javascript:closeWin1('"+encounter_id+"','"+patient_id+"','"+changeCallFunc+"')\">");								
									out.print("+</a></td>" );
									out.println("<td nowrap class='"+class_val+"' nowrap>"+adm_date_display+"</td>");

								 discharge_date_time_display = "&nbsp;";
								if(!(discharge_date_time==null || discharge_date_time.equals("&nbsp;") || discharge_date_time.equals("")))
									discharge_date_time_display = DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);

								if (   !no_of_days.equals("") )	
								{
									
									out.println("<td nowrap class='"+class_val+"'>"+discharge_date_time_display+"</td>");
								}
									out.println("<td nowrap class='"+class_val+"'>"+encounter_id+"</td>");	
								
							}
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' >"+patient_id+"</td>");
							
							if ((patient_name.trim()).equals(""))
								patient_name = "&nbsp;";
							out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+patient_name+"</td>");
							
							out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+Sex+"</td>");
							out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+location_type+"</td>");
							
							
								out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+location_desc+"</td>");
							
							out.println("</tr>");
							prev_val  = specialty_short_desc;
							prev_val2 = practitioner_name;
							i++;
							maxRecords++;
						}//End of While
					}
				out.println("</table>");
				if(maxRecords<12 || !(rs.next())){ %>	
					<SCRIPT LANGUAGE="JavaScript">
						document.getElementById("next").style.display="none";
					</SCRIPT>
				<%}else{  %>	
					<SCRIPT LANGUAGE="JavaScript">
						document.getElementById("next").style.display="inline";
					</SCRIPT>			
				<%}
				if(maxRecords==0){%>
					<SCRIPT LANGUAGE="JavaScript">
						alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
					</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



				<%}
					
				%>
					<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >
					
					<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >
					<input type='hidden' name='called_from' id='called_from' value="<%=called_from%>" >
					<input type='hidden' name='win_height' id='win_height' value="<%=win_height%>" >
					<input type='hidden' name='win_width' id='win_width' value="<%=win_width%>" >
					<input type='hidden' name='dialogTop' id='dialogTop' value="<%=dialogTop%>" >
					<input type='hidden' name='modal' id='modal' value="<%=modal%>" >
					<input type='hidden' name='module' id='module' value="<%=module%>" >
					<input type='hidden' name='model_window' id='model_window' value="<%=model_window%>" >
					<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>" >
					<input type='hidden' name='function_name' id='function_name' value="<%=function_name%>" >
					<input type='hidden' name='routine_tfr_yn' id='routine_tfr_yn' value="<%=routine_tfr_yn%>" >
					<input type='hidden' name='no_of_days' id='no_of_days' value="<%=no_of_days%>" >
					<input type='hidden' name='prog_id' id='prog_id' value="<%=prog_id%>" >
					<input type='hidden' name='bl_install' id='bl_install' value="<%=bl_operational%>" >
					<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=p_practitioner_id%>" >
					<input type='hidden' name='total_count' id='total_count' value="<%=(i-1)%>" >
					<input type='hidden' name='targetURL' id='targetURL' value="<%=targetURL%>" >
					<input type='hidden' name='IPParamValue' id='IPParamValue' value="" >
					<input type='hidden' name='leave_exp_dt_flag' id='leave_exp_dt_flag' value="<%=leave_exp_dt_flag%>" >
					<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>" >
					<input type='hidden' name='bed_block_period_max' id='bed_block_period_max' value="<%=bed_block_period_max%>" >
					<input type='hidden' name='bl_install_yn' id='bl_install_yn' value="<%=bl_install_yn%>" >
					<input type='hidden' name='bl_interfaced_yn' id='bl_interfaced_yn' value="<%=bl_interfaced_yn%>" >
					<input type='hidden' name='bedBlock_normal' id='bedBlock_normal' value="<%=bedBlock_normal%>" >
					<input type='hidden' name='max_blk_type' id='max_blk_type' value="<%=max_blk_type%>" >
					<input type='hidden' name='oper_stn_id' id='oper_stn_id' value="<%=oper_stn_id%>" >
					<input type='hidden' name='setup_bl_dtls_in_ip_yn' id='setup_bl_dtls_in_ip_yn' value="<%=setup_bl_dtls_in_ip_yn%>" >
					<input type='hidden' name='allow_discharge_date' id='allow_discharge_date' value="<%=allow_discharge_date%>" >
					<input type='hidden' name='max_disch_period_for_dc' id='max_disch_period_for_dc' value="<%=max_disch_period_for_predc%>" >
					<input type='hidden' name='sStyle' id='sStyle' value="<%=sStyle%>" >
					<input type='hidden' name='chg_nurs_unit_in_assign_bed_yn' id='chg_nurs_unit_in_assign_bed_yn' value="<%=chg_nurs_unit_in_assign_bed_yn%>" >
					<input type='hidden' name='sys_dt_time' id='sys_dt_time' value="<%=sys_dt_time%>" >
					<input type='hidden' name='confirmIP' id='confirmIP' value="<%=confirmIP%>" >
					<input type='hidden' name='p_service_type' id='p_service_type' value="<%=p_service_type%>" >
					<input type='hidden' name='pat_check_in_allowed_yn' id='pat_check_in_allowed_yn' value="<%=pat_check_in_allowed_yn%>" >
					<input type='hidden' name='priotity_status' id='priotity_status' value="<%=priotity_status%>" >
					<input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value="<%=bed_class_allowed%>" >
					<input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value="<%=deactivate_pseudo_bed_yn%>" >
					<input type='hidden' name='dflt_blk_prd_for_tfr_out' id='dflt_blk_prd_for_tfr_out' value="<%=dflt_blk_prd_for_tfr_out%>" >
					<input type='hidden' name='bed_block_period_normal' id='bed_block_period_normal' value="<%=bed_block_period_normal%>" >
					<input type='hidden' name='change_adm_dtls_duration' id='change_adm_dtls_duration' value="<%=change_admission_dtls%>" >
					<input type='hidden' name='reserve_bed_on_tfr_yn' id='reserve_bed_on_tfr_yn' value="<%=reserve_bed_on_tfr_yn%>" >
					<input type='hidden' name='bed_block_period_max_type' id='bed_block_period_max_type' value="<%=bed_block_period_max_type%>" >
					<input type='hidden' name='allow_multiple_bed_for_resv_yn' id='allow_multiple_bed_for_resv_yn' value="<%=allow_multiple_bed_for_resv_yn%>" >
					<!-- venkat crf 41-->
				
					<input type='hidden' name='result_count' id='result_count' value="<%=result_count%>" >
					<input type='hidden' name='chc_for_pen_orders_bfr_dis_adv' id='chc_for_pen_orders_bfr_dis_adv' value="<%= chc_for_pen_orders_bfr_dis_adv%>">
					<input type='hidden' name='dis_adv_allow_yn' id='dis_adv_allow_yn' value='<%=dis_adv_allow_yn%>'>
		<!-- venkat crf 41-->
					<input type='hidden' name='chc_for_pen_orders_bfr_dischrg' id='chc_for_pen_orders_bfr_dischrg' value="<%= chc_for_pen_orders_bfr_dischrg%>">
					<input type='hidden' name='dischrg_allow_yn' id='dischrg_allow_yn' value='<%=dischrg_allow_yn%>'>

					<input type='hidden' name='allow_late_discharge_reason' id='allow_late_discharge_reason' value='<%=allow_late_discharge_reason%>'>
					<input type='hidden' name='disch_reason_mand_yn' id='disch_reason_mand_yn' value='<%=disch_reason_mand_yn%>'>
					<input type='hidden' name='transfer_wo_delink_yn' id='transfer_wo_delink_yn' value='<%=transfer_wo_delink_yn%>'><!-- Added for the CRF HSA-CRF 0035 -->

					<input type='hidden' name='CancelledReason' id='CancelledReason' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforRejection.label","common_labels")%>" >
					<input type='hidden' name='CancelledBy' id='CancelledBy' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.RejectedBy.label","ip_labels")%>" >
					<input type='hidden' name='CancelledDate' id='CancelledDate' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.RejectedDate.label","ip_labels")%>" >
					<input type='hidden' name='bed_no' id='bed_no' value="<%=bed_no%>" >
					<!-- 10/17/2008-->
					<input type='hidden' name='assign_bed' id='assign_bed' value=" " >
				
					<!-- 10/17/2008    end-->
		<!-- 0-7/09/2009    end-->
						<input type='hidden' name='deceased_date_time' id='deceased_date_time' value="<%=deceased_date_time%>" >
					<input type='hidden' name='maternal_death_yn' id='maternal_death_yn' value="<%=maternal_death_yn%> " >
					<input type='hidden' name='indicator' id='indicator' value="<%=indicator%>" >
					<input type='hidden' name='discharge_date_time' id='discharge_date_time' value="<%=discharge_date_time_display%>" >
					<input type='hidden' name='age' id='age' value="<%=age%>" >
					<input type='hidden' name='pre_disch_appl_yn' id='pre_disch_appl_yn' value="<%=pre_disch_appl_yn%>" ><!-- Added for the CRF -KDAH-CRF-0104  by Dharma    end-->
					<input type='hidden' name='weight_on_admn_mandatory' id='weight_on_admn_mandatory' value="<%=weight_on_admn_mandatory%>" > <!-- Added by Dharma on Oct27th against HSA-CRF-0181 [IN:049541] -->
					<input type='hidden' name='restriction_for_wardReturn' id='restriction_for_wardReturn' value="<%=chk_pen_ward_rtn_bfr_dis_adv%>" > <!-- Added by Sangeetha on 09-Nov-2016 against GHL-CRF-412.2 -->

				

					</form>


					<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
						<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
							<tr><td width='100%' id='column'></td></tr>
						</table>
					</div>

					</body>
					<% 

					
					
					
					if(rs != null)				rs.close();
					
					if(paramstmt != null)		paramstmt.close();
					if(paramrs != null)			paramrs.close();

				}catch(Exception e)
				{
					//out.println("Exception @tryCatch : "+e.getMessage());
					e.printStackTrace();
				}
				finally
				{
						out.print("<script>if(parent.frames[1].document.forms[0]!= null)");
						out.print("if(parent.frames[1].document.forms[0].search)");
						out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
					
				}

				
				
				
				if(rs != null)				rs.close();
				if(paramstmt != null)		paramstmt.close();
				if(paramrs != null)			paramrs.close();
			}
			
			catch(Exception e)
			{ 
				//out.println("Error in MRLookupQueryResult : "+e.toString());	
				e.printStackTrace();
			}
			finally
			{
				ConnectionManager.returnConnection(con,request);
			}	
		
		
	}
	

%>
</html>

<%!
	// By Annadurai 2/23/2004 starts., to handle NullPointerException.
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

