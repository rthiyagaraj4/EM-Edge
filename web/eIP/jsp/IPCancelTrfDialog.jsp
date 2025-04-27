<!DOCTYPE html>
<!--Created by Thamizh selvi on 4th Apr 2017 against GDOH-CRF-0124-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,com.ehis.util.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
<HEAD>

	<TITLE> <fmt:message key="Common.CancelTransfer.label" bundle="${common_labels}"/> </TITLE>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eIP/js/IPCancelTransfer.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</HEAD>
<%
	String patient_id				= checkForNull(request.getParameter("patientId"));
	String enc_id					= checkForNull(request.getParameter("encounterId"));
	String srl_no					= checkForNull(request.getParameter("srlNo"));
	String frm_serv_code			= checkForNull(request.getParameter("frmServCode"));
	String frm_bed_cls_code			= checkForNull(request.getParameter("frmBedClsCode"));
	String frm_bed_cls_type			= checkForNull(request.getParameter("frmBedClsType"));
	String frm_pract_id				= checkForNull(request.getParameter("frmPractId"));
	String frm_spec_code			= checkForNull(request.getParameter("frmSpecCode"));
	String frm_sub_serv_code		= checkForNull(request.getParameter("frmSubServCode"));
	String trf_type					= checkForNull(request.getParameter("trfType"));

	String toNursUtCode				= checkForNull(request.getParameter("toNursUtCode"));
	String frmNursUtCode			= checkForNull(request.getParameter("frmNursUtCode"));
	String toBedNo					= checkForNull(request.getParameter("toBedNo"));
	String frmBedNo					= checkForNull(request.getParameter("frmBedNo"));
	String toRoomNo					= checkForNull(request.getParameter("toRoomNo"));
	String frmRoomNo				= checkForNull(request.getParameter("frmRoomNo"));
	
	String modifiedDate				= checkForNull(request.getParameter("modifiedDate"));
	String tfrReqRefNo				= checkForNull(request.getParameter("tfrReqRefNo"));
	

%>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='CancelTrfDialog' id='CancelTrfDialog' action='../../servlet/eIP.IPCancelTransferPatientInServlet' method='post' target='messageFrame'> 
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
	<tr>&nbsp;</tr>
	<tr>&nbsp;</tr>
	<tr>
		<td width="30%" class='label' valign="top"><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></td>
		<td width="70%" class='fields'><textarea style="overflow-y: scroll;  resize: none;" name='cancelReason' rows="4" cols="50" maxlength="100" onkeyup='return imposeMaxLength(this);'></textarea>&nbsp;<img align='top' src="../../eCommon/images/mandatory.gif"></td>
	</tr>
</table>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
	<tr>&nbsp;</tr>
	<tr>&nbsp;</tr>
	<tr>
		<td width="30%" class='label'>&nbsp;</td>
		<td width="35%" class='label'>&nbsp;</td>
		<td width="7%" class='label'>&nbsp;</td>
		<td width="28%" class="fields" nowrap><input type=button class='button' name = 'cancelTrf' style= "width: 50px;  height: 20px;" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick='CancelTrf(this);'>&nbsp;&nbsp;<input type=button class='button' name = 'close' style= "width: 50px;  height: 20px;" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='closeWin(this);'></td> 
	</tr>
</table>

<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
<input type='hidden' name='encounter_id' id='encounter_id' value='<%=enc_id%>'>
<input type='hidden' name='srl_no' id='srl_no' value='<%=srl_no%>'>
<input type='hidden' name='frmServCode' id='frmServCode' value='<%=frm_serv_code%>'>
<input type='hidden' name='frmBedClsCode' id='frmBedClsCode' value='<%=frm_bed_cls_code%>'>
<input type='hidden' name='frmBedClsType' id='frmBedClsType' value='<%=frm_bed_cls_type%>'>
<input type='hidden' name='frmPractId' id='frmPractId' value='<%=frm_pract_id%>'>
<input type='hidden' name='frmSpecCode' id='frmSpecCode' value='<%=frm_spec_code%>'>
<input type='hidden' name='frmSubServCode' id='frmSubServCode' value='<%=frm_sub_serv_code%>'>
<input type='hidden' name='trfType' id='trfType' value='<%=trf_type%>'>

<input type='hidden' name='to_nurs_code' id='to_nurs_code' value='<%=toNursUtCode%>'>
<input type='hidden' name='frm_nurs_code' id='frm_nurs_code' value='<%=frmNursUtCode%>'>
<input type='hidden' name='frm_room_no' id='frm_room_no' value='<%=frmRoomNo%>'>
<input type='hidden' name='to_room_no' id='to_room_no' value='<%=toRoomNo%>'>
<input type='hidden' name='frm_bed_no' id='frm_bed_no' value='<%=frmBedNo%>'>
<input type='hidden' name='to_bed_no' id='to_bed_no' value='<%=toBedNo%>'>

<input type='hidden' name='modified_date' id='modified_date' value='<%=modifiedDate%>'>
<input type='hidden' name='tfrReqRefNo' id='tfrReqRefNo' value='<%=tfrReqRefNo%>'>

</form>
</body>
</HTML>

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

