<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
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
				<td class='button'  colspan="8">
				<input type='button' class='button' name='add' id='add' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>' onClick="AddFiles();"><input type='button' class='button' name='show' id='show' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ShowAllFiles.label","fm_labels")%>' onCLick="selectVals();"><input type='button' class='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick="ClearData();"></td>
			</tr>
		</table>

		<TABLE border='0' cellpadding='0' cellspacing='0' width='100%' align='center' id ="hdr_tab0" style="visibility:'hidden'">
			<tr><td class='label'colspan='7' ><b><fmt:message key="eFM.FilesinTransit.label" bundle="${fm_labels}"/></b></td></tr>
		</TABLE>

		<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='center' id ="hdr_tab" style="visibility:'hidden'">
			<tr><td class='columnheader' width='30%' id="ParamID"><fmt:message key="eFM.FileNoPatientDetails.label" bundle="${fm_labels}"/></td>
			<td class='columnheader' width='12%' id="file_type_ID"><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>
			<td class='columnheader' width='8%'><fmt:message key="eFM.RequestRemarks.label" bundle="${fm_labels}"/></td>
			<td class='columnheader' width='20%'><fmt:message key="eFM.IssuedFSLocation.label" bundle="${fm_labels}"/></td>
			<td class='columnheader' width='8%'><fmt:message key="Common.IssueRemarks.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='15%'><fmt:message key="Common.issueddate.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='7%'><fmt:message key="eFM.ConfirmReceipt.label" bundle="${fm_labels}"/>?</td></tr>
			<script>
				if(document.forms[0].file_type_appl_yn.value=="Y")
				{
					document.getElementById("ParamID").innerText=getLabel("Common.PatientDetails.label","common");
					document.getElementById("file_type_ID").innerHTML=getLabel("Common.filetype.label","common")+ "/" +  getLabel("eFM.VolumeNo.label","FM");
				}
			</script>

		</TABLE>

		<input type='hidden' name='patientlistvals' id='patientlistvals' value=''>
		<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
	    <input type='hidden' name='remove_volume' id='remove_volume' value=''>
		<input type='hidden' name='p_stored_val' id='p_stored_val' value=''>
		
		</form>
	<%
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e);
	}
%>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

