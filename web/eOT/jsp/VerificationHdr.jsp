<!DOCTYPE html>
<!-- Modified by Bala on 29/06/2005-->           
<%@page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>

<%

	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8"); 
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
</head>
<body >
<form name="PendingOrderHdr" id="PendingOrderHdr" method="POST" >
<%
String chk_sequence = checkForNull(request.getParameter("chk_sequence"));
String roomCode=checkForNull(request.getParameter("room_code"));
String waitlistkey=checkForNull(request.getParameter("waitlistkey"));
if(waitlistkey.equals("")){
if(roomCode.length()!=0 && chk_sequence.equals("Y") ) { %>
<table class='grid' border='0' width='100%' cellpadding='3' cellspacing='0' align='left'>
	<tr>
			<td class ='columnheader' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>		
			<td class ='columnheader' nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="eOT.CurrentStage.Label" bundle="${ot_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="eOT.CurrentSequence.Label" bundle="${ot_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="eOT.ChangeSequence.Label" bundle="${ot_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
<%}else{%> 
		<table class='grid' border='0' width='100%' cellpadding='3' cellspacing='0' align='center'>
		<tr>
			<td class ='columnheader' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>		
			<td class ='columnheader' nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="eOT.CurrentStage.Label" bundle="${ot_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="eOT.CurrentSequence.Label" bundle="${ot_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="eOT.ChangeStage.Label" bundle="${ot_labels}"/></td>
			<td class ='columnheader' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
<%}	}else{%>
<table class='grid' border='0' width='100%' cellpadding='3' cellspacing='0' align='center'>
<tr nowrap>
	<td class ='columnheader' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td class ='columnheader' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
	<td class ='columnheader' nowrap><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>		
	<td class ='columnheader' nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
	<td class ='columnheader' nowrap><fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/></td>	
	<td class ='columnheader' nowrap><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></td>
	<td class ='columnheader' nowrap><fmt:message key="eOT.WaitlistDate.Label" bundle="${ot_labels}"/></td>
	<td class ='columnheader' nowrap><fmt:message key="eOT.WaitlistDays.Label" bundle="${ot_labels}"/></td>
	<td class ='columnheader' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
<%}%>
</tr>
</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>             

