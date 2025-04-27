<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"  %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script> 
	<script src='../../eMR/js/MRAuditParam.js' language='javascript'>
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");

	String operation="modify";
	Connection conn = null;
	Statement stmt=null;    
	ResultSet rset=null;

	try
	{
		conn = ConnectionManager.getConnection(request);
 /*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
	boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","MLC_TO_MEDICO_LEGAL_CASE");
	/*end ML-MMOH-CRF-0354 [IN057191] */
	

		stmt = conn.createStatement();

		String sql = "select * from MR_DEATH_REG_AUDIT_TRIAL_PARAM";

		rset = stmt.executeQuery(sql);

		String general_details_hist_val = "";
		String attending_practitioner_hist_val = "";
		String auth_practitioner_hist_val = "";
		String brought_dead_hist_val = "";
		String diagnosis_details_hist_val = "";
		String seq_no_hist_val = "";
		String add_diagnosis_hist_val = "";
		String moved_from_gen_to_cod_hist_val = "";
		String moved_from_cod_to_oth_hist_val = "";
		String moved_from_oth_to_cod_hist_val = "";
		String cause_of_death_remarks_hist_val = "";
		String moved_from_cod_to_gen_hist_val = "";
		String moved_from_gen_to_oth_hist_val = "";
		String onset_date_hist_val = "";
		String moved_from_oth_to_gen_hist_val = "";
		String female_patient_details_hist_val = "";
		String mlc_patient_details_hist_val = "";
		String medical_legal_case_hist_val = "";
		String pol_rep_no_hist_val = "";
		String pol_stn_id_hist_val = "";
		String pol_id_hist_val = "";
		String print_details_hist_val = "";

		String general_details_hist_chk = "";
		String attending_practitioner_hist_chk = "";
		String auth_practitioner_hist_chk = "";
		String brought_dead_hist_chk = "";
		String diagnosis_details_hist_chk = "";
		String seq_no_hist_chk = "";
		String add_diagnosis_hist_chk = "";
		String moved_from_gen_to_cod_hist_chk = "";
		String moved_from_oth_to_cod_hist_chk = "";
		String cause_of_death_remarks_hist_chk = "";
		String moved_from_cod_to_gen_hist_chk = "";
		String moved_from_cod_to_oth_hist_chk = "";
		String moved_from_oth_to_gen_hist_chk = "";
		String female_patient_details_hist_chk = "";
		String moved_from_gen_to_oth_hist_chk = "";
		String mlc_patient_details_hist_chk = "";
		String medical_legal_case_hist_chk = "";
		String pol_rep_no_hist_chk = "";
		String pol_stn_id_hist_chk = "";
		String pol_id_hist_chk = "";
		String print_details_hist_chk = "";
		String onset_date_hist_chk = "";


		String general_chk = "";
		String diagnosis_chk = "";
		String mlc_chk = "";


		if(rset.next())
		{

			general_details_hist_val=checkForNull(rset.getString("general_details_hist_yn"));
			attending_practitioner_hist_val=checkForNull(rset.getString("attending_practitioner_hist_yn"));
			auth_practitioner_hist_val=checkForNull(rset.getString("auth_practitioner_hist_yn"));
			brought_dead_hist_val=checkForNull(rset.getString("brought_in_dead_hist_yn"));
			diagnosis_details_hist_val=checkForNull(rset.getString("diagnosis_details_hist_yn"));
			seq_no_hist_val=checkForNull(rset.getString("seq_no_hist_yn"));
			add_diagnosis_hist_val=checkForNull(rset.getString("add_diagnosis_hist_yn"));
			moved_from_gen_to_cod_hist_val=checkForNull(rset.getString("moved_from_gen_to_cod_hist_yn"));
			moved_from_cod_to_oth_hist_val=checkForNull(rset.getString("moved_from_cod_to_oth_hist_yn"));
			moved_from_gen_to_cod_hist_val=checkForNull(rset.getString("moved_from_gen_to_cod_hist_yn"));
			moved_from_oth_to_cod_hist_val=checkForNull(rset.getString("moved_from_oth_to_cod_hist_yn"));
			cause_of_death_remarks_hist_val=checkForNull(rset.getString("cause_of_death_remarks_hist_yn"));
			moved_from_cod_to_gen_hist_val=checkForNull(rset.getString("moved_from_cod_to_gen_hist_yn"));
			moved_from_gen_to_oth_hist_val=checkForNull(rset.getString("moved_from_gen_to_oth_hist_yn"));
			moved_from_oth_to_gen_hist_val=checkForNull(rset.getString("moved_from_oth_to_gen_hist_yn"));
			onset_date_hist_val=checkForNull(rset.getString("onset_date_hist_yn"));
			female_patient_details_hist_val=checkForNull(rset.getString("female_patient_details_hist_yn"));
			mlc_patient_details_hist_val=checkForNull(rset.getString("mlc_patient_details_hist_yn"));
			medical_legal_case_hist_val=checkForNull(rset.getString("medical_legal_case_hist_yn"));
			pol_rep_no_hist_val=checkForNull(rset.getString("pol_rep_no_hist_yn"));
			pol_stn_id_hist_val=checkForNull(rset.getString("pol_stn_id_hist_yn"));
			pol_id_hist_val=checkForNull(rset.getString("pol_id_hist_yn"));
			print_details_hist_val=checkForNull(rset.getString("print_details_hist_yn"));
			
		}
		else{
			
				operation = "insert";
		}

	if(general_details_hist_val.equals("Y"))
	{
		general_details_hist_chk = "checked";
		general_chk = "";
	}
	else
	{
		general_details_hist_chk = "";
		general_chk = "disabled";
	}

	if(attending_practitioner_hist_val.equals("Y"))
		attending_practitioner_hist_chk = "checked";
	else
		attending_practitioner_hist_chk = "";

	if(auth_practitioner_hist_val.equals("Y"))
		auth_practitioner_hist_chk = "checked";
	else
		auth_practitioner_hist_chk = "";

	if(brought_dead_hist_val.equals("Y"))
		brought_dead_hist_chk = "checked";
	else
		brought_dead_hist_chk = "";

	if(diagnosis_details_hist_val.equals("Y"))
	{
		diagnosis_details_hist_chk = "checked";
		diagnosis_chk = "";
	}
	else
	{
		diagnosis_details_hist_chk = "";
		diagnosis_chk = "disabled";
	}

	if(seq_no_hist_val.equals("Y"))
		seq_no_hist_chk = "checked";
	else
		seq_no_hist_chk = "";

	if(add_diagnosis_hist_val.equals("Y"))
		add_diagnosis_hist_chk = "checked";
	else
		add_diagnosis_hist_chk = "";

	if(moved_from_gen_to_cod_hist_val.equals("Y"))
		moved_from_gen_to_cod_hist_chk = "checked";
	else
		moved_from_gen_to_cod_hist_chk = "";

	if(moved_from_gen_to_cod_hist_val.equals("Y"))
		moved_from_gen_to_cod_hist_chk = "checked";
	else
		moved_from_gen_to_cod_hist_chk = "";

	if(moved_from_oth_to_cod_hist_val.equals("Y"))
		moved_from_oth_to_cod_hist_chk = "checked";
	else
		moved_from_oth_to_cod_hist_chk = "";

	if(cause_of_death_remarks_hist_val.equals("Y"))
		cause_of_death_remarks_hist_chk = "checked";
	else
		cause_of_death_remarks_hist_chk = "";

	if(moved_from_cod_to_gen_hist_val.equals("Y"))
		moved_from_cod_to_gen_hist_chk = "checked";
	else
		moved_from_cod_to_gen_hist_chk = "";

	if(moved_from_gen_to_oth_hist_val.equals("Y"))
		moved_from_gen_to_oth_hist_chk = "checked";
	else
		moved_from_gen_to_oth_hist_chk = "";

	if(moved_from_oth_to_gen_hist_val.equals("Y"))
		moved_from_oth_to_gen_hist_chk = "checked";
	else
		moved_from_oth_to_gen_hist_chk = "";



	if(onset_date_hist_val.equals("Y"))
		onset_date_hist_chk = "checked";
	else
		onset_date_hist_chk = "";

	if(moved_from_cod_to_oth_hist_val.equals("Y"))
		moved_from_cod_to_oth_hist_chk = "checked";
	else
		moved_from_cod_to_oth_hist_chk = "";

	if(female_patient_details_hist_val.equals("Y"))
		female_patient_details_hist_chk = "checked";
	else
		female_patient_details_hist_chk = "";

	if(mlc_patient_details_hist_val.equals("Y"))
	{
		mlc_patient_details_hist_chk = "checked";
		mlc_chk = "";
	}
	else
	{
		mlc_patient_details_hist_chk = "";
		mlc_chk = "disabled";
	}

	if(medical_legal_case_hist_val.equals("Y"))
		medical_legal_case_hist_chk = "checked";
	else
		medical_legal_case_hist_chk = "";


	if(pol_rep_no_hist_val.equals("Y"))
		pol_rep_no_hist_chk = "checked";
	else
		pol_rep_no_hist_chk = "";

	if(pol_stn_id_hist_val.equals("Y"))
		pol_stn_id_hist_chk = "checked";
	else
		pol_stn_id_hist_chk = "";

	if(pol_id_hist_val.equals("Y"))
		pol_id_hist_chk = "checked";
	else
		pol_id_hist_chk = "";

	if(print_details_hist_val.equals("Y"))
		print_details_hist_chk = "checked";
	else
		print_details_hist_chk = "";

	 

%>
<body onKeyDown = 'lockKey()'>
<form name="AuditForm" id="AuditForm"  method="post" action='../../servlet/eMR.MRAuditTrialParameterServlet' target="messageFrame">

<table cellpadding='4' cellspacing=0 width="100%" border="0">
	<tr>
		<td class='PANELTOOLBAR' colspan='4'><fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMR.MaintainDeathRegister.label" bundle="${mr_labels}"/></td>
	</tr>
	</table>
	<table cellpadding='5' cellspacing=0 width="100%" border="0">
	<tr>
		<td class="PANELTOOLBAR"><fmt:message key="Common.general.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
	</tr>
	</table>
	<table cellpadding='5' cellspacing=0 width="100%" border="0">
	<tr>
		<td class="label" width='20%' ><fmt:message key="Common.general.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/> </td><td width='5%'><input type="checkbox" name="general_details_hist_yn" id="general_details_hist_yn" onclick='enableGeneralSection();' value="<%=general_details_hist_val%>" <%=general_details_hist_chk%>></td>
		<td width='20%'>&nbsp;</td>
		<td width='5%'>&nbsp;</td>
	</tr>
	 <tr>
		<td class="label" width='20%'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td> <td  width='5%'><input type="checkbox" name="attending_practitioner_hist_yn" id="attending_practitioner_hist_yn" <%=general_chk%> value="<%=attending_practitioner_hist_val%>" <%=attending_practitioner_hist_chk%>></td>
		<td class="label" width='10%'><fmt:message key="eMR.ceritifiedpractitioner.label" bundle="${mr_labels}"/> </td><td width='5%'><input type="checkbox" name="auth_practitioner_hist_yn" id="auth_practitioner_hist_yn" <%=general_chk%> value="<%=auth_practitioner_hist_val%>" <%=auth_practitioner_hist_chk%>></td>
		</tr>
	<tr>
		<td class="label" width='20%'><fmt:message key="Common.broughtindead.label" bundle="${common_labels}"/></td><td width='5%'> <input type="checkbox" name="brought_dead_hist_yn" id="brought_dead_hist_yn" <%=general_chk%> value="<%=brought_dead_hist_val%>" <%=brought_dead_hist_chk%>></td>
		<td width='20%'>&nbsp;</td>
		<td width='5%'>&nbsp;</td>
	</tr>  
</table>
<table cellpadding='5' cellspacing=0 width="100%" border="0" >
	<tr>
		<td class="PANELTOOLBAR" width='10%'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
	</tr>
	</table>
<table cellpadding='5' cellspacing=0 width="100%" border="0" align="center">

		<tr>
		<td class="label" width='20%'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td><td colspan="5"><input type="checkbox" name="diagnosis_details_hist_yn" id="diagnosis_details_hist_yn" onclick='enableDiagnosisSection();' value="<%=diagnosis_details_hist_val%>" <%=diagnosis_details_hist_chk%>></td>
	</tr>
	<tr>
		<td class="label" width='20%'><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td><td width='5%'><input type="checkbox" name="seq_no_hist_yn" id="seq_no_hist_yn" <%=diagnosis_chk%> value="<%=seq_no_hist_val%>" <%=seq_no_hist_chk%>></td>
		<td class="label" width='20%'><fmt:message key="Common.Add.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td><td width='5%'><input type="checkbox" name="add_diagnosis_hist_yn" id="add_diagnosis_hist_yn" <%=diagnosis_chk%> value="<%=add_diagnosis_hist_val%>" <%=add_diagnosis_hist_chk%>></td>

	</tr>
<tr>
		<td class="label" width='20%'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td><td width='5%'><input type="checkbox" name="onset_date_hist_yn" id="onset_date_hist_yn" <%=diagnosis_chk%> value="<%=onset_date_hist_val%>" <%=onset_date_hist_chk%>></td>

		<td class="label" width='20%' ><fmt:message key="eMR.MovedFromGeneralToCauseOfDeath.label" bundle="${mr_labels}"/></td><td width='5%'><input type="checkbox" name="moved_from_gen_to_cod_hist_yn" id="moved_from_gen_to_cod_hist_yn" <%=diagnosis_chk%> value="<%=moved_from_gen_to_cod_hist_val%>" <%=moved_from_gen_to_cod_hist_chk%>></td>

</tr>
		

	<tr>
		<td class="label" width='20%' ><fmt:message key="eMR.MovedFromCauseOfDeathToOther.label" bundle="${mr_labels}"/></td><td width='5%'><input type="checkbox" name="moved_from_cod_to_oth_hist_yn" id="moved_from_cod_to_oth_hist_yn" <%=diagnosis_chk%> value="<%=moved_from_cod_to_oth_hist_val%>" <%=moved_from_cod_to_oth_hist_chk%>></td>

		<td class="label" width='20%'><fmt:message key="eMR.MovedFromOtherToCauseOfDeath.label" bundle="${mr_labels}"/></td><td width='5%'><input type="checkbox" name="moved_from_oth_to_cod_hist_yn" id="moved_from_oth_to_cod_hist_yn" <%=diagnosis_chk%> value="<%=moved_from_oth_to_cod_hist_val%>" <%=moved_from_oth_to_cod_hist_chk%>></td>
    </tr>
	<tr>
			<td class="label" width='20%'><fmt:message key="eMR.MovedFromCauseOfDeathToGeneral.label" bundle="${mr_labels}"/></td><td width='5%'><input type="checkbox" name="moved_from_cod_to_gen_hist_yn" id="moved_from_cod_to_gen_hist_yn" <%=diagnosis_chk%> value="<%=moved_from_cod_to_gen_hist_val%>" <%=moved_from_cod_to_gen_hist_chk%>></td>
			<td class="label" width='20%'><fmt:message key="eMR.MovedFromOtherToGeneral.label" bundle="${mr_labels}"/></td><td width='5%'><input type="checkbox" name="moved_from_oth_to_gen_hist_yn" id="moved_from_oth_to_gen_hist_yn" <%=diagnosis_chk%> value="<%=moved_from_oth_to_gen_hist_val%>" <%=moved_from_oth_to_gen_hist_chk%>></td>
</tr>
<tr>		
		<td class="label" width='20%'><fmt:message key="eMR.MovedFromGeneralListToOther.label" bundle="${mr_labels}"/></td><td colspan="5"><input type="checkbox" name="moved_from_gen_to_oth_hist_yn" id="moved_from_gen_to_oth_hist_yn" <%=diagnosis_chk%> value="<%=moved_from_gen_to_oth_hist_val%>" <%=moved_from_gen_to_oth_hist_chk%>></td>
</tr>
</table>
<table cellpadding='5' cellspacing=0 width="100%" border="0">
	<tr>
		<td class="PANELTOOLBAR"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	</tr>
	</table>
<table cellpadding='5' cellspacing=0 width="100%" border="0">

<tr>
<td class="label" width='20%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td><td width='5%'><input type="checkbox" name="cause_of_death_remarks_hist_yn" id="cause_of_death_remarks_hist_yn" value="<%=cause_of_death_remarks_hist_val%>" <%=cause_of_death_remarks_hist_chk%>></td>
<td width='20%'>&nbsp;</td>
<td width='5%'>&nbsp;</td>
</tr>
</table>
<table cellpadding='5' cellspacing=0 width="100%" border="0">
	<tr>
		<td class="PANELTOOLBAR" width='10%'><fmt:message key="Common.female.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
	</tr>
	</table>
<table cellpadding='5' cellspacing=0 width="100%" border="0">
	<tr>
		<td class="label" width='20%'><fmt:message key="Common.female.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td><td width='5%'><input type="checkbox" name="female_patient_details_hist_yn" id="female_patient_details_hist_yn" value="<%=female_patient_details_hist_val%>" <%=female_patient_details_hist_chk%>></td>
		<td width='20%'>&nbsp;</td>
		<td width='5%'>&nbsp;</td>
	</tr>
	</table>
<table cellpadding='5' cellspacing=0 width="100%" border="0">
	<tr>
	<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
	    <%if(siteSpecific){%>
		<td class="PANELTOOLBAR"><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
		<%}else{%>
		<td class="PANELTOOLBAR"><fmt:message key="Common.mlc.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
		<%}%>
		<!--end ML-MMOH-CRF-0354 [IN057191 -->
	</tr>
	</table>
<table cellpadding='5' cellspacing=0 width="100%" border="0">
	<tr>
<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->	   
	   <%if(siteSpecific){%>
		<td class="label" width='20%'><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
		<%}else{%>
		<td class="label" width='20%'><fmt:message key="Common.mlc.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
		<%}%>
		<!--end ML-MMOH-CRF-0354 [IN057191 -->
		<td colspan="5"><input type="checkbox" name="mlc_patient_details_hist_yn" id="mlc_patient_details_hist_yn" onclick='enableMLCSection();' value="<%=mlc_patient_details_hist_val%>" <%=mlc_patient_details_hist_chk%>></td>
	</tr>
	<tr> 
	<!-- below line(s) modified by VenkateshS against ML-MMOH-CRF-0354 [IN057191] -->
	<%if(siteSpecific){%>
	<td class="label" width='20%'><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/></td><td width='5%'>
	     <%}else{%>
		<td class="label" width='20%'><fmt:message key="Common.mlc.label" bundle="${common_labels}"/></td><td width='5%'><%}%>
		<!--end ML-MMOH-CRF-0354 [IN057191 -->
		<input type="checkbox" name="medical_legal_case_hist_yn" id="medical_legal_case_hist_yn" <%=mlc_chk%> value="<%=medical_legal_case_hist_val%>" <%=medical_legal_case_hist_chk%>></td>
		<td class="label" width='20%'><fmt:message key="Common.PoliceReportNo.label" bundle="${common_labels}"/></td><td width='5%'><input type="checkbox" name="pol_rep_no_hist_yn" id="pol_rep_no_hist_yn" <%=mlc_chk%> value="<%=pol_rep_no_hist_val%>" <%=pol_rep_no_hist_chk%>></td>
	</tr>
	<tr>
		<td class="label" width='20%'><fmt:message key="Common.station.label" bundle="${common_labels}"/></td><td width='5%'><input type="checkbox" name="pol_stn_id_hist_yn" id="pol_stn_id_hist_yn" <%=mlc_chk%> value="<%=pol_stn_id_hist_val%>" <%=pol_stn_id_hist_chk%>></td>
		<td class="label" width='20%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td><td width='5%'><input type="checkbox" name="pol_id_hist_yn" id="pol_id_hist_yn" <%=mlc_chk%> value="<%=pol_id_hist_val%>" <%=pol_id_hist_chk%>></td>
	</tr>
 </table>
 <table cellpadding='5' cellspacing=0 width="100%" border="0">
	<tr>
		<td class="PANELTOOLBAR" width='10%'><fmt:message key="Common.print.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
	</tr>
	</table>
 <table cellpadding='5' cellspacing=0 width="100%" border="0">
	<tr>
		<td class="label" width='20%'><fmt:message key="Common.print.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></td><td width='5%'><input type="checkbox" name="print_details_hist_yn" id="print_details_hist_yn" value="<%=print_details_hist_val%>" <%=print_details_hist_chk%>></td>
		<td width='20%'>&nbsp;</td>
		<td width='5%'>&nbsp;</td>
	</tr>
</table>
<input type='hidden' name='function1' id='function1' value='<%=operation%>'> 





</form>
</body>
</html>
<%
}catch(Exception e){/* out.println(e.toString()); */e.printStackTrace();}
		finally
		{
			ConnectionManager.returnConnection(conn,request);
		}
%>
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

