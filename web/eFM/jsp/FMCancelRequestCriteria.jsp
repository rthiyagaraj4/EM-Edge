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
	<script language='javascript' src='../../eFM/js/FMCancelRequestFiles.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement();' onKeyDown = 'lockKey();'>
<form name='FMCancelRequestCriteria_form' id='FMCancelRequestCriteria_form'>
	<%
	Connection conn			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt	= null;
	ResultSet rst			= null;

	String maintain_doc_or_file = "";
	String mysql				= "";
	
	try
	{
		stmt  = conn.createStatement();
		
		mysql = "SELECT maintain_doc_or_file from mp_param";
		rst	  = stmt.executeQuery(mysql);
		if(rst != null && rst.next())
		{
			maintain_doc_or_file = rst.getString("maintain_doc_or_file");

//out.println("<script>alert('maintain_doc_or_file::"+maintain_doc_or_file+"');</script>");

		}
		%>
		<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
			<tr><td colspan="4">
				<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name="frame_name" value="parent.cancel_criteria"/>
					<jsp:param name="form_name" value="FMCancelRequestCriteria_form"/>
					<jsp:param name="messageframe_name" value="parent.messageFrame"/>
					<jsp:param name="patientid_name" value="patient_id"/>
					<jsp:param name="fileno_name" value="file_no"/>
					<jsp:param name="filetype_name" value="file_type_code"/>
					<jsp:param name="document_type_name" value="doc_type_code"/>
					<jsp:param name="document_folder_id_name" value="doc_folder_id"/>
					<jsp:param name="volumeno_name" value="volume_no"/>
					<jsp:param name="table_width" value="100"/>
					<jsp:param name="tablealign" value="CENTER"/>
					<jsp:param name="locn_code" value="f_curr_fs_locn"/>
				</jsp:include>
			</td>
			</tr>
			<tr>
				<td class='button' colspan="4" align="right"><input type='button' class='button' name='add' id='add' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>' onClick="AddFiles();"><%
				if(maintain_doc_or_file.equals("D")){%><input type='button' class='button' name='show' id='show' value='Show all Docs' onCLick="selectVals();"><%}
				else if(maintain_doc_or_file.equals("F")){%><input type='button' class='button' name='show' id='show' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ShowAllFiles.label","fm_labels")%>' onCLick="selectVals();"><%}%><input type='button' class='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick="ClearData();"></td>
			</tr>
			</table>
			<TABLE border='0' cellpadding='0' cellspacing='0' width='100%' align='center' id ="hdr_tab0" style="display:none">
				<tr><td class='label'colspan='4' ><b><fmt:message key="eFM.OutstandingRequest.label" bundle="${fm_labels}"/></b></td></tr>
			</TABLE>
			<%if(maintain_doc_or_file.equals("D")){
			%>
				<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='left' id ="hdr_tab1" style="display:none">
					<tr><td class='COLUMNHEADER' width='25%' id="ParamID"><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width='11%' id="file_type_ID"><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width='13%'><fmt:message key="Common.requesteddate.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width='12%'><fmt:message key="eFM.IssuedFSLocation.label" bundle="${fm_labels}"/></td>
						<td class='COLUMNHEADER' width='9%'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>?</td>
						<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.CancelRemarks.label" bundle="${common_labels}"/></td>
					</tr>
				</TABLE>
			<%
			}else if(maintain_doc_or_file.equals("F")){
			%>
				<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='left' id ="hdr_tab" style="display:none">
					<tr><td class='COLUMNHEADER' width='40%' id="ParamID"><fmt:message key="eFM.FileNoPatientDetails.label" bundle="${fm_labels}"/></td>
						<td class='COLUMNHEADER' width='13%' id="file_type_ID"><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>
						<td class='COLUMNHEADER' width='13%'><fmt:message key="Common.requesteddate.label" bundle="${common_labels}"/></td>
						<td class='COLUMNHEADER' width='15%'><fmt:message key="eFM.IssuedFSLocation.label" bundle="${fm_labels}"/></td>
						<td class='COLUMNHEADER' width='9%'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>?</td>
						<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.CancelRemarks.label" bundle="${common_labels}"/></td>
					</tr>
					<script>
						if (document.forms[0].file_type_appl_yn.value=="Y")
						{
							document.getElementById("ParamID").innerText=getLabel("Common.PatientDetails.label","common");
							document.getElementById("file_type_ID").innerHTML=getLabel("Common.filetype.label","common")+ "/" +  getLabel("eFM.VolumeNo.label","FM");
						}
					</script>
				<tr>
					<td  id="rem_remarks"></td>
					</TABLE> </tr>
		  <%}%>
			<input type='hidden' name='filelistvals' id='filelistvals' value=''>
			<input type='hidden' name='patientlistvals' id='patientlistvals' value=''>
			<input type='hidden' name='documentfolderlistvals' id='documentfolderlistvals' value=''>
			<input type='hidden' name='documenttypelistvals' id='documenttypelistvals' value=''>
			<input type='hidden' name='volumelistvals' id='volumelistvals' value=''>
			<input type='hidden' name='p_stored_val' id='p_stored_val' value=''>
			<input type='hidden' name='pat_file_vol' id='pat_file_vol' value=''>
			<input type='hidden' name='added_rem_remarks' id='added_rem_remarks' value=''>
			<input type='hidden' name='added_rem_remarks_values' id='added_rem_remarks_values' value=''>
			<input type='hidden' name='p_maintain_doc_or_file' id='p_maintain_doc_or_file' value='<%=maintain_doc_or_file%>'>
			<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
		</form>
		</body>
		<%
		if(rst  != null) rst.close();
		if(stmt != null) stmt.close();
	}catch (Exception e){out.println("Exception :"+e.toString());}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);	
	}
	%>
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

