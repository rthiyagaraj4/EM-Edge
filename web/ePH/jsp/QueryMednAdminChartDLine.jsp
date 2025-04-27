<!DOCTYPE html>
<!--This file is saved on 28/10/2005-->
<!-- 
Developed by	: Pushkala.B
Module/Function : QueryMednAdminChart
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="JavaScript" src="../../ePH/js/QueryMednAdminChart.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  topmargin="0">

<TABLE width="98%">
			<TR>
				<TH ALIGN="LEFT"  STYLE="BACKGROUND-COLOR:white;COLOR:black;FONT-SIZE:8PT;FONT-FAMILY:'VERDANA'">
				<fmt:message key="ePH.DrugAdminChart.label" bundle="${ph_labels}"/>
				</TH>
			</TR>
			</TABLE></form>
</body>
</html>

