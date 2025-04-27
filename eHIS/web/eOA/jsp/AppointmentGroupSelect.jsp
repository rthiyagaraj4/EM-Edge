<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>                  
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<html>  
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
        <script language='javascript' src='../../eOA/js/OAResourceComponent.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"> </script>
		<script src='../../eOA/js/BookAppointment.js' language='javascript'></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>		
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
       </head>

<%
	request.setCharacterEncoding("UTF-8");	
	String facilityid=(String)session.getValue("facility_id");
	
	
	
	String Resource_type="";
	String sql5="";
	String visitcode="";
	String visitdesc="";
	String visitind="";	
	String practid="";
	String practname="";
	String apptdate="";
	String fromtime="";
	String totime="";
	String spec_code="";
	String age_group_code="";
	String care_locn_ind_desc="";
	String service_code="";
	String allow_referral_yn = "";
	String allow_non_referral_yn = "";
	String locale ="";		
	
	String sydate_time="";
	String sys_date_time="";
	String starttime="";
    String endtime="";
    String srl_no="";
	
	
	

	String max_patients_per_slab =checkForNull(request.getParameter("max_patients_per_slab"),"0"); 
	
	String res_type=checkForNull(request.getParameter("res_type"),"P");
	String cliniccode=checkForNull(request.getParameter("i_clinic_code"));
	int visit_ind_count=0;	
	String visit_type_ind=checkForNull(request.getParameter("visit_type_ind"));	
	String clinic_type=checkForNull(request.getParameter("clinic_type"),"C");
	String clinicname=request.getParameter("clinic_name");
	practname=checkForNull(request.getParameter("i_practitioner_name"));
	practid=checkForNull(request.getParameter("i_practitioner_id"));
	
	String or_catalogue_code=request.getParameter("or_catalogue_code");
	if(or_catalogue_code ==null || or_catalogue_code.equals("null")) or_catalogue_code="";
	String order_id=request.getParameter("order_id");	
	if(order_id ==null || order_id.equals("null") )order_id ="";
	String order_line_num=request.getParameter("order_line_num");
	if(order_line_num ==null || order_line_num.equals("null")) order_line_num="";
	String order_catalog_code=request.getParameter("order_catalog_code");//From Pending order schedule
	if(order_catalog_code ==null || order_catalog_code.equals("null")) order_catalog_code="";
	String create_wait_list_yn=checkForNull(request.getParameter("create_wait_list_yn"));	
	String i_patient_id=checkForNull(request.getParameter("i_patient_id"));
	String time_table_type=checkForNull(request.getParameter("i_time_table_type"));
	String entitlement_by_pat_cat_yn	= checkForNull(request.getParameter("entitlement_by_pat_cat_yn"));
	String calling_mode	= checkForNull(request.getParameter("calling_mode"));
	
	StringBuffer sql_srl_no= new StringBuffer("");
	
	
	
	if(locale.equals("en")){
		practname=java.net.URLDecoder.decode(practname);
	}
	apptdate= checkForNull(request.getParameter("i_appt_date"));
	fromtime=request.getParameter("i_from_time");
	if(fromtime!=null){
		fromtime=fromtime.trim();
	}
	totime=request.getParameter("i_to_time");
	if(totime!=null){
		totime=totime.trim();
	}		
	
	
	Connection conn = null;
	Statement stmt_visit_type=null;
	Statement stmt_service=null;	
	ResultSet rs1=null;	
	ResultSet rsas=null;
	ResultSet rs_service=null;
	ResultSet rs =null;	
	ResultSet obc=null;
	PreparedStatement pstmt =null;	
	Statement stmtt=null;
	ResultSet rst=null;
	String visit_limit_rule		= "";
	int max_other_visits		= 0;
	int total_other_visits		= 0;
	int max_first_visits		= 0;
	int total_first_visit		= 0;
	
	
	if(clinic_type.equals("C")){
		care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}else if(clinic_type.equals("E")){
		care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
	}else if(clinic_type.equals("D")){
		care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
	}
	String res_class_desc="";
	int visit_type_cnt=0;
	
	if(res_type.equals("P")){
		res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	}else if(res_type.equals("E")){
		res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
	}else if(res_type.equals("R")){
	   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
	}else if(res_type.equals("O")){
		res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
	}
	
		
	try{
		conn = ConnectionManager.getConnection(request);
		locale = (String)session.getAttribute("LOCALE");
					
%>	
 
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onunload="clear_from_sess()">
<%
java.lang.StringBuffer strbfr_sql1=new java.lang.StringBuffer();
if(res_type.equals("P")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
}else if(res_type.equals("E")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
}else if(res_type.equals("R")){
   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
}else if(res_type.equals("O")){
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
}	
if(rs1 !=null)rs1.close();

if(res_type.equals("P")){
	sql5  = "select pract_type res_type,AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1')practname from am_practitioner where practitioner_id= ? and practitioner_id is not null" ;
	pstmt=conn.prepareStatement(sql5);
	pstmt.setString(1,locale);
	pstmt.setString(2,practid);
}else if(res_type.equals("R")){
	sql5  = "select room_type res_type,AM_GET_DESC.AM_FACILITY_ROOM(OPERATING_FACILITY_ID, room_num,?,'1')practname from am_facility_room where room_num =? and OPERATING_FACILITY_ID=? and room_num is not null";
	pstmt=conn.prepareStatement(sql5);
	pstmt.setString(1,locale);
	pstmt.setString(2,practid);
	pstmt.setString(3,facilityid);
}else{
	sql5  = "select resource_type res_type,AM_GET_DESC.AM_RESOURCE(FACILITY_ID, RESOURCE_ID,?,'1')practname from am_resource where resource_id = ? and facility_id= ? and resource_Class=? and resource_id is not null" ;
	pstmt=conn.prepareStatement(sql5);
	pstmt.setString(1,locale);
	pstmt.setString(2,practid);
	pstmt.setString(3,facilityid);
	pstmt.setString(4,res_type);
}
rs1=pstmt.executeQuery();
if(rs1!=null && rs1.next()){
	Resource_type = rs1.getString("res_type") ;
	practname = rs1.getString("practname") ;
}
if(pstmt!=null)	pstmt.close();
if(rs1 !=null)rs1.close();	
pstmt=conn.prepareStatement("select to_char(sysdate,'dd/mm/yyyy') dttm,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time from dual");
rs1=pstmt.executeQuery();
if(rs1!=null && rs1.next()){
sydate_time=rs1.getString("dttm");
sys_date_time=rs1.getString("sys_date_time");
}
if(pstmt!=null)	pstmt.close();
if(rs1 !=null)rs1.close();	
	
		pstmt=conn.prepareStatement("select speciality_code,service_code, allow_referral_yn, allow_non_referral_yn,age_group_code,long_desc  from op_clinic_lang_vw  where facility_id=?  and clinic_code =? and language_id=?");
		pstmt.setString(1,facilityid);
		pstmt.setString(2,cliniccode);
		pstmt.setString(3,locale);
		rsas=pstmt.executeQuery();
		if(rsas!=null && rsas.next()){
			clinicname=rsas.getString("long_desc");
			service_code=rsas.getString("service_code");
			allow_referral_yn = rsas.getString("allow_referral_yn");
			allow_non_referral_yn = rsas.getString("allow_non_referral_yn");
			spec_code=rsas.getString("SPECIALITY_CODE");
			age_group_code=rsas.getString("age_group_code");
			if(age_group_code==null) age_group_code="";
		}
		if(pstmt!=null){
			pstmt.close();
		}
			if(apptdate!=null && !(apptdate.equals(""))){
			stmtt=conn.createStatement();
			sql_srl_no.setLength(0);		
			
			//sql_srl_no.append("select to_char(start_time,'hh24:mi') start_time,to_char(end_time,'hh24:mi') end_time,srl_no from oa_clinic_schedule where clinic_code='"+cliniccode+"' and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_type+"' and trunc(clinic_date)=to_date('"+apptdate+"','DD/MM/YYYY') and facility_id='"+facilityid+"'   and nvl(schedule_status,'X')!='B'");
			sql_srl_no.append("select to_char(start_time,'hh24:mi') start_time,to_char(end_time,'hh24:mi') end_time,srl_no,visit_limit_rule,NVL (total_first_visit_slots_booked, 0) total_first_visit_slots_booked,NVL (max_slots_for_first_visit, 0) max_slots_for_first_visit,NVL (total_first_visit, 0) total_first_visit,NVL (max_other_visits, 0) max_other_visits,  NVL (total_follow_up, 0)+ NVL (total_routine, 0)+ NVL (total_series, 0)+ NVL (total_consult, 0)+ NVL (total_emergency, 0) total_other_visits,NVL (max_first_visits, 0) max_first_visits from oa_clinic_schedule where clinic_code='"+cliniccode+"' and care_locn_type_ind='"+clinic_type+"' and resource_class='"+res_type+"' and trunc(clinic_date)=to_date('"+apptdate+"','DD/MM/YYYY') and facility_id='"+facilityid+"'   and nvl(schedule_status,'X')!='B'");
			if(practid.equals("")){
				sql_srl_no.append(" and practitioner_id is null");
			}else{
				sql_srl_no.append(" and practitioner_id = '"+practid+"'");
			}
			rst=stmtt.executeQuery(sql_srl_no.toString());
			System.err.println("sql_srl_no.toString()=====>"+sql_srl_no.toString());
			sql_srl_no.setLength(0);
			if(rst != null && rst.next()){
				starttime=rst.getString("start_time");
				endtime=rst.getString("end_time");
				srl_no=rst.getString("srl_no");
				visit_limit_rule	= (rst.getString("visit_limit_rule")==null || rst.getString("visit_limit_rule").equals(""))?"N":rst.getString("visit_limit_rule");
				max_other_visits	= rst.getInt("max_other_visits");
				total_other_visits	= rst.getInt("total_other_visits");
				max_first_visits	= rst.getInt("max_first_visits");
				total_first_visit	= rst.getInt("total_first_visit");
			 /*
			   String sqlquery="select substr(to_date('"+apptdate+" "+totime+"','dd/mm/yyyy HH24:mi')- sysdate,0,1) diff, to_char(sysdate,'dd/mm/yyyy') toDate , to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time from dual";
			   System.err.println("sqlquery==>"+sqlquery);
			
				obc =stmtt.executeQuery(sqlquery);
				  if(obc!=null && obc.next()){
					obtm=obc.getString("diff");
					currentDate=obc.getString("toDate");
					sys_date_time=obc.getString("sys_date_time");
				}
				*/
			}
		}

		
		//book appointment
		
		
		
		
	
	
	%>
		
	    	<form name='groupApptForm' id='groupApptForm' action='../../servlet/eOA.BookAppointmentServlet' method='post' target='messageFrame'>

		
			<table border='0' cellpadding='3' cellspacing='0' width='100%' ><tr><td>

				
	<tr>
	<%
			String apptdate_display=DateUtils.convertDate(apptdate,"DMY","en",locale);
	%>
						<td  class='label' nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/>/<fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
			
					<td class='fields'  nowrap><b><%=apptdate_display%></b><input type='hidden' name='appt_date' id='appt_date' value="<%=apptdate%>" size='10' maxlength='10'>&nbsp;<input type='text' name='From_timeval' id='From_timeval' readonly value="<%=fromtime%>" size='3' maxlength='5'  onKeyUp="javascript:formatTimePerPatient(this)"> - <input type='text' name='To_timeval' id='To_timeval' value="<%=totime%>" readonly size='3' maxlength='5'  onKeyUp="javascript:formatTimePerPatient(this)"></td>
					
						<td class='label' colspan=2>&nbsp;</td>
					
			
	</tr>
	<!--<tr><td class='label' colspan=4>&nbsp;</td></tr>-->

	<tr>
			<td  class='label' nowrap width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td  class='fields'  nowrap ><b><%=care_locn_ind_desc%></b><b>/<%=clinicname%></b>
			<input type='hidden' name='clinic_name' id='clinic_name' value='<%=clinicname%>' size='15' maxlength='4'  >
			</td>

			<td  class='label' nowrap width='25%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			<td  class='fields'  nowrap ><select name = 'sel_service_code' id = 'sel_service_code'><option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
			<%

			stmt_service=conn.createStatement();
			int serviceCount = 0;
			String service_sql="select service_code,short_desc from am_service_lang_vw where language_id='"+locale+"' and eff_status='E' and service_code in(select service_code from op_clinic where clinic_code ='"+cliniccode+"' and facility_id='"+facilityid+"' union SELECT b.service_code FROM OP_CLINIC_FOR_SERVICE b WHERE b.clinic_code ='"+cliniccode+"' AND b.facility_id='"+facilityid+"')";
			rs_service=stmt_service.executeQuery(service_sql);
			while(rs_service!=null && rs_service.next()){
				serviceCount++;
				%>
			<option value="<%=rs_service.getString("service_code")%>"><%=rs_service.getString("short_desc")%></option>
			<%}		 
				%>
				<script>
					if('<%=serviceCount%>' == 1)
					   document.forms[0].sel_service_code.options[1].selected = true;
					</script>
			</select>
			</td>			
</tr>

	<!--<tr><td  colspan=4>&nbsp;</td></tr>-->
	<tr>
      		
			<td  class='label'  nowrap><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>

			<td class='fields' nowrap><select name='visit_type_short_desc' id='visit_type_short_desc'  >
			<%
			
			
			String max_appt_slots="";
			stmt_visit_type=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		    strbfr_sql1=strbfr_sql1.append("select b.short_desc ,a.visit_type_code,b.visit_type_ind,nvl(a.MAX_APPT_SLOTS,NVL((select MAX_APPT_SLOTS from op_visit_type where facility_id=a.facility_id and visit_type_code=a.visit_type_code),1)) max_appt_slots ,nvl(a.MAX_APPT_DURATION,NVL((select MAX_APPT_DURATION from op_visit_type where facility_id=a.facility_id and visit_type_code=a.visit_type_code),1)) max_appt_dur from op_visit_type_for_clinic a, op_visit_type_lang_vw b where a.facility_id='"+facilityid+"' AND a.facility_id=b.facility_id  AND a.VISIT_TYPE_CODE=b.VISIT_TYPE_CODE   AND b.LANGUAGE_ID='"+locale+"' and a.eff_status='E' and a.clinic_code='"+cliniccode+"' and b.visit_type_ind != 'E' ");
			
			//strbfr_sql1.append("SELECT short_desc, a.visit_type_code, a.visit_type_ind,NVL (b.max_appt_slots, 1) max_appt_slots,NVL (b.max_appt_duration, 1) max_appt_dur FROM op_visit_type_lang_vw a, op_visit_type_for_clinic b WHERE a.visit_type_code = '"+visit_type_ind+"' AND a.visit_type_code = b.visit_type_code AND a.facility_id = b.facility_id AND a.facility_id = '"+facilityid+"' AND b.clinic_code = '"+cliniccode+"' AND a.language_id = '"+locale+"'");
			System.out.println("strbfr_sql1.toString()==>"+strbfr_sql1.toString());
			rs1=stmt_visit_type.executeQuery(strbfr_sql1.toString());
			rs1.last();
			visit_type_cnt = rs1.getRow();
			rs1.beforeFirst();
			strbfr_sql1.setLength(0)	;
			
			if(visit_type_cnt > 1)
			{%>
			<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
			<%
			}
			while(rs1!=null && rs1.next()){
			visitcode=rs1.getString("visit_type_code");
			visitdesc=rs1.getString("short_desc");
			visitind=rs1.getString("visit_type_ind");
			max_appt_slots=rs1.getString("max_appt_slots");
			if (max_appt_slots==null) max_appt_slots="";
			int max_dur = rs1.getInt("max_appt_dur");
			if(visit_type_cnt<1)
			{%>
			<option value='<%=visitcode%>~<%=visitind%>' selected><%=visitdesc%>
			
				<script language="JavaScript">
				vis_code_Array[<%=visit_ind_count%>]		= '<%=visitcode+"~"+visitind%>';	
				max_dur_Array[<%=visit_ind_count%>]			= '<%=max_dur%>';
				max_appt_slots_Array[<%=visit_ind_count%>]  = '<%=max_appt_slots%>';
				</script>
			<%}else { 
			%>
			<option value='<%=visitcode%>~<%=visitind%>'><%=visitdesc%>
			
				<script language="JavaScript">
				vis_code_Array[<%=visit_ind_count%>]		= '<%=visitcode+"~"+visitind%>';	
				max_dur_Array[<%=visit_ind_count%>]			= '<%=max_dur%>';
				max_appt_slots_Array[<%=visit_ind_count%>]  = '<%=max_appt_slots%>';
				</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



			<%}
			visit_ind_count++;
			}
			if(rs1 !=null)rs1.close();
				%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>	

			<td  class='label'nowrap ><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>

			
			<td class='fields' nowrap><b><%=res_class_desc%>/</b><b><%=practname%></b>
				<input type='hidden' name='pame' id='pame' value='<%=practname%>' size='15' maxlength='15'  > 
				<input type='hidden' name='practitioner_name' id='practitioner_name' value='<%=practname%>' size='15' maxlength='15'  > 
			</td>
	</tr>
	<tr>				
					<td  class="label" nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
						
					<td class="fields" nowrap colspan=1><select name = 'priorty'><option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
					<option value="U"><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
					<option value="S"><fmt:message key="Common.semiurgent.label" bundle="${common_labels}"/></option>
					<option value="N"><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option></select>	
					
						
					</td>				
					
					
				</tr>
		
				<tr>
		<td class = 'label'  nowrap><fmt:message key="Common.GroupName.label" bundle="${common_labels}"/></td>
					<td  class='fields' colspan="3">
						<input type="hidden" name="group_id" id="group_id" >	
						<input type="hidden" name="min_patient" id="min_patient" id="min_patient" >
						<input type="hidden" name="max_patient" id="max_patient" id="max_patient" >	
						<input type="hidden" name="Existing_Group_Members" id="Existing_Group_Members" id="Existing_Group_Members" >
						<input type="hidden" name="group_location_id" id="group_location_id" id="group_location_id" >				
						<input type="text" name="group_name" id="group_name" id="group_name"  onblur='if(this.value!=""){callgroupname(this,document.forms[0].group_name)}else{clearValues();}'><input type="button" name="group_name_lookup" id="group_name_lookup" value="?" class="button" onclick="callgroupname(this,document.forms[0].group_name)"><img align='center' src='../../eCommon/images/mandatory.gif'></img>
						<span id="TdLocationResult"></span>
					</td>
		</tr>
		<!--<tr><td  colspan=4>&nbsp;</td></tr>-->
				<tr>
					<td class='label' width='18%'><fmt:message key="Common.ReasonForContact.label" bundle="${common_labels}"/>
</td>
					<td class='fields' nowrap width='28%'><input type="text" name="reason" id="reason" onblur="onblurcheck(this,reason,'<%=locale%>')" size='35' maxlength='30'  ><input type=hidden name='reason_for_contact' id='reason_for_contact'  size='30' maxlength='30' ></input><input type='button' class='button' value='?'  name='search_reason' id='search_reason' onClick="callReasonSearch(this,reason,'<%=locale%>');"  >
					<img id = 'reason_mand' src = '../../eCommon/images/mandatory.gif'>
					</td>	

					<td  class='label' width='23%' ><fmt:message key="Common.ReceivingDateTime.label" bundle="${common_labels}"/></td>
						
					<td class='fields' width='23%'><input type="text"  name="rec_date" id="rec_date" maxlength="16" size="13"   value='' onblur="validateDateTime(this)"><img  style="cursor:pointer" name= "dob1" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].rec_date.select();return showCalendar('rec_date',null,'hh:mm');" >						
							<input type="hidden" name="hddDTTM" id="hddDTTM" value="<%=sydate_time%>">
							<input type="hidden" name="sys_date_time" id="sys_date_time" value="<%=sys_date_time%>">
							<input type="hidden" name="hddDate" id="hddDate" value="">
							<input type="hidden" name="hddBDate" id="hddBDate" value="">
					</td>

				</tr>

<!--<tr><td  colspan=4>&nbsp;</td></tr>-->
				<tr>
                  <td  class='label'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
				
				  <td  class='fields'><input type='text' name='remarks' id='remarks' value="" size='40' maxlength='60' onblur='makeValidString(this);' ></td>

				  <td  class='label'  ><fmt:message key="Common.mode.label" bundle="${common_labels}"/></td>
					  
				   <td  class='fields'><select name='mode' id='mode' >
							<option value='E'><fmt:message key="Common.email.label" bundle="${common_labels}"/>
							<option value='T'><fmt:message key="Common.telephone.label" bundle="${common_labels}"/>
							<option value='F'><fmt:message key="Common.fax.label" bundle="${common_labels}"/>
							<option value='I' selected><fmt:message key="Common.InPerson.label" bundle="${common_labels}"/>
							<option value='W'><fmt:message key="Common.Web.label" bundle="${common_labels}"/>
							<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/>
							</select>

					</td>
				</tr>
			</table>					
			<%
			
	       
			
    		if(rs1!=null) rs1.close();
    		
    		if(rsas!=null) rsas.close();
    		
			
			
			if(stmt_visit_type !=null) stmt_visit_type.close();
			if(stmt_service !=null) stmt_service.close();

			if(pstmt!=null){
				pstmt.close();
			}


	

///// ---
}catch(Exception e){
	out.println(e);
	e.printStackTrace();
}finally{
    ConnectionManager.returnConnection(conn,request);
}

%>
	<input type='hidden' name='apptdate' id='apptdate' value='<%=apptdate%>'>
	<input type='hidden' name='practitionerid' id='practitionerid' value='<%=practid%>'>
	<input type='hidden' name='cliniccode' id='cliniccode' value='<%=cliniccode%>'>
	
	<input type='hidden' name='or_catalogue_code' id='or_catalogue_code' value='<%=or_catalogue_code%>'>
	<input type='hidden' name='order_catalog_code' id='order_catalog_code' value='<%=order_catalog_code%>'>	
	<input type="hidden" name='order_id' id='order_id' value='<%=order_id%>'>
	<input type="hidden" name='order_line_num' id='order_line_num' value='<%=order_line_num%>'>
	<input type="hidden" name="order_catalog_criteria" id="order_catalog_criteria" value ="<%=or_catalogue_code%>" >
	<input type="hidden" name="time_table_type" id="time_table_type" value ="<%=time_table_type%>" >
	<input type="hidden" name="entitlement_by_pat_cat_yn" id="entitlement_by_pat_cat_yn" value ="<%=entitlement_by_pat_cat_yn%>" >
	<input type="hidden" name="patient_id" id="patient_id" value ="<%=i_patient_id%>" >
	<input type="hidden" name="function_name" id="function_name" value ="GROUPAPPT" >
	<input type='hidden' name='style' id='style' value='<%=sStyle%>'>
	<input type="hidden" name="p_resource_class" id="p_resource_class" value ="<%=res_type%>" >
	<input type="hidden" name="max_patients_per_slab" id="max_patients_per_slab" value ="<%=max_patients_per_slab%>" >
	<input type="hidden" name="p_care_locn_type_ind" id="p_care_locn_type_ind" value ="<%=clinic_type%>" >
	<input type="hidden" name="spec_code" id="spec_code" value ="<%=spec_code%>" >
	<input type="hidden" name="calling_mode" id="calling_mode" value ="<%=calling_mode%>" >
	<input type='hidden' name='visit_limit_rule' id='visit_limit_rule' id='visit_limit_rule' value='<%=visit_limit_rule%>' />
	<input type='hidden' name='max_other_visits' id='max_other_visits' id='max_other_visits' value='<%=max_other_visits%>' />
	<input type='hidden' name='total_other_visits' id='total_other_visits' id='total_other_visits' value='<%=total_other_visits%>' />
	<input type='hidden' name='max_first_visits' id='max_first_visits' id='max_first_visits' value='<%=max_first_visits%>' />
	<input type='hidden' name='total_first_visit' id='total_first_visit' id='total_first_visit' value='<%=total_first_visit%>' />
	
	
</form>
<script>
function callgroupname(obj,target){

	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";	   
	tit=getLabel("Common.GroupName.label",'Common');
	sql ="select distinct a.group_id code, a.group_name description from oa_group_hdr a ,oa_group_dtls b where eff_status='E' and locn_code = '<%=cliniccode%>' and a.group_id=b.group_id and upper(a.group_id) like upper(?) and upper(a.group_name) like upper(?) order by 2";				
	
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = CommonLookup(tit, argumentArray);	
	if(retVal != null && retVal != "" ) {
              var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
	    document.forms[0].group_name.value=arr[1];	
	    document.forms[0].group_id.value=arr[0];	
		callGroupLocation(arr[0])
	   // document.getElementById("PatientSearchContainer").style.display="inline";
          } else {
        	  clearValues();
    }
}

function callGroupLocation(GroupId){  
	var apptdate	=  document.forms[0].appt_date.value;
	var fromtime	=  document.forms[0].From_timeval.value;
	var totime		=  document.forms[0].To_timeval.value;
	var cliniccode	=  document.forms[0].cliniccode.value;
	var practitionerid	=  document.forms[0].practitionerid.value;
	 $.ajax({  
      url:'../../eOA/jsp/GetGroupLocation.jsp',  
      type:'post',  
      data:{'GroupId':GroupId,'apptdate':apptdate,'fromtime':fromtime,'totime':totime,'cliniccode':cliniccode,'practitionerid':practitionerid,'action':'get_slap_overlap_count','action1':'get_available_slaps_count'},
      dataType: 'json',
      success: function(data) {  
     	 if(data.isJsonResults==1){
     		var ResultString	= "";     		
     		ResultString+="<span style='margin-left:10px;'class='label'>"+getLabel('Common.MIN.label','Common')+" "+getLabel('Common.patient.label','Common')+" : "+data.MIN_PATIENTS+"</span>";
     		ResultString+="<span style='margin-left:10px;' class='label'>"+getLabel('Common.Max.label','Common')+" "+getLabel('Common.patient.label','Common')+" : "+data.MAX_PATIENTS+"</span>";
     		if(data.TotMemberInGroup > 0){
     			ResultString+="<span style='margin-left:10px;' class='label'>"+getLabel('eOA.TotalPatientsLinkedInGroup.label','OA')+" : "+data.TotMemberInGroup+"</span>";
     		}
     		$("#min_patient").val(data.MIN_PATIENTS);
     		$("#max_patient").val(data.MAX_PATIENTS);
     		$("#Existing_Group_Members").val(data.TotMemberInGroup);
     		$("#group_location_id").val(data.LOCN_CODE);
     		$("#TdLocationResult").html(ResultString);
     		var Available_Slabs	= data.AVAILABLE_SLAP_COUNT;
			if(data.TotMemberInGroup < data.MIN_PATIENTS){		
			   var error = getMessage("PAT_ASSGRP_LESS_MINPAT","OA")
				// error = error.replace("$",data.TotMemberInGroup)
				// error = error.replace("#",data.MIN_PATIENTS)
			     alert(error)
			     clearValues();
			   return false;
		   }
		   if(Available_Slabs < data.TotMemberInGroup && Available_Slabs > 0){
				var error = getMessage("PATCNT_GREAT_SLOTS","OA");
				// error = error.replace("$",data.TotMemberInGroup)
				// error = error.replace("#",Available_Slabs)
				 alert(error)
				 clearValues();
				 return false;
		   }

		   
		   if(data.SLAP_OVERLAP_COUNT > 0){
			   alert(getMessage("APPT_OVERLAP","OA"));
		   }
     	 }
      } ,
      error: function(jqXHR, textStatus, errorThrown) {
          alert("incoming Text " + jqXHR.responseText);
      }
  });  
}

function clearValues(){
	document.forms[0].group_name.value = "";	
	$("#min_patient").val("");
	$("#max_patient").val("");
	$("#Existing_Group_Members").val("");
	$("#group_location_id").val("");
	$("#TdLocationResult").html("");
	//parent.frames[2].location.href = "../../eCommon/html/blank.html";
}
</script>
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

</body>
</html>

 


