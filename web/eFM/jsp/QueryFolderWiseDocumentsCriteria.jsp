<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	String facility_id	=	checkForNull((String) session.getValue("facility_id"));
%>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eFM/js/QueryFolderWiseDocuments.js'></script>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script language='javascript' src='../../eFM/js/DTDocumentNumberLookup.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown = "CodeArrest();" onLoad="FocusFirstElement();" onKeyDown = 'lockKey();'> 
<form name='QueryFolderWiseForm' id='QueryFolderWiseForm' action='' method=''>
<table cellpadding='0' cellspacing='0' border='0' width='100%' >
<tr>
	<td class="LABEL" nowrap width="20%"><fmt:message key="eFM.DocumentFolder.label" bundle="${fm_labels}"/>&nbsp;</td>
	<td class='fields' nowrap colspan="4" width="20%"><select name="specific" id="specific" onChange="clearFolders(this.value);">
		<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
		<option value="P"><fmt:message key="Common.PatientSpecific.label" bundle="${common_labels}"/></option>
		<option value="D"><fmt:message key="eFM.PeriodSpecific.label" bundle="${fm_labels}"/></option>
	</select>&nbsp;/&nbsp;
	<input type="text" name="folder_desc" id="folder_desc" value="" onChange="getReladteFolders(this.value);" disabled><input type="button" value="?" name="folder" id="folder" onClick="getReladteFolders(folder_desc.value);" class="BUTTON" disabled><img src='../../eCommon/images/mandatory.gif' align='center'></img>
	<input type="Hidden" name="folder_id" id="folder_id" value=""></td>
</tr>
<tr>
	<td id="frm_legend" class="LABEL"  nowrap width="20%">&nbsp;</td>
	<td id="frm_date" class="LABEL" nowrap width="20%">&nbsp;</td>
	<td id="to_legend" class="LABEL"  nowrap width="20%">&nbsp;</td>
	<td id="to_date" class="LABEL" nowrap width="20%">&nbsp;</td>
	<td  class='button' width="20%" nowrap><input type='button' class='button' name='search' id='search' value='Search' onClick='getResults();' style='width:50'>&nbsp;<input type='button' class='button' name='clear_page' id='clear_page' value='Clear' onClick='clearPage()' style='width:50'></td>
</tr>
</table>
<input type="Hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="Hidden" name="patient_id" id="patient_id" value="">
<input type="Hidden" name="period_from" id="period_from" value="">
<input type="Hidden" name="period_to" id="period_to" value="">
</form>
</body>
</html>
<%!

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static boolean isNull(String inputString)
{
	return (((inputString == null) || (inputString.equals("null")) ) ? false : true);
}

%>

