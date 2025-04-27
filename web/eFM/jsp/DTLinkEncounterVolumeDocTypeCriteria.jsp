<!DOCTYPE html>
<%@page session="true" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
try
{
%>	

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
	<script language='javascript' src='../../eFM/js/DTLinkEncounterVolumeDocType.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
function getResults()
{
	var maintain_doc_or_file	= document.forms[0].maintain_doc_or_file.value;
	
	if (maintain_doc_or_file=="D")
	{
		if (document.forms[0].doc_folder_id.value == "")
		{
			//alert("APP-000001 Document Folder cannot be blank...");
			var errormsg =getMessage("CAN_NOT_BE_BLANK","common");
			errormsg=errormsg.replace('$',getLabel("eFM.DocumentFolder.label","FM"));
			alert(errormsg);
			document.forms[0].doc_folder_desc.focus();
			return;
		}
		else if (document.forms[0].doc_type_id.value == "")
		{
			//alert("APP-000001 Document Type cannot be blank...");
			alert(getMessage("DOC_CAN_NOT_BE_BLANK","FM"));
			document.forms[0].doc_type_id.focus();
			return;
		}
		else if (document.forms[0].action_code.value == "")
		{
			//alert("APP-000001 Action cannot be blank...");
			var errormsg=getMessage("CAN_NOT_BE_BLANK","common");
			errormsg=errormsg.replace('$',getLabel("Common.action.label","common"));
			alert(errormsg);
			document.forms[0].doc_type_id.focus();
			return;
		}
	}
	else
	{
		var patient_id		= document.forms[0].patient_id.value;
		var action_code		= document.forms[0].action_code.value;
		if (document.forms[0].file_type_appl_yn.value == "Y")
		{
			var file_no		= "";
			var file_type	= document.forms[0].patient_file_type.value;
		}
		else
		{
			var file_no		= document.forms[0].file_no.value;
			var file_type	= "";
		}

		if (patient_id == "") 
		{
			//alert("APP-000001 Patient ID cannot be blank...");
			var errormsg=getMessage("CAN_NOT_BE_BLANK","common");
			errormsg=errormsg.replace('$',getLabel("Common.patientId.label","common"));
			alert(errormsg);
			document.forms[0].patient_id.focus();
			return;
		}

		if ((file_type == "") && (document.forms[0].file_type_appl_yn.value == "Y"))
		{
			//alert("APP-000001 File Type cannot be blank...");
			var errormsg=getMessage("CAN_NOT_BE_BLANK","common");
			errormsg=errormsg.replace('$',getLabel("Common.filetype.label","common"));
			alert(errormsg);
			document.forms[0].file_type.focus();
			return;
		}
		else if ((document.forms[0].file_type_appl_yn.value == "N") && (file_no == "" ))
		{
			//alert("APP-000001 File No cannot be blank...");
			alert(getMessage("FILE_CAN_NOT_BE_BLANK","FM"));
			document.forms[0].file_no.focus();
			return;
		}
		else if (action_code == "")
		{
			//alert("APP-000001 Action cannot be blank...");
			var errormsg=getMessage("CAN_NOT_BE_BLANK","common");
			errormsg=errormsg.replace('$',getLabel("Common.action.label","common"));
			alert(errormsg);
			document.forms[0].action_code.focus();
			return;
		}

		var file_type_appl_yn = document.forms[0].file_type_appl_yn.value;
		
		parent.result_frame.document.location.href="../../eFM/jsp/DTLinkEncounterVolumeDocTypeResult.jsp?patient_id="+patient_id+"&file_no="+file_no+"&file_type="+file_type+"&action_code="+action_code+"&searchYN=Y&file_type_appl_yn="+file_type_appl_yn+"&maintain_doc_or_file="+maintain_doc_or_file;
		document.forms[0].search.disabled = true;
	}
}
</script>
<body onMouseDown = "CodeArrest();" onLoad="FocusFirstElement();" onKeyDown = 'lockKey();'> 
<form name='FMLinkEncounterQueryForm' id='FMLinkEncounterQueryForm' action='' method=''>
<table cellpadding='3' cellspacing='0' border='0' width='100%'>
<tr>
<td colspan="4">
<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" flush="true">
	<jsp:param name="document_or_file_req" value="F" />
	<jsp:param name="frame_name" value="parent.criteria_frame"/>
	<jsp:param name="form_name" value="FMLinkEncounterQueryForm"/>
	<jsp:param name="messageframe_name" value="parent.messageFrame"/>
	<jsp:param name="patientid_name" value="patient_id"/>
	<jsp:param name="fileno_name" value="file_no"/>
	<jsp:param name="filetype_name" value="file_type"/>
	<jsp:param name="volumeno_name" value="volume_no"/>
	<jsp:param name="table_width" value="100"/>
	<jsp:param name="volume_no_appl_yn" value="N"/>
	<jsp:param name="locn_code" value="f_curr_fs_locn"/>
</jsp:include></td>
</tr> 
	<tr>
			<td class="LABEL" width='25%'><fmt:message key="Common.action.label" bundle="${common_labels}"/></td> 
			<td width='25%'><select name="action_code" id="action_code">
			<option value = "">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
			<option value = "L"><fmt:message key="Common.Link.label" bundle="${common_labels}"/></option>
			<option value = "D"><fmt:message key="eFM.De-Link.label" bundle="${fm_labels}"/></option>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>
 			<td width='25%'>&nbsp;</td> 
		<td  width='25%' class='button'><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='getResults();'><input type='button' class='button' name='clear_page' id='clear_page' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearPage()'></td><input type='hidden' name='user_id' id='user_id' value=''>
		<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
	</tr>
</table>
<%
}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
}
%>
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

