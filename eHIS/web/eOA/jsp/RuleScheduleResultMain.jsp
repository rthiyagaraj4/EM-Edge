<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<%
	String sStyle	=
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eOA/js/RuleBasedSchAppointment.js" language="JavaScript"></Script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con =null;
	PreparedStatement pstmt=null;
	CallableStatement cstmt=null;
	Statement stmt=null;
	ResultSet rs=null;
	String locale				= (String)session.getAttribute("LOCALE");
	String facility_id			= (String)session.getValue("facility_id");
	String patient_id			= checkForNull(request.getParameter("patient_id"));
	String name_prefix			= checkForNull(request.getParameter("name_prefix"));
	String first_name			= checkForNull(request.getParameter("first_name"));
	String second_name			= checkForNull(request.getParameter("second_name"));
	String third_name			= checkForNull(request.getParameter("third_name"));
	String family_name			= checkForNull(request.getParameter("family_name"));
	String name_suffix			= checkForNull(request.getParameter("name_suffix"));
	String name_prefix_oth_lang	= checkForNull(request.getParameter("name_prefix_oth_lang"));
	String first_name_oth_lang	= checkForNull(request.getParameter("first_name_oth_lang"));
	String second_name_oth_lang	= checkForNull(request.getParameter("second_name_oth_lang"));
	String third_name_oth_lang	= checkForNull(request.getParameter("third_name_oth_lang"));
	String family_name_oth_lang	= checkForNull(request.getParameter("family_name_oth_lang"));
	String name_suffix_oth_lang	= checkForNull(request.getParameter("name_suffix_oth_lang"));
	String gender				= checkForNull(request.getParameter("gender"));
	String contact_no			= checkForNull(request.getParameter("contact_no"));
	//String oper_stn_id		= checkForNull(request.getParameter("oper_stn_id"));
	String speciality			= checkForNull(request.getParameter("speciality"));
	String care_locn_ind		= checkForNull(request.getParameter("care_locn_ind"));
	String prefdate				= checkForNull(request.getParameter("prefdate1"));
	String From_timeval			= checkForNull(request.getParameter("From_timeval"));
	String To_timeval			= checkForNull(request.getParameter("To_timeval"));
	String term_set_id			= checkForNull(request.getParameter("term_set_id"));
	String linking_code			= checkForNull(request.getParameter("linking_code"));
	String transfer_YN			= checkForNull(request.getParameter("transfer_YN"));
	String resource_class		= checkForNull(request.getParameter("resource_class"));
	String language_code		= checkForNull(request.getParameter("language_code"));
	String prefDate_is_sysDate	= checkForNull(request.getParameter("prefDate_is_sysDate"));
	String clinic				= checkForNull(request.getParameter("clinic"));
	String nationality_code		= checkForNull(request.getParameter("nationality_code"));
	String order_id				= checkForNull(request.getParameter("order_id"));
	String order_line_num		= checkForNull(request.getParameter("order_line_num"));
	String order_catalog_code	= checkForNull(request.getParameter("order_catalog_code"));
	String prefPractYN			= "N";

	int freeSlotCount=0;
	int scheduledPractCount	= 0;
	int oldSchAvailbleCount=0;
	int opConsStatsCount=0;
	int maxFreeSlotCount = 0;
	float f1 =new Float("0.0");
	float f2 =new Float("0.0");
	int max_new_patients=0;
	int max_old_patients=0;
	int new_pat_pract_specCnt=0;
	int new_pat_pract_not_specific=0;
	int old_pat_pract_specCnt=0;
	int old_pat_pract_not_specific=0;
	Float floatTemp1 = new Float("0.0");
	Float floatTemp2 = new Float("0.0");
	Float floatTemp3 = new Float("0.0");
	StringBuffer scheduleSQl=new StringBuffer();
	String practString = null;
	String all_day_yn = "";
	String no_weeks_for_rule = "";
	String slot_appt_ctrl="";
	String visit_limit_rule="";
	String alcn_criteria="";
	String override_no_of_slots_yn="";
	String capture_fin_dtls_yn="";
	String min_ela_per_resc_noshow_in_day="";
	String noshow_ctrl_by_splty_or_clinic="";
	String contact_num_reqd_yn="";
	String no_of_noshow_appts_for_alert="";
	String per_chk_for_no_show_alert="";
	String db_clinic_code="";
	String db_pract_id="";
	String db_start_time="";
	String db_end_time="";
	String db_data="";
	StringTokenizer token=null;
	HashMap hashMap=new HashMap();//This HashMap Conatins all the data and most operations are performed on this HashMap only.
	HashMap hashMapTemp = null;
	ArrayList practArray=new ArrayList();
	ArrayList prefPractArray =  new ArrayList();
	ArrayList sortedPractList = null;
	Iterator iterator	= null;
	String	practStr =new String();
	String practId_temp			=null;
	String practName_temp		=null;
	String clinicCode_temp		=null;
	String clinicName_temp		=null;
	String fromTime_temp		=null;
	String toTime_temp			=null;
	String time_table_type_temp	=null;
	String prefPractID = "";
	String clinicIdString = null;
	String maxGlobalBooking 	="0";
	String totalGlobalBooking 	="0";
	boolean rule_defined=false;
	ArrayList schPractList 	= new ArrayList();//to store practitioner id when there is tie at max free slot count.
	ArrayList apptPractList = new ArrayList();//to store practitioner id when there is tie at Least Recently Appointment.
	int apptCount = 0; // Using at Appointment counts for identifying least Recently Appointment
	prefdate = com.ehis.util.DateUtils.convertDate(prefdate,"DMY",locale,"en");
	//String slot_slabSQL="SELECT practitioner_id, to_char(slot_slab_start_time,'hh24:mi')start_time,to_char(slot_slab_end_time,'hh24:mi')end_time,schedule_status,clinic_code FROM oa_clinic_schedule_slot_slab WHERE clinic_date = TO_DATE (?, 'dd/mm/yyyy')  AND resource_class = 'P' AND speciality_code = ? AND facility_id = ? AND schedule_status IS NULL AND (    TO_CHAR (slot_slab_start_time, 'HH24:mi') BETWEEN ? AND ? AND TO_CHAR (slot_slab_end_time, 'HH24:mi') BETWEEN ? AND ?) order by practitioner_id";
	StringBuffer slot_slabSQL=new StringBuffer();
	String oa_paramSQL="select slot_appt_ctrl,visit_limit_rule,ALCN_CRITERIA,override_no_of_slots_yn,CAPTURE_FIN_DTLS_YN,MIN_ELA_PER_RESC_NOSHOW_IN_DAY,NOSHOW_CTRL_BY_SPLTY_OR_CLINIC,CONTACT_NUM_REQD_YN,NO_OF_NOSHOW_APPTS_FOR_ALERT ,PER_CHK_FOR_NO_SHOW_ALERT from oa_param where module_id='OA'";
	//String op_cons_statsSQL="select max_new_patients, max_old_patients,old_pat_pract_specific_cnt,old_pat_pract_not_specific_cnt, new_pat_pract_specific_cnt,new_pat_pract_not_specific_cnt from op_consultation_stats where practitioner_id=? and day_no=(select to_char(TO_DATE (?, 'dd/mm/yyyy'),'D') dya_no from dual)";
	//String op_cons_statsSQL="select practitioner_id,max_new_patients, max_old_patients,old_pat_pract_specific_cnt,old_pat_pract_not_specific_cnt, new_pat_pract_specific_cnt,new_pat_pract_not_specific_cnt from op_consultation_stats where practitioner_id=?";
	//String op_cons_statsSQL="select sum(max_new_patients)max_new_patients, sum(max_old_patients)max_old_patients,sum(old_pat_pract_specific_cnt)old_pat_pract_specific_cnt,sum(old_pat_pract_not_specific_cnt)old_pat_pract_not_specific_cnt, sum(new_pat_pract_specific_cnt)new_pat_pract_specific_cnt,sum(new_pat_pract_not_specific_cnt)new_pat_pract_not_specific_cnt from op_consultation_stats where practitioner_id = ?";
	StringBuffer op_cons_statsSQL=new StringBuffer();
	//String inv_visit_frm_ca="select (SELECT INV_VISITREGN_MPQ_FROM_CA_YN FROM op_param WHERE OPERATING_FACILITY_ID='"+fcid+"')INV_VISITREGN_MPQ_FROM_CA_YN ,(select to_char(sysdate,'dd/mm/yyyy') system_date from dual)system_date,ALCN_CRITERIA from oa_param where module_id='OA'";
	String day_qry="select to_char(to_date('"+prefdate+"','dd/mm/yyyy'),'Day') dy,to_char(sysdate,'dd/mm/yyyy') sysdt,to_char(sysdate,'hh24:mi') systm from dual";
	String day="";
	String sys_date="";
	String systm="";
	String care_locn_type_ind="";
	String apptStatusCountSQL="";
	int consulted =0;
	int not_consulted =0;
			
	%>
	<body>
		<form name='rule_sch_appt_form' id='rule_sch_appt_form'>
<%	try{
		con = ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		rs = stmt.executeQuery(day_qry);
		rs.next();
		day=rs.getString("dy");
		sys_date=rs.getString("sysdt");
		systm=rs.getString("systm");			
		String ruleSQl = "select NO_WEEKS_FOR_RULE, ALL_DAY_YN from oa_rule_appt_schedule";
		pstmt = con.prepareStatement(ruleSQl);
		if(rs!=null)rs.close();
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next()){
			rule_defined = true;
			all_day_yn			= checkForNull(rs.getString("ALL_DAY_YN"));
			no_weeks_for_rule	= checkForNull(rs.getString("NO_WEEKS_FOR_RULE"));
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		if(rule_defined){
			pstmt = con.prepareStatement(oa_paramSQL);
			rs=pstmt.executeQuery();
			while(rs!=null && rs.next()){
				slot_appt_ctrl=checkForNull(rs.getString("slot_appt_ctrl"));
				visit_limit_rule=checkForNull(rs.getString("visit_limit_rule"));
				alcn_criteria=checkForNull(rs.getString("ALCN_CRITERIA"));
				override_no_of_slots_yn=checkForNull(rs.getString("override_no_of_slots_yn"));
				capture_fin_dtls_yn=checkForNull(rs.getString("CAPTURE_FIN_DTLS_YN"));
				min_ela_per_resc_noshow_in_day=checkForNull(rs.getString("MIN_ELA_PER_RESC_NOSHOW_IN_DAY"));
				noshow_ctrl_by_splty_or_clinic=checkForNull(rs.getString("NOSHOW_CTRL_BY_SPLTY_OR_CLINIC"));
				contact_num_reqd_yn=checkForNull(rs.getString("CONTACT_NUM_REQD_YN"));
				no_of_noshow_appts_for_alert=checkForNull(rs.getString("NO_OF_NOSHOW_APPTS_FOR_ALERT"));
				per_chk_for_no_show_alert=checkForNull(rs.getString("PER_CHK_FOR_NO_SHOW_ALERT"));
			}
			//out.println("prefdate :"+prefdate);
			if(rs!=null)rs.close();
		slot_slabSQL.append("SELECT a.PRACTITIONER_ID||'|'||AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,?,'1')||'|'||a.CLINIC_CODE||'|'||OP_GET_DESC.OP_CLINIC(?, a.CLINIC_CODE, ?, '1')||'|'||TO_CHAR(MIN(a.SLOT_SLAB_START_TIME),'HH24:MI')||'|'||TO_CHAR(MIN(a.SLOT_SLAB_END_TIME),'HH24:MI')||'|'||a.TIME_TABLE_TYPE data, c.CARE_LOCN_TYPE_IND,c.MAX_GLOBAL_BOOKING,c.TOTAL_GLOBAL_BOOKED  FROM oa_clinic_schedule_slot_slab a");
			if(!linking_code.equals("")){
				slot_slabSQL.append(",oa_pract_proc_link b");
			}
			slot_slabSQL.append(" ,oa_clinic_schedule c WHERE  c.facility_id = ? AND c.clinic_date = TO_DATE (?, 'dd/mm/yyyy')  AND c.resource_class = 'P' AND c.PRIMARY_RESOURCE_YN ='Y' AND c.speciality_code = ? and c.schedule_status IS NULL AND c.facility_id=a.facility_id AND c.clinic_code = a.clinic_code AND c.clinic_date = a.clinic_date  AND c.practitioner_id = a.practitioner_id AND c.resource_class = a.resource_class AND a.schedule_status IS NULL AND (    TO_CHAR (a.slot_slab_start_time, 'HH24:mi') BETWEEN ? AND ? AND TO_CHAR (a.slot_slab_end_time, 'HH24:mi') BETWEEN ? AND ?) AND ((a.clinic_date = trunc(sysdate) and TO_CHAR (a.slot_slab_start_time, 'HH24:mi') >= TO_CHAR (sysdate, 'HH24:mi')) or (a.clinic_date != trunc(sysdate)))");
			if(care_locn_ind !=null && !care_locn_ind.equals("")){
				slot_slabSQL.append(" and a.CARE_LOCN_TYPE_IND = ?");
			}
			if(clinic !=null && !clinic.equals("")){
				slot_slabSQL.append(" and c.clinic_code = ?");
			}
			if(resource_class !=null && !resource_class.equals(""))
				slot_slabSQL.append(" and c.resource_class = ? ");
			/*if(patient_id.equals("")){
				slot_slabSQL.append(" AND (c.clinic_date = trunc(sysdate) or nvl(c.MAX_NEW_PATIENTS,0) > nvl(c.TOTAL_NEW_PATIENTS_BOOKED,0))");
			}*/
			if(!linking_code.equals("")){
				slot_slabSQL.append(" AND a.practitioner_id = b.practitioner_id");
				slot_slabSQL.append(" AND b.PROC_CODING_SCHEME = ?");
				slot_slabSQL.append(" AND b.PROC_CODE = ? AND EFF_STATUS='Y'");
			}
			if(!order_catalog_code.equals("")){
				slot_slabSQL.append(" AND EXISTS (SELECT 1 FROM op_catalog_for_clinic Z WHERE facility_id = ? AND z.clinic_code = c.clinic_code AND (ORDER_CATALOG_CODE = ? OR EXISTS (SELECT 1 FROM or_order_set_component WHERE order_set_code = z.order_catalog_code AND order_catalog_code = ?)))");
			}
			slot_slabSQL.append(" GROUP BY a.practitioner_id,a.clinic_code,a.TIME_TABLE_TYPE,c.CARE_LOCN_TYPE_IND,c.MAX_GLOBAL_BOOKING,c.TOTAL_GLOBAL_BOOKED");
			//System.out.println("slot_slabSQL :"+slot_slabSQL.toString());
			pstmt = con.prepareStatement(slot_slabSQL.toString());
			int setCounter=1;
			pstmt.setString(setCounter++,locale);
			pstmt.setString(setCounter++,facility_id);
			pstmt.setString(setCounter++,locale);
			pstmt.setString(setCounter++,facility_id);
			pstmt.setString(setCounter++,prefdate);
			pstmt.setString(setCounter++,speciality);			
			pstmt.setString(setCounter++,From_timeval);
			pstmt.setString(setCounter++,To_timeval);
			pstmt.setString(setCounter++,From_timeval);
			pstmt.setString(setCounter++,To_timeval);
			if(care_locn_ind !=null && !care_locn_ind.equals("")){
				pstmt.setString(setCounter++,care_locn_ind);
			}
			if(clinic !=null && !clinic.equals("")){
				pstmt.setString(setCounter++,clinic);
			}
			if(resource_class !=null && !resource_class.equals("")){
				pstmt.setString(setCounter++,resource_class);
			}else{
				//pstmt.setString(11,"%");
			}	
			if(!linking_code.equals("")){
				pstmt.setString(setCounter++,term_set_id);
				pstmt.setString(setCounter++,linking_code);
			}
			if(!order_catalog_code.equals("")){
				pstmt.setString(setCounter++,facility_id);
				pstmt.setString(setCounter++,order_catalog_code);
				pstmt.setString(setCounter++,order_catalog_code);
			}
			rs=pstmt.executeQuery();
			while(rs!=null && rs.next()){
				freeSlotCount++;
				/*db_clinic_code=checkForNull(rs.getString("clinic_code"));
				db_pract_id=checkForNull(rs.getString("practitioner_id"));
				db_start_time=checkForNull(rs.getString("start_time"));
				db_end_time=checkForNull(rs.getString("end_time"));*/
				db_data=checkForNull(rs.getString("data"));
				care_locn_type_ind=checkForNull(rs.getString("CARE_LOCN_TYPE_IND"));
				maxGlobalBooking 	= checkForNull(rs.getString("MAX_GLOBAL_BOOKING"),"0");
				totalGlobalBooking 	= checkForNull(rs.getString("TOTAL_GLOBAL_BOOKED"),"0");
				token=new StringTokenizer(db_data,"|");
				if(token.hasMoreTokens()){
					practId_temp		= token.nextToken();
					practName_temp		= token.nextToken();
					clinicCode_temp		= token.nextToken();
					clinicName_temp		= token.nextToken();
					fromTime_temp		= token.nextToken();
					toTime_temp			= token.nextToken();
					time_table_type_temp= token.nextToken();
				}
				if(freeSlotCount == 1){
					db_clinic_code	= clinicCode_temp;
					db_pract_id		= practId_temp;
					db_start_time	= fromTime_temp;
					db_end_time		= toTime_temp;
					practStr		= "'"+practId_temp+"'";
				}else{
					if(practArray.contains(practId_temp)){// Avoid the same practitioner having the scheule with other clinic in the user specified time and it will get first free slot clinic only
						continue;
					}
					practStr=practStr+",'"+practId_temp+"'";
				}
				hashMapTemp=new HashMap();
				hashMapTemp.put("pract_id",practId_temp);
				hashMapTemp.put("pract_name",practName_temp);
				hashMapTemp.put("clinic_code",clinicCode_temp);
				hashMapTemp.put("clinic_name",clinicName_temp);
				hashMapTemp.put("from_time",fromTime_temp);
				hashMapTemp.put("to_time",toTime_temp);
				hashMapTemp.put("time_table_type",time_table_type_temp);
				hashMapTemp.put("max_new_patients",max_new_patients);
				hashMapTemp.put("max_old_patients",max_old_patients);
				hashMapTemp.put("new_pat_pract_specCnt",new_pat_pract_specCnt);
				hashMapTemp.put("new_pat_pract_not_specific",new_pat_pract_not_specific);
				hashMapTemp.put("old_pat_pract_specCnt",old_pat_pract_specCnt);
				hashMapTemp.put("old_pat_pract_not_specific",old_pat_pract_not_specific);
				hashMapTemp.put("entl_perc_new",f1);
				hashMapTemp.put("entl_perc_old",f1);
				hashMapTemp.put("actual_cons_perc_new",f1);
				hashMapTemp.put("actual_cons_perc_old",f1);
				hashMapTemp.put("act_by_ent_perc_new",f1);
				hashMapTemp.put("actual_by_ent_perc_old",f1);
				hashMapTemp.put("care_locn_type_ind",care_locn_type_ind);
				hashMapTemp.put("maxGlobalBooking",maxGlobalBooking);
				hashMapTemp.put("totalGlobalBooking",totalGlobalBooking);
				hashMap.put(practId_temp,hashMapTemp);
				practArray.add(practId_temp);
				prefPractArray.add(practId_temp);
			}		
			if(rs!=null)rs.close();
			if(freeSlotCount > 1){//We have more than one free slots available for Appointment
				int entld_new_patients_total=0;
				int entld_old_patients_total=0;
				max_new_patients=0;
				max_old_patients=0;
				new_pat_pract_specCnt=0;
				new_pat_pract_not_specific=0;
				old_pat_pract_specCnt=0;
				old_pat_pract_not_specific=0;
				int new_pat_pract_not_specific_total=0;
				int total_new_pract_specCnt=0;
				int total_old_pract_specCnt=0;
				int old_pat_pract_not_specific_total=0;
				int actual_new_pat_cnt=0;
				int actual_new_pat_cnt_total=0;
				int actual_old_pat_cnt_total=0;
				boolean op_cons_data = false;
				//scheduleSQlBuffer.append("SELECT practitioner_id,sum(MAX_NEW_PATIENTS)MAX_NEW_PATIENTS,sum(MAX_OLD_PATIENTS)MAX_OLD_PATIENTS FROM oa_clinic_schedule WHERE facility_id = ? AND speciality_code = ? AND practitioner_id in ("+practStr+") and clinic_date < trunc(sysdate)  /*AND clinic_date BETWEEN TRUNC (SYSDATE) - 20 * 7 AND TRUNC(SYSDATE) AND TO_CHAR(clinic_date,'DAY') = TO_CHAR(TO_DATE (?, 'DD/MM/YYYY'),'DAY')*/ group by practitioner_id");
				scheduleSQl.append("SELECT practitioner_id,sum(MAX_NEW_PATIENTS)MAX_NEW_PATIENTS,sum(MAX_OLD_PATIENTS)MAX_OLD_PATIENTS FROM oa_clinic_schedule WHERE facility_id = ? AND speciality_code = ? AND practitioner_id in ("+practStr+") and clinic_date < trunc(sysdate)");
				if(all_day_yn.equals("Y")){
					scheduleSQl.append(" AND clinic_date BETWEEN TRUNC (SYSDATE) - "+no_weeks_for_rule+" * 7 AND TRUNC(SYSDATE)");
				}else{
					scheduleSQl.append(" AND clinic_date BETWEEN TRUNC (SYSDATE) - "+no_weeks_for_rule+" * 7 AND TRUNC(SYSDATE) AND TO_CHAR(clinic_date,'DAY') = TO_CHAR(TO_DATE (?, 'DD/MM/YYYY'),'DAY')");
				}
				scheduleSQl.append(" group by practitioner_id");
				if(rs!=null)rs.close();
				//System.out.println("scheduleSQl :"+scheduleSQl.toString());
				pstmt = con.prepareStatement(scheduleSQl.toString());
				pstmt.setString(1,facility_id);
				pstmt.setString(2,speciality);
				if(!all_day_yn.equals("Y")){
					pstmt.setString(3,prefdate);
				}
				rs=pstmt.executeQuery();
				//out.println("After scheduleSQl :");
				oldSchAvailbleCount = 0;
				while(rs!=null && rs.next()){
					oldSchAvailbleCount++;
					practId_temp = rs.getString("practitioner_id");
					max_new_patients=Integer.parseInt(rs.getString("MAX_NEW_PATIENTS")==null?"0":rs.getString("MAX_NEW_PATIENTS"));
					max_old_patients=Integer.parseInt(rs.getString("MAX_OLD_PATIENTS")==null?"0":rs.getString("MAX_OLD_PATIENTS"));
					entld_new_patients_total=entld_new_patients_total+max_new_patients;
					entld_old_patients_total=entld_old_patients_total+max_old_patients;
					hashMapTemp	= (HashMap)hashMap.get(practId_temp);
					hashMapTemp.put("max_new_patients",max_new_patients);
					hashMapTemp.put("max_old_patients",max_old_patients);
					hashMap.put(practId_temp,hashMapTemp);
				}
				//out.println("oldSchAvailbleCount :"+oldSchAvailbleCount);
				if(oldSchAvailbleCount > 0){//Get the data from op_consultation_stats and apply the rule...
					op_cons_statsSQL.append("SELECT practitioner_id,clinic_code,sum(old_pat_pract_specific_cnt)old_pat_pract_specific_cnt,sum(old_pat_pract_not_specific_cnt)old_pat_pract_not_specific_cnt, sum(new_pat_pract_specific_cnt)new_pat_pract_specific_cnt,sum(new_pat_pract_not_specific_cnt)new_pat_pract_not_specific_cnt FROM op_consultation_stats WHERE FACILITY_ID = ? and specialty_code = ? and practitioner_id IN ("+practStr+") ");
					if(rs != null)rs.close();
					if(pstmt != null)pstmt.close();
					if(all_day_yn.equals("Y")){
						op_cons_statsSQL.append(" AND clinic_date BETWEEN TRUNC (SYSDATE) - "+no_weeks_for_rule+" * 7 AND TRUNC(SYSDATE) and clinic_date < trunc(sysdate)");
					}else{
						op_cons_statsSQL.append(" AND clinic_date BETWEEN TRUNC (SYSDATE) - "+no_weeks_for_rule+" * 7 AND TRUNC(SYSDATE)and clinic_date < trunc(sysdate) AND TO_CHAR(clinic_date,'DAY') = TO_CHAR(TO_DATE (?, 'DD/MM/YYYY'),'DAY')");
					}
					op_cons_statsSQL.append(" group by clinic_code,practitioner_id");
					pstmt = con.prepareStatement(op_cons_statsSQL.toString());
					//System.out.println("op_cons_statsSQL :"+op_cons_statsSQL.toString());
					pstmt.setString(1,facility_id);
					pstmt.setString(2,speciality);
					if(!all_day_yn.equals("Y")){
						pstmt.setString(3,prefdate);
					}
					rs=pstmt.executeQuery();
					//out.println("After op_cons_statsSQL :");
					while(rs!=null && rs.next()){
						opConsStatsCount++;
						new_pat_pract_specCnt=0;
						new_pat_pract_not_specific=0;
						old_pat_pract_specCnt=0;
						old_pat_pract_not_specific=0;
						practId_temp = rs.getString("practitioner_id");
						new_pat_pract_specCnt=new_pat_pract_specCnt+Integer.parseInt(rs.getString("NEW_PAT_PRACT_SPECIFIC_CNT")==null?"0":rs.getString("NEW_PAT_PRACT_SPECIFIC_CNT"));
						new_pat_pract_not_specific=new_pat_pract_not_specific+Integer.parseInt(rs.getString("NEW_PAT_PRACT_NOT_SPECIFIC_CNT")==null?"0":rs.getString("NEW_PAT_PRACT_NOT_SPECIFIC_CNT"));
						old_pat_pract_specCnt=old_pat_pract_specCnt+Integer.parseInt(rs.getString("OLD_PAT_PRACT_SPECIFIC_CNT")==null?"0":rs.getString("OLD_PAT_PRACT_SPECIFIC_CNT"));
						old_pat_pract_not_specific=old_pat_pract_not_specific+Integer.parseInt(rs.getString("OLD_PAT_PRACT_NOT_SPECIFIC_CNT")==null?"0":rs.getString("OLD_PAT_PRACT_NOT_SPECIFIC_CNT"));
						new_pat_pract_not_specific_total = new_pat_pract_not_specific_total+new_pat_pract_not_specific;
						old_pat_pract_not_specific_total = old_pat_pract_not_specific_total+old_pat_pract_not_specific;
						actual_new_pat_cnt_total=actual_new_pat_cnt_total+new_pat_pract_specCnt+new_pat_pract_not_specific;
						actual_old_pat_cnt_total=actual_old_pat_cnt_total+old_pat_pract_specCnt+old_pat_pract_not_specific;
						hashMapTemp	= (HashMap)hashMap.get(practId_temp);
						hashMapTemp.put("new_pat_pract_specCnt",new_pat_pract_specCnt);
						hashMapTemp.put("new_pat_pract_not_specific",new_pat_pract_not_specific);
						hashMapTemp.put("old_pat_pract_specCnt",old_pat_pract_specCnt);
						hashMapTemp.put("old_pat_pract_not_specific",old_pat_pract_not_specific);
						hashMap.put(practId_temp,hashMapTemp);
					}
					HashMap keyValueMap=new HashMap();
					if(opConsStatsCount >=1){//even if there are more than 1 record from oop_cons_stats then we have to apply the rule
						iterator=practArray.iterator();
						while(iterator.hasNext()){
							practId_temp=(String)iterator.next();
							hashMapTemp	= (HashMap)hashMap.get(practId_temp);						
							if(patient_id.equals("")){// Rule Calculation for New Patients.
								max_new_patients = ((Integer)hashMapTemp.get("max_new_patients")).intValue();							
								f1=max_new_patients;
								f2=entld_new_patients_total;
								if(f1 == 0 || f2 == 0){
									floatTemp1=new Float("0.0");
								}else{
									floatTemp1=new Float((f1)/f2);
								}
								hashMapTemp.put("entl_perc_new",floatTemp1);
								// for New patients  f1 = total new patients pract not specific count(of particular practitioner) minus total old patients pract not specific count(of particular practitioner)
								// for New patients  f2 = total new patients pract not specific count(of all practitioner) minus total old patients pract not specific count(of all practitioner)
								f1=((Integer)hashMapTemp.get("new_pat_pract_not_specific")).intValue()-((Integer)hashMapTemp.get("old_pat_pract_not_specific")).intValue();
								f2=new_pat_pract_not_specific_total-old_pat_pract_not_specific_total;
								if(f1 == 0 || f2 == 0){
									floatTemp2=new Float("0.0");
								}else{
									floatTemp2=new Float((f1)/f2);
								}
								if(floatTemp1 == 0 || floatTemp2 == 0){
									floatTemp3=new Float("0.0");
								}else{
									floatTemp3=new Float(floatTemp2/floatTemp1);//consulted raio/entitled ratio
								}
								hashMapTemp.put("actual_cons_perc_new",floatTemp2);
								hashMapTemp.put("act_by_ent_perc_new",floatTemp3);
								keyValueMap.put(practId_temp,floatTemp3);
							}else{						
								// Rule Calculation for Old Patients.
								max_old_patients = ((Integer)hashMapTemp.get("max_old_patients")).intValue();
								f1 = max_old_patients;
								f2 = entld_old_patients_total;
								if(f1 == 0 || f2 == 0){
									floatTemp1=new Float("0.0");
								}else{
									floatTemp1=new Float((f1)/f2);
								}
								hashMapTemp.put("entl_perc_old",floatTemp1);							
								old_pat_pract_not_specific = ((Integer)hashMapTemp.get("old_pat_pract_not_specific")).intValue();
								f1 = old_pat_pract_not_specific;
								f2 = old_pat_pract_not_specific_total;
								if(f1 == 0 || f2 == 0){
									floatTemp2=new Float("0.0");
								}else{
									floatTemp2=new Float((f1)/f2);
								}
								if(floatTemp1 ==0 || floatTemp2 == 0){
									floatTemp3=new Float("0.0");
								}else{
									floatTemp3=new Float(floatTemp2/floatTemp1);
								}
								hashMapTemp.put("actual_cons_perc_old",floatTemp2);
								hashMapTemp.put("actual_by_ent_perc_old",floatTemp3);
								keyValueMap.put(practId_temp,floatTemp3);							
							}
							hashMap.put(practId_temp,hashMapTemp);
						}
						List mapKeys = new ArrayList(keyValueMap.keySet());
						List unsortedMapValues = new ArrayList(keyValueMap.values());
						List sortedMapValues = new ArrayList(unsortedMapValues);
						Collections.sort(sortedMapValues);
						HashMap sortedMap = new LinkedHashMap();
						Object[] sortedArray = sortedMapValues.toArray();
						int size = sortedArray.length;
						Float temp1 = null;
						sortedPractList = new ArrayList();				
						if(opConsStatsCount >=1){
							prefPractArray.clear();						
							for (int i=0; i < size ; i++){
								Float value = (Float)sortedArray[i];
								int mapValueIndex = unsortedMapValues.indexOf(value);
								practId_temp = (String)mapKeys.get(mapValueIndex);
								if(i == 0){
									temp1 = value;
									prefPractArray.add(practId_temp);
								}else if(temp1.floatValue() == value.floatValue()){
									prefPractArray.add(practId_temp);
								}
								//sortedMap.put(mapKeys.get(mapValueIndex),sortedArray[i]);
								sortedMap.put((String)mapKeys.get(mapValueIndex),(HashMap)hashMap.get((String)mapKeys.get(mapValueIndex)));
								sortedPractList.add((String)mapKeys.get(mapValueIndex));
								mapKeys.remove(mapValueIndex);
								unsortedMapValues.remove(mapValueIndex);
							}
							//practArray = sortedPractList;
						}
					}//Rule apply for atleast two record in op_cons_stats				
				}
				//System.out.println("hashMap :"+hashMap.toString());
				if(/*prefPractID !=null && !prefPractID.equals("")*/prefPractArray.size() > 1){
					iterator=prefPractArray.iterator();
					int prefPractCount =0;					
					while(iterator.hasNext()){
						practId_temp = (String)iterator.next();
						hashMapTemp = (HashMap)hashMap.get(practId_temp);
						if(prefPractCount ==0){
							practString = "'"+practId_temp+"'";
							clinicIdString = "'"+hashMapTemp.get("clinic_code")+"'";
						}else{
							practString = practString+","+"'"+practId_temp+"'";
							clinicIdString = clinicIdString+","+"'"+hashMapTemp.get("clinic_code")+"'";
						}
						prefPractCount++;
					}		
					prefPractArray.clear();
					//String oa_clinic_schedule="select practitioner_id,(NVL(MAX_FIRST_VISITS,0)-nvl(TOTAL_FIRST_VISIT_SLOTS_BOOKED,0))+(nvl(MAX_OTHER_VISITS,0)-(nvl(TOTAL_FOLLOW_UP,0)+nvl(TOTAL_ROUTINE,0)+nvl(TOTAL_SERIES,0)+nvl(TOTAL_CONSULT,0)+nvl(TOTAL_EMERGENCY,0))) count from oa_clinic_schedule where facility_id=? and clinic_date = to_date(?,'dd/mm/yyyy') and practitioner_id in("+practString+") and clinic_code in ("+clinicIdString+") order by count desc";
					String oa_clinic_schedule="select practitioner_id,(NVL(MAX_PATIENTS_PER_DAY,0)-nvl(TOTAL_SLOTS_BOOKED,0)) count from oa_clinic_schedule where facility_id=? and clinic_date = to_date(?,'dd/mm/yyyy') and practitioner_id in("+practString+") and clinic_code in ("+clinicIdString+") order by count desc";
					if(rs!=null)rs.close();
					pstmt = con.prepareStatement(oa_clinic_schedule);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,prefdate);
					int count = 0;
					//pstmt.setString(3,practString);
					rs = pstmt.executeQuery();
					while(rs != null && rs.next()){
						if(count == 0){
							maxFreeSlotCount = Integer.parseInt(rs.getString("count"));
							prefPractID = rs.getString("practitioner_id");
							practString = "'"+rs.getString("practitioner_id")+"'";
							schPractList.add(rs.getString("practitioner_id"));
							prefPractArray.add(prefPractID);
						}else if(maxFreeSlotCount == Integer.parseInt(rs.getString("count"))){
							prefPractID = "";
							practId_temp	= rs.getString("practitioner_id");
							schPractList.add(rs.getString("practitioner_id"));
							prefPractArray.add(practId_temp);
							practString = practString+","+"'"+rs.getString("practitioner_id")+"'";
						}
						count++;
					}
					if(/*prefPractID !=null && !prefPractID.equals("")*/prefPractArray.size() > 1){
						// here we need to check the latest Appointment booked against the practitioner.
						//String oa_apptSQL ="select practitioner_id,appt_ref_no,ADDED_DATE from oa_appt where facility_id=? /*and APPT_DATE = to_date(?,'dd/mm/yyyy')*/ and practitioner_id IN ("+practString+") order by ADDED_DATE asc";
						String oa_apptSQL ="select practitioner_id,MAX(ADDED_DATE)added_date from oa_appt where facility_id=? and SPECIALITY_CODE = ? /*and APPT_DATE = to_date(?,'dd/mm/yyyy')*/ and practitioner_id IN ("+practString+") group by practitioner_id order by added_date asc";
						/*
							Scenario 1: We have 3 practitioners  who has same number of free slots and Tie 1 also tie then check following 
										a.If only one practitioner has appoitnment then other 2 practitioners will be indicated by System.
										b.If two practitioners have appointments and one is left without appointment then that practitioner 
										will be system indicated Choice.
										c.If 3 practitioners are having appointents then Least Recently Appointment for practitioner  will be
										System choice.
										d.If none of the practitioners are having appointments then all will be System indicated choice. Is it OK.
						*/
						if(rs!=null)rs.close();
						pstmt = con.prepareStatement(oa_apptSQL);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,speciality);
						//pstmt.setString(2,prefdate);
						rs = pstmt.executeQuery();
						apptCount = 0;							
						while(rs !=null && rs.next()){
							apptCount++;
							if(apptCount == 1){								
								prefPractID = rs.getString("practitioner_id");
							}
							apptPractList.add(rs.getString("practitioner_id"));
						}
					}
					if((prefPractArray.size() > 0 && apptPractList.size() >0)){
						if(prefPractArray.size() == apptPractList.size()){
							prefPractArray.clear();
							iterator=apptPractList.iterator();
							if(iterator.hasNext()){
								prefPractArray.add((String)iterator.next());
							}
						}else{
							iterator=apptPractList.iterator();
							while(iterator.hasNext()){
								prefPractArray.remove(prefPractArray.indexOf((String)iterator.next()));
							}
						}
					}
				}	
				%>
				<table border="0" cellpadding="0" cellspacing="0" width="80%" valign='top' id='sch_rule_table'>
					
					<%
						if(language_code !=null && !language_code.equals("")){
							String langTransSql ="select no_of_translator*multiply_factor total_translators,(select count(appt_ref_no) from oa_appt where  facility_id=? and appt_date = to_date(?,'dd/mm/yyyy') and language_id =?)sch_translators  from oa_translator_configuration where facility_id=? and language_id =? and to_date (?,'dd/mm/yyyy') between eff_date_from and eff_date_to and eff_status='E'";
							if(rs!=null)rs.close();
							pstmt = con.prepareStatement(langTransSql);
							//out.println("langTransSql :"+langTransSql.toString());
							pstmt.setString(1,facility_id);						
							pstmt.setString(2,prefdate);
							pstmt.setString(3,language_code);
							pstmt.setString(4,facility_id);
							pstmt.setString(5,language_code);
							pstmt.setString(6,prefdate);
							rs = pstmt.executeQuery();
							if(rs !=null && rs.next()){
								int total_translators	= Integer.parseInt(rs.getString("total_translators"));
								int sch_translators 	= Integer.parseInt(rs.getString("sch_translators"));
								int availableTranslatros= total_translators - sch_translators;
									if(availableTranslatros < 0)
										availableTranslatros = 0;
								if(total_translators > 0){%>
									<tr>
										<td colspan='6' class='COLUMNHEADER'><fmt:message key="eOA.TranslatorsAvble.label" bundle="${oa_labels}"/> :<%=availableTranslatros%>/<%=total_translators%></td>
									</tr>
									<tr>
										<td colspan='6'>&nbsp</td>
									</tr>
								<%}
							}
						}%>
							<tr>
								<td colspan='4' class='COLUMNHEADER'><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
								<%if(prefDate_is_sysDate.equals("Y")){
									if(patient_id.equals("")){%>
										<td class='COLUMNHEADER'><fmt:message key="eOA.NewPatConsltd.label" bundle="${oa_labels}"/></td> <td class='COLUMNHEADER'><fmt:message key="eOA.NewPatToBeConsltd.label" bundle="${oa_labels}"/></td>
									<%}else{%>
										<td class='COLUMNHEADER'><fmt:message key="eOA.OldPatConsltd.label" bundle="${oa_labels}"/></td> <td class='COLUMNHEADER'><fmt:message key="eOA.OldPatToBeConsltd.label" bundle="${oa_labels}"/></td>
									<%}
								}%>
							</tr>
						<%
						iterator=practArray.iterator();
						while(iterator.hasNext()){
							prefPractYN= "N";
							practId_temp = (String)iterator.next();
							String backColor = "";
							if(prefPractArray.size() > 0 && prefPractArray.contains(practId_temp)){
								prefPractYN ="Y";
								backColor="#91DAF2";
							}
							hashMapTemp	= (HashMap)hashMap.get(practId_temp);
							clinicCode_temp	=(String)hashMapTemp.get("clinic_code");
							fromTime_temp	=(String)hashMapTemp.get("from_time");
							toTime_temp		=(String)hashMapTemp.get("to_time");
							clinicName_temp	=(String)hashMapTemp.get("clinic_name");
							practName_temp	=(String)hashMapTemp.get("pract_name");
							time_table_type_temp	=(String)hashMapTemp.get("time_table_type");
							care_locn_type_ind	=(String)hashMapTemp.get("care_locn_type_ind");
							maxGlobalBooking 	= (String)hashMapTemp.get("maxGlobalBooking");
							totalGlobalBooking 	= (String)hashMapTemp.get("totalGlobalBooking");
							//select (select count(appt_status)count from oa_appt where  facility_id='HS' and appt_date = to_date('29/02/2012','dd/mm/yyyy') and clinic_code='RCR1' and appt_status='1')not_cons,(select count(appt_status)count from oa_appt where  facility_id='HS' and appt_date = to_date('29/02/2012','dd/mm/yyyy') and clinic_code='RCR1' and appt_status='A')cons from dual
							if(prefDate_is_sysDate.equals("Y")){
								if(patient_id.equals("")){
									apptStatusCountSQL ="select (select count(appt_status)count from oa_appt where  facility_id=? and appt_date = to_date(?,'dd/mm/yyyy') and clinic_code=? and practitioner_id= ? /*and appt_status='1'*/ and appt_category in('2','4') and appt_ref_no not in (select appt_id from op_patient_queue where facility_id=? and trunc(QUEUE_DATE)=to_date(?,'dd/mm/yyyy') and queue_status in('04','07','09') and appt_id is not null ))not_consulted,(select sum(nvl(NEW_PAT_PRACT_SPECIFIC_CNT,0)+nvl(NEW_PAT_PRACT_NOT_SPECIFIC_CNT,0))consulted from op_consultation_stats where facility_id=? and clinic_date = to_date(?,'dd/mm/yyyy') and clinic_code=? and practitioner_id= ?)consulted from dual";
								}else{
									apptStatusCountSQL ="select (select count(appt_status)count from oa_appt where  facility_id=? and appt_date = to_date(?,'dd/mm/yyyy') and clinic_code=? and practitioner_id= ? /*and appt_status='1'*/ and appt_category in('1','3')  and appt_ref_no not in (select appt_id from op_patient_queue where facility_id=? and trunc(QUEUE_DATE)=to_date(?,'dd/mm/yyyy') and queue_status in('04','07','09') and appt_id is not null ))not_consulted,(select sum(nvl(OLD_PAT_PRACT_SPECIFIC_CNT,0)+nvl(OLD_PAT_PRACT_NOT_SPECIFIC_CNT,0))consulted from op_consultation_stats where facility_id=? and clinic_date = to_date(?,'dd/mm/yyyy') and clinic_code=? and practitioner_id= ?)consulted from dual";
								}
								//out.println("practId_temp :"+practId_temp);
								//out.println("clinicCode_temp :"+clinicCode_temp);
								//out.println("apptStatusCountSQL :"+apptStatusCountSQL);							
								pstmt = con.prepareStatement(apptStatusCountSQL);
								pstmt.setString(1,facility_id);						
								pstmt.setString(2,prefdate);
								pstmt.setString(3,clinicCode_temp);
								pstmt.setString(4,practId_temp);
								pstmt.setString(5,facility_id);						
								pstmt.setString(6,prefdate);
								pstmt.setString(7,facility_id);						
								pstmt.setString(8,prefdate);
								pstmt.setString(9,clinicCode_temp);
								pstmt.setString(10,practId_temp);
								rs = pstmt.executeQuery();
								if(rs !=null && rs.next()){
									consulted = Integer.parseInt(rs.getString("consulted")==null?"0":rs.getString("consulted"));
									not_consulted = Integer.parseInt(rs.getString("not_consulted")==null?"0":rs.getString("not_consulted"));
									
									/*not_consulted = not_consulted - consulted;
									if(not_consulted < 0)
										not_consulted = 0;*/
								}
							}
					%>
							<tr style="background-color:'<%=backColor%>'">
							<td colspan='2'>&nbsp;<%=clinicName_temp%>/<%=practName_temp%></td><td><a href="javascript:callBookAppointment('<%=clinicCode_temp%>','<%=practId_temp%>','<%=fromTime_temp%>','<%=toTime_temp%>','<%=time_table_type_temp%>','<%=care_locn_type_ind%>','<%=prefPractYN%>','<%=maxGlobalBooking%>','<%=totalGlobalBooking%>');"><%=fromTime_temp%>-<%=toTime_temp%></a></td><td>&nbsp;</td>
								<%if(prefDate_is_sysDate.equals("Y")){%>
									<td align='center'><%=consulted%></td><td align='center'><%=not_consulted%></td>								
								<%}%>
							</tr>
					<%	}%>
				</table>
				<%
			//checking for Free slots ends here
			}else if(freeSlotCount == 0){%>
				<script>
					alert(getMessage('SCH_NOT_AVAILABLE','OA'));
				</script>
			<%}%>
		<input type="hidden" name='slot_appt_ctrl' id='slot_appt_ctrl' value="<%=slot_appt_ctrl%>">
		<input type="hidden" name='visit_limit_rule' id='visit_limit_rule' value="<%=visit_limit_rule%>">
		<input type="hidden" name='alcn_criteria' id='alcn_criteria' value="<%=alcn_criteria%>">
		<input type="hidden" name='override_no_of_slots_yn' id='override_no_of_slots_yn' value="<%=override_no_of_slots_yn%>">
		<input type="hidden" name='capture_fin_dtls_yn' id='capture_fin_dtls_yn' value="<%=capture_fin_dtls_yn%>">
		<input type="hidden" name='min_ela_per_resc_noshow_in_day' id='min_ela_per_resc_noshow_in_day' value="<%=min_ela_per_resc_noshow_in_day%>">
		<input type="hidden" name='noshow_ctrl_by_splty_or_clinic' id='noshow_ctrl_by_splty_or_clinic' value="<%=noshow_ctrl_by_splty_or_clinic%>">
		<input type="hidden" name='contact_num_reqd_yn' id='contact_num_reqd_yn' value="<%=contact_num_reqd_yn%>">
		<input type="hidden" name='no_of_noshow_appts_for_alert' id='no_of_noshow_appts_for_alert' value="<%=no_of_noshow_appts_for_alert%>">
		<input type="hidden" name='per_chk_for_no_show_alert' id='per_chk_for_no_show_alert' value="<%=per_chk_for_no_show_alert%>">
		<input type="hidden" name='patient_id' id='patient_id' value="<%=patient_id%>">
		<input type="hidden" name='name_prefix' id='name_prefix' value="<%=name_prefix%>">
		<input type="hidden" name='first_name' id='first_name' value="<%=first_name%>">
		<input type="hidden" name='second_name' id='second_name' value="<%=second_name%>">
		<input type="hidden" name='third_name' id='third_name' value="<%=third_name%>">
		<input type="hidden" name='family_name' id='family_name' value="<%=family_name%>">
		<input type="hidden" name='name_suffix' id='name_suffix' value="<%=name_suffix%>">
		<input type="hidden" name='name_prefix_oth_lang' id='name_prefix_oth_lang' value="<%=name_prefix_oth_lang%>">
		<input type="hidden" name='first_name_oth_lang' id='first_name_oth_lang' value="<%=first_name_oth_lang%>">
		<input type="hidden" name='second_name_oth_lang' id='second_name_oth_lang' value="<%=second_name_oth_lang%>">
		<input type="hidden" name='third_name_oth_lang' id='third_name_oth_lang' value="<%=third_name_oth_lang%>">
		<input type="hidden" name='family_name_oth_lang' id='family_name_oth_lang' value="<%=family_name_oth_lang%>">
		<input type="hidden" name='name_suffix_oth_lang' id='name_suffix_oth_lang' value="<%=name_suffix_oth_lang%>">
		<input type="hidden" name='gender' id='gender' value="<%=gender%>">
		<input type="hidden" name='contact_no' id='contact_no' value="<%=contact_no%>">
		<input type="hidden" name='speciality' id='speciality' value="<%=speciality%>">
		<input type="hidden" name='prefdate' id='prefdate' value="<%=prefdate%>">
		<input type="hidden" name='facility_id' id='facility_id' value="<%=facility_id%>">
		<input type="hidden" name='db_clinic_code' id='db_clinic_code' value="<%=db_clinic_code%>">
		<input type="hidden" name='db_pract_id' id='db_pract_id' value="<%=db_pract_id%>">
		<input type="hidden" name='db_start_time' id='db_start_time' value="<%=db_start_time%>">
		<input type="hidden" name='db_end_time' id='db_end_time' value="<%=db_end_time%>">
		<input type="hidden" name='prefPractID' id='prefPractID' value="<%=prefPractID%>">
		<input type="hidden" name='transfer_YN' id='transfer_YN' value="<%=transfer_YN%>">
		<input type="hidden" name='day' id='day' value="<%=day%>">
		<input type="hidden" name='sys_date' id='sys_date' value="<%=sys_date%>">
		<input type="hidden" name='sys_time' id='sys_time' value="<%=systm%>">
		<!-- clinic level set ups starts -->
		<input type="hidden" name='clinic_name' id='clinic_name' value="">
		<input type="hidden" name='practitioner_name' id='practitioner_name' value="">
		<input type="hidden" name='over_booked' id='over_booked' value="">
		<input type="hidden" name='time_table_type' id='time_table_type' value="">
		<input type="hidden" name='book_appt_across_catg_yn' id='book_appt_across_catg_yn' value="">
		<input type="hidden" name='book_appt_yn' id='book_appt_yn' value="">
		<input type="hidden" name='book_appt_wo_pid_yn' id='book_appt_wo_pid_yn' value="">
		<input type="hidden" name='obook_appt_yn' id='obook_appt_yn' value="">
		<input type="hidden" name='tfr_appt_yn' id='tfr_appt_yn' value="">
		<input type="hidden" name='tfr_appt_across_catg_yn' id='tfr_appt_across_catg_yn' value="">
		<input type="hidden" name='canc_appt_yn' id='canc_appt_yn' value="">
		<input type="hidden" name='obvisit_flag' id='obvisit_flag' value="">
		<input type="hidden" name='clinic_type' id='clinic_type' value="">
		<input type="hidden" name='res_type' id='res_type' value="">
		<input type="hidden" name='nationality_code' id='nationality_code' value="<%=nationality_code%>">
		<input type="hidden" name='language_code' id='language_code' value="<%=language_code%>">
		<input type="hidden" name='term_set_id' id='term_set_id' value="<%=term_set_id%>">
		<input type="hidden" name='linking_code' id='linking_code' value="<%=linking_code%>">
		<input type="hidden" name='order_id' id='order_id' value="<%=order_id%>">
		<input type="hidden" name='order_line_num' id='order_line_num' value="<%=order_line_num%>">
		<input type="hidden" name='order_catalog_code' id='order_catalog_code' value="<%=order_catalog_code%>">
		<input type="hidden" name='global_locn_yn' id='global_locn_yn' value="">
		<input type="hidden" name='global_book_appt_yn' id='global_book_appt_yn' value="">
		<input type="hidden" name='maxGlobalBooking' id='maxGlobalBooking' value="">
		<input type="hidden" name='totalGlobalBooking' id='totalGlobalBooking' value="">	
		<input type="hidden" name='prefPractYN' id='prefPractYN' value="">
		
		
		<!-- clinic level set ups ends -->
		<%if(freeSlotCount == 1){%>
				<script>
				callBookAppointment('<%=db_clinic_code%>','<%=db_pract_id%>','<%=db_start_time%>','<%=db_end_time%>','<%=time_table_type_temp%>','<%=care_locn_type_ind%>','Y','<%=maxGlobalBooking%>','<%=totalGlobalBooking%>');
				</script>
			<%}%>
		</form>
	<%}else{%>
		<script>
			var error = getMessage('RULE_NOT_DEFINED','OA');
			parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+error;
		</script>
	<%}%>
	</body>
	<%}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		ConnectionManager.returnConnection(con,request);
	}%>
</html>
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

