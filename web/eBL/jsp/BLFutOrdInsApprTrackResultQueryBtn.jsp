<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%
System.err.println("Query String in Btn.jsp:"+request.getQueryString());
	String facilityId = (String)session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("locale");
	String qry_patient_id = checkForNull(request.getParameter("patient_id"));
	String qry_encounter_id = checkForNull(request.getParameter("encounter_id"));
	String qry_episode_type = checkForNull(request.getParameter("episode_type"));
	String qry_payer_grp_code = checkForNull(request.getParameter("payer_grp_code"));
	String qry_payer_code = checkForNull(request.getParameter("payer_code"));
	String qry_policy_type_code = checkForNull(request.getParameter("policy_type_code"));
	String qry_enc_frm_date = checkForNull(request.getParameter("enc_frm_date"));
	String qry_enc_to_date = checkForNull(request.getParameter("enc_to_date"));
	String qry_spec_nursing_unit_code = checkForNull(request.getParameter("spec_nursing_unit_code"));	
	String qry_insurance_Status = checkForNull(request.getParameter("insurance_Status"));	
	String qry_order_status = checkForNull(request.getParameter("order_status"));
	String qry_serviceGroupCode = checkForNull(request.getParameter("serviceGroupCode"));
	String qry_serviceClassificationCode = checkForNull(request.getParameter("serviceClassificationCode"));
	String qry_coding_status = checkForNull(request.getParameter("coding_status"));
	String qry_billingGrpCode = checkForNull(request.getParameter("billingGrpCode"));
%>

<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eBL/js/BLFutOrdInsApprTrack.js' language='javascript'></script>
<script src='../../eBL/js/BLFutOrdInsApprTrackResult.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<body>
<form name='' id=''>

<table cellpadding='3' cellspacing='0'  width="100%">
	<tr>

		<td width="70%"  class='labels' colspan=5></td>
		<td width="30%" class='fields'>
			<input type='button' name="save_&_export" id="save_&_export" id="save_&_export" value="Save & Export" class='button' onclick='saveUserData("B");' >
			<input type='button' name="export_to_excel" id="export_to_excel" id="export_to_excel" value="Export to Excel" class='button' onclick='generateExcel("E");' >
			<input type='button' name="save" id="save" id="save" value="Save" class='button' onclick='saveUserData("S")' >			

			<input type="hidden" id="p_facility_id" name="p_facility_id" id="p_facility_id"	value="<%=facilityId%>">
			<input type="hidden" id="p_patient_id" name="p_patient_id" id="p_patient_id"	value="<%=qry_patient_id%>">
			<input type="hidden" id="p_episode_type" name="p_episode_type" id="p_episode_type"	value="<%=qry_episode_type%>">
			<input type="hidden" id="p_encounter_id" name="p_encounter_id" id="p_encounter_id"	value="<%=qry_encounter_id%>">
			<input type="hidden" id="p_SPECIALITY_CODE" name="p_SPECIALITY_CODE" id="p_SPECIALITY_CODE"	value="<%=qry_spec_nursing_unit_code%>">
			<input type="hidden" id="p_payer_grp_code" name="p_payer_grp_code" id="p_payer_grp_code"	value="<%=qry_payer_grp_code%>">
			<input type="hidden" id="p_payer_code" name="p_payer_code" id="p_payer_code"	value="<%=qry_payer_code%>">
			<input type="hidden" id="p_policy_type_code" name="p_policy_type_code" id="p_policy_type_code"	value="<%=qry_policy_type_code%>">
			<input type="hidden" id="p_enc_frm_date" name="p_enc_frm_date" id="p_enc_frm_date"	value="<%=qry_enc_frm_date%>">
			<input type="hidden" id="p_enc_to_date" name="p_enc_to_date" id="p_enc_to_date"	value="<%=qry_enc_to_date%>">
			<input type="hidden" id="p_ins_status" name="p_ins_status" id="p_ins_status"	value="<%=qry_insurance_Status%>">
			<input type="hidden" id="p_ORDER_LINE_STATUS" name="p_ORDER_LINE_STATUS" id="p_ORDER_LINE_STATUS"	value="<%=qry_order_status%>">
			<input type="hidden" id="p_SERV_GRP_CODE" name="p_SERV_GRP_CODE" id="p_SERV_GRP_CODE"	value="<%=qry_serviceGroupCode%>">
			<input type="hidden" id="p_SERV_CLASS_CODE" name="p_SERV_CLASS_CODE" id="p_SERV_CLASS_CODE"	value="<%=qry_serviceClassificationCode%>">
			<input type="hidden" id="p_BLNG_GRP_ID" name="p_BLNG_GRP_ID" id="p_BLNG_GRP_ID"	value="<%=qry_billingGrpCode%>">			
			
		</td>
	</tr>
</table>
</form>
</body>
</html>

