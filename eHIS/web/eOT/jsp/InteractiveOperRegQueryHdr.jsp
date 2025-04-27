<!DOCTYPE html>
<%//@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*" %>
<html>
<%@ page import ="eOT.*,eOT.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<!-- 	<script language='JavaScript' src='../../eOT/js/OTMessages.js'></script>  
 -->	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOT/js/InteractiveOperRegQuery.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="InteractiveOperRegQueryHdr" id="InteractiveOperRegQueryHdr" >
<table  border='1' width='100%' cellpadding=3 cellspacing=0>
	<tr>
		<th class='columnHeaderCenter'  width='20%' style='color:white'>
			<fmt:message key="Common.patient.label" bundle="${common_labels}"/>
		</th>
		<th class='columnHeaderCenter'  width='3% ' style='color:white'>
			<fmt:message key="Common.gender.label" bundle="${common_labels}"/>
		</th>
		<th class='columnHeaderCenter'  width='7% ' style='color:white'>
			<fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/>
		</th>
		<th class='columnHeaderCenter'  width='15%' style='color:white'>
			<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
		</th>
		<th class='columnHeaderCenter'  width='15%' style='color:white'>
			<fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/>
		</th>
		<th class='columnHeaderCenter'  width='15%' style='color:white'>
			<fmt:message key="Common.operation.label" bundle="${common_labels}"/>
		</th>
		<th class='columnHeaderCenter'  width='15%' style='color:white'>
			<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
		</th>
		<th class='columnHeaderCenter'  width='15%' style='color:white'>
			<fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/>
		</th>
		<th class='columnHeaderCenter'  width='4% ' style='color:white'>
			<fmt:message key="eOT.OperationNo.Label" bundle="${ot_labels}"/>
		</th>
		<th class='columnHeaderCenter'  width='3% ' style='color:white'>
			<fmt:message key="eOT.OperationDate.Label" bundle="${ot_labels}"/>
		</th>
		<th class='columnHeaderCenter'  width='15%' style='color:white'>
			<fmt:message key="Common.status.label" bundle="${common_labels}"/>
		</th>
	</tr>
</table>
</form>
</body>
</html>

