<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>               
<% request.setCharacterEncoding("UTF-8");	%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
	<body oncontextmenu="return false">
		<form name="AnaesthesiaHistoryResultHdr" id="AnaesthesiaHistoryResultHdr">
			<table  border='1' width='100%' cellpadding="3" cellspacing=0>
				<tr>
					<th class="columnHeader" nowrap></th>
					<th class="columnHeader" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
					<th class="columnHeader" nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
					<th class="columnHeader" nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
					<th class="columnHeader" nowrap><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></th>
					<th class="columnHeader" nowrap><fmt:message key="eOT.SurgeryDate.Label" bundle="${ot_labels}"/></th>
					<th class="columnHeader" nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
					<th class="columnHeader" nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
					<th class="columnHeader" nowrap><fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/></th>
					<th class="columnHeader" nowrap><fmt:message key="Common.details.label" bundle="${common_labels}"/></th>
					<th class="columnHeader" nowrap><fmt:message key="Common.notes.label" bundle="${common_labels}"/></th>
				</tr>
			</table>
		</form>
	</body>
</html>

