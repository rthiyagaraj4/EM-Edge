<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>
<html>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eOT/js/OTPatientSearch.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String patient_id = request.getParameter("patient_id");
String patient_class = request.getParameter("patient_class");
String patient_class_desc = request.getParameter("patient_class_desc");
%>
<body  onKeyDown = 'lockKey()' >
<form name="PatientSearchForm" id="PatientSearchForm" >
<table cellpadding=3  cellspacing="0" width="100%" border="0">
<tr>
	<td  class='label' width="25%" >
		<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%" >
		<input type="text"  name="patient_id" id="patient_id" size='15' value="" >
	</td>
	<td class='label' width="25%" >
		<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
	</td>
	<td class='label' width="25%" >
		<input type="text"  name="patient_name" id="patient_name" size='25' value="" >
	</td>
</tr>
<tr>
	<td class='label' width="25%" >
		<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%" >
		<input type="text"  name="patient_class_desc" id="patient_class_desc" size='15' value="<%=patient_class_desc%>" disabled >
		<input type="hidden"  name="patient_class" id="patient_class" value="<%=patient_class%>" >
	</td>
	<td class='label' width="25%" >
		<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%" >
		<input type="text"  name="encounter_id" id="encounter_id" size='15' value="" >
	</td>
</tr>
<tr>
	<td class='label' width="25%" >
		<fmt:message key="Common.ViewBy.label" bundle="${common_labels}"/>
	</td>
 
	<td class='fields' width="25%" >
		<select name="view_by" id="view_by">
				<option value="PATIENT_NAME" selected>
				<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
				</option>
				<option value="ENCOUNTER_ID" >
				<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
				</option>
				<option value="PATIENT_ID">
				<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>	</option>
		</select>
	</td>
	  <td class='fields' width="25%">
	  </td>
	  <td class='fields' width="25%" >
		<input type="button" class="button" name="search" id="search"
		value="<fmt:message key="Common.search.label" bundle="${common_labels}"/>" onclick="populatePatientDetails('1','14')"> 
	</td>
</tr>
</table>
</form>
</body>
</html>

