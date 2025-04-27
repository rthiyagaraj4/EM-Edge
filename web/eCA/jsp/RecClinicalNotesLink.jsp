<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<title>RecClinicalNotesLink.jsp</title>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  class='CONTENT' >
	<center>
	<form name='RecClinicalNotesLinkForm' id='RecClinicalNotesLinkForm' action="../../eCA/jsp/EncountersDocDisplay.jsp" target=RecClinicalNotesLinkDocsViewFrame method=post>
	<p align='left'>
		<table border='0' cellpadding='3' cellspacing='0' width='100%' height='100%' align='center' >
		<tr >
		<td width='25%'></td><td width='25%'></td><td width='25%'></td>
		<td width='25%'>
			<input type='BUTTON' class='BUTTON' name='select' id='select' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="returnData()">&nbsp;
			<input type='BUTTON' class='BUTTON' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick='parent.window.close();'>&nbsp;&nbsp;
		</td>
		</tr>
		</table>
	</p>
	<input name='hist_type' id='hist_type' type=hidden value="">
	<input name='accession_num' id='accession_num' type=hidden value="">
	<input name='data_type' id='data_type' type=hidden value="">
	<input name='from' id='from' type=hidden value="">
	<input name='contr_sys_id' id='contr_sys_id' type=hidden value="">
	<input name='contr_sys_event_code' id='contr_sys_event_code' type=hidden value="">
	</form>
	</center>
</body>
</html>

