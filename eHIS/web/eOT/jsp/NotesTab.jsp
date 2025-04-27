<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
</head>
<script language="javascript">
function changeTab(objStr)
{
	selectTab(objStr);
	//alert(objStr);
	var frmObj=document.forms[0];
	if(objStr=='hold_notes')
		locn_type="10";
	else if(objStr=='surg_notes')
		locn_type="30";
	else if(objStr=='rec_notes')
		locn_type="40";
	//alert(param);
	//alert(objStr);
	//alert(parent.ChildBaseFrame.name);
	var param=frmObj.param.value+"&tab_id="+objStr+"&locn_type="+locn_type;

	
	parent.TitleFrame.location.href='../../eOT/jsp/NotesTitle.jsp?'+param
	parent.ResultFrame.location.href='../../eOT/jsp/NotesCommonFrame.jsp?'+param;
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
	
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<form name="NotesTabForm" id="NotesTabForm">
	<table id="tab" cellspacing=0 cellpadding=3  border="0" width='100%'>
<tr>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist' style='padding-left:0px'>
			
			<li class='tablistitem' title='<fmt:message key="eOT.HoldingAreaNotes.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('hold_notes')" class="tabclicked" id="hold_notes">
					<span class="tabSpanclicked" id="hold_notesspan">
						<fmt:message key="eOT.HoldingAreaNotes.Label" bundle="${ot_labels}"/></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.SurgeonNotes.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('surg_notes')" class="tabA" id="surg_notes">
					<span class="tabAspan" id="surg_notesspan">
						<fmt:message key="eOT.SurgeonNotes.Label" bundle="${ot_labels}"/></span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eOT.RecoveryNotes.Label" bundle="${ot_labels}"/>'>
				<a onclick="changeTab('rec_notes')" class="tabA" id="rec_notes">
					<span class="tabAspan" id="rec_notesspan">
						<fmt:message key="eOT.RecoveryNotes.Label" bundle="${ot_labels}"/></span></a>
			</li>
		</ul>
	</td>
</tr>

</table>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>

</form>
<!-- The below line is required to change the select state of Initial tab selected -->
<script>changeTab('hold_notes');</script>
<script>prevTabObj='hold_notes'</script>

</body >
</html>


