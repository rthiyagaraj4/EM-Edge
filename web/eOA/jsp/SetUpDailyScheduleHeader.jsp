<!DOCTYPE html>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.* ,eCommon.XSSRequestWrapper" %>
	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>

	<script language="javascript" src="../../eOA/js/SetUpDailySchedule.js">		</script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"> 		</script>
	<script language="javascript" src="../../eOA/js/Scheduling.js"></script>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>

<%  
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			Connection conn=null; 
			Statement stmtn = null;
			Statement stmtnAlcn = null;
			Statement stmtnAlcn1 = null;
			Statement stmtn1 = null;
			Statement stmtn2 = null;	
	//		Statement stsql2 = null;	
	//		Statement stsql1 = null;	
			Statement st_valstart = null;
			Statement st_blkappt = null;
	//		Statement chk_time=null;
			ResultSet rs_valstart=null;
			ResultSet rs_blkappt=null;
			ResultSet rspop_sch=null;
			ResultSet rspop_break=null;
			ResultSet rsLoc=null;
		//	ResultSet rssql1=null;
		//	ResultSet rssql2=null;
			Statement st= null;
			ResultSet rsSet=null;
			ResultSet rsAlcn=null;
			ResultSet rsAlcn1=null;
			String alcn_basis="";
			String startTime="";
			String endTime="";

			PreparedStatement pstmt=null;
			
			//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
			Boolean isScheduleExtendAppl = false;
			String schedule_extend_param = "N";
			String schedule_extend_yn = "N";
			String schedule_extend_yn_chk = "";

			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			Boolean isSlotStartMidEndAppl = false;
			String ext_all_slots_yn = "N";
			String ext_all_slots_yn_chk = "";
			String ext_start_slots = "";
			String ext_mid_slots = "";
			String ext_end_slots = "";
try
{ 
			conn = ConnectionManager.getConnection(request);

			isScheduleExtendAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OA", "SCHEDULE_EXTEND");//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
			isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1

			stmtn = conn.createStatement();
			 stmtn1 = conn.createStatement();
			 stmtn2 = conn.createStatement();	
	//		 stsql2 = conn.createStatement();	
	//		 stsql1 = conn.createStatement();	
			 st_valstart = conn.createStatement();
			 st_blkappt = conn.createStatement();
	//		 chk_time=conn.createStatement();
			  st= conn.createStatement();
			String locale=(String)session.getAttribute("LOCALE");
			String facilityid=(String)session.getValue("facility_id");
			java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
		//	String fid=p.getProperty( "login_user" ) ;
			String function_mode=request.getParameter("function_mode");
			if( function_mode == null) function_mode="";
			
			String p_clinic_code = request.getParameter("clinic_code");
			if( p_clinic_code == null) p_clinic_code="";
			String  practid= request.getParameter("practid");
			if(practid ==null || practid.equals(" ") || practid.equals("null")) practid="";
			String clinic_date = request.getParameter("clinic_date");
			if( clinic_date == null) clinic_date="";
			String clinic_date_display=DateUtils.convertDate(clinic_date,"DMY","en",locale);
			if( clinic_date_display == null) clinic_date_display="";


			String timetabletype = request.getParameter("timetabletype");
			if( timetabletype == null) timetabletype="";
			String locn_care_ind=  request.getParameter("locn_care_ind");
			if( locn_care_ind == null) locn_care_ind="";
			String resource_class=  request.getParameter("resource_class");
			if( resource_class == null) resource_class="";
			String function_type=request.getParameter("function_type");
			if(function_type ==null) function_type="";
			
			String dayno = request.getParameter("dayno");
			if( dayno == null) dayno="";
						 
			String alcnCode="";
			String alcnDesc="";
			//	String alcnSlotNo="";

			int alcnSlotNo =0;
			String finalalcnString="";
			String day_of_week="";
			String start_appt_time="";
			String end_appt_time="";
			String block_start_time ="";
			String block_end_time="";
			String overbook_cnt="0";
			String first_visit_cnt="";
			String other_visit_cnt="";
			String alcncriteria = "";
			String slot_appt_ctrl="";
			String visit_limit_rule="";		 
			String p_max_slots_per_day="";		 
			String p_max_other_visits="";		 
			String slot_or_pat="";
			String time_per_pat_prompt=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.TimeperSlot.label","oa_labels");
			String p_clinic_name="";
			String p_practitioner_name="";
			String p_remarks="";
			String p_start_time="";
			String p_end_time="";
			String p_time_table_type="";
			//int p_max_patients_per_day = 0;
			String p_max_patients_per_day="0";
			String p_max_pat_per_day="";
			String p_time_per_slab="";
			String p_max_patients_per_slab="";
			String p_max_first_visits="";
			String p_max_over_booking="";
			String p_practitioner_code="";
			String p_time_per_patient="";
			String forcedNo="0";
			String globalNo="0";
			String res_class_desc="";
			String care_locn_desc="";
			String oper_stn_id="";
			String chk 	= "unchecked" ;
			String p_roster_checked="";
			String CurrentDatetm="";
			String CurrentDate="";
			String res_class="";
			String rule_appl_yn="";
			String max_new_patients="";
			String max_old_patients="";

			String sql1="select visit_limit_rule,slot_appt_ctrl,alcn_criteria,alcn_basis,to_char(SYSDATE,'dd/mm/yyyy hh24:mi') dttm,to_char(sysdate,'dd/mm/yyyy') dt,rule_appl_yn, schedule_extend_yn from oa_param ";

			oper_stn_id = request.getParameter("oper_stn_id");

			


		rs_valstart = st_valstart.executeQuery(sql1) ;
		if(rs_valstart!=null && rs_valstart.next())
			{
				alcncriteria	 = rs_valstart.getString("alcn_criteria");
				if(alcncriteria ==null) alcncriteria="";
				alcn_basis		 = rs_valstart.getString("alcn_basis");
				if(alcn_basis ==null)	 alcn_basis="";
				slot_appt_ctrl	 = rs_valstart.getString("slot_appt_ctrl");
				visit_limit_rule = rs_valstart.getString("visit_limit_rule");
				CurrentDatetm=rs_valstart.getString("dttm");
				 CurrentDate=rs_valstart.getString("dt");
				 rule_appl_yn	 = rs_valstart.getString("rule_appl_yn")==null?"N":rs_valstart.getString("rule_appl_yn");
				 //Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
				 schedule_extend_param	 = rs_valstart.getString("schedule_extend_yn")==null?"N":rs_valstart.getString("schedule_extend_yn");
			}else
			{
				out.println("<script>alert(getMessage('OA_PARAM_NOT_FOUND','OA'))</script>");
		%>
		 <script>
		parent.frames[1].location.href='../../eCommon/html/blank.html';</script> 
		<%
			}
		if (rs_valstart!=null) rs_valstart.close();

	if( function_mode.equals("modify") && function_type.equals("") )
	{			 

			//rs_valstart=st_valstart.executeQuery("select to_char(min(appt_slab_from_time),'hh24:mi') str_appt_time, to_char(max(appt_slab_to_time) ,'hh24:mi') end_appt_time from oa_appt where facility_id='"+facilityid+"'  and clinic_code='"+p_clinic_code+"'  and nvl(practitioner_id,'x') = nvl('"+practid+"','x') and appt_date= to_date('"+clinic_date+"','dd/mm/yyyy') ");
			String sql2 = "select to_char(min(appt_slab_from_time),'hh24:mi') str_appt_time, to_char(max(appt_slab_to_time) ,'hh24:mi') end_appt_time from oa_appt where facility_id=?  and clinic_code=?  and nvl(practitioner_id,'x') = nvl(?,'x') and appt_date= to_date(?,'dd/mm/yyyy') ";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,p_clinic_code);
			pstmt.setString(3,practid);
			pstmt.setString(4,clinic_date);
			rs_valstart = pstmt.executeQuery();
			while(rs_valstart.next())
				{
					start_appt_time= rs_valstart.getString("str_appt_time");
					if( start_appt_time == null) start_appt_time="";		
					end_appt_time = rs_valstart.getString("end_appt_time");
					if( end_appt_time == null) end_appt_time="";	
				}	
			//String sql_chk="select to_char(min(effective_from_date_time),'hh24:mi') block_start_time, to_char(max(effective_to_date_time),'hh24:mi') block_to_time from oa_block_appt where facility_id='"+facilityid+"'  and clinic_code='"+p_clinic_code+"'  and nvl(practitioner_id,'x') = nvl('"+practid+"','x') and block_date= to_date('"+clinic_date+"','dd/mm/yyyy') ";
			//rs_blkappt=st_blkappt.executeQuery(sql_chk);
			String sql_chk="select to_char(min(effective_from_date_time),'hh24:mi') block_start_time, to_char(max(effective_to_date_time),'hh24:mi') block_to_time from oa_block_appt where facility_id=?  and clinic_code=?  and nvl(practitioner_id,'x') = nvl(?,'x') and block_date= to_date(?,'dd/mm/yyyy') ";
			pstmt = conn.prepareStatement(sql_chk);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,p_clinic_code);
			pstmt.setString(3,practid);
			pstmt.setString(4,clinic_date);
			rs_blkappt = pstmt.executeQuery();
			while(rs_blkappt.next())
				{
					block_start_time = rs_blkappt.getString("block_start_time");
					if( block_start_time == null) block_start_time="";
					
					block_end_time = rs_blkappt.getString("block_to_time");
					if( block_end_time == null) block_end_time="";
				}	
	
}

 
	//String populate_schedule	="Select total_overbooked, nvl(total_first_visit,0)+nvl(total_first_visits_blocked,0) total_first_visit,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0)+nvl(total_other_visits_blocked,0) total_other_visits, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') clinic_name,clinic_code, clinic_date , srl_no , practitioner_id,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_name, time_table_type ,remarks , to_char(start_time,'hh24:mi') start_time, to_char(end_time,'hh24:mi')end_time,	to_char(time_per_patient,'hh24:mi') time_per_patient,	max_patients_per_day , to_char(time_per_slab,'hh24:mi' ) time_per_slab , max_patients_per_slab,	max_first_visits,max_over_booking,max_slots_per_day,max_other_visits,nvl(MAX_FORCED_IN_BOOKING,0) MAX_FORCED_IN_BOOKING ,nvl(MAX_GLOBAL_BOOKING,0) MAX_GLOBAL_BOOKING,nvl(RESOURCE_TYPE,'P') RESOURCE_TYPE,AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_ind,'"+locale+"','1')care_locn_type_ind_desc , resource_class,null resource_class_desc,MAX_NEW_PATIENTS, MAX_OLD_PATIENTS, schedule_extend_yn, to_char(org_end_time,'hh24:mi') org_end_time, org_max_patients_per_day, org_max_first_visits, org_max_slots_per_day, org_max_other_visits, ext_all_slots_yn, ext_start_slots, ext_mid_slots, ext_end_slots From oa_clinic_schedule where facility_id='"+facilityid+"' and Clinic_code='"+p_clinic_code+"' and clinic_date =to_date('"+clinic_date+"','dd/mm/yyyy') and Nvl(PRACTITIONER_ID,'X')= nvl('"+practid+"' ,'X') and care_locn_type_ind='"+locn_care_ind+"' and resource_class='"+resource_class+"' ";
	String populate_schedule	="Select total_overbooked, nvl(total_first_visit,0)+nvl(total_first_visits_blocked,0) total_first_visit,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0)+nvl(total_other_visits_blocked,0) total_other_visits, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,?,'1') clinic_name,clinic_code, clinic_date , srl_no , practitioner_id,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,?,'2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2')) practitioner_name, time_table_type ,remarks , to_char(start_time,'hh24:mi') start_time, to_char(end_time,'hh24:mi')end_time,	to_char(time_per_patient,'hh24:mi') time_per_patient,	max_patients_per_day , to_char(time_per_slab,'hh24:mi' ) time_per_slab , max_patients_per_slab,	max_first_visits,max_over_booking,max_slots_per_day,max_other_visits,nvl(MAX_FORCED_IN_BOOKING,0) MAX_FORCED_IN_BOOKING ,nvl(MAX_GLOBAL_BOOKING,0) MAX_GLOBAL_BOOKING,nvl(RESOURCE_TYPE,'P') RESOURCE_TYPE,AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_ind,?,'1')care_locn_type_ind_desc , resource_class,null resource_class_desc,MAX_NEW_PATIENTS, MAX_OLD_PATIENTS, schedule_extend_yn, to_char(org_end_time,'hh24:mi') org_end_time, org_max_patients_per_day, org_max_first_visits, org_max_slots_per_day, org_max_other_visits, ext_all_slots_yn, ext_start_slots, ext_mid_slots, ext_end_slots From oa_clinic_schedule where facility_id=? and Clinic_code=? and clinic_date =to_date(?,'dd/mm/yyyy') and Nvl(PRACTITIONER_ID,'X')= nvl(? ,'X') and care_locn_type_ind=? and resource_class=? ";
	//System.out.println("populate_schedule  ==>"+populate_schedule);
			
	//String time_table_sch ="select clinic_code,clinic_name,CARE_LOCN_TYPE_DESC,decode(resource_class,'P','Practitioner','E','Equipment','B','Bed','R','Room','O','Other') resource_class_desc,day_no,initCap(day_of_week) day_of_week,practitioner_id,nvl(practitioner_full_name,'')practitioner_name,time_table_type,to_char(start_time,'hh24:mi')start_time,to_char(end_time,'hh24:mi')end_time,nvl(to_char(time_per_patient,'hh24:mi'),'') time_per_patient,nvl(max_patients_per_day,'')max_patients_per_day,nvl(to_char(time_per_slab,'hh24:mi'),'')time_per_slab,nvl(max_patients_per_slab,'')max_patients_per_slab,nvl(max_first_visits,'')max_first_visits,nvl(max_over_booking,'')max_over_booking,nvl(max_slots_for_first_visit,'')max_slots_for_first_visit,NVL(phys_roster_reqd_yn,'N')phys_roster_reqd_yn,nvl(remarks,'&nbsp;')remarks,max_slots_per_day,max_other_visits,RESOURCE_CLASS,NO_OF_GLOBAL_APPT_FOR_REF,NO_OF_FORCED_IN_APPT,ALLOW_FORCED_IN_APPT_YN,MAX_NEW_PATIENTS, MAX_OLD_PATIENTS, schedule_extend_yn, ext_all_slots_yn, ext_start_slots, ext_mid_slots, ext_end_slots from oa_clinic_time_table_vw where facility_id = '"+facilityid+"' and clinic_code = '"+p_clinic_code+"' and nvl(practitioner_id,'X') = nvl('"+practid.trim()+"','X') and day_no = '"+dayno+"' and time_table_type = '"+timetabletype+"' and resource_class='"+resource_class+"' ";
	String time_table_sch ="select clinic_code,clinic_name,CARE_LOCN_TYPE_DESC,decode(resource_class,'P','Practitioner','E','Equipment','B','Bed','R','Room','O','Other') resource_class_desc,day_no,initCap(day_of_week) day_of_week,practitioner_id,nvl(practitioner_full_name,'')practitioner_name,time_table_type,to_char(start_time,'hh24:mi')start_time,to_char(end_time,'hh24:mi')end_time,nvl(to_char(time_per_patient,'hh24:mi'),'') time_per_patient,nvl(max_patients_per_day,'')max_patients_per_day,nvl(to_char(time_per_slab,'hh24:mi'),'')time_per_slab,nvl(max_patients_per_slab,'')max_patients_per_slab,nvl(max_first_visits,'')max_first_visits,nvl(max_over_booking,'')max_over_booking,nvl(max_slots_for_first_visit,'')max_slots_for_first_visit,NVL(phys_roster_reqd_yn,'N')phys_roster_reqd_yn,nvl(remarks,'&nbsp;')remarks,max_slots_per_day,max_other_visits,RESOURCE_CLASS,NO_OF_GLOBAL_APPT_FOR_REF,NO_OF_FORCED_IN_APPT,ALLOW_FORCED_IN_APPT_YN,MAX_NEW_PATIENTS, MAX_OLD_PATIENTS, schedule_extend_yn, ext_all_slots_yn, ext_start_slots, ext_mid_slots, ext_end_slots from oa_clinic_time_table_vw where facility_id = ? and clinic_code = ? and nvl(practitioner_id,'X') = nvl(?,'X') and day_no = ? and time_table_type = ? and resource_class=? ";
	//System.out.println("time_table_sch ==>"+time_table_sch);
		
	//String populate_tim_table_break= " Select to_char(break_start_time,'hh24:mi') break_start_time ,to_char(break_end_time,'hh24:mi')break_end_time  from oa_clinic_break Where facility_id='"+facilityid+"' and Clinic_code='"+p_clinic_code+"'  and day_no = '"+dayno+"'  and Nvl(practitioner_id,'X')= nvl( '"+practid+"' ,'X') Order by break_start_time ";
	String populate_tim_table_break= " Select to_char(break_start_time,'hh24:mi') break_start_time ,to_char(break_end_time,'hh24:mi')break_end_time  from oa_clinic_break Where facility_id=? and Clinic_code=?  and day_no = ?  and Nvl(practitioner_id,'X')= nvl( ? ,'X') Order by break_start_time ";

	//String populate_break= " Select to_char(break_start_time,'hh24:mi') break_start_time ,to_char(break_end_time,'hh24:mi')break_end_time  from oa_clinic_schedule_break Where facility_id='"+facilityid+"' and Clinic_code='"+p_clinic_code+"'  and clinic_date =to_date('"+clinic_date+"','dd/mm/yyyy')  and Nvl(practitioner_id,'X')= nvl( '"+practid+"' ,'X') Order by break_start_time ";
	String populate_break= " Select to_char(break_start_time,'hh24:mi') break_start_time ,to_char(break_end_time,'hh24:mi')break_end_time  from oa_clinic_schedule_break Where facility_id=? and Clinic_code=?  and clinic_date =to_date(?,'dd/mm/yyyy')  and Nvl(practitioner_id,'X')= nvl( ? ,'X') Order by break_start_time ";


	if( function_mode.equals("modify"))
	{
		if(function_type.equals(""))
		{			
		//rspop_sch = stmtn1.executeQuery(populate_schedule);
		pstmt = conn.prepareStatement(populate_schedule);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,locale);
		pstmt.setString(6,locale);
		pstmt.setString(7,facilityid);
		pstmt.setString(8,p_clinic_code);
		pstmt.setString(9,clinic_date);
		pstmt.setString(10,practid);
		pstmt.setString(11,locn_care_ind);
		pstmt.setString(12,resource_class);
		rspop_sch = pstmt.executeQuery();
		//rspop_break = stmtn2.executeQuery(populate_break);
		//if(pstmt != null) pstmt.close();
		pstmt = conn.prepareStatement(populate_break);
		pstmt.setString(1,facilityid);
		pstmt.setString(2,p_clinic_code);
		pstmt.setString(3,clinic_date);
		pstmt.setString(4,practid);
		rspop_break = pstmt.executeQuery();
		}else{	
			
		//rspop_sch = stmtn1.executeQuery(time_table_sch);
		//if(pstmt != null) pstmt.close();
		pstmt = conn.prepareStatement(time_table_sch);
		pstmt.setString(1,facilityid);
		pstmt.setString(2,p_clinic_code);
		pstmt.setString(3,practid.trim());
		pstmt.setString(4,dayno);
		pstmt.setString(5,timetabletype);
		pstmt.setString(6,resource_class);
		rspop_sch = pstmt.executeQuery();
		//if(pstmt != null) pstmt.close();
		//rspop_break = stmtn2.executeQuery(populate_tim_table_break);
		pstmt = conn.prepareStatement(populate_tim_table_break);
		pstmt.setString(1,facilityid);
		pstmt.setString(2,p_clinic_code);
		pstmt.setString(3,dayno);
		pstmt.setString(4,practid);
		rspop_break = pstmt.executeQuery();
		}
			while( rspop_sch.next())
			{
					if(function_type.equals(""))
				{
					overbook_cnt = rspop_sch.getString("total_overbooked");
					if( overbook_cnt == null) overbook_cnt="0";

					first_visit_cnt = rspop_sch.getString("total_first_visit");

					other_visit_cnt = rspop_sch.getString("total_other_visits");

					p_clinic_name=rspop_sch.getString("clinic_name");
					p_practitioner_name=rspop_sch.getString("practitioner_name");
					if( p_practitioner_name == null) p_practitioner_name="";

					p_practitioner_code =rspop_sch.getString("practitioner_id");
					if( p_practitioner_code == null) p_practitioner_code="";

					//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
					schedule_extend_yn = rspop_sch.getString("schedule_extend_yn")==null?"N":rspop_sch.getString("schedule_extend_yn");
					if(schedule_extend_yn.equals("Y"))
						schedule_extend_yn_chk = "checked";
					
					if(schedule_extend_yn.equals("Y"))
					{
						p_end_time = rspop_sch.getString("org_end_time");
						p_max_patients_per_day = rspop_sch.getString("org_max_patients_per_day");
						if(p_max_patients_per_day==null || p_max_patients_per_day.equals("null"))
							p_max_patients_per_day = "0";
						p_max_first_visits = rspop_sch.getString("org_max_first_visits");
						if( p_max_first_visits == null) p_max_first_visits="";
						p_max_slots_per_day = rspop_sch.getString("org_max_slots_per_day");
						if( p_max_slots_per_day == null) p_max_slots_per_day="";
						p_max_other_visits = rspop_sch.getString("org_max_other_visits");
						if( p_max_other_visits == null) p_max_other_visits="";
					}else
					{
						p_end_time = rspop_sch.getString("end_time");
						p_max_patients_per_day = rspop_sch.getString("max_patients_per_day");
						if(p_max_patients_per_day==null || p_max_patients_per_day.equals("null"))
							p_max_patients_per_day = "0";
						p_max_first_visits = rspop_sch.getString("max_first_visits");
						if( p_max_first_visits == null) p_max_first_visits="";
						p_max_slots_per_day = rspop_sch.getString("max_slots_per_day");
						if( p_max_slots_per_day == null) p_max_slots_per_day="";
						p_max_other_visits = rspop_sch.getString("max_other_visits");
						if( p_max_other_visits == null) p_max_other_visits="";
					}

					//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
					ext_all_slots_yn = rspop_sch.getString("ext_all_slots_yn")==null?"N":rspop_sch.getString("ext_all_slots_yn");
					if(ext_all_slots_yn.equals("Y"))
						ext_all_slots_yn_chk = "checked";
					ext_start_slots = rspop_sch.getString("ext_start_slots");
						if( ext_start_slots == null) ext_start_slots = "";
					ext_mid_slots = rspop_sch.getString("ext_mid_slots");
						if( ext_mid_slots == null) ext_mid_slots = "";
					ext_end_slots = rspop_sch.getString("ext_end_slots");
						if( ext_end_slots == null) ext_end_slots = "";

					p_remarks=rspop_sch.getString("remarks");       
					if( p_remarks == null) p_remarks="";
					p_start_time=rspop_sch.getString("start_time");         
					p_time_table_type=rspop_sch.getString("time_table_type");
					p_time_per_slab=rspop_sch.getString("time_per_slab");        
					if( p_time_per_slab == null )p_time_per_slab="";
					p_max_patients_per_slab	=rspop_sch.getString("max_patients_per_slab");
					if( p_max_patients_per_slab == null )p_max_patients_per_slab="";
					p_max_over_booking=rspop_sch.getString("max_over_booking");	
					if( p_max_over_booking == null) p_max_over_booking="";
					p_clinic_code = rspop_sch.getString("clinic_code");
					if( p_clinic_code == null) p_clinic_code="";
					p_time_per_patient = rspop_sch.getString("time_per_patient");
					if( p_time_per_patient == null) p_time_per_patient="";
										
					forcedNo=rspop_sch.getString("MAX_FORCED_IN_BOOKING");
					globalNo=rspop_sch.getString("MAX_GLOBAL_BOOKING");
					max_new_patients=rspop_sch.getString("MAX_NEW_PATIENTS")==null?"":rspop_sch.getString("MAX_NEW_PATIENTS");
					max_old_patients=rspop_sch.getString("MAX_OLD_PATIENTS")==null?"":rspop_sch.getString("MAX_OLD_PATIENTS");
					res_class= rspop_sch.getString("resource_class");
					if( res_class == null) res_class="";

				if(res_class.equals("P"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
				}else if(res_class.equals("E"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
				}else if(res_class.equals("R"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
				}else if(res_class.equals("O"))
				{
				res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
				}

					care_locn_desc= rspop_sch.getString("care_locn_type_ind_desc");
					if( care_locn_desc == null) care_locn_desc="";
					 
				}else
				{
					
					p_start_time=rspop_sch.getString("start_time");         
					p_end_time=rspop_sch.getString("end_time");        
					p_time_table_type=rspop_sch.getString("time_table_type");
					day_of_week =rspop_sch.getString("day_of_week");
					care_locn_desc= rspop_sch.getString("CARE_LOCN_TYPE_DESC");
					if( care_locn_desc == null) care_locn_desc="";
					res_class_desc= rspop_sch.getString("resource_class_desc");
					if( res_class_desc == null) res_class_desc="";
					p_remarks=rspop_sch.getString("remarks");       
					if( p_remarks == null) p_remarks="";
					p_max_patients_per_slab	= 	rspop_sch.getString("max_patients_per_slab") ;
					if(p_max_patients_per_slab == null) p_max_patients_per_slab="";

					//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
					schedule_extend_yn = rspop_sch.getString("schedule_extend_yn")==null?"N":rspop_sch.getString("schedule_extend_yn");
					if(schedule_extend_yn.equals("Y"))
						schedule_extend_yn_chk = "checked";

					//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
					ext_all_slots_yn = rspop_sch.getString("ext_all_slots_yn")==null?"N":rspop_sch.getString("ext_all_slots_yn");
					if(ext_all_slots_yn.equals("Y"))
						ext_all_slots_yn_chk = "checked";
					ext_start_slots = rspop_sch.getString("ext_start_slots");
						if( ext_start_slots == null) ext_start_slots = "";
					ext_mid_slots = rspop_sch.getString("ext_mid_slots");
						if( ext_mid_slots == null) ext_mid_slots = "";
					ext_end_slots = rspop_sch.getString("ext_end_slots");
						if( ext_end_slots == null) ext_end_slots = "";

					p_max_first_visits	=	rspop_sch.getString("max_first_visits") ;
					if(p_max_first_visits == null) p_max_first_visits="";
					p_max_patients_per_day 	=rspop_sch.getString("max_patients_per_day");
					if(p_max_patients_per_day==null || p_max_patients_per_day.equals("null"))
						p_max_patients_per_day = "0";
					p_max_over_booking	=	rspop_sch.getString("max_over_booking") ;
					if(p_max_over_booking == null) p_max_over_booking="";

					p_time_per_patient	=	rspop_sch.getString("time_per_patient" );
					if(p_time_per_patient == null) p_time_per_patient="";

					p_time_per_slab	= 	rspop_sch.getString("time_per_slab") ;
					if(p_time_per_slab == null) p_time_per_slab="";

					p_max_other_visits	= 	rspop_sch.getString("max_other_visits") ;
					if(p_max_other_visits == null) p_max_other_visits="";

					p_max_slots_per_day = 	rspop_sch.getString("max_slots_per_day") ;
					if(p_max_slots_per_day == null) p_max_slots_per_day="";

					p_clinic_name=rspop_sch.getString("clinic_name");
					p_practitioner_name=rspop_sch.getString("practitioner_name");
					if( p_practitioner_name == null) p_practitioner_name="";

					p_clinic_code=rspop_sch.getString("clinic_code");

					forcedNo	= 	rspop_sch.getString("NO_OF_FORCED_IN_APPT") ;
					if(forcedNo == null) forcedNo="0";
					globalNo	= 	rspop_sch.getString("NO_OF_GLOBAL_APPT_FOR_REF") ;
					max_new_patients	= 	rspop_sch.getString("MAX_NEW_PATIENTS")==null?"":rspop_sch.getString("MAX_NEW_PATIENTS");
					max_old_patients	= 	rspop_sch.getString("MAX_OLD_PATIENTS")==null?"":rspop_sch.getString("MAX_OLD_PATIENTS");
					if(globalNo == null) globalNo="0";
			
						p_roster_checked = rspop_sch.getString("phys_roster_reqd_yn") ;

						if (p_roster_checked.equals("Y"))
						{
							chk 	= "checked" ;
						}
						else
						{
							chk 	= "unchecked" ;
						}
					
				}
					if (timetabletype.equals("1"))
					{
						if (slot_appt_ctrl.equals("S")){
							slot_or_pat =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Slot.label","common_labels");
							time_per_pat_prompt =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.TimeperSlot.label","oa_labels");
						}
						else
							slot_or_pat =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels");
					}
					else
					slot_or_pat ="&nbsp;";
			}
	  }

	if( function_mode.equals("modify"))
	{
			//rsSet=st.executeQuery("Select to_char(working_day_start_time,'hh24:mi') stm,to_char(working_day_end_time,'hh24:mi') etm,to_char(base_slot_slab_time,'hh24:mi') dur from op_clinic where facility_id='"+facilityid+"' and clinic_type='"+locn_care_ind+"' and clinic_code='"+p_clinic_code+"'");
			//if(pstmt != null) pstmt.close();
			pstmt = conn.prepareStatement("Select to_char(working_day_start_time,'hh24:mi') stm,to_char(working_day_end_time,'hh24:mi') etm,to_char(base_slot_slab_time,'hh24:mi') dur from op_clinic where facility_id=? and clinic_type=? and clinic_code=?");
			pstmt.setString(1,facilityid);
			pstmt.setString(2,locn_care_ind);
			pstmt.setString(3,p_clinic_code);
			rsSet = pstmt.executeQuery();	
			if (rsSet.next())
			{
				startTime=rsSet.getString("stm");         
				endTime=rsSet.getString("etm");
				if (startTime==null) startTime="";
				if (endTime==null) endTime="";
			}

			if (rsSet!=null)    rsSet.close();
			if (st !=null) st.close();

			stmtnAlcn=conn.createStatement();
			
			//String sqlAlcn="select a.ALCN_CATG_CODE,b.STAT_GRP_DESC,a.ALCN_PATIENT from oa_clinic_alcn a,AM_STAT_GROUP b where a.ALCN_CATG_CODE=b.STAT_GRP_ID and a.facility_id='"+facilityid+"' and a.clinic_code='"+p_clinic_code+"' and NVL(a.PRACTITIONER_ID,'X')=NVL('"+practid+"','X') and a.day_no='"+dayno+"' and a.TIME_TABLE_TYPE='"+timetabletype+"'";
			//rsAlcn=stmtnAlcn.executeQuery(sqlAlcn);
			String sqlAlcn="select a.ALCN_CATG_CODE,b.STAT_GRP_DESC,a.ALCN_PATIENT from oa_clinic_alcn a,AM_STAT_GROUP b where a.ALCN_CATG_CODE=b.STAT_GRP_ID and a.facility_id=? and a.clinic_code=? and NVL(a.PRACTITIONER_ID,'X')=NVL(?,'X') and a.day_no=? and a.TIME_TABLE_TYPE=?";
			//if(pstmt != null) pstmt.close();
			pstmt = conn.prepareStatement(sqlAlcn);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,p_clinic_code);
			pstmt.setString(3,practid);
			pstmt.setString(4,dayno);
			pstmt.setString(5,timetabletype);
			rsAlcn = pstmt.executeQuery();		

			int count=0;
			int alcn_patientCnt=0;
			while (rsAlcn!=null && rsAlcn.next()){
				alcnCode=rsAlcn.getString("ALCN_CATG_CODE");
				alcnDesc=rsAlcn.getString("STAT_GRP_DESC");
				alcnSlotNo=rsAlcn.getInt("ALCN_PATIENT");
				alcn_patientCnt=alcn_patientCnt+alcnSlotNo;
				if(count==0){
					finalalcnString=alcnCode+"$"+alcnSlotNo+"$"+alcnDesc;
				}else{
					finalalcnString=finalalcnString+"|"+alcnCode+"$"+alcnSlotNo+"$"+alcnDesc;
				}
				count++;
			}
			int intval = 0;			
			 intval = (Integer.parseInt(p_max_patients_per_day)-alcn_patientCnt);
			if(finalalcnString!=null && !finalalcnString.equals("")){
				finalalcnString=finalalcnString+"|OTH$"+intval+"$Others";

			}else{
				finalalcnString=finalalcnString+"|OTH$"+intval+"$Others";


					}

			if(finalalcnString!=null)
				{		
							
							stmtnAlcn1=conn.createStatement();

							//String sqlAlcn1="SELECT a.alcn_catg_code ALCN_CATG_CODE, b.stat_grp_desc STAT_GRP_DESC,a.MAX_PATIENTS  MAX_PATIENTS FROM oa_clinic_schedule_dtl a, am_stat_group b where a.ALCN_CATG_CODE=b.STAT_GRP_ID and a.facility_id='"+facilityid+"' and a.clinic_code='"+p_clinic_code+"' and  clinic_date =to_date('"+clinic_date+"','dd/mm/yyyy')";
							//rsAlcn1=stmtnAlcn1.executeQuery(sqlAlcn1);
							String sqlAlcn1="SELECT a.alcn_catg_code ALCN_CATG_CODE, b.stat_grp_desc STAT_GRP_DESC,a.MAX_PATIENTS  MAX_PATIENTS FROM oa_clinic_schedule_dtl a, am_stat_group b where a.ALCN_CATG_CODE=b.STAT_GRP_ID and a.facility_id=? and a.clinic_code=? and  clinic_date =to_date(?,'dd/mm/yyyy')";
							

						//	if(pstmt != null) pstmt.close();
							pstmt = conn.prepareStatement(sqlAlcn1);
							pstmt.setString(1,facilityid);
							pstmt.setString(2,p_clinic_code);
							pstmt.setString(3,clinic_date);
							rsAlcn1 = pstmt.executeQuery();
							int count1=0;
			int alcn_patientCnt1=0;

			String alcnCode1 ="";
			String alcnDesc1 ="";
			int MAX_PATIENTS =0;

			int al_no = 0;

			while (rsAlcn1!=null && rsAlcn1.next()){
				alcnCode1=rsAlcn1.getString("ALCN_CATG_CODE");
				alcnDesc1=rsAlcn1.getString("STAT_GRP_DESC");
				MAX_PATIENTS=rsAlcn1.getInt("MAX_PATIENTS");

				alcn_patientCnt1 = MAX_PATIENTS;

				if(count1==0){
					finalalcnString=alcnCode1+"$"+alcn_patientCnt1+"$"+alcnDesc1;
					al_no = al_no+alcn_patientCnt1;

				}else{
					finalalcnString=finalalcnString+"|"+alcnCode1+"$"+alcn_patientCnt1+"$"+alcnDesc1;
				
					al_no = alcn_patientCnt1+al_no;
					
				}
				count1++;

			}
			int  intval1=0;


			intval1= (Integer.parseInt(p_max_patients_per_day)-al_no);

			if(finalalcnString!=null && !finalalcnString.equals("")){

				finalalcnString=finalalcnString+"|OTH$"+intval1+"$Others";


			}else{
								finalalcnString=finalalcnString+"|OTH$"+intval1+"$Others";

					}
				}

	}

				/*
						Commented for PE by Suresh on 24/06/2010
					rssql2=stsql2.executeQuery("SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityid+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+fid+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))");
						
					if (rssql2!=null && rssql2.next())
						{
							oper_stn_id=rssql2.getString("oper_stn_id");
							if(oper_stn_id == null) oper_stn_id="";
						
						}else{
					*/		
						%>				
					<!-- 	<script>alert(getMessage('NO_OPER_STN_FOR_USER','Common'));</script> -->
						<%
						//}
			

			
	
	%>
			<html>
			<head>
			</head>
			<body   onload='chkmandatory();check_Forced();'OnMouseDown="CodeArrest()"onKeyDown = 'lockKey()' >


<FORM name='SetUpDailySchedule' id='SetUpDailySchedule' method='post' action='../../servlet/eOA.SetUpDailyScheduleServlet' target='messageFrame'>
<table width='100%' cellpadding='0' cellspacing='0' border='0' align='center'>
			
		<th nowrap align='left' colspan='9' class='COLUMNHEADER' style="color:white"><fmt:message key="eOA.LocationResourceDetails.label" bundle="${oa_labels}"/></th>
		
		<tr>
			<TD class="label"  nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></TD>
			
			<td class='fields' nowrap>
				
			<%if(!function_mode.equals("modify")) { 
				rsLoc = stmtn.executeQuery("Select Locn_Type, Short_Desc,care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and language_id = '"+locale+"' and locn_type in ('C','E','Y') order by 2");
				String short_desc="";
				String clinic_type="";
				%>
				<SELECT name='location_type' id='location_type' width='6%' onChange="javascript:populateLocations(this);changeResource(this);">
				<option>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>	
				<%
					while (rsLoc.next()) 
					{
						short_desc=rsLoc.getString("short_desc");
						clinic_type=rsLoc.getString("care_locn_type_ind");
						%>
						<option value='<%=clinic_type%>'><%=short_desc%>
					<%}%>		
				</select>
			<%}else{
							%>
				<input type='text' name='location_type1' id='location_type1' value='<%=care_locn_desc%>'  size='15'   readOnly maxlength='15'>
				<input type='hidden' name='location_type' id='location_type' value='<%=locn_care_ind%>' >
			<%}%>
			<%
								if(!function_mode.equals("modify")) 
			{ %>
				<TD class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></TD>
				<%if(function_type.equals("")) {%>
				<td class='fields' nowrap colspan='3'>
					<!--<SELECT name='location' id='location'  onChange="javascript:checkinIdentification(this)">
					<option>----------------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------------------</option></SELECT>-->
					<input type='text' size='25' maxlength='25' name='b_loc_val' id='b_loc_val' value='' onblur="ena_loc_lookup(this);"><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup()" class='button'><img src="../../eCommon/images/mandatory.gif" align='center'></img>
					<input type="hidden" name="location" id="location" value="">
				<%}else {%>
					<td class='fields' colspan='3'>
					<!--<SELECT name='location' id='location'  onChange="javascript:populatePractitioner(this);">
					<option>------------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------------</option>	</SELECT><img src="../../eCommon/images/mandatory.gif" align='center'></img>-->
					<input type='text' size='25' maxlength='25' name='b_loc_val' id='b_loc_val' value='' onblur="ena_loc_lookup(this);" ><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup()" class='button'><img src="../../eCommon/images/mandatory.gif" align='center'></img>
					<input type="hidden" name="location" id="location" value="">
					<%}%>


			<%}else{%>
				<TD class="label"  ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></TD>

				<td class='fields' nowrap>
					<input type='text' name='location1' id='location1' value='<%=p_clinic_name%>'  size='15'   readOnly maxlength='15'>
					<input type='hidden' name='location' id='location' value='<%=p_clinic_code%>' >
					<input type='hidden' name='b_loc_val' id='b_loc_val' value='<%=p_clinic_name%>' >
			<%}%>
			
			</tr>


			<tr>
				<TD class="label" nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>

				<td   class='fields'>
				<%if(!function_mode.equals("modify")) 
				{ %>
					<SELECT name='resourceType' id='resourceType' disabled onchange="enable_dsiable_res(this)">
					<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>
					<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
					<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> </option>
					<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/> </option>
					<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> </option>
					</SELECT><img src = '../../eCommon/images/mandatory.gif'> 
				<%}else
				{%>
					<input type="text" size="18" name="resourceType1" id="resourceType1" value="<%=res_class_desc%>" readonly>
					<input type="hidden" name="resourceType" id="resourceType" value="<%=resource_class%>">
				<%}%>

				</td>
				<% if(!function_mode.equals("modify")) 
				{ %>

					<jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name ="from_page" value= "schedule" />
					<jsp:param name ="pract_value" value= "" />
					</jsp:include>

					<!-- <td   class='fields'><input type=text name='practitioner_name' id='practitioner_name' disabled onblur='onblurcheck(this,practitioner_name)' size='30' maxlength='30'  ><input type=hidden name='practitioner' id='practitioner'  size='30' maxlength='30' ></input><input type='button' class='button' value='?'  disabled name='search_pract' id='search_pract' onClick="callPractSearch(this,practitioner_name,'setUp');"  >
					<img id = 'practMandatory' src = '../../eCommon/images/mandatory.gif'>  -->
			<% } else { %>
				<TD class="label" nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
				<td class='fields' nowrap >
					<input type='text' name='practitioner1' id='practitioner1'   value='<%=p_practitioner_name%>'  size='30' readOnly maxlength='30'>
					<input type='hidden' name='practitioner' id='practitioner' value='<%=practid%>' >
			<% } %>
			</TD>

	</TR>
			
			<th nowrap align='left' colspan='9'class='COLUMNHEADER' style="color:white"><fmt:message key="eOA.DayTimeDetails.label" bundle="${oa_labels}"/></th>
	<%if(!function_type.equals("")) { %>
	<tr>		
		<TD class="label"  nowrap colspan='4'><fmt:message key="eOA.RosterRequired.label" bundle="${oa_labels}"/></td>
		
		<TD class="fields"  nowrap ><INPUT align=''TYPE=CHECKBOX name='b_roster_reqd' id='b_roster_reqd' VALUE='Y' disabled onClick='javascript:rostertype()' <%=chk%>></TD>

		<td colspan='2'>&nbsp;</td>
	</tr>

<%}%>

	<TR>
		<%if(function_type.equals("")) { %>			
			<TD class="label" nowrap><fmt:message key="Common.date.label" bundle="${common_labels}"/></TD>

			<TD class="fields" nowrap >
				<% 
					
				if(!function_mode.equals("modify")) 
				{ %>
					<input type='text'  name='clinic_date' id='clinic_date' value=''   size='10' maxLength='10' onBlur='validateClinicDate(this,location,practitioner);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif"  onClick=" document.getElementById('clinic_date').select();return showCalendar('clinic_date');"><img src="../../eCommon/images/mandatory.gif" align='center'></img>
				<%}else{%>
					<input type='text' name='clinic_date' id='clinic_date'  size='10'  value='<%=clinic_date_display%>'   maxLength='10' readOnly><img src="../../eCommon/images/mandatory.gif" align='center'></img>
				<%}%> 
			</td>
		<%}else {%>

				<TD class ="label" ><fmt:message key="Common.days.label" bundle="${common_labels}"/></TD>

				<% 
					
				if(!function_mode.equals("modify")) 
				{ %><TD class="fields" >
				<SELECT name='b_day' id='b_day' onChange="/*javascript:checkDuplicate()*/">
				<option>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----
				<option value='*A'>*All
				</SELECT><img src="../../eCommon/images/mandatory.gif" align='center'></img>
				</TD>
					<%}else{%>
					<TD class="fields" ><input type='text' name='b_day' id='b_day'  size='10'  value='<%=day_of_week%>'   maxLength='10' readOnly><img src="../../eCommon/images/mandatory.gif" align='center'></img><input type='hidden' name='day_no_modify' id='day_no_modify' value='<%=dayno%>'></td>
					<%}%>
		<%}%>
			<TD class="label"  nowrap><fmt:message key="eOA.TimeTableType.label" bundle="${oa_labels}"/></TD>

			<TD class="fields" nowrap colspan='3' >

					<% if(!function_mode.equals("modify"))
					{ %>
						<SELECT name='time_table_type' id='time_table_type'   onChange="javascript:check_loc(this);">
						<OPTION value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----
						<OPTION value='1'><fmt:message key="Common.Slot.label" bundle="${common_labels}"/></option>
						<OPTION value='2'><fmt:message key="eOA.slab.label" bundle="${oa_labels}"/></option>
						<OPTION value='3'><fmt:message key="Common.FreeFormat.label" bundle="${common_labels}"/></option>
						</SELECT><img  src="../../eCommon/images/mandatory.gif" align='center'></img>

					<%}else{%>
						<input type='hidden' name='time_table_type' id='time_table_type' value='<%=p_time_table_type%>' >
						<% if( p_time_table_type.equals("1")) 
						{ %>
							<input type='text' name='time_table_type1' id='time_table_type1' value='Slot'   readOnly size='10' maxlength='10'>
						<%} else if( p_time_table_type.equals("2")) 
						{%>
							<input type='text' name='time_table_type1' id='time_table_type1' value='Slab'   readOnly size='10' maxlength='10'>
						<%} else  if( p_time_table_type.equals("3"))
						{%>
							<input type='text' name='time_table_type1' id='time_table_type1' value='Free Format'  readOnly size='10' maxlength='10'>
						<%}%>
							<img  src="../../eCommon/images/mandatory.gif" align='center'></img>
				   <%}%>
			</TD>
		</TR>
		
		<TR>
				<TD class="label" ><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></TD>

				<TD class="fields"  nowrap >
					<INPUT TYPE=TEXT   SIZE=5 MAXLENGTH=5 name='start_time' id='start_time' value='<%=p_start_time%>'  onKeyUp="javascript:formatTimePerPatient(this)" onBlur="/*javascript:chkStartTime(this);*/timeValidation(this,'S','SetUpDailySchedule<%=function_mode%>');" onChange="//clearMaxFirstVisit(this);" ><img src="../../eCommon/images/mandatory.gif" align='center'></img>
				</TD>
				
				<TD class="label"  nowrap><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></TD>

			<TD class="fields"  nowrap>

				<% if( ! overbook_cnt.equals("0")) 
				{ %> 
					<input type=text size=5 maxlength=5 name='end_time' id='end_time'    value='<%=p_end_time%>'  readOnly  onKeyUp="javascript:formatTimePerPatient(this)" onBlur="/*javascript:chkEndTime(this);*/timeValidation(this,'E','SetUpDailySchedule<%=function_mode%>')" onChange="clearMaxFirstVisit(this)" >
				<%  } else 
				{ %>
					<input type=text size=5 maxlength=5 name='end_time' id='end_time'    value='<%=p_end_time%>'     onKeyUp="javascript:formatTimePerPatient(this)" onBlur="/*javascript: chkEndTime(this,end_appt_time,block_end_time);*/timeValidation(this,'E','SetUpDailySchedule<%=function_mode%>');" onChange="javascript:clearMaxFirstVisit(this);">
				<% } %> 
				<img src="../../eCommon/images/mandatory.gif" align='center'></img>
			</TD>

			<!--Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112-->
			<%if(isScheduleExtendAppl && schedule_extend_param.equals("Y")){%>
				<td class=label id="scheduleextendyn" style="display:none" nowrap colspan='2'><fmt:message key="eOA.ExtendTillDayEnd.label" bundle="${oa_labels}"/>
				<input type=checkbox name="schedule_extend_yn" id="schedule_extend_yn" onClick='ScheduleExtendYN(this);' value="<%=schedule_extend_yn%>" <%=schedule_extend_yn_chk%>></td>
			<%}%>

	</tr>

			<th nowrap colspan='6' align='left' class='COLUMNHEADER' style="color:white"><fmt:message key="eOA.SlotDetails.label" bundle="${oa_labels}"/>/<fmt:message key="eOA.SlabDetails.label" bundle="${oa_labels}"/>/<fmt:message key="eOA.FreeFormatDetails.label" bundle="${oa_labels}"/></th>
				
			
		
	<tr>

			<TD class="label" id = time_per_pat ><%=time_per_pat_prompt%></TD>

			<TD class="fields"  >
				<input name='time_per_patient' id='time_per_patient' type=text size=5 maxlength=5    value='<%=p_time_per_patient%>'  onBlur="TimePerPatientValid(this);" ><img id='t_per_pat' src="../../eCommon/images/mandatory.gif" align='center'></img>
			</TD>

			</td>

			<TD class="label" nowrap><fmt:message key="eOA.maxslotsperday.label" bundle="${oa_labels}"/></TD>

			<TD class="fields" nowrap colspan='3'>
				<INPUT name='b_max_slots_per_day' id='b_max_slots_per_day' disabled TYPE=TEXT SIZE=5 MAXLENGTH=3 
				onKeyPress='return  allowValidNumber(this,event,3,0);'value='<%=p_max_slots_per_day%>'>
			</TD>	
				
			<input type='hidden' name='l_max_pat_per_slot' id='l_max_pat_per_slot'>
</TR>

<TR>
			<TD class="label" ><fmt:message key="eOA.timeperslab.label" bundle="${oa_labels}"/></TD>

			<TD class="fields"><input name='time_per_slab' id='time_per_slab' type=text size=5 maxlength=5  value='<%=p_time_per_slab%>'   onKeyUp="javascript:formatTimePerSlab()" onBlur="javascript:TimePerSlab(this);"><img id='t_per_slab' src="../../eCommon/images/mandatory.gif" align='center'></img>
			</TD>

			

			<TD class="label"  nowrap><fmt:message key="eOA.maxpatperslab.label" bundle="${oa_labels}"/></TD>

			<TD class="fields" colspan='3'>
			<input name='max_patients_per_slab' id='max_patients_per_slab' type=text size=5 maxlength=3  value='<%=p_max_patients_per_slab%>' onBlur="javascript:MaxPatPerSlab(this);" onKeyPress='return  allowValidNumber(this,event,3,0);'><img id='mx_per_slab' src="../../eCommon/images/mandatory.gif" align='center'></img>
			</TD>

    </TR>
	<%
		if(!p_max_patients_per_day.equals("0")) {
			p_max_pat_per_day = p_max_patients_per_day;
		}
	%>

	<TR>	
		<TD class="label"  nowrap><fmt:message key="eOA.maxpatperday.label" bundle="${oa_labels}"/></TD>
		
			<TD class="fields" nowrap colspan='3'>
				<INPUT name='max_patients_per_day' id='max_patients_per_day' TYPE=TEXT SIZE=5 MAXLENGTH=3    value='<%=p_max_pat_per_day%>' onKeyPress='return  allowValidNumber(this,event,3,0);' onBlur="javascript:ChkNumber(this);MaxPatPerDay(this);" >

				<INPUT name='old_max_patients_per_day' id='old_max_patients_per_day' TYPE=hidden value='<%=p_max_patients_per_day%>' ><img id='mx_pat_per_day' src="../../eCommon/images/mandatory.gif" align='center'></img>
			</TD>

			<!--Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1-->
			<%if(isSlotStartMidEndAppl){%>
				<td class=label id="allslots" style="display:none" nowrap>
					<fmt:message key="eOA.AllSlots.label" bundle="${oa_labels}"/>
					<input type=checkbox name="ext_all_slots_yn" id="ext_all_slots_yn" onClick='ExtAllSlotsYN(this);' value="<%=ext_all_slots_yn%>" <%=ext_all_slots_yn_chk%>>
				</td>

				<td class="fields" id="StartMidEnd" style="display:none" nowrap>
					<input name='ext_start_slots' id='ext_start_slots' type=text size=3 maxlength=3 onKeyPress='return allowValidNumber(this,event,3,0);' value='<%=ext_start_slots%>'><fmt:message key="Common.Start.label" bundle="${common_labels}"/>
					&nbsp;
					<input name='ext_mid_slots' id='ext_mid_slots' type=text size=3 maxlength=3 onKeyPress='return allowValidNumber(this,event,3,0);' value='<%=ext_mid_slots%>'><fmt:message key="Common.Mid.label" bundle="${common_labels}"/>
					&nbsp;
					<input name='ext_end_slots' id='ext_end_slots' type=text size=3 maxlength=3 onKeyPress='return allowValidNumber(this,event,3,0);' value='<%=ext_end_slots%>'><fmt:message key="Common.End.label" bundle="${common_labels}"/>
				</td>
			<%}else{%>			
					<td  >&nbsp;</td>
					<td  >&nbsp;</td>
			<%}%>

	</TR>

			<th nowrap colspan='1' align='left' class='COLUMNHEADER' style="color:white"><fmt:message key="eOA.VisitOverBookingDetails.label" bundle="${oa_labels}"/></th><th class =COLUMNHEADER  id = 'slot_or_pat_id1' COLSPAN='5' style="color:white" nowrap><%=slot_or_pat%></th>
			<TR>
			<%if (visit_limit_rule.equals("E"))
			{%>
				<TD class="label"  nowrap><fmt:message key="eOA.nooffirstvisits.label" bundle="${oa_labels}"/></TD>
			<%}else {%>
				<TD class="label"  nowrap><fmt:message key="eOA.maxfirstvisits.label" bundle="${oa_labels}"/></TD>
			<%}%>
			
			<TD class="fields"  nowrap>
			<input name='max_first_visit' id='max_first_visit' type=text size=5 maxlength=3    value='<%=p_max_first_visits%>' onBlur="javascript:MaxFirstVisit(this);chkMaximumFirstVisit(this,first_visit_cnt)" onKeyPress='return  allowValidNumber(this,event,3,0);'>
			</td>

			
			
			<%if (visit_limit_rule.equals("E")){%>
				<TD class="label"  nowrap><fmt:message key="eOA.noofothervisits.label" bundle="${oa_labels}"/></TD>
			<%}else {%>
				<TD class="label"  nowrap><fmt:message key="eOA.MaxOtherVisits.label" bundle="${oa_labels}"/></TD>
			<%}%>
			
			<TD class="fields" nowrap colspan='3'>
			<INPUT name='max_other_visits' id='max_other_visits' TYPE=TEXT SIZE=5 MAXLENGTH=3 
			onblur = 'maxothervisit()' value='<%=p_max_other_visits%>' onKeyPress='return  allowValidNumber(this,event,3,0);'>
			
			</td>
			


			<INPUT name='b_max_slots_for_first_visit' id='b_max_slots_for_first_visit' TYPE=hidden value='0'></input>
	</tr>
	<%if(rule_appl_yn.equals("Y")){%>
		<tr id='entitledPatRow' style ='display:'>
			<td class="label"  nowrap>Max New Patients</td>
			<td class="fields"  nowrap>
			<input name='max_new_patients' id='max_new_patients' type=text size=5 maxlength=3    value='<%=max_new_patients%>' onBlur="javascript:NewOldPatValidation(this)" onKeyPress='return  allowValidNumber(this,event,3,0);'><img src="../../eCommon/images/mandatory.gif" align='center'>
			</td>
			<td class="label"  nowrap>Max Old Patients</td>
			<td class="fields"  nowrap>
			<input name='max_old_patients' id='max_old_patients' type=text size=5 maxlength=3    value='<%=max_old_patients%>' onBlur="javascript:NewOldPatValidation(this)" onKeyPress='return  allowValidNumber(this,event,3,0);'><img src="../../eCommon/images/mandatory.gif" align='center'>
			</td>
		</tr>
	<%}%>
	<tr>
				
			<TD class="label"  nowrap><fmt:message key="eOA.maxob.label" bundle="${oa_labels}"/></TD>

			<TD class="fields" colspan='3'>
			<input name='max_over_bookings' id='max_over_bookings' type=text size=5 maxlength=3    value='<%=p_max_over_booking%>' onBlur="javascript:MaxOverBookings(this,'setUp');chkMaximumOverBooking(this,overbook_cnt);" onKeyPress='return  allowValidNumber(this,event,3,0);'>		
			</TD>
				
			<td  >&nbsp;</td>
			<td  >&nbsp;</td>
			</TR>
			<%
							
				String	chked="";
				String dsib="disabled";
				if (Integer.parseInt(forcedNo)>0)
				{
					chked="checked";
					dsib="";
							

				}else{
					forcedNo="";

				}
				String dsib1="disabled";

				if (Integer.parseInt(globalNo)>=0)
				{
					dsib1="";
				}else {
					globalNo="";
				}
				if(Integer.parseInt(globalNo)==0)
				{
					globalNo="";
				}
				%>
		</TR>
	
			
			<th nowrap  align='left' class='COLUMNHEADER' COLSPAN='6' style="color:white"><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></th>
		
		<TR>
				<TD class="label" WIDTH='25%' nowrap><fmt:message key="eOA.ForcedinBookingsallowed.label" bundle="${oa_labels}"/></TD>

				<TD class="fields" WIDTH='25%'><input type="checkbox" name="forced_book_YN" id="forced_book_YN" onclick="check_Forced()" <%=chked%>></TD>

			

				<td class = label id = 'slot_or_pat_id3'nowrap><fmt:message key="eOA.NoofForcedinBookingday.label" bundle="${oa_labels}"/></td>
				
			<TD class="fields" colspan='3'>
			<% if(!function_mode.equals("modify")) 
			{ %>
				<input type="text" name="no_of_forced_booking" id="no_of_forced_booking" size=5 maxlength=3 value="" onKeyPress='return  allowValidNumber(this,event,3,0);'>
					
			<%}else{%>
				<input <%=dsib%> type="text" name="no_of_forced_booking" size=5 maxlength=3 value="<%=forcedNo%>" onKeyPress='return  allowValidNumber(this,event,3,0);'> 
			<%}%>
			
			<img id='forced' src="../../eCommon/images/mandatory.gif" align='center' ></img>
			
			
	</TR>	
	<TR>
		
			<TD class="label"  nowrap><fmt:message key="eOA.noofglobalbookingperday.label" bundle="${oa_labels}"/></TD>
		
			<TD class="fields" colspan='3' >	
			<% 
			
			if(!function_mode.equals("modify")) 
			{ %>
				<input type="text"  name="no_of_global_booking" id="no_of_global_booking" size=5 maxlength=3 value="" onKeyPress='return  allowValidNumber(this,event,3,0);'>
			<%}else{%>
				<input  type="text" <%=dsib1%>  name="no_of_global_booking" size=5 maxlength=3 value="<%=globalNo%>"   onKeyPress='return  allowValidNumber(this,event,3,0);'>
			<%}%>
			</td>
					
					<td  >&nbsp;</td>
			<%if(!alcncriteria.equals("")){%>
			<td class='button' nowrap colspan='2'><input type='button' name='AllocationDetails' id='AllocationDetails' value='<fmt:message key="eOA.Allocation.label" bundle="${oa_labels}"/>'  class="BUTTON" onclick='showAalocation()'></td>
			<%}else{%>
			<td >&nbsp;</td>
			<%}%>

	</TR>		
				
	<TR>
			<TD class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></TD>

			<TD class="fields" COLSPAN='5'>
			<input name='remarks' id='remarks' value="<%=p_remarks%>" type=text size=60  onblur = 'return makeValidString(this)'   maxlength=60 ></TD>
	</tr>
			</table>		
			<table width='100%' cellpadding='0' cellspacing='0' border='0'  align='center'>
			<th align='left' class='COLUMNHEADER' colspan='5' style="color:white"><fmt:message key="eOA.BreakTime.label" bundle="${oa_labels}"/></th>
				<tr><td colspan='4'></td>	</tr>
			<tr>
			<td class="label" align='right' width='34%'>&nbsp;</td>
			<td class="label"  width='8%' ><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></td>		
			<td class="label" align='right' width='10%'>&nbsp;</td>
			<td class="label"  width='6%'><fmt:message key="Common.totime.label" bundle="${common_labels}"/></td>
			<td class="label" >&nbsp;</td>
			<%	
			if(!function_mode.equals("modify"))
			{
				int i = 1; 
				for( i=1;i<6;i++)
				{%>

				<TR>
					<TD class="label">&nbsp;</TD>

					<TD class="fields">
						<INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name='from_time<%=i%>' id='from_time<%=i%>' onKeyUp='javascript:formatBreakFrToTime("<%=i%>")' onBlur='ChkTime(this);CallFromBreakTimeValidation(this,"<%=i%>");'>
					</TD>

					<TD class="label" >&nbsp;</TD>

					<TD class="fields" >
						<INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name='to_time<%=i%>' id='to_time<%=i%>'  onKeyUp='javascript:formatBreakFrToTime("<%=i%>")' onBlur='ChkTime(this);CallToBreakTimeValidation(this,"<%=i%>"); '>
					</TD>
					<td class="label" >&nbsp;</td>
				</TR>
				<%}
			}else
			{
				int i = 1;
				String fr="";
				String to="";
				boolean bool=true;
			  for( i=1;i<6;i++)
			  {
					%>
					<TR>
					<TD class="label" align='right' width='33%'>&nbsp;&nbsp;</TD>
					<TD class="fields" width='8%' >
					<%
					  if(rspop_break.next() && bool)
					  {
					   	fr=rspop_break.getString("break_start_time");
					   	to=rspop_break.getString("break_end_time");
					  }else
					  {
					   	fr="";
					   	to="";
					   	bool=false;
					   }%>
					 
					  <INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name='from_time<%=i%>' id='from_time<%=i%>' VALUE='<%=fr%>'
					  onKeyUp='javascript:formatBreakFrToTime("<%=i%>")' onBlur='ChkTime(this);CallFromBreakTimeValidation(this,"<%=i%>");'>
					  </TD>

					<TD class="label"  width='10%'>&nbsp;</TD>
					<TD class="fields" width='6' >
				
					<INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name='to_time<%=i%>' id='to_time<%=i%>' VALUE='<%=to%>' onKeyUp='javascript:formatBreakFrToTime("<%=i%>")' onBlur='ChkTime(this);CallToBreakTimeValidation(this,"<%=i%>");'>
					</TD>
					<td class="label" >&nbsp;</td>
					</TR>
				<%}//for loop
			}%>
			
				<tr><td colspan='5'>&nbsp;</td>	</tr>
				<input type='hidden' name='ftotstr' id='ftotstr' value=''>
				<% if(!function_mode.equals("modify")) 
				{ %>
					<input type='hidden' name='fmode' id='fmode' value='insert'>
				<% } else
				{ %>
					<input type='hidden' name='fmode' id='fmode' value='modify'>
				<% } %>

			</table>
			

		<input type='hidden' name='start_appt_time' id='start_appt_time' value='<%=start_appt_time%>' >
		<input type='hidden' name='end_appt_time' id='end_appt_time' value='<%=end_appt_time%>' >
		<input type='hidden' name='block_start_time' id='block_start_time' value='<%=block_start_time%>' >
		<input type='hidden' name='block_end_time' id='block_end_time' value='<%=block_end_time%>' >
		<input type='hidden' name='overbook_cnt' id='overbook_cnt'  value='<%=overbook_cnt%>' >
		<input type='hidden' name='first_visit_cnt' id='first_visit_cnt' value='<%=first_visit_cnt%>' >
		<input type='hidden' name='other_visit_cnt' id='other_visit_cnt' value='<%=other_visit_cnt%>' >
		<input type='hidden' name='alcn_criteria' id='alcn_criteria' value='<%=alcncriteria%>' >
		<input type='hidden' name='final_alcn_criteria' id='final_alcn_criteria' value='<%=finalalcnString%>' >
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facilityid%>' >
		<input type='hidden' name='insert_detail' id='insert_detail' value='N' >	
		<input type='hidden' name='final_values' id='final_values' value='' >		
		<input type='hidden' name='clinic_code' id='clinic_code' value='<%=p_clinic_code%>' >
		<input type='hidden' name='alcn_basis' id='alcn_basis' value='<%=alcn_basis%>' >
		<input type='hidden' name='practid' id='practid' value='<%=practid%>' >		
	   	<input type='hidden' name='final_string' id='final_string'  value=''>
	   	<input type='hidden' name='final_string1' id='final_string1'  value="DFLT">
	   	<input type='hidden' name='allocation_changed' id='allocation_changed'  value='N'>
		<input type='hidden' name='day_no' id='day_no'  value='1'>
		<input type='hidden' name='max_patients1' id='max_patients1'  value=''>
		<input type='hidden' name='p_time_table_type' id='p_time_table_type'  value='<%=p_time_table_type%>'>
		<input type='hidden' name='p_start_time' id='p_start_time'  value='<%=p_start_time%>'>
		<input type='hidden' name='p_end_time' id='p_end_time'  value='<%=p_end_time%>'>
		<input type='hidden' name='function_mode' id='function_mode'  value='<%=function_mode%>'>
		<input type='hidden' name='slot_appt_ctrl' id='slot_appt_ctrl' value='<%=slot_appt_ctrl%>'>
		<input type='hidden' name='visit_limit_rule' id='visit_limit_rule' value='<%=visit_limit_rule%>'>
		<input type='hidden' name='hddDur' id='hddDur' value=''>
		<input type='hidden' name='defStartTime' id='defStartTime' value='<%=startTime%>'>
		<input type='hidden' name='defEndTime' id='defEndTime' value='<%=endTime%>'>
		<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
		<input type='hidden' name='l_ident_at_checkin' id='l_ident_at_checkin'>
		<input type='hidden' name='l_fi_visit_type_appl_yn' id='l_fi_visit_type_appl_yn'>
		<INPUT TYPE='hidden' name='l_open_to_all_pract_yn' id='l_open_to_all_pract_yn' SIZE='10'>
		<INPUT type='hidden' name='DaysForClinic' id='DaysForClinic' value=''>
		<INPUT type='hidden' name='function_type' id='function_type' value='<%=function_type%>'>
		<INPUT type='hidden' name='locale' id='locale' value='<%=locale%>'>
			<input type='HIDDEN' name='CurrentDatetm' id='CurrentDatetm' value='<%=CurrentDatetm%>' >
		<input type='HIDDEN' name='CurrentDate' id='CurrentDate' value='<%=CurrentDate%>' >
		<input type='HIDDEN' name='result' id='result' value='' >
		<input type='HIDDEN' name='rule_appl_yn' id='rule_appl_yn' value='<%=rule_appl_yn%>' >

		<!--Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112-->
		<input type='hidden' name='isScheduleExtendAppl' id='isScheduleExtendAppl' value='<%=isScheduleExtendAppl%>' >
		<input type='hidden' name='schedule_extend_param' id='schedule_extend_param' value='<%=schedule_extend_param%>' >

		<!--Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1-->
		<input type='hidden' name='isSlotStartMidEndAppl' id='isSlotStartMidEndAppl' value='<%=isSlotStartMidEndAppl%>' >
		<input type='hidden' name='old_ext_all_slots_yn' id='old_ext_all_slots_yn' value='<%=ext_all_slots_yn%>' >
		<input type='hidden' name='old_ext_start_slots' id='old_ext_start_slots' value='<%=ext_start_slots%>' >
		<input type='hidden' name='old_ext_mid_slots' id='old_ext_mid_slots' value='<%=ext_mid_slots%>' >
		<input type='hidden' name='old_ext_end_slots' id='old_ext_end_slots' value='<%=ext_end_slots%>' >

			
		<% if(function_mode.equals("modify"))
		{ %>
					<% if(p_time_table_type.equals("1"))
					{ %>
							<script>
							//Commented by S.Sathish for IN020308 on Wednesday, April 07, 2010 
							//document.forms[0].time_per_patient.readOnly=true; 
							document.forms[0].max_patients_per_day.readOnly=true;
							document.forms[0].b_max_slots_per_day.disabled=true;
							document.forms[0].t_per_pat.style.visibility='visible'
							document.forms[0].mx_pat_per_day.style.visibility='visible'
							document.forms[0].t_per_slab.style.visibility='hidden'
							document.forms[0].mx_per_slab.style.visibility='hidden'
							document.forms[0].time_per_slab.readOnly=true;
							document.forms[0].max_patients_per_slab.readOnly=true;	
							if (document.forms[0].visit_limit_rule.value=="N")
			{
				 document.forms[0].max_first_visit.readOnly=true;
				 document.forms[0].max_other_visits.readOnly=true;
			}
							</script>
				  <%}else if( p_time_table_type.equals("2"))
				  { %> 
							<script>
							/*Commented by S.Sathish for IN020308 on Wednesday, April 07, 2010 starts here */
							//parent.frames[1].document.forms[0].time_per_slab.readOnly=true;
							//parent.frames[1].document.forms[0].max_patients_per_slab.readOnly=true;	
							/*Ends here*/
							document.getElementById('t_per_slab').style.visibility='visible'
							document.getElementById('mx_per_slab').style.visibility='visible'
							document.getElementById('t_per_pat').style.visibility='hidden'
							document.getElementById('mx_pat_per_day').style.visibility='hidden'	
							
							document.forms[0].time_per_patient.readOnly=true;
							document.forms[0].max_patients_per_day.readOnly=true;
							if (document.forms[0].visit_limit_rule.value=="N")
			{
				 document.forms[0].max_first_visit.readOnly=true;
				 document.forms[0].max_other_visits.readOnly=true;
			}
							</script>
							
				<% } else if(p_time_table_type.equals("3"))
				{%>
							<script>
							document.forms[0].time_per_slab.readOnly=true;
							document.forms[0].max_patients_per_slab.readOnly=true;
							document.forms[0].time_per_patient.readOnly=true;
							/*Commented by S.Sathish for IN020308 on Wednesday, April 07, 2010 starts here */
							//document.forms[0].max_patients_per_day.disabled=true;		
							//document.forms[0].time_per_patient.readOnly=true;
							//document.forms[0].time_per_slab.readOnly=true;
							//document.forms[0].max_patients_per_slab.readOnly=true;
							/*Ends here*/
							document.getElementById('mx_pat_per_day').style.visibility='visible';
							
							document.getElementById('t_per_pat').style.visibility='hidden'
							document.getElementById('t_per_slab').style.visibility='hidden'
							document.getElementById('mx_per_slab').style.visibility='hidden'
							
							if (document.forms[0].visit_limit_rule.value=="N")
							{
								 document.forms[0].max_first_visit.readOnly=true;
								document.forms[0].max_other_visits.readOnly=true;
							}
							</script>
				<% }%>
					
		<%}else
		{%> 
			<script>
			hidemand();       
			parent.frames[1].document.getElementById('slot_or_pat_id1').innerText = "           ";
			//parent.frames[1].document.getElementById('slot_or_pat_id2').innerText = "           ";
			//parent.frames[1].document.getElementById('slot_or_pat_id3').innerText = "           ";
			document.getElementById('imgpract').style.visibility='hidden';
			
			if (document.forms[0].visit_limit_rule.value=="N")
			{
				 document.forms[0].max_first_visit.readOnly=true;
				 document.forms[0].max_other_visits.readOnly=true;
			}
			</script> 
			<script>
				document.forms[0].forced_book_YN.disabled=true;
				document.forms[0].no_of_forced_booking.disabled=true;
			</script>

		<%}%>

		</form>
		</body>		
		</html>
<% 
	if(rsAlcn !=null) rsAlcn.close();

	if(rs_valstart !=null) rs_valstart.close();
	if(rs_valstart !=null) rs_valstart.close();
	if(rs_blkappt !=null) rs_blkappt.close();
	if(rspop_sch !=null) rspop_sch.close();
	if(rspop_break !=null) rspop_break.close();
	if(rsLoc !=null) rsLoc.close();
//	if(rssql1 !=null) rssql1.close();
//	if(rssql2 !=null) rssql2.close();
	if(stmtnAlcn !=null) stmtnAlcn.close();
	if(stmtn !=null) stmtn.close();
	if(stmtn1 !=null) stmtn1.close();
//	if(stsql1 !=null) stsql1.close();
	if(stmtn2 !=null) stmtn2.close();
//	if(stsql2 !=null) stsql2.close();
	if(st_valstart !=null) st_valstart.close();
	if(st_blkappt !=null) st_blkappt.close();
//	if(chk_time !=null)chk_time.close();
	if(stmtnAlcn1 !=null)stmtnAlcn1.close();
	if(rsAlcn1 !=null)rsAlcn1.close();
	
} catch(Exception e ){
	e.printStackTrace();
	//out.println("hre:"+e.toString());
}
finally
{
	ConnectionManager.returnConnection(conn,request);
}
%>

