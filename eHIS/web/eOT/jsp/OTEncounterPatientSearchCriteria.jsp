<!DOCTYPE html>
<%@page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<html>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eOT/js/OTEncounterPatientSearch.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String patient_id = request.getParameter("patient_id");
String patient_class = request.getParameter("patient_class");
String patient_class_desc = request.getParameter("patient_class_desc");
%>
<body  onKeyDown = 'lockKey()' >
<form name="EncounterPatientSearchForm" id="EncounterPatientSearchForm" >
<table cellpadding=3  cellspacing="0" width="100%" border="0">
<tr>
	<td  class='label' width="25%" nowrap>
		<B><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>:</B>
	</td>
	<td class='label' width="25%" > <%=patient_id%>
		<!--  <input type="label"  name="patient_id" id="patient_id" size='15' value="<%=patient_id%>" >-->
	</td>
	<td class='label' width="25%" nowrap>
		<B><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>:</B>
	</td>
	<td class='label' width="25%" > 
		<!-- <input type="label"  name="patient_class_desc" id="patient_class_desc" size='15' value="<%=patient_class_desc%>" > -->
		<%=patient_class_desc%>
		<input type="hidden"  name="patient_class" id="patient_class" value="<%=patient_class%>" >
	</td>
</tr>
<!-- <tr>
	
	<td class='label' width="25%" >
		<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%" >
		<input type="text"  name="encounter_id" id="encounter_id" size='15' value="" >
	</td>
	<td class='label' width="25%" >
		<fmt:message key="Common.ViewBy.label" bundle="${common_labels}"/>
	</td>
 
	<td class='fields' width="25%" >
		<select name="view_by" id="view_by">
				
				<option value="ENCOUNTER_ID" >
				<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
				</option>
				<option value="PATIENT_ID">
				<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>	</option>
		</select>
	</td>
</tr> -->

</table>
</form>
</body>
</html>

