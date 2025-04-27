<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>   
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
<script language='javascript' src="../../eOA/js/RuleBasedSchAppointment.js"></script>
<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
</script>
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");		
		String speciality_code="";		
		String practitioner_name=request.getParameter("practitioner_name")==null?"":request.getParameter("practitioner_name");		
		String clinic_name="";		
		String tfr_appt_across_catg_yn=request.getParameter("tfr_appt_across_catg_yn")==null?"":request.getParameter("tfr_appt_across_catg_yn");	
		String apptrefno=request.getParameter("apptrefno")==null?"":request.getParameter("apptrefno");		
		String cliniccode1="";		
		String practitionerid="";		
		String apptdate="";		
		String overbookedyn=request.getParameter("overbookedyn")==null?"":request.getParameter("overbookedyn");		
		String apptslabfromtime=request.getParameter("apptslabfromtime")==null?"":request.getParameter("apptslabfromtime");		
		String apptslabtotime=request.getParameter("apptslabtotime")==null?"":request.getParameter("apptslabtotime");		
		String appt_day1=request.getParameter("appt_day1")==null?"":request.getParameter("appt_day1");		
		String visit_type_ind=request.getParameter("visit_type_ind")==null?"":request.getParameter("visit_type_ind");		
		String team_id="";		
		String forced=request.getParameter("forced")==null?"":request.getParameter("forced");		
		String rsClass="";		
		String locnType="";		
		int no_of_slots_value=0;		
		String patient_id="";		
		String old_visit_type_ind="";
		String time_table_type="";
		String term_set_id ="";
		String linking_code = "";
		String language_code = "";
		Connection con=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;	 
		String splty_short_desc ="";
		String splty_code ="";
		//out.println("apptrefno :"+apptrefno);	
		String sys_date="";
		String order_catalog_code ="";
			
		try{
			Properties p =(Properties)session.getValue("jdbc");
			con=ConnectionManager.getConnection(request);
			String facilityid =(String)session.getValue("facility_id");
			String login_user = (String)p.getProperty("login_user");
			//out.println("facilityid :"+facilityid);	
			String sql="select a.speciality_code,a.CARE_LOCN_TYPE_IND,a.CLINIC_CODE,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.CLINIC_CODE,?,'1') clinic_name,a.PRACTITIONER_ID,TO_CHAR (a.appt_date, 'dd/mm/rrrr') appt_date,a.RESOURCE_CLASS,a.patient_id,b.visit_type_ind,a.no_of_slots,a.time_table_type,a.TERM_SET_ID,a.TERM_CODE,a.LANGUAGE_ID,a.TEAM_ID,TO_CHAR (sysdate, 'dd/mm/rrrr')sys_date,ORDER_CATALOG_CODE from oa_appt a, op_visit_type b where a.facility_id = ? and a.appt_ref_no=? and b.facility_id = a.facility_id and b.visit_type_code = a.appt_type_code ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,localeName);
			pstmt.setString(2,facilityid);
			pstmt.setString(3,apptrefno);
			rs = pstmt.executeQuery();
			while (rs !=null && rs.next()){
				speciality_code	 = rs.getString("speciality_code")==null?"":rs.getString("speciality_code");
				locnType 			= rs.getString("CARE_LOCN_TYPE_IND")==null?"":rs.getString("CARE_LOCN_TYPE_IND");
				cliniccode1 		= rs.getString("CLINIC_CODE")==null?"":rs.getString("CLINIC_CODE");
				clinic_name 		= rs.getString("clinic_name")==null?"":rs.getString("clinic_name");
				practitionerid 		= rs.getString("PRACTITIONER_ID")==null?"":rs.getString("PRACTITIONER_ID");
				apptdate	 		= rs.getString("appt_date")==null?"":rs.getString("appt_date");
				rsClass		 		= rs.getString("RESOURCE_CLASS")==null?"":rs.getString("RESOURCE_CLASS");
				old_visit_type_ind 	= rs.getString("visit_type_ind");
				no_of_slots_value	= rs.getInt("no_of_slots");
				patient_id			= rs.getString("patient_id")==null?"":rs.getString("patient_id");
				time_table_type 	= rs.getString("time_table_type")==null?"":rs.getString("time_table_type");
				term_set_id 		= rs.getString("TERM_SET_ID")==null?"":rs.getString("TERM_SET_ID");
				linking_code 		= rs.getString("TERM_CODE")==null?"":rs.getString("TERM_CODE");
				language_code 		= rs.getString("LANGUAGE_ID")==null?"":rs.getString("LANGUAGE_ID");
				team_id				= rs.getString("TEAM_ID")==null?"":rs.getString("TEAM_ID");
				sys_date			= rs.getString("sys_date")==null?"":rs.getString("sys_date");
				sys_date			= (DateUtils.convertDate(sys_date,"DMY","en",localeName));			
				order_catalog_code	= rs.getString("ORDER_CATALOG_CODE")==null?"":rs.getString("ORDER_CATALOG_CODE");				
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			//String  sql3="Select clinic_code from op_clinic a, am_locn_for_oper_stn b where  a.facility_id=? and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn ='Y' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id =(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id=? AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id =? AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E'";
			String specialtySQL="Select distinct c.speciality_code,am_get_desc.AM_SPECIALITY(c.speciality_code,?,2) short_desc from op_clinic a, am_locn_for_oper_stn b,am_speciality c where  a.facility_id=? and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn ='Y' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id =(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id=? AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id =? AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.speciality_code = c.speciality_code and c.EFF_STATUS = 'E' order by short_desc";			

			
%>
<form name='RuleBasedTransfer_criteria' id='RuleBasedTransfer_criteria'>
<br/>
<table  border='0' cellpadding='0' cellspacing='0' width='50%' align='center'>
<tr>
<td class='label'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
<td class='querydata'><select name='specialty' id='specialty' tabindex=0 onchange = 'specialtyChange()'><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----
<%
	pstmt=con.prepareStatement(specialtySQL);
	pstmt.setString(1,localeName);
	pstmt.setString(2,facilityid);
	pstmt.setString(3,facilityid);
	pstmt.setString(4,login_user);
	rs = pstmt.executeQuery();
	while (rs !=null && rs.next()){
		splty_short_desc=rs.getString("short_desc");
		splty_code=rs.getString("speciality_code");
		if(speciality_code.equals(splty_code)){%>
			<option value='<%=splty_code%>' selected><%=splty_short_desc%>
		<%}else{%>
			<option value='<%=splty_code%>'><%=splty_short_desc%>
		<%}
	}
%>
</td>
</tr>
<tr>
<td nowrap class=label ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
<td class='fields'>
	<select name='locn_type' id='locn_type' onchange='locnChange()' nowrap disabled>
		<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		<%
			if(pstmt!=null)	pstmt.close();
			if(rs!=null)	rs.close();
			pstmt=con.prepareStatement("select locn_type, am_get_desc.am_care_locn_type(locn_type,?,2) short_desc, CARE_LOCN_TYPE_IND from am_care_locn_type where SYS_USER_DEF_IND='S' and locn_type in ('C','E','Y') order by short_desc");
			pstmt.setString(1,localeName);
			rs=pstmt.executeQuery();
			while(rs!=null && rs.next()) {
				if(locnType.equals(rs.getString("CARE_LOCN_TYPE_IND"))){%>
				<option value='<%=rs.getString("CARE_LOCN_TYPE_IND")%>' selected ><%=rs.getString("short_desc")%>
			<%}else{%>
				<option value='<%=rs.getString("CARE_LOCN_TYPE_IND")%>'><%=rs.getString("short_desc")%>
			<%}
			}
		%>
	</select>
</td>
</tr>
<tr>
<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
<td class='fields'><input type='text' size='25' maxlength='25' name='b_loc_val' id='b_loc_val' value='<%=clinic_name%>' onblur="ena_loc_lookup_rule(this);"><input type="hidden" name="clinic" id="clinic" value='<%=cliniccode1%>' ><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup_rule();" class='button'></td>
</tr>
<tr>
<td class='label'><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></td>
<td class='fields'><input type='text' name='pref_date' id='pref_date' size='10' maxlength='10' value='' onBlur="validDateObj(this,'DMY',localeName);checkDateAlert(this);"><img id='frm_img' style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('pref_date');">&nbsp;<input type='text' name='From_timeval' id='From_timeval' value='' size='3' maxlength='5' onBlur='CheckTime(this,"FM")' onKeyUp="javascript:formatTimePerPatient(this)" > - <input type='text' name='To_timeval' id='To_timeval' size='3' maxlength='5'  value='' onBlur='CheckTime(this,"TO")' onKeyUp="javascript:formatTimePerPatient(this)"><img src='../../eCommon/images/mandatory.gif' align='center'></img></span>
</td>
</tr>
</table>
<br/>
<table  border='0' cellpadding='0' cellspacing='0' width='50%' align='center'>
<tr>
<td align='center' class='button'><input type='button' name='search' id='search' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='getRuleBasedResult()'>&nbsp;<input type='button' name='clear' id='clear' class='button' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick='clearFields()'></td>
<tr>
</table>
<input type='hidden' name='speciality_code' id='speciality_code' value='<%=speciality_code%>'>
<input type='hidden' name='practitioner_name' id='practitioner_name' value='<%=practitioner_name%>'>
<input type='hidden' name='clinic_name' id='clinic_name' value='<%=clinic_name%>'>
<input type='hidden' name='tfr_appt_across_catg_yn' id='tfr_appt_across_catg_yn' value='<%=tfr_appt_across_catg_yn%>'>
<input type='hidden' name='apptrefno' id='apptrefno' value='<%=apptrefno%>'>
<input type='hidden' name='cliniccode' id='cliniccode' value='<%=cliniccode1%>'>
<input type='hidden' name='practitionerid' id='practitionerid' value='<%=practitionerid%>'>
<input type='hidden' name='apptdate' id='apptdate' value='<%=apptdate%>'>
<input type='hidden' name='overbookedyn' id='overbookedyn' value='<%=overbookedyn%>'>
<input type='hidden' name='apptslabfromtime' id='apptslabfromtime' value='<%=apptslabfromtime%>'>
<input type='hidden' name='apptslabtotime' id='apptslabtotime' value='<%=apptslabtotime%>'>
<input type='hidden' name='appt_day' id='appt_day' value='<%=appt_day1%>'>
<input type='hidden' name='visit_type_ind' id='visit_type_ind' value='<%=old_visit_type_ind%>'>
<input type='hidden' name='team_id' id='team_id' value='<%=team_id%>'>
<input type='hidden' name='forced' id='forced' value='<%=forced%>'>
<input type='hidden' name='rsClass' id='rsClass' value='<%=rsClass%>'>
<input type='hidden' name='locnType' id='locnType' value='<%=locnType%>'>
<input type='hidden' name='no_of_slots_value' id='no_of_slots_value' value='<%=no_of_slots_value%>'>
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type='hidden' name='time_table_type' id='time_table_type' value='<%=time_table_type%>'>
<input type='hidden' name='term_set_id' id='term_set_id' value='<%=term_set_id%>'>
<input type='hidden' name='linking_code' id='linking_code' value='<%=linking_code%>'>
<input type='hidden' name='language_code' id='language_code' value='<%=language_code%>'>
<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>
<input type='hidden' name='order_catalog_code' id='order_catalog_code' value='<%=order_catalog_code%>'>

</form>
</body>
	<%}catch(Exception e ){
		e.printStackTrace();
	}finally{	
		ConnectionManager.returnConnection(con,request);
	}%>
</html>

