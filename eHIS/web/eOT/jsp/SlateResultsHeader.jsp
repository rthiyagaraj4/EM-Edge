<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%//@page contentType="text/html;charset=" import="java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*" %>

<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%// @include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
    <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>    
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- 	<script src="../../eOT/js/OTMessages.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 -->	<style>
	TD.HDR{
	FONT-SIZE: 8pt ;
	COLOR:white;
	BORDER-STYLE: solid;
	height:9;
	BACKGROUND-COLOR:black;
	BORDER-BOTTOM: #CC9966 1px solid;
    BORDER-LEFT: #CC9966 1px solid;
    BORDER-RIGHT: #CC9966 1px solid;
    BORDER-TOP: #CC9966 1px solid;
	}
	</style>

</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name="ResultsHeaderForm" id="ResultsHeaderForm">
		<%
			String sch_unsch_flag = request.getParameter("sch_unsch_flag");
			if(sch_unsch_flag.equals("SCH")){
				
		%>

<table cellpadding=3  cellspacing="0" width="100%" align="center" border="1" id="slate_results_table_header">
	<tr id="slate_results_table_row1">
			<td class="columnHeader">
			<fmt:message key="eOT.ScheduledCases.Label" bundle="${ot_labels}"/>
			</td>
	</tr>
</table>
<table><tr><td></td> </tr></table>
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="1" id="slate_results_table">
	<tr id="slate_results_table_row1">
			<td class='columnHeader' width="2%"></td>
				<td class='columnHeader' width="6%"><fmt:message key="Common.from.label" bundle="${common_labels}"/> </td>
				<td class='columnHeader' width="6%"><fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
				<td class='columnHeader' width="11%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class='columnHeader' width="17%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
				<td class='columnHeader' width="8%"><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></td>
				<td class='columnHeader' width="12%"><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>
				<td class='columnHeader' width="12%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td class='columnHeader' width="10%"><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
				<td class='columnHeader' width="15%"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			</tr>		
		</table>
			<%
				} else if(sch_unsch_flag.equals("UNSCH")){
			%>
				<table cellpadding=3  cellspacing="0" width="100%" align="center" border="1" id="slate_unsch_results_table_header">
					<tr id="slate_unsch_results_table_row1">
						<td class="columnHeader">
						<fmt:message key="eOT.UnScheduledCases.Label" bundle="${ot_labels}"/></td>
					</tr>
				</table>
				<table><tr><td></td> </tr></table>
				<table cellpadding=3  cellspacing="0" width="100%" align="center" border="1" id="slate_unsch_results_table">
					<tr id="slate_unsch_results_table_row1">
						<td class='columnHeader' width="2%"></td>
						<td class='columnHeader' width="13%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td class='columnHeader' width="24%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
						<td class='columnHeader' width="12%"><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></td>
						<td class='columnHeader' width="12%"><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>
						<td class='columnHeader' width="12%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
						<td class='columnHeader' width="12%"><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
						<td class='columnHeader' width="16%"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
					</tr>		
				</table>
			<%
				} else if(sch_unsch_flag.equals("WAITLIST")){
					//20, 30, 15, 15, 20
			%>
				<table cellpadding=3  cellspacing="0" width="100%" align="center" border="1" id="slate_waitlist_results_table_header">
					<tr id="slate_waitlist_results_table_row1">
						<td class="CAGROUPHEADING"><fmt:message key="eOT.WaitlistCases.Label" bundle="${ot_labels}"/></td>
					</tr>
				</table>
				<table cellpadding=3  cellspacing="0" width="100%" align="center" border="1" id="slate_waitlist_results_table">
					<tr id="slate_waitlist_results_table_row2">
						<td class='columnHeader' width="18%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td class='columnHeader' width="19%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
						<td class='columnHeader' width="13%"><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
						<td class='columnHeader' width="12%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
						<td class='columnHeader' width="13%"><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>
						<td class='columnHeader' width="19%"><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></td>
					</tr>		
				</table>
			<%
				} else if(sch_unsch_flag.equals("RESCHEDULE")){
			%>
				<table cellpadding=3  cellspacing="0" width="100%" align="center" border="1" id="slate_reschedule_results_table_header">
					<tr id="slate_reschedule_results_table_row1">
						<td class="CAGROUPHEADING" nowrap><fmt:message key="eOT.ReScheduleCases.Label" bundle="${ot_labels}"/></td>
					</tr>
				</table>
				<table cellpadding=3 cellspacing="0" width="100%" align="center" border="1" id="slate_reschedule_results_table">
					<tr id="slate_reschedule_results_table_row2">
						<td class='columnHeader' width="6%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td class='columnHeader' width="6%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
						<td class='columnHeader' width="6%"><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></td>
						<td class='columnHeader' width="6%"><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
						<td class='columnHeader' width="6%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
						<td class='columnHeader' width="6%"><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>
						<td class='columnHeader' width="6%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
					</tr>		
				</table>
			<%
				}
			%>
		</form>
</body>
</html>

