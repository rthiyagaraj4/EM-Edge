<!--Created by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");

	String display_message = checkForNull(request.getParameter("display_message"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));
	String location_code = checkForNull(request.getParameter("location_code"));
	String speciality_code = checkForNull(request.getParameter("speciality_code"));
	String practitioner_id = checkForNull(request.getParameter("practitioner_id"));
	String practitioner_type = checkForNull(request.getParameter("practitioner_type"));
	String gender = checkForNull(request.getParameter("gender"));
	String date_of_birth = checkForNull(request.getParameter("date_of_birth"));
	String visit_adm_date_time = checkForNull(request.getParameter("visit_adm_date_time"));
	String bed_num = checkForNull(request.getParameter("bed_num"));
	String room_num = checkForNull(request.getParameter("room_num"));
	String patient_class = checkForNull(request.getParameter("patient_class"));
	String location_type = checkForNull(request.getParameter("location_type"));
%>
<html>
<head>

	<title><fmt:message key="Common.Alert.label" bundle="${common_labels}"/></title>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	  
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	
	<script>
	
	window.onload = function() {
		document.getElementById("recorddiag").focus();
	};

	async function callRecordDiag()
	{
		var facility_id = document.DisplayDiagValidationMsgForm.facility_id.value;
		var patient_id = document.DisplayDiagValidationMsgForm.patient_id.value;
		var encounter_id = document.DisplayDiagValidationMsgForm.encounter_id.value;
		var speciality_code = document.DisplayDiagValidationMsgForm.speciality_code.value;
		var practitioner_type = document.DisplayDiagValidationMsgForm.practitioner_type.value;
		var practitioner_id = document.DisplayDiagValidationMsgForm.practitioner_id.value;
		var date_of_birth = document.DisplayDiagValidationMsgForm.date_of_birth.value;
		var gender = document.DisplayDiagValidationMsgForm.gender.value;
		var bed_num = document.DisplayDiagValidationMsgForm.bed_num.value;
		var location_code = document.DisplayDiagValidationMsgForm.location_code.value;
		var patient_class = document.DisplayDiagValidationMsgForm.patient_class.value;
		var room_num = document.DisplayDiagValidationMsgForm.room_num.value;
		var visit_adm_date_time = document.DisplayDiagValidationMsgForm.visit_adm_date_time.value;
		var location_type = document.DisplayDiagValidationMsgForm.location_type.value;
		var function_id = "RECORD_DIAGNOSIS_FROM_POPUP";
		var episode_type = "";
		var ip_yn = "N";

		if(patient_class == "OP") episode_type =  "O";
		if(patient_class == "IP") episode_type =  "I";
		if(patient_class == "DC") episode_type =  "D";
		if(patient_class == "EM") episode_type =  "E";

		if(patient_class == "IP" || patient_class == "DC") ip_yn =  "Y";

		var jsp_name = "";
		jsp_name = "../../eMR/jsp/RecDiagnosis.jsp?modal_yn=Y&IP_YN="+ip_yn+"&speciality_code="+speciality_code+"&practitioner_type="+practitioner_type+"&practitioner_id="+practitioner_id+"&Dob="+date_of_birth+"&Sex="+gender+"&bed_num="+bed_num+"&encounter_id="+encounter_id+"&episode_id="+encounter_id+"&episode_type="+episode_type+"&location_code="+location_code+"&location_type="+location_type+"&patient_class="+patient_class+"&patient_id="+patient_id+"&room_num="+room_num+"&visit_adm_date="+visit_adm_date_time+"&function_id="+function_id+"&FacilityId="+facility_id;

		var retVal = new String();
		var dialogHeight = "70vh";
		var dialogWidth = "75vw";
		var dialogTop = "72";
		var status = "no";
		var arguments = "";
		var features = "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		
		retVal = await window.showModalDialog(jsp_name,arguments,features);

		window.close();
    }

	</script>

</head>

<body onKeyDown='lockKey();'>

	<form name='DisplayDiagValidationMsgForm' id='DisplayDiagValidationMsgForm'>

		<table width="100%" align = "center"  border='0' cellpadding='0' cellspacing='0'>

			<tr><td width="20%">&nbsp;</td></tr>

			<tr>
				<td width="100%" align = "center" colspan='5'>
					<%if(display_message.equals("PRISECNR")){%>
						<fmt:message key="eMR.DiagNotRecWithPriSecDiagClass.label" bundle="${mr_labels}"/>
					<%}else if(display_message.equals("PRINR")){%>
						<fmt:message key="eMR.DiagNotRecWithPriDiagClass.label" bundle="${mr_labels}"/>
					<%}else if(display_message.equals("SECNR")){%>
						<fmt:message key="eMR.DiagNotRecWithSecDiagClass.label" bundle="${mr_labels}"/>
					<%}%>
				</td>
			</tr>

			<tr><td width="20%">&nbsp;</td></tr>
			<tr><td width="20%">&nbsp;</td></tr>

			<tr>
				<td width="20%">&nbsp;</td>

				<td width="20%" class='fields' align = "center">
					<input type='button' class="button" id='cancelalert' name='cancelalert' id='cancelalert' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="window.close();"></input>
				</td>

				<td width="20%">&nbsp;</td>
				
				<td width="20%" class='fields' align = "center">
					<input type='button' class="button" id='recorddiag' name='recorddiag' id='recorddiag' value='<fmt:message key="eMR.RecordDiagnosis.label" bundle="${mr_labels}"/>' onClick="callRecordDiag();"></input>
				</td>

				<td width="20%">&nbsp;</td>
			</tr>

		</table>

		<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		<input type="hidden" name="location_code" id="location_code" value="<%=location_code%>">
		<input type="hidden" name="speciality_code" id="speciality_code" value="<%=speciality_code%>">
		<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
		<input type="hidden" name="practitioner_type" id="practitioner_type" value="<%=practitioner_type%>">
		<input type="hidden" name="gender" id="gender" value="<%=gender%>">
		<input type="hidden" name="date_of_birth" id="date_of_birth" value="<%=date_of_birth%>">
		<input type="hidden" name="visit_adm_date_time" id="visit_adm_date_time" value="<%=visit_adm_date_time%>">
		<input type="hidden" name="bed_num" id="bed_num" value="<%=bed_num%>">
		<input type="hidden" name="room_num" id="room_num" value="<%=room_num%>">
		<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
		<input type="hidden" name="location_type" id="location_type" value="<%=location_type%>">

	</form>
</body>
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

