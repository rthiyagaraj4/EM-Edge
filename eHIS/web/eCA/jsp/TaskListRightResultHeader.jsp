<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,eCA.PatTaskListRepository,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String Groupby=request.getParameter("Groupby")==null?"":request.getParameter("Groupby");

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
<form name='TaskHeaderForm' id='TaskHeaderForm'>
 <!-- <table cellpadding=3 cellspacing=0 border=0 width="100%" style="display;height:30px" id='time_check'>
<tr ><td class='fields' align='right'><input type='checkbox' name='time_interval' id='time_interval' value='' onclick='follow();' ><fmt:message key="eCA.ShowTimeInterval.label" bundle="${ca_labels}"/></td>
</tr>
</table> -->
<!--<table id="tableheader" cellpadding=3 cellspacing=0 border=0 width="100%" style="height:25px">
		<tr>
		<td class=columnheader width='' nowrap>&nbsp;&nbsp;</td>
		<%if (Groupby.equals("P")){	%>
		<td class=columnheader width='' nowrap><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<%}%>
        <td class=columnheader width='' nowrap><fmt:message key="Common.time.label" bundle="${common_labels}"/></td>		
		<td class=columnheader width='' nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<%if (Groupby.equals("T")){	%>
        <td class=columnheader width='' nowrap><fmt:message key="Common.patient.label" bundle="${common_labels}"/></td>
		<%}%>
		<td class=columnheader width='' nowrap><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
</tr>
</table> -->
</form>
<script>
function follow()
{
var groupby='<%=request.getParameter("Groupby")%>';
if(groupby=="P")
	{
	/*	if(document.TaskHeaderForm.time_interval.checked)
			var time_chk="true";
		else */
			var time_chk="false";
parent.parent.TaskListRightFrame.TaskListRightResultFrame.location.href="../jsp/TaskListRightResult.jsp?<%=request.getQueryString()%>&time_chk="+time_chk;
//checkgroupby(groupby);
}
else
{
parent.parent.TaskListRightFrame.TaskListRightResultFrame.location.href="../jsp/TaskListRightResult.jsp?<%=request.getQueryString()%>&time_chk=false";
//checkgroupby(groupby);
}
}
follow();
</script>
</body>
</html>

