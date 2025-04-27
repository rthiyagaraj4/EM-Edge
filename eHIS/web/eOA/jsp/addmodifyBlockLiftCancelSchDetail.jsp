<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import  ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager,com.ehis.util.* ,eCommon.XSSRequestWrapper" %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eOA/js/BlockLiftCancelSch.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
</head>
</head>
<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	
 String locale=(String)session.getAttribute("LOCALE");

	String facilityId = (String) session.getValue( "facility_id" ) ;
	String efffrom =request.getParameter("eff_from");
	String effto =request.getParameter("eff_to");
	String action =request.getParameter("action");
	StringBuffer days =new StringBuffer("");
	String visit_limit_rule="";
	String bulk_blocking_yn="N";
	String block_time_from="00:00";
	String block_time_to="00:00";
	//String day =request.getParameter("day");
	String no_appts_booked="0";
	String day_1 =request.getParameter("day_1")==null?"":request.getParameter("day_1");
	String day_2 =request.getParameter("day_2")==null?"":request.getParameter("day_2");
	String day_3 =request.getParameter("day_3")==null?"":request.getParameter("day_3");
	String day_4 =request.getParameter("day_4")==null?"":request.getParameter("day_4");
	String day_5 =request.getParameter("day_5")==null?"":request.getParameter("day_5");
	String day_6 =request.getParameter("day_6")==null?"":request.getParameter("day_6");
	String day_7 =request.getParameter("day_7")==null?"":request.getParameter("day_7");
	String blk_time_to =request.getParameter("blk_time_to")==null?"":request.getParameter("blk_time_to");
	String blk_time_from =request.getParameter("blk_time_from")==null?"":request.getParameter("blk_time_from");

	//Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	String other_remarks = request.getParameter("other_remarks")==null?"":request.getParameter("other_remarks");

	boolean flag=false;
	String time_table_type="";
	if(day_1.equals("Y")){
		day_1="'MONDAY'";
		days.append(day_1);
		flag=true;
	}else{
		day_1="";
	}

	if(day_2.equals("Y")){
		day_2="'TUESDAY'";
		if(flag){
			days.append(","+day_2);
		}else{
			days.append(day_2);
		}
		flag=true;
	}else{
		day_2="";
	}

	if(day_3.equals("Y")){
		day_3="'WEDNESDAY'";
		if(flag){
			days.append(","+day_3);
		}else{
			days.append(day_3);
		}
		flag=true;
	}else{
		day_3="";
	}

	if(day_4.equals("Y")){
		day_4="'THURSDAY'";
		if(flag){
			days.append(","+day_4);
		}else{
			days.append(day_4);
		}
		flag=true;
	}else{
		day_4="";
	}

	if(day_5.equals("Y")){
		day_5="'FRIDAY'";
		if(flag){
			days.append(","+day_5);
		}else{
			days.append(day_5);
		}
		flag=true;
	}else{
		day_5="";
	}

	if(day_6.equals("Y")){
		day_6="'SATURDAY'";
		if(flag){
			days.append(","+day_6);
		}else{
			days.append(day_6);
		}
		flag=true;
	}else{
		day_6="";
	}

	if(day_7.equals("Y")){
		day_7="'SUNDAY'";
		if(flag){
			days.append(","+day_7);
		}else{
			days.append(day_7);
		}
		flag=true;
	}else{
		day_6="";
	}

	String dyas_qry="";
	if(flag){
		dyas_qry="in ("+days.toString()+")";
		//dyas_qry="=rtrim(to_char(clinic_date,'DAY'))";
	}else{
		dyas_qry="=rtrim(to_char(clinic_date,'DAY'))";
		//dyas_qry="in ("+days.toString()+")";
	}
	days.setLength(0);
	
	String practid = request.getParameter("pract_id");
	//out.println("practid::"+practid);
	String locncode = request.getParameter("locn_code");
	String reason = request.getParameter("reason");
	String reason_desc = request.getParameter("reason_desc");
	String resourcetype =request.getParameter("resourcetype");
	String locntype = request.getParameter("locntype");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	int    closed=0;
	int no_slots_to_be_blocked=0;

	String blk_schdl_with_appt_yn="N";

StringBuffer strsql2=new StringBuffer();
int blockApptCount=0;
String blockApptFlag="N";
String blockApptSQL="select count(*) from oa_block_appt where FACILITY_ID=? and CLINIC_CODE=? and trunc(BLOCK_DATE)=to_date(?,'dd/mm/yyyy') and nvl(practitioner_id,'X')= nvl(?,'X')";
   int currPage=0;


	efffrom=DateUtils.convertDate(efffrom,"DMY",locale,"en");
	effto=DateUtils.convertDate(effto,"DMY",locale,"en");

	String care_locn_type_ind="";
	String resource_class="";
	String clinic_day1 = "";
	if(reason_desc == null || reason_desc.equals("null"))  reason_desc = "";
	String cliniccode = "";
	String practname = "";
	String pract = "";
	String max_patients_per_day="";
		String primary_yn = "";
	String default_select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String clinicdate = "";
	String clinicdate_disp="";
	String noofappts = "";
	String sql = "";
	int k=0;
	String classValue="";
	String res_class="";
	String P_Report_Title = "";
	String start_time = "";
	String end_time = "";
	int total_time__blocking=0;
	String time_per_patient="";
	String time_per_slab="";
	int total_first_visits_available=0;
	int total_other_visits_available=0;
	int total_first_visits_blocked=0;
	int total_other_visits_blocked=0;
	if((blk_time_from!=null&&!blk_time_from.equals(""))&&(blk_time_to!=null&&!blk_time_to.equals(""))){
		StringTokenizer blk_time_from_token=new StringTokenizer(blk_time_from,":");
		StringTokenizer blk_time_to_token=new StringTokenizer(blk_time_to,":");
		int blk_time_from_hrs=0;
		int blk_time_from_mns=0;
		int blk_time_to_hrs=0;
		int blk_time_to_mns=0;
		bulk_blocking_yn="Y";
		while(blk_time_from_token.hasMoreElements()){
			blk_time_from_hrs=Integer.parseInt(blk_time_from_token.nextToken());
			blk_time_from_mns=Integer.parseInt(blk_time_from_token.nextToken());
		}
		while(blk_time_to_token.hasMoreElements()){
			blk_time_to_hrs=Integer.parseInt(blk_time_to_token.nextToken());
			blk_time_to_mns=Integer.parseInt(blk_time_to_token.nextToken());
		}
		if(blk_time_to_mns > blk_time_from_mns){
			total_time__blocking=((blk_time_to_hrs-blk_time_from_hrs)*60)+(blk_time_to_mns-blk_time_from_mns);
		}else{
			total_time__blocking=((blk_time_to_hrs-blk_time_from_hrs)*60)-(blk_time_from_mns-blk_time_to_mns);
		}
		
	}else{
		bulk_blocking_yn="N";
	}



    int i=1;

%>

<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()'>
<form name='BCLSchDetail_form' id='BCLSchDetail_form' action='../../servlet/eOA.BlockLiftCancelSchServlet' method='post' target='messageFrame'>
<%
		Connection con = null;
		Statement stmt = null,stmt1=null;
		PreparedStatement pstmt=null;
		ResultSet rset = null,rset1=null,prs=null;
		ResultSet rs1=null;
		int maxRecord = 0;
		String sql_param="SELECT VISIT_LIMIT_RULE,BLK_SCHDL_WITH_APPT_YN FROM oa_param where module_id='OA'";		
	 	
	try
		{
			con = ConnectionManager.getConnection(request);
			stmt=con.createStatement();
			stmt1=con.createStatement();
			rs1= stmt.executeQuery(sql_param);
			if(rs1!=null && rs1.next()){
				visit_limit_rule=rs1.getString("VISIT_LIMIT_RULE");
				blk_schdl_with_appt_yn=rs1.getString("BLK_SCHDL_WITH_APPT_YN")==null?"N":rs1.getString("BLK_SCHDL_WITH_APPT_YN");
			}
						int start = 0 ;
						int end = 0 ;

						if ( from == null )
							start = 1 ;
						else
							start = Integer.parseInt( from ) ;

						if ( to == null )
							end = 14 ;
						else
							end = Integer.parseInt( to ) ;

			if(action.equals("B"))
			{
					
					if(bulk_blocking_yn.equals("Y")){
					
					/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
					//sql=" from oa_clinic_schedule where facility_id='"+facilityId+"' and clinic_code=decode('"+locncode+"', '*ALL',clinic_code,'"+locncode+"') and nvl(practitioner_id,'X') = nvl('"+practid+"',nvl(practitioner_id,'X')) and care_locn_type_ind='"+locntype+"' and resource_class='"+resourcetype+"' and NVL(rtrim(to_char(clinic_date,'DAY')),'X') "+dyas_qry.toString()+" and clinic_date between to_date('"+efffrom+"','dd/mm/yyyy') and to_date('"+effto+"','dd/mm/yyyy') AND NVL (schedule_status, '*') NOT IN  ('B', 'X') AND time_table_type in ('1', '2') and (FACILITY_ID, CLINIC_CODE, CLINIC_DATE, PRACTITIONER_ID) in  (select FACILITY_ID, CLINIC_CODE, CLINIC_DATE, PRACTITIONER_ID from oa_clinic_schedule_slot_slab where facility_id='"+facilityId+"' and clinic_code = DECODE ('"+locncode+"', '*ALL', clinic_code, '"+locncode+"') AND NVL (practitioner_id, 'X') = NVL ('"+practid+"', NVL (practitioner_id, 'X')) AND care_locn_type_ind = '"+locntype+"' AND resource_class = '"+resourcetype+"' AND clinic_date BETWEEN TO_DATE ('"+efffrom+"', 'dd/mm/yyyy') AND TO_DATE ('"+effto+"', 'dd/mm/yyyy') AND to_date(to_char(SLOT_SLAB_START_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+blk_time_from+"','hh24:mi') and to_date('"+blk_time_to+"','hh24:mi') AND to_date(to_char(SLOT_SLAB_END_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+blk_time_from+"','hh24:mi') and to_date('"+blk_time_to+"','hh24:mi') AND NVL (schedule_status, '*') NOT IN  ('B', 'X'))";
				
                /* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
				sql=" from oa_clinic_schedule_vw where facility_id='"+facilityId+"' and clinic_code=decode('"+locncode+"', '*ALL',clinic_code,'"+locncode+"') and nvl(practitioner_id,'X') = nvl('"+practid+"',nvl(practitioner_id,'X')) and care_locn_type_ind='"+locntype+"' and resource_class='"+resourcetype+"' and NVL(rtrim(to_char(clinic_date,'DAY')),'X') "+dyas_qry.toString()+" and clinic_date between to_date('"+efffrom+"','dd/mm/yyyy') and to_date('"+effto+"','dd/mm/yyyy') AND NVL (schedule_status, '*') NOT IN  ('B', 'X') AND time_table_type in ('1', '2') and (FACILITY_ID, CLINIC_CODE, CLINIC_DATE, PRACTITIONER_ID) in  (select FACILITY_ID, CLINIC_CODE, CLINIC_DATE, PRACTITIONER_ID from oa_clinic_schedule_slot_slab where facility_id='"+facilityId+"' and clinic_code = DECODE ('"+locncode+"', '*ALL', clinic_code, '"+locncode+"') AND NVL (practitioner_id, 'X') = NVL ('"+practid+"', NVL (practitioner_id, 'X')) AND care_locn_type_ind = '"+locntype+"' AND resource_class = '"+resourcetype+"' AND clinic_date BETWEEN TO_DATE ('"+efffrom+"', 'dd/mm/yyyy') AND TO_DATE ('"+effto+"', 'dd/mm/yyyy') AND to_date(to_char(SLOT_SLAB_START_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+blk_time_from+"','hh24:mi') and to_date('"+blk_time_to+"','hh24:mi') AND to_date(to_char(SLOT_SLAB_END_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+blk_time_from+"','hh24:mi') and to_date('"+blk_time_to+"','hh24:mi') AND NVL (schedule_status, '*') NOT IN  ('B', 'X')) AND (eff_status != 'D' OR eff_status IS NULL)";
					
					
					}else{
					
					/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
					//sql = " from oa_clinic_schedule where facility_id='"+facilityId+"' and clinic_code=decode('"+locncode+"', '*ALL',clinic_code,'"+locncode+"') and nvl(practitioner_id,'X') = nvl('"+practid+"',nvl(practitioner_id,'X')) and care_locn_type_ind='"+locntype+"' and resource_class='"+resourcetype+"' and NVL(rtrim(to_char(clinic_date,'DAY')),'X') "+dyas_qry.toString()+" and clinic_date between to_date('"+efffrom+"','dd/mm/yyyy') and to_date('"+effto+"','dd/mm/yyyy') and NVL(schedule_status,'X') <> nvl( 'B','X')";  
					
					/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
					sql = " from oa_clinic_schedule_vw where facility_id='"+facilityId+"' and clinic_code=decode('"+locncode+"', '*ALL',clinic_code,'"+locncode+"') and nvl(practitioner_id,'X') = nvl('"+practid+"',nvl(practitioner_id,'X')) and care_locn_type_ind='"+locntype+"' and resource_class='"+resourcetype+"' and NVL(rtrim(to_char(clinic_date,'DAY')),'X') "+dyas_qry.toString()+" and clinic_date between to_date('"+efffrom+"','dd/mm/yyyy') and to_date('"+effto+"','dd/mm/yyyy') and NVL(schedule_status,'X') <> nvl( 'B','X') AND (eff_status != 'D' OR eff_status IS NULL)";  
					
					}
					sql=sql+" order by clinic_name,to_date(clinic_date,'dd/mm/yyyy')" ;
			}
			else if(action.equals("L"))
			{
					/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
					//sql = " from oa_clinic_schedule  where facility_id='"+facilityId+"' and clinic_code=decode('"+locncode+"', '*ALL',clinic_code,'"+locncode+"') and nvl(practitioner_id,'X')= nvl('"+practid+"',nvl(practitioner_id,'X')) and care_locn_type_ind='"+locntype+"' and resource_class='"+resourcetype+"' and NVL(schedule_status,'X') = nvl('B','X') and  NVL(rtrim(to_char (clinic_date,'DAY')), 'X')  "+dyas_qry.toString()+" and clinic_date between to_date ('"+efffrom+"', 'dd/mm/yyyy') and to_date('"+effto+"','dd/mm/yyyy')  order by clinic_name, to_date(clinic_date,'dd/mm/yyyy') " ;
				
				/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
				sql = " from oa_clinic_schedule_vw  where facility_id='"+facilityId+"' and clinic_code=decode('"+locncode+"', '*ALL',clinic_code,'"+locncode+"') and nvl(practitioner_id,'X')= nvl('"+practid+"',nvl(practitioner_id,'X')) and care_locn_type_ind='"+locntype+"' and resource_class='"+resourcetype+"' and NVL(schedule_status,'X') = nvl('B','X') and  NVL(rtrim(to_char (clinic_date,'DAY')), 'X')  "+dyas_qry.toString()+" and clinic_date between to_date ('"+efffrom+"', 'dd/mm/yyyy') and to_date('"+effto+"','dd/mm/yyyy') AND (eff_status != 'D' OR eff_status IS NULL) order by clinic_name, to_date(clinic_date,'dd/mm/yyyy') " ;
			}
			else if(action.equals("C"))
			{
					
					/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
					//sql = " from oa_clinic_schedule  where facility_id='"+facilityId+"' and clinic_code=decode('"+locncode+"', '*ALL',clinic_code,'"+locncode+"') and nvl(practitioner_id,'X')= nvl('"+practid+"',nvl(practitioner_id,'X')) and care_locn_type_ind='"+locntype+"' and resource_class='"+resourcetype+"'  and  NVL(rtrim(to_char (clinic_date,'DAY')), 'X')  "+dyas_qry.toString()+" and clinic_date between to_date ('"+efffrom+"', 'dd/mm/yyyy') and to_date('"+effto+"','dd/mm/yyyy')  order by clinic_name, to_date(clinic_date,'dd/mm/yyyy') " ;
					/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
					sql = " from oa_clinic_schedule_vw  where facility_id='"+facilityId+"' and clinic_code=decode('"+locncode+"', '*ALL',clinic_code,'"+locncode+"') and nvl(practitioner_id,'X')= nvl('"+practid+"',nvl(practitioner_id,'X')) and care_locn_type_ind='"+locntype+"' and resource_class='"+resourcetype+"'  and  NVL(rtrim(to_char (clinic_date,'DAY')), 'X')  "+dyas_qry.toString()+" and clinic_date between to_date ('"+efffrom+"', 'dd/mm/yyyy') and to_date('"+effto+"','dd/mm/yyyy') AND (eff_status != 'D' OR eff_status IS NULL) order by clinic_name, to_date(clinic_date,'dd/mm/yyyy') " ;
			}
			if(stmt!=null)stmt.close();
			stmt=con.createStatement();
			if(reason_desc.equals(""))
			{
				rset = stmt.executeQuery("Select CONTACT_REASON from AM_CONTACT_REASON_LANG_VW Where CONTACT_REASON_CODE ='"+reason+"' and language_id = '"+locale+"'");
				if(rset.next())
					reason_desc = rset.getString("CONTACT_REASON");
			}
			if(rset !=null) rset.close();
			
			/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
			
			//String sql2="Select time_table_type,to_char(TIME_PER_PATIENT,'hh24:mi') TIME_PER_PATIENT1,to_char(TIME_PER_SLAB,'hh24:mi') TIME_PER_SLAB1,MAX_FIRST_VISITS,TOTAL_FIRST_VISIT,TOTAL_FIRST_VISITS_BLOCKED,TOTAL_FOLLOW_UP, TOTAL_ROUTINE, TOTAL_SERIES, TOTAL_CONSULT,TOTAL_OTHER_VISITS_BLOCKED,MAX_OTHER_VISITS,clinic_code, nvl(total_slots_booked-(nvl(TOTAL_FIRST_VISITS_BLOCKED,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) total_slots_booked, primary_resource_yn, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, practitioner_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2')) practitioner_full_name, AM_GET_DESC.AM_CARE_LOCN_TYPE((select clinic_type from op_clinic where facility_id=oa_clinic_schedule.facility_id and CLINIC_CODE=oa_clinic_schedule.clinic_code),'"+locale+"','1')CARE_LOCN_TYPE_DESC, resource_class resource_class_desc, to_char(clinic_date,'dd/mm/yyyy') clinic_date, to_char(clinic_date,'Day') clinic_day1, TO_CHAR(clinic_date, 'DAY') clinic_day,(SELECT day_no FROM sm_day_of_week WHERE RTRIM (day_of_week) = RTRIM (TO_CHAR (clinic_date, 'DAY'))) CLINIC_DAY_NO ,  (nvl(total_slots_booked,0)+nvl(total_slots_overbooked,0)) no_of_appts, PRACTITIONER_ID, care_locn_type_ind, resource_class,to_char(START_TIME,'hh24:mi') START_TIME,to_char(END_TIME,'hh24:mi') END_TIME,MAX_PATIENTS_PER_DAY ";
			
			/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
			String sql2="Select time_table_type,to_char(TIME_PER_PATIENT,'hh24:mi') TIME_PER_PATIENT1,to_char(TIME_PER_SLAB,'hh24:mi') TIME_PER_SLAB1,MAX_FIRST_VISITS,TOTAL_FIRST_VISIT,TOTAL_FIRST_VISITS_BLOCKED,TOTAL_FOLLOW_UP, TOTAL_ROUTINE, TOTAL_SERIES, TOTAL_CONSULT,TOTAL_OTHER_VISITS_BLOCKED,MAX_OTHER_VISITS,clinic_code, nvl(total_slots_booked-(nvl(TOTAL_FIRST_VISITS_BLOCKED,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0))+( NVL (total_slots_overbooked,0) + NVL(TOTAL_FORCED_IN_BOOKED,0)),0) total_slots_booked, primary_resource_yn, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, practitioner_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2')) practitioner_full_name, AM_GET_DESC.AM_CARE_LOCN_TYPE((select clinic_type from op_clinic where facility_id=oa_clinic_schedule_vw.facility_id and CLINIC_CODE=oa_clinic_schedule_vw.clinic_code),'"+locale+"','1')CARE_LOCN_TYPE_DESC, resource_class resource_class_desc, to_char(clinic_date,'dd/mm/yyyy') clinic_date, to_char(clinic_date,'Day') clinic_day1, TO_CHAR(clinic_date, 'DAY') clinic_day,(SELECT day_no FROM sm_day_of_week WHERE RTRIM (day_of_week) = RTRIM (TO_CHAR (clinic_date, 'DAY'))) CLINIC_DAY_NO ,  (nvl(total_slots_booked,0)+nvl(total_slots_overbooked,0)) no_of_appts, PRACTITIONER_ID, care_locn_type_ind, resource_class,to_char(START_TIME,'hh24:mi') START_TIME,to_char(END_TIME,'hh24:mi') END_TIME,MAX_PATIENTS_PER_DAY ";
			
			if(action.equals("C")){
			
				
				/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
				//sql2=sql2+",(select count(*) from oa_appt where facility_id=oa_clinic_schedule.facility_id and clinic_code=oa_clinic_schedule.clinic_code and RESOURCE_CLASS=oa_clinic_schedule.RESOURCE_CLASS and nvl(practitioner_id,'X')= nvl(oa_clinic_schedule.practitioner_id,'X') and trunc(APPT_DATE) =  trunc(oa_clinic_schedule.clinic_date) and appt_status='A') closed";
				
				/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
				sql2=sql2+",(select count(*) from oa_appt where facility_id=oa_clinic_schedule_vw.facility_id and clinic_code=oa_clinic_schedule_vw.clinic_code and RESOURCE_CLASS=oa_clinic_schedule_vw.RESOURCE_CLASS and nvl(practitioner_id,'X')= nvl(oa_clinic_schedule_vw.practitioner_id,'X') and trunc(APPT_DATE) =  trunc(oa_clinic_schedule_vw.clinic_date) and appt_status='A') closed";
			}

			if(action.equals("B")&& (blk_time_from!=null&&!blk_time_from.equals(""))&&(blk_time_to!=null&&!blk_time_to.equals("")) ){
			        /*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
				//sql2=sql2+",(select count(*) from oa_appt where facility_id=oa_clinic_schedule.facility_id and clinic_code=oa_clinic_schedule.clinic_code and RESOURCE_CLASS=oa_clinic_schedule.RESOURCE_CLASS and nvl(practitioner_id,'X')= nvl(oa_clinic_schedule.practitioner_id,'X') and trunc(APPT_DATE) =  trunc(oa_clinic_schedule.clinic_date) AND to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+blk_time_from+"','hh24:mi') and to_date('"+blk_time_to+"','hh24:mi') AND to_date(to_char(APPT_SLAB_TO_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+blk_time_from+"','hh24:mi') and to_date('"+blk_time_to+"','hh24:mi')) no_appts_booked";
			    
				/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
       			sql2=sql2+",(select count(*) from oa_appt where facility_id=oa_clinic_schedule_vw.facility_id and clinic_code=oa_clinic_schedule_vw.clinic_code and RESOURCE_CLASS=oa_clinic_schedule_vw.RESOURCE_CLASS and nvl(practitioner_id,'X')= nvl(oa_clinic_schedule_vw.practitioner_id,'X') and trunc(APPT_DATE) =  trunc(oa_clinic_schedule_vw.clinic_date) AND to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+blk_time_from+"','hh24:mi') and to_date('"+blk_time_to+"','hh24:mi') AND to_date(to_char(APPT_SLAB_TO_TIME,'hh24:mi'), 'hh24:mi') between to_date('"+blk_time_from+"','hh24:mi') and to_date('"+blk_time_to+"','hh24:mi')) no_appts_booked";
			}
			
			
			rset = stmt.executeQuery(sql2+sql);	
					strsql2.append(sql2+sql);
			strsql2.setLength(0);

			if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
		  rset.next() ;
			}

			//int m=1;
		while ( i<=end && rset.next()  )
		{
			if(maxRecord==0)
			{

					
				   %>
				   <P>

<table  align='right'>
<tr>
<%if ( !(start <=1) ){%>
<td align ='right' id='prev'><A HREF='javascript:prevRecs("<%=(start-14)%>","<%=(end-14)%>")' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A></td>	
	<%
}
//if ( !( (start+14) > maxRecord ) )
	{%>
	<td align ='right' id='next' style='visibility:hidden'><A HREF='javascript:nextRecs("<%=(start+14)%>","<%=(end+14)%>")' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
<%}
  
%>
</td>
</tr>
</table>
<br><br>
</P>
				   <table border='1' cellpadding='0' cellspacing='0' align='center' width='95%'>
				   <th><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
				   <th><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
				   <th><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></th>
				   <th><fmt:message key="Common.resourcename.label" bundle="${common_labels}"/></th>
				   <th><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
				   <th><fmt:message key="Common.day.label" bundle="${common_labels}"/></th>
				   <th><fmt:message key="eOA.NoOfAppts.label" bundle="${oa_labels}"/></th>
				   <%if(bulk_blocking_yn.equals("Y")){%>
				   <th><fmt:message key="eOA.timeperslotslab.label" bundle="${oa_labels}"/></th>
				   <th><fmt:message key="eOA.Slotstobeblocked.label" bundle="${oa_labels}"/></th>
				   <th><fmt:message key="eOA.nooffirstvisits.label" bundle="${oa_labels}"/></th>
				   <th><fmt:message key="eOA.noofothervisits.label" bundle="${oa_labels}"/></th>
				   <%}%>
					<th><fmt:message key="Common.selectall.label" bundle="${common_labels}"/><input type='checkbox' name='selectall' id='selectall' onClick='selectAll(this);'  ></th>
				   <%
			}
				  
						cliniccode=rset.getString("clinic_code");
						practname=rset.getString("practitioner_full_name");
						pract = rset.getString("PRACTITIONER_ID");
						if(pract==null)pract="";
				
						clinicdate=rset.getString("clinic_date");
						clinicdate_disp=DateUtils.convertDate(clinicdate,"DMY","en",locale);

						clinic_day1 = rset.getString("CARE_LOCN_TYPE_DESC");
						

						care_locn_type_ind= rset.getString("care_locn_type_ind");
						resource_class= rset.getString("resource_class");
						start_time = rset.getString("start_time");
						end_time = rset.getString("end_time");
						max_patients_per_day= rset.getString("MAX_PATIENTS_PER_DAY");
						if(resource_class.equals("P"))
						{
						res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
						}else if(resource_class.equals("R"))
						{
						res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
						}else if(resource_class.equals("E"))
						{
						res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
						}else if(resource_class.equals("O"))
						{
						res_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
						}
						blockApptFlag="N";
						if(action.equals("B") && (blk_time_from.equals("") && blk_time_to.equals(""))){
							pstmt=con.prepareStatement(blockApptSQL);
							pstmt.setString(1,facilityId);
							pstmt.setString(2,cliniccode);
							pstmt.setString(3,clinicdate);
							pstmt.setString(4,pract);
							prs=pstmt.executeQuery();
							if(prs!=null && prs.next()){
								blockApptCount=Integer.parseInt(prs.getString(1)==null?"0":prs.getString(1));
							}
							if(blockApptCount > 0){
								blockApptFlag="Y";
							}
							if(prs!=null)prs.close();
							if(pstmt!=null)pstmt.close();
						}

						String clinic_day=rset.getString("clinic_day");
						clinic_day=clinic_day.trim();						
						if(clinic_day.equalsIgnoreCase("MONDAY"))
								{
									clinic_day=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(clinic_day.equalsIgnoreCase("TUESDAY"))
								{
									clinic_day=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(clinic_day.equalsIgnoreCase("WEDNESDAY"))
								{
									clinic_day=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(clinic_day.equalsIgnoreCase("THURSDAY"))
								{
									clinic_day=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(clinic_day.equalsIgnoreCase("FRIDAY"))
								{
									clinic_day=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(clinic_day.equalsIgnoreCase("SATURDAY"))
								{
									clinic_day=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(clinic_day.equalsIgnoreCase("SUNDAY"))
								{
									clinic_day=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

						noofappts = rset.getString("total_slots_booked");
						time_table_type = rset.getString("TIME_TABLE_TYPE");
						time_per_patient = rset.getString("TIME_PER_PATIENT1");
						time_per_slab = rset.getString("TIME_PER_SLAB1");
						String timeperslotslab="";
						int time_per_patient_setup=0;
						if(bulk_blocking_yn.equals("Y")){
							timeperslotslab=time_per_patient;
							int time_per_patient_hrs=0;
							int time_per_patient_mns=0;
							String time_per_patient_time="";
								StringTokenizer time_per_patient_token2=new StringTokenizer(time_per_patient_time,":");
								if(time_per_patient_token2.hasMoreElements()){
									time_per_patient_hrs=Integer.parseInt(time_per_patient_token2.nextToken());
									time_per_patient_mns=Integer.parseInt(time_per_patient_token2.nextToken());
								if(time_per_patient_hrs >0){
									time_per_patient_setup=time_per_patient_hrs*60;
								}
								time_per_patient_setup=time_per_patient_setup+time_per_patient_mns;
							}
							//no_slots_to_be_blocked=total_time__blocking/time_per_patient_setup;
							total_first_visits_available=Integer.parseInt(rset.getString("MAX_FIRST_VISITS")==null?"0":rset.getString("MAX_FIRST_VISITS"))-(Integer.parseInt(rset.getString("TOTAL_FIRST_VISITS_BLOCKED")==null?"0":rset.getString("TOTAL_FIRST_VISITS_BLOCKED"))+Integer.parseInt(rset.getString("TOTAL_FIRST_VISIT")==null?"0":rset.getString("TOTAL_FIRST_VISIT")));
							if(time_table_type.equals("2")){
								timeperslotslab=time_per_slab;
							}

							int total_follow_up=0;
							int total_routine=0;
							int total_series=0;
							int total_consult=0;
							total_other_visits_blocked=0;
							total_first_visits_blocked=0;
							int max_other_visits=0;
							total_first_visits_blocked=Integer.parseInt(rset.getString("TOTAL_FIRST_VISITS_BLOCKED")==null?"0":rset.getString("TOTAL_FIRST_VISITS_BLOCKED"));
							total_follow_up=Integer.parseInt(rset.getString("TOTAL_FOLLOW_UP")==null?"0":rset.getString("TOTAL_FOLLOW_UP"));
							total_routine=Integer.parseInt(rset.getString("TOTAL_ROUTINE")==null?"0":rset.getString("TOTAL_ROUTINE"));
							total_series=Integer.parseInt(rset.getString("TOTAL_SERIES")==null?"0":rset.getString("TOTAL_SERIES"));
							total_consult=Integer.parseInt(rset.getString("TOTAL_CONSULT")==null?"0":rset.getString("TOTAL_CONSULT"));
							total_other_visits_blocked=Integer.parseInt(rset.getString("TOTAL_OTHER_VISITS_BLOCKED")==null?"0":rset.getString("TOTAL_OTHER_VISITS_BLOCKED"));
							max_other_visits=Integer.parseInt(rset.getString("MAX_OTHER_VISITS")==null?"0":rset.getString("MAX_OTHER_VISITS"));
							if(max_other_visits > (total_follow_up+total_routine+total_series+total_consult+total_other_visits_blocked)){
								total_other_visits_available=max_other_visits-(total_follow_up+total_routine+total_series+total_consult+total_other_visits_blocked);
							}
							no_appts_booked=rset.getString("NO_APPTS_BOOKED")==null?"0":rset.getString("NO_APPTS_BOOKED");
						}
						if(bulk_blocking_yn.equals("Y")){
							String blockCount="SELECT count(*) no_of_slots_avbl FROM oa_clinic_schedule_slot_slab WHERE facility_id = '"+facilityId+"' AND clinic_code = DECODE ('"+locncode+"', '*ALL', clinic_code, '"+locncode+"') AND NVL (practitioner_id, 'X') = NVL ('"+pract+"', NVL (practitioner_id, 'X')) AND care_locn_type_ind = '"+locntype+"' AND resource_class = '"+resourcetype+"' AND clinic_date = TO_DATE ('"+clinicdate+"', 'dd/mm/yyyy') AND TO_DATE (TO_CHAR (slot_slab_start_time, 'hh24:mi'),'hh24:mi') BETWEEN TO_DATE ('"+blk_time_from+"', 'hh24:mi') AND TO_DATE ('"+blk_time_to+"', 'hh24:mi') AND TO_DATE (TO_CHAR (slot_slab_end_time, 'hh24:mi'), 'hh24:mi') BETWEEN TO_DATE ('"+blk_time_from+"', 'hh24:mi') AND TO_DATE ('"+blk_time_to+"', 'hh24:mi') and  NVL(schedule_status, '*') not in ('B','X')";
							rset1=stmt1.executeQuery(blockCount);
							if(rset1!=null && rset1.next()){
								no_slots_to_be_blocked=Integer.parseInt(rset1.getString("no_of_slots_avbl")==null?"0":rset1.getString("no_of_slots_avbl"));
							}
							if(rset1!=null)rset1.close();
						}
							primary_yn = rset.getString("primary_resource_yn");
							if(action.equals("C"))
							closed=rset.getInt("closed");
						if (pract==null) pract="";
						if(bulk_blocking_yn.equals("Y"))
							noofappts=no_appts_booked;
						
						String pract1="";					
						pract1 = pract;
						if(pract1.equals("")) {
							pract1="X";
						}

						if(practname == null || practname.equals(""))
							practname = "&nbsp";
						if ( k % 2==0 )
								classValue = "QRYODD" ;
						else
								classValue = "QRYEVEN" ;
						if(noofappts==null || noofappts.equals("null"))
							noofappts="";
				if(!(noofappts.equals("0"))){	
					 %>				
					<tr><td class='<%=classValue%>'><%=clinic_day1%></td><td class='<%=classValue%>'><%=rset.getString("clinic_name")%></td>
					<td class='<%=classValue%>'><%=res_class%></td><td class='<%=classValue%>'><%=practname%></td> <td class='<%=classValue%>'><%=clinicdate_disp%></td> <td class='<%=classValue%>'><%=clinic_day%></td> <td class='<%=classValue%>' align=middle id='noofappts<%=k%>' value='<%=noofappts%>'>
					<%if(primary_yn.equals("Y")){
						 %>
							 
					<a href="javascript:show_modwin('<%=cliniccode%>','<%=pract%>','<%=clinicdate%>','<%=clinic_day1.trim()%>','<%=care_locn_type_ind%>','<%=resource_class%>')" alt='Appointment Details' >
					<%}%>
					<%=noofappts%>&nbsp;</td>
			 <% }else{ 
						 %>
					<tr><td class='<%=classValue%>'><%=clinic_day1%></td><td class='<%=classValue%>'><%=rset.getString("clinic_name")%></td> <td class='<%=classValue%>'><%=res_class%></td><td class='<%=classValue%>'><%=practname%></td> <td class='<%=classValue%>'><%=clinicdate_disp%></td> <td class='<%=classValue%>'><%=clinic_day%></td> 
					<td class='<%=classValue%>' align=middle id='noofappts<%=k%>' value='<%=noofappts%>'><%=noofappts%>&nbsp;</td>
						<%
						}
						 String disableFlag="";
						 if(visit_limit_rule.equals("N")){
							 disableFlag="disabled";
						 }
						 if(!noofappts.equals("0"))
							 disableFlag="disabled";
						%>
						<%if(bulk_blocking_yn.equals("Y")){%>
						<td align='center' class='<%=classValue%>'><%=timeperslotslab%></td>
						<td align='center' class='<%=classValue%>'><%=no_slots_to_be_blocked%></td>
						<input type='hidden' name='no_slots_to_be_blocked<%=k%>' id='no_slots_to_be_blocked<%=k%>'  value='<%=no_slots_to_be_blocked%>'>
						<input type='hidden' name='time_table_type<%=k%>' id='time_table_type<%=k%>'  value='<%=time_table_type%>'>
						<input type='hidden' name='total_first_visits_blocked<%=k%>' id='total_first_visits_blocked<%=k%>'  value='<%=total_first_visits_blocked%>'>
						<input type='hidden' name='total_other_visits_blocked<%=k%>' id='total_other_visits_blocked<%=k%>'  value='<%=total_other_visits_blocked%>'>
						<input type='hidden' name='total_first_visits_available<%=k%>' id='total_first_visits_available<%=k%>'  value='<%=total_first_visits_available%>'>
						<input type='hidden' name='total_other_visits_available<%=k%>' id='total_other_visits_available<%=k%>'  value='<%=total_other_visits_available%>'>
						<input type='hidden' name='block_time_from<%=k%>' id='block_time_from<%=k%>'  value='<%=block_time_from%>'>
						<input type='hidden' name='block_time_to<%=k%>' id='block_time_to<%=k%>'  value='<%=block_time_to%>'>
						<td class='fields'><input type='text' name='nooffirstvisits<%=k%>' id='nooffirstvisits<%=k%>' value='0' size='2' MAXLENGTH=3 onKeyPress='return  allowValidNumber(this,event,3,0);' onblur='checkVisits("<%=k%>","1")' <%=disableFlag%>></td>
						<%if(visit_limit_rule.equals("N")){%>
							<td class='fields'><input type='text' name='noofothervisits<%=k%>' id='noofothervisits<%=k%>' value='<%=no_slots_to_be_blocked%>' size='2' MAXLENGTH=3 <%=disableFlag%>></td>
						<%}else{%>
							<td class='fields'><input type='text' name='noofothervisits<%=k%>' id='noofothervisits<%=k%>' value='0' size='2' MAXLENGTH=3 onKeyPress='return  allowValidNumber(this,event,3,0);' onblur='checkVisits("<%=k%>","2")' <%=disableFlag%>></td>
						<%}
						}%>
					<td align='center' class='<%=classValue%>'>
					
						<%if((primary_yn.equals("N") && ! noofappts.equals("0")|| (!action.equals("B")))){%>

						<input type='checkbox'  name='checkBox'  id='checkBox' value='' <%if(action.equals("C") && closed >0){%>disabled<%}%> onClick='check_cancel(<%=k%>,<%=noofappts%>);' title="Primary Bookings Exist">
							<input type='hidden' name='no_of_appt' id='no_of_appt'  value='<%=noofappts%>' >
						<%}else if((primary_yn.equals("Y") && ! noofappts.equals("0")) && blk_schdl_with_appt_yn.equals("N")){%>	
					
						<input type='checkbox'  name='checkBox' id='checkBox' value='' onClick='check_cancel(<%=k%>,<%=noofappts%>);' disabled title="Primary Bookings Exist">
						<input type='hidden' name='no_of_appt' id='no_of_appt'  value='<%=noofappts%>' >
						<%}else if((primary_yn.equals("Y") && ! noofappts.equals("0")) && blk_schdl_with_appt_yn.equals("Y")){%>	
					
						<input type='checkbox'  name='checkBox' id='checkBox' value='' onClick='check_cancel(<%=k%>,<%=noofappts%>);' title="Primary Bookings Exist">
						<input type='hidden' name='no_of_appt' id='no_of_appt'  value='<%=noofappts%>' >
						<%}else {%>

							<input type='checkbox'  name='checkBox' id='checkBox' onClick='check_cancel(<%=k%>,<%=noofappts%>);' value=''  >
							<input type='hidden' name='no_of_appt' id='no_of_appt'  value='<%=noofappts%>' >

						<%}%>

							
					</td></tr>
					<%if(action.equals("B") && (blk_time_from.equals("") && blk_time_to.equals(""))){%>
						<input type='hidden' name='vals' id='vals' value='<%=cliniccode%>|<%=pract1%>|<%=clinicdate%>|<%=rset.getString("CLINIC_DAY_NO")%>|<%=noofappts%>|<%=blockApptFlag%>' >
					<%}else{%>
						<input type='hidden' name='vals' id='vals' value='<%=cliniccode%>|<%=pract1%>|<%=clinicdate%>|<%=rset.getString("CLINIC_DAY_NO")%>|<%=noofappts%>' >
					<%}%>				
					<input type='hidden' name='vals1' id='vals1' value='<%=cliniccode%>|<%=pract1%>|<%=clinicdate%>|<%=rset.getString("CLINIC_DAY_NO")%>|<%=primary_yn%>' >
					<%	k++;
						i++;
						maxRecord++;
					} 
if(maxRecord == 0)
	{%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>
	<%}else{%>
	<script>parent.frames[1].document.forms[0].reportbut.disabled = false;</script>
	<%}

	if ( maxRecord < 14 || (!rset.next()) ) {
	%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='hidden';
		</script>
	<% 
			} else {%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}				


		}
		catch(Exception e){
			//out.print("sum" +e);
			e.printStackTrace();
		}finally{
			try{
				if(rset != null)rset.close();
				if(rset1 != null)rset1.close();
				if(stmt != null) stmt.close();
				if(stmt1 != null) stmt1.close();
				if(rs1 != null) rs1.close();
				if(pstmt != null) pstmt.close();
				if(prs != null) prs.close();
			}catch (Exception ex){
				ex.printStackTrace();
			}
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
%>
		<input type='hidden' name='no_of_rec' id='no_of_rec'  value= '<%=k%>' >
		<input type='hidden' name='final_vals' id='final_vals'  value= '' >
		<input type='hidden' name='final_vals1' id='final_vals1'  value= '' >
		<input type='hidden' name='action' id='action'  value= '<%=action%>' >
		<input type='hidden' name='sel_rec' id='sel_rec'  value= '' >
		<input type='hidden' name='eff_from' id='eff_from'  value= '<%=efffrom%>' >
		<input type='hidden' name='eff_to' id='eff_to'  value= '<%=effto%>' >
		<input type='hidden' name='reason' id='reason'  value= '<%=reason%>' >
		<input type='hidden' name="reason_desc" id="reason_desc"  value= "<%=reason_desc%>" >
		<input type='hidden' name='genrep' id='genrep'  value= '' ></input>		
		<input type="hidden" name="p_module_id" id="p_module_id"   value="OA"></input>
		<input type="hidden" name="p_report_id" id="p_report_id"   value="OAAFAPLST"></input>
		<input type="hidden" name="P_Facility_id" id="P_Facility_id" value='<%=facilityId%>'></input>
		<input type="hidden" name="locncode" id="locncode" value='<%=locncode%>'></input>
		<input type="hidden" name="practitioner" id="practitioner" value='<%=practid%>'></input>
		<input type="hidden" name="P_Action" id="P_Action" value=''></input>
		<input type="hidden" name="P_Report_Title" id="P_Report_Title" value='<%=P_Report_Title%>'></input>
		<input type="hidden" name="NoOfAppt" id="NoOfAppt" value='<%=noofappts%>'></input>
		<input type="hidden" name="location_type" id="location_type" value='<%=locntype%>'></input>
		<input type="hidden" name="resourcetype" id="resourcetype" value='<%=resourcetype%>'></input>
		<input type='hidden' name='default_select' id='default_select' value='<%=default_select%>'>
		<input type='hidden' name='start_time' id='start_time' value='<%=start_time%>'>
		<input type='hidden' name='end_time' id='end_time' value='<%=end_time%>'>
		<input type='hidden' name='max_patients_per_day' id='max_patients_per_day' value='<%=max_patients_per_day%>'>
		<input type='hidden' name='blk_time_from' id='blk_time_from' value='<%=blk_time_from%>'>
		<input type='hidden' name='blk_time_to' id='blk_time_to' value='<%=blk_time_to%>'>
		<input type='hidden' name='bulk_blocking_yn' id='bulk_blocking_yn' value='<%=bulk_blocking_yn%>'>
		<input type='hidden' name='visit_limit_rule' id='visit_limit_rule' value='<%=visit_limit_rule%>'>
		<input type='hidden' name='blk_schdl_with_appt_yn' id='blk_schdl_with_appt_yn' value='<%=blk_schdl_with_appt_yn%>'>

		<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
		<input type='hidden' name='other_remarks' id='other_remarks' value='<%=other_remarks%>'>
		
<input type='hidden' name='currentPage' id='currentPage' value='<%=currPage%>'>
</form>
</body>

</html>

