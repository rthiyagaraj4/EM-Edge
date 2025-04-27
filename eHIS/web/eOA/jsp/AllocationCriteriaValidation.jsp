<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*" %>
<script src='../../eOA/js/BookAppointment.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

</head>
<BODY CLASS="MESSAGE" onKeyDown = 'lockKey()'>

<%
Connection con = null;
ResultSet rs=null;
ResultSet prs=null;
ResultSet prs1=null;
request.setCharacterEncoding("UTF-8");	

Statement stmt = null;
PreparedStatement pstmt =null;
String facilityid=(String)session.getValue("facility_id");
String step=request.getParameter("step");
//String locale=(String)session.getAttribute("LOCALE");
if (step==null) step ="";
try{
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
 if (step.equals("3")){
		 String clinic_code=request.getParameter("clinic_code");
		 String gender=request.getParameter("gender");
		 String date_of_birth=request.getParameter("date_of_birth");
	
		 String sql =  "select count(1) cnt from op_clinic a where clinic_code =? and  ((age_group_code is null ) or ((age_group_code is not null) and  exists (select age_group.age_group_code from am_age_group age_group  where age_group.age_group_code=a.age_group_code and nvl(age_group.gender,?)=? and trunc(sysdate)-trunc(to_date(?,'dd/mm/yyyy')) between decode(age_group.age_unit,'Y',365,'M',30,1)*age_group.min_age and decode(age_group.age_unit,'Y',365,'M',30,1)*age_group.max_age and age_group.eff_status='E' ))) and facility_id = ?" ;
		 pstmt=con.prepareStatement(sql);
		 pstmt.setString(1,clinic_code);
		 pstmt.setString(2,gender);
		 pstmt.setString(3,gender);
		 pstmt.setString(4,date_of_birth);
		 pstmt.setString(5,facilityid);
		 prs=pstmt.executeQuery();
		 int cnt=0;


		 while(prs!=null&&prs.next()){
		  cnt = prs.getInt(1);
		  if (cnt==0){ %>
			 <script>
				var err_age = getMessage( "AGE_GENDER_NOT_MATCH","OA" ) ;
				alert(err_age);
				clear_all_fun_alcn();					
			</script>
			<%
		  }else{
			 %>
			 <script>
				Apply();
			</script>
			<%
		  }
		}
	 
}	
else if (step.equals("4"))
	{

	 String clinic_code  = request.getParameter("clinic_code");
	 String patient_id   = request.getParameter("patient_id");
	 String service_code = request.getParameter("service_code");
	 String sel_service_code = request.getParameter("sel_service_code");
	 String vtype_ind = request.getParameter("vtype_ind");
	 String override_vtype_on_epsd_yn=""; 
	if(clinic_code==null) clinic_code="";
	if(patient_id==null) patient_id="";
	if(service_code==null) service_code="";
	if(vtype_ind==null) vtype_ind="";
	if(pstmt !=null) pstmt.close();
	if(prs !=null)prs.close();
	//String sql =  "select OVERRIDE_VTYPE_ON_EPSD_YN from op_param where OPERATING_FACILITY_ID='"+facilityid+"'" ;
	String sql =  "select OVERRIDE_VTYPE_ON_EPSD_YN from op_param where OPERATING_FACILITY_ID=?" ;
	 pstmt=con.prepareStatement(sql);
	 pstmt.setString(1,facilityid);
	 prs=pstmt.executeQuery();
	 int cnt=0;
	 if(prs!=null && prs.next()){
	 override_vtype_on_epsd_yn = prs.getString("OVERRIDE_VTYPE_ON_EPSD_YN");
	 }
	 String sql_one="";
	  if (override_vtype_on_epsd_yn.equals("N") && !vtype_ind.equals("F"))
		 {
		  if(sel_service_code==null || sel_service_code.equals("")){
			 // sql_one="select count(*) count from pr_encounter where facility_id ='"+facilityid+"'and assign_care_locn_code = '"+clinic_code+"' and patient_id ='"+patient_id+"'  AND visit_adm_type_ind = 'F'  and patient_class = 'OP'";
			  sql_one="select count(*) count from pr_encounter where facility_id =? and assign_care_locn_code = ? and patient_id =?  AND visit_adm_type_ind = 'F'  and patient_class = 'OP'";
		  }
		  else{
			//  sql_one="SELECT COUNT (*) COUNT FROM pr_encounter WHERE facility_id = '"+facilityid+"' AND service_code = '"+sel_service_code+"' and patient_id ='"+patient_id+"'   AND visit_adm_type_ind = 'F' AND patient_class = 'OP'";
			  sql_one="SELECT COUNT (*) COUNT FROM pr_encounter WHERE facility_id = ? AND service_code = ? and patient_id = ?   AND visit_adm_type_ind = 'F' AND patient_class = 'OP'";
		  }

		  //prs1=stmt.executeQuery(sql_one);
		  pstmt = con.prepareStatement(sql_one);
		  if (override_vtype_on_epsd_yn.equals("N") && !vtype_ind.equals("F"))
		 {
		  if(sel_service_code==null || sel_service_code.equals("")){
		  pstmt.setString(1,facilityid);
		  pstmt.setString(2,clinic_code);
		  pstmt.setString(3,patient_id);
		 }
		 }
		 else{
		  pstmt.setString(1,facilityid);
		  pstmt.setString(2,sel_service_code);
		  pstmt.setString(3,patient_id);
		 }
		  prs1 = pstmt.executeQuery();
		  while(prs1 !=null && prs1.next())
		 {
			cnt=prs1.getInt("count");
		 }

		 if(cnt >=1)
		 {%>
		 <script>
			 Apply();
		</script>
		 <%}else
		{
			//Called during normal book appointment on click of "Confirm Booking"
			if(sel_service_code==null || sel_service_code.equals("")){
		 %>
		 <script>
			var err_age = getMessage( "FIRST_VISIT_ONLY_ALLOWED","OA") ;
			alert(err_age);
			parent.frames[2].document.forms[0].Insupd.disabled=false;
			parent.document.frames[0].document.forms[0].visit_type_short_desc.focus();
		</script>
        <%
			}else{%>
			<script>
			var err_age = getMessage( "NO_SERVICE_VISIT_FIRST_VISIT_ONLY","OA") ;
			alert(err_age);
			parent.frames[2].document.forms[0].Insupd.disabled=false;
			parent.document.frames[0].document.forms[0].visit_type_short_desc.focus();
		</script>
			<%
			}
		}
    
		}else {%>
			<script>
			
			 Apply();
		</script>
			<%}
}
else
{


String clinic_code=request.getParameter("clinic_code");
String practitioner_id=request.getParameter("practitioner_id");
String clinic_date=request.getParameter("appt_date");
String facilityId=(String)session.getValue("facility_id");
String pat_cat=request.getParameter("pat_cat");
String slot_appt_ctrl=request.getParameter("slot_appt_ctrl");
if(pat_cat==null) pat_cat="";
String no_slots=request.getParameter("no_slots");
if(no_slots==null) no_slots="0";
if(no_slots==""||no_slots.equals("")) no_slots="0";
int no_slots_value=Integer.parseInt(no_slots);
String book_appt_across_catg_yn=request.getParameter("book_appt_across_catg_yn");
String from_time=request.getParameter("from_time");
String to_time=request.getParameter("to_time");
String patient_id=request.getParameter("patient_id");
String time_table_type=request.getParameter("time_table_type");
String clinic_type=request.getParameter("clinic_type");
String c_name_prefix_accept_yn="";
String c_first_name_accept_yn="";
String c_second_name_accept_yn="";
String c_third_name_accept_yn="";
String c_family_name_accept_yn="";
String c_name_suffix_accept_yn="";
boolean allow_book=true;
boolean overlap=false;
String chk="";
String chk_cat_limit="";

//Added by Suman
if(pat_cat.equals(""))
	{
			
			//if(time_table_type.equals("1"))
		//{
			//String chk_overlap1= "select '1'  from oa_appt where ((to_date('"+from_time+"','HH24:mi')  +(1/(60*24)) between to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date('"+to_time+"','HH24:mi') between  		to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') > to_date('"+from_time+"','hh24:miss')  and	to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') < to_date('"+to_time+"','hh24:miss'))) and appt_date = to_date('"+clinic_date+"','dd/mm/yyyy') and patient_id='"+patient_id+"'	and CARE_LOCN_TYPE_IND='"+clinic_type+"'" ;
			//rs = stmt.executeQuery(chk_overlap1) ;
			String chk_overlap1= "select '1'  from oa_appt where ((to_date(?,'HH24:mi')  +(1/(60*24)) between to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date(?,'HH24:mi') between  		to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') > to_date(?,'hh24:miss')  and	to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') < to_date(?,'hh24:miss'))) and appt_date = to_date(?,'dd/mm/yyyy') and patient_id=?	and CARE_LOCN_TYPE_IND=?" ;
			pstmt = con.prepareStatement(chk_overlap1);
			pstmt.setString(1,from_time);
			pstmt.setString(2,to_time);
			pstmt.setString(3,from_time);
			pstmt.setString(4,to_time);
			pstmt.setString(5,clinic_date);
			pstmt.setString(6,patient_id);
			pstmt.setString(7,clinic_type);
			rs = pstmt.executeQuery();
			if(rs !=null){
				if(rs.next())
				{
					chk=rs.getString(1);
					overlap=true;
				}
				else
				{
				overlap=false;
				}
		  }
		/*}else if(time_table_type.equals("2") || time_table_type.equals("3"))
		{
			//String chk_overlap1= "select '1'  from oa_appt where ((to_date('"+from_time+"','HH24:mi')  +(1/(60*24)) between to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date('"+to_time+"','HH24:mi') between  		to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') > to_date('"+from_time+"','hh24:miss')  and	to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') < to_date('"+to_time+"','hh24:miss'))) and appt_date = to_date('"+clinic_date+"','dd/mm/yyyy') and patient_id='"+patient_id+"'	and CARE_LOCN_TYPE_IND='"+clinic_type+"' and clinic_code='"+clinic_code+"'" ;
			String chk_overlap1= "select '1'  from oa_appt where ((to_date('"+from_time+"','HH24:mi')  +(1/(60*24)) between to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date('"+to_time+"','HH24:mi') between  		to_date(to_char(appt_slab_from_time,'HH24:mi'),'HH24:mi')+(1/(60*24)) and to_date(to_char(appt_slab_to_time,'HH24:mi'),'HH24:mi')) or 	(to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') > to_date('"+from_time+"','hh24:miss')  and	to_date(to_char(APPT_SLAB_FROM_TIME,'hh24:miss'),'hh24:miss') < to_date('"+to_time+"','hh24:miss'))) and appt_date = to_date('"+clinic_date+"','dd/mm/yyyy') and patient_id='"+patient_id+"'	and CARE_LOCN_TYPE_IND='"+clinic_type+"'" ;
			System.out.println("chk_overlap1 time_table2:"+chk_overlap1);
			rs = stmt.executeQuery(chk_overlap1) ;
			if(rs !=null){
			if(rs.next())
			{
				chk=rs.getString(1);
				overlap=true;
		    }
			else
				{
			overlap=false;

			}
			
			
	}
		}*/
if(rs !=null) rs.close();
if (overlap){%>
	<script>
	alert(getMessage('APPT_OVERLAP_NOT_PROCEED','OA'));
			clear_fun_all();

	</script>
  <%
}else{
 %>
 <script>
	checkagegender();
 </script>
	<%
				
}


}else{

if(allow_book){
	if (no_slots_value>1 && time_table_type.equals("1") && slot_appt_ctrl.equals("S"))
	{
		if(practitioner_id== null || practitioner_id.equals("")){
			//chk_cat_limit="select 'N' catg_limit_crossed_yn from oa_clinic_schedule_dtl a  where a.facility_id ='"+facilityId+"' and a.clinic_code='"+clinic_code+"'  and a.clinic_date= to_date('"+clinic_date+"','DD/MM/YYYY')  and a.practitioner_id is null and a.alcn_catg_code= '"+pat_cat+"'and a.max_patients >= a.total_booked_patients +"+no_slots_value+"";
			chk_cat_limit="select 'N' catg_limit_crossed_yn from oa_clinic_schedule_dtl a  where a.facility_id =? and a.clinic_code=?  and a.clinic_date= to_date(?,'DD/MM/YYYY')  and a.practitioner_id is null and a.alcn_catg_code= ? and a.max_patients >= a.total_booked_patients + ?";
		}else{
			//chk_cat_limit="select 'N' catg_limit_crossed_yn from oa_clinic_schedule_dtl a  where a.facility_id ='"+facilityId+"' and a.clinic_code='"+clinic_code+"'  and a.clinic_date= to_date('"+clinic_date+"','DD/MM/YYYY')  and a.practitioner_id ='"+practitioner_id+"' and a.alcn_catg_code= '"+pat_cat+"'and a.max_patients >= a.total_booked_patients +"+no_slots_value+"";
			chk_cat_limit="select 'N' catg_limit_crossed_yn from oa_clinic_schedule_dtl a  where a.facility_id =? and a.clinic_code=? and a.clinic_date= to_date(?,'DD/MM/YYYY')  and a.practitioner_id =? and a.alcn_catg_code= ? and a.max_patients >= a.total_booked_patients +? ";
		}
		
	}else{
		if(practitioner_id== null || practitioner_id.equals("")){
			//chk_cat_limit="select 'N' catg_limit_crossed_yn from oa_clinic_schedule_dtl a where a.facility_id ='"+facilityId+"'   and a.clinic_code='"+clinic_code+"' and a.clinic_date= to_date('"+clinic_date+"','DD/MM/YYYY')  and a.practitioner_id is null and a.alcn_catg_code= '"+pat_cat+"' and a.max_patients > a.total_booked_patients";
			chk_cat_limit="select 'N' catg_limit_crossed_yn from oa_clinic_schedule_dtl a where a.facility_id =? and a.clinic_code=? and a.clinic_date= to_date(?,'DD/MM/YYYY')  and a.practitioner_id is null and a.alcn_catg_code= ? and a.max_patients > a.total_booked_patients";

		}else{
			//chk_cat_limit="select 'N' catg_limit_crossed_yn from oa_clinic_schedule_dtl a where a.facility_id ='"+facilityId+"'   and a.clinic_code='"+clinic_code+"' and a.clinic_date= to_date('"+clinic_date+"','DD/MM/YYYY')  and a.practitioner_id= '"+practitioner_id+"' and a.alcn_catg_code= '"+pat_cat+"' and a.max_patients > a.total_booked_patients";
			chk_cat_limit="select 'N' catg_limit_crossed_yn from oa_clinic_schedule_dtl a where a.facility_id =? and a.clinic_code=? and a.clinic_date= to_date(?,'DD/MM/YYYY')  and a.practitioner_id= ? and a.alcn_catg_code= ? and a.max_patients > a.total_booked_patients";

		}
	}
			//rs = stmt.executeQuery(chk_cat_limit) ;
			pstmt = con.prepareStatement(chk_cat_limit);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,clinic_code);
			pstmt.setString(3,clinic_date);
			if (no_slots_value>1 && time_table_type.equals("1") && slot_appt_ctrl.equals("S")){
			if(practitioner_id== null || practitioner_id.equals("")){
			pstmt.setString(4,pat_cat);
			pstmt.setInt(5,no_slots_value);
			}else{
			pstmt.setString(4,practitioner_id);
			pstmt.setString(5,pat_cat);
			pstmt.setInt(6,no_slots_value);
			}}
			else
			{
			if(practitioner_id== null || practitioner_id.equals("")){
			pstmt.setString(4,pat_cat);
			}else{
			pstmt.setString(4,practitioner_id);
			pstmt.setString(5,pat_cat);
			}
			}
			rs = pstmt.executeQuery();
			if(rs !=null){
				if(rs.next())
				{
				chk=rs.getString(1);
				allow_book=true;
				}
				else
				  allow_book=false;
				
			}
if(rs !=null) rs.close();
			if(chk.equals("N"))
				allow_book=true;			
			else
				allow_book=false;
					
		if(!patient_id.equals("")){
			String checking="select name_prefix_accept_yn, first_name_accept_yn,second_name_accept_yn,third_name_accept_yn,family_name_accept_yn,name_suffix_accept_yn from mp_param where module_id='MP'";
			//rs=stmt.executeQuery(checking);
			pstmt = con.prepareStatement(checking);
			rs = pstmt.executeQuery();
			if(rs!=null){
			while(rs.next()){
			c_name_prefix_accept_yn=rs.getString(1);
			c_first_name_accept_yn=rs.getString(2);
			c_second_name_accept_yn=rs.getString(3);
			c_third_name_accept_yn=rs.getString(4);
			c_family_name_accept_yn=rs.getString(5);
 			c_name_suffix_accept_yn=rs.getString(6);
			}
			}
			if(rs !=null) rs.close();
			//String chk_overlap= "select '1' from oa_appt where (appt_slab_from_time between to_date('"+from_time+"','hh24:mi') and to_date('"+to_time+"','hh24:mi') or appt_slab_to_time between to_date('"+from_time+"','hh24:mi') and to_date('"+to_time+"','hh24:mi'))and appt_date = to_date('"+clinic_date+"','dd/mm/yyyy') and patient_id='"+patient_id+"' and CARE_LOCN_TYPE_IND='"+clinic_type+"' ";
			//rs = stmt.executeQuery(chk_overlap) ;
			String chk_overlap= "select '1' from oa_appt where (appt_slab_from_time between to_date(?,'hh24:mi') and to_date(?,'hh24:mi') or appt_slab_to_time between to_date(?,'hh24:mi') and to_date(?,'hh24:mi'))and appt_date = to_date(?,'dd/mm/yyyy') and patient_id=? and CARE_LOCN_TYPE_IND=? ";
			pstmt = con.prepareStatement(chk_overlap);
			pstmt.setString(1,from_time);
			pstmt.setString(2,to_time);
			pstmt.setString(3,from_time);
			pstmt.setString(4,to_time);
			pstmt.setString(5,clinic_date);
			pstmt.setString(6,patient_id);
			pstmt.setString(7,clinic_type);
			rs = pstmt.executeQuery();
			if(rs !=null){
			if(rs.next())
			{
			chk=rs.getString(1);
			overlap=true;
		    }
			else
			{
			overlap=false;
			}
}
if(rs !=null) rs.close();
}
else{
overlap=false;
}
if(allow_book){
if(!(overlap))
{
allow_book=true;
}
else{
%>
<script>
parent.document.frames[0].document.forms[0].patient_id.value='';
parent.document.frames[0].document.forms[0].patient_id.disabled=false;
parent.document.frames[0].document.getElementById("pat_ser_but").disabled=false;
parent.document.frames[0].document.forms[0].patient_name.value='';
parent.document.frames[0].document.forms[0].patient_name.readOnly=false;
if (parent.document.frames[0].document.forms[0].national_id){
parent.document.frames[0].document.forms[0].national_id.value='';
parent.document.frames[0].document.forms[0].national_id.readOnly=false;}
if(parent.document.frames[0].document.forms[0].other_id1!=null)
	parent.document.frames[0].document.forms[0].other_id1.style.visibility='hidden';

</script>

<%	
	if(c_name_prefix_accept_yn.equals("Y")){
%>
	<script>
	parent.document.frames[0].document.forms[0].name_prefix.value='';
    parent.document.frames[0].document.forms[0].name_prefix.disabled=false;
	</script>
<% } %>
<%
	if(c_first_name_accept_yn.equals("Y")){
%>
	<script>
	parent.document.frames[0].document.forms[0].first_name.value='';
	parent.document.frames[0].document.forms[0].first_name.readOnly=false;
	</script>
<% } %>
<% 
	
	if(c_second_name_accept_yn.equals("Y"))
	{
%>
	<script>
	parent.document.frames[0].document.forms[0].second_name.value='';
	parent.document.frames[0].document.forms[0].second_name.readOnly=true;
	</script>
<% } %>
<% if(c_third_name_accept_yn.equals("Y"))
	{
%>
	<script>
	parent.document.frames[0].document.forms[0].third_name.value='';
	parent.document.frames[0].document.forms[0].third_name.readOnly=false;
	</script>
<% } %>
<%if(c_family_name_accept_yn.equals("Y"))
	{
%>
	<script>
	parent.document.frames[0].document.forms[0].family_name.value='';
	parent.document.frames[0].document.forms[0].family_name.readOnly=false;
	</script>
<% } %>
<% if(c_name_suffix_accept_yn.equals("Y"))
   {
%>
	<script>
	parent.document.frames[0].document.forms[0].name_suffix.value='';
	parent.document.frames[0].document.forms[0].name_suffix.disabled=false;
	</script>
<% } %>	
	
	<script>
	parent.document.frames[0].document.forms[0].sex.value='';
	parent.document.frames[0].document.forms[0].sex.disabled=false;
	parent.document.frames[0].document.forms[0].nationality.value='';
	parent.document.frames[0].document.forms[0].date_of_birth.value='';
	parent.document.frames[0].document.forms[0].date_of_birth.readOnly=false;
	parent.document.frames[0].document.forms[0].b_age.value='';
	parent.document.frames[0].document.forms[0].b_age.readOnly=false;
	parent.document.frames[0].document.forms[0].b_months.value='';
	parent.document.frames[0].document.forms[0].b_months.readOnly=false;
	parent.document.frames[0].document.forms[0].b_days.value='';
	parent.document.frames[0].document.forms[0].b_days.readOnly=false;
	parent.document.frames[0].document.forms[0].contact1_no.value='';
	parent.document.frames[0].document.forms[0].contact2_no.value='';
	parent.document.frames[0].document.forms[0].email.value='';
	parent.document.frames[0].document.forms[0].OtherAppts.disabled=false;
	parent.document.frames[0].document.forms[0].source.disabled=false;
	parent.document.frames[0].document.forms[0].source.value='';
    parent.document.frames[0].document.getElementById("ref_ser_but").disabled=false;
									
	allow_book=false;
</script>
<%
}
}
}


if(!(overlap)){	
	if(allow_book){	
	%>
	<script>
	checkagegender();
	</script>
	<%
	}else{
		if (no_slots_value>1 && time_table_type.equals("1")&& slot_appt_ctrl.equals("S")){
			String s1="";
			if(practitioner_id==null || practitioner_id.equals("")){
				//s1="select count(1) from oa_clinic_schedule_dtl where facility_id = '"+facilityid+"' and clinic_code ='"+clinic_code+"' and clinic_date= to_date('"+clinic_date+"','DD/MM/YYYY') and practitioner_id is null  and max_patients >= total_booked_patients+"+no_slots_value+"   ";
				s1="select count(1) from oa_clinic_schedule_dtl where facility_id = ? and clinic_code =? and clinic_date= to_date(?,'DD/MM/YYYY') and practitioner_id is null  and max_patients >= total_booked_patients+? ";
			}else{
				//s1="select count(1) from oa_clinic_schedule_dtl where facility_id = '"+facilityid+"' and clinic_code ='"+clinic_code+"' and clinic_date= to_date('"+clinic_date+"','DD/MM/YYYY') and practitioner_id= '"+practitioner_id+"' and max_patients >= total_booked_patients+"+no_slots_value+"   ";
				s1="select count(1) from oa_clinic_schedule_dtl where facility_id = ? and clinic_code = ? and clinic_date= to_date(? ,'DD/MM/YYYY') and practitioner_id= ? and max_patients >= total_booked_patients+? ";
			}
			
			if (rs!=null)rs.close();
			pstmt = con.prepareStatement(s1);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,clinic_code);
			pstmt.setString(3,clinic_date);
			if (no_slots_value>1 && time_table_type.equals("1")&& slot_appt_ctrl.equals("S")){
		    pstmt.setInt(4,no_slots_value);
			}else{
			pstmt.setString(4,practitioner_id);
			pstmt.setInt(5,no_slots_value);
			}
			rs = pstmt.executeQuery();
			//rs=stmt.executeQuery(s1);
			while(rs!=null&&rs.next()){
				if (rs.getInt(1)==0){%>
				<script>
					alert(getMessage('MULTI_SLOT_NOT_AVAILABLE','OA'));
					clear_all_fun_alcn();
				</script>
				<%}else{	
					if(book_appt_across_catg_yn!=null && book_appt_across_catg_yn.equals("Y")){%>
				<script>
					setTimeout('test_time()',500);
					function test_time(){
						var allow_book_across=confirm(getMessage("APPT_BOOK_ANOTHER_CAT","OA"));
						if(allow_book_across){
							parent.document.frames[0].document.Bkappt_form.book_apt_acr_cat_yn.value="Y";
							 checkagegender();
						}
					}
				</script>
				<%}else if(book_appt_across_catg_yn!=null && book_appt_across_catg_yn.equals("N")){%>
				<script>
					alert(getMessage('APPT_CAN_NOT_BOOK_OTH_CAT','OA'));
				    clear_all_fun_alcn();
				</script>
				<%}
				}
			}
		}else{	
		if(book_appt_across_catg_yn!=null && book_appt_across_catg_yn.equals("Y")){%>
		<script>
			setTimeout('test_time()',500);
			function test_time(){
				var allow_book_across=confirm(getMessage("APPT_BOOK_ANOTHER_CAT","OA"));
				if(allow_book_across){
					parent.document.frames[0].document.Bkappt_form.book_apt_acr_cat_yn.value="Y";
					checkagegender();
				}
			}
		</script>
		<%}else if(book_appt_across_catg_yn!=null && book_appt_across_catg_yn.equals("N")){%>
		<script>
			alert(getMessage('APPT_CAN_NOT_BOOK_OTH_CAT','OA'));
			clear_all_fun_alcn();
		</script>
		<%}
	 }
   }
}
else{
	%>
	<script>
	//Added by Suman
	alert(getMessage('APPT_OVERLAP_NOT_PROCEED','OA'));
	clear_fun_all();
	</script>
<%}
	}
	}
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
	if(prs !=null) prs.close();
	if(prs1 !=null) prs1.close();
	if(pstmt !=null) pstmt.close();
}catch( Exception e ){
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
	if(prs !=null) prs.close();
	if(prs1 !=null) prs1.close();
	if(pstmt !=null) pstmt.close();
}
%>		

