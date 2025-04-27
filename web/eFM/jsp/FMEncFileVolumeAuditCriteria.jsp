<!DOCTYPE html>
<%@page session="true" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
try
{
%>
<html>
<head>

    <%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>
	
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMEncFileVolumeAudit.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


<body onMouseDown = "CodeArrest();" onLoad="FocusFirstElement();" onKeyDown = 'lockKey();'>
<form name='FMLinkEncounterQueryForm' id='FMLinkEncounterQueryForm' action='' method=''>
<table cellpadding='3' cellspacing='0' border='0' width='100%'>
<tr>
<td colspan="4">

<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" flush="true">
	<jsp:param name="frame_name" value="parent.criteria_frame"/>
	<jsp:param name="form_name" value="FMLinkEncounterQueryForm"/>
	<jsp:param name="document_or_file_req" value="F"/>
	<jsp:param name="messageframe_name" value="parent.messageFrame"/>
	<jsp:param name="patientid_name" value="patient_id"/>
	<jsp:param name="fileno_name" value="file_no"/>
	<jsp:param name="filetype_name" value="file_type"/>
	<jsp:param name="volumeno_name" value="volume_no"/>
	<jsp:param name="table_width" value="100"/>
	<jsp:param name="volume_no_appl_yn" value="N"/>
	<jsp:param name="locn_code" value="f_curr_fs_locn"/>
	<jsp:param name="fileNoTypeMantatoryYN" value="N"/>
</jsp:include></td>
</tr>
<tr>
<td width="90%"><td>
<td width="25%" class='button'><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='getResults();'><input type='button' class='button' name='clear_page' id='clear_page' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearPage()'><td><input type='hidden' name='user_id' id='user_id' value=''>
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

