<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eAE/js/AEReviseVisit.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onKeyDown = 'lockKey()'>
<div align='right'>
<table  cellpadding='0' cellspacing='0'  width='100%' align='center'>
			<tr>
				  <td  class='COMMON_TOOLBAR' align ='left'  ><input type='button' name='Home' id='Home' value=<fmt:message key="Common.menu.label" bundle="${common_labels}"/> onClick='closewindow()'  class='button'></td>
			</tr>
</table>
</div>
</body>
</html>


