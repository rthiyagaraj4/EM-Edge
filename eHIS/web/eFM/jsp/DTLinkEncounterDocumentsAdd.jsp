<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/DTLinkEncounterVolumeDocType.js'></script>
	<script language='javascript' src='../../eFM/js/DTDocumentNumberLookup.js'></script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>	
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String encounter_id			=	checkForNull(request.getParameter("encounter_id"));
	String facilityID 			=	checkForNull((String) session.getValue("facility_id"));
	String volume_no			=	checkForNull(request.getParameter("volume_no"));
	String file_no			=	checkForNull(request.getParameter("file_no"));
	String doc_folder_id		=	checkForNull(request.getParameter("doc_folder_id"));
	String maintain_doc_or_file	=	checkForNull(request.getParameter("maintain_doc_or_file"));
%>
<body onMouseDown = "CodeArrest();" onLoad="FocusFirstElement();" onKeyDown = 'lockKey();'> 
<form name='DTLinkEncounterAddForm' id='DTLinkEncounterAddForm' action='' method='POST' >
	<table width="100%" cellpadding="3" cellspacing="0" border="0" style="border:1x solid black">
	<%
		if (!maintain_doc_or_file.equals("D"))
		{
	%>
	<tr>
		<td width="25%" class="LABEL" ><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>
		<td width="25%" class="querydata"><%=volume_no%><input type='Hidden' name='fs_location' id='fs_location' value=''></td>
		<td class='label' width='25%'>&nbsp;</td>
		<td class='label' width='25%'>&nbsp;</td>
	</tr>
	<%
		}
		if (maintain_doc_or_file.equals("D"))
		{
	%>
	<tr>
		<td width="25%" class="LABEL" ><fmt:message key="eFM.DocStorageLocation.label" bundle="${fm_labels}"/></td>
		<td width="25%" class="LABEL">
			<select name="fs_location" id="fs_location">
			<option value="">--------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------------</option> 
			<%
			Connection connection			=	null;
			PreparedStatement preStatement	=	null;
			ResultSet	resultSet			=	null;
			StringBuffer codeBuffer			=	new StringBuffer();
			try
			{
				connection = ConnectionManager.getConnection(request);	
				
				preStatement = connection.prepareStatement("SELECT a.short_desc,b.fs_locn_code FROM fm_storage_locn a,fm_folder_in_fs_locn b WHERE a.fs_locn_code=b.fs_locn_code AND a.facility_id = b.facility_id AND a.facility_id = ? AND doc_folder_id = ? ORDER BY a.short_desc");
				preStatement.setString(1, facilityID);
				preStatement.setString(2, doc_folder_id);
				resultSet =	preStatement.executeQuery();
				if(resultSet != null)
				{
					while(resultSet.next())
					{
						if (codeBuffer.length()>0)
							codeBuffer.delete(0, codeBuffer.length());
						codeBuffer.append(resultSet.getString("fs_locn_code"));
						codeBuffer.append("$$");
						codeBuffer.append(checkForNull(resultSet.getString("short_desc")));
					%>
					<option value='<%=codeBuffer.toString()%>' selected><%=checkForNull(resultSet.getString("short_desc"))%></option>
					<%
					}
				}
			if(resultSet!=null)	resultSet.close();
			if(preStatement!=null) preStatement.close();
			}
			catch(Exception e)
			{
				out.println("Exception : " + e.toString());
			}
			finally
			{
				ConnectionManager.returnConnection(connection,request);
			}
			%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
		</td>
		<td class='label' width='25%'>&nbsp;</td>
		<td class='label' width='25%'>&nbsp;</td>
	</tr>
	<%
		}
	%>
	<tr>
		<td class="LABEL" ><fmt:message key="eFM.DocumentID.label" bundle="${fm_labels}"/></td>
		<td class='fields'><input type="text" maxlength="15" size="15" name="document_no" id="document_no"  onChange="docNumberLookup(this.value);" onKeyPress="return getBarCodeValue(event, this.value);" onBlur="checkForDocNumber(this.value)"><input type='button' class='button' name='doc_fold_search' id='doc_fold_search' value='?' align=center onClick='docNumberLookup(document_no.value);'><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
	<!-- </tr>
	<tr> -->
		<td class="LABEL"><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
		<td id="doc_type" class="querydata" style="font-weight:bolder">&nbsp;</td>
	</tr>
	<tr>
		<td class="LABEL" ><fmt:message key="Common.DocumentDate.label" bundle="${common_labels}"/></td>
		<td class='fields' ><input type="text" id="doc_date" maxlength="10" size="10" name="document_date" id="document_date"  onBlur='validDateObj(this,"DMY","<%=localeName%>");'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('doc_date');">&nbsp;</td>
<!-- 	</tr>
	<tr> -->
		<td class="LABEL" ><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></td>
		<td class='fields'><TEXTAREA NAME="doc_details" COLS="20" maxlength='200'  onBlur="checkLength(this)"></TEXTAREA></td>
	</tr>
	<!-- onkeypress="return ValidString(event)" -->
	<tr>
	<td colspan="3">&nbsp;</td>
	<td ><table cellpadding="1" style="border:1x solid #339999"><tr><td class='button'><input type="button" class="BUTTON" name="add_button" id="add_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>" style="width:60;border:1x solid black;" onClick="AddRecords();" disabled><input type="button" class="BUTTON" name="clr_button" id="clr_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" style="width:60;border:1x solid black;" onClick="document.location.reload();";></td></tr></table>
	</td></tr>
	</table>
	<input type="Hidden" name="volume_no" id="volume_no" value="<%=volume_no%>">
	<input type="Hidden" name="file_no" id="file_no" value="<%=file_no%>">
	<input type="Hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	<input type="Hidden" name="maintain_doc_or_file" id="maintain_doc_or_file" value="<%=maintain_doc_or_file%>">
	<input type="Hidden" name="doc_type_code" id="doc_type_code" value="">
	<input type="Hidden" name="doc_type_desc" id="doc_type_desc" value="">	
	<input type="Hidden" name="operation" id="operation" value="AddRecords">
	<input type="Hidden" name="check_flag" id="check_flag" value="Y">
	<input type="Hidden" name="first_time" id="first_time" value="Y">
	<script>
		parent.parent.tab_frame.document.getElementById("first_tab").src="../../eFM/images/Encounters_click.gif";
		parent.parent.tab_frame.document.getElementById("second_tab").src="../../eFM/images/Documents.gif";
	</script>
</form>
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

