<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCA/js/ClinicalEventGroup.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class ='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="EventMainTabsForm" id="EventMainTabsForm">
<table border='0' cellpadding='0' cellspacing='0' id="Tab" width="50%" height="70%">
<tr>

	<td class='CAFOURTHLEVELCOLOR' style='color:white' align="center" onMouseOver='' onMouseOut='' style='cursor:pointer;'	onclick='callResult("S")'  width='10%' align='center' id='setup'>Set Up</td>
					
   <td class='CAFOURTHLEVELCOLOR' style='color:white' align="center" onMouseOver='' onMouseOut='' style='cursor:pointer;'	onclick='callResult("R")'  width='10%' align='center' id='relink'>Re-link</td>

</tr>
</table>
</form>
</body>
</html>



