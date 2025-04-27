<!--Created by Ashwini on 05-Apr-2024 for ML-MMOH-CRF-2060-->
<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,org.json.simple.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"> </script>
<script language="javascript" src="../../eOA/js/MultiSelectionApptRescheduling.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='JavaScript' src='../../eCommon/js/showModalDialog.js' ></script>

<%
request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

Connection con = null;

int init = 0;
String classValue = "OAQRYEVEN";
String srl_no = "";
String pri_appt_ref_no = "";
String previous_appt_ref_no = "";
String slot_slab_start_time = "";
String slot_slab_end_time = "";
String patient_id = "";
String patient_name = "";
String gender = "";
String visit_type_desc = "";
String visit_type_ind = "";
String reason_for_contact = "";
String no_of_slots = "";
String selCheckboxValue = "";
String selCheckboxAttr = "";
String selCheckboxEnDis = "";
String selCheckboxVisibility = "visible";

try{
	con = ConnectionManager.getConnection(request);

	String locale = (String)session.getAttribute("LOCALE");
	String fac_id = (String) session.getValue( "facility_id" );

	String locn_type = request.getParameter("locn_type");
	if(locn_type ==null) locn_type="";

	String from_speciality = request.getParameter("from_speciality");
	if(from_speciality ==null) from_speciality="";

	String from_locn = request.getParameter("from_locn");
	if(from_locn ==null) from_locn="";

	String from_resc = request.getParameter("from_resc");
	if(from_resc ==null)from_resc="";

	String from_date = request.getParameter("from_date");
	if(from_date ==null) from_date="";

	String from_res_class = request.getParameter("from_res_class");
	if(from_res_class ==null) from_res_class="";

	String to_speciality = request.getParameter("to_speciality");
	if(to_speciality ==null) to_speciality="";

	String to_locn = request.getParameter("to_locn");
	if(to_locn ==null) to_locn="";

	String to_resc = request.getParameter("to_resc");
	if(to_resc ==null)to_resc="";

	String to_date = request.getParameter("to_date");
	if(to_date ==null) to_date="";

	String to_res_class = request.getParameter("to_res_class");
	if(to_res_class ==null) to_res_class="";

	String visit_limit_rule = request.getParameter("visit_limit_rule");
	if(visit_limit_rule ==null) visit_limit_rule="N";
%>

</head>

<body OnMouseDown='CodeArrest();' onKeyDown='lockKey()'>

<form name="MultiSelectionApptReschResult1Form" id="MultiSelectionApptReschResult1Form">

<table border="1" width="100%" cellspacing='0' cellpadding='0' id='results1'>

<tr>
	<th class='COLUMNHEADER' ><div  id='head1' class='myClass'><fmt:message key="Common.Select.label" bundle="${common_labels}"/></div></th>
	<th class='COLUMNHEADER' ><div  id='head1' class='myClass'><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></div></th>
	<th class='COLUMNHEADER'  ><div  id='head2' width='12%' class='myClass'><fmt:message key="Common.totime.label" bundle="${common_labels}"/></div></th>
	<th class='COLUMNHEADER' ><div  id='head3'  class='myClass'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></div></th>
	<th class='COLUMNHEADER'  ><div  id='head4' width='12%' class='myClass'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></div></th>
	<th class='COLUMNHEADER' ><div  id='head5' class='myClass'><fmt:message key="Common.ReasonForContact.label" bundle="${common_labels}"/></div></th>
</tr>

<%

JSONArray ArrJSONSch = new JSONArray();
ArrJSONSch  = getFromSchedule(con,locale,fac_id,locn_type,from_locn,from_res_class,from_resc,from_date);	

for(int i = 0 ; i < ArrJSONSch.size() ; i++) 
{
	JSONObject jsonObjSch = (JSONObject)ArrJSONSch.get(i);

	srl_no = (String) jsonObjSch.get("srl_no");
	pri_appt_ref_no = (String) jsonObjSch.get("pri_appt_ref_no");

	if(pri_appt_ref_no.equals("")){
		selCheckboxValue = "N";
		selCheckboxAttr = "";
		selCheckboxEnDis = "Disabled";
	}else{
		selCheckboxValue = "Y";
		selCheckboxAttr = "Checked";
		selCheckboxEnDis = "";
	}

	if(previous_appt_ref_no.equals(pri_appt_ref_no) && !pri_appt_ref_no.equals("")){
		selCheckboxValue = "N";
		selCheckboxAttr = "";
		selCheckboxEnDis = "Disabled";
		selCheckboxVisibility = "hidden";
	}else{
		previous_appt_ref_no = pri_appt_ref_no;
		selCheckboxVisibility = "visible";
	}

	slot_slab_start_time = (String) jsonObjSch.get("slot_slab_start_time");
	slot_slab_end_time = (String) jsonObjSch.get("slot_slab_end_time");

	patient_id = (String) jsonObjSch.get("patient_id");

	if(patient_id.equals("")){
		patient_id="";
	}else{
		patient_id=patient_id+", ";
	}

	patient_name = (String) jsonObjSch.get("patient_name");
	gender = (String) jsonObjSch.get("gender");
	visit_type_desc = (String) jsonObjSch.get("visit_type_desc");
	visit_type_ind = (String) jsonObjSch.get("visit_type_ind");
	reason_for_contact = (String) jsonObjSch.get("reason_for_contact");
	no_of_slots = (String) jsonObjSch.get("no_of_slots");

%>
	<tr>

		<td width="10%" nowrap class="<%=classValue%>" align="center"><input type='checkbox' name='select_check_<%=init%>' onClick='checkbox_value(this)' value = "<%=selCheckboxValue%>" <%=selCheckboxAttr%> <%=selCheckboxEnDis%> style='visibility:<%=selCheckboxVisibility%>'>&nbsp;<%=srl_no%></td>

		<!--<td width="10%" nowrap class="<%=classValue%>" align="center"><input type='checkbox' name='select_check_<%=init%>' onClick='checkbox_value(this)' value = "<%=selCheckboxValue%>" <%=selCheckboxAttr%> <%=selCheckboxEnDis%> style='visibility:<%=selCheckboxVisibility%>'></td>-->

		<td width="10%" nowrap class="<%=classValue%>"><%=slot_slab_start_time%></td>

		<td width="10%" nowrap class="<%=classValue%>"><%=slot_slab_end_time%></td>

		<%if(!patient_name.equals("")){%>
		<td width='23%' nowrap class="<%=classValue%>"><%=patient_id%><%=patient_name%>,&nbsp;<%=gender%></td>
		<%}else{%>
		<td width='23%' class="<%=classValue%>">&nbsp;</td>
		<%}%>

		<%if(!visit_type_desc.equals("")){%>
		<td width='13%' nowrap class="<%=classValue%>"><%=visit_type_desc%></td>
		<%}else{%>
		<td width='13%' class="<%=classValue%>">&nbsp;</td>
		<%}%>

		<%if(!reason_for_contact.equals("")){%>
		<td width='23%' nowrap class="<%=classValue%>"><%=reason_for_contact%></td>
		<%}else{%>
		<td width='23%' class="<%=classValue%>">&nbsp;</td>
		<%}%>

		<input type='hidden' name='from_srl_no_<%=init%>' value='<%=srl_no%>'>
		<input type='hidden' name='from_appt_ref_no_<%=init%>' value='<%=pri_appt_ref_no%>'>
		<input type='hidden' name='from_visit_type_ind_<%=init%>' value='<%=visit_type_ind%>'>
		<input type='hidden' name='no_of_slots_<%=init%>' value='<%=no_of_slots%>'>

	</tr>
<%

	init++;
}
%>

</table>

<input type='hidden' name='total_from_slot_count' id='total_from_slot_count'  value='<%=init%>'>

</form>

<%

}catch(Exception es){
	es.printStackTrace();
}
finally { 
	ConnectionManager.returnConnection(con,request);
}

%>

</body>
</html>

<%!
public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static JSONArray getFromSchedule(Connection con, String locale, String fac_id, String locn_type, String from_locn, String from_res_class, String from_resc, String from_date) throws Exception{
	
	PreparedStatement pstmt = null;
	ResultSet rs 			= null;
	JSONArray ArrJSONSch	= new JSONArray();

	try{

		StringBuffer sql_label = new StringBuffer();

		sql_label.append("SELECT a.srl_no, a.pri_appt_ref_no, TO_CHAR (a.slot_slab_start_time, 'hh24:mi') AS slot_slab_start_time, TO_CHAR (a.slot_slab_end_time, 'hh24:mi') AS slot_slab_end_time, NVL (b.no_of_slots, 0) no_of_slots, b.patient_id, NVL (b.patient_name_loc_lang, b.patient_name) AS patient_name, DECODE (b.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown' ) AS gender, (SELECT short_desc visit_type FROM op_visit_type_lang_vw WHERE visit_type_code = b.appt_type_code AND ROWNUM = 1) AS visit_type_desc, (SELECT visit_type_ind FROM op_visit_type_lang_vw WHERE visit_type_code = b.appt_type_code AND ROWNUM = 1) AS visit_type_ind, am_get_desc.am_contact_reason (b.contact_reason_code, ?, 1 ) AS reason_for_contact FROM oa_clinic_schedule_slot_slab a LEFT JOIN oa_appt b ON a.pri_appt_ref_no = b.appt_ref_no and a.facility_id = b.facility_id WHERE a.facility_id = ? AND a.care_locn_type_ind = ? AND a.clinic_code = ? AND a.resource_class = ? AND a.clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND ");

		if(from_resc.equals("")){
			sql_label.append("a.practitioner_id is null");
		}else{
			sql_label.append("a.practitioner_id = ?");
		}

		pstmt = con.prepareStatement(sql_label.toString());

		pstmt.setString(1,locale);
		pstmt.setString(2,fac_id);
		pstmt.setString(3,locn_type);
		pstmt.setString(4,from_locn);
		pstmt.setString(5,from_res_class);
		pstmt.setString(6,from_date);
		
		if(!from_resc.equals("")){
			pstmt.setString(7,from_resc);
		}

		rs = pstmt.executeQuery();

		while( rs != null && rs.next() ){

			JSONObject jsonObjSch = new JSONObject();

			String srl_no = rs.getString("srl_no")==null?"":rs.getString("srl_no");
			String pri_appt_ref_no = rs.getString("pri_appt_ref_no")==null?"":rs.getString("pri_appt_ref_no");
			String slot_slab_start_time	= rs.getString("slot_slab_start_time")==null?"":rs.getString("slot_slab_start_time");
			String slot_slab_end_time = rs.getString("slot_slab_end_time")==null?"":rs.getString("slot_slab_end_time");
			String patient_id = rs.getString("patient_id")==null?"":rs.getString("patient_id");
			String patient_name = rs.getString("patient_name")==null?"":rs.getString("patient_name");
			String gender = rs.getString("gender")==null?"":rs.getString("gender");
			String visit_type_desc = rs.getString("visit_type_desc")==null?"":rs.getString("visit_type_desc");
			String visit_type_ind = rs.getString("visit_type_ind")==null?"":rs.getString("visit_type_ind");
			String reason_for_contact = rs.getString("reason_for_contact")==null?"":rs.getString("reason_for_contact");
			String no_of_slots = rs.getString("no_of_slots")==null?"":rs.getString("no_of_slots");
			
			jsonObjSch.put("srl_no",srl_no);
			jsonObjSch.put("pri_appt_ref_no",pri_appt_ref_no);
			jsonObjSch.put("slot_slab_start_time",slot_slab_start_time);
			jsonObjSch.put("slot_slab_end_time",slot_slab_end_time);
			jsonObjSch.put("patient_id",patient_id);
			jsonObjSch.put("patient_name",patient_name);
			jsonObjSch.put("gender",gender);
			jsonObjSch.put("visit_type_desc",visit_type_desc);
			jsonObjSch.put("visit_type_ind",visit_type_ind);
			jsonObjSch.put("reason_for_contact",reason_for_contact);
			jsonObjSch.put("no_of_slots",no_of_slots);

			ArrJSONSch.add(jsonObjSch);
		}
		
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		try{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}catch(Exception ex){
			System.err.println("Exception in getFromSchedule - "+ex.getMessage());
			ex.printStackTrace();
		}
	}
	return ArrJSONSch;
}
%>