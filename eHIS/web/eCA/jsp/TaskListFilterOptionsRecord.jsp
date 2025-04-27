<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,eCA.PatTaskListRepository,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");	
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/TaskList.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<form name='TaskListFilterBottom' id='TaskListFilterBottom'>
<table cellpadding=3 cellspacing=0 border=0 width="100%" height='100%' align=center>
<tr>
<td class='button' align="right"><input type='button' class='button' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' name='ok' onclick='setDate()'><input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' name='cancel' onClick='window.close();'>
</td>
</tr>
</table>
</form>
</body>
</html>

