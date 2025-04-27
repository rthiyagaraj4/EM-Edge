<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eOA/js/Blockapptslots.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>
    
<%


request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");	
String locale=(String)session.getAttribute("LOCALE");

String date=(String)request.getParameter("Date"); 

String from_page=(String)request.getParameter("from_page");
if(from_page ==null) from_page="";
if(from_page.equals(""))
{
date=DateUtils.convertDate(date,"DMY",locale,"en");
}

String clinic_code=(String)request.getParameter("clinic_code");
String practitioner_id=(String)request.getParameter("practitioner_id");
if(practitioner_id == null) practitioner_id="";
String value12=(String)request.getParameter("value12");
if( value12 == null || value12.equals("null")) value12="";
String value13=(String)request.getParameter("value13");
if( value13 == null || value13.equals("null"))  value12="";
String facilityid=(String)session.getValue("facility_id");
String anchor=(String)request.getParameter("anchor");
if( anchor == null || anchor.equals("null"))  anchor="";
String to_anchor=(String)request.getParameter("to_anchor");
if( to_anchor == null || to_anchor.equals("null"))  to_anchor="";

String rowNum=(String)request.getParameter("rowNum");
if( rowNum == null || rowNum.equals("null")) rowNum="0";

String clinic_type=request.getParameter("clinic_type");
String res_type=request.getParameter("res_type");


int v=0;
if( rowNum != null || ! rowNum.equals(""))
{
v=Integer.parseInt(rowNum);
}
%>


<%

String P_FACILITY_ID   =facilityid;
String P_CLINIC_DATE      =date;
String P_CLINIC_CODE      =clinic_code;
String P_PRACTITIONER_ID      =practitioner_id;
String p_o_srl_no			  ="";
String P_O_CLINIC             ="";
String P_O_PRACTITIONER       ="";
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
String P_O_AGE                ="";
String P_O_GENDER             ="";
String P_O_REASON_FOR_CON    ="";
String P_O_VISIT_TYPE         ="";
String P_O_CONTACT            ="";
String P_O_NO_OF_SLOTS= "";
String P_O_PATIENT_ID       ="";



String sys_date=request.getParameter("sys_date");
String sys_time=request.getParameter("sys_time");

String alcncriteria = "";
Connection con=null;
Statement stmt2=null;
ResultSet rs2=null;
Statement stmtsd=null;
PreparedStatement pstmt=null;
ResultSet rs= null;
CallableStatement statement=null;
CallableStatement cstmt = null;
CallableStatement statement_bru = null;
String time_per_patient="";
String time_per_slab="";
String visit_limit_rule=request.getParameter("visit_limit_rule");
String slot_appt_ctrl=request.getParameter("slot_appt_ctrl");
String primary_resource_yn="";

String total_first_visits_blocked="";
String total_other_visits_blocked="";
String time_table_type="";
String max_patients_per_slab="";

//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
String schedule_extend_yn="N"; 

 //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
 Boolean isSlotStartMidEndAppl = false;
 String p_o_ext_slot_status = "";
 String p_o_reserved_slot_dtls = "";
 String p_o_appt_slot_dtls = "";
 String p_o_block_slot_dtls = "";
 String p_o_break_slot_dtls = "";

try{
	con=ConnectionManager.getConnection(request);
stmt2 = con.createStatement();

isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1

String max_other_visits=""; 
String max_first_visits=""; 
String max_patients_per_day=""; 
String total_booked1=""; 
boolean block_allow_flag= true;

//String sql2="select time_per_patient,nvl(max_first_visits,0) max_first_visits,nvl(max_other_visits,0) max_other_visits, alcn_criteria,nvl(max_patients_per_day,0) max_patients_per_day, nvl(max_over_booking,0) max_over_booking, nvl(total_slots_booked,0) total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked, nvl(total_first_visits_blocked,0) total_first_visits_blocked,nvl(total_other_visits_blocked,0) total_other_visits_blocked, nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked,primary_resource_yn ,time_table_type,TIME_PER_SLAB,MAX_PATIENTS_PER_SLAB, schedule_extend_yn from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+date+"','dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"' ,'X') and nvl(schedule_status,'X') !=nvl('B','X')  and time_table_type !='3' and care_locn_type_ind='"+clinic_type+"' and  resource_class='"+res_type+"' ";
String sql2="select time_per_patient,nvl(max_first_visits,0) max_first_visits,nvl(max_other_visits,0) max_other_visits, alcn_criteria,nvl(max_patients_per_day,0) max_patients_per_day, nvl(max_over_booking,0) max_over_booking, nvl(total_slots_booked,0) total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked, nvl(total_first_visits_blocked,0) total_first_visits_blocked,nvl(total_other_visits_blocked,0) total_other_visits_blocked, nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked,primary_resource_yn ,time_table_type,TIME_PER_SLAB,MAX_PATIENTS_PER_SLAB, schedule_extend_yn from oa_clinic_schedule where facility_id=? and clinic_code=? and clinic_date=to_date(?,'dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl(? ,'X') and nvl(schedule_status,'X') !=nvl('B','X')  and time_table_type !='3' and care_locn_type_ind=? and  resource_class=? ";

//rs2 = stmt2.executeQuery(sql2);
pstmt = con.prepareStatement(sql2);
pstmt.setString(1,facilityid);
pstmt.setString(2,clinic_code);
pstmt.setString(3,date);
pstmt.setString(4,practitioner_id);
pstmt.setString(5,clinic_type);
pstmt.setString(6,res_type);
rs2 = pstmt.executeQuery();
if(rs2.next())
{
	time_table_type= rs2.getString("time_table_type");
	if(time_table_type.equals("1"))
	{
	String time_per_patient2=rs2.getString("time_per_patient");
	time_per_patient=time_per_patient2.substring(10,16);
	}else
	{
		time_per_slab=rs2.getString("TIME_PER_SLAB");
	time_per_patient=time_per_slab.substring(10,16);
	max_patients_per_slab=rs2.getString("MAX_PATIENTS_PER_SLAB");
	}
	max_first_visits=rs2.getString("max_first_visits");
	max_other_visits=rs2.getString("max_other_visits");
	primary_resource_yn=rs2.getString("primary_resource_yn");
	alcncriteria = rs2.getString("alcn_criteria")==null?"":rs2.getString("alcn_criteria"); 

	schedule_extend_yn=rs2.getString("schedule_extend_yn");
	if(schedule_extend_yn==null) schedule_extend_yn="N";
	
	max_patients_per_day= rs2.getString("max_patients_per_day");
	P_O_MAX_OVER_BOOK   =rs2.getString("max_over_booking" );        
	if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";
	P_O_BOOKED          =rs2.getString("total_slots_booked" );   
	if( P_O_BOOKED ==null) P_O_BOOKED="";
	P_O_OVER_BOOKED        =rs2.getString( "total_slots_overbooked" );    
					if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";
	total_booked1		= rs2.getString("total_booked");
	total_first_visits_blocked= rs2.getString("total_first_visits_blocked");
	total_other_visits_blocked= rs2.getString("total_other_visits_blocked");
	
if (slot_appt_ctrl.equals("P") && max_patients_per_day.equals(total_booked1))
			block_allow_flag=false;


/* Added for ML-BRU-CRF-0628.1 */
if(isSlotStartMidEndAppl){
	cstmt = con.prepareCall("{call oa_external_slots_BRU(?,?,?,?,?,?,?,?,?)}");
	cstmt.setString( 1, P_FACILITY_ID );
	cstmt.setString( 2, P_CLINIC_CODE );
	cstmt.setString( 3, P_PRACTITIONER_ID );
	cstmt.setString( 4, P_CLINIC_DATE );
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

if(isSlotStartMidEndAppl && time_table_type.equals("2") && !max_patients_per_slab.equals("1")){

	System.err.println("Before execute oa_slabs_BRU---in Param---P_FACILITY_ID-->"+P_FACILITY_ID+"  P_CLINIC_CODE-->"+P_CLINIC_CODE+"  P_PRACTITIONER_ID-->"+P_PRACTITIONER_ID+"  P_CLINIC_DATE-->"+P_CLINIC_DATE);

	statement_bru = con.prepareCall("{call oa_slabs_BRU(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

	statement_bru.setString( 1, P_FACILITY_ID);
	statement_bru.setString( 2, P_CLINIC_CODE);
	statement_bru.setString( 3, P_PRACTITIONER_ID);
	statement_bru.setString( 4, P_CLINIC_DATE);
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

	
	P_O_CLINIC = P_CLINIC_CODE;

	P_O_PRACTITIONER = P_PRACTITIONER_ID;

	P_O_MAX_PAT = max_patients_per_day;

	P_O_TIME_TAB_TYPE = time_table_type;

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

	P_O_PATIENT_ID = statement_bru.getString(15); 
	if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";

	p_o_srl_no = statement_bru.getString(16); 
	if( p_o_srl_no == null) p_o_srl_no="";

	P_O_FROM_TIME = statement_bru.getString(24);     
	if(P_O_FROM_TIME == null) P_O_FROM_TIME="";

	P_O_TO_TIME = statement_bru.getString(25);	
	if(P_O_TO_TIME == null) P_O_TO_TIME="";

	P_O_NO_OF_SLOTS = statement_bru.getString(26); 
	if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";

}else{
/* End ML-BRU-CRF-0628.1 */

String proc_name="";

//if(primary_resource_yn.equals("Y")){
	//proc_name="{call GET_DAY_SCHEDULE_STATUS_NEW( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

	System.err.println("Before execute get_day_status---in Param---P_FACILITY_ID-->"+P_FACILITY_ID+"  P_CLINIC_CODE-->"+P_CLINIC_CODE+"  P_PRACTITIONER_ID-->"+P_PRACTITIONER_ID+"  P_CLINIC_DATE-->"+P_CLINIC_DATE);

	proc_name="{call oa_schedules.get_day_status( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	statement=con.prepareCall(proc_name);

	statement.setString( 1, P_FACILITY_ID);
	statement.setString( 2, P_CLINIC_DATE);
	statement.setString( 3, P_CLINIC_CODE);
	statement.setString( 4, P_PRACTITIONER_ID);
	statement.setString( 5, clinic_type);
	statement.setString( 6, res_type);

	statement.registerOutParameter(7, Types.VARCHAR );
	statement.registerOutParameter(8, Types.VARCHAR );
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
	//if(primary_resource_yn.equals("Y")){
	statement.setString( 34, locale);
	statement.registerOutParameter(35 ,Types.VARCHAR );
	statement.registerOutParameter(36 ,Types.VARCHAR );
	statement.registerOutParameter(37 ,Types.VARCHAR );
	statement.registerOutParameter(38 ,Types.VARCHAR );
	statement.registerOutParameter(39 ,Types.VARCHAR );
	statement.registerOutParameter(40 ,Types.VARCHAR );
	statement.registerOutParameter(41 ,Types.VARCHAR );
//	}


	statement.execute() ;

	System.err.println("After execute get_day_status---in Param---P_FACILITY_ID-->"+P_FACILITY_ID+"  P_CLINIC_CODE-->"+P_CLINIC_CODE+"  P_PRACTITIONER_ID-->"+P_PRACTITIONER_ID+"  P_CLINIC_DATE-->"+P_CLINIC_DATE);

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
	P_O_NO_OF_SLOTS = statement.getString(27); if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";
	P_O_PATIENT_ID=statement.getString(32); if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";
	p_o_srl_no=statement.getString(33); if( p_o_srl_no == null) p_o_srl_no="";

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
	System.err.println("P_O_NO_OF_SLOTS-------->"+P_O_NO_OF_SLOTS);
	System.err.println("P_O_PATIENT_ID-------->"+P_O_PATIENT_ID);
	System.err.println("p_o_srl_no-------->"+p_o_srl_no);

	StringTokenizer token = new StringTokenizer(P_O_FROM_TIME, "|");
	int counter=token.countTokens();
	String from_time[]=new String[counter];
	int track=0;
	while (token.hasMoreTokens()){
		from_time[track]=token.nextToken();
		track++;
	}
	//StringTokenizer token1 = new StringTokenizer(P_O_TO_TIME, "|");
	token = new StringTokenizer(P_O_TO_TIME, "|");
	String to_time[]=new String[counter];
	int track1=0;
	String end_time ="";
	int tot_token= token.countTokens();

	while (token.hasMoreTokens())
	{
		end_time=token.nextToken();

		if(schedule_extend_yn.equals("Y") && P_O_TIME_TAB_TYPE.equals("1")) { // to handle last slot for extended

			if (tot_token-track1 == 1) {					
				end_time="00:00";
			}
		}
		
		to_time[track1]=end_time;

		track1++;
	}
	
	//StringTokenizer token2 = new StringTokenizer(P_O_PATIENT_NAME, "|");
	token = new StringTokenizer(P_O_PATIENT_NAME, "|");
	//String new_pat[]=new String[counter];
	String patient_name[]=new String[counter];
	int track2=0;
	String s = null;
	while (token.hasMoreTokens()){
		s = token.nextToken();
		patient_name[track2]=s;
		track2++;
	}
	//StringTokenizer token21 = new StringTokenizer(P_O_PATIENT_ID, "|");
	token = new StringTokenizer(P_O_PATIENT_ID, "|");
	String patient_id[]=new String[counter];
	int track21=0;
	while (token.hasMoreTokens()){
		patient_id[track21]=token.nextToken();
		track21++;
	}
	//StringTokenizer token3 = new StringTokenizer(P_O_AGE, "|");
	token = new StringTokenizer(P_O_AGE, "|");
	String age[]=new String[counter];
	int track3=0;
	while (token.hasMoreTokens()){
		age[track3]=token.nextToken();
		track3++;
	}
	//StringTokenizer token4 = new StringTokenizer(P_O_GENDER, "|");
	token = new StringTokenizer(P_O_GENDER, "|");
	String gender[]=new String[counter];
	int track4=0;
	while (token.hasMoreTokens()){
		gender[track4]=token.nextToken();
		track4++;
	}
	//StringTokenizer token5 = new StringTokenizer(P_O_REASON_FOR_CON, "|") ;
	token = new StringTokenizer(P_O_REASON_FOR_CON, "|") ;
	String reason_for_contact[]=new String[counter];
	int track5=0;
	while (token.hasMoreTokens()){
		reason_for_contact[track5]=token.nextToken();
		track5++;
	}
	//StringTokenizer token6 = new StringTokenizer(P_O_VISIT_TYPE, "|");
	token = new StringTokenizer(P_O_VISIT_TYPE, "|");
	String visit_type[]=new String[counter];
	int track6=0;
	while (token.hasMoreTokens()){
		visit_type[track6]=token.nextToken();
		track6++;
	}
	//StringTokenizer token7 = new StringTokenizer(P_O_CONTACT, "|");
	token = new StringTokenizer(P_O_CONTACT, "|");
	String contact[]=new String[counter];
	int track7=0;
	while (token.hasMoreTokens()){
		contact[track7]=token.nextToken();
		track7++;
	}
	//StringTokenizer token8 = new StringTokenizer(P_O_APPT_REF_NO, "|");
	token = new StringTokenizer(P_O_APPT_REF_NO, "|");
	String o_appt_ref_no[]=new String[counter];
	int track8=0;
	while (token.hasMoreTokens()){
		o_appt_ref_no[track8]=token.nextToken();
		track8++;
	}
	//StringTokenizer token9 = new StringTokenizer(P_O_STATUS, "|");
	token = new StringTokenizer(P_O_STATUS, "|");

	String status[]=new String[counter];
	String status1[]=new String[counter];
	int track9=0;
	while (token.hasMoreTokens()){
		status[track9]=token.nextToken();
		status1[track9]=status[track9];
		track9++;
	}
	//StringTokenizer token11 = new StringTokenizer(P_O_NO_OF_SLOTS, "|");
	token = new StringTokenizer(P_O_NO_OF_SLOTS, "|");
	String no_of_slots[]=new String[counter];
	int track11=0;
	while (token.hasMoreTokens()){
		no_of_slots[track11]=token.nextToken();
		track11++;
	}
%>
<html>
<head>
<script>
async function toFill(obj2){
	time_table_type=document.forms[0].time_table_type.value;	
	max_patients_per_slab=parseInt(document.forms[0].max_patients_per_slab.value);		
			
//document.forms[0].to_count.value=obj2;
var name=document.getElementById("results").rows[u1].cells[u2+2].innerText;
var value7=document.getElementById("results").rows[u1].cells[u2].innerText;
var visit_rule = document.forms[0].visit_limit_rule.value;
var slotsblocked; 
if(time_table_type == "2"){	
	identify_first=eval(document.getElementById("identify_first"+obj2)).value;
	obj3=max_patients_per_slab - identify_first ;
	slotsblocked = (eval(u1)-eval('<%=v%>'))+1+obj3;
	document.forms[0].to_count.value=eval(u1)+obj3;
}else{
	slotsblocked = (eval(u1)-eval('<%=v%>'))+1;
	document.forms[0].to_count.value=obj2;
}
var call_visit="N";
if ('<%=visit_limit_rule%>' == 'M'||'<%=visit_limit_rule%>' == 'E'){
	 if(parseInt('<%=max_other_visits%>') >0 ||parseInt('<%=max_first_visits%>')>0){
		call_visit = "Y";
	 }

}

if(name.length == 1){
	parent.parent.frames[0].document.forms[0].b_to.value=value7;
	
if(document.forms[0].time_table_type.value !="3"){

	if('<%=alcncriteria%>'	 != ''|| call_visit=="Y" ){
		var params = "facility_id=<%=facilityid%>&location_code=<%=clinic_code%>&time_table_type=<%=P_O_TIME_TAB_TYPE%>&slot_appt_ctrl=<%=slot_appt_ctrl%>&visit_limit_rule=<%=visit_limit_rule%>&block_date=<%=date%>&practitioner_id=<%=practitioner_id%>&max_other_visits=<%=max_other_visits%>&max_first_visits=<%=max_first_visits%>&srl_no=&slots_blocked="+slotsblocked+"&alcn_criteria=<%=alcncriteria%>&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>"
		//var features	= "dialogHeight:20; dialogWidth:30; scroll=no; status:no";
		var features	= "dialogHeight:90vh; dialogWidth:40vw; scroll=no; status:no";

	
		var retVal = await window.showModalDialog("../../eOA/jsp/BlockApptAllocationDetailsFrames.jsp?"+params,arguments,features);
	
		if(retVal==undefined)
				retVal="";		
		
		if(retVal !=''){
		
		if(retVal != null && retVal != '' && retVal != 'F')
		{
			var  temp = new Array()
			temp = retVal.split("$");
			if(temp[0]!="")
			{
				parent.parent.frames[0].document.forms[0].insert_detail.value = 'Y';
				parent.parent.frames[0].document.forms[0].final_values.value = temp[0];
				
			}
			if (temp[1]!=null)
			{
				var temp1 = new Array();
				temp1 = temp[1].split("#");
				parent.parent.frames[0].document.forms[0].first_visits_value.value = temp1[0];
				parent.parent.frames[0].document.forms[0].other_visits_value.value = temp1[1];
				
				

			}
		}
		else
		{
			parent.parent.frames[0].document.forms[0].insert_detail.value = 'N';
			parent.parent.frames[0].document.forms[0].final_values.value = "";
			parent.parent.frames[0].document.forms[0].first_visits_value.value = "";
			parent.parent.frames[0].document.forms[0].other_visits_value.value = "";
			parent.parent.frames[0].document.forms[0].b_to.value = "";

			parent.parent.frames[0].document.forms[0].b_from.readOnly = true;
			parent.parent.frames[0].document.forms[0].b_to.readOnly = true;

		}
		}else{
			parent.parent.frames[0].document.forms[0].b_from.readOnly = false;
			parent.parent.frames[0].document.forms[0].b_to.readOnly = false;
			parent.parent.frames[0].document.forms[0].insert_detail.value = 'N';
			parent.parent.frames[0].document.forms[0].final_values.value = "";
			parent.parent.frames[0].document.forms[0].first_visits_value.value = "";
			parent.parent.frames[0].document.forms[0].other_visits_value.value = "";

			parent.parent.frames[0].document.forms[0].b_to.value = "";

			parent.parent.frames[0].document.forms[0].b_from.readOnly = true;
			parent.parent.frames[0].document.forms[0].b_to.readOnly = true;


		}
	}
}
}else{
	alert(getMessage('CAN_NOT_SELECT_TIME',"OA"));
}
}
</script>
</head>
<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()' >
<form name='displayresults' id='displayresults'>
<table border="1" width="100%" cellspacing='0' cellpadding='0' id='results'>
	<th class='COLUMNHEADER' width='5%' style='color:white'><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></th>
	<th class='COLUMNHEADER' width='5%' style='color:white'><fmt:message key="Common.totime.label" bundle="${common_labels}"/></th>
	<th class='COLUMNHEADER' width='23%' style='color:white'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
	<th class='COLUMNHEADER' width='5%' style='color:white'><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
	<th class='COLUMNHEADER' width='2%' style='color:white'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
	<th class='COLUMNHEADER' width='30%' style='color:white'<fmt:message key="Common.ReasonForContact.label" bundle="${common_labels}"/></th>
	<th class='COLUMNHEADER' width='11%' style='color:white'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></th>
	<th class='COLUMNHEADER' width='23%' style='color:white'><fmt:message key="Common.contact.label" bundle="${common_labels}"/></th>

<%
String classValue="";
String to_anchor2="";
String same_appt = "N";
String pat_name = "";
int identify_first=1;
//int group_count=1;
//boolean breakFlag=false;
int slots = 0;
boolean m=true;
for(int init=0;init<counter;init++)
{
same_appt = "N";

if( !(no_of_slots[init].equals("~")) && (Integer.parseInt(no_of_slots[init]) > 1) ) 
{
	slots = Integer.parseInt(no_of_slots[init]);
	pat_name = patient_name[init];
}
if( v  == 0) to_anchor2="no";
else
if( init == v-1 ) to_anchor2="yes";
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
if(anchor.equals("reset"))
{
	%>
	<td width=5% class='<%=classValue%>' onClick='col(this)'><%=u%> <input type='hidden' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
		<%
	String chk_blank_row_patient1=patient_name[init];	
		if(chk_blank_row_patient1.equals("~"))
		{ 
		  if(slots > 0)
		  {
			slots--;
			same_appt = "Y";
		   }
		}
		else
		{
		pat_name = patient_name[init];
		slots--;
		}
}

else
{

	if( ! u .equals("~"))
	{
		String chk_blank_row_patient=patient_name[init];		
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT"))
		{
		if(chk_blank_row_patient.equals("~"))
		{ 
		  if(slots > 0)
		  {
			  %>
		<td width=5% class='<%=classValue%>' onClick='col(this)'><%= u%> <input type='hidden' name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
			<%
			slots--;
			same_appt = "Y";
			}
			else
			{
				if (z.equals("FL")&&(!block_allow_flag)) { %>
			<td width=5% class='<%=classValue%>' onClick='col(this)'><%=u%><input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
					<% }
				else { 								
					%>
			<td width=5% class='<%=classValue%>' onClick='col(this)'><a href= javascript:moveNext(<%=init%>)><%=u%></a> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
					<%						
					
					}
			}
		}


		else
		{
		if(z1.equals("OL*F"))
		{	%>		
			<td width=5% class='OAFORCED' title=  'Forced Appointment' onClick='col(this)'> <a href= javascript:moveNext(<%=init%>)><%=u%> </a><input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%> ' ></td>
		<%}

		else
		{ %>
		<td width=5% class='<%=classValue%>' onClick='col(this)'><a href= javascript:moveNext(<%=init%>)><%=u%></a> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' > </td>
		<%	
		pat_name = patient_name[init];
		slots--;
		}

	}
}
		else
		{
		if(z.equals("BN"))
		{ %>
			<td width=5% class='oared' title ='<%=reason%>'><%=u%> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
		<% }

		else { %>
		<td width=5% class='oablock'><%=u%> <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
				<% }

		
		}
	
	
}
	else { %>
		<td width=5% class='<%=classValue%>' >&nbsp; <input type='hidden'  name='o_appt_ref_no<%=init%>' id='o_appt_ref_no<%=init%>' value='<%=o_appt_ref_no[init]%>' ></td>
		<% }
}
 
String u1=to_time[init];

//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
if(u1.equals("00:00")){
	u1 = "23:59";
}

String u22=patient_name[init];
if(to_anchor2.equals("yes"))
{	
	if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT"))
	{
		if( u22.equals("~") && m == true)
		{ %>
			<td width=5% class='<%=classValue%>' onClick='col(this)'><a href=javascript:toFill(<%=init%>)><%=u1%> </a></td>
		<% }
		else
		{ %>
			<td width=5% class='<%=classValue%>' onClick='col(this)'><%=u1%> </td>
		<% }
	}
		else
	{
		if(z.equals("BN"))
		{ %>
	<td width=5% class='OARED'  title ='<%=reason%>'><%=u1%></td>
		<%
		}
		else
		{
			%>
		<td width=5% class='oablock'><%=u1%></td>
			<%
		}
		m=false;
	}

}
else
{
	if( ! u1 .equals("~"))
	{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT"))
		{

		
		if(z1.equals("OL*F"))
		{			
			%>
		<td width=5% class='OAFORCED' title= 'Forced Appointment'><%=u1%></td>

			<%
		}
		else
		{%>

	<td width=5% class="<%=classValue%>" ><%=u1%></td>
		<%}
		
		}
		else
		if(z.equals("BN"))
		{%>
			<td width=5% class='OARED'  title ='<%=reason%>'><%= u1%></td>
		<%}
		else
		{%>
	<td width=5% class='oablock'><%=u1%></td>
		<%}
	}
	else { %>
	<td width=5% class='<%=classValue%>' >&nbsp;</td>
		<% }
}

String u2=patient_name[init];
String pat_id=patient_id[init];
if(pat_id.equals("~"))
	pat_id="";
else
	pat_id=pat_id+" , ";


	if( ! u2 .equals("~"))		{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){
			if( (v-1) < init) v=0;
			%>
				<td width=23% class='<%=classValue%>' ><%=pat_id%> <%=u2%></td>
				<%

		}else
			%>
			<td width=23% class='oared'>&nbsp;</td>
			<%
	}else if(same_appt.equals("Y")){ %>
	<td width=23% class='<%=classValue%>' ><%=pat_name%></td>
	<% }else{
		if(z.equals("BN")){%>
				<td width=23% class="<%=classValue%>" ><fmt:message key="Common.blocked.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.reason.label" bundle="${common_labels}"/>:<b><%=reason%></b></td>
			<%}else{%>				 
				<td width=23% class="<%=classValue%>" >&nbsp;</td>
			<%}
	}

String u3=age[init];
	if( ! u3 .equals("~"))
		{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){ %>
	<td width=5% class='<%=classValue%>' ><%=u3%></td>
			<%
		}
		else
			%>
	<td width=5% class='oared'>&nbsp;</td>
		<%
		}
		else {
			%>
	<td width=5% class='<%=classValue%>' >&nbsp;</td>
			<% }

String u4=gender[init];
	if( ! u4 .equals("~"))
		{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){ %>
		<td width=2% class='<%=classValue%>' ><%=u4%></td>
		<%
		}
		else
			%>
	<td width=2% class='oared'>&nbsp;</td>
	<%
		}
		else {
		%>
		<td width=2% class='<%=classValue%>' >&nbsp;</td>
			<%}


String u5=reason_for_contact[init];
	if( ! u5 .equals("~"))
		{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){ %>
		<td width=30% class='<%=classValue%>' ><%=u5%></td>
		<%
		}
		else
		%>
			<td width=30% class='oared'>&nbsp;</td>
		<%
		}
		else {
			%>
	<td width=30% class='<%=classValue%>' >&nbsp;</td>
		<%}

String u6=visit_type[init];
	if( ! u6 .equals("~"))
		{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){ %>
	<td width=11% class='<%=classValue%>' ><%=u6%></td>
	<%
		}
		else
			%>
	<td width=11% class='oared'>&nbsp;</td>
		<%
		}
		else {
			%>
		<td width=11% class='<%=classValue%>' >&nbsp;</td>
		<% }

String u7=contact[init];
	if( ! u7 .equals("~"))
		{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){ %>
		<td width=23% class='<%=classValue%>' ><%=u7%></td>
		<%}
		else
	%><td width=23% class='oared'>&nbsp;</td><%
		}
		else {
		%><td width=23% class='<%=classValue%>' >&nbsp;</td>	
		
		<%}
		%>
			</tr> 
			<%											
				if(time_table_type.equals("2")){
				if(z.equals("RN")){
					identify_first=1;
					/*if(!breakFlag){
						group_count++;
						breakFlag=true;
					}*/
				}else{
					if(identify_first > Integer.parseInt(max_patients_per_slab)){						
							identify_first=1;
							//group_count++;							
					}
					//breakFlag=false;
				}
			%>
						<input type='hidden' name='identify_first<%=init%>' id='identify_first<%=init%>' value='<%=identify_first%>' >
									
<%   if(!z.equals("RN")){
				identify_first++;
		}else{
			//group_count++;
		}
		}
	}
%>
</table>
<br>
<%


%>
<input type='hidden' name='r_appt_status' id='r_appt_status' value='null' >
<input type='hidden' name='clinic_code' id='clinic_code' value=<%= clinic_code %> >
<input type='hidden' name='clinic_name' id='clinic_name' value=<%=P_O_CLINIC %> >
<input type='hidden' name='pract_id' id='pract_id' value=<%=practitioner_id %> >
<input type='hidden' name='pract_name' id='pract_name' value=<%=P_O_PRACTITIONER %> >
<input type='hidden' name='appt_date' id='appt_date' value=<%=date %> >
<input type='hidden' name='over_booked' id='over_booked' value=<%=P_O_OVER_BOOKING %> >
<input type='hidden' name='P_O_TIME_TAB_TYPE' id='P_O_TIME_TAB_TYPE' value=<%=P_O_TIME_TAB_TYPE%> >
<input type='hidden' name='patient_id' id='patient_id' value='null'>
<input type='hidden' name='sys_date' id='sys_date' value=<%=sys_date%> >
<input type='hidden' name='sys_time' id='sys_time' value=<%= sys_time %> >

	<input type='hidden' name='slot_appt_ctrl' id='slot_appt_ctrl'  value=<%= slot_appt_ctrl %> >

<input type='hidden' name='time_per_patient' id='time_per_patient'  value=<%= time_per_patient %> >
<input type='hidden' name='max_patients_per_slab' id='max_patients_per_slab'  value=<%=max_patients_per_slab %> >

<input type='hidden' name='reason_for_revise' id='reason_for_revise'  value=<%= value12%> >
<input type='hidden' name='ref_no' id='ref_no' value= <%= value13%> >
<input type='hidden' name='visit_limit_rule' id='visit_limit_rule' value='<%=visit_limit_rule%>'>
<input type='hidden' name='clinic_type' id='clinic_type' value= <%= clinic_type%> >
<input type='hidden' name='res_type' id='res_type' value= <%= res_type%> >
<input type='hidden' name='noslots' id='noslots' value= '' >
<input type='hidden' name='total_first_visits_blocked' id='total_first_visits_blocked' value= '<%=total_first_visits_blocked%>'>
<input type='hidden' name='total_other_visits_blocked' id='total_other_visits_blocked' value= '<%=total_other_visits_blocked%>' >
<input type='hidden' name='max_patients_per_day' id='max_patients_per_day' value= '<%=max_patients_per_day%>' >
<input type='hidden' name='time_table_type' id='time_table_type' value= '<%=time_table_type%>' >
<input type='hidden' name='counter' id='counter' value= '<%=counter%>' >

<input type='hidden' name='to_count' id='to_count' value= '' >

<!-- Added for ML-BRU-CRF-0628.1 -->
<input type="hidden" name="p_o_ext_slot_status" id="p_o_ext_slot_status" value="<%=p_o_ext_slot_status%>">
<input type="hidden" name="p_o_reserved_slot_dtls" id="p_o_reserved_slot_dtls" value="<%=p_o_reserved_slot_dtls%>">
<input type="hidden" name="p_o_appt_slot_dtls" id="p_o_appt_slot_dtls" value="<%=p_o_appt_slot_dtls%>">
<input type="hidden" name="p_o_block_slot_dtls" id="p_o_block_slot_dtls" value="<%=p_o_block_slot_dtls%>">
<input type="hidden" name="p_o_break_slot_dtls" id="p_o_break_slot_dtls" value="<%=p_o_break_slot_dtls%>">
<input type="hidden" name="isSlotStartMidEndAppl" id="isSlotStartMidEndAppl" value="<%=isSlotStartMidEndAppl%>">
<!-- End ML-BRU-CRF-0628.1 -->

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
				
					document.getElementById("results").rows(i+1).cells(0).style.backgroundColor = "Bisque";
					document.getElementById("results").rows(i+1).cells(1).style.backgroundColor = "Bisque";
					document.getElementById("results").rows(i+1).cells(0).style.Color = "Black";
					document.getElementById("results").rows(i+1).cells(1).style.Color = "Black";
					document.getElementById("results").rows(i+1).cells(2).style.backgroundColor = "Bisque";
					document.getElementById("results").rows(i+1).cells(2).innerText = "BRU Health Reservation : "+res_slot_arr[i];

				}else {
					document.getElementById("results").rows(i+1).cells(0).style.backgroundColor = "Bisque";
					document.getElementById("results").rows(i+1).cells(1).style.backgroundColor = "Bisque";
				}
			}

			
		}
			
	}
}
/* End ML-BRU-CRF-0628.1 */
</script>

<%

}
else
{%>
	<script>
	 var err = getMessage('SCH_NO_SLOT','OA');
	parent.parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+err; </script>
	
<script>parent.parent.frames[1].location.href='../../eCommon/html/blank.html' </script>
<%

}
	if (rs != null) rs.close();
	if (rs2 != null) rs2.close();
	if (stmt2 != null) stmt2.close();
	if (stmtsd != null) stmtsd.close();
	if (statement != null) statement.close();
	if (cstmt != null) cstmt.close();
	if (statement_bru != null) statement_bru.close();

}catch(Exception e) { 
	out.println("hre :" +e.toString());
	e.printStackTrace();
}finally{
	ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

