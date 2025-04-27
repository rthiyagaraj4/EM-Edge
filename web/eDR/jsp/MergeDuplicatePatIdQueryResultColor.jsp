<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" session="true" %>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
	<table border='1' width='99%'>
		<tr>
			<td width="5%"  class='DECEASED'></td>
			<td width="25%" class='oalabel'><fmt:message key="Common.deceased.label" bundle="${common_labels}"/></td>
			<td width="5%"  class='INACTIVE'></td>
			<td width="25%" class='oalabel'><fmt:message key="Common.Inactive.label" bundle="${common_labels}"/></td>
			<td width="5%" class='SUSPENDED'></td>
			<td width="25%" class='oalabel'><fmt:message key="Common.Suspended.label" bundle="${common_labels}"/></td>
		</tr>
	</table>
</body>
</html>

