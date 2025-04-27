<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<html>
<head>  
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con = null;
ResultSet rs=null;
Statement stmt=null;
PreparedStatement pstmt=null;
String new_date=(String)request.getParameter("new_appt_date");
String end_time ="";
String clinic_code=(String)request.getParameter("i_clinic_code");
String practitioner_id=(String)request.getParameter("i_practitioner_id");
if( practitioner_id == null || practitioner_id.equals("null") ) practitioner_id="";
String facilityid=(String)session.getValue("facility_id");
String curr_user_id=(String)session.getValue("login_user");
String over_book_rights_yn="";
int no_of_slots = 0;
String over_booked=(String)request.getParameter("over_booked");
if (over_booked== null || over_booked.equals("null") ) over_booked="";
String over_book_yn=(String)request.getParameter("obook_appt_yn");
if (over_book_yn== null || over_book_yn.equals("null") ) over_book_yn="";
String to_over_book_yn=(String)request.getParameter("overbook1");
if (to_over_book_yn== null || to_over_book_yn.equals("null") ) to_over_book_yn="";


String old_date=(String)request.getParameter("i_appt_date");
if(old_date  == null || old_date.equals("null")) old_date="";
String old_from_time=(String)request.getParameter("i_from_time");
if(old_from_time  == null || old_from_time.equals("null")) old_from_time="";
String old_to_time=(String)request.getParameter("i_to_time");
if(old_to_time  == null || old_to_time.equals("null")) old_to_time="";
String appt_ref_no=(String)request.getParameter("i_appt_ref_no");
if(appt_ref_no  == null || appt_ref_no.equals("null")) appt_ref_no="";
String alcn_criteria=(String)request.getParameter("alcn_criteria");
String global_locn_yn="";

String old_pract_id1=(String)request.getParameter("old_pract_id1");
if(old_pract_id1  == null || old_pract_id1.equals("null")) old_pract_id1="";

String old_clinic_code=(String)request.getParameter("old_clinic_code");
if(old_clinic_code  == null || old_clinic_code.equals("null")) old_clinic_code="";

String clinic_type=request.getParameter("clinic_type");
String res_type=request.getParameter("res_type");

if (clinic_type==null) clinic_type = "C";
if (res_type==null) res_type = "P";

String locale=(String)session.getAttribute("LOCALE");




String P_O_PRACTITIONER       ="";       
String P_O_MAX_PAT            ="";       
String P_O_MAX_OVER_BOOK      ="";       
String P_O_BOOKED             ="";       
String P_O_OVER_BOOKED        ="";       

String P_O_TIME_TAB_TYPE     ="";        
String P_O_TO_TIME            ="";       
String P_O_MAX_FORCED_BOOK    ="";
String P_O_FORCED_BOOK		  =""; 	
String P_O_MAX_GLOBAL_BOOK    ="";
String P_O_GLOBAL_BOOK		  =""; 	

String P_O_MAX_SLOTS_FOR_FIRST_VISITS = "";
String P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED="";
String P_O_MAX_FIRST_VISITS = "";
String P_O_MAX_FIRST_VISITSTemp = "";

String P_O_TOTAL_FIRST_VISIT = "";
String new_day = "";
String visit_type_ind = "";
String over_book_sql ="";
String P_O_MAX_SLOTS_PER_DAY="";
String P_O_MAX_OTHER_VISITS="";
String P_O_TOTAL_OTHER_VISITS="";

String TOTAL_NORMAL_TFR="";
String TOTAL_BULK_TFR="";

String slot_appt_ctrl=request.getParameter("slot_appt_ctrl");
String visit_limit_rule=request.getParameter("clinic_type");

no_of_slots = Integer.parseInt(request.getParameter("no_of_slots_value1"));
visit_type_ind =request.getParameter("old_visit_type_ind1");

try
{			

			con = ConnectionManager.getConnection(request);
			stmt=con.createStatement();

			

			String display_details=null;
			if(practitioner_id.equals("")){
			//	display_details="select OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_name, time_table_type, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked, start_time,end_time, nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked, nvl(max_slots_for_first_visit,0) max_slots_for_first_visit,  nvl(total_first_visit,0)+nvl(total_first_visits_blocked,0) total_first_visit, nvl(max_first_visits,'') max_first_visits, nvl(max_other_visits,0) max_other_visits, nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0)+nvl(total_other_visits_blocked,0) total_other_visits, nvl(max_slots_per_day,0) max_slots_per_day,nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING , nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING , nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED, TOTAL_NORMAL_TFR, TOTAL_BULK_TFR from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_date  =to_date('"+new_date+"','dd/mm/yyyy') and clinic_code='"+clinic_code+"' and care_locn_type_ind ='"+clinic_type+"' and resource_class='"+res_type+"'  and Practitioner_id is null";
				display_details="select OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,?,'1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,?,'2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2')) practitioner_name, time_table_type, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked, start_time,end_time, nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked, nvl(max_slots_for_first_visit,0) max_slots_for_first_visit,  nvl(total_first_visit,0)+nvl(total_first_visits_blocked,0) total_first_visit, nvl(max_first_visits,'') max_first_visits, nvl(max_other_visits,0) max_other_visits, nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0)+nvl(total_other_visits_blocked,0) total_other_visits, nvl(max_slots_per_day,0) max_slots_per_day,nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING , nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING , nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED, TOTAL_NORMAL_TFR, TOTAL_BULK_TFR from oa_clinic_schedule where facility_id=? and clinic_date  =to_date(?,'dd/mm/yyyy') and clinic_code=? and care_locn_type_ind =? and resource_class=? and Practitioner_id is null";
			}else{
				//display_details="select OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_name, time_table_type, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked, start_time,end_time, nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked, nvl(max_slots_for_first_visit,0) max_slots_for_first_visit,  nvl(total_first_visit,0)+nvl(total_first_visits_blocked,0) total_first_visit, nvl(max_first_visits,'') max_first_visits, nvl(max_other_visits,0) max_other_visits, nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0)+nvl(total_other_visits_blocked,0) total_other_visits, nvl(max_slots_per_day,0) max_slots_per_day,nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING , nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING , nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED, TOTAL_NORMAL_TFR, TOTAL_BULK_TFR from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_date  =to_date('"+new_date+"','dd/mm/yyyy') and clinic_code='"+clinic_code+"' and care_locn_type_ind ='"+clinic_type+"' and resource_class='"+res_type+"'  and Practitioner_id = '"+practitioner_id+"'";
				display_details="select OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,?,'1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,?,'2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2')) practitioner_name, time_table_type, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked, start_time,end_time, nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked, nvl(max_slots_for_first_visit,0) max_slots_for_first_visit,  nvl(total_first_visit,0)+nvl(total_first_visits_blocked,0) total_first_visit, nvl(max_first_visits,'') max_first_visits, nvl(max_other_visits,0) max_other_visits, nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0)+nvl(total_other_visits_blocked,0) total_other_visits, nvl(max_slots_per_day,0) max_slots_per_day,nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING , nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING , nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED, TOTAL_NORMAL_TFR, TOTAL_BULK_TFR from oa_clinic_schedule where facility_id=? and clinic_date  =to_date(?,'dd/mm/yyyy') and clinic_code=? and care_locn_type_ind =? and resource_class=?  and Practitioner_id = ?";
			}
						
		//	rs = stmt.executeQuery(display_details);
			pstmt = con.prepareStatement(display_details);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,facilityid);
			pstmt.setString(6,new_date);
			pstmt.setString(7,clinic_code);
			pstmt.setString(8,clinic_type);
			pstmt.setString(9,res_type);
			if(practitioner_id.equals("")){
			}
			else{
			pstmt.setString(10,practitioner_id);
			}
			rs = pstmt.executeQuery();
			if(rs!=null){
			while ( rs.next() )
			{

				P_O_PRACTITIONER 	= rs.getString("practitioner_name");
				if( P_O_PRACTITIONER == null) P_O_PRACTITIONER="";
				P_O_MAX_PAT 		= rs.getString("max_patients_per_day");
				P_O_TIME_TAB_TYPE    = rs.getString("time_table_type" );  
				
				P_O_MAX_FORCED_BOOK  =rs.getString("MAX_FORCED_IN_BOOKING");
				if(P_O_MAX_FORCED_BOOK==null)P_O_MAX_FORCED_BOOK="";
				P_O_FORCED_BOOK	=rs.getString("TOTAL_FORCED_IN_BOOKED");
				if(P_O_FORCED_BOOK==null)P_O_FORCED_BOOK="";

				P_O_MAX_GLOBAL_BOOK  =rs.getString("MAX_GLOBAL_BOOKING");
				if(P_O_MAX_GLOBAL_BOOK==null)P_O_MAX_GLOBAL_BOOK="";
				P_O_GLOBAL_BOOK	=rs.getString("TOTAL_GLOBAL_BOOKED");
				if(P_O_GLOBAL_BOOK==null)P_O_GLOBAL_BOOK="";

				TOTAL_NORMAL_TFR  =rs.getString("TOTAL_NORMAL_TFR");
				if(TOTAL_NORMAL_TFR==null)TOTAL_NORMAL_TFR="0";
				TOTAL_BULK_TFR	=rs.getString("TOTAL_BULK_TFR");
				if(TOTAL_BULK_TFR==null)TOTAL_BULK_TFR="0";
				

				P_O_MAX_OVER_BOOK   =rs.getString("max_over_booking" ); 
				if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";
				P_O_BOOKED                 	=rs.getString("total_slots_booked" );   if( P_O_BOOKED ==null) P_O_BOOKED="";
				P_O_OVER_BOOKED        =rs.getString( "total_slots_overbooked" );    if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";
				P_O_TO_TIME                  =rs.getString("start_time" );	if(P_O_TO_TIME == null) P_O_TO_TIME="";
				P_O_MAX_SLOTS_FOR_FIRST_VISITS = rs.getString("max_slots_for_first_visit"); if( P_O_MAX_SLOTS_FOR_FIRST_VISITS == null) P_O_MAX_SLOTS_FOR_FIRST_VISITS="";
				P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED= rs.getString("total_first_visit_slots_booked"); if( P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED == null) P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED="";
				P_O_MAX_FIRST_VISITSTemp = rs.getString("max_first_visits"); 
				
				if( !(P_O_MAX_FIRST_VISITSTemp == null || P_O_MAX_FIRST_VISITSTemp.equals("null"))){
					P_O_MAX_FIRST_VISITS=P_O_MAX_FIRST_VISITSTemp;
				}else{
					P_O_MAX_FIRST_VISITS="";
				}

				P_O_MAX_SLOTS_PER_DAY = rs.getString("MAX_SLOTS_PER_DAY"); if( P_O_MAX_SLOTS_PER_DAY== null) P_O_MAX_SLOTS_PER_DAY="";
				
				P_O_TOTAL_FIRST_VISIT = rs.getString("total_first_visit"); if( P_O_TOTAL_FIRST_VISIT == null) P_O_TOTAL_FIRST_VISIT="";
				P_O_MAX_OTHER_VISITS = rs.getString("max_other_visits"); if( P_O_MAX_OTHER_VISITS == null) P_O_MAX_OTHER_VISITS="";
				P_O_TOTAL_OTHER_VISITS = rs.getString("total_other_visits"); if( P_O_TOTAL_OTHER_VISITS == null) P_O_TOTAL_OTHER_VISITS="";
				if (P_O_TIME_TAB_TYPE.equals("1") && slot_appt_ctrl.equals("P"))
					P_O_BOOKED = String.valueOf(Integer.parseInt(P_O_TOTAL_FIRST_VISIT)+Integer.parseInt(P_O_TOTAL_OTHER_VISITS));
				if (!(visit_limit_rule.equals("N")))
				{
					if(! P_O_MAX_FIRST_VISITS.equals("") &&  !P_O_TOTAL_FIRST_VISIT.equals("") && 	 
					   ! P_O_MAX_OVER_BOOK.equals("")    && !P_O_OVER_BOOKED.equals(""))
						{
							if (Integer.parseInt(P_O_MAX_FIRST_VISITS) <= Integer.parseInt(P_O_TOTAL_FIRST_VISIT)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED) && visit_type_ind.equals("F")&&Integer.parseInt(P_O_MAX_FIRST_VISITS)>0)
												to_over_book_yn         ="Y";					
						}			
					if(! P_O_MAX_FIRST_VISITS.equals("") &&  !P_O_TOTAL_FIRST_VISIT.equals("") && 	 
					   ! P_O_MAX_OVER_BOOK.equals("")    && !P_O_OVER_BOOKED.equals("")&&visit_limit_rule.equals("E"))
						{
							if (Integer.parseInt(P_O_MAX_FIRST_VISITS) <= Integer.parseInt(P_O_TOTAL_FIRST_VISIT)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED) && visit_type_ind.equals("F"))
								to_over_book_yn         ="Y";					
						}			

					if(! P_O_MAX_OTHER_VISITS.equals("") &&  !P_O_TOTAL_OTHER_VISITS.equals("") && 	
						! P_O_MAX_OVER_BOOK.equals("")    && !P_O_OVER_BOOKED.equals("")&&Integer.parseInt(P_O_MAX_OTHER_VISITS)>0)
						{
						if (Integer.parseInt(P_O_MAX_OTHER_VISITS)>0 &&Integer.parseInt(P_O_MAX_OTHER_VISITS) <= Integer.parseInt(P_O_TOTAL_OTHER_VISITS)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED) && (!(visit_type_ind.equals("F"))))
							to_over_book_yn         ="Y";
					}
						if(! P_O_MAX_OTHER_VISITS.equals("") &&  !P_O_TOTAL_OTHER_VISITS.equals("") && 	
						! P_O_MAX_OVER_BOOK.equals("")    && !P_O_OVER_BOOKED.equals("")&&visit_limit_rule.equals("E"))
						{
						if (Integer.parseInt(P_O_MAX_OTHER_VISITS) <= Integer.parseInt(P_O_TOTAL_OTHER_VISITS)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED) && (!(visit_type_ind.equals("F"))))
							to_over_book_yn         ="Y";
					}
					
/*If condition added by S.Sathish for IN019815 on Monday, March 15, 2010*/
					 if(!P_O_MAX_PAT.equals("") &&  !P_O_BOOKED.equals(""))
						if((Integer.parseInt(P_O_MAX_PAT) > Integer.parseInt(P_O_BOOKED)) && (old_date.equals(new_date)) && (old_pract_id1.equals(practitioner_id)) && (old_clinic_code.equals(clinic_code))){
							to_over_book_yn         ="N";
						}




				}
				if(! P_O_MAX_PAT.equals("") &&  !P_O_BOOKED.equals("") && !P_O_MAX_OVER_BOOK.equals("") && !P_O_OVER_BOOKED.equals(""))
					{
		 				if (Integer.parseInt(P_O_MAX_PAT) == Integer.parseInt(P_O_BOOKED)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED))							to_over_book_yn         ="Y";
					}
				}

			}
			if(rs !=null) rs.close();
	 if (to_over_book_yn.equals("Y"))
		{
		 if(practitioner_id.equals("")){
			// over_book_sql = "select to_char(to_date('"+new_date+"','dd/mm/yyyy'),'Day') new_day, to_char(end_time,'hh24:mi') end_time from oa_clinic_schedule where facility_id ='"+facilityid+"' and clinic_code = '"+clinic_code+"' and clinic_date=to_date('"+new_date+"','dd/mm/yyyy') and practitioner_id is null";
			 over_book_sql = "select to_char(to_date(?,'dd/mm/yyyy'),'Day') new_day, to_char(end_time,'hh24:mi') end_time from oa_clinic_schedule where facility_id =? and clinic_code = ? and clinic_date=to_date(?,'dd/mm/yyyy') and practitioner_id is null";
		 }else{
			 //over_book_sql = "select to_char(to_date('"+new_date+"','dd/mm/yyyy'),'Day') new_day, to_char(end_time,'hh24:mi') end_time from oa_clinic_schedule where facility_id ='"+facilityid+"' and clinic_code = '"+clinic_code+"' and clinic_date=to_date('"+new_date+"','dd/mm/yyyy') and practitioner_id ='"+practitioner_id+"'";
			 over_book_sql = "select to_char(to_date(?,'dd/mm/yyyy'),'Day') new_day, to_char(end_time,'hh24:mi') end_time from oa_clinic_schedule where facility_id =? and clinic_code = ? and clinic_date=to_date(?,'dd/mm/yyyy') and practitioner_id =?";
		 }
		//rs = stmt.executeQuery(over_book_sql);
		pstmt = con.prepareStatement(over_book_sql);
		pstmt.setString(1,new_date);
		pstmt.setString(2,facilityid);
		pstmt.setString(3,clinic_code);
		pstmt.setString(4,new_date);
		if(practitioner_id.equals("")){
		 }else{
		pstmt.setString(5,practitioner_id);
		}
		rs = pstmt.executeQuery();
		while(rs!=null&&rs.next())
			{
			new_day = rs.getString("new_day");
			end_time = rs.getString("end_time");
			}
		if (rs!=null) rs.close();
		 //over_book_sql = "select nvl(b.obook_appt_yn,'N') over_book_rights_yn,global_locn_yn from op_clinic a,am_os_user_locn_access_vw b where a.clinic_code ='"+clinic_code+"' and a.facility_id='"+facilityid+"'  and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind='A' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityid+"'  AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+curr_user_id+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id='"+curr_user_id+"' and (b.book_appt_yn='Y' or b.book_appt_wo_pid_yn='Y' or b.obook_appt_yn='Y' or b.book_appt_across_catg_yn='Y' or b.tfr_appt_yn='Y' or b.tfr_appt_across_catg_yn='Y' or b.canc_appt_yn='Y') ";
		 over_book_sql = "select nvl(b.obook_appt_yn,'N') over_book_rights_yn,global_locn_yn from op_clinic a,am_os_user_locn_access_vw b where a.clinic_code =? and a.facility_id=? and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind='A' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id=?  AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id =? AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id=? and (b.book_appt_yn='Y' or b.book_appt_wo_pid_yn='Y' or b.obook_appt_yn='Y' or b.book_appt_across_catg_yn='Y' or b.tfr_appt_yn='Y' or b.tfr_appt_across_catg_yn='Y' or b.canc_appt_yn='Y') ";
		//rs = stmt.executeQuery(over_book_sql);
		pstmt = con.prepareStatement(over_book_sql);
		pstmt.setString(1,clinic_code);
		pstmt.setString(2,facilityid);
		pstmt.setString(3,facilityid);
		pstmt.setString(4,curr_user_id);
		pstmt.setString(5,curr_user_id);
		rs = pstmt.executeQuery();
		while(rs!=null&&rs.next())
			{
			over_book_rights_yn = rs.getString("over_book_rights_yn");
			global_locn_yn = rs.getString("global_locn_yn");
			if(global_locn_yn==null)global_locn_yn="N";
			}
		if (rs!=null) rs.close();


		}		
		if(alcn_criteria==null)alcn_criteria="";


String new_date_display=DateUtils.convertDate(new_date,"DMY","en",locale);

%>
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="single_pract" id="single_pract">
<input type='hidden' name='help_function_id' id='help_function_id' value='RESCHEDULE_APPOINTMENT'>
<table cellspacing='0' width='100%' cellpadding='0' border='0' width='90%'>
	<th align=left><b><fmt:message key="Common.day.label" bundle="${common_labels}"/> <fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>
 - <%=new_date_display%></b></th>
<tr><td class='white'></td></tr>
</table>
<form name="single_pract" id="single_pract">
<table border='0' cellspacing='0' width='100%' cellpadding='0'> 
<tr>
<td>
<table width='100%' cellspacing='0' cellpadding='0' border='0'>

	<tr>

	<td class='label' width='10%'>&nbsp;</td>
	<td class='label' width='10%'>&nbsp;</td>
	<td class='label' width='10%'>&nbsp;</td>
	<td class='label' width='10%'>&nbsp;</td>
	<td class='label' width='10%'>&nbsp;</td>
	<td class='label' width='10%'>&nbsp;</td>
	<td class='label' width='10%'>&nbsp;</td>
	<td class='label' width='10%'>&nbsp;</td>
	<td class='label' width='10%'>&nbsp;</td>
	</td><td class='label' >

	<%		
		if ( (to_over_book_yn.equals("Y") && global_locn_yn.equals("N")) && no_of_slots <=1) 
		{%><a href=javascript:over_booking() >
				<b><fmt:message key="eOA.overbooking.label" bundle="${oa_labels}"/></b> 
				</a> 
		<%}%></td>

	</tr>
	</table>

	<table width='100%' cellspacing='0' cellpadding='0' border='1'>
	<tr>
	<td class='label' >&nbsp;</td>
	<td class='label' align=middle>
	<% if (P_O_TIME_TAB_TYPE.equals("1") && slot_appt_ctrl.equals("S")){%>
		<b><fmt:message key="Common.Slot.label" bundle="${common_labels}"/></b>
	<%}else{%>
		<b><fmt:message key="Common.patient.label" bundle="${common_labels}"/></b>
	<%}%>
	</td>	
	<td class='label'><b><fmt:message key="Common.firstvisit.label" bundle="${common_labels}"/></b></td>
	<td class='label'><b><fmt:message key="Common.othervisit.label" bundle="${common_labels}"/></b></td>
	<td class='label'><b><fmt:message key="eOA.overbooking.label" bundle="${oa_labels}"/></b></td>
	<td class='label'><b><fmt:message key="eOA.Global.label" bundle="${oa_labels}"/></b></td>
	<td class='label'>
	<%if (!P_O_TIME_TAB_TYPE.equals("3")){%>		
		<b><fmt:message key="eOA.Forced.label" bundle="${oa_labels}"/></b>
	<%}else{%>
	<%}%>
    <!--Below line Modified for this CRF ML-MMOH-CRF-0606--> 
	<!--Below line Modified for this CRF ML-MMOH-CRF-0609 by Mano-->
	<td class='label'><b><fmt:message key="eOA.NormalReschedule.label" bundle="${oa_labels}"/>&nbsp;<fmt:message key="Common.count.label" bundle="${common_labels}"/></b></td>
	<td class='label'><b><fmt:message  key="eOA.BulkReschedule.label" bundle="${oa_labels}"/>&nbsp;<fmt:message key="Common.count.label" bundle="${common_labels}"/></b></td>
	<!--End this CRF ML-MMOH-CRF-0609-->
	<!--End this CRF ML-MMOH-CRF-0606-->
	</tr>
	<tr>
	<td class='label' ><b><fmt:message key="Common.maximum.label" bundle="${common_labels}"/></b></td>
	<td class='label' >
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
			<%}%>
	</td>
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
	<td class='label' align=middle>&nbsp;</td>
	<td class='label' align=middle>&nbsp;</td>
	</tr>	
	<tr>
	<td class='label' ><b><fmt:message key="Common.booked.label" bundle="${common_labels}"/></b></td>
	<!-- <td class='label' align=middle><b><%=P_O_BOOKED%></b></td>	 -->
	<td class='label' >
				<%if(P_O_BOOKED.equals("")){ //Added by S.Sathish for IN019815 on Monday, March 15, 2010 starts here
				P_O_BOOKED="0";
			%>				
				<b><%=P_O_BOOKED%></b>
			<%				
			}else{%>
				<b><%=P_O_BOOKED%></b>
			<%}%> <!--ends here-->
	</td>
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
	<td class='label' align=middle>&nbsp;</td>
	<td class='label' align=middle>&nbsp;</td>
	</tr>
	<tr>
	<!--Below line modified for this CRF ML-MMOH-CRF-0606-->
	<td class='label' nowrap width='2%'>&nbsp;</td>
	<td class='label'>&nbsp;</td>
	<td class='label'>&nbsp;</td>
	<td class='label'>&nbsp;</td>
	<td class='label'>&nbsp;</td>
	<td class='label'>&nbsp;</td>
	<td class='label'>&nbsp;</td>
	<td class='label' align=middle><b><%=TOTAL_NORMAL_TFR%></b></td>
	<td class='label' align=middle><b><%=TOTAL_BULK_TFR%></b></td>
	
	</tr>
		
</table>	
</table>	
<script>
async function over_booking()
{
	var appt_ref_no   ='<%=appt_ref_no%>'
	var clinic_code   ='<%=clinic_code%>'
	var pract_id	  ='<%=practitioner_id%>'
	var appt_date	  ='<%=new_date%>'
	var from_time     ='<%=end_time%>'
	var to_time		  ='<%=end_time%>'
	var over_booked	  ='<%=over_booked%>'
	var overbooked_yn ='<%=over_book_yn%>'
	var to_over_book_yn ='<%=to_over_book_yn%>'
	var old_date	  ='<%=old_date%>'
	var p_o_time_tab_type ='<%=P_O_TIME_TAB_TYPE%>'
	var over_book_rights_yn = '<%=over_book_rights_yn%>'
	var alcn_criteria='<%=alcn_criteria%>'

	var res_type= '<%=res_type%>'
	var clinic_type= '<%=clinic_type%>'
	var new_day = '<%=new_day%>'
	var retVal = 	new String();
	var dialogHeight= "40" ;
	var dialogWidth	= "85" ;
	var dialogTop = "65" ;
	var center = "1" ;
	var status="no";
	if(over_booked =='Y' && to_over_book_yn=='Y'){
		/*var appt_dateArr=appt_date.split("/");
		var old_dateArr=old_date.split("/");
		if(appt_dateArr[0]==old_dateArr[0] && appt_dateArr[1]==old_dateArr[1] && appt_dateArr[2]==old_dateArr[2]){
			alert('OverBooking Appointment can\'t be transferred to same date');
			return;
		}*/
		alert(getMessage('OVER_BOOK_NOT_ALLOWED_TO_ANOTHER_OVER_BOOK','OA'));  
		return;
	}
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
    if (over_book_rights_yn=="N")
	{
       alert(getMessage('OVER_BOOK_NOT_ALLOWED','OA'));       
	}
	else{
		var url="../../eOA/jsp/TransferAppointmentDetailsFrame.jsp?i_appt_ref_no="+appt_ref_no+"&i_clinic_code="+clinic_code+"&i_practitioner_id="+pract_id+"&new_day="+new_day+"&i_appt_date="+appt_date+"&i_from_time="+from_time+"&i_to_time="+to_time+"&over_booked="+over_booked+"&overbooked_yn="+overbooked_yn+"&i_time_table_type="+p_o_time_tab_type+"&old_date="+old_date+"&to_over_book_yn="+to_over_book_yn+"&clinic_type="+clinic_type+"&res_type="+res_type+"&alcn_criteria="+alcn_criteria;

	retVal = await window.showModalDialog(url,arguments,features);
	if(retVal=='closed')
	{
	setTimeout('close_main_wind()',1000);
	}
	}
}

function close_main_wind(){
	parent.window.returnValue='closed';
	parent.window.close();

}

</script>
<% 
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();

}catch(Exception e) { 
	//out.println(e);
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

  %>
</form>
</body>
</html>

