<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" session="true" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<table border='1' width='99%'>
		<tr>
			<td width="5%" align='center' class=''><b>A</td>
			<td width="25%" align='left' class='oalabel'><fmt:message key="Common.AllFacilities.label" bundle="${common_labels}"/></td>
			<td width="5%" align='center' class=''><b>L</td>
			<td width="25%" align='left' class='oalabel'><fmt:message key="Common.LoggedinFacility.label" bundle="${common_labels}"/></td>
			<td width="5%" align='center' class=''><b>N</td>
			<td width="25%" align='left' class='oalabel'><fmt:message key="Common.none.label" bundle="${common_labels}"/></td>
		</tr>
	</table>
</body>
</html>

