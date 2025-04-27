<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMConfirmReceiptFiles.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name='FMConfirmRcptCriteria_form' id='FMConfirmRcptCriteria_form'>
<%
//	String location = request.getParameter("location");
try
{
%>
<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
<tr><td colspan="8">
	<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name="frame_name" value="parent.receipt_criteria"/>
		<jsp:param name="form_name" value="FMConfirmRcptCriteria_form"/>
		<jsp:param name="messageframe_name" value="parent.messageFrame"/>
		<jsp:param name="patientid_name" value="patient_id"/>
		<jsp:param name="fileno_name" value="file_no"/>
		<jsp:param name="filetype_name" value="file_type_code"/>
		<jsp:param name="volumeno_name" value="volume_no"/>
		<jsp:param name="table_width" value="100"/>
		<jsp:param name="tablealign" value="center"/>
		<jsp:param name="locn_code" value="f_curr_fs_locn"/>
	</jsp:include>
</tr>
<tr>
	<td class='button' colspan="8">
	<input type='button' class='button' name='add' id='add' value='  Add  ' onClick="AddFiles();">
	<input type='button' class='button' name='show' id='show' value='Show all Docs' onCLick="selectVals();">
		<input type='button' class='button' name='clear' id='clear' value=' Clear ' onClick="ClearData();"></td>
	</tr>
</table>
	<TABLE border='0' cellpadding='0' cellspacing='0' width='100%' align='center' id ="hdr_tab0" style="visibility:'hidden'">
		<tr><td class='label'colspan='7' ><b><fmt:message key="eFM.DocumentsinTransit.label" bundle="${fm_labels}"/></b></td></tr>
	</TABLE>
	<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='center' id ="hdr_tab" style="visibility:'hidden'">
		<tr><th align ='center' width='20%' id="ParamID"><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></th>
		<th align ='center' width='10%' id="file_type_ID" nowrap><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></th>
		<th align ='center' width='10%'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
		<th align ='center' width='12%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
		<th align ='center' width='8%'><fmt:message key="eFM.RequestRemarks.label" bundle="${fm_labels}"/></th>
		<th align ='center' width='15%'><fmt:message key="eFM.IssuedDSLocation.label" bundle="${fm_labels}"/></th>
		<th align ='center' width='8%'><fmt:message key="Common.IssueRemarks.label" bundle="${common_labels}"/></th>
		<th align ='center' width='10%'><fmt:message key="Common.issueddate.label" bundle="${common_labels}"/></th>
		<th align ='center' width='7%'><fmt:message key="eFM.ConfirmReceipt.label" bundle="${fm_labels}"/>?</th></tr>
	</TABLE>
<input type='hidden' name='filelistvals' id='filelistvals' value=''>
<input type='hidden' name='volume_no' id='volume_no' value=''>
<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
</form>
</body>
</html>
<%
}
catch (Exception e)
{
	out.println(e.toString());
}
finally
{}
%>

