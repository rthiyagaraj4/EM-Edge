<!DOCTYPE html>
<%@page import="java.sql.Date"%>
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection,java.math.*,java.net.*,java.text.*,webbeans.eCommon.*,org.apache.commons.codec.binary.Base64"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eBL/js/BLDischClear.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eBL/js/RCMClaimsStatusChange.js' language='javascript'></script>
<script src='../../eBL/js/RCMClaims.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
%>
<%
	
	String facilityId = (String)session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("LOCALE");
	System.err.println("Query String in inerrorbtn.jsp:"+request.getQueryString());
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String claim_status = checkForNull(request.getParameter("claim_status"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String episode_type = checkForNull(request.getParameter("episode_type"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));
	String spec_nursing_unit_code = checkForNull(request.getParameter("spec_nursing_unit_code"));
	String payer_grp_code = checkForNull(request.getParameter("payer_grp_code"));
	String payer_code = checkForNull(request.getParameter("payer_code"));
	String policy_type_code = checkForNull(request.getParameter("policy_type_code"));
	String enc_frm_date = checkForNull(request.getParameter("enc_frm_date"));
	String enc_to_date = checkForNull(request.getParameter("enc_to_date"));
	String doc_gen_from = checkForNull(request.getParameter("doc_gen_from"));
	String doc_gen_to = checkForNull(request.getParameter("doc_gen_to"));
	String claim_number = checkForNull(request.getParameter("claim_number"));
	String ins_status = checkForNull(request.getParameter("ins_status"));
	String past_recs_days = checkForNull(request.getParameter("past_recs_days"));
%>
<body onKeyDown="lockKey()" onMouseDown="CodeArrest()" method="Post">
<form name='' id=''>

<table cellpadding='3' cellspacing='0'  width="100%">
	<tr>
<% 
	if(claim_status.equals("E")){
%>
		<td width="75%"  class='labels' colspan=6></td>
		<td width="25%" class='fields'>
			<input type='button' name="generate" id="generate" id="generate" value="Generate" class='button' onclick='generateDocs();' >
			<input type='button' name="export_to_excel" id="export_to_excel" id="export_to_excel" value="Export to Excel" class='button' onclick='generateExcel();'>
<%
	}else if(claim_status.equals("D")){
%>
		<td width="70%"  class='labels' colspan=5></td>
		<td width="30%" class='fields'>
			<input type='button' name="regenerate" id="regenerate" id="regenerate" value="Regenerate" class='button' onclick='regeneratePDF()' >
			<input type='button' name="ReviewApprove" id="ReviewApprove" id="ReviewApprove" value="Review & Approve" class='button' onclick='reviewAppCall()' >
			<input type='button' name="export_to_excel" id="export_to_excel" id="export_to_excel" value="Export to Excel" class='button' onclick='generateExcel();' >			
<%
	}else if(claim_status.equals("R")){
%>
		<td width="67%"  class='labels' colspan=5></td>
		<td width="33%" class='fields'>
			<input type='button' name="revertSts" id="revertSts" id="revertSts" value="Revert Status" class='button' onclick='revertStatus()' >
			<input type='button' name="regenerate" id="regenerate" id="regenerate" value="Regenerate" class='button' onclick='regeneratePDF()' >
			<input type='button' name="genClaim" id="genClaim" id="genClaim" value="Generate claim" class='button' onclick='generateClaim()' >
			<input type='button' name="export_to_excel" id="export_to_excel" id="export_to_excel" value="Export to Excel" class='button' onclick='generateExcel();'>			
<%
	}else if(claim_status.equals("G")){
%>
		<td width="67%"  class='labels' colspan=5></td>
		<td width="33%" class='fields'>
			<input type='button' name="revertSts" id="revertSts" id="revertSts" value="Revert Status" class='button' onclick='revertStatus()' >
			<input type='button' name="regenerate" id="regenerate" id="regenerate" disabled value="Regenerate" class='button' onclick='regeneratePDF()' >
			<input type='button' name="subToIns" id="subToIns" id="subToIns" value="Submit to insurance" class='button' onclick='submitToIns()' >
			<input type='button' name="export_to_excel" id="export_to_excel" id="export_to_excel" value="Export to Excel" class='button' onclick='generateExcel();' >						
<%
	}
%>
			<input type="hidden" id="p_facility_id" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
			<input type="hidden" id="p_claim_status" name="p_claim_status" id="p_claim_status"	value="<%=claim_status%>">
			<input type="hidden" id="p_patient_id" name="p_patient_id" id="p_patient_id"	value="<%=patient_id%>">
			<input type="hidden" id="p_episode_type" name="p_episode_type" id="p_episode_type"	value="<%=episode_type%>">
			<input type="hidden" id="p_encounter_id" name="p_encounter_id" id="p_encounter_id"	value="<%=encounter_id%>">
			<input type="hidden" id="p_spec_nursing_unit_code" name="p_spec_nursing_unit_code" id="p_spec_nursing_unit_code"	value="<%=spec_nursing_unit_code%>">
			<input type="hidden" id="p_payer_grp_code" name="p_payer_grp_code" id="p_payer_grp_code"	value="<%=payer_grp_code%>">
			<input type="hidden" id="p_payer_code" name="p_payer_code" id="p_payer_code"	value="<%=payer_code%>">
			<input type="hidden" id="p_policy_type_code" name="p_policy_type_code" id="p_policy_type_code"	value="<%=policy_type_code%>">
			<input type="hidden" id="p_enc_frm_date" name="p_enc_frm_date" id="p_enc_frm_date"	value="<%=enc_frm_date%>">
			<input type="hidden" id="p_enc_to_date" name="p_enc_to_date" id="p_enc_to_date"	value="<%=enc_to_date%>">
			<input type="hidden" id="p_doc_gen_from" name="p_doc_gen_from" id="p_doc_gen_from"	value="<%=doc_gen_from%>">
			<input type="hidden" id="p_doc_gen_to" name="p_doc_gen_to" id="p_doc_gen_to"	value="<%=doc_gen_to%>">
			<input type="hidden" id="p_claim_number" name="p_claim_number" id="p_claim_number"	value="<%=claim_number%>">
			<input type="hidden" id="p_ins_status" name="p_ins_status" id="p_ins_status"	value="<%=ins_status%>">
			<input type="hidden" id="p_past_recs_days" name="p_past_recs_days" id="p_past_recs_days"	value="<%=past_recs_days%>">
			
			<input type="hidden" id="claim_status" name="claim_status" id="claim_status"	value="<%=claim_status%>">			
		</td>
		
	</tr>
</table>
</form>
</body>  
</html>

