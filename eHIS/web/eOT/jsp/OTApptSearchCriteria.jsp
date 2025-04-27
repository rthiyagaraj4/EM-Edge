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
	<script language="JavaScript" src="../../eOT/js/OTApptRefNumSearch.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String patient_id = request.getParameter("patient_id");
String patient_class = request.getParameter("patient_class");
String patient_class_desc = request.getParameter("patient_class_desc");
%>
<body  onKeyDown = 'lockKey()' >
<form name="ApptRefNumSearchForm" id="ApptRefNumSearchForm" >
<table cellpadding=3  cellspacing="0" width="100%" border="0">
<tr>
	<td  class='label' width="25%" nowrap>
		<B><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>:</B>
	</td>
	<td class='label' width="25%" > <%=patient_id%>
		<!--  <input type="label"  name="patient_id" id="patient_id" size='15' value="<%=patient_id%>" >-->
	</td>

</tr>

</table>
</form>
</body>
</html>

