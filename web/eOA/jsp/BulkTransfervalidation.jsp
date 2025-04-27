
 
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<% 
Connection con = null;
ResultSet rs=null;
ResultSet rs3=null;
Statement stmtas =null;
Statement stmt =null;
ResultSet rset_sec_value=null;


try{
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);

	stmtas = con.createStatement();
	stmt = con.createStatement();

	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String facilityId	=(String) session.getValue("facility_id");
	String loginuser 	= (String) session.getValue( "login_user" ) ;
	String steps		=(String) hash.get("steps");
	String from_date			= (String) hash.get("from_date");
	String clinic_type			= (String) hash.get("clinic_type");
	String resc_code			= (String) hash.get("resc_code");
	String resc_class			= (String) hash.get("resc_class");
	String to_date			= (String) hash.get("to_date");
	String clinic_type_to			= (String) hash.get("clinic_type_to");
	String resc_code_to			= (String) hash.get("resc_code_to");
	String resc_class_to			= (String) hash.get("resc_class_to");
	String locn_type			= (String) hash.get("locn_type");
	String Sys_date				= (String) hash.get("Sys_date");
	String CARE_LOCN_TYPE_IND = (String) hash.get("CARE_LOCN_TYPE_IND");

	String speciality_code = (String) hash.get("speciality_code");
	String clinic_code1=(String) hash.get("clinic_code1");
	String sec_req=(String) hash.get("sec_req");
	String clinic_code_sec=(String) hash.get("clinic_code");
	String clinic_date_sec = (String) hash.get("clinic_date");
	String facility_id_sec =(String) hash.get("facility_id");
	String sel_sec=(String) hash.get("sel_sec");

	String locale			= (String)session.getAttribute("LOCALE");


	if(steps.equals("bulktransfer_sch_exists")){ 
	
	
	int cnt_from=0;
	int cnt_to=0;
	int MAX_PATIENTS_PER_DAY=0;
	int TOTAL_SLOTS_BOOKED=0;
	int MAX_FORCED_IN_BOOKING=0;
	int MAX_PATIENTS_PER_DAY_FROM=0;
	int TOTAL_SLOTS_BOOKED_FROM=0;
	int MAX_FORCED_IN_BOOKING_FROM=0;
	int TOTAL_FORCED_IN_BOOKED=0;
	int MAX_OVER_BOOKING_FROM=0; 
	int TOTAL_OVERBOOKED_FROM=0;
	int MAX_OVER_BOOKING_TO=0; 
	int TOTAL_OVERBOOKED_TO=0;
	int TOTAL_FIRST_VISIT_SLOTS_BOOKED_FROM=0;
	int TOTAL_OTHER_VISIT_SLOTS_BOOKED_FROM=0;
	int TOTAL_FIRST_VISIT_SLOTS_BOOKED_TO=0;
	int TOTAL_OTHER_VISIT_SLOTS_BOOKED_TO=0;
	int MAX_FIRST_VISITS_TO=0;
	int MAX_OTHER_VISITS_TO=0;
	int MAX_FIRST_VISITS_FROM=0;
	int MAX_OTHER_VISITS_FROM=0;
	int SCHEDULE_EXTEND_TO=0;
	String SCHEDULE_EXTEND_TO_STR="";
	int SCHEDULE_EXTEND_FROM=0;
	String SCHEDULE_EXTEND_FROM_STR="";
	%>var flag=true;
	var error=true;
	var cnt_val="";
	var max_pat_per_day="";
	var tot_booked="";
	var max_forced_in_booking="";
	var max_pat_per_day_from="";
	var tot_booked_from="";
	var max_forced_in_booking_from="";
	var total_forced_in_booked_to="";
	var max_over_booking_from=""; 
	var total_overbooked_from="";
	var max_over_booking_to=""; 
	var total_overbooked_to="";
	var total_first_visit_slots_booked_from="";
	var total_other_visit_slots_booked_from="";
	var total_first_visit_slots_booked_to="";
	var total_other_visit_slots_booked_to="";
	var max_first_visits_to="";
	var max_other_visits_to="";
	var max_first_visits_from="";
	var max_other_visits_from="";
	var schedule_extend_to="";
	var schedule_extend_from="";
	<%
	StringBuffer sql_from =new StringBuffer();


	 sql_from.append("SELECT Count(*) FROM oa_appt WHERE appt_date=To_Date('"+from_date+"','dd/mm/yyyy') AND clinic_code='"+clinic_type+"' AND  PRACTITIONER_ID ='"+resc_code+"' AND facility_id='"+facilityId+"' and CARE_LOCN_TYPE_IND='"+locn_type+"' and RESOURCE_CLASS='"+resc_class+"' and Trunc(APPT_DATE) >=Trunc(sysdate)");

	 if(from_date.equals(Sys_date))
	{
	 sql_from.append("and to_char(APPT_SLAB_TO_TIME,'hh24:mi') >= to_char(sysdate,'hh24:mi')");
	}

	rs=stmtas.executeQuery(sql_from.toString());

	if(rs!=null && rs.next()) 
	{
	cnt_from=rs.getInt(1);
	}
	if(rs !=null) rs.close();
if(cnt_from >0 )
	{

	String sql_to="SELECT MAX_PATIENTS_PER_DAY,TOTAL_SLOTS_BOOKED,MAX_FORCED_IN_BOOKING,TOTAL_FORCED_IN_BOOKED ,MAX_OVER_BOOKING ,TOTAL_OVERBOOKED,TOTAL_FIRST_VISIT_SLOTS_BOOKED,nvl(TOTAL_FOLLOW_UP,0)+ nvl(TOTAL_ROUTINE,0)+nvl(TOTAL_SERIES,0)+nvl(TOTAL_CONSULT,0)+nvl(TOTAL_EMERGENCY,0) other_visits_booked,MAX_FIRST_VISITS,MAX_OTHER_VISITS,nvl(SCHEDULE_EXTEND_YN,'N') SCHEDULE_EXTEND_YN FROM oa_clinic_schedule WHERE clinic_date=To_Date('"+to_date+"','dd/mm/yyyy') AND clinic_code='"+clinic_type_to+"' AND  PRACTITIONER_ID ='"+resc_code_to+"' AND facility_id='"+facilityId+"' and CARE_LOCN_TYPE_IND='"+locn_type+"' and RESOURCE_CLASS='"+resc_class_to+"'";

	rs=stmtas.executeQuery(sql_to);
	if(rs!=null && rs.next()) 
	{
	MAX_PATIENTS_PER_DAY=rs.getInt("MAX_PATIENTS_PER_DAY");
	TOTAL_SLOTS_BOOKED=rs.getInt("TOTAL_SLOTS_BOOKED");
	MAX_FORCED_IN_BOOKING=rs.getInt("MAX_FORCED_IN_BOOKING");
	TOTAL_FORCED_IN_BOOKED=rs.getInt("TOTAL_FORCED_IN_BOOKED");
	MAX_OVER_BOOKING_TO=rs.getInt("MAX_OVER_BOOKING");
	TOTAL_OVERBOOKED_TO=rs.getInt("TOTAL_OVERBOOKED");
	TOTAL_FIRST_VISIT_SLOTS_BOOKED_TO=rs.getInt("TOTAL_FIRST_VISIT_SLOTS_BOOKED");
	TOTAL_OTHER_VISIT_SLOTS_BOOKED_TO=rs.getInt("other_visits_booked");
	MAX_FIRST_VISITS_TO=rs.getInt("MAX_FIRST_VISITS");
	MAX_OTHER_VISITS_TO=rs.getInt("MAX_OTHER_VISITS");
	SCHEDULE_EXTEND_TO_STR=rs.getString("SCHEDULE_EXTEND_YN");
	if(SCHEDULE_EXTEND_TO_STR.equals("Y"))
		SCHEDULE_EXTEND_TO=1; 
	cnt_to=1;
	}else
	{
	cnt_to=0;
	}

	if(rs !=null) rs.close();

	String sql_appt_form="SELECT MAX_FIRST_VISITS,MAX_OTHER_VISITS,MAX_PATIENTS_PER_DAY,TOTAL_SLOTS_BOOKED,TOTAL_FORCED_IN_BOOKED,MAX_OVER_BOOKING ,TOTAL_OVERBOOKED,TOTAL_FIRST_VISIT_SLOTS_BOOKED,nvl(TOTAL_FOLLOW_UP,0)+ nvl(TOTAL_ROUTINE,0)+nvl(TOTAL_SERIES,0)+nvl(TOTAL_CONSULT,0)+nvl(TOTAL_EMERGENCY,0) other_visits_booked,nvl(SCHEDULE_EXTEND_YN,'N') SCHEDULE_EXTEND_YN FROM oa_clinic_schedule WHERE clinic_date=To_Date('"+from_date+"','dd/mm/yyyy') AND clinic_code='"+clinic_type+"' AND  PRACTITIONER_ID ='"+resc_code+"' AND facility_id='"+facilityId+"' and CARE_LOCN_TYPE_IND='"+locn_type+"' and RESOURCE_CLASS='"+resc_class+"'";


	rs=stmtas.executeQuery(sql_appt_form);
	if(rs!=null && rs.next())  
	{
	MAX_PATIENTS_PER_DAY_FROM=rs.getInt("MAX_PATIENTS_PER_DAY");
	TOTAL_SLOTS_BOOKED_FROM=rs.getInt("TOTAL_SLOTS_BOOKED");
	MAX_FORCED_IN_BOOKING_FROM=rs.getInt("TOTAL_FORCED_IN_BOOKED");
	MAX_OVER_BOOKING_FROM=rs.getInt("MAX_OVER_BOOKING");
	TOTAL_OVERBOOKED_FROM=rs.getInt("TOTAL_OVERBOOKED");
	TOTAL_FIRST_VISIT_SLOTS_BOOKED_FROM=rs.getInt("TOTAL_FIRST_VISIT_SLOTS_BOOKED");
	TOTAL_OTHER_VISIT_SLOTS_BOOKED_FROM=rs.getInt("other_visits_booked");
	MAX_FIRST_VISITS_FROM=rs.getInt("MAX_FIRST_VISITS");
	MAX_OTHER_VISITS_FROM=rs.getInt("MAX_OTHER_VISITS");
	SCHEDULE_EXTEND_FROM_STR=rs.getString("SCHEDULE_EXTEND_YN");
	if(SCHEDULE_EXTEND_FROM_STR.equals("Y"))
		SCHEDULE_EXTEND_FROM=1;
	cnt_to=1;
	}



	if(cnt_to >0)
	{%>
	error=true;
	 max_pat_per_day=<%=MAX_PATIENTS_PER_DAY%>;
	 tot_booked=<%=TOTAL_SLOTS_BOOKED%>;
	 max_forced_in_booking=<%=MAX_FORCED_IN_BOOKING%>;
	total_forced_in_booked_to=<%=TOTAL_FORCED_IN_BOOKED%>;
	max_pat_per_day_from=<%=MAX_PATIENTS_PER_DAY_FROM%>;
	tot_booked_from=<%=TOTAL_SLOTS_BOOKED_FROM%>;
	max_forced_in_booking_from=<%=MAX_FORCED_IN_BOOKING_FROM%>;
	max_over_booking_from=<%=MAX_OVER_BOOKING_FROM%>;
	total_overbooked_from=<%=TOTAL_OVERBOOKED_FROM%>;
	max_over_booking_to=<%=MAX_OVER_BOOKING_TO%>;
	total_overbooked_to=<%=TOTAL_OVERBOOKED_TO%>;
	total_first_visit_slots_booked_from=<%=TOTAL_FIRST_VISIT_SLOTS_BOOKED_FROM%>;
	total_other_visit_slots_booked_from=<%=TOTAL_OTHER_VISIT_SLOTS_BOOKED_FROM%>;
	total_first_visit_slots_booked_to=<%=TOTAL_FIRST_VISIT_SLOTS_BOOKED_TO%>;
	total_other_visit_slots_booked_to=<%=TOTAL_OTHER_VISIT_SLOTS_BOOKED_TO%>;
	max_first_visits_to=<%=MAX_FIRST_VISITS_TO%>;
	max_other_visits_to=<%=MAX_OTHER_VISITS_TO%>;
	max_first_visits_from=<%=MAX_FIRST_VISITS_FROM%>;
	max_other_visits_from=<%=MAX_OTHER_VISITS_FROM%>;
	schedule_extend_to=<%=SCHEDULE_EXTEND_TO%>;
	schedule_extend_from=<%=SCHEDULE_EXTEND_FROM%>;
		<%
	}else
	{ %>
	error=false;
	<%}

	}else
	{%>
	flag=false;
	<%
	}
	
	if(cnt_from >0 )
	{%>
		flag=true;
		cnt_val=<%=cnt_from%><%
	}else if(cnt_to >0)
	{%>
		flag=true;
		 max_pat_per_day=<%=MAX_PATIENTS_PER_DAY%>;
		 tot_booked=<%=TOTAL_SLOTS_BOOKED%>;
		<%
	}else
	{ %>
	flag=false;
	<%}
	session.removeAttribute("sec_resc_val_old");

}else if(steps.equals("bulktransfer_slot_slab_freeformat")){

String time_table_type_from="";
String time_table_type_to="";
String schedule_status="";
	%>var flag1=true;<%
	%>var flag2=true;<%
	%>var TT_empty=false;<%
	%>var scheduleStatusFlag=false;<%

	String sql_from="SELECT TIME_TABLE_TYPE FROM oa_clinic_schedule WHERE clinic_date=To_Date('"+from_date+"','dd/mm/yyyy') AND 	clinic_code='"+clinic_type+"' AND  PRACTITIONER_ID ='"+resc_code+"' AND facility_id='"+facilityId+"' and CARE_LOCN_TYPE_IND='"+locn_type+"' and RESOURCE_CLASS='"+resc_class+"'";
	rs=stmtas.executeQuery(sql_from);
	if(rs!=null && rs.next()) 
	{
	time_table_type_from=rs.getString(1);
	}

	if(rs !=null) rs.close();
	String sql_to="SELECT TIME_TABLE_TYPE,schedule_status FROM oa_clinic_schedule WHERE clinic_date=To_Date('"+to_date+"','dd/mm/yyyy') AND clinic_code='"+clinic_type_to+"' AND  PRACTITIONER_ID ='"+resc_code_to+"' AND facility_id='"+facilityId+"' and CARE_LOCN_TYPE_IND='"+locn_type+"' and RESOURCE_CLASS='"+resc_class_to+"'";
	rs=stmtas.executeQuery(sql_to);
	if(rs!=null && rs.next()) 
	{
	time_table_type_to=rs.getString(1);
	schedule_status=rs.getString(2);
	}

		
	if(time_table_type_from.equals("3") || time_table_type_to.equals("3"))
	{
	%>flag1=true;
	flag2=true;<%
	}else
	{
	%>flag1=true;
	flag2=true;<%
	}

	if(!time_table_type_from.equals("") && !time_table_type_to.equals("")){
		if(time_table_type_from.equals(time_table_type_to )){			
			if(schedule_status!=null && schedule_status.equals("B")){%>
				flag1=false;
				scheduleStatusFlag=true;
			<%}else{
				%>parent.frames[1].document.forms[0].time_table_type.value='<%=time_table_type_from%>';
				flag1=true;<%
			}
		}else{
			%>flag1=false;<%
		}
	}else{
		%>flag1=false;
		TT_empty=true;<%
	}



}else if(steps.equals("ADD_BULK_SEC_TO_SESSION"))
{
	String 	SEC_RESC_VAL= (String) hash.get("sel_sec");
	session.putValue("sec_resc_val_old",SEC_RESC_VAL);

}else if(steps.equals("REMOVE_ADD_BULK_SEC_TO_SESSION"))
{
	session.removeAttribute("sec_resc_val_old");

	String 	SEC_RESC_VAL= (String) hash.get("sel_sec");
	session.putValue("sec_resc_val_old",SEC_RESC_VAL);

}else if(steps.equals("bulk_Loc")){  // Bulk location

			
	
		String sql="select locn_type, short_desc, CARE_LOCN_TYPE_IND from am_care_locn_type_lang_vw where SYS_USER_DEF_IND='S' and CARE_LOCN_TYPE_IND='"+CARE_LOCN_TYPE_IND+"' and language_id = '"+locale+"' order by short_desc";

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql);
	

		String b_loc1_value ="";
		String b_loc1_name ="";
		%>
		var i=1;
		var len=parent.frames[1].document.forms[0].b_loc2.options.length;
		var lBox=parent.frames[1].document.forms[0].b_loc2; 

		while(i<=len){
				lBox.remove(lBox.options[i]);
				i+=1;
			}
		
		<%
		if(rs!=null) {
			while(rs.next()) {

				 b_loc1_value= rs.getString("CARE_LOCN_TYPE_IND");
				 b_loc1_name = rs.getString("short_desc");


				%>
				var element = parent.frames[1].document.createElement('OPTION');
				element.text = "<%=b_loc1_name%>";
				element.value= "<%=b_loc1_value%>";
				
				parent.frames[1].document.forms[0].b_loc2.add(element);
				<%    
			}
		}

	}else if(steps.equals("bulk_enable_pract_from")){

	
		String location			= (String) hash.get("location");

		String sql  = "select primary_resource_class from op_clinic where clinic_code='"+clinic_code1+"' and care_locn_type_ind='"+clinic_type+"' and facility_id='"+facilityId+"'";

		String code="";
		String desc="";

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql);

		while(rs!=null && rs.next()){
			code=rs.getString("primary_resource_class");
			//desc=rs.getString("description");
			if(code.equals("P"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			}else if(code.equals("E"))
			{
		    desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			}else if(code.equals("R"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}else if(code.equals("O"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
		}

		%>
		parent.frames[1].document.forms[0].resourceType1.value="<%=code%>";
		parent.frames[1].document.forms[0].location_code1.value="<%=location%>";
		parent.frames[1].document.forms[0].specialty_code1.value="<%=speciality_code%>";
		parent.frames[1].document.forms[0].locationType1.value="<%=clinic_type%>";

		<%

	}else if(steps.equals("bulk_enable_pract_to")){

		String location			= (String) hash.get("location");

		String sql  = "select primary_resource_class from op_clinic where clinic_code='"+clinic_code1+"' and care_locn_type_ind='"+clinic_type+"' and facility_id='"+facilityId+"'";

		String code="";
		String desc="";

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql);

		while(rs!=null && rs.next()){
			code=rs.getString("primary_resource_class");
			//desc=rs.getString("description");
			if(code.equals("P"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			}else if(code.equals("E"))
			{
		    desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			}else if(code.equals("R"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}else if(code.equals("O"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
		}

		%>
		parent.frames[1].document.getElementById("resourceType3").value="<%=code%>";
		parent.frames[1].document.forms[0].location_code2.value="<%=location%>";
		parent.frames[1].document.forms[0].specialty_code2.value="<%=speciality_code%>";
		parent.frames[1].document.forms[0].locationType2.value="<%=clinic_type%>";
		
		<%

	}else if(steps.equals("ADD_SEC_TO_SESSION")){
		int sec_count=0;
				
		String sec_value="";

		%>var flag;<%
		sec_value="select count(practitioner_id) sum from oa_clinic_schedule where clinic_code='"+clinic_code_sec+"' and  trunc(clinic_date)=to_date('"+clinic_date_sec+"','dd/mm/yyyy') and facility_id='"+facility_id_sec+"' and primary_resource_yn='N' and resource_class in ("+sec_req+") and time_table_type in (1,2) group by resource_class";

		rset_sec_value=stmtas.executeQuery(sec_value);
		if(rset_sec_value !=null){
			while( rset_sec_value.next()){
				sec_count=rset_sec_value.getInt("sum");
			
				if(sec_count >1){%> 
					flag="T"; 
					document.forms[0].sec_value_count.value="Y"; <%
					break ;
				}else{
					%> flag="F";
				<%}%>

				if(flag=='T'){
					document.forms[0].sec_value_count.value="Y"; 
				}else{
					document.forms[0].sec_value_count.value="N";
				}<%
			}// while
		}// if

		session.putValue("SEC_RES_SEL",sel_sec);

if(stmtas !=null) stmtas.close();
	}


	if(rs !=null) rs.close();
	if(rs3 !=null) rs3.close();
	if(stmtas !=null) stmtas.close();
	if(stmt!= null) stmt.close() ;

	hash.clear();

}catch( Exception e ){
	//out.println(e.toString());
	e.printStackTrace() ;

}finally{
	if(con !=null) ConnectionManager.returnConnection(con,request);
}
%>	
