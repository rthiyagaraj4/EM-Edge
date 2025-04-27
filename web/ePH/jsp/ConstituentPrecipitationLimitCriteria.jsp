<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eCommon.Common.*, ePH.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> --> 
	<%
	request.setCharacterEncoding("UTF-8");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../ePH/js/QueryMednAdminChart.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="JavaScript" src="../js/ConstituentPrecipitationLimit.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>

<body onMouseDown="" onKeyDown="lockKey()">
<br>
<form name="FormConstituentPresLimitCriteria" id="FormConstituentPresLimitCriteria" >
	<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
		<tr>
			<td align="right" class="label" ><fmt:message key="ePH.ConstituentGroup.label" bundle="${ph_labels}"/></td>
			<td align="left" ><input type="text" name="constituent_group_txt" id="constituent_group_txt" value="Electrolytes" readonly></td>
			<td align="right" class="label" ><fmt:message key="ePH.Applicable.label" bundle="${ph_labels}"/></td>
			<td align="left" ><input type="text" name="Applicable_txt" id="Applicable_txt" value="Non Standard Regimen" readonly></td>

		</tr>
	
</table>

</form>
</body>
</html>


